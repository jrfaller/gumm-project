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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An input graph allows to represent a directed graph with labeled nodes and edges.
 * Its internal representation is an incidence graph (a set of nodes and a set of edges). 
 * @author Jean-Rémy Falleri
 */
public class ModelGraph implements ModelGraphItf {
	
	private int lastNodeID;
	
	private List<LabeledNode> nodes;
	
	private List<LabeledEdge> edges;
	
	private Map<Object,ObjectNode> objectNodeMap;
	
	private Map<String,Map<String,ValueNode>> valueNodeMap;
	
	/**
	 * Creates an empty source graph.
	 */
	public ModelGraph() {
		nodes = new ArrayList<LabeledNode>();
		edges = new ArrayList<LabeledEdge>();
		
		objectNodeMap = new HashMap<Object, ObjectNode>();
		valueNodeMap = new HashMap<String, Map<String,ValueNode>>();
		
		lastNodeID = 0;
	}
	
	/**
	 * Converts the source graph to an adjacent source graph.
	 * @return an adjacent source graph.
	 */
	public AdjModelGraph toAdjInputGraph() {
		return new AdjModelGraph(this);
	}
	
	/**
	 * Creates a new object node with the next available ID. This node is automatically added in the graph.
	 * @param label the label of the node.
	 * @return the created labeled node.
	 */
	public ObjectNode createObjectNode(String label,Object object,String type) {
		ObjectNode n = new ObjectNode(lastNodeID,label,type,object);
		lastNodeID++;
		objectNodeMap.put(object, n);
		addNode(n);
		return n;
	}
	
	/**
	 * Creates a sink node for the given value of the given type.
	 * @param value a value.
	 * @param type a type.
	 * @return a sink node.
	 */
	public ValueNode createValueNode(String value,String type) {
		ValueNode n = new ValueNode(lastNodeID,value,type);
		lastNodeID++;
		
		if ( !valueNodeMap.containsKey(type) )
			valueNodeMap.put(type,new HashMap<String, ValueNode>());
		
		valueNodeMap.get(type).put(value,n);
		addNode(n);
		return n;
	}
	
	/**
	 * Returns the object node corresponding to the given object if it exists, null either.
	 * @param object an object.
	 * @return an object node.
	 */
	public ObjectNode nodeForObject(Object object) {
		return objectNodeMap.get(object);
	}
	
	/**
	 * Returns the sink node corresponding to the given value if it exists, null either.
	 * @param value value of the sink node.
	 * @param type type of the sink node.
	 * @return a value node.
	 */
	public ValueNode nodeForValue(String value,String type) {
		if ( !valueNodeMap.containsKey(type) )
			return null;
		
		return valueNodeMap.get(type).get(value);
	}
	
	/**
	 * Creates a directed labeled edge between the two given labeled node, with the given label.
	 * The edge is automatically added in the graph.
	 * @param source the source labeled node.
	 * @param target the target labeled node.
	 * @param label the label of the edge.
	 * @return the created directed labeled edge.
	 */
	public LabeledEdge createEdge(LabeledNode source, LabeledNode target, String label) {
		LabeledEdge e = new LabeledEdge(source,target,label);
		addEdge(e);
		return e;
	}
	
	/**
	 * Adds the given labeled node to the graph.
	 * @param node a labeled node.
	 */
	public void addNode(LabeledNode node) {
		nodes.add(node);
	}
	
	/**
	 * Adds the given labeled directed edge to the graph.
	 * @param edge a directed labeled edge.
	 */
	public void addEdge(LabeledEdge edge) {
		edges.add(edge);
	}
	
	/**
	 * Returns the map between object and object nodes.
	 * @return the map between object and object nodes.
	 */
	public Map<Object,ObjectNode> getObjectNodesMap() {
		return this.objectNodeMap;
	}
	
	/**
	 * Tests if there is now value node that is source of
	 * an edge of the graph;
	 * @return
	 */
	public boolean isOk() {
		boolean ok = true;
		for( LabeledEdge edge: edges )
			if ( edge.getSource() instanceof ValueNode )
				ok = false;
		
		return ok;
	}
	
	public int getNodesNb() {
		return nodes.size();
	}
	
	public int getEdgesNb() {
		return edges.size();
	}

	public List<LabeledNode> getNodes() {
		return nodes;
	}

	public List<LabeledEdge> getEdges() {
		return edges;
	}
	
	@Override
	public String toString() {
		return "Input graph with " + getNodesNb() + " nodes and " + getEdgesNb() + " edges. Is ok: " + isOk();
	}
	
}
