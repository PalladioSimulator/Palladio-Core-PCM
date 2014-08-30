/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage;
import de.uka.ipd.sdq.context.computed_usage.LoopIteration;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Loop Iteration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.LoopIterationImpl#getLoopaction_LoopIteration
 * <em>Loopaction Loop Iteration</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.LoopIterationImpl#getSpecification_LoopIteration
 * <em>Specification Loop Iteration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopIterationImpl extends EObjectImpl implements LoopIteration {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * The cached value of the '{@link #getLoopaction_LoopIteration()
     * <em>Loopaction Loop Iteration</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLoopaction_LoopIteration()
     * @generated
     * @ordered
     */
    protected AbstractLoopAction loopaction_LoopIteration;

    /**
     * The cached value of the '{@link #getSpecification_LoopIteration()
     * <em>Specification Loop Iteration</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getSpecification_LoopIteration()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable specification_LoopIteration;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected LoopIterationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ComputedUsagePackage.Literals.LOOP_ITERATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractLoopAction getLoopaction_LoopIteration() {
        if (loopaction_LoopIteration != null && loopaction_LoopIteration.eIsProxy()) {
            InternalEObject oldLoopaction_LoopIteration = (InternalEObject) loopaction_LoopIteration;
            loopaction_LoopIteration = (AbstractLoopAction) eResolveProxy(oldLoopaction_LoopIteration);
            if (loopaction_LoopIteration != oldLoopaction_LoopIteration) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ComputedUsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION,
                            oldLoopaction_LoopIteration, loopaction_LoopIteration));
            }
        }
        return loopaction_LoopIteration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractLoopAction basicGetLoopaction_LoopIteration() {
        return loopaction_LoopIteration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLoopaction_LoopIteration(AbstractLoopAction newLoopaction_LoopIteration) {
        AbstractLoopAction oldLoopaction_LoopIteration = loopaction_LoopIteration;
        loopaction_LoopIteration = newLoopaction_LoopIteration;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ComputedUsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION, oldLoopaction_LoopIteration,
                    loopaction_LoopIteration));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PCMRandomVariable getSpecification_LoopIteration() {
        return specification_LoopIteration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetSpecification_LoopIteration(PCMRandomVariable newSpecification_LoopIteration,
            NotificationChain msgs) {
        PCMRandomVariable oldSpecification_LoopIteration = specification_LoopIteration;
        specification_LoopIteration = newSpecification_LoopIteration;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    ComputedUsagePackage.LOOP_ITERATION__SPECIFICATION_LOOP_ITERATION, oldSpecification_LoopIteration,
                    newSpecification_LoopIteration);
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
    public void setSpecification_LoopIteration(PCMRandomVariable newSpecification_LoopIteration) {
        if (newSpecification_LoopIteration != specification_LoopIteration) {
            NotificationChain msgs = null;
            if (specification_LoopIteration != null)
                msgs = ((InternalEObject) specification_LoopIteration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - ComputedUsagePackage.LOOP_ITERATION__SPECIFICATION_LOOP_ITERATION, null, msgs);
            if (newSpecification_LoopIteration != null)
                msgs = ((InternalEObject) newSpecification_LoopIteration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - ComputedUsagePackage.LOOP_ITERATION__SPECIFICATION_LOOP_ITERATION, null, msgs);
            msgs = basicSetSpecification_LoopIteration(newSpecification_LoopIteration, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ComputedUsagePackage.LOOP_ITERATION__SPECIFICATION_LOOP_ITERATION, newSpecification_LoopIteration,
                    newSpecification_LoopIteration));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ComputedUsagePackage.LOOP_ITERATION__SPECIFICATION_LOOP_ITERATION:
            return basicSetSpecification_LoopIteration(null, msgs);
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
        case ComputedUsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION:
            if (resolve)
                return getLoopaction_LoopIteration();
            return basicGetLoopaction_LoopIteration();
        case ComputedUsagePackage.LOOP_ITERATION__SPECIFICATION_LOOP_ITERATION:
            return getSpecification_LoopIteration();
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
        case ComputedUsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION:
            setLoopaction_LoopIteration((AbstractLoopAction) newValue);
            return;
        case ComputedUsagePackage.LOOP_ITERATION__SPECIFICATION_LOOP_ITERATION:
            setSpecification_LoopIteration((PCMRandomVariable) newValue);
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
        case ComputedUsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION:
            setLoopaction_LoopIteration((AbstractLoopAction) null);
            return;
        case ComputedUsagePackage.LOOP_ITERATION__SPECIFICATION_LOOP_ITERATION:
            setSpecification_LoopIteration((PCMRandomVariable) null);
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
        case ComputedUsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION:
            return loopaction_LoopIteration != null;
        case ComputedUsagePackage.LOOP_ITERATION__SPECIFICATION_LOOP_ITERATION:
            return specification_LoopIteration != null;
        }
        return super.eIsSet(featureID);
    }

} // LoopIterationImpl
