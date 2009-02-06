/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel.impl;

import de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentSetting;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasureCharacterization;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.PersistenceKindOptions;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.SensorDeclaration;
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
 * An implementation of the model object '<em><b>Sensor Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.SensorDeclarationImpl#getExperimentSetting <em>Experiment Setting</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.SensorDeclarationImpl#getMeasureCharacterization <em>Measure Characterization</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.impl.SensorDeclarationImpl#getPersistencyKind <em>Persistency Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SensorDeclarationImpl extends EObjectImpl implements SensorDeclaration {
	/**
	 * The cached value of the '{@link #getMeasureCharacterization() <em>Measure Characterization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasureCharacterization()
	 * @generated
	 * @ordered
	 */
	protected MeasureCharacterization measureCharacterization;

	/**
	 * The default value of the '{@link #getPersistencyKind() <em>Persistency Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistencyKind()
	 * @generated
	 * @ordered
	 */
	protected static final PersistenceKindOptions PERSISTENCY_KIND_EDEFAULT = PersistenceKindOptions.BINARY_LONG;

	/**
	 * The cached value of the '{@link #getPersistencyKind() <em>Persistency Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistencyKind()
	 * @generated
	 * @ordered
	 */
	protected PersistenceKindOptions persistencyKind = PERSISTENCY_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SensorDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return emfmodelPackage.Literals.SENSOR_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentSetting getExperimentSetting() {
		if (eContainerFeatureID != emfmodelPackage.SENSOR_DECLARATION__EXPERIMENT_SETTING) return null;
		return (ExperimentSetting)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExperimentSetting(ExperimentSetting newExperimentSetting, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExperimentSetting, emfmodelPackage.SENSOR_DECLARATION__EXPERIMENT_SETTING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExperimentSetting(ExperimentSetting newExperimentSetting) {
		if (newExperimentSetting != eInternalContainer() || (eContainerFeatureID != emfmodelPackage.SENSOR_DECLARATION__EXPERIMENT_SETTING && newExperimentSetting != null)) {
			if (EcoreUtil.isAncestor(this, newExperimentSetting))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExperimentSetting != null)
				msgs = ((InternalEObject)newExperimentSetting).eInverseAdd(this, emfmodelPackage.EXPERIMENT_SETTING__SENSORS, ExperimentSetting.class, msgs);
			msgs = basicSetExperimentSetting(newExperimentSetting, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, emfmodelPackage.SENSOR_DECLARATION__EXPERIMENT_SETTING, newExperimentSetting, newExperimentSetting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasureCharacterization getMeasureCharacterization() {
		return measureCharacterization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeasureCharacterization(MeasureCharacterization newMeasureCharacterization, NotificationChain msgs) {
		MeasureCharacterization oldMeasureCharacterization = measureCharacterization;
		measureCharacterization = newMeasureCharacterization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, emfmodelPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION, oldMeasureCharacterization, newMeasureCharacterization);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasureCharacterization(MeasureCharacterization newMeasureCharacterization) {
		if (newMeasureCharacterization != measureCharacterization) {
			NotificationChain msgs = null;
			if (measureCharacterization != null)
				msgs = ((InternalEObject)measureCharacterization).eInverseRemove(this, emfmodelPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION, MeasureCharacterization.class, msgs);
			if (newMeasureCharacterization != null)
				msgs = ((InternalEObject)newMeasureCharacterization).eInverseAdd(this, emfmodelPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION, MeasureCharacterization.class, msgs);
			msgs = basicSetMeasureCharacterization(newMeasureCharacterization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, emfmodelPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION, newMeasureCharacterization, newMeasureCharacterization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersistenceKindOptions getPersistencyKind() {
		return persistencyKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistencyKind(PersistenceKindOptions newPersistencyKind) {
		PersistenceKindOptions oldPersistencyKind = persistencyKind;
		persistencyKind = newPersistencyKind == null ? PERSISTENCY_KIND_EDEFAULT : newPersistencyKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, emfmodelPackage.SENSOR_DECLARATION__PERSISTENCY_KIND, oldPersistencyKind, persistencyKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case emfmodelPackage.SENSOR_DECLARATION__EXPERIMENT_SETTING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetExperimentSetting((ExperimentSetting)otherEnd, msgs);
			case emfmodelPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION:
				if (measureCharacterization != null)
					msgs = ((InternalEObject)measureCharacterization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - emfmodelPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION, null, msgs);
				return basicSetMeasureCharacterization((MeasureCharacterization)otherEnd, msgs);
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
			case emfmodelPackage.SENSOR_DECLARATION__EXPERIMENT_SETTING:
				return basicSetExperimentSetting(null, msgs);
			case emfmodelPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION:
				return basicSetMeasureCharacterization(null, msgs);
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
			case emfmodelPackage.SENSOR_DECLARATION__EXPERIMENT_SETTING:
				return eInternalContainer().eInverseRemove(this, emfmodelPackage.EXPERIMENT_SETTING__SENSORS, ExperimentSetting.class, msgs);
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
			case emfmodelPackage.SENSOR_DECLARATION__EXPERIMENT_SETTING:
				return getExperimentSetting();
			case emfmodelPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION:
				return getMeasureCharacterization();
			case emfmodelPackage.SENSOR_DECLARATION__PERSISTENCY_KIND:
				return getPersistencyKind();
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
			case emfmodelPackage.SENSOR_DECLARATION__EXPERIMENT_SETTING:
				setExperimentSetting((ExperimentSetting)newValue);
				return;
			case emfmodelPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION:
				setMeasureCharacterization((MeasureCharacterization)newValue);
				return;
			case emfmodelPackage.SENSOR_DECLARATION__PERSISTENCY_KIND:
				setPersistencyKind((PersistenceKindOptions)newValue);
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
			case emfmodelPackage.SENSOR_DECLARATION__EXPERIMENT_SETTING:
				setExperimentSetting((ExperimentSetting)null);
				return;
			case emfmodelPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION:
				setMeasureCharacterization((MeasureCharacterization)null);
				return;
			case emfmodelPackage.SENSOR_DECLARATION__PERSISTENCY_KIND:
				setPersistencyKind(PERSISTENCY_KIND_EDEFAULT);
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
			case emfmodelPackage.SENSOR_DECLARATION__EXPERIMENT_SETTING:
				return getExperimentSetting() != null;
			case emfmodelPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION:
				return measureCharacterization != null;
			case emfmodelPackage.SENSOR_DECLARATION__PERSISTENCY_KIND:
				return persistencyKind != PERSISTENCY_KIND_EDEFAULT;
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
		result.append(" (persistencyKind: ");
		result.append(persistencyKind);
		result.append(')');
		return result.toString();
	}

} //SensorDeclarationImpl
