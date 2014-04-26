/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package de.uka.ipd.sdq.pcm.seff.seff_performance.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformanceFactory;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class SeffPerformanceFactoryImpl extends EFactoryImpl implements SeffPerformanceFactory {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static SeffPerformanceFactory init() {
        try {
            SeffPerformanceFactory theSeffPerformanceFactory = (SeffPerformanceFactory)EPackage.Registry.INSTANCE.getEFactory(SeffPerformancePackage.eNS_URI);
            if (theSeffPerformanceFactory != null) {
                return theSeffPerformanceFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SeffPerformanceFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public SeffPerformanceFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case SeffPerformancePackage.INFRASTRUCTURE_CALL: return createInfrastructureCall();
            case SeffPerformancePackage.RESOURCE_CALL: return createResourceCall();
            case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND: return createParametricResourceDemand();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureCall createInfrastructureCall() {
        InfrastructureCallImpl infrastructureCall = new InfrastructureCallImpl();
        return infrastructureCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ResourceCall createResourceCall() {
        ResourceCallImpl resourceCall = new ResourceCallImpl();
        return resourceCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ParametricResourceDemand createParametricResourceDemand() {
        ParametricResourceDemandImpl parametricResourceDemand = new ParametricResourceDemandImpl();
        return parametricResourceDemand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public SeffPerformancePackage getSeffPerformancePackage() {
        return (SeffPerformancePackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SeffPerformancePackage getPackage() {
        return SeffPerformancePackage.eINSTANCE;
    }

} // SeffPerformanceFactoryImpl
