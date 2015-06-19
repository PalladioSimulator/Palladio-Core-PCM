/**
 */
package org.palladiosimulator.pcmmeasuringpoint;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage
 * @generated
 */
public interface PcmmeasuringpointFactory extends EFactory {

    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    PcmmeasuringpointFactory eINSTANCE = org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointFactoryImpl
            .init();

    /**
     * Returns a new object of class '<em>Assembly Operation Measuring Point</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Assembly Operation Measuring Point</em>'.
     * @generated
     */
    AssemblyOperationMeasuringPoint createAssemblyOperationMeasuringPoint();

    /**
     * Returns a new object of class '<em>Assembly Passive Resource Measuring Point</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Assembly Passive Resource Measuring Point</em>'.
     * @generated
     */
    AssemblyPassiveResourceMeasuringPoint createAssemblyPassiveResourceMeasuringPoint();

    /**
     * Returns a new object of class '<em>Active Resource Measuring Point</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Active Resource Measuring Point</em>'.
     * @generated
     */
    ActiveResourceMeasuringPoint createActiveResourceMeasuringPoint();

    /**
     * Returns a new object of class '<em>System Operation Measuring Point</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>System Operation Measuring Point</em>'.
     * @generated
     */
    SystemOperationMeasuringPoint createSystemOperationMeasuringPoint();

    /**
     * Returns a new object of class '<em>Linking Resource Measuring Point</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Linking Resource Measuring Point</em>'.
     * @generated
     */
    LinkingResourceMeasuringPoint createLinkingResourceMeasuringPoint();

    /**
     * Returns a new object of class '<em>Sub System Operation Measuring Point</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Sub System Operation Measuring Point</em>'.
     * @generated
     */
    SubSystemOperationMeasuringPoint createSubSystemOperationMeasuringPoint();

    /**
     * Returns a new object of class '<em>Usage Scenario Measuring Point</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Usage Scenario Measuring Point</em>'.
     * @generated
     */
    UsageScenarioMeasuringPoint createUsageScenarioMeasuringPoint();

    /**
     * Returns a new object of class '<em>Entry Level System Call Measuring Point</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Entry Level System Call Measuring Point</em>'.
     * @generated
     */
    EntryLevelSystemCallMeasuringPoint createEntryLevelSystemCallMeasuringPoint();

    /**
     * Returns a new object of class '<em>External Call Action Measuring Point</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>External Call Action Measuring Point</em>'.
     * @generated
     */
    ExternalCallActionMeasuringPoint createExternalCallActionMeasuringPoint();

    /**
     * Returns a new object of class '<em>Resource Environment Measuring Point</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Resource Environment Measuring Point</em>'.
     * @generated
     */
    ResourceEnvironmentMeasuringPoint createResourceEnvironmentMeasuringPoint();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    PcmmeasuringpointPackage getPcmmeasuringpointPackage();

} // PcmmeasuringpointFactory
