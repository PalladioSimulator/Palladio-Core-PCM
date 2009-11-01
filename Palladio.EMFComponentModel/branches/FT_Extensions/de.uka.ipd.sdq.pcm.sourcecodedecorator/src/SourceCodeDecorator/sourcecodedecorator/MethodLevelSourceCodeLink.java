/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.sourcecodedecorator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Level Source Code Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.MethodLevelSourceCodeLink#getMethods <em>Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getMethodLevelSourceCodeLink()
 * @model
 * @generated
 */
public interface MethodLevelSourceCodeLink extends FileLevelSourceCodeLink {
	/**
	 * Returns the value of the '<em><b>Methods</b></em>' reference list.
	 * The list contents are of type {@link SourceCodeDecorator.sourcecodedecorator.Methods}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' reference list.
	 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getMethodLevelSourceCodeLink_Methods()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Methods> getMethods();

} // MethodLevelSourceCodeLink
