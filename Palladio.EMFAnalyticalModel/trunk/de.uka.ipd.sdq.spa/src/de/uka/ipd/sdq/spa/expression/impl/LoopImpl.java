/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression.impl;

import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;

import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.ExpressionPackage;
import de.uka.ipd.sdq.spa.expression.Loop;

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
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.LoopImpl#getIterationsPMF <em>Iterations PMF</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.LoopImpl#getIterationsString <em>Iterations String</em>}</li>
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
	protected Expression regExp = null;

	/**
	 * The cached value of the '{@link #getIterationsPMF() <em>Iterations PMF</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationsPMF()
	 * @generated
	 * @ordered
	 */
	protected ProbabilityMassFunction iterationsPMF = null;

	/**
	 * The default value of the '{@link #getIterationsString() <em>Iterations String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationsString()
	 * @generated
	 * @ordered
	 */
	protected static final String ITERATIONS_STRING_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getIterationsString() <em>Iterations String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationsString()
	 * @generated
	 * @ordered
	 */
	protected String iterationsString = ITERATIONS_STRING_EDEFAULT;

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
	public Expression getRegExp() {
		return regExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegExp(Expression newRegExp, NotificationChain msgs) {
		Expression oldRegExp = regExp;
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
	public void setRegExp(Expression newRegExp) {
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
	public ProbabilityMassFunction getIterationsPMF() {
		return iterationsPMF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterationsPMF(ProbabilityMassFunction newIterationsPMF, NotificationChain msgs) {
		ProbabilityMassFunction oldIterationsPMF = iterationsPMF;
		iterationsPMF = newIterationsPMF;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.LOOP__ITERATIONS_PMF, oldIterationsPMF, newIterationsPMF);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterationsPMF(ProbabilityMassFunction newIterationsPMF) {
		if (newIterationsPMF != iterationsPMF) {
			NotificationChain msgs = null;
			if (iterationsPMF != null)
				msgs = ((InternalEObject)iterationsPMF).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.LOOP__ITERATIONS_PMF, null, msgs);
			if (newIterationsPMF != null)
				msgs = ((InternalEObject)newIterationsPMF).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.LOOP__ITERATIONS_PMF, null, msgs);
			msgs = basicSetIterationsPMF(newIterationsPMF, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.LOOP__ITERATIONS_PMF, newIterationsPMF, newIterationsPMF));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIterationsString() {
		return iterationsString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterationsString(String newIterationsString) {
		String oldIterationsString = iterationsString;
		iterationsString = newIterationsString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.LOOP__ITERATIONS_STRING, oldIterationsString, iterationsString));
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
			case ExpressionPackage.LOOP__ITERATIONS_PMF:
				return basicSetIterationsPMF(null, msgs);
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
			case ExpressionPackage.LOOP__ITERATIONS_PMF:
				return getIterationsPMF();
			case ExpressionPackage.LOOP__ITERATIONS_STRING:
				return getIterationsString();
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
				setRegExp((Expression)newValue);
				return;
			case ExpressionPackage.LOOP__ITERATIONS_PMF:
				setIterationsPMF((ProbabilityMassFunction)newValue);
				return;
			case ExpressionPackage.LOOP__ITERATIONS_STRING:
				setIterationsString((String)newValue);
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
				setRegExp((Expression)null);
				return;
			case ExpressionPackage.LOOP__ITERATIONS_PMF:
				setIterationsPMF((ProbabilityMassFunction)null);
				return;
			case ExpressionPackage.LOOP__ITERATIONS_STRING:
				setIterationsString(ITERATIONS_STRING_EDEFAULT);
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
			case ExpressionPackage.LOOP__ITERATIONS_PMF:
				return iterationsPMF != null;
			case ExpressionPackage.LOOP__ITERATIONS_STRING:
				return ITERATIONS_STRING_EDEFAULT == null ? iterationsString != null : !ITERATIONS_STRING_EDEFAULT.equals(iterationsString);
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
		result.append(" (iterationsString: ");
		result.append(iterationsString);
		result.append(')');
		return result.toString();
	}

} //LoopImpl