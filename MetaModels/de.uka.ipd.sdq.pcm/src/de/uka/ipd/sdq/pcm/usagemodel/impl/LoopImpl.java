/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Loop</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.LoopImpl#getLoopIteration_Loop <em>Loop Iteration
 * Loop</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.LoopImpl#getBodyBehaviour_Loop <em>Body Behaviour
 * Loop</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopImpl extends AbstractUserActionImpl implements Loop {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getLoopIteration_Loop() <em>Loop Iteration Loop</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLoopIteration_Loop()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable loopIteration_Loop;
    /**
     * The cached value of the '{@link #getBodyBehaviour_Loop() <em>Body Behaviour Loop</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getBodyBehaviour_Loop()
     * @generated
     * @ordered
     */
    protected ScenarioBehaviour bodyBehaviour_Loop;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected LoopImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.LOOP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMRandomVariable getLoopIteration_Loop() {
        return this.loopIteration_Loop;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetLoopIteration_Loop(final PCMRandomVariable newLoopIteration_Loop,
            NotificationChain msgs) {
        final PCMRandomVariable oldLoopIteration_Loop = this.loopIteration_Loop;
        this.loopIteration_Loop = newLoopIteration_Loop;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.LOOP__LOOP_ITERATION_LOOP, oldLoopIteration_Loop, newLoopIteration_Loop);
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
    public void setLoopIteration_Loop(final PCMRandomVariable newLoopIteration_Loop) {
        if (newLoopIteration_Loop != this.loopIteration_Loop) {
            NotificationChain msgs = null;
            if (this.loopIteration_Loop != null) {
                msgs = ((InternalEObject) this.loopIteration_Loop).eInverseRemove(this,
                        CorePackage.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION, PCMRandomVariable.class, msgs);
            }
            if (newLoopIteration_Loop != null) {
                msgs = ((InternalEObject) newLoopIteration_Loop).eInverseAdd(this,
                        CorePackage.PCM_RANDOM_VARIABLE__LOOP_LOOP_ITERATION, PCMRandomVariable.class, msgs);
            }
            msgs = this.basicSetLoopIteration_Loop(newLoopIteration_Loop, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.LOOP__LOOP_ITERATION_LOOP,
                    newLoopIteration_Loop, newLoopIteration_Loop));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ScenarioBehaviour getBodyBehaviour_Loop() {
        return this.bodyBehaviour_Loop;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetBodyBehaviour_Loop(final ScenarioBehaviour newBodyBehaviour_Loop,
            NotificationChain msgs) {
        final ScenarioBehaviour oldBodyBehaviour_Loop = this.bodyBehaviour_Loop;
        this.bodyBehaviour_Loop = newBodyBehaviour_Loop;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP, oldBodyBehaviour_Loop, newBodyBehaviour_Loop);
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
    public void setBodyBehaviour_Loop(final ScenarioBehaviour newBodyBehaviour_Loop) {
        if (newBodyBehaviour_Loop != this.bodyBehaviour_Loop) {
            NotificationChain msgs = null;
            if (this.bodyBehaviour_Loop != null) {
                msgs = ((InternalEObject) this.bodyBehaviour_Loop).eInverseRemove(this,
                        UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR, ScenarioBehaviour.class, msgs);
            }
            if (newBodyBehaviour_Loop != null) {
                msgs = ((InternalEObject) newBodyBehaviour_Loop).eInverseAdd(this,
                        UsagemodelPackage.SCENARIO_BEHAVIOUR__LOOP_SCENARIO_BEHAVIOUR, ScenarioBehaviour.class, msgs);
            }
            msgs = this.basicSetBodyBehaviour_Loop(newBodyBehaviour_Loop, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP,
                    newBodyBehaviour_Loop, newBodyBehaviour_Loop));
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
        case UsagemodelPackage.LOOP__LOOP_ITERATION_LOOP:
            if (this.loopIteration_Loop != null) {
                msgs = ((InternalEObject) this.loopIteration_Loop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - UsagemodelPackage.LOOP__LOOP_ITERATION_LOOP, null, msgs);
            }
            return this.basicSetLoopIteration_Loop((PCMRandomVariable) otherEnd, msgs);
        case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
            if (this.bodyBehaviour_Loop != null) {
                msgs = ((InternalEObject) this.bodyBehaviour_Loop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP, null, msgs);
            }
            return this.basicSetBodyBehaviour_Loop((ScenarioBehaviour) otherEnd, msgs);
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
        case UsagemodelPackage.LOOP__LOOP_ITERATION_LOOP:
            return this.basicSetLoopIteration_Loop(null, msgs);
        case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
            return this.basicSetBodyBehaviour_Loop(null, msgs);
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
        case UsagemodelPackage.LOOP__LOOP_ITERATION_LOOP:
            return this.getLoopIteration_Loop();
        case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
            return this.getBodyBehaviour_Loop();
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
        case UsagemodelPackage.LOOP__LOOP_ITERATION_LOOP:
            this.setLoopIteration_Loop((PCMRandomVariable) newValue);
            return;
        case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
            this.setBodyBehaviour_Loop((ScenarioBehaviour) newValue);
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
        case UsagemodelPackage.LOOP__LOOP_ITERATION_LOOP:
            this.setLoopIteration_Loop((PCMRandomVariable) null);
            return;
        case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
            this.setBodyBehaviour_Loop((ScenarioBehaviour) null);
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
        case UsagemodelPackage.LOOP__LOOP_ITERATION_LOOP:
            return this.loopIteration_Loop != null;
        case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
            return this.bodyBehaviour_Loop != null;
        }
        return super.eIsSet(featureID);
    }

} // LoopImpl
