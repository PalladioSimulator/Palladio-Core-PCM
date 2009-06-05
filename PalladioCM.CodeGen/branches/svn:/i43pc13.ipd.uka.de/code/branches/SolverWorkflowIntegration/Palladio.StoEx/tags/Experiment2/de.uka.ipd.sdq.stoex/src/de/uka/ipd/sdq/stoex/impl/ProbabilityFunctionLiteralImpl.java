/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex.impl;

import de.uka.ipd.sdq.probfunction.ProbabilityFunction;

import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.StoexPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Probability Function Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.stoex.impl.ProbabilityFunctionLiteralImpl#getFunction_ProbabilityFunctionLiteral <em>Function Probability Function Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProbabilityFunctionLiteralImpl extends AtomImpl implements ProbabilityFunctionLiteral {
	/**
	 * The cached value of the '{@link #getFunction_ProbabilityFunctionLiteral() <em>Function Probability Function Literal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction_ProbabilityFunctionLiteral()
	 * @generated
	 * @ordered
	 */
	protected ProbabilityFunction function_ProbabilityFunctionLiteral;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProbabilityFunctionLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoexPackage.Literals.PROBABILITY_FUNCTION_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilityFunction getFunction_ProbabilityFunctionLiteral() {
		return function_ProbabilityFunctionLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction_ProbabilityFunctionLiteral(ProbabilityFunction newFunction_ProbabilityFunctionLiteral, NotificationChain msgs) {
		ProbabilityFunction oldFunction_ProbabilityFunctionLiteral = function_ProbabilityFunctionLiteral;
		function_ProbabilityFunctionLiteral = newFunction_ProbabilityFunctionLiteral;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StoexPackage.PROBABILITY_FUNCTION_LITERAL__FUNCTION_PROBABILITY_FUNCTION_LITERAL, oldFunction_ProbabilityFunctionLiteral, newFunction_ProbabilityFunctionLiteral);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction_ProbabilityFunctionLiteral(ProbabilityFunction newFunction_ProbabilityFunctionLiteral) {
		if (newFunction_ProbabilityFunctionLiteral != function_ProbabilityFunctionLiteral) {
			NotificationChain msgs = null;
			if (function_ProbabilityFunctionLiteral != null)
				msgs = ((InternalEObject)function_ProbabilityFunctionLiteral).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StoexPackage.PROBABILITY_FUNCTION_LITERAL__FUNCTION_PROBABILITY_FUNCTION_LITERAL, null, msgs);
			if (newFunction_ProbabilityFunctionLiteral != null)
				msgs = ((InternalEObject)newFunction_ProbabilityFunctionLiteral).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StoexPackage.PROBABILITY_FUNCTION_LITERAL__FUNCTION_PROBABILITY_FUNCTION_LITERAL, null, msgs);
			msgs = basicSetFunction_ProbabilityFunctionLiteral(newFunction_ProbabilityFunctionLiteral, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoexPackage.PROBABILITY_FUNCTION_LITERAL__FUNCTION_PROBABILITY_FUNCTION_LITERAL, newFunction_ProbabilityFunctionLiteral, newFunction_ProbabilityFunctionLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoexPackage.PROBABILITY_FUNCTION_LITERAL__FUNCTION_PROBABILITY_FUNCTION_LITERAL:
				return basicSetFunction_ProbabilityFunctionLiteral(null, msgs);
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
			case StoexPackage.PROBABILITY_FUNCTION_LITERAL__FUNCTION_PROBABILITY_FUNCTION_LITERAL:
				return getFunction_ProbabilityFunctionLiteral();
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
			case StoexPackage.PROBABILITY_FUNCTION_LITERAL__FUNCTION_PROBABILITY_FUNCTION_LITERAL:
				setFunction_ProbabilityFunctionLiteral((ProbabilityFunction)newValue);
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
			case StoexPackage.PROBABILITY_FUNCTION_LITERAL__FUNCTION_PROBABILITY_FUNCTION_LITERAL:
				setFunction_ProbabilityFunctionLiteral((ProbabilityFunction)null);
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
			case StoexPackage.PROBABILITY_FUNCTION_LITERAL__FUNCTION_PROBABILITY_FUNCTION_LITERAL:
				return function_ProbabilityFunctionLiteral != null;
		}
		return super.eIsSet(featureID);
	}

} //ProbabilityFunctionLiteralImpl
