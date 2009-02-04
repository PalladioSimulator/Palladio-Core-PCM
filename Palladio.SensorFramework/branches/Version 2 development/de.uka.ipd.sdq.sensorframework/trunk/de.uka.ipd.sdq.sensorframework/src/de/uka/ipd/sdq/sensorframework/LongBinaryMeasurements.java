/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;

import javax.measure.unit.Unit;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Long Binary Measurements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class is responsible for long measurements. These are stored in IEEE standardized binary format. All values are stored in the same unit.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.LongBinaryMeasurements#getValues <em>Values</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.LongBinaryMeasurements#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getLongBinaryMeasurements()
 * @model
 * @generated
 */
public interface LongBinaryMeasurements extends RawYValues {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getLongBinaryMeasurements_Values()
	 * @model unique="false" dataType="de.uka.ipd.sdq.sensorframework.EBackgroundList"
	 * @generated
	 */
	EList<BackgroundMemoryList> getValues();

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
	 * @see de.uka.ipd.sdq.sensorframework.SensorframeworkPackage#getLongBinaryMeasurements_Unit()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.EJSUnit" required="true" ordered="false"
	 * @generated
	 */
	Unit getUnit();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.LongBinaryMeasurements#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(Unit value);

} // LongBinaryMeasurements
