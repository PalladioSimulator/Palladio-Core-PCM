/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduling Policy Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree#getDomainOfAllowedSchedulingPolicies <em>Domain Of Allowed Scheduling Policies</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getSchedulingPolicyDegree()
 * @model
 * @generated
 */
public interface SchedulingPolicyDegree extends EnumDegree, ProcessingResourceDegree {
	/**
	 * Returns the value of the '<em><b>Domain Of Allowed Scheduling Policies</b></em>' attribute list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy}.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Of Allowed Scheduling Policies</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Of Allowed Scheduling Policies</em>' attribute list.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getSchedulingPolicyDegree_DomainOfAllowedSchedulingPolicies()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SchedulingPolicy> getDomainOfAllowedSchedulingPolicies();

} // SchedulingPolicyDegree
