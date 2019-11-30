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
 * An adjacent labeled node class.
 * @author Jean-Rémy Falleri
 *
 */
public class AdjLabeledNode {

	private LabeledNode node;
	
	private String label;
	
	/**
	 * Creates a new adjacent node with the given labeled node and the given edge label.
	 * @param node a node.
	 * @param label a label.
	 */
	public AdjLabeledNode(LabeledNode node, String label) {
		this.node = node;
		this.label = label;
	}

	/**
	 * Returns the node.
	 * @return a node.
	 */
	public LabeledNode getNode() {
		return node;
	}

	/**
	 * Returns the label of the edge connecting the node.
	 * @return a label.
	 */
	public String getLabel() {
		return label;
	}

}
