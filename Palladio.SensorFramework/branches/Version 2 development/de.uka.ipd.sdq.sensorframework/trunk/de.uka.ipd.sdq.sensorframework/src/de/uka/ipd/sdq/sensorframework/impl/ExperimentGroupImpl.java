/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.ExperimentGroup;
import de.uka.ipd.sdq.sensorframework.ExperimentSetting;
import de.uka.ipd.sdq.sensorframework.Propertyable;
import de.uka.ipd.sdq.sensorframework.SensorframeworkPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Experiment Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.ExperimentGroupImpl#getAdditionalInformation <em>Additional Information</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.impl.ExperimentGroupImpl#getExperimentSettings <em>Experiment Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExperimentGroupImpl extends IdentifiableImpl implements ExperimentGroup {
	/**
	 * The cached value of the '{@link #getAdditionalInformation() <em>Additional Information</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalInformation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Object> additionalInformation;

	/**
	 * The cached value of the '{@link #getExperimentSettings() <em>Experiment Settings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExperimentSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<ExperimentSetting> experimentSettings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExperimentGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensorframeworkPackage.Literals.EXPERIMENT_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Object> getAdditionalInformation() {
		if (additionalInformation == null) {
			additionalInformation = new EcoreEMap<String,Object>(SensorframeworkPackage.Literals.ESTRINGTO_EOBJECT_MAP_ENTRY, EStringtoEObjectMapEntryImpl.class, this, SensorframeworkPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION);
		}
		return additionalInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExperimentSetting> getExperimentSettings() {
		if (experimentSettings == null) {
			experimentSettings = new EObjectContainmentEList<ExperimentSetting>(ExperimentSetting.class, this, SensorframeworkPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS);
		}
		return experimentSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SensorframeworkPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
				return ((InternalEList<?>)getAdditionalInformation()).basicRemove(otherEnd, msgs);
			case SensorframeworkPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
				return ((InternalEList<?>)getExperimentSettings()).basicRemove(otherEnd, msgs);
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
			case SensorframeworkPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
				if (coreType) return getAdditionalInformation();
				else return getAdditionalInformation().map();
			case SensorframeworkPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
				return getExperimentSettings();
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
			case SensorframeworkPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
				((EStructuralFeature.Setting)getAdditionalInformation()).set(newValue);
				return;
			case SensorframeworkPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
				getExperimentSettings().clear();
				getExperimentSettings().addAll((Collection<? extends ExperimentSetting>)newValue);
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
			case SensorframeworkPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
				getAdditionalInformation().clear();
				return;
			case SensorframeworkPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
				getExperimentSettings().clear();
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
			case SensorframeworkPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
				return additionalInformation != null && !additionalInformation.isEmpty();
			case SensorframeworkPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
				return experimentSettings != null && !experimentSettings.isEmpty();
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
		if (baseClass == Propertyable.class) {
			switch (derivedFeatureID) {
				case SensorframeworkPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION: return SensorframeworkPackage.PROPERTYABLE__ADDITIONAL_INFORMATION;
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
		if (baseClass == Propertyable.class) {
			switch (baseFeatureID) {
				case SensorframeworkPackage.PROPERTYABLE__ADDITIONAL_INFORMATION: return SensorframeworkPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ExperimentGroupImpl
