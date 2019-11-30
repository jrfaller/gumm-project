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
 * A labeled and typed node.
 * @author Jean-Rémy Falleri
 *
 */
public class LabeledNode extends Node {
	
	protected String label;
	
	protected String type;
	
	/**
	 * Returns the type of the node.
	 * @return a type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the node.
	 * @param type a type.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Creates a labeled node with the given ID and label.
	 * @param ID an ID.
	 * @param label a label.
	 */
	public LabeledNode(int id,String label,String type) {
		super(id);
		this.label = label;
		this.type = type;
		if ( label == null )
			this.label = "";
		if ( type == null )
			this.type = "";
	}
	
	/**
	 * Creates a labeled node with a given id and no label.
	 * @param ID an ID.
	 */
	public LabeledNode(int id) {
		this(id,"","");
	}
	
	/**
	 * Returns the label of the node.
	 * @return the label of the node.
	 */
	public String getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return getLabel();
	}

}
