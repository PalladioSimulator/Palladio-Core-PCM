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
public class Package extends ReferenceableImplementation implements StructuralEntity, Referenceable, NamedModelElement {
	protected ModelElementList subPackages;
	protected ModelElementList classes;
	protected Package surroundingPackage;

	protected ModelElementList delegates;
	protected ModelElementList typeAliases;
	protected ModelElementList globalVariables;
	protected ModelElementList globalFunctions;

	protected Root root;

	public Package(String name) {
		super(name);
		subPackages = new ModelElementList();
		classes = new ModelElementList();
		delegates = new ModelElementList();
		typeAliases = new ModelElementList();
		globalVariables = new ModelElementList();
		globalFunctions = new ModelElementList();
	}

	public Package(String name, Root root) {
		this(name);
		root.addPackage(this);
	}
	
	public String getQualifiedName() {
		String prefix;
		if (getSurroundingPackage() != null)
			prefix = getSurroundingPackage().getQualifiedName() + '.';
		else
			prefix = new String();
		return prefix + getSimpleName();
	}

/*	public void setSubPackages(ModelElementList subPackages) {
		this.subPackages.clear();
		this.subPackages.addAll(subPackages);
		Iterator it = this.subPackages.iterator();
		while (it.hasNext()) {
			Package pack = (Package)it.next();
			pack.setSurroundingPackage(this);
		}
	}*/

	public ModelElementList getSubPackages() {
		return subPackages;
	}

	public void addSubPackage(Package pack) {
		subPackages.addUnique(pack);
		pack.setSurroundingPackage(this);
		root.addPackage(pack);
	}

/*	public void setClasses(ModelElementList classes) {
		this.classes.clear();
		this.classes.addAll(classes);
		Iterator it = this.classes.iterator();
		while (it.hasNext()) {
			Class cls = (Class)it.next();
			cls.setSurroundingPackage(this);
		}		
	}*/

	public ModelElementList getClasses() {
		return classes;
	}
	
	public void addClass(Class cls) {
		classes.addUnique(cls);
		cls.setSurroundingPackage(this);
		root.addType(cls);
	}

	/**
	 * Do not call this method directly. Use Package.addSubPackage instead.
	 */
	public void setSurroundingPackage(Package surroundingPackage) {
	    this.surroundingPackage = surroundingPackage;
	}

	public Package getSurroundingPackage() {
		return surroundingPackage;
	}

	/**
	 * Do not call this method directly. Use Root.addPackage instead.
	 */
	void setRoot(Root root) {
		this.root = root;
	}

	public Root getRoot() {
		return root;
	}

	public Class getClassByName(String simpleName) {
		Iterator it = classes.iterator();
		while (it.hasNext()) {
			Class cls = (Class)it.next();
			if (cls.getSimpleName().equals(simpleName))
				return cls;
		}
		return null;
	}
	
    public boolean existsClass(String simpleName) {
    	if (getClassByName(simpleName) != null)
    		return true;
    	return false;
    }

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		classes.destroy();
		delegates.destroy();
		globalFunctions.destroy();
		globalVariables.destroy();
		subPackages.destroy();
		typeAliases.destroy();

		classes = null;
		delegates = null;
		globalFunctions = null;
		globalVariables = null;
		subPackages = null;
		typeAliases = null;

		root = null;
		surroundingPackage = null;
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitPackage(this);
	}
	
	public ModelElement getParent() {
		if (getSurroundingPackage() != null)
			return getSurroundingPackage();
		return root;
	}

/*	public void setDelegates(ModelElementList delegates) {
		this.delegates.clear();
		this.delegates.addAll(delegates);
		Iterator it = this.delegates.iterator();
		while (it.hasNext()) {
			Delegate delegate = (Delegate)it.next();
			delegate.setSurroundingPackage(this);
		}
	}*/

	public ModelElementList getDelegates() {
		return delegates;
	}

	public void addDelegate(Delegate delegate) {
		delegates.addUnique(delegate);
		delegate.setSurroundingPackage(this);
		root.addType(delegate);
	}

/*	public void setTypeAliases(ModelElementList typeAliases) {
		this.typeAliases.clear();
		this.typeAliases.addAll(typeAliases);
		Iterator it = this.typeAliases.iterator();
		while (it.hasNext()) {
			TypeAlias typeAlias = (TypeAlias)it.next();
			typeAlias.setSurroundingPackage(this);
		}
	}*/

	public ModelElementList getTypeAliases() {
		return typeAliases;
	}

	public void addTypeAlias(TypeAlias typeAlias) {
		if (typeAliases.contains(typeAlias))
		    return;
	    typeAliases.addUnique(typeAlias);
		typeAlias.setSurroundingPackage(this);
		root.addType(typeAlias);
	}

