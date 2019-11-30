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

package com.googlecode.gumm.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * An adjacent source graph allow to represent a directed graph with labeled nodes and edges. The internal
 * representation is based on an adjacency list.
 * @author Jean-Rémy Falleri
 */
public class AdjModelGraph implements ModelGraphItf {
	
	private LabeledNode[] nodeArray;
	
	private AdjLabeledNodes[] edgeArray;
	
	/**
	 * Converts the given source graph to an adjacent source graph.
	 * @param g a source graph.
	 */
	public AdjModelGraph(ModelGraph g) {
		nodeArray = new LabeledNode[g.getNodes().size()];	
		for( LabeledNode n: g.getNodes() )
			nodeArray[n.getId()] = n;
		
		edgeArray = new AdjLabeledNodes[g.getNodes().size()];
		for(int i=0;i<edgeArray.length;i++)
			edgeArray[i] = new AdjLabeledNodes();
		for( LabeledEdge e: g.getEdges() )
			edgeArray[e.getSource().getId()].add(new AdjLabeledNode((LabeledNode) e.getTarget(),e.getLabel()));
	}
	
	/**
	 * Returns the nodes connected to the given labeled node.
	 * @param node a labeled node.
	 * @return a list containing the adjacent nodes. 
	 */
	public AdjLabeledNodes getTargetNodes(LabeledNode node) {
		return edgeArray[node.getId()];
	}
	
	/**
	 * Returns the nodes connected to the given labeled node by a labeled edge with the given label. 
	 * @param node a labeled node.
	 * @param label the label of the edge.
	 * @return a list containing the adjacent nodes.
	 */
	public AdjLabeledNodes getTargetNodes(LabeledNode node,String label) {
		AdjLabeledNodes nodes = new AdjLabeledNodes();
		for(AdjLabeledNode lan: getTargetNodes(node))
			if (lan.getLabel().equals(label))
				nodes.add(lan);
		
		return nodes;
	}
	
	/**
	 * Tests if there is no value node that is source of an edge of the graph.
	 * @return
	 */
	public boolean isOk() {
		boolean ok = true;
		for( LabeledEdge edge: this.getEdges() )
			if ( edge.getSource() instanceof ValueNode )
				ok = false;
		
		return ok;
	}
	
	/**
	 * Returns the number of cycles of the graph.
	 * @return the number of cycles.
	 */
	public int cycleNb() {
		int cycleNb = 0;
		for( LabeledNode n: this.getNodes() ) {
			List<LabeledNode> neighbours = adjLabeledNodesToList(getTargetNodes(n));
			Set<LabeledNode> visited = new HashSet<LabeledNode>();
			
			while ( neighbours.size() > 0 ) {
				LabeledNode neighbour = neighbours.remove(0);
				if ( neighbour == n ) {
					cycleNb++;
					break;
				}
				if ( !visited.contains(neighbour) ) {
					neighbours.addAll(adjLabeledNodesToList(getTargetNodes(neighbour)));
					visited.add(neighbour);
				}
			}
			
		}
		return cycleNb;
	}
	
	public int getNodesNb() {
		return nodeArray.length;
	}
	
	public int getEdgesNb() {
		int size = 0;
		for(int i=0;i<edgeArray.length;i++)
			size += edgeArray[i].size();
		
		return size;
	}
	
	public List<LabeledNode> getNodes() {
		return Arrays.asList(nodeArray);
	}
	
	public List<LabeledEdge> getEdges() {
		LinkedList<LabeledEdge> edges = new LinkedList<LabeledEdge>();
		for(int i=0;i<edgeArray.length;i++)
			for(AdjLabeledNode lan: edgeArray[i])
				edges.add(new LabeledEdge(nodeArray[i],lan.getNode(),lan.getLabel()));
		
		return edges;
	}
	
	@Override
	public String toString() {
		return "Adjacent input graph with " + getNodesNb() + " nodes and " + getEdgesNb() + " edges. Is ok: " + isOk(); 
	}
	
	private List<LabeledNode> adjLabeledNodesToList(AdjLabeledNodes adjNodes) {
		List<LabeledNode> nodes = new LinkedList<LabeledNode>();
		for( AdjLabeledNode adjNode: adjNodes )
			nodes.add(adjNode.getNode());
		
		return nodes;
	}
	
}
