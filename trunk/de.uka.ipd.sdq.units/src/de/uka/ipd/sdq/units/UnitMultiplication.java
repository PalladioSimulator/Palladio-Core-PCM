/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.units;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Multiplication</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.units.UnitMultiplication#getUnits <em>Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.units.UnitsPackage#getUnitMultiplication()
 * @model
 * @generated
 */
public interface UnitMultiplication extends Unit {
	/**
	 * Returns the value of the '<em><b>Units</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.units.Unit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units</em>' containment reference list.
	 * @see de.uka.ipd.sdq.units.UnitsPackage#getUnitMultiplication_Units()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Unit> getUnits();

} // UnitMultiplication
