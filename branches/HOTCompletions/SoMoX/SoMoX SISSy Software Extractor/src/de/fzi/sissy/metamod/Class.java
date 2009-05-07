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
public class Class extends TypeImplementation implements Member, AccessContainer {
	private boolean pAnonymous, pInterface, pPrimitive;
	private Package surroundingPackage;
	private Function surroundingFunction;
    private ModelElementList inheritanceTypeAccesses;
    private ModelElementList directDescendants;
    private transient ModelElementList cachedDirectSuperClasses;
    private ModelElementList innerClasses;
	private ModelElementList innerDelegates;
	private ModelElementList innerTypeAliases;
    private ModelElementList fields;
    private ModelElementList properties;
    private ModelElementList constructors;
	private ModelElementList destructors;
    private ModelElementList methods;
/*    private Constructor defaultConstructor;*/
    private Field self;
	private ModelElementList friendClasses;
	private ModelElementList friendFunctions;
	
	private ModelElementList allAncestorCache;
	
	private int linesOfComments;

	public Class(String name) {
		this(name, true);
	}
		
	public Class(String name, boolean createSelf) {
		super(name);
		if (name == null)
			pAnonymous = true;
		else
			if (name.length() == 0)
				pAnonymous = true;
		if (createSelf) {
			setSelf(new Field("<self>"));
			DeclarationTypeAccess dta = new DeclarationTypeAccess(this);
			dta.setPosition(new Position(null, -1, -1, -1, -1));
            dta.setImplicit();
			self.setTypeDeclaration(dta);
		}
		inheritanceTypeAccesses = new ModelElementList();
		directDescendants = new ModelElementList();
		innerClasses = new ModelElementList();
		innerDelegates = new ModelElementList();
		fields = new ModelElementList();
		properties = new ModelElementList();
		constructors = new ModelElementList();
		destructors = new ModelElementList();
		methods = new ModelElementList();
		innerTypeAliases = new ModelElementList();
		friendClasses = new ModelElementList();
		friendFunctions = new ModelElementList();

		allAncestorCache = new ModelElementList();
		
	}
	
	/**
	 * Do not call this method directly. Use Package.addClass instead.
	 */
	public void setSurroundingPackage(Package surroundingPackage) {
		this.surroundingPackage = surroundingPackage;
	}

	public Package getSurroundingPackage() {
		return surroundingPackage;
	}

	public void setInheritanceTypeAccesses(ModelElementList inheritanceTypeAccesses) {
		this.inheritanceTypeAccesses = inheritanceTypeAccesses;
		Iterator it = this.inheritanceTypeAccesses.iterator();
		while (it.hasNext()) {
			InheritanceTypeAccess ita = (InheritanceTypeAccess)it.next();
			ita.setSurroundingAccessContainer(this);
			Class cls = ita.getAccessedSuperClass();
			cls.addDirectDescendant(this);		
		}	
	} 

	public ModelElementList getInheritanceTypeAccesses() {
		return inheritanceTypeAccesses;
	}
	
	public void addInheritanceTypeAccess(InheritanceTypeAccess ita) {
		inheritanceTypeAccesses.addUnique(ita);
		ita.setSurroundingAccessContainer(this);
		ita.getAccessedSuperClass().addDirectDescendant(this);
	}
	
	public ModelElementList getDirectSuperClasses() {
		if (cachedDirectSuperClasses == null) {
			cachedDirectSuperClasses = new ModelElementList();
			Iterator it = inheritanceTypeAccesses.iterator();
			while (it.hasNext()) {
				InheritanceTypeAccess ita = (InheritanceTypeAccess)it.next();
				cachedDirectSuperClasses.addUnique(ita.getAccessedSuperClass());
			}
		}
		return cachedDirectSuperClasses;
	}
	
	public ModelElementList getDirectDescendants() {
		return directDescendants;
	}
	
	/**
	 * Do not call this method directly. Use Class.addDirectSuperClass instead.
	 */
	public void addDirectDescendant(Class cls) {
		directDescendants.addUnique(cls);	
	}
	
	/**
	 * Removes the direct descendant from the list of direct descendants.
	 * For internal use only.
	 * @param cls - the descendant to be removed.
	 */
	public void removeDirectDescendant(Class cls) {
	    directDescendants.remove(cls);
	}
	
	public void clearCache() {
		cachedDirectSuperClasses = null;
	}	

