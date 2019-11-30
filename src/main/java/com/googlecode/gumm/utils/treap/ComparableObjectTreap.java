/*
 * Copyright (C) 1997 Stefan Nilsson <Stefan.Nilsson@hut.fi>
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

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;

/**
 * An implentation of an ordered dictionary data structure, based
 * on the randomized search trees (treaps) by Seidel and Aragon.
 * <blockquote>
 * R. Seidel and C. R. Aragon. Randomized Binary Search Trees.
 * <em>Algorithmica</em>, 16(4/5):464-497, 1996.
 * </blockquote>
 *
 * This class is based on the implementation of Stefan Nilsson that can be found 
 * at <url>http://www.nada.kth.se/~snilsson/public/code/treap/</url>.
 * 
 * This implementation uses generic types to allow customization of types of the
 * keys and values stored in the treap. Type of the key must implements the 
 * Comparable interface.
 *  
 * Most methods run in <math>O(log n)</math> randomized time, where
 * <math>n</math> is the number of keys in the treap; the exceptions
 * are <code>clone()</code> and <code>toString()</code> that run in time
 * proportional to the size of their output.
 *
 * @author Jean-Rémy Falleri
 * @param <U> type of the keys of the treap, must implements Comparable<U>.
 * @param <W> type of the values of the treap. 
 */
public class ComparableObjectTreap<U extends Comparable<U>,W> implements Iterable<ComparableObjectPair<U,W>>
{
	private ComparableObjectTree<U,W> tree;
	
	private int size;
	
	private Random prio;

	/* If during an <code>insert()</code> or <code>delete()</code> it is
	 * found that the key is present in the tree, <code>keyFound</code>
	 * will be <code>true</code>.
	 */
	private boolean keyFound;

	/**
	 * Constructs a new empty treap.
	 */
	public ComparableObjectTreap() {
		tree = null;
		size = 0;
		prio = new Random();
	}

	/**
	 * Maps the key to the specified value in this treap.
	 * Neither the key, nor the value can be <code>null</code>.
	 */
	public synchronized void put(U key, W value) {
		ComparableObjectTree<U,W> node = new ComparableObjectTree<U,W>();
		node.key = key;
		node.value = value;
		node.prio = prio.nextInt();
		keyFound = false;
		tree = insert(node, tree);
		if ( !keyFound)
			size++;
	}

	/**
	 * Gets the object associated with the specified key in the treap.
	 * @return the value to which the key is mapped in the treap, or
	 * <code>null</code> if the key is not mapped to any value in
	 * this treap.
	 */
	public synchronized W get(U key) {
		ComparableObjectTree<U,W> t = tree;
		int comp;

		while (t != null && (comp = key.compareTo(t.key) ) != 0)
			if (comp < 0)
				t = t.left;
			else
				t = t.right;
		return t != null ? t.value : null;
	}
	
	/**
	 * Returns true if the key exists in the treap, false either.
	 * @param key a key.
	 * @return a boolean.
	 */
	public synchronized boolean hasKey(U key) {
		ComparableObjectTree<U,W> t = tree;
		int comp;

		while (t != null && (comp = key.compareTo(t.key) ) != 0)
			if (comp < 0)
				t = t.left;
			else
				t = t.right;
		
		return t != null ? true : false;
	}

	/**
	 * Returns the minimum key of the treap.
	 * @exception NoSuchElementException if the treap is empty.
	 */
	public synchronized U getMinKey() {
		ComparableObjectTree<U,W> t = tree;

		if (t == null)
			throw new NoSuchElementException("Treap");

		while (t.left != null)
			t = t.left;
		return t.key;
	}

	/**
	 * Returns the maximum key of the treap.
	 * @exception NoSuchElementException if the treap is empty.
	 */
	public synchronized U getMaxKey() {
		ComparableObjectTree<U,W> t = tree;

		if (t == null)
			throw new NoSuchElementException("Treap");
		while (t.right != null)
			t = t.right;
		
		return t.key;
	}

