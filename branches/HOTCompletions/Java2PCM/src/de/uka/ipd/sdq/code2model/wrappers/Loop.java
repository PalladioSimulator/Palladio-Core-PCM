package de.uka.ipd.sdq.code2model.wrappers;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.WhileStatement;

import de.uka.ipd.sdq.code2model.analysis.VariableExpressionTracer;
import de.uka.ipd.sdq.code2model.astvisitors.AbstractASTVisitor;

/**
 * Encapsulates a loop, along with the analysis of whether it is an iteration
 * over a collection.
 * 
 * @author thomas
 */
public class Loop {

	/**
	 * @author thomas
	 *
	 */
	public class IteratorCheckVisitor extends AbstractASTVisitor {
		private String collectionExpression = null;
		protected String getCollection() {
			return collectionExpression;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.MethodInvocation)
		 */
		@Override
		public boolean visit(MethodInvocation node) {
			Expression exp = node.getExpression();
			if (exp instanceof SimpleName) {
				SimpleName objectName = (SimpleName) exp;
				ITypeBinding typeBinding = objectName.resolveTypeBinding();
				if (isIterator(typeBinding)) {
					IBinding iteratorBinding = objectName.resolveBinding();
					collectionExpression = getCollectionVariableFromIterator(iteratorBinding);
					return skipChildren;
				}
			}
			return visitChildren;
		}

		/**
		 * Check if a type binding is of an iterator.
		 * 
		 * @param b
		 *            the binding to check
		 * @return true if it is an iterator, false otherwise
		 */
		private boolean isIterator(ITypeBinding b) {
			String objectType = b.getName();
			if (b.isParameterizedType()) {
				objectType = objectType.substring(0, objectType.indexOf("<"));
			}
			if (objectType.equals("Iterator")) {
				return true;
			}
			return false;
		}

		/**
		 * Get the variable holding the collection from a loop using an
		 * {@link Iterator}.
		 * 
		 * @param iterator
		 *            the binding of the iterator
		 * @return the collection variable
		 */
		private String getCollectionVariableFromIterator(IBinding iterator) {
			Expression initExp = tracer.getVariableContent(iterator);
			if ((initExp != null) && (initExp instanceof MethodInvocation)) {
				MethodInvocation initInvocation = (MethodInvocation) initExp;
				Expression initInvocationExp = initInvocation.getExpression();
				if (initInvocationExp instanceof SimpleName) {
					SimpleName collectionName = (SimpleName) initInvocationExp;
					// It could have been changed in loopExp by the
					// VariableExpressionTracer, check that.
					logger.debug("Expanding " + collectionName.getIdentifier() + "in IteratorCheckVisitor.");
					String collection = tracer.expandExpression(collectionName);
					return collection;
				}
			}
			return null;
		}
		
	}

	/**
	 * @author thomas
	 *
	 */
	public class ForStatementVisitor extends AbstractASTVisitor {
		private String collectionExpression;
		
		private boolean forIsIt_initializerIsZero = false;
		private boolean forIsIt_initVarIsUsedInComparison = false;
		private boolean forIsIt_operatorIsLessThan = false;
		private boolean forIsIt_updaterIsPlusplus = false;
		
		private boolean infixVisited = false;
		private boolean varDeclVisited = false;
		
		private VariableDeclarationFragment initializerDeclaration;
		
		/**
		 * Check if this for loop is an iteration over a collection or array.
		 * The result depends on
		 * {@link #initializerIsZero(VariableDeclarationFragment)},
		 * {@link #initVarIsUsedInComparison(VariableDeclarationFragment, InfixExpression)},
		 * {@link #operandIsIterationVariable(Expression)} and
		 * {@link #operatorIsLessThan(InfixExpression)}, which must all yield
		 * true.
		 * 
		 * @return true if the loop is an iteration, false otherwise
		 */
		private boolean isIteration() {
			return (forIsIt_initializerIsZero
					&& forIsIt_initVarIsUsedInComparison
					&& forIsIt_operatorIsLessThan
					&& forIsIt_updaterIsPlusplus);
		}
		