	public void setInnerClasses(ModelElementList innerClasses) {
		this.innerClasses.clear();
		Iterator it = innerClasses.iterator();
		while (it.hasNext()) {
			Class cls = (Class)it.next();
			addInnerClass(cls);
		}	
	}

	public ModelElementList getInnerClasses() {
		return innerClasses;
	}
	
	public void addInnerClass(Class cls) {
		if (cls == this)
		    return;
	    innerClasses.addUnique(cls);
	    getRoot().addType(cls);
		cls.setSurroundingClass(this);
		cls.setSurroundingPackage(this.surroundingPackage);
		if (surroundingPackage != null)
			surroundingPackage.simpleAddClass(cls);
	}

	public void setFriendClasses(ModelElementList friendClasses) {
		this.friendClasses.clear();
		this.friendClasses.addAll(friendClasses);
	}
	
	public ModelElementList getFriendClasses() {
		return friendClasses;
	}
	
	public void addFriendClass(Class friendClass) {
		friendClasses.addUnique(friendClass);
	}

	public void setFriendFunctions(ModelElementList friendFunctions) {
		this.friendFunctions.clear();
		this.friendFunctions.addAll(friendFunctions);
	}

	public ModelElementList getFriendFunctions() {
		return friendFunctions;
	}
	
	public void addFriendFunction(Function friendFunction) {
		friendFunctions.addUnique(friendFunction);
	}

	public void setFields(ModelElementList fields) {
		this.fields = fields;
		Iterator it = this.fields.iterator();
		while (it.hasNext()) {
			Field fld = (Field)it.next();
			fld.setSurroundingClass(this);
		}	
	}
	
	public ModelElementList getFields() {
		return fields;
	}
	
	public void addField(Field fld) {
		fields.addUnique(fld);
		fld.setSurroundingClass(this);
	}

/*	public void setProperties(ModelElementList properties) {
		properties.clear();
		Iterator it = properties.iterator();
		while (it.hasNext()) {
			Property prop = (Property)it.next();
			prop.setSurroundingClass(this);
		}	
	}*/

	public ModelElementList getProperties() {
		return properties;
	}
	
	public void addProperty(Property prop) {
		properties.addUnique(prop);
		if (prop.getGetter() != null)
		    addMethod(prop.getGetter());
		if (prop.getSetter() != null)
		    addMethod(prop.getSetter());
		prop.setSurroundingClass(this);
	}

	public void setConstructors(ModelElementList constructors) {
		this.constructors = constructors;
		Iterator it = this.constructors.iterator();
		while (it.hasNext()) {
			Constructor c = (Constructor)it.next();
			c.setSurroundingClass(this);
		}	
	}

	public ModelElementList getConstructors() {
		return constructors;
	}
	
	public void addConstructor(Constructor c) {
		constructors.addUnique(c);
		c.setSurroundingClass(this);
	}

	public void setDestructors(ModelElementList destructors) {
		this.destructors = destructors;
		Iterator it = this.destructors.iterator();
		while (it.hasNext()) {
			Destructor d = (Destructor)it.next();
			d.setSurroundingClass(this);
		}	
	}

	public ModelElementList getDestructors() {
		return destructors;
	}
	
	public void addDestructor(Destructor d) {
		destructors.addUnique(d);
		d.setSurroundingClass(this);
	}

	public void setMethods(ModelElementList methods) {
		this.methods = methods;
		Iterator it = this.methods.iterator();
		while (it.hasNext()) {
			Method m = (Method)it.next();
			m.setSurroundingClass(this);
		}	
	}

	public ModelElementList getMethods() {
		return methods;
	}
	
	public void addMethod(Method m) {
		methods.addUnique(m);
		m.setSurroundingClass(this);
	}

	public void setInnerTypeAliases(ModelElementList typeAliases) {
		this.innerTypeAliases = typeAliases;
		Iterator it = this.innerTypeAliases.iterator();
		while (it.hasNext()) {
			TypeAlias ta = (TypeAlias)it.next();
			ta.setSurroundingClass(this);
		}	
	}

	public ModelElementList getInnerTypeAliases() {
		return innerTypeAliases;
	}
	
	public void addInnerTypeAlias(TypeAlias ta) {
		innerTypeAliases.addUnique(ta);
		ta.setSurroundingClass(this);
		getSurroundingPackage().addTypeAlias(ta);
	}

