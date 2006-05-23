/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx.impl;

import RegEx.DistributionFunction;
import RegEx.Expression;
import RegEx.Parallel;
import RegEx.RegExPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parallel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link RegEx.impl.ParallelImpl#getDistributionFunction <em>Distribution Function</em>}</li>
 *   <li>{@link RegEx.impl.ParallelImpl#getDistributionFunctionFreq <em>Distribution Function Freq</em>}</li>
 *   <li>{@link RegEx.impl.ParallelImpl#getTaskOne <em>Task One</em>}</li>
 *   <li>{@link RegEx.impl.ParallelImpl#getTaskTwo <em>Task Two</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParallelImpl extends EObjectImpl implements Parallel {
	/**
	 * The cached value of the '{@link #getDistributionFunction() <em>Distribution Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistributionFunction()
	 * @generated
	 * @ordered
	 */
	protected DistributionFunction distributionFunction = null;

	/**
	 * The cached value of the '{@link #getDistributionFunctionFreq() <em>Distribution Function Freq</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistributionFunctionFreq()
	 * @generated
	 * @ordered
	 */
	protected DistributionFunction distributionFunctionFreq = null;

	/**
	 * The cached value of the '{@link #getTaskOne() <em>Task One</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskOne()
	 * @generated
	 * @ordered
	 */
	protected Expression taskOne = null;

	/**
	 * The cached value of the '{@link #getTaskTwo() <em>Task Two</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskTwo()
	 * @generated
	 * @ordered
	 */
	protected Expression taskTwo = null;

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
	protected EClass eStaticClass() {
		return RegExPackage.Literals.PARALLEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistributionFunction getDistributionFunction() {
		return distributionFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDistributionFunction(DistributionFunction newDistributionFunction, NotificationChain msgs) {
		DistributionFunction oldDistributionFunction = distributionFunction;
		distributionFunction = newDistributionFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION, oldDistributionFunction, newDistributionFunction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistributionFunction(DistributionFunction newDistributionFunction) {
		if (newDistributionFunction != distributionFunction) {
			NotificationChain msgs = null;
			if (distributionFunction != null)
				msgs = ((InternalEObject)distributionFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION, null, msgs);
			if (newDistributionFunction != null)
				msgs = ((InternalEObject)newDistributionFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION, null, msgs);
			msgs = basicSetDistributionFunction(newDistributionFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION, newDistributionFunction, newDistributionFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistributionFunction getDistributionFunctionFreq() {
		return distributionFunctionFreq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDistributionFunctionFreq(DistributionFunction newDistributionFunctionFreq, NotificationChain msgs) {
		DistributionFunction oldDistributionFunctionFreq = distributionFunctionFreq;
		distributionFunctionFreq = newDistributionFunctionFreq;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION_FREQ, oldDistributionFunctionFreq, newDistributionFunctionFreq);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistributionFunctionFreq(DistributionFunction newDistributionFunctionFreq) {
		if (newDistributionFunctionFreq != distributionFunctionFreq) {
			NotificationChain msgs = null;
			if (distributionFunctionFreq != null)
				msgs = ((InternalEObject)distributionFunctionFreq).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION_FREQ, null, msgs);
			if (newDistributionFunctionFreq != null)
				msgs = ((InternalEObject)newDistributionFunctionFreq).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION_FREQ, null, msgs);
			msgs = basicSetDistributionFunctionFreq(newDistributionFunctionFreq, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION_FREQ, newDistributionFunctionFreq, newDistributionFunctionFreq));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTaskOne() {
		return taskOne;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTaskOne(Expression newTaskOne, NotificationChain msgs) {
		Expression oldTaskOne = taskOne;
		taskOne = newTaskOne;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.PARALLEL__TASK_ONE, oldTaskOne, newTaskOne);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskOne(Expression newTaskOne) {
		if (newTaskOne != taskOne) {
			NotificationChain msgs = null;
			if (taskOne != null)
				msgs = ((InternalEObject)taskOne).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.PARALLEL__TASK_ONE, null, msgs);
			if (newTaskOne != null)
				msgs = ((InternalEObject)newTaskOne).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.PARALLEL__TASK_ONE, null, msgs);
			msgs = basicSetTaskOne(newTaskOne, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.PARALLEL__TASK_ONE, newTaskOne, newTaskOne));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTaskTwo() {
		return taskTwo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTaskTwo(Expression newTaskTwo, NotificationChain msgs) {
		Expression oldTaskTwo = taskTwo;
		taskTwo = newTaskTwo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.PARALLEL__TASK_TWO, oldTaskTwo, newTaskTwo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskTwo(Expression newTaskTwo) {
		if (newTaskTwo != taskTwo) {
			NotificationChain msgs = null;
			if (taskTwo != null)
				msgs = ((InternalEObject)taskTwo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.PARALLEL__TASK_TWO, null, msgs);
			if (newTaskTwo != null)
				msgs = ((InternalEObject)newTaskTwo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.PARALLEL__TASK_TWO, null, msgs);
			msgs = basicSetTaskTwo(newTaskTwo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.PARALLEL__TASK_TWO, newTaskTwo, newTaskTwo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION:
				return basicSetDistributionFunction(null, msgs);
			case RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION_FREQ:
				return basicSetDistributionFunctionFreq(null, msgs);
			case RegExPackage.PARALLEL__TASK_ONE:
				return basicSetTaskOne(null, msgs);
			case RegExPackage.PARALLEL__TASK_TWO:
				return basicSetTaskTwo(null, msgs);
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
			case RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION:
				return getDistributionFunction();
			case RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION_FREQ:
				return getDistributionFunctionFreq();
			case RegExPackage.PARALLEL__TASK_ONE:
				return getTaskOne();
			case RegExPackage.PARALLEL__TASK_TWO:
				return getTaskTwo();
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
			case RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION:
				setDistributionFunction((DistributionFunction)newValue);
				return;
			case RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION_FREQ:
				setDistributionFunctionFreq((DistributionFunction)newValue);
				return;
			case RegExPackage.PARALLEL__TASK_ONE:
				setTaskOne((Expression)newValue);
				return;
			case RegExPackage.PARALLEL__TASK_TWO:
				setTaskTwo((Expression)newValue);
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
			case RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION:
				setDistributionFunction((DistributionFunction)null);
				return;
			case RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION_FREQ:
				setDistributionFunctionFreq((DistributionFunction)null);
				return;
			case RegExPackage.PARALLEL__TASK_ONE:
				setTaskOne((Expression)null);
				return;
			case RegExPackage.PARALLEL__TASK_TWO:
				setTaskTwo((Expression)null);
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
			case RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION:
				return distributionFunction != null;
			case RegExPackage.PARALLEL__DISTRIBUTION_FUNCTION_FREQ:
				return distributionFunctionFreq != null;
			case RegExPackage.PARALLEL__TASK_ONE:
				return taskOne != null;
			case RegExPackage.PARALLEL__TASK_TWO:
				return taskTwo != null;
		}
		return super.eIsSet(featureID);
	}

} //ParallelImpl