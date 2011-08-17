/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Characterised PCM Parameter Partition Interval</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.CharacterisedPCMParameterPartitionIntervalImpl#getFrom <em>From</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.CharacterisedPCMParameterPartitionIntervalImpl#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CharacterisedPCMParameterPartitionIntervalImpl extends CharacterisedPCMParameterPartitionImpl implements CharacterisedPCMParameterPartitionInterval {
	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected PCMRandomVariable from;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected PCMRandomVariable to;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CharacterisedPCMParameterPartitionIntervalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRandomVariable getFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFrom(PCMRandomVariable newFrom, NotificationChain msgs) {
		PCMRandomVariable oldFrom = from;
		from = newFrom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM, oldFrom, newFrom);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(PCMRandomVariable newFrom) {
		if (newFrom != from) {
			NotificationChain msgs = null;
			if (from != null)
				msgs = ((InternalEObject)from).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM, null, msgs);
			if (newFrom != null)
				msgs = ((InternalEObject)newFrom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM, null, msgs);
			msgs = basicSetFrom(newFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM, newFrom, newFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRandomVariable getTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTo(PCMRandomVariable newTo, NotificationChain msgs) {
		PCMRandomVariable oldTo = to;
		to = newTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO, oldTo, newTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(PCMRandomVariable newTo) {
		if (newTo != to) {
			NotificationChain msgs = null;
			if (to != null)
				msgs = ((InternalEObject)to).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO, null, msgs);
			if (newTo != null)
				msgs = ((InternalEObject)newTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO, null, msgs);
			msgs = basicSetTo(newTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO, newTo, newTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM:
				return basicSetFrom(null, msgs);
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO:
				return basicSetTo(null, msgs);
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
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM:
				return getFrom();
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO:
				return getTo();
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
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM:
				setFrom((PCMRandomVariable)newValue);
				return;
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO:
				setTo((PCMRandomVariable)newValue);
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
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM:
				setFrom((PCMRandomVariable)null);
				return;
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO:
				setTo((PCMRandomVariable)null);
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
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM:
				return from != null;
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO:
				return to != null;
		}
		return super.eIsSet(featureID);
	}

} //CharacterisedPCMParameterPartitionIntervalImpl
