/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.usagemodel.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.PCMRandomVariable;

import org.palladiosimulator.pcm.usagemodel.Delay;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delay</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.DelayImpl#getTimeSpecification_Delay <em>Time Specification Delay</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DelayImpl extends AbstractUserActionImpl implements Delay {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DelayImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.DELAY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PCMRandomVariable getTimeSpecification_Delay() {
        return (PCMRandomVariable) eDynamicGet(UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY,
                UsagemodelPackage.Literals.DELAY__TIME_SPECIFICATION_DELAY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTimeSpecification_Delay(PCMRandomVariable newTimeSpecification_Delay,
            NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newTimeSpecification_Delay,
                UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimeSpecification_Delay(PCMRandomVariable newTimeSpecification_Delay) {
        eDynamicSet(UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY,
                UsagemodelPackage.Literals.DELAY__TIME_SPECIFICATION_DELAY, newTimeSpecification_Delay);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY:
            PCMRandomVariable timeSpecification_Delay = getTimeSpecification_Delay();
            if (timeSpecification_Delay != null)
                msgs = ((InternalEObject) timeSpecification_Delay).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY, null, msgs);
            return basicSetTimeSpecification_Delay((PCMRandomVariable) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY:
            return basicSetTimeSpecification_Delay(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY:
            return getTimeSpecification_Delay();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY:
            setTimeSpecification_Delay((PCMRandomVariable) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY:
            setTimeSpecification_Delay((PCMRandomVariable) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case UsagemodelPackage.DELAY__TIME_SPECIFICATION_DELAY:
            return getTimeSpecification_Delay() != null;
        }
        return super.eIsSet(featureID);
    }

} //DelayImpl
