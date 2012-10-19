/**
 */
package probfunction.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import probfunction.Complex;
import probfunction.ProbfunctionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link probfunction.impl.ComplexImpl#getReal <em>Real</em>}</li>
 *   <li>{@link probfunction.impl.ComplexImpl#getImaginary <em>Imaginary</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexImpl extends EObjectImpl implements Complex {
	/**
	 * The default value of the '{@link #getReal() <em>Real</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReal()
	 * @generated
	 * @ordered
	 */
	protected static final double REAL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getReal() <em>Real</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReal()
	 * @generated
	 * @ordered
	 */
	protected double real = REAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getImaginary() <em>Imaginary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImaginary()
	 * @generated
	 * @ordered
	 */
	protected static final double IMAGINARY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getImaginary() <em>Imaginary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImaginary()
	 * @generated
	 * @ordered
	 */
	protected double imaginary = IMAGINARY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProbfunctionPackage.Literals.COMPLEX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getReal() {
		return real;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReal(double newReal) {
		double oldReal = real;
		real = newReal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProbfunctionPackage.COMPLEX__REAL, oldReal, real));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getImaginary() {
		return imaginary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImaginary(double newImaginary) {
		double oldImaginary = imaginary;
		imaginary = newImaginary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProbfunctionPackage.COMPLEX__IMAGINARY, oldImaginary, imaginary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProbfunctionPackage.COMPLEX__REAL:
				return getReal();
			case ProbfunctionPackage.COMPLEX__IMAGINARY:
				return getImaginary();
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
			case ProbfunctionPackage.COMPLEX__REAL:
				setReal((Double)newValue);
				return;
			case ProbfunctionPackage.COMPLEX__IMAGINARY:
				setImaginary((Double)newValue);
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
			case ProbfunctionPackage.COMPLEX__REAL:
				setReal(REAL_EDEFAULT);
				return;
			case ProbfunctionPackage.COMPLEX__IMAGINARY:
				setImaginary(IMAGINARY_EDEFAULT);
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
			case ProbfunctionPackage.COMPLEX__REAL:
				return real != REAL_EDEFAULT;
			case ProbfunctionPackage.COMPLEX__IMAGINARY:
				return imaginary != IMAGINARY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (real: ");
		result.append(real);
		result.append(", imaginary: ");
		result.append(imaginary);
		result.append(')');
		return result.toString();
	}

} //ComplexImpl
