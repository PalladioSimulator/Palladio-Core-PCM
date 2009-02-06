/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel;

import javax.measure.unit.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Long Binary Measurements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class is responsible for long measurements. These are stored in IEEE standardized binary format. All values are stored in the same unit. The actual measurements are stored outside the EMF model, see {@link de.uka.ipd.sdq.sensorframework.storage.Daofactory}.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.LongBinaryMeasurements#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getLongBinaryMeasurements()
 * @model
 * @generated
 */
public interface LongBinaryMeasurements extends RawYValues {
	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see #setUnit(Unit)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getLongBinaryMeasurements_Unit()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.models.emfmodel.EJSUnit" required="true" ordered="false"
	 * @generated
	 */
	Unit getUnit();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.LongBinaryMeasurements#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(Unit value);

} // LongBinaryMeasurements
