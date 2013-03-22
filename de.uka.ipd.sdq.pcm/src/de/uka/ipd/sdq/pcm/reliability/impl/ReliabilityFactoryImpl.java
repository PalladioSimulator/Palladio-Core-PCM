/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityFactory;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType;
import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ReliabilityFactoryImpl extends EFactoryImpl implements ReliabilityFactory {
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
    public static ReliabilityFactory init() {
		try {
			ReliabilityFactory theReliabilityFactory = (ReliabilityFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PalladioComponentModel/Reliability/5.0"); 
			if (theReliabilityFactory != null) {
				return theReliabilityFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ReliabilityFactoryImpl();
	}

    /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ReliabilityFactoryImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE: return createHardwareInducedFailureType();
			case ReliabilityPackage.SOFTWARE_INDUCED_FAILURE_TYPE: return createSoftwareInducedFailureType();
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION: return createInternalFailureOccurrenceDescription();
			case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE: return createNetworkInducedFailureType();
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION: return createExternalFailureOccurrenceDescription();
			case ReliabilityPackage.RESOURCE_TIMEOUT_FAILURE_TYPE: return createResourceTimeoutFailureType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public HardwareInducedFailureType createHardwareInducedFailureType() {
		HardwareInducedFailureTypeImpl hardwareInducedFailureType = new HardwareInducedFailureTypeImpl();
		return hardwareInducedFailureType;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ExternalFailureOccurrenceDescription createExternalFailureOccurrenceDescription() {
		ExternalFailureOccurrenceDescriptionImpl externalFailureOccurrenceDescription = new ExternalFailureOccurrenceDescriptionImpl();
		return externalFailureOccurrenceDescription;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ResourceTimeoutFailureType createResourceTimeoutFailureType() {
		ResourceTimeoutFailureTypeImpl resourceTimeoutFailureType = new ResourceTimeoutFailureTypeImpl();
		return resourceTimeoutFailureType;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public NetworkInducedFailureType createNetworkInducedFailureType() {
		NetworkInducedFailureTypeImpl networkInducedFailureType = new NetworkInducedFailureTypeImpl();
		return networkInducedFailureType;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public InternalFailureOccurrenceDescription createInternalFailureOccurrenceDescription() {
		InternalFailureOccurrenceDescriptionImpl internalFailureOccurrenceDescription = new InternalFailureOccurrenceDescriptionImpl();
		return internalFailureOccurrenceDescription;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public SoftwareInducedFailureType createSoftwareInducedFailureType() {
		SoftwareInducedFailureTypeImpl softwareInducedFailureType = new SoftwareInducedFailureTypeImpl();
		return softwareInducedFailureType;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ReliabilityPackage getReliabilityPackage() {
		return (ReliabilityPackage)getEPackage();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
    @Deprecated
    public static ReliabilityPackage getPackage() {
		return ReliabilityPackage.eINSTANCE;
	}

} // ReliabilityFactoryImpl
