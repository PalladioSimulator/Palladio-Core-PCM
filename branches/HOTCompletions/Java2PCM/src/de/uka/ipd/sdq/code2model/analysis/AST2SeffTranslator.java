package de.uka.ipd.sdq.code2model.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.IPackageBinding;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jface.preference.IPreferenceStore;

import de.uka.ipd.sdq.code2model.Activator;
import de.uka.ipd.sdq.code2model.astvisitors.AnalysingASTVisitor;
import de.uka.ipd.sdq.code2model.pcm.SeffBuilder;
import de.uka.ipd.sdq.code2model.pcm.StoexGenerator;
import de.uka.ipd.sdq.code2model.preferences.Code2ModelPreferences;
import de.uka.ipd.sdq.code2model.wrappers.Loop;
import de.uka.ipd.sdq.code2model.wrappers.Method;

/**
 * Translates the JDT objects found while parsing the AST for the SeffBuilder.
 * <p>
 * Decouples the {@link SeffBuilder} from the {@link AnalysingASTVisitor},
 * and is responsible for logging the expressions associated to variables via a
 * {@link VariableExpressionTracer}.
 * </p>
 * 
 * @author thomas
 */
public class AST2SeffTranslator {

	private SeffBuilder builder;
	protected VariableExpressionTracer tracer;
	private StoexGenerator stoexGenerator;

	private Stack<SwitchCase> firstSwitchCases;
	private Stack<String> switchConditionLHS;
	private String lastSwitchCond;
	private Logger logger;

	private static final String RECURSIVE_CALL = "Recursive call: ";
	private static final String IRRELEVANT_CONTROLFLOW_STATEMENT = "Code considered irrelevant: ";

	public AST2SeffTranslator(SeffBuilder builder) {
		this.tracer = new VariableExpressionTracer();
		this.stoexGenerator = new StoexGenerator();
		this.builder = builder;
		this.logger = Logger.getLogger(this.getClass());

		this.switchConditionLHS = new Stack<String>();
		this.firstSwitchCases = new Stack<SwitchCase>();
	}

	/**
	 * Record a variable assignment, for tracing parameter influence.
	 * 
	 * @param assignment
	 *            the variable assignment
	 */
	public void assignment(Assignment assignment) {
		Expression lhs = assignment.getLeftHandSide();
		if (lhs instanceof SimpleName) {
			SimpleName varName = (SimpleName) lhs;
			IBinding varBinding = varName.resolveBinding();
			Expression rhs = assignment.getRightHandSide();
			tracer.updateVariable(varBinding, rhs);
		}
	}

	/**
	 * Record a new variable declaration for tracing parameter influence.
	 * 
	 * @param declFragment
	 *            the variable declaration
	 */
	public void variableDeclaration(VariableDeclarationFragment declFragment) {
		Expression initExp = declFragment.getInitializer();
		if (initExp != null) {
			SimpleName varName = declFragment.getName();
			IBinding varBinding = varName.resolveBinding();
			tracer.updateVariable(varBinding, initExp);
		}
	}

	/**
	 * Handle a method invocation that is inlined in the RDSEFF.
	 * 
	 * @param params
	 *            the method's formal parameters, a list of
	 *            {@link SingleVariableDeclaration}
	 * @param args
	 *            the parameter's actual arguments, a list of {@link Expression}
	 * @throws Exception
	 */
	public void inlinedMethod(List<SingleVariableDeclaration> params,
			List<Expression> args) throws Exception {
		int numParams = params.size();
		if (numParams != args.size()) {
			throw new Exception(
					"Number of parameters does not equal number of arguments!");
		}
		// Record each parameter in the tracer.
		for (int i = 0; i < numParams; i++) {
			SingleVariableDeclaration param = params.get(i);
			SimpleName varName = param.getName();
			IBinding varBinding = varName.resolveBinding();
			Expression argExp = args.get(i);
			tracer.updateVariable(varBinding, argExp);
		}
	}

