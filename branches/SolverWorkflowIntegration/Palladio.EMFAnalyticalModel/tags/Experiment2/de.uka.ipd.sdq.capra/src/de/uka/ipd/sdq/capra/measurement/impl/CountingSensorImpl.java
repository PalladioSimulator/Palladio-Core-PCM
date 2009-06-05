/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.measurement.CountingRecorder;
import de.uka.ipd.sdq.capra.measurement.CountingSensor;
import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;
import de.uka.ipd.sdq.capra.measurement.VisitProbe;

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
 * An implementation of the model object '<em><b>Counting Sensor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.CountingSensorImpl#getCountingRecorders <em>Counting Recorders</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.CountingSensorImpl#getCountVisits <em>Count Visits</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CountingSensorImpl extends SensorImpl implements CountingSensor {
	/**
	 * The cached value of the '{@link #getCountingRecorders() <em>Counting Recorders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountingRecorders()
	 * @generated
	 * @ordered
	 */
	protected EList<CountingRecorder> countingRecorders;

	/**
	 * The cached value of the '{@link #getCountVisits() <em>Count Visits</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountVisits()
	 * @generated
	 * @ordered
	 */
	protected VisitProbe countVisits;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CountingSensorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementPackage.Literals.COUNTING_SENSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CountingRecorder> getCountingRecorders() {
		if (countingRecorders == null) {
			countingRecorders = new EObjectContainmentWithInverseEList<CountingRecorder>(CountingRecorder.class, this, MeasurementPackage.COUNTING_SENSOR__COUNTING_RECORDERS, MeasurementPackage.COUNTING_RECORDER__COUNTING_SENSOR);
		}
		return countingRecorders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitProbe getCountVisits() {
		if (countVisits != null && countVisits.eIsProxy()) {
			InternalEObject oldCountVisits = (InternalEObject)countVisits;
			countVisits = (VisitProbe)eResolveProxy(oldCountVisits);
			if (countVisits != oldCountVisits) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MeasurementPackage.COUNTING_SENSOR__COUNT_VISITS, oldCountVisits, countVisits));
			}
		}
		return countVisits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitProbe basicGetCountVisits() {
		return countVisits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountVisits(VisitProbe newCountVisits) {
		VisitProbe oldCountVisits = countVisits;
		countVisits = newCountVisits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.COUNTING_SENSOR__COUNT_VISITS, oldCountVisits, countVisits));
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
			case MeasurementPackage.COUNTING_SENSOR__COUNTING_RECORDERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCountingRecorders()).basicAdd(otherEnd, msgs);
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
			case MeasurementPackage.COUNTING_SENSOR__COUNTING_RECORDERS:
				return ((InternalEList<?>)getCountingRecorders()).basicRemove(otherEnd, msgs);
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
			case MeasurementPackage.COUNTING_SENSOR__COUNTING_RECORDERS:
				return getCountingRecorders();
			case MeasurementPackage.COUNTING_SENSOR__COUNT_VISITS:
				if (resolve) return getCountVisits();
				return basicGetCountVisits();
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
			case MeasurementPackage.COUNTING_SENSOR__COUNTING_RECORDERS:
				getCountingRecorders().clear();
				getCountingRecorders().addAll((Collection<? extends CountingRecorder>)newValue);
				return;
			case MeasurementPackage.COUNTING_SENSOR__COUNT_VISITS:
				setCountVisits((VisitProbe)newValue);
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
			case MeasurementPackage.COUNTING_SENSOR__COUNTING_RECORDERS:
				getCountingRecorders().clear();
				return;
			case MeasurementPackage.COUNTING_SENSOR__COUNT_VISITS:
				setCountVisits((VisitProbe)null);
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
			case MeasurementPackage.COUNTING_SENSOR__COUNTING_RECORDERS:
				return countingRecorders != null && !countingRecorders.isEmpty();
			case MeasurementPackage.COUNTING_SENSOR__COUNT_VISITS:
				return countVisits != null;
		}
		return super.eIsSet(featureID);
	}

} //CountingSensorImpl
