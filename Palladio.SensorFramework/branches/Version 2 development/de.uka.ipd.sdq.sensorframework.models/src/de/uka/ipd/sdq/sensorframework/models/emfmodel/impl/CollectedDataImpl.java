/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel.impl;

import de.uka.ipd.sdq.sensorframework.models.emfmodel.CollectedData;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasurementRange;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.SensorDeclaration;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collected Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.CollectedDataImpl#getSensorDeclaration <em>Sensor Declaration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.CollectedDataImpl#getExperimentRun <em>Experiment Run</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.CollectedDataImpl#getMeasurementRange <em>Measurement Range</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectedDataImpl extends PropertyableImpl implements CollectedData {
	/**
	 * The cached value of the '{@link #getSensorDeclaration() <em>Sensor Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSensorDeclaration()
	 * @generated
	 * @ordered
	 */
	protected SensorDeclaration sensorDeclaration;

	/**
	 * The cached value of the '{@link #getMeasurementRange() <em>Measurement Range</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurementRange()
	 * @generated
	 * @ordered
	 */
	protected EList<MeasurementRange> measurementRange;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectedDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return emfmodelPackage.Literals.COLLECTED_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorDeclaration getSensorDeclaration() {
		if (sensorDeclaration != null && sensorDeclaration.eIsProxy()) {
			InternalEObject oldSensorDeclaration = (InternalEObject)sensorDeclaration;
			sensorDeclaration = (SensorDeclaration)eResolveProxy(oldSensorDeclaration);
			if (sensorDeclaration != oldSensorDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, emfmodelPackage.COLLECTED_DATA__SENSOR_DECLARATION, oldSensorDeclaration, sensorDeclaration));
			}
		}
		return sensorDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorDeclaration basicGetSensorDeclaration() {
		return sensorDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSensorDeclaration(SensorDeclaration newSensorDeclaration) {
		SensorDeclaration oldSensorDeclaration = sensorDeclaration;
		sensorDeclaration = newSensorDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, emfmodelPackage.COLLECTED_DATA__SENSOR_DECLARATION, oldSensorDeclaration, sensorDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentRun getExperimentRun() {
		if (eContainerFeatureID != emfmodelPackage.COLLECTED_DATA__EXPERIMENT_RUN) return null;
		return (ExperimentRun)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExperimentRun(ExperimentRun newExperimentRun, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExperimentRun, emfmodelPackage.COLLECTED_DATA__EXPERIMENT_RUN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExperimentRun(ExperimentRun newExperimentRun) {
		if (newExperimentRun != eInternalContainer() || (eContainerFeatureID != emfmodelPackage.COLLECTED_DATA__EXPERIMENT_RUN && newExperimentRun != null)) {
			if (EcoreUtil.isAncestor(this, newExperimentRun))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExperimentRun != null)
				msgs = ((InternalEObject)newExperimentRun).eInverseAdd(this, emfmodelPackage.EXPERIMENT_RUN__COLLECTED_DATA, ExperimentRun.class, msgs);
			msgs = basicSetExperimentRun(newExperimentRun, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, emfmodelPackage.COLLECTED_DATA__EXPERIMENT_RUN, newExperimentRun, newExperimentRun));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MeasurementRange> getMeasurementRange() {
		if (measurementRange == null) {
			measurementRange = new EObjectContainmentWithInverseEList<MeasurementRange>(MeasurementRange.class, this, emfmodelPackage.COLLECTED_DATA__MEASUREMENT_RANGE, emfmodelPackage.MEASUREMENT_RANGE__COLLECTED_DATA);
		}
		return measurementRange;
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
			case emfmodelPackage.COLLECTED_DATA__EXPERIMENT_RUN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetExperimentRun((ExperimentRun)otherEnd, msgs);
			case emfmodelPackage.COLLECTED_DATA__MEASUREMENT_RANGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMeasurementRange()).basicAdd(otherEnd, msgs);
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
			case emfmodelPackage.COLLECTED_DATA__EXPERIMENT_RUN:
				return basicSetExperimentRun(null, msgs);
			case emfmodelPackage.COLLECTED_DATA__MEASUREMENT_RANGE:
				return ((InternalEList<?>)getMeasurementRange()).basicRemove(otherEnd, msgs);
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
			case emfmodelPackage.COLLECTED_DATA__EXPERIMENT_RUN:
				return eInternalContainer().eInverseRemove(this, emfmodelPackage.EXPERIMENT_RUN__COLLECTED_DATA, ExperimentRun.class, msgs);
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
			case emfmodelPackage.COLLECTED_DATA__SENSOR_DECLARATION:
				if (resolve) return getSensorDeclaration();
				return basicGetSensorDeclaration();
			case emfmodelPackage.COLLECTED_DATA__EXPERIMENT_RUN:
				return getExperimentRun();
			case emfmodelPackage.COLLECTED_DATA__MEASUREMENT_RANGE:
				return getMeasurementRange();
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
			case emfmodelPackage.COLLECTED_DATA__SENSOR_DECLARATION:
				setSensorDeclaration((SensorDeclaration)newValue);
				return;
			case emfmodelPackage.COLLECTED_DATA__EXPERIMENT_RUN:
				setExperimentRun((ExperimentRun)newValue);
				return;
			case emfmodelPackage.COLLECTED_DATA__MEASUREMENT_RANGE:
				getMeasurementRange().clear();
				getMeasurementRange().addAll((Collection<? extends MeasurementRange>)newValue);
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
			case emfmodelPackage.COLLECTED_DATA__SENSOR_DECLARATION:
				setSensorDeclaration((SensorDeclaration)null);
				return;
			case emfmodelPackage.COLLECTED_DATA__EXPERIMENT_RUN:
				setExperimentRun((ExperimentRun)null);
				return;
			case emfmodelPackage.COLLECTED_DATA__MEASUREMENT_RANGE:
				getMeasurementRange().clear();
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
			case emfmodelPackage.COLLECTED_DATA__SENSOR_DECLARATION:
				return sensorDeclaration != null;
			case emfmodelPackage.COLLECTED_DATA__EXPERIMENT_RUN:
				return getExperimentRun() != null;
			case emfmodelPackage.COLLECTED_DATA__MEASUREMENT_RANGE:
				return measurementRange != null && !measurementRange.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CollectedDataImpl
