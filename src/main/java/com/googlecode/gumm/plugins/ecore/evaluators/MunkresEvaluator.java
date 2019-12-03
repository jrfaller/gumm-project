package com.googlecode.gumm.plugins.ecore.evaluators;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.gumm.flood.graph.CompatibilityNode;
import com.googlecode.gumm.graph.AdjLabeledNode;
import com.googlecode.gumm.graph.AdjLabeledNodes;
import com.googlecode.gumm.graph.AdjModelGraph;
import com.googlecode.gumm.graph.LabeledNode;
import fr.lirmm.nlpse.distance.MunkresDistance;

public class MunkresEvaluator extends EcoreEvaluator {

	private AdjModelGraph source;

	private AdjModelGraph target;

	public MunkresEvaluator(AdjModelGraph source, AdjModelGraph target) {
		super();
		this.source = source;
		this.target = target;
	}

	public void initSigma0() {
		// removeWrongNodes(propagationGraph); FIXME

		List<CompatibilityNode> toRemove = new ArrayList<>();
		
		for(CompatibilityNode cn: propagationGraph.getNodes()) {
			LabeledNode sn = cn.getSourceNode();
			LabeledNode tn = cn.getTargetNode();

			List<String> c1 = createContext(sn,source,"label");
			List<String> c2 = createContext(tn,target,"label");

			if ( c1.size() > 0 && c2.size() > 0 )
				sigma0.setSimilarity(cn.getId(),MunkresDistance.getSimilarity(c1, c2));
			
			LevenshteinEvaluator l = new LevenshteinEvaluator();
			
			if ( !sn.getLabel().startsWith("#") && !sn.getLabel().startsWith("#") )
				if ( sigma0.getSimilarity(cn.getId()) <= 0.0F ) {
					sigma0.setSimilarity(cn.getId(),l.getSimilarity(sn.getLabel(),tn.getLabel()));
					//toRemove.add(cn);
				}
		}
		
		propagationGraph.deleteCompatibilityNodes(toRemove);
		
	}

	private List<String> createContext(LabeledNode n , AdjModelGraph graph , String labelArcName ) {
		List<String> c = new ArrayList<String>();

		if ( n.getLabel().startsWith("#") ) {

			String nLabel = nodeLabel(n, graph, labelArcName);
			if ( nLabel != null )
				c.add(nLabel);
			for(AdjLabeledNode v: graph.getTargetNodes(n) ) {
				if ( v.getNode().getLabel().startsWith("#") ) {
					
					//if ( nLabel.equals("EClass") )
						//System.out.println(v.getNode().getLabel());
					
					String vLabel = nodeLabel(v.getNode(),graph, labelArcName);
					if ( vLabel != null && !"".equals(nLabel) )
						c.add(vLabel);
				}
			}
	
		}

		return c;
	}

	private String nodeLabel(LabeledNode n, AdjModelGraph graph , String labelArcName ) {
		AdjLabeledNodes alns = graph.getTargetNodes(n);
		if ( alns.size() < 1 ) {
			return null;
		}
		else {
			AdjLabeledNode aln = alns.get(0);
			if ( "".equals(aln.getNode().getLabel()) )
				return null;
			else
				return aln.getNode().getLabel();
		}
	}

	private void dumpContext(List<String> c ) {
		for(String s: c)
			System.out.print(s + " - ");
		System.out.print("\n");
	}
	
	@Override
	protected float getSimilarity(String s1, String s2) {
		return 0.0F;
	}

}
