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
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.SchedulingPolicyDegreeImpl#getProcessingresourcetype <em>Processingresourcetype</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.SchedulingPolicyDegreeImpl#getDomainOfAllowedSchedulingPolicies <em>Domain Of Allowed Scheduling Policies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulingPolicyDegreeImpl extends EnumDegreeImpl implements SchedulingPolicyDegree {
	/**
	 * The cached value of the '{@link #getProcessingresourcetype() <em>Processingresourcetype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingresourcetype()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResourceType processingresourcetype;
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
	public ProcessingResourceType getProcessingresourcetype() {
		if (processingresourcetype != null && processingresourcetype.eIsProxy()) {
			InternalEObject oldProcessingresourcetype = (InternalEObject)processingresourcetype;
			processingresourcetype = (ProcessingResourceType)eResolveProxy(oldProcessingresourcetype);
			if (processingresourcetype != oldProcessingresourcetype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.SCHEDULING_POLICY_DEGREE__PROCESSINGRESOURCETYPE, oldProcessingresourcetype, processingresourcetype));
			}
		}
		return processingresourcetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceType basicGetProcessingresourcetype() {
		return processingresourcetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingresourcetype(ProcessingResourceType newProcessingresourcetype) {
		ProcessingResourceType oldProcessingresourcetype = processingresourcetype;
		processingresourcetype = newProcessingresourcetype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.SCHEDULING_POLICY_DEGREE__PROCESSINGRESOURCETYPE, oldProcessingresourcetype, processingresourcetype));
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
			case designdecisionPackage.SCHEDULING_POLICY_DEGREE__PROCESSINGRESOURCETYPE:
				if (resolve) return getProcessingresourcetype();
				return basicGetProcessingresourcetype();
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
			case designdecisionPackage.SCHEDULING_POLICY_DEGREE__PROCESSINGRESOURCETYPE:
				setProcessingresourcetype((ProcessingResourceType)newValue);
				return;
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
			case designdecisionPackage.SCHEDULING_POLICY_DEGREE__PROCESSINGRESOURCETYPE:
				setProcessingresourcetype((ProcessingResourceType)null);
				return;
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
			case designdecisionPackage.SCHEDULING_POLICY_DEGREE__PROCESSINGRESOURCETYPE:
				return processingresourcetype != null;
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ProcessingResourceDegree.class) {
			switch (derivedFeatureID) {
				case designdecisionPackage.SCHEDULING_POLICY_DEGREE__PROCESSINGRESOURCETYPE: return designdecisionPackage.PROCESSING_RESOURCE_DEGREE__PROCESSINGRESOURCETYPE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ProcessingResourceDegree.class) {
			switch (baseFeatureID) {
				case designdecisionPackage.PROCESSING_RESOURCE_DEGREE__PROCESSINGRESOURCETYPE: return designdecisionPackage.SCHEDULING_POLICY_DEGREE__PROCESSINGRESOURCETYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
