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

/**
 * @author Mircea Trifu
 *
 */
class MemberImplementation implements Serializable{
	public static final int PRIVATE = 1;
	public static final int PACKAGE = 2;
	public static final int STRICTPROTECTED = 3;
	public static final int PROTECTED = 4;
	public static final int PUBLIC = 5;
	public static final int ACCESS_SPECIFIER = 15;
	public static final int ABSTRACT = 16;
	public static final int FINAL = 32;
	public static final int STATIC = 64;
	public static final int VIRTUAL = 128;
	public static final int INTERNAL = 256;
	public static final int EXTERN = 512;
	public static final int OVERRIDE = 1024;
	public static final int INTROSPECTABLE = 2048;
	
	public Member overridenMember;
		
	/*
	 * modifier - bit fields
	 * Bits			Field
	 *  0-3			AccessSpecifier
	 *  4			Abstract
	 *  5			Final
	 *  6			Static
	 *  7			Virtual
	 *  8			Internal
	 *  9			Extern
	 * 10			Override(1), New(0)
	 */
	 
	public static int defaultModifier = PACKAGE;
	private int modifiers = defaultModifier;
	private Class surroundingClass;

	public boolean isPrivate() {
		return (modifiers & ACCESS_SPECIFIER) == PRIVATE;
	}

	public boolean isProtected() {
		return (modifiers & ACCESS_SPECIFIER) == PROTECTED;
	}

	public boolean isStrictProtected() {
		return (modifiers & ACCESS_SPECIFIER) == STRICTPROTECTED;
	}

	public boolean isPackage() {
		return (modifiers & ACCESS_SPECIFIER) == PACKAGE;
	}

	public boolean isPublic() {
		return (modifiers & ACCESS_SPECIFIER) == PUBLIC;
	}
	
	public boolean isIntrospectable() {
		return (modifiers & INTROSPECTABLE) != 0;
	}

	public boolean isAbstract() {
		return (modifiers & ABSTRACT) != 0;
	}

	public boolean isFinal() {
		return (modifiers & FINAL) != 0;
	}

	public boolean isStatic() {
		return (modifiers & STATIC) != 0;
	}

	public boolean isVirtual() {
		return (modifiers & VIRTUAL) != 0;
	}

	public boolean isInternal() {
		return (modifiers & INTERNAL) != 0;
	}

	public boolean isExtern() {
		return (modifiers & EXTERN) != 0;
	}

	public boolean isNew() {
		return (modifiers & OVERRIDE) == 0;
	}

	public boolean isOverride() {
		return (modifiers & OVERRIDE) != 0;
	}

	public void setInternal(boolean i) {
		if (i) 
			modifiers = modifiers | INTERNAL;
		else 
			modifiers = modifiers & ~INTERNAL;
	}

	public void setExtern(boolean e) {
		if (e) 
			modifiers = modifiers | EXTERN;
		else 
			modifiers = modifiers & ~EXTERN;
	}

	public void setNew() {
		modifiers = modifiers & ~OVERRIDE;
	}

	public void setOverride() {
		modifiers = modifiers | OVERRIDE;
	}

	public Member getOverridenMember() {
		return overridenMember;
	}

	public void setOverridenMember(Member overridenMember) {
		this.overridenMember = overridenMember;
	}

	public void setPrivate() {
		modifiers = (modifiers & ~ACCESS_SPECIFIER) | PRIVATE;
	}

	public void setPackage() {
		modifiers = (modifiers & ~ACCESS_SPECIFIER) | PACKAGE;
	}

	public void setProtected() {
		modifiers = (modifiers & ~ACCESS_SPECIFIER) | PROTECTED;
	}

	public void setStrictProtected() {
		modifiers = (modifiers & ~ACCESS_SPECIFIER) | STRICTPROTECTED;
	}

	public void setPublic() {
		modifiers = (modifiers & ~ACCESS_SPECIFIER) | PUBLIC;
	}
	
	public void setIntrospectable(boolean i) {
		if (i)
			modifiers = modifiers | INTROSPECTABLE;
		else
			modifiers = modifiers & ~INTROSPECTABLE;
		
	}

	public void setAbstract(boolean a) {
		if (a) 
			modifiers = modifiers | ABSTRACT;
		else
			modifiers = modifiers & ~ABSTRACT;
	}

	public void setFinal(boolean f) {
		if (f) 
			modifiers = modifiers | FINAL;
		else
			modifiers = modifiers & ~FINAL;
	}

	public void setStatic(boolean s) {
		if (s)
			modifiers = modifiers | STATIC;
		else
			modifiers = modifiers & ~STATIC;
			
	}

	public void setVirtual(boolean v) {
		if (v)
			modifiers = modifiers | VIRTUAL;
		else
			modifiers = modifiers & ~VIRTUAL;
	}

	public Class getSurroundingClass() {
		return surroundingClass;
	}

	void setSurroundingClass(Class cls) {
		surroundingClass = cls;		
	}

/*	public boolean isAccessibleFrom(Class c) {
		// TO DO Query isAccessibleFrom(Class c)
		return false;
	}*/

/*	public boolean isAccessibleFrom(String qualifiedName) {
		// TO DO Query isAccessibleFrom(String qualifiedName)
		return false;
	}*/

	public boolean isTypeParameterMember() {
		return getSurroundingClass() instanceof TypeParameterClass;
	}
	
	public ModelElement getParent() {
		return getSurroundingClass();
	}
	
	public void changeAccessSpecifier(int a) {
		modifiers = (modifiers & ~ACCESS_SPECIFIER) | a;
	}
	
	public void toggleIntrospectable() {
		modifiers = (~modifiers & INTROSPECTABLE) | (modifiers & ~INTROSPECTABLE);
	}

	public void toggleAbstract() {
		modifiers = (~modifiers & ABSTRACT) | (modifiers & ~ABSTRACT);
	}
	
	public void toggleFinal() {
		modifiers = (~modifiers & FINAL) | (modifiers & ~FINAL);
	}

	public void toggleStatic() {
	    modifiers = (~modifiers & STATIC) | (modifiers & ~STATIC); 
	}
	
	public void toggleExtern() {
	    modifiers = (~modifiers & EXTERN) | (modifiers & ~EXTERN);
	}
	
	public void toggleVirtual() {
	    modifiers = (~modifiers & VIRTUAL) | (modifiers & ~VIRTUAL);
	}
	
	public void toggleNew() {
	    modifiers = (~modifiers & OVERRIDE) | (modifiers & ~OVERRIDE);
	}
	
	public void toggleOverride() {
		toggleNew();
	}
}
