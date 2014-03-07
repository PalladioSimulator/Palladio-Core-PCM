/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Set Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A multi-dimensional metric description.&nbsp; It is build by pointing to metric descriptions for the included dimensions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription#getSubsumedMetrics <em>Subsumed Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getMetricSetDescription()
 * @model
 * @generated
 */
public interface MetricSetDescription extends MetricDescription {
	/**
     * Returns the value of the '<em><b>Subsumed Metrics</b></em>' reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsumed Metrics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Subsumed Metrics</em>' reference list.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getMetricSetDescription_SubsumedMetrics()
     * @model required="true"
     * @generated
     */
	EList<MetricDescription> getSubsumedMetrics();

} // MetricSetDescription
