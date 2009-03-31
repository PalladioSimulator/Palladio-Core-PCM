/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.emfmodel.Measure;
import de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasureImpl#getExperimentSetting <em>Experiment Setting</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasureImpl#getExperimentSettings <em>Experiment Settings</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasureImpl#getPersistencyKind <em>Persistency Kind</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasureImpl#getMeasuredObject <em>Measured Object</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasureImpl#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MeasureImpl extends EObjectImpl implements Measure {
	/**
	 * The cached value of the '{@link #getExperimentSettings() <em>Experiment Settings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExperimentSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<ExperimentSetting> experimentSettings;

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
	 * The default value of the '{@link #getMeasuredObject() <em>Measured Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasuredObject()
	 * @generated
	 * @ordered
	 */
	protected static final String MEASURED_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeasuredObject() <em>Measured Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasuredObject()
	 * @generated
	 * @ordered
	 */
	protected String measuredObject = MEASURED_OBJECT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetric() <em>Metric</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetric()
	 * @generated
	 * @ordered
	 */
	protected BaseMetricDescription metric;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.MEASURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentGroup getExperimentSetting() {
		if (eContainerFeatureID != EmfmodelPackage.MEASURE__EXPERIMENT_SETTING) return null;
		return (ExperimentGroup)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExperimentSetting(ExperimentGroup newExperimentSetting, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExperimentSetting, EmfmodelPackage.MEASURE__EXPERIMENT_SETTING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExperimentSetting(ExperimentGroup newExperimentSetting) {
		if (newExperimentSetting != eInternalContainer() || (eContainerFeatureID != EmfmodelPackage.MEASURE__EXPERIMENT_SETTING && newExperimentSetting != null)) {
			if (EcoreUtil.isAncestor(this, newExperimentSetting))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExperimentSetting != null)
				msgs = ((InternalEObject)newExperimentSetting).eInverseAdd(this, EmfmodelPackage.EXPERIMENT_GROUP__MEASURE, ExperimentGroup.class, msgs);
			msgs = basicSetExperimentSetting(newExperimentSetting, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.MEASURE__EXPERIMENT_SETTING, newExperimentSetting, newExperimentSetting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExperimentSetting> getExperimentSettings() {
		if (experimentSettings == null) {
			experimentSettings = new EObjectWithInverseResolvingEList.ManyInverse<ExperimentSetting>(ExperimentSetting.class, this, EmfmodelPackage.MEASURE__EXPERIMENT_SETTINGS, EmfmodelPackage.EXPERIMENT_SETTING__MEASURE);
		}
		return experimentSettings;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.MEASURE__PERSISTENCY_KIND, oldPersistencyKind, persistencyKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasuredObject() {
		return measuredObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasuredObject(String newMeasuredObject) {
		String oldMeasuredObject = measuredObject;
		measuredObject = newMeasuredObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.MEASURE__MEASURED_OBJECT, oldMeasuredObject, measuredObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseMetricDescription getMetric() {
		if (metric != null && metric.eIsProxy()) {
			InternalEObject oldMetric = (InternalEObject)metric;
			metric = (BaseMetricDescription)eResolveProxy(oldMetric);
			if (metric != oldMetric) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfmodelPackage.MEASURE__METRIC, oldMetric, metric));
			}
		}
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseMetricDescription basicGetMetric() {
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetric(BaseMetricDescription newMetric) {
		BaseMetricDescription oldMetric = metric;
		metric = newMetric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.MEASURE__METRIC, oldMetric, metric));
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
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetExperimentSetting((ExperimentGroup)otherEnd, msgs);
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExperimentSettings()).basicAdd(otherEnd, msgs);
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
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTING:
				return basicSetExperimentSetting(null, msgs);
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTINGS:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTING:
				return eInternalContainer().eInverseRemove(this, EmfmodelPackage.EXPERIMENT_GROUP__MEASURE, ExperimentGroup.class, msgs);
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
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTING:
				return getExperimentSetting();
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTINGS:
				return getExperimentSettings();
			case EmfmodelPackage.MEASURE__PERSISTENCY_KIND:
				return getPersistencyKind();
			case EmfmodelPackage.MEASURE__MEASURED_OBJECT:
				return getMeasuredObject();
			case EmfmodelPackage.MEASURE__METRIC:
				if (resolve) return getMetric();
				return basicGetMetric();
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
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTING:
				setExperimentSetting((ExperimentGroup)newValue);
				return;
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTINGS:
				getExperimentSettings().clear();
				getExperimentSettings().addAll((Collection<? extends ExperimentSetting>)newValue);
				return;
			case EmfmodelPackage.MEASURE__PERSISTENCY_KIND:
				setPersistencyKind((PersistenceKindOptions)newValue);
				return;
			case EmfmodelPackage.MEASURE__MEASURED_OBJECT:
				setMeasuredObject((String)newValue);
				return;
			case EmfmodelPackage.MEASURE__METRIC:
				setMetric((BaseMetricDescription)newValue);
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
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTING:
				setExperimentSetting((ExperimentGroup)null);
				return;
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTINGS:
				getExperimentSettings().clear();
				return;
			case EmfmodelPackage.MEASURE__PERSISTENCY_KIND:
				setPersistencyKind(PERSISTENCY_KIND_EDEFAULT);
				return;
			case EmfmodelPackage.MEASURE__MEASURED_OBJECT:
				setMeasuredObject(MEASURED_OBJECT_EDEFAULT);
				return;
			case EmfmodelPackage.MEASURE__METRIC:
				setMetric((BaseMetricDescription)null);
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
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTING:
				return getExperimentSetting() != null;
			case EmfmodelPackage.MEASURE__EXPERIMENT_SETTINGS:
				return experimentSettings != null && !experimentSettings.isEmpty();
			case EmfmodelPackage.MEASURE__PERSISTENCY_KIND:
				return persistencyKind != PERSISTENCY_KIND_EDEFAULT;
			case EmfmodelPackage.MEASURE__MEASURED_OBJECT:
				return MEASURED_OBJECT_EDEFAULT == null ? measuredObject != null : !MEASURED_OBJECT_EDEFAULT.equals(measuredObject);
			case EmfmodelPackage.MEASURE__METRIC:
				return metric != null;
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
		result.append(", measuredObject: ");
		result.append(measuredObject);
		result.append(')');
		return result.toString();
	}

} //MeasureImpl
