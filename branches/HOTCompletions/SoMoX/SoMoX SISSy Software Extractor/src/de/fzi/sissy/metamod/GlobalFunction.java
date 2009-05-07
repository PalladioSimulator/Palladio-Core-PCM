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

/**
 * @author Mircea Trifu
 *
 */
public class GlobalFunction extends Function implements Referenceable {
	public static final int NORMAL = 1;
	public static final int UNIT_INITIALIZER = 2;
	public static final int UNIT_FINALIZER = 3;
	private Root root;
	private int kind = NORMAL;

	private Package surroundingPackage;

	public GlobalFunction(String name) {
		super(name);
	}

	void setRoot(Root root) {
		this.root = root;
	}

	public Root getRoot() {
		return root;
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		root = null;
		surroundingPackage = null;
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitGlobalFunction(this);
	}
	
	public ModelElement getParent() {
		if (surroundingPackage != null)
			return getSurroundingPackage();
		return getRoot();
	}

	public boolean isUnitInitializer() {
		return (kind == UNIT_INITIALIZER);
	}

	public boolean isUnitFinalizer() {
		return (kind == UNIT_FINALIZER);
	}

	public void setKind(int kind) {
		if ((kind >= NORMAL) && (kind <= UNIT_FINALIZER))
			this.kind = kind;
	}
	
	public Package getSurroundingPackage() {
		return surroundingPackage;
	}

	//is called from Package.addGlobalFunction
	public void setSurroundingPackage(Package package1) {
		surroundingPackage = package1;
	}

	public void convertToUnitInitializer() {
		if (kind == UNIT_INITIALIZER)
		    return;
		
		kind = UNIT_INITIALIZER;
		setReturnTypeDeclaration(null);
	    setSimpleName("");
	    Iterator itor = (new ArrayList(getFormalParameters())).iterator();
	    while (itor.hasNext()) {
	        removeFormalParameter((FormalParameter)itor.next());
	    }
	}

	public void convertToUnitFinalizer() {
		if (kind == UNIT_FINALIZER)
		    return;
		
		kind = UNIT_FINALIZER;
		setReturnTypeDeclaration(null);
	    setSimpleName("");
	    Iterator itor = (new ArrayList(getFormalParameters())).iterator();
	    while (itor.hasNext()) {
	        removeFormalParameter((FormalParameter)itor.next());
	    }
	}

	public void convertToGlobalFunction() {
		if (kind == NORMAL)
		    return;

		kind = NORMAL;
		
		setSimpleName("init");

		Type voidType = getRoot().findType("void");
		DeclarationTypeAccess dta = new DeclarationTypeAccess(voidType);
		setReturnTypeDeclaration(dta);		
	}

	public void moveToPackage(Package pack) {
		getSurroundingPackage().simpleRemoveGlobalFunction(this);
		pack.simpleAddGlobalFunction(this);
	}

}
