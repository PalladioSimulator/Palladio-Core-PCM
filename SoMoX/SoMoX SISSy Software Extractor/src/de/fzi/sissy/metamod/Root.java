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

import java.util.Iterator;

/**
 * @author Mircea Trifu
 *
 */
public class Root extends ModelElementImplementation implements ModelElement {
	private transient ModelElementRepository repository;
	private ModelElementList globalVariables;
	private ModelElementList globalFunctions;
	private ModelElementList files;
	private ModelElementList packages;
	private ModelElementList types;
	private ModelElementList clones;
	private ModelElementList abstractions;
	private transient ModelElementList cachedClassList;

	Root(ModelElementRepository repository) {
		this.repository = repository;
		types = new ModelElementList();
		globalVariables = new ModelElementList();
		globalFunctions = new ModelElementList();		
		files = new ModelElementList();
		packages = new ModelElementList();
		clones = new ModelElementList();
		abstractions = new ModelElementList();
	}
	
	public ModelElementRepository getRepository() {
		return repository;
	}
    public int getLinesOfCode() {
    	int LOC = 0;
    	Iterator it;
    	// -- Packages
    	it =  getPackages().iterator();
    	while(it.hasNext())
    	{
    		Package pack = (Package)it.next();
    		LOC += pack.getLinesOfCode();
    	}
    	return LOC;
    }
    public int getLinesOfComments() {
    	int LOC = 0;
    	Iterator it;
    	// -- Packages
    	it =  getPackages().iterator();
    	while(it.hasNext())
    	{
    		Package pack = (Package)it.next();
    		LOC += pack.getLinesOfComments();
    	}
    	return LOC;
    }


/*	public void setGlobalVariables(ModelElementList globalVariables) {
	    this.globalVariables.clear();
		Iterator it = globalVariables.iterator();
		while (it.hasNext()) {
			GlobalVariable gv = (GlobalVariable)it.next();
			addGlobalVariable(gv);
		}
	}*/

	public ModelElementList getGlobalVariables() {
		return globalVariables;
	}

    // only caching
	public void addGlobalVariable(GlobalVariable gv) {
		globalVariables.addUnique(gv);
		gv.setRoot(this);
	}

/*	public void setGlobalFunctions(ModelElementList globalFunctions) {
		this.globalFunctions = globalFunctions;
		Iterator it = this.globalFunctions.iterator();
		while (it.hasNext()) {
			GlobalFunction gf = (GlobalFunction)it.next();
			gf.setRoot(this);
		}
	}*/

	public ModelElementList getGlobalFunctions() {
		return globalFunctions;
	}

	public void addGlobalFunction(GlobalFunction gf) {
		globalFunctions.addUnique(gf);
		gf.setRoot(this);
	}

/*	public void setFiles(ModelElementList files) {
		this.files = files;
		Iterator it = this.files.iterator();
		while (it.hasNext()) {
			File file = (File)it.next();
			file.setRoot(this);
		}
	}*/

	public ModelElementList getFiles() {
		return files;
	}

	public void addFile(File f) {
		files.addUnique(f);
		f.setRoot(this);
	}

/*	public void setPackages(ModelElementList newPackages) {
		packages.clear();
	    Iterator it = newPackages.iterator();
		while (it.hasNext()) {
			Package pack = (Package)it.next();
			addPackage(pack);
		}
	}*/
	
	public ModelElementList getPackages() {
		return packages;
	}

	/**
	 * This function adds a package and all its types, global variables, global functions and
	 * subpackages to the root node. 
	 * @param pack the package to be added
	 */
	public void addPackage(Package pack) {
        cachedClassList = null;
        
		packages.addUnique(pack);
		pack.setRoot(this);
		Iterator it = pack.getClasses().iterator();
		while (it.hasNext()) 
		    addType((Class)it.next());
		
		it = pack.getDelegates().iterator();
		while (it.hasNext()) 
		    addType((Delegate)it.next());
		
		it = pack.getTypeAliases().iterator();
		while (it.hasNext()) 
		    addType((TypeAlias)it.next());
		
		it = pack.getGlobalFunctions().iterator();
		while (it.hasNext())
		    addGlobalFunction((GlobalFunction)it.next());
		
		it = pack.getGlobalVariables().iterator();
		while (it.hasNext())
		    addGlobalVariable((GlobalVariable)it.next());
		
		it = pack.getSubPackages().iterator();
		while (it.hasNext())
		    addPackage((Package)it.next());
	}

/*	public void setTypes(ModelElementList primitiveTypes) {
		this.types = primitiveTypes;
		Iterator it = this.types.iterator();
		while (it.hasNext()) {
			TypeImplementation pt = (TypeImplementation)it.next();
			pt.setRoot(this);
		}
	}*/

