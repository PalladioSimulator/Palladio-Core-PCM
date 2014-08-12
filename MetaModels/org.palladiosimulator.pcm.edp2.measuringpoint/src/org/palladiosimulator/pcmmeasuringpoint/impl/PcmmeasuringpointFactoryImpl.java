/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointFactory;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class PcmmeasuringpointFactoryImpl extends EFactoryImpl implements PcmmeasuringpointFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static PcmmeasuringpointFactory init() {
        try {
            final PcmmeasuringpointFactory thePcmmeasuringpointFactory = (PcmmeasuringpointFactory) EPackage.Registry.INSTANCE
                    .getEFactory(PcmmeasuringpointPackage.eNS_URI);
            if (thePcmmeasuringpointFactory != null) {
                return thePcmmeasuringpointFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new PcmmeasuringpointFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PcmmeasuringpointFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT:
            return this.createAssemblyOperationMeasuringPoint();
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT:
            return this.createAssemblyPassiveResourceMeasuringPoint();
        case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT:
            return this.createActiveResourceMeasuringPoint();
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT:
            return this.createSystemOperationMeasuringPoint();
        case PcmmeasuringpointPackage.LINKING_RESOURCE_MEASURING_POINT:
            return this.createLinkingResourceMeasuringPoint();
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT:
            return this.createSubSystemOperationMeasuringPoint();
        case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT:
            return this.createUsageScenarioMeasuringPoint();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyOperationMeasuringPoint createAssemblyOperationMeasuringPoint() {
        final AssemblyOperationMeasuringPointImpl assemblyOperationMeasuringPoint = new AssemblyOperationMeasuringPointImpl();
        return assemblyOperationMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyPassiveResourceMeasuringPoint createAssemblyPassiveResourceMeasuringPoint() {
        final AssemblyPassiveResourceMeasuringPointImpl assemblyPassiveResourceMeasuringPoint = new AssemblyPassiveResourceMeasuringPointImpl();
        return assemblyPassiveResourceMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ActiveResourceMeasuringPoint createActiveResourceMeasuringPoint() {
        final ActiveResourceMeasuringPointImpl activeResourceMeasuringPoint = new ActiveResourceMeasuringPointImpl();
        return activeResourceMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SystemOperationMeasuringPoint createSystemOperationMeasuringPoint() {
        final SystemOperationMeasuringPointImpl systemOperationMeasuringPoint = new SystemOperationMeasuringPointImpl();
        return systemOperationMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public LinkingResourceMeasuringPoint createLinkingResourceMeasuringPoint() {
        final LinkingResourceMeasuringPointImpl linkingResourceMeasuringPoint = new LinkingResourceMeasuringPointImpl();
        return linkingResourceMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SubSystemOperationMeasuringPoint createSubSystemOperationMeasuringPoint() {
        final SubSystemOperationMeasuringPointImpl subSystemOperationMeasuringPoint = new SubSystemOperationMeasuringPointImpl();
        return subSystemOperationMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public UsageScenarioMeasuringPoint createUsageScenarioMeasuringPoint() {
        final UsageScenarioMeasuringPointImpl usageScenarioMeasuringPoint = new UsageScenarioMeasuringPointImpl();
        return usageScenarioMeasuringPoint;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PcmmeasuringpointPackage getPcmmeasuringpointPackage() {
        return (PcmmeasuringpointPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static PcmmeasuringpointPackage getPackage() {
        return PcmmeasuringpointPackage.eINSTANCE;
    }

} // PcmmeasuringpointFactoryImpl
