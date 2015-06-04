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
import de.uka.ipd.sdq.pcm.core.composition.RequiredInfrastructureDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Required Infrastructure Delegation Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredInfrastructureDelegationConnectorImpl#getInnerRequiredRole__RequiredInfrastructureDelegationConnector
 * <em>Inner Required Role Required Infrastructure Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredInfrastructureDelegationConnectorImpl#getOuterRequiredRole__RequiredInfrastructureDelegationConnector
 * <em>Outer Required Role Required Infrastructure Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredInfrastructureDelegationConnectorImpl#getAssemblyContext__RequiredInfrastructureDelegationConnector
 * <em>Assembly Context Required Infrastructure Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequiredInfrastructureDelegationConnectorImpl extends DelegationConnectorImpl implements
RequiredInfrastructureDelegationConnector {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '
     * {@link #getInnerRequiredRole__RequiredInfrastructureDelegationConnector()
     * <em>Inner Required Role Required Infrastructure Delegation Connector</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getInnerRequiredRole__RequiredInfrastructureDelegationConnector()
     * @generated
     * @ordered
     */
    protected InfrastructureRequiredRole innerRequiredRole__RequiredInfrastructureDelegationConnector;
    /**
     * The cached value of the '
     * {@link #getOuterRequiredRole__RequiredInfrastructureDelegationConnector()
     * <em>Outer Required Role Required Infrastructure Delegation Connector</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOuterRequiredRole__RequiredInfrastructureDelegationConnector()
     * @generated
     * @ordered
     */
    protected InfrastructureRequiredRole outerRequiredRole__RequiredInfrastructureDelegationConnector;
    /**
     * The cached value of the '
     * {@link #getAssemblyContext__RequiredInfrastructureDelegationConnector()
     * <em>Assembly Context Required Infrastructure Delegation Connector</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAssemblyContext__RequiredInfrastructureDelegationConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext__RequiredInfrastructureDelegationConnector;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RequiredInfrastructureDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InfrastructureRequiredRole getInnerRequiredRole__RequiredInfrastructureDelegationConnector() {
        if (this.innerRequiredRole__RequiredInfrastructureDelegationConnector != null
                && this.innerRequiredRole__RequiredInfrastructureDelegationConnector.eIsProxy()) {
            final InternalEObject oldInnerRequiredRole__RequiredInfrastructureDelegationConnector = (InternalEObject) this.innerRequiredRole__RequiredInfrastructureDelegationConnector;
            this.innerRequiredRole__RequiredInfrastructureDelegationConnector = (InfrastructureRequiredRole) this
                    .eResolveProxy(oldInnerRequiredRole__RequiredInfrastructureDelegationConnector);
            if (this.innerRequiredRole__RequiredInfrastructureDelegationConnector != oldInnerRequiredRole__RequiredInfrastructureDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                            oldInnerRequiredRole__RequiredInfrastructureDelegationConnector,
                            this.innerRequiredRole__RequiredInfrastructureDelegationConnector));
                }
            }
        }
        return this.innerRequiredRole__RequiredInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public InfrastructureRequiredRole basicGetInnerRequiredRole__RequiredInfrastructureDelegationConnector() {
        return this.innerRequiredRole__RequiredInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInnerRequiredRole__RequiredInfrastructureDelegationConnector(
            final InfrastructureRequiredRole newInnerRequiredRole__RequiredInfrastructureDelegationConnector) {
        final InfrastructureRequiredRole oldInnerRequiredRole__RequiredInfrastructureDelegationConnector = this.innerRequiredRole__RequiredInfrastructureDelegationConnector;
        this.innerRequiredRole__RequiredInfrastructureDelegationConnector = newInnerRequiredRole__RequiredInfrastructureDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                    oldInnerRequiredRole__RequiredInfrastructureDelegationConnector,
                    this.innerRequiredRole__RequiredInfrastructureDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InfrastructureRequiredRole getOuterRequiredRole__RequiredInfrastructureDelegationConnector() {
        if (this.outerRequiredRole__RequiredInfrastructureDelegationConnector != null
                && this.outerRequiredRole__RequiredInfrastructureDelegationConnector.eIsProxy()) {
            final InternalEObject oldOuterRequiredRole__RequiredInfrastructureDelegationConnector = (InternalEObject) this.outerRequiredRole__RequiredInfrastructureDelegationConnector;
            this.outerRequiredRole__RequiredInfrastructureDelegationConnector = (InfrastructureRequiredRole) this
                    .eResolveProxy(oldOuterRequiredRole__RequiredInfrastructureDelegationConnector);
            if (this.outerRequiredRole__RequiredInfrastructureDelegationConnector != oldOuterRequiredRole__RequiredInfrastructureDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                            oldOuterRequiredRole__RequiredInfrastructureDelegationConnector,
                            this.outerRequiredRole__RequiredInfrastructureDelegationConnector));
                }
            }
        }
        return this.outerRequiredRole__RequiredInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public InfrastructureRequiredRole basicGetOuterRequiredRole__RequiredInfrastructureDelegationConnector() {
        return this.outerRequiredRole__RequiredInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOuterRequiredRole__RequiredInfrastructureDelegationConnector(
            final InfrastructureRequiredRole newOuterRequiredRole__RequiredInfrastructureDelegationConnector) {
        final InfrastructureRequiredRole oldOuterRequiredRole__RequiredInfrastructureDelegationConnector = this.outerRequiredRole__RequiredInfrastructureDelegationConnector;
        this.outerRequiredRole__RequiredInfrastructureDelegationConnector = newOuterRequiredRole__RequiredInfrastructureDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                    oldOuterRequiredRole__RequiredInfrastructureDelegationConnector,
                    this.outerRequiredRole__RequiredInfrastructureDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext__RequiredInfrastructureDelegationConnector() {
        if (this.assemblyContext__RequiredInfrastructureDelegationConnector != null
                && this.assemblyContext__RequiredInfrastructureDelegationConnector.eIsProxy()) {
            final InternalEObject oldAssemblyContext__RequiredInfrastructureDelegationConnector = (InternalEObject) this.assemblyContext__RequiredInfrastructureDelegationConnector;
            this.assemblyContext__RequiredInfrastructureDelegationConnector = (AssemblyContext) this
                    .eResolveProxy(oldAssemblyContext__RequiredInfrastructureDelegationConnector);
            if (this.assemblyContext__RequiredInfrastructureDelegationConnector != oldAssemblyContext__RequiredInfrastructureDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                            oldAssemblyContext__RequiredInfrastructureDelegationConnector,
                            this.assemblyContext__RequiredInfrastructureDelegationConnector));
                }
            }
        }
        return this.assemblyContext__RequiredInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__RequiredInfrastructureDelegationConnector() {
        return this.assemblyContext__RequiredInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAssemblyContext__RequiredInfrastructureDelegationConnector(
            final AssemblyContext newAssemblyContext__RequiredInfrastructureDelegationConnector) {
        final AssemblyContext oldAssemblyContext__RequiredInfrastructureDelegationConnector = this.assemblyContext__RequiredInfrastructureDelegationConnector;
        this.assemblyContext__RequiredInfrastructureDelegationConnector = newAssemblyContext__RequiredInfrastructureDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR,
                    oldAssemblyContext__RequiredInfrastructureDelegationConnector,
                    this.assemblyContext__RequiredInfrastructureDelegationConnector));
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
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getInnerRequiredRole__RequiredInfrastructureDelegationConnector();
            }
            return this.basicGetInnerRequiredRole__RequiredInfrastructureDelegationConnector();
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getOuterRequiredRole__RequiredInfrastructureDelegationConnector();
            }
            return this.basicGetOuterRequiredRole__RequiredInfrastructureDelegationConnector();
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getAssemblyContext__RequiredInfrastructureDelegationConnector();
            }
            return this.basicGetAssemblyContext__RequiredInfrastructureDelegationConnector();
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
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            this.setInnerRequiredRole__RequiredInfrastructureDelegationConnector((InfrastructureRequiredRole) newValue);
            return;
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            this.setOuterRequiredRole__RequiredInfrastructureDelegationConnector((InfrastructureRequiredRole) newValue);
            return;
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            this.setAssemblyContext__RequiredInfrastructureDelegationConnector((AssemblyContext) newValue);
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
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            this.setInnerRequiredRole__RequiredInfrastructureDelegationConnector((InfrastructureRequiredRole) null);
            return;
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            this.setOuterRequiredRole__RequiredInfrastructureDelegationConnector((InfrastructureRequiredRole) null);
            return;
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            this.setAssemblyContext__RequiredInfrastructureDelegationConnector((AssemblyContext) null);
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
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return this.innerRequiredRole__RequiredInfrastructureDelegationConnector != null;
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return this.outerRequiredRole__RequiredInfrastructureDelegationConnector != null;
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return this.assemblyContext__RequiredInfrastructureDelegationConnector != null;
        }
        return super.eIsSet(featureID);
    }

} // RequiredInfrastructureDelegationConnectorImpl
