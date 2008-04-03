/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.InternalSelector#getProbability <em>Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.InternalSelector#getProcess <em>Process</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getInternalSelector()
 * @model
 * @generated
 */
public interface InternalSelector extends EObject {
	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see #setProbability(double)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getInternalSelector_Probability()
	 * @model default="1" unique="false" required="true" ordered="false"
	 * @generated
	 */
	double getProbability();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.InternalSelector#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(double value);

	/**
	 * Returns the value of the '<em><b>Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process</em>' containment reference.
	 * @see #setProcess(CapraExpression)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getInternalSelector_Process()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	CapraExpression getProcess();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.InternalSelector#getProcess <em>Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process</em>' containment reference.
	 * @see #getProcess()
	 * @generated
	 */
	void setProcess(CapraExpression value);

} // InternalSelector
