package de.uka.ipd.sdq.code2model.astvisitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;

import de.uka.ipd.sdq.code2model.analysis.callclassification.ServiceCallClassifier;
import de.uka.ipd.sdq.code2model.wrappers.Method;

/**
 * An AST Visitor collecting all method invocations. It does not do anything
 * else.
 * <p>
 * It is capable of inlining and checking whether declared methods are relevant,
 * so it parses exactly the same code as the main {@link AnalysingASTVisitor}.
 * </p>
 * 
 * @author thomas
 */
public class MethodInvocationCollectingASTVisitor extends SelectionAwareASTVisitor {

	private List<IMethodBinding> collectedMethods;
	
	public MethodInvocationCollectingASTVisitor(Set<Method> selectedMethodsForUnit,
			ServiceCallClassifier classifier) {
		super(selectedMethodsForUnit, classifier);
		collectedMethods = new ArrayList<IMethodBinding>();
	}

	/**
	 * Get all collected invoked methods.
	 * 
	 * @return the collected methods
	 */
	public List<IMethodBinding> getCollectedMethods() {
		return this.collectedMethods;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.MethodDeclaration)
	 */
//	@Override
//	public boolean visit(MethodDeclaration node) {
//		if (methodIsRelevant(node)) {
//			logger.info("Entering " + new Method(node));
//			return visitChildren;
//		}
//		logger.info("Skipping " + new Method(node));
//		return skipChildren;
//	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.MethodInvocation)
	 */
	@Override
	public boolean visit(MethodInvocation node) {
		logger.debug("Visiting invocation " + node);
		IMethodBinding binding = node.resolveMethodBinding();
		if (binding == null) {
			logger.error("For method invocation " + node.toString()
					+ " the binding could not be resolved!");
			return visitChildren;
		}

		int classification = classifyMethod(binding);
		logger.debug(classification);
		if (classification == ServiceCallClassifier.EXTERNAL_PACKAGE) {
			// External just means here "is not one of the special cases" (like
			// thread invocation). So, let the user decide.
			logger.info("Added " + node + " to invoked methods.");
			collectedMethods.add(binding);
		} else if (classification == ServiceCallClassifier.SAME_PACKAGE) {
			inlineMethod(binding, node.arguments());
		}
		return visitChildren;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.code2model.astvisitors.InliningASTVisitor#beforeInlining(org.eclipse.jdt.core.dom.MethodDeclaration,
	 *      java.util.List)
	 */
	@Override
	protected void beforeInlining(
			@SuppressWarnings("unused") MethodDeclaration decl, 
			@SuppressWarnings("unused") List<Expression> args) {
		// EMPTY
	}

}
