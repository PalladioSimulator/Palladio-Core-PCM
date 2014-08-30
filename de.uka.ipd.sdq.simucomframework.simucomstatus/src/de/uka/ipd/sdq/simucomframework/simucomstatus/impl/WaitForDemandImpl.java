/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Wait For Demand</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForDemandImpl#getDemand <em>
 * Demand</em>}</li>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForDemandImpl#getResource <em>
 * Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WaitForDemandImpl extends ActionImpl implements WaitForDemand {
    /**
     * The default value of the '{@link #getDemand() <em>Demand</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDemand()
     * @generated
     * @ordered
     */
    protected static final double DEMAND_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getDemand() <em>Demand</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getDemand()
     * @generated
     * @ordered
     */
    protected double demand = DEMAND_EDEFAULT;

    /**
     * The cached value of the '{@link #getResource() <em>Resource</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getResource()
     * @generated
     * @ordered
     */
    protected ActiveResouce resource;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WaitForDemandImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimucomstatusPackage.Literals.WAIT_FOR_DEMAND;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public double getDemand() {
        return demand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDemand(double newDemand) {
        double oldDemand = demand;
        demand = newDemand;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimucomstatusPackage.WAIT_FOR_DEMAND__DEMAND,
                    oldDemand, demand));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ActiveResouce getResource() {
        if (resource != null && resource.eIsProxy()) {
            InternalEObject oldResource = (InternalEObject) resource;
            resource = (ActiveResouce) eResolveProxy(oldResource);
            if (resource != oldResource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SimucomstatusPackage.WAIT_FOR_DEMAND__RESOURCE, oldResource, resource));
            }
        }
        return resource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ActiveResouce basicGetResource() {
        return resource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetResource(ActiveResouce newResource, NotificationChain msgs) {
        ActiveResouce oldResource = resource;
        resource = newResource;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SimucomstatusPackage.WAIT_FOR_DEMAND__RESOURCE, oldResource, newResource);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setResource(ActiveResouce newResource) {
        if (newResource != resource) {
            NotificationChain msgs = null;
            if (resource != null)
                msgs = ((InternalEObject) resource).eInverseRemove(this,
                        SimucomstatusPackage.ACTIVE_RESOUCE__WAITING_DEMANDS, ActiveResouce.class, msgs);
            if (newResource != null)
                msgs = ((InternalEObject) newResource).eInverseAdd(this,
                        SimucomstatusPackage.ACTIVE_RESOUCE__WAITING_DEMANDS, ActiveResouce.class, msgs);
            msgs = basicSetResource(newResource, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimucomstatusPackage.WAIT_FOR_DEMAND__RESOURCE,
                    newResource, newResource));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SimucomstatusPackage.WAIT_FOR_DEMAND__RESOURCE:
            if (resource != null)
                msgs = ((InternalEObject) resource).eInverseRemove(this,
                        SimucomstatusPackage.ACTIVE_RESOUCE__WAITING_DEMANDS, ActiveResouce.class, msgs);
            return basicSetResource((ActiveResouce) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SimucomstatusPackage.WAIT_FOR_DEMAND__RESOURCE:
            return basicSetResource(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SimucomstatusPackage.WAIT_FOR_DEMAND__DEMAND:
            return new Double(getDemand());
        case SimucomstatusPackage.WAIT_FOR_DEMAND__RESOURCE:
            if (resolve)
                return getResource();
            return basicGetResource();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case SimucomstatusPackage.WAIT_FOR_DEMAND__DEMAND:
            setDemand(((Double) newValue).doubleValue());
            return;
        case SimucomstatusPackage.WAIT_FOR_DEMAND__RESOURCE:
            setResource((ActiveResouce) newValue);
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
    public void eUnset(int featureID) {
        switch (featureID) {
        case SimucomstatusPackage.WAIT_FOR_DEMAND__DEMAND:
            setDemand(DEMAND_EDEFAULT);
            return;
        case SimucomstatusPackage.WAIT_FOR_DEMAND__RESOURCE:
            setResource((ActiveResouce) null);
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case SimucomstatusPackage.WAIT_FOR_DEMAND__DEMAND:
            return demand != DEMAND_EDEFAULT;
        case SimucomstatusPackage.WAIT_FOR_DEMAND__RESOURCE:
            return resource != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (demand: ");
        result.append(demand);
        result.append(')');
        return result.toString();
    }

} // WaitForDemandImpl
