/**
 * GenericConstructor.java, 29.05.2007
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

public class GenericConstructor extends Constructor implements GenericEntity {

	public GenericConstructor(String name) {
		super(name);
		typeParameters = new ModelElementList();
	}
	
	private ModelElementList typeParameters;

	public void setTypeParameters(ModelElementList typeParameters) {
		this.typeParameters = typeParameters;
	}

	public ModelElementList getTypeParameters() {
		return typeParameters;
	}
	
	public void addTypeParameter(TypeParameterClass tpc) {
		typeParameters.addUnique(tpc);
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		typeParameters.destroy();
		typeParameters = null;
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitGenericConstructor(this);
	}

	public void insertTypeParameter(TypeParameterClass tpc, int position) {
		typeParameters.add(position, tpc);  
	}

	public void removeTypeParameter(TypeParameterClass tpc) {
		typeParameters.remove(tpc); 
	    ModelElementRepository.getWorkingRepository().removeElement(tpc);
	}
}
