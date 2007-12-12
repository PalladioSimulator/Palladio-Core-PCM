package de.uka.ipd.sdq.code2model.astvisitors;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jface.preference.IPreferenceStore;

import de.uka.ipd.sdq.code2model.Activator;
import de.uka.ipd.sdq.code2model.analysis.callclassification.ServiceCallClassifier;
import de.uka.ipd.sdq.code2model.preferences.Code2ModelPreferences;

/**
 * An {@link ASTVisitor} that checks the block it visits for relevancy.
 * <p>
 * Relevancy means here that the block contains at least one action or statement
 * that should be represented in the generated performance model.
 * </p>
 * <p>
 * The class is given a {@link ServiceCallClassifier} at instantiation. It
 * performs the actual analysis of the found method invocations, the
 * {@link BlockRelevancyCheckingASTVisitor} then does the classification. It stores
 * its result - whether the block is relevant or not - in the boolean variable
 * {@link #relevant}.
 * </p>
 * <p>
 * The {@link BlockRelevancyCheckingASTVisitor} is a Singleton, the instance can be
 * retrieved with {@link #getInstance(ServiceCallClassifier)}.
 * </p>
 * <p>
 * TODO: So far, results are not cached. This means that blocks are checked
 * multiple times, except the leafs of the analyzed AST, because the blocks
 * lower down in the AST are part of the higher blocks and have already been
 * checked when the relevancy classifier is accepted by them.
 * </p>
 * 
 * @author thomas
 */
public class BlockRelevancyCheckingASTVisitor extends InliningASTVisitor {

	private static BlockRelevancyCheckingASTVisitor thisVisitor;

	/**
	 * Stores the result: should the block be further processed or not.
	 */
	public boolean relevant = false;

	private ServiceCallClassifier classifier;

	public BlockRelevancyCheckingASTVisitor(ServiceCallClassifier classifier) {
		super(classifier);
		this.classifier = classifier;
	}

	/**
	 * The method to get an instance, as defined by the Singleton pattern.
	 * 
	 * @param classifier
	 *            in case a visitor is instantiated, it is parameterized with
	 *            this {@link ServiceCallClassifier}
	 * @return a {@link BlockRelevancyCheckingASTVisitor}
	 */
	public static BlockRelevancyCheckingASTVisitor getInstance(
			ServiceCallClassifier classifier) {
		if (thisVisitor == null) {
			thisVisitor = new BlockRelevancyCheckingASTVisitor(classifier);
		} else {
			thisVisitor.reset();
		}
		return thisVisitor;
	}

	/**
	 * Resets the block relevancy checker.
	 */
	public void reset() {
		this.relevant = false;
	}

	/**
	 * Performance shortcut. The visitor shouldn't even begin descending if we
	 * are already relevant.
	 * 
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.Block)
	 */
	@Override
	public boolean visit(Block node) {
		if (this.relevant == true) {
			return skipChildren;
		}
		return visitChildren;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.ClassInstanceCreation)
	 */
	@Override
	public boolean visit(ClassInstanceCreation node) {
		IMethodBinding mBinding = node.resolveConstructorBinding();
		checkMethod(mBinding, node.arguments());
		return visitChildren;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.MethodInvocation)
	 */
	@Override
	public boolean visit(MethodInvocation arg0) {
		IMethodBinding mBinding = arg0.resolveMethodBinding();
		checkMethod(mBinding, arg0.arguments());

		// Method invocations can be nested as in localMethod(
		// externalService.condition() ), so we visit the children, too.
		return visitChildren;
	}

	/**
	 * Check a method for relevancy using the {@link #classifier}.
	 * 
	 * @param mBinding
	 *            the binding of the method to check for relevancy
	 */
	private void checkMethod(IMethodBinding mBinding, List<Expression> args) {
		if (mBinding == null) {
			logger.warn("Received an unresolved binding.  " +
					"Method arguments are " + args + ".");
			return;
		}
		
		int methodSource = classifyMethod(mBinding);

		// We want these two in each case.
		if (methodSource == ServiceCallClassifier.EXTERNAL_PACKAGE) {
			this.relevant = true;
		}

		if (methodSource == ServiceCallClassifier.JAVA_WANTED) {
			IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
			boolean separateAPI = 
					prefs.getBoolean(Code2ModelPreferences.separateInternalActionsforAPI);
			if (separateAPI) {
				this.relevant = true;
			}
		}
		
		/*
		 * It might seem strange that EXTERNAL_PACKAGE and SAME_PACKAGE yield
		 * the same result here. The reason is that internal methods are not
		 * interesting per se for the RDSEFF, but their performance-relevant
		 * actions are, if any. So they are inlined if they contain something
		 * relevant.
		 * 
		 * We don't know that yet here, so we just let them be parsed by the
		 * control flow ASTVisitor which then decides.
		 */
		if (methodSource == ServiceCallClassifier.SAME_PACKAGE) {
			inlineMethod(mBinding, args);
		}
	}

	/**
	 * Extract the necessary info from the binding and use the
	 * {@link ServiceCallClassifier} to classify a method invocation.
	 * 
	 * @param mBinding
	 *            the binding of the method
	 * @return the classification as defined by {@link ServiceCallClassifier}
	 */
	private int classifyMethod(IMethodBinding mBinding) {
		ITypeBinding tBinding = mBinding.getDeclaringClass();
		String declaringClassFQN = tBinding.getQualifiedName();
		String methodName = mBinding.getName().toString();

		// Can happen, for unknown reasons.
		if ((declaringClassFQN == null) || (declaringClassFQN.equals(""))) {
			logger.warn("Method binding " + mBinding.getName()
					+ " has no declaring class.");
			return ServiceCallClassifier.IGNORE;
		}

		return this.classifier.classifyMethod(declaringClassFQN, methodName);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.code2model.astvisitors.InliningASTVisitor#beforeInlining(org.eclipse.jdt.core.dom.MethodDeclaration, java.util.List)
	 */
	@Override
	protected void beforeInlining(MethodDeclaration decl, List<Expression> args) {
		// EMPTY
	}

}