		/**
		 * Get the collection over which this loop iterates.
		 * <p>
		 * This assumes that it actually does iterate over a collection or an
		 * array and that this was recognized by the analysis. If this is not
		 * the case, the method will yield <code>null</code>. This can be
		 * checked beforehand by {@link #isIteration()}.
		 * </p>
		 * 
		 * @return the collection
		 */
		protected String getCollection() {
			return collectionExpression;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.InfixExpression)
		 */
		@Override
		public boolean visit(InfixExpression node) {
			if (infixVisited) {
				return skipChildren;
			}
			if (forIsIt_initializerIsZero) {
				forIsIt_initVarIsUsedInComparison = initVarIsUsedInComparison(
						initializerDeclaration, node);
				forIsIt_operatorIsLessThan = operatorIsLessThan(node);
			}
			infixVisited = true;
			return skipChildren;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.VariableDeclarationFragment)
		 */
		@Override
		public boolean visit(VariableDeclarationFragment node) {
			if (varDeclVisited) {
				return skipChildren;
			}
			initializerDeclaration = node;
			forIsIt_initializerIsZero = initializerIsZero(node);
			varDeclVisited = true;
			return skipChildren;
		}

		/**
		 * Get the variable holding the collection from a standard for loop.
		 * This involves checking if the loop iterates over a collection at all,
		 * by checking if the pattern <code>i=0; i<VAR; i++</code> or similar
		 * is present.
		 * 
		 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.ForStatement)
		 */
		@Override
		public void endVisit(ForStatement node) {
			forIsIt_updaterIsPlusplus = updaterIsPlusplus(node);

			if (isIteration()) {
				Name collectionName = null;
				collectionName = findCollectionName(node);

				if (collectionName != null) {
					collectionExpression = tracer
							.expandExpression(collectionName);
				}
			}
		}

		/**
		 * Find the name of the collection or array that is iterated over by
		 * this loop.
		 * <p>
		 * Method contract:
		 * <ol>
		 * <li>The loop was checked to be such an iteration ({@link #isIteration()})</li>
		 * <li>The termination expression is an {@link InfixExpression}.
		 * Should be a consequence of 1.</li>
		 * </ol>
		 * </p>
		 * 
		 * @param node the for loop statement
		 * @return the Name of the collection or array
		 */
		private Name findCollectionName(ForStatement node) {
			Name collectionName = null;
			InfixExpression comparison = (InfixExpression) node.getExpression();

			Expression collectionExp = comparison.getLeftOperand();
			if (operandIsIterationVariable(collectionExp)) {
				collectionExp = comparison.getRightOperand();
			}

			// We consider two common cases: coll.size() and
			// array.length.
			if (collectionExp instanceof MethodInvocation) {
				MethodInvocation inv = (MethodInvocation) collectionExp;
				Expression invExp = inv.getExpression();
				if (invExp instanceof SimpleName) {
					collectionName = (SimpleName) invExp;
				}
			} else if (collectionExp instanceof QualifiedName) {
				QualifiedName lengthExp = (QualifiedName) collectionExp;
				String qualifier = lengthExp.getName().toString();
				if (qualifier.equals("length")) {
					collectionName = lengthExp.getQualifier();
				}
			}

			return collectionName;
		}

		/**
		 * Check if the variable in the initializer expression is set to zero
		 * and not to another value. The other checks are based on this
		 * assumption.
		 * 
		 * @param node
		 *            the variable declaration of the initializer
		 * @return true if the loop variable is set to zero, false otherwise
		 */
		private boolean initializerIsZero(VariableDeclarationFragment node) {
			Expression initializer = node.getInitializer();
			if (initializer instanceof NumberLiteral) {
				NumberLiteral initNumber = (NumberLiteral) initializer;
				if (initNumber.getToken().equals("0")) {
					return true;
				}
			}
			return false;
		}

