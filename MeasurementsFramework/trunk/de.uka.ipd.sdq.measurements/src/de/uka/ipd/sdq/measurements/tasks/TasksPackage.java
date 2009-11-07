/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.tasks;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

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
 * @see de.uka.ipd.sdq.measurements.tasks.TasksFactory
 * @model kind="package"
 * @generated
 */
public interface TasksPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tasks";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/MeasurementsFramework/Tasks/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tasks";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TasksPackage eINSTANCE = de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.tasks.impl.AbstractTaskImpl <em>Abstract Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.tasks.impl.AbstractTaskImpl
	 * @see de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl#getAbstractTask()
	 * @generated
	 */
	int ABSTRACT_TASK = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__DESCRIPTION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.tasks.impl.LoopTaskImpl <em>Loop Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.tasks.impl.LoopTaskImpl
	 * @see de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl#getLoopTask()
	 * @generated
	 */
	int LOOP_TASK = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TASK__ID = ABSTRACT_TASK__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TASK__DESCRIPTION = ABSTRACT_TASK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TASK__NAME = ABSTRACT_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Number Of Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TASK__NUMBER_OF_ITERATIONS = ABSTRACT_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TASK__TASK = ABSTRACT_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Loop Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TASK_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.tasks.impl.MachineTaskImpl <em>Machine Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.tasks.impl.MachineTaskImpl
	 * @see de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl#getMachineTask()
	 * @generated
	 */
	int MACHINE_TASK = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TASK__ID = ABSTRACT_TASK__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TASK__DESCRIPTION = ABSTRACT_TASK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TASK__NAME = ABSTRACT_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TASK__MACHINE = ABSTRACT_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Machine Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TASK_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.tasks.impl.ParallelTaskImpl <em>Parallel Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.tasks.impl.ParallelTaskImpl
	 * @see de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl#getParallelTask()
	 * @generated
	 */
	int PARALLEL_TASK = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_TASK__ID = ABSTRACT_TASK__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_TASK__DESCRIPTION = ABSTRACT_TASK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_TASK__NAME = ABSTRACT_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_TASK__TASKS = ABSTRACT_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parallel Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_TASK_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.tasks.impl.SequenceTaskImpl <em>Sequence Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.tasks.impl.SequenceTaskImpl
	 * @see de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl#getSequenceTask()
	 * @generated
	 */
	int SEQUENCE_TASK = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TASK__ID = ABSTRACT_TASK__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TASK__DESCRIPTION = ABSTRACT_TASK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TASK__NAME = ABSTRACT_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TASK__TASKS = ABSTRACT_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sequence Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TASK_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.tasks.impl.TaskSetImpl <em>Task Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.tasks.impl.TaskSetImpl
	 * @see de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl#getTaskSet()
	 * @generated
	 */
	int TASK_SET = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SET__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SET__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Root Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SET__ROOT_TASK = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Probe Spec Repository</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SET__PROBE_SPEC_REPOSITORY = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Machine References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SET__MACHINE_REFERENCES = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Task Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SET_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.tasks.AbstractTask <em>Abstract Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Task</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.AbstractTask
	 * @generated
	 */
	EClass getAbstractTask();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.measurements.tasks.AbstractTask#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.AbstractTask#getDescription()
	 * @see #getAbstractTask()
	 * @generated
	 */
	EAttribute getAbstractTask_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.measurements.tasks.AbstractTask#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.AbstractTask#getName()
	 * @see #getAbstractTask()
	 * @generated
	 */
	EAttribute getAbstractTask_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.tasks.LoopTask <em>Loop Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Task</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.LoopTask
	 * @generated
	 */
	EClass getLoopTask();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.measurements.tasks.LoopTask#getNumberOfIterations <em>Number Of Iterations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Iterations</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.LoopTask#getNumberOfIterations()
	 * @see #getLoopTask()
	 * @generated
	 */
	EAttribute getLoopTask_NumberOfIterations();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.measurements.tasks.LoopTask#getTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.LoopTask#getTask()
	 * @see #getLoopTask()
	 * @generated
	 */
	EReference getLoopTask_Task();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.tasks.MachineTask <em>Machine Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Task</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.MachineTask
	 * @generated
	 */
	EClass getMachineTask();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.measurements.tasks.MachineTask#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Machine</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.MachineTask#getMachine()
	 * @see #getMachineTask()
	 * @generated
	 */
	EReference getMachineTask_Machine();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.tasks.ParallelTask <em>Parallel Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel Task</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.ParallelTask
	 * @generated
	 */
	EClass getParallelTask();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.measurements.tasks.ParallelTask#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.ParallelTask#getTasks()
	 * @see #getParallelTask()
	 * @generated
	 */
	EReference getParallelTask_Tasks();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.tasks.SequenceTask <em>Sequence Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Task</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.SequenceTask
	 * @generated
	 */
	EClass getSequenceTask();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.measurements.tasks.SequenceTask#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.SequenceTask#getTasks()
	 * @see #getSequenceTask()
	 * @generated
	 */
	EReference getSequenceTask_Tasks();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.tasks.TaskSet <em>Task Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Set</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.TaskSet
	 * @generated
	 */
	EClass getTaskSet();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.measurements.tasks.TaskSet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.TaskSet#getName()
	 * @see #getTaskSet()
	 * @generated
	 */
	EAttribute getTaskSet_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.measurements.tasks.TaskSet#getRootTask <em>Root Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root Task</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.TaskSet#getRootTask()
	 * @see #getTaskSet()
	 * @generated
	 */
	EReference getTaskSet_RootTask();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.measurements.tasks.TaskSet#getProbeSpecRepository <em>Probe Spec Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Probe Spec Repository</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.TaskSet#getProbeSpecRepository()
	 * @see #getTaskSet()
	 * @generated
	 */
	EReference getTaskSet_ProbeSpecRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.measurements.tasks.TaskSet#getMachineReferences <em>Machine References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machine References</em>'.
	 * @see de.uka.ipd.sdq.measurements.tasks.TaskSet#getMachineReferences()
	 * @see #getTaskSet()
	 * @generated
	 */
	EReference getTaskSet_MachineReferences();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TasksFactory getTasksFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.tasks.impl.AbstractTaskImpl <em>Abstract Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.tasks.impl.AbstractTaskImpl
		 * @see de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl#getAbstractTask()
		 * @generated
		 */
		EClass ABSTRACT_TASK = eINSTANCE.getAbstractTask();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_TASK__DESCRIPTION = eINSTANCE.getAbstractTask_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_TASK__NAME = eINSTANCE.getAbstractTask_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.tasks.impl.LoopTaskImpl <em>Loop Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.tasks.impl.LoopTaskImpl
		 * @see de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl#getLoopTask()
		 * @generated
		 */
		EClass LOOP_TASK = eINSTANCE.getLoopTask();

		/**
		 * The meta object literal for the '<em><b>Number Of Iterations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP_TASK__NUMBER_OF_ITERATIONS = eINSTANCE.getLoopTask_NumberOfIterations();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_TASK__TASK = eINSTANCE.getLoopTask_Task();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.tasks.impl.MachineTaskImpl <em>Machine Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.tasks.impl.MachineTaskImpl
		 * @see de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl#getMachineTask()
		 * @generated
		 */
		EClass MACHINE_TASK = eINSTANCE.getMachineTask();

		/**
		 * The meta object literal for the '<em><b>Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_TASK__MACHINE = eINSTANCE.getMachineTask_Machine();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.tasks.impl.ParallelTaskImpl <em>Parallel Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.tasks.impl.ParallelTaskImpl
		 * @see de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl#getParallelTask()
		 * @generated
		 */
		EClass PARALLEL_TASK = eINSTANCE.getParallelTask();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARALLEL_TASK__TASKS = eINSTANCE.getParallelTask_Tasks();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.tasks.impl.SequenceTaskImpl <em>Sequence Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.tasks.impl.SequenceTaskImpl
		 * @see de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl#getSequenceTask()
		 * @generated
		 */
		EClass SEQUENCE_TASK = eINSTANCE.getSequenceTask();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_TASK__TASKS = eINSTANCE.getSequenceTask_Tasks();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.tasks.impl.TaskSetImpl <em>Task Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.tasks.impl.TaskSetImpl
		 * @see de.uka.ipd.sdq.measurements.tasks.impl.TasksPackageImpl#getTaskSet()
		 * @generated
		 */
		EClass TASK_SET = eINSTANCE.getTaskSet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_SET__NAME = eINSTANCE.getTaskSet_Name();

		/**
		 * The meta object literal for the '<em><b>Root Task</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_SET__ROOT_TASK = eINSTANCE.getTaskSet_RootTask();

		/**
		 * The meta object literal for the '<em><b>Probe Spec Repository</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_SET__PROBE_SPEC_REPOSITORY = eINSTANCE.getTaskSet_ProbeSpecRepository();

		/**
		 * The meta object literal for the '<em><b>Machine References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_SET__MACHINE_REFERENCES = eINSTANCE.getTaskSet_MachineReferences();

	}

} //TasksPackage
