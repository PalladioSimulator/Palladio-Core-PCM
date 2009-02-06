/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregation Characterization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AggregationCharacterization#getFunction <em>Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AggregationCharacterization#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getAggregationCharacterization()
 * @model
 * @generated
 */
public interface AggregationCharacterization extends EObject {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Describes the used aggregation function.
	 * 
	 * Examples are: sum, minimum, average, mean, maximum or count for the number of measurements falling into one interval.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function</em>' attribute.
	 * @see #setFunction(String)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getAggregationCharacterization_Function()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getFunction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AggregationCharacterization#getFunction <em>Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' attribute.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(String value);

	/**
	 * Returns the value of the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AggregatedMeasurements#getAggregationCharacterization <em>Aggregation Characterization</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregated Measurements</em>' container reference.
	 * @see #setAggregatedMeasurements(AggregatedMeasurements)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getAggregationCharacterization_AggregatedMeasurements()
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.AggregatedMeasurements#getAggregationCharacterization
	 * @model opposite="aggregationCharacterization" required="true" transient="false" ordered="false"
	 * @generated
	 */
	AggregatedMeasurements getAggregatedMeasurements();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AggregationCharacterization#getAggregatedMeasurements <em>Aggregated Measurements</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregated Measurements</em>' container reference.
	 * @see #getAggregatedMeasurements()
	 * @generated
	 */
	void setAggregatedMeasurements(AggregatedMeasurements value);

} // AggregationCharacterization
