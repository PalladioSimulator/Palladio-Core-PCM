/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.measurement.Condition;
import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;
import de.uka.ipd.sdq.capra.measurement.Recorder;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recorder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.RecorderImpl#getStartCondition <em>Start Condition</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.RecorderImpl#getStopCondition <em>Stop Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RecorderImpl extends EObjectImpl implements Recorder {
	/**
	 * The cached value of the '{@link #getStartCondition() <em>Start Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartCondition()
	 * @generated
	 * @ordered
	 */
	protected Condition startCondition;

	/**
	 * The cached value of the '{@link #getStopCondition() <em>Stop Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopCondition()
	 * @generated
	 * @ordered
	 */
	protected Condition stopCondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecorderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementPackage.Literals.RECORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getStartCondition() {
		return startCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartCondition(Condition newStartCondition, NotificationChain msgs) {
		Condition oldStartCondition = startCondition;
		startCondition = newStartCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MeasurementPackage.RECORDER__START_CONDITION, oldStartCondition, newStartCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartCondition(Condition newStartCondition) {
		if (newStartCondition != startCondition) {
			NotificationChain msgs = null;
			if (startCondition != null)
				msgs = ((InternalEObject)startCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MeasurementPackage.RECORDER__START_CONDITION, null, msgs);
			if (newStartCondition != null)
				msgs = ((InternalEObject)newStartCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MeasurementPackage.RECORDER__START_CONDITION, null, msgs);
			msgs = basicSetStartCondition(newStartCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.RECORDER__START_CONDITION, newStartCondition, newStartCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getStopCondition() {
		return stopCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStopCondition(Condition newStopCondition, NotificationChain msgs) {
		Condition oldStopCondition = stopCondition;
		stopCondition = newStopCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MeasurementPackage.RECORDER__STOP_CONDITION, oldStopCondition, newStopCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopCondition(Condition newStopCondition) {
		if (newStopCondition != stopCondition) {
			NotificationChain msgs = null;
			if (stopCondition != null)
				msgs = ((InternalEObject)stopCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MeasurementPackage.RECORDER__STOP_CONDITION, null, msgs);
			if (newStopCondition != null)
				msgs = ((InternalEObject)newStopCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MeasurementPackage.RECORDER__STOP_CONDITION, null, msgs);
			msgs = basicSetStopCondition(newStopCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.RECORDER__STOP_CONDITION, newStopCondition, newStopCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MeasurementPackage.RECORDER__START_CONDITION:
				return basicSetStartCondition(null, msgs);
			case MeasurementPackage.RECORDER__STOP_CONDITION:
				return basicSetStopCondition(null, msgs);
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
			case MeasurementPackage.RECORDER__START_CONDITION:
				return getStartCondition();
			case MeasurementPackage.RECORDER__STOP_CONDITION:
				return getStopCondition();
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
			case MeasurementPackage.RECORDER__START_CONDITION:
				setStartCondition((Condition)newValue);
				return;
			case MeasurementPackage.RECORDER__STOP_CONDITION:
				setStopCondition((Condition)newValue);
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
			case MeasurementPackage.RECORDER__START_CONDITION:
				setStartCondition((Condition)null);
				return;
			case MeasurementPackage.RECORDER__STOP_CONDITION:
				setStopCondition((Condition)null);
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
			case MeasurementPackage.RECORDER__START_CONDITION:
				return startCondition != null;
			case MeasurementPackage.RECORDER__STOP_CONDITION:
				return stopCondition != null;
		}
		return super.eIsSet(featureID);
	}

} //RecorderImpl
