/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel;

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
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.JSXmlMeasurements#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getJSXmlMeasurements()
 * @model
 * @generated
 */
public interface JSXmlMeasurements extends RawYValues {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute.
	 * @see #setValues(Measure)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getJSXmlMeasurements_Values()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.models.emfmodel.EJSMeasure" required="true"
	 * @generated
	 */
	Measure getValues();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.JSXmlMeasurements#getValues <em>Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Values</em>' attribute.
	 * @see #getValues()
	 * @generated
	 */
	void setValues(Measure value);

} // JSXmlMeasurements
