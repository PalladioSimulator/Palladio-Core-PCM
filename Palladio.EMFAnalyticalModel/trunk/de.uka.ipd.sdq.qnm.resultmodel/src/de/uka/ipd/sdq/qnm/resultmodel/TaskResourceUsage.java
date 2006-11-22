/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

import de.uka.ipd.sdq.qnm.Task;

import de.uka.ipd.sdq.spa.resourcemodel.Resource;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Resource Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getQueueLengthOneLess <em>Queue Length One Less</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getQueueLength <em>Queue Length</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getTaskServiceTime <em>Task Service Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getWaitingTimeOneLess <em>Waiting Time One Less</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getWaitingTime <em>Waiting Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getTask <em>Task</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getTaskResourceUsage()
 * @model
 * @generated
 */
public interface TaskResourceUsage extends EObject {
	/**
	 * Returns the value of the '<em><b>Queue Length One Less</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Length One Less</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Length One Less</em>' attribute.
	 * @see #setQueueLengthOneLess(ManagedPMF)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getTaskResourceUsage_QueueLengthOneLess()
	 * @model dataType="de.uka.ipd.sdq.qnm.resultmodel.ManagedPMF" required="true"
	 * @generated
	 */
	ManagedPMF getQueueLengthOneLess();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getQueueLengthOneLess <em>Queue Length One Less</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Length One Less</em>' attribute.
	 * @see #getQueueLengthOneLess()
	 * @generated
	 */
	void setQueueLengthOneLess(ManagedPMF value);

	/**
	 * Returns the value of the '<em><b>Queue Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Length</em>' attribute.
	 * @see #setQueueLength(ManagedPMF)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getTaskResourceUsage_QueueLength()
	 * @model dataType="de.uka.ipd.sdq.qnm.resultmodel.ManagedPMF" required="true"
	 * @generated
	 */
	ManagedPMF getQueueLength();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getQueueLength <em>Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Length</em>' attribute.
	 * @see #getQueueLength()
	 * @generated
	 */
	void setQueueLength(ManagedPMF value);

	/**
	 * Returns the value of the '<em><b>Task Service Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Service Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Service Time</em>' attribute.
	 * @see #setTaskServiceTime(ManagedPDF)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getTaskResourceUsage_TaskServiceTime()
	 * @model dataType="de.uka.ipd.sdq.qnm.resultmodel.ManagedPDF" required="true"
	 * @generated
	 */
	ManagedPDF getTaskServiceTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getTaskServiceTime <em>Task Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Service Time</em>' attribute.
	 * @see #getTaskServiceTime()
	 * @generated
	 */
	void setTaskServiceTime(ManagedPDF value);

	/**
	 * Returns the value of the '<em><b>Waiting Time One Less</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Waiting Time One Less</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waiting Time One Less</em>' attribute.
	 * @see #setWaitingTimeOneLess(ManagedPDF)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getTaskResourceUsage_WaitingTimeOneLess()
	 * @model dataType="de.uka.ipd.sdq.qnm.resultmodel.ManagedPDF" required="true"
	 * @generated
	 */
	ManagedPDF getWaitingTimeOneLess();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getWaitingTimeOneLess <em>Waiting Time One Less</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Waiting Time One Less</em>' attribute.
	 * @see #getWaitingTimeOneLess()
	 * @generated
	 */
	void setWaitingTimeOneLess(ManagedPDF value);

	/**
	 * Returns the value of the '<em><b>Waiting Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Waiting Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waiting Time</em>' attribute.
	 * @see #setWaitingTime(ManagedPDF)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getTaskResourceUsage_WaitingTime()
	 * @model dataType="de.uka.ipd.sdq.qnm.resultmodel.ManagedPDF" required="true"
	 * @generated
	 */
	ManagedPDF getWaitingTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getWaitingTime <em>Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Waiting Time</em>' attribute.
	 * @see #getWaitingTime()
	 * @generated
	 */
	void setWaitingTime(ManagedPDF value);

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
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getTaskResourceUsage_Task()
	 * @model required="true"
	 * @generated
	 */
	Task getTask();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getTask <em>Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task</em>' reference.
	 * @see #getTask()
	 * @generated
	 */
	void setTask(Task value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(Resource)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getTaskResourceUsage_Resource()
	 * @model required="true"
	 * @generated
	 */
	Resource getResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(Resource value);

} // TaskResourceUsage