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

/**
 * @author Mircea Trifu
 *
 */
public class FunctionAccess extends AccessImplementation implements Access {
    private ModelElementList typeArgs;
        
    /**
	 * @param target
	 */
	public FunctionAccess(Function target) {
		super(target);
		typeArgs = new ModelElementList();
	}

    public Function getAccessedFunction() {
    	return (Function)getAccessedTarget();
    }

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitFunctionAccess(this);
	}
		
	public void setTypeArgs(ModelElementList typeArgs) {
		this.typeArgs = typeArgs; 
	}
	
	public ModelElementList getTypeArgs() {
		return this.typeArgs;	
	}

	public void addTypeArg(Type typeArg) {
		this.typeArgs.addUnique(typeArg);
	}

	public void insertTypeArgument(Type ta, int position) {
		typeArgs.add(position, ta); 
	}
	
	public void removeTypeArgument(int position) {
		typeArgs.remove(typeArgs.get(position));
	}

    public String toString() {
        if (this.getAccessedFunction() != null)
            return this.getAccessedFunction().signature().toString();
        
        return "null-function accessed";
    }
}
