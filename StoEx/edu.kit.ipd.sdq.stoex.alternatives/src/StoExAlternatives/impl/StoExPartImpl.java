/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package StoExAlternatives.impl;

import StoExAlternatives.ExpressionProxy;
import StoExAlternatives.StoExAlternativesPackage;
import StoExAlternatives.StoExPart;

import de.uka.ipd.sdq.stoex.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sto Ex Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link StoExAlternatives.impl.StoExPartImpl#getSubExpression <em>Sub Expression</em>}</li>
 *   <li>{@link StoExAlternatives.impl.StoExPartImpl#getExpressionProxy <em>Expression Proxy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StoExPartImpl extends EObjectImpl implements StoExPart {
	/**
	 * The cached value of the '{@link #getSubExpression() <em>Sub Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression subExpression;

	/**
	 * The cached value of the '{@link #getExpressionProxy() <em>Expression Proxy</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionProxy()
	 * @generated
	 * @ordered
	 */
	protected ExpressionProxy expressionProxy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StoExPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoExAlternativesPackage.Literals.STO_EX_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getSubExpression() {
		if (subExpression != null && subExpression.eIsProxy()) {
			InternalEObject oldSubExpression = (InternalEObject)subExpression;
			subExpression = (Expression)eResolveProxy(oldSubExpression);
			if (subExpression != oldSubExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StoExAlternativesPackage.STO_EX_PART__SUB_EXPRESSION, oldSubExpression, subExpression));
			}
		}
		return subExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetSubExpression() {
		return subExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubExpression(Expression newSubExpression) {
		Expression oldSubExpression = subExpression;
		subExpression = newSubExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoExAlternativesPackage.STO_EX_PART__SUB_EXPRESSION, oldSubExpression, subExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionProxy getExpressionProxy() {
		if (expressionProxy != null && expressionProxy.eIsProxy()) {
			InternalEObject oldExpressionProxy = (InternalEObject)expressionProxy;
			expressionProxy = (ExpressionProxy)eResolveProxy(oldExpressionProxy);
			if (expressionProxy != oldExpressionProxy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StoExAlternativesPackage.STO_EX_PART__EXPRESSION_PROXY, oldExpressionProxy, expressionProxy));
			}
		}
		return expressionProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionProxy basicGetExpressionProxy() {
		return expressionProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpressionProxy(ExpressionProxy newExpressionProxy, NotificationChain msgs) {
		ExpressionProxy oldExpressionProxy = expressionProxy;
		expressionProxy = newExpressionProxy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StoExAlternativesPackage.STO_EX_PART__EXPRESSION_PROXY, oldExpressionProxy, newExpressionProxy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionProxy(ExpressionProxy newExpressionProxy) {
		if (newExpressionProxy != expressionProxy) {
			NotificationChain msgs = null;
			if (expressionProxy != null)
				msgs = ((InternalEObject)expressionProxy).eInverseRemove(this, StoExAlternativesPackage.EXPRESSION_PROXY__ALTERNATIVES, ExpressionProxy.class, msgs);
			if (newExpressionProxy != null)
				msgs = ((InternalEObject)newExpressionProxy).eInverseAdd(this, StoExAlternativesPackage.EXPRESSION_PROXY__ALTERNATIVES, ExpressionProxy.class, msgs);
			msgs = basicSetExpressionProxy(newExpressionProxy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoExAlternativesPackage.STO_EX_PART__EXPRESSION_PROXY, newExpressionProxy, newExpressionProxy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoExAlternativesPackage.STO_EX_PART__EXPRESSION_PROXY:
				if (expressionProxy != null)
					msgs = ((InternalEObject)expressionProxy).eInverseRemove(this, StoExAlternativesPackage.EXPRESSION_PROXY__ALTERNATIVES, ExpressionProxy.class, msgs);
				return basicSetExpressionProxy((ExpressionProxy)otherEnd, msgs);
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
			case StoExAlternativesPackage.STO_EX_PART__EXPRESSION_PROXY:
				return basicSetExpressionProxy(null, msgs);
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
			case StoExAlternativesPackage.STO_EX_PART__SUB_EXPRESSION:
				if (resolve) return getSubExpression();
				return basicGetSubExpression();
			case StoExAlternativesPackage.STO_EX_PART__EXPRESSION_PROXY:
				if (resolve) return getExpressionProxy();
				return basicGetExpressionProxy();
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
			case StoExAlternativesPackage.STO_EX_PART__SUB_EXPRESSION:
				setSubExpression((Expression)newValue);
				return;
			case StoExAlternativesPackage.STO_EX_PART__EXPRESSION_PROXY:
				setExpressionProxy((ExpressionProxy)newValue);
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
			case StoExAlternativesPackage.STO_EX_PART__SUB_EXPRESSION:
				setSubExpression((Expression)null);
				return;
			case StoExAlternativesPackage.STO_EX_PART__EXPRESSION_PROXY:
				setExpressionProxy((ExpressionProxy)null);
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
			case StoExAlternativesPackage.STO_EX_PART__SUB_EXPRESSION:
				return subExpression != null;
			case StoExAlternativesPackage.STO_EX_PART__EXPRESSION_PROXY:
				return expressionProxy != null;
		}
		return super.eIsSet(featureID);
	}

} //StoExPartImpl
