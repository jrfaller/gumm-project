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

package com.googlecode.gumm.flood.graph;

public class AdjWeightedCompNode {
	
	private CompatibilityNode node;
	
	private float weight;
	
	public AdjWeightedCompNode(CompatibilityNode node,float weight) {
		this.node = node;
		this.weight = weight;
	}
	
	public CompatibilityNode getNode() {
		return node;
	}

	public float getWeight() {
		return weight;
	}

}
