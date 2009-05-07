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
import java.util.Vector;

import de.fzi.sissy.util.Debug;

/**
 * @author Mircea Trifu
 *
 */
public class Method extends Function implements Member, Referenceable {
	private Property surroundingProperty = null;

	public Method(String name) {
		super(name);
	}

    public boolean isPolymorphic() {
		// TODO Query isPolymorphic() -- SimpleName + isOverride ??
		Class thisClass = this.getSurroundingClass();
		
		//get transitive all descendants:
		ModelElementList descendants = thisClass.getAllDescendants();
		
		//check methods for equal name and for override
		Iterator descendants_itr = descendants.iterator();
		while (descendants_itr.hasNext()) {
			Class descendant = (Class) descendants_itr.next();
			Iterator methods_itr = descendant.getMethods().iterator();
			while (methods_itr.hasNext()) {
				Method method = (Method) methods_itr.next();
				if (method.getSimpleName().equals(this.getSimpleName()))
					if (method.isOverride())
						return true;
			}
		}
		
		return false;
    }

    public ModelElementList getPolymorphicMethods() {
		// TODO Query getPolymorphicMethods()
		ModelElementList ergebnis = new ModelElementList();

		Class thisClass = this.getSurroundingClass();
		
		//get transitive all descendants:
		ModelElementList descendants = thisClass.getAllDescendants();
		
		//check methods for equal name and for override
		Iterator descendants_itr = descendants.iterator();
		while (descendants_itr.hasNext()) {
			Class descendant = (Class) descendants_itr.next();
			Iterator methods_itr = descendant.getMethods().iterator();
			while (methods_itr.hasNext()) {
				Method method = (Method) methods_itr.next();
				if (method.getSimpleName().equals(this.getSimpleName()))
					if (method.isOverride())
						ergebnis.addUnique(method);
			}
		}

    	return ergebnis;
    }

    public boolean hasExplicitSuperAccess() {
		Class thisClass = this.getSurroundingClass();
	
		ModelElementList functionAccesses = this.getFunctionAccesses();
		
		Iterator itr = functionAccesses.iterator();
		
		while(itr.hasNext()) {
			FunctionAccess functionAccess = (FunctionAccess)itr.next();
			
			Function function = functionAccess.getAccessedFunction();
			
			if (function instanceof Method)
				if (thisClass.extendsClass(((Method)function).getSurroundingClass()))
					if(function.signature().equals(this.signature())) 
						return true;
		}
		
		return false;
    }

	/**
	 * @param surroundingProperty The surroundingProperty to set.
	 */
	void setSurroundingProperty(Property surroundingProperty) {		
		this.surroundingProperty = surroundingProperty;
		if (surroundingProperty != null) {
			if ((surroundingProperty.getSurroundingClass() != getSurroundingClass()
				&& getSurroundingClass() != null )) // MB : Added null pointer check	
				getSurroundingClass().getMethods().remove(this);
			setSurroundingClass(surroundingProperty.getSurroundingClass());
		}
	}

	/**
	 * @return Returns the surroundingProperty.
	 */
	public Property getSurroundingProperty() {
		return surroundingProperty;
	}

	public boolean isPropertyMethod() {
		return (getSurroundingProperty() != null);
    }
    
	private MemberImplementation memberImplementation = new MemberImplementation();

	/**
	 * Do not call this method directly. Use Class.addMethod instead.
	 */
	void setSurroundingClass(Class surroundingClass) {
		memberImplementation.setSurroundingClass(surroundingClass);
	}

