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
 * This implementation is specific for int keys and values, avoiding boxing and unboxing 
 * of this primitive type, leading to a better running time compared to the generic version.
 * 
 * This implementation used parameterized types to customize the type of the values stored in
 * the treap.
 *  
 * Most methods run in <math>O(log n)</math> randomized time, where
 * <math>n</math> is the number of keys in the treap; the exceptions
 * are <code>clone()</code> and <code>toString()</code> that run in time
 * proportional to the size of their output.
 *
 * @author Jean-Rémy Falleri
 * @param <V> type of the values stored in the treap.
 */
public class IntObjectTreap<V> implements Iterable<IndexedObject<V>>
{
	private IntObjectTree<V> tree;
	
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
	public IntObjectTreap() {
		tree = null;
		size = 0;
		prio = new Random();
	}

	/**
	 * Maps the key to the specified value in this treap.
	 * Neither the key, nor the value can be <code>null</code>.
	 */
	public synchronized void put(int key, V value) {
		IntObjectTree<V> node = new IntObjectTree<V>();
		node.key = key;
		node.value = value;
		node.prio = prio.nextInt();
		keyFound = false;
		tree = insert(node, tree);
		
		if ( !keyFound )
			size++;
	}

	/**
	 * Gets the object associated with the specified key in the treap.
	 * @return the value to which the key is mapped in the treap, or
	 * <code>null</code> if the key is not mapped to any value in
	 * this treap.
	 */
	public synchronized V get(int key) {
		IntObjectTree<V> t = tree;
		int comp;

		while (t != null && (comp = key - t.key) != 0)
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
	public synchronized boolean hasKey(int key) {
		IntObjectTree<V> t = tree;
		int comp;

		while (t != null && (comp = key - t.key) != 0)
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
	public synchronized int getMinKey() {
		IntObjectTree<V> t = tree;

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
	public synchronized int getMaxKey() {
		IntObjectTree<V> t = tree;

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
	public synchronized V getMinValue() {
		IntObjectTree<V> t = tree;

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
	public synchronized V getMaxValue() {
		IntObjectTree<V> t = tree;

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
	public synchronized Iterator<IndexedObject<V>> iterator() {
		return new IntObjectTreapIterator<V>(tree,true);
	}
	
	/**
	 * Returns an iterator over the keys and values stored in the treap,
	 * in the given order of the key (ascending or descending).
	 * @param ascending order of the keys.
	 * @return an iterator.
	 */
	public synchronized Iterator<IndexedObject<V>> iterator(boolean ascending) {
		return new IntObjectTreapIterator<V>(tree,ascending);
	}

	/**
	 * Returns <code>true</code> if this treap contains no mappings.
	 */
	public boolean isEmpty() {
		return tree == null;
	}

	/**
	 * Removes tke key (and its corresponding value) from this treap.
	 * This method does nothing if the key is not in the treap.
	 */
	public synchronized void remove(int key) {
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
		IntObjectTree<V> t = tree, tprev;

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
	 * Removes tke maximum key (and its corresponding value) from
	 * this treap. This method does nothing if the treap is empty.
	 */
	public synchronized void removeMax() {
		IntObjectTree<V> t = tree, tprev;

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
	private IntObjectTree<V> insert(IntObjectTree<V> node, IntObjectTree<V> tree) {
		if (tree == null) return node;
		int comp = node.key - tree.key;
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
	private IntObjectTree<V> delete(int key, IntObjectTree<V> t) {
		if (t == null) return null;
		int comp = key - t.key;
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
class IntObjectTree<T>
{
	int key;
	T value;
	int prio;
	IntObjectTree<T> left, right;

	/* Rotate this tree to the left
	 */
	final IntObjectTree<T> rotateLeft() {
		IntObjectTree<T> temp = right;
		right = right.left;
		temp.left = this;
		return temp;
	}

	/* Rotate this tree to the right
	 */
	final IntObjectTree<T> rotateRight() {
		IntObjectTree<T> temp = left;
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
	final IntObjectTree<T> deleteRoot() {
		IntObjectTree<T> temp;

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
 * 
 * @param <U> type of the values of the treap.
 */
class IntObjectTreapIterator<U> implements Iterator<IndexedObject<U>>
{
	private Stack<IntObjectTree<U>> stack;
	
	private boolean ascending;

	IntObjectTreapIterator(IntObjectTree<U> t, boolean ascending) {
		stack = new Stack<IntObjectTree<U>>();

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

	public IndexedObject<U> next() {
		if (stack.empty())
			throw new NoSuchElementException("TreapEnumeration");

		IntObjectTree<U> node =  stack.peek();

		if (ascending)
			if (node.right == null) {
				IntObjectTree<U> t =  stack.pop();
				while (!stack.empty() && ( stack.peek()).right == t)
					t =  stack.pop();
			} 
			else
				for (IntObjectTree<U> t = node.right; t != null; t = t.left)
					stack.push(t);
		else // descending
			if (node.left == null) {
				IntObjectTree<U> t =  stack.pop();
				while (!stack.empty() && ( stack.peek()).left == t)
					t =  stack.pop();
			} 
			else
				for (IntObjectTree<U> t = node.left; t != null; t = t.right)
					stack.push(t);

		return new IndexedObject<U>(node.key,node.value);
	}

	public void remove() {
	}
	
}
