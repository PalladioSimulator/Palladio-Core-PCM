/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.palladiosimulator.pcmmeasuringpoint.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PcmmeasuringpointFactoryImpl extends EFactoryImpl implements PcmmeasuringpointFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static PcmmeasuringpointFactory init() {
        try {
            PcmmeasuringpointFactory thePcmmeasuringpointFactory = (PcmmeasuringpointFactory)EPackage.Registry.INSTANCE.getEFactory(PcmmeasuringpointPackage.eNS_URI);
            if (thePcmmeasuringpointFactory != null) {
                return thePcmmeasuringpointFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new PcmmeasuringpointFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PcmmeasuringpointFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT: return createAssemblyOperationMeasuringPoint();
            case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT: return createAssemblyPassiveResourceMeasuringPoint();
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT: return createActiveResourceMeasuringPoint();
            case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT: return createSystemOperationMeasuringPoint();
            case PcmmeasuringpointPackage.LINKING_RESOURCE_MEASURING_POINT: return createLinkingResourceMeasuringPoint();
            case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT: return createSubSystemOperationMeasuringPoint();
            case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT: return createUsageScenarioMeasuringPoint();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyOperationMeasuringPoint createAssemblyOperationMeasuringPoint() {
        AssemblyOperationMeasuringPointImpl assemblyOperationMeasuringPoint = new AssemblyOperationMeasuringPointImpl();
        return assemblyOperationMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyPassiveResourceMeasuringPoint createAssemblyPassiveResourceMeasuringPoint() {
        AssemblyPassiveResourceMeasuringPointImpl assemblyPassiveResourceMeasuringPoint = new AssemblyPassiveResourceMeasuringPointImpl();
        return assemblyPassiveResourceMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ActiveResourceMeasuringPoint createActiveResourceMeasuringPoint() {
        ActiveResourceMeasuringPointImpl activeResourceMeasuringPoint = new ActiveResourceMeasuringPointImpl();
        return activeResourceMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SystemOperationMeasuringPoint createSystemOperationMeasuringPoint() {
        SystemOperationMeasuringPointImpl systemOperationMeasuringPoint = new SystemOperationMeasuringPointImpl();
        return systemOperationMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LinkingResourceMeasuringPoint createLinkingResourceMeasuringPoint() {
        LinkingResourceMeasuringPointImpl linkingResourceMeasuringPoint = new LinkingResourceMeasuringPointImpl();
        return linkingResourceMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SubSystemOperationMeasuringPoint createSubSystemOperationMeasuringPoint() {
        SubSystemOperationMeasuringPointImpl subSystemOperationMeasuringPoint = new SubSystemOperationMeasuringPointImpl();
        return subSystemOperationMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UsageScenarioMeasuringPoint createUsageScenarioMeasuringPoint() {
        UsageScenarioMeasuringPointImpl usageScenarioMeasuringPoint = new UsageScenarioMeasuringPointImpl();
        return usageScenarioMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PcmmeasuringpointPackage getPcmmeasuringpointPackage() {
        return (PcmmeasuringpointPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static PcmmeasuringpointPackage getPackage() {
        return PcmmeasuringpointPackage.eINSTANCE;
    }

} //PcmmeasuringpointFactoryImpl
