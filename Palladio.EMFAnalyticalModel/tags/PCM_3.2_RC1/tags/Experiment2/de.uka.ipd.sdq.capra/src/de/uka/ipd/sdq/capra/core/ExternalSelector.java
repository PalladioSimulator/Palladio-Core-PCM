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
 * A representation of the model object '<em><b>External Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ExternalSelector#getInput <em>Input</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ExternalSelector#getTargetProcess <em>Target Process</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getExternalSelector()
 * @model
 * @generated
 */
public interface ExternalSelector extends EObject {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' containment reference.
	 * @see #setInput(InputEventAction)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getExternalSelector_Input()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InputEventAction getInput();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.ExternalSelector#getInput <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' containment reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(InputEventAction value);

	/**
	 * Returns the value of the '<em><b>Target Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Process</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Process</em>' containment reference.
	 * @see #setTargetProcess(CapraExpression)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getExternalSelector_TargetProcess()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CapraExpression getTargetProcess();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.ExternalSelector#getTargetProcess <em>Target Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Process</em>' containment reference.
	 * @see #getTargetProcess()
	 * @generated
	 */
	void setTargetProcess(CapraExpression value);

} // ExternalSelector
