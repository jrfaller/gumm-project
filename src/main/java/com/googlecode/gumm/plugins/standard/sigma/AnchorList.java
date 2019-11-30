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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AnchorList {
	
	private Set<String> anchoredLabels;
	
	private List<Anchor> anchors;
	
	public AnchorList() {
		anchors = new LinkedList<Anchor>();
		anchoredLabels = new HashSet<String>();
	}
	
	public AnchorList(File f) throws FileNotFoundException, IOException {
		super();
		BufferedReader br = new BufferedReader(new FileReader(f));
		while( br.ready() ) {
			String line = br.readLine();
			String[] tokens = line.split(";");
			this.addAnchor(tokens[0],tokens[1]);
		}
		br.close();
	}
	
	public boolean fullFill(String s1,String s2) {
		if ( !anchoredLabels.contains(s1) && !anchoredLabels.contains(s2) )
			return false;
		else {
			List<Anchor> relatedAnchors = relatedAnchors(s1, s2);
			boolean accept = false;
			for(Anchor a: relatedAnchors )
				if ( a.isAnchor(s1, s2))
					accept = true;
			return accept;
		}
	}
	
	public boolean accept(String s1,String s2) {
		if ( !anchoredLabels.contains(s1) && !anchoredLabels.contains(s2) )
			return true;
		else {
			List<Anchor> relatedAnchors = relatedAnchors(s1, s2);
			boolean accept = false;
			for(Anchor a: relatedAnchors )
				if ( a.isAnchor(s1, s2))
					accept = true;
			return accept;
		}
	}
	
	public void addAnchor(String s1,String s2) {
		this.addAnchor(new Anchor(s1,s2));
	}
	
	public void addAnchor(Anchor anchor) {
		anchoredLabels.add(anchor.source);
		anchoredLabels.add(anchor.target);
		this.anchors.add(anchor);
	}
	
	private List<Anchor> relatedAnchors(String s1,String s2) {
		List<Anchor> relatedAnchord = new LinkedList<Anchor>();
		for(Anchor a: anchors) {
			if ( a.inAnchor(s1, s2) )
				relatedAnchord.add(a);
		}
		return relatedAnchord;
	}

}
