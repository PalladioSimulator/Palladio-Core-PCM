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
abstract class AccessImplementation extends ModelElementImplementation implements Access {
	private AccessContainer container;
	private Referenceable accessedTarget;
	
	public AccessImplementation(Referenceable target) {
		accessedTarget = target;
		if (target != null)
			if (target instanceof ReferenceableImplementation) {
			    ((ReferenceableImplementation)target).addReferencingAccess(this);
			}		
	}
	
	public void setSurroundingAccessContainer(AccessContainer cont) {
		if ((container != null) && (container != cont))
			container.removeContainedAccess(this);
		container = cont;
	}
	
	public AccessContainer getSurroundingContainer() {
		return container;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Access#getSurroundingClass()
	 */
	public Class getSurroundingClass() {
		ModelElement elem = container;
		while (elem != null) {
			if (elem instanceof Class)
				return (Class)elem;
			elem = elem.getParent();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Access#getSurroundingFunction()
	 */
	public Function getSurroundingFunction() {
		ModelElement elem = container;
		while (elem != null) {
			if (elem instanceof Function)
				return (Function)elem;
			elem = elem.getParent();
		}
		return null;
	}

	public Statement getSurroundingStatement() {
		ModelElement elem = container;
		while (elem != null) {
			if (elem instanceof Statement)
				return (Statement)elem;
			elem = elem.getParent();
		}
		return null;
	}
	
	public CompositeAccess getSurroundingCompositeAccess() {
		if (container instanceof CompositeAccess)
			return (CompositeAccess)container;
		else
			return null;
	}
	
	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Access#getAccessTarget()
	 */
	public Referenceable getAccessedTarget() {
		return accessedTarget;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Access#setAccessedTarget(de.fzi.sissy.metamod.Referenceable)
	 */
	void setAccessedTarget(Referenceable target) {
		accessedTarget = target;
	}
	
	public ModelElement getParent() {
		return getSurroundingContainer();
	}
	
	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		container = null;
		accessedTarget = null;
		setPosition(null);
	}

	// delegation to the SourceEntityImplemenatation
	
	private SourceEntityImplementation sourceEntityImplementation = new SourceEntityImplementation();
	
	public void setPosition(Position pos) {
	    sourceEntityImplementation.setPosition(pos, this);
	}
	
	public Position getPosition() {
	    return sourceEntityImplementation.getPosition();
	}
	
	public void moveToFile(File file) {
	    sourceEntityImplementation.moveToFile(file);
	}
	
	public void changeTarget(Referenceable t) {
		((ReferenceableImplementation)getAccessedTarget()).removeReferencingAccess(this);
	    ((ReferenceableImplementation)t).addReferencingAccess(this);
		setAccessedTarget(t);
	}
	
	public Class getAccessedClass() {
		Referenceable accessedTarget = this.getAccessedTarget();
		
        if (accessedTarget == null)
            return null;
        
		if (accessedTarget instanceof Class) {
			return (Class)accessedTarget;
		} else if (accessedTarget instanceof Member) {
			return ((Member)accessedTarget).getSurroundingClass();
		} else {
			ModelElement parent = accessedTarget.getParent();
			while ((parent != null) && !(parent instanceof Class))
				parent = parent.getParent();
			if (parent instanceof Class)
				return (Class)parent;
			else
				return null;
		}
	}

}
