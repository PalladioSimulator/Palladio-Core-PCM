/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.seff.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.PCMRandomVariable;

import org.palladiosimulator.pcm.seff.LoopAction;
import org.palladiosimulator.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.LoopActionImpl#getIterationCount_LoopAction <em>Iteration Count Loop Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoopActionImpl extends AbstractLoopActionImpl implements LoopAction {

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
    protected LoopActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.LOOP_ACTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PCMRandomVariable getIterationCount_LoopAction() {
        return (PCMRandomVariable) eDynamicGet(SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION,
                SeffPackage.Literals.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetIterationCount_LoopAction(PCMRandomVariable newIterationCount_LoopAction,
            NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newIterationCount_LoopAction,
                SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIterationCount_LoopAction(PCMRandomVariable newIterationCount_LoopAction) {
        eDynamicSet(SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION,
                SeffPackage.Literals.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION, newIterationCount_LoopAction);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION:
            PCMRandomVariable iterationCount_LoopAction = getIterationCount_LoopAction();
            if (iterationCount_LoopAction != null)
                msgs = ((InternalEObject) iterationCount_LoopAction).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION, null, msgs);
            return basicSetIterationCount_LoopAction((PCMRandomVariable) otherEnd, msgs);
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
        case SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION:
            return basicSetIterationCount_LoopAction(null, msgs);
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
        case SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION:
            return getIterationCount_LoopAction();
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
        case SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION:
            setIterationCount_LoopAction((PCMRandomVariable) newValue);
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
        case SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION:
            setIterationCount_LoopAction((PCMRandomVariable) null);
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
        case SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION:
            return getIterationCount_LoopAction() != null;
        }
        return super.eIsSet(featureID);
    }

} //LoopActionImpl
