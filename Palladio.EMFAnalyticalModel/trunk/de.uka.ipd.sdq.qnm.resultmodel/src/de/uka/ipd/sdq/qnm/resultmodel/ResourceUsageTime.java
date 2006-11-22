/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Usage Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getResourceUsage <em>Resource Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getServiceTime <em>Service Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getResponseTime <em>Response Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getServiceTimeBreakDowns <em>Service Time Break Downs</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getResourceUsageTime()
 * @model
 * @generated
 */
public interface ResourceUsageTime extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource Usage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Usage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Usage</em>' reference.
	 * @see #setResourceUsage(AbstractResourceUsage)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getResourceUsageTime_ResourceUsage()
	 * @model required="true"
	 * @generated
	 */
	AbstractResourceUsage getResourceUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getResourceUsage <em>Resource Usage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Usage</em>' reference.
	 * @see #getResourceUsage()
	 * @generated
	 */
	void setResourceUsage(AbstractResourceUsage value);

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
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getResourceUsageTime_ServiceTime()
	 * @model dataType="de.uka.ipd.sdq.qnm.resultmodel.ManagedPDF" required="true"
	 * @generated
	 */
	ManagedPDF getServiceTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getServiceTime <em>Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Time</em>' attribute.
	 * @see #getServiceTime()
	 * @generated
	 */
	void setServiceTime(ManagedPDF value);

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
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getResourceUsageTime_ResponseTime()
	 * @model dataType="de.uka.ipd.sdq.qnm.resultmodel.ManagedPDF" required="true"
	 * @generated
	 */
	ManagedPDF getResponseTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime#getResponseTime <em>Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Time</em>' attribute.
	 * @see #getResponseTime()
	 * @generated
	 */
	void setResponseTime(ManagedPDF value);

	/**
	 * Returns the value of the '<em><b>Service Time Break Downs</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Time Break Downs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Time Break Downs</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getResourceUsageTime_ServiceTimeBreakDowns()
	 * @model type="de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown" containment="true"
	 * @generated
	 */
	EList getServiceTimeBreakDowns();

} // ResourceUsageTime