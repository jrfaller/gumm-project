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

package com.googlecode.gumm.utils.treap;

/**
 * A pair key (int) value (T).
 * @author Jean-Rémy Falleri
 * @param <T> type of the value.
 */
public class IndexedObject<T> extends IndexedValue {

	private T value;

	public IndexedObject(int key,T value) {
		super(key);
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
}