/*	public void setGlobalVariables(ModelElementList gv) {
		globalVariables.clear();
		Iterator it = gv.iterator();
		while (it.hasNext()) {
		    addGlobalVariable((GlobalVariable) it.next());
		}
	}*/

	public ModelElementList getGlobalVariables() {
		return globalVariables;
	}

	public void addGlobalVariable(GlobalVariable globalVariable) {
		globalVariables.addUnique(globalVariable);
		globalVariable.setSurroundingPackage(this);
		root.addGlobalVariable(globalVariable);
	}

/*	public void setGlobalFunctions(ModelElementList globalFunctions) {
		this.globalFunctions.clear();
		Iterator it = globalFunctions.iterator();
		while (it.hasNext()) {
		    addGlobalFunction((GlobalFunction) it.next());
		}
	}*/

	public ModelElementList getGlobalFunctions() {
		return globalFunctions;
	}
    public int getLinesOfCode() {
    	int LOC = 0;
    	Iterator it;
    	// -- Classes
    	it =  getClasses().iterator();
    	while(it.hasNext())
    	{
    		Class cls = (Class)it.next();
    		LOC += cls.getTotalLinesOfCode();
    	}
    	// -- Global functions
    	it =  getGlobalFunctions().iterator();
    	while(it.hasNext())
    	{
    		Function func = (Function)it.next();
    		LOC += func.getLinesOfCode();
    	}
    	return LOC;
    }

    public int getLinesOfComments() {
    	int LOC = 0;
    	Iterator it;
    	// -- Classes
    	it =  getClasses().iterator();
    	while(it.hasNext())
    	{
    		Class cls = (Class)it.next();
    		LOC += cls.getTotalLinesOfComments();
    	}
    	// -- Global functions
    	it =  getGlobalFunctions().iterator();
    	while(it.hasNext())
    	{
    		Function func = (Function)it.next();
    		LOC += func.getLinesOfComments();
    	}
    	return LOC;
    }    

	public void addGlobalFunction(GlobalFunction globalFunction) {
		globalFunctions.addUnique(globalFunction);
		globalFunction.setSurroundingPackage(this);
		root.addGlobalFunction(globalFunction);
	}

	void simpleRemoveSubPackage(Package pack) {
	    subPackages.remove(pack);
	}
	
	void simpleAddSubPackage(Package pack) {
	    subPackages.addUnique(pack);
	}
	
	public void moveToRoot() {
	    if (surroundingPackage != null) {
	        surroundingPackage.simpleRemoveSubPackage(this);
	        setSurroundingPackage(null);
	    }
	}

	public void moveToPackage(Package pack) {
		if (surroundingPackage != null)
		    surroundingPackage.simpleRemoveSubPackage(this);
		pack.simpleAddSubPackage(pack);
	}

	public void removeSubPackage(Package pack) {
		if (!subPackages.contains(pack))
		    return;
	    subPackages.remove(pack);
	    root.removePackage(pack);
	}

	public void removeGlobalFunction(GlobalFunction gf) {
		if (!globalFunctions.contains(gf))
		    return;
		globalFunctions.remove(gf);
		root.removeGlobalFunction(gf);
	}

	public void removeGlobalVariable(GlobalVariable gv) {
		if (!globalVariables.contains(gv))
		    return;
		globalVariables.remove(gv);
		root.removeGlobalVariable(gv);
	}

	public void removeClass(Class cl) {
		if (!classes.contains(cl))
		    return;
		classes.remove(cl);
		root.removeType(cl);
	}

	public void removeDelegate(Delegate dg) {
	    if (!delegates.contains(dg))
	        return;
	    delegates.remove(dg);
	    root.removeType(dg);
	}

	public void removeTypeAlias(TypeAlias ta) {
		if (!typeAliases.contains(ta))
		    return;
		typeAliases.remove(ta);
		root.removeType(ta);
	}

	void simpleRemoveClass(Class cls) {
	    classes.remove(cls);
	}
	
	void simpleAddClass(Class cls) {
	    classes.addUnique(cls);
	}

	void simpleRemoveTypeAlias(TypeAlias alias) {
	    typeAliases.remove(alias);
	}
	
	void simpleAddTypeAlias(TypeAlias alias) {
	    typeAliases.addUnique(alias);
	}

	void simpleAddDelegate(Delegate d) {
	    delegates.addUnique(d);
	}
	
	void simpleRemoveDelegate(Delegate d) {
	    delegates.remove(d);
	}

	void simpleRemoveGlobalVariable(GlobalVariable var) {
	    globalVariables.remove(var);
	}
	
	void simpleAddGlobalVariable(GlobalVariable var) {
	    globalVariables.addUnique(var);
	}
	
	void simpleRemoveGlobalFunction(GlobalFunction gf) {
	    globalFunctions.remove(gf);
	}
	
	void simpleAddGlobalFunction(GlobalFunction gf) {
	    globalFunctions.addUnique(gf);
	}
}
