/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Level Source Code Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.MethodLevelSourceCodeLink#getMethods <em>Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage#getMethodLevelSourceCodeLink()
 * @model
 * @generated
 */
public interface MethodLevelSourceCodeLink extends FileLevelSourceCodeLink {
	/**
	 * Returns the value of the '<em><b>Methods</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.Methods}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage#getMethodLevelSourceCodeLink_Methods()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Methods> getMethods();

} // MethodLevelSourceCodeLink
