/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.impl;

import de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption;
import de.uka.ipd.sdq.pcm.system.SystemFactory;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.system.SystemProvidedRole;
import de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.system.SystemRequiredRole;

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
public class SystemFactoryImpl extends EFactoryImpl implements SystemFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SystemFactory init() {
		try {
			SystemFactory theSystemFactory = (SystemFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PalladioComponentModel/System/1.0"); 
			if (theSystemFactory != null) {
				return theSystemFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SystemFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SystemPackage.SYSTEM_REQUIRED_ROLE: return createSystemRequiredRole();
			case SystemPackage.SYSTEM: return createSystem();
			case SystemPackage.SYSTEM_PROVIDED_DELEGATION_CONNECTOR: return createSystemProvidedDelegationConnector();
			case SystemPackage.SYSTEM_REQUIRED_DELEGATION_CONNECTOR: return createSystemRequiredDelegationConnector();
			case SystemPackage.SPECIFIED_TIME_CONSUMPTION: return createSpecifiedTimeConsumption();
			case SystemPackage.SYSTEM_PROVIDED_ROLE: return createSystemProvidedRole();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemRequiredRole createSystemRequiredRole() {
		SystemRequiredRoleImpl systemRequiredRole = new SystemRequiredRoleImpl();
		return systemRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.uka.ipd.sdq.pcm.system.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemProvidedDelegationConnector createSystemProvidedDelegationConnector() {
		SystemProvidedDelegationConnectorImpl systemProvidedDelegationConnector = new SystemProvidedDelegationConnectorImpl();
		return systemProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemRequiredDelegationConnector createSystemRequiredDelegationConnector() {
		SystemRequiredDelegationConnectorImpl systemRequiredDelegationConnector = new SystemRequiredDelegationConnectorImpl();
		return systemRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecifiedTimeConsumption createSpecifiedTimeConsumption() {
		SpecifiedTimeConsumptionImpl specifiedTimeConsumption = new SpecifiedTimeConsumptionImpl();
		return specifiedTimeConsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemProvidedRole createSystemProvidedRole() {
		SystemProvidedRoleImpl systemProvidedRole = new SystemProvidedRoleImpl();
		return systemProvidedRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemPackage getSystemPackage() {
		return (SystemPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static SystemPackage getPackage() {
		return SystemPackage.eINSTANCE;
	}

} //SystemFactoryImpl
