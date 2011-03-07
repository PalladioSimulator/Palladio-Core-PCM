/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;
import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;

import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduling Policy Degree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.SchedulingPolicyDegreeImpl#getDomainOfAllowedSchedulingPolicies <em>Domain Of Allowed Scheduling Policies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulingPolicyDegreeImpl extends ProcessingResourceDegreeImpl implements SchedulingPolicyDegree {
	/**
	 * The cached value of the '{@link #getDomainOfAllowedSchedulingPolicies() <em>Domain Of Allowed Scheduling Policies</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainOfAllowedSchedulingPolicies()
	 * @generated
	 * @ordered
	 */
	protected EList<SchedulingPolicy> domainOfAllowedSchedulingPolicies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulingPolicyDegreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.SCHEDULING_POLICY_DEGREE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SchedulingPolicy> getDomainOfAllowedSchedulingPolicies() {
		if (domainOfAllowedSchedulingPolicies == null) {
			domainOfAllowedSchedulingPolicies = new EDataTypeUniqueEList<SchedulingPolicy>(SchedulingPolicy.class, this, designdecisionPackage.SCHEDULING_POLICY_DEGREE__DOMAIN_OF_ALLOWED_SCHEDULING_POLICIES);
		}
		return domainOfAllowedSchedulingPolicies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.SCHEDULING_POLICY_DEGREE__DOMAIN_OF_ALLOWED_SCHEDULING_POLICIES:
				return getDomainOfAllowedSchedulingPolicies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case designdecisionPackage.SCHEDULING_POLICY_DEGREE__DOMAIN_OF_ALLOWED_SCHEDULING_POLICIES:
				getDomainOfAllowedSchedulingPolicies().clear();
				getDomainOfAllowedSchedulingPolicies().addAll((Collection<? extends SchedulingPolicy>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case designdecisionPackage.SCHEDULING_POLICY_DEGREE__DOMAIN_OF_ALLOWED_SCHEDULING_POLICIES:
				getDomainOfAllowedSchedulingPolicies().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case designdecisionPackage.SCHEDULING_POLICY_DEGREE__DOMAIN_OF_ALLOWED_SCHEDULING_POLICIES:
				return domainOfAllowedSchedulingPolicies != null && !domainOfAllowedSchedulingPolicies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (domainOfAllowedSchedulingPolicies: ");
		result.append(domainOfAllowedSchedulingPolicies);
		result.append(')');
		return result.toString();
	}

} //SchedulingPolicyDegreeImpl
