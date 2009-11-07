/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.tasks;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.measurements.tasks.TasksPackage
 * @generated
 */
public interface TasksFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TasksFactory eINSTANCE = de.uka.ipd.sdq.measurements.tasks.impl.TasksFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Loop Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Task</em>'.
	 * @generated
	 */
	LoopTask createLoopTask();

	/**
	 * Returns a new object of class '<em>Parallel Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parallel Task</em>'.
	 * @generated
	 */
	ParallelTask createParallelTask();

	/**
	 * Returns a new object of class '<em>Sequence Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Task</em>'.
	 * @generated
	 */
	SequenceTask createSequenceTask();

	/**
	 * Returns a new object of class '<em>Task Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Set</em>'.
	 * @generated
	 */
	TaskSet createTaskSet();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TasksPackage getTasksPackage();

} //TasksFactory
