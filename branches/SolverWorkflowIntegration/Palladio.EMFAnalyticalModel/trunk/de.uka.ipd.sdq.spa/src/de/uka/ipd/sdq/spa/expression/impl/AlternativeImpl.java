/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression.impl;

import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.ExpressionPackage;
import de.uka.ipd.sdq.spa.expression.Option;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.AlternativeImpl#getLeftOption <em>Left Option</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.AlternativeImpl#getRightOption <em>Right Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlternativeImpl extends OperationImpl implements Alternative {
	/**
	 * The cached value of the '{@link #getLeftOption() <em>Left Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftOption()
	 * @generated
	 * @ordered
	 */
	protected Option leftOption = null;

	/**
	 * The cached value of the '{@link #getRightOption() <em>Right Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightOption()
	 * @generated
	 * @ordered
	 */
	protected Option rightOption = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlternativeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.ALTERNATIVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Option getLeftOption() {
		return leftOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftOption(Option newLeftOption, NotificationChain msgs) {
		Option oldLeftOption = leftOption;
		leftOption = newLeftOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.ALTERNATIVE__LEFT_OPTION, oldLeftOption, newLeftOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftOption(Option newLeftOption) {
		if (newLeftOption != leftOption) {
			NotificationChain msgs = null;
			if (leftOption != null)
				msgs = ((InternalEObject)leftOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.ALTERNATIVE__LEFT_OPTION, null, msgs);
			if (newLeftOption != null)
				msgs = ((InternalEObject)newLeftOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.ALTERNATIVE__LEFT_OPTION, null, msgs);
			msgs = basicSetLeftOption(newLeftOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.ALTERNATIVE__LEFT_OPTION, newLeftOption, newLeftOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Option getRightOption() {
		return rightOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightOption(Option newRightOption, NotificationChain msgs) {
		Option oldRightOption = rightOption;
		rightOption = newRightOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.ALTERNATIVE__RIGHT_OPTION, oldRightOption, newRightOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightOption(Option newRightOption) {
		if (newRightOption != rightOption) {
			NotificationChain msgs = null;
			if (rightOption != null)
				msgs = ((InternalEObject)rightOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.ALTERNATIVE__RIGHT_OPTION, null, msgs);
			if (newRightOption != null)
				msgs = ((InternalEObject)newRightOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.ALTERNATIVE__RIGHT_OPTION, null, msgs);
			msgs = basicSetRightOption(newRightOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.ALTERNATIVE__RIGHT_OPTION, newRightOption, newRightOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.ALTERNATIVE__LEFT_OPTION:
				return basicSetLeftOption(null, msgs);
			case ExpressionPackage.ALTERNATIVE__RIGHT_OPTION:
				return basicSetRightOption(null, msgs);
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
			case ExpressionPackage.ALTERNATIVE__LEFT_OPTION:
				return getLeftOption();
			case ExpressionPackage.ALTERNATIVE__RIGHT_OPTION:
				return getRightOption();
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
			case ExpressionPackage.ALTERNATIVE__LEFT_OPTION:
				setLeftOption((Option)newValue);
				return;
			case ExpressionPackage.ALTERNATIVE__RIGHT_OPTION:
				setRightOption((Option)newValue);
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
			case ExpressionPackage.ALTERNATIVE__LEFT_OPTION:
				setLeftOption((Option)null);
				return;
			case ExpressionPackage.ALTERNATIVE__RIGHT_OPTION:
				setRightOption((Option)null);
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
			case ExpressionPackage.ALTERNATIVE__LEFT_OPTION:
				return leftOption != null;
			case ExpressionPackage.ALTERNATIVE__RIGHT_OPTION:
				return rightOption != null;
		}
		return super.eIsSet(featureID);
	}

} //AlternativeImpl
