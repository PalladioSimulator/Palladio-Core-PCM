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

import recoder.abstraction.ParameterizedType;
import recoder.abstraction.Type;
import recoder.convenience.TreeWalker;
import recoder.java.Comment;
import recoder.java.NonTerminalProgramElement;
import recoder.java.ProgramElement;
import recoder.java.Statement;
import recoder.java.StatementBlock;
import recoder.java.StatementContainer;
import recoder.java.declaration.ConstructorDeclaration;
import recoder.java.declaration.MethodDeclaration;
import recoder.java.declaration.ParameterDeclaration;
import recoder.java.declaration.VariableSpecification;
import recoder.java.statement.BranchStatement;
import recoder.java.statement.Case;
import recoder.java.statement.Catch;
import recoder.java.statement.Default;
import recoder.java.statement.Else;
import recoder.java.statement.EmptyStatement;
import recoder.java.statement.Finally;
import recoder.java.statement.If;
import recoder.java.statement.JumpStatement;
import recoder.java.statement.LabelJumpStatement;
import recoder.java.statement.LabeledStatement;
import recoder.java.statement.LoopStatement;
import recoder.java.statement.Return;
import recoder.java.statement.Switch;
import recoder.java.statement.SynchronizedBlock;
import recoder.java.statement.Then;
import recoder.java.statement.Throw;
import recoder.java.statement.Try;
import recoder.list.generic.ASTList;
import de.fzi.sissy.metamod.BlockStatement;
import de.fzi.sissy.metamod.CatchBlock;
import de.fzi.sissy.metamod.CatchParameter;
import de.fzi.sissy.metamod.ExceptionHandler;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.util.Debug;

