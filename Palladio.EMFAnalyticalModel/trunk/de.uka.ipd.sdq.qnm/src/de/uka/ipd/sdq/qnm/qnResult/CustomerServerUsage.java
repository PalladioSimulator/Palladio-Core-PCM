/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer Server Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCustomerResult <em>Customer Result</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getServerResult <em>Server Result</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCausedWaitingTime <em>Caused Waiting Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCausedWaitingTimeOneLess <em>Caused Waiting Time One Less</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getQueueLength <em>Queue Length</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getQueueLengthOneLess <em>Queue Length One Less</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getDemandsToServer <em>Demands To Server</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCustomerServiceTime <em>Customer Service Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getCustomerServerUsage()
 * @model
 * @generated
 */
public interface CustomerServerUsage extends EObject {
	/**
	 * Returns the value of the '<em><b>Customer Result</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerResult#getServerUsage <em>Server Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer Result</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer Result</em>' reference.
	 * @see #setCustomerResult(CustomerResult)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getCustomerServerUsage_CustomerResult()
	 * @see de.uka.ipd.sdq.qnm.qnResult.CustomerResult#getServerUsage
	 * @model opposite="serverUsage" required="true"
	 * @generated
	 */
	CustomerResult getCustomerResult();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCustomerResult <em>Customer Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer Result</em>' reference.
	 * @see #getCustomerResult()
	 * @generated
	 */
	void setCustomerResult(CustomerResult value);

	/**
	 * Returns the value of the '<em><b>Server Result</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.qnm.qnResult.ServerResult#getUsingCustomers <em>Using Customers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Result</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Result</em>' reference.
	 * @see #setServerResult(ServerResult)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getCustomerServerUsage_ServerResult()
	 * @see de.uka.ipd.sdq.qnm.qnResult.ServerResult#getUsingCustomers
	 * @model opposite="usingCustomers" required="true"
	 * @generated
	 */
	ServerResult getServerResult();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getServerResult <em>Server Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Result</em>' reference.
	 * @see #getServerResult()
	 * @generated
	 */
	void setServerResult(ServerResult value);

	/**
	 * Returns the value of the '<em><b>Caused Waiting Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caused Waiting Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caused Waiting Time</em>' attribute.
	 * @see #setCausedWaitingTime(ManagedPDF)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getCustomerServerUsage_CausedWaitingTime()
	 * @model dataType="de.uka.ipd.sdq.qnm.ManagedPDF" required="true"
	 * @generated
	 */
	ManagedPDF getCausedWaitingTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCausedWaitingTime <em>Caused Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caused Waiting Time</em>' attribute.
	 * @see #getCausedWaitingTime()
	 * @generated
	 */
	void setCausedWaitingTime(ManagedPDF value);

	/**
	 * Returns the value of the '<em><b>Caused Waiting Time One Less</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caused Waiting Time One Less</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caused Waiting Time One Less</em>' attribute.
	 * @see #setCausedWaitingTimeOneLess(ManagedPDF)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getCustomerServerUsage_CausedWaitingTimeOneLess()
	 * @model dataType="de.uka.ipd.sdq.qnm.ManagedPDF" required="true"
	 * @generated
	 */
	ManagedPDF getCausedWaitingTimeOneLess();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCausedWaitingTimeOneLess <em>Caused Waiting Time One Less</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caused Waiting Time One Less</em>' attribute.
	 * @see #getCausedWaitingTimeOneLess()
	 * @generated
	 */
	void setCausedWaitingTimeOneLess(ManagedPDF value);

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
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getCustomerServerUsage_QueueLength()
	 * @model dataType="de.uka.ipd.sdq.qnm.ManagedPMF" required="true"
	 * @generated
	 */
	ManagedPMF getQueueLength();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getQueueLength <em>Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Length</em>' attribute.
	 * @see #getQueueLength()
	 * @generated
	 */
	void setQueueLength(ManagedPMF value);

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
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getCustomerServerUsage_QueueLengthOneLess()
	 * @model dataType="de.uka.ipd.sdq.qnm.ManagedPMF" required="true"
	 * @generated
	 */
	ManagedPMF getQueueLengthOneLess();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getQueueLengthOneLess <em>Queue Length One Less</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Length One Less</em>' attribute.
	 * @see #getQueueLengthOneLess()
	 * @generated
	 */
	void setQueueLengthOneLess(ManagedPMF value);

	/**
	 * Returns the value of the '<em><b>Demands To Server</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.qnResult.DemandResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demands To Server</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demands To Server</em>' reference list.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getCustomerServerUsage_DemandsToServer()
	 * @model type="de.uka.ipd.sdq.qnm.qnResult.DemandResult"
	 * @generated
	 */
	EList getDemandsToServer();

	/**
	 * Returns the value of the '<em><b>Customer Service Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer Service Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer Service Time</em>' attribute.
	 * @see #setCustomerServiceTime(ManagedPDF)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getCustomerServerUsage_CustomerServiceTime()
	 * @model dataType="de.uka.ipd.sdq.qnm.ManagedPDF" required="true"
	 * @generated
	 */
	ManagedPDF getCustomerServiceTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage#getCustomerServiceTime <em>Customer Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer Service Time</em>' attribute.
	 * @see #getCustomerServiceTime()
	 * @generated
	 */
	void setCustomerServiceTime(ManagedPDF value);

} // CustomerServerUsage