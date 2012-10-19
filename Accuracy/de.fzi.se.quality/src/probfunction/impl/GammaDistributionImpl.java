/**
 */
package probfunction.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import probfunction.GammaDistribution;
import probfunction.ProbfunctionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gamma Distribution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link probfunction.impl.GammaDistributionImpl#getAlpha <em>Alpha</em>}</li>
 *   <li>{@link probfunction.impl.GammaDistributionImpl#getTheta <em>Theta</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GammaDistributionImpl extends ContinuousPDFImpl implements GammaDistribution {
	/**
	 * The default value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha()
	 * @generated
	 * @ordered
	 */
	protected static final double ALPHA_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha()
	 * @generated
	 * @ordered
	 */
	protected double alpha = ALPHA_EDEFAULT;

	/**
	 * The default value of the '{@link #getTheta() <em>Theta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheta()
	 * @generated
	 * @ordered
	 */
	protected static final double THETA_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTheta() <em>Theta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheta()
	 * @generated
	 * @ordered
	 */
	protected double theta = THETA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GammaDistributionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProbfunctionPackage.Literals.GAMMA_DISTRIBUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAlpha() {
		return alpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlpha(double newAlpha) {
		double oldAlpha = alpha;
		alpha = newAlpha;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProbfunctionPackage.GAMMA_DISTRIBUTION__ALPHA, oldAlpha, alpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTheta() {
		return theta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheta(double newTheta) {
		double oldTheta = theta;
		theta = newTheta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProbfunctionPackage.GAMMA_DISTRIBUTION__THETA, oldTheta, theta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProbfunctionPackage.GAMMA_DISTRIBUTION__ALPHA:
				return getAlpha();
			case ProbfunctionPackage.GAMMA_DISTRIBUTION__THETA:
				return getTheta();
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
			case ProbfunctionPackage.GAMMA_DISTRIBUTION__ALPHA:
				setAlpha((Double)newValue);
				return;
			case ProbfunctionPackage.GAMMA_DISTRIBUTION__THETA:
				setTheta((Double)newValue);
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
			case ProbfunctionPackage.GAMMA_DISTRIBUTION__ALPHA:
				setAlpha(ALPHA_EDEFAULT);
				return;
			case ProbfunctionPackage.GAMMA_DISTRIBUTION__THETA:
				setTheta(THETA_EDEFAULT);
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
			case ProbfunctionPackage.GAMMA_DISTRIBUTION__ALPHA:
				return alpha != ALPHA_EDEFAULT;
			case ProbfunctionPackage.GAMMA_DISTRIBUTION__THETA:
				return theta != THETA_EDEFAULT;
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
		result.append(" (alpha: ");
		result.append(alpha);
		result.append(", theta: ");
		result.append(theta);
		result.append(')');
		return result.toString();
	}

} //GammaDistributionImpl
