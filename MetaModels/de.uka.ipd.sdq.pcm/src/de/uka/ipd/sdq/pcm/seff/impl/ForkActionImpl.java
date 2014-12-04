/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Fork Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.ForkActionImpl#getAsynchronousForkedBehaviours_ForkAction
 * <em>Asynchronous Forked Behaviours Fork Action</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ForkActionImpl#getSynchronisingBehaviours_ForkAction <em>
 * Synchronising Behaviours Fork Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForkActionImpl extends AbstractInternalControlFlowActionImpl implements ForkAction {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the ' {@link #getAsynchronousForkedBehaviours_ForkAction()
     * <em>Asynchronous Forked Behaviours Fork Action</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAsynchronousForkedBehaviours_ForkAction()
     * @generated
     * @ordered
     */
    protected EList<ForkedBehaviour> asynchronousForkedBehaviours_ForkAction;

    /**
     * The cached value of the '{@link #getSynchronisingBehaviours_ForkAction()
     * <em>Synchronising Behaviours Fork Action</em>}' containment reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getSynchronisingBehaviours_ForkAction()
     * @generated
     * @ordered
     */
    protected SynchronisationPoint synchronisingBehaviours_ForkAction;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ForkActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.FORK_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ForkedBehaviour> getAsynchronousForkedBehaviours_ForkAction() {
        if (this.asynchronousForkedBehaviours_ForkAction == null) {
            this.asynchronousForkedBehaviours_ForkAction = new EObjectContainmentWithInverseEList<ForkedBehaviour>(
                    ForkedBehaviour.class, this, SeffPackage.FORK_ACTION__ASYNCHRONOUS_FORKED_BEHAVIOURS_FORK_ACTION,
                    SeffPackage.FORKED_BEHAVIOUR__FORK_ACTION_FORKED_BEHAIVOUR);
        }
        return this.asynchronousForkedBehaviours_ForkAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SynchronisationPoint getSynchronisingBehaviours_ForkAction() {
        return this.synchronisingBehaviours_ForkAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetSynchronisingBehaviours_ForkAction(
            final SynchronisationPoint newSynchronisingBehaviours_ForkAction, NotificationChain msgs) {
        final SynchronisationPoint oldSynchronisingBehaviours_ForkAction = this.synchronisingBehaviours_ForkAction;
        this.synchronisingBehaviours_ForkAction = newSynchronisingBehaviours_ForkAction;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SeffPackage.FORK_ACTION__SYNCHRONISING_BEHAVIOURS_FORK_ACTION,
                    oldSynchronisingBehaviours_ForkAction, newSynchronisingBehaviours_ForkAction);
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
    public void setSynchronisingBehaviours_ForkAction(final SynchronisationPoint newSynchronisingBehaviours_ForkAction) {
        if (newSynchronisingBehaviours_ForkAction != this.synchronisingBehaviours_ForkAction) {
            NotificationChain msgs = null;
            if (this.synchronisingBehaviours_ForkAction != null) {
                msgs = ((InternalEObject) this.synchronisingBehaviours_ForkAction).eInverseRemove(this,
                        SeffPackage.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT,
                        SynchronisationPoint.class, msgs);
            }
            if (newSynchronisingBehaviours_ForkAction != null) {
                msgs = ((InternalEObject) newSynchronisingBehaviours_ForkAction).eInverseAdd(this,
                        SeffPackage.SYNCHRONISATION_POINT__FORK_ACTION_SYNCHRONISATION_POINT,
                        SynchronisationPoint.class, msgs);
            }
            msgs = this.basicSetSynchronisingBehaviours_ForkAction(newSynchronisingBehaviours_ForkAction, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.FORK_ACTION__SYNCHRONISING_BEHAVIOURS_FORK_ACTION,
                    newSynchronisingBehaviours_ForkAction, newSynchronisingBehaviours_ForkAction));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SeffPackage.FORK_ACTION__ASYNCHRONOUS_FORKED_BEHAVIOURS_FORK_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getAsynchronousForkedBehaviours_ForkAction()).basicAdd(otherEnd, msgs);
        case SeffPackage.FORK_ACTION__SYNCHRONISING_BEHAVIOURS_FORK_ACTION:
            if (this.synchronisingBehaviours_ForkAction != null) {
                msgs = ((InternalEObject) this.synchronisingBehaviours_ForkAction).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - SeffPackage.FORK_ACTION__SYNCHRONISING_BEHAVIOURS_FORK_ACTION, null,
                        msgs);
            }
            return this.basicSetSynchronisingBehaviours_ForkAction((SynchronisationPoint) otherEnd, msgs);
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
        case SeffPackage.FORK_ACTION__ASYNCHRONOUS_FORKED_BEHAVIOURS_FORK_ACTION:
            return ((InternalEList<?>) this.getAsynchronousForkedBehaviours_ForkAction()).basicRemove(otherEnd, msgs);
        case SeffPackage.FORK_ACTION__SYNCHRONISING_BEHAVIOURS_FORK_ACTION:
            return this.basicSetSynchronisingBehaviours_ForkAction(null, msgs);
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
        case SeffPackage.FORK_ACTION__ASYNCHRONOUS_FORKED_BEHAVIOURS_FORK_ACTION:
            return this.getAsynchronousForkedBehaviours_ForkAction();
        case SeffPackage.FORK_ACTION__SYNCHRONISING_BEHAVIOURS_FORK_ACTION:
            return this.getSynchronisingBehaviours_ForkAction();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case SeffPackage.FORK_ACTION__ASYNCHRONOUS_FORKED_BEHAVIOURS_FORK_ACTION:
            this.getAsynchronousForkedBehaviours_ForkAction().clear();
            this.getAsynchronousForkedBehaviours_ForkAction().addAll((Collection<? extends ForkedBehaviour>) newValue);
            return;
        case SeffPackage.FORK_ACTION__SYNCHRONISING_BEHAVIOURS_FORK_ACTION:
            this.setSynchronisingBehaviours_ForkAction((SynchronisationPoint) newValue);
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
        case SeffPackage.FORK_ACTION__ASYNCHRONOUS_FORKED_BEHAVIOURS_FORK_ACTION:
            this.getAsynchronousForkedBehaviours_ForkAction().clear();
            return;
        case SeffPackage.FORK_ACTION__SYNCHRONISING_BEHAVIOURS_FORK_ACTION:
            this.setSynchronisingBehaviours_ForkAction((SynchronisationPoint) null);
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
        case SeffPackage.FORK_ACTION__ASYNCHRONOUS_FORKED_BEHAVIOURS_FORK_ACTION:
            return this.asynchronousForkedBehaviours_ForkAction != null
            && !this.asynchronousForkedBehaviours_ForkAction.isEmpty();
        case SeffPackage.FORK_ACTION__SYNCHRONISING_BEHAVIOURS_FORK_ACTION:
            return this.synchronisingBehaviours_ForkAction != null;
        }
        return super.eIsSet(featureID);
    }

} // ForkActionImpl
