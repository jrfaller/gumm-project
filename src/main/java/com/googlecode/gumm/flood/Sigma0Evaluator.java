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

public abstract class Sigma0Evaluator {
	
	protected PropagationGraph propagationGraph;
	
	protected Sigma sigma0;
	
	public void setPropagationGraph(PropagationGraph propagationGraph) {
		this.propagationGraph = propagationGraph;
	}
	
	public void setSigma0(Sigma sigma0) {
		this.sigma0 = sigma0;
	}
	
	public abstract void computeSigma0();
	
}
