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

package com.googlecode.gumm.viz;

import java.text.NumberFormat;

import com.googlecode.exputils.CodeGenerator;

import com.googlecode.gumm.flood.graph.*;
import com.googlecode.gumm.graph.*;
import com.googlecode.gumm.utils.treap.IndexedObject;

/**
 * Generates the dot code corresponding to the given propagation graph.
 * @author Jean-Rémy Falleri
 *
 */
public class PropagationGraphToDot extends CodeGenerator {
	private PropagationGraph propagationGraph;

	/**
	 * Creates a propagation graph to dot exporter.
	 * @param pgraph a propagation graph.
	 */
	public PropagationGraphToDot(PropagationGraph pgraph) {
		super();
		this.propagationGraph = pgraph;
		generateCode();
	}

	public void generateCode() {
		appendLine("digraph G {");

		for(IndexedObject<CompatibilityNode> pair: propagationGraph.getCompatibilityNodes() ) {
			int ID = pair.getKey();
			String weight = NumberFormat.getInstance().format(propagationGraph.getSigma0().getSimilarity(ID));
			appendLine("\t" + ID + " [label=\"" + pair.getValue().toString() + ": " + weight + "\"];");
		}

		for(Edge e : propagationGraph.getEdges() ) {
			appendLine("\t" + e.getSource().getId() + " -> " + e.getTarget().getId() + " [label=\"" + e.toString() + "\"];");
		}

		append("}");
	}

}