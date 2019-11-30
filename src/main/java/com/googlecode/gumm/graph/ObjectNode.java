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
 * Node that represent an object of the "real" world.
 * @author Jean-Rémy Falleri
 */
public class ObjectNode extends LabeledNode {
	
	protected Object object;

	/**
	 * Creates an object node with the given id, label, object and type.
	 * @param id an id.
	 * @param label a label.
	 * @param type a type.
	 * @param object an object.
	 */
	public ObjectNode(int id,String label,String type,Object object) {
		super(id,label,type);
		this.object = object;
	}

	/**
	 * Creates an object node with the given id.
	 * @param id
	 */
	public ObjectNode(int id) {
		this(id,"","",null);
	}
	
	/**
	 * Sets the object associated to the node.
	 * @param object an object.
	 */
	public void setObject(Object object) {
		this.object = object;
	}
	
	/**
	 * Returns the object associated to the node.
	 * @return an object.
	 */
	public Object getObject() {
		return this.object;
	}
	
	@Override
	public String toString() {
		return "|" + label + "|";
	}

}
