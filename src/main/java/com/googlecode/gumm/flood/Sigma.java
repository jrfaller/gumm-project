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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.googlecode.gumm.utils.treap.*;

/**
 * An array of floats containing compatibility node similarity values. Index position in the array corresponds to the ID of 
 * the related compatibility node. 
 * @author Jean-Rémy Falleri
 *
 */
public class Sigma {
	/**
	 * Maximum weight of a compatibility node.
	 */
	public final static float MAX_WEIGHT = 1.0F;
	
	/**
	 * Minimum weight of a compatibility node.
	 */
	public final static float MIN_WEIGHT = 0.0F;
	
	private IntFloatTreap similarities;
	
	/**
	 * Creates an empty sigma.
	 */
	public Sigma() {
		similarities = new IntFloatTreap();
	}
	
	/**
	 * Returns the similarity of the compatibility node with the given id. 
	 * @param id an id.
	 * @return a similarity value.
	 */
	public float getSimilarity(int id) {
		return similarities.get(id);
	}
	
	/**
	 * Sets the similarity for the compatibility node with the given id.
	 * @param id an id.
	 * @param similarity a similarity.
	 */
	public void setSimilarity(int id,float similarity) {
		similarities.put(id,similarity);
	}
	
	/**
	 * Computes the euclidian distance from a sigma to an other.
	 * @param s2 a sigma.
	 * @return the euclidian distance.
	 */
	public float euclidianDistance(Sigma s2) {
		float sum = 0F;

		for( IndexedFloat pair: similarities )
			sum += Math.pow( pair.getValue() - s2.getSimilarity(pair.getKey()),2D);
		
		return (float) Math.sqrt(sum);
	}
	
	/**
	 * Divides each similarity value of the sigma by the given value.
	 * @param value a value.
	 */
	public void normalize(float value) {
		
		for( IndexedFloat pair: similarities )
			setSimilarity( pair.getKey(), pair.getValue() / value );
		
	}
	
	/**
	 * Output the sigma in the given file
	 * @param f a file.
	 * @throws IOException
	 */
	public void outputToFile(File f) throws IOException {
		FileWriter fw = new FileWriter(f);
		fw.append(toString());
		fw.close();
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		
		for( IndexedFloat pair: similarities ) 
			b.append(pair.getKey() + ";" + pair.getValue() + "\n"); 
		
		return b.toString();
	}
	
}
