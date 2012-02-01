/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.effort.estimation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Effort Estimation Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getNumberTestcases <em>Number Testcases</em>}</li>
 *   <li>{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getIntermediate <em>Intermediate</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.effort.estimation.EstimationPackage#getEffortEstimationResult()
 * @model
 * @generated
 */
public interface EffortEstimationResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Number Testcases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Testcases</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Testcases</em>' attribute.
	 * @see #setNumberTestcases(int)
	 * @see de.fzi.se.validation.effort.estimation.EstimationPackage#getEffortEstimationResult_NumberTestcases()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getNumberTestcases();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getNumberTestcases <em>Number Testcases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Testcases</em>' attribute.
	 * @see #getNumberTestcases()
	 * @generated
	 */
	void setNumberTestcases(int value);

	/**
	 * Returns the value of the '<em><b>Intermediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intermediate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate</em>' attribute.
	 * @see #setIntermediate(double)
	 * @see de.fzi.se.validation.effort.estimation.EstimationPackage#getEffortEstimationResult_Intermediate()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getIntermediate();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getIntermediate <em>Intermediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate</em>' attribute.
	 * @see #getIntermediate()
	 * @generated
	 */
	void setIntermediate(double value);

} // EffortEstimationResult
