/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.StoexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parenthesis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.stoex.impl.ParenthesisImpl#getInnerExpression <em>Inner Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParenthesisImpl extends AtomImpl implements Parenthesis {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";
	/**
	 * The cached value of the '{@link #getInnerExpression() <em>Inner Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression innerExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParenthesisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoexPackage.Literals.PARENTHESIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getInnerExpression() {
		return innerExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInnerExpression(Expression newInnerExpression, NotificationChain msgs) {
		Expression oldInnerExpression = innerExpression;
		innerExpression = newInnerExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StoexPackage.PARENTHESIS__INNER_EXPRESSION, oldInnerExpression, newInnerExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerExpression(Expression newInnerExpression) {
		if (newInnerExpression != innerExpression) {
			NotificationChain msgs = null;
			if (innerExpression != null)
				msgs = ((InternalEObject)innerExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StoexPackage.PARENTHESIS__INNER_EXPRESSION, null, msgs);
			if (newInnerExpression != null)
				msgs = ((InternalEObject)newInnerExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StoexPackage.PARENTHESIS__INNER_EXPRESSION, null, msgs);
			msgs = basicSetInnerExpression(newInnerExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoexPackage.PARENTHESIS__INNER_EXPRESSION, newInnerExpression, newInnerExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoexPackage.PARENTHESIS__INNER_EXPRESSION:
				return basicSetInnerExpression(null, msgs);
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
			case StoexPackage.PARENTHESIS__INNER_EXPRESSION:
				return getInnerExpression();
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
			case StoexPackage.PARENTHESIS__INNER_EXPRESSION:
				setInnerExpression((Expression)newValue);
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
			case StoexPackage.PARENTHESIS__INNER_EXPRESSION:
				setInnerExpression((Expression)null);
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
			case StoexPackage.PARENTHESIS__INNER_EXPRESSION:
				return innerExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ParenthesisImpl
