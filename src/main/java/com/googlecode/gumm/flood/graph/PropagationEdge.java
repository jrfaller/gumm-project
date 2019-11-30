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

import java.text.NumberFormat;

import com.googlecode.gumm.graph.*;

/**
 * Directed and weighted edges.
 * @author Jean-Rémy Falleri
 *
 */
public class PropagationEdge extends Edge {
	
	private float weight;
	
	/**
	 * Creates a weighted edge between the two given nodes with the given weight.
	 * @param source a node.
	 * @param target a node.
	 * @param weight a weight.
	 */
	public PropagationEdge(Node source,Node target,float weight) {
		super(source,target);
		this.weight  = weight;
	}
	
	/**
	 * Returns the weight of the edge.
	 * @return the weight of the edge.
	 */
	public float getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return NumberFormat.getInstance().format(weight);
	}
	
}
