/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;

import javax.measure.unit.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Binary Measurements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class is responsible for double measurements. These are stored in IEEE standardized binary format. All values are stored in the same unit.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.DoubleBinaryMeasurements#getValues <em>Values</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.DoubleBinaryMeasurements#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getDoubleBinaryMeasurements()
 * @model
 * @generated
 */
public interface DoubleBinaryMeasurements extends RawYValues {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute.
	 * @see #setValues(BackgroundMemoryList)
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getDoubleBinaryMeasurements_Values()
	 * @model unique="false" dataType="de.uka.ipd.sdq.sensorframework.EBackgroundList" required="true"
	 * @generated
	 */
	BackgroundMemoryList getValues();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.DoubleBinaryMeasurements#getValues <em>Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Values</em>' attribute.
	 * @see #getValues()
	 * @generated
	 */
	void setValues(BackgroundMemoryList value);

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
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getDoubleBinaryMeasurements_Unit()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.EJSUnit" required="true" ordered="false"
	 * @generated
	 */
	Unit getUnit();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.DoubleBinaryMeasurements#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(Unit value);

} // DoubleBinaryMeasurements
