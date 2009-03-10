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
package de.fzi.sissy.extractors.cdt.ast;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.cdt.core.parser.ast.IASTReference;

import de.fzi.sissy.util.Debug;

public abstract class ASTAbstractStatement implements IASTStatement {
	
    private Collection refs = null;

    public void addReference(IASTReference ref) {
    	if (refs == null) {
    		refs = new Vector();
    	}
    	
    	//Debug.cbinfo("adding reference (" + ref.getReferencedElement() + ") to statement |[" + this.toString() + "]|");
        refs.add(ref);
    }
    
    public Collection getReferences() {
        return refs;
    }
    
    // position info
    private int startLine;
    private int startOffset;
    private int endLine;
    private int endOffset;
	
    public int getEndLine() {
		return endLine;
	}
	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}
	public int getEndOffset() {
		return endOffset;
	}
	public void setEndOffset(int endOffset) {
		this.endOffset = endOffset;
	}
	public int getStartLine() {
		return startLine;
	}
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}
	public int getStartOffset() {
		return startOffset;
	}
	public void setStartOffset(int startOffset) {
		this.startOffset = startOffset;
	}
}
