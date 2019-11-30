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
import com.googlecode.gumm.utils.treap.*;

/**
 * Generates the latex code corresponding to the alignment.
 * @author Jean-Rémy Falleri
 *
 */
public class AlignmentToLatex extends CodeGenerator {

	private Alignment alignment;

	public AlignmentToLatex(Alignment alignment) {
		this.alignment = alignment;
	}

	public void generateCode() {
		append("\\begin{tabularx}{1.0\\columnwidth}");
		append("{|X|X|c|}");
		newLine();
		appendLine("\\hline");
		appendLine("\\textbf{Source} & \\textbf{Target} & \\textbf{Similarity}\\\\");
		appendLine("\\hline");
		for( IndexedObject<Mapping> pair: alignment ) {
			Mapping mapping = pair.getValue();
			
			String srcLbl = mapping.getSourceNode().toString().replaceAll("#","\\\\#").replaceAll("::","::\\\\-");

			String tgtLbl = mapping.getSourceNode().toString().replaceAll("#","\\\\#").replaceAll("::","::\\\\-");
			
			appendLine( srcLbl + " & " + tgtLbl + " & " + NumberFormat.getInstance().format(mapping.getSimilarity()) + "\\\\" );
			appendLine( "\\hline" );
		}
		appendLine("\\end{tabularx}");
	}

}
