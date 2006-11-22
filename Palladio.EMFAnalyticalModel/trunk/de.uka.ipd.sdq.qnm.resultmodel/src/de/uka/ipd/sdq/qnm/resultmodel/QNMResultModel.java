/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel;

import de.uka.ipd.sdq.qnm.QNModel;

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
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getTaskResourceUsages <em>Task Resource Usages</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel#getResourceUsageTimes <em>Resource Usage Times</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getQNMResultModel()
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
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getQNMResultModel_Qnmodel()
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
	 * Returns the value of the '<em><b>Task Resource Usages</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Resource Usages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Resource Usages</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getQNMResultModel_TaskResourceUsages()
	 * @model type="de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage" containment="true"
	 * @generated
	 */
	EList getTaskResourceUsages();

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
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getQNMResultModel_ResourceUsageTimes()
	 * @model type="de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime" containment="true"
	 * @generated
	 */
	EList getResourceUsageTimes();

} // QNMResultModel