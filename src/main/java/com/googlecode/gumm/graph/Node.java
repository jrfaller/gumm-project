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

package com.googlecode.gumm.graph;

/**
 * A node class with a numeric id.
 * @author Jean-Rémy Falleri
 *
 */
public class Node implements Comparable<Node> {
	
	protected int id;
	
	/**
	 * Creates a node with the given id.
	 * @param id an id.
	 */
	public Node(int id) {
		this.id = id;
	}

	/**
	 * Returns the id of the node.
	 * @return the id of the node.
	 */
	public int getId() {
		return id;
	}

	public int compareTo(Node n2) {
		return this.id - n2.id;
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object o) {
		if ( o instanceof Node )
			return ( ((Node) o).id == this.id  );
		else
			return false;
	}
	
	@Override
	public String toString() {
		return Integer.toString(getId());
	}
	
}
