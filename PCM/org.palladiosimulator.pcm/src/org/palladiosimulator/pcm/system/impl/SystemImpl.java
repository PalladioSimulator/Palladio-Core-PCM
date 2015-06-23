/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.system.impl;

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
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.Connector;
import org.palladiosimulator.pcm.core.composition.EventChannel;
import org.palladiosimulator.pcm.core.composition.ResourceRequiredDelegationConnector;
import org.palladiosimulator.pcm.core.composition.util.CompositionValidator;
import org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity;
import org.palladiosimulator.pcm.core.entity.EntityPackage;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingEntity;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity;
import org.palladiosimulator.pcm.core.entity.InterfaceRequiringEntity;
import org.palladiosimulator.pcm.core.entity.ResourceInterfaceRequiringEntity;
import org.palladiosimulator.pcm.core.entity.ResourceRequiredRole;
import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;
import org.palladiosimulator.pcm.core.entity.util.EntityValidator;
import org.palladiosimulator.pcm.qosannotations.QoSAnnotations;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.system.SystemPackage;
import org.palladiosimulator.pcm.system.util.SystemValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>System</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.system.impl.SystemImpl#getAssemblyContexts__ComposedStructure
 * <em>Assembly Contexts Composed Structure</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.system.impl.SystemImpl#getResourceRequiredDelegationConnectors_ComposedStructure
 * <em>Resource Required Delegation Connectors Composed Structure</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.system.impl.SystemImpl#getEventChannel__ComposedStructure
 * <em>Event Channel Composed Structure</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.system.impl.SystemImpl#getConnectors__ComposedStructure
 * <em>Connectors Composed Structure</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.system.impl.SystemImpl#getProvidedRoles_InterfaceProvidingEntity
 * <em>Provided Roles Interface Providing Entity</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.system.impl.SystemImpl#getResourceRequiredRoles__ResourceInterfaceRequiringEntity
 * <em>Resource Required Roles Resource Interface Requiring Entity</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.system.impl.SystemImpl#getRequiredRoles_InterfaceRequiringEntity
 * <em>Required Roles Interface Requiring Entity</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.system.impl.SystemImpl#getQosAnnotations_System
 * <em>Qos Annotations System</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemImpl extends EntityImpl implements org.palladiosimulator.pcm.system.System {

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
    protected SystemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SystemPackage.Literals.SYSTEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<AssemblyContext> getAssemblyContexts__ComposedStructure() {
        return (EList<AssemblyContext>) this.eDynamicGet(SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE,
                CompositionPackage.Literals.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<ResourceRequiredDelegationConnector> getResourceRequiredDelegationConnectors_ComposedStructure() {
        return (EList<ResourceRequiredDelegationConnector>) this.eDynamicGet(
                SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE,
                CompositionPackage.Literals.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<EventChannel> getEventChannel__ComposedStructure() {
        return (EList<EventChannel>) this.eDynamicGet(SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE,
                CompositionPackage.Literals.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<Connector> getConnectors__ComposedStructure() {
        return (EList<Connector>) this.eDynamicGet(SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE,
                CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<ProvidedRole> getProvidedRoles_InterfaceProvidingEntity() {
        return (EList<ProvidedRole>) this.eDynamicGet(SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY,
                EntityPackage.Literals.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<ResourceRequiredRole> getResourceRequiredRoles__ResourceInterfaceRequiringEntity() {
        return (EList<ResourceRequiredRole>) this.eDynamicGet(
                SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY,
                EntityPackage.Literals.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<RequiredRole> getRequiredRoles_InterfaceRequiringEntity() {
        return (EList<RequiredRole>) this.eDynamicGet(SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY,
                EntityPackage.Literals.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<QoSAnnotations> getQosAnnotations_System() {
        return (EList<QoSAnnotations>) this.eDynamicGet(SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM,
                SystemPackage.Literals.SYSTEM__QOS_ANNOTATIONS_SYSTEM, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean MultipleConnectorsConstraint(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, CompositionValidator.DIAGNOSTIC_SOURCE,
                                CompositionValidator.COMPOSED_STRUCTURE__MULTIPLE_CONNECTORS_CONSTRAINT,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "MultipleConnectorsConstraint",
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
    public boolean MultipleConnectorsConstraintForAssemblyConnectors(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, CompositionValidator.DIAGNOSTIC_SOURCE,
                                CompositionValidator.COMPOSED_STRUCTURE__MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "MultipleConnectorsConstraintForAssemblyConnectors",
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
    public boolean ProvidedRolesMustBeBound(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, EntityValidator.DIAGNOSTIC_SOURCE,
                                EntityValidator.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_MUST_BE_BOUND,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "ProvidedRolesMustBeBound",
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
    public boolean SystemMustHaveAtLeastOneProvidedRole(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, SystemValidator.DIAGNOSTIC_SOURCE,
                                SystemValidator.SYSTEM__SYSTEM_MUST_HAVE_AT_LEAST_ONE_PROVIDED_ROLE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "SystemMustHaveAtLeastOneProvidedRole",
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
        case SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getAssemblyContexts__ComposedStructure())
                    .basicAdd(otherEnd, msgs);
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getResourceRequiredDelegationConnectors_ComposedStructure()).basicAdd(otherEnd, msgs);
        case SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getEventChannel__ComposedStructure())
                    .basicAdd(otherEnd, msgs);
        case SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getConnectors__ComposedStructure())
                    .basicAdd(otherEnd, msgs);
        case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getProvidedRoles_InterfaceProvidingEntity()).basicAdd(otherEnd, msgs);
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getResourceRequiredRoles__ResourceInterfaceRequiringEntity()).basicAdd(otherEnd, msgs);
        case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getRequiredRoles_InterfaceRequiringEntity()).basicAdd(otherEnd, msgs);
        case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getQosAnnotations_System())
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
        case SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) this.getAssemblyContexts__ComposedStructure()).basicRemove(otherEnd, msgs);
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) this.getResourceRequiredDelegationConnectors_ComposedStructure())
                    .basicRemove(otherEnd, msgs);
        case SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) this.getEventChannel__ComposedStructure()).basicRemove(otherEnd, msgs);
        case SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) this.getConnectors__ComposedStructure()).basicRemove(otherEnd, msgs);
        case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return ((InternalEList<?>) this.getProvidedRoles_InterfaceProvidingEntity()).basicRemove(otherEnd, msgs);
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            return ((InternalEList<?>) this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity())
                    .basicRemove(otherEnd, msgs);
        case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            return ((InternalEList<?>) this.getRequiredRoles_InterfaceRequiringEntity()).basicRemove(otherEnd, msgs);
        case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
            return ((InternalEList<?>) this.getQosAnnotations_System()).basicRemove(otherEnd, msgs);
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
        case SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return this.getAssemblyContexts__ComposedStructure();
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return this.getResourceRequiredDelegationConnectors_ComposedStructure();
        case SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return this.getEventChannel__ComposedStructure();
        case SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE:
            return this.getConnectors__ComposedStructure();
        case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return this.getProvidedRoles_InterfaceProvidingEntity();
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            return this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity();
        case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            return this.getRequiredRoles_InterfaceRequiringEntity();
        case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
            return this.getQosAnnotations_System();
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
        case SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            this.getAssemblyContexts__ComposedStructure().clear();
            this.getAssemblyContexts__ComposedStructure().addAll((Collection<? extends AssemblyContext>) newValue);
            return;
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            this.getResourceRequiredDelegationConnectors_ComposedStructure().clear();
            this.getResourceRequiredDelegationConnectors_ComposedStructure()
                    .addAll((Collection<? extends ResourceRequiredDelegationConnector>) newValue);
            return;
        case SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            this.getEventChannel__ComposedStructure().clear();
            this.getEventChannel__ComposedStructure().addAll((Collection<? extends EventChannel>) newValue);
            return;
        case SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE:
            this.getConnectors__ComposedStructure().clear();
            this.getConnectors__ComposedStructure().addAll((Collection<? extends Connector>) newValue);
            return;
        case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            this.getProvidedRoles_InterfaceProvidingEntity().clear();
            this.getProvidedRoles_InterfaceProvidingEntity().addAll((Collection<? extends ProvidedRole>) newValue);
            return;
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity().clear();
            this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity()
                    .addAll((Collection<? extends ResourceRequiredRole>) newValue);
            return;
        case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            this.getRequiredRoles_InterfaceRequiringEntity().clear();
            this.getRequiredRoles_InterfaceRequiringEntity().addAll((Collection<? extends RequiredRole>) newValue);
            return;
        case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
            this.getQosAnnotations_System().clear();
            this.getQosAnnotations_System().addAll((Collection<? extends QoSAnnotations>) newValue);
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
        case SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            this.getAssemblyContexts__ComposedStructure().clear();
            return;
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            this.getResourceRequiredDelegationConnectors_ComposedStructure().clear();
            return;
        case SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            this.getEventChannel__ComposedStructure().clear();
            return;
        case SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE:
            this.getConnectors__ComposedStructure().clear();
            return;
        case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            this.getProvidedRoles_InterfaceProvidingEntity().clear();
            return;
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity().clear();
            return;
        case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            this.getRequiredRoles_InterfaceRequiringEntity().clear();
            return;
        case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
            this.getQosAnnotations_System().clear();
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
        case SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return !this.getAssemblyContexts__ComposedStructure().isEmpty();
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return !this.getResourceRequiredDelegationConnectors_ComposedStructure().isEmpty();
        case SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return !this.getEventChannel__ComposedStructure().isEmpty();
        case SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE:
            return !this.getConnectors__ComposedStructure().isEmpty();
        case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return !this.getProvidedRoles_InterfaceProvidingEntity().isEmpty();
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            return !this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity().isEmpty();
        case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            return !this.getRequiredRoles_InterfaceRequiringEntity().isEmpty();
        case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
            return !this.getQosAnnotations_System().isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(final int derivedFeatureID, final Class<?> baseClass) {
        if (baseClass == ComposedStructure.class) {
            switch (derivedFeatureID) {
            case SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
                return CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE;
            case SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
                return CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;
            case SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE:
                return CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE;
            case SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE:
                return CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE;
            default:
                return -1;
            }
        }
        if (baseClass == InterfaceProvidingEntity.class) {
            switch (derivedFeatureID) {
            case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
                return EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;
            default:
                return -1;
            }
        }
        if (baseClass == ResourceInterfaceRequiringEntity.class) {
            switch (derivedFeatureID) {
            case SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
                return EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;
            default:
                return -1;
            }
        }
        if (baseClass == InterfaceRequiringEntity.class) {
            switch (derivedFeatureID) {
            case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
                return EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;
            default:
                return -1;
            }
        }
        if (baseClass == InterfaceProvidingRequiringEntity.class) {
            switch (derivedFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == ComposedProvidingRequiringEntity.class) {
            switch (derivedFeatureID) {
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(final int baseFeatureID, final Class<?> baseClass) {
        if (baseClass == ComposedStructure.class) {
            switch (baseFeatureID) {
            case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
                return SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE;
            case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
                return SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;
            case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
                return SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE;
            case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
                return SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE;
            default:
                return -1;
            }
        }
        if (baseClass == InterfaceProvidingEntity.class) {
            switch (baseFeatureID) {
            case EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
                return SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;
            default:
                return -1;
            }
        }
        if (baseClass == ResourceInterfaceRequiringEntity.class) {
            switch (baseFeatureID) {
            case EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
                return SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;
            default:
                return -1;
            }
        }
        if (baseClass == InterfaceRequiringEntity.class) {
            switch (baseFeatureID) {
            case EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
                return SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;
            default:
                return -1;
            }
        }
        if (baseClass == InterfaceProvidingRequiringEntity.class) {
            switch (baseFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == ComposedProvidingRequiringEntity.class) {
            switch (baseFeatureID) {
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // SystemImpl
