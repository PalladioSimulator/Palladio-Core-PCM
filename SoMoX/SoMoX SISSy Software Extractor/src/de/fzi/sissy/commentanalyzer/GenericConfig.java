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
package de.fzi.sissy.commentanalyzer;

import java.util.regex.Pattern;


/**
 * @author Philipp Haller
 */
public class GenericConfig implements IConfig {

	protected String lineStart, normalStart, normalEnd, formalStart, formalEnd;
	protected String[] normalStartList = { "/*" }; // defaults
	protected String[] normalEndList = { "*/" };

	protected String[] todoPatterns = new String[]{};

	protected Pattern fileFilter;

	public GenericConfig() {
		// set default values (Java)
		lineStart = "//";
		normalStart = "/*";
		normalEnd = "*/";
		formalStart = "/**";
		formalEnd = "*/";
		setFileFilter(".*\\.(java|c|cpp|h|hpp|pas|dpr)");
	}

	public String getLineCommentStart() {
		return lineStart;
	}

	public void setLineCommentStart(String s) {
		lineStart = s;
	}

	public String[] getNormalBlockCommentStarts() { return normalStartList; }
	public String getNormalBlockCommentStart() {
		return normalStart;
	}

	public void setNormalBlockCommentStarts(String[] s) { normalStartList = s; }
	public void setNormalBlockCommentStart(String s) {
		normalStart = s;
	}

	public String[] getNormalBlockCommentEnds() { return normalEndList; }
	public String getNormalBlockCommentEnd() {
		return normalEnd;
	}

	public void setNormalBlockCommentEnds(String[] s) { normalEndList = s; }
	public void setNormalBlockCommentEnd(String s) {
		normalEnd = s;
	}

	public String getFormalBlockCommentStart() { return formalStart; }

	public void setFormalBlockCommentStart(String s) { formalStart = s; }

	public String getFormalBlockCommentEnd() { return formalEnd; }

	public void setFormalBlockCommentEnd(String s) { formalEnd = s; }

	public String[] getTodoPatterns() {
		return todoPatterns;
	}

	public void setTodoPatterns(String[] regexps) {
		todoPatterns = regexps;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("line comment start:         " + lineStart + "\n");
		buf.append("normal block comment start: " + normalStart + "\n");
		buf.append("normal block comment end:   " + normalEnd + "\n");
		buf.append("formal block comment start: " + formalStart + "\n");
		buf.append("formal block comment end:   " + formalEnd + "\n");
		buf.append("file filter:                " + fileFilter + "\n");
		return buf.toString();
	}

	public Pattern getFileFilter() {
		return fileFilter;
	}

	public void setFileFilter(String regexp) {
		fileFilter = Pattern.compile(regexp);
	}
}
