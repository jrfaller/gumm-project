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

package com.googlecode.gumm.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.flood.graph.*;
import com.googlecode.gumm.graph.*;
import com.googlecode.gumm.plugins.standard.sigma.StandardSigmaEvaluator;
import com.googlecode.gumm.plugins.standard.weights.*;


public class WeightedGraphTest {
	
	@Test
	public void testProductWeights() {
		ModelGraph g1 = getGraph();
		ModelGraph g2 = getGraph();
		
		IdManager idManager = new IdManager(g1.getNodesNb(),g2.getNodesNb());
		
		ConnectivityGraph g1g2 =  new ConnectivityGraph(idManager,g1,g2);
		
		WeightEvaluator w = new Product(g1g2);
		Sigma0Evaluator s = new StandardSigmaEvaluator();
		
		PropagationGraph pg1g2 = new PropagationGraph(idManager,g1g2,w,s);

		assertTrue(pg1g2.getCompatibilityNodes().size() == 5);
		assertTrue(pg1g2.getEdges().size() == 8);
		for(AdjWeightedCompNode sourceNode: pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(8)))
			assertTrue(sourceNode.getWeight() == 1.0F);
		
		assertTrue(pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(0)).get(0).getWeight() == 0.25F);
		assertTrue(pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(1)).get(0).getWeight() == 0.25F);
		assertTrue(pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(3)).get(0).getWeight() == 0.25F);
		assertTrue(pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(4)).get(0).getWeight() == 0.25F);
	}
	
	@Test
	public void testConstantWeights() {
		ModelGraph g1 = getGraph();
		ModelGraph g2 = getGraph();
		
		IdManager idManager = new IdManager(g1.getNodesNb(),g2.getNodesNb());
		
		ConnectivityGraph g1g2 =  new ConnectivityGraph(idManager,g1,g2);
		
		WeightEvaluator w = new Constant(g1g2);
		Sigma0Evaluator s = new StandardSigmaEvaluator();
		
		PropagationGraph pg1g2 = new PropagationGraph(idManager,g1g2,w,s);

		assertTrue(pg1g2.getCompatibilityNodes().size() == 5);
		assertTrue(pg1g2.getEdges().size() == 8);
		for(AdjWeightedCompNode sourceNode: pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(8)))
			assertTrue(sourceNode.getWeight() == 1.0F);
		
		assertTrue(pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(0)).get(0).getWeight() == 1.0F);
		assertTrue(pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(1)).get(0).getWeight() == 1.0F);
		assertTrue(pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(3)).get(0).getWeight() == 1.0F);
		assertTrue(pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(4)).get(0).getWeight() == 1.0F);

	}

	private static ModelGraph getGraph() {
		ModelGraph g1 = new ModelGraph();
		LabeledNode na = new LabeledNode(0,"0","Any");
		LabeledNode nb = new LabeledNode(1,"1","Any");
		LabeledNode nc = new LabeledNode(2,"2","Any");
		LabeledEdge e1 = new LabeledEdge(na,nc,"l1");
		LabeledEdge e2 = new LabeledEdge(nb,nc,"l1");
		g1.addNode(na);g1.addNode(nb);g1.addNode(nc);
		g1.addEdge(e1);g1.addEdge(e2);
		return g1;
	}

}
