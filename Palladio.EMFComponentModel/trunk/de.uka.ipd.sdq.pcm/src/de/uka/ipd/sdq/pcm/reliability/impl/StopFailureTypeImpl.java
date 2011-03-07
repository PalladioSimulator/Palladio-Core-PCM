/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.impl;

import de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.StopFailureType;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stop Failure Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.impl.StopFailureTypeImpl#getExternalFailureOccurrenceDescriptions__StopFailureType <em>External Failure Occurrence Descriptions Stop Failure Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StopFailureTypeImpl extends FailureTypeImpl implements StopFailureType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getExternalFailureOccurrenceDescriptions__StopFailureType() <em>External Failure Occurrence Descriptions Stop Failure Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalFailureOccurrenceDescriptions__StopFailureType()
	 * @generated
	 * @ordered
	 */
	protected EList<ExternalFailureOccurrenceDescription> externalFailureOccurrenceDescriptions__StopFailureType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StopFailureTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReliabilityPackage.Literals.STOP_FAILURE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExternalFailureOccurrenceDescription> getExternalFailureOccurrenceDescriptions__StopFailureType() {
		if (externalFailureOccurrenceDescriptions__StopFailureType == null) {
			externalFailureOccurrenceDescriptions__StopFailureType = new EObjectWithInverseResolvingEList<ExternalFailureOccurrenceDescription>(ExternalFailureOccurrenceDescription.class, this, ReliabilityPackage.STOP_FAILURE_TYPE__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_STOP_FAILURE_TYPE, ReliabilityPackage.EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION__STOP_FAILURE_TYPE_EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTION);
		}
		return externalFailureOccurrenceDescriptions__StopFailureType;
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
			case ReliabilityPackage.STOP_FAILURE_TYPE__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_STOP_FAILURE_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExternalFailureOccurrenceDescriptions__StopFailureType()).basicAdd(otherEnd, msgs);
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
			case ReliabilityPackage.STOP_FAILURE_TYPE__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_STOP_FAILURE_TYPE:
				return ((InternalEList<?>)getExternalFailureOccurrenceDescriptions__StopFailureType()).basicRemove(otherEnd, msgs);
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
			case ReliabilityPackage.STOP_FAILURE_TYPE__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_STOP_FAILURE_TYPE:
				return getExternalFailureOccurrenceDescriptions__StopFailureType();
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
			case ReliabilityPackage.STOP_FAILURE_TYPE__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_STOP_FAILURE_TYPE:
				getExternalFailureOccurrenceDescriptions__StopFailureType().clear();
				getExternalFailureOccurrenceDescriptions__StopFailureType().addAll((Collection<? extends ExternalFailureOccurrenceDescription>)newValue);
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
			case ReliabilityPackage.STOP_FAILURE_TYPE__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_STOP_FAILURE_TYPE:
				getExternalFailureOccurrenceDescriptions__StopFailureType().clear();
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
			case ReliabilityPackage.STOP_FAILURE_TYPE__EXTERNAL_FAILURE_OCCURRENCE_DESCRIPTIONS_STOP_FAILURE_TYPE:
				return externalFailureOccurrenceDescriptions__StopFailureType != null && !externalFailureOccurrenceDescriptions__StopFailureType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StopFailureTypeImpl
