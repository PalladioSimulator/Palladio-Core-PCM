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
import java.util.List;

import de.fzi.sissy.util.Debug;

/**
 * @author Mircea Trifu
 *
 */
public class File extends ModelElementImplementation implements ModelElement {
	private Root root;
	private String pathName;
	private ModelElementList includedFiles;
	private ModelElementList importedPackages;
	private ModelElementList importedTypes;
	private ModelElementList importedGlobalVariables;
	private ModelElementList importedGlobalFunctions;
	private int linesOfCode;
	private boolean pSource;


	public File(String name) {
		setPathName(name);
		includedFiles = new ModelElementList();
		importedPackages = new ModelElementList();
		importedTypes = new ModelElementList();
		importedGlobalVariables = new ModelElementList();
		importedGlobalFunctions = new ModelElementList();
		pSource = true;
	}
	
	/**
	 * Do not call this method directly. Use Root.addFile instead.
	 * @param root - the Root node
	 */
	void setRoot(Root root) {
		this.root = root;
	}

	public Root getRoot() {
		return root;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
		if (isLibraryFile())
			setLibrary();
		else
			setNormal();
	}

	public String getPathName() {
		return pathName;
	}

	public String getSystemPathName() {
		int idx = pathName.indexOf(":");
		if(idx>1)
		{
			return pathName.substring(idx+1);
		}
		return pathName;
	}

	public void setIncludedFiles(ModelElementList includedFiles) {
		this.includedFiles = includedFiles;
	}

	public ModelElementList getIncludedFiles() {
		return includedFiles;
	}
	
	public void addIncludedFile(File f) {
		includedFiles.add(f);
	}

	public void setImportedPackages(ModelElementList importedPackages) {
		this.importedPackages = importedPackages;
	}

	public ModelElementList getImportedPackages() {
		return importedPackages;
	}
	
	public void addImportedPackage(Package pack) {
		importedPackages.add(pack);
	}

	public void setImportedTypes(ModelElementList importedTypes) {
		this.importedTypes = importedTypes;
	}

	public ModelElementList getImportedTypes() {
		return importedTypes;
	}
	
	public void addImportedType(Type type) {
		importedTypes.add(type);
	}

	public void setImportedGlobalVariables(ModelElementList importedGlobalVariables) {
		this.importedGlobalVariables = importedGlobalVariables;
	}

	public ModelElementList getImportedGlobalVariables() {
		return importedGlobalVariables;
	}
	
	public void addImportedGlobalVariable(GlobalVariable gv) {
		importedGlobalVariables.add(gv);
	}

	public void setImportedGlobalFunctions(ModelElementList importedGlobalFunctions) {
		this.importedGlobalFunctions = importedGlobalFunctions;
	}

	public ModelElementList getImportedGlobalFunctions() {
		return importedGlobalFunctions;
	}
	
	public void addImportedGlobalFunction(GlobalFunction gf) {
		importedGlobalFunctions.add(gf);
	}

	public ModelElementList getGlobalVariables() {

		ModelElementList ergebnis = new ModelElementList();
		ModelElementList suchliste = this.root.getGlobalVariables();
		Iterator it = suchliste.iterator();
		
		while(it.hasNext()) {
			SourceEntity se = (SourceEntity) it.next();		
			if (se.getPosition().getSourceFile()==this) 
				ergebnis.addUnique(se);
		}
		
		return ergebnis;
	}
	
	public ModelElementList getGlobalFunctions() { 
		
		ModelElementList ergebnis = new ModelElementList();
		if (root == null)
		    return ergebnis;
		ModelElementList suchliste = this.root.getGlobalFunctions();
		Iterator it = suchliste.iterator();
		
		while(it.hasNext()) {
			SourceEntity se = (SourceEntity) it.next();		
			if (se.getPosition().getSourceFile()==this) 
				ergebnis.addUnique(se);
		}
		
		return ergebnis;

	}
	
