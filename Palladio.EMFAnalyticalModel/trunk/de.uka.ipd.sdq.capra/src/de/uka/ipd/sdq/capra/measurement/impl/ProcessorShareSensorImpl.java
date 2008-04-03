/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.core.ProcessVariable;

import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;
import de.uka.ipd.sdq.capra.measurement.ProcessorShareSensor;
import de.uka.ipd.sdq.capra.measurement.StateRecorder;

import de.uka.ipd.sdq.capra.measurement.StateSensor;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processor Share Sensor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.ProcessorShareSensorImpl#getStateRecorder <em>State Recorder</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.ProcessorShareSensorImpl#getObservedProcess <em>Observed Process</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessorShareSensorImpl extends ResourceSensorImpl implements ProcessorShareSensor {
	/**
	 * The cached value of the '{@link #getStateRecorder() <em>State Recorder</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateRecorder()
	 * @generated
	 * @ordered
	 */
	protected EList<StateRecorder> stateRecorder;

	/**
	 * The cached value of the '{@link #getObservedProcess() <em>Observed Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservedProcess()
	 * @generated
	 * @ordered
	 */
	protected ProcessVariable observedProcess;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessorShareSensorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementPackage.Literals.PROCESSOR_SHARE_SENSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateRecorder> getStateRecorder() {
		if (stateRecorder == null) {
			stateRecorder = new EObjectContainmentWithInverseEList<StateRecorder>(StateRecorder.class, this, MeasurementPackage.PROCESSOR_SHARE_SENSOR__STATE_RECORDER, MeasurementPackage.STATE_RECORDER__STATE_SENSOR);
		}
		return stateRecorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessVariable getObservedProcess() {
		if (observedProcess != null && observedProcess.eIsProxy()) {
			InternalEObject oldObservedProcess = (InternalEObject)observedProcess;
			observedProcess = (ProcessVariable)eResolveProxy(oldObservedProcess);
			if (observedProcess != oldObservedProcess) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MeasurementPackage.PROCESSOR_SHARE_SENSOR__OBSERVED_PROCESS, oldObservedProcess, observedProcess));
			}
		}
		return observedProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessVariable basicGetObservedProcess() {
		return observedProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObservedProcess(ProcessVariable newObservedProcess) {
		ProcessVariable oldObservedProcess = observedProcess;
		observedProcess = newObservedProcess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeasurementPackage.PROCESSOR_SHARE_SENSOR__OBSERVED_PROCESS, oldObservedProcess, observedProcess));
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
			case MeasurementPackage.PROCESSOR_SHARE_SENSOR__STATE_RECORDER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStateRecorder()).basicAdd(otherEnd, msgs);
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
			case MeasurementPackage.PROCESSOR_SHARE_SENSOR__STATE_RECORDER:
				return ((InternalEList<?>)getStateRecorder()).basicRemove(otherEnd, msgs);
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
			case MeasurementPackage.PROCESSOR_SHARE_SENSOR__STATE_RECORDER:
				return getStateRecorder();
			case MeasurementPackage.PROCESSOR_SHARE_SENSOR__OBSERVED_PROCESS:
				if (resolve) return getObservedProcess();
				return basicGetObservedProcess();
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
			case MeasurementPackage.PROCESSOR_SHARE_SENSOR__STATE_RECORDER:
				getStateRecorder().clear();
				getStateRecorder().addAll((Collection<? extends StateRecorder>)newValue);
				return;
			case MeasurementPackage.PROCESSOR_SHARE_SENSOR__OBSERVED_PROCESS:
				setObservedProcess((ProcessVariable)newValue);
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
			case MeasurementPackage.PROCESSOR_SHARE_SENSOR__STATE_RECORDER:
				getStateRecorder().clear();
				return;
			case MeasurementPackage.PROCESSOR_SHARE_SENSOR__OBSERVED_PROCESS:
				setObservedProcess((ProcessVariable)null);
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
			case MeasurementPackage.PROCESSOR_SHARE_SENSOR__STATE_RECORDER:
				return stateRecorder != null && !stateRecorder.isEmpty();
			case MeasurementPackage.PROCESSOR_SHARE_SENSOR__OBSERVED_PROCESS:
				return observedProcess != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == StateSensor.class) {
			switch (derivedFeatureID) {
				case MeasurementPackage.PROCESSOR_SHARE_SENSOR__STATE_RECORDER: return MeasurementPackage.STATE_SENSOR__STATE_RECORDER;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == StateSensor.class) {
			switch (baseFeatureID) {
				case MeasurementPackage.STATE_SENSOR__STATE_RECORDER: return MeasurementPackage.PROCESSOR_SHARE_SENSOR__STATE_RECORDER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ProcessorShareSensorImpl
