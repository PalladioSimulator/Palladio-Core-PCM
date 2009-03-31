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
import de.uka.ipd.sdq.edp2.models.emfmodel.Measurement;
import de.uka.ipd.sdq.edp2.models.emfmodel.Propertyable;

import de.uka.ipd.sdq.edp2.models.emfmodel.util.EmfmodelValidator;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Experiment Run</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentRunImpl#getAdditionalInformation <em>Additional Information</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentRunImpl#getCollectedData <em>Collected Data</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentRunImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentRunImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentRunImpl#getExperimentSetting <em>Experiment Setting</em>}</li>
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
	 * The cached value of the '{@link #getCollectedData() <em>Collected Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectedData()
	 * @generated
	 * @ordered
	 */
	protected EList<Measurement> collectedData;

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
		return EmfmodelPackage.Literals.EXPERIMENT_RUN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Object> getAdditionalInformation() {
		if (additionalInformation == null) {
			additionalInformation = new EcoreEMap<String,Object>(EmfmodelPackage.Literals.ESTRINGTO_EOBJECT_MAP_ENTRY, EStringtoEObjectMapEntryImpl.class, this, EmfmodelPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION);
		}
		return additionalInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Measurement> getCollectedData() {
		if (collectedData == null) {
			collectedData = new EObjectContainmentWithInverseEList<Measurement>(Measurement.class, this, EmfmodelPackage.EXPERIMENT_RUN__COLLECTED_DATA, EmfmodelPackage.MEASUREMENT__EXPERIMENT_RUN);
		}
		return collectedData;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.EXPERIMENT_RUN__START_TIME, oldStartTime, startTime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.EXPERIMENT_RUN__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentSetting getExperimentSetting() {
		if (eContainerFeatureID != EmfmodelPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING) return null;
		return (ExperimentSetting)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExperimentSetting(ExperimentSetting newExperimentSetting, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExperimentSetting, EmfmodelPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExperimentSetting(ExperimentSetting newExperimentSetting) {
		if (newExperimentSetting != eInternalContainer() || (eContainerFeatureID != EmfmodelPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING && newExperimentSetting != null)) {
			if (EcoreUtil.isAncestor(this, newExperimentSetting))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExperimentSetting != null)
				msgs = ((InternalEObject)newExperimentSetting).eInverseAdd(this, EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS, ExperimentSetting.class, msgs);
			msgs = basicSetExperimentSetting(newExperimentSetting, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING, newExperimentSetting, newExperimentSetting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ExactlyOneDataCollectionPerSensor(DiagnosticChain diagnostics, Map context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 EmfmodelValidator.DIAGNOSTIC_SOURCE,
						 EmfmodelValidator.EXPERIMENT_RUN__EXACTLY_ONE_DATA_COLLECTION_PER_SENSOR,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ExactlyOneDataCollectionPerSensor", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
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
			case EmfmodelPackage.EXPERIMENT_RUN__COLLECTED_DATA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCollectedData()).basicAdd(otherEnd, msgs);
			case EmfmodelPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
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
			case EmfmodelPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION:
				return ((InternalEList<?>)getAdditionalInformation()).basicRemove(otherEnd, msgs);
			case EmfmodelPackage.EXPERIMENT_RUN__COLLECTED_DATA:
				return ((InternalEList<?>)getCollectedData()).basicRemove(otherEnd, msgs);
			case EmfmodelPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
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
		switch (eContainerFeatureID) {
			case EmfmodelPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
				return eInternalContainer().eInverseRemove(this, EmfmodelPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS, ExperimentSetting.class, msgs);
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
			case EmfmodelPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION:
				if (coreType) return getAdditionalInformation();
				else return getAdditionalInformation().map();
			case EmfmodelPackage.EXPERIMENT_RUN__COLLECTED_DATA:
				return getCollectedData();
			case EmfmodelPackage.EXPERIMENT_RUN__START_TIME:
				return getStartTime();
			case EmfmodelPackage.EXPERIMENT_RUN__DURATION:
				return getDuration();
			case EmfmodelPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
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
			case EmfmodelPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION:
				((EStructuralFeature.Setting)getAdditionalInformation()).set(newValue);
				return;
			case EmfmodelPackage.EXPERIMENT_RUN__COLLECTED_DATA:
				getCollectedData().clear();
				getCollectedData().addAll((Collection<? extends Measurement>)newValue);
				return;
			case EmfmodelPackage.EXPERIMENT_RUN__START_TIME:
				setStartTime((Date)newValue);
				return;
			case EmfmodelPackage.EXPERIMENT_RUN__DURATION:
				setDuration((Measure)newValue);
				return;
			case EmfmodelPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
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
			case EmfmodelPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION:
				getAdditionalInformation().clear();
				return;
			case EmfmodelPackage.EXPERIMENT_RUN__COLLECTED_DATA:
				getCollectedData().clear();
				return;
			case EmfmodelPackage.EXPERIMENT_RUN__START_TIME:
				setStartTime(START_TIME_EDEFAULT);
				return;
			case EmfmodelPackage.EXPERIMENT_RUN__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case EmfmodelPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
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
			case EmfmodelPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION:
				return additionalInformation != null && !additionalInformation.isEmpty();
			case EmfmodelPackage.EXPERIMENT_RUN__COLLECTED_DATA:
				return collectedData != null && !collectedData.isEmpty();
			case EmfmodelPackage.EXPERIMENT_RUN__START_TIME:
				return START_TIME_EDEFAULT == null ? startTime != null : !START_TIME_EDEFAULT.equals(startTime);
			case EmfmodelPackage.EXPERIMENT_RUN__DURATION:
				return DURATION_EDEFAULT == null ? duration != null : !DURATION_EDEFAULT.equals(duration);
			case EmfmodelPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING:
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
				case EmfmodelPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION: return EmfmodelPackage.PROPERTYABLE__ADDITIONAL_INFORMATION;
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
				case EmfmodelPackage.PROPERTYABLE__ADDITIONAL_INFORMATION: return EmfmodelPackage.EXPERIMENT_RUN__ADDITIONAL_INFORMATION;
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
