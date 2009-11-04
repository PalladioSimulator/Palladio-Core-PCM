/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.performance;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;

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
 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.PerformanceFactory
 * @model kind="package"
 * @generated
 */
public interface PerformancePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

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
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/QoSAnnotations/Performance/4.0";

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
	PerformancePackage eINSTANCE = de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.qosannotations.performance.impl.SystemSpecifiedExecutionTimeImpl <em>System Specified Execution Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.impl.SystemSpecifiedExecutionTimeImpl
	 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl#getSystemSpecifiedExecutionTime()
	 * @generated
	 */
	int SYSTEM_SPECIFIED_EXECUTION_TIME = 0;

	/**
	 * The feature id for the '<em><b>Signature Specified Qo SAnnation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_QO_SANNATION = QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION;

	/**
	 * The feature id for the '<em><b>Role Specified Qo SAnnotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_QO_SANNOTATION = QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION;

	/**
	 * The feature id for the '<em><b>Specification Specified Execution Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_SPECIFIED_EXECUTION_TIME__SPECIFICATION_SPECIFIED_EXECUTION_TIME = QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME;

	/**
	 * The number of structural features of the '<em>System Specified Execution Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_SPECIFIED_EXECUTION_TIME_FEATURE_COUNT = QosannotationsPackage.SPECIFIED_QO_SANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.qosannotations.performance.impl.ComponentSpecifiedExecutionTimeImpl <em>Component Specified Execution Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.impl.ComponentSpecifiedExecutionTimeImpl
	 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl#getComponentSpecifiedExecutionTime()
	 * @generated
	 */
	int COMPONENT_SPECIFIED_EXECUTION_TIME = 1;

	/**
	 * The feature id for the '<em><b>Signature Specified Qo SAnnation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_QO_SANNATION = QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION;

	/**
	 * The feature id for the '<em><b>Role Specified Qo SAnnotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_QO_SANNOTATION = QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION;

	/**
	 * The feature id for the '<em><b>Specification Specified Execution Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SPECIFIED_EXECUTION_TIME__SPECIFICATION_SPECIFIED_EXECUTION_TIME = QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME;

	/**
	 * The feature id for the '<em><b>Assembly Context Component Specified Execution Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME = QosannotationsPackage.SPECIFIED_QO_SANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Specified Execution Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SPECIFIED_EXECUTION_TIME_FEATURE_COUNT = QosannotationsPackage.SPECIFIED_QO_SANNOTATION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.qosannotations.performance.SystemSpecifiedExecutionTime <em>System Specified Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Specified Execution Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.SystemSpecifiedExecutionTime
	 * @generated
	 */
	EClass getSystemSpecifiedExecutionTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.qosannotations.performance.ComponentSpecifiedExecutionTime <em>Component Specified Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Specified Execution Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.ComponentSpecifiedExecutionTime
	 * @generated
	 */
	EClass getComponentSpecifiedExecutionTime();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.qosannotations.performance.ComponentSpecifiedExecutionTime#getAssemblyContext_ComponentSpecifiedExecutionTime <em>Assembly Context Component Specified Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context Component Specified Execution Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.ComponentSpecifiedExecutionTime#getAssemblyContext_ComponentSpecifiedExecutionTime()
	 * @see #getComponentSpecifiedExecutionTime()
	 * @generated
	 */
	EReference getComponentSpecifiedExecutionTime_AssemblyContext_ComponentSpecifiedExecutionTime();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.qosannotations.performance.impl.SystemSpecifiedExecutionTimeImpl <em>System Specified Execution Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.impl.SystemSpecifiedExecutionTimeImpl
		 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl#getSystemSpecifiedExecutionTime()
		 * @generated
		 */
		EClass SYSTEM_SPECIFIED_EXECUTION_TIME = eINSTANCE.getSystemSpecifiedExecutionTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.qosannotations.performance.impl.ComponentSpecifiedExecutionTimeImpl <em>Component Specified Execution Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.impl.ComponentSpecifiedExecutionTimeImpl
		 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl#getComponentSpecifiedExecutionTime()
		 * @generated
		 */
		EClass COMPONENT_SPECIFIED_EXECUTION_TIME = eINSTANCE.getComponentSpecifiedExecutionTime();

		/**
		 * The meta object literal for the '<em><b>Assembly Context Component Specified Execution Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME = eINSTANCE.getComponentSpecifiedExecutionTime_AssemblyContext_ComponentSpecifiedExecutionTime();

	}

} //PerformancePackage
