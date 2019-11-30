/*
 * Copyright (C) 2009 Jean-Rémy Falleri <jr.falleri@laposte.net>
 */

/*
 * This file is part of Gumm.

 * Gumm is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Gumm is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public License
 * along with Gumm. If not, see <http://www.gnu.org/licenses/>.
 */

package com.googlecode.gumm.plugins.standard.sigma;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.flood.graph.*;
import com.googlecode.gumm.graph.*;
import com.googlecode.gumm.utils.treap.IndexedObject;

/**
 * Sigma evaluator that assigns initial weights to the compatibility node of the propagation graph. Some predefinied
 * matches between object nodes are furnished. Compatibility nodes corresponding to those matches are assigned a maximum
 * weight.
 * @author Jean-Rémy Falleri
 */
public class StandardAnchoredEvaluator extends Sigma0Evaluator {
	
	public AnchorList anchors;
	
	public StandardAnchoredEvaluator(File f) throws IOException, FileNotFoundException {
		anchors = new AnchorList(f);
	}
	
	public StandardAnchoredEvaluator(AnchorList anchors) {
		this.anchors = anchors;
	}
	
	public void computeSigma0() {
		List<CompatibilityNode> toDelete = new LinkedList<CompatibilityNode>();
		
		for( IndexedObject<CompatibilityNode> pair: propagationGraph.getCompatibilityNodes() ) {
			
			int ID = pair.getKey();
			CompatibilityNode compNode = pair.getValue();
			
			LabeledNode n1 = compNode.getSourceNode();
			LabeledNode n2 = compNode.getTargetNode();
			
			if ( n1 instanceof ObjectNode && n2 instanceof ObjectNode ) {
				String s1 = n1.getLabel();
				String s2 = n2.getLabel();
				
				if ( !anchors.accept(s1,s2) )
					toDelete.add(compNode);
				else if ( ( anchors.fullFill(s1,s2) ) )
					sigma0.setSimilarity(ID, 1.0F);
				else
					setObjectNodesSimilarity(compNode.getId(), (ObjectNode) n1, (ObjectNode) n2);
			}	
			else if ( n1 instanceof ValueNode && n2 instanceof ValueNode ) {
				ValueNode sn1 = (ValueNode) n1;
				ValueNode sn2 = (ValueNode) n2;
				
				if ( ValueNode.TYPE_STRING.equals(sn1.getType()) && ValueNode.TYPE_STRING.equals(sn2.getType()) )
					setStringSimilarity(ID,sn1,sn2);
				else if ( ValueNode.TYPE_INTEGER.equals(sn1.getType()) && ValueNode.TYPE_INTEGER.equals(sn2.getType()) )
					setIntegerSimilarity(ID,sn1,sn2);
				else if ( ValueNode.TYPE_FLOAT.equals(sn1.getType()) && ValueNode.TYPE_FLOAT.equals(sn2.getType()) )
					setFloatSimilarity(ID,sn1,sn2);
				else if ( ValueNode.TYPE_BOOLEAN.equals(sn1.getType()) && ValueNode.TYPE_BOOLEAN.equals(sn2.getType()) )
					setBooleanSimilarity(ID,sn1,sn2);
				else
					setSimilarity(ID,sn1,sn2);
			}
			else
				setSimilarity(ID,n1,n2);
		}
		
		propagationGraph.deleteCompatibilityNodes(toDelete);
	}
	
	protected void setObjectNodesSimilarity(int ID , ObjectNode n1 , ObjectNode n2 ) {
		sigma0.setSimilarity(ID,0.0F);
	}
	
	
	protected void setStringSimilarity(int ID , ValueNode n1 , ValueNode n2 ) {
		String l1 = n1.getLabel().toLowerCase();
		String l2 = n2.getLabel().toLowerCase();
		
		if ( l1.contains(l2) || l2.contains(l1) )
			sigma0.setSimilarity(ID, 1.0F);
		else
			sigma0.setSimilarity(ID, 0.0F);
		
	}
	
	protected void setIntegerSimilarity(int ID , ValueNode n1 , ValueNode n2 ) {
		float sim = 0.0F;
		if ( n1.getLabel().equals(n2.getLabel()))
			sim = 1.0F;
		sigma0.setSimilarity(ID,sim);
	}
	
	protected void setFloatSimilarity(int ID, ValueNode n1 , ValueNode n2 ) {
		float sim = 0.0F;
		if ( n1.getLabel().equals(n2.getLabel()))
			sim = 1.0F;
		sigma0.setSimilarity(ID,sim);
	}
	
	protected void setBooleanSimilarity(int ID, ValueNode n1 , ValueNode n2 ) {
		float sim = 0.0F;
		if ( n1.getLabel().equals(n2.getLabel()))
			sim = 1.0F;
		sigma0.setSimilarity(ID,sim);
	}
	
	protected void setSimilarity(int ID,LabeledNode n1,LabeledNode n2) {
		sigma0.setSimilarity(ID, 0.0F);
	}
	
}
