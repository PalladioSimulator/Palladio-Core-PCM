/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.emfmodel.Measure;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Experiment Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentSettingImpl#getExperimentName <em>Experiment Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentSettingImpl#getExperimentRuns <em>Experiment Runs</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentSettingImpl#getMeasure <em>Measure</em>}</li>
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
	 * The cached value of the '{@link #getMeasure() <em>Measure</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected EList<Measure> measure;

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
		return EmfmodelPackage.Literals.EXPERIMENT_SETTING;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_NAME, oldExperimentName, experimentName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExperimentRun> getExperimentRuns() {
		if (experimentRuns == null) {
			experimentRuns = new EObjectContainmentWithInverseEList<ExperimentRun>(ExperimentRun.class, this, EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS, EmfmodelPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING);
		}
		return experimentRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Measure> getMeasure() {
		if (measure == null) {
			measure = new EObjectWithInverseResolvingEList.ManyInverse<Measure>(Measure.class, this, EmfmodelPackage.EXPERIMENT_SETTING__MEASURE, EmfmodelPackage.MEASURE__EXPERIMENT_SETTINGS);
		}
		return measure;
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
			case EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExperimentRuns()).basicAdd(otherEnd, msgs);
			case EmfmodelPackage.EXPERIMENT_SETTING__MEASURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMeasure()).basicAdd(otherEnd, msgs);
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
			case EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
				return ((InternalEList<?>)getExperimentRuns()).basicRemove(otherEnd, msgs);
			case EmfmodelPackage.EXPERIMENT_SETTING__MEASURE:
				return ((InternalEList<?>)getMeasure()).basicRemove(otherEnd, msgs);
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
			case EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_NAME:
				return getExperimentName();
			case EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
				return getExperimentRuns();
			case EmfmodelPackage.EXPERIMENT_SETTING__MEASURE:
				return getMeasure();
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
			case EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_NAME:
				setExperimentName((String)newValue);
				return;
			case EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
				getExperimentRuns().clear();
				getExperimentRuns().addAll((Collection<? extends ExperimentRun>)newValue);
				return;
			case EmfmodelPackage.EXPERIMENT_SETTING__MEASURE:
				getMeasure().clear();
				getMeasure().addAll((Collection<? extends Measure>)newValue);
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
			case EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_NAME:
				setExperimentName(EXPERIMENT_NAME_EDEFAULT);
				return;
			case EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
				getExperimentRuns().clear();
				return;
			case EmfmodelPackage.EXPERIMENT_SETTING__MEASURE:
				getMeasure().clear();
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
			case EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_NAME:
				return EXPERIMENT_NAME_EDEFAULT == null ? experimentName != null : !EXPERIMENT_NAME_EDEFAULT.equals(experimentName);
			case EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
				return experimentRuns != null && !experimentRuns.isEmpty();
			case EmfmodelPackage.EXPERIMENT_SETTING__MEASURE:
				return measure != null && !measure.isEmpty();
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
