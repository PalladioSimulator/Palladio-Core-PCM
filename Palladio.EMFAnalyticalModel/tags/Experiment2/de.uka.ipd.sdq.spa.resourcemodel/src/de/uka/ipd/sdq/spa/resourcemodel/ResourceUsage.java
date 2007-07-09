/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage#getUsageTime <em>Usage Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getResourceUsage()
 * @model
 * @generated
 */
public interface ResourceUsage extends AbstractResourceUsage {
	/**
	 * Returns the value of the '<em><b>Usage Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Time</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Time</em>' containment reference.
	 * @see #setUsageTime(ProbabilityDensityFunction)
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getResourceUsage_UsageTime()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ProbabilityDensityFunction getUsageTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage#getUsageTime <em>Usage Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Time</em>' containment reference.
	 * @see #getUsageTime()
	 * @generated
	 */
	void setUsageTime(ProbabilityDensityFunction value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(ActiveResource)
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getResourceUsage_Resource()
	 * @model required="true"
	 * @generated
	 */
	ActiveResource getResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(ActiveResource value);

} // ResourceUsage
