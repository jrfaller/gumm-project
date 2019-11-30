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

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.utils.MunkresAlgorithm;
import com.googlecode.gumm.utils.treap.IndexedObject;

/**
 * Applies the Munkres algorithm to compute a maximum weight 1 to 1 alignment.
 * @author Jean-Rémy Falleri
 */
public class MunkresFilter extends Filter {

	@Override
	public void filter() {
		float[][] costMatrix = new float[alignment.getIdManager().getSourceNodeNb()][alignment.getIdManager().getTargetNodeNb()];

		for(int i = 0 ; i < alignment.getIdManager().getSourceNodeNb() ; i++ )
			for(int j = 0 ; j < alignment.getIdManager().getTargetNodeNb() ; j++ )
				costMatrix[i][j] = Sigma.MIN_WEIGHT;

		for( IndexedObject<Mapping> pair: alignment.getMappings() ) {
			int id = pair.getKey();
			Mapping m = pair.getValue();
			int[] ids = alignment.getIdManager().computeOriginalIds(id);
			costMatrix[ids[0]][ids[1]] = m.getSimilarity(); 
		}

		MunkresAlgorithm algo = new MunkresAlgorithm(costMatrix);

		int[][] assignments = algo.getAssigments();

		for( IndexedObject<Mapping> pair: alignment.getMappings() ) {
			int id = pair.getKey();
			if ( ! inAssignment(id, assignments))
				alignment.removeMapping(id);
		}
	}

	private boolean inAssignment(int id,int[][] assignments) {
		int[] assigment = alignment.getIdManager().computeOriginalIds(id);
		for(int i = 0 ; i < assignments.length ; i++ )
			if ( assigment[0] == assignments[i][0] && assigment[1] == assignments[i][1])
				return true;

		return false;
	}

}
