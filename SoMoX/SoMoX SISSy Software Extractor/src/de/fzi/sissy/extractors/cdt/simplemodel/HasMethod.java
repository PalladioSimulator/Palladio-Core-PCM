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
 * Created on 22.08.2004
 */

/**
 * @author phil
 */
public class HasMethod {

	private String sourceName;
	private String targetName;
	private String visibility;
	
	public HasMethod(String sourceName, String targetName) {
		this.setSourceName(sourceName);
		this.setTargetName(targetName);
	}
	
	public boolean equals(Object o) {
		if (o instanceof HasMethod) {
			HasMethod other = (HasMethod) o;
			if (other.getSourceName().equals(sourceName)
					&& (other.getTargetName().equals(targetName)))
				return true;
		}
		return false;
	}
	
	public int hashCode() {
		return sourceName.hashCode() + targetName.hashCode();
	}
	
	/**
	 * @param sourceName The sourceName to set.
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	/**
	 * @return Returns the sourceName.
	 */
	public String getSourceName() {
		return sourceName;
	}
	/**
	 * @param targetName The targetName to set.
	 */
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	/**
	 * @return Returns the targetName.
	 */
	public String getTargetName() {
		return targetName;
	}
	/**
	 * @param visibility The visibility to set.
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	/**
	 * @return Returns the visibility.
	 */
	public String getVisibility() {
		return visibility;
	}
}
