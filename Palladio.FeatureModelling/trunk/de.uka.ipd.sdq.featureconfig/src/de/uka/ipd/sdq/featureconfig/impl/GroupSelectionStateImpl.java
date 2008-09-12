/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.impl;

import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.GroupSelectionState;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;

import de.uka.ipd.sdq.featuremodel.FeatureGroup;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Selection State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.GroupSelectionStateImpl#getFeaturegroup <em>Featuregroup</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.GroupSelectionStateImpl#getConfigStatus <em>Config Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupSelectionStateImpl extends EObjectImpl implements GroupSelectionState {
	/**
	 * The cached value of the '{@link #getFeaturegroup() <em>Featuregroup</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturegroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureGroup featuregroup;

	/**
	 * The default value of the '{@link #getConfigStatus() <em>Config Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ConfigState CONFIG_STATUS_EDEFAULT = ConfigState.SELECTED;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupSelectionStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featureconfigPackage.Literals.GROUP_SELECTION_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroup getFeaturegroup() {
		if (featuregroup != null && featuregroup.eIsProxy()) {
			InternalEObject oldFeaturegroup = (InternalEObject)featuregroup;
			featuregroup = (FeatureGroup)eResolveProxy(oldFeaturegroup);
			if (featuregroup != oldFeaturegroup) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, featureconfigPackage.GROUP_SELECTION_STATE__FEATUREGROUP, oldFeaturegroup, featuregroup));
			}
		}
		return featuregroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroup basicGetFeaturegroup() {
		return featuregroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeaturegroup(FeatureGroup newFeaturegroup) {
		FeatureGroup oldFeaturegroup = featuregroup;
		featuregroup = newFeaturegroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.GROUP_SELECTION_STATE__FEATUREGROUP, oldFeaturegroup, featuregroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigState getConfigStatus() {
		// TODO: implement this method to return the 'Config Status' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case featureconfigPackage.GROUP_SELECTION_STATE__FEATUREGROUP:
				if (resolve) return getFeaturegroup();
				return basicGetFeaturegroup();
			case featureconfigPackage.GROUP_SELECTION_STATE__CONFIG_STATUS:
				return getConfigStatus();
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
			case featureconfigPackage.GROUP_SELECTION_STATE__FEATUREGROUP:
				setFeaturegroup((FeatureGroup)newValue);
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
			case featureconfigPackage.GROUP_SELECTION_STATE__FEATUREGROUP:
				setFeaturegroup((FeatureGroup)null);
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
			case featureconfigPackage.GROUP_SELECTION_STATE__FEATUREGROUP:
				return featuregroup != null;
			case featureconfigPackage.GROUP_SELECTION_STATE__CONFIG_STATUS:
				return getConfigStatus() != CONFIG_STATUS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //GroupSelectionStateImpl
