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
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Propertyable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.MeasurementsImpl#getAdditionalInformation <em>Additional Information</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.MeasurementsImpl#getMeasure <em>Measure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.MeasurementsImpl#getMeasurementsRanges <em>Measurements Ranges</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.MeasurementsImpl#getExperimentRun <em>Experiment Run</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeasurementsImpl extends IdentifiableImpl implements Measurements {
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
     * The cached value of the '{@link #getMeasure() <em>Measure</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMeasure()
     * @generated
     * @ordered
     */
	protected Edp2Measure measure;

	/**
     * The cached value of the '{@link #getMeasurementsRanges() <em>Measurements Ranges</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMeasurementsRanges()
     * @generated
     * @ordered
     */
	protected EList<MeasurementsRange> measurementsRanges;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected MeasurementsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.MEASUREMENTS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EMap<String, Object> getAdditionalInformation() {
        if (additionalInformation == null) {
            additionalInformation = new EcoreEMap<String,Object>(ExperimentDataPackage.Literals.ESTRINGTO_EOBJECT_MAP_ENTRY, EStringtoEObjectMapEntryImpl.class, this, ExperimentDataPackage.MEASUREMENTS__ADDITIONAL_INFORMATION);
        }
        return additionalInformation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Edp2Measure getMeasure() {
        if (measure != null && measure.eIsProxy()) {
            InternalEObject oldMeasure = (InternalEObject)measure;
            measure = (Edp2Measure)eResolveProxy(oldMeasure);
            if (measure != oldMeasure) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.MEASUREMENTS__MEASURE, oldMeasure, measure));
            }
        }
        return measure;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Edp2Measure basicGetMeasure() {
        return measure;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMeasure(Edp2Measure newMeasure) {
        Edp2Measure oldMeasure = measure;
        measure = newMeasure;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.MEASUREMENTS__MEASURE, oldMeasure, measure));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExperimentRun getExperimentRun() {
        if (eContainerFeatureID() != ExperimentDataPackage.MEASUREMENTS__EXPERIMENT_RUN) return null;
        return (ExperimentRun)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetExperimentRun(ExperimentRun newExperimentRun, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newExperimentRun, ExperimentDataPackage.MEASUREMENTS__EXPERIMENT_RUN, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExperimentRun(ExperimentRun newExperimentRun) {
        if (newExperimentRun != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.MEASUREMENTS__EXPERIMENT_RUN && newExperimentRun != null)) {
            if (EcoreUtil.isAncestor(this, newExperimentRun))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newExperimentRun != null)
                msgs = ((InternalEObject)newExperimentRun).eInverseAdd(this, ExperimentDataPackage.EXPERIMENT_RUN__MEASUREMENTS, ExperimentRun.class, msgs);
            msgs = basicSetExperimentRun(newExperimentRun, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.MEASUREMENTS__EXPERIMENT_RUN, newExperimentRun, newExperimentRun));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MeasurementsRange> getMeasurementsRanges() {
        if (measurementsRanges == null) {
            measurementsRanges = new EObjectContainmentWithInverseEList<MeasurementsRange>(MeasurementsRange.class, this, ExperimentDataPackage.MEASUREMENTS__MEASUREMENTS_RANGES, ExperimentDataPackage.MEASUREMENTS_RANGE__MEASUREMENTS);
        }
        return measurementsRanges;
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
            case ExperimentDataPackage.MEASUREMENTS__MEASUREMENTS_RANGES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMeasurementsRanges()).basicAdd(otherEnd, msgs);
            case ExperimentDataPackage.MEASUREMENTS__EXPERIMENT_RUN:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetExperimentRun((ExperimentRun)otherEnd, msgs);
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
            case ExperimentDataPackage.MEASUREMENTS__ADDITIONAL_INFORMATION:
                return ((InternalEList<?>)getAdditionalInformation()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.MEASUREMENTS__MEASUREMENTS_RANGES:
                return ((InternalEList<?>)getMeasurementsRanges()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.MEASUREMENTS__EXPERIMENT_RUN:
                return basicSetExperimentRun(null, msgs);
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
            case ExperimentDataPackage.MEASUREMENTS__EXPERIMENT_RUN:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.EXPERIMENT_RUN__MEASUREMENTS, ExperimentRun.class, msgs);
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
            case ExperimentDataPackage.MEASUREMENTS__ADDITIONAL_INFORMATION:
                if (coreType) return getAdditionalInformation();
                else return getAdditionalInformation().map();
            case ExperimentDataPackage.MEASUREMENTS__MEASURE:
                if (resolve) return getMeasure();
                return basicGetMeasure();
            case ExperimentDataPackage.MEASUREMENTS__MEASUREMENTS_RANGES:
                return getMeasurementsRanges();
            case ExperimentDataPackage.MEASUREMENTS__EXPERIMENT_RUN:
                return getExperimentRun();
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
            case ExperimentDataPackage.MEASUREMENTS__ADDITIONAL_INFORMATION:
                ((EStructuralFeature.Setting)getAdditionalInformation()).set(newValue);
                return;
            case ExperimentDataPackage.MEASUREMENTS__MEASURE:
                setMeasure((Edp2Measure)newValue);
                return;
            case ExperimentDataPackage.MEASUREMENTS__MEASUREMENTS_RANGES:
                getMeasurementsRanges().clear();
                getMeasurementsRanges().addAll((Collection<? extends MeasurementsRange>)newValue);
                return;
            case ExperimentDataPackage.MEASUREMENTS__EXPERIMENT_RUN:
                setExperimentRun((ExperimentRun)newValue);
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
            case ExperimentDataPackage.MEASUREMENTS__ADDITIONAL_INFORMATION:
                getAdditionalInformation().clear();
                return;
            case ExperimentDataPackage.MEASUREMENTS__MEASURE:
                setMeasure((Edp2Measure)null);
                return;
            case ExperimentDataPackage.MEASUREMENTS__MEASUREMENTS_RANGES:
                getMeasurementsRanges().clear();
                return;
            case ExperimentDataPackage.MEASUREMENTS__EXPERIMENT_RUN:
                setExperimentRun((ExperimentRun)null);
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
            case ExperimentDataPackage.MEASUREMENTS__ADDITIONAL_INFORMATION:
                return additionalInformation != null && !additionalInformation.isEmpty();
            case ExperimentDataPackage.MEASUREMENTS__MEASURE:
                return measure != null;
            case ExperimentDataPackage.MEASUREMENTS__MEASUREMENTS_RANGES:
                return measurementsRanges != null && !measurementsRanges.isEmpty();
            case ExperimentDataPackage.MEASUREMENTS__EXPERIMENT_RUN:
                return getExperimentRun() != null;
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
                case ExperimentDataPackage.MEASUREMENTS__ADDITIONAL_INFORMATION: return ExperimentDataPackage.PROPERTYABLE__ADDITIONAL_INFORMATION;
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
                case ExperimentDataPackage.PROPERTYABLE__ADDITIONAL_INFORMATION: return ExperimentDataPackage.MEASUREMENTS__ADDITIONAL_INFORMATION;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //MeasurementsImpl
