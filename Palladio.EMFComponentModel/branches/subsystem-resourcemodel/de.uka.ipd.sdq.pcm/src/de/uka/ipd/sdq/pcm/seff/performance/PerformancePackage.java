/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.performance;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.seff.performance.PerformanceFactory
 * @model kind="package"
 * @generated
 */
public interface PerformancePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "performance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/Performance/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PerformancePackage eINSTANCE = de.uka.ipd.sdq.pcm.seff.performance.impl.PerformancePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.performance.impl.ParametricResourceDemandImpl <em>Parametric Resource Demand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.performance.impl.ParametricResourceDemandImpl
	 * @see de.uka.ipd.sdq.pcm.seff.performance.impl.PerformancePackageImpl#getParametricResourceDemand()
	 * @generated
	 */
	int PARAMETRIC_RESOURCE_DEMAND = 0;

	/**
	 * The feature id for the '<em><b>Specification Parameteric Resource Demand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND = 0;

	/**
	 * The feature id for the '<em><b>Required Resource Parametric Resource Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND = 1;

	/**
	 * The feature id for the '<em><b>Action Parametric Resource Demand</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND = 2;

	/**
	 * The number of structural features of the '<em>Parametric Resource Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand <em>Parametric Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametric Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand
	 * @generated
	 */
	EClass getParametricResourceDemand();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getSpecification_ParametericResourceDemand <em>Specification Parameteric Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification Parameteric Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getSpecification_ParametericResourceDemand()
	 * @see #getParametricResourceDemand()
	 * @generated
	 */
	EReference getParametricResourceDemand_Specification_ParametericResourceDemand();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getRequiredResource_ParametricResourceDemand <em>Required Resource Parametric Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Resource Parametric Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getRequiredResource_ParametricResourceDemand()
	 * @see #getParametricResourceDemand()
	 * @generated
	 */
	EReference getParametricResourceDemand_RequiredResource_ParametricResourceDemand();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getAction_ParametricResourceDemand <em>Action Parametric Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Action Parametric Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getAction_ParametricResourceDemand()
	 * @see #getParametricResourceDemand()
	 * @generated
	 */
	EReference getParametricResourceDemand_Action_ParametricResourceDemand();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PerformanceFactory getPerformanceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.performance.impl.ParametricResourceDemandImpl <em>Parametric Resource Demand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.performance.impl.ParametricResourceDemandImpl
		 * @see de.uka.ipd.sdq.pcm.seff.performance.impl.PerformancePackageImpl#getParametricResourceDemand()
		 * @generated
		 */
		EClass PARAMETRIC_RESOURCE_DEMAND = eINSTANCE.getParametricResourceDemand();

		/**
		 * The meta object literal for the '<em><b>Specification Parameteric Resource Demand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND = eINSTANCE.getParametricResourceDemand_Specification_ParametericResourceDemand();

		/**
		 * The meta object literal for the '<em><b>Required Resource Parametric Resource Demand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND = eINSTANCE.getParametricResourceDemand_RequiredResource_ParametricResourceDemand();

		/**
		 * The meta object literal for the '<em><b>Action Parametric Resource Demand</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND = eINSTANCE.getParametricResourceDemand_Action_ParametricResourceDemand();

	}

} //PerformancePackage
