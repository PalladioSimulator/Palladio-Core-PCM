/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression.impl;

import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;

import de.uka.ipd.sdq.spa.expression.ExpressionPackage;
import de.uka.ipd.sdq.spa.expression.Loop;
import de.uka.ipd.sdq.spa.expression.RegularExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.LoopImpl#getRegExp <em>Reg Exp</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.LoopImpl#getIterations <em>Iterations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopImpl extends OperationImpl implements Loop {
	/**
	 * The cached value of the '{@link #getRegExp() <em>Reg Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegExp()
	 * @generated
	 * @ordered
	 */
	protected RegularExpression regExp = null;

	/**
	 * The cached value of the '{@link #getIterations() <em>Iterations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations()
	 * @generated
	 * @ordered
	 */
	protected ProbabilityMassFunction iterations = null;

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
		return ExpressionPackage.Literals.LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegularExpression getRegExp() {
		return regExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegExp(RegularExpression newRegExp, NotificationChain msgs) {
		RegularExpression oldRegExp = regExp;
		regExp = newRegExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.LOOP__REG_EXP, oldRegExp, newRegExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegExp(RegularExpression newRegExp) {
		if (newRegExp != regExp) {
			NotificationChain msgs = null;
			if (regExp != null)
				msgs = ((InternalEObject)regExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.LOOP__REG_EXP, null, msgs);
			if (newRegExp != null)
				msgs = ((InternalEObject)newRegExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.LOOP__REG_EXP, null, msgs);
			msgs = basicSetRegExp(newRegExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.LOOP__REG_EXP, newRegExp, newRegExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilityMassFunction getIterations() {
		return iterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterations(ProbabilityMassFunction newIterations, NotificationChain msgs) {
		ProbabilityMassFunction oldIterations = iterations;
		iterations = newIterations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.LOOP__ITERATIONS, oldIterations, newIterations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterations(ProbabilityMassFunction newIterations) {
		if (newIterations != iterations) {
			NotificationChain msgs = null;
			if (iterations != null)
				msgs = ((InternalEObject)iterations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.LOOP__ITERATIONS, null, msgs);
			if (newIterations != null)
				msgs = ((InternalEObject)newIterations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.LOOP__ITERATIONS, null, msgs);
			msgs = basicSetIterations(newIterations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.LOOP__ITERATIONS, newIterations, newIterations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.LOOP__REG_EXP:
				return basicSetRegExp(null, msgs);
			case ExpressionPackage.LOOP__ITERATIONS:
				return basicSetIterations(null, msgs);
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
			case ExpressionPackage.LOOP__REG_EXP:
				return getRegExp();
			case ExpressionPackage.LOOP__ITERATIONS:
				return getIterations();
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
			case ExpressionPackage.LOOP__REG_EXP:
				setRegExp((RegularExpression)newValue);
				return;
			case ExpressionPackage.LOOP__ITERATIONS:
				setIterations((ProbabilityMassFunction)newValue);
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
			case ExpressionPackage.LOOP__REG_EXP:
				setRegExp((RegularExpression)null);
				return;
			case ExpressionPackage.LOOP__ITERATIONS:
				setIterations((ProbabilityMassFunction)null);
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
			case ExpressionPackage.LOOP__REG_EXP:
				return regExp != null;
			case ExpressionPackage.LOOP__ITERATIONS:
				return iterations != null;
		}
		return super.eIsSet(featureID);
	}

} //LoopImpl