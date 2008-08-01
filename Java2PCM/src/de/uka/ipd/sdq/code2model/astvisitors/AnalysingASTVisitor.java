package de.uka.ipd.sdq.code2model.astvisitors;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;

import de.uka.ipd.sdq.code2model.analysis.AST2SeffTranslator;
import de.uka.ipd.sdq.code2model.analysis.callclassification.ServiceCallClassifier;
import de.uka.ipd.sdq.code2model.pcm.SeffBuilder;
import de.uka.ipd.sdq.code2model.wrappers.Method;

/**
 * Visits the AST of the analyzed source code, checking things for relevancy
 * w.r.t. the performance model and notifies the {@link AST2SeffTranslator}
 * about what it encounters.
 * <p>
 * The AnalysingASTVisitor, the {@link AST2SeffTranslator}, and the
 * {@link SeffBuilder} are the core of the code2model code analysis. The visitor
 * works on the source code side, the builder on the Palladio component model
 * side.
 * </p>
 * <p>
 * {@link ASTVisitor}s implement the "Visitor" design pattern and are accepted
 * by {@link ASTNode}s.
 * </p>
 * <p>
 * The AnalysingASTVisitor is reentrant, that is, it can (and is!) called
 * repeatedly as in <code>accept(this)</code> and must not lose or overwrite
 * information in this case. When introducing new variables, always consider
 * using a Stack instead of a simple variable.
 * </p>
 * 
 * @author thomas
 */
public class AnalysingASTVisitor extends SelectionAwareASTVisitor {

	/**
	 * Maps {@link Thread} objects to the type (as unique {@link ITypeBinding})
	 * they are parameterized with (@see {@link #visit(MethodInvocation)}).
	 */
	private Map<IBinding, ITypeBinding> threadObjectsToTypeBindings = 
			new Hashtable<IBinding, ITypeBinding>();

	/**
	 * When skipping a block because it contains no interesting method calls,
	 * the corresponding endVisit() call has to know that it should skip the
	 * Translator.endFoo() call. As the endVisit() call occurs directly after
	 * the visit() call when the children are skipped, this can be done via a
	 * simple boolean variable.
	 */
	private boolean skip = false;
	
	private Stack<ITypeBinding> currentClasses = new Stack<ITypeBinding>();

	private AST2SeffTranslator translator;

	public AnalysingASTVisitor(AST2SeffTranslator translator,
			ServiceCallClassifier classifier,
			Set<Method> selectedMethodsForUnit)
			throws Exception {
		super(selectedMethodsForUnit, classifier);
		this.translator = translator;
		logger = Logger.getLogger(this.getClass());
	}

	/**
	 * Formats information about the given node in a nice way. For debugging
	 * purposes only.
	 * 
	 * @param node
	 *            the node to examine
	 */
	private String getNodeInfoString(ASTNode node) {
		int MAXLENGTH = 70;
		int type = node.getNodeType();
		String nodeClass = ASTNode.nodeClassForType(type).getSimpleName();
		String info = "Visiting a " + nodeClass + ": ";
		String nodeString = node.toString().replace("\n", " \\n ");
		int length = nodeString.length();
		if (length > MAXLENGTH) {
			info += nodeString.substring(0, MAXLENGTH) + "[...]";
		} else {
			info += nodeString;
		}
		return info;
	}
	
	/**
	 * Start a loop in the {@link SeffBuilder}, if it contains something
	 * relevant.
	 * 
	 * @param loopStatement
	 *            the loop to handle
	 * @return whether to visit its children (i.e. it was deemed relevant), or
	 *         not
	 */
	private boolean startLoop(Statement loopStatement) {
		if (containsRelevantActions(loopStatement)) {
			this.translator.loopStatement(loopStatement);
			return visitChildren;
		}
		this.translator.irrelevantStatement(loopStatement);
		this.skip = true;
		return skipChildren;
	}

