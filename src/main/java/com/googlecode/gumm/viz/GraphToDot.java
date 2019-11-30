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

import java.util.HashSet;
import java.util.Set;

import com.googlecode.exputils.CodeGenerator;
import com.googlecode.gumm.graph.Edge;
import com.googlecode.gumm.graph.GraphItf;
import com.googlecode.gumm.graph.Node;
import com.googlecode.gumm.graph.ValueNode;

/**
 * Generates the dot code corresponding to the given graph.
 * @author Jean-Rémy Falleri
 *
 */
public class GraphToDot extends CodeGenerator {
	
	private GraphItf graph;
	
	private Boolean hideValueNodes;
	
	private Set<String> filteredEdges;
	
	/**
	 * Creates a graph to dot exporter that displays the value nodes according to the
	 * given boolean value. This exporter does not display the edges with labeld contained
	 * in the given filtered edges list.
	 * @param graph a graph.
	 * @param hideValueNodes a boolean.
	 * @param filteredEdges a set of string.
	 */
	public GraphToDot(GraphItf graph,boolean hideValueNodes,Set<String> filteredEdges) {
		super();
		this.graph = graph;
		this.filteredEdges = filteredEdges;
		this.hideValueNodes = hideValueNodes;
		generateCode();
	}
	
	/**
	 * Creates a graph to dot exporter that displays the value nodes according to the
	 * given boolean value.
	 * @param graph a graph.
	 * @param hideValueNodes a boolean.
	 */
	public GraphToDot(GraphItf graph,boolean hideValueNodes) {
		this(graph,hideValueNodes,new HashSet<String>());
	}
	
	/**
	 * Creates a graph to  dot exporter.
	 * @param graph a graph.
	 */
	public GraphToDot(GraphItf graph) {
		this(graph,false,new HashSet<String>());
	}
	
	
	public void generateCode() {
		appendLine("digraph G {");
		for(Node n: graph.getNodes() ) {
			if (  !(n instanceof ValueNode) || !(hideValueNodes) )
				appendLine("\t" + n.getId() + " [label=\"" + n.toString() + "\"];");
		}
	
		for(Edge e : graph.getEdges() )
			if ( (!(e.getSource() instanceof ValueNode) && !(e.getTarget() instanceof ValueNode)) || !hideValueNodes )
				if ( !filteredEdges.contains(e.toString())) // TODO remove this ugly hack, should word only on labeled edges.
					appendLine("\t" + e.getSource().getId() + " -> " + e.getTarget().getId() + " [label=\"" + e.toString() + "\"];");
		
		append("}");
	}
	
}
