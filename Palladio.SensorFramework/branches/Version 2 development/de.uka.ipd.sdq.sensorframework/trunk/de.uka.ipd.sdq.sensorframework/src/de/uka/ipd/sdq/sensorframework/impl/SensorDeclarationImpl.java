/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.ExperimentSetting;
import de.uka.ipd.sdq.sensorframework.MeasureCharacterization;
import de.uka.ipd.sdq.sensorframework.PersistenceKindOptions;
import de.uka.ipd.sdq.sensorframework.SensorDeclaration;
import de.uka.ipd.sdq.sensorframework.sensorframeworkPackage;

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
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.SensorDeclarationImpl#getOwningExperiment <em>Owning Experiment</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.SensorDeclarationImpl#getMeasureCharacterization <em>Measure Characterization</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.SensorDeclarationImpl#getPersistencyKind <em>Persistency Kind</em>}</li>
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
		return sensorframeworkPackage.Literals.SENSOR_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentSetting getOwningExperiment() {
		if (eContainerFeatureID != sensorframeworkPackage.SENSOR_DECLARATION__OWNING_EXPERIMENT) return null;
		return (ExperimentSetting)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningExperiment(ExperimentSetting newOwningExperiment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningExperiment, sensorframeworkPackage.SENSOR_DECLARATION__OWNING_EXPERIMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningExperiment(ExperimentSetting newOwningExperiment) {
		if (newOwningExperiment != eInternalContainer() || (eContainerFeatureID != sensorframeworkPackage.SENSOR_DECLARATION__OWNING_EXPERIMENT && newOwningExperiment != null)) {
			if (EcoreUtil.isAncestor(this, newOwningExperiment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningExperiment != null)
				msgs = ((InternalEObject)newOwningExperiment).eInverseAdd(this, sensorframeworkPackage.EXPERIMENT_SETTING__SENSORS, ExperimentSetting.class, msgs);
			msgs = basicSetOwningExperiment(newOwningExperiment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.SENSOR_DECLARATION__OWNING_EXPERIMENT, newOwningExperiment, newOwningExperiment));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION, oldMeasureCharacterization, newMeasureCharacterization);
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
				msgs = ((InternalEObject)measureCharacterization).eInverseRemove(this, sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION, MeasureCharacterization.class, msgs);
			if (newMeasureCharacterization != null)
				msgs = ((InternalEObject)newMeasureCharacterization).eInverseAdd(this, sensorframeworkPackage.MEASURE_CHARACTERIZATION__SENSOR_DECLARATION, MeasureCharacterization.class, msgs);
			msgs = basicSetMeasureCharacterization(newMeasureCharacterization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION, newMeasureCharacterization, newMeasureCharacterization));
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
			eNotify(new ENotificationImpl(this, Notification.SET, sensorframeworkPackage.SENSOR_DECLARATION__PERSISTENCY_KIND, oldPersistencyKind, persistencyKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case sensorframeworkPackage.SENSOR_DECLARATION__OWNING_EXPERIMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningExperiment((ExperimentSetting)otherEnd, msgs);
			case sensorframeworkPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION:
				if (measureCharacterization != null)
					msgs = ((InternalEObject)measureCharacterization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - sensorframeworkPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION, null, msgs);
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
			case sensorframeworkPackage.SENSOR_DECLARATION__OWNING_EXPERIMENT:
				return basicSetOwningExperiment(null, msgs);
			case sensorframeworkPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION:
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
			case sensorframeworkPackage.SENSOR_DECLARATION__OWNING_EXPERIMENT:
				return eInternalContainer().eInverseRemove(this, sensorframeworkPackage.EXPERIMENT_SETTING__SENSORS, ExperimentSetting.class, msgs);
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
			case sensorframeworkPackage.SENSOR_DECLARATION__OWNING_EXPERIMENT:
				return getOwningExperiment();
			case sensorframeworkPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION:
				return getMeasureCharacterization();
			case sensorframeworkPackage.SENSOR_DECLARATION__PERSISTENCY_KIND:
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
			case sensorframeworkPackage.SENSOR_DECLARATION__OWNING_EXPERIMENT:
				setOwningExperiment((ExperimentSetting)newValue);
				return;
			case sensorframeworkPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION:
				setMeasureCharacterization((MeasureCharacterization)newValue);
				return;
			case sensorframeworkPackage.SENSOR_DECLARATION__PERSISTENCY_KIND:
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
			case sensorframeworkPackage.SENSOR_DECLARATION__OWNING_EXPERIMENT:
				setOwningExperiment((ExperimentSetting)null);
				return;
			case sensorframeworkPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION:
				setMeasureCharacterization((MeasureCharacterization)null);
				return;
			case sensorframeworkPackage.SENSOR_DECLARATION__PERSISTENCY_KIND:
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
			case sensorframeworkPackage.SENSOR_DECLARATION__OWNING_EXPERIMENT:
				return getOwningExperiment() != null;
			case sensorframeworkPackage.SENSOR_DECLARATION__MEASURE_CHARACTERIZATION:
				return measureCharacterization != null;
			case sensorframeworkPackage.SENSOR_DECLARATION__PERSISTENCY_KIND:
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