	/**
	 * End a loop in the {@link SeffBuilder}.
	 */
	private void endLoop() {
		if (this.skip) {
			this.skip = false;
		} else {
			this.translator.endLoop();
		}
	}

	/**
	 * Checks is a node is relevant, i.e., if its AST contains actions or calls
	 * deemed performance-relevant.
	 * 
	 * @param node
	 *            the node to examine
	 * @return whether it is relevant
	 */
	private boolean containsRelevantActions(ASTNode node) {
		BlockRelevancyCheckingASTVisitor checker = BlockRelevancyCheckingASTVisitor
				.getInstance(this.classifier);
		node.accept(checker);
		return checker.relevant;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#preVisit(org.eclipse.jdt.core.dom.ASTNode)
	 */
	@Override
	public void preVisit(ASTNode arg0) {
		logger.debug(getNodeInfoString(arg0));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.Assignment)
	 */
	@Override
	public boolean visit(Assignment node) {
		this.translator.assignment(node);
		return visitChildren;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.Block)
	 */
	@Override
	public boolean visit(Block node) {
		if (! containsRelevantActions(node)) {
			this.skip = true;
			this.translator.irrelevantStatement(node);
			return skipChildren;
		}
		return visitChildren;
	}

	/* (non-Javadoc) 
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.BreakStatement)
	 */
	@Override
	public boolean visit(BreakStatement arg0) {
		this.translator.breakStatement();
		return visitChildren;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.CatchClause)
	 */
	@Override
	public boolean visit(CatchClause node) {
		return skipChildren;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.ClassInstanceCreation)
	 */
	@Override
	public boolean visit(ClassInstanceCreation node) {
		if (node.getAnonymousClassDeclaration() != null) {
			return skipChildren;
		}
		
		IMethodBinding mBinding = node.resolveConstructorBinding();
		int distance = classifyMethod(mBinding);
		if (distance == ServiceCallClassifier.EXTERNAL_PACKAGE) {
			notifyExternalCall(mBinding, node);
		}
		return visitChildren;
	}

	/* (non-Javadoc) 
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.DoStatement)
	 */
	@Override
	public boolean visit(DoStatement arg0) {
		return startLoop(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.EnhancedForStatement)
	 */
	@Override
	public boolean visit(EnhancedForStatement arg0) {
		return startLoop(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.ForStatement)
	 */
	@Override
	public boolean visit(ForStatement arg0) {
		// Register the variable declared in the initializer expression, if any,
		// with the VariableExpressionTracer. That's important if the variable
		// is an iterator, for finding out the collection on which it iterates.
		Expression initExp = (Expression) arg0.initializers().get(0);
		if (initExp instanceof VariableDeclarationExpression) {
			VariableDeclarationExpression initDecl = (VariableDeclarationExpression) initExp;
			VariableDeclarationFragment fragment = (VariableDeclarationFragment) initDecl
					.fragments().get(0);
			fragment.accept(this);
		}

		return startLoop(arg0);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.IfStatement)
	 */
	@Override
	public boolean visit(IfStatement arg0) {
		ifCondition(arg0);

		handleIfBranches(arg0);

		return skipChildren;
	}

	/**
	 * Handle the condition of an if statement by checking for relevancy, and in
	 * that case creating the RDSEFF constructs.
	 * 
	 * @param arg0
	 *            the {@link IfStatement}
	 */
	private void ifCondition(IfStatement arg0) {
		Expression condExp = arg0.getExpression();
		if (containsRelevantActions(condExp)) {
			condExp.accept(this);
		}
	}

	/**
	 * Check the two branches of an if statement (then and else) for relevancy
	 * and further parse the relevant ones.
	 * 
	 * @param ifStatement
	 *            the {@link IfStatement}
	 */
	@SuppressWarnings("null")
	private void handleIfBranches(IfStatement ifStatement) {
		Statement thenBranch = ifStatement.getThenStatement();
		Statement elseBranch = ifStatement.getElseStatement();

		// Check
		boolean thenIsRelevant = containsRelevantActions(thenBranch);
		boolean elseIsRelevant = (elseBranch != null) && containsRelevantActions(elseBranch);

		if (!thenIsRelevant && !elseIsRelevant) {
			this.translator.irrelevantStatement(ifStatement);
			this.skip = true;
			return;
		}

		this.translator.ifStatement(ifStatement);

		if (thenIsRelevant) {
			this.translator.branchTransition(ifStatement, false);
			thenBranch.accept(this);
			this.translator.endBranchTransition();
		} else {
			this.translator.irrelevantStatement(thenBranch);
		}
		
		// TODO Create at least two transitions in any case, required by PCM.
		if (elseIsRelevant) {
			this.translator.branchTransition(ifStatement, true);
			elseBranch.accept(this);
			this.translator.endBranchTransition();
		} else if (elseBranch != null) {
			this.translator.irrelevantStatement(elseBranch);
		}

		this.translator.endIfStatement();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.Initializer)
	 * 
	 * TODO don't know currently what to do with them.
	 */
	@Override
	public boolean visit(Initializer node) {
//		if (containsRelevantActions(node)) {
//			this.translator.initializer(this.className.toString());
//		}
		return skipChildren;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.MethodDeclaration)
	 */
	@Override
	public boolean visit(MethodDeclaration arg0) {
		// We only build RDSEFFs for public methods (i.e. provided services).
		if (methodIsRelevant(arg0)) {
			logger.info("Method " + arg0.getName() + " is relevant.");
			// monitor.subTask("Method " + arg0.getName());
			// TODO: empty RDSEFFs yes or no?
			//if (containsRelevantActions(arg0)) {
			logger.info("Method " + arg0.getName() + " has interesting actions.");
			this.currentMethods.push(arg0.resolveBinding());

			this.translator.methodDeclaration(arg0);
			return visitChildren;
			//}
		}

		// If we arrive here, the method is not interesting.
		this.skip = true;
		return skipChildren;
	}

	/** 
	 * TODO: nested method calls. Call arg0.arguments() and check.
	 * 
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.MethodInvocation)
	 */
	@Override
	public boolean visit(MethodInvocation arg0) {
		IMethodBinding mBinding = arg0.resolveMethodBinding();
		int distance = classifyMethod(mBinding);
		switch (distance) {
		case ServiceCallClassifier.IGNORE:
			return visitChildren;
		case ServiceCallClassifier.EXTERNAL_PACKAGE:
			notifyExternalCall(mBinding, arg0);
			return visitChildren;
		case ServiceCallClassifier.JAVA_WANTED:
			this.translator.internalAction(arg0);
			return visitChildren;
		case ServiceCallClassifier.SAME_PACKAGE:
			logger.info("Inlining " + arg0);
			inlineMethod(mBinding, arg0.arguments());
			break;
		case ServiceCallClassifier.THREAD_INVOCATION:
			fork(arg0);
			break;
		default:
			break;
		}

		return visitChildren;
	}

	/**
	 * Handles a method invocation that is the start of a thread.
	 * <p>
	 * The thread code, i.e. the run() method, has to be inlined at this point
	 * in the source code (inside a ForkAction). run()s binding is looked up by
	 * {@link AnalysingASTVisitor#getRunBindingForThreadObject(SimpleName)}.
	 * </p>
	 * 
	 * @param arg0
	 *            the {@link MethodInvocation}
	 * @throws Exception
	 */
	private void fork(MethodInvocation arg0) {
		this.translator.fork();

		// We need the thread class (extending Thread or implementing
		// Runnable) with which the java.lang.Thread was initialized with
		// at creation.
		Expression invocationExp = arg0.getExpression();
		if (invocationExp instanceof SimpleName) { // e.g. foo.start()
			SimpleName invocationVarName = (SimpleName) invocationExp;
			IMethodBinding runBinding = getRunBindingForThreadObject(invocationVarName);
			if (runBinding != null) {
				inlineMethod(runBinding, arg0.arguments());
			} else {
				// No exceptions in visit() allowed.
				logger.warn("Could not resolve binding of the "
						+ "run() method for " + arg0.toString());
				/*
				 * Exception e = new Exception("Could not resolve binding of the " +
				 * "run() method for " + arg0.toString()); throw(e);
				 */
			}
		} else {
			// That's the pathological case "new Thread(bar).start()". Don't
			// know if this can even occur, because then there is no Thread
			// object on which to join() etc.
			logger.warn("java.lang.Thread.start() not "
					+ "invoked on object as expected in expression "
					+ invocationExp.toString());
			/*
			 * Exception e = new Exception("java.lang.Thread.start() not " +
			 * "invoked on object as expected."); throw(e);
			 */
		}
		this.translator.endFork();
	}

	/**
	 * For {@link AnalysingASTVisitor#fork(MethodInvocation)} to work, the
	 * binding of the run() method has to be available. This method retrieves
	 * it, given the thread object's name.
	 * 
	 * @param invocationVarName
	 *            the name of the object on which run() is invoked
	 * @return the method binding of the run method
	 */
	private IMethodBinding getRunBindingForThreadObject(
			SimpleName invocationVarName) {
		IBinding invocationVarBinding = invocationVarName.resolveBinding();
		// This variable is of type java.lang.Thread, but we want the
		// class the Thread object was initialized with.
		ITypeBinding threadClassBinding = this.threadObjectsToTypeBindings
				.get(invocationVarBinding);
		IMethodBinding[] methods = threadClassBinding.getDeclaredMethods();
		IMethodBinding runBinding = null;
		for (IMethodBinding curBinding : methods) {
			if (curBinding.getName().equals("run")) {
				runBinding = curBinding;
				break;
			}
		}
		return runBinding;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.code2model.astvisitors.InliningASTVisitor#beforeInlining(org.eclipse.jdt.core.dom.MethodDeclaration, java.util.List)
	 */
	@Override
	protected void beforeInlining(MethodDeclaration decl, List<Expression> args) {
		try {
			this.translator.inlinedMethod(decl.parameters(), args);
		} catch (Exception e) {
			// ASTVisitor.visit() may not throw exceptions.
			logger.error("Exception in translator.inlinedMethod: "
					+ e.getMessage());
		}
	}

	/**
	 * Notify the translator about an external service call. First, the method
	 * checks if we are inside a method. If not, the call occurs on the right
	 * hand side of a field declaration. This is currently not supported.
	 * 
	 * @param mBinding
	 *            the binding of the invoked external method
	 */
	private void notifyExternalCall(IMethodBinding mBinding, Expression invocationExp) {
		if (! this.currentMethods.isEmpty()) {
			String callingClassName = this.currentClasses.peek().getQualifiedName();
			this.translator.externalCall(mBinding, invocationExp, callingClassName);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.SwitchCase)
	 */
	@Override
	public boolean visit(SwitchCase arg0) {
		this.translator.switchCase(arg0);

		// Switch/case constructs are flat in the AST, i.e. the cases
		// and their contents on the same level in the tree.
		return skipChildren;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.SwitchStatement)
	 */
	@Override
	public boolean visit(SwitchStatement arg0) {
		if (containsRelevantActions(arg0)) {
			this.translator.switchStatement(arg0);
			return visitChildren;
		}
		this.translator.irrelevantStatement(arg0);
		this.skip = true;
		return skipChildren;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.code2model.astvisitors.SelectionAwareASTVisitor#visit(org.eclipse.jdt.core.dom.TypeDeclaration)
	 */
	@Override
	public boolean visit(TypeDeclaration node) {
		if (node.isInterface()) {
			return skipChildren;
		}
		
		boolean visitChildren = super.visit(node);
		this.currentClasses.push(node.resolveBinding());
		this.translator.typeDeclaration(node);

		return visitChildren;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.VariableDeclarationFragment)
	 */
	@Override
	public boolean visit(VariableDeclarationFragment node) {
		this.translator.variableDeclaration(node);

		// The initializer might be an external or API call.
		return visitChildren;
	}

	/**
	 * Record {@link Thread} instantiations to be able to inline their code
	 * later (see {@link #visit(MethodInvocation)}).
	 * <p>
	 * The creation of a {@link Thread} object looks like this:
	 * <code>Thread t = new Thread(new ownThread());</code>, where
	 * <code>ownThread</code> is a class implementing {@link Runnable} or
	 * extending {@link Thread}. This class is what the developers implemented
	 * for the analyzed software, so we want its source code for further
	 * analysis and inclusion in the generated model. However, if we resolve the
	 * bindings of the created object <code>t</code>, we only get its type
	 * <code>java.lang.Thread</code> which is not interesting. To get the
	 * class it was parameterized with, we have to record each Thread object
	 * creation and look up it up later when <code>start()</code> is invoked
	 * on the object.
	 * </p>
	 * <p>
	 * This recording is done here, the lookup when visiting a
	 * {@link MethodInvocation} ({@link #visit(MethodInvocation)}).
	 * </p>
	 * 
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.VariableDeclarationStatement)
	 */
	@Override
	public boolean visit(VariableDeclarationStatement arg0) {
		/* Is it a thread type? */
		ITypeBinding binding = arg0.getType().resolveBinding();
		if (binding == null) {
			logger.warn("Type binding of variable " + arg0 + " could not be resolved.");
			return visitChildren;
		}
		String varType = binding.getQualifiedName();
		if (varType.equals("java.lang.Thread")) {
			// 1. What's the object's name?
			VariableDeclarationFragment varnameFragment = (VariableDeclarationFragment) arg0
					.fragments().get(0);
			SimpleName varName = varnameFragment.getName();
			IBinding varBinding = varName.resolveBinding();

			// 2. What's the class the Thread object is initialized with
			// (implementing Runnable or extending Thread.)?
			ClassInstanceCreation initExp = (ClassInstanceCreation) varnameFragment
					.getInitializer();
			// Cast should be safe, that's the "new Thread()".
			Expression creationArg = (Expression) initExp.arguments().get(0);
			ITypeBinding threadClass = creationArg.resolveTypeBinding();

			// Record the pair for later lookup when visiting MethodInvocations.
			this.threadObjectsToTypeBindings.put(varBinding, threadClass);
		}
		return visitChildren;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.WhileStatement)
	 */
	@Override
	public boolean visit(WhileStatement arg0) {
		return startLoop(arg0);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.Block)
	 */
	@Override
	public void endVisit(Block node) {
		if (this.skip) {
			this.skip = false;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.DoStatement)
	 */
	@Override
	public void endVisit(DoStatement arg0) {
		endLoop();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.EnhancedForStatement)
	 */
	@Override
	public void endVisit(EnhancedForStatement arg0) {
		endLoop();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.ForStatement)
	 */
	@Override
	public void endVisit(ForStatement arg0) {
		endLoop();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.IfStatement)
	 */
	@Override
	public void endVisit(IfStatement arg0) {
		this.skip = false;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.MethodDeclaration)
	 */
	@Override
	public void endVisit(MethodDeclaration arg0) {
		if (this.skip) {
			this.skip = false;
		} else {
			this.currentMethods.pop();
			this.translator.endMethodDeclaration();
			// this.monitor.worked(1);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.SwitchStatement)
	 */
	@Override
	public void endVisit(SwitchStatement arg0) {
		if (this.skip) {
			this.skip = false;
		} else {
			this.translator.endSwitchStatement();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.WhileStatement)
	 */
	@Override
	public void endVisit(WhileStatement arg0) {
		endLoop();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#endVisit(org.eclipse.jdt.core.dom.TypeDeclaration)
	 */
	@Override
	public void endVisit(TypeDeclaration node) {
		this.currentClasses.pop();
	}

}
