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
import de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.SinkRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Sink Delegation Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl#getAssemblyContext__SinkDelegationConnector
 * <em>Assembly Context Sink Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl#getInnerSinkRole__SinkRole
 * <em>Inner Sink Role Sink Role</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl#getOuterSinkRole__SinkRole
 * <em>Outer Sink Role Sink Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SinkDelegationConnectorImpl extends DelegationConnectorImpl implements SinkDelegationConnector {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getAssemblyContext__SinkDelegationConnector()
     * <em>Assembly Context Sink Delegation Connector</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getAssemblyContext__SinkDelegationConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext__SinkDelegationConnector;
    /**
     * The cached value of the '{@link #getInnerSinkRole__SinkRole()
     * <em>Inner Sink Role Sink Role</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getInnerSinkRole__SinkRole()
     * @generated
     * @ordered
     */
    protected SinkRole innerSinkRole__SinkRole;
    /**
     * The cached value of the '{@link #getOuterSinkRole__SinkRole()
     * <em>Outer Sink Role Sink Role</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOuterSinkRole__SinkRole()
     * @generated
     * @ordered
     */
    protected SinkRole outerSinkRole__SinkRole;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SinkDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext__SinkDelegationConnector() {
        if (this.assemblyContext__SinkDelegationConnector != null
                && this.assemblyContext__SinkDelegationConnector.eIsProxy()) {
            final InternalEObject oldAssemblyContext__SinkDelegationConnector = (InternalEObject) this.assemblyContext__SinkDelegationConnector;
            this.assemblyContext__SinkDelegationConnector = (AssemblyContext) this
                    .eResolveProxy(oldAssemblyContext__SinkDelegationConnector);
            if (this.assemblyContext__SinkDelegationConnector != oldAssemblyContext__SinkDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR,
                            oldAssemblyContext__SinkDelegationConnector, this.assemblyContext__SinkDelegationConnector));
                }
            }
        }
        return this.assemblyContext__SinkDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__SinkDelegationConnector() {
        return this.assemblyContext__SinkDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAssemblyContext__SinkDelegationConnector(
            final AssemblyContext newAssemblyContext__SinkDelegationConnector) {
        final AssemblyContext oldAssemblyContext__SinkDelegationConnector = this.assemblyContext__SinkDelegationConnector;
        this.assemblyContext__SinkDelegationConnector = newAssemblyContext__SinkDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR,
                    oldAssemblyContext__SinkDelegationConnector, this.assemblyContext__SinkDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SinkRole getInnerSinkRole__SinkRole() {
        if (this.innerSinkRole__SinkRole != null && this.innerSinkRole__SinkRole.eIsProxy()) {
            final InternalEObject oldInnerSinkRole__SinkRole = (InternalEObject) this.innerSinkRole__SinkRole;
            this.innerSinkRole__SinkRole = (SinkRole) this.eResolveProxy(oldInnerSinkRole__SinkRole);
            if (this.innerSinkRole__SinkRole != oldInnerSinkRole__SinkRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE,
                            oldInnerSinkRole__SinkRole, this.innerSinkRole__SinkRole));
                }
            }
        }
        return this.innerSinkRole__SinkRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SinkRole basicGetInnerSinkRole__SinkRole() {
        return this.innerSinkRole__SinkRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setInnerSinkRole__SinkRole(final SinkRole newInnerSinkRole__SinkRole) {
        final SinkRole oldInnerSinkRole__SinkRole = this.innerSinkRole__SinkRole;
        this.innerSinkRole__SinkRole = newInnerSinkRole__SinkRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE,
                    oldInnerSinkRole__SinkRole, this.innerSinkRole__SinkRole));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SinkRole getOuterSinkRole__SinkRole() {
        if (this.outerSinkRole__SinkRole != null && this.outerSinkRole__SinkRole.eIsProxy()) {
            final InternalEObject oldOuterSinkRole__SinkRole = (InternalEObject) this.outerSinkRole__SinkRole;
            this.outerSinkRole__SinkRole = (SinkRole) this.eResolveProxy(oldOuterSinkRole__SinkRole);
            if (this.outerSinkRole__SinkRole != oldOuterSinkRole__SinkRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE,
                            oldOuterSinkRole__SinkRole, this.outerSinkRole__SinkRole));
                }
            }
        }
        return this.outerSinkRole__SinkRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SinkRole basicGetOuterSinkRole__SinkRole() {
        return this.outerSinkRole__SinkRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOuterSinkRole__SinkRole(final SinkRole newOuterSinkRole__SinkRole) {
        final SinkRole oldOuterSinkRole__SinkRole = this.outerSinkRole__SinkRole;
        this.outerSinkRole__SinkRole = newOuterSinkRole__SinkRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE,
                    oldOuterSinkRole__SinkRole, this.outerSinkRole__SinkRole));
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
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getAssemblyContext__SinkDelegationConnector();
            }
            return this.basicGetAssemblyContext__SinkDelegationConnector();
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE:
            if (resolve) {
                return this.getInnerSinkRole__SinkRole();
            }
            return this.basicGetInnerSinkRole__SinkRole();
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE:
            if (resolve) {
                return this.getOuterSinkRole__SinkRole();
            }
            return this.basicGetOuterSinkRole__SinkRole();
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
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
            this.setAssemblyContext__SinkDelegationConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE:
            this.setInnerSinkRole__SinkRole((SinkRole) newValue);
            return;
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE:
            this.setOuterSinkRole__SinkRole((SinkRole) newValue);
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
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
            this.setAssemblyContext__SinkDelegationConnector((AssemblyContext) null);
            return;
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE:
            this.setInnerSinkRole__SinkRole((SinkRole) null);
            return;
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE:
            this.setOuterSinkRole__SinkRole((SinkRole) null);
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
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
            return this.assemblyContext__SinkDelegationConnector != null;
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE:
            return this.innerSinkRole__SinkRole != null;
        case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE:
            return this.outerSinkRole__SinkRole != null;
        }
        return super.eIsSet(featureID);
    }

} // SinkDelegationConnectorImpl
