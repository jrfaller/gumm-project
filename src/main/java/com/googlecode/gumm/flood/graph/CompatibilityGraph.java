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

public abstract class CompatibilityGraph implements GraphItf {
	
	protected IntObjectTreap<CompatibilityNode> nodes;
	
	protected IdManager idManager;

	public CompatibilityNode createCompatibilityNode(LabeledNode sourceNode,LabeledNode targetNode) {
		int id = idManager.computeUniqueId(sourceNode.getId(),targetNode.getId());
		
		if ( ! nodes.hasKey(id) ) 
			nodes.put(id,new CompatibilityNode(id,sourceNode,targetNode));

		return nodes.get(id);
	}
	
	/**
	 * Returns the id manager associated to the compatibility graph.
	 * @return an id manager.
	 */
	public IdManager getIdManager() {
		return this.idManager;
	}

	/**
	 * Returns the compatibility node with the given id.
	 * @param id an id.
	 * @return a compatibility node.
	 */
	public CompatibilityNode getCompatibilityNode(int id) {
		return nodes.get(id);
	}
	
	/**
	 * Returns the treap containing all the compatibility nodes.
	 * @return a treap.
	 */
	public IntObjectTreap<CompatibilityNode> getCompatibilityNodes() {
		return nodes;
	}

	/**
	 * Returns true if the compatibility node with the given id exists, false either.
	 * @param id an id.
	 * @return a boolean.
	 */
	public boolean hasCompatibilityNode(int id) {
		return nodes.hasKey(id);
	}

	public int getNodesNb() {
		return nodes.size();
	}
	
	public List<CompatibilityNode> getNodes() {
		List<CompatibilityNode> nodeList = new LinkedList<CompatibilityNode>();
		
		for( IndexedObject<CompatibilityNode> pair : nodes )
			nodeList.add(pair.getValue());
		
		return nodeList;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " with " + getNodesNb() + " nodes.";
	}

}
