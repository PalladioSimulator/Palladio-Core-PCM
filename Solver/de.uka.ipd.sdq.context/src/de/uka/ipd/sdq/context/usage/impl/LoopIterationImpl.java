/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.usage.impl;

import de.uka.ipd.sdq.context.usage.LoopIteration;
import de.uka.ipd.sdq.context.usage.UsagePackage;

import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;

import de.uka.ipd.sdq.stoex.impl.RandomVariableImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Iteration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.usage.impl.LoopIterationImpl#getLoopaction_LoopIteration <em>Loopaction Loop Iteration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopIterationImpl extends RandomVariableImpl implements LoopIteration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The cached value of the '{@link #getLoopaction_LoopIteration() <em>Loopaction Loop Iteration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopaction_LoopIteration()
	 * @generated
	 * @ordered
	 */
	protected AbstractLoopAction loopaction_LoopIteration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopIterationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UsagePackage.Literals.LOOP_ITERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractLoopAction getLoopaction_LoopIteration() {
		if (loopaction_LoopIteration != null && loopaction_LoopIteration.eIsProxy()) {
			InternalEObject oldLoopaction_LoopIteration = (InternalEObject)loopaction_LoopIteration;
			loopaction_LoopIteration = (AbstractLoopAction)eResolveProxy(oldLoopaction_LoopIteration);
			if (loopaction_LoopIteration != oldLoopaction_LoopIteration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION, oldLoopaction_LoopIteration, loopaction_LoopIteration));
			}
		}
		return loopaction_LoopIteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractLoopAction basicGetLoopaction_LoopIteration() {
		return loopaction_LoopIteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopaction_LoopIteration(AbstractLoopAction newLoopaction_LoopIteration) {
		AbstractLoopAction oldLoopaction_LoopIteration = loopaction_LoopIteration;
		loopaction_LoopIteration = newLoopaction_LoopIteration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION, oldLoopaction_LoopIteration, loopaction_LoopIteration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION:
				if (resolve) return getLoopaction_LoopIteration();
				return basicGetLoopaction_LoopIteration();
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
			case UsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION:
				setLoopaction_LoopIteration((AbstractLoopAction)newValue);
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
			case UsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION:
				setLoopaction_LoopIteration((AbstractLoopAction)null);
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
			case UsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION:
				return loopaction_LoopIteration != null;
		}
		return super.eIsSet(featureID);
	}

} //LoopIterationImpl