	/**
	 * Handle a branch transition in SEFF building.
	 * 
	 * @param ifStatement
	 *            the if statement
	 * @param isElseBranch
	 *            is it the else branch of the statement
	 */
	public void branchTransition(IfStatement ifStatement, boolean isElseBranch) {
		Expression conditionalExpression = ifStatement.getExpression();
		String conditional = findServiceParamsInExpression(conditionalExpression);
		conditional = stoexGenerator.performGeneralReplacements(conditional);
		this.builder.branchTransition(conditional, isElseBranch);
	}

	/**
	 * End a branch transition.
	 */
	public void endBranchTransition() {
		this.builder.endBranchTransition();
	}

	/**
	 * Check an {@link Expression} for service parameters influencing its
	 * evaluation.
	 * 
	 * @param exp
	 *            the {@link Expression} to check
	 * @return a String with the conditional and its contained service
	 *         parameters
	 */
	private String findServiceParamsInExpression(Expression exp) {
		return this.tracer.expandExpression(exp);
	}

	/**
	 * Start new method, i.e., a new service.
	 * <p>
	 * This resets the associated {@link VariableExpressionTracer}.
	 * </p>
	 * 
	 * @param decl
	 *            the declared method
	 * @param definingType
	 *            the interface defining this method, or <code>null</code> if
	 *            it is defined by the class itself
	 */
	public void methodDeclaration(MethodDeclaration decl) {
		this.tracer.newService(decl.parameters());
		this.stoexGenerator.newService(decl.parameters());

		Method declaredMethod = new Method(decl);
		builder.addSignature(declaredMethod);
		builder.methodDeclaration(declaredMethod);
	}

	/**
	 * End a method declaration.
	 */
	public void endMethodDeclaration() {
		this.builder.endBehaviour();
	}

	/**
	 * Take approprate action to handle a recursive method call in the RDSEFF.
	 * 
	 * @param binding
	 *            the binding of the method called recursively
	 */
	public void recursiveCall(IMethodBinding binding) {
		this.builder.internalAction(RECURSIVE_CALL + binding.toString());
	}

	/**
	 * Handle a loop statement in the code.
	 * 
	 * @param loopStatement
	 *            a loop to build into the RDSEFF
	 */
	public void loopStatement(Statement loopStatement) {
		Loop loop = new Loop(loopStatement, this.tracer);

		String loopExpression = loop.getLoopExpression();
		if (loop.isCollectionIteration()) {
			this.builder.collectionIterator(loopExpression);
		} else {
			loopExpression = this.stoexGenerator
					.performGeneralReplacements(loopExpression);
			this.builder.loopStatement(loopExpression);
		}
	}

	/**
	 * End a loop.
	 */
	public void endLoop() {
		this.builder.endBehaviour();
	}

	/**
	 * If the user requested it via the preferences, create an
	 * internal action for a block considered not relevant.
	 * 
	 * @param node
	 *            the AST node deemed irrelevant
	 */
	public void irrelevantStatement(ASTNode node) {
		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
		boolean makeInternal = prefs
				.getBoolean(Code2ModelPreferences.alwaysInternalAction);
		if (makeInternal) {
			String codeExcerpt = node.toString();
			if (codeExcerpt.length() > 40) {
				codeExcerpt = codeExcerpt.substring(0, 40) + " ...";
			}
			this.builder
					.internalAction(IRRELEVANT_CONTROLFLOW_STATEMENT + codeExcerpt);
		}
	}

	/**
	 * Record an if statement.
	 */
	public void ifStatement(IfStatement statement) {
		this.builder.ifStatement(statement.toString());
	}

	/**
	 * End an if statement.
	 */
	public void endIfStatement() {
		this.builder.endIfStatement();
	}

	/**
	 * Start a fork.
	 */
	public void fork() {
		this.builder.fork();
	}

	/**
	 * End a fork.
	 */
	public void endFork() {
		this.builder.endBehaviour();
	}

