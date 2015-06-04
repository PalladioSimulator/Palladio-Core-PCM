/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.impl;

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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannel;
import de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.core.entity.util.EntityValidator;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.util.SystemValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>System</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getAssemblyContexts__ComposedStructure <em>
 * Assembly Contexts Composed Structure</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getResourceRequiredDelegationConnectors_ComposedStructure
 * <em>Resource Required Delegation Connectors Composed Structure</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getEventChannel__ComposedStructure <em>Event
 * Channel Composed Structure</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getConnectors__ComposedStructure <em>
 * Connectors Composed Structure</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getProvidedRoles_InterfaceProvidingEntity
 * <em>Provided Roles Interface Providing Entity</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getResourceRequiredRoles__ResourceInterfaceRequiringEntity
 * <em>Resource Required Roles Resource Interface Requiring Entity</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getRequiredRoles_InterfaceRequiringEntity
 * <em>Required Roles Interface Requiring Entity</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getQosAnnotations_System <em>Qos Annotations
 * System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends EntityImpl implements de.uka.ipd.sdq.pcm.system.System {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getAssemblyContexts__ComposedStructure()
     * <em>Assembly Contexts Composed Structure</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAssemblyContexts__ComposedStructure()
     * @generated
     * @ordered
     */
    protected EList<AssemblyContext> assemblyContexts__ComposedStructure;

    /**
     * The cached value of the '{@link #getResourceRequiredDelegationConnectors_ComposedStructure()
     * <em>Resource Required Delegation Connectors Composed Structure</em>}' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceRequiredDelegationConnectors_ComposedStructure()
     * @generated
     * @ordered
     */
    protected EList<ResourceRequiredDelegationConnector> resourceRequiredDelegationConnectors_ComposedStructure;

    /**
     * The cached value of the '{@link #getEventChannel__ComposedStructure()
     * <em>Event Channel Composed Structure</em>}' containment reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getEventChannel__ComposedStructure()
     * @generated
     * @ordered
     */
    protected EList<EventChannel> eventChannel__ComposedStructure;

    /**
     * The cached value of the '{@link #getConnectors__ComposedStructure()
     * <em>Connectors Composed Structure</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getConnectors__ComposedStructure()
     * @generated
     * @ordered
     */
    protected EList<Connector> connectors__ComposedStructure;

    /**
     * The cached value of the '{@link #getProvidedRoles_InterfaceProvidingEntity()
     * <em>Provided Roles Interface Providing Entity</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getProvidedRoles_InterfaceProvidingEntity()
     * @generated
     * @ordered
     */
    protected EList<ProvidedRole> providedRoles_InterfaceProvidingEntity;

    /**
     * The cached value of the '
     * {@link #getResourceRequiredRoles__ResourceInterfaceRequiringEntity()
     * <em>Resource Required Roles Resource Interface Requiring Entity</em>}' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceRequiredRoles__ResourceInterfaceRequiringEntity()
     * @generated
     * @ordered
     */
    protected EList<ResourceRequiredRole> resourceRequiredRoles__ResourceInterfaceRequiringEntity;

    /**
     * The cached value of the '{@link #getRequiredRoles_InterfaceRequiringEntity()
     * <em>Required Roles Interface Requiring Entity</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRequiredRoles_InterfaceRequiringEntity()
     * @generated
     * @ordered
     */
    protected EList<RequiredRole> requiredRoles_InterfaceRequiringEntity;

    /**
     * The cached value of the '{@link #getQosAnnotations_System() <em>Qos Annotations System</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getQosAnnotations_System()
     * @generated
     * @ordered
     */
    protected EList<QoSAnnotations> qosAnnotations_System;

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
    @SuppressWarnings("unchecked")
    @Override
    public EList<AssemblyContext> getAssemblyContexts__ComposedStructure() {
        if (this.assemblyContexts__ComposedStructure == null) {
            this.assemblyContexts__ComposedStructure = new EObjectContainmentWithInverseEList<AssemblyContext>(
                    AssemblyContext.class, this, SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE,
                    CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT);
        }
        return this.assemblyContexts__ComposedStructure;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ResourceRequiredDelegationConnector> getResourceRequiredDelegationConnectors_ComposedStructure() {
        if (this.resourceRequiredDelegationConnectors_ComposedStructure == null) {
            this.resourceRequiredDelegationConnectors_ComposedStructure = new EObjectContainmentWithInverseEList<ResourceRequiredDelegationConnector>(
                    ResourceRequiredDelegationConnector.class,
                    this,
                    SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE,
                    CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR);
        }
        return this.resourceRequiredDelegationConnectors_ComposedStructure;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<EventChannel> getEventChannel__ComposedStructure() {
        if (this.eventChannel__ComposedStructure == null) {
            this.eventChannel__ComposedStructure = new EObjectContainmentWithInverseEList<EventChannel>(
                    EventChannel.class, this, SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE,
                    CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL);
        }
        return this.eventChannel__ComposedStructure;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<Connector> getConnectors__ComposedStructure() {
        if (this.connectors__ComposedStructure == null) {
            this.connectors__ComposedStructure = new EObjectContainmentWithInverseEList<Connector>(Connector.class,
                    this, SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE,
                    CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR);
        }
        return this.connectors__ComposedStructure;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ProvidedRole> getProvidedRoles_InterfaceProvidingEntity() {
        if (this.providedRoles_InterfaceProvidingEntity == null) {
            this.providedRoles_InterfaceProvidingEntity = new EObjectContainmentWithInverseEList<ProvidedRole>(
                    ProvidedRole.class, this, SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY,
                    RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE);
        }
        return this.providedRoles_InterfaceProvidingEntity;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ResourceRequiredRole> getResourceRequiredRoles__ResourceInterfaceRequiringEntity() {
        if (this.resourceRequiredRoles__ResourceInterfaceRequiringEntity == null) {
            this.resourceRequiredRoles__ResourceInterfaceRequiringEntity = new EObjectContainmentWithInverseEList<ResourceRequiredRole>(
                    ResourceRequiredRole.class, this,
                    SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY,
                    EntityPackage.RESOURCE_REQUIRED_ROLE__RESOURCE_INTERFACE_REQUIRING_ENTITY_RESOURCE_REQUIRED_ROLE);
        }
        return this.resourceRequiredRoles__ResourceInterfaceRequiringEntity;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<RequiredRole> getRequiredRoles_InterfaceRequiringEntity() {
        if (this.requiredRoles_InterfaceRequiringEntity == null) {
            this.requiredRoles_InterfaceRequiringEntity = new EObjectContainmentWithInverseEList<RequiredRole>(
                    RequiredRole.class, this, SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY,
                    RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE);
        }
        return this.requiredRoles_InterfaceRequiringEntity;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<QoSAnnotations> getQosAnnotations_System() {
        if (this.qosAnnotations_System == null) {
            this.qosAnnotations_System = new EObjectContainmentWithInverseEList<QoSAnnotations>(QoSAnnotations.class,
                    this, SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM,
                    QosannotationsPackage.QO_SANNOTATIONS__SYSTEM_QO_SANNOTATIONS);
        }
        return this.qosAnnotations_System;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #MultipleConnectorsConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Multiple Connectors Constraint</em>}' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #MultipleConnectorsConstraint(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.connectors__ComposedStructure->select(conn | conn.oclIsTypeOf(pcm::core::composition::ProvidedDelegationConnector)).oclAsType(pcm::core::composition::ProvidedDelegationConnector)->forAll( c1, c2 | c1 <> c2 implies c1.outerProvidedRole_ProvidedDelegationConnector <> c2.outerProvidedRole_ProvidedDelegationConnector)\n"
            + "";

    /**
     * The cached OCL invariant for the '
     * {@link #MultipleConnectorsConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Multiple Connectors Constraint</em>}' invariant operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #MultipleConnectorsConstraint(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean MultipleConnectorsConstraint(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(CompositionPackage.Literals.COMPOSED_STRUCTURE);
            try {
                MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, CompositionValidator.DIAGNOSTIC_SOURCE,
                        CompositionValidator.COMPOSED_STRUCTURE__MULTIPLE_CONNECTORS_CONSTRAINT, EcorePlugin.INSTANCE
                        .getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "MultipleConnectorsConstraint",
                                        EObjectValidator.getObjectLabel(this, context) }),
                                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #MultipleConnectorsConstraintForAssemblyConnectors(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Multiple Connectors Constraint For Assembly Connectors</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MultipleConnectorsConstraintForAssemblyConnectors(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.connectors__ComposedStructure->select(conn | conn.oclIsTypeOf(pcm::core::composition::AssemblyConnector)).oclAsType(AssemblyConnector)->forAll( c1, c2 | ( (c1 <> c2) and ( c1.requiringAssemblyContext_AssemblyConnector = c2.requiringAssemblyContext_AssemblyConnector ) ) implies c1.requiredRole_AssemblyConnector <> c2.requiredRole_AssemblyConnector )\n"
            + "";

    /**
     * The cached OCL invariant for the '
     * {@link #MultipleConnectorsConstraintForAssemblyConnectors(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Multiple Connectors Constraint For Assembly Connectors</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MultipleConnectorsConstraintForAssemblyConnectors(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean MultipleConnectorsConstraintForAssemblyConnectors(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(CompositionPackage.Literals.COMPOSED_STRUCTURE);
            try {
                MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        CompositionValidator.DIAGNOSTIC_SOURCE,
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
     * The cached OCL expression body for the '
     * {@link #ProvidedRolesMustBeBound(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Provided Roles Must Be Bound</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #ProvidedRolesMustBeBound(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String PROVIDED_ROLES_MUST_BE_BOUND__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.providedRoles_InterfaceProvidingEntity->forAll(role|self.connectors__ComposedStructure->select(conn | conn.oclIsTypeOf(pcm::core::composition::ProvidedDelegationConnector)).oclAsType(pcm::core::composition::ProvidedDelegationConnector)->exists(connector|connector.outerProvidedRole_ProvidedDelegationConnector = role))\n"
            + "\n" + "";

    /**
     * The cached OCL invariant for the '
     * {@link #ProvidedRolesMustBeBound(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Provided Roles Must Be Bound</em>}' invariant operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #ProvidedRolesMustBeBound(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint PROVIDED_ROLES_MUST_BE_BOUND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean ProvidedRolesMustBeBound(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (PROVIDED_ROLES_MUST_BE_BOUND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(EntityPackage.Literals.COMPOSED_PROVIDING_REQUIRING_ENTITY);
            try {
                PROVIDED_ROLES_MUST_BE_BOUND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(PROVIDED_ROLES_MUST_BE_BOUND__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(PROVIDED_ROLES_MUST_BE_BOUND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, EntityValidator.DIAGNOSTIC_SOURCE,
                        EntityValidator.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_MUST_BE_BOUND,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "ProvidedRolesMustBeBound", EObjectValidator.getObjectLabel(this, context) }),
                                new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #SystemMustHaveAtLeastOneProvidedRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>System Must Have At Least One Provided Role</em>}' operation. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #SystemMustHaveAtLeastOneProvidedRole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String SYSTEM_MUST_HAVE_AT_LEAST_ONE_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.providedRoles_InterfaceProvidingEntity->isEmpty()";

    /**
     * The cached OCL invariant for the '
     * {@link #SystemMustHaveAtLeastOneProvidedRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>System Must Have At Least One Provided Role</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #SystemMustHaveAtLeastOneProvidedRole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint SYSTEM_MUST_HAVE_AT_LEAST_ONE_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean SystemMustHaveAtLeastOneProvidedRole(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (SYSTEM_MUST_HAVE_AT_LEAST_ONE_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SystemPackage.Literals.SYSTEM);
            try {
                SYSTEM_MUST_HAVE_AT_LEAST_ONE_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(SYSTEM_MUST_HAVE_AT_LEAST_ONE_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(SYSTEM_MUST_HAVE_AT_LEAST_ONE_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(
                this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, SystemValidator.DIAGNOSTIC_SOURCE,
                        SystemValidator.SYSTEM__SYSTEM_MUST_HAVE_AT_LEAST_ONE_PROVIDED_ROLE, EcorePlugin.INSTANCE
                        .getString(
                                "_UI_GenericInvariant_diagnostic",
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
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getQosAnnotations_System()).basicAdd(
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
        case SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) this.getAssemblyContexts__ComposedStructure()).basicRemove(otherEnd, msgs);
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) this.getResourceRequiredDelegationConnectors_ComposedStructure()).basicRemove(
                    otherEnd, msgs);
        case SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) this.getEventChannel__ComposedStructure()).basicRemove(otherEnd, msgs);
        case SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) this.getConnectors__ComposedStructure()).basicRemove(otherEnd, msgs);
        case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return ((InternalEList<?>) this.getProvidedRoles_InterfaceProvidingEntity()).basicRemove(otherEnd, msgs);
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            return ((InternalEList<?>) this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity()).basicRemove(
                    otherEnd, msgs);
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
            this.getResourceRequiredDelegationConnectors_ComposedStructure().addAll(
                    (Collection<? extends ResourceRequiredDelegationConnector>) newValue);
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
            this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity().addAll(
                    (Collection<? extends ResourceRequiredRole>) newValue);
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
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case SystemPackage.SYSTEM__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return this.assemblyContexts__ComposedStructure != null
                    && !this.assemblyContexts__ComposedStructure.isEmpty();
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return this.resourceRequiredDelegationConnectors_ComposedStructure != null
            && !this.resourceRequiredDelegationConnectors_ComposedStructure.isEmpty();
        case SystemPackage.SYSTEM__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return this.eventChannel__ComposedStructure != null && !this.eventChannel__ComposedStructure.isEmpty();
        case SystemPackage.SYSTEM__CONNECTORS_COMPOSED_STRUCTURE:
            return this.connectors__ComposedStructure != null && !this.connectors__ComposedStructure.isEmpty();
        case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return this.providedRoles_InterfaceProvidingEntity != null
                    && !this.providedRoles_InterfaceProvidingEntity.isEmpty();
        case SystemPackage.SYSTEM__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            return this.resourceRequiredRoles__ResourceInterfaceRequiringEntity != null
            && !this.resourceRequiredRoles__ResourceInterfaceRequiringEntity.isEmpty();
        case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            return this.requiredRoles_InterfaceRequiringEntity != null
                    && !this.requiredRoles_InterfaceRequiringEntity.isEmpty();
        case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
            return this.qosAnnotations_System != null && !this.qosAnnotations_System.isEmpty();
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

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // SystemImpl
