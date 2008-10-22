/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.subsystem.impl;

import de.uka.ipd.sdq.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl;

import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.subsystem.SubSystem;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.subsystem.impl.SubSystemImpl#getRepository__SubSystem <em>Repository Sub System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubSystemImpl extends ComposedProvidingRequiringEntityImpl implements SubSystem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SubsystemPackage.Literals.SUB_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository getRepository__SubSystem() {
		if (eContainerFeatureID != SubsystemPackage.SUB_SYSTEM__REPOSITORY_SUB_SYSTEM) return null;
		return (Repository)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository__SubSystem(Repository newRepository__SubSystem, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepository__SubSystem, SubsystemPackage.SUB_SYSTEM__REPOSITORY_SUB_SYSTEM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepository__SubSystem(Repository newRepository__SubSystem) {
		if (newRepository__SubSystem != eInternalContainer() || (eContainerFeatureID != SubsystemPackage.SUB_SYSTEM__REPOSITORY_SUB_SYSTEM && newRepository__SubSystem != null)) {
			if (EcoreUtil.isAncestor(this, newRepository__SubSystem))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepository__SubSystem != null)
				msgs = ((InternalEObject)newRepository__SubSystem).eInverseAdd(this, RepositoryPackage.REPOSITORY__SUBSYSTEMS_REPOSITORY, Repository.class, msgs);
			msgs = basicSetRepository__SubSystem(newRepository__SubSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SubsystemPackage.SUB_SYSTEM__REPOSITORY_SUB_SYSTEM, newRepository__SubSystem, newRepository__SubSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SubsystemPackage.SUB_SYSTEM__REPOSITORY_SUB_SYSTEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRepository__SubSystem((Repository)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SubsystemPackage.SUB_SYSTEM__REPOSITORY_SUB_SYSTEM:
				return basicSetRepository__SubSystem(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case SubsystemPackage.SUB_SYSTEM__REPOSITORY_SUB_SYSTEM:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__SUBSYSTEMS_REPOSITORY, Repository.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SubsystemPackage.SUB_SYSTEM__REPOSITORY_SUB_SYSTEM:
				return getRepository__SubSystem();
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
			case SubsystemPackage.SUB_SYSTEM__REPOSITORY_SUB_SYSTEM:
				setRepository__SubSystem((Repository)newValue);
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
			case SubsystemPackage.SUB_SYSTEM__REPOSITORY_SUB_SYSTEM:
				setRepository__SubSystem((Repository)null);
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
			case SubsystemPackage.SUB_SYSTEM__REPOSITORY_SUB_SYSTEM:
				return getRepository__SubSystem() != null;
		}
		return super.eIsSet(featureID);
	}

} //SubSystemImpl
