/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;
import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.impl.EStereotypableObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>User Data</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UserDataImpl#getAssemblyContext_userData <em>
 * Assembly Context user Data</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UserDataImpl#getUsageModel_UserData <em>Usage Model
 * User Data</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UserDataImpl#getUserDataParameterUsages_UserData
 * <em>User Data Parameter Usages User Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserDataImpl extends EStereotypableObjectImpl implements UserData {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getAssemblyContext_userData()
     * <em>Assembly Context user Data</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getAssemblyContext_userData()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext_userData;

    /**
     * The cached value of the '{@link #getUserDataParameterUsages_UserData()
     * <em>User Data Parameter Usages User Data</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getUserDataParameterUsages_UserData()
     * @generated
     * @ordered
     */
    protected EList<VariableUsage> userDataParameterUsages_UserData;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected UserDataImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.USER_DATA;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public UsageModel getUsageModel_UserData() {
        if (eContainerFeatureID() != UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA)
            return null;
        return (UsageModel) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetUsageModel_UserData(UsageModel newUsageModel_UserData, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newUsageModel_UserData,
                UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setUsageModel_UserData(UsageModel newUsageModel_UserData) {
        if (newUsageModel_UserData != eInternalContainer()
                || (eContainerFeatureID() != UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA && newUsageModel_UserData != null)) {
            if (EcoreUtil.isAncestor(this, (EObject) newUsageModel_UserData))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newUsageModel_UserData != null)
                msgs = ((InternalEObject) newUsageModel_UserData).eInverseAdd(this,
                        UsagemodelPackage.USAGE_MODEL__USER_DATA_USAGE_MODEL, UsageModel.class, msgs);
            msgs = basicSetUsageModel_UserData(newUsageModel_UserData, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA,
                    newUsageModel_UserData, newUsageModel_UserData));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext_userData() {
        if (assemblyContext_userData != null && ((EObject) assemblyContext_userData).eIsProxy()) {
            InternalEObject oldAssemblyContext_userData = (InternalEObject) assemblyContext_userData;
            assemblyContext_userData = (AssemblyContext) eResolveProxy(oldAssemblyContext_userData);
            if (assemblyContext_userData != oldAssemblyContext_userData) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA, oldAssemblyContext_userData,
                            assemblyContext_userData));
            }
        }
        return assemblyContext_userData;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext_userData() {
        return assemblyContext_userData;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAssemblyContext_userData(AssemblyContext newAssemblyContext_userData) {
        AssemblyContext oldAssemblyContext_userData = assemblyContext_userData;
        assemblyContext_userData = newAssemblyContext_userData;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA, oldAssemblyContext_userData,
                    assemblyContext_userData));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<VariableUsage> getUserDataParameterUsages_UserData() {
        if (userDataParameterUsages_UserData == null) {
            userDataParameterUsages_UserData = new EObjectContainmentWithInverseEList<VariableUsage>(
                    VariableUsage.class, this, UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA,
                    ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE);
        }
        return userDataParameterUsages_UserData;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case UsagemodelPackage.USER_DATA__ASSEMBLY_CONTEXT_USER_DATA:
            return assemblyContext_userData != null;
        case UsagemodelPackage.USER_DATA__USAGE_MODEL_USER_DATA:
            return getUsageModel_UserData() != null;
        case UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA:
            return userDataParameterUsages_UserData != null && !userDataParameterUsages_UserData.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // UserDataImpl