	/**
	 * Do not call this method directly. Use Function.addLocalClasss instead.
	 */
	public void setSurroundingFunction(Function surroundingFunction) {
		this.surroundingFunction = surroundingFunction;
	}

	public Function getSurroundingFunction() {
		return surroundingFunction;
	}

    public boolean isInnerClass() {
		return ((getSurroundingClass() != null) && (getSurroundingFunction() == null));   	
    }

    public boolean isLocalClass() {
		return (getSurroundingFunction() != null);
    }

	public void setSimpleName(String simpleName) {
		super.setSimpleName(simpleName);
		if (simpleName.length() == 0)
			pAnonymous = true;
	}

    public boolean isAnonymousClass() {
    	return pAnonymous;
    }

	public void setInterface() {
		pInterface = true;
	}

	public void toggleInterface() {
		pInterface = !pInterface;
	}

	public boolean isInterface() {
		return pInterface;
	}
    
    public String getQualifiedName() {
		String prefix = "";
		String sep = "";
		Class cls = getSurroundingClass();
		Function f = getSurroundingFunction();
		
		if (cls != null) {
			prefix = cls.getQualifiedName();
			sep = "$";
		}
		else if (getSurroundingPackage() != null) {
			prefix = getSurroundingPackage().getQualifiedName();
			sep = ".";
		}
		if (f != null) {
			prefix = prefix + "." + f.getSimpleName();
			sep = "$";
			return prefix + sep + f.getLocalClasses().indexOf(this);
		}
		else
			return prefix + sep + getSimpleName();
    }

	public ModelElementList getSuperTypes() {
		ModelElementList ergebnis = new ModelElementList();
		Iterator it = this.inheritanceTypeAccesses.iterator();
		
		while(it.hasNext()) {
			InheritanceTypeAccess ita = (InheritanceTypeAccess) it.next();
			if (ita.isInterfaceInheritance()) 
				ergebnis.addUnique(ita.getAccessedSuperClass());
		}
		
		return ergebnis;    	
	}

	public ModelElementList getAncestors() {
		/*
		ModelElementList ergebnis = new ModelElementList();
		Iterator it = this.inheritanceTypeAccesses.iterator();
		
		while(it.hasNext()) {
			InheritanceTypeAccess ita = (InheritanceTypeAccess) it.next();
			ergebnis.addUnique(ita.getAccessedSuperClass());
		}
		
		return ergebnis;
		*/
		return this.getDirectSuperClasses();
	}

	public boolean extendsClass(String qualifiedName) {
		Iterator n_itr = this.getAllAncestors(true).iterator();
		
		while(n_itr.hasNext()) {
			Class ancestorOfThisClass = (Class) n_itr.next();
			if (ancestorOfThisClass.getQualifiedName().equals(qualifiedName)) 
				return true;
		}
		
		return false;
	}

	public boolean extendsClass(Class c) {
		Iterator n_itr = this.getAllAncestors(true).iterator();
		
		while(n_itr.hasNext()) {
			Class ancestorOfThisClass = (Class) n_itr.next();
			if (ancestorOfThisClass == c) 
				return true;
		}
		
		return false;
	}

	
	public ModelElementList getAllDescendants() {
		
		ModelElementList ergebnis = new ModelElementList();
		
		ModelElementList desc = this.getDirectDescendants();
		
		ergebnis.addAll(desc);
		
		ModelElementList neudesc = null;
		do {
			neudesc = new ModelElementList();
			for (int i=0; i < desc.size(); i++) {
				Class descClass = (Class)desc.get(i);
				neudesc.addAll(descClass.getDirectDescendants());
			}
			ergebnis.addAll(neudesc);
			desc = new ModelElementList();
			desc.addAll(neudesc);
		} while(neudesc.size()>0);
	
		return ergebnis;
	}
	
	
	
	
	public ModelElementList getAllAncestors(boolean recalculate) {
		// use cache:
		if (!recalculate) {
			if (!allAncestorCache.isEmpty()) {
				//Debug.info("Use allAncestorCache");
				return allAncestorCache;
			}
		}
		
		ModelElementList ergebnis = new ModelElementList();
		
		ergebnis.addAll(this.getAncestors());
		
		if (ergebnis.isEmpty()) {
			allAncestorCache = ergebnis;
			return ergebnis;
		}
		
		ModelElementList pruefmenge = new ModelElementList();
		pruefmenge.addAll(ergebnis); 
		
		boolean change;
		do {
			change = false;
			
			Iterator itr2 = pruefmenge.iterator();
			ModelElementList neuErgebnis = new ModelElementList();
			while(itr2.hasNext()) {
				Class ancestorClass = (Class)itr2.next();
				Iterator itr3 = ancestorClass.getAncestors().iterator();
				while(itr3.hasNext()) {
					ModelElement ancestor = (ModelElement)itr3.next();
					if (ancestor instanceof Class) {
						if (!ergebnis.contains(ancestor)) {
							neuErgebnis.addUnique(ancestor);
							ergebnis.addUnique(ancestor);
							change = true;
						}
					}
				}
			}
			pruefmenge = new ModelElementList();
			pruefmenge.addAll(neuErgebnis);
			neuErgebnis.clear();
		} while(change);
		
		allAncestorCache = ergebnis;
		return ergebnis;    	
	}