	public ModelElementList getTypes() {
		return types;
	}
	
	public void addType(Type type) {
        cachedClassList = null;
        
		types.addUnique(type);
		type.setRoot(this);
	}

	/*public void setClones(ModelElementList clones) {
	    this.clones.clear();
		Iterator it = clones.iterator();
		while (it.hasNext()) {
			Clone clone = (Clone)it.next();
			addClone(clone);
		}
	}*/

	public ModelElementList getClones() {
		return clones;
	}

	public void addClone(Clone clone) {
		clones.addUnique(clone);
		clone.setRoot(this);
	}

	/*public void setStructuralAbstractions(ModelElementList abstractions) {
	    this.abstractions.clear();
		Iterator it = abstractions.iterator();
		while (it.hasNext()) {
			StructuralAbstraction abs = (StructuralAbstraction)it.next();
			addStructuralAbstraction(abs);
		}
	}*/

	public ModelElementList getStructuralAbstractions() {
		return abstractions;
	}

	public void addStructuralAbstraction(StructuralAbstraction abs) {
		abstractions.addUnique(abs);
		abs.setRoot(this);
	}

	public Package getPackageByName(String name) {
		Iterator it = this.packages.iterator();
		while (it.hasNext()) {
			Package pack = (Package)it.next();
			if (pack.getSimpleName().equals(name))
				return pack;
		}
		return null;
	}
    
    public Package getPackageByQualifiedName(String name) {
        Iterator it = this.packages.iterator();
        while (it.hasNext()) {
            Package pack = (Package)it.next();
            if (pack.getQualifiedName().equals(name))
                return pack;
        }
        return null;
    }    
	
	public boolean existsPackage(String name) {
		if (getPackageByName(name) != null)
			return true;
		return false;
	}

	public ModelElementList getClasses() {
		if (cachedClassList == null) {
			cachedClassList = new ModelElementList();
			Iterator it = packages.iterator();
			while (it.hasNext()) {
				Package pack = (Package)it.next();
				cachedClassList.addAll(pack.getClasses());
			}
		}
		return cachedClassList;
	}

    public Class getClassByQualifiedName(String qualifiedName) {
    	try {
	    	Package pack = getPackageByQualifiedName(qualifiedName.substring(0, qualifiedName.lastIndexOf('.')));
    		if (pack != null)
    			return pack.getClassByName(qualifiedName.substring(qualifiedName.lastIndexOf('.') + 1));
		} catch (IndexOutOfBoundsException e) {
		}
    	return null;	
    }
    
    public boolean existsClass(String qualifiedName) {
    	if (getClassByQualifiedName(qualifiedName) != null)
    		return true;
    	return false;
    }
    
