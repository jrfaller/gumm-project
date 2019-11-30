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
 * A node representing a value from the "real" world.
 * @author Jean-Rémy Falleri
 *
 */
public class ValueNode extends LabeledNode {
	
	/**
	 * Basic integer type.
	 */
	public static final String TYPE_INTEGER = "Integer";

	/**
	 * Basic float type.
	 */
	public static final String TYPE_FLOAT = "Float";
	
	/**
	 * Basic string type.
	 */
	public static final String TYPE_STRING = "String";
	
	/**
	 * Basic boolean type.
	 */
	public static final String TYPE_BOOLEAN = "Boolean";

	/**
	 * Basic date type.
	 */
	public static final String TYPE_DATE = "Date";
	
	/**
	 * Creates a sink node with the given id and type.
	 * @param id an id.
	 * @param label a label.
	 * @param type a type.
	 */
	public ValueNode(int id,String label,String type) {
		super(id,label,type);
	}
	
	/**
	 * Creates a sink node with the given id;
	 * @param id
	 */
	public ValueNode(int id) {
		this(id,"","");
	}
	
	@Override
	public String toString() {
		return getLabel();
	}

}
