/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.assembly.impl;

import de.uka.ipd.sdq.pcm.assembly.*;

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
public class AssemblyFactoryImpl extends EFactoryImpl implements AssemblyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AssemblyFactory init() {
		try {
			AssemblyFactory theAssemblyFactory = (AssemblyFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PalladioComponentModel/Assembly/1.0"); 
			if (theAssemblyFactory != null) {
				return theAssemblyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AssemblyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR: return createSystemAssemblyConnector();
			case AssemblyPackage.ASSEMBLY_CONTEXT: return createAssemblyContext();
			case AssemblyPackage.ASSEMBLY: return createAssembly();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemAssemblyConnector createSystemAssemblyConnector() {
		SystemAssemblyConnectorImpl systemAssemblyConnector = new SystemAssemblyConnectorImpl();
		return systemAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext createAssemblyContext() {
		AssemblyContextImpl assemblyContext = new AssemblyContextImpl();
		return assemblyContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assembly createAssembly() {
		AssemblyImpl assembly = new AssemblyImpl();
		return assembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyPackage getAssemblyPackage() {
		return (AssemblyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static AssemblyPackage getPackage() {
		return AssemblyPackage.eINSTANCE;
	}

} //AssemblyFactoryImpl
