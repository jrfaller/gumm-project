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

import com.googlecode.gumm.flood.graph.*;

/**
 * This class is used to compute the weights on the edges of the propagation graphs.
 * @author Jean-Rémy Falleri
 *
 */
public abstract class WeightEvaluator {

	protected PropagationGraph propagationGraph;
	
	protected ConnectivityGraph connectivityGraph;
	
	public WeightEvaluator(ConnectivityGraph connectivityGraph) {
		this.connectivityGraph = connectivityGraph;
	}
	
	public WeightEvaluator() {}
	
	public void setConnectivityGraph(ConnectivityGraph connectivityGraph) {
		this.connectivityGraph = connectivityGraph;
	}
	
	public void setPropagationGraph(PropagationGraph propagationGraph) {
		this.propagationGraph = propagationGraph;
	}

	/**
	 * Assign the weights in the weighted edge array.
	 */
	public abstract void computeWeights();

}
