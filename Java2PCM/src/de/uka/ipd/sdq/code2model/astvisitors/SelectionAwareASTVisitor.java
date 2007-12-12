/**
 * 
 */
package de.uka.ipd.sdq.code2model.astvisitors;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Level;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jface.preference.IPreferenceStore;

import de.uka.ipd.sdq.code2model.Activator;
import de.uka.ipd.sdq.code2model.analysis.callclassification.ServiceCallClassifier;
import de.uka.ipd.sdq.code2model.preferences.Code2ModelPreferences;
import de.uka.ipd.sdq.code2model.wrappers.Method;

/**
 * An abstract AST Visitor that adds the capability of knowing what the user
 * selected in Eclipse over the {@link InliningASTVisitor}.
 * 
 * @author thomas
 */
public abstract class SelectionAwareASTVisitor extends InliningASTVisitor {
	protected Set<Method> selectedMethodsForUnit;
	protected HashMap<Method,ITypeBinding> methodsToInterfaces = 
			new HashMap<Method, ITypeBinding>();

	public SelectionAwareASTVisitor(Set<Method> selectedMethodsForUnit,
			ServiceCallClassifier classifier) {
		super(classifier);
		this.selectedMethodsForUnit = selectedMethodsForUnit;
		if (logger.getLevel() == Level.DEBUG) {
			logger.debug("User selected");
			for (Method m : selectedMethodsForUnit) {
				logger.debug("    " + m);
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.TypeDeclaration)
	 */
	@Override
	public boolean visit(TypeDeclaration node) {
		this.className = node.getName();
		registerMethodsDeclaredInIFace(node);
		return visitChildren;
	}

	/**
	 * Collect all methods declared in the interfaces the given class
	 * implements. The interface a method is declared in can then easily be
	 * retrieved from {@link #methodsToInterfaces}.
	 * 
	 * @param node the class declaration
	 */
	private void registerMethodsDeclaredInIFace(TypeDeclaration node) {
		List<SimpleType> implementedIFaces = node.superInterfaceTypes();
		for (SimpleType ifaceType : implementedIFaces) {
			ITypeBinding ifaceBinding = ifaceType.resolveBinding();
			IMethodBinding[] methodBindings = ifaceBinding.getDeclaredMethods();
			for (IMethodBinding mdecl : methodBindings) {
				Method method = new Method(mdecl);
				this.methodsToInterfaces.put(method, ifaceBinding);
			}
		}
	}


	/**
	 * Checks a method declaration encountered while traversing the AST if we
	 * should generate an RDSEFF for it.
	 * <p>
	 * The following criteria are checked:
	 * <ul>
	 * <li>If a particular method was selected by the user in the UI, we only
	 * have to check if this one is among the selected ones.</li>
	 * <li>If a whole compilation unit was selected, we have to check</li>
	 * <ul>
	 * <li>if the method is public</li>
	 * <li>if the user has chosen to only handle methods declared in an
	 * interface; if so, check whether this one was.</li>
	 * </ul>
	 * </ul>
	 * </p>
	 * 
	 * @param decl
	 *            the method declaration to check
	 * @return whether to analyze it or to skip it
	 */
	protected boolean methodIsRelevant(MethodDeclaration decl) {
		Method method = new Method(decl);
		// Was the whole CompilationUnit selected?
		if (this.selectedMethodsForUnit.isEmpty()) {
			// 1. It must be public.
			boolean isPublic = (decl.getModifiers() & Modifier.PUBLIC) != 0;
			if (!isPublic) {
				return false;
			}

			if (methodsMustBeInIFace()) {
				return methodIsDefinedInInterface(method);
			}
			
			return true;
		}
		// A particular method was selected. In this case, we trust the
		// user and don't do additional checks. We only have to check if the
		// current method is one of the selected ones.
		return this.selectedMethodsForUnit.contains(method);
	}

	/**
	 * Check if the user has requested that public services must be defined in
	 * an interface.
	 * 
	 * @return true if requested by the user, false otherwise
	 */
	private boolean methodsMustBeInIFace() {
		IPreferenceStore prefStore = Activator.getDefault()
				.getPreferenceStore();
		return prefStore.getBoolean(Code2ModelPreferences.methodsMustBeInIFace);
	}

	/**
	 * Check if the given method is defined in an interface.
	 * 
	 * @param method
	 *            the method whose definition to check
	 * @return true if defined in an implemented interface, false if defined in
	 *         the class itself
	 */
	protected boolean methodIsDefinedInInterface(Method method) {
		// TODO Doesn't work!!  And the HashMap is not necessary anyway.
		return this.methodsToInterfaces.keySet().contains(method); 
	}

	/**
	 * Get the distance of a called service from the analyzed class, i.e. the
	 * relation between the two packages as determined by the
	 * {@link ServiceCallClassifier}.
	 * 
	 * @param mBinding
	 *            the method invocation to be examined
	 * @return the distance as defined in {@link ServiceCallClassifier}
	 */
	protected int classifyMethod(IMethodBinding mBinding) {
		String declaringClassFQN = mBinding.getDeclaringClass()
				.getQualifiedName();
		String methodName = mBinding.getName().toString();
		int distance = this.classifier.classifyMethod(declaringClassFQN,
				methodName);
		return distance;
	}

}
