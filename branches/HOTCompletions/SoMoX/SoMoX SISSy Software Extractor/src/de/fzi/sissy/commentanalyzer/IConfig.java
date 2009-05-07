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
 * Common interface to access configuration information that controls the
 * operation of the comment analyzer.
 * 
 * @author Philipp Haller
 */
public interface IConfig {

	String getLineCommentStart();
	void setLineCommentStart(String s);
	
	String[] getNormalBlockCommentStarts();
	void setNormalBlockCommentStarts(String[] s);
	String getNormalBlockCommentStart();
	void setNormalBlockCommentStart(String s);
	
	String[] getNormalBlockCommentEnds();
	void setNormalBlockCommentEnds(String[] s);
	String getNormalBlockCommentEnd();
	void setNormalBlockCommentEnd(String s);
	
	String getFormalBlockCommentStart();
	void setFormalBlockCommentStart(String s);
	
	String getFormalBlockCommentEnd();
	void setFormalBlockCommentEnd(String s);
	
	String[] getTodoPatterns();
	void setTodoPatterns(String[] regexps);
	
	Pattern getFileFilter();
	void setFileFilter(String regexp);
}
