/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computed Aggregated Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Combines the ServiceExecutionContexts from one UsageScenario. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage#getServiceExecutionContexts_ComputedAggregatedUsage <em>Service Execution Contexts Computed Aggregated Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getComputedAggregatedUsage()
 * @model
 * @generated
 */
public interface ComputedAggregatedUsage extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Returns the value of the '<em><b>Service Execution Contexts Computed Aggregated Usage</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Execution Contexts Computed Aggregated Usage</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Execution Contexts Computed Aggregated Usage</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getComputedAggregatedUsage_ServiceExecutionContexts_ComputedAggregatedUsage()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ServiceExecutionContext> getServiceExecutionContexts_ComputedAggregatedUsage();

} // ComputedAggregatedUsage
