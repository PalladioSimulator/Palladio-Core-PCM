/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.allocation.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.allocation.AllocationPackage;
import org.palladiosimulator.pcm.allocation.util.AllocationValidator;
import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Allocation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.allocation.impl.AllocationImpl#getTargetResourceEnvironment_Allocation
 * <em>Target Resource Environment Allocation</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.allocation.impl.AllocationImpl#getSystem_Allocation
 * <em>System Allocation</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.allocation.impl.AllocationImpl#getAllocationContexts_Allocation
 * <em>Allocation Contexts Allocation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AllocationImpl extends EntityImpl implements Allocation {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AllocationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AllocationPackage.Literals.ALLOCATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceEnvironment getTargetResourceEnvironment_Allocation() {
        return (ResourceEnvironment) this.eDynamicGet(
                AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION,
                AllocationPackage.Literals.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceEnvironment basicGetTargetResourceEnvironment_Allocation() {
        return (ResourceEnvironment) this.eDynamicGet(
                AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION,
                AllocationPackage.Literals.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTargetResourceEnvironment_Allocation(
            final ResourceEnvironment newTargetResourceEnvironment_Allocation) {
        this.eDynamicSet(AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION,
                AllocationPackage.Literals.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION,
                newTargetResourceEnvironment_Allocation);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public org.palladiosimulator.pcm.system.System getSystem_Allocation() {
        return (org.palladiosimulator.pcm.system.System) this.eDynamicGet(
                AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION,
                AllocationPackage.Literals.ALLOCATION__SYSTEM_ALLOCATION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public org.palladiosimulator.pcm.system.System basicGetSystem_Allocation() {
        return (org.palladiosimulator.pcm.system.System) this.eDynamicGet(
                AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION,
                AllocationPackage.Literals.ALLOCATION__SYSTEM_ALLOCATION, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSystem_Allocation(final org.palladiosimulator.pcm.system.System newSystem_Allocation) {
        this.eDynamicSet(AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION,
                AllocationPackage.Literals.ALLOCATION__SYSTEM_ALLOCATION, newSystem_Allocation);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<AllocationContext> getAllocationContexts_Allocation() {
        return (EList<AllocationContext>) this.eDynamicGet(AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION,
                AllocationPackage.Literals.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, AllocationValidator.DIAGNOSTIC_SOURCE,
                                AllocationValidator.ALLOCATION__EACH_ASSEMBLY_CONTEXT_WITHIN_SYSTEM_HAS_TO_BE_ALLOCATED_EXACTLY_ONCE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce",
                                                EObjectValidator.getObjectLabel(this, context) }),
                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean CommunicatingServersHaveToBeConnectedByLinkingResource(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, AllocationValidator.DIAGNOSTIC_SOURCE,
                                AllocationValidator.ALLOCATION__COMMUNICATING_SERVERS_HAVE_TO_BE_CONNECTED_BY_LINKING_RESOURCE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "CommunicatingServersHaveToBeConnectedByLinkingResource",
                                                EObjectValidator.getObjectLabel(this, context) }),
                        new Object[] { this }));
            }
            return false;
        }
        return true;
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
        case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getAllocationContexts_Allocation())
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
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
            return ((InternalEList<?>) this.getAllocationContexts_Allocation()).basicRemove(otherEnd, msgs);
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
        case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
            if (resolve) {
                return this.getTargetResourceEnvironment_Allocation();
            }
            return this.basicGetTargetResourceEnvironment_Allocation();
        case AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION:
            if (resolve) {
                return this.getSystem_Allocation();
            }
            return this.basicGetSystem_Allocation();
        case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
            return this.getAllocationContexts_Allocation();
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
        case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
            this.setTargetResourceEnvironment_Allocation((ResourceEnvironment) newValue);
            return;
        case AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION:
            this.setSystem_Allocation((org.palladiosimulator.pcm.system.System) newValue);
            return;
        case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
            this.getAllocationContexts_Allocation().clear();
            this.getAllocationContexts_Allocation().addAll((Collection<? extends AllocationContext>) newValue);
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
        case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
            this.setTargetResourceEnvironment_Allocation((ResourceEnvironment) null);
            return;
        case AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION:
            this.setSystem_Allocation((org.palladiosimulator.pcm.system.System) null);
            return;
        case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
            this.getAllocationContexts_Allocation().clear();
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
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
            return this.basicGetTargetResourceEnvironment_Allocation() != null;
        case AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION:
            return this.basicGetSystem_Allocation() != null;
        case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
            return !this.getAllocationContexts_Allocation().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // AllocationImpl
