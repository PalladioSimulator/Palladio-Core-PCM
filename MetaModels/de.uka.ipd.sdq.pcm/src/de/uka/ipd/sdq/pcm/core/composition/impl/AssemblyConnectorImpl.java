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

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Assembly Connector</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getRequiringAssemblyContext_AssemblyConnector <em>Requiring Assembly Context Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getProvidingAssemblyContext_AssemblyConnector <em>Providing Assembly Context Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getProvidedRole_AssemblyConnector <em>Provided Role Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getRequiredRole_AssemblyConnector <em>Required Role Assembly Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssemblyConnectorImpl extends ConnectorImpl implements AssemblyConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getRequiringAssemblyContext_AssemblyConnector() <em>Requiring Assembly Context Assembly Connector</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRequiringAssemblyContext_AssemblyConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext requiringAssemblyContext_AssemblyConnector;

    /**
     * The cached value of the '{@link #getProvidingAssemblyContext_AssemblyConnector() <em>Providing Assembly Context Assembly Connector</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProvidingAssemblyContext_AssemblyConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext providingAssemblyContext_AssemblyConnector;

    /**
     * The cached value of the '{@link #getProvidedRole_AssemblyConnector() <em>Provided Role Assembly Connector</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getProvidedRole_AssemblyConnector()
     * @generated
     * @ordered
     */
    protected OperationProvidedRole providedRole_AssemblyConnector;

    /**
     * The cached value of the '{@link #getRequiredRole_AssemblyConnector() <em>Required Role Assembly Connector</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getRequiredRole_AssemblyConnector()
     * @generated
     * @ordered
     */
    protected OperationRequiredRole requiredRole_AssemblyConnector;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected AssemblyConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.ASSEMBLY_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getRequiringAssemblyContext_AssemblyConnector() {
        if (requiringAssemblyContext_AssemblyConnector != null && ((EObject)requiringAssemblyContext_AssemblyConnector).eIsProxy()) {
            InternalEObject oldRequiringAssemblyContext_AssemblyConnector = (InternalEObject)requiringAssemblyContext_AssemblyConnector;
            requiringAssemblyContext_AssemblyConnector = (AssemblyContext)eResolveProxy(oldRequiringAssemblyContext_AssemblyConnector);
            if (requiringAssemblyContext_AssemblyConnector != oldRequiringAssemblyContext_AssemblyConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR, oldRequiringAssemblyContext_AssemblyConnector, requiringAssemblyContext_AssemblyConnector));
            }
        }
        return requiringAssemblyContext_AssemblyConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetRequiringAssemblyContext_AssemblyConnector() {
        return requiringAssemblyContext_AssemblyConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setRequiringAssemblyContext_AssemblyConnector(
            AssemblyContext newRequiringAssemblyContext_AssemblyConnector) {
        AssemblyContext oldRequiringAssemblyContext_AssemblyConnector = requiringAssemblyContext_AssemblyConnector;
        requiringAssemblyContext_AssemblyConnector = newRequiringAssemblyContext_AssemblyConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR, oldRequiringAssemblyContext_AssemblyConnector, requiringAssemblyContext_AssemblyConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getProvidingAssemblyContext_AssemblyConnector() {
        if (providingAssemblyContext_AssemblyConnector != null && ((EObject)providingAssemblyContext_AssemblyConnector).eIsProxy()) {
            InternalEObject oldProvidingAssemblyContext_AssemblyConnector = (InternalEObject)providingAssemblyContext_AssemblyConnector;
            providingAssemblyContext_AssemblyConnector = (AssemblyContext)eResolveProxy(oldProvidingAssemblyContext_AssemblyConnector);
            if (providingAssemblyContext_AssemblyConnector != oldProvidingAssemblyContext_AssemblyConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR, oldProvidingAssemblyContext_AssemblyConnector, providingAssemblyContext_AssemblyConnector));
            }
        }
        return providingAssemblyContext_AssemblyConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetProvidingAssemblyContext_AssemblyConnector() {
        return providingAssemblyContext_AssemblyConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setProvidingAssemblyContext_AssemblyConnector(
            AssemblyContext newProvidingAssemblyContext_AssemblyConnector) {
        AssemblyContext oldProvidingAssemblyContext_AssemblyConnector = providingAssemblyContext_AssemblyConnector;
        providingAssemblyContext_AssemblyConnector = newProvidingAssemblyContext_AssemblyConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR, oldProvidingAssemblyContext_AssemblyConnector, providingAssemblyContext_AssemblyConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public OperationProvidedRole getProvidedRole_AssemblyConnector() {
        if (providedRole_AssemblyConnector != null && ((EObject)providedRole_AssemblyConnector).eIsProxy()) {
            InternalEObject oldProvidedRole_AssemblyConnector = (InternalEObject)providedRole_AssemblyConnector;
            providedRole_AssemblyConnector = (OperationProvidedRole)eResolveProxy(oldProvidedRole_AssemblyConnector);
            if (providedRole_AssemblyConnector != oldProvidedRole_AssemblyConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR, oldProvidedRole_AssemblyConnector, providedRole_AssemblyConnector));
            }
        }
        return providedRole_AssemblyConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public OperationProvidedRole basicGetProvidedRole_AssemblyConnector() {
        return providedRole_AssemblyConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setProvidedRole_AssemblyConnector(OperationProvidedRole newProvidedRole_AssemblyConnector) {
        OperationProvidedRole oldProvidedRole_AssemblyConnector = providedRole_AssemblyConnector;
        providedRole_AssemblyConnector = newProvidedRole_AssemblyConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR, oldProvidedRole_AssemblyConnector, providedRole_AssemblyConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public OperationRequiredRole getRequiredRole_AssemblyConnector() {
        if (requiredRole_AssemblyConnector != null && ((EObject)requiredRole_AssemblyConnector).eIsProxy()) {
            InternalEObject oldRequiredRole_AssemblyConnector = (InternalEObject)requiredRole_AssemblyConnector;
            requiredRole_AssemblyConnector = (OperationRequiredRole)eResolveProxy(oldRequiredRole_AssemblyConnector);
            if (requiredRole_AssemblyConnector != oldRequiredRole_AssemblyConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR, oldRequiredRole_AssemblyConnector, requiredRole_AssemblyConnector));
            }
        }
        return requiredRole_AssemblyConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public OperationRequiredRole basicGetRequiredRole_AssemblyConnector() {
        return requiredRole_AssemblyConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setRequiredRole_AssemblyConnector(OperationRequiredRole newRequiredRole_AssemblyConnector) {
        OperationRequiredRole oldRequiredRole_AssemblyConnector = requiredRole_AssemblyConnector;
        requiredRole_AssemblyConnector = newRequiredRole_AssemblyConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR, oldRequiredRole_AssemblyConnector, requiredRole_AssemblyConnector));
    }

    /**
     * The cached OCL expression body for the '{@link #AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Assembly Connectors Referenced Provided Roles And Child Context Must Match</em>}' operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String ASSEMBLY_CONNECTORS_REFERENCED_PROVIDED_ROLES_AND_CHILD_CONTEXT_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.providingAssemblyContext_AssemblyConnector.encapsulatedComponent__AssemblyContext.providedRoles_InterfaceProvidingEntity->includes(self.providedRole_AssemblyConnector)\n"+"\n"+"";

    /**
     * The cached OCL invariant for the '{@link #AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Assembly Connectors Referenced Provided Roles And Child Context Must Match</em>}' invariant operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint ASSEMBLY_CONNECTORS_REFERENCED_PROVIDED_ROLES_AND_CHILD_CONTEXT_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (ASSEMBLY_CONNECTORS_REFERENCED_PROVIDED_ROLES_AND_CHILD_CONTEXT_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(CompositionPackage.Literals.ASSEMBLY_CONNECTOR);
            try {
                ASSEMBLY_CONNECTORS_REFERENCED_PROVIDED_ROLES_AND_CHILD_CONTEXT_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ASSEMBLY_CONNECTORS_REFERENCED_PROVIDED_ROLES_AND_CHILD_CONTEXT_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            }
            catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(ASSEMBLY_CONNECTORS_REFERENCED_PROVIDED_ROLES_AND_CHILD_CONTEXT_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         CompositionValidator.DIAGNOSTIC_SOURCE,
                         CompositionValidator.ASSEMBLY_CONNECTOR__ASSEMBLY_CONNECTORS_REFERENCED_PROVIDED_ROLES_AND_CHILD_CONTEXT_MUST_MATCH,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '{@link #AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Assembly Connectors Referenced Required Role And Child Context Must Match</em>}' operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String ASSEMBLY_CONNECTORS_REFERENCED_REQUIRED_ROLE_AND_CHILD_CONTEXT_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.requiringAssemblyContext_AssemblyConnector.encapsulatedComponent__AssemblyContext.requiredRoles_InterfaceRequiringEntity->includes(self.requiredRole_AssemblyConnector)\n"+"\n"+"";

    /**
     * The cached OCL invariant for the '{@link #AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Assembly Connectors Referenced Required Role And Child Context Must Match</em>}' invariant operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint ASSEMBLY_CONNECTORS_REFERENCED_REQUIRED_ROLE_AND_CHILD_CONTEXT_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (ASSEMBLY_CONNECTORS_REFERENCED_REQUIRED_ROLE_AND_CHILD_CONTEXT_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(CompositionPackage.Literals.ASSEMBLY_CONNECTOR);
            try {
                ASSEMBLY_CONNECTORS_REFERENCED_REQUIRED_ROLE_AND_CHILD_CONTEXT_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ASSEMBLY_CONNECTORS_REFERENCED_REQUIRED_ROLE_AND_CHILD_CONTEXT_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            }
            catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(ASSEMBLY_CONNECTORS_REFERENCED_REQUIRED_ROLE_AND_CHILD_CONTEXT_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         CompositionValidator.DIAGNOSTIC_SOURCE,
                         CompositionValidator.ASSEMBLY_CONNECTOR__ASSEMBLY_CONNECTORS_REFERENCED_REQUIRED_ROLE_AND_CHILD_CONTEXT_MUST_MATCH,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #AssemblyConnectorsReferencedInterfacesMustMatch(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Assembly Connectors Referenced Interfaces Must Match</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #AssemblyConnectorsReferencedInterfacesMustMatch(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String ASSEMBLY_CONNECTORS_REFERENCED_INTERFACES_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.providedRole_AssemblyConnector.providedInterface__OperationProvidedRole = self.requiredRole_AssemblyConnector.requiredInterface__OperationRequiredRole";

    /**
     * The cached OCL invariant for the '
     * {@link #AssemblyConnectorsReferencedInterfacesMustMatch(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Assembly Connectors Referenced Interfaces Must Match</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #AssemblyConnectorsReferencedInterfacesMustMatch(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint ASSEMBLY_CONNECTORS_REFERENCED_INTERFACES_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean AssemblyConnectorsReferencedInterfacesMustMatch(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (ASSEMBLY_CONNECTORS_REFERENCED_INTERFACES_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(CompositionPackage.Literals.ASSEMBLY_CONNECTOR);
            try {
                ASSEMBLY_CONNECTORS_REFERENCED_INTERFACES_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ASSEMBLY_CONNECTORS_REFERENCED_INTERFACES_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            }
            catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(ASSEMBLY_CONNECTORS_REFERENCED_INTERFACES_MUST_MATCH__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         CompositionValidator.DIAGNOSTIC_SOURCE,
                         CompositionValidator.ASSEMBLY_CONNECTOR__ASSEMBLY_CONNECTORS_REFERENCED_INTERFACES_MUST_MATCH,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AssemblyConnectorsReferencedInterfacesMustMatch", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
                if (resolve) return getRequiringAssemblyContext_AssemblyConnector();
                return basicGetRequiringAssemblyContext_AssemblyConnector();
            case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
                if (resolve) return getProvidingAssemblyContext_AssemblyConnector();
                return basicGetProvidingAssemblyContext_AssemblyConnector();
            case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR:
                if (resolve) return getProvidedRole_AssemblyConnector();
                return basicGetProvidedRole_AssemblyConnector();
            case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR:
                if (resolve) return getRequiredRole_AssemblyConnector();
                return basicGetRequiredRole_AssemblyConnector();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
                setRequiringAssemblyContext_AssemblyConnector((AssemblyContext)newValue);
                return;
            case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
                setProvidingAssemblyContext_AssemblyConnector((AssemblyContext)newValue);
                return;
            case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR:
                setProvidedRole_AssemblyConnector((OperationProvidedRole)newValue);
                return;
            case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR:
                setRequiredRole_AssemblyConnector((OperationRequiredRole)newValue);
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
            case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
                setRequiringAssemblyContext_AssemblyConnector((AssemblyContext)null);
                return;
            case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
                setProvidingAssemblyContext_AssemblyConnector((AssemblyContext)null);
                return;
            case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR:
                setProvidedRole_AssemblyConnector((OperationProvidedRole)null);
                return;
            case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR:
                setRequiredRole_AssemblyConnector((OperationRequiredRole)null);
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
            case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
                return requiringAssemblyContext_AssemblyConnector != null;
            case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
                return providingAssemblyContext_AssemblyConnector != null;
            case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR:
                return providedRole_AssemblyConnector != null;
            case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR:
                return requiredRole_AssemblyConnector != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * The cached environment for evaluating OCL expressions.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // AssemblyConnectorImpl
