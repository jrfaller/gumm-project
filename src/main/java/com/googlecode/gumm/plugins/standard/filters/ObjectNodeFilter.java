package com.googlecode.gumm.plugins.standard.filters;

import java.util.LinkedList;

import com.googlecode.gumm.flood.Filter;
import com.googlecode.gumm.flood.Mapping;
import com.googlecode.gumm.graph.ObjectNode;
import com.googlecode.gumm.utils.treap.IndexedObject;

/**
 * Filters that removes every mapping that involves an object node from the alignment.
 * @author Jean-Rémy Falleri
 */
public class ObjectNodeFilter extends Filter {

	public void filter() {
		LinkedList<Integer> toRemove = new LinkedList<Integer>();
		
		for( IndexedObject<Mapping> pair: alignment) {
			Mapping m = pair.getValue();
			int id = pair.getKey();
			if ( m.getSourceNode() instanceof ObjectNode || m.getTargetNode() instanceof ObjectNode )
				toRemove.add(id);
		}
		alignment.removeMappings(toRemove);
	}

}
