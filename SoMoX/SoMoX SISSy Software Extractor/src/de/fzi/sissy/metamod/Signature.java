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

import java.io.Serializable;
import java.util.Iterator;

import de.fzi.sissy.util.Debug;

/**
 * @author Mircea Trifu
 *
 */
public class Signature implements Serializable {
	private TypeAccess returnTypeDeclaration;
    private String simpleName;
	private ModelElementList parameterTypeDeclarations;
	private ModelElementList exceptionTypeDeclarations;
	
	public Signature(TypeAccess retTypeDeclaration, String name, ModelElementList paramTypes, ModelElementList exTypes) {
		returnTypeDeclaration = retTypeDeclaration;
		simpleName = name;
		parameterTypeDeclarations = paramTypes;
		exceptionTypeDeclarations = exTypes;
	}
	
	public void setReturnTypeDeclaration(TypeAccess returnTypeDeclaration) {
		this.returnTypeDeclaration = returnTypeDeclaration;
	}

	public TypeAccess getReturnTypeDeclaration() {
		return returnTypeDeclaration;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setParameterTypeDeclarations(ModelElementList parameterTypeDeclarations) {
		this.parameterTypeDeclarations = parameterTypeDeclarations;
	}

	public ModelElementList getParameterTypeDeclarations() {
		return parameterTypeDeclarations;
	}
	
	public void addParameterTypeDeclaration(TypeAccess type) {
		parameterTypeDeclarations.addUnique(type);
	}

	public void setExceptionTypeDeclarations(ModelElementList exceptionTypeDeclarations) {
		this.exceptionTypeDeclarations = exceptionTypeDeclarations;
	}

	public ModelElementList getExceptionTypeDeclarations() {
		return exceptionTypeDeclarations;
	}
	
	public void addExceptionTypeDeclaration(TypeAccess type) {
		exceptionTypeDeclarations.addUnique(type);
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();

		/* mtrifu: Commented out because return types do not belong to the signature
		if (getReturnTypeDeclaration() != null) {
			buf = new StringBuffer(getReturnTypeDeclaration().getAccessedType().getQualifiedName());
			buf.append(" ");
		}
		*/

		buf.append(getSimpleName());
		buf.append("(");
		Iterator it = getParameterTypeDeclarations().iterator();
		while (it.hasNext()) {
			TypeAccess param = (TypeAccess)it.next();
            
            if (param!=null) {
            	buf.append(param.getAccessedType().getQualifiedName());
            }
            else {
            	// This may happen for Delphi for untyped pointers
            	// This should actually be fixed in the delphi extractor code
                Debug.warning("Signature.toString():Formal Parameter-Declaration Type Access for " + getSimpleName() + " was null!");
            }
            if (it.hasNext())
				buf.append(", ");
		}
		buf.append(")");
		/* mtrifu: Commented out because exception types do not belong to the signature
		it = getExceptionTypeDeclarations().iterator();
		if (it.hasNext())
			buf.append(" throws ");			
		while (it.hasNext()) {
			TypeAccess ex = (TypeAccess)it.next();
            if (ex.getAccessedType()!=null)
                buf.append(ex.getAccessedType().getQualifiedName());
			if (it.hasNext())
				buf.append(", ");
		}
		*/
		return buf.toString();
	}
	
	public boolean equals(Signature signature) {
		if (signature.quickcompareCode() != this.quickcompareCode())
			return false;
			
		return this.toString().equals(signature.toString());
	}
	
	public int quickcompareCode() {
		return simpleName.length()*100+this.parameterTypeDeclarations.size();
	}
}
