/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

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
 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsFactory
 * @model kind="package"
 * @generated
 */
public interface QosannotationsPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qosannotations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/QoSAnnotations/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcm.qosannotations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QosannotationsPackage eINSTANCE = de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedExecutionTimeImpl <em>Specified Execution Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedExecutionTimeImpl
	 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl#getSpecifiedExecutionTime()
	 * @generated
	 */
	int SPECIFIED_EXECUTION_TIME = 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_EXECUTION_TIME__SPECIFICATION = StoexPackage.RANDOM_VARIABLE__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Signature Specified Time Consumption</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_TIME_CONSUMPTION = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Role Specified Execution Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_EXECUTION_TIME = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Specified Execution Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_EXECUTION_TIME_FEATURE_COUNT = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedFailureProbabilityImpl <em>Specified Failure Probability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedFailureProbabilityImpl
	 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl#getSpecifiedFailureProbability()
	 * @generated
	 */
	int SPECIFIED_FAILURE_PROBABILITY = 1;

	/**
	 * The number of structural features of the '<em>Specified Failure Probability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_FAILURE_PROBABILITY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SystemSpecifiedExecutionTimeImpl <em>System Specified Execution Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.SystemSpecifiedExecutionTimeImpl
	 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl#getSystemSpecifiedExecutionTime()
	 * @generated
	 */
	int SYSTEM_SPECIFIED_EXECUTION_TIME = 2;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_SPECIFIED_EXECUTION_TIME__SPECIFICATION = SPECIFIED_EXECUTION_TIME__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Signature Specified Time Consumption</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_TIME_CONSUMPTION = SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_TIME_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Role Specified Execution Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_EXECUTION_TIME = SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_EXECUTION_TIME;

	/**
	 * The number of structural features of the '<em>System Specified Execution Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_SPECIFIED_EXECUTION_TIME_FEATURE_COUNT = SPECIFIED_EXECUTION_TIME_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.qosannotations.impl.ComponentSpecifiedExecutionTimeImpl <em>Component Specified Execution Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.ComponentSpecifiedExecutionTimeImpl
	 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl#getComponentSpecifiedExecutionTime()
	 * @generated
	 */
	int COMPONENT_SPECIFIED_EXECUTION_TIME = 3;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SPECIFIED_EXECUTION_TIME__SPECIFICATION = SPECIFIED_EXECUTION_TIME__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Signature Specified Time Consumption</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_TIME_CONSUMPTION = SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_TIME_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Role Specified Execution Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_EXECUTION_TIME = SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_EXECUTION_TIME;

	/**
	 * The feature id for the '<em><b>Assembly Context Component Specified Execution Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME = SPECIFIED_EXECUTION_TIME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Specified Execution Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SPECIFIED_EXECUTION_TIME_FEATURE_COUNT = SPECIFIED_EXECUTION_TIME_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.qosannotations.impl.QoSAnnotationsImpl <em>Qo SAnnotations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QoSAnnotationsImpl
	 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl#getQoSAnnotations()
	 * @generated
	 */
	int QO_SANNOTATIONS = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SANNOTATIONS__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SANNOTATIONS__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Specified Execution Times Qo SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SANNOTATIONS__SPECIFIED_EXECUTION_TIMES_QO_SANNOTATIONS = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Qo SAnnotations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SANNOTATIONS_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedExecutionTime <em>Specified Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specified Execution Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.SpecifiedExecutionTime
	 * @generated
	 */
	EClass getSpecifiedExecutionTime();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedExecutionTime#getSignature_SpecifiedTimeConsumption <em>Signature Specified Time Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature Specified Time Consumption</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.SpecifiedExecutionTime#getSignature_SpecifiedTimeConsumption()
	 * @see #getSpecifiedExecutionTime()
	 * @generated
	 */
	EReference getSpecifiedExecutionTime_Signature_SpecifiedTimeConsumption();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedExecutionTime#getRole_SpecifiedExecutionTime <em>Role Specified Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role Specified Execution Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.SpecifiedExecutionTime#getRole_SpecifiedExecutionTime()
	 * @see #getSpecifiedExecutionTime()
	 * @generated
	 */
	EReference getSpecifiedExecutionTime_Role_SpecifiedExecutionTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedFailureProbability <em>Specified Failure Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specified Failure Probability</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.SpecifiedFailureProbability
	 * @generated
	 */
	EClass getSpecifiedFailureProbability();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.qosannotations.SystemSpecifiedExecutionTime <em>System Specified Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Specified Execution Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.SystemSpecifiedExecutionTime
	 * @generated
	 */
	EClass getSystemSpecifiedExecutionTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.qosannotations.ComponentSpecifiedExecutionTime <em>Component Specified Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Specified Execution Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.ComponentSpecifiedExecutionTime
	 * @generated
	 */
	EClass getComponentSpecifiedExecutionTime();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.qosannotations.ComponentSpecifiedExecutionTime#getAssemblyContext_ComponentSpecifiedExecutionTime <em>Assembly Context Component Specified Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context Component Specified Execution Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.ComponentSpecifiedExecutionTime#getAssemblyContext_ComponentSpecifiedExecutionTime()
	 * @see #getComponentSpecifiedExecutionTime()
	 * @generated
	 */
	EReference getComponentSpecifiedExecutionTime_AssemblyContext_ComponentSpecifiedExecutionTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations <em>Qo SAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qo SAnnotations</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations
	 * @generated
	 */
	EClass getQoSAnnotations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations#getSpecifiedExecutionTimes_QoSAnnotations <em>Specified Execution Times Qo SAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Specified Execution Times Qo SAnnotations</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations#getSpecifiedExecutionTimes_QoSAnnotations()
	 * @see #getQoSAnnotations()
	 * @generated
	 */
	EReference getQoSAnnotations_SpecifiedExecutionTimes_QoSAnnotations();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QosannotationsFactory getQosannotationsFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedExecutionTimeImpl <em>Specified Execution Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedExecutionTimeImpl
		 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl#getSpecifiedExecutionTime()
		 * @generated
		 */
		EClass SPECIFIED_EXECUTION_TIME = eINSTANCE.getSpecifiedExecutionTime();

		/**
		 * The meta object literal for the '<em><b>Signature Specified Time Consumption</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIED_EXECUTION_TIME__SIGNATURE_SPECIFIED_TIME_CONSUMPTION = eINSTANCE.getSpecifiedExecutionTime_Signature_SpecifiedTimeConsumption();

		/**
		 * The meta object literal for the '<em><b>Role Specified Execution Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIED_EXECUTION_TIME__ROLE_SPECIFIED_EXECUTION_TIME = eINSTANCE.getSpecifiedExecutionTime_Role_SpecifiedExecutionTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedFailureProbabilityImpl <em>Specified Failure Probability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedFailureProbabilityImpl
		 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl#getSpecifiedFailureProbability()
		 * @generated
		 */
		EClass SPECIFIED_FAILURE_PROBABILITY = eINSTANCE.getSpecifiedFailureProbability();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SystemSpecifiedExecutionTimeImpl <em>System Specified Execution Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.SystemSpecifiedExecutionTimeImpl
		 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl#getSystemSpecifiedExecutionTime()
		 * @generated
		 */
		EClass SYSTEM_SPECIFIED_EXECUTION_TIME = eINSTANCE.getSystemSpecifiedExecutionTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.qosannotations.impl.ComponentSpecifiedExecutionTimeImpl <em>Component Specified Execution Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.ComponentSpecifiedExecutionTimeImpl
		 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl#getComponentSpecifiedExecutionTime()
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

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.qosannotations.impl.QoSAnnotationsImpl <em>Qo SAnnotations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QoSAnnotationsImpl
		 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl#getQoSAnnotations()
		 * @generated
		 */
		EClass QO_SANNOTATIONS = eINSTANCE.getQoSAnnotations();

		/**
		 * The meta object literal for the '<em><b>Specified Execution Times Qo SAnnotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QO_SANNOTATIONS__SPECIFIED_EXECUTION_TIMES_QO_SANNOTATIONS = eINSTANCE.getQoSAnnotations_SpecifiedExecutionTimes_QoSAnnotations();

	}

} //QosannotationsPackage
