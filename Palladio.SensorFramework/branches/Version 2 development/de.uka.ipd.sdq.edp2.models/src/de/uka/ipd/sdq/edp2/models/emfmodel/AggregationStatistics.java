/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregation Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregationStatistics#getDistinctValuesBeforeAggregation <em>Distinct Values Before Aggregation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregationStatistics#getDistinctValuesAfterAggregation <em>Distinct Values After Aggregation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getAggregationStatistics()
 * @model
 * @generated
 */
public interface AggregationStatistics extends EObject {
	/**
	 * Returns the value of the '<em><b>Distinct Values Before Aggregation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of distinct data values before aggregation.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Distinct Values Before Aggregation</em>' attribute.
	 * @see #setDistinctValuesBeforeAggregation(long)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getAggregationStatistics_DistinctValuesBeforeAggregation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getDistinctValuesBeforeAggregation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregationStatistics#getDistinctValuesBeforeAggregation <em>Distinct Values Before Aggregation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distinct Values Before Aggregation</em>' attribute.
	 * @see #getDistinctValuesBeforeAggregation()
	 * @generated
	 */
	void setDistinctValuesBeforeAggregation(long value);

	/**
	 * Returns the value of the '<em><b>Distinct Values After Aggregation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of distinct data values after aggregation.
	 * 
	 * For example if measurements were aggregated to three different groups the number is three.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Distinct Values After Aggregation</em>' attribute.
	 * @see #setDistinctValuesAfterAggregation(long)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getAggregationStatistics_DistinctValuesAfterAggregation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getDistinctValuesAfterAggregation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.AggregationStatistics#getDistinctValuesAfterAggregation <em>Distinct Values After Aggregation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distinct Values After Aggregation</em>' attribute.
	 * @see #getDistinctValuesAfterAggregation()
	 * @generated
	 */
	void setDistinctValuesAfterAggregation(long value);

} // AggregationStatistics