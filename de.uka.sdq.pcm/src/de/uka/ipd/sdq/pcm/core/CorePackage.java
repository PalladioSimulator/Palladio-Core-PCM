/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import de.uka.ipd.sdq.stoex.StoexPackage;

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
 * <!-- begin-model-doc -->
 * This package contains the PCM Core meta-classes used throughout the PCM: entities carrying a  globally unique ID (GUID), an abstract model for entities which provide and require interfaces, and  an abstract model to describe entities composed from other entities.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.core.CoreFactory
 * @model kind="package"
 * @generated
 */
public interface CorePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "core";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Core/4.0";

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
	CorePackage eINSTANCE = de.uka.ipd.sdq.pcm.core.impl.CorePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.impl.PCMRandomVariableImpl <em>PCM Random Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.impl.PCMRandomVariableImpl
	 * @see de.uka.ipd.sdq.pcm.core.impl.CorePackageImpl#getPCMRandomVariable()
	 * @generated
	 */
	int PCM_RANDOM_VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__SPECIFICATION = StoexPackage.RANDOM_VARIABLE__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__EXPRESSION = StoexPackage.RANDOM_VARIABLE__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Closed Workload PCM Random Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Passive Resource capacity PCM Random Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parametric Resource Demand PCM Random Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Loop Action PCM Random Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Guarded Branch Transition PCM Random Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Open Workload PCM Random Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Communication Link Resource Specifcation throughput PCM Random Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Processing Resource Specification processing Rate PCM Random Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Communication Link Resource Specification latency PCM Random Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>PCM Random Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE_FEATURE_COUNT = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 9;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable <em>PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable
	 * @generated
	 */
	EClass getPCMRandomVariable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getClosedWorkload_PCMRandomVariable <em>Closed Workload PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Closed Workload PCM Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getClosedWorkload_PCMRandomVariable()
	 * @see #getPCMRandomVariable()
	 * @generated
	 */
	EReference getPCMRandomVariable_ClosedWorkload_PCMRandomVariable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getPassiveResource_capacity_PCMRandomVariable <em>Passive Resource capacity PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Passive Resource capacity PCM Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getPassiveResource_capacity_PCMRandomVariable()
	 * @see #getPCMRandomVariable()
	 * @generated
	 */
	EReference getPCMRandomVariable_PassiveResource_capacity_PCMRandomVariable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getParametricResourceDemand_PCMRandomVariable <em>Parametric Resource Demand PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parametric Resource Demand PCM Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getParametricResourceDemand_PCMRandomVariable()
	 * @see #getPCMRandomVariable()
	 * @generated
	 */
	EReference getPCMRandomVariable_ParametricResourceDemand_PCMRandomVariable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getLoopAction_PCMRandomVariable <em>Loop Action PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Loop Action PCM Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getLoopAction_PCMRandomVariable()
	 * @see #getPCMRandomVariable()
	 * @generated
	 */
	EReference getPCMRandomVariable_LoopAction_PCMRandomVariable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getGuardedBranchTransition_PCMRandomVariable <em>Guarded Branch Transition PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Guarded Branch Transition PCM Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getGuardedBranchTransition_PCMRandomVariable()
	 * @see #getPCMRandomVariable()
	 * @generated
	 */
	EReference getPCMRandomVariable_GuardedBranchTransition_PCMRandomVariable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getOpenWorkload_PCMRandomVariable <em>Open Workload PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Open Workload PCM Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getOpenWorkload_PCMRandomVariable()
	 * @see #getPCMRandomVariable()
	 * @generated
	 */
	EReference getPCMRandomVariable_OpenWorkload_PCMRandomVariable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable <em>Communication Link Resource Specifcation throughput PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Communication Link Resource Specifcation throughput PCM Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable()
	 * @see #getPCMRandomVariable()
	 * @generated
	 */
	EReference getPCMRandomVariable_CommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getProcessingResourceSpecification_processingRate_PCMRandomVariable <em>Processing Resource Specification processing Rate PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Processing Resource Specification processing Rate PCM Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getProcessingResourceSpecification_processingRate_PCMRandomVariable()
	 * @see #getPCMRandomVariable()
	 * @generated
	 */
	EReference getPCMRandomVariable_ProcessingResourceSpecification_processingRate_PCMRandomVariable();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getCommunicationLinkResourceSpecification_latency_PCMRandomVariable <em>Communication Link Resource Specification latency PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Communication Link Resource Specification latency PCM Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getCommunicationLinkResourceSpecification_latency_PCMRandomVariable()
	 * @see #getPCMRandomVariable()
	 * @generated
	 */
	EReference getPCMRandomVariable_CommunicationLinkResourceSpecification_latency_PCMRandomVariable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoreFactory getCoreFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.impl.PCMRandomVariableImpl <em>PCM Random Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.impl.PCMRandomVariableImpl
		 * @see de.uka.ipd.sdq.pcm.core.impl.CorePackageImpl#getPCMRandomVariable()
		 * @generated
		 */
		EClass PCM_RANDOM_VARIABLE = eINSTANCE.getPCMRandomVariable();
		/**
		 * The meta object literal for the '<em><b>Closed Workload PCM Random Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_RANDOM_VARIABLE__CLOSED_WORKLOAD_PCM_RANDOM_VARIABLE = eINSTANCE.getPCMRandomVariable_ClosedWorkload_PCMRandomVariable();
		/**
		 * The meta object literal for the '<em><b>Passive Resource capacity PCM Random Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_RANDOM_VARIABLE__PASSIVE_RESOURCE_CAPACITY_PCM_RANDOM_VARIABLE = eINSTANCE.getPCMRandomVariable_PassiveResource_capacity_PCMRandomVariable();
		/**
		 * The meta object literal for the '<em><b>Parametric Resource Demand PCM Random Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE = eINSTANCE.getPCMRandomVariable_ParametricResourceDemand_PCMRandomVariable();
		/**
		 * The meta object literal for the '<em><b>Loop Action PCM Random Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE = eINSTANCE.getPCMRandomVariable_LoopAction_PCMRandomVariable();
		/**
		 * The meta object literal for the '<em><b>Guarded Branch Transition PCM Random Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE = eINSTANCE.getPCMRandomVariable_GuardedBranchTransition_PCMRandomVariable();
		/**
		 * The meta object literal for the '<em><b>Open Workload PCM Random Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_RANDOM_VARIABLE__OPEN_WORKLOAD_PCM_RANDOM_VARIABLE = eINSTANCE.getPCMRandomVariable_OpenWorkload_PCMRandomVariable();
		/**
		 * The meta object literal for the '<em><b>Communication Link Resource Specifcation throughput PCM Random Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFCATION_THROUGHPUT_PCM_RANDOM_VARIABLE = eINSTANCE.getPCMRandomVariable_CommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable();
		/**
		 * The meta object literal for the '<em><b>Processing Resource Specification processing Rate PCM Random Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_RANDOM_VARIABLE__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RATE_PCM_RANDOM_VARIABLE = eINSTANCE.getPCMRandomVariable_ProcessingResourceSpecification_processingRate_PCMRandomVariable();
		/**
		 * The meta object literal for the '<em><b>Communication Link Resource Specification latency PCM Random Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_RANDOM_VARIABLE__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_LATENCY_PCM_RANDOM_VARIABLE = eINSTANCE.getPCMRandomVariable_CommunicationLinkResourceSpecification_latency_PCMRandomVariable();

	}

} //CorePackage
