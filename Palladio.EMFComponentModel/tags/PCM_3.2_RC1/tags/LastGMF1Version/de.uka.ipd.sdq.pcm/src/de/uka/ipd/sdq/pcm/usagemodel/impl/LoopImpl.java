
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.LoopIterations;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.LoopImpl#getBodyBehaviour_Loop <em>Body Behaviour Loop</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.LoopImpl#getIterations_Loop <em>Iterations Loop</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopImpl extends AbstractUserActionImpl implements Loop {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getBodyBehaviour_Loop() <em>Body Behaviour Loop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyBehaviour_Loop()
	 * @generated
	 * @ordered
	 */
	protected ScenarioBehaviour bodyBehaviour_Loop = null;

	/**
	 * The cached value of the '{@link #getIterations_Loop() <em>Iterations Loop</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations_Loop()
	 * @generated
	 * @ordered
	 */
	protected EList iterations_Loop = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UsagemodelPackage.Literals.LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioBehaviour getBodyBehaviour_Loop() {
		return bodyBehaviour_Loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyBehaviour_Loop(ScenarioBehaviour newBodyBehaviour_Loop, NotificationChain msgs) {
		ScenarioBehaviour oldBodyBehaviour_Loop = bodyBehaviour_Loop;
		bodyBehaviour_Loop = newBodyBehaviour_Loop;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP, oldBodyBehaviour_Loop, newBodyBehaviour_Loop);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyBehaviour_Loop(ScenarioBehaviour newBodyBehaviour_Loop) {
		if (newBodyBehaviour_Loop != bodyBehaviour_Loop) {
			NotificationChain msgs = null;
			if (bodyBehaviour_Loop != null)
				msgs = ((InternalEObject)bodyBehaviour_Loop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP, null, msgs);
			if (newBodyBehaviour_Loop != null)
				msgs = ((InternalEObject)newBodyBehaviour_Loop).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP, null, msgs);
			msgs = basicSetBodyBehaviour_Loop(newBodyBehaviour_Loop, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP, newBodyBehaviour_Loop, newBodyBehaviour_Loop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getIterations_Loop() {
		if (iterations_Loop == null) {
			iterations_Loop = new EObjectContainmentEList(LoopIterations.class, this, UsagemodelPackage.LOOP__ITERATIONS_LOOP);
		}
		return iterations_Loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				return basicSetBodyBehaviour_Loop(null, msgs);
			case UsagemodelPackage.LOOP__ITERATIONS_LOOP:
				return ((InternalEList)getIterations_Loop()).basicRemove(otherEnd, msgs);
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
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				return getBodyBehaviour_Loop();
			case UsagemodelPackage.LOOP__ITERATIONS_LOOP:
				return getIterations_Loop();
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
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				setBodyBehaviour_Loop((ScenarioBehaviour)newValue);
				return;
			case UsagemodelPackage.LOOP__ITERATIONS_LOOP:
				getIterations_Loop().clear();
				getIterations_Loop().addAll((Collection)newValue);
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
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				setBodyBehaviour_Loop((ScenarioBehaviour)null);
				return;
			case UsagemodelPackage.LOOP__ITERATIONS_LOOP:
				getIterations_Loop().clear();
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
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				return bodyBehaviour_Loop != null;
			case UsagemodelPackage.LOOP__ITERATIONS_LOOP:
				return iterations_Loop != null && !iterations_Loop.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LoopImpl