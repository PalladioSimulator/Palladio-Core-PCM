/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel;

import de.uka.ipd.sdq.spa.resourcemodel.Resource;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Time Break Down</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown#getUsageProbability <em>Usage Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown#getUsageTime <em>Usage Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown#getUsedResource <em>Used Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getServiceTimeBreakDown()
 * @model
 * @generated
 */
public interface ServiceTimeBreakDown extends EObject {
	/**
	 * Returns the value of the '<em><b>Usage Probability</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Probability</em>' attribute.
	 * @see #setUsageProbability(double)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getServiceTimeBreakDown_UsageProbability()
	 * @model default="0" required="true"
	 * @generated
	 */
	double getUsageProbability();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown#getUsageProbability <em>Usage Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Probability</em>' attribute.
	 * @see #getUsageProbability()
	 * @generated
	 */
	void setUsageProbability(double value);

	/**
	 * Returns the value of the '<em><b>Usage Time</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Time</em>' attribute.
	 * @see #setUsageTime(double)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getServiceTimeBreakDown_UsageTime()
	 * @model default="0" required="true"
	 * @generated
	 */
	double getUsageTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown#getUsageTime <em>Usage Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Time</em>' attribute.
	 * @see #getUsageTime()
	 * @generated
	 */
	void setUsageTime(double value);

	/**
	 * Returns the value of the '<em><b>Used Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Resource</em>' reference.
	 * @see #setUsedResource(Resource)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage#getServiceTimeBreakDown_UsedResource()
	 * @model required="true"
	 * @generated
	 */
	Resource getUsedResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown#getUsedResource <em>Used Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used Resource</em>' reference.
	 * @see #getUsedResource()
	 * @generated
	 */
	void setUsedResource(Resource value);

} // ServiceTimeBreakDown