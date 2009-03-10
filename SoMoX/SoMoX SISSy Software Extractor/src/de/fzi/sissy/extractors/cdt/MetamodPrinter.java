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
package de.fzi.sissy.extractors.cdt;

import java.util.Iterator;

import de.fzi.sissy.metamod.*;
import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.Package;

public class MetamodPrinter {

	public static void printModel(Root root) {
		System.out.println("Printing Metamod model...");
		
        System.out.println("Files:");
        Iterator files = root.getFiles().iterator();
        while (files.hasNext()) {
            de.fzi.sissy.metamod.File file = (de.fzi.sissy.metamod.File) files.next();
            println(file.getPathName(), 2);
        }
        
        System.out.println("Packages:");
        Iterator packages = root.getPackages().iterator();
		while (packages.hasNext()) {
			Package pkg = (Package) packages.next();
			printPackage(pkg, 0);
		}
        
        System.out.println("Subsystems:");
        Iterator subsystems = root.getStructuralAbstractions().iterator();
        while (subsystems.hasNext()) {
            StructuralAbstraction sa = (StructuralAbstraction) subsystems.next();
            if (sa instanceof Subsystem) {
                printSubsystem((Subsystem)sa, 0);
            }
        }
	}
	
    static void printSubsystem(Subsystem subsys, int level) {
        println("Subsys " + subsys.getSimpleName(), level);
        
        Iterator files = subsys.getModelElements().iterator();
        while (files.hasNext()) {
            ModelElement element = (ModelElement) files.next();
            print(element, level+2);
        }
    }
    
    static void print(ModelElement el, int level) {
        if (el instanceof Subsystem) {
            println("Subsys " + ((Subsystem)el).getSimpleName(), level);
        }
        else if (el instanceof File) {
            println("File " + ((File)el).getPathName(), level);
            
            // include relation
            Iterator includedFiles = ((File)el).getIncludedFiles().iterator();
            while (includedFiles.hasNext()) {
				File included = (File) includedFiles.next();
				println("Includes " + included.getPathName(), level+2);
			}
        }
    }
    
	static void printPackage(Package pkg, int level) {
		println(pkg.getQualifiedName(), level);
		
		Iterator classes = pkg.getClasses().iterator();
		while (classes.hasNext()) {
			Class cls = (Class) classes.next();
			printClass(cls, level+2);
		}
        
        Iterator globVars = pkg.getGlobalVariables().iterator();
        while (globVars.hasNext()) {
            GlobalVariable globvar = (GlobalVariable) globVars.next();
            println(globvar.getSimpleName(), level+2);
        }
        
        Iterator globFuns = pkg.getGlobalFunctions().iterator();
        while (globFuns.hasNext()) {
            GlobalFunction globfun = (GlobalFunction) globFuns.next();
            printFunction(globfun, level+2);
        }
	}
	
	static void printPosition(Position pos, int level) {
		println("([" + pos.getStartLine() + ", "
				+ pos.getStartColumn() + "], ["
				+ pos.getEndLine() + ", "
				+ pos.getEndColumn() + "])", level + 2);
	}
	
	static void printClass(Class cls, int level) {
		println(cls.getQualifiedName(), level);
        
		// Position
		/*printPosition(cls.getPosition(), level+2);*/
        
		Iterator fields = cls.getFields().iterator();
        while (fields.hasNext()) {
            Field fld = (Field) fields.next();
            
            // Sichtbarkeit
            if (fld.isPublic())
                print("public ", level+2);
            else if(fld.isPrivate())
                print("private ", level+2);
            else if(fld.isStrictProtected())
                print("protected ", level+2);
            
            System.out.println(fld.getSimpleName());
        }
        
        Iterator methods = cls.getMethods().iterator();
        while (methods.hasNext()) {
            Method m = (Method) methods.next();
            printFunction(m, level+2);
        }
	}
	
    private static ModelElementList getAccesses(Statement stmt) {
        ModelElementList list = new ModelElementList();
        
        if (stmt instanceof BlockStatement) {
            Iterator stmts = ((BlockStatement)stmt).getStatements().iterator();
            while (stmts.hasNext()) {
                Statement s = (Statement) stmts.next();
                list.addAll(getAccesses(s));
            }
        }
        else {
            if (stmt != null)
                list.addAll(stmt.getAccesses());
        }
        
        return list;
    }
    
    private static void printFunction(Function m, int level) {
        if (m instanceof Method) {
            // Sichtbarkeit
            if (((Method) m).isPublic())
                print("public ", level + 2);
            else if (((Method) m).isPrivate())
                print("private ", level + 2);
            else if (((Method) m).isStrictProtected())
                print("protected ", level + 2);
        }
        
        try {
            System.out.print(m.getReturnType().getSimpleName() + " "
                    + m.getSimpleName());
        } catch (NullPointerException npe) {

        }
        
        // print parameters
        System.out.print(" ( ");
        
        Iterator params = m.getFormalParameters().iterator();
        
        if (params.hasNext()) {
            FormalParameter p = (FormalParameter) params.next();
            System.out.print(p.getType().getSimpleName() + " " + p.getSimpleName());
        }
        
        while (params.hasNext()) {
            FormalParameter p = (FormalParameter) params.next();
            System.out.print(", " + p.getType().getSimpleName() + " " + p.getSimpleName());
        }
        
        System.out.println(" ) ");
        
        println("Accesses:", level+2);
        
        boolean write;
        
        Iterator acc = m.getAccesses().iterator();
        while (acc.hasNext()) {
            Access a = (Access) acc.next();
            if (a instanceof VariableAccess) {
            	write = ((VariableAccess)a).isWriteAccess();
                println("VarAcc (write=" + write + "): " + a.getAccessedTarget().getSimpleName(), level+4);
                if (a.getAccessedTarget() instanceof Field) {
                	Field field = (Field) a.getAccessedTarget();
                	if (field.getSurroundingClass() != null)
                		println("Owner: " + field.getSurroundingClass().getSimpleName(), level+6);
                }
            }
            else if (a instanceof FunctionAccess) {
                println("FunAcc: " + a.getAccessedTarget().getSimpleName(), level+4);
            }
        }
        
        println("computed accesses:", level+2);
        acc = getAccesses(m.getBody()).iterator();
        while (acc.hasNext()) {
            Access a = (Access) acc.next();
            println(a.toString(), level+4);
            if (a instanceof VariableAccess) {
            	write = ((VariableAccess)a).isWriteAccess();
                println("VarAcc (write=" + write + "): " + a.getAccessedTarget().getSimpleName(), level+4);
            }
            else if (a instanceof FunctionAccess) {
                println("FunAcc: " + a.getAccessedTarget().getSimpleName(), level+4);
            }
//          position of access:
            printPosition(a.getPosition(), level+6);
        }
    }

    static void print(String s, int level) {
        for (int i = 0; i < level; i++)
            System.out.print(" ");
        System.out.print(s);
    }
    
	static void println(String s, int level) {
		for (int i = 0; i < level; i++)
			System.out.print(" ");
		System.out.println(s);
	}
}
