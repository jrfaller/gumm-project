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
 * A directed edge.
 * @author Jean-Rémy Falleri
 *
 */
public class Edge {
	
	private Node source;
	
	private Node target;
	
	/**
	 * Creates a directed edges between two given nodes.
	 * @param source a node.
	 * @param target a node.
	 */
	public Edge(Node source,Node target) {
		this.source = source;
		this.target = target;
	}

	/**
	 * Returns the source node of the edge.
	 * @return the source node of the edge.
	 */
	public Node getSource() {
		return source;
	}

	/**
	 * Returns the target node of the edge.
	 * @return the target node of the edge.
	 */
	public Node getTarget() {
		return target;
	}
	
	@Override
	public String toString() {
		return "";
	}

}
