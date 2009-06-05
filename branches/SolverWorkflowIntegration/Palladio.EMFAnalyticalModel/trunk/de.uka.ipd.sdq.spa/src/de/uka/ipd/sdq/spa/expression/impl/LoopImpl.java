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
	
	protected ProbabilityMassFunction iterationsPMF;

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
	@Override
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
		// TODO: implement this method to return the 'Iterations PMF' containment reference
		// Ensure that you remove @generated or mark it @generated NOT
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterationsPMF(ProbabilityMassFunction newIterationsPMF, NotificationChain msgs) {
		// TODO: implement this method to set the contained 'Iterations PMF' containment reference
		// -> this method is automatically invoked to keep the containment relationship in synch
		// -> do not modify other features
		// -> return msgs, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setIterationsPMF(ProbabilityMassFunction newIterationsPMF) {
		// TODO: implement this method to set the 'Iterations PMF' containment reference
		// Ensure that you remove @generated or mark it @generated NOT
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpressionPackage.LOOP__REG_EXP:
				return regExp != null;
			case ExpressionPackage.LOOP__ITERATIONS_PMF:
				return getIterationsPMF() != null;
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
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (iterationsString: ");
		result.append(iterationsString);
		result.append(')');
		return result.toString();
	}

} //LoopImpl
