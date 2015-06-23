/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.usagemodel.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;
import org.palladiosimulator.pcm.usagemodel.Workload;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usage Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.UsageScenarioImpl#getUsageModel_UsageScenario <em>Usage Model Usage Scenario</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.UsageScenarioImpl#getScenarioBehaviour_UsageScenario <em>Scenario Behaviour Usage Scenario</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.UsageScenarioImpl#getWorkload_UsageScenario <em>Workload Usage Scenario</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UsageScenarioImpl extends EntityImpl implements UsageScenario {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UsageScenarioImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.USAGE_SCENARIO;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UsageModel getUsageModel_UsageScenario() {
        return (UsageModel) eDynamicGet(UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO,
                UsagemodelPackage.Literals.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetUsageModel_UsageScenario(UsageModel newUsageModel_UsageScenario,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newUsageModel_UsageScenario,
                UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUsageModel_UsageScenario(UsageModel newUsageModel_UsageScenario) {
        eDynamicSet(UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO,
                UsagemodelPackage.Literals.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO, newUsageModel_UsageScenario);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScenarioBehaviour getScenarioBehaviour_UsageScenario() {
        return (ScenarioBehaviour) eDynamicGet(UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO,
                UsagemodelPackage.Literals.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetScenarioBehaviour_UsageScenario(
            ScenarioBehaviour newScenarioBehaviour_UsageScenario, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newScenarioBehaviour_UsageScenario,
                UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setScenarioBehaviour_UsageScenario(ScenarioBehaviour newScenarioBehaviour_UsageScenario) {
        eDynamicSet(UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO,
                UsagemodelPackage.Literals.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO,
                newScenarioBehaviour_UsageScenario);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Workload getWorkload_UsageScenario() {
        return (Workload) eDynamicGet(UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO,
                UsagemodelPackage.Literals.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetWorkload_UsageScenario(Workload newWorkload_UsageScenario,
            NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newWorkload_UsageScenario,
                UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWorkload_UsageScenario(Workload newWorkload_UsageScenario) {
        eDynamicSet(UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO,
                UsagemodelPackage.Literals.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, newWorkload_UsageScenario);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetUsageModel_UsageScenario((UsageModel) otherEnd, msgs);
        case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
            ScenarioBehaviour scenarioBehaviour_UsageScenario = getScenarioBehaviour_UsageScenario();
            if (scenarioBehaviour_UsageScenario != null)
                msgs = ((InternalEObject) scenarioBehaviour_UsageScenario).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO,
                        null, msgs);
            return basicSetScenarioBehaviour_UsageScenario((ScenarioBehaviour) otherEnd, msgs);
        case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
            Workload workload_UsageScenario = getWorkload_UsageScenario();
            if (workload_UsageScenario != null)
                msgs = ((InternalEObject) workload_UsageScenario).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, null, msgs);
            return basicSetWorkload_UsageScenario((Workload) otherEnd, msgs);
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
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            return basicSetUsageModel_UsageScenario(null, msgs);
        case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
            return basicSetScenarioBehaviour_UsageScenario(null, msgs);
        case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
            return basicSetWorkload_UsageScenario(null, msgs);
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
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            return eInternalContainer().eInverseRemove(this, UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL,
                    UsageModel.class, msgs);
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
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            return getUsageModel_UsageScenario();
        case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
            return getScenarioBehaviour_UsageScenario();
        case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
            return getWorkload_UsageScenario();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            setUsageModel_UsageScenario((UsageModel) newValue);
            return;
        case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
            setScenarioBehaviour_UsageScenario((ScenarioBehaviour) newValue);
            return;
        case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
            setWorkload_UsageScenario((Workload) newValue);
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
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            setUsageModel_UsageScenario((UsageModel) null);
            return;
        case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
            setScenarioBehaviour_UsageScenario((ScenarioBehaviour) null);
            return;
        case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
            setWorkload_UsageScenario((Workload) null);
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
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            return getUsageModel_UsageScenario() != null;
        case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
            return getScenarioBehaviour_UsageScenario() != null;
        case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
            return getWorkload_UsageScenario() != null;
        }
        return super.eIsSet(featureID);
    }

} //UsageScenarioImpl
