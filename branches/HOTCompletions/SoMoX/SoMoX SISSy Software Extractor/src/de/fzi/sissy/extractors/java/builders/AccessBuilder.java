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

import recoder.abstraction.ClassType;
import recoder.abstraction.Constructor;
import recoder.abstraction.Field;
import recoder.abstraction.Member;
import recoder.abstraction.Method;
import recoder.abstraction.Type;
import recoder.abstraction.Variable;
import recoder.convenience.TreeWalker;
import recoder.java.Expression;
import recoder.java.ExpressionContainer;
import recoder.java.Identifier;
import recoder.java.NonTerminalProgramElement;
import recoder.java.ProgramElement;
import recoder.java.Reference;
import recoder.java.SourceElement;
import recoder.java.Statement;
import recoder.java.StatementContainer;
import recoder.java.declaration.EnumConstantSpecification;
import recoder.java.declaration.FieldSpecification;
import recoder.java.declaration.MethodDeclaration;
import recoder.java.declaration.VariableSpecification;
import recoder.java.expression.ArrayInitializer;
import recoder.java.expression.Assignment;
import recoder.java.expression.Operator;
import recoder.java.expression.operator.ComparativeOperator;
import recoder.java.expression.operator.CopyAssignment;
import recoder.java.expression.operator.TypeOperator;
import recoder.java.reference.ArrayLengthReference;
import recoder.java.reference.ArrayReference;
import recoder.java.reference.ConstructorReference;
import recoder.java.reference.EnumConstructorReference;
import recoder.java.reference.FieldReference;
import recoder.java.reference.MethodReference;
import recoder.java.reference.ReferencePrefix;
import recoder.java.reference.SpecialConstructorReference;
import recoder.java.reference.SuperReference;
import recoder.java.reference.ThisReference;
import recoder.java.reference.TypeReference;
import recoder.java.reference.TypeReferenceContainer;
import recoder.java.reference.UncollatedReferenceQualifier;
import recoder.java.reference.VariableReference;
import recoder.java.statement.Case;
import recoder.java.statement.JavaStatement;
import recoder.list.generic.ASTList;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.Access;
import de.fzi.sissy.metamod.CompositeAccess;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.FunctionAccess;
import de.fzi.sissy.metamod.SelfAccess;
import de.fzi.sissy.metamod.StaticTypeAccess;
import de.fzi.sissy.metamod.VariableAccess;
import de.fzi.sissy.util.Debug;

/**
 * @author szuli
 *  
 */
public class AccessBuilder extends Builder {
	protected static AccessBuilder singleton = null;

	/**
	 *  
	 */
	public AccessBuilder() {
		super();
	}

	public static AccessBuilder getSingleton() {
		if (singleton == null) {
			singleton = new AccessBuilder();
		} //if
		return singleton;
	} //getSingleton

	public void extractFromRecoder(Method method_recoder) {
		if (method_recoder instanceof MethodDeclaration) {
			MethodDeclaration methodDeclaration_recoder = (MethodDeclaration) method_recoder;
			Function method_metamod = (Function) RecoderToOMMapper.getSingleton().getInstanceFromMapper(method_recoder);
			if (method_metamod == null) {
			    Debug.error("No metamod function found for a given recoder function");
			    return;
			}
			//Debug.info("Accesses for "+ method_recoder.getFullName());
			walkToFindAndCreateAccesses(methodDeclaration_recoder);
		}
	}

	public void extractFromRecoder(Field field_recoder) {
		if (field_recoder instanceof FieldSpecification) {
			de.fzi.sissy.metamod.Field field_metamod = (de.fzi.sissy.metamod.Field) RecoderToOMMapper.getSingleton().getInstanceFromMapper(field_recoder);
			if (field_metamod == null) {
			    Debug.error("No field function found for a given recoder field");
			    return;
			}
			//Debug.info("Accesses for "+ method_recoder.getFullName());
			walkToFindAndCreateAccesses((FieldSpecification)field_recoder);
		}
	}
	
	
	private void handleVariableReference(ProgramElement ASTElement_recoder) {
		VariableReference variableRef_recoder =	(VariableReference) ASTElement_recoder;
		//Debug.info("VariableReference "+variableRef_recoder.getName()+" gefunden an");
		
		de.fzi.sissy.metamod.Statement statement_metamod = findStatement(ASTElement_recoder);
		if (statement_metamod == null) {
			Debug.warning("Statement was null! ASTElement: "+ASTElement_recoder.toString()+ " Variable: "+variableRef_recoder.getName());
			Debug.warning("STOP");
		}
		this.extractVariableReference(statement_metamod, variableRef_recoder);
	}
	
