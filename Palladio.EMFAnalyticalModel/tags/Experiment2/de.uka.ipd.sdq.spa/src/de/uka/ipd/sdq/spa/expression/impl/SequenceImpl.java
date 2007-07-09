/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression.impl;

import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.ExpressionPackage;
import de.uka.ipd.sdq.spa.expression.Sequence;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.SequenceImpl#getLeftRegExp <em>Left Reg Exp</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.SequenceImpl#getRightRegExp <em>Right Reg Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceImpl extends OperationImpl implements Sequence {
	/**
	 * The cached value of the '{@link #getLeftRegExp() <em>Left Reg Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftRegExp()
	 * @generated
	 * @ordered
	 */
	protected Expression leftRegExp = null;

	/**
	 * The cached value of the '{@link #getRightRegExp() <em>Right Reg Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightRegExp()
	 * @generated
	 * @ordered
	 */
	protected Expression rightRegExp = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLeftRegExp() {
		return leftRegExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftRegExp(Expression newLeftRegExp, NotificationChain msgs) {
		Expression oldLeftRegExp = leftRegExp;
		leftRegExp = newLeftRegExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.SEQUENCE__LEFT_REG_EXP, oldLeftRegExp, newLeftRegExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftRegExp(Expression newLeftRegExp) {
		if (newLeftRegExp != leftRegExp) {
			NotificationChain msgs = null;
			if (leftRegExp != null)
				msgs = ((InternalEObject)leftRegExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.SEQUENCE__LEFT_REG_EXP, null, msgs);
			if (newLeftRegExp != null)
				msgs = ((InternalEObject)newLeftRegExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.SEQUENCE__LEFT_REG_EXP, null, msgs);
			msgs = basicSetLeftRegExp(newLeftRegExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.SEQUENCE__LEFT_REG_EXP, newLeftRegExp, newLeftRegExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRightRegExp() {
		return rightRegExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightRegExp(Expression newRightRegExp, NotificationChain msgs) {
		Expression oldRightRegExp = rightRegExp;
		rightRegExp = newRightRegExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.SEQUENCE__RIGHT_REG_EXP, oldRightRegExp, newRightRegExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightRegExp(Expression newRightRegExp) {
		if (newRightRegExp != rightRegExp) {
			NotificationChain msgs = null;
			if (rightRegExp != null)
				msgs = ((InternalEObject)rightRegExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.SEQUENCE__RIGHT_REG_EXP, null, msgs);
			if (newRightRegExp != null)
				msgs = ((InternalEObject)newRightRegExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.SEQUENCE__RIGHT_REG_EXP, null, msgs);
			msgs = basicSetRightRegExp(newRightRegExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.SEQUENCE__RIGHT_REG_EXP, newRightRegExp, newRightRegExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.SEQUENCE__LEFT_REG_EXP:
				return basicSetLeftRegExp(null, msgs);
			case ExpressionPackage.SEQUENCE__RIGHT_REG_EXP:
				return basicSetRightRegExp(null, msgs);
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
			case ExpressionPackage.SEQUENCE__LEFT_REG_EXP:
				return getLeftRegExp();
			case ExpressionPackage.SEQUENCE__RIGHT_REG_EXP:
				return getRightRegExp();
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
			case ExpressionPackage.SEQUENCE__LEFT_REG_EXP:
				setLeftRegExp((Expression)newValue);
				return;
			case ExpressionPackage.SEQUENCE__RIGHT_REG_EXP:
				setRightRegExp((Expression)newValue);
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
			case ExpressionPackage.SEQUENCE__LEFT_REG_EXP:
				setLeftRegExp((Expression)null);
				return;
			case ExpressionPackage.SEQUENCE__RIGHT_REG_EXP:
				setRightRegExp((Expression)null);
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
			case ExpressionPackage.SEQUENCE__LEFT_REG_EXP:
				return leftRegExp != null;
			case ExpressionPackage.SEQUENCE__RIGHT_REG_EXP:
				return rightRegExp != null;
		}
		return super.eIsSet(featureID);
	}

} //SequenceImpl
