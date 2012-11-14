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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import de.uka.ipd.sdq.pcm.reliability.FailureType;
import de.uka.ipd.sdq.sensitivity.FailureTypeResultSpecification;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Type Result Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.FailureTypeResultSpecificationImpl#getFailureTypes__FailureTypeResultSpecification <em>Failure Types Failure Type Result Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FailureTypeResultSpecificationImpl extends SensitivityResultSpecificationImpl implements FailureTypeResultSpecification {
	/**
	 * The cached value of the '{@link #getFailureTypes__FailureTypeResultSpecification() <em>Failure Types Failure Type Result Specification</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureTypes__FailureTypeResultSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureType> failureTypes__FailureTypeResultSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FailureTypeResultSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensitivityPackage.Literals.FAILURE_TYPE_RESULT_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureType> getFailureTypes__FailureTypeResultSpecification() {
		if (failureTypes__FailureTypeResultSpecification == null) {
			failureTypes__FailureTypeResultSpecification = new EObjectResolvingEList<FailureType>(FailureType.class, this, SensitivityPackage.FAILURE_TYPE_RESULT_SPECIFICATION__FAILURE_TYPES_FAILURE_TYPE_RESULT_SPECIFICATION);
		}
		return failureTypes__FailureTypeResultSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SensitivityPackage.FAILURE_TYPE_RESULT_SPECIFICATION__FAILURE_TYPES_FAILURE_TYPE_RESULT_SPECIFICATION:
				return getFailureTypes__FailureTypeResultSpecification();
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
			case SensitivityPackage.FAILURE_TYPE_RESULT_SPECIFICATION__FAILURE_TYPES_FAILURE_TYPE_RESULT_SPECIFICATION:
				getFailureTypes__FailureTypeResultSpecification().clear();
				getFailureTypes__FailureTypeResultSpecification().addAll((Collection<? extends FailureType>)newValue);
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
			case SensitivityPackage.FAILURE_TYPE_RESULT_SPECIFICATION__FAILURE_TYPES_FAILURE_TYPE_RESULT_SPECIFICATION:
				getFailureTypes__FailureTypeResultSpecification().clear();
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
			case SensitivityPackage.FAILURE_TYPE_RESULT_SPECIFICATION__FAILURE_TYPES_FAILURE_TYPE_RESULT_SPECIFICATION:
				return failureTypes__FailureTypeResultSpecification != null && !failureTypes__FailureTypeResultSpecification.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FailureTypeResultSpecificationImpl
