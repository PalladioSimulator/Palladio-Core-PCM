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
import de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.SinkRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Sink Delegation Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl#getAssemblyContext__SinkDelegationConnector <em>Assembly Context Sink Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl#getInnerSinkRole__SinkRole <em>Inner Sink Role Sink Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl#getOuterSinkRole__SinkRole <em>Outer Sink Role Sink Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SinkDelegationConnectorImpl extends DelegationConnectorImpl implements SinkDelegationConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getAssemblyContext__SinkDelegationConnector() <em>Assembly Context Sink Delegation Connector</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getAssemblyContext__SinkDelegationConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext__SinkDelegationConnector;

    /**
     * The cached value of the '{@link #getInnerSinkRole__SinkRole() <em>Inner Sink Role Sink Role</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getInnerSinkRole__SinkRole()
     * @generated
     * @ordered
     */
    protected SinkRole innerSinkRole__SinkRole;

    /**
     * The cached value of the '{@link #getOuterSinkRole__SinkRole() <em>Outer Sink Role Sink Role</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getOuterSinkRole__SinkRole()
     * @generated
     * @ordered
     */
    protected SinkRole outerSinkRole__SinkRole;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected SinkDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getAssemblyContext__SinkDelegationConnector() {
        if (assemblyContext__SinkDelegationConnector != null && ((EObject)assemblyContext__SinkDelegationConnector).eIsProxy()) {
            InternalEObject oldAssemblyContext__SinkDelegationConnector = (InternalEObject)assemblyContext__SinkDelegationConnector;
            assemblyContext__SinkDelegationConnector = (AssemblyContext)eResolveProxy(oldAssemblyContext__SinkDelegationConnector);
            if (assemblyContext__SinkDelegationConnector != oldAssemblyContext__SinkDelegationConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR, oldAssemblyContext__SinkDelegationConnector, assemblyContext__SinkDelegationConnector));
            }
        }
        return assemblyContext__SinkDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__SinkDelegationConnector() {
        return assemblyContext__SinkDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setAssemblyContext__SinkDelegationConnector(AssemblyContext newAssemblyContext__SinkDelegationConnector) {
        AssemblyContext oldAssemblyContext__SinkDelegationConnector = assemblyContext__SinkDelegationConnector;
        assemblyContext__SinkDelegationConnector = newAssemblyContext__SinkDelegationConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR, oldAssemblyContext__SinkDelegationConnector, assemblyContext__SinkDelegationConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public SinkRole getInnerSinkRole__SinkRole() {
        if (innerSinkRole__SinkRole != null && ((EObject)innerSinkRole__SinkRole).eIsProxy()) {
            InternalEObject oldInnerSinkRole__SinkRole = (InternalEObject)innerSinkRole__SinkRole;
            innerSinkRole__SinkRole = (SinkRole)eResolveProxy(oldInnerSinkRole__SinkRole);
            if (innerSinkRole__SinkRole != oldInnerSinkRole__SinkRole) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE, oldInnerSinkRole__SinkRole, innerSinkRole__SinkRole));
            }
        }
        return innerSinkRole__SinkRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public SinkRole basicGetInnerSinkRole__SinkRole() {
        return innerSinkRole__SinkRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setInnerSinkRole__SinkRole(SinkRole newInnerSinkRole__SinkRole) {
        SinkRole oldInnerSinkRole__SinkRole = innerSinkRole__SinkRole;
        innerSinkRole__SinkRole = newInnerSinkRole__SinkRole;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE, oldInnerSinkRole__SinkRole, innerSinkRole__SinkRole));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public SinkRole getOuterSinkRole__SinkRole() {
        if (outerSinkRole__SinkRole != null && ((EObject)outerSinkRole__SinkRole).eIsProxy()) {
            InternalEObject oldOuterSinkRole__SinkRole = (InternalEObject)outerSinkRole__SinkRole;
            outerSinkRole__SinkRole = (SinkRole)eResolveProxy(oldOuterSinkRole__SinkRole);
            if (outerSinkRole__SinkRole != oldOuterSinkRole__SinkRole) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE, oldOuterSinkRole__SinkRole, outerSinkRole__SinkRole));
            }
        }
        return outerSinkRole__SinkRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public SinkRole basicGetOuterSinkRole__SinkRole() {
        return outerSinkRole__SinkRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setOuterSinkRole__SinkRole(SinkRole newOuterSinkRole__SinkRole) {
        SinkRole oldOuterSinkRole__SinkRole = outerSinkRole__SinkRole;
        outerSinkRole__SinkRole = newOuterSinkRole__SinkRole;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE, oldOuterSinkRole__SinkRole, outerSinkRole__SinkRole));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
                if (resolve) return getAssemblyContext__SinkDelegationConnector();
                return basicGetAssemblyContext__SinkDelegationConnector();
            case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE:
                if (resolve) return getInnerSinkRole__SinkRole();
                return basicGetInnerSinkRole__SinkRole();
            case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE:
                if (resolve) return getOuterSinkRole__SinkRole();
                return basicGetOuterSinkRole__SinkRole();
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
            case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
                setAssemblyContext__SinkDelegationConnector((AssemblyContext)newValue);
                return;
            case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE:
                setInnerSinkRole__SinkRole((SinkRole)newValue);
                return;
            case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE:
                setOuterSinkRole__SinkRole((SinkRole)newValue);
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
            case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
                setAssemblyContext__SinkDelegationConnector((AssemblyContext)null);
                return;
            case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE:
                setInnerSinkRole__SinkRole((SinkRole)null);
                return;
            case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE:
                setOuterSinkRole__SinkRole((SinkRole)null);
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
            case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
                return assemblyContext__SinkDelegationConnector != null;
            case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE:
                return innerSinkRole__SinkRole != null;
            case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE:
                return outerSinkRole__SinkRole != null;
        }
        return super.eIsSet(featureID);
    }

} // SinkDelegationConnectorImpl
