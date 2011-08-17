/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Set Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.MetricSetDescription#getSubsumedMetrics <em>Subsumed Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getMetricSetDescription()
 * @model
 * @generated
 */
public interface MetricSetDescription extends MetricDescription {
	/**
	 * Returns the value of the '<em><b>Subsumed Metrics</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.emfmodel.MetricDescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsumed Metrics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsumed Metrics</em>' reference list.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getMetricSetDescription_SubsumedMetrics()
	 * @model required="true"
	 * @generated
	 */
	EList<MetricDescription> getSubsumedMetrics();

} // MetricSetDescription