	public ModelElementList getTypes() {
		ModelElementList ergebnis = new ModelElementList();
		if (root == null)
		    return ergebnis;
		ModelElementList suchliste = this.root.getTypes();
		Iterator it = suchliste.iterator();
		SourceEntity se = null;
		
		while(it.hasNext()) {
			Type typ = (Type) it.next();
			if (typ instanceof SourceEntity) {
				se = (SourceEntity) typ;
				if (se.getPosition() != null) {
					if (se.getPosition().getSourceFile() == this)
						ergebnis.addUnique(typ);
				}
			}
		}
		
		return ergebnis;
	}

	public void setSourceFile() {
		this.pSource = true;
		if (isLibraryFile())
			setLibrary();
		else
			setNormal();
	}
	
	public void setAssembly() {
		this.pSource = false;
		setLibrary();
	}
	
	public boolean isSourceFile() {
		return this.pSource;
	}
	
	public boolean isAssembly() {
		return !this.pSource;
	}

	/**
	 * @param linesOfCode The linesOfCode to set.
	 */
	public void setLinesOfCode(int linesOfCode) {
		this.linesOfCode = linesOfCode;
	}

	/**
	 * @return Returns the linesOfCode.
	 */
	public int getLinesOfCode() {
		return linesOfCode;
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		includedFiles.destroy();
		importedPackages.destroy();
		importedTypes.destroy();
		importedGlobalVariables.destroy();
		importedGlobalFunctions.destroy();
		root = null;
		pathName = null;
		includedFiles = null;
		importedPackages = null;
		importedTypes = null;
		importedGlobalVariables = null;
		importedGlobalFunctions = null;
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitFile(this);
	}
	
	public ModelElement getParent() {
		return getRoot();
	}
	
	public void changePathName(String pathname) {
		setPathName(pathname);
	}
	
	public void removeIncludedFile(File file) {
		includedFiles.remove(file);
	}

	public void removeImportedPackage(Package pack) {
		importedPackages.remove(pack);
	}

	public void removeImportedGlobalFunction(GlobalFunction gf) {
	    importedGlobalFunctions.remove(gf);
	}

	public void removeImportedGlobalVariable(GlobalVariable gv) {
		importedGlobalVariables.remove(gv);
	}

	public void removeImportedType(Type type) {
		importedTypes.remove(type);
	}

	public void addGlobalFunction(GlobalFunction gf) {
	    if (isSourceFile())
	        gf.getPosition().setSourceFile(this);
	    else
	        gf.getPosition().setAssembly(this);
	    root.addGlobalFunction(gf);
	}

	public void removeGlobalFunction(GlobalFunction gf) {
		root.removeGlobalFunction(gf);
	}

	public void addGlobalVariable(GlobalVariable gv) {
	    if (isSourceFile())
	        gv.getPosition().setSourceFile(this);
	    else
	        gv.getPosition().setAssembly(this);
		root.addGlobalVariable(gv);
	}

	public void removeGlobalVariable(GlobalVariable gv) {
		root.removeGlobalVariable(gv);
	}

	public void addType(Type type) {
	    SourceEntity t;
	    if (type instanceof SourceEntity) {
	        t = (SourceEntity) type;
		    if (isSourceFile())
		        t.getPosition().setSourceFile(this);
		    else
		        t.getPosition().setAssembly(this);
	    }
	    root.addType(type);   
	}

	public void removeType(Type type) {
		root.removeType(type);
	}
    
    public String toString() {
        return getClass().getName() + ":" + getPathName();
    }
    
    private boolean isLibraryFile() {
        String pos_pathname = getPathName();                
        
        if (pos_pathname != null) {
        
	        if (pos_pathname.indexOf("ARCHIVE:") == 0) {
	            pos_pathname = pos_pathname.substring(8);
	            return true;
	        }
	
	        if (pos_pathname.indexOf("FILE:")==0) {
	            pos_pathname = pos_pathname.substring(5);
	        }
	
	        List files = ModelElementRepository.getWorkingRepository().getFileList();
	        
	        if (files.contains(pos_pathname)) {
	        	return false;
	        }
        }
        
        return true;
    }
}
