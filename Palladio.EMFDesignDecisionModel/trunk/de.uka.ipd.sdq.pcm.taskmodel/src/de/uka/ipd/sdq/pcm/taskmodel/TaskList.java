/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.taskmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The root model element that contains all Tasks of this model. Additionally, it contains a set of Alternatives, that contain AlternativeTasks to model component selection options. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.TaskList#getTask_TaskList <em>Task Task List</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.TaskList#getStartTask_TaskList <em>Start Task Task List</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.TaskList#getAlternative_TaskList <em>Alternative Task List</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTaskList()
 * @model
 * @generated
 */
public interface TaskList extends EObject {
	/**
	 * Returns the value of the '<em><b>Task Task List</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.taskmodel.Task}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of Tasks in the model. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Task Task List</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTaskList_Task_TaskList()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Task> getTask_TaskList();

	/**
	 * Returns the value of the '<em><b>Start Task Task List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Task Task List</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Task Task List</em>' reference.
	 * @see #setStartTask_TaskList(Task)
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTaskList_StartTask_TaskList()
	 * @model ordered="false"
	 * @generated
	 */
	Task getStartTask_TaskList();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.taskmodel.TaskList#getStartTask_TaskList <em>Start Task Task List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Task Task List</em>' reference.
	 * @see #getStartTask_TaskList()
	 * @generated
	 */
	void setStartTask_TaskList(Task value);

	/**
	 * Returns the value of the '<em><b>Alternative Task List</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.taskmodel.Alternative}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternative Task List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternative Task List</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTaskList_Alternative_TaskList()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Alternative> getAlternative_TaskList();

} // TaskList