		/**
		 * One of the checks for the pattern <code>i=0; i<VAR; i++</code>:
		 * is the initialized variable used as-is in the comparison? This
		 * excludes cases where a programmer tried to be fancy, like
		 * <code>i=0; foo(i)<VAR; i++</code>.
		 * 
		 * @param initializerDeclaration
		 *            the variable declaration from the initializer part (<code>int i=0</code>)
		 * @param exp
		 *            the comparison expression (<code>i<VAR</code>)
		 * @return true if the variables are identical, false otherwise
		 */
		private boolean initVarIsUsedInComparison(
				VariableDeclarationFragment initializerDeclaration,
				InfixExpression exp) {
			Expression left = exp.getLeftOperand();
			Expression right = exp.getRightOperand();
			SimpleName expVarName;
			if (left instanceof SimpleName) {
				expVarName = (SimpleName) left;
			} else if (right instanceof SimpleName) {
				expVarName = (SimpleName) right;
			} else {
				return false;
			}
			IBinding expressionVar = expVarName.resolveBinding();
			IBinding initVar = initializerDeclaration.getName().resolveBinding();
			if (expressionVar.equals(initVar)) {
				return true;
			}
			return false;
		}

		/**
		 * One of the checks for the pattern <code>i=0; i<VAR; i++</code>:
		 * Is the comparison operator in the termination expression
		 * <code>&lt;</code> or <code>&lt;=</code>.
		 * 
		 * @param node
		 *            the termination check, an infix expression
		 * @return true if the operator is <code>&lt;</code> or
		 *         <code>&lt;=</code>, false otherwise
		 */
		private boolean operatorIsLessThan(InfixExpression node) {
			// matches <= also
			String operator = node.getOperator().toString(); 
			return operator.substring(0, 1).equals("<");
		}

		/**
		 * One of the checks for the pattern <code>i=0; i<VAR; i++</code>:
		 * Is one of the operands of the termination check is the variable
		 * from the initializer. Should always be the case, but it is not
		 * required.
		 * 
		 * @param operandExp
		 *            the termination expression (like <code>i < x</code>)
		 * @return true if the initializer variable is used, false otherwise
		 */
		private boolean operandIsIterationVariable(Expression operandExp) {
			if (operandExp instanceof SimpleName) {
				IBinding operand = ((SimpleName) operandExp).resolveBinding();
				IBinding initializerVariable = initializerDeclaration.getName()
						.resolveBinding();
				if (operand.equals(initializerVariable)) {
					return true;
				}
			}
			return false;
		}

		/**
		 * Check if the increment operator of the for loop is <code>++</code>
		 * (leading or tailing).
		 * 
		 * @param node
		 *            the loop statement to check
		 * @return true if the updater is <code>++</code>, false otherwise
		 */
		private boolean updaterIsPlusplus(ForStatement node) {
			String updater = ((Expression) node.updaters().get(0)).toString();
			String loopVarName = initializerDeclaration.getName().toString();
			if (updater.matches("\\+\\+" + loopVarName)
					|| updater.matches(loopVarName + "\\+\\+")) {
				return true;
			}
			return false;
		}

	}


	private Statement statement;
	private VariableExpressionTracer tracer;
	
	private boolean isCollectionIteration = true;
	private Expression loopExpression = null;
	private String loopExpressionStr = null;
	private static Logger logger;

	public Loop(Statement loopStatement, VariableExpressionTracer tracer) {
		this.statement = loopStatement;
		this.tracer = tracer;
		logger = Logger.getLogger(this.getClass());
	}
	
	/**
	 * Check if this loop is an iteration over a collection (or array). 
	 * 
	 * @return true if it is a collection iteration, false otherwise
	 */
	public boolean isCollectionIteration() {
		if (loopExpressionStr == null) {
			getAndAnalyseExpression();
		}
		if (isCollectionIteration) {
			logger.info(loopExpressionStr + " is a collection iteration.");
		} else {
			logger.info(loopExpressionStr + " is no collection iteration.");
		}
		return isCollectionIteration;
	}

