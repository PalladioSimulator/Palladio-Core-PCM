/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.tasks.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.measurements.tasks.LoopTask;
import de.uka.ipd.sdq.measurements.tasks.ParallelTask;
import de.uka.ipd.sdq.measurements.tasks.SequenceTask;
import de.uka.ipd.sdq.measurements.tasks.TaskSet;
import de.uka.ipd.sdq.measurements.tasks.TasksFactory;
import de.uka.ipd.sdq.measurements.tasks.TasksPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TasksFactoryImpl extends EFactoryImpl implements TasksFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TasksFactory init() {
		try {
			TasksFactory theTasksFactory = (TasksFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/MeasurementsFramework/Tasks/1.0"); 
			if (theTasksFactory != null) {
				return theTasksFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TasksFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TasksFactoryImpl() {
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
			case TasksPackage.LOOP_TASK: return createLoopTask();
			case TasksPackage.PARALLEL_TASK: return createParallelTask();
			case TasksPackage.SEQUENCE_TASK: return createSequenceTask();
			case TasksPackage.TASK_SET: return createTaskSet();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopTask createLoopTask() {
		LoopTaskImpl loopTask = new LoopTaskImpl();
		return loopTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParallelTask createParallelTask() {
		ParallelTaskImpl parallelTask = new ParallelTaskImpl();
		return parallelTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceTask createSequenceTask() {
		SequenceTaskImpl sequenceTask = new SequenceTaskImpl();
		return sequenceTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskSet createTaskSet() {
		TaskSetImpl taskSet = new TaskSetImpl();
		return taskSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TasksPackage getTasksPackage() {
		return (TasksPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TasksPackage getPackage() {
		return TasksPackage.eINSTANCE;
	}

} //TasksFactoryImpl
