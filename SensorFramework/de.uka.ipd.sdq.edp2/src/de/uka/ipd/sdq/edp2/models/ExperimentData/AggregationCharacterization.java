/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregation Characterization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationCharacterization#getFunction <em>Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationCharacterization#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getAggregationCharacterization()
 * @model
 * @generated
 */
public interface AggregationCharacterization extends EObject {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Describes the used aggregation function.
	 * 
	 * Examples are: sum, minimum, average, mean, maximum or count for the number of measurements falling into one interval.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(AggregationFunctionDescription)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getAggregationCharacterization_Function()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AggregationFunctionDescription getFunction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationCharacterization#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(AggregationFunctionDescription value);

	/**
	 * Returns the value of the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getAggregationCharacterization <em>Aggregation Characterization</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregated Measurements</em>' container reference.
	 * @see #setAggregatedMeasurements(AggregatedMeasurements)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getAggregationCharacterization_AggregatedMeasurements()
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements#getAggregationCharacterization
	 * @model opposite="aggregationCharacterization" required="true" transient="false" ordered="false"
	 * @generated
	 */
	AggregatedMeasurements getAggregatedMeasurements();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationCharacterization#getAggregatedMeasurements <em>Aggregated Measurements</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregated Measurements</em>' container reference.
	 * @see #getAggregatedMeasurements()
	 * @generated
	 */
	void setAggregatedMeasurements(AggregatedMeasurements value);

} // AggregationCharacterization