	/**
	 * Register a break statement.
	 */
	public void breakStatement() {
		this.lastSwitchCond = "";
	}

	/**
	 * Handle an external service call.
	 * 
	 * @param externalInvocation
	 *            the service invocation
	 * @param callingClassName 
	 */
	public void externalCall(IMethodBinding externalInvocation, 
			Expression invocationExp, String callingClassName) {
		Set<String> influencingParams = 
				this.tracer.getInfluencingParameters(invocationExp);
		
		Method calledMethod = new Method(externalInvocation);
		this.builder.externalCall(calledMethod, influencingParams, callingClassName);
	}

	/**
	 * Handle an internal method invocation.
	 * 
	 * @param internalInvocation
	 *            the method invocation
	 */
	public void internalAction(MethodInvocation internalInvocation) {
		List<Expression> args = internalInvocation.arguments();
		List<String> argsStr = new ArrayList<String>();
		for (Expression e : args) {
			argsStr.add(e.toString());
		}
		// String description = internalInvocation.toString();
		IPackageBinding packageBinding = internalInvocation
				.resolveMethodBinding().getDeclaringClass().getPackage();
		String pkg = packageBinding.getName();
		String methodName = internalInvocation.getName().toString();

		this.builder.internalAction(argsStr, pkg, methodName);
	}

	/**
	 * Register a new switch case.
	 * 
	 * @param switchCase
	 *            the switch case
	 */
	public void switchCase(SwitchCase switchCase) {
		// If this is *not* the first case of a switch statement, end the
		// previous one.
		SwitchCase firstCaseOfStatement = this.firstSwitchCases.peek();
		if (!switchCase.equals(firstCaseOfStatement)) {
			this.builder.endSwitchCase();
		}

		String condition;
		String switchCondLHS = this.switchConditionLHS.peek();
		Expression caseExp = switchCase.getExpression();
		// null is the default case
		if (caseExp != null) {
			String condRHS = caseExp.toString();
			condition = "(" + switchCondLHS + " == " + condRHS + ")";
		} else {
			condition = "(default case for " + switchCondLHS + ")";
		}
		// If there is a previous case and it wasn't ended with a break, its
		// condition also leads to this case.
		if (!this.lastSwitchCond.equals("")) {
			condition += " OR " + this.lastSwitchCond;
		}

		this.lastSwitchCond = condition;
		this.builder.switchCase(condition);
	}

	/**
	 * Handle a new switch statement.
	 * 
	 * @param switchStatement
	 *            the switch statement
	 */
	public void switchStatement(SwitchStatement switchStatement) {
		// Record the first switch case, it's needed in switchCase().
		List<Statement> statements = switchStatement.statements();
		for (Object o : statements) {
			if (o instanceof SwitchCase) {
				SwitchCase firstCase = (SwitchCase) o;
				this.firstSwitchCases.push(firstCase);
				break;
			}
		}

		this.lastSwitchCond = "";

		String curSwitchCondLHS = switchStatement.getExpression().toString();
		this.switchConditionLHS.push(curSwitchCondLHS);

		this.builder.switchStatement(switchStatement.toString());
	}

	/**
	 * End the current switch statement.
	 */
	public void endSwitchStatement() {
		this.switchConditionLHS.pop();
		this.firstSwitchCases.pop();

		this.builder.endSwitchStatement();
	}

	/**
	 * Record a new type (class or interface) declaration.
	 * <p>
	 * In case it is a class, the {@link SeffBuilder} is instructed to build a
	 * new basic component. In case it's an interface, nothing happens. It it is
	 * implemented by one of the selected classes, it is created in the
	 * repository when handling this class.
	 * </p>
	 * 
	 * @param node
	 *            the type declaration
	 */
	public void typeDeclaration(TypeDeclaration node) {
		if (!node.isInterface()) {
			// The qualified name looks a bit ugly in the PCM Bench, but it's
			// required for unique lookup of components later.
			String className = node.resolveBinding().getQualifiedName();
			this.builder.newComponent(className);
		}
	}

}
