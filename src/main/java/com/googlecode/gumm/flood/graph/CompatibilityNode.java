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

import com.googlecode.gumm.graph.LabeledNode;
import com.googlecode.gumm.graph.Node;

/**
 * A compatibility node groups two nodes from a graph 1 and a graph 2.
 * @author Jean-Rémy Falleri
 *
 */
public class CompatibilityNode extends Node {
	
	private LabeledNode sourceNode;
	
	private LabeledNode targetNode;
	
	/**
	 * Creates a compatibility node with the given ID between two given nodes.
	 * @param sourceNode a node from the source graph.
	 * @param targetNode a node from the target graph.
	 * @param id of the compatibility node.
	 */
	public CompatibilityNode(int id, LabeledNode sourceNode, LabeledNode targetNode) {
		this(id);
		this.sourceNode = sourceNode;
		this.targetNode = targetNode;
	}
	
	public CompatibilityNode(int id) {
		super(id);
	}

	/**
	 * Returns the node from the source graph involved in this compatibility
	 * node.
	 * @return a node from the source graph.
	 */
	public LabeledNode getSourceNode() {
		return sourceNode;
	}

	/**
	 * Returns the node from the target graph involved in this compatibility
	 * node.
	 * @return a node from the target graph.
	 */
	public LabeledNode getTargetNode() {
		return targetNode;
	}
	
	@Override
	public String toString() {
		return /*getID() + ": " +*/ "(" + sourceNode.toString() + "," + targetNode.toString() + ")";
	}
	
}
