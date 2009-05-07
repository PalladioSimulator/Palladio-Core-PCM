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

/**
 * @author Mircea Trifu
 *
 */
public class Field extends Variable implements Member, Referenceable {
	public Field(String name) {
		super(name);
	}

    public boolean isPropertyField() {
    	return false;
    }

	private MemberImplementation memberImplementation = new MemberImplementation();

	/**
	 * Do not call this method directly. Use Class.addField instead.
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
		this.setConst(a);
	}

	public void setConst(boolean a) {
		memberImplementation.setFinal(a);
		super.setConst(a);
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

	public void setOverride() {
		memberImplementation.setOverride();
	}

	public ModelElement getParent() {
		return memberImplementation.getParent();
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitField(this);
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
		getSurroundingClass().simpleRemoveField(this);
		cls.simpleAddField(this);
		setSurroundingClass(cls);
	}
    
    public String toString() {
        Class c = getSurroundingClass();
        if (c != null)
            return getClass().getName() + ":" + c.getSimpleName() + "<-" + getSimpleName();
        else
            return getClass().getName() + ":" + getSimpleName();
    }
}
