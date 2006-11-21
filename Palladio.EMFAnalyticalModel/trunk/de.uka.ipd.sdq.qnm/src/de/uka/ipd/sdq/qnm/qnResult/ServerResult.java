/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult;

import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.qnm.Resource;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.ServerResult#getUsingCustomers <em>Using Customers</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.ServerResult#getServer <em>Server</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.ServerResult#getUsageDemands <em>Usage Demands</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getServerResult()
 * @model
 * @generated
 */
public interface ServerResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Using Customers</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getServerResult <em>Server Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Using Customers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Using Customers</em>' reference list.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getServerResult_UsingCustomers()
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getServerResult
	 * @model type="de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage" opposite="serverResult"
	 * @generated
	 */
	EList getUsingCustomers();

	/**
	 * Returns the value of the '<em><b>Server</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server</em>' reference.
	 * @see #setServer(Resource)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getServerResult_Server()
	 * @model required="true"
	 * @generated
	 */
	Resource getServer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.ServerResult#getServer <em>Server</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server</em>' reference.
	 * @see #getServer()
	 * @generated
	 */
	void setServer(Resource value);

	/**
	 * Returns the value of the '<em><b>Usage Demands</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getServer <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Demands</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Demands</em>' reference list.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getServerResult_UsageDemands()
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getServer
	 * @model type="de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage" opposite="server"
	 * @generated
	 */
	EList getUsageDemands();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	CustomerServerUsage getUsageByCustomer(Task customer);

} // ServerResult