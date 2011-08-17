
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
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getBodyBehaviour_Loop() <em>Body Behaviour Loop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyBehaviour_Loop()
	 * @generated
	 * @ordered
	 */
	protected ScenarioBehaviour bodyBehaviour_Loop;

	/**
	 * The cached value of the '{@link #getIterations_Loop() <em>Iterations Loop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations_Loop()
	 * @generated
	 * @ordered
	 */
	protected LoopIterations iterations_Loop;


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
	@Override
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
	public LoopIterations getIterations_Loop() {
		return iterations_Loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterations_Loop(LoopIterations newIterations_Loop, NotificationChain msgs) {
		LoopIterations oldIterations_Loop = iterations_Loop;
		iterations_Loop = newIterations_Loop;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsagemodelPackage.LOOP__ITERATIONS_LOOP, oldIterations_Loop, newIterations_Loop);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterations_Loop(LoopIterations newIterations_Loop) {
		if (newIterations_Loop != iterations_Loop) {
			NotificationChain msgs = null;
			if (iterations_Loop != null)
				msgs = ((InternalEObject)iterations_Loop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.LOOP__ITERATIONS_LOOP, null, msgs);
			if (newIterations_Loop != null)
				msgs = ((InternalEObject)newIterations_Loop).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.LOOP__ITERATIONS_LOOP, null, msgs);
			msgs = basicSetIterations_Loop(newIterations_Loop, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.LOOP__ITERATIONS_LOOP, newIterations_Loop, newIterations_Loop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				return basicSetBodyBehaviour_Loop(null, msgs);
			case UsagemodelPackage.LOOP__ITERATIONS_LOOP:
				return basicSetIterations_Loop(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				setBodyBehaviour_Loop((ScenarioBehaviour)newValue);
				return;
			case UsagemodelPackage.LOOP__ITERATIONS_LOOP:
				setIterations_Loop((LoopIterations)newValue);
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
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				setBodyBehaviour_Loop((ScenarioBehaviour)null);
				return;
			case UsagemodelPackage.LOOP__ITERATIONS_LOOP:
				setIterations_Loop((LoopIterations)null);
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
			case UsagemodelPackage.LOOP__BODY_BEHAVIOUR_LOOP:
				return bodyBehaviour_Loop != null;
			case UsagemodelPackage.LOOP__ITERATIONS_LOOP:
				return iterations_Loop != null;
		}
		return super.eIsSet(featureID);
	}

} //LoopImpl
