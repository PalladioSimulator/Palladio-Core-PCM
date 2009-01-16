/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import javax.measure.Measure;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JS Xml Measurements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Stores the JScience types for which no fast background storage facility is available.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.JSXmlMeasurements#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getJSXmlMeasurements()
 * @model
 * @generated
 */
public interface JSXmlMeasurements extends RawYValues {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Measure)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getJSXmlMeasurements_Value()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.JSXmlMeasurements#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Measure value);

} // JSXmlMeasurements
