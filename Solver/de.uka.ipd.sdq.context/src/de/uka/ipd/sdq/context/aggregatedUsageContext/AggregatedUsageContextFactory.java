/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage
 * @generated
 */
public interface AggregatedUsageContextFactory extends EFactory {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    AggregatedUsageContextFactory eINSTANCE = de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedUsageContextFactoryImpl
            .init();

    /**
     * Returns a new object of class '<em>Service Execution Context</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Service Execution Context</em>'.
     * @generated
     */
    ServiceExecutionContext createServiceExecutionContext();

    /**
     * Returns a new object of class '<em>Aggregated Resource Demand</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Aggregated Resource Demand</em>'.
     * @generated
     */
    AggregatedResourceDemand createAggregatedResourceDemand();

    /**
     * Returns a new object of class '<em>Aggregated Communication</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Aggregated Communication</em>'.
     * @generated
     */
    AggregatedCommunication createAggregatedCommunication();

    /**
     * Returns a new object of class '<em>Computed Aggregated Usage</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Computed Aggregated Usage</em>'.
     * @generated
     */
    ComputedAggregatedUsage createComputedAggregatedUsage();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    AggregatedUsageContextPackage getAggregatedUsageContextPackage();

} // AggregatedUsageContextFactory
