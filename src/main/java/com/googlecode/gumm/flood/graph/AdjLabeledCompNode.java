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

/**
 * A convenience class used to represent a graph of compatibility nodes through an adjacency list.
 * @author Jean-Rémy Falleri
 *
 */
public class AdjLabeledCompNode {

	private CompatibilityNode node;
	
	private String label;
	
	public AdjLabeledCompNode(CompatibilityNode node,String label) {
		this.node = node;
		this.label = label;
	}
	
	public CompatibilityNode getNode() {
		return node;
	}

	public String getLabel() {
		return label;
	}
	
}
