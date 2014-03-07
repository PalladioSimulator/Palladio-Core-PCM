/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import java.util.Collection;
import java.util.Date;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Propertyable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Experiment Run</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentRunImpl#getAdditionalInformation <em>Additional Information</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentRunImpl#getMeasurements <em>Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentRunImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentRunImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentRunImpl#getExperimentSetting <em>Experiment Setting</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExperimentRunImpl extends IdentifiableImpl implements ExperimentRun {
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
     * The cached value of the '{@link #getMeasurements() <em>Measurements</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMeasurements()
     * @generated
     * @ordered
     */
	protected EList<Measurements> measurements;

	/**
     * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStartTime()
     * @generated
     * @ordered
     */
	protected static final Date START_TIME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStartTime()
     * @generated
     * @ordered
     */
	protected Date startTime = START_TIME_EDEFAULT;

	/**
     * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDuration()
     * @generated
     * @ordered
     */
	protected static final Measure DURATION_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDuration()
     * @generated
     * @ordered
     */
	protected Measure duration = DURATION_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ExperimentRunImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.EXPERIMENT_RUN;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EMap<String, Object> getAdditionalInformation() {
        if (additionalInformation == null) {
            additionalInformation = new EcoreEMap<String,Object>(ExperimentDataPackage.Literals.ESTRINGTO_EOBJECT_MAP_ENTRY, EStringtoEObjectMapEntryImpl.class, this, ExperimentDataPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION);
        }
        return additionalInformation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Measurements> getMeasurements() {
        if (measurements == null) {
            measurements = new EObjectContainmentWithInverseEList<Measurements>(Measurements.class, this, ExperimentDataPackage.EXPERIMENT_RUN__MEASUREMENTS, ExperimentDataPackage.MEASUREMENTS__EXPERIMENT_RUN);
        }
        return measurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Date getStartTime() {
        return startTime;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setStartTime(Date newStartTime) {
        Date oldStartTime = startTime;
        startTime = newStartTime;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.EXPERIMENT_RUN__START_TIME, oldStartTime, startTime));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measure getDuration() {
        return duration;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDuration(Measure newDuration) {
        Measure oldDuration = duration;
        duration = newDuration;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.EXPERIMENT_RUN__DURATION, oldDuration, duration));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExperimentSetting getExperimentSetting() {
        if (eContainerFeatureID() != ExperimentDataPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING) return null;
        return (ExperimentSetting)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetExperimentSetting(ExperimentSetting newExperimentSetting, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newExperimentSetting, ExperimentDataPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExperimentSetting(ExperimentSetting newExperimentSetting) {
        if (newExperimentSetting != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING && newExperimentSetting != null)) {
            if (EcoreUtil.isAncestor(this, newExperimentSetting))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newExperimentSetting != null)
                msgs = ((InternalEObject)newExperimentSetting).eInverseAdd(this, ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS, ExperimentSetting.class, msgs);
            msgs = basicSetExperimentSetting(newExperimentSetting, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING, newExperimentSetting, newExperimentSetting));
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
            case ExperimentDataPackage.EXPERIMENT_RUN__MEASUREMENTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMeasurements()).basicAdd(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetExperimentSetting((ExperimentSetting)otherEnd, msgs);
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
            case ExperimentDataPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION:
                return ((InternalEList<?>)getAdditionalInformation()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_RUN__MEASUREMENTS:
                return ((InternalEList<?>)getMeasurements()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
                return basicSetExperimentSetting(null, msgs);
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
            case ExperimentDataPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS, ExperimentSetting.class, msgs);
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
            case ExperimentDataPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION:
                if (coreType) return getAdditionalInformation();
                else return getAdditionalInformation().map();
            case ExperimentDataPackage.EXPERIMENT_RUN__MEASUREMENTS:
                return getMeasurements();
            case ExperimentDataPackage.EXPERIMENT_RUN__START_TIME:
                return getStartTime();
            case ExperimentDataPackage.EXPERIMENT_RUN__DURATION:
                return getDuration();
            case ExperimentDataPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
                return getExperimentSetting();
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
            case ExperimentDataPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION:
                ((EStructuralFeature.Setting)getAdditionalInformation()).set(newValue);
                return;
            case ExperimentDataPackage.EXPERIMENT_RUN__MEASUREMENTS:
                getMeasurements().clear();
                getMeasurements().addAll((Collection<? extends Measurements>)newValue);
                return;
            case ExperimentDataPackage.EXPERIMENT_RUN__START_TIME:
                setStartTime((Date)newValue);
                return;
            case ExperimentDataPackage.EXPERIMENT_RUN__DURATION:
                setDuration((Measure)newValue);
                return;
            case ExperimentDataPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
                setExperimentSetting((ExperimentSetting)newValue);
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
            case ExperimentDataPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION:
                getAdditionalInformation().clear();
                return;
            case ExperimentDataPackage.EXPERIMENT_RUN__MEASUREMENTS:
                getMeasurements().clear();
                return;
            case ExperimentDataPackage.EXPERIMENT_RUN__START_TIME:
                setStartTime(START_TIME_EDEFAULT);
                return;
            case ExperimentDataPackage.EXPERIMENT_RUN__DURATION:
                setDuration(DURATION_EDEFAULT);
                return;
            case ExperimentDataPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
                setExperimentSetting((ExperimentSetting)null);
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
            case ExperimentDataPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION:
                return additionalInformation != null && !additionalInformation.isEmpty();
            case ExperimentDataPackage.EXPERIMENT_RUN__MEASUREMENTS:
                return measurements != null && !measurements.isEmpty();
            case ExperimentDataPackage.EXPERIMENT_RUN__START_TIME:
                return START_TIME_EDEFAULT == null ? startTime != null : !START_TIME_EDEFAULT.equals(startTime);
            case ExperimentDataPackage.EXPERIMENT_RUN__DURATION:
                return DURATION_EDEFAULT == null ? duration != null : !DURATION_EDEFAULT.equals(duration);
            case ExperimentDataPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
                return getExperimentSetting() != null;
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
                case ExperimentDataPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION: return ExperimentDataPackage.PROPERTYABLE__ADDITIONAL_INFORMATION;
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
                case ExperimentDataPackage.PROPERTYABLE__ADDITIONAL_INFORMATION: return ExperimentDataPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (startTime: ");
        result.append(startTime);
        result.append(", duration: ");
        result.append(duration);
        result.append(')');
        return result.toString();
    }

} //ExperimentRunImpl
