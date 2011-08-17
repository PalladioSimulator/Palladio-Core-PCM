/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.seff_reliability.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAction;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.Seff_reliabilityFactory;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.Seff_reliabilityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Seff_reliabilityFactoryImpl extends EFactoryImpl implements Seff_reliabilityFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Seff_reliabilityFactory init() {
		try {
			Seff_reliabilityFactory theSeff_reliabilityFactory = (Seff_reliabilityFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/SEFF_Reliability/1.0"); 
			if (theSeff_reliabilityFactory != null) {
				return theSeff_reliabilityFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Seff_reliabilityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seff_reliabilityFactoryImpl() {
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
			case Seff_reliabilityPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR: return createRecoveryBlockAlternativeBehaviour();
			case Seff_reliabilityPackage.RECOVERY_BLOCK_ACTION: return createRecoveryBlockAction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecoveryBlockAlternativeBehaviour createRecoveryBlockAlternativeBehaviour() {
		RecoveryBlockAlternativeBehaviourImpl recoveryBlockAlternativeBehaviour = new RecoveryBlockAlternativeBehaviourImpl();
		return recoveryBlockAlternativeBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecoveryBlockAction createRecoveryBlockAction() {
		RecoveryBlockActionImpl recoveryBlockAction = new RecoveryBlockActionImpl();
		return recoveryBlockAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seff_reliabilityPackage getSeff_reliabilityPackage() {
		return (Seff_reliabilityPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Seff_reliabilityPackage getPackage() {
		return Seff_reliabilityPackage.eINSTANCE;
	}

} //Seff_reliabilityFactoryImpl
