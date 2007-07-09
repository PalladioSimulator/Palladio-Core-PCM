/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex.impl;

import de.uka.ipd.sdq.stoex.BooleanExpression;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.StoexPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Else Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.stoex.impl.IfElseExpressionImpl#getIfExpression <em>If Expression</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.stoex.impl.IfElseExpressionImpl#getElseExpression <em>Else Expression</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.stoex.impl.IfElseExpressionImpl#getConditionExpression <em>Condition Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfElseExpressionImpl extends IfElseImpl implements IfElseExpression {
	/**
	 * The cached value of the '{@link #getIfExpression() <em>If Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfExpression()
	 * @generated
	 * @ordered
	 */
	protected BooleanExpression ifExpression;

	/**
	 * The cached value of the '{@link #getElseExpression() <em>Else Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseExpression()
	 * @generated
	 * @ordered
	 */
	protected BooleanExpression elseExpression;

	/**
	 * The cached value of the '{@link #getConditionExpression() <em>Condition Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionExpression()
	 * @generated
	 * @ordered
	 */
	protected BooleanExpression conditionExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfElseExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoexPackage.Literals.IF_ELSE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExpression getIfExpression() {
		return ifExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIfExpression(BooleanExpression newIfExpression, NotificationChain msgs) {
		BooleanExpression oldIfExpression = ifExpression;
		ifExpression = newIfExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StoexPackage.IF_ELSE_EXPRESSION__IF_EXPRESSION, oldIfExpression, newIfExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfExpression(BooleanExpression newIfExpression) {
		if (newIfExpression != ifExpression) {
			NotificationChain msgs = null;
			if (ifExpression != null)
				msgs = ((InternalEObject)ifExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StoexPackage.IF_ELSE_EXPRESSION__IF_EXPRESSION, null, msgs);
			if (newIfExpression != null)
				msgs = ((InternalEObject)newIfExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StoexPackage.IF_ELSE_EXPRESSION__IF_EXPRESSION, null, msgs);
			msgs = basicSetIfExpression(newIfExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoexPackage.IF_ELSE_EXPRESSION__IF_EXPRESSION, newIfExpression, newIfExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExpression getElseExpression() {
		return elseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseExpression(BooleanExpression newElseExpression, NotificationChain msgs) {
		BooleanExpression oldElseExpression = elseExpression;
		elseExpression = newElseExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StoexPackage.IF_ELSE_EXPRESSION__ELSE_EXPRESSION, oldElseExpression, newElseExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseExpression(BooleanExpression newElseExpression) {
		if (newElseExpression != elseExpression) {
			NotificationChain msgs = null;
			if (elseExpression != null)
				msgs = ((InternalEObject)elseExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StoexPackage.IF_ELSE_EXPRESSION__ELSE_EXPRESSION, null, msgs);
			if (newElseExpression != null)
				msgs = ((InternalEObject)newElseExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StoexPackage.IF_ELSE_EXPRESSION__ELSE_EXPRESSION, null, msgs);
			msgs = basicSetElseExpression(newElseExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoexPackage.IF_ELSE_EXPRESSION__ELSE_EXPRESSION, newElseExpression, newElseExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExpression getConditionExpression() {
		return conditionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConditionExpression(BooleanExpression newConditionExpression, NotificationChain msgs) {
		BooleanExpression oldConditionExpression = conditionExpression;
		conditionExpression = newConditionExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StoexPackage.IF_ELSE_EXPRESSION__CONDITION_EXPRESSION, oldConditionExpression, newConditionExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionExpression(BooleanExpression newConditionExpression) {
		if (newConditionExpression != conditionExpression) {
			NotificationChain msgs = null;
			if (conditionExpression != null)
				msgs = ((InternalEObject)conditionExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StoexPackage.IF_ELSE_EXPRESSION__CONDITION_EXPRESSION, null, msgs);
			if (newConditionExpression != null)
				msgs = ((InternalEObject)newConditionExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StoexPackage.IF_ELSE_EXPRESSION__CONDITION_EXPRESSION, null, msgs);
			msgs = basicSetConditionExpression(newConditionExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoexPackage.IF_ELSE_EXPRESSION__CONDITION_EXPRESSION, newConditionExpression, newConditionExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoexPackage.IF_ELSE_EXPRESSION__IF_EXPRESSION:
				return basicSetIfExpression(null, msgs);
			case StoexPackage.IF_ELSE_EXPRESSION__ELSE_EXPRESSION:
				return basicSetElseExpression(null, msgs);
			case StoexPackage.IF_ELSE_EXPRESSION__CONDITION_EXPRESSION:
				return basicSetConditionExpression(null, msgs);
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
			case StoexPackage.IF_ELSE_EXPRESSION__IF_EXPRESSION:
				return getIfExpression();
			case StoexPackage.IF_ELSE_EXPRESSION__ELSE_EXPRESSION:
				return getElseExpression();
			case StoexPackage.IF_ELSE_EXPRESSION__CONDITION_EXPRESSION:
				return getConditionExpression();
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
			case StoexPackage.IF_ELSE_EXPRESSION__IF_EXPRESSION:
				setIfExpression((BooleanExpression)newValue);
				return;
			case StoexPackage.IF_ELSE_EXPRESSION__ELSE_EXPRESSION:
				setElseExpression((BooleanExpression)newValue);
				return;
			case StoexPackage.IF_ELSE_EXPRESSION__CONDITION_EXPRESSION:
				setConditionExpression((BooleanExpression)newValue);
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
			case StoexPackage.IF_ELSE_EXPRESSION__IF_EXPRESSION:
				setIfExpression((BooleanExpression)null);
				return;
			case StoexPackage.IF_ELSE_EXPRESSION__ELSE_EXPRESSION:
				setElseExpression((BooleanExpression)null);
				return;
			case StoexPackage.IF_ELSE_EXPRESSION__CONDITION_EXPRESSION:
				setConditionExpression((BooleanExpression)null);
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
			case StoexPackage.IF_ELSE_EXPRESSION__IF_EXPRESSION:
				return ifExpression != null;
			case StoexPackage.IF_ELSE_EXPRESSION__ELSE_EXPRESSION:
				return elseExpression != null;
			case StoexPackage.IF_ELSE_EXPRESSION__CONDITION_EXPRESSION:
				return conditionExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //IfElseExpressionImpl
