/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.RequiredDelegationConnector;
import org.palladiosimulator.pcm.core.composition.util.CompositionValidator;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Required Delegation Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.core.composition.impl.RequiredDelegationConnectorImpl#getInnerRequiredRole_RequiredDelegationConnector
 * <em>Inner Required Role Required Delegation Connector</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.core.composition.impl.RequiredDelegationConnectorImpl#getOuterRequiredRole_RequiredDelegationConnector
 * <em>Outer Required Role Required Delegation Connector</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.core.composition.impl.RequiredDelegationConnectorImpl#getAssemblyContext_RequiredDelegationConnector
 * <em>Assembly Context Required Delegation Connector</em>}</li>
 * </ul>
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
        return (OperationRequiredRole) this.eDynamicGet(
                CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationRequiredRole basicGetInnerRequiredRole_RequiredDelegationConnector() {
        return (OperationRequiredRole) this.eDynamicGet(
                CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInnerRequiredRole_RequiredDelegationConnector(
            final OperationRequiredRole newInnerRequiredRole_RequiredDelegationConnector) {
        this.eDynamicSet(
                CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                newInnerRequiredRole_RequiredDelegationConnector);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationRequiredRole getOuterRequiredRole_RequiredDelegationConnector() {
        return (OperationRequiredRole) this.eDynamicGet(
                CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationRequiredRole basicGetOuterRequiredRole_RequiredDelegationConnector() {
        return (OperationRequiredRole) this.eDynamicGet(
                CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOuterRequiredRole_RequiredDelegationConnector(
            final OperationRequiredRole newOuterRequiredRole_RequiredDelegationConnector) {
        this.eDynamicSet(
                CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR,
                newOuterRequiredRole_RequiredDelegationConnector);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext_RequiredDelegationConnector() {
        return (AssemblyContext) this.eDynamicGet(
                CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext_RequiredDelegationConnector() {
        return (AssemblyContext) this.eDynamicGet(
                CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR,
                false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAssemblyContext_RequiredDelegationConnector(
            final AssemblyContext newAssemblyContext_RequiredDelegationConnector) {
        this.eDynamicSet(
                CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR,
                CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR,
                newAssemblyContext_RequiredDelegationConnector);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, CompositionValidator.DIAGNOSTIC_SOURCE,
                        CompositionValidator.REQUIRED_DELEGATION_CONNECTOR__REQUIRED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, CompositionValidator.DIAGNOSTIC_SOURCE,
                        CompositionValidator.REQUIRED_DELEGATION_CONNECTOR__COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_REQUIRING_COMPONENT_NEED_TO_BE_THE_SAME,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                new Object[] {
                                        "ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame",
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
    public boolean RequiringEntityOfOuterRequiredRoleMustBeTheSameAsTheParentOfTheRequiredDelegationConnector(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, CompositionValidator.DIAGNOSTIC_SOURCE,
                        CompositionValidator.REQUIRED_DELEGATION_CONNECTOR__REQUIRING_ENTITY_OF_OUTER_REQUIRED_ROLE_MUST_BE_THE_SAME_AS_THE_PARENT_OF_THE_REQUIRED_DELEGATION_CONNECTOR,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
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
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getInnerRequiredRole_RequiredDelegationConnector();
            }
            return this.basicGetInnerRequiredRole_RequiredDelegationConnector();
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getOuterRequiredRole_RequiredDelegationConnector();
            }
            return this.basicGetOuterRequiredRole_RequiredDelegationConnector();
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getAssemblyContext_RequiredDelegationConnector();
            }
            return this.basicGetAssemblyContext_RequiredDelegationConnector();
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
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            this.setInnerRequiredRole_RequiredDelegationConnector((OperationRequiredRole) newValue);
            return;
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            this.setOuterRequiredRole_RequiredDelegationConnector((OperationRequiredRole) newValue);
            return;
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
            this.setAssemblyContext_RequiredDelegationConnector((AssemblyContext) newValue);
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
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            this.setInnerRequiredRole_RequiredDelegationConnector((OperationRequiredRole) null);
            return;
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            this.setOuterRequiredRole_RequiredDelegationConnector((OperationRequiredRole) null);
            return;
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
            this.setAssemblyContext_RequiredDelegationConnector((AssemblyContext) null);
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
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            return this.basicGetInnerRequiredRole_RequiredDelegationConnector() != null;
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
            return this.basicGetOuterRequiredRole_RequiredDelegationConnector() != null;
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
            return this.basicGetAssemblyContext_RequiredDelegationConnector() != null;
        }
        return super.eIsSet(featureID);
    }

} // RequiredDelegationConnectorImpl
