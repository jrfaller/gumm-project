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

package com.googlecode.gumm.flood.graph;

import java.util.LinkedList;
import java.util.List;

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.graph.*;
import com.googlecode.gumm.utils.treap.*;

/**
 * A connectivity graph composed of compatibility nodes. It is implemented with an adjacency list for each node 
 * containing the nodes linked to this node, with this node as source.
 * @author Jean-Rémy Falleri
 */
public class ConnectivityGraph extends CompatibilityGraph {

	protected IntObjectTreap<AdjLabeledCompNodes> edges;
	
	/**
	 * Creates a connectivity graph with the given id manager, source graph and target graph.
	 * @param idManager an id manager.
	 * @param sourceGraph a source graph.
	 * @param targetGraph a target graph.
	 */
	public ConnectivityGraph(IdManager idManager,ModelGraphItf sourceGraph,ModelGraphItf targetGraph) {
		this.idManager = idManager;
		nodes = new IntObjectTreap<CompatibilityNode>();
		edges = new IntObjectTreap<AdjLabeledCompNodes>();
		build(sourceGraph,targetGraph);
	}

	/**
	 * Adds reverse edges to the connectivity graph.
	 */
	public void complete() {
		List<LabeledEdge> newEdges = new LinkedList<LabeledEdge>();
		for( IndexedObject<CompatibilityNode> pair: getCompatibilityNodes() ) {
			for(AdjLabeledCompNode targetAdjacentNode: getTargetNodes(pair.getValue())) {
				CompatibilityNode targetNode = targetAdjacentNode.getNode();
				newEdges.add(new LabeledEdge(targetNode,pair.getValue(),targetAdjacentNode.getLabel()));
			}
		}

		for(LabeledEdge edge: newEdges)
			createEdge((CompatibilityNode) edge.getSource(), (CompatibilityNode) edge.getTarget(), edge.getLabel());
	}

	/**
	 * Creates an edge in the connectivity graph.
	 * @param source the source node.
	 * @param target the target node.
	 * @param label the edge label.
	 */
	public void createEdge(CompatibilityNode source, CompatibilityNode target,String label) {
		edges.get(source.getId()).add(new AdjLabeledCompNode(target,label));
	}

	/**
	 * Returns the number of edges with the given label going out the given node.
	 * @param node a node.
	 * @param label 
	 * @return the number of edges.
	 */
	public int getEdgesNb(CompatibilityNode node, String label) {
		int nb = 0;

		for(AdjLabeledCompNode lan: edges.get(node.getId()))
			if ( lan.getLabel().equals(label))
				nb++;

		return nb;
	}

	/**
	 * Returns the adjacent nodes to the given node/
	 * @param node a node.
	 * @return the list of adjacent nodes.
	 */
	public List<AdjLabeledCompNode> getTargetNodes(CompatibilityNode node) {
		return edges.get(node.getId());
	}

	public List<LabeledEdge> getEdges() {
		LinkedList<LabeledEdge> edgeList = new LinkedList<LabeledEdge>();

		for( IndexedObject<AdjLabeledCompNodes> pair: edges )
			for ( AdjLabeledCompNode lan: pair.getValue() )
				edgeList.add(new LabeledEdge(nodes.get(pair.getKey()),lan.getNode(),lan.getLabel()));

		return edgeList;
	}

	public int getEdgesNb() {
		int e = 0;
		
		for( IndexedObject<AdjLabeledCompNodes> pair: edges )
			e += pair.getValue().size();
		
		return e;
	}
	
	@Override
	public String toString() {
		return "Connectivity Graph with: " + getNodesNb() + " nodes and with " + getEdgesNb() + " edges.";
	}
	

	private void build(ModelGraphItf sourceGraph,ModelGraphItf targetGraph) {
		// Creations of the compatibility nodes.
		// Iterates on every pair (e1,e2) of edges in the source and target graphs.
		for( LabeledEdge e1: sourceGraph.getEdges() ) {
			for( LabeledEdge e2: targetGraph.getEdges() ) {
				// When the (e1,e2) have the same label
				if ( e1.getLabel().equals(e2.getLabel() ) ) {
					LabeledNode s1 = (LabeledNode) e1.getSource();
					LabeledNode s2 = (LabeledNode) e2.getSource();
					LabeledNode t1 = (LabeledNode) e1.getTarget();
					LabeledNode t2 = (LabeledNode) e2.getTarget();
					
					// Checks if the source and target nodes of the edges are compatible.
					if ( s1.getType().equals(s2.getType()) && t1.getType().equals(t2.getType()) ) {
						CompatibilityNode s = createCompatibilityNode(s1,s2);
						CompatibilityNode t = createCompatibilityNode(t1,t2);
						
						// If the adjacency list of the node is null, initializes it.
						if ( !edges.hasKey(s.getId()) )
							edges.put(s.getId(),new AdjLabeledCompNodes());

						edges.get(s.getId()).add(new AdjLabeledCompNode(t,e1.getLabel()));
					}
				}
			}
		}

		// Finish initialization of adjacency lists.
		for( IndexedObject<CompatibilityNode> pair: nodes ) {
			int key = pair.getKey();
			if ( !edges.hasKey(key) )
				edges.put(key,new AdjLabeledCompNodes());
		}

	}

}
