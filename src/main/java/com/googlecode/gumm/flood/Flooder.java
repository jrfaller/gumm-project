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

import com.googlecode.gumm.flood.graph.*;
import com.googlecode.gumm.utils.treap.IndexedObject;

/**
 * A class implementing the Similarity Flooding process.
 * @author Jean-Rémy Falleri
 *
 */
public class Flooder {

	private float limit;

	private int maxStepNb;

	private int lastStepNb;

	private float lastEuclidianDistance;

	private Alignment alignment;

	private PropagationGraph propagationGraph;

	/**
	 * Creates a flooder on the given propagation graph, with the given sigma evaluator, stopping
	 * after the given limit and performing a given maximum number of steps.
	 * @param propagationGraph a propagation graph.
	 * @param limit a limit.
	 * @param maxStepNb a maximum number of step.
	 */
	public Flooder(PropagationGraph propagationGraph,float limit,int maxStepNb) {
		this.limit = limit;
		this.maxStepNb = maxStepNb;
		this.propagationGraph = propagationGraph;
	}

	/**
	 * Performs the flooding process.
	 */
	public void flood() {
		// Initializes flooding parameter.
		int stepNb = 0;
		boolean stop = false;
		
		// Sets the different sigmas.
		Sigma sigmaN =  new Sigma();
		//Sigma sigmaN = new Sigma(new IndexedArrayContainer<Float>(new Float[getPropagationGraph().getMaximumID()]));
		Sigma sigmaNm1 = propagationGraph.getSigma0();

		while( !stop ) {
			float bestSim = 0.0F;

			sigmaN = new Sigma();

			for(IndexedObject<CompatibilityNode> pair: propagationGraph.getCompatibilityNodes() ) {
				CompatibilityNode n = pair.getValue();
				float sim = sigmaNm1.getSimilarity(n.getId()) + propagationGraph.getSigma0().getSimilarity(n.getId());
				
				for(AdjWeightedCompNode wan: propagationGraph.getSourceNodes(n)) {
					sim += wan.getWeight() * sigmaNm1.getSimilarity(wan.getNode().getId());

					sim += wan.getWeight() * propagationGraph.getSigma0().getSimilarity(wan.getNode().getId());
				}

				if ( sim > bestSim )
					bestSim = sim;

				sigmaN.setSimilarity(n.getId(), sim);
			}

			sigmaN.normalize(bestSim);

			stepNb++;

			float dist = sigmaN.euclidianDistance(sigmaNm1);
			
			if ( dist < limit || stepNb == maxStepNb )
				stop = true;
			else
				sigmaNm1 = sigmaN;
		}

		lastStepNb = stepNb;
		lastEuclidianDistance = sigmaNm1.euclidianDistance(sigmaN);
		
		computeMapping(sigmaN);
	}

	private void computeMapping(Sigma sigma) {
		this.alignment = new Alignment(propagationGraph.getIdManager());
		for( IndexedObject<CompatibilityNode> pair: propagationGraph.getCompatibilityNodes() ) {
			int id = pair.getKey();
			alignment.setMapping(id,new Mapping(this.getPropagationGraph().getCompatibilityNode(id),sigma.getSimilarity(id)));
		}
	}

	/**
	 * Returns informations about the flooding process.
	 * @return informations about the flooding process.
	 */
	public String getProcessInformations() {
		return "Flooding process with " + lastStepNb + " flooding steps, last euclidian distance: " + lastEuclidianDistance + ".";
	}

	/**
	 * Returns the maximum allowed number of steps in the flooding process.
	 * @return the maximum allowed number of steps.
	 */
	public int getMaxStepNb() {
		return maxStepNb;
	}

	/**
	 * Returns the number of step done by the flooding process.
	 * @return the number of step done by the flooding process.
	 */
	public int getLastStepNb() {
		return lastStepNb;
	}

	/**
	 * Returns the euclidian distance between the two last iterations of the flooding process.
	 * @return the euclidian distance between the two last iterations of the flooding process.
	 */
	public float getLastEuclidianDistance() {
		return lastEuclidianDistance;
	}

	/**
	 * Returns the propagation graph involved in the flooding process.
	 * @return the propagation graph involved in the flooding process.
	 */
	public PropagationGraph getPropagationGraph() {
		return propagationGraph;
	}

	/**
	 * Returns the alignment computed by the flooder.
	 * @return the alignment computed by the flooder.
	 */
	public Alignment getAlignment() {
		return this.alignment;
	}

	/**
	 * Returns the limit of the flooder.
	 * @return a float. 
	 */
	public float getLimit() {
		return this.limit;
	}

	@Override
	public String toString() {
		return "Flooder with " + maxStepNb + " maximum steps and " + NumberFormat.getInstance().format(limit) + " limit.";
	}

}
