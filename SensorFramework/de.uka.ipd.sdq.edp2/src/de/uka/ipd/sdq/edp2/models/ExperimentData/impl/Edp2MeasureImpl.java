/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edp2 Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.Edp2MeasureImpl#getExperimentGroup <em>Experiment Group</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.Edp2MeasureImpl#getExperimentSettings <em>Experiment Settings</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.Edp2MeasureImpl#getMeasuredObject <em>Measured Object</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.Edp2MeasureImpl#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Edp2MeasureImpl extends IdentifiableImpl implements Edp2Measure {
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
	protected MetricDescription metric;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected Edp2MeasureImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.EDP2_MEASURE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExperimentGroup getExperimentGroup() {
        if (eContainerFeatureID() != ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_GROUP) return null;
        return (ExperimentGroup)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetExperimentGroup(ExperimentGroup newExperimentGroup, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newExperimentGroup, ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_GROUP, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExperimentGroup(ExperimentGroup newExperimentGroup) {
        if (newExperimentGroup != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_GROUP && newExperimentGroup != null)) {
            if (EcoreUtil.isAncestor(this, newExperimentGroup))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newExperimentGroup != null)
                msgs = ((InternalEObject)newExperimentGroup).eInverseAdd(this, ExperimentDataPackage.EXPERIMENT_GROUP__MEASURE, ExperimentGroup.class, msgs);
            msgs = basicSetExperimentGroup(newExperimentGroup, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_GROUP, newExperimentGroup, newExperimentGroup));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ExperimentSetting> getExperimentSettings() {
        if (experimentSettings == null) {
            experimentSettings = new EObjectWithInverseResolvingEList.ManyInverse<ExperimentSetting>(ExperimentSetting.class, this, ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS, ExperimentDataPackage.EXPERIMENT_SETTING__MEASURE);
        }
        return experimentSettings;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.EDP2_MEASURE__MEASURED_OBJECT, oldMeasuredObject, measuredObject));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MetricDescription getMetric() {
        if (metric != null && metric.eIsProxy()) {
            InternalEObject oldMetric = (InternalEObject)metric;
            metric = (MetricDescription)eResolveProxy(oldMetric);
            if (metric != oldMetric) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.EDP2_MEASURE__METRIC, oldMetric, metric));
            }
        }
        return metric;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MetricDescription basicGetMetric() {
        return metric;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMetric(MetricDescription newMetric) {
        MetricDescription oldMetric = metric;
        metric = newMetric;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.EDP2_MEASURE__METRIC, oldMetric, metric));
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
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetExperimentGroup((ExperimentGroup)otherEnd, msgs);
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS:
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
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
                return basicSetExperimentGroup(null, msgs);
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS:
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
        switch (eContainerFeatureID()) {
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.EXPERIMENT_GROUP__MEASURE, ExperimentGroup.class, msgs);
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
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
                return getExperimentGroup();
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS:
                return getExperimentSettings();
            case ExperimentDataPackage.EDP2_MEASURE__MEASURED_OBJECT:
                return getMeasuredObject();
            case ExperimentDataPackage.EDP2_MEASURE__METRIC:
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
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
                setExperimentGroup((ExperimentGroup)newValue);
                return;
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS:
                getExperimentSettings().clear();
                getExperimentSettings().addAll((Collection<? extends ExperimentSetting>)newValue);
                return;
            case ExperimentDataPackage.EDP2_MEASURE__MEASURED_OBJECT:
                setMeasuredObject((String)newValue);
                return;
            case ExperimentDataPackage.EDP2_MEASURE__METRIC:
                setMetric((MetricDescription)newValue);
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
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
                setExperimentGroup((ExperimentGroup)null);
                return;
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS:
                getExperimentSettings().clear();
                return;
            case ExperimentDataPackage.EDP2_MEASURE__MEASURED_OBJECT:
                setMeasuredObject(MEASURED_OBJECT_EDEFAULT);
                return;
            case ExperimentDataPackage.EDP2_MEASURE__METRIC:
                setMetric((MetricDescription)null);
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
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
                return getExperimentGroup() != null;
            case ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS:
                return experimentSettings != null && !experimentSettings.isEmpty();
            case ExperimentDataPackage.EDP2_MEASURE__MEASURED_OBJECT:
                return MEASURED_OBJECT_EDEFAULT == null ? measuredObject != null : !MEASURED_OBJECT_EDEFAULT.equals(measuredObject);
            case ExperimentDataPackage.EDP2_MEASURE__METRIC:
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
        result.append(" (measuredObject: ");
        result.append(measuredObject);
        result.append(')');
        return result.toString();
    }

} //Edp2MeasureImpl
