/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Observed Nominal Measurements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedNominalMeasurements#getObservedCategories <em>Observed Categories</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedNominalMeasurements#getUuid <em>Uuid</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getObservedNominalMeasurements()
 * @model
 * @generated
 */
public interface ObservedNominalMeasurements extends EObject {
	/**
	 * Returns the value of the '<em><b>Observed Categories</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observed Categories</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observed Categories</em>' containment reference list.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getObservedNominalMeasurements_ObservedCategories()
	 * @model containment="true"
	 * @generated
	 */
	EList<ObservedCategory> getObservedCategories();

	/**
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see #setUuid(String)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getObservedNominalMeasurements_Uuid()
	 * @model id="true" required="true" ordered="false"
	 * @generated
	 */
	String getUuid();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedNominalMeasurements#getUuid <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uuid</em>' attribute.
	 * @see #getUuid()
	 * @generated
	 */
	void setUuid(String value);

} // ObservedNominalMeasurements
