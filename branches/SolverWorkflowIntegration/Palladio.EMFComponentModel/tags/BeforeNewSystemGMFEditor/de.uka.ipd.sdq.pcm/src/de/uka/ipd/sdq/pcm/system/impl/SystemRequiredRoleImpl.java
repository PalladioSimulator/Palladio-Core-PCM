
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.impl;

import de.uka.ipd.sdq.pcm.repository.impl.RequiredRoleImpl;

import de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemRequiredRole;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Required Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemRequiredRoleImpl#getSystem_SystemRequiredRole <em>System System Required Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemRequiredRoleImpl#getSpecifiedTimeConsumption_SystemRequiredRole <em>Specified Time Consumption System Required Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemRequiredRoleImpl extends RequiredRoleImpl implements SystemRequiredRole {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getSpecifiedTimeConsumption_SystemRequiredRole() <em>Specified Time Consumption System Required Role</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifiedTimeConsumption_SystemRequiredRole()
	 * @generated
	 * @ordered
	 */
	protected EList specifiedTimeConsumption_SystemRequiredRole = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemRequiredRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SystemPackage.Literals.SYSTEM_REQUIRED_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.uka.ipd.sdq.pcm.system.System getSystem_SystemRequiredRole() {
		if (eContainerFeatureID != SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE) return null;
		return (de.uka.ipd.sdq.pcm.system.System)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem_SystemRequiredRole(de.uka.ipd.sdq.pcm.system.System newSystem_SystemRequiredRole, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSystem_SystemRequiredRole, SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem_SystemRequiredRole(de.uka.ipd.sdq.pcm.system.System newSystem_SystemRequiredRole) {
		if (newSystem_SystemRequiredRole != eInternalContainer() || (eContainerFeatureID != SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE && newSystem_SystemRequiredRole != null)) {
			if (EcoreUtil.isAncestor(this, newSystem_SystemRequiredRole))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSystem_SystemRequiredRole != null)
				msgs = ((InternalEObject)newSystem_SystemRequiredRole).eInverseAdd(this, SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM, de.uka.ipd.sdq.pcm.system.System.class, msgs);
			msgs = basicSetSystem_SystemRequiredRole(newSystem_SystemRequiredRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE, newSystem_SystemRequiredRole, newSystem_SystemRequiredRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSpecifiedTimeConsumption_SystemRequiredRole() {
		if (specifiedTimeConsumption_SystemRequiredRole == null) {
			specifiedTimeConsumption_SystemRequiredRole = new EObjectContainmentEList(SpecifiedTimeConsumption.class, this, SystemPackage.SYSTEM_REQUIRED_ROLE__SPECIFIED_TIME_CONSUMPTION_SYSTEM_REQUIRED_ROLE);
		}
		return specifiedTimeConsumption_SystemRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSystem_SystemRequiredRole((de.uka.ipd.sdq.pcm.system.System)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE:
				return basicSetSystem_SystemRequiredRole(null, msgs);
			case SystemPackage.SYSTEM_REQUIRED_ROLE__SPECIFIED_TIME_CONSUMPTION_SYSTEM_REQUIRED_ROLE:
				return ((InternalEList)getSpecifiedTimeConsumption_SystemRequiredRole()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE:
				return eInternalContainer().eInverseRemove(this, SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM, de.uka.ipd.sdq.pcm.system.System.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE:
				return getSystem_SystemRequiredRole();
			case SystemPackage.SYSTEM_REQUIRED_ROLE__SPECIFIED_TIME_CONSUMPTION_SYSTEM_REQUIRED_ROLE:
				return getSpecifiedTimeConsumption_SystemRequiredRole();
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
			case SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE:
				setSystem_SystemRequiredRole((de.uka.ipd.sdq.pcm.system.System)newValue);
				return;
			case SystemPackage.SYSTEM_REQUIRED_ROLE__SPECIFIED_TIME_CONSUMPTION_SYSTEM_REQUIRED_ROLE:
				getSpecifiedTimeConsumption_SystemRequiredRole().clear();
				getSpecifiedTimeConsumption_SystemRequiredRole().addAll((Collection)newValue);
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
			case SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE:
				setSystem_SystemRequiredRole((de.uka.ipd.sdq.pcm.system.System)null);
				return;
			case SystemPackage.SYSTEM_REQUIRED_ROLE__SPECIFIED_TIME_CONSUMPTION_SYSTEM_REQUIRED_ROLE:
				getSpecifiedTimeConsumption_SystemRequiredRole().clear();
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
			case SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE:
				return getSystem_SystemRequiredRole() != null;
			case SystemPackage.SYSTEM_REQUIRED_ROLE__SPECIFIED_TIME_CONSUMPTION_SYSTEM_REQUIRED_ROLE:
				return specifiedTimeConsumption_SystemRequiredRole != null && !specifiedTimeConsumption_SystemRequiredRole.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SystemRequiredRoleImpl