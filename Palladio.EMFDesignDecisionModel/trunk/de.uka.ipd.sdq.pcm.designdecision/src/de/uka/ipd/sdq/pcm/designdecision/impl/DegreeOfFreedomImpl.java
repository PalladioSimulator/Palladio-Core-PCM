/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Degree Of Freedom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.DegreeOfFreedomImpl#getChangeableEntity <em>Changeable Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DegreeOfFreedomImpl extends EObjectImpl implements DegreeOfFreedom {
	/**
	 * The cached value of the '{@link #getChangeableEntity() <em>Changeable Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeableEntity()
	 * @generated
	 * @ordered
	 */
	protected Entity changeableEntity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DegreeOfFreedomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.DEGREE_OF_FREEDOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getChangeableEntity() {
		if (changeableEntity != null && changeableEntity.eIsProxy()) {
			InternalEObject oldChangeableEntity = (InternalEObject)changeableEntity;
			changeableEntity = (Entity)eResolveProxy(oldChangeableEntity);
			if (changeableEntity != oldChangeableEntity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY, oldChangeableEntity, changeableEntity));
			}
		}
		return changeableEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetChangeableEntity() {
		return changeableEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeableEntity(Entity newChangeableEntity) {
		Entity oldChangeableEntity = changeableEntity;
		changeableEntity = newChangeableEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY, oldChangeableEntity, changeableEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY:
				if (resolve) return getChangeableEntity();
				return basicGetChangeableEntity();
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
			case designdecisionPackage.DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY:
				setChangeableEntity((Entity)newValue);
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
			case designdecisionPackage.DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY:
				setChangeableEntity((Entity)null);
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
			case designdecisionPackage.DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY:
				return changeableEntity != null;
		}
		return super.eIsSet(featureID);
	}

} //DegreeOfFreedomImpl
