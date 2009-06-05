/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Variable Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ProcessVariableUsage#getProcessVariable <em>Process Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getProcessVariableUsage()
 * @model
 * @generated
 */
public interface ProcessVariableUsage extends CapraExpression {
	/**
	 * Returns the value of the '<em><b>Process Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Variable</em>' reference.
	 * @see #setProcessVariable(ProcessVariable)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getProcessVariableUsage_ProcessVariable()
	 * @model required="true"
	 * @generated
	 */
	ProcessVariable getProcessVariable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.ProcessVariableUsage#getProcessVariable <em>Process Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Variable</em>' reference.
	 * @see #getProcessVariable()
	 * @generated
	 */
	void setProcessVariable(ProcessVariable value);

} // ProcessVariableUsage
