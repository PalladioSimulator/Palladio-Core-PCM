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
package de.fzi.sissy.sql;

/**
 * @author Mircea Trifu
 *
 */
public interface SQLModelConstants {
	public final int ROOT = 1;
	public final int FILE_SOURCE = 2;
	public final int FILE_ASSEMBLY = 3;
	public final int COMMENT = 4;
	public final int PACK_PACKAGE = 17;
	public final int PACK_SUBPACKAGE = 18;
	public final int PACK_PACKAGEALIAS = 19;
	public final int TYPE_PRIMITIVE = 33;
	public final int TYPE_INTERFACE = 34;
	public final int TYPE_CLASS = 35;
	public final int TYPE_GENERICINTERFACE = 36;
	public final int TYPE_GENERICCLASS = 37;
	public final int TYPE_TYPEPARAMCLASS = 38;
	public final int TYPE_ARRAY = 39;
	public final int TYPE_TYPEALIAS = 40;
	public final int TYPE_IMPLICITREFERENCE = 41;
	public final int TYPE_EXPLICITREFERENCE = 42;
	public final int FUNC_TYPE_DELEGATE= 49;
	public final int FUNC_GLOBALFUNC = 50;
	public final int FUNC_GENERICFUNC = 51;
	public final int FUNC_METHOD = 52;
	public final int FUNC_CONSTRUCTOR = 53;
	public final int FUNC_DESTRUCTOR = 54;
	public final int FUNC_INITIALIZER = 55;
	public final int FUNC_PROPGETTER = 56;
	public final int FUNC_PROPSETTER = 57;
	public final int FUNC_UNITINITIALIZER = 58;
	public final int FUNC_UNITFINALIZER = 59;
	public final int FUNC_GENERICMETHOD = 60;
	public final int FUNC_GENERICCONSTRUCTOR = 61;
	public final int VAR_FIELD = 65;
	public final int VAR_LOCALVAR = 66;
	public final int VAR_GLOBALVAR = 67;
	public final int VAR_FORMALPARAM = 68;
	public final int VAR_CATCHPARAM = 69;
	public final int VAR_PROPERTY = 70;
	public final int STATEMENT_SIMPLE = 71;
	public final int STATEMENT_THROW = 72;
	public final int STATEMENT_RETURN = 73;
	public final int STATEMENT_JUMP = 74;
	public final int STATEMENT_LOOP = 75;
	public final int STATEMENT_BRANCH =76;
	public final int STATEMENT_BLOCK = 77;
	public final int STATEMENT_EXCEPTIONHANDLER = 78;
	public final int STATEMENT_CATCHBLOCK = 79;
	public final int VARACCESS_READ = 81;
	public final int VARACCESS_WRITE = 82;
	public final int PROPACCESS_READ = 83;
	public final int PROPACCESS_WRITE = 84;
	public final int SELFACCESS_THIS = 94;
	public final int SELFACCESS_SUPER = 95;
	public final int COMPOSITEACCESS = 96;
	public final int FUNCACCESS = 97;
	public final int DELEGATEACCESS = 98;
	public final int TYPEACCESS_INTERFACEINHERITANCE = 113;
	public final int TYPEACCESS_IMPLEMENTATIONINHERITANCE = 114;
	public final int TYPEACCESS_DECLAREDTHROW = 115;
	public final int TYPEACCESS_THROW = 116;
	public final int TYPEACCESS_DECLARATION = 117;
	public final int TYPEACCESS_CAST = 118;
	public final int TYPEACCESS_RTTI = 119;
	public final int TYPEACCESS_STATIC = 120;
	public final int CLONE_CLONE = 121;
	public final int CLONE_INSTANCE = 122;
	public final int ABSTRACTION_STRUCTURALABSTRACTION = 123;	
	public final int ABSTRACTION_SUBSYSTEM = 124;	
	public final int SCOPE_GLOBAL = 129;
	public final int SCOPE_PACKAGE = 130;
	public final int SCOPE_CLASS = 131;
	public final int SCOPE_LOCAL = 132;
	public final int SCOPE_PROPERTY = 133;
	public final int SCOPE_DECLARATION = 134;
	public final int SCOPE_STATEMENT = 135;
	public final int SCOPE_ACCESS = 136;
	public final int SCOPE_FILE = 137;
	public final int VISIBILITY_PUBLIC = 145;
	public final int VISIBILITY_PROTECTED = 146;
	public final int VISIBILITY_STRICTPROTECTED = 147;
	public final int VISIBILITY_PACKAGE = 148;
	public final int VISIBILITY_PRIVATE = 149;
	public final int STATUS_NORMAL = 161;
	public final int STATUS_LIBRARY = 162;
	public final int STATUS_IMPLICIT = 163;
	public final int STATUS_FAILEDDEP = 164;
}