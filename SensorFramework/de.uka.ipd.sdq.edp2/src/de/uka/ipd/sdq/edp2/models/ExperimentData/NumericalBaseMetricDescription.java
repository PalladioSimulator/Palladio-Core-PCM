/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import javax.measure.unit.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical Base Metric Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * self.captureType <> CaptureType::Identifier
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription#getDefaultUnit <em>Default Unit</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription#getPersistenceKind <em>Persistence Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalBaseMetricDescription()
 * @model
 * @generated
 */
public interface NumericalBaseMetricDescription extends BaseMetricDescription {
	/**
     * Returns the value of the '<em><b>Default Unit</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The default unit to use for the measurements. Please note that
     * there&nbsp;is&nbsp;no&nbsp;unit&nbsp;for&nbsp;NominalMeasurements.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Default Unit</em>' attribute.
     * @see #setDefaultUnit(Unit)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalBaseMetricDescription_DefaultUnit()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSUnit" ordered="false"
     * @generated
     */
	Unit getDefaultUnit();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription#getDefaultUnit <em>Default Unit</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Unit</em>' attribute.
     * @see #getDefaultUnit()
     * @generated
     */
	void setDefaultUnit(Unit value);

	/**
     * Returns the value of the '<em><b>Persistence Kind</b></em>' attribute.
     * The literals are from the enumeration {@link de.uka.ipd.sdq.edp2.models.ExperimentData.PersistenceKindOptions}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistence Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Persistence Kind</em>' attribute.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.PersistenceKindOptions
     * @see #setPersistenceKind(PersistenceKindOptions)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalBaseMetricDescription_PersistenceKind()
     * @model required="true" ordered="false"
     * @generated
     */
	PersistenceKindOptions getPersistenceKind();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription#getPersistenceKind <em>Persistence Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Persistence Kind</em>' attribute.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.PersistenceKindOptions
     * @see #getPersistenceKind()
     * @generated
     */
	void setPersistenceKind(PersistenceKindOptions value);

} // NumericalBaseMetricDescription
