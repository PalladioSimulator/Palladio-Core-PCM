/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.impl;

import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;
import de.uka.ipd.sdq.capra.measurement.ResourceUtilisationSensor;
import de.uka.ipd.sdq.capra.measurement.StateRecorder;

import de.uka.ipd.sdq.capra.measurement.StateSensor;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Utilisation Sensor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.impl.ResourceUtilisationSensorImpl#getStateRecorder <em>State Recorder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceUtilisationSensorImpl extends ResourceSensorImpl implements ResourceUtilisationSensor {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceUtilisationSensorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeasurementPackage.Literals.RESOURCE_UTILISATION_SENSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateRecorder> getStateRecorder() {
		if (stateRecorder == null) {
			stateRecorder = new EObjectContainmentWithInverseEList<StateRecorder>(StateRecorder.class, this, MeasurementPackage.RESOURCE_UTILISATION_SENSOR__STATE_RECORDER, MeasurementPackage.STATE_RECORDER__STATE_SENSOR);
		}
		return stateRecorder;
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
			case MeasurementPackage.RESOURCE_UTILISATION_SENSOR__STATE_RECORDER:
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
			case MeasurementPackage.RESOURCE_UTILISATION_SENSOR__STATE_RECORDER:
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
			case MeasurementPackage.RESOURCE_UTILISATION_SENSOR__STATE_RECORDER:
				return getStateRecorder();
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
			case MeasurementPackage.RESOURCE_UTILISATION_SENSOR__STATE_RECORDER:
				getStateRecorder().clear();
				getStateRecorder().addAll((Collection<? extends StateRecorder>)newValue);
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
			case MeasurementPackage.RESOURCE_UTILISATION_SENSOR__STATE_RECORDER:
				getStateRecorder().clear();
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
			case MeasurementPackage.RESOURCE_UTILISATION_SENSOR__STATE_RECORDER:
				return stateRecorder != null && !stateRecorder.isEmpty();
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
				case MeasurementPackage.RESOURCE_UTILISATION_SENSOR__STATE_RECORDER: return MeasurementPackage.STATE_SENSOR__STATE_RECORDER;
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
				case MeasurementPackage.STATE_SENSOR__STATE_RECORDER: return MeasurementPackage.RESOURCE_UTILISATION_SENSOR__STATE_RECORDER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ResourceUtilisationSensorImpl
