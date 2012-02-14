/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl;


import de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityPropertiesPackage;
import de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityProperty;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quality Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl.QualityPropertyImpl#getQualityValue <em>Quality Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class QualityPropertyImpl extends EObjectImpl implements QualityProperty {
	/**
	 * The default value of the '{@link #getQualityValue() <em>Quality Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object QUALITY_VALUE_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualityPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityPropertiesPackage.Literals.QUALITY_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getQualityValue() {
		// TODO: implement this method to return the 'Quality Value' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualityValue(Object newQualityValue) {
		// TODO: implement this method to set the 'Quality Value' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QualityPropertiesPackage.QUALITY_PROPERTY__QUALITY_VALUE:
				return getQualityValue();
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
			case QualityPropertiesPackage.QUALITY_PROPERTY__QUALITY_VALUE:
				setQualityValue(newValue);
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
			case QualityPropertiesPackage.QUALITY_PROPERTY__QUALITY_VALUE:
				setQualityValue(QUALITY_VALUE_EDEFAULT);
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
			case QualityPropertiesPackage.QUALITY_PROPERTY__QUALITY_VALUE:
				return QUALITY_VALUE_EDEFAULT == null ? getQualityValue() != null : !QUALITY_VALUE_EDEFAULT.equals(getQualityValue());
		}
		return super.eIsSet(featureID);
	}

} //QualityPropertyImpl
