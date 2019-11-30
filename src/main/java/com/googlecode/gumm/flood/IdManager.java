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

package com.googlecode.gumm.flood;

import java.util.HashSet;
import java.util.Set;

import com.googlecode.gumm.graph.ModelGraphItf;
import com.googlecode.gumm.utils.treap.IntObjectTreap;

/**
 * Utility class the helps computing unique ids.
 * @author Jean-Rémy Falleri
 *
 */
public class IdManager {
	
	private int sourceNodeNb;
	
	private int targetNodeNb;
	
	private int maxNodeId;
	
	public IdManager(int sourceNodeNumber,int targetNodeNumber) {
		this.sourceNodeNb = sourceNodeNumber;
		this.targetNodeNb = targetNodeNumber;
		this.maxNodeId = sourceNodeNumber * targetNodeNumber;
	}
	
	public IdManager(ModelGraphItf sourceGraph,ModelGraphItf targetGraph) {
		this(sourceGraph.getNodesNb(),targetGraph.getNodesNb());
	}
	
	/**
	 * Computes an unique id for the given source and target node ids. 
	 * @param sourceNodeId a source node id.
	 * @param targetNodeId a target node id.
	 * @return an unique id.
	 */
	public int computeUniqueId(int sourceNodeId,int targetNodeId) {
		return (targetNodeId * (sourceNodeNb)) + sourceNodeId;
	}

	/**
	 * Compute the original ids that led to the creation of the unique given id.
	 * @param id an id.
	 * @return an array of ids with first element associated to the source id and second
	 * element associated to the target id.
	 */
	public int[] computeOriginalIds(int id) {
		int[] result = new int[2];
		result[0] = id % (sourceNodeNb);
		result[1] = id / (sourceNodeNb);
		return result;
	}
	
	/**
	 * Returns the list of all computed ids that involves the source node with the given id. 
	 * @param sourceNodeId the id of the source node.
	 * @param container the treap container that contains the compatibility nodes.
	 * @return a set of ids.
	 */
	public Set<Integer> candidatesForSourceId(int sourceNodeId,IntObjectTreap<?> container) {
		Set<Integer> candidates = new HashSet<Integer>();
		
		for( int targetNodeId = 0 ; targetNodeId < targetNodeNb ; targetNodeId++ ) {
			int id = computeUniqueId(sourceNodeId,targetNodeId);
			if ( container.hasKey(id) )
				candidates.add(id);
		}
			
		return candidates;
	}
	
	/**
	 * Returns the list of all computed ids that involves the target node with the given id. 
	 * @param targetNodeId the id of the target node.
	 * @param container the treap container that contains the compatibility nodes.
	 * @return a set of ids.
	 */
	public Set<Integer> candidatesForTargetId(int targetNodeId,IntObjectTreap<?> container) {
		Set<Integer> candidates = new HashSet<Integer>();
		
		for( int sourceNodeId = 0 ; sourceNodeId < sourceNodeNb ; sourceNodeId++ ) {
			int id = computeUniqueId(sourceNodeId,targetNodeId);
			if ( container.hasKey(id) )
				candidates.add(id);
		}
			
		return candidates;
	}
	
	/**
	 * Returns the number of node in the source graph.
	 * @return the number of node in the source graph.
	 */
	public int getSourceNodeNb() {
		return sourceNodeNb;
	}
	
	/**
	 * Returns the number of node in the target graph.
	 * @return the number of node in the target graph.
	 */
	public int getTargetNodeNb() {
		return targetNodeNb;
	}

	/**
	 * Returns the maximum unique id given the source and target graph sizes.
	 * @return  the maximum unique id that can be computed.
	 */
	public int getMaxNodeId() {
		return maxNodeId;
	}
	
	@Override
	public String toString() {
		return "Id manager with " + getSourceNodeNb() + " source nodes and " + getTargetNodeNb() + " target nodes. Id range is between 0 and " + getMaxNodeId() + "."; 
	}

}
