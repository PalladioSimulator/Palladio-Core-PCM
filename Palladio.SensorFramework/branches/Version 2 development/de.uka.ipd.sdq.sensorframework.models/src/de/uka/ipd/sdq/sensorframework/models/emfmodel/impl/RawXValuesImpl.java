/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel.impl;

import de.uka.ipd.sdq.sensorframework.models.emfmodel.RawMeasurements;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.RawXValues;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Raw XValues</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.RawXValuesImpl#getRawMeasurements <em>Raw Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RawXValuesImpl extends EObjectImpl implements RawXValues {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RawXValuesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return emfmodelPackage.Literals.RAW_XVALUES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawMeasurements getRawMeasurements() {
		if (eContainerFeatureID != emfmodelPackage.RAW_XVALUES__RAW_MEASUREMENTS) return null;
		return (RawMeasurements)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawMeasurements(RawMeasurements newRawMeasurements, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRawMeasurements, emfmodelPackage.RAW_XVALUES__RAW_MEASUREMENTS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawMeasurements(RawMeasurements newRawMeasurements) {
		if (newRawMeasurements != eInternalContainer() || (eContainerFeatureID != emfmodelPackage.RAW_XVALUES__RAW_MEASUREMENTS && newRawMeasurements != null)) {
			if (EcoreUtil.isAncestor(this, newRawMeasurements))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRawMeasurements != null)
				msgs = ((InternalEObject)newRawMeasurements).eInverseAdd(this, emfmodelPackage.RAW_MEASUREMENTS__RAW_XVALUES, RawMeasurements.class, msgs);
			msgs = basicSetRawMeasurements(newRawMeasurements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, emfmodelPackage.RAW_XVALUES__RAW_MEASUREMENTS, newRawMeasurements, newRawMeasurements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case emfmodelPackage.RAW_XVALUES__RAW_MEASUREMENTS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRawMeasurements((RawMeasurements)otherEnd, msgs);
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
			case emfmodelPackage.RAW_XVALUES__RAW_MEASUREMENTS:
				return basicSetRawMeasurements(null, msgs);
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
		switch (eContainerFeatureID) {
			case emfmodelPackage.RAW_XVALUES__RAW_MEASUREMENTS:
				return eInternalContainer().eInverseRemove(this, emfmodelPackage.RAW_MEASUREMENTS__RAW_XVALUES, RawMeasurements.class, msgs);
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
			case emfmodelPackage.RAW_XVALUES__RAW_MEASUREMENTS:
				return getRawMeasurements();
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
			case emfmodelPackage.RAW_XVALUES__RAW_MEASUREMENTS:
				setRawMeasurements((RawMeasurements)newValue);
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
			case emfmodelPackage.RAW_XVALUES__RAW_MEASUREMENTS:
				setRawMeasurements((RawMeasurements)null);
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
			case emfmodelPackage.RAW_XVALUES__RAW_MEASUREMENTS:
				return getRawMeasurements() != null;
		}
		return super.eIsSet(featureID);
	}

} //RawXValuesImpl
