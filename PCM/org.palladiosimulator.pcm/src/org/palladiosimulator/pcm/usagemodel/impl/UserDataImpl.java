/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.usagemodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;

import org.palladiosimulator.pcm.parameter.VariableUsage;

import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;
import org.palladiosimulator.pcm.usagemodel.UserData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.UserDataImpl#getAssemblyContext_userData <em>Assembly Context user Data</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.UserDataImpl#getUsageModel_UserData <em>Usage Model User Data</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.UserDataImpl#getUserDataParameterUsages_UserData <em>User Data Parameter Usages User Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UserDataImpl extends CDOObjectImpl implements UserData {

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
    protected UserDataImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.USER_DATA;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getAssemblyContext_userData() {
        return (AssemblyContext) eDynamicGet(UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA,
                UsagemodelPackage.Literals.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext_userData() {
        return (AssemblyContext) eDynamicGet(UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA,
                UsagemodelPackage.Literals.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAssemblyContext_userData(AssemblyContext newAssemblyContext_userData) {
        eDynamicSet(UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA,
                UsagemodelPackage.Literals.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA, newAssemblyContext_userData);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UsageModel getUsageModel_UserData() {
        return (UsageModel) eDynamicGet(UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA,
                UsagemodelPackage.Literals.USER_DATA__USAGE_MODEL_USER_DATA, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetUsageModel_UserData(UsageModel newUsageModel_UserData, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newUsageModel_UserData,
                UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUsageModel_UserData(UsageModel newUsageModel_UserData) {
        eDynamicSet(UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA,
                UsagemodelPackage.Literals.USER_DATA__USAGE_MODEL_USER_DATA, newUsageModel_UserData);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<VariableUsage> getUserDataParameterUsages_UserData() {
        return (EList<VariableUsage>) eDynamicGet(UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA,
                UsagemodelPackage.Literals.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA, true, true);
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
        case UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetUsageModel_UserData((UsageModel) otherEnd, msgs);
        case UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getUserDataParameterUsages_UserData())
                    .basicAdd(otherEnd, msgs);
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
        case UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA:
            return basicSetUsageModel_UserData(null, msgs);
        case UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA:
            return ((InternalEList<?>) getUserDataParameterUsages_UserData()).basicRemove(otherEnd, msgs);
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
        case UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA:
            return eInternalContainer().eInverseRemove(this, UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL,
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
        case UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA:
            if (resolve)
                return getAssemblyContext_userData();
            return basicGetAssemblyContext_userData();
        case UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA:
            return getUsageModel_UserData();
        case UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA:
            return getUserDataParameterUsages_UserData();
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
        case UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA:
            setAssemblyContext_userData((AssemblyContext) newValue);
            return;
        case UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA:
            setUsageModel_UserData((UsageModel) newValue);
            return;
        case UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA:
            getUserDataParameterUsages_UserData().clear();
            getUserDataParameterUsages_UserData().addAll((Collection<? extends VariableUsage>) newValue);
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
        case UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA:
            setAssemblyContext_userData((AssemblyContext) null);
            return;
        case UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA:
            setUsageModel_UserData((UsageModel) null);
            return;
        case UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA:
            getUserDataParameterUsages_UserData().clear();
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
        case UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA:
            return basicGetAssemblyContext_userData() != null;
        case UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA:
            return getUsageModel_UserData() != null;
        case UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA:
            return !getUserDataParameterUsages_UserData().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //UserDataImpl
