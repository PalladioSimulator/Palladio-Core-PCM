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

import de.uka.ipd.sdq.sensitivity.DoubleParameterSequence;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Double Parameter Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.DoubleParameterSequenceImpl#getDoubleValues <em>Double Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DoubleParameterSequenceImpl extends DoubleParameterVariationImpl implements DoubleParameterSequence {
	/**
	 * The cached value of the '{@link #getDoubleValues() <em>Double Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> doubleValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleParameterSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensitivityPackage.Literals.DOUBLE_PARAMETER_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getDoubleValues() {
		if (doubleValues == null) {
			doubleValues = new EDataTypeEList<Double>(Double.class, this, SensitivityPackage.DOUBLE_PARAMETER_SEQUENCE__DOUBLE_VALUES);
		}
		return doubleValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SensitivityPackage.DOUBLE_PARAMETER_SEQUENCE__DOUBLE_VALUES:
				return getDoubleValues();
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
			case SensitivityPackage.DOUBLE_PARAMETER_SEQUENCE__DOUBLE_VALUES:
				getDoubleValues().clear();
				getDoubleValues().addAll((Collection<? extends Double>)newValue);
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
			case SensitivityPackage.DOUBLE_PARAMETER_SEQUENCE__DOUBLE_VALUES:
				getDoubleValues().clear();
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
			case SensitivityPackage.DOUBLE_PARAMETER_SEQUENCE__DOUBLE_VALUES:
				return doubleValues != null && !doubleValues.isEmpty();
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
		result.append(" (doubleValues: ");
		result.append(doubleValues);
		result.append(')');
		return result.toString();
	}

} //DoubleParameterSequenceImpl
