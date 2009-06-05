/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.emfmodel.Measure;
import de.uka.ipd.sdq.edp2.models.emfmodel.Measurement;
import de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange;

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
 * An implementation of the model object '<em><b>Measurement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasurementImpl#getMeasure <em>Measure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasurementImpl#getExperimentRun <em>Experiment Run</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.MeasurementImpl#getMeasurementRange <em>Measurement Range</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeasurementImpl extends PropertyableImpl implements Measurement {
	/**
	 * The cached value of the '{@link #getMeasure() <em>Measure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected Measure measure;

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
	protected MeasurementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.MEASUREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure getMeasure() {
		if (measure != null && measure.eIsProxy()) {
			InternalEObject oldMeasure = (InternalEObject)measure;
			measure = (Measure)eResolveProxy(oldMeasure);
			if (measure != oldMeasure) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfmodelPackage.MEASUREMENT__MEASURE, oldMeasure, measure));
			}
		}
		return measure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure basicGetMeasure() {
		return measure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasure(Measure newMeasure) {
		Measure oldMeasure = measure;
		measure = newMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.MEASUREMENT__MEASURE, oldMeasure, measure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentRun getExperimentRun() {
		if (eContainerFeatureID != EmfmodelPackage.MEASUREMENT__EXPERIMENT_RUN) return null;
		return (ExperimentRun)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExperimentRun(ExperimentRun newExperimentRun, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExperimentRun, EmfmodelPackage.MEASUREMENT__EXPERIMENT_RUN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExperimentRun(ExperimentRun newExperimentRun) {
		if (newExperimentRun != eInternalContainer() || (eContainerFeatureID != EmfmodelPackage.MEASUREMENT__EXPERIMENT_RUN && newExperimentRun != null)) {
			if (EcoreUtil.isAncestor(this, newExperimentRun))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExperimentRun != null)
				msgs = ((InternalEObject)newExperimentRun).eInverseAdd(this, EmfmodelPackage.EXPERIMENT_RUN__MEASUREMENT, ExperimentRun.class, msgs);
			msgs = basicSetExperimentRun(newExperimentRun, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.MEASUREMENT__EXPERIMENT_RUN, newExperimentRun, newExperimentRun));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MeasurementRange> getMeasurementRange() {
		if (measurementRange == null) {
			measurementRange = new EObjectContainmentWithInverseEList<MeasurementRange>(MeasurementRange.class, this, EmfmodelPackage.MEASUREMENT__MEASUREMENT_RANGE, EmfmodelPackage.MEASUREMENT_RANGE__MEASUREMENT);
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
			case EmfmodelPackage.MEASUREMENT__EXPERIMENT_RUN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetExperimentRun((ExperimentRun)otherEnd, msgs);
			case EmfmodelPackage.MEASUREMENT__MEASUREMENT_RANGE:
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
			case EmfmodelPackage.MEASUREMENT__EXPERIMENT_RUN:
				return basicSetExperimentRun(null, msgs);
			case EmfmodelPackage.MEASUREMENT__MEASUREMENT_RANGE:
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
			case EmfmodelPackage.MEASUREMENT__EXPERIMENT_RUN:
				return eInternalContainer().eInverseRemove(this, EmfmodelPackage.EXPERIMENT_RUN__MEASUREMENT, ExperimentRun.class, msgs);
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
			case EmfmodelPackage.MEASUREMENT__MEASURE:
				if (resolve) return getMeasure();
				return basicGetMeasure();
			case EmfmodelPackage.MEASUREMENT__EXPERIMENT_RUN:
				return getExperimentRun();
			case EmfmodelPackage.MEASUREMENT__MEASUREMENT_RANGE:
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
			case EmfmodelPackage.MEASUREMENT__MEASURE:
				setMeasure((Measure)newValue);
				return;
			case EmfmodelPackage.MEASUREMENT__EXPERIMENT_RUN:
				setExperimentRun((ExperimentRun)newValue);
				return;
			case EmfmodelPackage.MEASUREMENT__MEASUREMENT_RANGE:
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
			case EmfmodelPackage.MEASUREMENT__MEASURE:
				setMeasure((Measure)null);
				return;
			case EmfmodelPackage.MEASUREMENT__EXPERIMENT_RUN:
				setExperimentRun((ExperimentRun)null);
				return;
			case EmfmodelPackage.MEASUREMENT__MEASUREMENT_RANGE:
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
			case EmfmodelPackage.MEASUREMENT__MEASURE:
				return measure != null;
			case EmfmodelPackage.MEASUREMENT__EXPERIMENT_RUN:
				return getExperimentRun() != null;
			case EmfmodelPackage.MEASUREMENT__MEASUREMENT_RANGE:
				return measurementRange != null && !measurementRange.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MeasurementImpl
