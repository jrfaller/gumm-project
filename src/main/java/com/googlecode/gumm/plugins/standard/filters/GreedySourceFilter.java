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

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.utils.treap.IndexedObject;

/**
 * A filter that uses a greedy heuristic to compute a 1 to 1 cardinality alignment, ensuring that every node from the source
 * graph will be assigned a matching node in the target graph.
 * @author Jean-Rémy Falleri
 *
 */
public class GreedySourceFilter extends Filter {

	@Override
	public void filter() {
		List<Integer> toDelete = new LinkedList<Integer>();
		
		for( IndexedObject<Mapping> pair: alignment.getMappings() ) {
			int id = pair.getKey();
			Mapping m = pair.getValue();
			if ( alignment.bestMappingForSourceNode(m.getSourceNode().getId()) != m )
				toDelete.add(id);
		}
		alignment.removeMappings(toDelete);
	}

}
