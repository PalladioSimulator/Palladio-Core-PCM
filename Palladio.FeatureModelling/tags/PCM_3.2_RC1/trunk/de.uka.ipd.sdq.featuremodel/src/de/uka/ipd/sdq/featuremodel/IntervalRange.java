/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.IntervalRange#isLowerBoundIncluded <em>Lower Bound Included</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.IntervalRange#isUpperBoundIncluded <em>Upper Bound Included</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getIntervalRange()
 * @model abstract="true"
 * @generated
 */
public interface IntervalRange extends EObject {
	/**
	 * Returns the value of the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound Included</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound Included</em>' attribute.
	 * @see #setLowerBoundIncluded(boolean)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getIntervalRange_LowerBoundIncluded()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isLowerBoundIncluded();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.IntervalRange#isLowerBoundIncluded <em>Lower Bound Included</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound Included</em>' attribute.
	 * @see #isLowerBoundIncluded()
	 * @generated
	 */
	void setLowerBoundIncluded(boolean value);

	/**
	 * Returns the value of the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound Included</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound Included</em>' attribute.
	 * @see #setUpperBoundIncluded(boolean)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getIntervalRange_UpperBoundIncluded()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isUpperBoundIncluded();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.IntervalRange#isUpperBoundIncluded <em>Upper Bound Included</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound Included</em>' attribute.
	 * @see #isUpperBoundIncluded()
	 * @generated
	 */
	void setUpperBoundIncluded(boolean value);

} // IntervalRange
