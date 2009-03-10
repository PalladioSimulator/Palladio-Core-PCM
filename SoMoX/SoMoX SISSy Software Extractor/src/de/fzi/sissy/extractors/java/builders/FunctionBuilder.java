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
package de.fzi.sissy.extractors.java.builders;

import java.util.List;

import recoder.abstraction.ClassType;
import recoder.abstraction.Constructor;
import recoder.abstraction.DefaultConstructor;
import recoder.abstraction.ImplicitEnumMethod;
import recoder.abstraction.ImplicitEnumValueOf;
import recoder.abstraction.Method;
import recoder.abstraction.ParameterizedType;
import recoder.abstraction.Type;
import recoder.abstraction.TypeParameter;
import recoder.bytecode.MethodInfo;
import recoder.java.Statement;
import recoder.java.StatementBlock;
import recoder.java.declaration.MethodDeclaration;
import recoder.java.declaration.TypeParameterDeclaration;
import recoder.java.statement.Branch;
import recoder.java.statement.BranchStatement;
import recoder.java.statement.Case;
import recoder.java.statement.Catch;
import recoder.java.statement.Default;
import recoder.java.statement.Else;
import recoder.java.statement.Finally;
import recoder.java.statement.LoopStatement;
import recoder.java.statement.Then;
import recoder.list.generic.ASTList;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.GenericClass;
import de.fzi.sissy.metamod.GenericEntity;
import de.fzi.sissy.metamod.Member;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.metamod.TypeParameterClass;
import de.fzi.sissy.util.Debug;

/**
 * @author szuli
 *  
 */
public abstract class FunctionBuilder extends Builder {

	/**
	 *  
	 */
	public FunctionBuilder() {
		super();
	}

	protected abstract Function addNewInstance(String simpleName, boolean generic);
	
	protected abstract void addToContainerClass(
		Class containerClass_metamod,
		Function function_metamod);

	public void extractFromRecoder(Method function_recoder) {

		if (RecoderToOMMapper.getSingleton().getInstanceFromMapper(function_recoder) != null)
		    return;

       // if (function_recoder instanceof ImplicitEnumMethod)
       //     return;
        
		String simpleName = null;
	    

		simpleName = function_recoder.getName();
        boolean generic = false;
        if ((function_recoder.getTypeParameters() != null) && (!function_recoder.getTypeParameters().isEmpty())) {
            generic = true;
        }
        Function function_metamod = addNewInstance(simpleName, generic);

		//we also add it to the recoder to OM mapper
		RecoderToOMMapper.getSingleton().addInstanceToMapper(function_recoder, function_metamod);

		if (function_metamod instanceof GenericEntity) {
			extractTypeParameters((GenericEntity)function_metamod, function_recoder);
		}
		
		boolean positionSetted = false;
        if (function_recoder instanceof ImplicitEnumMethod) {
            ImplicitEnumMethod ievo = (ImplicitEnumMethod) function_recoder;
            
            function_metamod.setImplicit();
            function_metamod.setPosition(new Position(null, -1, -1, -1, -1));
            positionSetted = true;      
        
        } else if (function_recoder instanceof MethodDeclaration) {
			// method was declared in a source file (not in a compiled class file):
			
			MethodDeclaration methodDeclaration = (MethodDeclaration) function_recoder;

			StatementBuilder.getSingleton().extractFromRecoder((MethodDeclaration)function_recoder);
			/* In StatementBuilder the following tasks are done:
			 * 
			 * - create Metamod-Statement-Objects
			 * - establish Containment-Relations between Statements
			 * - establish Containment-Relation with Function
			 * - get/set Position
			 * - set NumberOfComments
			 * 
			 * (the following numbers are calculated in metamod:)
			 * - calculate LOC
			 * - calculate NumberOfStatements
			 * - calculate NumberOfEdgesInCFG
			 * - calculate NumberOfNodesInCFG
			 * - calculate MaximumNestingLevel
			 */

			// (10e) Setup Position
			function_metamod.setPosition(FileBuilder.getSingleton().getSourcePosition(methodDeclaration));
			positionSetted = true;
			
			// Setup Number of Function-Comment-Lines
			StatementBuilder.getSingleton().setupLinesOfComments(function_metamod, methodDeclaration);
				
		} else {
			// TODO missing Position ???
			// we have no file:
			//function_metamod.setFailedDependency();
			if (!(function_recoder instanceof DefaultConstructor)&&!(function_recoder instanceof MethodInfo)) {
				Debug.warning("FunctionRecoder was instanceof "+function_recoder.getClass().getName());
				Debug.warning("FunctionRecoder: "+function_recoder.getFullName());
				Debug.warning("STOP");
				positionSetted = false;
			}
			else if (function_recoder instanceof DefaultConstructor) {
				function_metamod.setImplicit();
				function_metamod.setPosition(new Position(null, -1, -1, -1, -1));
				positionSetted = true;				
			}
			else {
				positionSetted = false;				
			}		
		}

		// (10h) Modifiers
		//We extract the modifiers of this function
		extractModifiers(function_recoder);

		// (10j) establish Class-Function-Containment-Relation
		establishClassFunctionContainmentRelation(function_recoder, function_metamod);
		
		if (!positionSetted) {
			// TODO missing Position ???
			// get position of surrounding_class
			Class surroundingClass = ((Member)function_metamod).getSurroundingClass();
			if (surroundingClass != null) {
				Position position = surroundingClass.getPosition(); 
				if (position != null) {
					Position pos = new Position(position.getSourceFile(), -1, -1, -1, -1);
					pos.setAssembly(position.getAssembly());
					function_metamod.setPosition(pos);
				} else {
					Debug.warning("Null-Position for function_metamod setted! (position of surrounding class was null)");
				}
			} else {
				Debug.warning("Null-Position for function_metamod setted! (surrounding class was null !)");
			}
		}


		// (10i) Return Type (creates DeclarationTypeAccess)
		//get return type of function
		extractReturnType(function_recoder, function_metamod);
			
		// (10k) Formal Parameters
		extractParameters(function_recoder);

		// (10l) Local Variables - we have to extract localVariables before creating of Statement-Structure ???
		extractLocalVariables(function_recoder);

	} //extractFromRecoder

	
	protected void extractModifiers(Method method_recoder) {

		//we look up the appropriate member
		Member member_metamod =
			(Member) RecoderToOMMapper.getSingleton().getInstanceFromMapper(method_recoder);
		
		if (method_recoder.isAbstract()) {
			member_metamod.setAbstract(true);
		}

		if (method_recoder.isFinal()) {
			member_metamod.setFinal(true);
		}
		else {
			member_metamod.setVirtual(true);
		}

		if (method_recoder.isPrivate()) {
			member_metamod.setPrivate();
		}

		if (method_recoder.isProtected()) {
			member_metamod.setProtected();
		}

		if (method_recoder.isPublic()) {
			member_metamod.setPublic();
		}

		if (method_recoder.isStatic()) {
			member_metamod.setStatic(true);
		}

	} //extractModifiers