/**
 * @author stammel
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class StatementBuilder extends Builder {

	private static StatementBuilder singleton = null;

	/**
	 *  
	 */
	public StatementBuilder() {
		super();
	}

	public static StatementBuilder getSingleton() {
		if (singleton == null) {
			singleton = new StatementBuilder();
		} //if
		return singleton;
	} //getSingleton

	public void extractFromRecoder(MethodDeclaration methodDeclaration) {
		Debug.info("Create Statement-Hierarchie for "+ methodDeclaration.getFullName());
		
		// get body StatementBlock from MethodDeclaration
		StatementBlock body_block_recoder = methodDeclaration.getBody();
		
		// get metamod-Function-Object
		Function function_metamod = (Function)RecoderToOMMapper.getSingleton().getInstanceFromMapper(methodDeclaration);
		
		generateStatementHierarchie(function_metamod, body_block_recoder);
	}

	public void generateStatementHierarchie(Function function_metamod, StatementBlock body_block_recoder) {
		//First we have to create a Metamod-BlockStatement for the body of this function:
		// create Metamod-Object
		de.fzi.sissy.metamod.BlockStatement body_block_metamod = createBlockStatement(body_block_recoder);
		// establish containment-relation with metamod-function-object:
		function_metamod.setBody(body_block_metamod);

		
		// add lines of comments to function lines of comments
		//setupLinesOfComments(function_metamod, body_block_recoder);
		
		// Now we can walk through Statement-Tree (deapth first)
		TreeWalker walker = new TreeWalker(body_block_recoder);
		
		if (walker.next())
			walker.getProgramElement();

		treewalk:
		while (walker.next()) {
			// get next ProgramElement ...
			ProgramElement element = walker.getProgramElement();
			// ... which is a Statement
			boolean isTrueStatement = false;
			if (element instanceof ProgramElement) {
				ProgramElement statement_recoder = (ProgramElement)element;

				// determine parent of given statement:
				NonTerminalProgramElement parent = (NonTerminalProgramElement) statement_recoder.getASTParent();
				
				// test whether it is a statement or not
				// if parent is a statementContainer ==> it is a true statement !!!
				if (parent instanceof StatementContainer) {
					 isTrueStatement = true;
				}
				
				// get parent-container-object which is mapped to the appropriate metamod-statement-object
				
				/* Example:
				 * 
				 * if (x == 5) {       
				 * 		x = 6;
				 * }
				 * 
				 * recoder-structure:
				 * 
				 * If
				 *  +- Then
				 *       +- StatementBlock
				 *            +- CopyAssignment
				 * 
				 * metamod-structure:
				 * 
				 * BranchStatement
				 *   +- BlockStatement
				 *         +- SimpleStatement  
				 * 
				 * (1) if we get IF we create a BranchStatement
				 * (2) if we get THEN we create nothing
				 * (3) if we get STATEMENTBLOCK with parent-THEN 
				 *        we get parent-IF and mapped BranchStatement from (1)
				 *        and create a BlockStatement and add as Branch to parent-BranchStatement.
				 * (4) if we get CopyAssignment it is recognized as SimpleStatement which is created
				 *     and added to parent-BlockStatement from (3).
				 * 
				 * 
				 */
				
				Try try_parent = null;
				// parent-container for everything under THEN is IF
				if (parent instanceof Then)
					parent = ((Then)parent).getASTParent();
				// parent-container for everything unter ELSE is IF
				if (parent instanceof Else)
					parent = ((Else)parent).getASTParent();
				if (parent instanceof LabeledStatement)
					parent = ((LabeledStatement)parent).getASTParent();
				if (parent instanceof Catch)
					try_parent = (Try)((Catch)parent).getASTParent();
				if (parent instanceof Finally)
					try_parent = (Try)((Finally)parent).getASTParent();
				
				// LoopStatements are special cases: 
				// - a loop-statement has statements in head and body
				// - we only create statements in the body
				// - How can we detect whether a statement is in the body?
				 
				if (parent instanceof LoopStatement) {
					LoopStatement parentLoopStatement = (LoopStatement) parent;
					if (statement_recoder == parentLoopStatement.getBody()) {
						// ok go on and create statements !!
					} else {
						// statement is between head and body
						de.fzi.sissy.metamod.ModelElement parent_metamod = RecoderToOMMapper.getSingleton().getInstanceFromMapper(parent);
						if (parent_metamod==null)
							Debug.warning("LoopStatement: parent_metamod was null!");
						recoderToOMMapping(statement_recoder, parent_metamod);
						continue treewalk;
					}
				} 

				// Synchronized Blocks are special cases: 
				// - we only create statements in the body
				// - How can we detect whether a statement is in the body?
				// - statements between head and body are mapped to 
				//   corresponding blockstatement
				 
				if (parent instanceof SynchronizedBlock) {
					SynchronizedBlock parentSynchronizedBlock = (SynchronizedBlock) parent;
					if (statement_recoder == parentSynchronizedBlock.getBody()) {
						// ok go on and create statements !!
					} else {
						// statement is between head and body
						de.fzi.sissy.metamod.ModelElement parent_metamod = RecoderToOMMapper.getSingleton().getInstanceFromMapper(parent);
						if (parent_metamod==null)
							Debug.warning("SychronizedBlock: parent_metamod was null!");
						recoderToOMMapping(statement_recoder, parent_metamod);
						continue treewalk;
					}
				} 

				
				// create according object
				if (statement_recoder instanceof StatementBlock) {
					//Debug.info("BlockStatement");
					// statement-blocks in try-statements are special treated:
					if (try_parent != null) {
						//get according metamod_object of exception handler;
						ExceptionHandler exceptionHandler_metamod = (ExceptionHandler)RecoderToOMMapper.getSingleton().getInstanceFromMapper(try_parent);
						
						if (parent instanceof Catch){
							CatchBlock blockstatement_metamod = createCatchBlock((StatementBlock)statement_recoder);
							exceptionHandler_metamod.addCatchBlock(blockstatement_metamod);
							// here we create the CatchParameter for ParameterDeclaration of Catch:
							ParameterDeclaration paramDeclaration = ((Catch)parent).getParameterDeclaration();
							
							// get VariableSpecification of Recoder for the CatchParameter
							VariableSpecification variableSpecificationRecoder = paramDeclaration.getVariableSpecification();
							
							Type type_recoder = variableSpecificationRecoder.getType();
                            if (type_recoder instanceof ParameterizedType) 
                                type_recoder = ((ParameterizedType) type_recoder).getGenericType();
                                
                            							
							de.fzi.sissy.metamod.Type type_metamod = (de.fzi.sissy.metamod.Type)
							ClassTypeBuilder.getSingleton().getInstanceFromMapper(type_recoder);

							// create DeclarationTypeAccess for CatchParameter !!
							de.fzi.sissy.metamod.DeclarationTypeAccess dta = new de.fzi.sissy.metamod.DeclarationTypeAccess(type_metamod);
							Common.extractTypeArguments(dta, variableSpecificationRecoder.getType());
                            // Position for dta
							dta.setPosition(FileBuilder.getSingleton().getSourcePosition(variableSpecificationRecoder));

							String simpleName = variableSpecificationRecoder.getName();
							
							// create Metamod-Catch-Parameter-Object
							CatchParameter catchParameter_metamod = new CatchParameter(simpleName);
							
							blockstatement_metamod.addAccess(dta);
							
							// Map VariableSpecification of Recoder to Metamod-CatchParameter
							RecoderToOMMapper.getSingleton().addInstanceToMapper(variableSpecificationRecoder, catchParameter_metamod);
							
							// set catchParameter to catchBlock
							blockstatement_metamod.setCatchParameter(catchParameter_metamod);
							catchParameter_metamod.setTypeDeclaration(dta);
							
						}
						if (parent instanceof Finally) {
							BlockStatement blockstatement_metamod = createBlockStatement((StatementBlock)statement_recoder);
							exceptionHandler_metamod.setFinallyBlock(blockstatement_metamod);
						}
						continue treewalk;
						
					} else if (parent instanceof SynchronizedBlock) {
						// internal statement-block is mapped to
						// block-statement which was created for synchronized block
						// so accesses in synchronized-line are added
						// to according metamod_block_statement
						
						// get BlockStatement for SynchronizedBlock-parent:
						SynchronizedBlock sync_block_recoder = (SynchronizedBlock)parent;
						BlockStatement block_statement_metamod = (BlockStatement) RecoderToOMMapper.getSingleton().getInstanceFromMapper(sync_block_recoder);
						recoderToOMMapping(statement_recoder, block_statement_metamod);
						continue treewalk;
						//Debug.warning("Synchronized Block handled.");
					} else {
						//Debug.info("Map StatementBlock to BlockStatement");
						createBlockStatement((StatementBlock)statement_recoder);
					}
				} else if (statement_recoder instanceof JumpStatement) {
					//Debug.info("JumpStatement");
					de.fzi.sissy.metamod.JumpStatement statement_metamod = createJumpStatement((JumpStatement)statement_recoder);
					
				} else if (statement_recoder instanceof LoopStatement) {
					//Debug.info("LoopStatement");
					createLoopStatement((LoopStatement)statement_recoder);
				} else if (statement_recoder instanceof If) {
					// here we create a BranchStatement 
					//Debug.info("BranchStatement (If)");
					de.fzi.sissy.metamod.BranchStatement metamod_branch = createBranchStatement((If)statement_recoder);
					
					// we have to check if there is an ELSE for this IF
					// if not we have to add an empty-BlockStatement
					// to the corresponding metamod-BranchStatement:
					If recoderIF = (If) statement_recoder;
					if (recoderIF.getElse()==null) {
						BlockStatement emptyBlock_metamod = createBlockStatement(null);
						metamod_branch.addBranch(emptyBlock_metamod);
                        emptyBlock_metamod.setImplicit();
					}
				} else if (statement_recoder instanceof Then) {
					// nothing created here
					// contained statements are directly put into parent-If-BranchStatement
					continue treewalk;
				} else if (statement_recoder instanceof Else) {
					// nothing created here
					// contained statements are directly put into parent-If-BranchStatement
					continue treewalk;
				} else if (statement_recoder instanceof Try) {
					// An ExceptionHandler for Try
					//Debug.info("ExceptionHandler for Try");
					createExceptionHandler((Try)statement_recoder);
					// the body of try is a StatementBlock
				} else if (statement_recoder instanceof Catch) {
					// nothing created, is done for contained StatementBlock
					continue treewalk;
				} else if (statement_recoder instanceof LabeledStatement) {
					// nothing created, is done for contained Statement
					continue treewalk;
				} else if (statement_recoder instanceof Finally) {
					// nothing created, is done for contained StatementBlock
					continue treewalk;
				} else if (statement_recoder instanceof Switch) {
					//Debug.info("BranchStatement (Switch)");
					de.fzi.sissy.metamod.BranchStatement metamod_branch = createBranchStatement((Switch)statement_recoder);
					
					// We have to check if there is a DEFAULT-Branch for this SWITCH
					// if not we have to add an empty-BlockStatement to the 
					// corresponding metamod-BranchStatement:
					
					Switch recoderSWITCH = (Switch) statement_recoder;
					
					boolean hasDefault = false;
					for (int i=0; i<recoderSWITCH.getChildCount(); i++) {
						if (recoderSWITCH.getChildAt(i) instanceof Default)
							hasDefault = true;
					}
					
					if (!hasDefault) {
						BlockStatement emptyBlock_metamod = createBlockStatement(null);
						metamod_branch.addBranch(emptyBlock_metamod);
                        emptyBlock_metamod.setImplicit();
					}
				} else if (statement_recoder instanceof Case) {
					// here we create a BlockStatement 
					// because after Case there can be more than one statement
					// even without {}:
					// we always create a BlockStatement even if it is a fallthrough!
					//Debug.info("Case");
					createBlockStatement((Case)statement_recoder);
				} else if (statement_recoder instanceof Default) {
					// analog to Case:
					//Debug.info("BlockStatement (Default)");
					createBlockStatement((Default)statement_recoder);
				} else if (statement_recoder instanceof EmptyStatement) {
					// For an EmptyStatement we create an empty BlockStatement:
					//Debug.info("BlockStatement (EmptyStatement)");
					createBlockStatement((EmptyStatement)statement_recoder);
				} else if (statement_recoder instanceof SynchronizedBlock) {
					// For an SynchronizedBlock we create a BlockStatement.
					// Internal StatementBlock is handled extra 
					// (mapped on this BlockStatement) (see upwards)
					BlockStatement block_statement_metamod = createBlockStatement((SynchronizedBlock)statement_recoder);
				} else {
					// all other Types of Statements:
					if (!isTrueStatement) {
						//Debug.warning("not true statement: Nothing created for "+ statement_recoder.getClass().getName());
						continue treewalk;
					} else if (!(statement_recoder instanceof Statement)) {
						// nothing created, continue with next program-element:
						//Debug.warning("no recoder-statement: Nothing created for "+ statement_recoder.getClass().getName());
						continue treewalk;
					} else if (RecoderToOMMapper.getSingleton().getInstanceFromMapper(statement_recoder)==null) {
							//Debug.info("SimpleStatement for "+ statement_recoder.getClass().getName());
							createSimpleStatement((Statement)statement_recoder);
					} else {
						//Debug.warning("statement already mapped to something: Nothing created for "+ statement_recoder.getClass().getName());
						continue treewalk;
					}
				}

				// get according metamod-object of this parent:
				de.fzi.sissy.metamod.ModelElement parent_metamod = RecoderToOMMapper.getSingleton().getInstanceFromMapper(parent);
				if (parent_metamod == null) {
					if (parent instanceof ConstructorDeclaration)
						ConstructorBuilder.getSingleton().extractFromRecoder((MethodDeclaration)parent);
					else if (parent instanceof MethodDeclaration)
						MethodBuilder.getSingleton().extractFromRecoder((MethodDeclaration)parent);
				}
				parent_metamod = RecoderToOMMapper.getSingleton().getInstanceFromMapper(parent);				
				
				// get created metamod-object:
				de.fzi.sissy.metamod.Statement created_statement_metamod = (de.fzi.sissy.metamod.Statement)RecoderToOMMapper.getSingleton().getInstanceFromMapper(statement_recoder); 
				
				// add lines of comments to function lines of comments
				setupLinesOfComments(function_metamod, statement_recoder);
					
				// establish containment-relation:
				if (parent_metamod instanceof BlockStatement) {
					((BlockStatement)parent_metamod).addStatement(created_statement_metamod);
				} else if (parent_metamod instanceof de.fzi.sissy.metamod.LoopStatement) {
					((de.fzi.sissy.metamod.LoopStatement)parent_metamod).setBody(created_statement_metamod);
				} else if (parent_metamod instanceof de.fzi.sissy.metamod.BranchStatement) {
					((de.fzi.sissy.metamod.BranchStatement)parent_metamod).addBranch(created_statement_metamod);
				} else if (parent_metamod instanceof de.fzi.sissy.metamod.ExceptionHandler) {
					((de.fzi.sissy.metamod.ExceptionHandler)parent_metamod).setGuardedBlock((BlockStatement)created_statement_metamod);
				} else if ((parent_metamod instanceof Function) && (created_statement_metamod instanceof BlockStatement)) {
					((Function)parent_metamod).setBody((BlockStatement)created_statement_metamod);
				} else {
					// Added by mtrifu
					// TODO [BUG]: mtrifu: In case of syncronized blocks an extra SimpleStatement is created for the target of the synchronization 
					System.out.println("This should not happen");
				}
			}
		}
		
	}

	public void setupLinesOfComments(Function function_metamod, ProgramElement statement_recoder) {
	
		// calculate number of comment lines:
	
		int sumOfCommentLines = 0;
 		if (statement_recoder.getComments()!=null) {
	 		ASTList<Comment> cml = statement_recoder.getComments();
	 		int size = cml.size();
	 		for (int i=0; i<size; i++) {
		 		Comment com = cml.get(i);
		 		String text = com.getText();
		 		StringBuffer sb = new StringBuffer(text);

		 		//zähle zeilenumbrüche im kommentartext
 				int lines = 1;
 				for(int j=0; j<sb.length(); j++) {
	 				int ch = sb.charAt(j);
	 				if (ch == 13)
		 				lines++;
 				}
 				
// 				Debug.info(""+lines); 
		 		sumOfCommentLines +=  lines;
	 		}
 		}

 
 		// add number of comment lines to function:	
 		
 		int currentLinesOfComments = function_metamod.getLinesOfComments();
 		currentLinesOfComments += sumOfCommentLines;
 		function_metamod.setLinesOfComments(currentLinesOfComments);
		
	}



	/**
	 * @param block
	 */
	private BlockStatement createBlockStatement(ProgramElement statement_recoder) {
		
		// create Metamod-Object
		de.fzi.sissy.metamod.BlockStatement statement_metamod = new de.fzi.sissy.metamod.BlockStatement();

		// setup statement:
		if (statement_recoder != null)
			setupStatement(statement_metamod, statement_recoder);


		return statement_metamod;
		
	}

	/**
	 * @param statement
	 */
	private de.fzi.sissy.metamod.JumpStatement createJumpStatement(recoder.java.statement.JumpStatement statement_recoder) {

		// create Metamod-Object
		de.fzi.sissy.metamod.JumpStatement statement_metamod = new de.fzi.sissy.metamod.JumpStatement();
			
		if (statement_recoder instanceof Return) {
			statement_metamod.setReturn();
		} else if (statement_recoder instanceof Throw) {
			statement_metamod.setThrow();
		} else if (statement_recoder instanceof LabelJumpStatement) {
			// Continue + Break
			statement_metamod.setJump();
		}

		// setup statement:
		setupStatement(statement_metamod, statement_recoder);

		return statement_metamod;
	}

	/**
	 * @param statement
	 */
	private de.fzi.sissy.metamod.LoopStatement createLoopStatement(LoopStatement statement_recoder) {
		// Do, For and While

		// create Metamod-Object
		de.fzi.sissy.metamod.LoopStatement statement_metamod = new de.fzi.sissy.metamod.LoopStatement();

		// setup statement:
		setupStatement(statement_metamod, statement_recoder);

		return statement_metamod;
	}

	/**
	 * @param statement
	 */
	private de.fzi.sissy.metamod.BranchStatement createBranchStatement(BranchStatement statement_recoder) {
		// Switch or If

		// create Metamod-Object
		de.fzi.sissy.metamod.BranchStatement statement_metamod = new de.fzi.sissy.metamod.BranchStatement();

		// setup statement:
		setupStatement(statement_metamod, statement_recoder);

		return statement_metamod;
	}

	/**
	 * @param statement
	 */
	private de.fzi.sissy.metamod.ExceptionHandler createExceptionHandler(Try statement_recoder) {
		// Try

		// create Metamod-Object
		de.fzi.sissy.metamod.ExceptionHandler statement_metamod = new de.fzi.sissy.metamod.ExceptionHandler();

		// setup statement:
		setupStatement(statement_metamod, statement_recoder);

		return statement_metamod;
		
	}

	/**
	 * @param statement
	 */
	private de.fzi.sissy.metamod.CatchBlock createCatchBlock(StatementBlock statement_recoder) {
		// CatchBlock

		// create Metamod-Object
		de.fzi.sissy.metamod.CatchBlock statement_metamod = new de.fzi.sissy.metamod.CatchBlock();

		// setup statement:
		setupStatement(statement_metamod, statement_recoder);

		return statement_metamod;
		
	}

	/**
	 * @param statement
	 */
	private de.fzi.sissy.metamod.SimpleStatement createSimpleStatement(Statement statement_recoder) {
		// Try

		// create Metamod-Object
		de.fzi.sissy.metamod.SimpleStatement statement_metamod = new de.fzi.sissy.metamod.SimpleStatement();

		// setup statement:
		setupStatement(statement_metamod, statement_recoder);

		return statement_metamod;
	}
	
	public void setupStatement(de.fzi.sissy.metamod.Statement statement_metamod, ProgramElement statement_recoder) {
		// mapping:
		recoderToOMMapping(statement_recoder, statement_metamod);

		// setup Position:
		statement_metamod.setPosition(FileBuilder.getSingleton().getSourcePosition(statement_recoder));
		
		// TODO Mapping of Filename to statement:
		// We need this Mapping for Clone-Analyses!
		//Debug.info("F2S-Mapping: "+ statement_metamod.getPosition().getSourceFile().getPathName().substring(5));
		//FilenameToStatementMapper.getSingleton().addStatement(statement_metamod.getPosition().getSourceFile().getPathName().substring(5), statement_metamod);
	}
}
