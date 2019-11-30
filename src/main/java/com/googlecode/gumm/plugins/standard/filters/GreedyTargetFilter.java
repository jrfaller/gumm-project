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

package com.googlecode.gumm.plugins.standard.filters;

import java.util.LinkedList;
import java.util.List;

import com.googlecode.gumm.flood.Filter;
import com.googlecode.gumm.flood.Mapping;
import com.googlecode.gumm.utils.treap.IndexedObject;

/**
 * A filter that uses a greedy heuristic to compute a 1 to 1 cardinality alignment, ensuring that every node from the target
 * graph will be assigned a matching node in the source graph.
 * @author Jean-Rémy Falleri
 *
 */
public class GreedyTargetFilter extends Filter {
	
	@Override
	public void filter() {
		List<Integer> toRemove = new LinkedList<Integer>();
		
		for(IndexedObject<Mapping> pair: alignment.getMappings() ) {
			int id = pair.getKey();
			if ( alignment.getMapping(id) != null )
				if ( alignment.bestMappingForTargetNode(alignment.getMapping(id).getTargetNode().getId()) != alignment.getMapping(id) )
					toRemove.add(id);
		}
		alignment.removeMappings(toRemove);
	}

}
