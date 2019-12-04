package com.googlecode.gumm.main;

import java.util.Map;

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.flood.graph.ConnectivityGraph;
import com.googlecode.gumm.flood.graph.PropagationGraph;
import com.googlecode.gumm.graph.AdjModelGraph;
import com.googlecode.gumm.graph.LabeledNode;
import com.googlecode.gumm.graph.ModelGraph;
import com.googlecode.gumm.plugins.standard.filters.ThresholdFilter;
import com.googlecode.gumm.plugins.standard.weights.Product;
import org.eclipse.emf.ecore.EObject;

import com.googlecode.gumm.plugins.ecore.evaluators.*;
import com.googlecode.gumm.plugins.ecore.filters.*;
import com.googlecode.gumm.plugins.ecore.importers.*;

public class EcoreFlooderTest {
	
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		
		String leftP = args[0];
		String rightP = args[1];
		
		EcoreImporter leftI = new StandardEcoreImporter(leftP);
		EcoreImporter rightI = new StandardEcoreImporter(rightP);

		ModelGraph leftG = leftI.getGraph();
		ModelGraph rightG = rightI.getGraph();
		
		AdjModelGraph leftAdjG = leftG.toAdjInputGraph();
		AdjModelGraph rightAdjG = rightG.toAdjInputGraph();
		
		System.out.println("Left graph: " + leftAdjG);
		System.out.println("Right graph: " + rightAdjG);
		
		Map<LabeledNode,EObject> leftE = leftI.getEnvironment();
		Map<LabeledNode,EObject> rightE = rightI.getEnvironment();
		
		System.out.println("Creating connectivity graph.");
		IdManager idManager = new IdManager(leftAdjG.getNodesNb(), rightAdjG.getNodesNb());
		ConnectivityGraph cg = new ConnectivityGraph(idManager, leftAdjG,rightAdjG);
		
		System.out.println("Connectivity graph: " + cg);
		
		WeightEvaluator w = new Product(cg);
		
		//HashMap<String,Float> weights = new HashMap<String, Float>();
		//weights.put("supertype", 0.8F);
		//weights.put("own", 0.8F);
		//weights.put("ref", 0.8F);
		//weights.put("supertype", 0.8F);
		//WeightEvaluator w = new Custom(cg,0.2F,weights);
		
		System.out.println("Creating propagation graph.");
		Sigma0Evaluator s = new MunkresEvaluator(leftAdjG, rightAdjG);
		
		PropagationGraph pg = new PropagationGraph(idManager, cg, w, s);

		System.out.println("Propagation graph: " + cg);
		System.out.println(pg);

		Flooder flooder = new Flooder(pg,0.05F,100);
		
		System.out.println("Flooding.");
		
		flooder.flood();

		System.out.println("Filtering step.");

		Alignment alignment = flooder.getAlignment();
		FilterManager filterManager = new FilterManager(alignment);
		filterManager.addFilter(new ThresholdFilter(0.9F));
		filterManager.addFilter(new EcoreFilter());
		filterManager.applyFilters();
		
		System.out.println("Number of matches after filtering: " + alignment.getMappings().size());
		
		long t2 = System.currentTimeMillis();
		
		float t = (float) (t2 - t1);
		float m = t / ( 60000F );
		
		System.out.println("Computation time: " + m + " mins.");
	}

}
