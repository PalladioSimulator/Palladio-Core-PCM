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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.InternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingInternalBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Internal Call Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getPredecessor_AbstractAction <em>
 * Predecessor Abstract Action</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getSuccessor_AbstractAction <em>
 * Successor Abstract Action</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getResourceDemandingBehaviour_AbstractAction
 * <em>Resource Demanding Behaviour Abstract Action</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getResourceDemand_Action <em>
 * Resource Demand Action</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getInfrastructureCall__Action <em>
 * Infrastructure Call Action</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getResourceCall__Action <em>
 * Resource Call Action</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getCalledResourceDemandingInternalBehaviour
 * <em>Called Resource Demanding Internal Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalCallActionImpl extends CallActionImpl implements InternalCallAction {
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
     * The cached value of the '{@link #getResourceDemand_Action() <em>Resource Demand Action</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getResourceDemand_Action()
     * @generated
     * @ordered
     */
    protected EList<ParametricResourceDemand> resourceDemand_Action;
    /**
     * The cached value of the '{@link #getInfrastructureCall__Action()
     * <em>Infrastructure Call Action</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getInfrastructureCall__Action()
     * @generated
     * @ordered
     */
    protected EList<InfrastructureCall> infrastructureCall__Action;
    /**
     * The cached value of the '{@link #getResourceCall__Action() <em>Resource Call Action</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getResourceCall__Action()
     * @generated
     * @ordered
     */
    protected EList<ResourceCall> resourceCall__Action;
    /**
     * The cached value of the '{@link #getCalledResourceDemandingInternalBehaviour()
     * <em>Called Resource Demanding Internal Behaviour</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getCalledResourceDemandingInternalBehaviour()
     * @generated
     * @ordered
     */
    protected ResourceDemandingInternalBehaviour calledResourceDemandingInternalBehaviour;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InternalCallActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.INTERNAL_CALL_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AbstractAction getPredecessor_AbstractAction() {
        if (this.predecessor_AbstractAction != null && this.predecessor_AbstractAction.eIsProxy()) {
            final InternalEObject oldPredecessor_AbstractAction = (InternalEObject) this.predecessor_AbstractAction;
            this.predecessor_AbstractAction = (AbstractAction) this.eResolveProxy(oldPredecessor_AbstractAction);
            if (this.predecessor_AbstractAction != oldPredecessor_AbstractAction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION,
                            oldPredecessor_AbstractAction, this.predecessor_AbstractAction));
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
                    SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION, oldPredecessor_AbstractAction,
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
                    SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION, newPredecessor_AbstractAction,
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
        if (this.successor_AbstractAction != null && this.successor_AbstractAction.eIsProxy()) {
            final InternalEObject oldSuccessor_AbstractAction = (InternalEObject) this.successor_AbstractAction;
            this.successor_AbstractAction = (AbstractAction) this.eResolveProxy(oldSuccessor_AbstractAction);
            if (this.successor_AbstractAction != oldSuccessor_AbstractAction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION, oldSuccessor_AbstractAction,
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
                    SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION, oldSuccessor_AbstractAction,
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
                    SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION, newSuccessor_AbstractAction,
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
        if (this.eContainerFeatureID() != SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION) {
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
                SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION, msgs);
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
                || (this.eContainerFeatureID() != SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION && newResourceDemandingBehaviour_AbstractAction != null)) {
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
                    SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION,
                    newResourceDemandingBehaviour_AbstractAction, newResourceDemandingBehaviour_AbstractAction));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ParametricResourceDemand> getResourceDemand_Action() {
        if (this.resourceDemand_Action == null) {
            this.resourceDemand_Action = new EObjectContainmentWithInverseEList<ParametricResourceDemand>(
                    ParametricResourceDemand.class, this, SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION,
                    SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND);
        }
        return this.resourceDemand_Action;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<InfrastructureCall> getInfrastructureCall__Action() {
        if (this.infrastructureCall__Action == null) {
            this.infrastructureCall__Action = new EObjectContainmentWithInverseEList<InfrastructureCall>(
                    InfrastructureCall.class, this, SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION,
                    SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL);
        }
        return this.infrastructureCall__Action;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ResourceCall> getResourceCall__Action() {
        if (this.resourceCall__Action == null) {
            this.resourceCall__Action = new EObjectContainmentWithInverseEList<ResourceCall>(ResourceCall.class, this,
                    SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION,
                    SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL);
        }
        return this.resourceCall__Action;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceDemandingInternalBehaviour getCalledResourceDemandingInternalBehaviour() {
        if (this.calledResourceDemandingInternalBehaviour != null
                && this.calledResourceDemandingInternalBehaviour.eIsProxy()) {
            final InternalEObject oldCalledResourceDemandingInternalBehaviour = (InternalEObject) this.calledResourceDemandingInternalBehaviour;
            this.calledResourceDemandingInternalBehaviour = (ResourceDemandingInternalBehaviour) this
                    .eResolveProxy(oldCalledResourceDemandingInternalBehaviour);
            if (this.calledResourceDemandingInternalBehaviour != oldCalledResourceDemandingInternalBehaviour) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR,
                            oldCalledResourceDemandingInternalBehaviour, this.calledResourceDemandingInternalBehaviour));
                }
            }
        }
        return this.calledResourceDemandingInternalBehaviour;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceDemandingInternalBehaviour basicGetCalledResourceDemandingInternalBehaviour() {
        return this.calledResourceDemandingInternalBehaviour;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCalledResourceDemandingInternalBehaviour(
            final ResourceDemandingInternalBehaviour newCalledResourceDemandingInternalBehaviour) {
        final ResourceDemandingInternalBehaviour oldCalledResourceDemandingInternalBehaviour = this.calledResourceDemandingInternalBehaviour;
        this.calledResourceDemandingInternalBehaviour = newCalledResourceDemandingInternalBehaviour;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR,
                    oldCalledResourceDemandingInternalBehaviour, this.calledResourceDemandingInternalBehaviour));
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
        case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            if (this.predecessor_AbstractAction != null) {
                msgs = ((InternalEObject) this.predecessor_AbstractAction).eInverseRemove(this,
                        SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            }
            return this.basicSetPredecessor_AbstractAction((AbstractAction) otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            if (this.successor_AbstractAction != null) {
                msgs = ((InternalEObject) this.successor_AbstractAction).eInverseRemove(this,
                        SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            }
            return this.basicSetSuccessor_AbstractAction((AbstractAction) otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetResourceDemandingBehaviour_AbstractAction((ResourceDemandingBehaviour) otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getResourceDemand_Action()).basicAdd(
                    otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getInfrastructureCall__Action()).basicAdd(
                    otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getResourceCall__Action()).basicAdd(
                    otherEnd, msgs);
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
        case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            return this.basicSetPredecessor_AbstractAction(null, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            return this.basicSetSuccessor_AbstractAction(null, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return this.basicSetResourceDemandingBehaviour_AbstractAction(null, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
            return ((InternalEList<?>) this.getResourceDemand_Action()).basicRemove(otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
            return ((InternalEList<?>) this.getInfrastructureCall__Action()).basicRemove(otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
            return ((InternalEList<?>) this.getResourceCall__Action()).basicRemove(otherEnd, msgs);
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
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
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
        case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            if (resolve) {
                return this.getPredecessor_AbstractAction();
            }
            return this.basicGetPredecessor_AbstractAction();
        case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            if (resolve) {
                return this.getSuccessor_AbstractAction();
            }
            return this.basicGetSuccessor_AbstractAction();
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return this.getResourceDemandingBehaviour_AbstractAction();
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
            return this.getResourceDemand_Action();
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
            return this.getInfrastructureCall__Action();
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
            return this.getResourceCall__Action();
        case SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            if (resolve) {
                return this.getCalledResourceDemandingInternalBehaviour();
            }
            return this.basicGetCalledResourceDemandingInternalBehaviour();
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
        case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            this.setPredecessor_AbstractAction((AbstractAction) newValue);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            this.setSuccessor_AbstractAction((AbstractAction) newValue);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            this.setResourceDemandingBehaviour_AbstractAction((ResourceDemandingBehaviour) newValue);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
            this.getResourceDemand_Action().clear();
            this.getResourceDemand_Action().addAll((Collection<? extends ParametricResourceDemand>) newValue);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
            this.getInfrastructureCall__Action().clear();
            this.getInfrastructureCall__Action().addAll((Collection<? extends InfrastructureCall>) newValue);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
            this.getResourceCall__Action().clear();
            this.getResourceCall__Action().addAll((Collection<? extends ResourceCall>) newValue);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            this.setCalledResourceDemandingInternalBehaviour((ResourceDemandingInternalBehaviour) newValue);
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
        case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            this.setPredecessor_AbstractAction((AbstractAction) null);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            this.setSuccessor_AbstractAction((AbstractAction) null);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            this.setResourceDemandingBehaviour_AbstractAction((ResourceDemandingBehaviour) null);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
            this.getResourceDemand_Action().clear();
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
            this.getInfrastructureCall__Action().clear();
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
            this.getResourceCall__Action().clear();
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            this.setCalledResourceDemandingInternalBehaviour((ResourceDemandingInternalBehaviour) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            return this.predecessor_AbstractAction != null;
        case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            return this.successor_AbstractAction != null;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return this.getResourceDemandingBehaviour_AbstractAction() != null;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
            return this.resourceDemand_Action != null && !this.resourceDemand_Action.isEmpty();
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
            return this.infrastructureCall__Action != null && !this.infrastructureCall__Action.isEmpty();
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
            return this.resourceCall__Action != null && !this.resourceCall__Action.isEmpty();
        case SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            return this.calledResourceDemandingInternalBehaviour != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(final int derivedFeatureID, final Class<?> baseClass) {
        if (baseClass == AbstractAction.class) {
            switch (derivedFeatureID) {
            case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
                return SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;
            case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
                return SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;
            case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
                return SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;
            default:
                return -1;
            }
        }
        if (baseClass == AbstractInternalControlFlowAction.class) {
            switch (derivedFeatureID) {
            case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
                return SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION;
            case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
                return SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION;
            case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
                return SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(final int baseFeatureID, final Class<?> baseClass) {
        if (baseClass == AbstractAction.class) {
            switch (baseFeatureID) {
            case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
                return SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION;
            case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
                return SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION;
            case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
                return SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;
            default:
                return -1;
            }
        }
        if (baseClass == AbstractInternalControlFlowAction.class) {
            switch (baseFeatureID) {
            case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
                return SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION;
            case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION:
                return SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION;
            case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION:
                return SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // InternalCallActionImpl
