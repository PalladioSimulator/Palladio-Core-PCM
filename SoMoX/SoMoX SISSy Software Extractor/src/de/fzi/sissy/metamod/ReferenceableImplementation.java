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
abstract class ReferenceableImplementation extends NamedModelElementImplementation implements Referenceable {
	
	private ModelElementList accesses;
	
	public ReferenceableImplementation(String name) {
		super(name);
		accesses = new ModelElementList();
	}
	
	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Referenceable#isReferenced()
	 */
	public boolean isReferenced() {
		return !accesses.isEmpty();
	}
 
	public void addReferencingAccess(Access access) {
		accesses.addUnique(access);
	}
 
	void removeReferencingAccess(Access access) {
	    accesses.remove(access);
	    ModelElementRepository.getWorkingRepository().removeElement(access);
	}
	
	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Referenceable#referencingPackages()
	 */
	public ModelElementList referencingPackages() {
		ModelElementList ergebnis = new ModelElementList();

		Iterator itr = accesses.iterator();

		while (itr.hasNext()) {
			Access access = (Access) itr.next();
			
			Class class1 = access.getSurroundingClass();
			
			if (class1 != null) {
				ergebnis.addUnique(class1.getSurroundingPackage());
			} else {
					
				Function function = access.getSurroundingFunction();
				
				if (function != null) {
					if (function instanceof Delegate) {
						Delegate delegate = (Delegate)function;
						ergebnis.addUnique(delegate.getSurroundingPackage());
					} else if (function instanceof Member) {
						Member member = (Member)function;
						ergebnis.addUnique(member.getSurroundingClass().getSurroundingPackage());
					} else if (function instanceof GlobalFunction) {
						// GlobalFunction
						GlobalFunction gf = (GlobalFunction)function;
						Package pg = gf.getSurroundingPackage();
						if (pg!=null)
							ergebnis.addUnique(pg);
					}
				} else if (access instanceof DeclarationTypeAccess) {
					DeclarationTypeAccess dta = (DeclarationTypeAccess) access;
					
					Variable surroundingVariable = dta.getSurroundingVariable();

					//FormalParameter, LocalVariable, CatchParameter already 
					//done by the Function Section above					
					if (surroundingVariable != null) {
						// Field, Property with Member
						if (surroundingVariable instanceof Member) {
							Member member = (Member)surroundingVariable;
							ergebnis.addUnique(member.getSurroundingClass().getSurroundingPackage());
						} 
						// GlobalVariable	
						else if (surroundingVariable instanceof GlobalVariable) {
							GlobalVariable gv = (GlobalVariable)surroundingVariable;
							Package pg = gv.getSurroundingPackage();
							if (pg!=null)
								ergebnis.addUnique(pg);
						}
					}
				}
			}
		}
		
		return ergebnis;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Referenceable#referencingMethods()
	 */
	public ModelElementList referencingTypes() {
		ModelElementList ergebnis = new ModelElementList();
		ergebnis.addAll(this.referencingClasses());
		ergebnis.addAll(this.referencingDelegates());
		
		return ergebnis;
	}


	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Referenceable#referencingClasses()
	 */
	public ModelElementList referencingClasses() {
		ModelElementList ergebnis = new ModelElementList();
		Iterator itr = accesses.iterator();

		while (itr.hasNext()) {
			Access access = (Access) itr.next();
			Class class1 = access.getSurroundingClass();
			ergebnis.addUnique(class1);
		}
		
		//transitive classes:
		/*
		boolean change;
		do {
			change = false;
			Iterator itr2 = ergebnis.iterator();
			while (itr2.hasNext()) {
				Class class2 = (Class)itr2.next();
				if (class2.getSurroundingClass()!=null) {
					Class surclass = class2.getSurroundingClass();
					if (ergebnis.addUnique(surclass))
						change = true;
				}
			}
		} while (change);
		*/
		
		return ergebnis;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Referenceable#referencingMembers()
	 */
	public ModelElementList referencingMembers() {
		ModelElementList ergebnis = new ModelElementList();
		Iterator itr = accesses.iterator();

		while (itr.hasNext()) {
			Access access = (Access) itr.next();
			
			Class class1 = access.getSurroundingClass();
			if (class1 != null) {
				if (class1.getSurroundingClass()!=null)
					ergebnis.addUnique(class1);
			}

			Function function = access.getSurroundingFunction();
			if (function != null) 
				if (function instanceof Member) {
					if (function instanceof Delegate) {
						Delegate delegate = (Delegate) function;
						if (delegate.getSurroundingClass()!=null)
							ergebnis.add(delegate);
					} else {
						if (((Member)function).getSurroundingClass()!=null)
							ergebnis.addUnique(function);
					}
			}

			if (access instanceof DeclarationTypeAccess) {
				Variable variable = ((DeclarationTypeAccess)access).getSurroundingVariable();
				if (variable != null) 
				if (variable instanceof Member){
					if (((Member)variable).getSurroundingClass()!=null)
						ergebnis.addUnique(variable);
				}
			}
		}
		
		return ergebnis;
	}


	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Referenceable#referencingFunctions()
	 */
	public ModelElementList referencingFunctions() {
		ModelElementList ergebnis = new ModelElementList();
		Iterator itr = accesses.iterator();

		while (itr.hasNext()) {
			Access access = (Access) itr.next();
			Function function = access.getSurroundingFunction();
			if (!(function instanceof Delegate))
				ergebnis.addUnique(function);
		}
		
		return ergebnis;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Referenceable#referencingConstructors()
	 */
	public ModelElementList referencingDelegates() {
		ModelElementList ergebnis = new ModelElementList();
		Iterator itr = accesses.iterator();

		while (itr.hasNext()) {
			Access access = (Access) itr.next();
			Function function = access.getSurroundingFunction();
			if (function instanceof Delegate)
				ergebnis.addUnique(function);
		}
		
		return ergebnis;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Referenceable#referencingVariables()
	 */
	public ModelElementList referencingVariables() {
		ModelElementList ergebnis = new ModelElementList();
		Iterator itr = accesses.iterator();

		while (itr.hasNext()) {
			Access access = (Access) itr.next();
			if (access instanceof DeclarationTypeAccess) {
				Variable variable = ((DeclarationTypeAccess)access).getSurroundingVariable();
				ergebnis.addUnique(variable); 
			}
		}
		
		return ergebnis;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Referenceable#referencingProperties()
	 */
	public ModelElementList referencingProperties() {
		ModelElementList ergebnis = new ModelElementList();
		Iterator itr = accesses.iterator();

		while (itr.hasNext()) {
			Access access = (Access) itr.next();
			if (access instanceof DeclarationTypeAccess) {
				Variable variable = ((DeclarationTypeAccess)access).getSurroundingVariable();
				if (variable instanceof Property) 
					ergebnis.addUnique(variable); 
			}
		}
		
		return ergebnis;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Referenceable#referencingAccesses()
	 */
	public ModelElementList referencingAccesses() {
		return accesses;
	}

	void destroy() {
		super.destroy();
		accesses.destroy();
		accesses = null;
	}
		
	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitReferenceable(this);
	}
}
