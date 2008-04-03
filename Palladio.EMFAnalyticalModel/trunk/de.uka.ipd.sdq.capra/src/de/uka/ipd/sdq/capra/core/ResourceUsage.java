/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;

import de.uka.ipd.sdq.capra.resources.ProcessingResource;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ResourceUsage#getResource <em>Resource</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ResourceUsage#getUsageTime <em>Usage Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ResourceUsage#getUsageTimeSpecification <em>Usage Time Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getResourceUsage()
 * @model
 * @generated
 */
public interface ResourceUsage extends AbstractResourceUsage {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(ProcessingResource)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getResourceUsage_Resource()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessingResource getResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.ResourceUsage#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(ProcessingResource value);

	/**
	 * Returns the value of the '<em><b>Usage Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Time</em>' reference.
	 * @see #setUsageTime(ProbabilityDensityFunction)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getResourceUsage_UsageTime()
	 * @model required="true" transient="true" volatile="true" ordered="false"
	 * @generated
	 */
	ProbabilityDensityFunction getUsageTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.ResourceUsage#getUsageTime <em>Usage Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Time</em>' reference.
	 * @see #getUsageTime()
	 * @generated
	 */
	void setUsageTime(ProbabilityDensityFunction value);

	/**
	 * Returns the value of the '<em><b>Usage Time Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Time Specification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Time Specification</em>' attribute.
	 * @see #setUsageTimeSpecification(String)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getResourceUsage_UsageTimeSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getUsageTimeSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.ResourceUsage#getUsageTimeSpecification <em>Usage Time Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Time Specification</em>' attribute.
	 * @see #getUsageTimeSpecification()
	 * @generated
	 */
	void setUsageTimeSpecification(String value);

} // ResourceUsage
