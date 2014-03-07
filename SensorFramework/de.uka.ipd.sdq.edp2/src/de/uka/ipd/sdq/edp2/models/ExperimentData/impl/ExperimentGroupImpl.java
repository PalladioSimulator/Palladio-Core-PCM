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
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Propertyable;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Experiment Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentGroupImpl#getAdditionalInformation <em>Additional Information</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentGroupImpl#getExperimentSettings <em>Experiment Settings</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentGroupImpl#getMeasure <em>Measure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentGroupImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentGroupImpl#getRepository <em>Repository</em>}</li>
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
     * The cached value of the '{@link #getMeasure() <em>Measure</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMeasure()
     * @generated
     * @ordered
     */
	protected EList<Edp2Measure> measure;

	/**
     * The default value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPurpose()
     * @generated
     * @ordered
     */
	protected static final String PURPOSE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPurpose()
     * @generated
     * @ordered
     */
	protected String purpose = PURPOSE_EDEFAULT;

	/**
     * The cached value of the '{@link #getRepository() <em>Repository</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRepository()
     * @generated
     * @ordered
     */
	protected Repository repository;

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
        return ExperimentDataPackage.Literals.EXPERIMENT_GROUP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EMap<String, Object> getAdditionalInformation() {
        if (additionalInformation == null) {
            additionalInformation = new EcoreEMap<String,Object>(ExperimentDataPackage.Literals.ESTRINGTO_EOBJECT_MAP_ENTRY, EStringtoEObjectMapEntryImpl.class, this, ExperimentDataPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION);
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
            experimentSettings = new EObjectContainmentWithInverseEList<ExperimentSetting>(ExperimentSetting.class, this, ExperimentDataPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS, ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_GROUP);
        }
        return experimentSettings;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Repository getRepository() {
        if (repository != null && repository.eIsProxy()) {
            InternalEObject oldRepository = (InternalEObject)repository;
            repository = (Repository)eResolveProxy(oldRepository);
            if (repository != oldRepository) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.EXPERIMENT_GROUP__REPOSITORY, oldRepository, repository));
            }
        }
        return repository;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Repository basicGetRepository() {
        return repository;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRepository(Repository newRepository, NotificationChain msgs) {
        Repository oldRepository = repository;
        repository = newRepository;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.EXPERIMENT_GROUP__REPOSITORY, oldRepository, newRepository);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRepository(Repository newRepository) {
        if (newRepository != repository) {
            NotificationChain msgs = null;
            if (repository != null)
                msgs = ((InternalEObject)repository).eInverseRemove(this, RepositoryPackage.REPOSITORY__EXPERIMENT_GROUPS, Repository.class, msgs);
            if (newRepository != null)
                msgs = ((InternalEObject)newRepository).eInverseAdd(this, RepositoryPackage.REPOSITORY__EXPERIMENT_GROUPS, Repository.class, msgs);
            msgs = basicSetRepository(newRepository, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.EXPERIMENT_GROUP__REPOSITORY, newRepository, newRepository));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getPurpose() {
        return purpose;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPurpose(String newPurpose) {
        String oldPurpose = purpose;
        purpose = newPurpose;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.EXPERIMENT_GROUP__PURPOSE, oldPurpose, purpose));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Edp2Measure> getMeasure() {
        if (measure == null) {
            measure = new EObjectContainmentWithInverseEList<Edp2Measure>(Edp2Measure.class, this, ExperimentDataPackage.EXPERIMENT_GROUP__MEASURE, ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_GROUP);
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
            case ExperimentDataPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getExperimentSettings()).basicAdd(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_GROUP__MEASURE:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMeasure()).basicAdd(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_GROUP__REPOSITORY:
                if (repository != null)
                    msgs = ((InternalEObject)repository).eInverseRemove(this, RepositoryPackage.REPOSITORY__EXPERIMENT_GROUPS, Repository.class, msgs);
                return basicSetRepository((Repository)otherEnd, msgs);
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
            case ExperimentDataPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
                return ((InternalEList<?>)getAdditionalInformation()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
                return ((InternalEList<?>)getExperimentSettings()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_GROUP__MEASURE:
                return ((InternalEList<?>)getMeasure()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_GROUP__REPOSITORY:
                return basicSetRepository(null, msgs);
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
            case ExperimentDataPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
                if (coreType) return getAdditionalInformation();
                else return getAdditionalInformation().map();
            case ExperimentDataPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
                return getExperimentSettings();
            case ExperimentDataPackage.EXPERIMENT_GROUP__MEASURE:
                return getMeasure();
            case ExperimentDataPackage.EXPERIMENT_GROUP__PURPOSE:
                return getPurpose();
            case ExperimentDataPackage.EXPERIMENT_GROUP__REPOSITORY:
                if (resolve) return getRepository();
                return basicGetRepository();
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
            case ExperimentDataPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
                ((EStructuralFeature.Setting)getAdditionalInformation()).set(newValue);
                return;
            case ExperimentDataPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
                getExperimentSettings().clear();
                getExperimentSettings().addAll((Collection<? extends ExperimentSetting>)newValue);
                return;
            case ExperimentDataPackage.EXPERIMENT_GROUP__MEASURE:
                getMeasure().clear();
                getMeasure().addAll((Collection<? extends Edp2Measure>)newValue);
                return;
            case ExperimentDataPackage.EXPERIMENT_GROUP__PURPOSE:
                setPurpose((String)newValue);
                return;
            case ExperimentDataPackage.EXPERIMENT_GROUP__REPOSITORY:
                setRepository((Repository)newValue);
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
            case ExperimentDataPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
                getAdditionalInformation().clear();
                return;
            case ExperimentDataPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
                getExperimentSettings().clear();
                return;
            case ExperimentDataPackage.EXPERIMENT_GROUP__MEASURE:
                getMeasure().clear();
                return;
            case ExperimentDataPackage.EXPERIMENT_GROUP__PURPOSE:
                setPurpose(PURPOSE_EDEFAULT);
                return;
            case ExperimentDataPackage.EXPERIMENT_GROUP__REPOSITORY:
                setRepository((Repository)null);
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
            case ExperimentDataPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
                return additionalInformation != null && !additionalInformation.isEmpty();
            case ExperimentDataPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
                return experimentSettings != null && !experimentSettings.isEmpty();
            case ExperimentDataPackage.EXPERIMENT_GROUP__MEASURE:
                return measure != null && !measure.isEmpty();
            case ExperimentDataPackage.EXPERIMENT_GROUP__PURPOSE:
                return PURPOSE_EDEFAULT == null ? purpose != null : !PURPOSE_EDEFAULT.equals(purpose);
            case ExperimentDataPackage.EXPERIMENT_GROUP__REPOSITORY:
                return repository != null;
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
                case ExperimentDataPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION: return ExperimentDataPackage.PROPERTYABLE__ADDITIONAL_INFORMATION;
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
                case ExperimentDataPackage.PROPERTYABLE__ADDITIONAL_INFORMATION: return ExperimentDataPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION;
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
        result.append(" (purpose: ");
        result.append(purpose);
        result.append(')');
        return result.toString();
    }

} //ExperimentGroupImpl
