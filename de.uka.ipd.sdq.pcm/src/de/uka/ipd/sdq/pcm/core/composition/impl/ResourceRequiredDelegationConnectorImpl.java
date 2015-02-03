/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;
import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.impl.EStereotypableObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Required Delegation Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl#getInnerResourceRequiredRole_ResourceRequiredDelegationConnector
 * <em>Inner Resource Required Role Resource Required Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl#getOuterResourceRequiredRole_ResourceRequiredDelegationConnector
 * <em>Outer Resource Required Role Resource Required Delegation Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl#getParentStructure_ResourceRequiredDelegationConnector
 * <em>Parent Structure Resource Required Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceRequiredDelegationConnectorImpl extends EStereotypableObjectImpl implements
ResourceRequiredDelegationConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '
     * {@link #getInnerResourceRequiredRole_ResourceRequiredDelegationConnector()
     * <em>Inner Resource Required Role Resource Required Delegation Connector</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getInnerResourceRequiredRole_ResourceRequiredDelegationConnector()
     * @generated
     * @ordered
     */
    protected ResourceRequiredRole innerResourceRequiredRole_ResourceRequiredDelegationConnector;

    /**
     * The cached value of the '
     * {@link #getOuterResourceRequiredRole_ResourceRequiredDelegationConnector()
     * <em>Outer Resource Required Role Resource Required Delegation Connector</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOuterResourceRequiredRole_ResourceRequiredDelegationConnector()
     * @generated
     * @ordered
     */
    protected ResourceRequiredRole outerResourceRequiredRole_ResourceRequiredDelegationConnector;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceRequiredDelegationConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.RESOURCE_REQUIRED_DELEGATION_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ComposedStructure getParentStructure_ResourceRequiredDelegationConnector() {
        if (this.eContainerFeatureID() != CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR) {
            return null;
        }
        return (ComposedStructure) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetParentStructure_ResourceRequiredDelegationConnector(
            final ComposedStructure newParentStructure_ResourceRequiredDelegationConnector, NotificationChain msgs) {
        msgs = this
                .eBasicSetContainer(
                        (InternalEObject) newParentStructure_ResourceRequiredDelegationConnector,
                        CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                        msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setParentStructure_ResourceRequiredDelegationConnector(
            final ComposedStructure newParentStructure_ResourceRequiredDelegationConnector) {
        if (newParentStructure_ResourceRequiredDelegationConnector != this.eInternalContainer()
                || (this.eContainerFeatureID() != CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR && newParentStructure_ResourceRequiredDelegationConnector != null)) {
            if (EcoreUtil.isAncestor(this, newParentStructure_ResourceRequiredDelegationConnector)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newParentStructure_ResourceRequiredDelegationConnector != null) {
                msgs = ((InternalEObject) newParentStructure_ResourceRequiredDelegationConnector)
                        .eInverseAdd(
                                this,
                                CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE,
                                ComposedStructure.class, msgs);
            }
            msgs = this.basicSetParentStructure_ResourceRequiredDelegationConnector(
                    newParentStructure_ResourceRequiredDelegationConnector, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                    newParentStructure_ResourceRequiredDelegationConnector,
                    newParentStructure_ResourceRequiredDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceRequiredRole getInnerResourceRequiredRole_ResourceRequiredDelegationConnector() {
        if (this.innerResourceRequiredRole_ResourceRequiredDelegationConnector != null
                && ((EObject) this.innerResourceRequiredRole_ResourceRequiredDelegationConnector).eIsProxy()) {
            final InternalEObject oldInnerResourceRequiredRole_ResourceRequiredDelegationConnector = (InternalEObject) this.innerResourceRequiredRole_ResourceRequiredDelegationConnector;
            this.innerResourceRequiredRole_ResourceRequiredDelegationConnector = (ResourceRequiredRole) this
                    .eResolveProxy(oldInnerResourceRequiredRole_ResourceRequiredDelegationConnector);
            if (this.innerResourceRequiredRole_ResourceRequiredDelegationConnector != oldInnerResourceRequiredRole_ResourceRequiredDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                            oldInnerResourceRequiredRole_ResourceRequiredDelegationConnector,
                            this.innerResourceRequiredRole_ResourceRequiredDelegationConnector));
                }
            }
        }
        return this.innerResourceRequiredRole_ResourceRequiredDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceRequiredRole basicGetInnerResourceRequiredRole_ResourceRequiredDelegationConnector() {
        return this.innerResourceRequiredRole_ResourceRequiredDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInnerResourceRequiredRole_ResourceRequiredDelegationConnector(
            final ResourceRequiredRole newInnerResourceRequiredRole_ResourceRequiredDelegationConnector) {
        final ResourceRequiredRole oldInnerResourceRequiredRole_ResourceRequiredDelegationConnector = this.innerResourceRequiredRole_ResourceRequiredDelegationConnector;
        this.innerResourceRequiredRole_ResourceRequiredDelegationConnector = newInnerResourceRequiredRole_ResourceRequiredDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                    oldInnerResourceRequiredRole_ResourceRequiredDelegationConnector,
                    this.innerResourceRequiredRole_ResourceRequiredDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceRequiredRole getOuterResourceRequiredRole_ResourceRequiredDelegationConnector() {
        if (this.outerResourceRequiredRole_ResourceRequiredDelegationConnector != null
                && ((EObject) this.outerResourceRequiredRole_ResourceRequiredDelegationConnector).eIsProxy()) {
            final InternalEObject oldOuterResourceRequiredRole_ResourceRequiredDelegationConnector = (InternalEObject) this.outerResourceRequiredRole_ResourceRequiredDelegationConnector;
            this.outerResourceRequiredRole_ResourceRequiredDelegationConnector = (ResourceRequiredRole) this
                    .eResolveProxy(oldOuterResourceRequiredRole_ResourceRequiredDelegationConnector);
            if (this.outerResourceRequiredRole_ResourceRequiredDelegationConnector != oldOuterResourceRequiredRole_ResourceRequiredDelegationConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                            oldOuterResourceRequiredRole_ResourceRequiredDelegationConnector,
                            this.outerResourceRequiredRole_ResourceRequiredDelegationConnector));
                }
            }
        }
        return this.outerResourceRequiredRole_ResourceRequiredDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceRequiredRole basicGetOuterResourceRequiredRole_ResourceRequiredDelegationConnector() {
        return this.outerResourceRequiredRole_ResourceRequiredDelegationConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOuterResourceRequiredRole_ResourceRequiredDelegationConnector(
            final ResourceRequiredRole newOuterResourceRequiredRole_ResourceRequiredDelegationConnector) {
        final ResourceRequiredRole oldOuterResourceRequiredRole_ResourceRequiredDelegationConnector = this.outerResourceRequiredRole_ResourceRequiredDelegationConnector;
        this.outerResourceRequiredRole_ResourceRequiredDelegationConnector = newOuterResourceRequiredRole_ResourceRequiredDelegationConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR,
                    oldOuterResourceRequiredRole_ResourceRequiredDelegationConnector,
                    this.outerResourceRequiredRole_ResourceRequiredDelegationConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetParentStructure_ResourceRequiredDelegationConnector((ComposedStructure) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return this.basicSetParentStructure_ResourceRequiredDelegationConnector(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return this.eInternalContainer().eInverseRemove(this,
                    CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE,
                    ComposedStructure.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getInnerResourceRequiredRole_ResourceRequiredDelegationConnector();
            }
            return this.basicGetInnerResourceRequiredRole_ResourceRequiredDelegationConnector();
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            if (resolve) {
                return this.getOuterResourceRequiredRole_ResourceRequiredDelegationConnector();
            }
            return this.basicGetOuterResourceRequiredRole_ResourceRequiredDelegationConnector();
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return this.getParentStructure_ResourceRequiredDelegationConnector();
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
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            this.setInnerResourceRequiredRole_ResourceRequiredDelegationConnector((ResourceRequiredRole) newValue);
            return;
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            this.setOuterResourceRequiredRole_ResourceRequiredDelegationConnector((ResourceRequiredRole) newValue);
            return;
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            this.setParentStructure_ResourceRequiredDelegationConnector((ComposedStructure) newValue);
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
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            this.setInnerResourceRequiredRole_ResourceRequiredDelegationConnector((ResourceRequiredRole) null);
            return;
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            this.setOuterResourceRequiredRole_ResourceRequiredDelegationConnector((ResourceRequiredRole) null);
            return;
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            this.setParentStructure_ResourceRequiredDelegationConnector((ComposedStructure) null);
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
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return this.innerResourceRequiredRole_ResourceRequiredDelegationConnector != null;
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return this.outerResourceRequiredRole_ResourceRequiredDelegationConnector != null;
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return this.getParentStructure_ResourceRequiredDelegationConnector() != null;
        }
        return super.eIsSet(featureID);
    }

} // ResourceRequiredDelegationConnectorImpl
