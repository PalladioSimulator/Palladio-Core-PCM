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

import de.uka.ipd.sdq.stoex.impl.ExpressionImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Proxy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link StoExAlternatives.impl.ExpressionProxyImpl#getAlternatives <em>Alternatives</em>}</li>
 *   <li>{@link StoExAlternatives.impl.ExpressionProxyImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionProxyImpl extends ExpressionImpl implements ExpressionProxy {
	/**
	 * The cached value of the '{@link #getAlternatives() <em>Alternatives</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternatives()
	 * @generated
	 * @ordered
	 */
	protected EList<StoExPart> alternatives;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression expression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionProxyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoExAlternativesPackage.Literals.EXPRESSION_PROXY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StoExPart> getAlternatives() {
		if (alternatives == null) {
			alternatives = new EObjectWithInverseResolvingEList<StoExPart>(StoExPart.class, this, StoExAlternativesPackage.EXPRESSION_PROXY__ALTERNATIVES, StoExAlternativesPackage.STO_EX_PART__EXPRESSION_PROXY);
		}
		return alternatives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		if (expression != null && expression.eIsProxy()) {
			InternalEObject oldExpression = (InternalEObject)expression;
			expression = (Expression)eResolveProxy(oldExpression);
			if (expression != oldExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StoExAlternativesPackage.EXPRESSION_PROXY__EXPRESSION, oldExpression, expression));
			}
		}
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		Expression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoExAlternativesPackage.EXPRESSION_PROXY__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoExAlternativesPackage.EXPRESSION_PROXY__ALTERNATIVES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAlternatives()).basicAdd(otherEnd, msgs);
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
			case StoExAlternativesPackage.EXPRESSION_PROXY__ALTERNATIVES:
				return ((InternalEList<?>)getAlternatives()).basicRemove(otherEnd, msgs);
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
			case StoExAlternativesPackage.EXPRESSION_PROXY__ALTERNATIVES:
				return getAlternatives();
			case StoExAlternativesPackage.EXPRESSION_PROXY__EXPRESSION:
				if (resolve) return getExpression();
				return basicGetExpression();
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
			case StoExAlternativesPackage.EXPRESSION_PROXY__ALTERNATIVES:
				getAlternatives().clear();
				getAlternatives().addAll((Collection<? extends StoExPart>)newValue);
				return;
			case StoExAlternativesPackage.EXPRESSION_PROXY__EXPRESSION:
				setExpression((Expression)newValue);
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
			case StoExAlternativesPackage.EXPRESSION_PROXY__ALTERNATIVES:
				getAlternatives().clear();
				return;
			case StoExAlternativesPackage.EXPRESSION_PROXY__EXPRESSION:
				setExpression((Expression)null);
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
			case StoExAlternativesPackage.EXPRESSION_PROXY__ALTERNATIVES:
				return alternatives != null && !alternatives.isEmpty();
			case StoExAlternativesPackage.EXPRESSION_PROXY__EXPRESSION:
				return expression != null;
		}
		return super.eIsSet(featureID);
	}

} //ExpressionProxyImpl
