/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult;

import de.uka.ipd.sdq.qnm.Customer;
import de.uka.ipd.sdq.qnm.Server;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.CustomerResult#getCustomer <em>Customer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.CustomerResult#getServerUsage <em>Server Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getCustomerResult()
 * @model
 * @generated
 */
public interface CustomerResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Customer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer</em>' reference.
	 * @see #setCustomer(Customer)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getCustomerResult_Customer()
	 * @model required="true"
	 * @generated
	 */
	Customer getCustomer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerResult#getCustomer <em>Customer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer</em>' reference.
	 * @see #getCustomer()
	 * @generated
	 */
	void setCustomer(Customer value);

	/**
	 * Returns the value of the '<em><b>Server Usage</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCustomerResult <em>Customer Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Usage</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Usage</em>' reference list.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getCustomerResult_ServerUsage()
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCustomerResult
	 * @model type="de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage" opposite="customerResult"
	 * @generated
	 */
	EList getServerUsage();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	CustomerServerUsage getServerUsage(Server server);

} // CustomerResult