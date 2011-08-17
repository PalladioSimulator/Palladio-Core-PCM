/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.impl;

import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.Requirement;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.SimpleQMLProfile;

import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple QML Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.impl.SimpleQMLProfileImpl#getUsageModel <em>Usage Model</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.impl.SimpleQMLProfileImpl#getRequirements <em>Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleQMLProfileImpl extends GenericQMLProfileImpl implements SimpleQMLProfile {
	/**
	 * The cached value of the '{@link #getUsageModel() <em>Usage Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageModel()
	 * @generated
	 * @ordered
	 */
	protected UsageModel usageModel;

	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> requirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleQMLProfileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QMLProfilePackage.Literals.SIMPLE_QML_PROFILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageModel getUsageModel() {
		if (usageModel != null && usageModel.eIsProxy()) {
			InternalEObject oldUsageModel = (InternalEObject)usageModel;
			usageModel = (UsageModel)eResolveProxy(oldUsageModel);
			if (usageModel != oldUsageModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QMLProfilePackage.SIMPLE_QML_PROFILE__USAGE_MODEL, oldUsageModel, usageModel));
			}
		}
		return usageModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageModel basicGetUsageModel() {
		return usageModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageModel(UsageModel newUsageModel) {
		UsageModel oldUsageModel = usageModel;
		usageModel = newUsageModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QMLProfilePackage.SIMPLE_QML_PROFILE__USAGE_MODEL, oldUsageModel, usageModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectContainmentEList<Requirement>(Requirement.class, this, QMLProfilePackage.SIMPLE_QML_PROFILE__REQUIREMENTS);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QMLProfilePackage.SIMPLE_QML_PROFILE__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
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
			case QMLProfilePackage.SIMPLE_QML_PROFILE__USAGE_MODEL:
				if (resolve) return getUsageModel();
				return basicGetUsageModel();
			case QMLProfilePackage.SIMPLE_QML_PROFILE__REQUIREMENTS:
				return getRequirements();
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
			case QMLProfilePackage.SIMPLE_QML_PROFILE__USAGE_MODEL:
				setUsageModel((UsageModel)newValue);
				return;
			case QMLProfilePackage.SIMPLE_QML_PROFILE__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends Requirement>)newValue);
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
			case QMLProfilePackage.SIMPLE_QML_PROFILE__USAGE_MODEL:
				setUsageModel((UsageModel)null);
				return;
			case QMLProfilePackage.SIMPLE_QML_PROFILE__REQUIREMENTS:
				getRequirements().clear();
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
			case QMLProfilePackage.SIMPLE_QML_PROFILE__USAGE_MODEL:
				return usageModel != null;
			case QMLProfilePackage.SIMPLE_QML_PROFILE__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SimpleQMLProfileImpl
