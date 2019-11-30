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

import com.googlecode.gumm.flood.Sigma0Evaluator;
import com.googlecode.gumm.flood.graph.CompatibilityNode;
import com.googlecode.gumm.graph.*;
import com.googlecode.gumm.utils.treap.IndexedObject;

public class StandardSigmaEvaluator extends Sigma0Evaluator {
	
	public void computeSigma0() {
		for(IndexedObject<CompatibilityNode> pair: propagationGraph.getCompatibilityNodes() ) {
			
			CompatibilityNode compNode = pair.getValue();
			int id = compNode.getId();
			
			LabeledNode n1 = compNode.getSourceNode();
			LabeledNode n2 = compNode.getTargetNode();
			
			if ( n1 instanceof ObjectNode && n2 instanceof ObjectNode )
				setObjectNodesSimilarity(compNode.getId(), (ObjectNode) n1, (ObjectNode) n2);
			else if ( n1 instanceof ValueNode && n2 instanceof ValueNode ) {
				ValueNode sn1 = (ValueNode) n1;
				ValueNode sn2 = (ValueNode) n2;
				if ( ValueNode.TYPE_STRING.equals(sn1.getType()) && ValueNode.TYPE_STRING.equals(sn2.getType()) )
					setStringSimilarity(id,sn1,sn2);
				else if ( ValueNode.TYPE_INTEGER.equals(sn1.getType()) && ValueNode.TYPE_INTEGER.equals(sn2.getType()) )
					setIntegerSimilarity(id,sn1,sn2);
				else if ( ValueNode.TYPE_FLOAT.equals(sn1.getType()) && ValueNode.TYPE_FLOAT.equals(sn2.getType()) )
					setFloatSimilarity(id,sn1,sn2);
				else if ( ValueNode.TYPE_BOOLEAN.equals(sn1.getType()) && ValueNode.TYPE_BOOLEAN.equals(sn2.getType()) )
					setBooleanSimilarity(id,sn1,sn2);
				else
					setValueNodesSimilarity(id,sn1,sn2);
			}
			else
				setSimilarity(id,n1,n2);
		}
	}
	
	protected void setObjectNodesSimilarity(int id , ObjectNode n1 , ObjectNode n2 ) {
		sigma0.setSimilarity(id,0.0F);
	}
	
	protected void setStringSimilarity(int id , ValueNode n1 , ValueNode n2 ) {
		String l1 = n1.getLabel().toLowerCase();
		String l2 = n2.getLabel().toLowerCase();
		
		if ( !"".equals(l1) && !"".equals(l2) ) {
			if ( l1.contains(l2) || l2.contains(l1) )
				sigma0.setSimilarity(id, 1.0F);
			else
				sigma0.setSimilarity(id, 0.0F);
		}
		else if ( "".equals(l1) && "".equals(l2) )
			sigma0.setSimilarity(id, 1.0F);
		else
			sigma0.setSimilarity(id, 0.0F);
		
	}
	
	protected void setIntegerSimilarity(int id , ValueNode n1 , ValueNode n2 ) {
		float sim = 0.0F;
		if ( n1.getLabel().equals(n2.getLabel()))
			sim = 1.0F;
		sigma0.setSimilarity(id,sim);
	}
	
	protected void setFloatSimilarity(int id, ValueNode n1 , ValueNode n2 ) {
		float sim = 0.0F;
		if ( n1.getLabel().equals(n2.getLabel()))
			sim = 1.0F;
		sigma0.setSimilarity(id,sim);
	}
	
	protected void setBooleanSimilarity(int id, ValueNode n1 , ValueNode n2 ) {
		float sim = 0.0F;
		if ( n1.getLabel().equals(n2.getLabel()))
			sim = 1.0F;
		sigma0.setSimilarity(id,sim);
	}
	
	protected void setValueNodesSimilarity(int id, ValueNode n1, ValueNode n2) {
		sigma0.setSimilarity(id, 0.0F);
	}
	
	protected void setSimilarity(int id,LabeledNode n1,LabeledNode n2) {
		sigma0.setSimilarity(id, 0.0F);
	}

}
