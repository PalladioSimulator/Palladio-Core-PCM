/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.seff.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

import org.palladiosimulator.pcm.parameter.VariableUsage;

import org.palladiosimulator.pcm.seff.ForkAction;
import org.palladiosimulator.pcm.seff.ForkedBehaviour;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.SynchronisationPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Synchronisation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.SynchronisationPointImpl#getOutputParameterUsage_SynchronisationPoint <em>Output Parameter Usage Synchronisation Point</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.SynchronisationPointImpl#getForkAction_SynchronisationPoint <em>Fork Action Synchronisation Point</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.SynchronisationPointImpl#getSynchronousForkedBehaviours_SynchronisationPoint <em>Synchronous Forked Behaviours Synchronisation Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SynchronisationPointImpl extends EntityImpl implements SynchronisationPoint {

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
    protected SynchronisationPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.SYNCHRONISATION_POINT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<VariableUsage> getOutputParameterUsage_SynchronisationPoint() {
        return (EList<VariableUsage>) eDynamicGet(
                SeffPackage.SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT,
                SeffPackage.Literals.SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ForkAction getForkAction_SynchronisationPoint() {
        return (ForkAction) eDynamicGet(SeffPackage.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT,
                SeffPackage.Literals.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetForkAction_SynchronisationPoint(ForkAction newForkAction_SynchronisationPoint,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newForkAction_SynchronisationPoint,
                SeffPackage.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setForkAction_SynchronisationPoint(ForkAction newForkAction_SynchronisationPoint) {
        eDynamicSet(SeffPackage.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT,
                SeffPackage.Literals.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT,
                newForkAction_SynchronisationPoint);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<ForkedBehaviour> getSynchronousForkedBehaviours_SynchronisationPoint() {
        return (EList<ForkedBehaviour>) eDynamicGet(
                SeffPackage.SYNCHRONISATION_POINT__SYNCHRONOUS_FORKED_BEHAVIOURS_SYNCHRONISATION_POINT,
                SeffPackage.Literals.SYNCHRONISATION_POINT__SYNCHRONOUS_FORKED_BEHAVIOURS_SYNCHRONISATION_POINT, true,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SeffPackage.SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getOutputParameterUsage_SynchronisationPoint())
                    .basicAdd(otherEnd, msgs);
        case SeffPackage.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetForkAction_SynchronisationPoint((ForkAction) otherEnd, msgs);
        case SeffPackage.SYNCHRONISATION_POINT__SYNCHRONOUS_FORKED_BEHAVIOURS_SYNCHRONISATION_POINT:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getSynchronousForkedBehaviours_SynchronisationPoint())
                    .basicAdd(otherEnd, msgs);
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
        case SeffPackage.SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT:
            return ((InternalEList<?>) getOutputParameterUsage_SynchronisationPoint()).basicRemove(otherEnd, msgs);
        case SeffPackage.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT:
            return basicSetForkAction_SynchronisationPoint(null, msgs);
        case SeffPackage.SYNCHRONISATION_POINT__SYNCHRONOUS_FORKED_BEHAVIOURS_SYNCHRONISATION_POINT:
            return ((InternalEList<?>) getSynchronousForkedBehaviours_SynchronisationPoint()).basicRemove(otherEnd,
                    msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case SeffPackage.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT:
            return eInternalContainer().eInverseRemove(this,
                    SeffPackage.FORK_ACTION__SYNCHRONISING_BEHAVIOURS_FORK_ACTION, ForkAction.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SeffPackage.SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT:
            return getOutputParameterUsage_SynchronisationPoint();
        case SeffPackage.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT:
            return getForkAction_SynchronisationPoint();
        case SeffPackage.SYNCHRONISATION_POINT__SYNCHRONOUS_FORKED_BEHAVIOURS_SYNCHRONISATION_POINT:
            return getSynchronousForkedBehaviours_SynchronisationPoint();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case SeffPackage.SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT:
            getOutputParameterUsage_SynchronisationPoint().clear();
            getOutputParameterUsage_SynchronisationPoint().addAll((Collection<? extends VariableUsage>) newValue);
            return;
        case SeffPackage.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT:
            setForkAction_SynchronisationPoint((ForkAction) newValue);
            return;
        case SeffPackage.SYNCHRONISATION_POINT__SYNCHRONOUS_FORKED_BEHAVIOURS_SYNCHRONISATION_POINT:
            getSynchronousForkedBehaviours_SynchronisationPoint().clear();
            getSynchronousForkedBehaviours_SynchronisationPoint()
                    .addAll((Collection<? extends ForkedBehaviour>) newValue);
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
        case SeffPackage.SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT:
            getOutputParameterUsage_SynchronisationPoint().clear();
            return;
        case SeffPackage.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT:
            setForkAction_SynchronisationPoint((ForkAction) null);
            return;
        case SeffPackage.SYNCHRONISATION_POINT__SYNCHRONOUS_FORKED_BEHAVIOURS_SYNCHRONISATION_POINT:
            getSynchronousForkedBehaviours_SynchronisationPoint().clear();
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
        case SeffPackage.SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT:
            return !getOutputParameterUsage_SynchronisationPoint().isEmpty();
        case SeffPackage.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT:
            return getForkAction_SynchronisationPoint() != null;
        case SeffPackage.SYNCHRONISATION_POINT__SYNCHRONOUS_FORKED_BEHAVIOURS_SYNCHRONISATION_POINT:
            return !getSynchronousForkedBehaviours_SynchronisationPoint().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //SynchronisationPointImpl
