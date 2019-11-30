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
import com.googlecode.gumm.plugins.standard.weights.Product;


public class BasicGraphTest2 {
	
	@Test
	public void testConnectivityGraph() {
		ModelGraph g1 = getGraph1();
		ModelGraph g2 = getGraph2();
		
		IdManager idManager = new IdManager(g1.getNodesNb(),g2.getNodesNb());
		
		ConnectivityGraph g1g2 = new ConnectivityGraph(idManager,g1,g2);
		assertTrue(g1g2.getCompatibilityNodes().size() == 6);
		assertTrue(g1g2.getEdges().size() == 4);
		assertTrue(g1g2.hasCompatibilityNode(0));
		assertTrue(g1g2.hasCompatibilityNode(1));
		assertTrue(g1g2.hasCompatibilityNode(4));
		assertTrue(g1g2.hasCompatibilityNode(5));
		assertTrue(g1g2.hasCompatibilityNode(7));
		assertTrue(g1g2.hasCompatibilityNode(8));
		assertTrue(g1g2.getTargetNodes(g1g2.getCompatibilityNode(0)).size() == 2 );
		int id1 = g1g2.getTargetNodes(g1g2.getCompatibilityNode(0)).get(0).getNode().getId();
		int id2 = g1g2.getTargetNodes(g1g2.getCompatibilityNode(0)).get(1).getNode().getId();
		assertTrue(id1 != id2);
		assertTrue(id1 == 4 || id1 == 5);
		assertTrue(id2 == 4 || id2 == 5);
		assertTrue(g1g2.getTargetNodes(g1g2.getCompatibilityNode(0)).get(0).getLabel().equals("l1"));
		assertTrue(g1g2.getTargetNodes(g1g2.getCompatibilityNode(0)).get(1).getLabel().equals("l1"));
		assertTrue(g1g2.getTargetNodes(g1g2.getCompatibilityNode(7)).size() == 1 );
		assertTrue(g1g2.getTargetNodes(g1g2.getCompatibilityNode(7)).get(0).getNode().getId() == 5);
		assertTrue(g1g2.getTargetNodes(g1g2.getCompatibilityNode(7)).get(0).getLabel().equals("l2"));
		assertTrue(g1g2.getTargetNodes(g1g2.getCompatibilityNode(1)).size() == 1 );
		assertTrue(g1g2.getTargetNodes(g1g2.getCompatibilityNode(1)).get(0).getNode().getId() == 8);
		assertTrue(g1g2.getTargetNodes(g1g2.getCompatibilityNode(1)).get(0).getLabel().equals("l2"));
	}
	
	@Test
	public void testPropagationGraph() {
		ModelGraph g1 = getGraph1();
		ModelGraph g2 = getGraph2();
		
		IdManager idManager = new IdManager(g1.getNodesNb(),g2.getNodesNb());
		
		ConnectivityGraph g1g2 =  new ConnectivityGraph(idManager,g1,g2);
		WeightEvaluator w = new Product(g1g2);
		Sigma0Evaluator s = new StandardSigmaEvaluator();
		PropagationGraph pg1g2 = new PropagationGraph(idManager,g1g2,w,s);
		assertTrue(pg1g2.getCompatibilityNodes().size() == 6);
		assertTrue(pg1g2.getEdges().size() == 8);
		assertTrue(pg1g2.hasCompatibilityNode(0));
		assertTrue(pg1g2.hasCompatibilityNode(1));
		assertTrue(pg1g2.hasCompatibilityNode(4));
		assertTrue(pg1g2.hasCompatibilityNode(5));
		assertTrue(pg1g2.hasCompatibilityNode(7));
		assertTrue(pg1g2.hasCompatibilityNode(8));
		assertTrue(pg1g2.getSourceNodes(g1g2.getCompatibilityNode(0)).size() == 2 );
		assertTrue(pg1g2.getSourceNodes(g1g2.getCompatibilityNode(0)).get(0).getWeight() == 1.0F );
		assertTrue(pg1g2.getSourceNodes(g1g2.getCompatibilityNode(0)).get(1).getWeight() == 1.0F );
		assertTrue(pg1g2.getSourceNodes(g1g2.getCompatibilityNode(4)).size() == 1);
		assertTrue(pg1g2.getSourceNodes(g1g2.getCompatibilityNode(4)).get(0).getWeight() == 0.5F );
		assertTrue(pg1g2.getSourceNodes(g1g2.getCompatibilityNode(5)).size() == 2);
		float f1 = pg1g2.getSourceNodes(g1g2.getCompatibilityNode(5)).get(0).getWeight();
		float f2 = pg1g2.getSourceNodes(g1g2.getCompatibilityNode(5)).get(1).getWeight();
		assertTrue( f1 != f2);
		assertTrue( f1 == 0.5F || f1 == 1.0F );
		assertTrue( f2 == 0.5F || f2 == 1.0F );
		assertTrue(pg1g2.getSourceNodes(g1g2.getCompatibilityNode(7)).size() == 1);
		assertTrue(pg1g2.getSourceNodes(g1g2.getCompatibilityNode(7)).get(0).getWeight() == 1.0F );
		assertTrue(pg1g2.getSourceNodes(g1g2.getCompatibilityNode(1)).size() == 1);
		assertTrue(pg1g2.getSourceNodes(g1g2.getCompatibilityNode(1)).get(0).getWeight() == 1.0F );
		assertTrue(pg1g2.getSourceNodes(g1g2.getCompatibilityNode(8)).size() == 1);
		assertTrue(pg1g2.getSourceNodes(g1g2.getCompatibilityNode(8)).get(0).getWeight() == 1.0F );
	}
	
	private static ModelGraph getGraph1() {
		ModelGraph g1 = new ModelGraph();
		LabeledNode na = new LabeledNode(0,"0","Any");
		LabeledNode nb = new LabeledNode(1,"1","Any");
		LabeledNode nc = new LabeledNode(2,"2","Any");
		LabeledEdge e1 = new LabeledEdge(na,nb,"l1");
		LabeledEdge e2 = new LabeledEdge(na,nc,"l1");
		LabeledEdge e3 = new LabeledEdge(nb,nc,"l2");
		g1.addNode(na);g1.addNode(nb);g1.addNode(nc);
		g1.addEdge(e1);g1.addEdge(e2);g1.addEdge(e3);
		return g1;
	}
	
	private static ModelGraph getGraph2() {
		ModelGraph g2 = new ModelGraph();
		LabeledNode nd = new LabeledNode(0,"0","Any");
		LabeledNode ne = new LabeledNode(1,"1","Any");
		LabeledNode nf = new LabeledNode(2,"2","Any");
		LabeledEdge ee1 = new LabeledEdge(nd,ne,"l1");
		LabeledEdge ee2 = new LabeledEdge(nd,nf,"l2");
		LabeledEdge ee3 = new LabeledEdge(nf,ne,"l2");
		g2.addNode(nd);g2.addNode(ne);g2.addNode(nf);
		g2.addEdge(ee1);g2.addEdge(ee2);g2.addEdge(ee3);
		return g2;
	}

}
