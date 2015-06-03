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
import de.uka.ipd.sdq.pcm.core.composition.RequiredResourceDelegationConnector;
import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Required Resource Delegation Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredResourceDelegationConnectorImpl#getAssemblyContext__RequiredResourceDelegationConnector
 * <em>Assembly Context Required Resource Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredResourceDelegationConnectorImpl#getInnerRequiredRole__RequiredResourceDelegationConnector
 * <em>Inner Required Role Required Resource Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredResourceDelegationConnectorImpl#getOuterRequiredRole__RequiredResourceDelegationConnector
 * <em>Outer Required Role Required Resource Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequiredResourceDelegationConnectorImpl extends DelegationConnectorImpl implements
RequiredResourceDelegationConnector {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getAssemblyContext__RequiredResourceDelegationConnector()
     * <em>Assembly Context Required Resource Delegation Connector</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAssemblyContext__RequiredResourceDelegationConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext__RequiredResourceDelegationConnector;
    /**
     * The cached value of the '{@link #getInnerRequiredRole__RequiredResourceDelegationConnector()
     * <em>Inner Required Role Required Resource Delegation Connector</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getInnerRequiredRole__RequiredResourceDelegationConnector()
     * @generated
     * @ordered
     */
    protected ResourceRequiredRole innerRequiredRole__RequiredResourceDelegationConnector;
    /**
     * The cached value of the '{@link #getOuterRequiredRole__RequiredResourceDelegationConnector()
     * <em>Outer Required Role Required Resource Delegation Connector</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOuterRequiredRole__RequiredResourceDelegationConnector()
     * @generated
     * @ordered
     */
    protected ResourceRequiredRole outerRequiredRole__RequiredResourceDelegationConnector;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RequiredResourceDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.REQUIRED_RESOURCE_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext__RequiredResourceDelegationConnector() {
        if (this.assemblyContext__RequiredResourceDelegationConnector != null
                && this.assemblyContext__RequiredResourceDelegationConnector.eIsProxy()) {
            final InternalEObject oldAssemblyContext__RequiredResourceDelegationConnector = (InternalEObject) this.assemblyContext__RequiredResourceDelegationConnector;
            this.assemblyContext__RequiredResourceDelegationConnector = (AssemblyContext) this
                    .eResolveProxy(oldAssemblyContext__RequiredResourceDelegationConnector);
            if (this.assemblyContext__RequiredResourceDelegationConnector != oldAssemblyContext__RequiredResourceDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_RESOURCE_DELEGATION_CONNECTOR,
                            oldAssemblyContext__RequiredResourceDelegationConnector,
                            this.assemblyContext__RequiredResourceDelegationConnector));
                }
            }
        }
        return this.assemblyContext__RequiredResourceDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__RequiredResourceDelegationConnector() {
        return this.assemblyContext__RequiredResourceDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAssemblyContext__RequiredResourceDelegationConnector(
            final AssemblyContext newAssemblyContext__RequiredResourceDelegationConnector) {
        final AssemblyContext oldAssemblyContext__RequiredResourceDelegationConnector = this.assemblyContext__RequiredResourceDelegationConnector;
        this.assemblyContext__RequiredResourceDelegationConnector = newAssemblyContext__RequiredResourceDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_RESOURCE_DELEGATION_CONNECTOR,
                    oldAssemblyContext__RequiredResourceDelegationConnector,
                    this.assemblyContext__RequiredResourceDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceRequiredRole getInnerRequiredRole__RequiredResourceDelegationConnector() {
        if (this.innerRequiredRole__RequiredResourceDelegationConnector != null
                && this.innerRequiredRole__RequiredResourceDelegationConnector.eIsProxy()) {
            final InternalEObject oldInnerRequiredRole__RequiredResourceDelegationConnector = (InternalEObject) this.innerRequiredRole__RequiredResourceDelegationConnector;
            this.innerRequiredRole__RequiredResourceDelegationConnector = (ResourceRequiredRole) this
                    .eResolveProxy(oldInnerRequiredRole__RequiredResourceDelegationConnector);
            if (this.innerRequiredRole__RequiredResourceDelegationConnector != oldInnerRequiredRole__RequiredResourceDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR,
                            oldInnerRequiredRole__RequiredResourceDelegationConnector,
                            this.innerRequiredRole__RequiredResourceDelegationConnector));
                }
            }
        }
        return this.innerRequiredRole__RequiredResourceDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceRequiredRole basicGetInnerRequiredRole__RequiredResourceDelegationConnector() {
        return this.innerRequiredRole__RequiredResourceDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInnerRequiredRole__RequiredResourceDelegationConnector(
            final ResourceRequiredRole newInnerRequiredRole__RequiredResourceDelegationConnector) {
        final ResourceRequiredRole oldInnerRequiredRole__RequiredResourceDelegationConnector = this.innerRequiredRole__RequiredResourceDelegationConnector;
        this.innerRequiredRole__RequiredResourceDelegationConnector = newInnerRequiredRole__RequiredResourceDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR,
                    oldInnerRequiredRole__RequiredResourceDelegationConnector,
                    this.innerRequiredRole__RequiredResourceDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceRequiredRole getOuterRequiredRole__RequiredResourceDelegationConnector() {
        if (this.outerRequiredRole__RequiredResourceDelegationConnector != null
                && this.outerRequiredRole__RequiredResourceDelegationConnector.eIsProxy()) {
            final InternalEObject oldOuterRequiredRole__RequiredResourceDelegationConnector = (InternalEObject) this.outerRequiredRole__RequiredResourceDelegationConnector;
            this.outerRequiredRole__RequiredResourceDelegationConnector = (ResourceRequiredRole) this
                    .eResolveProxy(oldOuterRequiredRole__RequiredResourceDelegationConnector);
            if (this.outerRequiredRole__RequiredResourceDelegationConnector != oldOuterRequiredRole__RequiredResourceDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR,
                            oldOuterRequiredRole__RequiredResourceDelegationConnector,
                            this.outerRequiredRole__RequiredResourceDelegationConnector));
                }
            }
        }
        return this.outerRequiredRole__RequiredResourceDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceRequiredRole basicGetOuterRequiredRole__RequiredResourceDelegationConnector() {
        return this.outerRequiredRole__RequiredResourceDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOuterRequiredRole__RequiredResourceDelegationConnector(
            final ResourceRequiredRole newOuterRequiredRole__RequiredResourceDelegationConnector) {
        final ResourceRequiredRole oldOuterRequiredRole__RequiredResourceDelegationConnector = this.outerRequiredRole__RequiredResourceDelegationConnector;
        this.outerRequiredRole__RequiredResourceDelegationConnector = newOuterRequiredRole__RequiredResourceDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR,
                    oldOuterRequiredRole__RequiredResourceDelegationConnector,
                    this.outerRequiredRole__RequiredResourceDelegationConnector));
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
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getAssemblyContext__RequiredResourceDelegationConnector();
            }
            return this.basicGetAssemblyContext__RequiredResourceDelegationConnector();
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getInnerRequiredRole__RequiredResourceDelegationConnector();
            }
            return this.basicGetInnerRequiredRole__RequiredResourceDelegationConnector();
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getOuterRequiredRole__RequiredResourceDelegationConnector();
            }
            return this.basicGetOuterRequiredRole__RequiredResourceDelegationConnector();
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
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            this.setAssemblyContext__RequiredResourceDelegationConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            this.setInnerRequiredRole__RequiredResourceDelegationConnector((ResourceRequiredRole) newValue);
            return;
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            this.setOuterRequiredRole__RequiredResourceDelegationConnector((ResourceRequiredRole) newValue);
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
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            this.setAssemblyContext__RequiredResourceDelegationConnector((AssemblyContext) null);
            return;
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            this.setInnerRequiredRole__RequiredResourceDelegationConnector((ResourceRequiredRole) null);
            return;
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            this.setOuterRequiredRole__RequiredResourceDelegationConnector((ResourceRequiredRole) null);
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
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            return this.assemblyContext__RequiredResourceDelegationConnector != null;
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            return this.innerRequiredRole__RequiredResourceDelegationConnector != null;
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            return this.outerRequiredRole__RequiredResourceDelegationConnector != null;
        }
        return super.eIsSet(featureID);
    }

} // RequiredResourceDelegationConnectorImpl
