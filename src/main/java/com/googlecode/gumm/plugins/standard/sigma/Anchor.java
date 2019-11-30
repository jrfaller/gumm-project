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

package com.googlecode.gumm.plugins.standard.sigma;

public class Anchor {
	
	public String source;
	
	public String target;
	
	public Anchor(String source,String target) {
		this.source = source;
		this.target = target;
	}
	
	public boolean isAnchor(String s1,String s2) {
		if ( s1.equals(source) && s2.equals(target))
			return true;
		if ( s1.equals(target) && s2.equals(source))
			return true;
		
		return false;
	}
	
	public boolean inAnchor(String s1,String s2) {
		if ( s1.equals(source) )
			return true;
		if ( s1.equals(target) )
			return true;
		if ( s2.equals(source) )
			return true;
		if ( s2.equals(target) )
			return true;
		
		return false;
	}
	
}
