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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import de.fzi.sissy.util.Debug;

/**
 * @author Mircea Trifu
 *
 */
abstract public class Function extends ReferenceableImplementation 
		implements Referenceable, SourceEntity, StructuralEntity, 
		BehavioralEntity, NamedModelElement, AccessContainer {

	private DeclarationTypeAccess returnTypeDeclaration;

	private ModelElementList formalParameters;
	private ModelElementList catchParameters;
	private ModelElementList localClasses;
	private ModelElementList localVariables;
	private BlockStatement body;
	private ModelElementList accesses;
	private int linesOfComments;
	private int numberOfStatements;
	private int numberOfNodes;
	private int numberOfEdges;
	private int maxNestingLevel;

	private boolean pOperator;

	public Function(String name) {
		super(name);
		formalParameters = new ModelElementList();
		catchParameters = new ModelElementList();
		localClasses = new ModelElementList();
		localVariables = new ModelElementList();
		accesses = new ModelElementList();
        
		}

	public void setReturnTypeDeclaration(DeclarationTypeAccess returnTypeDeclaration) {
		this.returnTypeDeclaration = returnTypeDeclaration;
		if (returnTypeDeclaration != null) {
			returnTypeDeclaration.setSurroundingAccessContainer(this);
		}
	}

	public DeclarationTypeAccess getReturnTypeDeclaration() {
		return this.returnTypeDeclaration;
	}

	public Type getReturnType() {
		if (this.returnTypeDeclaration == null) 
			return null;
		else
			return this.returnTypeDeclaration.getAccessedType();
	}

	public void setFormalParameters(ModelElementList formalParameters) {
		this.formalParameters = formalParameters;
		Iterator it = this.formalParameters.iterator();
		while (it.hasNext()) {
			FormalParameter fp = (FormalParameter)it.next();
			fp.setSurroundingFunction(this);
		}	
	}

	public ModelElementList getFormalParameters() {
		return formalParameters;
	}
	
	public void addFormalParameter(FormalParameter fp) {
		formalParameters.addUnique(fp);
		fp.setSurroundingFunction(this);
	}

	public ModelElementList getCatchParameters() {
		if (body != null) {
			ModelElementList result = new ModelElementList();
	
			StatementTreeWalker walker = new StatementTreeWalker(body);
			
			while(walker.next()) {
				Statement currentStatement = walker.getStatement();
				
				if (currentStatement instanceof CatchBlock) {
					result.add(((CatchBlock)currentStatement).getCatchParameter());
				}
			}
			
			return result;
		}
		return catchParameters;
	}

	public void addCatchParameter(CatchParameter param) {
		catchParameters.addUnique(param);
		param.setSurroundingFunction(this);		
	}
	
	public ModelElementList getLocalClasses() {
		return localClasses;
	}
	
	public void addLocalClass(Class cls) {
		localClasses.addUnique(cls);
		cls.setSurroundingFunction(this);
	}

	public void setLocalVariables(ModelElementList localVariables) {
		this.localVariables = localVariables;
		Iterator it = this.localVariables.iterator();
		while (it.hasNext()) {
			LocalVariable lv = (LocalVariable)it.next();
			lv.setSurroundingFunction(this);
		}	
	}

	public ModelElementList getLocalVariables() {
		return localVariables;
	}
	
	public void addLocalVariable(LocalVariable lv) {
		localVariables.addUnique(lv);
		lv.setSurroundingFunction(this);
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
	
	public void addAccess(Access acc) {
		accesses.addUnique(acc);
		((AccessImplementation)acc).setSurroundingAccessContainer(this);
	}

	public ModelElementList getThrowTypeAccesses() {
		ModelElementList result = new ModelElementList();

		// Declared ThrowTypeAccesses of Function
		result.addAll(this.accesses.filter("de.fzi.sissy.metamod.ThrowTypeAccess"));

		// ThrowTypeAccesses in Statements
		if (body != null)
			result.addAll(getAccessesOfType("de.fzi.sissy.metamod.ThrowTypeAccess"));
		
		return result;
	}

	public ModelElementList getCastTypeAccesses() {
		if (body != null)
			return getAccessesOfType("de.fzi.sissy.metamod.CastTypeAccess");
		return accesses.filter("de.fzi.sissy.metamod.CastTypeAccess");
	}
	
	public ModelElementList getStaticTypeAccesses() {
		if (body != null)
			return getAccessesOfType("de.fzi.sissy.metamod.StaticTypeAccess");
		return accesses.filter("de.fzi.sissy.metamod.StaticTypeAccess");
	}
	
	public ModelElementList getSelfAccesses() {
		if (body != null)
			return getAccessesOfType("de.fzi.sissy.metamod.SelfAccess");
		return accesses.filter("de.fzi.sissy.metamod.SelfAccess");
	}
	
	public ModelElementList getRunTimeTypeAccesses() {
		if (body != null)
			return getAccessesOfType("de.fzi.sissy.metamod.RunTimeTypeAccess");
		return accesses.filter("de.fzi.sissy.metamod.RunTimeTypeAccess");
	}
	
	public ModelElementList getFunctionAccesses() {
		if (body != null)
			return getAccessesOfType("de.fzi.sissy.metamod.FunctionAccess");
		return accesses.filter("de.fzi.sissy.metamod.FunctionAccess");
	}

	public ModelElementList getVariableAccesses() {
		if (body != null)
			return getAccessesOfType("de.fzi.sissy.metamod.VariableAccess");
		return accesses.filter("de.fzi.sissy.metamod.VariableAccess");
	}

	private ModelElementList getAccessesOfType(String clsName) {
		ModelElementList result = new ModelElementList();

		StatementTreeWalker walker = new StatementTreeWalker(body);
		
		while(walker.next()) {
			Statement currentStatement = walker.getStatement();
			
			result.addAll(currentStatement.getAccesses().filter(clsName));
		}
		
		return result;
	}
	
	public BlockStatement getBody() {
		return body;
	}
	
	public void setBody(BlockStatement statement) {
		body = statement;
		body.setFunction(this);
	}

	public void changeBody(BlockStatement statement) {
		this.setBody(statement);
	}

	public int getLinesOfCode() {
		Position pos = this.getPosition();
		
		if (pos == null)
			return 0;
		if (pos.getSourceFile() == null)
			return 0; // -- No source files => No LOC's
			
		int loc = pos.getEndLine() - pos.getStartLine() + 1;
		
		return loc;
	}

	public int getNumberOfStatements() {
		if (body != null)
			return body.getNumberOfStatements();
		return numberOfStatements;
	}

	public void setNumberOfStatements(int val) {
		numberOfStatements = val;
	}

	public int getNumberOfEdgesInCFG() {
		if (body != null)
			return body.getNumberOfEdgesInCFG();
		return numberOfEdges;
	}

	public void setNumberOfEdgesInCFG(int val) {
		numberOfEdges = val;
	}

	public int getNumberOfNodesInCFG() {
		if (body != null)
			return body.getNumberOfNodesInCFG();
		return numberOfNodes;
	}

	public void setNumberOfNodesInCFG(int val) {
		numberOfNodes = val;
	}

	public int getMaximumNestingLevel() {
		if (body != null)
			return body.getMaximumNestingLevel();
		return maxNestingLevel;
	}

	public void setMaximumNestingLevel(int val) {
		maxNestingLevel = val;
	}

	public void setLinesOfComments(int linesOfComments) {
		this.linesOfComments = linesOfComments;
	}

	public int getLinesOfComments() {
		return linesOfComments;
	}
	
    public Signature signature() {
    	ModelElementList paramTypes = new ModelElementList();
    	ModelElementList exTypes = new ModelElementList();
    	Iterator it = formalParameters.iterator();
    	while (it.hasNext()) {
    		FormalParameter fp = (FormalParameter)it.next();
    		paramTypes.add(fp.getTypeDeclaration());
    	}
    	it = this.getThrowTypeAccesses().iterator();
		while (it.hasNext()) {
			ThrowTypeAccess trw = (ThrowTypeAccess)it.next();
			exTypes.add(trw);
		}
    	
    	return new Signature(returnTypeDeclaration, getSimpleName(), paramTypes, exTypes);
    }

    public boolean hasIdenticalSignature(Function f) {
		return this.signature().equals(f.signature());
    }

	public void setOperator(boolean pOp) {
		pOperator = pOp;
	}

	public boolean isOperator() {
		return pOperator;
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		accesses.destroy();
		catchParameters.destroy();
		formalParameters.destroy();
		localClasses.destroy();
		localVariables.destroy();
        
		accesses = null;
		catchParameters = null;
		formalParameters = null;
		localClasses = null;
		localVariables = null;
		returnTypeDeclaration = null;
        
		body = null;
		setPosition(null);
	}
	
	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitFunction(this);
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
	
	void simpleRemoveLocalClass(Class cls) {
	    localClasses.remove(cls);
	}
	
	void simpleAddLocalClass(Class cls) {
	    localClasses.addUnique(cls);
	}
	
	void simpleAddLocalVariable(LocalVariable var) {
	    localVariables.addUnique(var);
	}
	
	void simpleRemoveLocalVariable(LocalVariable var) {
	    localVariables.remove(var);
	}
	
	public void convertToOperator() {
		pOperator = true;
	}

	public void convertToFunction() {
		pOperator = false;
	}

	public void changeReturnType(DeclarationTypeAccess dta) {
		((ReferenceableImplementation)returnTypeDeclaration.getAccessedTarget()).removeReferencingAccess(returnTypeDeclaration);
		returnTypeDeclaration = dta;
	}
	
	public void insertFormalParameter(FormalParameter fp, int position) {
		formalParameters.add(position, fp);
	}

	public void removeFormalParameter(FormalParameter fp) {
		formalParameters.remove(fp);
	    ModelElementRepository.getWorkingRepository().removeElement(fp);
	}

	public void removeThrowTypeAccess(ThrowTypeAccess tta) { 
		accesses.remove(tta);
	    ModelElementRepository.getWorkingRepository().removeElement(tta);
	}

	public void removeLocalClass(Class cls) { 
		if (!localClasses.contains(cls))
		    return;
		Root root = cls.getRoot();
		if (root == null)
		    Debug.error("Function::removeLocalClass - Root is null");
		
		localClasses.remove(cls);
	    ModelElementRepository.getWorkingRepository().removeElement(cls);
	    root.removeType(cls);
	}
	
	public void removeLocalVariable(LocalVariable lv) {
		if (!localVariables.contains(lv))
		    return;
		
	    ModelElementRepository.getWorkingRepository().removeElement(lv);
	    localVariables.remove(lv);
	}
    
    /*
    public String toString() {
        return this.signature().toString();
    }
    */
	
	public void removeContainedAccess(Access acc) {
		if (acc == returnTypeDeclaration)
			returnTypeDeclaration = null;
		else
			accesses.remove(acc);
	}
    /**
     * Returns a flat list of all statements in the function
     * @return the list of the statements
     */
    public ModelElementList getAllStatements() {
        ModelElementList result = new ModelElementList();
        
        int pos = 0;
        if (getBody() == null)
            return result;
        result.add(getBody());
        while (pos < result.size()) {
            if (! (result.get(pos) instanceof Statement)) {
                pos++;
                continue;
            }
            Statement statement = (Statement) result.get(pos);

            if (statement instanceof BlockStatement) 
                result.addAll( ((BlockStatement)statement).getStatements() );
            if (statement instanceof BranchStatement)
                result.addAll( ((BranchStatement)statement).getBranches() );
            if (statement instanceof ExceptionHandler) {
                result.addAll( ((ExceptionHandler)statement).getCatchBlocks() );
                result.add( ((ExceptionHandler)statement).getGuardedBlock() );
                result.add( ((ExceptionHandler)statement).getFinallyBlock() );
            }
            if (statement instanceof LoopStatement)
                result.add( ((LoopStatement)statement).getBody() );
            pos++;
        }
        
        return result;
    }
    
    /**
     * Returns the list of all variables accessed in the method. Also the possibility to include
     * indirect accesses (accesses via getters/setters) is given, by setting the parameter to true 
     * @param indirect when true, this value indicates, that indirect accesses should be also included in the list, when
     * false, only direct variables accesses are counted.
     * @return the list of accessed variables
     */
    public ModelElementList getAccessedVariables(boolean indirect) {
        ModelElementList result = new ModelElementList();
        Set accessedVariables = new HashSet();
        ModelElementList allAccesses = getAllAccesses();
        ModelElementList varAccesses = allAccesses.filter("de.fzi.sissy.metamod.VariableAccess");
        Iterator it = varAccesses.iterator();
        while (it.hasNext()) {
            accessedVariables.add(((VariableAccess)it.next()).getAccessedVariable());
        }
        
        if (indirect) {
            ModelElementList funcAccesses = allAccesses.filter("de.fzi.sissy.metamod.FunctionAccess");
            it = funcAccesses.iterator();
            while (it.hasNext()) {
                Method m = null;
                try {
                    m = (Method) ((FunctionAccess)it.next()).getAccessedFunction();
                } catch (ClassCastException e) {
                    continue;
                }
                Field getterField = m.findGetterField();
                if (getterField != null)
                    accessedVariables.add(getterField);
                
                Field setterField = m.findSetterField();
                if (setterField != null)
                    accessedVariables.add(setterField);
            }
        }
        
        it = accessedVariables.iterator();
        while (it.hasNext()) {
            result.add(it.next());
        }
        
        return result;
    }
    
    /**
     * Returns the list of all accesses in the method
     * @return the list of accesses
     */
    public ModelElementList getAllAccesses() {
        ModelElementList result = new ModelElementList();
        ModelElementList statements = getAllStatements();
        Iterator it = statements.iterator();
        while (it.hasNext()) { 
            Object o = it.next();
            if ((o != null) && (((Statement)o).getAccesses()!= null))
                result.addAll(((Statement)o).getAccesses());
        }
        return result;
    }


}
