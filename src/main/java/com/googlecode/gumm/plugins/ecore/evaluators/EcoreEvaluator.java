package com.googlecode.gumm.plugins.ecore.evaluators;

import com.googlecode.gumm.flood.graph.CompatibilityNode;
import com.googlecode.gumm.plugins.standard.sigma.AnchorList;
import com.googlecode.gumm.plugins.standard.sigma.StandardAnchoredEvaluator;

public abstract class EcoreEvaluator extends StandardAnchoredEvaluator {
	
	public EcoreEvaluator() {
		super(ecoreAnchors());
	}

	public void initSigma0() {
		// removeWrongNodes(propagationGraph); FIXME: where is this method?
		
		for(CompatibilityNode node: propagationGraph.getNodes()) {

			String s1 = node.getSourceNode().getLabel();
			String s2 = node.getTargetNode().getLabel();
			if ( ! s1.startsWith("#") && ! s2.startsWith("#") ) {
				float distance = getSimilarity(s1, s2);
				sigma0.setSimilarity(node.getId(), distance);
			}
			else
				sigma0.setSimilarity(node.getId(),0.0F);
		}
	}
	
	protected abstract float getSimilarity(String s1,String s2);
	
	private static AnchorList ecoreAnchors() {
		AnchorList anchors = new AnchorList();
		anchors.addAnchor("true","true");
		anchors.addAnchor("false","false");
		anchors.addAnchor("ClassElement","ClassElement");
		anchors.addAnchor("EnumElement","EnumElement");
		anchors.addAnchor("DataTypeElement","DataTypeElement");
		anchors.addAnchor("AttributeElement","AttributeElement");
		anchors.addAnchor("EnumLiteralElement","EnumLiteralElement");
		anchors.addAnchor("ReferenceElement", "ReferenceElement");
		anchors.addAnchor("0", "0");
		anchors.addAnchor("1", "1");
		anchors.addAnchor("n", "n");
		return anchors;
	}

	public String getDescription() {
		return "Ecore anchored evaluator";
	}

	public String getName() {
		return "Ecore anchored evaluator";
	}

}
