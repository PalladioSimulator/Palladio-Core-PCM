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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Propertyable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Experiment Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentSettingImpl#getAdditionalInformation <em>Additional Information</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentSettingImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentSettingImpl#getExperimentRuns <em>Experiment Runs</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentSettingImpl#getMeasure <em>Measure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentSettingImpl#getExperimentGroup <em>Experiment Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExperimentSettingImpl extends IdentifiableImpl implements ExperimentSetting {
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
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
	protected String description = DESCRIPTION_EDEFAULT;

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
	protected EList<Edp2Measure> measure;

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
        return ExperimentDataPackage.Literals.EXPERIMENT_SETTING;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EMap<String, Object> getAdditionalInformation() {
        if (additionalInformation == null) {
            additionalInformation = new EcoreEMap<String,Object>(ExperimentDataPackage.Literals.ESTRINGTO_EOBJECT_MAP_ENTRY, EStringtoEObjectMapEntryImpl.class, this, ExperimentDataPackage.EXPERIMENT_SETTING__ADDITIONAL_INFORMATION);
        }
        return additionalInformation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getDescription() {
        return description;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.EXPERIMENT_SETTING__DESCRIPTION, oldDescription, description));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ExperimentRun> getExperimentRuns() {
        if (experimentRuns == null) {
            experimentRuns = new EObjectContainmentWithInverseEList<ExperimentRun>(ExperimentRun.class, this, ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS, ExperimentDataPackage.EXPERIMENT_RUN__EXPERIMENT_SETTING);
        }
        return experimentRuns;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Edp2Measure> getMeasure() {
        if (measure == null) {
            measure = new EObjectWithInverseResolvingEList.ManyInverse<Edp2Measure>(Edp2Measure.class, this, ExperimentDataPackage.EXPERIMENT_SETTING__MEASURE, ExperimentDataPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS);
        }
        return measure;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExperimentGroup getExperimentGroup() {
        if (eContainerFeatureID() != ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_GROUP) return null;
        return (ExperimentGroup)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetExperimentGroup(ExperimentGroup newExperimentGroup, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newExperimentGroup, ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_GROUP, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExperimentGroup(ExperimentGroup newExperimentGroup) {
        if (newExperimentGroup != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_GROUP && newExperimentGroup != null)) {
            if (EcoreUtil.isAncestor(this, newExperimentGroup))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newExperimentGroup != null)
                msgs = ((InternalEObject)newExperimentGroup).eInverseAdd(this, ExperimentDataPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS, ExperimentGroup.class, msgs);
            msgs = basicSetExperimentGroup(newExperimentGroup, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_GROUP, newExperimentGroup, newExperimentGroup));
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
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getExperimentRuns()).basicAdd(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_SETTING__MEASURE:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMeasure()).basicAdd(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_GROUP:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetExperimentGroup((ExperimentGroup)otherEnd, msgs);
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
            case ExperimentDataPackage.EXPERIMENT_SETTING__ADDITIONAL_INFORMATION:
                return ((InternalEList<?>)getAdditionalInformation()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
                return ((InternalEList<?>)getExperimentRuns()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_SETTING__MEASURE:
                return ((InternalEList<?>)getMeasure()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_GROUP:
                return basicSetExperimentGroup(null, msgs);
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
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_GROUP:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS, ExperimentGroup.class, msgs);
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
            case ExperimentDataPackage.EXPERIMENT_SETTING__ADDITIONAL_INFORMATION:
                if (coreType) return getAdditionalInformation();
                else return getAdditionalInformation().map();
            case ExperimentDataPackage.EXPERIMENT_SETTING__DESCRIPTION:
                return getDescription();
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
                return getExperimentRuns();
            case ExperimentDataPackage.EXPERIMENT_SETTING__MEASURE:
                return getMeasure();
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_GROUP:
                return getExperimentGroup();
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
            case ExperimentDataPackage.EXPERIMENT_SETTING__ADDITIONAL_INFORMATION:
                ((EStructuralFeature.Setting)getAdditionalInformation()).set(newValue);
                return;
            case ExperimentDataPackage.EXPERIMENT_SETTING__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
                getExperimentRuns().clear();
                getExperimentRuns().addAll((Collection<? extends ExperimentRun>)newValue);
                return;
            case ExperimentDataPackage.EXPERIMENT_SETTING__MEASURE:
                getMeasure().clear();
                getMeasure().addAll((Collection<? extends Edp2Measure>)newValue);
                return;
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_GROUP:
                setExperimentGroup((ExperimentGroup)newValue);
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
            case ExperimentDataPackage.EXPERIMENT_SETTING__ADDITIONAL_INFORMATION:
                getAdditionalInformation().clear();
                return;
            case ExperimentDataPackage.EXPERIMENT_SETTING__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
                getExperimentRuns().clear();
                return;
            case ExperimentDataPackage.EXPERIMENT_SETTING__MEASURE:
                getMeasure().clear();
                return;
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_GROUP:
                setExperimentGroup((ExperimentGroup)null);
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
            case ExperimentDataPackage.EXPERIMENT_SETTING__ADDITIONAL_INFORMATION:
                return additionalInformation != null && !additionalInformation.isEmpty();
            case ExperimentDataPackage.EXPERIMENT_SETTING__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_RUNS:
                return experimentRuns != null && !experimentRuns.isEmpty();
            case ExperimentDataPackage.EXPERIMENT_SETTING__MEASURE:
                return measure != null && !measure.isEmpty();
            case ExperimentDataPackage.EXPERIMENT_SETTING__EXPERIMENT_GROUP:
                return getExperimentGroup() != null;
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
                case ExperimentDataPackage.EXPERIMENT_SETTING__ADDITIONAL_INFORMATION: return ExperimentDataPackage.PROPERTYABLE__ADDITIONAL_INFORMATION;
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
                case ExperimentDataPackage.PROPERTYABLE__ADDITIONAL_INFORMATION: return ExperimentDataPackage.EXPERIMENT_SETTING__ADDITIONAL_INFORMATION;
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
        result.append(" (description: ");
        result.append(description);
        result.append(')');
        return result.toString();
    }

} //ExperimentSettingImpl