	private void handleMethodReference(ProgramElement ASTElement_recoder) {
		MethodReference methodRef_recoder = (MethodReference) ASTElement_recoder;
		//Debug.info("MethodReference "+methodRef_recoder.getName()+" gefunden.");
		de.fzi.sissy.metamod.Statement statement_metamod = findStatement(ASTElement_recoder);
		addMethodAccess(statement_metamod, methodRef_recoder);	    
	}
	
	private void handleConstructorReference(ProgramElement ASTElement_recoder) {
		if (ASTElement_recoder instanceof EnumConstructorReference)
            return;
        ConstructorReference constructorRef_recoder = (ConstructorReference) ASTElement_recoder;
		//Debug.info("ConstructorReference "+constructorRef_recoder.getClass().getName()+" gefunden.");
		de.fzi.sissy.metamod.Statement statement_metamod = findStatement(ASTElement_recoder);
		addConstructorAccess(statement_metamod, constructorRef_recoder);
	}
	
	
	private void walkToFindAndCreateAccesses(ProgramElement pe) {
		
		TreeWalker treeWalker = new TreeWalker(pe);

		treewalk:
		while (treeWalker.next()) {
			ProgramElement ASTElement_recoder =	treeWalker.getProgramElement();
			
			if (ASTElement_recoder instanceof Identifier) {
	       		//Variable reference?
				if (ASTElement_recoder.getASTParent() instanceof VariableReference) {
				    handleVariableReference(ASTElement_recoder.getASTParent());
				} 
			    /* For getting the correct Access-Order we 
			     * identify the function-access-position by Identifier-Node
			     * within a MethodReference
			     */
				else if (ASTElement_recoder.getASTParent() instanceof MethodReference) {
				    handleMethodReference(ASTElement_recoder.getASTParent());
			    } 
        	}
        	//Reference to a constructor?
        	else if (ASTElement_recoder instanceof ConstructorReference) {
        	    handleConstructorReference(ASTElement_recoder);
			}
        	else if (ASTElement_recoder instanceof TypeReference) {
    			Function method_metamod = null;
    			if (pe instanceof MethodDeclaration)
    				method_metamod = (Function) RecoderToOMMapper.getSingleton().getInstanceFromMapper((MethodDeclaration)pe);
        	    ClassAccessBuilder.getSingleton().handleTypeReference(ASTElement_recoder, method_metamod);
			} //if
		}
	}

	
	private void createAndSetupStaticTypeAccess(de.fzi.sissy.metamod.Statement statement_metamod, ProgramElement reference_recoder) {
		// if we have a TypeReference as child of a FieldReference or MethodReference 
		// then we can create and add a StaticTypeAccess to the according metamod-statement
		
		if ((reference_recoder instanceof MethodReference)||
		    (reference_recoder instanceof FieldReference)) {
			
			TypeReferenceContainer typref_container = (TypeReferenceContainer) reference_recoder;
			
			if (typref_container.getTypeReferenceCount()>0) {
				for (int i=0; i < typref_container.getTypeReferenceCount(); i++) {
					
					TypeReference typref_recoder = (TypeReference) typref_container.getTypeReferenceAt(i);

					Type referencedType_recoder = ExtractorFassade.getSourceInfo().getType(typref_recoder);
					
					// get metamod-type 
					de.fzi.sissy.metamod.Type metamod_type = (de.fzi.sissy.metamod.Type) RecoderToOMMapper.getSingleton().getInstanceFromMapper(referencedType_recoder);
					
					if (metamod_type != null) {
						StaticTypeAccess sta_metamod = new StaticTypeAccess(metamod_type);
						
						sta_metamod.setPosition(FileBuilder.getSingleton().getSourcePosition(typref_recoder));
						 
						addAccessToCompositeAccessOrStatement(statement_metamod, reference_recoder, sta_metamod);						
					} else {
						Debug.warning("StaticTypeAccess-Generation: Metamod-Type was null!");
					}
				}
			}
		} else {
			//Debug.warning("Attempt to create StaticTypeAccess failed ! ");
		}
	}
	
	
	/*
	 * It is called, when a reference to a variable was found. This method goes
	 * into the "details" and decides whether it is a reference to an
	 * attribute, formal parameter or local variable. It then also adds the
	 * appropriate model elements to the METAMOD instance.
	 */
	private void extractVariableReference(de.fzi.sissy.metamod.Statement statement_metamod,	VariableReference variableRef_recoder) {

		//Recoder SourceInfo gives us the Variable that corresponds to that
		// VariableReference
		Variable variable_recoder =	ExtractorFassade.getSourceInfo().getVariable(variableRef_recoder);
		
        // Christoph says: In the Recoder documentation, it says: 
        // "Returns: the referred variable (may be null)." 
        // Thus, we must take care of the case when it is null. 
        
        Type type_recoder;
        if (variable_recoder != null) 		
            type_recoder = variable_recoder.getType();
        else
            type_recoder = null;
		
		if (type_recoder == null) {
		    Debug.error("AccessBuilder::extractVariablReference - type of variable is null");
		    return;
		}

		de.fzi.sissy.metamod.Variable variable_metamod = null;
		variable_metamod = (de.fzi.sissy.metamod.Variable)RecoderToOMMapper.getSingleton().getInstanceFromMapper(variable_recoder);
		
		if (variable_metamod==null) {
			if (variable_recoder instanceof Member) { 
				ClassType containingClassType = variable_recoder.getProgramModelInfo().getContainingClassType((Member)variable_recoder);
				// create metamod-variable
				variable_metamod = FieldBuilder.getSingleton().createField(containingClassType, (Field)variable_recoder);
			} else {
				Debug.warning("We are going to add an Access with Target-Variable is null! "+ variable_recoder.getFullName() + "  Recoder-Variabe was instance of "+variable_recoder.getClass().getName());
				Debug.warning("STOP");
			}
		}

		if (variableRef_recoder instanceof FieldReference) {
			if (((FieldReference)variableRef_recoder).getReferencePrefix() != null) {
				ReferencePrefix prefix = ((FieldReference)variableRef_recoder).getReferencePrefix();
				if (prefix instanceof ThisReference) {
					SelfAccess sfAcc = new SelfAccess(((de.fzi.sissy.metamod.Member)variable_metamod).getSurroundingClass());
					addAccessToCompositeAccessOrStatement(statement_metamod, variableRef_recoder, sfAcc);					
				}
				else if (prefix instanceof SuperReference) {
					SelfAccess sfAcc = new SelfAccess(((de.fzi.sissy.metamod.Member)variable_metamod).getSurroundingClass());
					sfAcc.setSuperAccess(true);
					addAccessToCompositeAccessOrStatement(statement_metamod, variableRef_recoder, sfAcc);					
				}
				else
					createAndSetupStaticTypeAccess(statement_metamod, variableRef_recoder);
			}
			else if (variable_metamod instanceof de.fzi.sissy.metamod.Member) {
				SelfAccess sfAcc = new SelfAccess(((de.fzi.sissy.metamod.Member)variable_metamod).getSurroundingClass());
				addAccessToCompositeAccessOrStatement(statement_metamod, variableRef_recoder, sfAcc);
			}
		}
		ExpressionContainer expressionContainer = variableRef_recoder.getExpressionContainer();
			
		if (expressionContainer != null) {
			    
		    if ((expressionContainer instanceof ComparativeOperator) ||
		        (expressionContainer instanceof ArrayReference) ||
		        (expressionContainer instanceof JavaStatement) ||
		        (expressionContainer instanceof MethodReference) ||
		        (expressionContainer instanceof TypeOperator) ||
		        (expressionContainer instanceof VariableSpecification) ||
		        (expressionContainer instanceof Case) ||
		        (expressionContainer instanceof ArrayInitializer) ||
		        (expressionContainer instanceof SpecialConstructorReference)) {
		        addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, false);
		        return;
		    }
			    
		    if (expressionContainer instanceof CopyAssignment) {
		        CopyAssignment copyAssignment = (CopyAssignment) expressionContainer;
		        // if our variable reference is on the left side of a copyassignment this is a write access,
		        // otherwise a read access
		        if (copyAssignment.getChildAt(0) == variableRef_recoder)
		            addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, true);
		        else
		            addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, false);
		        return;
		    }
		    
		    // after we've handled the copy assignment, which is the only one with either read or write access
		    // handle other assignments which are either read or read-write
		    if (expressionContainer instanceof Assignment) {
		        Assignment assignment = (Assignment)expressionContainer;
		        if (assignment.getChildAt(0) == variableRef_recoder) {
		            addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, false);
		            addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, true);
		        } else 
		            addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, false);
		        return;
		    }

		    if (expressionContainer instanceof Operator) {
		        addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, false);
		        return;
		    }
		    
		    // if there's something we did not think of, assume it's a read access
			Debug.warning("First: A Variable Access without category is added ! "+ variable_metamod.getSimpleName());
		    addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, false);
		    
		} else {
		    ProgramElement pe = variableRef_recoder.getASTParent();
		    
		    if ((pe instanceof MethodReference) ||
		        (pe instanceof ArrayLengthReference) ||
		        (pe instanceof FieldReference) ||
		        (pe instanceof UncollatedReferenceQualifier)) {
		        addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, false);
		        return;
		    }
		    
		    if (pe instanceof ArrayReference) {
		        if (pe.getASTParent() instanceof CopyAssignment) {
		            if (pe.getASTParent().getChildAt(0) == pe)
		                addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, true);
		            else
		                addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, false);
		            return;
		        }
		        
		        if (pe.getASTParent() instanceof Assignment) {
		            if (pe.getASTParent().getChildAt(0) == pe) {
		                addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, false);
			            addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, true);
		            } else
		                addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, false);
		            return;
		        }
		        
		        addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, false);
		        return;
		    }
		    
		    // if there's something we did not think of, assume it's a read access
		    Debug.warning("Second: A Variable Access without category is added ! "+ variable_metamod.getSimpleName());
		    addVariableAccess(statement_metamod, variable_metamod, variableRef_recoder, false); 
		}
	} //extractVariableReference

	private void addMethodAccess(de.fzi.sissy.metamod.Statement statement_metamod, MethodReference methodRef_recoder) {
		//Recoder SourceInfo gives us the Method that corresponds to that
		// MethodReference
		Method referencedMethod_recoder = ExtractorFassade.getSourceInfo().getMethod(methodRef_recoder);

		if (referencedMethod_recoder != null) {
			de.fzi.sissy.metamod.Method accessedMethod_metamod = 
			    (de.fzi.sissy.metamod.Method)RecoderToOMMapper.getSingleton().getInstanceFromMapper(referencedMethod_recoder);

			if (accessedMethod_metamod == null) {
				//it means, that the accessed method is in a compiled (class) file
				//Debug.warning("Accessed Method was null! "+referencedMethod_recoder.getFullName() + " Interface:"+referencedMethod_recoder.getContainingClassType().isInterface());
				MethodBuilder.getSingleton().extractFromRecoder(referencedMethod_recoder);
				accessedMethod_metamod =
					(de.fzi.sissy.metamod.Method) RecoderToOMMapper.getSingleton().getInstanceFromMapper(referencedMethod_recoder);
			}
			
			if (methodRef_recoder.getReferencePrefix() != null) {
				ReferencePrefix prefix = methodRef_recoder.getReferencePrefix();
				if (prefix instanceof ThisReference) {
					SelfAccess sfAcc = new SelfAccess(accessedMethod_metamod.getSurroundingClass());
					addAccessToCompositeAccessOrStatement(statement_metamod, methodRef_recoder, sfAcc);
				}
				else if (prefix instanceof SuperReference) {
					SelfAccess sfAcc = new SelfAccess(accessedMethod_metamod.getSurroundingClass());
					sfAcc.setSuperAccess(true);
					addAccessToCompositeAccessOrStatement(statement_metamod, methodRef_recoder, sfAcc);
				}
				else
					createAndSetupStaticTypeAccess(statement_metamod, methodRef_recoder);
			}
			else {
				SelfAccess sfAcc = new SelfAccess(accessedMethod_metamod.getSurroundingClass());
				addAccessToCompositeAccessOrStatement(statement_metamod, methodRef_recoder, sfAcc);
			}
			// (13b) Method/FunctionAccess-Object created.
			//create MethodAccess
			FunctionAccess functionAccess =	new FunctionAccess(accessedMethod_metamod);
			functionAccess.setPosition(FileBuilder.getSingleton().getSourcePosition(methodRef_recoder));

            /*
            if (statement_metamod != null) {
                statement_metamod.addAccess(functionAccess);
            } else {
                Debug.warning("Method Access could not be added to Statement!");
            }
*/
            CompositeAccess surroundingCompositeAccess = addAccessToCompositeAccessOrStatement(statement_metamod, methodRef_recoder, functionAccess);

            // composite accesses are added either to statement or to surrounding composite access!
            if (methodRef_recoder.getArguments()!=null)
            createCompositeAccessesForFunctionReference(statement_metamod, methodRef_recoder.getArguments(), surroundingCompositeAccess);
            
            Common.extractTypeArguments(functionAccess, methodRef_recoder);
	
	//		method_metamod.addFunctionAccess(functionAccess);
		}
	} //addMethodAccess

    private void createCompositeAccessesForFunctionReference(de.fzi.sissy.metamod.Statement statement_metamod, ASTList<Expression> argument_list, CompositeAccess surroundingCompositeAccess) {
        if (argument_list == null) {
            Debug.warning("Argument List for Reference was null!");
            return;
        } else {
            //Debug.warning("Argument List for Reference was NOT null!");
        }
        
        
        // For all arguments we create an CompositeAccess and map them so the expression object
        // Later we have to check, whether an Reference is directly contained in a mapped container expression
//        ExpressionMutableList argument_list = methodRef_recoder.getArguments();
        
        for (int i=0; i<argument_list.size(); i++) {
            Expression argument = argument_list.get(i);
            
            CompositeAccess composite_access_metamod = new CompositeAccess();
            
            RecoderToOMMapper.getSingleton().addInstanceToMapper(argument, composite_access_metamod);
            
            if (surroundingCompositeAccess!= null) {
                // the corresponding functionaccess is contained in surrounding composite access
                // SCA(...., FA, CAM, .....)
                surroundingCompositeAccess.addAccess(composite_access_metamod);
            } else if (statement_metamod != null) {
                // the corresponding functionaccess is contained in statement
                // STM(...., FA, CAM, .....)
                statement_metamod.addAccess(composite_access_metamod);
            } else {
                Debug.warning("CompositeAccess could neither be added to SurroundingCompositeAccess nor to Statement!");
            }
        }
    }

    
	private void addConstructorAccess(de.fzi.sissy.metamod.Statement statement_metamod, ConstructorReference constructorRef_recoder) {

		//Recoder SourceInfo provides the Constructor that corresponds to that
		// ConstructorReference
		Constructor referencedConstructor_recoder =	ExtractorFassade.getSourceInfo().getConstructor(constructorRef_recoder);

		if (referencedConstructor_recoder != null) {
			de.fzi.sissy.metamod.Constructor accessedConstructor_metamod = 
			    	(de.fzi.sissy.metamod.Constructor)RecoderToOMMapper.getSingleton().getInstanceFromMapper(referencedConstructor_recoder);
			
			if (accessedConstructor_metamod == null) {
				//it means, that the accessed constructor is in a compiled (class) file
				//Debug.warning("Accessed Constructor was null!");
				ConstructorBuilder.getSingleton().extractFromRecoder(referencedConstructor_recoder);
				accessedConstructor_metamod =
				    (de.fzi.sissy.metamod.Constructor) RecoderToOMMapper.getSingleton().getInstanceFromMapper(referencedConstructor_recoder);
				
			}
			
			// (13c) Constructor/FunctionAccess-Object created.
			FunctionAccess functionAccess = new FunctionAccess(accessedConstructor_metamod);
			functionAccess.setPosition(FileBuilder.getSingleton().getSourcePosition(constructorRef_recoder));

            
            CompositeAccess surroundingCompositeAccess = addAccessToCompositeAccessOrStatement(statement_metamod, constructorRef_recoder, functionAccess);

            if (constructorRef_recoder.getArguments()!=null)
            createCompositeAccessesForFunctionReference(statement_metamod, constructorRef_recoder.getArguments(), surroundingCompositeAccess);

            /*
			if (statement_metamod != null) {
				statement_metamod.addAccess(functionAccess);
			} else {
				Debug.warning("Constructor Access could not be added to Statement!");
			}
            */
            
            Common.extractTypeArguments(functionAccess, constructorRef_recoder);

            //method_metamod.addFunctionAccess(functionAccess);
		} //if
	} //addConstructorAccess

	public void addVariableAccess(de.fzi.sissy.metamod.Statement statement_metamod, de.fzi.sissy.metamod.Variable variable_metamod, 
	        					   SourceElement sourceElement, boolean writeAccess) {
		// (13a) VariableAccess-Object created.
		/*
		if (variable_metamod == null) {
			Debug.warning("Variable was null!");
			return;
		}
		*/
		
		//Debug.info("VariableAccess created for "+ variable_metamod.getSimpleName());
	    VariableAccess access = new VariableAccess(variable_metamod, writeAccess);
	    access.setPosition(FileBuilder.getSingleton().getSourcePosition(sourceElement));
        
        addAccessToCompositeAccessOrStatement(statement_metamod, sourceElement, access);
	    
	}

    public CompositeAccess addAccessToCompositeAccessOrStatement(de.fzi.sissy.metamod.Statement statement_metamod, SourceElement sourceElement, Access access) {
        // as reference we need VariableReference, MethodReference or ConstructorReference
        
        // When VariableReference is contained in a FunctionReference, we get the 
        // first argument expression of this FunctionReference and get the corresponding
        // compositeAccess, and add the VariableAccess to the compositeAccess
        // but not to the statement directly
        
        CompositeAccess compositeAccess = getCompositeAccessToReferenceElement(sourceElement);

        if (compositeAccess != null) {
            compositeAccess.addAccess(access);
            return compositeAccess;
        } else if (statement_metamod != null) {
            statement_metamod.addAccess(access);
        } else {
           Debug.warning("Access could not be added to statement!");
        }
    
        return null;
    }
    
	private CompositeAccess getCompositeAccessToReferenceElement(SourceElement sourceElement) {
        if (!((sourceElement instanceof VariableReference)||(sourceElement instanceof MethodReference)||
                (sourceElement instanceof ConstructorReference)||(sourceElement instanceof TypeReference))) {
            return null;
        }
        
        
        // look for surrounding function-reference ==> note last expression on the way upwards 
        // (corresponds to function argument element which is mapped to composite access)
        Expression last_expression = null;
            
        Reference var_ref = (Reference)sourceElement;
        if (sourceElement instanceof Expression)
        	last_expression = (Expression)sourceElement;
        NonTerminalProgramElement parent = var_ref.getASTParent();
            
        while (parent!=null && 
                !(parent instanceof MethodReference) && 
                !(parent instanceof ConstructorReference)) {
        	
        	/*
        	 * Workaround added by mtrifu to avoid compiler bug: Incompatible types 
        	 * due to methods with co-variant return types:
        	 * 		Expression Expression.deepClone()
        	 * 		SourceElement SourceElement.deepClone()  
        	 */
        	Object par = parent;
            if (par instanceof Expression) {
                last_expression = (Expression)par;
            }
            
            parent = parent.getASTParent();
        }
            
        if (parent == null) {
            // there is no function reference surrounding ==> no composite access available
            return null;
        } 
        
        if ((parent instanceof MethodReference)||(parent instanceof ConstructorReference)) {
            // last expression corresponds to argument and we get mapped composite access
        
            if (last_expression != null) {
            
                Object mapped_obj = RecoderToOMMapper.getSingleton().getInstanceFromMapper(last_expression);
                
                if (mapped_obj == null) {
                    return null;
                }
                
                if (mapped_obj instanceof CompositeAccess) {
                    CompositeAccess compositeAccess = (CompositeAccess)mapped_obj;
                    return compositeAccess;
                } else {
                    // other object-types mapped
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public de.fzi.sissy.metamod.Statement findStatement(ProgramElement current_element) {
		/*
		NonTerminalProgramElement parent = reference.getASTParent();
		
		if (parent != null)
		while((parent.getASTParent()!=null)&&!(parent instanceof recoder.java.Statement)) {
			parent = parent.getASTParent();
		}
		
		de.fzi.sissy.metamod.Statement statement_metamod = null;
		if (parent instanceof recoder.java.Statement) {
			statement_metamod = (de.fzi.sissy.metamod.Statement)RecoderToOMMapper.getSingleton().getInstanceFromMapper(parent);
		}
		
		if (statement_metamod == null)
			Debug.warning("Statement for Access could not be found !");
		
		return statement_metamod;
		*/
		
		//ProgramElement current_element = ASTElement_recoder;
		NonTerminalProgramElement parent = null;
		ProgramElement associated_statement_recoder = null;
		ProgramElement orig_elem = current_element;

		parent = current_element.getASTParent();
		// while current program-element is not a statement:
		while ((parent != null)&&(!(parent instanceof StatementContainer))&&(!(parent instanceof FieldSpecification))) {
			current_element = parent;
			parent = current_element.getASTParent();
		}
						
		if (parent == null) {
			if ((current_element instanceof Statement)||(current_element instanceof Case)) {		
				associated_statement_recoder = (ProgramElement) current_element;
			} else {
				Debug.warning("AccessBuilder: Parent was null and Current Element was not a Statement");	
				return null;
			}
        } else if (parent instanceof EnumConstantSpecification){
            return null; 
        } else if (parent instanceof FieldSpecification) {
			current_element = ((FieldSpecification)parent).getInitializer();
			associated_statement_recoder = (ProgramElement) current_element;
		} else {
			if ((current_element instanceof Statement)||(current_element instanceof Case)) {		
				associated_statement_recoder = (ProgramElement) current_element;
			} else {
				if ((parent instanceof Statement)||(parent instanceof Case)) {
					associated_statement_recoder = (ProgramElement) parent;
				} else {
					Debug.warning("AccessBuilder: CurrentElement "+ current_element.getClass().getName()+" not Statement, Parent not Statement " + parent.getClass().getName());	
					return null;
				}
			}
		}

        if (associated_statement_recoder == null) {
            Debug.warning("AccessBuilder: associated_statement_recoder was null!"); 
            return null;
        }
        
		//Debug.info("associated recoder-statement: "+ associated_statement_recoder.getClass().getName());
		Object mapped_object = RecoderToOMMapper.getSingleton().getInstanceFromMapper(associated_statement_recoder);
        
        de.fzi.sissy.metamod.Statement statement_metamod = null;
        if (mapped_object instanceof de.fzi.sissy.metamod.Statement)
            statement_metamod = (de.fzi.sissy.metamod.Statement)mapped_object;
        else {
            Debug.warning("AccessBuilder: mapped object to recoder-statement was not metamod-statement-instance!"); 
            return null;
        }
		
		if (statement_metamod == null) {
			Debug.warning("AccesBuilder: Associated Statement: "+associated_statement_recoder.getClass());	
		}
		return statement_metamod;
	}
	
}

