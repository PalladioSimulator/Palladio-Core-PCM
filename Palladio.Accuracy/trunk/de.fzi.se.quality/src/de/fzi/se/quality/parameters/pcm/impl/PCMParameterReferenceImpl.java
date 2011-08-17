/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import de.fzi.se.quality.parameters.impl.ParameterReferenceImpl;

import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.fzi.se.quality.parameters.pcm.PCMParameterReference;

import de.fzi.se.quality.qualityannotation.PCMParameterPartition;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMParameterReferenceImpl#getParameterPartition <em>Parameter Partition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PCMParameterReferenceImpl extends ParameterReferenceImpl implements PCMParameterReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMParameterReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PCMPackage.Literals.PCM_PARAMETER_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMParameterPartition getParameterPartition() {
		if (eContainerFeatureID() != PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION) return null;
		return (PCMParameterPartition)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterPartition(PCMParameterPartition newParameterPartition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParameterPartition, PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterPartition(PCMParameterPartition newParameterPartition) {
		if (newParameterPartition != eInternalContainer() || (eContainerFeatureID() != PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION && newParameterPartition != null)) {
			if (EcoreUtil.isAncestor(this, newParameterPartition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParameterPartition != null)
				msgs = ((InternalEObject)newParameterPartition).eInverseAdd(this, QualityAnnotationPackage.PCM_PARAMETER_PARTITION__PARAMETER_REFERENCE, PCMParameterPartition.class, msgs);
			msgs = basicSetParameterPartition(newParameterPartition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION, newParameterPartition, newParameterPartition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParameterPartition((PCMParameterPartition)otherEnd, msgs);
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
			case PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION:
				return basicSetParameterPartition(null, msgs);
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
			case PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION:
				return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.PCM_PARAMETER_PARTITION__PARAMETER_REFERENCE, PCMParameterPartition.class, msgs);
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
			case PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION:
				return getParameterPartition();
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
			case PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION:
				setParameterPartition((PCMParameterPartition)newValue);
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
			case PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION:
				setParameterPartition((PCMParameterPartition)null);
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
			case PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION:
				return getParameterPartition() != null;
		}
		return super.eIsSet(featureID);
	}

} //PCMParameterReferenceImpl
