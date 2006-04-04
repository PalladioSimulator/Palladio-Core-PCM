/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucom.model.simucom.impl;

import de.uka.ipd.sdq.simucom.model.simucom.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimuComModelFactoryImpl extends EFactoryImpl implements SimuComModelFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by Steffen Becker, 2006"; //$NON-NLS-1$

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimuComModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SimuComModelPackage.SIMULATED_ARCHITECTURE: return createSimulatedArchitecture();
			case SimuComModelPackage.SIMULATED_COMPONENT: return createSimulatedComponent();
			case SimuComModelPackage.SIMULATED_METHOD: return createSimulatedMethod();
			case SimuComModelPackage.SERVICE_EFFECT: return createServiceEffect();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulatedArchitecture createSimulatedArchitecture() {
		SimulatedArchitectureImpl simulatedArchitecture = new SimulatedArchitectureImpl();
		return simulatedArchitecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulatedComponent createSimulatedComponent() {
		SimulatedComponentImpl simulatedComponent = new SimulatedComponentImpl();
		return simulatedComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulatedMethod createSimulatedMethod() {
		SimulatedMethodImpl simulatedMethod = new SimulatedMethodImpl();
		return simulatedMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceEffect createServiceEffect() {
		ServiceEffectImpl serviceEffect = new ServiceEffectImpl();
		return serviceEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimuComModelPackage getSimuComModelPackage() {
		return (SimuComModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static SimuComModelPackage getPackage() {
		return SimuComModelPackage.eINSTANCE;
	}

} //SimuComModelFactoryImpl
