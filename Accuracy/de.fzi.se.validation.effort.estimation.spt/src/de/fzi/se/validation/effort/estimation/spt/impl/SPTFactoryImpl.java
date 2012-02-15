/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.effort.estimation.spt.impl;

import de.fzi.se.validation.effort.estimation.spt.*;

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
public class SPTFactoryImpl extends EFactoryImpl implements SPTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SPTFactory init() {
		try {
			SPTFactory theSPTFactory = (SPTFactory)EPackage.Registry.INSTANCE.getEFactory("http://se.fzi.de/ValidationEffortEstimation/SPT/0.5"); 
			if (theSPTFactory != null) {
				return theSPTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SPTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPTFactoryImpl() {
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
			case SPTPackage.SPT_EFFORT_ESTIMATION_RESULT: return createSPTEffortEstimationResult();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPTEffortEstimationResult createSPTEffortEstimationResult() {
		SPTEffortEstimationResultImpl sptEffortEstimationResult = new SPTEffortEstimationResultImpl();
		return sptEffortEstimationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPTPackage getSPTPackage() {
		return (SPTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SPTPackage getPackage() {
		return SPTPackage.eINSTANCE;
	}

} //SPTFactoryImpl
