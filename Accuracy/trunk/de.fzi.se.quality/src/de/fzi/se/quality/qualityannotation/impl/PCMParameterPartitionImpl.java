/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.parameters.impl.ParameterPartitionImpl;

import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.fzi.se.quality.parameters.pcm.PCMParameterReference;

import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition;
import de.fzi.se.quality.qualityannotation.PCMParameterPartition;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCM Parameter Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMParameterPartitionImpl#getCharacerisedParameterPartitions <em>Characerised Parameter Partitions</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMParameterPartitionImpl#getParameterReference <em>Parameter Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMParameterPartitionImpl extends ParameterPartitionImpl implements PCMParameterPartition {
	/**
	 * The cached value of the '{@link #getCharacerisedParameterPartitions() <em>Characerised Parameter Partitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacerisedParameterPartitions()
	 * @generated
	 * @ordered
	 */
	protected EList<CharacterisedPCMParameterPartition> characerisedParameterPartitions;

	/**
	 * The cached value of the '{@link #getParameterReference() <em>Parameter Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterReference()
	 * @generated
	 * @ordered
	 */
	protected PCMParameterReference parameterReference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMParameterPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.PCM_PARAMETER_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CharacterisedPCMParameterPartition> getCharacerisedParameterPartitions() {
		if (characerisedParameterPartitions == null) {
			characerisedParameterPartitions = new EObjectContainmentWithInverseEList<CharacterisedPCMParameterPartition>(CharacterisedPCMParameterPartition.class, this, QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS, QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION);
		}
		return characerisedParameterPartitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMParameterReference getParameterReference() {
		return parameterReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterReference(PCMParameterReference newParameterReference, NotificationChain msgs) {
		PCMParameterReference oldParameterReference = parameterReference;
		parameterReference = newParameterReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PCM_PARAMETER_PARTITION__PARAMETER_REFERENCE, oldParameterReference, newParameterReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterReference(PCMParameterReference newParameterReference) {
		if (newParameterReference != parameterReference) {
			NotificationChain msgs = null;
			if (parameterReference != null)
				msgs = ((InternalEObject)parameterReference).eInverseRemove(this, PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION, PCMParameterReference.class, msgs);
			if (newParameterReference != null)
				msgs = ((InternalEObject)newParameterReference).eInverseAdd(this, PCMPackage.PCM_PARAMETER_REFERENCE__PARAMETER_PARTITION, PCMParameterReference.class, msgs);
			msgs = basicSetParameterReference(newParameterReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PCM_PARAMETER_PARTITION__PARAMETER_REFERENCE, newParameterReference, newParameterReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCharacerisedParameterPartitions()).basicAdd(otherEnd, msgs);
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__PARAMETER_REFERENCE:
				if (parameterReference != null)
					msgs = ((InternalEObject)parameterReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.PCM_PARAMETER_PARTITION__PARAMETER_REFERENCE, null, msgs);
				return basicSetParameterReference((PCMParameterReference)otherEnd, msgs);
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
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS:
				return ((InternalEList<?>)getCharacerisedParameterPartitions()).basicRemove(otherEnd, msgs);
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__PARAMETER_REFERENCE:
				return basicSetParameterReference(null, msgs);
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
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS:
				return getCharacerisedParameterPartitions();
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__PARAMETER_REFERENCE:
				return getParameterReference();
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
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS:
				getCharacerisedParameterPartitions().clear();
				getCharacerisedParameterPartitions().addAll((Collection<? extends CharacterisedPCMParameterPartition>)newValue);
				return;
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__PARAMETER_REFERENCE:
				setParameterReference((PCMParameterReference)newValue);
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
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS:
				getCharacerisedParameterPartitions().clear();
				return;
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__PARAMETER_REFERENCE:
				setParameterReference((PCMParameterReference)null);
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
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS:
				return characerisedParameterPartitions != null && !characerisedParameterPartitions.isEmpty();
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__PARAMETER_REFERENCE:
				return parameterReference != null;
		}
		return super.eIsSet(featureID);
	}

} //PCMParameterPartitionImpl
