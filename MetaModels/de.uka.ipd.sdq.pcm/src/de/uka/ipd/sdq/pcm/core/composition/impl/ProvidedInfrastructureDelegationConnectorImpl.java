/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedInfrastructureDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Provided Infrastructure Delegation Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedInfrastructureDelegationConnectorImpl#getInnerProvidedRole__ProvidedInfrastructureDelegationConnector <em>Inner Provided Role Provided Infrastructure Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedInfrastructureDelegationConnectorImpl#getOuterProvidedRole__ProvidedInfrastructureDelegationConnector <em>Outer Provided Role Provided Infrastructure Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedInfrastructureDelegationConnectorImpl#getAssemblyContext__ProvidedInfrastructureDelegationConnector <em>Assembly Context Provided Infrastructure Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProvidedInfrastructureDelegationConnectorImpl extends DelegationConnectorImpl implements
        ProvidedInfrastructureDelegationConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '
     * {@link #getInnerProvidedRole__ProvidedInfrastructureDelegationConnector()
     * <em>Inner Provided Role Provided Infrastructure Delegation Connector</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getInnerProvidedRole__ProvidedInfrastructureDelegationConnector()
     * @generated
     * @ordered
     */
    protected InfrastructureProvidedRole innerProvidedRole__ProvidedInfrastructureDelegationConnector;

    /**
     * The cached value of the '
     * {@link #getOuterProvidedRole__ProvidedInfrastructureDelegationConnector()
     * <em>Outer Provided Role Provided Infrastructure Delegation Connector</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOuterProvidedRole__ProvidedInfrastructureDelegationConnector()
     * @generated
     * @ordered
     */
    protected InfrastructureProvidedRole outerProvidedRole__ProvidedInfrastructureDelegationConnector;

    /**
     * The cached value of the '
     * {@link #getAssemblyContext__ProvidedInfrastructureDelegationConnector()
     * <em>Assembly Context Provided Infrastructure Delegation Connector</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getAssemblyContext__ProvidedInfrastructureDelegationConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext__ProvidedInfrastructureDelegationConnector;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ProvidedInfrastructureDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureProvidedRole getInnerProvidedRole__ProvidedInfrastructureDelegationConnector() {
        if (innerProvidedRole__ProvidedInfrastructureDelegationConnector != null && innerProvidedRole__ProvidedInfrastructureDelegationConnector.eIsProxy()) {
            InternalEObject oldInnerProvidedRole__ProvidedInfrastructureDelegationConnector = (InternalEObject)innerProvidedRole__ProvidedInfrastructureDelegationConnector;
            innerProvidedRole__ProvidedInfrastructureDelegationConnector = (InfrastructureProvidedRole)eResolveProxy(oldInnerProvidedRole__ProvidedInfrastructureDelegationConnector);
            if (innerProvidedRole__ProvidedInfrastructureDelegationConnector != oldInnerProvidedRole__ProvidedInfrastructureDelegationConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR, oldInnerProvidedRole__ProvidedInfrastructureDelegationConnector, innerProvidedRole__ProvidedInfrastructureDelegationConnector));
            }
        }
        return innerProvidedRole__ProvidedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureProvidedRole basicGetInnerProvidedRole__ProvidedInfrastructureDelegationConnector() {
        return innerProvidedRole__ProvidedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setInnerProvidedRole__ProvidedInfrastructureDelegationConnector(
            InfrastructureProvidedRole newInnerProvidedRole__ProvidedInfrastructureDelegationConnector) {
        InfrastructureProvidedRole oldInnerProvidedRole__ProvidedInfrastructureDelegationConnector = innerProvidedRole__ProvidedInfrastructureDelegationConnector;
        innerProvidedRole__ProvidedInfrastructureDelegationConnector = newInnerProvidedRole__ProvidedInfrastructureDelegationConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR, oldInnerProvidedRole__ProvidedInfrastructureDelegationConnector, innerProvidedRole__ProvidedInfrastructureDelegationConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureProvidedRole getOuterProvidedRole__ProvidedInfrastructureDelegationConnector() {
        if (outerProvidedRole__ProvidedInfrastructureDelegationConnector != null && outerProvidedRole__ProvidedInfrastructureDelegationConnector.eIsProxy()) {
            InternalEObject oldOuterProvidedRole__ProvidedInfrastructureDelegationConnector = (InternalEObject)outerProvidedRole__ProvidedInfrastructureDelegationConnector;
            outerProvidedRole__ProvidedInfrastructureDelegationConnector = (InfrastructureProvidedRole)eResolveProxy(oldOuterProvidedRole__ProvidedInfrastructureDelegationConnector);
            if (outerProvidedRole__ProvidedInfrastructureDelegationConnector != oldOuterProvidedRole__ProvidedInfrastructureDelegationConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR, oldOuterProvidedRole__ProvidedInfrastructureDelegationConnector, outerProvidedRole__ProvidedInfrastructureDelegationConnector));
            }
        }
        return outerProvidedRole__ProvidedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureProvidedRole basicGetOuterProvidedRole__ProvidedInfrastructureDelegationConnector() {
        return outerProvidedRole__ProvidedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setOuterProvidedRole__ProvidedInfrastructureDelegationConnector(
            InfrastructureProvidedRole newOuterProvidedRole__ProvidedInfrastructureDelegationConnector) {
        InfrastructureProvidedRole oldOuterProvidedRole__ProvidedInfrastructureDelegationConnector = outerProvidedRole__ProvidedInfrastructureDelegationConnector;
        outerProvidedRole__ProvidedInfrastructureDelegationConnector = newOuterProvidedRole__ProvidedInfrastructureDelegationConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR, oldOuterProvidedRole__ProvidedInfrastructureDelegationConnector, outerProvidedRole__ProvidedInfrastructureDelegationConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getAssemblyContext__ProvidedInfrastructureDelegationConnector() {
        if (assemblyContext__ProvidedInfrastructureDelegationConnector != null && assemblyContext__ProvidedInfrastructureDelegationConnector.eIsProxy()) {
            InternalEObject oldAssemblyContext__ProvidedInfrastructureDelegationConnector = (InternalEObject)assemblyContext__ProvidedInfrastructureDelegationConnector;
            assemblyContext__ProvidedInfrastructureDelegationConnector = (AssemblyContext)eResolveProxy(oldAssemblyContext__ProvidedInfrastructureDelegationConnector);
            if (assemblyContext__ProvidedInfrastructureDelegationConnector != oldAssemblyContext__ProvidedInfrastructureDelegationConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR, oldAssemblyContext__ProvidedInfrastructureDelegationConnector, assemblyContext__ProvidedInfrastructureDelegationConnector));
            }
        }
        return assemblyContext__ProvidedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__ProvidedInfrastructureDelegationConnector() {
        return assemblyContext__ProvidedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setAssemblyContext__ProvidedInfrastructureDelegationConnector(
            AssemblyContext newAssemblyContext__ProvidedInfrastructureDelegationConnector) {
        AssemblyContext oldAssemblyContext__ProvidedInfrastructureDelegationConnector = assemblyContext__ProvidedInfrastructureDelegationConnector;
        assemblyContext__ProvidedInfrastructureDelegationConnector = newAssemblyContext__ProvidedInfrastructureDelegationConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR, oldAssemblyContext__ProvidedInfrastructureDelegationConnector, assemblyContext__ProvidedInfrastructureDelegationConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
                if (resolve) return getInnerProvidedRole__ProvidedInfrastructureDelegationConnector();
                return basicGetInnerProvidedRole__ProvidedInfrastructureDelegationConnector();
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
                if (resolve) return getOuterProvidedRole__ProvidedInfrastructureDelegationConnector();
                return basicGetOuterProvidedRole__ProvidedInfrastructureDelegationConnector();
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
                if (resolve) return getAssemblyContext__ProvidedInfrastructureDelegationConnector();
                return basicGetAssemblyContext__ProvidedInfrastructureDelegationConnector();
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
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
                setInnerProvidedRole__ProvidedInfrastructureDelegationConnector((InfrastructureProvidedRole)newValue);
                return;
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
                setOuterProvidedRole__ProvidedInfrastructureDelegationConnector((InfrastructureProvidedRole)newValue);
                return;
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
                setAssemblyContext__ProvidedInfrastructureDelegationConnector((AssemblyContext)newValue);
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
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
                setInnerProvidedRole__ProvidedInfrastructureDelegationConnector((InfrastructureProvidedRole)null);
                return;
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
                setOuterProvidedRole__ProvidedInfrastructureDelegationConnector((InfrastructureProvidedRole)null);
                return;
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
                setAssemblyContext__ProvidedInfrastructureDelegationConnector((AssemblyContext)null);
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
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
                return innerProvidedRole__ProvidedInfrastructureDelegationConnector != null;
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
                return outerProvidedRole__ProvidedInfrastructureDelegationConnector != null;
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
                return assemblyContext__ProvidedInfrastructureDelegationConnector != null;
        }
        return super.eIsSet(featureID);
    }

} // ProvidedInfrastructureDelegationConnectorImpl
