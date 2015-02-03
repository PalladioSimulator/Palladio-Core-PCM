/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Abstract Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractActionImpl#getPredecessor_AbstractAction <em>
 * Predecessor Abstract Action</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractActionImpl#getSuccessor_AbstractAction <em>
 * Successor Abstract Action</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.AbstractActionImpl#getResourceDemandingBehaviour_AbstractAction
 * <em>Resource Demanding Behaviour Abstract Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractActionImpl extends EntityImpl implements AbstractAction {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getPredecessor_AbstractAction()
     * <em>Predecessor Abstract Action</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getPredecessor_AbstractAction()
     * @generated
     * @ordered
     */
    protected AbstractAction predecessor_AbstractAction;

    /**
     * The cached value of the '{@link #getSuccessor_AbstractAction()
     * <em>Successor Abstract Action</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSuccessor_AbstractAction()
     * @generated
     * @ordered
     */
    protected AbstractAction successor_AbstractAction;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AbstractActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.ABSTRACT_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AbstractAction getPredecessor_AbstractAction() {
        if (this.predecessor_AbstractAction != null && ((EObject) this.predecessor_AbstractAction).eIsProxy()) {
            final InternalEObject oldPredecessor_AbstractAction = (InternalEObject) this.predecessor_AbstractAction;
            this.predecessor_AbstractAction = (AbstractAction) this.eResolveProxy(oldPredecessor_AbstractAction);
            if (this.predecessor_AbstractAction != oldPredecessor_AbstractAction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, oldPredecessor_AbstractAction,
                            this.predecessor_AbstractAction));
                }
            }
        }
        return this.predecessor_AbstractAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AbstractAction basicGetPredecessor_AbstractAction() {
        return this.predecessor_AbstractAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetPredecessor_AbstractAction(final AbstractAction newPredecessor_AbstractAction,
            NotificationChain msgs) {
        final AbstractAction oldPredecessor_AbstractAction = this.predecessor_AbstractAction;
        this.predecessor_AbstractAction = newPredecessor_AbstractAction;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, oldPredecessor_AbstractAction,
                    newPredecessor_AbstractAction);
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
    public void setPredecessor_AbstractAction(final AbstractAction newPredecessor_AbstractAction) {
        if (newPredecessor_AbstractAction != this.predecessor_AbstractAction) {
            NotificationChain msgs = null;
            if (this.predecessor_AbstractAction != null) {
                msgs = ((InternalEObject) this.predecessor_AbstractAction).eInverseRemove(this,
                        SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            }
            if (newPredecessor_AbstractAction != null) {
                msgs = ((InternalEObject) newPredecessor_AbstractAction).eInverseAdd(this,
                        SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            }
            msgs = this.basicSetPredecessor_AbstractAction(newPredecessor_AbstractAction, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, newPredecessor_AbstractAction,
                    newPredecessor_AbstractAction));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AbstractAction getSuccessor_AbstractAction() {
        if (this.successor_AbstractAction != null && ((EObject) this.successor_AbstractAction).eIsProxy()) {
            final InternalEObject oldSuccessor_AbstractAction = (InternalEObject) this.successor_AbstractAction;
            this.successor_AbstractAction = (AbstractAction) this.eResolveProxy(oldSuccessor_AbstractAction);
            if (this.successor_AbstractAction != oldSuccessor_AbstractAction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, oldSuccessor_AbstractAction,
                            this.successor_AbstractAction));
                }
            }
        }
        return this.successor_AbstractAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AbstractAction basicGetSuccessor_AbstractAction() {
        return this.successor_AbstractAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetSuccessor_AbstractAction(final AbstractAction newSuccessor_AbstractAction,
            NotificationChain msgs) {
        final AbstractAction oldSuccessor_AbstractAction = this.successor_AbstractAction;
        this.successor_AbstractAction = newSuccessor_AbstractAction;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, oldSuccessor_AbstractAction,
                    newSuccessor_AbstractAction);
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
    public void setSuccessor_AbstractAction(final AbstractAction newSuccessor_AbstractAction) {
        if (newSuccessor_AbstractAction != this.successor_AbstractAction) {
            NotificationChain msgs = null;
            if (this.successor_AbstractAction != null) {
                msgs = ((InternalEObject) this.successor_AbstractAction).eInverseRemove(this,
                        SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            }
            if (newSuccessor_AbstractAction != null) {
                msgs = ((InternalEObject) newSuccessor_AbstractAction).eInverseAdd(this,
                        SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            }
            msgs = this.basicSetSuccessor_AbstractAction(newSuccessor_AbstractAction, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, newSuccessor_AbstractAction,
                    newSuccessor_AbstractAction));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceDemandingBehaviour getResourceDemandingBehaviour_AbstractAction() {
        if (this.eContainerFeatureID() != SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION) {
            return null;
        }
        return (ResourceDemandingBehaviour) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetResourceDemandingBehaviour_AbstractAction(
            final ResourceDemandingBehaviour newResourceDemandingBehaviour_AbstractAction, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newResourceDemandingBehaviour_AbstractAction,
                SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceDemandingBehaviour_AbstractAction(
            final ResourceDemandingBehaviour newResourceDemandingBehaviour_AbstractAction) {
        if (newResourceDemandingBehaviour_AbstractAction != this.eInternalContainer()
                || (this.eContainerFeatureID() != SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION && newResourceDemandingBehaviour_AbstractAction != null)) {
            if (EcoreUtil.isAncestor(this, newResourceDemandingBehaviour_AbstractAction)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newResourceDemandingBehaviour_AbstractAction != null) {
                msgs = ((InternalEObject) newResourceDemandingBehaviour_AbstractAction).eInverseAdd(this,
                        SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR, ResourceDemandingBehaviour.class,
                        msgs);
            }
            msgs = this.basicSetResourceDemandingBehaviour_AbstractAction(newResourceDemandingBehaviour_AbstractAction,
                    msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION,
                    newResourceDemandingBehaviour_AbstractAction, newResourceDemandingBehaviour_AbstractAction));
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
        case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            if (this.predecessor_AbstractAction != null) {
                msgs = ((InternalEObject) this.predecessor_AbstractAction).eInverseRemove(this,
                        SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            }
            return this.basicSetPredecessor_AbstractAction((AbstractAction) otherEnd, msgs);
        case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            if (this.successor_AbstractAction != null) {
                msgs = ((InternalEObject) this.successor_AbstractAction).eInverseRemove(this,
                        SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            }
            return this.basicSetSuccessor_AbstractAction((AbstractAction) otherEnd, msgs);
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetResourceDemandingBehaviour_AbstractAction((ResourceDemandingBehaviour) otherEnd, msgs);
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
        case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            return this.basicSetPredecessor_AbstractAction(null, msgs);
        case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            return this.basicSetSuccessor_AbstractAction(null, msgs);
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return this.basicSetResourceDemandingBehaviour_AbstractAction(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return this.eInternalContainer().eInverseRemove(this,
                    SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR, ResourceDemandingBehaviour.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            if (resolve) {
                return this.getPredecessor_AbstractAction();
            }
            return this.basicGetPredecessor_AbstractAction();
        case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            if (resolve) {
                return this.getSuccessor_AbstractAction();
            }
            return this.basicGetSuccessor_AbstractAction();
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return this.getResourceDemandingBehaviour_AbstractAction();
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
        case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            this.setPredecessor_AbstractAction((AbstractAction) newValue);
            return;
        case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            this.setSuccessor_AbstractAction((AbstractAction) newValue);
            return;
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            this.setResourceDemandingBehaviour_AbstractAction((ResourceDemandingBehaviour) newValue);
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
        case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            this.setPredecessor_AbstractAction((AbstractAction) null);
            return;
        case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            this.setSuccessor_AbstractAction((AbstractAction) null);
            return;
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            this.setResourceDemandingBehaviour_AbstractAction((ResourceDemandingBehaviour) null);
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
        case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            return this.predecessor_AbstractAction != null;
        case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            return this.successor_AbstractAction != null;
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return this.getResourceDemandingBehaviour_AbstractAction() != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractActionImpl
