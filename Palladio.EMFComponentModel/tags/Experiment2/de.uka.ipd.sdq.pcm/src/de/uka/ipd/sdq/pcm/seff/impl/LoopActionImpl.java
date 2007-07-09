
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.seff.IterationCount;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
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
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.LoopActionImpl#getIterations_LoopAction <em>Iterations Loop Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopActionImpl extends AbstractLoopActionImpl implements LoopAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getIterations_LoopAction() <em>Iterations Loop Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations_LoopAction()
	 * @generated
	 * @ordered
	 */
	protected IterationCount iterations_LoopAction;


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
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.LOOP_ACTION;
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
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
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
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
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeffPackage.LOOP_ACTION__ITERATIONS_LOOP_ACTION:
				return iterations_LoopAction != null;
		}
		return super.eIsSet(featureID);
	}

} //LoopActionImpl
