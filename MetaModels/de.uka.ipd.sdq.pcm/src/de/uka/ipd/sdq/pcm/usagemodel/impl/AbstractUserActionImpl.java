/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract User Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.AbstractUserActionImpl#getSuccessor <em>Successor
 * </em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.AbstractUserActionImpl#getPredecessor <em>
 * Predecessor</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.usagemodel.impl.AbstractUserActionImpl#getScenarioBehaviour_AbstractUserAction
 * <em>Scenario Behaviour Abstract User Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractUserActionImpl extends EntityImpl implements AbstractUserAction {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getSuccessor() <em>Successor</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSuccessor()
     * @generated
     * @ordered
     */
    protected AbstractUserAction successor;
    /**
     * The cached value of the '{@link #getPredecessor() <em>Predecessor</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPredecessor()
     * @generated
     * @ordered
     */
    protected AbstractUserAction predecessor;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AbstractUserActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.ABSTRACT_USER_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AbstractUserAction getSuccessor() {
        if (this.successor != null && ((EObject) this.successor).eIsProxy()) {
            final InternalEObject oldSuccessor = (InternalEObject) this.successor;
            this.successor = (AbstractUserAction) this.eResolveProxy(oldSuccessor);
            if (this.successor != oldSuccessor) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, oldSuccessor, this.successor));
                }
            }
        }
        return this.successor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AbstractUserAction basicGetSuccessor() {
        return this.successor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetSuccessor(final AbstractUserAction newSuccessor, NotificationChain msgs) {
        final AbstractUserAction oldSuccessor = this.successor;
        this.successor = newSuccessor;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, oldSuccessor, newSuccessor);
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
    public void setSuccessor(final AbstractUserAction newSuccessor) {
        if (newSuccessor != this.successor) {
            NotificationChain msgs = null;
            if (this.successor != null) {
                msgs = ((InternalEObject) this.successor).eInverseRemove(this,
                        UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, AbstractUserAction.class, msgs);
            }
            if (newSuccessor != null) {
                msgs = ((InternalEObject) newSuccessor).eInverseAdd(this,
                        UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, AbstractUserAction.class, msgs);
            }
            msgs = this.basicSetSuccessor(newSuccessor, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, newSuccessor, newSuccessor));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AbstractUserAction getPredecessor() {
        if (this.predecessor != null && ((EObject) this.predecessor).eIsProxy()) {
            final InternalEObject oldPredecessor = (InternalEObject) this.predecessor;
            this.predecessor = (AbstractUserAction) this.eResolveProxy(oldPredecessor);
            if (this.predecessor != oldPredecessor) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, oldPredecessor, this.predecessor));
                }
            }
        }
        return this.predecessor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AbstractUserAction basicGetPredecessor() {
        return this.predecessor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetPredecessor(final AbstractUserAction newPredecessor, NotificationChain msgs) {
        final AbstractUserAction oldPredecessor = this.predecessor;
        this.predecessor = newPredecessor;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, oldPredecessor, newPredecessor);
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
    public void setPredecessor(final AbstractUserAction newPredecessor) {
        if (newPredecessor != this.predecessor) {
            NotificationChain msgs = null;
            if (this.predecessor != null) {
                msgs = ((InternalEObject) this.predecessor).eInverseRemove(this,
                        UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, AbstractUserAction.class, msgs);
            }
            if (newPredecessor != null) {
                msgs = ((InternalEObject) newPredecessor).eInverseAdd(this,
                        UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, AbstractUserAction.class, msgs);
            }
            msgs = this.basicSetPredecessor(newPredecessor, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, newPredecessor, newPredecessor));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ScenarioBehaviour getScenarioBehaviour_AbstractUserAction() {
        if (this.eContainerFeatureID() != UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION) {
            return null;
        }
        return (ScenarioBehaviour) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetScenarioBehaviour_AbstractUserAction(
            final ScenarioBehaviour newScenarioBehaviour_AbstractUserAction, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newScenarioBehaviour_AbstractUserAction,
                UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setScenarioBehaviour_AbstractUserAction(final ScenarioBehaviour newScenarioBehaviour_AbstractUserAction) {
        if (newScenarioBehaviour_AbstractUserAction != this.eInternalContainer()
                || (this.eContainerFeatureID() != UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION && newScenarioBehaviour_AbstractUserAction != null)) {
            if (EcoreUtil.isAncestor(this, newScenarioBehaviour_AbstractUserAction)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newScenarioBehaviour_AbstractUserAction != null) {
                msgs = ((InternalEObject) newScenarioBehaviour_AbstractUserAction)
                        .eInverseAdd(this, UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR,
                                ScenarioBehaviour.class, msgs);
            }
            msgs = this.basicSetScenarioBehaviour_AbstractUserAction(newScenarioBehaviour_AbstractUserAction, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION,
                    newScenarioBehaviour_AbstractUserAction, newScenarioBehaviour_AbstractUserAction));
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
            if (this.successor != null) {
                msgs = ((InternalEObject) this.successor).eInverseRemove(this,
                        UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, AbstractUserAction.class, msgs);
            }
            return this.basicSetSuccessor((AbstractUserAction) otherEnd, msgs);
        case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
            if (this.predecessor != null) {
                msgs = ((InternalEObject) this.predecessor).eInverseRemove(this,
                        UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, AbstractUserAction.class, msgs);
            }
            return this.basicSetPredecessor((AbstractUserAction) otherEnd, msgs);
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetScenarioBehaviour_AbstractUserAction((ScenarioBehaviour) otherEnd, msgs);
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
            return this.basicSetSuccessor(null, msgs);
        case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
            return this.basicSetPredecessor(null, msgs);
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            return this.basicSetScenarioBehaviour_AbstractUserAction(null, msgs);
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            return this.eInternalContainer().eInverseRemove(this,
                    UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR, ScenarioBehaviour.class, msgs);
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
            if (resolve) {
                return this.getSuccessor();
            }
            return this.basicGetSuccessor();
        case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
            if (resolve) {
                return this.getPredecessor();
            }
            return this.basicGetPredecessor();
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            return this.getScenarioBehaviour_AbstractUserAction();
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
            this.setSuccessor((AbstractUserAction) newValue);
            return;
        case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
            this.setPredecessor((AbstractUserAction) newValue);
            return;
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            this.setScenarioBehaviour_AbstractUserAction((ScenarioBehaviour) newValue);
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
            this.setSuccessor((AbstractUserAction) null);
            return;
        case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
            this.setPredecessor((AbstractUserAction) null);
            return;
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            this.setScenarioBehaviour_AbstractUserAction((ScenarioBehaviour) null);
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
            return this.successor != null;
        case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
            return this.predecessor != null;
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            return this.getScenarioBehaviour_AbstractUserAction() != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractUserActionImpl
