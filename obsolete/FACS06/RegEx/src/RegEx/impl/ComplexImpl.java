/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx.impl;

import RegEx.Complex;
import RegEx.RegExPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link RegEx.impl.ComplexImpl#getRe <em>Re</em>}</li>
 *   <li>{@link RegEx.impl.ComplexImpl#getIm <em>Im</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexImpl extends EObjectImpl implements Complex {
	/**
	 * The default value of the '{@link #getRe() <em>Re</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRe()
	 * @generated
	 * @ordered
	 */
	protected static final double RE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRe() <em>Re</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRe()
	 * @generated
	 * @ordered
	 */
	protected double re = RE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIm() <em>Im</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIm()
	 * @generated
	 * @ordered
	 */
	protected static final double IM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getIm() <em>Im</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIm()
	 * @generated
	 * @ordered
	 */
	protected double im = IM_EDEFAULT;

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
	protected EClass eStaticClass() {
		return RegExPackage.Literals.COMPLEX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRe() {
		return re;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRe(double newRe) {
		double oldRe = re;
		re = newRe;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.COMPLEX__RE, oldRe, re));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIm() {
		return im;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIm(double newIm) {
		double oldIm = im;
		im = newIm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.COMPLEX__IM, oldIm, im));
	}

	public ComplexImpl(double real, double imag) {
		super();
		re = real;
		im = imag;
	}
	
    public double abs()   { 
    	return Math.sqrt(re*re + im*im);  
    }
    
    public double phase() { 
    	return Math.atan2(im, re);        
    }

    // return a new object whose value is (this + b)
    public Complex plus(Complex b) {
        Complex a = this;             // invoking object
        double real = a.getRe() + b.getRe();
        double imag = a.getIm() + b.getIm();
        Complex sum = new ComplexImpl(real, imag);
        return sum;
    }

    // return a new object whose value is (this - b)
    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.getRe() - b.getRe();
        double imag = a.getIm() - b.getIm();
        Complex diff = new ComplexImpl(real, imag);
        return diff;
    }

    // return a new object whose value is (this * b)
    public Complex times(Complex b) {
        Complex a = this;
        double real = a.getRe() * b.getRe() - a.getIm() * b.getIm();
        double imag = a.getRe() * b.getIm() + a.getIm() * b.getRe();
        Complex prod = new ComplexImpl(real, imag);
        return prod;
    }

    // return a new object whose value is the conjugate of this
    public Complex conjugate() {  return new ComplexImpl(re, -im); }

    // return a new object whose value is the reciprocal of this
    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new ComplexImpl(re / scale, -im / scale);
    }


    // return a / b
    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    // a static version of plus
    public Complex plus(Complex a, Complex b) {
        double real = a.getRe() + b.getRe();
        double imag = a.getIm() + b.getIm();
        Complex sum = new ComplexImpl(real, imag);
        return sum;
    }
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RegExPackage.COMPLEX__RE:
				return new Double(getRe());
			case RegExPackage.COMPLEX__IM:
				return new Double(getIm());
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
			case RegExPackage.COMPLEX__RE:
				setRe(((Double)newValue).doubleValue());
				return;
			case RegExPackage.COMPLEX__IM:
				setIm(((Double)newValue).doubleValue());
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
			case RegExPackage.COMPLEX__RE:
				setRe(RE_EDEFAULT);
				return;
			case RegExPackage.COMPLEX__IM:
				setIm(IM_EDEFAULT);
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
			case RegExPackage.COMPLEX__RE:
				return re != RE_EDEFAULT;
			case RegExPackage.COMPLEX__IM:
				return im != IM_EDEFAULT;
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
		result.append(" (re: ");
		result.append(re);
		result.append(", im: ");
		result.append(im);
		result.append(')');
		return result.toString();
	}

} //ComplexImpl