	/**
	 * Returns the value to which the minimum key of the treap is mapped.
	 * @exception NoSuchElementException if the treap is empty.
	 */
	public synchronized W getMinValue() {
		ComparableObjectTree<U,W> t = tree;

		if (t == null)
			throw new NoSuchElementException("Treap");
		while (t.left != null)
			t = t.left;
		return t.value;
	}

	/**
	 * Returns the value to which the maximum key of the treap is mapped.
	 * @exception NoSuchElementException if the treap is empty.
	 */
	public synchronized W getMaxValue() {
		ComparableObjectTree<U,W> t = tree;

		if (t == null)
			throw new NoSuchElementException("Treap");
		while (t.right != null)
			t = t.right;
		return t.value;
	}
	
	/**
	 * Returns an iterator over the keys and values stored in the treap,
	 * in ascending order of the key.
	 * @return an iterator.
	 */
	public synchronized Iterator<ComparableObjectPair<U,W>> iterator() {
		return new ComparableObjectTreapIterator<U,W>(tree,true);
	}
	
	/**
	 * Returns an iterator over the keys and values stored in the treap,
	 * in the given order of the key (ascending or descending).
	 * @param ascending order of the keys.
	 * @return an iterator.
	 */
	public synchronized Iterator<ComparableObjectPair<U,W>> iterator(boolean ascending) {
		return new ComparableObjectTreapIterator<U,W>(tree,ascending);
	}

	/**
	 * Returns <code>true</code> if this treap contains no mappings.
	 */
	public boolean isEmpty() {
		return tree == null;
	}

	/**
	 * Removes the key (and its corresponding value) from this treap.
	 * This method does nothing if the key is not in the treap.
	 */
	public synchronized void remove(U key) {
		keyFound = false;
		tree = delete(key, tree);
		if (keyFound)
			size--;
	}

	/**
	 * Removes the minimum key (and its corresponding value) from
	 * this treap. This method does nothing if the treap is empty.
	 */
	public synchronized void removeMin() {
		ComparableObjectTree<U,W> t = tree, tprev;

		if (tree == null)
			return;
		if (t.left == null)
			tree = t.right;
		else {
			do {
				tprev = t;
				t = t.left;
			} while (t.left != null);
			tprev.left = t.right;
		}
		size--;
	}

	/**
	 * Removes the maximum key (and its corresponding value) from
	 * this treap. This method does nothing if the treap is empty.
	 */
	public synchronized void removeMax() {
		ComparableObjectTree<U,W> t = tree, tprev;

		if (t == null)
			return;
		if (t.right == null)
			tree = t.left;
		else {
			do {
				tprev = t;
				t = t.right;
			} while (t.right != null);
			tprev.right = t.left;
		}
		size--;
	}

	/**
	 * Clear the treap so that it contains no mappings.
	 */
	public synchronized void clear() {
		tree = null;
		size = 0;
	}

	/**
	 * Returns the number of keys in this treap.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns a string representation of this treap.
	 * This routine is inefficient and primarily intended for
	 * debugging.
	 */
	public synchronized String toString() {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("{");
		if (tree != null)
			strbuf.append(tree.toString());
		if (strbuf.length() > 1)
			strbuf.setLength(strbuf.length() - 2);  // remove last ", "
		strbuf.append("}");
		return strbuf.toString();
	}

	/* Inserts a node into tree and returns the updated treap */
	private ComparableObjectTree<U,W> insert(ComparableObjectTree<U,W> node, ComparableObjectTree<U,W> tree) {
		if (tree == null) return node;
		int comp = node.key.compareTo(tree.key);
		if (comp < 0) {
			tree.left = insert(node, tree.left);
			if (tree.prio > tree.left.prio)
				tree = tree.rotateRight();
		} else if (comp > 0) {
			tree.right = insert(node, tree.right);
			if (tree.prio > tree.right.prio)
				tree = tree.rotateLeft();
		} else {
			keyFound = true;
			tree.value = node.value;
		}
		return tree;
	}

	/* Searches for a node with this key. If found, deletes this
	 * node and returns the updated treap.
	 */
	private ComparableObjectTree<U,W> delete(U key, ComparableObjectTree<U,W> t) {
		if (t == null) return null;
		int comp = key.compareTo(t.key);
		if (comp < 0)
			t.left = delete(key, t.left);
		else if (comp > 0)
			t.right = delete(key, t.right);
		else {
			keyFound = true;
			t = t.deleteRoot();
		}
		return t;
	}

