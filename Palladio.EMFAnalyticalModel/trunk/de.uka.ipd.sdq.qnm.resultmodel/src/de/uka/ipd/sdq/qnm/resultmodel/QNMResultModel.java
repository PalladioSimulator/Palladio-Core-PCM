/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel;

import de.uka.ipd.sdq.qnm.QNModel;

import de.uka.ipd.sdq.qnm.Task;

import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;

import de.uka.ipd.sdq.spa.resourcemodel.Resource;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>QNM Result Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getQnmodel <em>Qnmodel</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getResourceResults <em>Resource Results</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getTaskResults <em>Task Results</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getTaskresourceusages <em>Taskresourceusages</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getResourceUsageTimes <em>Resource Usage Times</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage#getQNMResultModel()
 * @model
 * @generated
 */
public interface QNMResultModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Qnmodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qnmodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qnmodel</em>' reference.
	 * @see #setQnmodel(QNModel)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage#getQNMResultModel_Qnmodel()
	 * @model required="true"
	 * @generated
	 */
	QNModel getQnmodel();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getQnmodel <em>Qnmodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qnmodel</em>' reference.
	 * @see #getQnmodel()
	 * @generated
	 */
	void setQnmodel(QNModel value);

	/**
	 * Returns the value of the '<em><b>Resource Results</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.resultmodel.ResourceResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Results</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage#getQNMResultModel_ResourceResults()
	 * @model type="de.uka.ipd.sdq.qnm.resultmodel.ResourceResult" containment="true"
	 * @generated
	 */
	EList getResourceResults();

	/**
	 * Returns the value of the '<em><b>Task Results</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.resultmodel.TaskResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Results</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage#getQNMResultModel_TaskResults()
	 * @model type="de.uka.ipd.sdq.qnm.resultmodel.TaskResult" containment="true"
	 * @generated
	 */
	EList getTaskResults();

	/**
	 * Returns the value of the '<em><b>Taskresourceusages</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Taskresourceusages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Taskresourceusages</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage#getQNMResultModel_Taskresourceusages()
	 * @model type="de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage" containment="true"
	 * @generated
	 */
	EList getTaskresourceusages();

	/**
	 * Returns the value of the '<em><b>Resource Usage Times</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Usage Times</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Usage Times</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage#getQNMResultModel_ResourceUsageTimes()
	 * @model type="de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime" containment="true"
	 * @generated
	 */
	EList getResourceUsageTimes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResourceUsageTime getTimeForResourceUsage(AbstractResourceUsage resourceUsage);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	TaskResult getResultForTask(Task task);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResourceResult getResultForResource(Resource OwnedParameter1);

} // QNMResultModel