/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ParameterPartitionImpl#getValidatedSetting <em>Validated Setting</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterPartitionImpl extends IdentifierImpl implements ParameterPartition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParametersPackage.Literals.PARAMETER_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityAnnotation getValidatedSetting() {
		if (eContainerFeatureID() != ParametersPackage.PARAMETER_PARTITION__VALIDATED_SETTING) return null;
		return (QualityAnnotation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValidatedSetting(QualityAnnotation newValidatedSetting, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newValidatedSetting, ParametersPackage.PARAMETER_PARTITION__VALIDATED_SETTING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidatedSetting(QualityAnnotation newValidatedSetting) {
		if (newValidatedSetting != eInternalContainer() || (eContainerFeatureID() != ParametersPackage.PARAMETER_PARTITION__VALIDATED_SETTING && newValidatedSetting != null)) {
			if (EcoreUtil.isAncestor(this, newValidatedSetting))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newValidatedSetting != null)
				msgs = ((InternalEObject)newValidatedSetting).eInverseAdd(this, QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS, QualityAnnotation.class, msgs);
			msgs = basicSetValidatedSetting(newValidatedSetting, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_PARTITION__VALIDATED_SETTING, newValidatedSetting, newValidatedSetting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParametersPackage.PARAMETER_PARTITION__VALIDATED_SETTING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetValidatedSetting((QualityAnnotation)otherEnd, msgs);
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
			case ParametersPackage.PARAMETER_PARTITION__VALIDATED_SETTING:
				return basicSetValidatedSetting(null, msgs);
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
			case ParametersPackage.PARAMETER_PARTITION__VALIDATED_SETTING:
				return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS, QualityAnnotation.class, msgs);
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
			case ParametersPackage.PARAMETER_PARTITION__VALIDATED_SETTING:
				return getValidatedSetting();
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
			case ParametersPackage.PARAMETER_PARTITION__VALIDATED_SETTING:
				setValidatedSetting((QualityAnnotation)newValue);
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
			case ParametersPackage.PARAMETER_PARTITION__VALIDATED_SETTING:
				setValidatedSetting((QualityAnnotation)null);
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
			case ParametersPackage.PARAMETER_PARTITION__VALIDATED_SETTING:
				return getValidatedSetting() != null;
		}
		return super.eIsSet(featureID);
	}

} //ParameterPartitionImpl
