/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx.impl;

import RegEx.Alternative;
import RegEx.DistributionFunction;
import RegEx.Expression;
import RegEx.RegExPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link RegEx.impl.AlternativeImpl#getDistributionFunction <em>Distribution Function</em>}</li>
 *   <li>{@link RegEx.impl.AlternativeImpl#getDistributionFunctionFreq <em>Distribution Function Freq</em>}</li>
 *   <li>{@link RegEx.impl.AlternativeImpl#getAltOne <em>Alt One</em>}</li>
 *   <li>{@link RegEx.impl.AlternativeImpl#getAltTwo <em>Alt Two</em>}</li>
 *   <li>{@link RegEx.impl.AlternativeImpl#getProbOne <em>Prob One</em>}</li>
 *   <li>{@link RegEx.impl.AlternativeImpl#getProbTwo <em>Prob Two</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlternativeImpl extends EObjectImpl implements Alternative {
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
	 * The cached value of the '{@link #getAltOne() <em>Alt One</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAltOne()
	 * @generated
	 * @ordered
	 */
	protected Expression altOne = null;

	/**
	 * The cached value of the '{@link #getAltTwo() <em>Alt Two</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAltTwo()
	 * @generated
	 * @ordered
	 */
	protected Expression altTwo = null;

	/**
	 * The default value of the '{@link #getProbOne() <em>Prob One</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbOne()
	 * @generated
	 * @ordered
	 */
	protected static final double PROB_ONE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProbOne() <em>Prob One</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbOne()
	 * @generated
	 * @ordered
	 */
	protected double probOne = PROB_ONE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProbTwo() <em>Prob Two</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbTwo()
	 * @generated
	 * @ordered
	 */
	protected static final double PROB_TWO_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProbTwo() <em>Prob Two</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbTwo()
	 * @generated
	 * @ordered
	 */
	protected double probTwo = PROB_TWO_EDEFAULT;

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
	protected EClass eStaticClass() {
		return RegExPackage.Literals.ALTERNATIVE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION, oldDistributionFunction, newDistributionFunction);
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
				msgs = ((InternalEObject)distributionFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION, null, msgs);
			if (newDistributionFunction != null)
				msgs = ((InternalEObject)newDistributionFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION, null, msgs);
			msgs = basicSetDistributionFunction(newDistributionFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION, newDistributionFunction, newDistributionFunction));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION_FREQ, oldDistributionFunctionFreq, newDistributionFunctionFreq);
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
				msgs = ((InternalEObject)distributionFunctionFreq).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION_FREQ, null, msgs);
			if (newDistributionFunctionFreq != null)
				msgs = ((InternalEObject)newDistributionFunctionFreq).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION_FREQ, null, msgs);
			msgs = basicSetDistributionFunctionFreq(newDistributionFunctionFreq, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION_FREQ, newDistributionFunctionFreq, newDistributionFunctionFreq));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getAltOne() {
		return altOne;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAltOne(Expression newAltOne, NotificationChain msgs) {
		Expression oldAltOne = altOne;
		altOne = newAltOne;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.ALTERNATIVE__ALT_ONE, oldAltOne, newAltOne);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAltOne(Expression newAltOne) {
		if (newAltOne != altOne) {
			NotificationChain msgs = null;
			if (altOne != null)
				msgs = ((InternalEObject)altOne).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.ALTERNATIVE__ALT_ONE, null, msgs);
			if (newAltOne != null)
				msgs = ((InternalEObject)newAltOne).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.ALTERNATIVE__ALT_ONE, null, msgs);
			msgs = basicSetAltOne(newAltOne, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.ALTERNATIVE__ALT_ONE, newAltOne, newAltOne));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getAltTwo() {
		return altTwo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAltTwo(Expression newAltTwo, NotificationChain msgs) {
		Expression oldAltTwo = altTwo;
		altTwo = newAltTwo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.ALTERNATIVE__ALT_TWO, oldAltTwo, newAltTwo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAltTwo(Expression newAltTwo) {
		if (newAltTwo != altTwo) {
			NotificationChain msgs = null;
			if (altTwo != null)
				msgs = ((InternalEObject)altTwo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.ALTERNATIVE__ALT_TWO, null, msgs);
			if (newAltTwo != null)
				msgs = ((InternalEObject)newAltTwo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.ALTERNATIVE__ALT_TWO, null, msgs);
			msgs = basicSetAltTwo(newAltTwo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.ALTERNATIVE__ALT_TWO, newAltTwo, newAltTwo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProbOne() {
		return probOne;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbOne(double newProbOne) {
		double oldProbOne = probOne;
		probOne = newProbOne;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.ALTERNATIVE__PROB_ONE, oldProbOne, probOne));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProbTwo() {
		return probTwo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbTwo(double newProbTwo) {
		double oldProbTwo = probTwo;
		probTwo = newProbTwo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.ALTERNATIVE__PROB_TWO, oldProbTwo, probTwo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION:
				return basicSetDistributionFunction(null, msgs);
			case RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION_FREQ:
				return basicSetDistributionFunctionFreq(null, msgs);
			case RegExPackage.ALTERNATIVE__ALT_ONE:
				return basicSetAltOne(null, msgs);
			case RegExPackage.ALTERNATIVE__ALT_TWO:
				return basicSetAltTwo(null, msgs);
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
			case RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION:
				return getDistributionFunction();
			case RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION_FREQ:
				return getDistributionFunctionFreq();
			case RegExPackage.ALTERNATIVE__ALT_ONE:
				return getAltOne();
			case RegExPackage.ALTERNATIVE__ALT_TWO:
				return getAltTwo();
			case RegExPackage.ALTERNATIVE__PROB_ONE:
				return new Double(getProbOne());
			case RegExPackage.ALTERNATIVE__PROB_TWO:
				return new Double(getProbTwo());
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
			case RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION:
				setDistributionFunction((DistributionFunction)newValue);
				return;
			case RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION_FREQ:
				setDistributionFunctionFreq((DistributionFunction)newValue);
				return;
			case RegExPackage.ALTERNATIVE__ALT_ONE:
				setAltOne((Expression)newValue);
				return;
			case RegExPackage.ALTERNATIVE__ALT_TWO:
				setAltTwo((Expression)newValue);
				return;
			case RegExPackage.ALTERNATIVE__PROB_ONE:
				setProbOne(((Double)newValue).doubleValue());
				return;
			case RegExPackage.ALTERNATIVE__PROB_TWO:
				setProbTwo(((Double)newValue).doubleValue());
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
			case RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION:
				setDistributionFunction((DistributionFunction)null);
				return;
			case RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION_FREQ:
				setDistributionFunctionFreq((DistributionFunction)null);
				return;
			case RegExPackage.ALTERNATIVE__ALT_ONE:
				setAltOne((Expression)null);
				return;
			case RegExPackage.ALTERNATIVE__ALT_TWO:
				setAltTwo((Expression)null);
				return;
			case RegExPackage.ALTERNATIVE__PROB_ONE:
				setProbOne(PROB_ONE_EDEFAULT);
				return;
			case RegExPackage.ALTERNATIVE__PROB_TWO:
				setProbTwo(PROB_TWO_EDEFAULT);
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
			case RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION:
				return distributionFunction != null;
			case RegExPackage.ALTERNATIVE__DISTRIBUTION_FUNCTION_FREQ:
				return distributionFunctionFreq != null;
			case RegExPackage.ALTERNATIVE__ALT_ONE:
				return altOne != null;
			case RegExPackage.ALTERNATIVE__ALT_TWO:
				return altTwo != null;
			case RegExPackage.ALTERNATIVE__PROB_ONE:
				return probOne != PROB_ONE_EDEFAULT;
			case RegExPackage.ALTERNATIVE__PROB_TWO:
				return probTwo != PROB_TWO_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (probOne: ");
		result.append(probOne);
		result.append(", probTwo: ");
		result.append(probTwo);
		result.append(')');
		return result.toString();
	}

} //AlternativeImpl