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

import de.fzi.sissy.metamod.File;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author Mircea Trifu
 *
 */
public class Position implements Serializable {
	private File sourceFile;
    private int startLine;
    private int startColumn;
    private int endLine;
    private int endColumn;
    private File assembly;

	public Position(File sourceFile, int startLine, int startColumn, int endLine, int endColumn) {
		setSourceFile(sourceFile);
		setStartLine(startLine);
		setStartColumn(startColumn);
		setEndLine(endLine);
		setEndColumn(endColumn);
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public File getSourceFile() {
		return sourceFile;
	}
	
	public void setAssembly(File file) {
	    assembly = file;
	}
	
	public File getAssembly() {
	    return assembly;
	}

	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}

	public int getStartLine() {
		return startLine;
	}

	public void setStartColumn(int startColumn) {
		this.startColumn = startColumn;
	}

	public int getStartColumn() {
		return startColumn;
	}

	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	public int getEndLine() {
		return endLine;
	}

	public void setEndColumn(int endColumn) {
		this.endColumn = endColumn;
	}

	public int getEndColumn() {
		return endColumn;
	}
	
	public boolean contains(Position pos)
	{
		if(pos.sourceFile == null) return false;
		java.io.File thisFile = new java.io.File(sourceFile.getSystemPathName());
		java.io.File otherFile = new java.io.File(pos.sourceFile.getSystemPathName());
		try {
			if(!thisFile.getCanonicalPath().equals(otherFile.getCanonicalPath()))
			{
				return false;
			}
		} catch (IOException e) {
			// e.printStackTrace();
			return false;
		}
		if(pos.startLine>=startLine&&pos.endLine<=endLine)
		{
			return true;
		}
		return false;
	}
}
