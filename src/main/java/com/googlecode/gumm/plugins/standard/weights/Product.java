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

package com.googlecode.gumm.plugins.standard.weights;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.flood.graph.*;
import com.googlecode.gumm.utils.treap.IndexedObject;


/**
 * Assign weights on edges of the propgation graph based on the number
 * of edges leaving each node.
 * 
 * @author Jean-Rémy Falleri
 */
public class Product extends WeightEvaluator {
	
	public Product(ConnectivityGraph connectivityGraph) {
		super(connectivityGraph);
	}
	
	public Product() {}
	
	public void computeWeights() {
		connectivityGraph.complete();
		
		for( IndexedObject<CompatibilityNode> pair: connectivityGraph.getCompatibilityNodes() ) {
			CompatibilityNode node = pair.getValue();
			Map<String,Integer> targetNodesNb = new HashMap<String, Integer>(); 
			for( AdjLabeledCompNode lan: connectivityGraph.getTargetNodes(node) ) {
				String label = lan.getLabel();
				if (targetNodesNb.get(label) == null)
					targetNodesNb.put(label, connectivityGraph.getEdgesNb(node, label));
				float coef = 1.0F / (float) targetNodesNb.get(label);
				propagationGraph.createEdge(node,lan.getNode(),coef);
			}
		}
	}

}