	private void extractReturnType(Method function_recoder, Function function_metamod) {
		
		// recoder's getReturnType does not return the correct return type, this is a bug
		// so use a workaround, ProgramModelInfo.getReturnType(func) also does not always
	    // return a valid result.

		de.fzi.sissy.metamod.Type returnType_metamod = null;
		Type returnType_recoder = null;
		Type realReturnType_recoder = null;
        String typeName = "";
		
		if (function_recoder instanceof Constructor) {
			// Constructors have no return type
			// TODO null or Null-Type ???
		    //function_metamod.setReturnTypeDeclaration(null);	
		    return;
		}
		
		try {
		    realReturnType_recoder = ExtractorFassade.getSourceInfo().getReturnType(function_recoder);
		    returnType_recoder = realReturnType_recoder;
            if (returnType_recoder instanceof ParameterizedType)
                returnType_recoder = ((ParameterizedType)returnType_recoder).getGenericType();
        } catch (NullPointerException exc) {
		    returnType_recoder = null;
		}
		
		if (returnType_recoder != null) {
		    typeName = returnType_recoder.getFullName();
			if (typeName.equals("void")) 
				returnType_metamod = (de.fzi.sissy.metamod.Type) RecoderToOMMapper.getSingleton().getInstanceFromMapper(ExtractorFassade.getNameInfo().getNullType());
			else 
			    returnType_metamod = (de.fzi.sissy.metamod.Type) ClassTypeBuilder.getSingleton().getInstanceFromMapper(returnType_recoder);
		} else {
			if (function_recoder instanceof MethodDeclaration) {
			    MethodDeclaration methodDeclaration = (MethodDeclaration) function_recoder;
			    typeName = methodDeclaration.getTypeReference().getName();
			} else if (function_recoder instanceof MethodInfo) {
			    MethodInfo methodInfo = (MethodInfo) function_recoder;
			    typeName = methodInfo.getTypeName();
			}
				
			if (typeName.equals("void")) 
				returnType_metamod = (de.fzi.sissy.metamod.Type) RecoderToOMMapper.getSingleton().getInstanceFromMapper(ExtractorFassade.getNameInfo().getNullType());
			else {
			    try {
			        returnType_recoder = ExtractorFassade.getNameInfo().getType(typeName);
			    } catch (NullPointerException exc) {
			        Debug.warning("Return type of a function " + function_recoder.getFullName() + " could not be determined");
			        return;
			    }
			    
                returnType_metamod = (de.fzi.sissy.metamod.Type) ClassTypeBuilder.getSingleton().getInstanceFromMapper(returnType_recoder);
			}

		}

		if (returnType_metamod != null) {
			// create DeclarationTypeAccess for ReturnType of Function:
			de.fzi.sissy.metamod.DeclarationTypeAccess dta = new de.fzi.sissy.metamod.DeclarationTypeAccess(returnType_metamod);
			Common.extractTypeArguments(dta, realReturnType_recoder);
            // Position for dta
			dta.setPosition(function_metamod.getPosition());
			function_metamod.setReturnTypeDeclaration(dta);
		}
		  
	}
	
