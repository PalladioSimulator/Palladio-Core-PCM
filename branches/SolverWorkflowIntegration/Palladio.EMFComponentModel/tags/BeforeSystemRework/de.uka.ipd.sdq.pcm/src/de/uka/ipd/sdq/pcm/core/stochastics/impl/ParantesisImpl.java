
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.stochastics.impl;

import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.core.stochastics.Parantesis;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parantesis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.ParantesisImpl#getInnerExpression <em>Inner Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParantesisImpl extends AtomImpl implements Parantesis {
	/**
	 * The cached value of the '{@link #getInnerExpression() <em>Inner Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression innerExpression = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParantesisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return StochasticsPackage.Literals.PARANTESIS;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StochasticsPackage.PARANTESIS__INNER_EXPRESSION, oldInnerExpression, newInnerExpression);
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
				msgs = ((InternalEObject)innerExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StochasticsPackage.PARANTESIS__INNER_EXPRESSION, null, msgs);
			if (newInnerExpression != null)
				msgs = ((InternalEObject)newInnerExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StochasticsPackage.PARANTESIS__INNER_EXPRESSION, null, msgs);
			msgs = basicSetInnerExpression(newInnerExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StochasticsPackage.PARANTESIS__INNER_EXPRESSION, newInnerExpression, newInnerExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StochasticsPackage.PARANTESIS__INNER_EXPRESSION:
				return basicSetInnerExpression(null, msgs);
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
			case StochasticsPackage.PARANTESIS__INNER_EXPRESSION:
				return getInnerExpression();
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
			case StochasticsPackage.PARANTESIS__INNER_EXPRESSION:
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case StochasticsPackage.PARANTESIS__INNER_EXPRESSION:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StochasticsPackage.PARANTESIS__INNER_EXPRESSION:
				return innerExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ParantesisImpl