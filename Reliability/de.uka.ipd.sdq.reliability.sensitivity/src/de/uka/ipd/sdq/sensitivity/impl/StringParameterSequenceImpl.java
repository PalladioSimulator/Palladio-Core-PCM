/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeEList;

import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.StringParameterSequence;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Parameter Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.StringParameterSequenceImpl#getStringValues <em>String Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StringParameterSequenceImpl extends SensitivityParameterVariationImpl implements StringParameterSequence {
	/**
	 * The cached value of the '{@link #getStringValues() <em>String Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringValues()
	 * @generated
	 * @ordered
	 */
	protected EList<String> stringValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringParameterSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensitivityPackage.Literals.STRING_PARAMETER_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStringValues() {
		if (stringValues == null) {
			stringValues = new EDataTypeEList<String>(String.class, this, SensitivityPackage.STRING_PARAMETER_SEQUENCE__STRING_VALUES);
		}
		return stringValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SensitivityPackage.STRING_PARAMETER_SEQUENCE__STRING_VALUES:
				return getStringValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SensitivityPackage.STRING_PARAMETER_SEQUENCE__STRING_VALUES:
				getStringValues().clear();
				getStringValues().addAll((Collection<? extends String>)newValue);
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
			case SensitivityPackage.STRING_PARAMETER_SEQUENCE__STRING_VALUES:
				getStringValues().clear();
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
			case SensitivityPackage.STRING_PARAMETER_SEQUENCE__STRING_VALUES:
				return stringValues != null && !stringValues.isEmpty();
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
		result.append(" (stringValues: ");
		result.append(stringValues);
		result.append(')');
		return result.toString();
	}

} //StringParameterSequenceImpl
