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
package de.fzi.sissy.extractors.cdt.simplemodel;
/*
 * Created on 26.08.2004
 */

/**
 * @author phil
 */
public class Method {

	private String name;
	private String fullyQualifiedName;
	private boolean isStatic;
	
	public Method(String name, String fullyQualifiedName, boolean isStatic) {
		this.name = name;
		this.fullyQualifiedName = fullyQualifiedName;
		this.isStatic = isStatic;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param fullyQualifiedName The fullyQualifiedName to set.
	 */
	public void setFullyQualifiedName(String fullyQualifiedName) {
		this.fullyQualifiedName = fullyQualifiedName;
	}

	/**
	 * @return Returns the fullyQualifiedName.
	 */
	public String getFullyQualifiedName() {
		return fullyQualifiedName;
	}

	/**
	 * @param isStatic The isStatic to set.
	 */
	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	/**
	 * @return Returns the isStatic.
	 */
	public boolean isStatic() {
		return isStatic;
	}
}