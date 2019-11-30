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

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.flood.graph.*;
import com.googlecode.gumm.utils.treap.IndexedObject;

public class Constant extends WeightEvaluator {
	
	public Constant() {}
	
	public Constant(ConnectivityGraph connectivityGraph) {
		super(connectivityGraph);
	}
	
	public void computeWeights() {
		connectivityGraph.complete();
	
		for(IndexedObject<CompatibilityNode> pair: connectivityGraph.getCompatibilityNodes() ) {
			CompatibilityNode n = pair.getValue();
			for( AdjLabeledCompNode lan: connectivityGraph.getTargetNodes(n) )
				propagationGraph.createEdge(n,lan.getNode(),1.0F);
		}
		
	}
	
}
