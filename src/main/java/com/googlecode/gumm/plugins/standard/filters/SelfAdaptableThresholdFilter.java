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
import java.util.List;
import java.util.Map;

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.utils.treap.IndexedObject;

public class SelfAdaptableThresholdFilter extends Filter {

	@Override
	public void filter() {

		Map<Integer,Float> srcLimits = new HashMap<Integer, Float>();
		Map<Integer,Float> tgtLimits = new HashMap<Integer, Float>();

		List<Integer> toRemove = new LinkedList<Integer>();

		for( IndexedObject<Mapping> pair: alignment.getMappings() ) {
			Mapping m = pair.getValue();

			int srcId = m.getSourceNode().getId();
			int tgtId = m.getTargetNode().getId();

			float bestSrcWeight = alignment.bestMappingForSourceNode(m.getSourceNode().getId()).getSimilarity();
			float bestTgtWeight = alignment.bestMappingForTargetNode(m.getTargetNode().getId()).getSimilarity();

			float lSrc, lTgt;

			if ( !srcLimits.containsKey(srcId) ) {
				float srcMapWeight = 0F;

				int srcMapNb = 0;

				for( int srcM : alignment.mappingsForSourceNode(m.getSourceNode().getId()) ) {
					srcMapWeight += alignment.getMapping(srcM).getSimilarity() / bestSrcWeight;
					srcMapNb++;
				}

				float meanSrc = srcMapWeight / (float) srcMapNb;

				float varSrc = 0F;

				for( int srcM : alignment.mappingsForSourceNode(m.getSourceNode().getId()) )
					varSrc += Math.pow(meanSrc - (alignment.getMapping(srcM).getSimilarity()/bestSrcWeight),2D);

				varSrc = varSrc / (float) srcMapNb;

				lSrc = meanSrc + 2 * (float)Math.sqrt(varSrc);

				srcLimits.put(srcId,lSrc);
			}
			else
				lSrc = srcLimits.get(srcId);

			if ( !tgtLimits.containsKey(tgtId) ) {
				float tgtMapWeight = 0F;

				tgtMapWeight += 0F;

				int tgtMapNb = 0;


				for( int tgtM : alignment.mappingsForTargetNode(m.getTargetNode().getId()) ) {
					tgtMapWeight += alignment.getMapping(tgtM).getSimilarity() / bestTgtWeight;
					tgtMapNb++;
				}

				float meanTgt = tgtMapWeight / (float) tgtMapNb;

				float varTgt = 0F;

				for( int tgtM : alignment.mappingsForTargetNode(m.getTargetNode().getId()) )
					varTgt += (meanTgt - (alignment.getMapping(tgtM).getSimilarity()/bestTgtWeight))*(meanTgt - (alignment.getMapping(tgtM).getSimilarity()/bestTgtWeight));

				varTgt = varTgt / (float) tgtMapNb;

				lTgt = meanTgt + 2 * (float)Math.sqrt(varTgt);
			}
			else
				lTgt = tgtLimits.get(tgtId);


			if ( ( m.getSimilarity() / bestSrcWeight ) < lSrc || ( m.getSimilarity() / bestTgtWeight ) < lTgt )
				toRemove.add(pair.getKey());
		}
		alignment.removeMappings(toRemove);

	}

}
