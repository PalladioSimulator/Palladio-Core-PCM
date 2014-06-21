/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Provided Delegation Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl#getInnerProvidedRole_ProvidedDelegationConnector
 * <em>Inner Provided Role Provided Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl#getOuterProvidedRole_ProvidedDelegationConnector
 * <em>Outer Provided Role Provided Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl#getAssemblyContext_ProvidedDelegationConnector
 * <em>Assembly Context Provided Delegation Connector</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProvidedDelegationConnectorImpl extends DelegationConnectorImpl implements ProvidedDelegationConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the ' {@link #getInnerProvidedRole_ProvidedDelegationConnector()
     * <em>Inner Provided Role Provided Delegation Connector</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getInnerProvidedRole_ProvidedDelegationConnector()
     * @generated
     * @ordered
     */
    protected OperationProvidedRole innerProvidedRole_ProvidedDelegationConnector;

    /**
     * The cached value of the ' {@link #getOuterProvidedRole_ProvidedDelegationConnector()
     * <em>Outer Provided Role Provided Delegation Connector</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getOuterProvidedRole_ProvidedDelegationConnector()
     * @generated
     * @ordered
     */
    protected OperationProvidedRole outerProvidedRole_ProvidedDelegationConnector;

    /**
     * The cached value of the ' {@link #getAssemblyContext_ProvidedDelegationConnector()
     * <em>Assembly Context Provided Delegation Connector</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getAssemblyContext_ProvidedDelegationConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext_ProvidedDelegationConnector;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ProvidedDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.PROVIDED_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public OperationProvidedRole getInnerProvidedRole_ProvidedDelegationConnector() {
        if (this.innerProvidedRole_ProvidedDelegationConnector != null
                && ((EObject) this.innerProvidedRole_ProvidedDelegationConnector).eIsProxy()) {
            final InternalEObject oldInnerProvidedRole_ProvidedDelegationConnector = (InternalEObject) this.innerProvidedRole_ProvidedDelegationConnector;
            this.innerProvidedRole_ProvidedDelegationConnector = (OperationProvidedRole) this
                    .eResolveProxy(oldInnerProvidedRole_ProvidedDelegationConnector);
            if (this.innerProvidedRole_ProvidedDelegationConnector != oldInnerProvidedRole_ProvidedDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR,
                            oldInnerProvidedRole_ProvidedDelegationConnector,
                            this.innerProvidedRole_ProvidedDelegationConnector));
                }
            }
        }
        return this.innerProvidedRole_ProvidedDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperationProvidedRole basicGetInnerProvidedRole_ProvidedDelegationConnector() {
        return this.innerProvidedRole_ProvidedDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setInnerProvidedRole_ProvidedDelegationConnector(
            final OperationProvidedRole newInnerProvidedRole_ProvidedDelegationConnector) {
        final OperationProvidedRole oldInnerProvidedRole_ProvidedDelegationConnector = this.innerProvidedRole_ProvidedDelegationConnector;
        this.innerProvidedRole_ProvidedDelegationConnector = newInnerProvidedRole_ProvidedDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR,
                    oldInnerProvidedRole_ProvidedDelegationConnector,
                    this.innerProvidedRole_ProvidedDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public OperationProvidedRole getOuterProvidedRole_ProvidedDelegationConnector() {
        if (this.outerProvidedRole_ProvidedDelegationConnector != null
                && ((EObject) this.outerProvidedRole_ProvidedDelegationConnector).eIsProxy()) {
            final InternalEObject oldOuterProvidedRole_ProvidedDelegationConnector = (InternalEObject) this.outerProvidedRole_ProvidedDelegationConnector;
            this.outerProvidedRole_ProvidedDelegationConnector = (OperationProvidedRole) this
                    .eResolveProxy(oldOuterProvidedRole_ProvidedDelegationConnector);
            if (this.outerProvidedRole_ProvidedDelegationConnector != oldOuterProvidedRole_ProvidedDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR,
                            oldOuterProvidedRole_ProvidedDelegationConnector,
                            this.outerProvidedRole_ProvidedDelegationConnector));
                }
            }
        }
        return this.outerProvidedRole_ProvidedDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperationProvidedRole basicGetOuterProvidedRole_ProvidedDelegationConnector() {
        return this.outerProvidedRole_ProvidedDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOuterProvidedRole_ProvidedDelegationConnector(
            final OperationProvidedRole newOuterProvidedRole_ProvidedDelegationConnector) {
        final OperationProvidedRole oldOuterProvidedRole_ProvidedDelegationConnector = this.outerProvidedRole_ProvidedDelegationConnector;
        this.outerProvidedRole_ProvidedDelegationConnector = newOuterProvidedRole_ProvidedDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR,
                    oldOuterProvidedRole_ProvidedDelegationConnector,
                    this.outerProvidedRole_ProvidedDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext_ProvidedDelegationConnector() {
        if (this.assemblyContext_ProvidedDelegationConnector != null
                && ((EObject) this.assemblyContext_ProvidedDelegationConnector).eIsProxy()) {
            final InternalEObject oldAssemblyContext_ProvidedDelegationConnector = (InternalEObject) this.assemblyContext_ProvidedDelegationConnector;
            this.assemblyContext_ProvidedDelegationConnector = (AssemblyContext) this
                    .eResolveProxy(oldAssemblyContext_ProvidedDelegationConnector);
            if (this.assemblyContext_ProvidedDelegationConnector != oldAssemblyContext_ProvidedDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR,
                            oldAssemblyContext_ProvidedDelegationConnector,
                            this.assemblyContext_ProvidedDelegationConnector));
                }
            }
        }
        return this.assemblyContext_ProvidedDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext_ProvidedDelegationConnector() {
        return this.assemblyContext_ProvidedDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAssemblyContext_ProvidedDelegationConnector(
            final AssemblyContext newAssemblyContext_ProvidedDelegationConnector) {
        final AssemblyContext oldAssemblyContext_ProvidedDelegationConnector = this.assemblyContext_ProvidedDelegationConnector;
        this.assemblyContext_ProvidedDelegationConnector = newAssemblyContext_ProvidedDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR,
                    oldAssemblyContext_ProvidedDelegationConnector, this.assemblyContext_ProvidedDelegationConnector));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Provided Delegation Connectorandtheconnected Componentmustbepartofthesamecompositestructure</em>}
     * ' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentStructure__Connector = self.assemblyContext_ProvidedDelegationConnector.parentStructure__AssemblyContext";

    /**
     * The cached OCL invariant for the '
     * {@link #ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Provided Delegation Connectorandtheconnected Componentmustbepartofthesamecompositestructure</em>}
     * ' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(CompositionPackage.Literals.PROVIDED_DELEGATION_CONNECTOR);
            try {
                PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                CompositionValidator.DIAGNOSTIC_SOURCE,
                                CompositionValidator.PROVIDED_DELEGATION_CONNECTOR__PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE,
                                EcorePlugin.INSTANCE
                                        .getString(
                                                "_UI_GenericInvariant_diagnostic",
                                                new Object[] {
                                                        "ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure",
                                                        EObjectValidator.getObjectLabel(this, context) }),
                                new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Component Of Assembly Context And Inner Role Providing Component Need To Be The Same</em>}
     * ' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.innerProvidedRole_ProvidedDelegationConnector.providingEntity_ProvidedRole = self.assemblyContext_ProvidedDelegationConnector.encapsulatedComponent__AssemblyContext";

    /**
     * The cached OCL invariant for the '
     * {@link #ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Component Of Assembly Context And Inner Role Providing Component Need To Be The Same</em>}
     * ' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(CompositionPackage.Literals.PROVIDED_DELEGATION_CONNECTOR);
            try {
                COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                CompositionValidator.DIAGNOSTIC_SOURCE,
                                CompositionValidator.PROVIDED_DELEGATION_CONNECTOR__COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                        "ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
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
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getInnerProvidedRole_ProvidedDelegationConnector();
            }
            return this.basicGetInnerProvidedRole_ProvidedDelegationConnector();
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getOuterProvidedRole_ProvidedDelegationConnector();
            }
            return this.basicGetOuterProvidedRole_ProvidedDelegationConnector();
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getAssemblyContext_ProvidedDelegationConnector();
            }
            return this.basicGetAssemblyContext_ProvidedDelegationConnector();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
            this.setInnerProvidedRole_ProvidedDelegationConnector((OperationProvidedRole) newValue);
            return;
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
            this.setOuterProvidedRole_ProvidedDelegationConnector((OperationProvidedRole) newValue);
            return;
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR:
            this.setAssemblyContext_ProvidedDelegationConnector((AssemblyContext) newValue);
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
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
            this.setInnerProvidedRole_ProvidedDelegationConnector((OperationProvidedRole) null);
            return;
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
            this.setOuterProvidedRole_ProvidedDelegationConnector((OperationProvidedRole) null);
            return;
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR:
            this.setAssemblyContext_ProvidedDelegationConnector((AssemblyContext) null);
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
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
            return this.innerProvidedRole_ProvidedDelegationConnector != null;
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
            return this.outerProvidedRole_ProvidedDelegationConnector != null;
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR:
            return this.assemblyContext_ProvidedDelegationConnector != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // ProvidedDelegationConnectorImpl
