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

import com.googlecode.gumm.flood.IdManager;
import com.googlecode.gumm.flood.Sigma0Evaluator;
import com.googlecode.gumm.flood.WeightEvaluator;
import com.googlecode.gumm.flood.graph.AdjWeightedCompNode;
import com.googlecode.gumm.flood.graph.ConnectivityGraph;
import com.googlecode.gumm.flood.graph.PropagationEdge;
import com.googlecode.gumm.flood.graph.PropagationGraph;
import com.googlecode.gumm.graph.AdjModelGraph;
import com.googlecode.gumm.graph.Edge;
import com.googlecode.gumm.graph.LabeledNode;
import com.googlecode.gumm.graph.ModelGraph;
import com.googlecode.gumm.plugins.standard.sigma.StandardSigmaEvaluator;
import com.googlecode.gumm.plugins.standard.weights.Product;


public class MultiLinksTest {
	
	@Test
	public void testMultiLinks() {
		AdjModelGraph g1 = getGraph1().toAdjInputGraph();
		AdjModelGraph g2 = getGraph2().toAdjInputGraph();
		
		IdManager idManager = new IdManager(g1.getNodesNb(),g2.getNodesNb());
		
		ConnectivityGraph g1g2 = new ConnectivityGraph(idManager,g1,g2);
		WeightEvaluator w = new Product(g1g2);
		Sigma0Evaluator s = new StandardSigmaEvaluator();
		PropagationGraph pg1g2 = new PropagationGraph(idManager,g1g2,w,s);
		assertTrue(pg1g2.getCompatibilityNodes().size() == 2 );
		assertTrue(pg1g2.hasCompatibilityNode(0));
		assertTrue(pg1g2.hasCompatibilityNode(3));
		assertTrue( pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(0)).size() == 2 );
		assertTrue( pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(3)).size() == 2 );
		for(AdjWeightedCompNode wan: pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(0)))
			assertTrue(wan.getNode().getId() == 3);
		for(AdjWeightedCompNode wan: pg1g2.getSourceNodes(pg1g2.getCompatibilityNode(3)))
			assertTrue(wan.getNode().getId() == 0);
		for(Edge e: pg1g2.getEdges() ) {
			PropagationEdge pe = (PropagationEdge) e;
			assertTrue( pe.getWeight() == 1.0F );
		}
	}
	
	
	private static ModelGraph getGraph1() {
		ModelGraph g = new ModelGraph();
		LabeledNode n1 = g.createObjectNode("a1",null,"Any");
		LabeledNode n2 = g.createObjectNode("b1",null,"Any");
		g.createEdge(n1,n2,"u");
		g.createEdge(n1,n2,"l");
		return g;
	}
	
	private static ModelGraph getGraph2() {
		ModelGraph g = new ModelGraph();
		LabeledNode n1 = g.createObjectNode("a2",null,"Any");
		LabeledNode n2 = g.createObjectNode("b2",null,"Any");
		g.createEdge(n1,n2,"u");
		g.createEdge(n1,n2,"l");
		return g;
	}

}
