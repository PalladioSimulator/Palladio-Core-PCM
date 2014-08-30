/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Wait For Delay</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.WaitForDelayImpl#getDelay <em>Delay
 * </em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WaitForDelayImpl extends ActionImpl implements WaitForDelay {
    /**
     * The default value of the '{@link #getDelay() <em>Delay</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getDelay()
     * @generated
     * @ordered
     */
    protected static final double DELAY_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getDelay() <em>Delay</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getDelay()
     * @generated
     * @ordered
     */
    protected double delay = DELAY_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WaitForDelayImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimucomstatusPackage.Literals.WAIT_FOR_DELAY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public double getDelay() {
        return delay;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDelay(double newDelay) {
        double oldDelay = delay;
        delay = newDelay;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimucomstatusPackage.WAIT_FOR_DELAY__DELAY, oldDelay,
                    delay));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SimucomstatusPackage.WAIT_FOR_DELAY__DELAY:
            return new Double(getDelay());
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
        case SimucomstatusPackage.WAIT_FOR_DELAY__DELAY:
            setDelay(((Double) newValue).doubleValue());
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
        case SimucomstatusPackage.WAIT_FOR_DELAY__DELAY:
            setDelay(DELAY_EDEFAULT);
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
        case SimucomstatusPackage.WAIT_FOR_DELAY__DELAY:
            return delay != DELAY_EDEFAULT;
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
        result.append(" (delay: ");
        result.append(delay);
        result.append(')');
        return result.toString();
    }

} // WaitForDelayImpl
