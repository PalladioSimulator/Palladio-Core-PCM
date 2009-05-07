/**
 * 
 */
package de.uka.ipd.sdq.code2model.astvisitors;

import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import de.uka.ipd.sdq.code2model.analysis.AnalysisState;
import de.uka.ipd.sdq.code2model.ui.UserMessage;


/**
 * An AST Visitor collecting all method declarations. They are stored in the
 * global, static {@link AnalysisState}.
 * 
 * @author thomas
 */
public class MethodDeclarationCollectingASTVisitor extends AbstractASTVisitor {

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.MethodDeclaration)
	 */
	@Override
	public boolean visit(MethodDeclaration node) {
		IMethodBinding binding = node.resolveBinding();
		if (binding == null) {
			logger.error("Binding of declaration " + node.getName()
					+ " cannot be resolved!");
			UserMessage.displayBindingProblemsMessage();
		} else {
			logger.debug("Storing declaration of " + binding);
			AnalysisState.addMethodDeclaration(binding, node);
		}

		return skipChildren;
	}

}
