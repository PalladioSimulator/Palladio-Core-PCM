/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.impl;

import de.uka.ipd.sdq.pcm.qosannotations.reliability.SpecifiedReliabilityAnnotation;

import de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.StopFailureType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Failure Occurrence Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.impl.ExternalFailureOccurrenceDescriptionImpl#getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription <em>Specified Reliability Annotation External Failure Occurrence Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.impl.ExternalFailureOccurrenceDescriptionImpl#getStopFailureType__ExternalFailureOccurrenceDescription <em>Stop Failure Type External Failure Occurrence Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalFailureOccurrenceDescriptionImpl extends FailureOccurrenceDescriptionImpl implements ExternalFailureOccurrenceDescription {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getStopFailureType__ExternalFailureOccurrenceDescription() <em>Stop Failure Type External Failure Occurrence Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopFailureType__ExternalFailureOccurrenceDescription()
	 * @generated
	 * @ordered
	 */
	protected StopFailureType stopFailureType__ExternalFailureOccurrenceDescription;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalFailureOccurrenceDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReliabilityPackage.Literals.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecifiedReliabilityAnnotation getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription() {
		if (eContainerFeatureID() != ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION) return null;
		return (SpecifiedReliabilityAnnotation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(SpecifiedReliabilityAnnotation newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription, ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(SpecifiedReliabilityAnnotation newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription) {
		if (newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription != eInternalContainer() || (eContainerFeatureID() != ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION && newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription != null)) {
			if (EcoreUtil.isAncestor(this, newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription != null)
				msgs = ((InternalEObject)newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription).eInverseAdd(this, de.uka.ipd.sdq.pcm.qosannotations.reliability.ReliabilityPackage.SPECIFIED_RELIABILITY_ANNOTATION__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SPECIFIED_RELIABILITY_ANNOTATION, SpecifiedReliabilityAnnotation.class, msgs);
			msgs = basicSetSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION, newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription, newSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StopFailureType getStopFailureType__ExternalFailureOccurrenceDescription() {
		if (stopFailureType__ExternalFailureOccurrenceDescription != null && stopFailureType__ExternalFailureOccurrenceDescription.eIsProxy()) {
			InternalEObject oldStopFailureType__ExternalFailureOccurrenceDescription = (InternalEObject)stopFailureType__ExternalFailureOccurrenceDescription;
			stopFailureType__ExternalFailureOccurrenceDescription = (StopFailureType)eResolveProxy(oldStopFailureType__ExternalFailureOccurrenceDescription);
			if (stopFailureType__ExternalFailureOccurrenceDescription != oldStopFailureType__ExternalFailureOccurrenceDescription) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__STOP_FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION, oldStopFailureType__ExternalFailureOccurrenceDescription, stopFailureType__ExternalFailureOccurrenceDescription));
			}
		}
		return stopFailureType__ExternalFailureOccurrenceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StopFailureType basicGetStopFailureType__ExternalFailureOccurrenceDescription() {
		return stopFailureType__ExternalFailureOccurrenceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStopFailureType__ExternalFailureOccurrenceDescription(StopFailureType newStopFailureType__ExternalFailureOccurrenceDescription, NotificationChain msgs) {
		StopFailureType oldStopFailureType__ExternalFailureOccurrenceDescription = stopFailureType__ExternalFailureOccurrenceDescription;
		stopFailureType__ExternalFailureOccurrenceDescription = newStopFailureType__ExternalFailureOccurrenceDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__STOP_FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION, oldStopFailureType__ExternalFailureOccurrenceDescription, newStopFailureType__ExternalFailureOccurrenceDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopFailureType__ExternalFailureOccurrenceDescription(StopFailureType newStopFailureType__ExternalFailureOccurrenceDescription) {
		if (newStopFailureType__ExternalFailureOccurrenceDescription != stopFailureType__ExternalFailureOccurrenceDescription) {
			NotificationChain msgs = null;
			if (stopFailureType__ExternalFailureOccurrenceDescription != null)
				msgs = ((InternalEObject)stopFailureType__ExternalFailureOccurrenceDescription).eInverseRemove(this, ReliabilityPackage.STOP_FAILURE_TYPE__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_STOP_FAILURE_TYPE, StopFailureType.class, msgs);
			if (newStopFailureType__ExternalFailureOccurrenceDescription != null)
				msgs = ((InternalEObject)newStopFailureType__ExternalFailureOccurrenceDescription).eInverseAdd(this, ReliabilityPackage.STOP_FAILURE_TYPE__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_STOP_FAILURE_TYPE, StopFailureType.class, msgs);
			msgs = basicSetStopFailureType__ExternalFailureOccurrenceDescription(newStopFailureType__ExternalFailureOccurrenceDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__STOP_FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION, newStopFailureType__ExternalFailureOccurrenceDescription, newStopFailureType__ExternalFailureOccurrenceDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription((SpecifiedReliabilityAnnotation)otherEnd, msgs);
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__STOP_FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				if (stopFailureType__ExternalFailureOccurrenceDescription != null)
					msgs = ((InternalEObject)stopFailureType__ExternalFailureOccurrenceDescription).eInverseRemove(this, ReliabilityPackage.STOP_FAILURE_TYPE__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_STOP_FAILURE_TYPE, StopFailureType.class, msgs);
				return basicSetStopFailureType__ExternalFailureOccurrenceDescription((StopFailureType)otherEnd, msgs);
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
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return basicSetSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription(null, msgs);
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__STOP_FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return basicSetStopFailureType__ExternalFailureOccurrenceDescription(null, msgs);
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
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return eInternalContainer().eInverseRemove(this, de.uka.ipd.sdq.pcm.qosannotations.reliability.ReliabilityPackage.SPECIFIED_RELIABILITY_ANNOTATION__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SPECIFIED_RELIABILITY_ANNOTATION, SpecifiedReliabilityAnnotation.class, msgs);
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
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription();
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__STOP_FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				if (resolve) return getStopFailureType__ExternalFailureOccurrenceDescription();
				return basicGetStopFailureType__ExternalFailureOccurrenceDescription();
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
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				setSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription((SpecifiedReliabilityAnnotation)newValue);
				return;
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__STOP_FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				setStopFailureType__ExternalFailureOccurrenceDescription((StopFailureType)newValue);
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
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				setSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription((SpecifiedReliabilityAnnotation)null);
				return;
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__STOP_FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				setStopFailureType__ExternalFailureOccurrenceDescription((StopFailureType)null);
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
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SPECIFIED_RELIABILITY_ANNOTATION_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription() != null;
			case ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__STOP_FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return stopFailureType__ExternalFailureOccurrenceDescription != null;
		}
		return super.eIsSet(featureID);
	}

} //ExternalFailureOccurrenceDescriptionImpl
