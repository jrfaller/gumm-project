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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.utils.treap.IndexedObject;

/**
 * Filter based on the one described in the article on Similarity Flooding.
 * 
 * <blockquote>
 * S. Melnik, H. Garcia-Molina and E. Rahm. Similarity Flooding: a Versatile Graph Matching
 * algorithm and its Application to Schema Matching.
 * <em>ICDE</em>, 117-128, 2002.
 * </blockquote>
 * 
 * @author Jean-Rémy Falleri
 */
public class ThresholdFilter extends Filter {

	private float limit;

	/**
	 * Creates a threshold filter with a given limit.
	 * @param limit the limit under which mappings are removed from the alignment (between 0 and 1).
	 */
	public ThresholdFilter(float limit) {
		this.limit = limit;
	}

	@Override
	public void filter() {
		Map<Integer,Mapping> sourceBestMatches = new HashMap<Integer,Mapping>();
		Map<Integer,Mapping> targetBestMatches = new HashMap<Integer,Mapping>();
		
		LinkedList<Integer> toRemove = new LinkedList<Integer>();
		
		for( IndexedObject<Mapping> pair: alignment.getMappings() ) {
			Mapping m = pair.getValue();
			
			if ( sourceBestMatches.get(m.getSourceNode().getId()) == null )
				sourceBestMatches.put(m.getSourceNode().getId(), alignment.bestMappingForSourceNode(m.getSourceNode().getId()));
			if ( targetBestMatches.get(m.getTargetNode().getId()) == null )
				targetBestMatches.put(m.getTargetNode().getId(), alignment.bestMappingForTargetNode(m.getTargetNode().getId()));

			float bestMatchForSource = sourceBestMatches.get(m.getSourceNode().getId()).getSimilarity();
			float bestMatchForTarget = targetBestMatches.get(m.getTargetNode().getId()).getSimilarity();

			float simSourceTarget = m.getSimilarity() / bestMatchForSource;
			float simTargetSource = m.getSimilarity() / bestMatchForTarget;

			if ( !( simSourceTarget >= limit && simTargetSource >= limit ) )
				toRemove.add(pair.getKey());
		}
		alignment.removeMappings(toRemove);
	}

}