	void clearCache() {
		cachedClassList = null;
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		abstractions.destroy();
		if (cachedClassList != null)
		    cachedClassList.destroy();
		clones.destroy();
		files.destroy();
		globalFunctions.destroy();
		globalVariables.destroy();
		packages.destroy();
		types.destroy();

		abstractions = null;
		cachedClassList = null;
		clones = null;
		files = null;
		globalFunctions = null;
		globalVariables = null;
		packages = null;
		types = null;

		repository = null;
}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitRoot(this);
	}
	
	public ModelElement getParent() {
		return null;
	}

	public void removeFile(File file) {
		if (!files.contains(file))
		    return;
	    files.remove(file);
	    ModelElementRepository.getWorkingRepository().removeElement(file);
		Iterator it = files.iterator();
		while (it.hasNext())
		    ((File)it.next()).removeIncludedFile(file);
		types.removeAll(file.getTypes());
		globalFunctions.removeAll(file.getGlobalFunctions());
		globalVariables.removeAll(file.getGlobalVariables());
	    ModelElementRepository.getWorkingRepository().removeElement(file);
		file.destroy();
	}

	public void removePackage(Package pack) {
	    if (!packages.contains(pack))
	        return;
	    packages.remove(pack);
	    ModelElementRepository.getWorkingRepository().removeElement(pack);

	    
	    if (pack.getSurroundingPackage() != null)
	        pack.getSurroundingPackage().removeSubPackage(pack);

	    Iterator it = pack.getClasses().iterator();
		while (it.hasNext())
		    removeType((Type)it.next());

		it = pack.getDelegates().iterator();
		while (it.hasNext())
		    removeType((Type)it.next());

		it = pack.getTypeAliases().iterator();
		while (it.hasNext())
		    removeType((Type)it.next());

		it = pack.getGlobalFunctions().iterator();
		while (it.hasNext())
		    removeGlobalFunction((GlobalFunction)it.next());

		it = pack.getGlobalVariables().iterator();
		while (it.hasNext())
		    removeGlobalVariable((GlobalVariable)it.next());

		Iterator itr = pack.getSubPackages().iterator();
		while (itr.hasNext()) {
		    Package p = (Package) itr.next();
		    removePackage(p);
		}
	    ModelElementRepository.getWorkingRepository().removeElement(pack);
	    pack.destroy();
	}

	public void removeGlobalFunction(GlobalFunction func) {
	    if (!globalFunctions.contains(func))
	        return;
	    globalFunctions.remove(func);
	    ModelElementRepository.getWorkingRepository().removeElement(func);
	    Iterator it = files.iterator();
	    while (it.hasNext()) 
	        ((File)it.next()).removeImportedGlobalFunction(func);
	    
	    if (func.getSurroundingPackage() != null) 
	        func.getSurroundingPackage().removeGlobalFunction(func);
	    
	    it = func.referencingAccesses().iterator();
	    while (it.hasNext()) 
	        ((Access)it.next()).getSurroundingStatement().removeAccess((Access)it.next());
	    ModelElementRepository.getWorkingRepository().removeElement(func);
	    func.destroy();
	}
	
	public void removeGlobalVariable(GlobalVariable var) {
	    if (!globalVariables.contains(var))
	        return;
	    globalVariables.remove(var);
	    ModelElementRepository.getWorkingRepository().removeElement(var);

	    Iterator it = files.iterator();
	    while (it.hasNext())
	        ((File)it.next()).removeImportedGlobalVariable(var);
	    
	    if (var.getSurroundingPackage() != null)
	        var.getSurroundingPackage().removeGlobalVariable(var);
	    
	    it = var.referencingAccesses().iterator();
	    while (it.hasNext())
	        ((Access)it.next()).getSurroundingStatement().removeAccess((Access)it.next());

	    ModelElementRepository.getWorkingRepository().removeElement(var);
	    
	    var.destroy();
	}
	
	public void removeType(Type type) {
	    if (!types.contains(type))
	        return;
	    types.remove(type);
	    ModelElementRepository.getWorkingRepository().removeElement(type);
	    Iterator it = files.iterator();
	    while (it.hasNext())
	        ((File)it.next()).removeImportedType(type);
	    
	    if (type instanceof Class) {
	        Class cls = (Class)type;
	        if (cls.getSurroundingClass() != null) {
	            cls.getSurroundingClass().removeFriendClass(cls);
	            cls.getSurroundingClass().removeInnerClass(cls);
	        }
	        if (cls.getSurroundingPackage() != null) {
	            cls.getSurroundingPackage().removeClass(cls);
	        }
	        if (cls.getSurroundingFunction() != null) {
	            cls.getSurroundingFunction().removeLocalClass(cls);
	        }
	       
	    }
	        
	    if (type.getSurroundingPackage() != null) {
	        if (type instanceof TypeAlias)
	            type.getSurroundingPackage().removeTypeAlias((TypeAlias)type);
	        if (type instanceof Delegate)
	            type.getSurroundingPackage().removeDelegate((Delegate)type);
	    }
	    
	    it = type.referencingAccesses().iterator();
	    while (it.hasNext()) {
            Access ac = (Access) it.next();
            AccessContainer acc = ac.getSurroundingContainer();
            if (acc != null)
                acc.removeContainedAccess(ac);
        }	    
	    
	    ModelElementRepository.getWorkingRepository().removeElement(type);
	}

	public void removeStructuralAbstraction(StructuralAbstraction abs) {
		if (!abstractions.contains(abs))
			return;
		abstractions.remove(abs);
		ModelElementRepository.getWorkingRepository().removeElement(abs);
		abs.destroy();
	}
	
	/**
	 * removes the given type from the list of types. No further action is being taken.
	 * For internal use only.
	 * @param type
	 */
	public void simpleRemoveType(Type type) {
	    types.remove(type);
	}

	Type findType(String qualifiedName) {
	    Iterator itor = types.iterator();
	    while (itor.hasNext()) {
	        Type type = (Type)itor.next();
	        if (type.getQualifiedName() == qualifiedName)
	            return type;
	    }
	    return null;
	}
	
	public ModelElementList getFunctions()
	{
		ModelElementList functions = new ModelElementList();
		functions.addAll(globalFunctions);
		ModelElementList classes = getClasses();

		Iterator it = classes.iterator();
		while(it.hasNext())
		{
			Class clas = (Class)it.next();
			functions.addAll(clas.getMethods());
			functions.addAll(clas.getConstructors());
			functions.addAll(clas.getDestructors());
		}
		return functions;
	}
}
