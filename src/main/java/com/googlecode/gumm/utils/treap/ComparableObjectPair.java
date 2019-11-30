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
 * A pair K (key, extends Comparable<K>), V (value).
 * @author Jean-Rémy Falleri
 * @param <K> type of the key (must extends Comparable<K>).
 * @param <V> type of the value.
 */
public class ComparableObjectPair<K extends Comparable<K>,V> {
	
	private V value;
	
	private K key;
	
	public V getValue() {
		return value;
	}

	public K getKey() {
		return key;
	}
	
	public ComparableObjectPair(K key,V value) {
		this.key = key;
		this.value = value;
	}

}
