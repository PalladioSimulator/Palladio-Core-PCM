/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.usage.impl;

import de.uka.ipd.sdq.context.usage.LoopIteration;
import de.uka.ipd.sdq.context.usage.UsagePackage;

import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;

import de.uka.ipd.sdq.stoex.RandomVariable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Iteration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.usage.impl.LoopIterationImpl#getLoopaction_LoopIteration <em>Loopaction Loop Iteration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.usage.impl.LoopIterationImpl#getIterations_LoopIteration <em>Iterations Loop Iteration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopIterationImpl extends EObjectImpl implements LoopIteration {
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
	 * The cached value of the '{@link #getIterations_LoopIteration() <em>Iterations Loop Iteration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations_LoopIteration()
	 * @generated
	 * @ordered
	 */
	protected RandomVariable iterations_LoopIteration;

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
	public RandomVariable getIterations_LoopIteration() {
		return iterations_LoopIteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterations_LoopIteration(RandomVariable newIterations_LoopIteration, NotificationChain msgs) {
		RandomVariable oldIterations_LoopIteration = iterations_LoopIteration;
		iterations_LoopIteration = newIterations_LoopIteration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsagePackage.LOOP_ITERATION__ITERATIONS_LOOP_ITERATION, oldIterations_LoopIteration, newIterations_LoopIteration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterations_LoopIteration(RandomVariable newIterations_LoopIteration) {
		if (newIterations_LoopIteration != iterations_LoopIteration) {
			NotificationChain msgs = null;
			if (iterations_LoopIteration != null)
				msgs = ((InternalEObject)iterations_LoopIteration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsagePackage.LOOP_ITERATION__ITERATIONS_LOOP_ITERATION, null, msgs);
			if (newIterations_LoopIteration != null)
				msgs = ((InternalEObject)newIterations_LoopIteration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsagePackage.LOOP_ITERATION__ITERATIONS_LOOP_ITERATION, null, msgs);
			msgs = basicSetIterations_LoopIteration(newIterations_LoopIteration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagePackage.LOOP_ITERATION__ITERATIONS_LOOP_ITERATION, newIterations_LoopIteration, newIterations_LoopIteration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagePackage.LOOP_ITERATION__ITERATIONS_LOOP_ITERATION:
				return basicSetIterations_LoopIteration(null, msgs);
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
			case UsagePackage.LOOP_ITERATION__LOOPACTION_LOOP_ITERATION:
				if (resolve) return getLoopaction_LoopIteration();
				return basicGetLoopaction_LoopIteration();
			case UsagePackage.LOOP_ITERATION__ITERATIONS_LOOP_ITERATION:
				return getIterations_LoopIteration();
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
			case UsagePackage.LOOP_ITERATION__ITERATIONS_LOOP_ITERATION:
				setIterations_LoopIteration((RandomVariable)newValue);
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
			case UsagePackage.LOOP_ITERATION__ITERATIONS_LOOP_ITERATION:
				setIterations_LoopIteration((RandomVariable)null);
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
			case UsagePackage.LOOP_ITERATION__ITERATIONS_LOOP_ITERATION:
				return iterations_LoopIteration != null;
		}
		return super.eIsSet(featureID);
	}

} //LoopIterationImpl
