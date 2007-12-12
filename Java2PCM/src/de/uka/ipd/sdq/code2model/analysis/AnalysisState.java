/**
 * 
 */
package de.uka.ipd.sdq.code2model.analysis;

import java.util.Hashtable;

import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;

/**
 * A static, global state holder for information that is needed at several
 * places, does not change is too cumbersome to pass around. As of 2007-06,
 * these are only method declarations.
 * 
 * @author thomas
 */
public class AnalysisState {	
	private static Hashtable<IMethodBinding, MethodDeclaration> declarations = 
			new Hashtable<IMethodBinding, MethodDeclaration>();
	
	/**
	 * Register a method declaration. 
	 * 
	 * @param binding the binding of the declaration
	 * @param declaration the declaration itself
	 */
	public static void addMethodDeclaration(IMethodBinding binding,
			MethodDeclaration declaration) {
		declarations.put(binding, declaration);
	}
	
	/**
	 * Get the method declaration for the given method binding.
	 * 
	 * @param binding
	 *            the method binding
	 * @return the method's declaration
	 */
	public static MethodDeclaration getMethodDeclaration(IMethodBinding binding) {
		return declarations.get(binding);
	}
	
	/**
	 * Clear the state to start a clean new analysis.
	 */
	public static void reset() {
		declarations.clear();
	}
}
