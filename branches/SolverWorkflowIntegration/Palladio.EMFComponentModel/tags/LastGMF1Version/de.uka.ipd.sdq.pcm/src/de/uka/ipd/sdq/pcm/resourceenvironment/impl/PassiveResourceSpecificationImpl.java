
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.PassiveResourceType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Passive Resource Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.PassiveResourceSpecificationImpl#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.PassiveResourceSpecificationImpl#getPassiveResourceType_PassiveResourceSpecification <em>Passive Resource Type Passive Resource Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PassiveResourceSpecificationImpl extends EObjectImpl implements PassiveResourceSpecification {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final int CAPACITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected int capacity = CAPACITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPassiveResourceType_PassiveResourceSpecification() <em>Passive Resource Type Passive Resource Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassiveResourceType_PassiveResourceSpecification()
	 * @generated
	 * @ordered
	 */
	protected PassiveResourceType passiveResourceType_PassiveResourceSpecification = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PassiveResourceSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.PASSIVE_RESOURCE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacity(int newCapacity) {
		int oldCapacity = capacity;
		capacity = newCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION__CAPACITY, oldCapacity, capacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceType getPassiveResourceType_PassiveResourceSpecification() {
		if (passiveResourceType_PassiveResourceSpecification != null && passiveResourceType_PassiveResourceSpecification.eIsProxy()) {
			InternalEObject oldPassiveResourceType_PassiveResourceSpecification = (InternalEObject)passiveResourceType_PassiveResourceSpecification;
			passiveResourceType_PassiveResourceSpecification = (PassiveResourceType)eResolveProxy(oldPassiveResourceType_PassiveResourceSpecification);
			if (passiveResourceType_PassiveResourceSpecification != oldPassiveResourceType_PassiveResourceSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION__PASSIVE_RESOURCE_TYPE_PASSIVE_RESOURCE_SPECIFICATION, oldPassiveResourceType_PassiveResourceSpecification, passiveResourceType_PassiveResourceSpecification));
			}
		}
		return passiveResourceType_PassiveResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceType basicGetPassiveResourceType_PassiveResourceSpecification() {
		return passiveResourceType_PassiveResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassiveResourceType_PassiveResourceSpecification(PassiveResourceType newPassiveResourceType_PassiveResourceSpecification) {
		PassiveResourceType oldPassiveResourceType_PassiveResourceSpecification = passiveResourceType_PassiveResourceSpecification;
		passiveResourceType_PassiveResourceSpecification = newPassiveResourceType_PassiveResourceSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION__PASSIVE_RESOURCE_TYPE_PASSIVE_RESOURCE_SPECIFICATION, oldPassiveResourceType_PassiveResourceSpecification, passiveResourceType_PassiveResourceSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION__CAPACITY:
				return new Integer(getCapacity());
			case ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION__PASSIVE_RESOURCE_TYPE_PASSIVE_RESOURCE_SPECIFICATION:
				if (resolve) return getPassiveResourceType_PassiveResourceSpecification();
				return basicGetPassiveResourceType_PassiveResourceSpecification();
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
			case ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION__CAPACITY:
				setCapacity(((Integer)newValue).intValue());
				return;
			case ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION__PASSIVE_RESOURCE_TYPE_PASSIVE_RESOURCE_SPECIFICATION:
				setPassiveResourceType_PassiveResourceSpecification((PassiveResourceType)newValue);
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
			case ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION__CAPACITY:
				setCapacity(CAPACITY_EDEFAULT);
				return;
			case ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION__PASSIVE_RESOURCE_TYPE_PASSIVE_RESOURCE_SPECIFICATION:
				setPassiveResourceType_PassiveResourceSpecification((PassiveResourceType)null);
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
			case ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION__CAPACITY:
				return capacity != CAPACITY_EDEFAULT;
			case ResourceenvironmentPackage.PASSIVE_RESOURCE_SPECIFICATION__PASSIVE_RESOURCE_TYPE_PASSIVE_RESOURCE_SPECIFICATION:
				return passiveResourceType_PassiveResourceSpecification != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (capacity: ");
		result.append(capacity);
		result.append(')');
		return result.toString();
	}

} //PassiveResourceSpecificationImpl