	private void establishClassFunctionContainmentRelation(Method function_recoder, Function function_metamod) {
		// get Surrounding Metamod-Class-Object:
		ClassType containingClassType = function_recoder.getContainingClassType();
		Class containingClassType_metamod =	(Class) ClassTypeBuilder.getSingleton().getInstanceFromMapper(containingClassType);
		
		if (containingClassType_metamod != null) {
			addToContainerClass(
				containingClassType_metamod,
				function_metamod);
		} //if

	}

	private void extractParameters(Method method_recoder) {
		FormalParameterBuilder.getSingleton().extractFromRecoder(
			method_recoder);
	} //extractParameters

	private void extractLocalVariables(Method method_recoder) {
		LocalVariableBuilder.getSingleton().extractFromRecoder(method_recoder);
	} //extractLocalVariables

	/*
	 * computeNestingLevel helper method.
	 */
	private int computeNestingLevel(Statement[] sa) {
		int nl = 0;
		for (int i = 0; i < sa.length; i++) {
			if (sa[i] instanceof LoopStatement) {
				LoopStatement loop = (LoopStatement) sa[i];
				Statement s = loop.getBody();
				if (s instanceof StatementBlock) {
					ASTList<Statement> sml = ((StatementBlock) s).getBody();
					Statement[] sa2 = sml.toArray(new Statement[0]);
					int nl2 = computeNestingLevel(sa2);
					if (nl2 + 1 > nl)
						nl = nl2 + 1;
				}
			} else if (sa[i] instanceof BranchStatement) {
				BranchStatement bs = (BranchStatement) sa[i];

				for (int j = 0; j < bs.getBranchCount(); j++) {
					Branch b = bs.getBranchAt(j);

					if (b instanceof Case) {
						ASTList<Statement> sml = ((Case) b).getBody();
						Statement[] sa2 = sml.toArray(new Statement[0]);
						int nl2 = computeNestingLevel(sa2);
						if (nl2 + 1 > nl)
							nl = nl2 + 1;
					} else if (b instanceof Catch) {
						Statement s = ((Catch) b).getBody();
						if (s instanceof StatementBlock) {
							ASTList<Statement> sml =
								((StatementBlock) s).getBody();
							Statement[] sa2 = sml.toArray(new Statement[0]);
							int nl2 = computeNestingLevel(sa2);
							if (nl2 + 1 > nl)
								nl = nl2 + 1;
						}
					} else if (b instanceof Default) {
						ASTList<Statement> sml = ((Default) b).getBody();
						Statement[] sa2 = sml.toArray(new Statement[0]);
						int nl2 = computeNestingLevel(sa2);
						if (nl2 + 1 > nl)
							nl = nl2 + 1;
					} else if (b instanceof Else) {
						Statement s = ((Else) b).getBody();
						if (s instanceof StatementBlock) {
							ASTList<Statement> sml =
								((StatementBlock) s).getBody();
							Statement[] sa2 = sml.toArray(new Statement[0]);
							int nl2 = computeNestingLevel(sa2);
							if (nl2 + 1 > nl)
								nl = nl2 + 1;
						}
					} else if (b instanceof Finally) {
						Statement s = ((Finally) b).getBody();
						if (s instanceof StatementBlock) {
							ASTList<Statement> sml =
								((StatementBlock) s).getBody();
							Statement[] sa2 = sml.toArray(new Statement[0]);
							int nl2 = computeNestingLevel(sa2);
							if (nl2 + 1 > nl)
								nl = nl2 + 1;
						}
					} else if (b instanceof Then) {
						Statement s = ((Then) b).getBody();
						if (s instanceof StatementBlock) {
							ASTList<Statement> sml =
								((StatementBlock) s).getBody();
							Statement[] sa2 = sml.toArray(new Statement[0]);
							int nl2 = computeNestingLevel(sa2);
							if (nl2 + 1 > nl)
								nl = nl2 + 1;
						}
					}
				}
			}
		}

		return nl;
	}