	public ModelElementList getAllSuperTypes() {
		ModelElementList ergebnis = new ModelElementList();
		
		Iterator itr = this.getSuperTypes().iterator();
		while(itr.hasNext()) {
			ModelElement supertype = (ModelElement)itr.next();
			if (supertype instanceof Class) {
				//Debug.info("supertype: "+((Class)supertype).getSimpleName());
				ergebnis.addUnique(supertype);
			}
		}
		
		boolean change;
		do {
			change = false;
			Iterator itr2 = ergebnis.iterator();
			ModelElementList neuErgebnis = new ModelElementList();
			while(itr2.hasNext()) {
				Class supertypeClass = (Class)itr2.next();
				Iterator itr3 = supertypeClass.getSuperTypes().iterator();
				while(itr3.hasNext()) {
					ModelElement supertype = (ModelElement)itr3.next();
					if (supertype instanceof Class) {
						if (!ergebnis.contains(supertype)) {
							neuErgebnis.addUnique(supertype);
							change = true;
						}
					}
				}
			}
			ergebnis.addAll(neuErgebnis);
			neuErgebnis.clear();
		} while(change);
		
		return ergebnis;    	
	}
	
	public boolean isSubTypeOf(Class cls)
	{
		ModelElementList list = getAllSuperTypes();
		return list.contains(cls);
	}
	
    public boolean existsMethod(Signature signature) {
		Iterator itr = this.methods.iterator();
		
		while(itr.hasNext()) {
			Method method = (Method) itr.next();
			if (method.signature().equals(signature))
				return true;
		}
		
		return false;    	
    }

    public boolean inheritsMethod(Signature signature) {
		ModelElementList ancestors = this.getAncestors();
		
		Iterator itr = ancestors.iterator();
		
		while(itr.hasNext()) {
			Class ancestor = (Class) itr.next();
			if (ancestor.existsMethod(signature))
				return true;
			else if (ancestor.inheritsMethod(signature))
				return true;
		}

		return false;    	
    }

    public boolean existsConstructor(Signature signature) {
		Iterator itr = this.constructors.iterator();
		
		while(itr.hasNext()) {
			Constructor constructor = (Constructor) itr.next();
			if (constructor.signature().equals(signature))
				return true;
		}


		return false;    	
    }

    public boolean existsField(String name) {
		Iterator itr = this.fields.iterator();
		
		while(itr.hasNext()) {
			Field field = (Field) itr.next();
			if (field.getSimpleName().equals(name))
				return true;
		}
		
		return false;    	
    }

    public boolean inheritsField(String name) {
		ModelElementList ancestors = this.getAncestors();
		
		Iterator itr = ancestors.iterator();
		
		while(itr.hasNext()) {
			Class ancestor = (Class) itr.next();
			if (ancestor.existsField(name))
				return true;
			else if (ancestor.inheritsField(name))
				return true;
		}

		return false;    	
    }

    public int getLinesOfCode() {
		return getPosition().getEndLine()-getPosition().getStartLine() + 1;
    }

    /**
     * Get total lines of code including function bodies in other files
     * @return total LOC
     */
    public int getTotalLinesOfCode() {
		int LOC = getLinesOfCode();
		Position pos = getPosition();
		ModelElementList functions = new ModelElementList();
		functions.addAll(getMethods());
		functions.addAll(getConstructors());
		functions.addAll(getDestructors());
		Iterator it = functions.iterator();
		while(it.hasNext())
		{
			Function func = (Function)it.next();
			if(!pos.contains(func.getPosition()))
			{
				LOC += func.getLinesOfCode();
			}
		}
    	return LOC;
    }

