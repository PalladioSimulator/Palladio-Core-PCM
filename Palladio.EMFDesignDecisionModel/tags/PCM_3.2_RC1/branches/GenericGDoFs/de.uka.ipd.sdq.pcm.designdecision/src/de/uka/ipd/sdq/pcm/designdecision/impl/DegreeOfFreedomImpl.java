/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;

import de.uka.ipd.sdq.pcm.designdecision.GDoF.GenericDegreeOfFreedom;

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
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.DegreeOfFreedomImpl#getPrimaryChanged <em>Primary Changed</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.DegreeOfFreedomImpl#getGdof <em>Gdof</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DegreeOfFreedomImpl extends EObjectImpl implements DegreeOfFreedom {
	/**
	 * The cached value of the '{@link #getPrimaryChanged() <em>Primary Changed</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryChanged()
	 * @generated
	 * @ordered
	 */
	protected Entity primaryChanged;

	/**
	 * The cached value of the '{@link #getGdof() <em>Gdof</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGdof()
	 * @generated
	 * @ordered
	 */
	protected GenericDegreeOfFreedom gdof;

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
	public Entity getPrimaryChanged() {
		if (primaryChanged != null && primaryChanged.eIsProxy()) {
			InternalEObject oldPrimaryChanged = (InternalEObject)primaryChanged;
			primaryChanged = (Entity)eResolveProxy(oldPrimaryChanged);
			if (primaryChanged != oldPrimaryChanged) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.DEGREE_OF_FREEDOM__PRIMARY_CHANGED, oldPrimaryChanged, primaryChanged));
			}
		}
		return primaryChanged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetPrimaryChanged() {
		return primaryChanged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryChanged(Entity newPrimaryChanged) {
		Entity oldPrimaryChanged = primaryChanged;
		primaryChanged = newPrimaryChanged;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.DEGREE_OF_FREEDOM__PRIMARY_CHANGED, oldPrimaryChanged, primaryChanged));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericDegreeOfFreedom getGdof() {
		if (gdof != null && gdof.eIsProxy()) {
			InternalEObject oldGdof = (InternalEObject)gdof;
			gdof = (GenericDegreeOfFreedom)eResolveProxy(oldGdof);
			if (gdof != oldGdof) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.DEGREE_OF_FREEDOM__GDOF, oldGdof, gdof));
			}
		}
		return gdof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericDegreeOfFreedom basicGetGdof() {
		return gdof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGdof(GenericDegreeOfFreedom newGdof) {
		GenericDegreeOfFreedom oldGdof = gdof;
		gdof = newGdof;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.DEGREE_OF_FREEDOM__GDOF, oldGdof, gdof));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.DEGREE_OF_FREEDOM__PRIMARY_CHANGED:
				if (resolve) return getPrimaryChanged();
				return basicGetPrimaryChanged();
			case designdecisionPackage.DEGREE_OF_FREEDOM__GDOF:
				if (resolve) return getGdof();
				return basicGetGdof();
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
			case designdecisionPackage.DEGREE_OF_FREEDOM__PRIMARY_CHANGED:
				setPrimaryChanged((Entity)newValue);
				return;
			case designdecisionPackage.DEGREE_OF_FREEDOM__GDOF:
				setGdof((GenericDegreeOfFreedom)newValue);
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
			case designdecisionPackage.DEGREE_OF_FREEDOM__PRIMARY_CHANGED:
				setPrimaryChanged((Entity)null);
				return;
			case designdecisionPackage.DEGREE_OF_FREEDOM__GDOF:
				setGdof((GenericDegreeOfFreedom)null);
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
			case designdecisionPackage.DEGREE_OF_FREEDOM__PRIMARY_CHANGED:
				return primaryChanged != null;
			case designdecisionPackage.DEGREE_OF_FREEDOM__GDOF:
				return gdof != null;
		}
		return super.eIsSet(featureID);
	}

} //DegreeOfFreedomImpl