    private void extractTypeParameters(GenericEntity mmMet, Method rMet) {
        List<? extends TypeParameter> rTpList = rMet.getTypeParameters();
        for (TypeParameter tp : rTpList) {
        	TypeParameterClass tpc = (TypeParameterClass)ClassTypeBuilder.getSingleton().extractMembers(tp);
        	if (tp instanceof TypeParameterDeclaration)
        		tpc.setNormal();
            mmMet.addTypeParameter(tpc);
        }
    }    
		
	private void oldParts() {
		/*
				if (function_recoder instanceof MethodDeclaration) {
					// (10a) NumberOfStatements
					// 
					// calcutale numberOfStatements here
					// getStatementCount() actually returns either 0 or 1, 0 in case of an abstract function
					// and 1 in all other cases - this 1 statement is a statementblock, so compute the statement count
					// recursively
			
					Vector statementVector = new Vector(); 
					int num = methodDeclaration.getStatementCount();
					int pos = 0;
					for (int i=0; i<num; i++) 
						statementVector.add(methodDeclaration.getStatementAt(i));
			
					while (pos < statementVector.size()) {
						Statement statement = (Statement) statementVector.elementAt(pos);
						if (statement instanceof StatementContainer) {
							StatementContainer container = (StatementContainer) statement;
							num = container.getStatementCount();
							for (int i=0; i<num; i++)
								statementVector.add(container.getStatementAt(i));
							if (!(container instanceof StatementBlock))
								numberOfStatements++;
						} else
							numberOfStatements++;
						pos++;
					}
					// numberOfStatement calculation ends here

					// (10b) NumberOfComments

					CommentMutableList numberOfCommentsList = methodDeclaration.getComments();
					if (numberOfCommentsList != null) {
						for (int i=0; i<numberOfCommentsList.size(); i++) {
							StringTokenizer t = new StringTokenizer( ((Comment)numberOfCommentsList.getObject(i)).getText(), "\n");
							numberOfComments += t.countTokens();
						}
					} //if
					//NOS, NOC etc have to be computated here
		*/

					//we add comments attached to the method declaration to LOC
					/*
					 * Comment[] cmts =
					 * methodDeclaration.getComments().toCommentArray(); int
					 * cmtEndLine, cmtStartLine; for (int i = 0; i
					 * < cmts.length; i++) { cmtStartLine =
					 * cmts[i].getStartPosition().getLine(); cmtEndLine =
					 * cmts[i].getEndPosition().getLine(); LOC += cmtEndLine -
					 * cmtStartLine; }
					 */
		/*
					// (10c) CFG, count nodes and edges
					//compute CFG and count nodes and edges
					CFGBuilder cfgBuilder = new CFGBuilder();

					Node node = cfgBuilder.buildCFG(methodDeclaration);

					numberOfNodesInCFG = cfgBuilder.countNodes(node);
					numberOfEdgesInCFG = cfgBuilder.countEdges(node);

					// (10d) maximum nesting level
					//compute maximum nesting level
					StatementBlock sb = methodDeclaration.getBody();
					if (sb != null) {
						StatementMutableList sl = sb.getBody();
						maxiNestingLevel = computeNestingLevel(sl.toStatementArray());
					}

			
					// (10f) LOC
					LOC = position_metamod.getEndLine() - position_metamod.getStartLine() + 1;
				} //if

						function_metamod.setLinesOfCode(LOC);
				function_metamod.setNumberOfEdgesInCFG(numberOfEdgesInCFG);
				function_metamod.setNumberOfNodesInCFG(numberOfNodesInCFG);
				function_metamod.setMaximumNestingLevel(maxiNestingLevel);
				function_metamod.setNumberOfStatements(numberOfStatements);
				function_metamod.setLinesOfComments(numberOfComments);
		*/		
	}


}
