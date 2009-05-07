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

import java.util.HashMap;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.Package;
import de.fzi.sissy.metamod.Type;
import de.fzi.sissy.metamod.Variable;

/**
 * @author phil
 */
public class CdtToMetamodMap {

	public HashMap typeMap = null;
	public HashMap varMap = null;
	public HashMap funMap = null;
    public HashMap pkgMap = null;
	
	public CdtToMetamodMap() {
		typeMap = new HashMap();
		varMap = new HashMap();
		funMap = new HashMap();
        pkgMap = new HashMap();
	}
	
	public void clear() {
		typeMap.clear();
		varMap.clear();
		funMap.clear();
        pkgMap.clear();
	}
	
	public void putType(String name, Type type) {
		typeMap.put(name, type);
	}

	public Type getType(String name) {
		return (Type) typeMap.get(name);
	}
	
	public void putFunction(String name, Function fun) {
		funMap.put(name, fun);
	}
	
	public Function getFunction(String name) {
		return (Function) funMap.get(name);
	}
	
	public void putVariable(String name, Variable var) {
		varMap.put(name, var);
	}
	
	public Variable getVariable(String name) {
		return (Variable) varMap.get(name);
	}
    
    public void putPackage(String name, Package pkg) {
        pkgMap.put(name, pkg);
    }
    
    public Package getPackage(String name) {
        return (Package) pkgMap.get(name);
    }
}
