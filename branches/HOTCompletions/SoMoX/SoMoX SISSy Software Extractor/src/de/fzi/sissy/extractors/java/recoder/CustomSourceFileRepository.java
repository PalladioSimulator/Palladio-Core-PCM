/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik, 
 * 10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.fzi.sissy.extractors.java.recoder;

import recoder.CrossReferenceServiceConfiguration;
import recoder.ParserException;
import recoder.io.DefaultSourceFileRepository;
import recoder.java.CompilationUnit;
import recoder.parser.ParseException;
import recoder.util.Debug;

/**
 * @author szuli
 *  
 */
public class CustomSourceFileRepository extends DefaultSourceFileRepository {

	public CustomSourceFileRepository(CrossReferenceServiceConfiguration crossReferenceServiceConfiguration) {
		super(crossReferenceServiceConfiguration);
	}

	public CompilationUnit getCompilationUnitFromFile(String filename) throws ParserException {

		try {
			CompilationUnit newCU = super.getCompilationUnitFromFile(filename);
			return newCU;

		} catch (Error err) {
			return null;
		} catch (ParserException e) {
			if (e instanceof ParseException) {
				ParseException p = (ParseException)e;
				Debug.error("Parse error after token \"" + p.currentToken.toString() +  "\", line " + Integer.toString(p.currentToken.endLine)
							+ ", column " + Integer.toString(p.currentToken.endColumn));
				String a = new String("Expected ");
				for (int i=0; i<p.expectedTokenSequences.length; i++) {
					for (int j=0; j<p.expectedTokenSequences[i].length; j++) {
						a += p.tokenImage[p.expectedTokenSequences[i][j]] + " ";
					}
				}
				a += " but found \"" + p.currentToken.next.image + "\"";
				Debug.error(a);
				Debug.error("Skipping this file...");
			}

			return null;
		}
	}

}
