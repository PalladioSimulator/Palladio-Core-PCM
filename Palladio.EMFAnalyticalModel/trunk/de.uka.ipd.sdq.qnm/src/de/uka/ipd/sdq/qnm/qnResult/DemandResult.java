/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

import de.uka.ipd.sdq.qnm.Demand;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Demand Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult#getResponseTime <em>Response Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult#getServerUsages <em>Server Usages</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult#getDemand <em>Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult#getServiceTime <em>Service Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getDemandResult()
 * @model
 * @generated
 */
public interface DemandResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Time</em>' attribute.
	 * @see #setResponseTime(ManagedPDF)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getDemandResult_ResponseTime()
	 * @model dataType="de.uka.ipd.sdq.qnm.ManagedPDF" required="true"
	 * @generated
	 */
	ManagedPDF getResponseTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult#getResponseTime <em>Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Time</em>' attribute.
	 * @see #getResponseTime()
	 * @generated
	 */
	void setResponseTime(ManagedPDF value);

	/**
	 * Returns the value of the '<em><b>Server Usages</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getDemand <em>Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Usages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Usages</em>' reference list.
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getDemandResult_ServerUsages()
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getDemand
	 * @model type="de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage" opposite="demand"
	 * @generated
	 */
	EList getServerUsages();

	/**
	 * Returns the value of the '<em><b>Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demand</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demand</em>' reference.
	 * @see #setDemand(Demand)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getDemandResult_Demand()
	 * @model required="true"
	 * @generated
	 */
	Demand getDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult#getDemand <em>Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Demand</em>' reference.
	 * @see #getDemand()
	 * @generated
	 */
	void setDemand(Demand value);

	/**
	 * Returns the value of the '<em><b>Service Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Time</em>' attribute.
	 * @see #setServiceTime(ManagedPDF)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getDemandResult_ServiceTime()
	 * @model dataType="de.uka.ipd.sdq.qnm.ManagedPDF" required="true"
	 * @generated
	 */
	ManagedPDF getServiceTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult#getServiceTime <em>Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Time</em>' attribute.
	 * @see #getServiceTime()
	 * @generated
	 */
	void setServiceTime(ManagedPDF value);

} // DemandResult