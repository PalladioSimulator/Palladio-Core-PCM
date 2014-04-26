/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.sensitivity.FailureDimension;
import de.uka.ipd.sdq.sensitivity.FailureDimensionResultSpecification;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Dimension Result Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.FailureDimensionResultSpecificationImpl#getFailureDimension__FailureDimensionResultSpecification <em>Failure Dimension Failure Dimension Result Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FailureDimensionResultSpecificationImpl extends SensitivityResultSpecificationImpl implements FailureDimensionResultSpecification {
	/**
     * The default value of the '{@link #getFailureDimension__FailureDimensionResultSpecification() <em>Failure Dimension Failure Dimension Result Specification</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFailureDimension__FailureDimensionResultSpecification()
     * @generated
     * @ordered
     */
	protected static final FailureDimension FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION_EDEFAULT = FailureDimension.SOFTWARE;

	/**
     * The cached value of the '{@link #getFailureDimension__FailureDimensionResultSpecification() <em>Failure Dimension Failure Dimension Result Specification</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFailureDimension__FailureDimensionResultSpecification()
     * @generated
     * @ordered
     */
	protected FailureDimension failureDimension__FailureDimensionResultSpecification = FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FailureDimensionResultSpecificationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SensitivityPackage.Literals.FAILURE_DIMENSION_RESULT_SPECIFICATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FailureDimension getFailureDimension__FailureDimensionResultSpecification() {
        return failureDimension__FailureDimensionResultSpecification;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFailureDimension__FailureDimensionResultSpecification(FailureDimension newFailureDimension__FailureDimensionResultSpecification) {
        FailureDimension oldFailureDimension__FailureDimensionResultSpecification = failureDimension__FailureDimensionResultSpecification;
        failureDimension__FailureDimensionResultSpecification = newFailureDimension__FailureDimensionResultSpecification == null ? FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION_EDEFAULT : newFailureDimension__FailureDimensionResultSpecification;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.FAILURE_DIMENSION_RESULT_SPECIFICATION__FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION, oldFailureDimension__FailureDimensionResultSpecification, failureDimension__FailureDimensionResultSpecification));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SensitivityPackage.FAILURE_DIMENSION_RESULT_SPECIFICATION__FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION:
                return getFailureDimension__FailureDimensionResultSpecification();
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
            case SensitivityPackage.FAILURE_DIMENSION_RESULT_SPECIFICATION__FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION:
                setFailureDimension__FailureDimensionResultSpecification((FailureDimension)newValue);
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
            case SensitivityPackage.FAILURE_DIMENSION_RESULT_SPECIFICATION__FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION:
                setFailureDimension__FailureDimensionResultSpecification(FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION_EDEFAULT);
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
            case SensitivityPackage.FAILURE_DIMENSION_RESULT_SPECIFICATION__FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION:
                return failureDimension__FailureDimensionResultSpecification != FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION_EDEFAULT;
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
        result.append(" (failureDimension__FailureDimensionResultSpecification: ");
        result.append(failureDimension__FailureDimensionResultSpecification);
        result.append(')');
        return result.toString();
    }

} //FailureDimensionResultSpecificationImpl
