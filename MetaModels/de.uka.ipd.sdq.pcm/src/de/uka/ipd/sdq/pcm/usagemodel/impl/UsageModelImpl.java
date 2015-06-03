/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.mdsdprofiles.impl.ProfileableElementImpl;

import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Usage Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageModelImpl#getUsageScenario_UsageModel <em>
 * Usage Scenario Usage Model</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageModelImpl#getUserData_UsageModel <em>User Data
 * Usage Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsageModelImpl extends ProfileableElementImpl implements UsageModel {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getUsageScenario_UsageModel()
     * <em>Usage Scenario Usage Model</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getUsageScenario_UsageModel()
     * @generated
     * @ordered
     */
    protected EList<UsageScenario> usageScenario_UsageModel;

    /**
     * The cached value of the '{@link #getUserData_UsageModel() <em>User Data Usage Model</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getUserData_UsageModel()
     * @generated
     * @ordered
     */
    protected EList<UserData> userData_UsageModel;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected UsageModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.USAGE_MODEL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<UserData> getUserData_UsageModel() {
        if (this.userData_UsageModel == null) {
            this.userData_UsageModel = new EObjectContainmentWithInverseEList<UserData>(UserData.class, this,
                    UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL,
                    UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA);
        }
        return this.userData_UsageModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<UsageScenario> getUsageScenario_UsageModel() {
        if (this.usageScenario_UsageModel == null) {
            this.usageScenario_UsageModel = new EObjectContainmentWithInverseEList<UsageScenario>(UsageScenario.class,
                    this, UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL,
                    UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO);
        }
        return this.usageScenario_UsageModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getUsageScenario_UsageModel()).basicAdd(
                    otherEnd, msgs);
        case UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getUserData_UsageModel()).basicAdd(
                    otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL:
            return ((InternalEList<?>) this.getUsageScenario_UsageModel()).basicRemove(otherEnd, msgs);
        case UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL:
            return ((InternalEList<?>) this.getUserData_UsageModel()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL:
            return this.getUsageScenario_UsageModel();
        case UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL:
            return this.getUserData_UsageModel();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL:
            this.getUsageScenario_UsageModel().clear();
            this.getUsageScenario_UsageModel().addAll((Collection<? extends UsageScenario>) newValue);
            return;
        case UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL:
            this.getUserData_UsageModel().clear();
            this.getUserData_UsageModel().addAll((Collection<? extends UserData>) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL:
            this.getUsageScenario_UsageModel().clear();
            return;
        case UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL:
            this.getUserData_UsageModel().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL:
            return this.usageScenario_UsageModel != null && !this.usageScenario_UsageModel.isEmpty();
        case UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL:
            return this.userData_UsageModel != null && !this.userData_UsageModel.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // UsageModelImpl
