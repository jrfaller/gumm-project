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
import com.googlecode.gumm.flood.*;
import com.googlecode.gumm.utils.treap.IndexedObject;

public class AlignmentToHtml extends CodeGenerator {

	private Alignment alignment;

	public AlignmentToHtml(Alignment alignment) {
		this.alignment = alignment;
		generateCode();
	}

	public void generateCode() {
		append( "<html><head><title>Gumm Mapping</title>");
		append( "<style type=\"text/css\">table {border: thin solid #000000;border-collapse: collapse;}" +
		"td {border: thin solid #000000;} th {border: thin solid #00000 ; background-color: #abc; } tr { background-color: #fff; } tr.odd {background-color: #eee;} {</style>" );
		append("</head><body>");
		append( "<p>" + alignment.getMappings().size() + " mappings found.</p>" );
		append( "<table><tr><th>Source</th><th>Target</th><th>Similarity</th></tr>");

		boolean odd = false;
		for( IndexedObject<Mapping> pair: alignment ) {
			Mapping mapping = pair.getValue();

			if ( odd ) {
				append("<tr class=\"odd\">");
				odd = false;
			}
			else {
				append("<tr>");
				odd = true;
			}
			append("<td>" + mapping.getSourceNode().getLabel() + "</td><td>" +  
					mapping.getTargetNode().getLabel() + "</td><td><center>" + NumberFormat.getInstance().format(mapping.getSimilarity()) + "</center></td></tr>");
		}

		append("</table></body></html>");
	}

}
