/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression.impl;

import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.ExpressionPackage;
import de.uka.ipd.sdq.spa.expression.Parallel;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parallel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.ParallelImpl#getLeftTask <em>Left Task</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.ParallelImpl#getRightTask <em>Right Task</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParallelImpl extends OperationImpl implements Parallel {
	/**
	 * The cached value of the '{@link #getLeftTask() <em>Left Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftTask()
	 * @generated
	 * @ordered
	 */
	protected Expression leftTask = null;

	/**
	 * The cached value of the '{@link #getRightTask() <em>Right Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightTask()
	 * @generated
	 * @ordered
	 */
	protected Expression rightTask = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParallelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.PARALLEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLeftTask() {
		return leftTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftTask(Expression newLeftTask, NotificationChain msgs) {
		Expression oldLeftTask = leftTask;
		leftTask = newLeftTask;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.PARALLEL__LEFT_TASK, oldLeftTask, newLeftTask);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftTask(Expression newLeftTask) {
		if (newLeftTask != leftTask) {
			NotificationChain msgs = null;
			if (leftTask != null)
				msgs = ((InternalEObject)leftTask).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.PARALLEL__LEFT_TASK, null, msgs);
			if (newLeftTask != null)
				msgs = ((InternalEObject)newLeftTask).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.PARALLEL__LEFT_TASK, null, msgs);
			msgs = basicSetLeftTask(newLeftTask, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.PARALLEL__LEFT_TASK, newLeftTask, newLeftTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRightTask() {
		return rightTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightTask(Expression newRightTask, NotificationChain msgs) {
		Expression oldRightTask = rightTask;
		rightTask = newRightTask;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.PARALLEL__RIGHT_TASK, oldRightTask, newRightTask);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightTask(Expression newRightTask) {
		if (newRightTask != rightTask) {
			NotificationChain msgs = null;
			if (rightTask != null)
				msgs = ((InternalEObject)rightTask).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.PARALLEL__RIGHT_TASK, null, msgs);
			if (newRightTask != null)
				msgs = ((InternalEObject)newRightTask).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.PARALLEL__RIGHT_TASK, null, msgs);
			msgs = basicSetRightTask(newRightTask, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.PARALLEL__RIGHT_TASK, newRightTask, newRightTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.PARALLEL__LEFT_TASK:
				return basicSetLeftTask(null, msgs);
			case ExpressionPackage.PARALLEL__RIGHT_TASK:
				return basicSetRightTask(null, msgs);
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
			case ExpressionPackage.PARALLEL__LEFT_TASK:
				return getLeftTask();
			case ExpressionPackage.PARALLEL__RIGHT_TASK:
				return getRightTask();
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
			case ExpressionPackage.PARALLEL__LEFT_TASK:
				setLeftTask((Expression)newValue);
				return;
			case ExpressionPackage.PARALLEL__RIGHT_TASK:
				setRightTask((Expression)newValue);
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
			case ExpressionPackage.PARALLEL__LEFT_TASK:
				setLeftTask((Expression)null);
				return;
			case ExpressionPackage.PARALLEL__RIGHT_TASK:
				setRightTask((Expression)null);
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
			case ExpressionPackage.PARALLEL__LEFT_TASK:
				return leftTask != null;
			case ExpressionPackage.PARALLEL__RIGHT_TASK:
				return rightTask != null;
		}
		return super.eIsSet(featureID);
	}

} //ParallelImpl
