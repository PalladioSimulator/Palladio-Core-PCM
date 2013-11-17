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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;
import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.impl.EStereotypableObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Usage Model</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageModelImpl#getUsageScenario_UsageModel <em>Usage Scenario Usage Model</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageModelImpl#getUserData_UsageModel <em>User Data Usage Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsageModelImpl extends EStereotypableObjectImpl implements UsageModel {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getUsageScenario_UsageModel() <em>Usage Scenario Usage Model</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsageScenario_UsageModel()
     * @generated
     * @ordered
     */
    protected EList<UsageScenario> usageScenario_UsageModel;

    /**
     * The cached value of the '{@link #getUserData_UsageModel() <em>User Data Usage Model</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getUserData_UsageModel()
     * @generated
     * @ordered
     */
    protected EList<UserData> userData_UsageModel;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected UsageModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.USAGE_MODEL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<UserData> getUserData_UsageModel() {
        if (userData_UsageModel == null) {
            userData_UsageModel = new EObjectContainmentWithInverseEList<UserData>(UserData.class, this, UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL, UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA);
        }
        return userData_UsageModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<UsageScenario> getUsageScenario_UsageModel() {
        if (usageScenario_UsageModel == null) {
            usageScenario_UsageModel = new EObjectContainmentWithInverseEList<UsageScenario>(UsageScenario.class, this, UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL, UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO);
        }
        return usageScenario_UsageModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getUsageScenario_UsageModel()).basicAdd(otherEnd, msgs);
            case UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getUserData_UsageModel()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL:
                return ((InternalEList<?>)getUsageScenario_UsageModel()).basicRemove(otherEnd, msgs);
            case UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL:
                return ((InternalEList<?>)getUserData_UsageModel()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL:
                return getUsageScenario_UsageModel();
            case UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL:
                return getUserData_UsageModel();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL:
                getUsageScenario_UsageModel().clear();
                getUsageScenario_UsageModel().addAll((Collection<? extends UsageScenario>)newValue);
                return;
            case UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL:
                getUserData_UsageModel().clear();
                getUserData_UsageModel().addAll((Collection<? extends UserData>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL:
                getUsageScenario_UsageModel().clear();
                return;
            case UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL:
                getUserData_UsageModel().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL:
                return usageScenario_UsageModel != null && !usageScenario_UsageModel.isEmpty();
            case UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL:
                return userData_UsageModel != null && !userData_UsageModel.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // UsageModelImpl
