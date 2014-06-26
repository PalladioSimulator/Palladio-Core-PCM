/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.simucom.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimucomFactoryImpl extends EFactoryImpl implements SimucomFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimucomFactory init() {
		try {
			SimucomFactory theSimucomFactory = (SimucomFactory)EPackage.Registry.INSTANCE.getEFactory(SimucomPackage.eNS_URI);
			if (theSimucomFactory != null) {
				return theSimucomFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SimucomFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimucomFactoryImpl() {
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
			case SimucomPackage.SIMU_COM_CONFIGURATION: return createSimuComConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimuComConfiguration createSimuComConfiguration() {
		SimuComConfigurationImpl simuComConfiguration = new SimuComConfigurationImpl();
		return simuComConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimucomPackage getSimucomPackage() {
		return (SimucomPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SimucomPackage getPackage() {
		return SimucomPackage.eINSTANCE;
	}

} //SimucomFactoryImpl
