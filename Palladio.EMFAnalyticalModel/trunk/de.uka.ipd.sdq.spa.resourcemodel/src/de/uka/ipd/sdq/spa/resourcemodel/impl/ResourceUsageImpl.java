/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel.impl;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;

import de.uka.ipd.sdq.spa.resourcemodel.ActiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceUsageImpl#getUsageTime <em>Usage Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceUsageImpl extends AbstractResourceUsageImpl implements ResourceUsage {
	/**
	 * The cached value of the '{@link #getUsageTime() <em>Usage Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageTime()
	 * @generated
	 * @ordered
	 */
	protected ProbabilityDensityFunction usageTime = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResourceModelPackage.Literals.RESOURCE_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilityDensityFunction getUsageTime() {
		return usageTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUsageTime(ProbabilityDensityFunction newUsageTime, NotificationChain msgs) {
		ProbabilityDensityFunction oldUsageTime = usageTime;
		usageTime = newUsageTime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourceModelPackage.RESOURCE_USAGE__USAGE_TIME, oldUsageTime, newUsageTime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageTime(ProbabilityDensityFunction newUsageTime) {
		if (newUsageTime != usageTime) {
			NotificationChain msgs = null;
			if (usageTime != null)
				msgs = ((InternalEObject)usageTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResourceModelPackage.RESOURCE_USAGE__USAGE_TIME, null, msgs);
			if (newUsageTime != null)
				msgs = ((InternalEObject)newUsageTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResourceModelPackage.RESOURCE_USAGE__USAGE_TIME, null, msgs);
			msgs = basicSetUsageTime(newUsageTime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceModelPackage.RESOURCE_USAGE__USAGE_TIME, newUsageTime, newUsageTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourceModelPackage.RESOURCE_USAGE__USAGE_TIME:
				return basicSetUsageTime(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceModelPackage.RESOURCE_USAGE__USAGE_TIME:
				return getUsageTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResourceModelPackage.RESOURCE_USAGE__USAGE_TIME:
				setUsageTime((ProbabilityDensityFunction)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ResourceModelPackage.RESOURCE_USAGE__USAGE_TIME:
				setUsageTime((ProbabilityDensityFunction)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ResourceModelPackage.RESOURCE_USAGE__USAGE_TIME:
				return usageTime != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceUsageImpl