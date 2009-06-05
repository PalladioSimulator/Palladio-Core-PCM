/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probfunction;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Probability Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probfunction.ProbabilityFunction#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage#getProbabilityFunction()
 * @model abstract="true"
 * @generated
 */
public interface ProbabilityFunction extends EObject {
	/**
	 * Returns the value of the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' containment reference.
	 * @see #setUnit(Unit)
	 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage#getProbabilityFunction_Unit()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Unit getUnit();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.probfunction.ProbabilityFunction#getUnit <em>Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' containment reference.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(Unit value);

} // ProbabilityFunction