	public Class getSurroundingClass() {
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

	public boolean isStrictProtected() {
		return memberImplementation.isStrictProtected();
	}

	public void setStrictProtected() {
		memberImplementation.setStrictProtected();
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

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setProtected()
	 */
	public void setProtected() {
		memberImplementation.setProtected();
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Member#setPackage()
	 */
	public void setPackage() {
		memberImplementation.setPackage();
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

	public ModelElement getParent() {
		Property prop = getSurroundingProperty(); 
		if (prop != null)
			return prop;
		return memberImplementation.getParent();
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


	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitMethod(this);
	}
	
	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		memberImplementation = null;
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

	public void moveToClass(Class cls) {
		convertToClassMethod();
		getSurroundingClass().simpleRemoveMethod(this);
		cls.simpleAddMethod(this);
		setSurroundingClass(cls);
	}

	public void convertToClassMethod() {
		if (! isPropertyMethod())
		    return;
		
		Property prop = getSurroundingProperty();
				
		if (this == prop.getGetter()) {
		    prop.setGetter(null);
		}
		else {
		    prop.setSetter(null);
		}
	}

    /**
     * This method returns true if the method is an accessor method, i.e. it is either getter or setter.
     * Getter ist defined as method which returns an attribute of the class (without doning any computations on this
     * attribute). A getter accepts no parameters. A getter has only 1 return statement.
     * 
     * A setter is defined as a method, which has "void" as a return type, and accepts exactly one parameter, 
     * which is assigned to an attribute of the class (no changes are made to this parameter)
     * 
     * @return true if the method is an accessor method 
     * 
     */
    public boolean isAccessor() {
        return isGetter() || isSetter();
    }
  
    /**
     * This method tries to determine if the method is a getter. it does it by trying to find a field in the surrounding class,
     * which is passed as a return value. the method must have to parameters to be a getter
     * @return the return value is the field if it has been found, or null, if no suitable field has been found 
     */
    public Field findGetterField() {
        if (getFormalParameters().isEmpty()) {
            ModelElementList mel = getAllStatements().filter("de.fzi.sissy.metamod.JumpStatement");
            Vector returnStatements = new Vector();
            // find the return statement
            Iterator it = mel.iterator();
            while (it.hasNext()) {
                JumpStatement js = (JumpStatement) it.next();
                    if (js.isReturn())
                        returnStatements.add(js);
            }

            if (returnStatements.size() != 1)
                return null;
            // check if the return statement references a field of a class
            ModelElementList accesses = ((JumpStatement)returnStatements.get(0)).getAccesses();
            it = accesses.iterator();
            while (it.hasNext()) {
                Access a = (Access)it.next();
                if (a instanceof VariableAccess) {
                    VariableAccess va = (VariableAccess) a;
                    if (va.getAccessedVariable() instanceof Field) {
                        Field f = (Field) va.getAccessedVariable();
                        if (getSurroundingClass().getFields().contains(f))
                            return f; // we found it: the returns statement has a reference to a field of the class
                    }
                }
            }
        }
        
        return null;
    }
    
    /**
     * This method tries to detect if it is a setter method. A setter is defined as a method, which has "void" as a return type, and accepts exactly one parameter, 
     * which is assigned to an attribute of the class (no changes are made to this parameter). 
     * @return the return value is the reference to the field the setter is accessing, and null if the method is not a setter.
     */
    public Field findSetterField() {
        // 2 things to check: find an assignment with field on the left side and the parameter
        // on the right side. Check that there are no write accesses to the parameter
        if (getFormalParameters().size() == 1) {
            FormalParameter fp = (FormalParameter)getFormalParameters().get(0);
            ModelElementList mel = getAllStatements();
            Iterator it = mel.iterator();
            while (it.hasNext()) {
                Statement st = (Statement) it.next();
                if ((st == null) || (st.getAccesses() == null))
                    return null;
                ModelElementList varAccesses = st.getAccesses().filter("de.fzi.sissy.metamod.VariableAccess"); 
                Iterator it2 = varAccesses.iterator();
                while (it2.hasNext()) {
                    VariableAccess va = (VariableAccess) it2.next();
                    if ( (va.getAccessedVariable()== fp) && (va.isWriteAccess()) )
                        return null;
                }
            }
            it = mel.iterator();
            while (it.hasNext()) {
                Statement st = (Statement) it.next();
                ModelElementList varAccesses = st.getAccesses().filter("de.fzi.sissy.metamod.VariableAccess"); 
                Iterator it2 = varAccesses.iterator();
                boolean fieldAccess = false;
                boolean paramAccess = false;
                Field f = null;
                while (it2.hasNext()) {
                    VariableAccess va = (VariableAccess) it2.next();
                    if (getSurroundingClass().getFields().contains(va.getAccessedVariable())) {
                        fieldAccess = true;
                        f = (Field) va.getAccessedVariable();
                    }
                    if (va.getAccessedVariable() == fp)
                        paramAccess = true;
                    
                }
                if (fieldAccess && paramAccess)
                    return f;
            }    
                
        }
        return null;
    }
    
    /**
     * @return true if the method is a getter method, false otherwise
     * @see #findGetterField()
     */
    public boolean isGetter() {
        return findGetterField() != null;
    }
    
    /**
     * @return true if the method is a setter method, false otherwise
     * @see #findSetterField()
     */
    public boolean isSetter() {
        return findSetterField() != null;
    }

}
