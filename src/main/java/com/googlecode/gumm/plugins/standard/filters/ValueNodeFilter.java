package com.googlecode.gumm.plugins.standard.filters;

import java.util.LinkedList;

import com.googlecode.gumm.flood.Filter;
import com.googlecode.gumm.flood.Mapping;
import com.googlecode.gumm.graph.ValueNode;
import com.googlecode.gumm.utils.treap.IndexedObject;

/**
 * Filters that removes every mapping that involves a value node from the alignment.
 * @author Jean-Rémy Falleri
 */
public class ValueNodeFilter extends Filter {

	public void filter() {
		LinkedList<Integer> toRemove = new LinkedList<Integer>();
		
		for( IndexedObject<Mapping> pair: alignment) {
			Mapping m = pair.getValue();
			int id = pair.getKey();
			if ( m.getSourceNode() instanceof ValueNode || m.getTargetNode() instanceof ValueNode )
				toRemove.add(id);
		}
		alignment.removeMappings(toRemove);
	}

}
