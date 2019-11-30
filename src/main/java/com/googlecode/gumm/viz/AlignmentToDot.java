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

import com.googlecode.exputils.CodeGenerator;
import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.graph.*;
import com.googlecode.gumm.utils.treap.IndexedObject;

/**
 * Generates the dot code corresponding to the two input graphs and arrows connecting the nodes of those graphs
 * according to the computed alignment.
 * @author Jean-Rémy Falleri
 */
public class AlignmentToDot extends CodeGenerator {

	private ModelGraphItf sourceGraph;

	private ModelGraphItf targetGraph;

	private Alignment alignment;
	
	private boolean hideValueNodes;

	/**
	 * Creates an alignment to dot generator with the given alignment, the given source graph, the given target graph.
	 * Displays value nodes according to the value of the given boolean. 
	 * @param sourceGraph an input graph.
	 * @param targetGraph an input graph.
	 * @param alignment an alignment.
	 * @param hideValueNodes a boolean.
	 */
	public AlignmentToDot(ModelGraphItf sourceGraph,ModelGraphItf targetGraph,Alignment alignment,boolean hideValueNodes) {
		super();
		this.sourceGraph = sourceGraph;
		this.targetGraph = targetGraph;
		this.alignment = alignment;
		this.hideValueNodes = hideValueNodes;
	}
	
	/**
	 * Creates an alignment to dot generator with the given alignment, the given source graph, the given target graph.
	 * @param sourceGraph an input graph.
	 * @param targetGraph an input graph.
	 * @param alignment an alignment.
	 */
	public AlignmentToDot(ModelGraphItf sourceGraph,ModelGraphItf targetGraph,Alignment alignment) {
		this(sourceGraph,targetGraph,alignment,true);
	}

	public void generateCode() {
		appendLine("digraph G {");

		appendLine("\tsubgraph cluster_1 {");

		for(Node n: sourceGraph.getNodes() )
			if ( !(n instanceof ValueNode) || !hideValueNodes )
				appendLine("\t\t" + n.getId() + " [label=\"" + n.toString() + "\"];");

		for(Edge e : sourceGraph.getEdges() )
			if ( (!(e.getSource() instanceof ValueNode) && !(e.getTarget() instanceof ValueNode)) || !hideValueNodes )
				appendLine("\t\t" + e.getSource().getId() + " -> " + e.getTarget().getId() + " [label=\"" + e.toString() + "\"];");
		
		appendLine("\t}");

		appendLine("\tsubgraph cluster_2 {");

		for(Node n: targetGraph.getNodes() )
			if ( !(n instanceof ValueNode) || ! hideValueNodes )
				appendLine("\t\t" + normalizeTargetId(n.getId()) + " [label=\"" + n.toString() + "\"];");

		for(Edge e : targetGraph.getEdges() )
			if ( (!(e.getSource() instanceof ValueNode) && !(e.getTarget() instanceof ValueNode)) || !hideValueNodes )
				appendLine("\t\t" + normalizeTargetId(e.getSource().getId()) + " -> " + normalizeTargetId(e.getTarget().getId()) + " [label=\"" + e.toString() + "\"];");

		appendLine("\t}");

		for( IndexedObject<Mapping> pair: alignment.getMappings() ) {
			Mapping mapping = pair.getValue();
			if ( (!(mapping.getSourceNode() instanceof ValueNode) && !(mapping.getTargetNode() instanceof ValueNode)) || !hideValueNodes  )
			appendLine("\t" + mapping.getSourceNode().getId() + " -> " + normalizeTargetId(mapping.getTargetNode().getId()) + " [label=\"" + mapping.getSimilarity() + "\",style=bold,weight=10,arrowhead=dot,arrowtail=dot,color=red];");
		}

		append("}");
	}

	private int normalizeTargetId(int id) {
		return id + sourceGraph.getNodesNb();
	}

}
