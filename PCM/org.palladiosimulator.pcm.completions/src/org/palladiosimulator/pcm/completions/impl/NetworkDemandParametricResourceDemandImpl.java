/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 */
package org.palladiosimulator.pcm.completions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.pcm.completions.CompletionsPackage;
import org.palladiosimulator.pcm.completions.NetworkDemandParametricResourceDemand;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Network Demand Parametric Resource Demand</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.completions.impl.NetworkDemandParametricResourceDemandImpl#getRequiredCommunicationLinkResource_ParametricResourceDemand
 * <em>Required Communication Link Resource Parametric Resource Demand</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NetworkDemandParametricResourceDemandImpl
        extends de.uka.ipd.sdq.pcm.seff.seff_performance.impl.ParametricResourceDemandImpl
        implements NetworkDemandParametricResourceDemand {

    /**
     * The cached value of the '
     * {@link #getRequiredCommunicationLinkResource_ParametricResourceDemand()
     * <em>Required Communication Link Resource Parametric Resource Demand</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRequiredCommunicationLinkResource_ParametricResourceDemand()
     * @generated
     * @ordered
     */
    protected de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType requiredCommunicationLinkResource_ParametricResourceDemand;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NetworkDemandParametricResourceDemandImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompletionsPackage.Literals.NETWORK_DEMAND_PARAMETRIC_RESOURCE_DEMAND;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType getRequiredCommunicationLinkResource_ParametricResourceDemand() {
        if (this.requiredCommunicationLinkResource_ParametricResourceDemand != null
                && ((EObject) this.requiredCommunicationLinkResource_ParametricResourceDemand).eIsProxy()) {
            final InternalEObject oldRequiredCommunicationLinkResource_ParametricResourceDemand = (InternalEObject) this.requiredCommunicationLinkResource_ParametricResourceDemand;
            this.requiredCommunicationLinkResource_ParametricResourceDemand = (de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType) eResolveProxy(
                    oldRequiredCommunicationLinkResource_ParametricResourceDemand);
            if (this.requiredCommunicationLinkResource_ParametricResourceDemand != oldRequiredCommunicationLinkResource_ParametricResourceDemand) {
                if (eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompletionsPackage.NETWORK_DEMAND_PARAMETRIC_RESOURCE_DEMAND__REQUIRED_COMMUNICATION_LINK_RESOURCE_PARAMETRIC_RESOURCE_DEMAND,
                            oldRequiredCommunicationLinkResource_ParametricResourceDemand,
                            this.requiredCommunicationLinkResource_ParametricResourceDemand));
                }
            }
        }
        return this.requiredCommunicationLinkResource_ParametricResourceDemand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType basicGetRequiredCommunicationLinkResource_ParametricResourceDemand() {
        return this.requiredCommunicationLinkResource_ParametricResourceDemand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRequiredCommunicationLinkResource_ParametricResourceDemand(
            final de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType newRequiredCommunicationLinkResource_ParametricResourceDemand) {
        final de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType oldRequiredCommunicationLinkResource_ParametricResourceDemand = this.requiredCommunicationLinkResource_ParametricResourceDemand;
        this.requiredCommunicationLinkResource_ParametricResourceDemand = newRequiredCommunicationLinkResource_ParametricResourceDemand;
        if (eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompletionsPackage.NETWORK_DEMAND_PARAMETRIC_RESOURCE_DEMAND__REQUIRED_COMMUNICATION_LINK_RESOURCE_PARAMETRIC_RESOURCE_DEMAND,
                    oldRequiredCommunicationLinkResource_ParametricResourceDemand,
                    this.requiredCommunicationLinkResource_ParametricResourceDemand));
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
        case CompletionsPackage.NETWORK_DEMAND_PARAMETRIC_RESOURCE_DEMAND__REQUIRED_COMMUNICATION_LINK_RESOURCE_PARAMETRIC_RESOURCE_DEMAND:
            if (resolve) {
                return this.getRequiredCommunicationLinkResource_ParametricResourceDemand();
            }
            return this.basicGetRequiredCommunicationLinkResource_ParametricResourceDemand();
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
        case CompletionsPackage.NETWORK_DEMAND_PARAMETRIC_RESOURCE_DEMAND__REQUIRED_COMMUNICATION_LINK_RESOURCE_PARAMETRIC_RESOURCE_DEMAND:
            this.setRequiredCommunicationLinkResource_ParametricResourceDemand(
                    (de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType) newValue);
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
        case CompletionsPackage.NETWORK_DEMAND_PARAMETRIC_RESOURCE_DEMAND__REQUIRED_COMMUNICATION_LINK_RESOURCE_PARAMETRIC_RESOURCE_DEMAND:
            this.setRequiredCommunicationLinkResource_ParametricResourceDemand(
                    (de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType) null);
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
        case CompletionsPackage.NETWORK_DEMAND_PARAMETRIC_RESOURCE_DEMAND__REQUIRED_COMMUNICATION_LINK_RESOURCE_PARAMETRIC_RESOURCE_DEMAND:
            return this.requiredCommunicationLinkResource_ParametricResourceDemand != null;
        }
        return super.eIsSet(featureID);
    }

} // NetworkDemandParametricResourceDemandImpl
