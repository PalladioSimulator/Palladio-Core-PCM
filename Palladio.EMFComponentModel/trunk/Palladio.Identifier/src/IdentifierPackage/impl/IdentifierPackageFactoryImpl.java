/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package IdentifierPackage.impl;

import IdentifierPackage.*;

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
public class IdentifierPackageFactoryImpl extends EFactoryImpl implements IdentifierPackageFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IdentifierPackageFactory init() {
		try {
			IdentifierPackageFactory theIdentifierPackageFactory = (IdentifierPackageFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/IdentifierPackage"); 
			if (theIdentifierPackageFactory != null) {
				return theIdentifierPackageFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IdentifierPackageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierPackageFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierPackagePackage getIdentifierPackagePackage() {
		return (IdentifierPackagePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static IdentifierPackagePackage getPackage() {
		return IdentifierPackagePackage.eINSTANCE;
	}

} //IdentifierPackageFactoryImpl
