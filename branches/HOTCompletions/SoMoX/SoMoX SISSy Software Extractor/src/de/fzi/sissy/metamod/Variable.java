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
abstract public class Variable extends ReferenceableImplementation 
		implements Referenceable, StructuralEntity, SourceEntity, 
		NamedModelElement, AccessContainer {
	private DeclarationTypeAccess typeDeclaration;
	private boolean pConst;
	
	public Variable(String name) {
		super(name);
		pConst = false;
	}

    public void setTypeDeclaration(DeclarationTypeAccess typeDeclaration) {
		this.typeDeclaration = typeDeclaration;
		if (typeDeclaration!=null) {
			typeDeclaration.setSurroundingAccessContainer(this);
		}
    }

	public DeclarationTypeAccess getTypeDeclaration() {
		return typeDeclaration;
	}

	public Type getType() {
		return typeDeclaration.getAccessedType();
	}

	public void setConst(boolean pconst) {
		pConst = pconst;
	}

	public boolean isConst() {
		return pConst;
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		setPosition(null);
		sourceEntityImplementation = null;
		typeDeclaration = null;
	}
	
	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitVariable(this);
	}

	// delegation to the sourceentityimplemenatation
	
	private SourceEntityImplementation sourceEntityImplementation = new SourceEntityImplementation();
	
	public void setPosition(Position pos) {
	    sourceEntityImplementation.setPosition(pos, this);
	}
	
	public Position getPosition() {
	    return sourceEntityImplementation.getPosition();
	}
	
	public void moveToFile(File file) {
	    sourceEntityImplementation.moveToFile(file);
	}

	public void changeType(DeclarationTypeAccess dta) {
		typeDeclaration.getSurroundingStatement().replaceAccess(typeDeclaration, dta);
		typeDeclaration = dta;
	}

	public void toggleConst() {
		pConst = !pConst;
	}
    
    /*
    public String toString() {
        if (this.getType()!=null)
            return this.getType().getQualifiedName() + " " + this.getSimpleName();
        
        return this.getSimpleName();
    }
    */
	
	public void removeContainedAccess(Access acc) {
		if (acc == typeDeclaration)
			typeDeclaration = null;
	}	
}
