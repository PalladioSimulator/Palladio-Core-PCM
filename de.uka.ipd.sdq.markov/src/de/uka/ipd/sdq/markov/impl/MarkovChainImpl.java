/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.markov.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.markov.MarkovPackage;
import de.uka.ipd.sdq.markov.State;
import de.uka.ipd.sdq.markov.Transition;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Chain</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.markov.impl.MarkovChainImpl#getStates <em>States</em>}</li>
 * <li>{@link de.uka.ipd.sdq.markov.impl.MarkovChainImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MarkovChainImpl extends EntityImpl implements MarkovChain {
    /**
     * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getStates()
     * @generated
     * @ordered
     */
    protected EList<State> states;

    /**
     * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTransitions()
     * @generated
     * @ordered
     */
    protected EList<Transition> transitions;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MarkovChainImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MarkovPackage.Literals.MARKOV_CHAIN;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<State> getStates() {
        if (states == null) {
            states = new EObjectContainmentEList<State>(State.class, this, MarkovPackage.MARKOV_CHAIN__STATES);
        }
        return states;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Transition> getTransitions() {
        if (transitions == null) {
            transitions = new EObjectContainmentEList<Transition>(Transition.class, this,
                    MarkovPackage.MARKOV_CHAIN__TRANSITIONS);
        }
        return transitions;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case MarkovPackage.MARKOV_CHAIN__STATES:
            return ((InternalEList<?>) getStates()).basicRemove(otherEnd, msgs);
        case MarkovPackage.MARKOV_CHAIN__TRANSITIONS:
            return ((InternalEList<?>) getTransitions()).basicRemove(otherEnd, msgs);
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
        case MarkovPackage.MARKOV_CHAIN__STATES:
            return getStates();
        case MarkovPackage.MARKOV_CHAIN__TRANSITIONS:
            return getTransitions();
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
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case MarkovPackage.MARKOV_CHAIN__STATES:
            getStates().clear();
            getStates().addAll((Collection<? extends State>) newValue);
            return;
        case MarkovPackage.MARKOV_CHAIN__TRANSITIONS:
            getTransitions().clear();
            getTransitions().addAll((Collection<? extends Transition>) newValue);
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
        case MarkovPackage.MARKOV_CHAIN__STATES:
            getStates().clear();
            return;
        case MarkovPackage.MARKOV_CHAIN__TRANSITIONS:
            getTransitions().clear();
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
        case MarkovPackage.MARKOV_CHAIN__STATES:
            return states != null && !states.isEmpty();
        case MarkovPackage.MARKOV_CHAIN__TRANSITIONS:
            return transitions != null && !transitions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // MarkovChainImpl
