/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.LoopActionImpl#getIterationCount_LoopAction <em>Iteration Count Loop Action</em>}</li>
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
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getIterationCount_LoopAction() <em>Iteration Count Loop Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationCount_LoopAction()
	 * @generated
	 * @ordered
	 */
	protected PCMRandomVariable iterationCount_LoopAction;

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
	public PCMRandomVariable getIterationCount_LoopAction() {
		return iterationCount_LoopAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterationCount_LoopAction(PCMRandomVariable newIterationCount_LoopAction, NotificationChain msgs) {
		PCMRandomVariable oldIterationCount_LoopAction = iterationCount_LoopAction;
		iterationCount_LoopAction = newIterationCount_LoopAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION, oldIterationCount_LoopAction, newIterationCount_LoopAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterationCount_LoopAction(PCMRandomVariable newIterationCount_LoopAction) {
		if (newIterationCount_LoopAction != iterationCount_LoopAction) {
			NotificationChain msgs = null;
			if (iterationCount_LoopAction != null)
				msgs = ((InternalEObject)iterationCount_LoopAction).eInverseRemove(this, CorePackage.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE, PCMRandomVariable.class, msgs);
			if (newIterationCount_LoopAction != null)
				msgs = ((InternalEObject)newIterationCount_LoopAction).eInverseAdd(this, CorePackage.PCM_RANDOM_VARIABLE__LOOP_ACTION_PCM_RANDOM_VARIABLE, PCMRandomVariable.class, msgs);
			msgs = basicSetIterationCount_LoopAction(newIterationCount_LoopAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION, newIterationCount_LoopAction, newIterationCount_LoopAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION:
				if (iterationCount_LoopAction != null)
					msgs = ((InternalEObject)iterationCount_LoopAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION, null, msgs);
				return basicSetIterationCount_LoopAction((PCMRandomVariable)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION:
				return basicSetIterationCount_LoopAction(null, msgs);
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
			case SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION:
				return getIterationCount_LoopAction();
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
			case SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION:
				setIterationCount_LoopAction((PCMRandomVariable)newValue);
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
			case SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION:
				setIterationCount_LoopAction((PCMRandomVariable)null);
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
			case SeffPackage.LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION:
				return iterationCount_LoopAction != null;
		}
		return super.eIsSet(featureID);
	}

} //LoopActionImpl
