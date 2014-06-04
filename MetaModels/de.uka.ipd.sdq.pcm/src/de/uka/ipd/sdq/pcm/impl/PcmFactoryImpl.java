/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.DummyClass;
import de.uka.ipd.sdq.pcm.PcmFactory;
import de.uka.ipd.sdq.pcm.PcmPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class PcmFactoryImpl extends EFactoryImpl implements PcmFactory {
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
    public static PcmFactory init() {
        try {
            PcmFactory thePcmFactory = (PcmFactory)EPackage.Registry.INSTANCE.getEFactory(PcmPackage.eNS_URI);
            if (thePcmFactory != null) {
                return thePcmFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new PcmFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public PcmFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case PcmPackage.DUMMY_CLASS: return (EObject)createDummyClass();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DummyClass createDummyClass() {
        DummyClassImpl dummyClass = new DummyClassImpl();
        return dummyClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public PcmPackage getPcmPackage() {
        return (PcmPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static PcmPackage getPackage() {
        return PcmPackage.eINSTANCE;
    }

} // PcmFactoryImpl
