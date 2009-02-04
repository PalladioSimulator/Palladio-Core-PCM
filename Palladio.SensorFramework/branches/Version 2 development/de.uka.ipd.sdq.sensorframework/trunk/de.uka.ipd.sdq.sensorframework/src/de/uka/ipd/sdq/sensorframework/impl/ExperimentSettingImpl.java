/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.ExperimentSetting;
import de.uka.ipd.sdq.sensorframework.SensorDeclaration;
import de.uka.ipd.sdq.sensorframework.SensorframeworkPackage;

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
 * An implementation of the model object '<em><b>Experiment Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.ExperimentSettingImpl#getExperimentName <em>Experiment Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.ExperimentSettingImpl#getExperimentRuns <em>Experiment Runs</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.ExperimentSettingImpl#getSensors <em>Sensors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExperimentSettingImpl extends PropertyableImpl implements ExperimentSetting {
	/**
	 * The default value of the '{@link #getExperimentName() <em>Experiment Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExperimentName()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPERIMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExperimentName() <em>Experiment Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExperimentName()
	 * @generated
	 * @ordered
	 */
	protected String experimentName = EXPERIMENT_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExperimentRuns() <em>Experiment Runs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExperimentRuns()
	 * @generated
	 * @ordered
	 */
	protected EList<ExperimentRun> experimentRuns;

	/**
	 * The cached value of the '{@link #getSensors() <em>Sensors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSensors()
	 * @generated
	 * @ordered
	 */
	protected EList<SensorDeclaration> sensors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExperimentSettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensorframeworkPackage.Literals.EXPERIMENT_SETTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExperimentName() {
		return experimentName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExperimentName(String newExperimentName) {
		String oldExperimentName = experimentName;
		experimentName = newExperimentName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensorframeworkPackage.EXPERIMENT_SETTING__EXPERIMENT_NAME, oldExperimentName, experimentName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExperimentRun> getExperimentRuns() {
		if (experimentRuns == null) {
			experimentRuns = new EObjectContainmentWithInverseEList<ExperimentRun>(ExperimentRun.class, this, SensorframeworkPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS, SensorframeworkPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING);
		}
		return experimentRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SensorDeclaration> getSensors() {
		if (sensors == null) {
			sensors = new EObjectContainmentWithInverseEList<SensorDeclaration>(SensorDeclaration.class, this, SensorframeworkPackage.EXPERIMENT_SETTING__SENSORS, SensorframeworkPackage.SENSOR_DECLARATION__EXPERIMENT_SETTING);
		}
		return sensors;
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
			case SensorframeworkPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExperimentRuns()).basicAdd(otherEnd, msgs);
			case SensorframeworkPackage.EXPERIMENT_SETTING__SENSORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSensors()).basicAdd(otherEnd, msgs);
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
			case SensorframeworkPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
				return ((InternalEList<?>)getExperimentRuns()).basicRemove(otherEnd, msgs);
			case SensorframeworkPackage.EXPERIMENT_SETTING__SENSORS:
				return ((InternalEList<?>)getSensors()).basicRemove(otherEnd, msgs);
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
			case SensorframeworkPackage.EXPERIMENT_SETTING__EXPERIMENT_NAME:
				return getExperimentName();
			case SensorframeworkPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
				return getExperimentRuns();
			case SensorframeworkPackage.EXPERIMENT_SETTING__SENSORS:
				return getSensors();
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
			case SensorframeworkPackage.EXPERIMENT_SETTING__EXPERIMENT_NAME:
				setExperimentName((String)newValue);
				return;
			case SensorframeworkPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
				getExperimentRuns().clear();
				getExperimentRuns().addAll((Collection<? extends ExperimentRun>)newValue);
				return;
			case SensorframeworkPackage.EXPERIMENT_SETTING__SENSORS:
				getSensors().clear();
				getSensors().addAll((Collection<? extends SensorDeclaration>)newValue);
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
			case SensorframeworkPackage.EXPERIMENT_SETTING__EXPERIMENT_NAME:
				setExperimentName(EXPERIMENT_NAME_EDEFAULT);
				return;
			case SensorframeworkPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
				getExperimentRuns().clear();
				return;
			case SensorframeworkPackage.EXPERIMENT_SETTING__SENSORS:
				getSensors().clear();
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
			case SensorframeworkPackage.EXPERIMENT_SETTING__EXPERIMENT_NAME:
				return EXPERIMENT_NAME_EDEFAULT == null ? experimentName != null : !EXPERIMENT_NAME_EDEFAULT.equals(experimentName);
			case SensorframeworkPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
				return experimentRuns != null && !experimentRuns.isEmpty();
			case SensorframeworkPackage.EXPERIMENT_SETTING__SENSORS:
				return sensors != null && !sensors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (experimentName: ");
		result.append(experimentName);
		result.append(')');
		return result.toString();
	}

} //ExperimentSettingImpl
