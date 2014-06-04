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
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.AbstractUserActionImpl#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.AbstractUserActionImpl#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.AbstractUserActionImpl#getScenarioBehaviour_AbstractUserAction <em>Scenario Behaviour Abstract User Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractUserActionImpl extends EntityImpl implements AbstractUserAction {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
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
     * @generated
     */
    protected AbstractUserActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.ABSTRACT_USER_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AbstractUserAction getSuccessor() {
        if (successor != null && ((EObject)successor).eIsProxy()) {
            InternalEObject oldSuccessor = (InternalEObject)successor;
            successor = (AbstractUserAction)eResolveProxy(oldSuccessor);
            if (successor != oldSuccessor) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, oldSuccessor, successor));
            }
        }
        return successor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AbstractUserAction basicGetSuccessor() {
        return successor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSuccessor(AbstractUserAction newSuccessor, NotificationChain msgs) {
        AbstractUserAction oldSuccessor = successor;
        successor = newSuccessor;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, oldSuccessor, newSuccessor);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setSuccessor(AbstractUserAction newSuccessor) {
        if (newSuccessor != successor) {
            NotificationChain msgs = null;
            if (successor != null)
                msgs = ((InternalEObject)successor).eInverseRemove(this, UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, AbstractUserAction.class, msgs);
            if (newSuccessor != null)
                msgs = ((InternalEObject)newSuccessor).eInverseAdd(this, UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, AbstractUserAction.class, msgs);
            msgs = basicSetSuccessor(newSuccessor, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, newSuccessor, newSuccessor));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AbstractUserAction getPredecessor() {
        if (predecessor != null && ((EObject)predecessor).eIsProxy()) {
            InternalEObject oldPredecessor = (InternalEObject)predecessor;
            predecessor = (AbstractUserAction)eResolveProxy(oldPredecessor);
            if (predecessor != oldPredecessor) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, oldPredecessor, predecessor));
            }
        }
        return predecessor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AbstractUserAction basicGetPredecessor() {
        return predecessor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPredecessor(AbstractUserAction newPredecessor, NotificationChain msgs) {
        AbstractUserAction oldPredecessor = predecessor;
        predecessor = newPredecessor;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, oldPredecessor, newPredecessor);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setPredecessor(AbstractUserAction newPredecessor) {
        if (newPredecessor != predecessor) {
            NotificationChain msgs = null;
            if (predecessor != null)
                msgs = ((InternalEObject)predecessor).eInverseRemove(this, UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, AbstractUserAction.class, msgs);
            if (newPredecessor != null)
                msgs = ((InternalEObject)newPredecessor).eInverseAdd(this, UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, AbstractUserAction.class, msgs);
            msgs = basicSetPredecessor(newPredecessor, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, newPredecessor, newPredecessor));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ScenarioBehaviour getScenarioBehaviour_AbstractUserAction() {
        if (eContainerFeatureID() != UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION) return null;
        return (ScenarioBehaviour)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetScenarioBehaviour_AbstractUserAction(
            ScenarioBehaviour newScenarioBehaviour_AbstractUserAction, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newScenarioBehaviour_AbstractUserAction, UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setScenarioBehaviour_AbstractUserAction(ScenarioBehaviour newScenarioBehaviour_AbstractUserAction) {
        if (newScenarioBehaviour_AbstractUserAction != eInternalContainer() || (eContainerFeatureID() != UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION && newScenarioBehaviour_AbstractUserAction != null)) {
            if (EcoreUtil.isAncestor(this, (EObject)newScenarioBehaviour_AbstractUserAction))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newScenarioBehaviour_AbstractUserAction != null)
                msgs = ((InternalEObject)newScenarioBehaviour_AbstractUserAction).eInverseAdd(this, UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR, ScenarioBehaviour.class, msgs);
            msgs = basicSetScenarioBehaviour_AbstractUserAction(newScenarioBehaviour_AbstractUserAction, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION, newScenarioBehaviour_AbstractUserAction, newScenarioBehaviour_AbstractUserAction));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
                if (successor != null)
                    msgs = ((InternalEObject)successor).eInverseRemove(this, UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, AbstractUserAction.class, msgs);
                return basicSetSuccessor((AbstractUserAction)otherEnd, msgs);
            case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
                if (predecessor != null)
                    msgs = ((InternalEObject)predecessor).eInverseRemove(this, UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, AbstractUserAction.class, msgs);
                return basicSetPredecessor((AbstractUserAction)otherEnd, msgs);
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetScenarioBehaviour_AbstractUserAction((ScenarioBehaviour)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
                return basicSetSuccessor(null, msgs);
            case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
                return basicSetPredecessor(null, msgs);
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
                return basicSetScenarioBehaviour_AbstractUserAction(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
                return eInternalContainer().eInverseRemove(this, UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR, ScenarioBehaviour.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
                if (resolve) return getSuccessor();
                return basicGetSuccessor();
            case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
                if (resolve) return getPredecessor();
                return basicGetPredecessor();
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
                return getScenarioBehaviour_AbstractUserAction();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
                setSuccessor((AbstractUserAction)newValue);
                return;
            case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
                setPredecessor((AbstractUserAction)newValue);
                return;
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
                setScenarioBehaviour_AbstractUserAction((ScenarioBehaviour)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
                setSuccessor((AbstractUserAction)null);
                return;
            case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
                setPredecessor((AbstractUserAction)null);
                return;
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
                setScenarioBehaviour_AbstractUserAction((ScenarioBehaviour)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
                return successor != null;
            case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
                return predecessor != null;
            case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
                return getScenarioBehaviour_AbstractUserAction() != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractUserActionImpl
