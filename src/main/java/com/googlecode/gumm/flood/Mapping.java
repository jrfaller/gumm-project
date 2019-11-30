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

package com.googlecode.gumm.flood;

import java.text.NumberFormat;

import com.googlecode.gumm.flood.graph.CompatibilityNode;
import com.googlecode.gumm.graph.LabeledNode;

/**
 * A match is composed of a compatibility node and a similarity value.
 * @author Jean-Rémy Falleri
 *
 */
public class Mapping {
	
	private LabeledNode sourceNode;
	
	private LabeledNode targetNode;
	
	private float similarity;
	
	/**
	 * Creates a mapping for the given compatibility node with the given similarity.
	 * @param compatibilityNode a compatibility node.
	 * @param similarity a similarity value.
	 */
	public Mapping(CompatibilityNode compatibilityNode, float similarity) {
		this.sourceNode = compatibilityNode.getSourceNode();
		this.targetNode = compatibilityNode.getTargetNode();
		this.similarity = similarity;
	}
	
	/**
	 * Returns the source labeled node of the mapping.
	 * @return the source labeled node.
	 */
	public LabeledNode getSourceNode() {
		return sourceNode;
	}
	
	/**
	 * Returns the target labeled node of the mapping.
	 * @return the target labeled node.
	 */	
	public LabeledNode getTargetNode() {
		return targetNode;
	}

	/**
	 * Returns the similarity of the mapping.
	 * @return the similarity of the mapping.
	 */
	public float getSimilarity() {
		return similarity;
	}
	
	/**
	 * Sets the similarity of the mapping.
	 * @param similarity a similarity value.
	 */
	public void setSimilarity(float similarity) {
		this.similarity = similarity;
	}
	
	@Override
	public String toString() {
		return  sourceNode + ";" + targetNode + ";" + NumberFormat.getInstance().format(similarity);
	}
	
}
