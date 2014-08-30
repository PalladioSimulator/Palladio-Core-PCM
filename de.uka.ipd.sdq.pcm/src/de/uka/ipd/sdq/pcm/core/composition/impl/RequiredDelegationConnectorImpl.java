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
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Required Delegation Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredDelegationConnectorImpl#getInnerRequiredRole_RequiredDelegationConnector
 * <em>Inner Required Role Required Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredDelegationConnectorImpl#getOuterRequiredRole_RequiredDelegationConnector
 * <em>Outer Required Role Required Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredDelegationConnectorImpl#getAssemblyContext_RequiredDelegationConnector
 * <em>Assembly Context Required Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequiredDelegationConnectorImpl extends DelegationConnectorImpl implements RequiredDelegationConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getInnerRequiredRole_RequiredDelegationConnector()
     * <em>Inner Required Role Required Delegation Connector</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getInnerRequiredRole_RequiredDelegationConnector()
     * @generated
     * @ordered
     */
    protected OperationRequiredRole innerRequiredRole_RequiredDelegationConnector;

    /**
     * The cached value of the '{@link #getOuterRequiredRole_RequiredDelegationConnector()
     * <em>Outer Required Role Required Delegation Connector</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getOuterRequiredRole_RequiredDelegationConnector()
     * @generated
     * @ordered
     */
    protected OperationRequiredRole outerRequiredRole_RequiredDelegationConnector;

    /**
     * The cached value of the '{@link #getAssemblyContext_RequiredDelegationConnector()
     * <em>Assembly Context Required Delegation Connector</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getAssemblyContext_RequiredDelegationConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext_RequiredDelegationConnector;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RequiredDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public OperationRequiredRole getInnerRequiredRole_RequiredDelegationConnector() {
        if (innerRequiredRole_RequiredDelegationConnector != null
                && ((EObject) innerRequiredRole_RequiredDelegationConnector).eIsProxy()) {
            InternalEObject oldInnerRequiredRole_RequiredDelegationConnector = (InternalEObject) innerRequiredRole_RequiredDelegationConnector;
            innerRequiredRole_RequiredDelegationConnector = (OperationRequiredRole) eResolveProxy(oldInnerRequiredRole_RequiredDelegationConnector);
            if (innerRequiredRole_RequiredDelegationConnector != oldInnerRequiredRole_RequiredDelegationConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                            oldInnerRequiredRole_RequiredDelegationConnector,
                            innerRequiredRole_RequiredDelegationConnector));
            }
        }
        return innerRequiredRole_RequiredDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperationRequiredRole basicGetInnerRequiredRole_RequiredDelegationConnector() {
        return innerRequiredRole_RequiredDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setInnerRequiredRole_RequiredDelegationConnector(
            OperationRequiredRole newInnerRequiredRole_RequiredDelegationConnector) {
        OperationRequiredRole oldInnerRequiredRole_RequiredDelegationConnector = innerRequiredRole_RequiredDelegationConnector;
        innerRequiredRole_RequiredDelegationConnector = newInnerRequiredRole_RequiredDelegationConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                    oldInnerRequiredRole_RequiredDelegationConnector, innerRequiredRole_RequiredDelegationConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public OperationRequiredRole getOuterRequiredRole_RequiredDelegationConnector() {
        if (outerRequiredRole_RequiredDelegationConnector != null
                && ((EObject) outerRequiredRole_RequiredDelegationConnector).eIsProxy()) {
            InternalEObject oldOuterRequiredRole_RequiredDelegationConnector = (InternalEObject) outerRequiredRole_RequiredDelegationConnector;
            outerRequiredRole_RequiredDelegationConnector = (OperationRequiredRole) eResolveProxy(oldOuterRequiredRole_RequiredDelegationConnector);
            if (outerRequiredRole_RequiredDelegationConnector != oldOuterRequiredRole_RequiredDelegationConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                            oldOuterRequiredRole_RequiredDelegationConnector,
                            outerRequiredRole_RequiredDelegationConnector));
            }
        }
        return outerRequiredRole_RequiredDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperationRequiredRole basicGetOuterRequiredRole_RequiredDelegationConnector() {
        return outerRequiredRole_RequiredDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOuterRequiredRole_RequiredDelegationConnector(
            OperationRequiredRole newOuterRequiredRole_RequiredDelegationConnector) {
        OperationRequiredRole oldOuterRequiredRole_RequiredDelegationConnector = outerRequiredRole_RequiredDelegationConnector;
        outerRequiredRole_RequiredDelegationConnector = newOuterRequiredRole_RequiredDelegationConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                    oldOuterRequiredRole_RequiredDelegationConnector, outerRequiredRole_RequiredDelegationConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext_RequiredDelegationConnector() {
        if (assemblyContext_RequiredDelegationConnector != null
                && ((EObject) assemblyContext_RequiredDelegationConnector).eIsProxy()) {
            InternalEObject oldAssemblyContext_RequiredDelegationConnector = (InternalEObject) assemblyContext_RequiredDelegationConnector;
            assemblyContext_RequiredDelegationConnector = (AssemblyContext) eResolveProxy(oldAssemblyContext_RequiredDelegationConnector);
            if (assemblyContext_RequiredDelegationConnector != oldAssemblyContext_RequiredDelegationConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR,
                            oldAssemblyContext_RequiredDelegationConnector, assemblyContext_RequiredDelegationConnector));
            }
        }
        return assemblyContext_RequiredDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext_RequiredDelegationConnector() {
        return assemblyContext_RequiredDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAssemblyContext_RequiredDelegationConnector(
            AssemblyContext newAssemblyContext_RequiredDelegationConnector) {
        AssemblyContext oldAssemblyContext_RequiredDelegationConnector = assemblyContext_RequiredDelegationConnector;
        assemblyContext_RequiredDelegationConnector = newAssemblyContext_RequiredDelegationConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR,
                    oldAssemblyContext_RequiredDelegationConnector, assemblyContext_RequiredDelegationConnector));
    }

    /**
     * The cached OCL expression body for the '
     * {@link #RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Required Delegation Connectorandtheconnected Componentmustbepartofthesamecompositestructure</em>}
     * ' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String REQUIRED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentStructure__Connector = self.assemblyContext_RequiredDelegationConnector.parentStructure__AssemblyContext";

    /**
     * The cached OCL invariant for the '
     * {@link #RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Required Delegation Connectorandtheconnected Componentmustbepartofthesamecompositestructure</em>}
     * ' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint REQUIRED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (REQUIRED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR);
            try {
                REQUIRED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(REQUIRED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        REQUIRED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                CompositionValidator.DIAGNOSTIC_SOURCE,
                                CompositionValidator.REQUIRED_DELEGATION_CONNECTOR__REQUIRED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE,
                                EcorePlugin.INSTANCE
                                        .getString(
                                                "_UI_GenericInvariant_diagnostic",
                                                new Object[] {
                                                        "RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure",
                                                        EObjectValidator.getObjectLabel(this, context) }),
                                new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Component Of Assembly Context And Inner Role Requiring Component Need To Be The Same</em>}
     * ' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_REQUIRING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.innerRequiredRole_RequiredDelegationConnector.requiringEntity_RequiredRole = self.assemblyContext_RequiredDelegationConnector.encapsulatedComponent__AssemblyContext";

    /**
     * The cached OCL invariant for the '
     * {@link #ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Component Of Assembly Context And Inner Role Requiring Component Need To Be The Same</em>}
     * ' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_REQUIRING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_REQUIRING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR);
            try {
                COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_REQUIRING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_REQUIRING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_REQUIRING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                CompositionValidator.DIAGNOSTIC_SOURCE,
                                CompositionValidator.REQUIRED_DELEGATION_CONNECTOR__COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_REQUIRING_COMPONENT_NEED_TO_BE_THE_SAME,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                        "ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #RequiringEntityOfOuterRequiredRoleMustBeTheSameAsTheParentOfTheRequiredDelegationConnector(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Requiring Entity Of Outer Required Role Must Be The Same As The Parent Of The Required Delegation Connector</em>}
     * ' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #RequiringEntityOfOuterRequiredRoleMustBeTheSameAsTheParentOfTheRequiredDelegationConnector(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String REQUIRING_ENTITY_OF_OUTER_REQUIRED_ROLE_MUST_BE_THE_SAME_AS_THE_PARENT_OF_THE_REQUIRED_DELEGATION_CONNECTOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.outerRequiredRole_RequiredDelegationConnector.requiringEntity_RequiredRole=self.parentStructure__Connector";

    /**
     * The cached OCL invariant for the '
     * {@link #RequiringEntityOfOuterRequiredRoleMustBeTheSameAsTheParentOfTheRequiredDelegationConnector(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Requiring Entity Of Outer Required Role Must Be The Same As The Parent Of The Required Delegation Connector</em>}
     * ' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #RequiringEntityOfOuterRequiredRoleMustBeTheSameAsTheParentOfTheRequiredDelegationConnector(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint REQUIRING_ENTITY_OF_OUTER_REQUIRED_ROLE_MUST_BE_THE_SAME_AS_THE_PARENT_OF_THE_REQUIRED_DELEGATION_CONNECTOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean RequiringEntityOfOuterRequiredRoleMustBeTheSameAsTheParentOfTheRequiredDelegationConnector(
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (REQUIRING_ENTITY_OF_OUTER_REQUIRED_ROLE_MUST_BE_THE_SAME_AS_THE_PARENT_OF_THE_REQUIRED_DELEGATION_CONNECTOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR);
            try {
                REQUIRING_ENTITY_OF_OUTER_REQUIRED_ROLE_MUST_BE_THE_SAME_AS_THE_PARENT_OF_THE_REQUIRED_DELEGATION_CONNECTOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(REQUIRING_ENTITY_OF_OUTER_REQUIRED_ROLE_MUST_BE_THE_SAME_AS_THE_PARENT_OF_THE_REQUIRED_DELEGATION_CONNECTOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        REQUIRING_ENTITY_OF_OUTER_REQUIRED_ROLE_MUST_BE_THE_SAME_AS_THE_PARENT_OF_THE_REQUIRED_DELEGATION_CONNECTOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                CompositionValidator.DIAGNOSTIC_SOURCE,
                                CompositionValidator.REQUIRED_DELEGATION_CONNECTOR__REQUIRING_ENTITY_OF_OUTER_REQUIRED_ROLE_MUST_BE_THE_SAME_AS_THE_PARENT_OF_THE_REQUIRED_DELEGATION_CONNECTOR,
                                EcorePlugin.INSTANCE
                                        .getString(
                                                "_UI_GenericInvariant_diagnostic",
                                                new Object[] {
                                                        "RequiringEntityOfOuterRequiredRoleMustBeTheSameAsTheParentOfTheRequiredDelegationConnector",
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
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            if (resolve)
                return getInnerRequiredRole_RequiredDelegationConnector();
            return basicGetInnerRequiredRole_RequiredDelegationConnector();
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            if (resolve)
                return getOuterRequiredRole_RequiredDelegationConnector();
            return basicGetOuterRequiredRole_RequiredDelegationConnector();
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
            if (resolve)
                return getAssemblyContext_RequiredDelegationConnector();
            return basicGetAssemblyContext_RequiredDelegationConnector();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            setInnerRequiredRole_RequiredDelegationConnector((OperationRequiredRole) newValue);
            return;
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            setOuterRequiredRole_RequiredDelegationConnector((OperationRequiredRole) newValue);
            return;
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
            setAssemblyContext_RequiredDelegationConnector((AssemblyContext) newValue);
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
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            setInnerRequiredRole_RequiredDelegationConnector((OperationRequiredRole) null);
            return;
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            setOuterRequiredRole_RequiredDelegationConnector((OperationRequiredRole) null);
            return;
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
            setAssemblyContext_RequiredDelegationConnector((AssemblyContext) null);
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
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            return innerRequiredRole_RequiredDelegationConnector != null;
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            return outerRequiredRole_RequiredDelegationConnector != null;
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
            return assemblyContext_RequiredDelegationConnector != null;
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

} // RequiredDelegationConnectorImpl