    /**
     * Get total lines of comment including function bodies in other files
     * @return total LOC
     */
    public int getTotalLinesOfComments() {
		int LOC = getLinesOfComments();
		Position pos = getPosition();
		ModelElementList functions = new ModelElementList();
		functions.addAll(getMethods());
		functions.addAll(getConstructors());
		functions.addAll(getDestructors());
		Iterator it = functions.iterator();
		while(it.hasNext())
		{
			Function func = (Function)it.next();
			if(!pos.contains(func.getPosition()))
			{
				LOC += func.getLinesOfComments();
			}
		}
    	return LOC;
    }

    public int getLinesOfComments() {
    	return linesOfComments;
    }
    
    public void setLinesOfComment(int value) {
        linesOfComments = value;
    }

	private MemberImplementation memberImplementation = new MemberImplementation();

	/**
	 * Do not call this method directly. Use Class.addInnerClasss instead.
	 */
	public void setSurroundingClass(Class surroundingClass) {
		memberImplementation.setSurroundingClass(surroundingClass);
	}

	public Class getSurroundingClass() {
		Function f = getSurroundingFunction();
		if ((f != null) && (f instanceof Member)) {
			return ((Member)f).getSurroundingClass();
		}
		return memberImplementation.getSurroundingClass();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#isPrivate()
	 */
	public boolean isPrivate() {
		return memberImplementation.isPrivate();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#isProtected()
	 */
	public boolean isProtected() {
		return memberImplementation.isProtected();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#isPackage()
	 */
	public boolean isPackage() {
		return memberImplementation.isPackage();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#isPublic()
	 */
	public boolean isPublic() {
		return memberImplementation.isPublic();
	}
	
	public boolean isIntrospectable() {
		return memberImplementation.isIntrospectable();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#isAbstract()
	 */
	public boolean isAbstract() {
		return memberImplementation.isAbstract();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#isFinal()
	 */
	public boolean isFinal() {
		return memberImplementation.isFinal();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#isStatic()
	 */
	public boolean isStatic() {
		return memberImplementation.isStatic();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#isVirtual()
	 */
	public boolean isVirtual() {
		return memberImplementation.isVirtual();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setPrivate()
	 */
	public void setPrivate() {
		memberImplementation.setPrivate();
	}

	public boolean isStrictProtected() {
		return memberImplementation.isStrictProtected();
	}

	public void setStrictProtected() {
		memberImplementation.setStrictProtected();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setProtected()
	 */
	public void setProtected() {
		memberImplementation.setProtected();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setPublic()
	 */
	public void setPublic() {
		memberImplementation.setPublic();
	}
	
	public void setIntrospectable(boolean i) {
		memberImplementation.setIntrospectable(i);
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setAbstract()
	 */
	public void setAbstract(boolean a) {
		memberImplementation.setAbstract(a);
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setFinal()
	 */
	public void setFinal(boolean a) {
		memberImplementation.setFinal(a);
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setStatic()
	 */
	public void setStatic(boolean a) {
		memberImplementation.setStatic(a);
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setVirtual()
	 */
	public void setVirtual(boolean a) {
		memberImplementation.setVirtual(a);
	}

	public boolean isTypeParameterMember() {
		return memberImplementation.isTypeParameterMember();
	}

	public boolean isPrimitive() {
		return pPrimitive;
	}

	public void setPrimitive() {
		pPrimitive = true;
	}
	
	public void setSelf(Field fld) {
        if (fld != null) {
    		self = fld;
            self.setImplicit();
    		self.setSurroundingClass(this);
    		self.setPrivate();
    		self.setPosition(new Position(null, -1, -1, -1, -1));
        }
	}
	
	public Field getSelf() {
		return self;
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		inheritanceTypeAccesses.destroy();
		directDescendants.destroy();
		innerClasses.destroy();
		friendClasses.destroy();
		friendFunctions.destroy();
		fields.destroy();
		properties.destroy();
		constructors.destroy();
		destructors.destroy();
		methods.destroy();
		innerTypeAliases.destroy();
		setPosition(null);
		surroundingFunction = null;
		surroundingPackage = null;
		memberImplementation = null;
		innerTypeAliases = null;
		methods = null;
		constructors = null;
		destructors = null;
		properties = null;
		fields = null;
		friendClasses = null;
		friendFunctions = null;
		inheritanceTypeAccesses = null;
		directDescendants = null;
		innerClasses = null;
		
		allAncestorCache.destroy();
		allAncestorCache = null;
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitClass(this);
	}
	
	public ModelElement getParent() {
		if (isLocalClass())
			return getSurroundingFunction();
		else if (isInnerClass())
			return getSurroundingClass();
		else if (isPrimitive())
			return getRoot();
		return getSurroundingPackage();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#isInternal()
	 */
	public boolean isInternal() {
		return memberImplementation.isInternal();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#isExtern()
	 */
	public boolean isExtern() {
		return memberImplementation.isExtern();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#isNew()
	 */
	public boolean isNew() {
		return memberImplementation.isNew();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#isOverride()
	 */
	public boolean isOverride() {
		return memberImplementation.isOverride();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#getOverridenMember()
	 */
	public Member getOverridenMember() {
		return memberImplementation.getOverridenMember();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setOverridenMember()
	 */
	public void setOverridenMember(Member member) {
		memberImplementation.setOverridenMember(member);
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setInternal()
	 */
	public void setInternal(boolean a) {
		memberImplementation.setInternal(a);
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setExtern()
	 */
	public void setExtern(boolean a) {
		memberImplementation.setExtern(a);
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setNew()
	 */
	public void setNew() {
		memberImplementation.setNew();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setOverride()
	 */
	public void setOverride() {
		memberImplementation.setOverride();
	}

	public void setPackage() {
		memberImplementation.setPackage();
	}

	public ModelElementList getInnerDelegates() {
		return innerDelegates;
	}

	public void addInnerDelegate(Delegate dg) {
		innerDelegates.addUnique(dg);
		dg.setSurroundingClass(this);
		getRoot().addType(dg);
		getSurroundingPackage().addDelegate(dg);
	}

	public void setInnerDelegates(ModelElementList innerDelegates) {
		this.innerDelegates.clear();
		Iterator it = innerDelegates.iterator();
		while (it.hasNext()) {
			Delegate dg = (Delegate)it.next();
			addInnerDelegate(dg);
			dg.setSurroundingClass(this);
		}	
	}

	// delegation to the SourceEntityImplemenatation
	
	private SourceEntityImplementation sourceEntityImplementation = new SourceEntityImplementation();
	
	public void setPosition(Position pos) {
	    sourceEntityImplementation.setPosition(pos, this);
	}
	
	public Position getPosition() {
	    return sourceEntityImplementation.getPosition();
	}
	
	/**
	 * removes the inner class cls from the list of inner classes, without any
	 * further action being taken. For internal use only.
	 * @param cls - the class to be removed
	 */
	public void simpleRemoveInnerClass(Class cls) {
	    innerClasses.remove(cls);
	}
	
	/**
	 * Appends a given class to the list of inner classes without taking
	 * any further action. For internal use only.
	 * @param cls
	 */
	public void simpleAddInnerClass(Class cls) {
	    innerClasses.addUnique(cls);
	}
	
	public void moveToFile(File file) {
	    sourceEntityImplementation.moveToFile(file);
	}
	
	public void convertToInterface() {
	    if (isInterface())
	        return;
	    
	    setInterface();
	    
	    while (!constructors.isEmpty())
	        removeConstructor((Constructor)constructors.iterator().next());
	    
	    while (!destructors.isEmpty())
	        removeDestructor((Destructor)destructors.iterator().next());
	    
	    Iterator it = methods.iterator();
	    while (it.hasNext())
	        ((Function)it.next()).setBody(null);
	}

	public void convertToClass() {
		if (!isInterface())
		    return;
		
		setAbstract(true);
		pInterface = false;
	}

	public void moveToPackage(Package pack) {
		if (isInnerClass()) {
		    getSurroundingClass().simpleRemoveInnerClass(this);
		    setSurroundingClass(null);
		}
		if (isLocalClass()) {
		    getSurroundingFunction().simpleRemoveLocalClass(this);
		    setSurroundingFunction(null);
		}
		getSurroundingPackage().simpleRemoveClass(this);
		pack.simpleAddClass(this);
		setSurroundingPackage(pack);
	}

	public void moveToClass(Class cls) {
		if (isLocalClass()) {
		    getSurroundingFunction().simpleRemoveLocalClass(this);
		    setSurroundingFunction(null);
		}
		if (!isInnerClass()) {
		    getSurroundingPackage().simpleRemoveClass(this);
		    getRoot().simpleRemoveType(this);
		    setSurroundingPackage(null);
		} else {
		    getSurroundingClass().simpleRemoveInnerClass(this);
		}
		    cls.simpleAddInnerClass(this);
		    setSurroundingClass(cls);
	}

	public void moveToFunction(Function fc) {
	    if (!isLocalClass()) {
	        if (isInnerClass()) {
	            getSurroundingClass().simpleRemoveInnerClass(this);
	            setSurroundingClass(null);
	        } else {
	            getSurroundingPackage().simpleRemoveClass(this);
	            getRoot().simpleRemoveType(null);
	            setSurroundingPackage(null);
	        }
	        fc.simpleAddLocalClass(this);
	        setSurroundingFunction(fc);
	    }
	}

	private void rebuildMethodInheritanceData() {
	    ModelElementList otherMethods = new ModelElementList();
	    Iterator it = getAllSuperTypes().iterator();
	    while (it.hasNext()) 
	        otherMethods.addAll(((Class)it.next()).getMethods());
	    
	    it = methods.iterator();
	    boolean overriden = false;

	    while (it.hasNext()) {
	        Iterator it2 = otherMethods.iterator();
            Method m = (Method)it.next();
	        while (it2.hasNext()) {
	            Method m2 = (Method)it2.next();
	            if (m.hasIdenticalSignature(m2)) {
	                overriden = true;
	                m.setOverride();
	                m.setOverridenMember(m2);
	                otherMethods.remove(m2);
	                break;
	            }
	        }
            if (!overriden)
                m.setNew();
	    }
	}
	
	public void removeInheritanceTypeAccess(InheritanceTypeAccess ita) {
		if (!inheritanceTypeAccesses.contains(ita))
		    return;
	    inheritanceTypeAccesses.remove(ita);
	    ModelElementRepository.getWorkingRepository().removeElement(ita);
	    rebuildMethodInheritanceData();
	}
	
	public void removeInnerClass(Class cls) {
		if (!innerClasses.contains(cls))
		    return;
	    innerClasses.remove(cls);
	    ModelElementRepository.getWorkingRepository().removeElement(cls);
		Iterator it = cls.referencingAccesses().iterator();
		while (it.hasNext()) {
		    ((Access)it.next()).getSurroundingStatement().removeAccess((Access)it.next());
		}
	    getRoot().removeType(cls);
	}

	public void removeInnerDelegate(Delegate dg) {
		if (!innerDelegates.contains(dg))
		    return;
		innerDelegates.remove(dg);
	    ModelElementRepository.getWorkingRepository().removeElement(dg);
		Iterator it = dg.referencingAccesses().iterator();
		while (it.hasNext()) {
		    ((Access)it.next()).getSurroundingStatement().removeAccess((Access)it.next());
		}
		getRoot().removeType(dg);
	}

	public void removeInnerTypeAlias(TypeAlias ta) {
		if (!innerTypeAliases.contains(ta))
		    return;
		innerTypeAliases.remove(ta);
	    ModelElementRepository.getWorkingRepository().removeElement(ta);
		Iterator it = ta.referencingAccesses().iterator();
		while (it.hasNext()) {
		    ((Access)it.next()).getSurroundingStatement().removeAccess((Access)it.next());
		}
		getRoot().removeType(ta);
	}
	
	public void removeField(Field fld) {
		if (!fields.contains(fld))
		    return;
		
		fields.remove(fld);
		ModelElementRepository.getWorkingRepository().removeElement(fld);
		Iterator it = fld.referencingAccesses().iterator();
		while (it.hasNext()) {
		    ((Access)it.next()).getSurroundingStatement().removeAccess((Access)it.next());
		}
	}
	
	public void removeProperty(Property prop) {
		if (!properties.contains(prop))
		    return;
		
		properties.remove(prop);
	    ModelElementRepository.getWorkingRepository().removeElement(prop);
		Iterator it = prop.referencingAccesses().iterator();
		while (it.hasNext()) 
		    ((Access)it.next()).getSurroundingStatement().removeAccess((Access)it.next());
		
		
		if (prop.getGetter() != null)
		    removeMethod(prop.getGetter());
		
		if (prop.getSetter() != null)
		    removeMethod(prop.getSetter());
	}

	public void removeMethod(Method m) {
		if (!methods.contains(m))
		    return;
		
		methods.remove(m);
	    ModelElementRepository.getWorkingRepository().removeElement(m);
		Iterator it = m.referencingAccesses().iterator();
		while (it.hasNext()) 
		    ((Access)it.next()).getSurroundingStatement().removeAccess((Access)it.next());
		
	}

	/**
	 * Adds a method to the list of methods.
	 * No further action is taken.
	 * @param m
	 */
	void simpleAddMethod(Method m) {
		methods.addUnique(m);
	}
	
	/**
	 * Removes the method from the list of methods.
	 * No further action is taken.
	 * @param m
	 */
	void simpleRemoveMethod(Method m) {
		methods.remove(m);
	}
	
	public void removeConstructor(Constructor c) {
		if (!constructors.contains(c))
		    return;
		
		constructors.remove(c);
		ModelElementRepository.getWorkingRepository().removeElement(c);
		Iterator it = c.referencingAccesses().iterator();
		while (it.hasNext())
		    ((Access)it.next()).getSurroundingStatement().removeAccess((Access)it.next());
	}

	/**
	 * Adds a constructor to the constructor list.
	 * No further action is taken
	 */
	void simpleAddConstructor(Constructor c) {
		constructors.addUnique(c);
	}
	
	/**
	 * Removes the constructor from the list of constructors.
	 * No further action is taken
	 */
	void simpleRemoveConstructor(Constructor c) {
		constructors.remove(c);
	}
	
	public void removeDestructor(Destructor c) {
		if (!destructors.contains(c))
		    return;
		
		destructors.remove(c);
		ModelElementRepository.getWorkingRepository().removeElement(c);
		Iterator it = c.referencingAccesses().iterator();
		while (it.hasNext())
		    ((Access)it.next()).getSurroundingStatement().removeAccess((Access)it.next());
	}

	public void removeFriendClass(Class friendClass) {
		friendClasses.remove(friendClass);
	}

	public void removeFriendFunction(Function friendFunction) {
		friendFunctions.remove(friendFunction);
	}

	public void changeAccessSpecifier(int a) {
		memberImplementation.changeAccessSpecifier(a);
	}
	
	public void toggleIntrospectable() {
		memberImplementation.toggleIntrospectable();
	}

	public void toggleAbstract() {
		memberImplementation.toggleAbstract();
	}

	public void toggleFinal() {
	    memberImplementation.toggleFinal();
	}

	public void toggleStatic() {
		memberImplementation.toggleStatic();
	}

	public void toggleExtern() {
	    memberImplementation.toggleExtern();
	}

	public void toggleVirtual() {
	    memberImplementation.toggleVirtual();
	}

	public void toggleNew() {
	    memberImplementation.toggleNew();
	}

	public void toggleOverride() {
		memberImplementation.toggleOverride();
	}
	
	void simpleAddInnerTypeAlias(TypeAlias t) {
		innerTypeAliases.addUnique(t);
	}
	
	void simpleRemoveInnerTypeAlias(TypeAlias t) {
		innerTypeAliases.remove(t);
	}
	
	void simpleRemoveInnerDelegate(Delegate d) {
	    innerDelegates.remove(d);
	}
	
	void simpleAddInnerDelegate(Delegate d) {
	    innerDelegates.addUnique(d);
	}

	void replaceMethod(Method oldMethod, Method newMethod) {
	    if (methods.indexOf(newMethod) != -1)
	        methods.replaceObject(oldMethod, newMethod);
	}

	void simpleAddDestructor(Destructor d) {
	    destructors.addUnique(d);
	}
	
	void simpleRemoveDestructor(Destructor d) {
	    destructors.remove(d);
	}
	
	void simpleAddField(Field f) {
	    fields.addUnique(f);
	}
	
	void simpleRemoveField(Field f) {
	    fields.remove(f);
	}
    /*
    public String toString() {
        return this.getQualifiedName();
    }
    */

	public void removeContainedAccess(Access acc) {
		if (acc instanceof InheritanceTypeAccess)
			removeInheritanceTypeAccess((InheritanceTypeAccess)acc);
	}

    /**
     * This method checks if class toCheck is unrelated to the class, i.e. toCheck is not a supertype of
     * the class and toCheck is not an inner class of the class
     * @param toCheck the class against which should be checked
     * @return true if b is unrelated to a, false otherwise
     */
    public boolean isUnrelatedTo(Class toCheck) {
        if (    (getInnerClasses().contains(toCheck)) ||
                (getAllSuperTypes().contains(toCheck)) ||
                (this == toCheck) )
            return false;
        return true;
    }
}
