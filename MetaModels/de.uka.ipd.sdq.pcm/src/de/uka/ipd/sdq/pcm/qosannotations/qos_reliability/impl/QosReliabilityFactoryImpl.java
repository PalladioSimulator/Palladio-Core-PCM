/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.QosReliabilityFactory;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.QosReliabilityPackage;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.SpecifiedReliabilityAnnotation;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class QosReliabilityFactoryImpl extends EFactoryImpl implements QosReliabilityFactory {
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
    public static QosReliabilityFactory init() {
        try {
            QosReliabilityFactory theQosReliabilityFactory = (QosReliabilityFactory)EPackage.Registry.INSTANCE.getEFactory(QosReliabilityPackage.eNS_URI);
            if (theQosReliabilityFactory != null) {
                return theQosReliabilityFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new QosReliabilityFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public QosReliabilityFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case QosReliabilityPackage.SPECIFIED_RELIABILITY_ANNOTATION: return createSpecifiedReliabilityAnnotation();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public SpecifiedReliabilityAnnotation createSpecifiedReliabilityAnnotation() {
        SpecifiedReliabilityAnnotationImpl specifiedReliabilityAnnotation = new SpecifiedReliabilityAnnotationImpl();
        return specifiedReliabilityAnnotation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public QosReliabilityPackage getQosReliabilityPackage() {
        return (QosReliabilityPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static QosReliabilityPackage getPackage() {
        return QosReliabilityPackage.eINSTANCE;
    }

} // QosReliabilityFactoryImpl
