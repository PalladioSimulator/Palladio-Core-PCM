/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityConfiguration;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.SensitivityParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.SensitivityParameterImpl#getParentParameter__SensitivityParameter <em>Parent Parameter Sensitivity Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.SensitivityParameterImpl#getSensitivityConfiguration__SensitivityParameter <em>Sensitivity Configuration Sensitivity Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SensitivityParameterImpl extends EntityImpl implements SensitivityParameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SensitivityParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensitivityPackage.Literals.SENSITIVITY_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombinedSensitivityParameter getParentParameter__SensitivityParameter() {
		if (eContainerFeatureID() != SensitivityPackage.SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER) return null;
		return (CombinedSensitivityParameter)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentParameter__SensitivityParameter(CombinedSensitivityParameter newParentParameter__SensitivityParameter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentParameter__SensitivityParameter, SensitivityPackage.SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentParameter__SensitivityParameter(CombinedSensitivityParameter newParentParameter__SensitivityParameter) {
		if (newParentParameter__SensitivityParameter != eInternalContainer() || (eContainerFeatureID() != SensitivityPackage.SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER && newParentParameter__SensitivityParameter != null)) {
			if (EcoreUtil.isAncestor(this, newParentParameter__SensitivityParameter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentParameter__SensitivityParameter != null)
				msgs = ((InternalEObject)newParentParameter__SensitivityParameter).eInverseAdd(this, SensitivityPackage.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER, CombinedSensitivityParameter.class, msgs);
			msgs = basicSetParentParameter__SensitivityParameter(newParentParameter__SensitivityParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER, newParentParameter__SensitivityParameter, newParentParameter__SensitivityParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensitivityConfiguration getSensitivityConfiguration__SensitivityParameter() {
		if (eContainerFeatureID() != SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER) return null;
		return (SensitivityConfiguration)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSensitivityConfiguration__SensitivityParameter(SensitivityConfiguration newSensitivityConfiguration__SensitivityParameter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSensitivityConfiguration__SensitivityParameter, SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSensitivityConfiguration__SensitivityParameter(SensitivityConfiguration newSensitivityConfiguration__SensitivityParameter) {
		if (newSensitivityConfiguration__SensitivityParameter != eInternalContainer() || (eContainerFeatureID() != SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER && newSensitivityConfiguration__SensitivityParameter != null)) {
			if (EcoreUtil.isAncestor(this, newSensitivityConfiguration__SensitivityParameter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSensitivityConfiguration__SensitivityParameter != null)
				msgs = ((InternalEObject)newSensitivityConfiguration__SensitivityParameter).eInverseAdd(this, SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION, SensitivityConfiguration.class, msgs);
			msgs = basicSetSensitivityConfiguration__SensitivityParameter(newSensitivityConfiguration__SensitivityParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER, newSensitivityConfiguration__SensitivityParameter, newSensitivityConfiguration__SensitivityParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SensitivityPackage.SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentParameter__SensitivityParameter((CombinedSensitivityParameter)otherEnd, msgs);
			case SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSensitivityConfiguration__SensitivityParameter((SensitivityConfiguration)otherEnd, msgs);
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
			case SensitivityPackage.SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER:
				return basicSetParentParameter__SensitivityParameter(null, msgs);
			case SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER:
				return basicSetSensitivityConfiguration__SensitivityParameter(null, msgs);
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
		switch (eContainerFeatureID()) {
			case SensitivityPackage.SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER:
				return eInternalContainer().eInverseRemove(this, SensitivityPackage.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER, CombinedSensitivityParameter.class, msgs);
			case SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER:
				return eInternalContainer().eInverseRemove(this, SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION, SensitivityConfiguration.class, msgs);
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
			case SensitivityPackage.SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER:
				return getParentParameter__SensitivityParameter();
			case SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER:
				return getSensitivityConfiguration__SensitivityParameter();
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
			case SensitivityPackage.SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER:
				setParentParameter__SensitivityParameter((CombinedSensitivityParameter)newValue);
				return;
			case SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER:
				setSensitivityConfiguration__SensitivityParameter((SensitivityConfiguration)newValue);
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
			case SensitivityPackage.SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER:
				setParentParameter__SensitivityParameter((CombinedSensitivityParameter)null);
				return;
			case SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER:
				setSensitivityConfiguration__SensitivityParameter((SensitivityConfiguration)null);
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
			case SensitivityPackage.SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER:
				return getParentParameter__SensitivityParameter() != null;
			case SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER:
				return getSensitivityConfiguration__SensitivityParameter() != null;
		}
		return super.eIsSet(featureID);
	}

} //SensitivityParameterImpl
