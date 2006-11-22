/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage;

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
 * @see de.uka.ipd.sdq.qnm.QnmFactory
 * @model kind="package"
 * @generated
 */
public interface QnmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qnm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/QueueingNetworkModel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qnm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QnmPackage eINSTANCE = de.uka.ipd.sdq.qnm.impl.QnmPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.QNModelImpl <em>QN Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.QNModelImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getQNModel()
	 * @generated
	 */
	int QN_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_MODEL__TASKS = 0;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_MODEL__RESOURCES = 1;

	/**
	 * The number of structural features of the '<em>QN Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QN_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.TaskImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 1;

	/**
	 * The feature id for the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NUM_REPLICAS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NAME = 1;

	/**
	 * The feature id for the '<em><b>Resource Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__RESOURCE_USAGE = 2;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.CompositeResourceUsageImpl <em>Composite Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.CompositeResourceUsageImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getCompositeResourceUsage()
	 * @generated
	 */
	int COMPOSITE_RESOURCE_USAGE = 2;

	/**
	 * The feature id for the '<em><b>Passive Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_RESOURCE_USAGE__PASSIVE_RESOURCE = ResourceModelPackage.ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_RESOURCE_USAGE__RESOURCE_USAGES = ResourceModelPackage.ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_RESOURCE_USAGE_FEATURE_COUNT = ResourceModelPackage.ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.SequentialResourceUsageImpl <em>Sequential Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.SequentialResourceUsageImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getSequentialResourceUsage()
	 * @generated
	 */
	int SEQUENTIAL_RESOURCE_USAGE = 3;

	/**
	 * The feature id for the '<em><b>Passive Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_RESOURCE_USAGE__PASSIVE_RESOURCE = COMPOSITE_RESOURCE_USAGE__PASSIVE_RESOURCE;

	/**
	 * The feature id for the '<em><b>Resource Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_RESOURCE_USAGE__RESOURCE_USAGES = COMPOSITE_RESOURCE_USAGE__RESOURCE_USAGES;

	/**
	 * The number of structural features of the '<em>Sequential Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_RESOURCE_USAGE_FEATURE_COUNT = COMPOSITE_RESOURCE_USAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.AlternativeResourceUsageImpl <em>Alternative Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.AlternativeResourceUsageImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getAlternativeResourceUsage()
	 * @generated
	 */
	int ALTERNATIVE_RESOURCE_USAGE = 4;

	/**
	 * The feature id for the '<em><b>Passive Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_RESOURCE_USAGE__PASSIVE_RESOURCE = COMPOSITE_RESOURCE_USAGE__PASSIVE_RESOURCE;

	/**
	 * The feature id for the '<em><b>Resource Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_RESOURCE_USAGE__RESOURCE_USAGES = COMPOSITE_RESOURCE_USAGE__RESOURCE_USAGES;

	/**
	 * The number of structural features of the '<em>Alternative Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_RESOURCE_USAGE_FEATURE_COUNT = COMPOSITE_RESOURCE_USAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.IterativeResourceUsageImpl <em>Iterative Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.IterativeResourceUsageImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getIterativeResourceUsage()
	 * @generated
	 */
	int ITERATIVE_RESOURCE_USAGE = 5;

	/**
	 * The feature id for the '<em><b>Passive Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_RESOURCE_USAGE__PASSIVE_RESOURCE = COMPOSITE_RESOURCE_USAGE__PASSIVE_RESOURCE;

	/**
	 * The feature id for the '<em><b>Resource Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_RESOURCE_USAGE__RESOURCE_USAGES = COMPOSITE_RESOURCE_USAGE__RESOURCE_USAGES;

	/**
	 * The number of structural features of the '<em>Iterative Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATIVE_RESOURCE_USAGE_FEATURE_COUNT = COMPOSITE_RESOURCE_USAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.qnm.impl.ParallelResourceUsageImpl <em>Parallel Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.qnm.impl.ParallelResourceUsageImpl
	 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getParallelResourceUsage()
	 * @generated
	 */
	int PARALLEL_RESOURCE_USAGE = 6;

	/**
	 * The feature id for the '<em><b>Passive Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_RESOURCE_USAGE__PASSIVE_RESOURCE = COMPOSITE_RESOURCE_USAGE__PASSIVE_RESOURCE;

	/**
	 * The feature id for the '<em><b>Resource Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_RESOURCE_USAGE__RESOURCE_USAGES = COMPOSITE_RESOURCE_USAGE__RESOURCE_USAGES;

	/**
	 * The number of structural features of the '<em>Parallel Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_RESOURCE_USAGE_FEATURE_COUNT = COMPOSITE_RESOURCE_USAGE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.QNModel <em>QN Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QN Model</em>'.
	 * @see de.uka.ipd.sdq.qnm.QNModel
	 * @generated
	 */
	EClass getQNModel();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.QNModel#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see de.uka.ipd.sdq.qnm.QNModel#getTasks()
	 * @see #getQNModel()
	 * @generated
	 */
	EReference getQNModel_Tasks();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.QNModel#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see de.uka.ipd.sdq.qnm.QNModel#getResources()
	 * @see #getQNModel()
	 * @generated
	 */
	EReference getQNModel_Resources();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see de.uka.ipd.sdq.qnm.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.Task#getNumReplicas <em>Num Replicas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Replicas</em>'.
	 * @see de.uka.ipd.sdq.qnm.Task#getNumReplicas()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_NumReplicas();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.qnm.Task#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.qnm.Task#getName()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.qnm.Task#getResourceUsage <em>Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.qnm.Task#getResourceUsage()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_ResourceUsage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.CompositeResourceUsage <em>Composite Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.qnm.CompositeResourceUsage
	 * @generated
	 */
	EClass getCompositeResourceUsage();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.qnm.CompositeResourceUsage#getPassiveResource <em>Passive Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Passive Resource</em>'.
	 * @see de.uka.ipd.sdq.qnm.CompositeResourceUsage#getPassiveResource()
	 * @see #getCompositeResourceUsage()
	 * @generated
	 */
	EReference getCompositeResourceUsage_PassiveResource();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.qnm.CompositeResourceUsage#getResourceUsages <em>Resource Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Usages</em>'.
	 * @see de.uka.ipd.sdq.qnm.CompositeResourceUsage#getResourceUsages()
	 * @see #getCompositeResourceUsage()
	 * @generated
	 */
	EReference getCompositeResourceUsage_ResourceUsages();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.SequentialResourceUsage <em>Sequential Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequential Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.qnm.SequentialResourceUsage
	 * @generated
	 */
	EClass getSequentialResourceUsage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.AlternativeResourceUsage <em>Alternative Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.qnm.AlternativeResourceUsage
	 * @generated
	 */
	EClass getAlternativeResourceUsage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.IterativeResourceUsage <em>Iterative Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterative Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.qnm.IterativeResourceUsage
	 * @generated
	 */
	EClass getIterativeResourceUsage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.qnm.ParallelResourceUsage <em>Parallel Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.qnm.ParallelResourceUsage
	 * @generated
	 */
	EClass getParallelResourceUsage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QnmFactory getQnmFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.QNModelImpl <em>QN Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.QNModelImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getQNModel()
		 * @generated
		 */
		EClass QN_MODEL = eINSTANCE.getQNModel();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QN_MODEL__TASKS = eINSTANCE.getQNModel_Tasks();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QN_MODEL__RESOURCES = eINSTANCE.getQNModel_Resources();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.TaskImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em><b>Num Replicas</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__NUM_REPLICAS = eINSTANCE.getTask_NumReplicas();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__NAME = eINSTANCE.getTask_Name();

		/**
		 * The meta object literal for the '<em><b>Resource Usage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__RESOURCE_USAGE = eINSTANCE.getTask_ResourceUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.CompositeResourceUsageImpl <em>Composite Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.CompositeResourceUsageImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getCompositeResourceUsage()
		 * @generated
		 */
		EClass COMPOSITE_RESOURCE_USAGE = eINSTANCE.getCompositeResourceUsage();

		/**
		 * The meta object literal for the '<em><b>Passive Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_RESOURCE_USAGE__PASSIVE_RESOURCE = eINSTANCE.getCompositeResourceUsage_PassiveResource();

		/**
		 * The meta object literal for the '<em><b>Resource Usages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_RESOURCE_USAGE__RESOURCE_USAGES = eINSTANCE.getCompositeResourceUsage_ResourceUsages();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.SequentialResourceUsageImpl <em>Sequential Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.SequentialResourceUsageImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getSequentialResourceUsage()
		 * @generated
		 */
		EClass SEQUENTIAL_RESOURCE_USAGE = eINSTANCE.getSequentialResourceUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.AlternativeResourceUsageImpl <em>Alternative Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.AlternativeResourceUsageImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getAlternativeResourceUsage()
		 * @generated
		 */
		EClass ALTERNATIVE_RESOURCE_USAGE = eINSTANCE.getAlternativeResourceUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.IterativeResourceUsageImpl <em>Iterative Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.IterativeResourceUsageImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getIterativeResourceUsage()
		 * @generated
		 */
		EClass ITERATIVE_RESOURCE_USAGE = eINSTANCE.getIterativeResourceUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.qnm.impl.ParallelResourceUsageImpl <em>Parallel Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.qnm.impl.ParallelResourceUsageImpl
		 * @see de.uka.ipd.sdq.qnm.impl.QnmPackageImpl#getParallelResourceUsage()
		 * @generated
		 */
		EClass PARALLEL_RESOURCE_USAGE = eINSTANCE.getParallelResourceUsage();

	}

} //QnmPackage
