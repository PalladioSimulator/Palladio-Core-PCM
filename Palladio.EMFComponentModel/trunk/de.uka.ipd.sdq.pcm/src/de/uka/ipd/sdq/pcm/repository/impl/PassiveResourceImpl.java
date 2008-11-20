/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Passive Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.PassiveResourceImpl#getCapacity_PassiveResource <em>Capacity Passive Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PassiveResourceImpl extends EntityImpl implements PassiveResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";
	/**
	 * The cached value of the '{@link #getCapacity_PassiveResource() <em>Capacity Passive Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity_PassiveResource()
	 * @generated
	 * @ordered
	 */
	protected PCMRandomVariable capacity_PassiveResource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PassiveResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.PASSIVE_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRandomVariable getCapacity_PassiveResource() {
		return capacity_PassiveResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapacity_PassiveResource(PCMRandomVariable newCapacity_PassiveResource, NotificationChain msgs) {
		PCMRandomVariable oldCapacity_PassiveResource = capacity_PassiveResource;
		capacity_PassiveResource = newCapacity_PassiveResource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE, oldCapacity_PassiveResource, newCapacity_PassiveResource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacity_PassiveResource(PCMRandomVariable newCapacity_PassiveResource) {
		if (newCapacity_PassiveResource != capacity_PassiveResource) {
			NotificationChain msgs = null;
			if (capacity_PassiveResource != null)
				msgs = ((InternalEObject)capacity_PassiveResource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE, null, msgs);
			if (newCapacity_PassiveResource != null)
				msgs = ((InternalEObject)newCapacity_PassiveResource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE, null, msgs);
			msgs = basicSetCapacity_PassiveResource(newCapacity_PassiveResource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE, newCapacity_PassiveResource, newCapacity_PassiveResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
				return basicSetCapacity_PassiveResource(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
				return getCapacity_PassiveResource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
				setCapacity_PassiveResource((PCMRandomVariable)newValue);
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
			case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
				setCapacity_PassiveResource((PCMRandomVariable)null);
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
			case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
				return capacity_PassiveResource != null;
		}
		return super.eIsSet(featureID);
	}

} //PassiveResourceImpl
