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
        if (predecessor_AbstractAction != null && ((EObject) predecessor_AbstractAction).eIsProxy()) {
            InternalEObject oldPredecessor_AbstractAction = (InternalEObject) predecessor_AbstractAction;
            predecessor_AbstractAction = (AbstractAction) eResolveProxy(oldPredecessor_AbstractAction);
            if (predecessor_AbstractAction != oldPredecessor_AbstractAction) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, oldPredecessor_AbstractAction,
                            predecessor_AbstractAction));
            }
        }
        return predecessor_AbstractAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractAction basicGetPredecessor_AbstractAction() {
        return predecessor_AbstractAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetPredecessor_AbstractAction(AbstractAction newPredecessor_AbstractAction,
            NotificationChain msgs) {
        AbstractAction oldPredecessor_AbstractAction = predecessor_AbstractAction;
        predecessor_AbstractAction = newPredecessor_AbstractAction;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, oldPredecessor_AbstractAction,
                    newPredecessor_AbstractAction);
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
    @Override
    public void setPredecessor_AbstractAction(AbstractAction newPredecessor_AbstractAction) {
        if (newPredecessor_AbstractAction != predecessor_AbstractAction) {
            NotificationChain msgs = null;
            if (predecessor_AbstractAction != null)
                msgs = ((InternalEObject) predecessor_AbstractAction).eInverseRemove(this,
                        SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            if (newPredecessor_AbstractAction != null)
                msgs = ((InternalEObject) newPredecessor_AbstractAction).eInverseAdd(this,
                        SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            msgs = basicSetPredecessor_AbstractAction(newPredecessor_AbstractAction, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, newPredecessor_AbstractAction,
                    newPredecessor_AbstractAction));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AbstractAction getSuccessor_AbstractAction() {
        if (successor_AbstractAction != null && ((EObject) successor_AbstractAction).eIsProxy()) {
            InternalEObject oldSuccessor_AbstractAction = (InternalEObject) successor_AbstractAction;
            successor_AbstractAction = (AbstractAction) eResolveProxy(oldSuccessor_AbstractAction);
            if (successor_AbstractAction != oldSuccessor_AbstractAction) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, oldSuccessor_AbstractAction,
                            successor_AbstractAction));
            }
        }
        return successor_AbstractAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractAction basicGetSuccessor_AbstractAction() {
        return successor_AbstractAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetSuccessor_AbstractAction(AbstractAction newSuccessor_AbstractAction,
            NotificationChain msgs) {
        AbstractAction oldSuccessor_AbstractAction = successor_AbstractAction;
        successor_AbstractAction = newSuccessor_AbstractAction;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, oldSuccessor_AbstractAction,
                    newSuccessor_AbstractAction);
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
    @Override
    public void setSuccessor_AbstractAction(AbstractAction newSuccessor_AbstractAction) {
        if (newSuccessor_AbstractAction != successor_AbstractAction) {
            NotificationChain msgs = null;
            if (successor_AbstractAction != null)
                msgs = ((InternalEObject) successor_AbstractAction).eInverseRemove(this,
                        SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            if (newSuccessor_AbstractAction != null)
                msgs = ((InternalEObject) newSuccessor_AbstractAction).eInverseAdd(this,
                        SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            msgs = basicSetSuccessor_AbstractAction(newSuccessor_AbstractAction, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, newSuccessor_AbstractAction,
                    newSuccessor_AbstractAction));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceDemandingBehaviour getResourceDemandingBehaviour_AbstractAction() {
        if (eContainerFeatureID() != SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION)
            return null;
        return (ResourceDemandingBehaviour) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetResourceDemandingBehaviour_AbstractAction(
            ResourceDemandingBehaviour newResourceDemandingBehaviour_AbstractAction, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newResourceDemandingBehaviour_AbstractAction,
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
            ResourceDemandingBehaviour newResourceDemandingBehaviour_AbstractAction) {
        if (newResourceDemandingBehaviour_AbstractAction != eInternalContainer()
                || (eContainerFeatureID() != SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION && newResourceDemandingBehaviour_AbstractAction != null)) {
            if (EcoreUtil.isAncestor(this, (EObject) newResourceDemandingBehaviour_AbstractAction))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newResourceDemandingBehaviour_AbstractAction != null)
                msgs = ((InternalEObject) newResourceDemandingBehaviour_AbstractAction).eInverseAdd(this,
                        SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR, ResourceDemandingBehaviour.class,
                        msgs);
            msgs = basicSetResourceDemandingBehaviour_AbstractAction(newResourceDemandingBehaviour_AbstractAction, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION,
                    newResourceDemandingBehaviour_AbstractAction, newResourceDemandingBehaviour_AbstractAction));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            if (predecessor_AbstractAction != null)
                msgs = ((InternalEObject) predecessor_AbstractAction).eInverseRemove(this,
                        SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            return basicSetPredecessor_AbstractAction((AbstractAction) otherEnd, msgs);
        case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            if (successor_AbstractAction != null)
                msgs = ((InternalEObject) successor_AbstractAction).eInverseRemove(this,
                        SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            return basicSetSuccessor_AbstractAction((AbstractAction) otherEnd, msgs);
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetResourceDemandingBehaviour_AbstractAction((ResourceDemandingBehaviour) otherEnd, msgs);
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
        case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            return basicSetPredecessor_AbstractAction(null, msgs);
        case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            return basicSetSuccessor_AbstractAction(null, msgs);
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return basicSetResourceDemandingBehaviour_AbstractAction(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return eInternalContainer().eInverseRemove(this, SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                    ResourceDemandingBehaviour.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            if (resolve)
                return getPredecessor_AbstractAction();
            return basicGetPredecessor_AbstractAction();
        case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            if (resolve)
                return getSuccessor_AbstractAction();
            return basicGetSuccessor_AbstractAction();
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return getResourceDemandingBehaviour_AbstractAction();
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
        case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            setPredecessor_AbstractAction((AbstractAction) newValue);
            return;
        case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            setSuccessor_AbstractAction((AbstractAction) newValue);
            return;
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            setResourceDemandingBehaviour_AbstractAction((ResourceDemandingBehaviour) newValue);
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
        case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            setPredecessor_AbstractAction((AbstractAction) null);
            return;
        case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            setSuccessor_AbstractAction((AbstractAction) null);
            return;
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            setResourceDemandingBehaviour_AbstractAction((ResourceDemandingBehaviour) null);
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
        case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            return predecessor_AbstractAction != null;
        case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            return successor_AbstractAction != null;
        case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return getResourceDemandingBehaviour_AbstractAction() != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractActionImpl
