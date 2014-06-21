/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedInfrastructureDelegationConnectorImpl#getInnerProvidedRole__ProvidedInfrastructureDelegationConnector
 * <em>Inner Provided Role Provided Infrastructure Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedInfrastructureDelegationConnectorImpl#getOuterProvidedRole__ProvidedInfrastructureDelegationConnector
 * <em>Outer Provided Role Provided Infrastructure Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedInfrastructureDelegationConnectorImpl#getAssemblyContext__ProvidedInfrastructureDelegationConnector
 * <em>Assembly Context Provided Infrastructure Delegation Connector</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProvidedInfrastructureDelegationConnectorImpl extends DelegationConnectorImpl implements
        ProvidedInfrastructureDelegationConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '
     * {@link #getInnerProvidedRole__ProvidedInfrastructureDelegationConnector()
     * <em>Inner Provided Role Provided Infrastructure Delegation Connector</em>} ' reference. <!--
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
     * <em>Outer Provided Role Provided Infrastructure Delegation Connector</em>} ' reference. <!--
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
     * 
     * @generated
     */
    protected ProvidedInfrastructureDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructureProvidedRole getInnerProvidedRole__ProvidedInfrastructureDelegationConnector() {
        if (this.innerProvidedRole__ProvidedInfrastructureDelegationConnector != null
                && ((EObject) this.innerProvidedRole__ProvidedInfrastructureDelegationConnector).eIsProxy()) {
            final InternalEObject oldInnerProvidedRole__ProvidedInfrastructureDelegationConnector = (InternalEObject) this.innerProvidedRole__ProvidedInfrastructureDelegationConnector;
            this.innerProvidedRole__ProvidedInfrastructureDelegationConnector = (InfrastructureProvidedRole) this
                    .eResolveProxy(oldInnerProvidedRole__ProvidedInfrastructureDelegationConnector);
            if (this.innerProvidedRole__ProvidedInfrastructureDelegationConnector != oldInnerProvidedRole__ProvidedInfrastructureDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                            oldInnerProvidedRole__ProvidedInfrastructureDelegationConnector,
                            this.innerProvidedRole__ProvidedInfrastructureDelegationConnector));
                }
            }
        }
        return this.innerProvidedRole__ProvidedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InfrastructureProvidedRole basicGetInnerProvidedRole__ProvidedInfrastructureDelegationConnector() {
        return this.innerProvidedRole__ProvidedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setInnerProvidedRole__ProvidedInfrastructureDelegationConnector(
            final InfrastructureProvidedRole newInnerProvidedRole__ProvidedInfrastructureDelegationConnector) {
        final InfrastructureProvidedRole oldInnerProvidedRole__ProvidedInfrastructureDelegationConnector = this.innerProvidedRole__ProvidedInfrastructureDelegationConnector;
        this.innerProvidedRole__ProvidedInfrastructureDelegationConnector = newInnerProvidedRole__ProvidedInfrastructureDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                    oldInnerProvidedRole__ProvidedInfrastructureDelegationConnector,
                    this.innerProvidedRole__ProvidedInfrastructureDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructureProvidedRole getOuterProvidedRole__ProvidedInfrastructureDelegationConnector() {
        if (this.outerProvidedRole__ProvidedInfrastructureDelegationConnector != null
                && ((EObject) this.outerProvidedRole__ProvidedInfrastructureDelegationConnector).eIsProxy()) {
            final InternalEObject oldOuterProvidedRole__ProvidedInfrastructureDelegationConnector = (InternalEObject) this.outerProvidedRole__ProvidedInfrastructureDelegationConnector;
            this.outerProvidedRole__ProvidedInfrastructureDelegationConnector = (InfrastructureProvidedRole) this
                    .eResolveProxy(oldOuterProvidedRole__ProvidedInfrastructureDelegationConnector);
            if (this.outerProvidedRole__ProvidedInfrastructureDelegationConnector != oldOuterProvidedRole__ProvidedInfrastructureDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                            oldOuterProvidedRole__ProvidedInfrastructureDelegationConnector,
                            this.outerProvidedRole__ProvidedInfrastructureDelegationConnector));
                }
            }
        }
        return this.outerProvidedRole__ProvidedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InfrastructureProvidedRole basicGetOuterProvidedRole__ProvidedInfrastructureDelegationConnector() {
        return this.outerProvidedRole__ProvidedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOuterProvidedRole__ProvidedInfrastructureDelegationConnector(
            final InfrastructureProvidedRole newOuterProvidedRole__ProvidedInfrastructureDelegationConnector) {
        final InfrastructureProvidedRole oldOuterProvidedRole__ProvidedInfrastructureDelegationConnector = this.outerProvidedRole__ProvidedInfrastructureDelegationConnector;
        this.outerProvidedRole__ProvidedInfrastructureDelegationConnector = newOuterProvidedRole__ProvidedInfrastructureDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                    oldOuterProvidedRole__ProvidedInfrastructureDelegationConnector,
                    this.outerProvidedRole__ProvidedInfrastructureDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext__ProvidedInfrastructureDelegationConnector() {
        if (this.assemblyContext__ProvidedInfrastructureDelegationConnector != null
                && ((EObject) this.assemblyContext__ProvidedInfrastructureDelegationConnector).eIsProxy()) {
            final InternalEObject oldAssemblyContext__ProvidedInfrastructureDelegationConnector = (InternalEObject) this.assemblyContext__ProvidedInfrastructureDelegationConnector;
            this.assemblyContext__ProvidedInfrastructureDelegationConnector = (AssemblyContext) this
                    .eResolveProxy(oldAssemblyContext__ProvidedInfrastructureDelegationConnector);
            if (this.assemblyContext__ProvidedInfrastructureDelegationConnector != oldAssemblyContext__ProvidedInfrastructureDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                            oldAssemblyContext__ProvidedInfrastructureDelegationConnector,
                            this.assemblyContext__ProvidedInfrastructureDelegationConnector));
                }
            }
        }
        return this.assemblyContext__ProvidedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__ProvidedInfrastructureDelegationConnector() {
        return this.assemblyContext__ProvidedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAssemblyContext__ProvidedInfrastructureDelegationConnector(
            final AssemblyContext newAssemblyContext__ProvidedInfrastructureDelegationConnector) {
        final AssemblyContext oldAssemblyContext__ProvidedInfrastructureDelegationConnector = this.assemblyContext__ProvidedInfrastructureDelegationConnector;
        this.assemblyContext__ProvidedInfrastructureDelegationConnector = newAssemblyContext__ProvidedInfrastructureDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                    oldAssemblyContext__ProvidedInfrastructureDelegationConnector,
                    this.assemblyContext__ProvidedInfrastructureDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getInnerProvidedRole__ProvidedInfrastructureDelegationConnector();
            }
            return this.basicGetInnerProvidedRole__ProvidedInfrastructureDelegationConnector();
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getOuterProvidedRole__ProvidedInfrastructureDelegationConnector();
            }
            return this.basicGetOuterProvidedRole__ProvidedInfrastructureDelegationConnector();
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getAssemblyContext__ProvidedInfrastructureDelegationConnector();
            }
            return this.basicGetAssemblyContext__ProvidedInfrastructureDelegationConnector();
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
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            this.setInnerProvidedRole__ProvidedInfrastructureDelegationConnector((InfrastructureProvidedRole) newValue);
            return;
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            this.setOuterProvidedRole__ProvidedInfrastructureDelegationConnector((InfrastructureProvidedRole) newValue);
            return;
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            this.setAssemblyContext__ProvidedInfrastructureDelegationConnector((AssemblyContext) newValue);
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
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            this.setInnerProvidedRole__ProvidedInfrastructureDelegationConnector((InfrastructureProvidedRole) null);
            return;
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            this.setOuterProvidedRole__ProvidedInfrastructureDelegationConnector((InfrastructureProvidedRole) null);
            return;
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            this.setAssemblyContext__ProvidedInfrastructureDelegationConnector((AssemblyContext) null);
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
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return this.innerProvidedRole__ProvidedInfrastructureDelegationConnector != null;
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return this.outerProvidedRole__ProvidedInfrastructureDelegationConnector != null;
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return this.assemblyContext__ProvidedInfrastructureDelegationConnector != null;
        }
        return super.eIsSet(featureID);
    }

} // ProvidedInfrastructureDelegationConnectorImpl
