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

import java.util.Map;

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.flood.graph.*;
import com.googlecode.gumm.utils.treap.IndexedObject;


/**
 * The custom weight evaluator allows to put custom weights on the edges of the propagation graph 
 * according to the edge name.
 * 
 * @author Jean-Rémy Falleri
 */
public class Custom extends WeightEvaluator {
	
	private Map<String,Float> weights;
	
	private Float defaultWeight;
	
	public Custom(Float defaultWeight,Map<String,Float> weights) {
		this.defaultWeight = defaultWeight;
		this.weights = weights;
	}
	
	public Custom(ConnectivityGraph connectivityGraph,Float defaultWeight,Map<String,Float> weights) {
		super(connectivityGraph);
		this.defaultWeight = defaultWeight;
		this.weights = weights;
	}
	
	public void computeWeights() {
		connectivityGraph.complete();
		
		for( IndexedObject<CompatibilityNode> pair: connectivityGraph.getCompatibilityNodes() ) {
			CompatibilityNode node = pair.getValue();
			for( AdjLabeledCompNode lan: connectivityGraph.getTargetNodes(node) ) {
				float coef;
				if ( weights.get(lan.getLabel()) != null )
					coef = weights.get(lan.getLabel());
				else
					coef = defaultWeight;
				
				propagationGraph.createEdge(node,lan.getNode(),coef);
			}
		}
		
	}

}
