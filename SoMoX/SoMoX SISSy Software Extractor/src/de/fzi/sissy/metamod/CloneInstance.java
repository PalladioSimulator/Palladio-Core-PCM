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
 * @author stammel
 *
 */
public class CloneInstance extends ModelElementImplementation implements ModelElement, ModelAnnotation {

	private ModelElementList statements;
	private Clone clone;
	
	public CloneInstance() {
		statements = new ModelElementList();
	}

	public void setStatements(ModelElementList statements) {
		this.statements = statements;
	}

	public void addStatement(Statement statement) {
		this.statements.addUnique(statement);
		// TODO CloneInstance: Annotation added to Statement ????
		statement.addAnnotation(this);
	}

	public ModelElementList getStatements() {
		return this.statements;
	}

	public Clone getClone() {
		return clone;
	}
	
	public void setClone(Clone clone) {
		this.clone = clone;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#getParent()
	 */
	public ModelElement getParent() {
		return clone;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#acceptVisitor(de.fzi.sissy.metamod.ModelVisitor)
	 */
	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitCloneInstance(this);
	}
	
	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		statements.destroy();
		statements = null;
		clone = null;
	}

}
