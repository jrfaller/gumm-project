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

package com.googlecode.gumm.junit;

import static org.junit.Assert.*;
import org.junit.Test;

import com.googlecode.gumm.flood.IdManager;
import com.googlecode.gumm.graph.*;

public class IdManagerTest {
	
	@Test
	public void testRank() {
		ModelGraph g1 = new ModelGraph();
		ModelGraph g2 = new ModelGraph();
		
		for(int i=0;i<20;i++)
			g1.addNode(new LabeledNode(i));
		
		for(int i=0;i<30;i++)
			g2.addNode(new LabeledNode(i));
		
		IdManager idManager = new IdManager(g1.getNodesNb(),g2.getNodesNb());
		
		for(int i=0;i<20;i++) {
			for(int j=0;j<30;j++) {
				int rank = idManager.computeUniqueId(i,j);
				int[] ids = idManager.computeOriginalIds(rank);
				assertTrue(ids[0] == i);
				assertTrue(ids[1] == j);
			}
		}
		
		assertTrue(idManager.computeUniqueId(0,0) == 0);
		assertTrue(idManager.computeUniqueId(19,29) == 20*30 - 1);
	}

}
