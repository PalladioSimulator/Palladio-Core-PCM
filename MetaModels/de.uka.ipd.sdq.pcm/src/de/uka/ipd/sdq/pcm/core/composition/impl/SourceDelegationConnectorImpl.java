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
import de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Source Delegation Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.SourceDelegationConnectorImpl#getInnerSourceRole__SourceRole
 * <em>Inner Source Role Source Role</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.SourceDelegationConnectorImpl#getOuterSourceRole__SourceRole
 * <em>Outer Source Role Source Role</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.SourceDelegationConnectorImpl#getAssemblyContext__SourceDelegationConnector
 * <em>Assembly Context Source Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceDelegationConnectorImpl extends DelegationConnectorImpl implements SourceDelegationConnector {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getInnerSourceRole__SourceRole()
     * <em>Inner Source Role Source Role</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getInnerSourceRole__SourceRole()
     * @generated
     * @ordered
     */
    protected SourceRole innerSourceRole__SourceRole;
    /**
     * The cached value of the '{@link #getOuterSourceRole__SourceRole()
     * <em>Outer Source Role Source Role</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getOuterSourceRole__SourceRole()
     * @generated
     * @ordered
     */
    protected SourceRole outerSourceRole__SourceRole;
    /**
     * The cached value of the '{@link #getAssemblyContext__SourceDelegationConnector()
     * <em>Assembly Context Source Delegation Connector</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getAssemblyContext__SourceDelegationConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext__SourceDelegationConnector;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SourceDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.SOURCE_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SourceRole getInnerSourceRole__SourceRole() {
        if (this.innerSourceRole__SourceRole != null && ((EObject) this.innerSourceRole__SourceRole).eIsProxy()) {
            final InternalEObject oldInnerSourceRole__SourceRole = (InternalEObject) this.innerSourceRole__SourceRole;
            this.innerSourceRole__SourceRole = (SourceRole) this.eResolveProxy(oldInnerSourceRole__SourceRole);
            if (this.innerSourceRole__SourceRole != oldInnerSourceRole__SourceRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE,
                            oldInnerSourceRole__SourceRole, this.innerSourceRole__SourceRole));
                }
            }
        }
        return this.innerSourceRole__SourceRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SourceRole basicGetInnerSourceRole__SourceRole() {
        return this.innerSourceRole__SourceRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInnerSourceRole__SourceRole(final SourceRole newInnerSourceRole__SourceRole) {
        final SourceRole oldInnerSourceRole__SourceRole = this.innerSourceRole__SourceRole;
        this.innerSourceRole__SourceRole = newInnerSourceRole__SourceRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE,
                    oldInnerSourceRole__SourceRole, this.innerSourceRole__SourceRole));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SourceRole getOuterSourceRole__SourceRole() {
        if (this.outerSourceRole__SourceRole != null && ((EObject) this.outerSourceRole__SourceRole).eIsProxy()) {
            final InternalEObject oldOuterSourceRole__SourceRole = (InternalEObject) this.outerSourceRole__SourceRole;
            this.outerSourceRole__SourceRole = (SourceRole) this.eResolveProxy(oldOuterSourceRole__SourceRole);
            if (this.outerSourceRole__SourceRole != oldOuterSourceRole__SourceRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE,
                            oldOuterSourceRole__SourceRole, this.outerSourceRole__SourceRole));
                }
            }
        }
        return this.outerSourceRole__SourceRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SourceRole basicGetOuterSourceRole__SourceRole() {
        return this.outerSourceRole__SourceRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOuterSourceRole__SourceRole(final SourceRole newOuterSourceRole__SourceRole) {
        final SourceRole oldOuterSourceRole__SourceRole = this.outerSourceRole__SourceRole;
        this.outerSourceRole__SourceRole = newOuterSourceRole__SourceRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE,
                    oldOuterSourceRole__SourceRole, this.outerSourceRole__SourceRole));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext__SourceDelegationConnector() {
        if (this.assemblyContext__SourceDelegationConnector != null
                && ((EObject) this.assemblyContext__SourceDelegationConnector).eIsProxy()) {
            final InternalEObject oldAssemblyContext__SourceDelegationConnector = (InternalEObject) this.assemblyContext__SourceDelegationConnector;
            this.assemblyContext__SourceDelegationConnector = (AssemblyContext) this
                    .eResolveProxy(oldAssemblyContext__SourceDelegationConnector);
            if (this.assemblyContext__SourceDelegationConnector != oldAssemblyContext__SourceDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR,
                            oldAssemblyContext__SourceDelegationConnector,
                            this.assemblyContext__SourceDelegationConnector));
                }
            }
        }
        return this.assemblyContext__SourceDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__SourceDelegationConnector() {
        return this.assemblyContext__SourceDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAssemblyContext__SourceDelegationConnector(
            final AssemblyContext newAssemblyContext__SourceDelegationConnector) {
        final AssemblyContext oldAssemblyContext__SourceDelegationConnector = this.assemblyContext__SourceDelegationConnector;
        this.assemblyContext__SourceDelegationConnector = newAssemblyContext__SourceDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR,
                    oldAssemblyContext__SourceDelegationConnector, this.assemblyContext__SourceDelegationConnector));
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
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE:
            if (resolve) {
                return this.getInnerSourceRole__SourceRole();
            }
            return this.basicGetInnerSourceRole__SourceRole();
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE:
            if (resolve) {
                return this.getOuterSourceRole__SourceRole();
            }
            return this.basicGetOuterSourceRole__SourceRole();
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getAssemblyContext__SourceDelegationConnector();
            }
            return this.basicGetAssemblyContext__SourceDelegationConnector();
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
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE:
            this.setInnerSourceRole__SourceRole((SourceRole) newValue);
            return;
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE:
            this.setOuterSourceRole__SourceRole((SourceRole) newValue);
            return;
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR:
            this.setAssemblyContext__SourceDelegationConnector((AssemblyContext) newValue);
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
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE:
            this.setInnerSourceRole__SourceRole((SourceRole) null);
            return;
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE:
            this.setOuterSourceRole__SourceRole((SourceRole) null);
            return;
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR:
            this.setAssemblyContext__SourceDelegationConnector((AssemblyContext) null);
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
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_ROLE:
            return this.innerSourceRole__SourceRole != null;
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_ROLE:
            return this.outerSourceRole__SourceRole != null;
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR:
            return this.assemblyContext__SourceDelegationConnector != null;
        }
        return super.eIsSet(featureID);
    }

} // SourceDelegationConnectorImpl
