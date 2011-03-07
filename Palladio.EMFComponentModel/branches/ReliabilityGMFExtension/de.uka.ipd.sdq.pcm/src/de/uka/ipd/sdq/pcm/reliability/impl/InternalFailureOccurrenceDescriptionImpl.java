/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.impl;

import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType;

import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Failure Occurrence Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.impl.InternalFailureOccurrenceDescriptionImpl#getSoftwareInducedFailureType__InternalFailureOccurrenceDescription <em>Software Induced Failure Type Internal Failure Occurrence Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.impl.InternalFailureOccurrenceDescriptionImpl#getInternalAction__InternalFailureOccurrenceDescription <em>Internal Action Internal Failure Occurrence Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalFailureOccurrenceDescriptionImpl extends FailureOccurrenceDescriptionImpl implements InternalFailureOccurrenceDescription {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getSoftwareInducedFailureType__InternalFailureOccurrenceDescription() <em>Software Induced Failure Type Internal Failure Occurrence Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoftwareInducedFailureType__InternalFailureOccurrenceDescription()
	 * @generated
	 * @ordered
	 */
	protected SoftwareInducedFailureType softwareInducedFailureType__InternalFailureOccurrenceDescription;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalFailureOccurrenceDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReliabilityPackage.Literals.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareInducedFailureType getSoftwareInducedFailureType__InternalFailureOccurrenceDescription() {
		if (softwareInducedFailureType__InternalFailureOccurrenceDescription != null && softwareInducedFailureType__InternalFailureOccurrenceDescription.eIsProxy()) {
			InternalEObject oldSoftwareInducedFailureType__InternalFailureOccurrenceDescription = (InternalEObject)softwareInducedFailureType__InternalFailureOccurrenceDescription;
			softwareInducedFailureType__InternalFailureOccurrenceDescription = (SoftwareInducedFailureType)eResolveProxy(oldSoftwareInducedFailureType__InternalFailureOccurrenceDescription);
			if (softwareInducedFailureType__InternalFailureOccurrenceDescription != oldSoftwareInducedFailureType__InternalFailureOccurrenceDescription) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION, oldSoftwareInducedFailureType__InternalFailureOccurrenceDescription, softwareInducedFailureType__InternalFailureOccurrenceDescription));
			}
		}
		return softwareInducedFailureType__InternalFailureOccurrenceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareInducedFailureType basicGetSoftwareInducedFailureType__InternalFailureOccurrenceDescription() {
		return softwareInducedFailureType__InternalFailureOccurrenceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSoftwareInducedFailureType__InternalFailureOccurrenceDescription(SoftwareInducedFailureType newSoftwareInducedFailureType__InternalFailureOccurrenceDescription, NotificationChain msgs) {
		SoftwareInducedFailureType oldSoftwareInducedFailureType__InternalFailureOccurrenceDescription = softwareInducedFailureType__InternalFailureOccurrenceDescription;
		softwareInducedFailureType__InternalFailureOccurrenceDescription = newSoftwareInducedFailureType__InternalFailureOccurrenceDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION, oldSoftwareInducedFailureType__InternalFailureOccurrenceDescription, newSoftwareInducedFailureType__InternalFailureOccurrenceDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoftwareInducedFailureType__InternalFailureOccurrenceDescription(SoftwareInducedFailureType newSoftwareInducedFailureType__InternalFailureOccurrenceDescription) {
		if (newSoftwareInducedFailureType__InternalFailureOccurrenceDescription != softwareInducedFailureType__InternalFailureOccurrenceDescription) {
			NotificationChain msgs = null;
			if (softwareInducedFailureType__InternalFailureOccurrenceDescription != null)
				msgs = ((InternalEObject)softwareInducedFailureType__InternalFailureOccurrenceDescription).eInverseRemove(this, ReliabilityPackage.SOFTWARE_INDUCED_FAILURE_TYPE__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SOFTWARE_INDUCED_FAILURE_TYPE, SoftwareInducedFailureType.class, msgs);
			if (newSoftwareInducedFailureType__InternalFailureOccurrenceDescription != null)
				msgs = ((InternalEObject)newSoftwareInducedFailureType__InternalFailureOccurrenceDescription).eInverseAdd(this, ReliabilityPackage.SOFTWARE_INDUCED_FAILURE_TYPE__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SOFTWARE_INDUCED_FAILURE_TYPE, SoftwareInducedFailureType.class, msgs);
			msgs = basicSetSoftwareInducedFailureType__InternalFailureOccurrenceDescription(newSoftwareInducedFailureType__InternalFailureOccurrenceDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION, newSoftwareInducedFailureType__InternalFailureOccurrenceDescription, newSoftwareInducedFailureType__InternalFailureOccurrenceDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalAction getInternalAction__InternalFailureOccurrenceDescription() {
		if (eContainerFeatureID() != ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION) return null;
		return (InternalAction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInternalAction__InternalFailureOccurrenceDescription(InternalAction newInternalAction__InternalFailureOccurrenceDescription, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInternalAction__InternalFailureOccurrenceDescription, ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalAction__InternalFailureOccurrenceDescription(InternalAction newInternalAction__InternalFailureOccurrenceDescription) {
		if (newInternalAction__InternalFailureOccurrenceDescription != eInternalContainer() || (eContainerFeatureID() != ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION && newInternalAction__InternalFailureOccurrenceDescription != null)) {
			if (EcoreUtil.isAncestor(this, newInternalAction__InternalFailureOccurrenceDescription))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInternalAction__InternalFailureOccurrenceDescription != null)
				msgs = ((InternalEObject)newInternalAction__InternalFailureOccurrenceDescription).eInverseAdd(this, SeffPackage.INTERNAL_ACTION__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_INTERNAL_ACTION, InternalAction.class, msgs);
			msgs = basicSetInternalAction__InternalFailureOccurrenceDescription(newInternalAction__InternalFailureOccurrenceDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION, newInternalAction__InternalFailureOccurrenceDescription, newInternalAction__InternalFailureOccurrenceDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				if (softwareInducedFailureType__InternalFailureOccurrenceDescription != null)
					msgs = ((InternalEObject)softwareInducedFailureType__InternalFailureOccurrenceDescription).eInverseRemove(this, ReliabilityPackage.SOFTWARE_INDUCED_FAILURE_TYPE__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_SOFTWARE_INDUCED_FAILURE_TYPE, SoftwareInducedFailureType.class, msgs);
				return basicSetSoftwareInducedFailureType__InternalFailureOccurrenceDescription((SoftwareInducedFailureType)otherEnd, msgs);
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInternalAction__InternalFailureOccurrenceDescription((InternalAction)otherEnd, msgs);
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
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return basicSetSoftwareInducedFailureType__InternalFailureOccurrenceDescription(null, msgs);
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return basicSetInternalAction__InternalFailureOccurrenceDescription(null, msgs);
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
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return eInternalContainer().eInverseRemove(this, SeffPackage.INTERNAL_ACTION__INTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_INTERNAL_ACTION, InternalAction.class, msgs);
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
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				if (resolve) return getSoftwareInducedFailureType__InternalFailureOccurrenceDescription();
				return basicGetSoftwareInducedFailureType__InternalFailureOccurrenceDescription();
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return getInternalAction__InternalFailureOccurrenceDescription();
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
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				setSoftwareInducedFailureType__InternalFailureOccurrenceDescription((SoftwareInducedFailureType)newValue);
				return;
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				setInternalAction__InternalFailureOccurrenceDescription((InternalAction)newValue);
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
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				setSoftwareInducedFailureType__InternalFailureOccurrenceDescription((SoftwareInducedFailureType)null);
				return;
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				setInternalAction__InternalFailureOccurrenceDescription((InternalAction)null);
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
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return softwareInducedFailureType__InternalFailureOccurrenceDescription != null;
			case ReliabilityPackage.INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__INTERNAL_ACTION_INTERNAL_FAILURE_OCCURRENCE_DESCRIPTION:
				return getInternalAction__InternalFailureOccurrenceDescription() != null;
		}
		return super.eIsSet(featureID);
	}

} //InternalFailureOccurrenceDescriptionImpl
