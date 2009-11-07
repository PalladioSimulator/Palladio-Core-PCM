/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.tasks.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.measurements.tasks.*;
import de.uka.ipd.sdq.measurements.tasks.AbstractTask;
import de.uka.ipd.sdq.measurements.tasks.LoopTask;
import de.uka.ipd.sdq.measurements.tasks.MachineTask;
import de.uka.ipd.sdq.measurements.tasks.ParallelTask;
import de.uka.ipd.sdq.measurements.tasks.SequenceTask;
import de.uka.ipd.sdq.measurements.tasks.TaskSet;
import de.uka.ipd.sdq.measurements.tasks.TasksPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.measurements.tasks.TasksPackage
 * @generated
 */
public class TasksSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TasksPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TasksSwitch() {
		if (modelPackage == null) {
			modelPackage = TasksPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TasksPackage.ABSTRACT_TASK: {
				AbstractTask abstractTask = (AbstractTask)theEObject;
				T result = caseAbstractTask(abstractTask);
				if (result == null) result = caseIdentifier(abstractTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TasksPackage.LOOP_TASK: {
				LoopTask loopTask = (LoopTask)theEObject;
				T result = caseLoopTask(loopTask);
				if (result == null) result = caseAbstractTask(loopTask);
				if (result == null) result = caseIdentifier(loopTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TasksPackage.MACHINE_TASK: {
				MachineTask machineTask = (MachineTask)theEObject;
				T result = caseMachineTask(machineTask);
				if (result == null) result = caseAbstractTask(machineTask);
				if (result == null) result = caseIdentifier(machineTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TasksPackage.PARALLEL_TASK: {
				ParallelTask parallelTask = (ParallelTask)theEObject;
				T result = caseParallelTask(parallelTask);
				if (result == null) result = caseAbstractTask(parallelTask);
				if (result == null) result = caseIdentifier(parallelTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TasksPackage.SEQUENCE_TASK: {
				SequenceTask sequenceTask = (SequenceTask)theEObject;
				T result = caseSequenceTask(sequenceTask);
				if (result == null) result = caseAbstractTask(sequenceTask);
				if (result == null) result = caseIdentifier(sequenceTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TasksPackage.TASK_SET: {
				TaskSet taskSet = (TaskSet)theEObject;
				T result = caseTaskSet(taskSet);
				if (result == null) result = caseIdentifier(taskSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTask(AbstractTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopTask(LoopTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Machine Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Machine Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMachineTask(MachineTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parallel Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parallel Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParallelTask(ParallelTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceTask(SequenceTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskSet(TaskSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //TasksSwitch
