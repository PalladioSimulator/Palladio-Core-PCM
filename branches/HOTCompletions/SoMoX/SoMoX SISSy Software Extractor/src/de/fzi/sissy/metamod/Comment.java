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
package de.fzi.sissy.metamod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Philipp Haller
 * 
 */
public class Comment extends ModelElementImplementation implements
		ModelAnnotation, SourceEntity {

	public ModelElement getParent() {
		return null;
	}
	
	private ArrayList text;
	private Position pos;
	private boolean formal;
	private int todoCount;
	
	public Comment(boolean formal, ArrayList commTextLines, int todoCount) {
		this.formal = formal;
		text = commTextLines;
		this.todoCount = todoCount;
	}

	public Comment(boolean formal, String commText, int todoCount) {
		this.formal = formal;
		text = new ArrayList();
		StringTokenizer tok = new StringTokenizer(commText, "\n");
		while (tok.hasMoreTokens())
			text.add(tok.nextToken());
		this.todoCount = todoCount;
	}
	
	public String getText() {
		StringBuffer buf = new StringBuffer();
		Iterator lines = text.iterator();
		if (lines.hasNext())
			buf.append(lines.next());
		while (lines.hasNext()) {
			buf.append("\n").append((String)lines.next());
		}
		return buf.toString();
	}

	public int getNumberOfCommentLines() { return text.size(); }

	public boolean isFormal() { return formal; }

	public boolean isTodo() { return todoCount > 0; }

	public int getTodoCount() { return todoCount; }

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Comment line from ");
		buf.append(pos.getStartLine());
		buf.append(" to ").append(pos.getEndLine());
		buf.append(": ");
		buf.append(getText());
		return buf.toString();
	}

	public void setPosition(Position p) { pos = p; }

	public Position getPosition() { return pos; }
		
	public boolean isDirectlyInFrontOf(Position p) {
		if ((pos.getEndLine() >= p.getStartLine() - 2)
				&& (pos.getEndLine() <= p.getStartLine()))
			return true;
		return false;
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitComment(this);
	}

	public void moveToFile(File file) {
		// TODO Auto-generated method stub
		
	}
}
