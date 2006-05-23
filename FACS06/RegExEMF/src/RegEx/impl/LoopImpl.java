/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx.impl;

import RegEx.DistributionFunction;
import RegEx.Expression;
import RegEx.Loop;
import RegEx.RegExPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link RegEx.impl.LoopImpl#getDistributionFunction <em>Distribution Function</em>}</li>
 *   <li>{@link RegEx.impl.LoopImpl#getDistributionFunctionFreq <em>Distribution Function Freq</em>}</li>
 *   <li>{@link RegEx.impl.LoopImpl#getInner <em>Inner</em>}</li>
 *   <li>{@link RegEx.impl.LoopImpl#getReiterationDistribution <em>Reiteration Distribution</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopImpl extends EObjectImpl implements Loop {
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
	 * The cached value of the '{@link #getInner() <em>Inner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInner()
	 * @generated
	 * @ordered
	 */
	protected Expression inner = null;

	/**
	 * The cached value of the '{@link #getReiterationDistribution() <em>Reiteration Distribution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReiterationDistribution()
	 * @generated
	 * @ordered
	 */
	protected DistributionFunction reiterationDistribution = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RegExPackage.Literals.LOOP;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.LOOP__DISTRIBUTION_FUNCTION, oldDistributionFunction, newDistributionFunction);
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
				msgs = ((InternalEObject)distributionFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.LOOP__DISTRIBUTION_FUNCTION, null, msgs);
			if (newDistributionFunction != null)
				msgs = ((InternalEObject)newDistributionFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.LOOP__DISTRIBUTION_FUNCTION, null, msgs);
			msgs = basicSetDistributionFunction(newDistributionFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.LOOP__DISTRIBUTION_FUNCTION, newDistributionFunction, newDistributionFunction));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.LOOP__DISTRIBUTION_FUNCTION_FREQ, oldDistributionFunctionFreq, newDistributionFunctionFreq);
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
				msgs = ((InternalEObject)distributionFunctionFreq).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.LOOP__DISTRIBUTION_FUNCTION_FREQ, null, msgs);
			if (newDistributionFunctionFreq != null)
				msgs = ((InternalEObject)newDistributionFunctionFreq).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.LOOP__DISTRIBUTION_FUNCTION_FREQ, null, msgs);
			msgs = basicSetDistributionFunctionFreq(newDistributionFunctionFreq, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.LOOP__DISTRIBUTION_FUNCTION_FREQ, newDistributionFunctionFreq, newDistributionFunctionFreq));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getInner() {
		return inner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInner(Expression newInner, NotificationChain msgs) {
		Expression oldInner = inner;
		inner = newInner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.LOOP__INNER, oldInner, newInner);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInner(Expression newInner) {
		if (newInner != inner) {
			NotificationChain msgs = null;
			if (inner != null)
				msgs = ((InternalEObject)inner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.LOOP__INNER, null, msgs);
			if (newInner != null)
				msgs = ((InternalEObject)newInner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.LOOP__INNER, null, msgs);
			msgs = basicSetInner(newInner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.LOOP__INNER, newInner, newInner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistributionFunction getReiterationDistribution() {
		return reiterationDistribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReiterationDistribution(DistributionFunction newReiterationDistribution, NotificationChain msgs) {
		DistributionFunction oldReiterationDistribution = reiterationDistribution;
		reiterationDistribution = newReiterationDistribution;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.LOOP__REITERATION_DISTRIBUTION, oldReiterationDistribution, newReiterationDistribution);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReiterationDistribution(DistributionFunction newReiterationDistribution) {
		if (newReiterationDistribution != reiterationDistribution) {
			NotificationChain msgs = null;
			if (reiterationDistribution != null)
				msgs = ((InternalEObject)reiterationDistribution).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.LOOP__REITERATION_DISTRIBUTION, null, msgs);
			if (newReiterationDistribution != null)
				msgs = ((InternalEObject)newReiterationDistribution).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.LOOP__REITERATION_DISTRIBUTION, null, msgs);
			msgs = basicSetReiterationDistribution(newReiterationDistribution, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.LOOP__REITERATION_DISTRIBUTION, newReiterationDistribution, newReiterationDistribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RegExPackage.LOOP__DISTRIBUTION_FUNCTION:
				return basicSetDistributionFunction(null, msgs);
			case RegExPackage.LOOP__DISTRIBUTION_FUNCTION_FREQ:
				return basicSetDistributionFunctionFreq(null, msgs);
			case RegExPackage.LOOP__INNER:
				return basicSetInner(null, msgs);
			case RegExPackage.LOOP__REITERATION_DISTRIBUTION:
				return basicSetReiterationDistribution(null, msgs);
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
			case RegExPackage.LOOP__DISTRIBUTION_FUNCTION:
				return getDistributionFunction();
			case RegExPackage.LOOP__DISTRIBUTION_FUNCTION_FREQ:
				return getDistributionFunctionFreq();
			case RegExPackage.LOOP__INNER:
				return getInner();
			case RegExPackage.LOOP__REITERATION_DISTRIBUTION:
				return getReiterationDistribution();
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
			case RegExPackage.LOOP__DISTRIBUTION_FUNCTION:
				setDistributionFunction((DistributionFunction)newValue);
				return;
			case RegExPackage.LOOP__DISTRIBUTION_FUNCTION_FREQ:
				setDistributionFunctionFreq((DistributionFunction)newValue);
				return;
			case RegExPackage.LOOP__INNER:
				setInner((Expression)newValue);
				return;
			case RegExPackage.LOOP__REITERATION_DISTRIBUTION:
				setReiterationDistribution((DistributionFunction)newValue);
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
			case RegExPackage.LOOP__DISTRIBUTION_FUNCTION:
				setDistributionFunction((DistributionFunction)null);
				return;
			case RegExPackage.LOOP__DISTRIBUTION_FUNCTION_FREQ:
				setDistributionFunctionFreq((DistributionFunction)null);
				return;
			case RegExPackage.LOOP__INNER:
				setInner((Expression)null);
				return;
			case RegExPackage.LOOP__REITERATION_DISTRIBUTION:
				setReiterationDistribution((DistributionFunction)null);
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
			case RegExPackage.LOOP__DISTRIBUTION_FUNCTION:
				return distributionFunction != null;
			case RegExPackage.LOOP__DISTRIBUTION_FUNCTION_FREQ:
				return distributionFunctionFreq != null;
			case RegExPackage.LOOP__INNER:
				return inner != null;
			case RegExPackage.LOOP__REITERATION_DISTRIBUTION:
				return reiterationDistribution != null;
		}
		return super.eIsSet(featureID);
	}

} //LoopImpl