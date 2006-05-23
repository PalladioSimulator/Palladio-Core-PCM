/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx.impl;

import RegEx.DistributionFunction;
import RegEx.RegExPackage;
import RegEx.Symbol;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Symbol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link RegEx.impl.SymbolImpl#getDistributionFunction <em>Distribution Function</em>}</li>
 *   <li>{@link RegEx.impl.SymbolImpl#getDistributionFunctionFreq <em>Distribution Function Freq</em>}</li>
 *   <li>{@link RegEx.impl.SymbolImpl#isFatherParallel <em>Father Parallel</em>}</li>
 *   <li>{@link RegEx.impl.SymbolImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SymbolImpl extends EObjectImpl implements Symbol {
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
	 * The default value of the '{@link #isFatherParallel() <em>Father Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFatherParallel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FATHER_PARALLEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFatherParallel() <em>Father Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFatherParallel()
	 * @generated
	 * @ordered
	 */
	protected boolean fatherParallel = FATHER_PARALLEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SymbolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RegExPackage.Literals.SYMBOL;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION, oldDistributionFunction, newDistributionFunction);
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
				msgs = ((InternalEObject)distributionFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION, null, msgs);
			if (newDistributionFunction != null)
				msgs = ((InternalEObject)newDistributionFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION, null, msgs);
			msgs = basicSetDistributionFunction(newDistributionFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION, newDistributionFunction, newDistributionFunction));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION_FREQ, oldDistributionFunctionFreq, newDistributionFunctionFreq);
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
				msgs = ((InternalEObject)distributionFunctionFreq).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION_FREQ, null, msgs);
			if (newDistributionFunctionFreq != null)
				msgs = ((InternalEObject)newDistributionFunctionFreq).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION_FREQ, null, msgs);
			msgs = basicSetDistributionFunctionFreq(newDistributionFunctionFreq, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION_FREQ, newDistributionFunctionFreq, newDistributionFunctionFreq));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFatherParallel() {
		return fatherParallel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFatherParallel(boolean newFatherParallel) {
		boolean oldFatherParallel = fatherParallel;
		fatherParallel = newFatherParallel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.SYMBOL__FATHER_PARALLEL, oldFatherParallel, fatherParallel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.SYMBOL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION:
				return basicSetDistributionFunction(null, msgs);
			case RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION_FREQ:
				return basicSetDistributionFunctionFreq(null, msgs);
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
			case RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION:
				return getDistributionFunction();
			case RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION_FREQ:
				return getDistributionFunctionFreq();
			case RegExPackage.SYMBOL__FATHER_PARALLEL:
				return isFatherParallel() ? Boolean.TRUE : Boolean.FALSE;
			case RegExPackage.SYMBOL__NAME:
				return getName();
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
			case RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION:
				setDistributionFunction((DistributionFunction)newValue);
				return;
			case RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION_FREQ:
				setDistributionFunctionFreq((DistributionFunction)newValue);
				return;
			case RegExPackage.SYMBOL__FATHER_PARALLEL:
				setFatherParallel(((Boolean)newValue).booleanValue());
				return;
			case RegExPackage.SYMBOL__NAME:
				setName((String)newValue);
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
			case RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION:
				setDistributionFunction((DistributionFunction)null);
				return;
			case RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION_FREQ:
				setDistributionFunctionFreq((DistributionFunction)null);
				return;
			case RegExPackage.SYMBOL__FATHER_PARALLEL:
				setFatherParallel(FATHER_PARALLEL_EDEFAULT);
				return;
			case RegExPackage.SYMBOL__NAME:
				setName(NAME_EDEFAULT);
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
			case RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION:
				return distributionFunction != null;
			case RegExPackage.SYMBOL__DISTRIBUTION_FUNCTION_FREQ:
				return distributionFunctionFreq != null;
			case RegExPackage.SYMBOL__FATHER_PARALLEL:
				return fatherParallel != FATHER_PARALLEL_EDEFAULT;
			case RegExPackage.SYMBOL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (fatherParallel: ");
		result.append(fatherParallel);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SymbolImpl