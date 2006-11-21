/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel;

import de.uka.ipd.sdq.qnm.Task;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResult#getTask <em>Task</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResult#getTaskresourceusages <em>Taskresourceusages</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage#getTaskResult()
 * @model
 * @generated
 */
public interface TaskResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' reference.
	 * @see #setTask(Task)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage#getTaskResult_Task()
	 * @model required="true"
	 * @generated
	 */
	Task getTask();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResult#getTask <em>Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task</em>' reference.
	 * @see #getTask()
	 * @generated
	 */
	void setTask(Task value);

	/**
	 * Returns the value of the '<em><b>Taskresourceusages</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getTaskresult <em>Taskresult</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Taskresourceusages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Taskresourceusages</em>' reference list.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage#getTaskResult_Taskresourceusages()
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getTaskresult
	 * @model type="de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage" opposite="taskresult"
	 * @generated
	 */
	EList getTaskresourceusages();

} // TaskResult