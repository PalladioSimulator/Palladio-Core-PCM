/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.util.ReliabilityValidator;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Network Induced Failure Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.reliability.impl.NetworkInducedFailureTypeImpl#getCommunicationLinkResourceType__NetworkInducedFailureType
 * <em>Communication Link Resource Type Network Induced Failure Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NetworkInducedFailureTypeImpl extends FailureTypeImpl implements NetworkInducedFailureType {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '
     * {@link #getCommunicationLinkResourceType__NetworkInducedFailureType()
     * <em>Communication Link Resource Type Network Induced Failure Type</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getCommunicationLinkResourceType__NetworkInducedFailureType()
     * @generated
     * @ordered
     */
    protected CommunicationLinkResourceType communicationLinkResourceType__NetworkInducedFailureType;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NetworkInducedFailureTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ReliabilityPackage.Literals.NETWORK_INDUCED_FAILURE_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CommunicationLinkResourceType getCommunicationLinkResourceType__NetworkInducedFailureType() {
        if (this.communicationLinkResourceType__NetworkInducedFailureType != null
                && this.communicationLinkResourceType__NetworkInducedFailureType.eIsProxy()) {
            final InternalEObject oldCommunicationLinkResourceType__NetworkInducedFailureType = (InternalEObject) this.communicationLinkResourceType__NetworkInducedFailureType;
            this.communicationLinkResourceType__NetworkInducedFailureType = (CommunicationLinkResourceType) this
                    .eResolveProxy(oldCommunicationLinkResourceType__NetworkInducedFailureType);
            if (this.communicationLinkResourceType__NetworkInducedFailureType != oldCommunicationLinkResourceType__NetworkInducedFailureType) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE,
                            oldCommunicationLinkResourceType__NetworkInducedFailureType,
                            this.communicationLinkResourceType__NetworkInducedFailureType));
                }
            }
        }
        return this.communicationLinkResourceType__NetworkInducedFailureType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CommunicationLinkResourceType basicGetCommunicationLinkResourceType__NetworkInducedFailureType() {
        return this.communicationLinkResourceType__NetworkInducedFailureType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetCommunicationLinkResourceType__NetworkInducedFailureType(
            final CommunicationLinkResourceType newCommunicationLinkResourceType__NetworkInducedFailureType,
            NotificationChain msgs) {
        final CommunicationLinkResourceType oldCommunicationLinkResourceType__NetworkInducedFailureType = this.communicationLinkResourceType__NetworkInducedFailureType;
        this.communicationLinkResourceType__NetworkInducedFailureType = newCommunicationLinkResourceType__NetworkInducedFailureType;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(
                    this,
                    Notification.SET,
                    ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE,
                    oldCommunicationLinkResourceType__NetworkInducedFailureType,
                    newCommunicationLinkResourceType__NetworkInducedFailureType);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCommunicationLinkResourceType__NetworkInducedFailureType(
            final CommunicationLinkResourceType newCommunicationLinkResourceType__NetworkInducedFailureType) {
        if (newCommunicationLinkResourceType__NetworkInducedFailureType != this.communicationLinkResourceType__NetworkInducedFailureType) {
            NotificationChain msgs = null;
            if (this.communicationLinkResourceType__NetworkInducedFailureType != null) {
                msgs = ((InternalEObject) this.communicationLinkResourceType__NetworkInducedFailureType)
                        .eInverseRemove(
                                this,
                                ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE,
                                CommunicationLinkResourceType.class, msgs);
            }
            if (newCommunicationLinkResourceType__NetworkInducedFailureType != null) {
                msgs = ((InternalEObject) newCommunicationLinkResourceType__NetworkInducedFailureType)
                        .eInverseAdd(
                                this,
                                ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE,
                                CommunicationLinkResourceType.class, msgs);
            }
            msgs = this.basicSetCommunicationLinkResourceType__NetworkInducedFailureType(
                    newCommunicationLinkResourceType__NetworkInducedFailureType, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE,
                    newCommunicationLinkResourceType__NetworkInducedFailureType,
                    newCommunicationLinkResourceType__NetworkInducedFailureType));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #NetworkInducedFailureTypeHasCommunicationLinkResourceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Network Induced Failure Type Has Communication Link Resource Type</em>} ' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #NetworkInducedFailureTypeHasCommunicationLinkResourceType(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.communicationLinkResourceType__NetworkInducedFailureType <> null";

    /**
     * The cached OCL invariant for the '
     * {@link #NetworkInducedFailureTypeHasCommunicationLinkResourceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Network Induced Failure Type Has Communication Link Resource Type</em>}' invariant
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #NetworkInducedFailureTypeHasCommunicationLinkResourceType(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean NetworkInducedFailureTypeHasCommunicationLinkResourceType(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(ReliabilityPackage.Literals.NETWORK_INDUCED_FAILURE_TYPE);
            try {
                NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        ReliabilityValidator.DIAGNOSTIC_SOURCE,
                        ReliabilityValidator.NETWORK_INDUCED_FAILURE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                new Object[] { "NetworkInducedFailureTypeHasCommunicationLinkResourceType",
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
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE:
            if (this.communicationLinkResourceType__NetworkInducedFailureType != null) {
                msgs = ((InternalEObject) this.communicationLinkResourceType__NetworkInducedFailureType)
                        .eInverseRemove(
                                this,
                                ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE,
                                CommunicationLinkResourceType.class, msgs);
            }
            return this.basicSetCommunicationLinkResourceType__NetworkInducedFailureType(
                    (CommunicationLinkResourceType) otherEnd, msgs);
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
        case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE:
            return this.basicSetCommunicationLinkResourceType__NetworkInducedFailureType(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE:
            if (resolve) {
                return this.getCommunicationLinkResourceType__NetworkInducedFailureType();
            }
            return this.basicGetCommunicationLinkResourceType__NetworkInducedFailureType();
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
        case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE:
            this.setCommunicationLinkResourceType__NetworkInducedFailureType((CommunicationLinkResourceType) newValue);
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
        case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE:
            this.setCommunicationLinkResourceType__NetworkInducedFailureType((CommunicationLinkResourceType) null);
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
        case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE:
            return this.communicationLinkResourceType__NetworkInducedFailureType != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // NetworkInducedFailureTypeImpl
