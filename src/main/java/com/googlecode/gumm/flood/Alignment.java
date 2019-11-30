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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import com.googlecode.gumm.utils.treap.IndexedObject;
import com.googlecode.gumm.utils.treap.IntObjectTreap;

/**
 * A mapping represents a collection of matches between labeled nodes from a source graph
 * to labeled node from a target graph.
 * 
 * @author Jean-Rémy Falleri
 */
public class Alignment implements Iterable<IndexedObject<Mapping>> {

	private IntObjectTreap<Mapping> mappings;
	
	private IdManager idManager;
	
	/**
	 * Creates an alignement using the given id manager.
	 * @param idManager an id manager.
	 */
	public Alignment(IdManager idManager) {
		this.idManager = idManager;
		mappings = new IntObjectTreap<Mapping>();
	}
	
	public IdManager getIdManager() {
		return idManager;
	}
	
	/**
	 * Returns an iterator over the matches of the mapping.
	 */
	public Iterator<IndexedObject<Mapping>> iterator() {
		return mappings.iterator();
	}
	
	/**
	 * Returns the mapping with the given id.
	 * @param id a id.
	 * @return the mapping with the given id.
	 */
	public Mapping getMapping(int id) {
		return mappings.get(id);
	}

	/**
	 * Removes the mapping with the given id.
	 * @param id a id.
	 */
	public void removeMapping(int id) {
		mappings.remove(id);
	}
	
	/**
	 * Removes the mappings with the id in the given list.
	 * @param ids a collection of ids.
	 */
	public void removeMappings(Collection<Integer> ids) {
		for(int id: ids)
			removeMapping(id);
	}
	
	/**
	 * Adds a mapping to the list
	 * @param id the id of the mapping.
	 * @param m the mapping.
	 */
	public void setMapping(int id,Mapping m) {
		mappings.put(id,m);
	}

	public Set<Integer> mappingsForSourceNode(int sourceNodeId) {
		return idManager.candidatesForSourceId(sourceNodeId,mappings);
	}


	public Set<Integer> mappingsForTargetNode(int targetNodeId) {
		return idManager.candidatesForTargetId(targetNodeId,mappings);
	}
	
	
	/**
	 * Returns the best mapping from the labeled node from source graph with the given id.
	 * @param sourceNodeId id ID of a source node.
	 * @return the best mapping.
	 */
	public Mapping bestMappingForSourceNode(int sourceNodeId) {
		float bestSim = -1.0F;
		Mapping bestMapping = null;
		
		for( int id: mappingsForSourceNode(sourceNodeId) ) {
			if( mappings.get(id).getSimilarity() > bestSim ) {
				bestMapping = mappings.get(id);
				bestSim = bestMapping.getSimilarity();
			}
		}

		return bestMapping;
	}
	
	/**
	 * Returns the best mapping from the labeled node from target graph with the given ID.
	 * @param targetNodeId a ID.
	 * @return the best mapping.
	 */
	public Mapping bestMappingForTargetNode(int targetNodeId) {
		float bestSim = -1.0F;
		Mapping bestMapping = null;
		
		for( int id: mappingsForTargetNode(targetNodeId) ) {
			if( mappings.get(id).getSimilarity() > bestSim ) {
				bestMapping = mappings.get(id);
				bestSim = bestMapping.getSimilarity();
			}
		}

		return bestMapping;
	}
	
	public IntObjectTreap<Mapping> getMappings() {
		return mappings;
	}
	
	/**
	 * Output the current mapping to the given file.
	 * @param f a file.
	 * @throws IOException
	 */
	public void outputToFile(File f) throws IOException {
		FileWriter fw = new FileWriter(f);
		for( IndexedObject<Mapping> m: this)
			fw.append(m.getValue().getSourceNode().getLabel() + ";" + m.getValue().getTargetNode().getLabel() + ";" + m.getValue().getSimilarity() + "\n");
		fw.close();
	}
	
}
