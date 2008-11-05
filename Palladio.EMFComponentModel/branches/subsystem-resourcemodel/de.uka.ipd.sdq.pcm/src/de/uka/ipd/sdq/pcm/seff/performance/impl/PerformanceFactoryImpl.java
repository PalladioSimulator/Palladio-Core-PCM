/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.performance.impl;

import de.uka.ipd.sdq.pcm.seff.performance.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.performance.PerformanceFactory;
import de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PerformanceFactoryImpl extends EFactoryImpl implements PerformanceFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PerformanceFactory init() {
		try {
			PerformanceFactory thePerformanceFactory = (PerformanceFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/Performance/1.0"); 
			if (thePerformanceFactory != null) {
				return thePerformanceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PerformanceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerformanceFactoryImpl() {
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
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND: return createParametricResourceDemand();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricResourceDemand createParametricResourceDemand() {
		ParametricResourceDemandImpl parametricResourceDemand = new ParametricResourceDemandImpl();
		return parametricResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerformancePackage getPerformancePackage() {
		return (PerformancePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PerformancePackage getPackage() {
		return PerformancePackage.eINSTANCE;
	}

} //PerformanceFactoryImpl
