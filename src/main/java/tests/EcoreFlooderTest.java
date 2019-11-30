package tests;

import java.io.IOException;
import java.util.Map;

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.flood.graph.ConnectivityGraph;
import com.googlecode.gumm.flood.graph.PropagationGraph;
import com.googlecode.gumm.graph.AdjModelGraph;
import com.googlecode.gumm.graph.LabeledNode;
import com.googlecode.gumm.plugins.standard.filters.ThresholdFilter;
import com.googlecode.gumm.plugins.standard.weights.Product;
import org.eclipse.emf.ecore.EObject;

import fr.lirmm.gumm.plugins.ecore.evaluators.*;
import fr.lirmm.gumm.plugins.ecore.filters.*;
import fr.lirmm.gumm.plugins.ecore.importers.*;

public class EcoreFlooderTest {
	
	public static void main(String[] args) throws IOException {
		long t1 = System.currentTimeMillis();
		
		String leftP = "./dataset/metamodels/Ecore.ecore";
		String rightP = "./dataset/metamodels/kermeta.ecore";
		
		EcoreImporter leftI = new StandardEcoreImporter(leftP);
		EcoreImporter rightI = new StandardEcoreImporter(rightP);
		
		AdjModelGraph leftG = leftI.getGraph().toAdjInputGraph();
		AdjModelGraph rightG = rightI.getGraph().toAdjInputGraph();
		
		System.out.println("Left graph: " + leftG);
		System.out.println("Right graph: " + rightG);
		
		Map<LabeledNode,EObject> leftE = leftI.getEnvironment();
		Map<LabeledNode,EObject> rightE = rightI.getEnvironment();
		
		System.out.println("Creating connectivity graph.");
		IdManager idManager = new IdManager(leftG.getNodesNb(), rightG.getNodesNb());
		ConnectivityGraph cg = new ConnectivityGraph(idManager, leftG,rightG);
		
		System.out.println("Connectivity graph: " + cg);
		
		WeightEvaluator w = new Product(cg);
		
		//HashMap<String,Float> weights = new HashMap<String, Float>();
		//weights.put("supertype", 0.8F);
		//weights.put("own", 0.8F);
		//weights.put("ref", 0.8F);
		//weights.put("supertype", 0.8F);
		//WeightEvaluator w = new Custom(cg,0.2F,weights);
		
		System.out.println("Creating propagation graph.");
		Sigma0Evaluator s = new MunkresEvaluator(leftG,rightG);
		
		PropagationGraph pg = new PropagationGraph(idManager,cg,w,s);

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
