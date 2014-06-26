/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.simcomp.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.simcomp.*;

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
public class SimcompFactoryImpl extends EFactoryImpl implements SimcompFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimcompFactory init() {
		try {
			SimcompFactory theSimcompFactory = (SimcompFactory)EPackage.Registry.INSTANCE.getEFactory(SimcompPackage.eNS_URI);
			if (theSimcompFactory != null) {
				return theSimcompFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SimcompFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimcompFactoryImpl() {
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
			case SimcompPackage.SIM_COMP_CONFIGURATION: return createSimCompConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimCompConfiguration createSimCompConfiguration() {
		SimCompConfigurationImpl simCompConfiguration = new SimCompConfigurationImpl();
		return simCompConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimcompPackage getSimcompPackage() {
		return (SimcompPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SimcompPackage getPackage() {
		return SimcompPackage.eINSTANCE;
	}

} //SimcompFactoryImpl
