/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult;

import de.uka.ipd.sdq.qnm.Customer;
import de.uka.ipd.sdq.qnm.Demand;
import de.uka.ipd.sdq.qnm.QNModel;

import de.uka.ipd.sdq.qnm.Server;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getCustomerServerUsage <em>Customer Server Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getQnModel <em>Qn Model</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getCustomerResults <em>Customer Results</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getServerResults <em>Server Results</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getDemandResults <em>Demand Results</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getDemandServerUsages <em>Demand Server Usages</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getQNResultModel()
 * @model
 * @generated
 */
public interface QNResultModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Customer Server Usage</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer Server Usage</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer Server Usage</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getQNResultModel_CustomerServerUsage()
	 * @model type="de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage" containment="true"
	 * @generated
	 */
	EList getCustomerServerUsage();

	/**
	 * Returns the value of the '<em><b>Qn Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qn Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qn Model</em>' reference.
	 * @see #setQnModel(QNModel)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getQNResultModel_QnModel()
	 * @model required="true"
	 * @generated
	 */
	QNModel getQnModel();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.QNResultModel#getQnModel <em>Qn Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qn Model</em>' reference.
	 * @see #getQnModel()
	 * @generated
	 */
	void setQnModel(QNModel value);

	/**
	 * Returns the value of the '<em><b>Customer Results</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.qnResult.CustomerResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customerresults</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer Results</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getQNResultModel_CustomerResults()
	 * @model type="de.uka.ipd.sdq.qnm.qnResult.CustomerResult" containment="true"
	 * @generated
	 */
	EList getCustomerResults();

	/**
	 * Returns the value of the '<em><b>Server Results</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.qnResult.ServerResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serverresults</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Results</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getQNResultModel_ServerResults()
	 * @model type="de.uka.ipd.sdq.qnm.qnResult.ServerResult" containment="true"
	 * @generated
	 */
	EList getServerResults();

	/**
	 * Returns the value of the '<em><b>Demand Results</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.qnResult.DemandResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demand Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demand Results</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getQNResultModel_DemandResults()
	 * @model type="de.uka.ipd.sdq.qnm.qnResult.DemandResult" containment="true"
	 * @generated
	 */
	EList getDemandResults();

	/**
	 * Returns the value of the '<em><b>Demand Server Usages</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demand Server Usages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demand Server Usages</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getQNResultModel_DemandServerUsages()
	 * @model type="de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage" containment="true"
	 * @generated
	 */
	EList getDemandServerUsages();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ServerResult getResultForServer(Server server);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	CustomerResult getResultForCustomer(Customer customer);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DemandResult getResultForDemand(Demand demand);

} // QNResultModel