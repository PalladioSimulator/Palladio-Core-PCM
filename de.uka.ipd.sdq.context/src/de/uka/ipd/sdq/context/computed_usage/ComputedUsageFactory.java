/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage
 * @generated
 */
public interface ComputedUsageFactory extends EFactory {
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
    ComputedUsageFactory eINSTANCE = de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Context</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return a new object of class '<em>Context</em>'.
     * @generated
     */
    ComputedUsageContext createComputedUsageContext();

    /**
     * Returns a new object of class '<em>Branch Probability</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Branch Probability</em>'.
     * @generated
     */
    BranchProbability createBranchProbability();

    /**
     * Returns a new object of class '<em>Loop Iteration</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Loop Iteration</em>'.
     * @generated
     */
    LoopIteration createLoopIteration();

    /**
     * Returns a new object of class '<em>Input</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Input</em>'.
     * @generated
     */
    Input createInput();

    /**
     * Returns a new object of class '<em>External Call Output</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>External Call Output</em>'.
     * @generated
     */
    ExternalCallOutput createExternalCallOutput();

    /**
     * Returns a new object of class '<em>External Call Input</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>External Call Input</em>'.
     * @generated
     */
    ExternalCallInput createExternalCallInput();

    /**
     * Returns a new object of class '<em>Output</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return a new object of class '<em>Output</em>'.
     * @generated
     */
    Output createOutput();

    /**
     * Returns a new object of class '<em>Computed Usage</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Computed Usage</em>'.
     * @generated
     */
    ComputedUsage createComputedUsage();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    ComputedUsagePackage getComputedUsagePackage();

} // ComputedUsageFactory