	/**
	 * Prints the treap on stderr, displaying the tree structure
	 * and the priority numbers.
	 */
	public synchronized void printDebug() {
		System.err.println("size: " + size);
		if (tree != null) tree.printDebug(0);
	}
}

/* An object of this class represents a node in a binary tree */
class ComparableObjectTree<K extends Comparable<?>,V>
{
	K key;
	V value;
	int prio;
	ComparableObjectTree<K,V> left, right;

	/* Rotate this tree to the left
	 */
	final ComparableObjectTree<K,V> rotateLeft() {
		ComparableObjectTree<K,V> temp = right;
		right = right.left;
		temp.left = this;
		return temp;
	}

	/* Rotate this tree to the right
	 */
	final ComparableObjectTree<K,V> rotateRight() {
		ComparableObjectTree<K,V> temp = left;
		left = left.right;
		temp.right = this;
		return temp;
	}

	/* If one of the children is an empty tree, remove the root
	 * and put the other child in its place. If both children
	 * are nonempty, rotate the tree at the root so that the child
	 * with the smallest prio-number comes to the top, then delete
	 * the root from the other subtee.
	 */
	final ComparableObjectTree<K,V> deleteRoot() {
		ComparableObjectTree<K,V> temp;

		if (left == null)
			return right;
		if (right == null)
			return left;
		if (left.prio < right.prio) {
			temp = rotateRight();
			temp.right = deleteRoot();
		} else {
			temp = rotateLeft();
			temp.left = deleteRoot();
		}
		return temp;
	}

	public String toString() {
		StringBuffer strbuf = new StringBuffer();

		if (left != null)
			strbuf.append(left.toString());
		strbuf.append(key + "=" + value + ", ");
		if (right != null)
			strbuf.append(right.toString());

		return strbuf.toString();
	}

	/* Print in sorted order, displaying the tree structure
	 * and the priority numbers.
	 */
	void printDebug(int level) {
		if (left != null)
			left.printDebug(level +1 );
		for (int i = 0; i < level; i++)
			System.err.print("  ");
		System.err.println(key + "=" + value + " (" + prio + ")");
		if (right != null)
			right.printDebug(level + 1);
	}
}

/**
 * A treap enumeration class that returns the keys or elements
 * of a treap in sorted order.
 */
class ComparableObjectTreapIterator<A extends Comparable<A>,B> implements Iterator<ComparableObjectPair<A,B>>
{
	private Stack<ComparableObjectTree<A,B>> stack;
	
	private boolean ascending;

	ComparableObjectTreapIterator(ComparableObjectTree<A,B> t, boolean ascending) {
		stack = new Stack<ComparableObjectTree<A,B>>();

		this.ascending = ascending;

		if (ascending)
			for ( ; t != null ; t = t.left)
				stack.push(t);
		else // descending
			for ( ; t != null; t = t.right)
				stack.push(t);
	}

	public boolean hasNext() {
		return !stack.empty();
	}

	public ComparableObjectPair<A,B> next() {
		if (stack.empty())
			throw new NoSuchElementException("TreapEnumeration");

		ComparableObjectTree<A,B> node =  stack.peek();

		if (ascending)
			if (node.right == null) {
				ComparableObjectTree<A,B> t =  stack.pop();
				while (!stack.empty() && ( stack.peek()).right == t)
					t =  stack.pop();
			} 
			else
				for (ComparableObjectTree<A,B> t = node.right; t != null; t = t.left)
					stack.push(t);
		else // descending
			if (node.left == null) {
				ComparableObjectTree<A,B> t =  stack.pop();
				while (!stack.empty() && ( stack.peek()).left == t)
					t =  stack.pop();
			} 
			else
				for (ComparableObjectTree<A,B> t = node.left; t != null; t = t.right)
					stack.push(t);

		return new ComparableObjectPair<A, B>(node.key,node.value);
	}

	public void remove() {
	}
	
}
