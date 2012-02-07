/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths.impl;

import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Creation Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsCreationParameterImpl#getN <em>N</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsCreationParameterImpl#getTargetId <em>Target Id</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsCreationParameterImpl#getAlpha <em>Alpha</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JJnPathsCreationParameterImpl extends EObjectImpl implements JJnPathsCreationParameter {
	/**
	 * The default value of the '{@link #getN() <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getN()
	 * @generated
	 * @ordered
	 */
	protected static final int N_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getN() <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getN()
	 * @generated
	 * @ordered
	 */
	protected int n = N_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetId() <em>Target Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetId()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetId() <em>Target Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetId()
	 * @generated
	 * @ordered
	 */
	protected String targetId = TARGET_ID_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JJnPathsCreationParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JJnPathsPackage.Literals.JJN_PATHS_CREATION_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getN() {
		return n;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setN(int newN) {
		int oldN = n;
		n = newN;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__N, oldN, n));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetId() {
		return targetId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetId(String newTargetId) {
		String oldTargetId = targetId;
		targetId = newTargetId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__TARGET_ID, oldTargetId, targetId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__ALPHA, oldAlpha, alpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__N:
				return getN();
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__TARGET_ID:
				return getTargetId();
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__ALPHA:
				return getAlpha();
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
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__N:
				setN((Integer)newValue);
				return;
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__TARGET_ID:
				setTargetId((String)newValue);
				return;
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__ALPHA:
				setAlpha((Double)newValue);
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
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__N:
				setN(N_EDEFAULT);
				return;
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__TARGET_ID:
				setTargetId(TARGET_ID_EDEFAULT);
				return;
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__ALPHA:
				setAlpha(ALPHA_EDEFAULT);
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
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__N:
				return n != N_EDEFAULT;
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__TARGET_ID:
				return TARGET_ID_EDEFAULT == null ? targetId != null : !TARGET_ID_EDEFAULT.equals(targetId);
			case JJnPathsPackage.JJN_PATHS_CREATION_PARAMETER__ALPHA:
				return alpha != ALPHA_EDEFAULT;
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
		result.append(" (n: ");
		result.append(n);
		result.append(", targetId: ");
		result.append(targetId);
		result.append(", alpha: ");
		result.append(alpha);
		result.append(')');
		return result.toString();
	}

} //JJnPathsCreationParameterImpl
