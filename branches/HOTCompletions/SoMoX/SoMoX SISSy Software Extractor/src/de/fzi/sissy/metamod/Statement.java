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

// import de.fzi.delphi.PositionElement;

/**
 * @author Mircea Trifu
 * @author stammel
 *
 */
public abstract class Statement extends ModelElementImplementation implements SourceEntity, AccessContainer {

	private ModelElementList accesses;
	private Statement container;
	private int numberOfComments;
		
	public Statement() {
		accesses = new ModelElementList();
	}

	public ModelElement getParent() {
		if (container==null) 
			return this.getSurroundingFunction();
		return container;
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitStatement(this);
	}

	public Function getSurroundingFunction() {
		Statement statement = this;
		
		while (statement.container!=null)
			statement = statement.container;
		
		if (statement instanceof BlockStatement)
			return ((BlockStatement)statement).getFunction();
			
		return null;
	}

	public int getLinesOfCode() {
		
		// We get lines of code via the position of this SourceEntity.
		Position position = this.getPosition();
		
		if (position == null) {
			return 0;
		}
		
		int LOC = position.getEndLine() - position.getStartLine() + 1;
		
		return LOC;
	}
	
	public abstract int getNumberOfEdgesInCFG(); 

	public abstract int getNumberOfNodesInCFG();

	public abstract int getMaximumNestingLevel();

	public abstract int getNumberOfStatements();
	
	public int getNumberOfComments() {
	    return numberOfComments;
	}
	
	public void setNumberOfComments(int newNumberOfComments) {
	    numberOfComments = newNumberOfComments;
	}

	public ModelElementList getAccesses() {
		return accesses;
	}

	public void setAccesses(ModelElementList list) {
		accesses = list;
		Iterator itr = accesses.iterator();
		while (itr.hasNext()) {
			AccessImplementation access = (AccessImplementation)itr.next();
			access.setSurroundingAccessContainer(this);
		}
		
	}

	public void addAccess(Access access) {
		accesses.addUnique(access);
		((AccessImplementation)access).setSurroundingAccessContainer(this);
	}

	public Statement getContainer() {
		return container;
	}

	public void setContainer(Statement statement) {
		if (container != null)
			container.simpleRemoveContainedStatement(this);
		container = statement;
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		accesses.destroy();
		accesses = null;
		container = null;
		setPosition(null);
		sourceEntityImplementation = null;
	}

	// delegation to the sourceentityimplemenatation
	
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

	public void insertAccess(Access access, int position) {
		accesses.add(position, access);
		((AccessImplementation)access).setSurroundingAccessContainer(this);
	}
	
	public void removeAccess(Access access) {
		accesses.remove(access);
		ModelElementRepository.getWorkingRepository().removeElement(access);
	}

	public static ModelElementList allConnectedStatements(Statement statement) {
		ModelElementList ergebnis = new ModelElementList();
		
		if (statement instanceof SimpleStatement)
			return ergebnis;
		
		return null;
	}
	
	protected int countStatementObjects() {
		return 1;
	}
	
	public abstract int getStatementPosition(Statement st);
	
	void replaceAccess(Access oldAccess, Access newAccess) {
	    accesses.replaceObject(oldAccess, newAccess);
	}
	
	void simpleRemoveContainedStatement(Statement stmt) {
	}

	public void removeContainedAccess(Access acc) {
		accesses.remove(acc);
	}
    
/*    
    public void addPositionElement(PositionElement posElement) {
        Position position = new Position(null, posElement.getStartLine(), posElement.getStartColumn(), posElement.getEndLine(), posElement.getEndColumn());
        setPosition(position);
    }
*/    
}
