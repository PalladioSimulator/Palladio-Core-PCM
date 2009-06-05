
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.seff.IterationCount;
import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;

import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.LoopActionImpl#getIterations <em>Iterations</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.LoopActionImpl#getBodyBehaviour_Loop <em>Body Behaviour Loop</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.LoopActionImpl#getIterations_LoopAction <em>Iterations Loop Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopActionImpl extends AbstractResourceDemandingActionImpl implements LoopAction {
	/**
	 * The default value of the '{@link #getIterations() <em>Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations()
	 * @generated
	 * @ordered
	 */
	protected static final String ITERATIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIterations() <em>Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations()
	 * @generated
	 * @ordered
	 */
	protected String iterations = ITERATIONS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBodyBehaviour_Loop() <em>Body Behaviour Loop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyBehaviour_Loop()
	 * @generated
	 * @ordered
	 */
	protected ResourceDemandingBehaviour bodyBehaviour_Loop = null;


	/**
	 * The cached value of the '{@link #getIterations_LoopAction() <em>Iterations Loop Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations_LoopAction()
	 * @generated
	 * @ordered
	 */
	protected IterationCount iterations_LoopAction = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SeffPackage.Literals.LOOP_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIterations() {
		return iterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterations(String newIterations) {
		String oldIterations = iterations;
		iterations = newIterations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.LOOP_ACTION__ITERATIONS, oldIterations, iterations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingBehaviour getBodyBehaviour_Loop() {
		return bodyBehaviour_Loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyBehaviour_Loop(ResourceDemandingBehaviour newBodyBehaviour_Loop, NotificationChain msgs) {
		ResourceDemandingBehaviour oldBodyBehaviour_Loop = bodyBehaviour_Loop;
		bodyBehaviour_Loop = newBodyBehaviour_Loop;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeffPackage.LOOP_ACTION__BODY_BEHAVIOUR_LOOP, oldBodyBehaviour_Loop, newBodyBehaviour_Loop);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyBehaviour_Loop(ResourceDemandingBehaviour newBodyBehaviour_Loop) {
		if (newBodyBehaviour_Loop != bodyBehaviour_Loop) {
			NotificationChain msgs = null;
			if (bodyBehaviour_Loop != null)
				msgs = ((InternalEObject)bodyBehaviour_Loop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SeffPackage.LOOP_ACTION__BODY_BEHAVIOUR_LOOP, null, msgs);
			if (newBodyBehaviour_Loop != null)
				msgs = ((InternalEObject)newBodyBehaviour_Loop).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SeffPackage.LOOP_ACTION__BODY_BEHAVIOUR_LOOP, null, msgs);
			msgs = basicSetBodyBehaviour_Loop(newBodyBehaviour_Loop, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.LOOP_ACTION__BODY_BEHAVIOUR_LOOP, newBodyBehaviour_Loop, newBodyBehaviour_Loop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationCount getIterations_LoopAction() {
		return iterations_LoopAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterations_LoopAction(IterationCount newIterations_LoopAction, NotificationChain msgs) {
		IterationCount oldIterations_LoopAction = iterations_LoopAction;
		iterations_LoopAction = newIterations_LoopAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeffPackage.LOOP_ACTION__ITERATIONS_LOOP_ACTION, oldIterations_LoopAction, newIterations_LoopAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterations_LoopAction(IterationCount newIterations_LoopAction) {
		if (newIterations_LoopAction != iterations_LoopAction) {
			NotificationChain msgs = null;
			if (iterations_LoopAction != null)
				msgs = ((InternalEObject)iterations_LoopAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SeffPackage.LOOP_ACTION__ITERATIONS_LOOP_ACTION, null, msgs);
			if (newIterations_LoopAction != null)
				msgs = ((InternalEObject)newIterations_LoopAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SeffPackage.LOOP_ACTION__ITERATIONS_LOOP_ACTION, null, msgs);
			msgs = basicSetIterations_LoopAction(newIterations_LoopAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.LOOP_ACTION__ITERATIONS_LOOP_ACTION, newIterations_LoopAction, newIterations_LoopAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
				return basicSetBodyBehaviour_Loop(null, msgs);
			case SeffPackage.LOOP_ACTION__ITERATIONS_LOOP_ACTION:
				return basicSetIterations_LoopAction(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.LOOP_ACTION__ITERATIONS:
				return getIterations();
			case SeffPackage.LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
				return getBodyBehaviour_Loop();
			case SeffPackage.LOOP_ACTION__ITERATIONS_LOOP_ACTION:
				return getIterations_LoopAction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SeffPackage.LOOP_ACTION__ITERATIONS:
				setIterations((String)newValue);
				return;
			case SeffPackage.LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
				setBodyBehaviour_Loop((ResourceDemandingBehaviour)newValue);
				return;
			case SeffPackage.LOOP_ACTION__ITERATIONS_LOOP_ACTION:
				setIterations_LoopAction((IterationCount)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case SeffPackage.LOOP_ACTION__ITERATIONS:
				setIterations(ITERATIONS_EDEFAULT);
				return;
			case SeffPackage.LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
				setBodyBehaviour_Loop((ResourceDemandingBehaviour)null);
				return;
			case SeffPackage.LOOP_ACTION__ITERATIONS_LOOP_ACTION:
				setIterations_LoopAction((IterationCount)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeffPackage.LOOP_ACTION__ITERATIONS:
				return ITERATIONS_EDEFAULT == null ? iterations != null : !ITERATIONS_EDEFAULT.equals(iterations);
			case SeffPackage.LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
				return bodyBehaviour_Loop != null;
			case SeffPackage.LOOP_ACTION__ITERATIONS_LOOP_ACTION:
				return iterations_LoopAction != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (iterations: ");
		result.append(iterations);
		result.append(')');
		return result.toString();
	}

} //LoopActionImpl