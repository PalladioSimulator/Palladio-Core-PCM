/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.GDoF;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Context Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.StaticContextRule#getContextClass <em>Context Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getStaticContextRule()
 * @model abstract="true"
 * @generated
 */
public interface StaticContextRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Context Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Class</em>' reference.
	 * @see #setContextClass(EClass)
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getStaticContextRule_ContextClass()
	 * @model ordered="false"
	 * @generated
	 */
	EClass getContextClass();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.StaticContextRule#getContextClass <em>Context Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Class</em>' reference.
	 * @see #getContextClass()
	 * @generated
	 */
	void setContextClass(EClass value);

} // StaticContextRule
