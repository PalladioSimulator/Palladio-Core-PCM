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
import org.eclipse.emf.ecore.EObject;
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
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.impl.NetworkInducedFailureTypeImpl#getCommunicationLinkResourceType__NetworkInducedFailureType <em>Communication Link Resource Type Network Induced Failure Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NetworkInducedFailureTypeImpl extends FailureTypeImpl implements NetworkInducedFailureType {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
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
     * @generated
     */
    protected NetworkInducedFailureTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ReliabilityPackage.Literals.NETWORK_INDUCED_FAILURE_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public CommunicationLinkResourceType getCommunicationLinkResourceType__NetworkInducedFailureType() {
        if (communicationLinkResourceType__NetworkInducedFailureType != null && ((EObject)communicationLinkResourceType__NetworkInducedFailureType).eIsProxy()) {
            InternalEObject oldCommunicationLinkResourceType__NetworkInducedFailureType = (InternalEObject)communicationLinkResourceType__NetworkInducedFailureType;
            communicationLinkResourceType__NetworkInducedFailureType = (CommunicationLinkResourceType)eResolveProxy(oldCommunicationLinkResourceType__NetworkInducedFailureType);
            if (communicationLinkResourceType__NetworkInducedFailureType != oldCommunicationLinkResourceType__NetworkInducedFailureType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE, oldCommunicationLinkResourceType__NetworkInducedFailureType, communicationLinkResourceType__NetworkInducedFailureType));
            }
        }
        return communicationLinkResourceType__NetworkInducedFailureType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public CommunicationLinkResourceType basicGetCommunicationLinkResourceType__NetworkInducedFailureType() {
        return communicationLinkResourceType__NetworkInducedFailureType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCommunicationLinkResourceType__NetworkInducedFailureType(
            CommunicationLinkResourceType newCommunicationLinkResourceType__NetworkInducedFailureType,
            NotificationChain msgs) {
        CommunicationLinkResourceType oldCommunicationLinkResourceType__NetworkInducedFailureType = communicationLinkResourceType__NetworkInducedFailureType;
        communicationLinkResourceType__NetworkInducedFailureType = newCommunicationLinkResourceType__NetworkInducedFailureType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE, oldCommunicationLinkResourceType__NetworkInducedFailureType, newCommunicationLinkResourceType__NetworkInducedFailureType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setCommunicationLinkResourceType__NetworkInducedFailureType(
            CommunicationLinkResourceType newCommunicationLinkResourceType__NetworkInducedFailureType) {
        if (newCommunicationLinkResourceType__NetworkInducedFailureType != communicationLinkResourceType__NetworkInducedFailureType) {
            NotificationChain msgs = null;
            if (communicationLinkResourceType__NetworkInducedFailureType != null)
                msgs = ((InternalEObject)communicationLinkResourceType__NetworkInducedFailureType).eInverseRemove(this, ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE, CommunicationLinkResourceType.class, msgs);
            if (newCommunicationLinkResourceType__NetworkInducedFailureType != null)
                msgs = ((InternalEObject)newCommunicationLinkResourceType__NetworkInducedFailureType).eInverseAdd(this, ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE, CommunicationLinkResourceType.class, msgs);
            msgs = basicSetCommunicationLinkResourceType__NetworkInducedFailureType(newCommunicationLinkResourceType__NetworkInducedFailureType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE, newCommunicationLinkResourceType__NetworkInducedFailureType, newCommunicationLinkResourceType__NetworkInducedFailureType));
    }

    /**
     * The cached OCL expression body for the '
     * {@link #NetworkInducedFailureTypeHasCommunicationLinkResourceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Network Induced Failure Type Has Communication Link Resource Type</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #NetworkInducedFailureTypeHasCommunicationLinkResourceType(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.communicationLinkResourceType__NetworkInducedFailureType <> null";

    /**
     * The cached OCL invariant for the '{@link #NetworkInducedFailureTypeHasCommunicationLinkResourceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Network Induced Failure Type Has Communication Link Resource Type</em>}' invariant operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #NetworkInducedFailureTypeHasCommunicationLinkResourceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean NetworkInducedFailureTypeHasCommunicationLinkResourceType(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(ReliabilityPackage.Literals.NETWORK_INDUCED_FAILURE_TYPE);
            try {
                NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            }
            catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ReliabilityValidator.DIAGNOSTIC_SOURCE,
                         ReliabilityValidator.NETWORK_INDUCED_FAILURE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_HAS_COMMUNICATION_LINK_RESOURCE_TYPE,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "NetworkInducedFailureTypeHasCommunicationLinkResourceType", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE:
                if (communicationLinkResourceType__NetworkInducedFailureType != null)
                    msgs = ((InternalEObject)communicationLinkResourceType__NetworkInducedFailureType).eInverseRemove(this, ResourcetypePackage.COMMUNICATION_LINK_RESOURCE_TYPE__NETWORK_INDUCED_FAILURE_TYPE_COMMUNICATION_LINK_RESOURCE_TYPE, CommunicationLinkResourceType.class, msgs);
                return basicSetCommunicationLinkResourceType__NetworkInducedFailureType((CommunicationLinkResourceType)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE:
                return basicSetCommunicationLinkResourceType__NetworkInducedFailureType(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE:
                if (resolve) return getCommunicationLinkResourceType__NetworkInducedFailureType();
                return basicGetCommunicationLinkResourceType__NetworkInducedFailureType();
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
            case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE:
                setCommunicationLinkResourceType__NetworkInducedFailureType((CommunicationLinkResourceType)newValue);
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
            case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE:
                setCommunicationLinkResourceType__NetworkInducedFailureType((CommunicationLinkResourceType)null);
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
            case ReliabilityPackage.NETWORK_INDUCED_FAILURE_TYPE__COMMUNICATION_LINK_RESOURCE_TYPE_NETWORK_INDUCED_FAILURE_TYPE:
                return communicationLinkResourceType__NetworkInducedFailureType != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * The cached environment for evaluating OCL expressions.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // NetworkInducedFailureTypeImpl
