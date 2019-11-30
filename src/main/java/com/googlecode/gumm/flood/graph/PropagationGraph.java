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

package com.googlecode.gumm.flood.graph;

import java.util.LinkedList;
import java.util.List;

import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.utils.treap.*;

public class PropagationGraph extends CompatibilityGraph {
	
	protected IntObjectTreap<AdjWeightedCompNodes> edges;
	
	protected Sigma sigma0;
	
	/**
	 * Creates a propgation graph using the given connectivity graph, with the given id manager,
	 * weight evaluator and sigma0 evaluator. 
	 * @param idManager an idmanager.
	 * @param connectivityGraph a connectivity graph.
	 * @param weightEvaluator a weight evaluator.
	 * @param sigma0Evaluator a sigma 0 evaluator.
	 */
	public PropagationGraph(IdManager idManager,ConnectivityGraph connectivityGraph,
			WeightEvaluator weightEvaluator,Sigma0Evaluator sigma0Evaluator) {
		this.idManager = idManager;
		this.nodes = connectivityGraph.nodes;

		edges = new IntObjectTreap<AdjWeightedCompNodes>();
		
		weightEvaluator.setPropagationGraph(this);
		weightEvaluator.computeWeights();

		this.sigma0 = new Sigma();
		
		sigma0Evaluator.setSigma0(this.sigma0);
		sigma0Evaluator.setPropagationGraph(this);
		sigma0Evaluator.computeSigma0();
	}

	/**
	 * Creates a propagation edge in the propagation graph.
	 * @param sourceNode the source compatibility node.
	 * @param targetNode the target compatibility node.
	 * @param weight the weight of the edge.
	 */
	public void createEdge(CompatibilityNode sourceNode, CompatibilityNode targetNode,float weight) {
		int targetID = targetNode.getId();
		
		if ( !edges.hasKey(targetID) )
			edges.put(targetID, new AdjWeightedCompNodes());
		
		edges.get(targetID).add(new AdjWeightedCompNode(sourceNode,weight));
	}

	/**
	 * Deletes the given list of compatibility nodes from the graph.
	 * @param nodesToDelete a list of compatibility nodes.
	 */
	public void deleteCompatibilityNodes(List<CompatibilityNode> nodesToDelete) {
		for( IndexedObject<CompatibilityNode> pair: nodes ) {
			int key = pair.getKey();
			List<AdjWeightedCompNode> toRemove = new LinkedList<AdjWeightedCompNode>();
			for(AdjWeightedCompNode lacn: edges.get(key) )
				if ( nodesToDelete.contains(lacn.getNode()))
					toRemove.add(lacn);

			for(AdjWeightedCompNode wacn: toRemove)
				edges.get(key).remove(wacn);
		}
		
		for( CompatibilityNode cn: nodesToDelete )
			nodes.remove(cn.getId());
	}

	/**
	 * Returns the sigma 0 associated to the graph.
	 * @return a sigma 0.
	 */
	public Sigma getSigma0() {
		return this.sigma0;
	}

	/**
	 * Returns the source nodes of a given node.
	 * @param node a node.
	 * @return a list of source nodes (in adjacent representation).
	 */
	public List<AdjWeightedCompNode> getSourceNodes(CompatibilityNode node) {
		return edges.get(node.getId());
	}

	/**
	 * Returns the list of propagation edges of the graph.
	 * @return a list of propgation edges.
	 */
	public List<PropagationEdge> getEdges() {
		LinkedList<PropagationEdge> edgeList = new LinkedList<PropagationEdge>();

		for( IndexedObject<AdjWeightedCompNodes> pair: edges )
			for( AdjWeightedCompNode wan: edges.get(pair.getKey()) )
				edgeList.add(new PropagationEdge(wan.getNode(),nodes.get(pair.getKey()),wan.getWeight()));

		return edgeList;
	}

	/**
	 * Returns the number of propagation edges in the graph.
	 * @return the number of propagation edges in the graph.
	 */
	public int getEdgesNb() {
		int e = 0;
		
		for( IndexedObject<AdjWeightedCompNodes> pair: edges )
			e += pair.getValue().size();
		
		return e;
	}
	
	@Override
	public String toString() {
		return "Propagation Graph with: " + getNodesNb() + " nodes and with " + getEdgesNb() + " edges.";
	}

}
