/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.tasks;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parallel Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.measurements.tasks.ParallelTask#getTasks <em>Tasks</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.measurements.tasks.TasksPackage#getParallelTask()
 * @model
 * @generated
 */
public interface ParallelTask extends AbstractTask {
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.measurements.tasks.AbstractTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see de.uka.ipd.sdq.measurements.tasks.TasksPackage#getParallelTask_Tasks()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<AbstractTask> getTasks();

} // ParallelTask
