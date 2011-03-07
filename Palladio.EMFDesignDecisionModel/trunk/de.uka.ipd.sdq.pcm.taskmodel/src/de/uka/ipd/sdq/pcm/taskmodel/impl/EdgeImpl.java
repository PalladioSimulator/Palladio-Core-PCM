/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.taskmodel.impl;

import de.uka.ipd.sdq.pcm.taskmodel.Edge;
import de.uka.ipd.sdq.pcm.taskmodel.Task;
import de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.EdgeImpl#getTransitionProbability <em>Transition Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.EdgeImpl#getSuccessor_Edge <em>Successor Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeImpl extends EObjectImpl implements Edge {
	/**
	 * The default value of the '{@link #getTransitionProbability() <em>Transition Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double TRANSITION_PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTransitionProbability() <em>Transition Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionProbability()
	 * @generated
	 * @ordered
	 */
	protected double transitionProbability = TRANSITION_PROBABILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSuccessor_Edge() <em>Successor Edge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessor_Edge()
	 * @generated
	 * @ordered
	 */
	protected Task successor_Edge;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return taskmodelPackage.Literals.EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTransitionProbability() {
		return transitionProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitionProbability(double newTransitionProbability) {
		double oldTransitionProbability = transitionProbability;
		transitionProbability = newTransitionProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, taskmodelPackage.EDGE__TRANSITION_PROBABILITY, oldTransitionProbability, transitionProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task getSuccessor_Edge() {
		if (successor_Edge != null && successor_Edge.eIsProxy()) {
			InternalEObject oldSuccessor_Edge = (InternalEObject)successor_Edge;
			successor_Edge = (Task)eResolveProxy(oldSuccessor_Edge);
			if (successor_Edge != oldSuccessor_Edge) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, taskmodelPackage.EDGE__SUCCESSOR_EDGE, oldSuccessor_Edge, successor_Edge));
			}
		}
		return successor_Edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task basicGetSuccessor_Edge() {
		return successor_Edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuccessor_Edge(Task newSuccessor_Edge) {
		Task oldSuccessor_Edge = successor_Edge;
		successor_Edge = newSuccessor_Edge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, taskmodelPackage.EDGE__SUCCESSOR_EDGE, oldSuccessor_Edge, successor_Edge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case taskmodelPackage.EDGE__TRANSITION_PROBABILITY:
				return getTransitionProbability();
			case taskmodelPackage.EDGE__SUCCESSOR_EDGE:
				if (resolve) return getSuccessor_Edge();
				return basicGetSuccessor_Edge();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case taskmodelPackage.EDGE__TRANSITION_PROBABILITY:
				setTransitionProbability((Double)newValue);
				return;
			case taskmodelPackage.EDGE__SUCCESSOR_EDGE:
				setSuccessor_Edge((Task)newValue);
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
			case taskmodelPackage.EDGE__TRANSITION_PROBABILITY:
				setTransitionProbability(TRANSITION_PROBABILITY_EDEFAULT);
				return;
			case taskmodelPackage.EDGE__SUCCESSOR_EDGE:
				setSuccessor_Edge((Task)null);
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
			case taskmodelPackage.EDGE__TRANSITION_PROBABILITY:
				return transitionProbability != TRANSITION_PROBABILITY_EDEFAULT;
			case taskmodelPackage.EDGE__SUCCESSOR_EDGE:
				return successor_Edge != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (transitionProbability: ");
		result.append(transitionProbability);
		result.append(')');
		return result.toString();
	}

} //EdgeImpl
