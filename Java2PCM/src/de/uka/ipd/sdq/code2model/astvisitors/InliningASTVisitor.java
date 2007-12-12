/**
 * All AST Visitors are collected in this package.
 */
package de.uka.ipd.sdq.code2model.astvisitors;

import java.util.List;
import java.util.Stack;

import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;

import de.uka.ipd.sdq.code2model.analysis.AnalysisState;
import de.uka.ipd.sdq.code2model.analysis.callclassification.ServiceCallClassifier;

/**
 * An abstract AST Visitor that adds the capability of inlining methods.
 * <p>
 * Inlining, also called in-line expansion, is basically the insertion of the
 * code of an invoked method at the place of invocation, so that the analysis
 * seemlessly continues with the method body.
 * </p>
 * 
 * @author thomas
 */
public abstract class InliningASTVisitor extends AbstractASTVisitor {

	protected SimpleName className;
	protected ServiceCallClassifier classifier;

	/**
	 * Keeps track of the methods we are currently "in". Used to detect
	 * recursion.
	 */
	protected Stack<IMethodBinding> currentMethods = new Stack<IMethodBinding>();

	public InliningASTVisitor(ServiceCallClassifier classifier) {
		super();
		this.classifier = classifier;
	}
	

	/**
	 * Inline an invoked method at this point.
	 * <p>
	 * Internal methods and run() methods of thread classes are inlined, like
	 * compilers do. Because we <code>accept</code> 'this' on the method body,
	 * everything (like relevancy checks) is continued and we don't have to hold
	 * state or check for special cases.
	 * </p>
	 * <p>
	 * Because our SeffBuilder is stateful, the constructs occuring in the
	 * method body are automatically inserted at the right place in the RDSEFF.
	 * </p>
	 * 
	 * @param binding
	 *            the invoked method's binding
	 * @param args
	 *            the list of argument expressions
	 * @throws Exception
	 *             if the binding for the method declaration could not be found
	 */
	protected void inlineMethod(IMethodBinding binding, List<Expression> args) {
		MethodDeclaration decl = AnalysisState.getMethodDeclaration(binding);
		if (decl != null) {
			// recursive?
			if (this.currentMethods.contains(binding)) {
				return;
			}

			beforeInlining(decl, args);

			Block methodBody = decl.getBody();
			if (methodBody != null) {
				logger.debug("Inlining " + binding);
				this.currentMethods.push(binding);
				methodBody.accept(this);
				this.currentMethods.pop();
			}
		} else {
			logger.warn("Method declaration for " + binding
					+ " could not be found.");
		}
	}

	/**
	 * This method is executed directly before the inlining, i.e., before
	 * <code>methodBody.accept(this)</code>.
	 * 
	 * @param decl
	 *            the declaration of the inlined method
	 * @param args
	 *            the list of argument expressions
	 */
	protected abstract void beforeInlining(MethodDeclaration decl, List<Expression> args);

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.PackageDeclaration)
	 */
	@Override
	public boolean visit(PackageDeclaration arg0) {
		Name packageName = arg0.getName();
		this.classifier.setOurPackage(packageName);
	
		return visitChildren;
	}

}
