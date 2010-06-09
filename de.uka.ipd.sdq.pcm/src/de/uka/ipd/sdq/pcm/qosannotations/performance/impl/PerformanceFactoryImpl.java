/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.performance.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.qosannotations.performance.ComponentSpecifiedExecutionTime;
import de.uka.ipd.sdq.pcm.qosannotations.performance.PerformanceFactory;
import de.uka.ipd.sdq.pcm.qosannotations.performance.PerformancePackage;
import de.uka.ipd.sdq.pcm.qosannotations.performance.SystemSpecifiedExecutionTime;

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
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PerformanceFactory init() {
		try {
			PerformanceFactory thePerformanceFactory = (PerformanceFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PalladioComponentModel/QoSAnnotations/Performance/4.0"); 
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
			case PerformancePackage.SYSTEM_SPECIFIED_EXECUTION_TIME: return createSystemSpecifiedExecutionTime();
			case PerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME: return createComponentSpecifiedExecutionTime();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemSpecifiedExecutionTime createSystemSpecifiedExecutionTime() {
		SystemSpecifiedExecutionTimeImpl systemSpecifiedExecutionTime = new SystemSpecifiedExecutionTimeImpl();
		return systemSpecifiedExecutionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentSpecifiedExecutionTime createComponentSpecifiedExecutionTime() {
		ComponentSpecifiedExecutionTimeImpl componentSpecifiedExecutionTime = new ComponentSpecifiedExecutionTimeImpl();
		return componentSpecifiedExecutionTime;
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