	/**
	 * Get the loop expression.
	 * <p>
	 * If it is an iteration over a collection (check with
	 * {@link #isCollectionIteration()}), the expression is the name of the
	 * collection variable. If not, it is the complete loop expression.
	 * </p>
	 * <p>
	 * Replacements of parameter tracing and transformation to Stochastic
	 * Expressions are performed.
	 * </p>
	 * 
	 * @return the loopExpression
	 */
	public String getLoopExpression() {
		if (loopExpressionStr == null) {
			getAndAnalyseExpression();
		}
		return loopExpressionStr;
	}


	/**
	 * Get the loop expression, and do the complete analysis before.
	 * <p>
	 * If the loop is not an iteration over a collection,
	 * {@link #isCollectionIteration} is set to false.
	 * </p>
	 */
	private void getAndAnalyseExpression() {
		loopExpression = getLoopExpression(statement);

		if (statement instanceof EnhancedForStatement) {
			logger.debug("Expanding " + loopExpression.toString());
			loopExpressionStr = tracer.expandExpression(loopExpression);
		} else {
			loopExpressionStr = getCollectionVariableForIteration();
		}

		if (loopExpressionStr == null && statement instanceof ForStatement) {
			loopExpressionStr = getCollectionVariableForClassicForIteration();
		}
		
		if (loopExpressionStr == null) {
			isCollectionIteration = false;
			logger.debug("Expanding " + loopExpression.toString());
			loopExpressionStr = tracer.expandExpression(loopExpression);
		} else {
			isCollectionIteration = true;
		}

	}

	/**
	 * Get the {@link Expression} of the loop.
	 * 
	 * @param loopStatement
	 *            the loop {@link Statement} to get the expression from
	 * @return the Expression
	 */
	private Expression getLoopExpression(Statement loopStatement) {
		// It's not important really what kind of loop it is, but
		// getExpression() cannot be called on all Statements, so we must cast,
		// and there is no common class for loops.
		Expression loopExpression = null;
		if (loopStatement instanceof ForStatement) {
			ForStatement statement = (ForStatement) loopStatement;
			loopExpression = statement.getExpression();
		} else if (loopStatement instanceof DoStatement) {
			DoStatement statement = (DoStatement) loopStatement;
			loopExpression = statement.getExpression();
		} else if (loopStatement instanceof WhileStatement) {
			WhileStatement statement = (WhileStatement) loopStatement;
			loopExpression = statement.getExpression();
		} else if (loopStatement instanceof EnhancedForStatement) {
			EnhancedForStatement statement = (EnhancedForStatement) loopStatement;
			loopExpression = statement.getExpression();
		}
		return loopExpression;
	}
	
	/**
	 * For the loop statement {@link #statement}, get the collection that is
	 * iterated upon.
	 * <p>
	 * It is of course possible that this loop is no iteration using an
	 * Iterator, then <code>null</code> is returned. Client code has to check.
	 * </p>
	 * 
	 * @return the name of the collection, or null if the loop is no iteration
	 */
	private String getCollectionVariableForIteration() {
		IteratorCheckVisitor iteratorVisitor = new IteratorCheckVisitor();
		statement.accept(iteratorVisitor);
		logger.debug("Got iterator exp from loop: " + iteratorVisitor.getCollection());
		return iteratorVisitor.getCollection();
	}

	/**
	 * For the loop statement {@link #statement}, get the collection that is
	 * iterated upon, in case this is a "classic" for iteration:
	 * <code>i=0; i<VAR; i++</code>.
	 * <p>
	 * It is of course possible that this loop is no such iteration, then
	 * <code>null</code> is returned. Client code has to check.
	 * </p>
	 * 
	 * @return the name of the collection, or null if the loop is no iteration
	 */
	private String getCollectionVariableForClassicForIteration() {
		ForStatementVisitor forVisitor = new ForStatementVisitor();
		statement.accept(forVisitor);
		String collection = forVisitor.getCollection();
		logger.debug("Got collection exp from classic for: " + collection);
		return collection;
	}

}
