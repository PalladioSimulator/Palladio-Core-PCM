/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel;

import java.util.Map;

import javax.measure.unit.Unit;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measurable Sensor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Sensor which stores any measurable or quantifyable value. The values have to be described using the JScience framework.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasurableSensor#getUnitOfMeasurements <em>Unit Of Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getMeasurableSensor()
 * @model
 * @generated
 */
public interface MeasurableSensor extends SensorDeclaration {
	/**
	 * Returns the value of the '<em><b>Unit Of Measurements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Of Measurements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Of Measurements</em>' attribute.
	 * @see #setUnitOfMeasurements(Unit)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getMeasurableSensor_UnitOfMeasurements()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.models.emfmodel.EJSUnit" required="true" ordered="false"
	 * @generated
	 */
	Unit getUnitOfMeasurements();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasurableSensor#getUnitOfMeasurements <em>Unit Of Measurements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Of Measurements</em>' attribute.
	 * @see #getUnitOfMeasurements()
	 * @generated
	 */
	void setUnitOfMeasurements(Unit value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.persistencyKind != PersistenceKindOptions::Emf
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean PersistencyKindNotEmf(DiagnosticChain diagnostics, Map context);

} // MeasurableSensor
