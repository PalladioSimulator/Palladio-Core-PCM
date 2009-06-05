/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;

import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bounded Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.BoundedLoop#getRepeatedProcess <em>Repeated Process</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.BoundedLoop#getTargetProcess <em>Target Process</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.BoundedLoop#getNumberOfIterations <em>Number Of Iterations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getBoundedLoop()
 * @model
 * @generated
 */
public interface BoundedLoop extends Operator {
	/**
	 * Returns the value of the '<em><b>Repeated Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repeated Process</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repeated Process</em>' containment reference.
	 * @see #setRepeatedProcess(CapraExpression)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getBoundedLoop_RepeatedProcess()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CapraExpression getRepeatedProcess();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.BoundedLoop#getRepeatedProcess <em>Repeated Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repeated Process</em>' containment reference.
	 * @see #getRepeatedProcess()
	 * @generated
	 */
	void setRepeatedProcess(CapraExpression value);

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
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getBoundedLoop_TargetProcess()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CapraExpression getTargetProcess();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.BoundedLoop#getTargetProcess <em>Target Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Process</em>' containment reference.
	 * @see #getTargetProcess()
	 * @generated
	 */
	void setTargetProcess(CapraExpression value);

	/**
	 * Returns the value of the '<em><b>Number Of Iterations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Iterations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Iterations</em>' containment reference.
	 * @see #setNumberOfIterations(ProbabilityMassFunction)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getBoundedLoop_NumberOfIterations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ProbabilityMassFunction getNumberOfIterations();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.BoundedLoop#getNumberOfIterations <em>Number Of Iterations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Iterations</em>' containment reference.
	 * @see #getNumberOfIterations()
	 * @generated
	 */
	void setNumberOfIterations(ProbabilityMassFunction value);

} // BoundedLoop
