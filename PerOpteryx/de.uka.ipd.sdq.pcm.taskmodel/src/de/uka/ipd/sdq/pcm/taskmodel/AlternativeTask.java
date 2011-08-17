/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.taskmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * To model the exchange of components, we need a mapping from an AlternativeTask (e.g. A') to the original Task it can replace (e.g. A). Note that AlternativeTasks may have different a probability of execution than their original Task. Additionally, they specify their own Edges. 
 * 
 * The mapping is derived from the degrees of freedom during the transformation. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.AlternativeTask#getTask_AlternativeTask <em>Task Alternative Task</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getAlternativeTask()
 * @model
 * @generated
 */
public interface AlternativeTask extends Task {
	/**
	 * Returns the value of the '<em><b>Task Alternative Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Alternative Task</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Alternative Task</em>' reference.
	 * @see #setTask_AlternativeTask(Task)
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getAlternativeTask_Task_AlternativeTask()
	 * @model ordered="false"
	 * @generated
	 */
	Task getTask_AlternativeTask();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.taskmodel.AlternativeTask#getTask_AlternativeTask <em>Task Alternative Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Alternative Task</em>' reference.
	 * @see #getTask_AlternativeTask()
	 * @generated
	 */
	void setTask_AlternativeTask(Task value);

} // AlternativeTask
