/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

import de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence;
import de.uka.ipd.sdq.sensitivity.DoubleOffsetType;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Double Offset Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.DoubleOffsetSequenceImpl#getOffsetValues <em>Offset Values</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.DoubleOffsetSequenceImpl#getDoubleOffsetType__DoubleOffsetSequence <em>Double Offset Type Double Offset Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DoubleOffsetSequenceImpl extends DoubleParameterVariationImpl implements DoubleOffsetSequence {
	/**
     * The cached value of the '{@link #getOffsetValues() <em>Offset Values</em>}' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOffsetValues()
     * @generated
     * @ordered
     */
	protected EList<Double> offsetValues;

	/**
     * The default value of the '{@link #getDoubleOffsetType__DoubleOffsetSequence() <em>Double Offset Type Double Offset Sequence</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDoubleOffsetType__DoubleOffsetSequence()
     * @generated
     * @ordered
     */
	protected static final DoubleOffsetType DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE_EDEFAULT = DoubleOffsetType.ADD;

	/**
     * The cached value of the '{@link #getDoubleOffsetType__DoubleOffsetSequence() <em>Double Offset Type Double Offset Sequence</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDoubleOffsetType__DoubleOffsetSequence()
     * @generated
     * @ordered
     */
	protected DoubleOffsetType doubleOffsetType__DoubleOffsetSequence = DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DoubleOffsetSequenceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SensitivityPackage.Literals.DOUBLE_OFFSET_SEQUENCE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Double> getOffsetValues() {
        if (offsetValues == null) {
            offsetValues = new EDataTypeEList<Double>(Double.class, this, SensitivityPackage.DOUBLE_OFFSET_SEQUENCE__OFFSET_VALUES);
        }
        return offsetValues;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DoubleOffsetType getDoubleOffsetType__DoubleOffsetSequence() {
        return doubleOffsetType__DoubleOffsetSequence;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDoubleOffsetType__DoubleOffsetSequence(DoubleOffsetType newDoubleOffsetType__DoubleOffsetSequence) {
        DoubleOffsetType oldDoubleOffsetType__DoubleOffsetSequence = doubleOffsetType__DoubleOffsetSequence;
        doubleOffsetType__DoubleOffsetSequence = newDoubleOffsetType__DoubleOffsetSequence == null ? DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE_EDEFAULT : newDoubleOffsetType__DoubleOffsetSequence;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.DOUBLE_OFFSET_SEQUENCE__DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE, oldDoubleOffsetType__DoubleOffsetSequence, doubleOffsetType__DoubleOffsetSequence));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SensitivityPackage.DOUBLE_OFFSET_SEQUENCE__OFFSET_VALUES:
                return getOffsetValues();
            case SensitivityPackage.DOUBLE_OFFSET_SEQUENCE__DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE:
                return getDoubleOffsetType__DoubleOffsetSequence();
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
            case SensitivityPackage.DOUBLE_OFFSET_SEQUENCE__OFFSET_VALUES:
                getOffsetValues().clear();
                getOffsetValues().addAll((Collection<? extends Double>)newValue);
                return;
            case SensitivityPackage.DOUBLE_OFFSET_SEQUENCE__DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE:
                setDoubleOffsetType__DoubleOffsetSequence((DoubleOffsetType)newValue);
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
            case SensitivityPackage.DOUBLE_OFFSET_SEQUENCE__OFFSET_VALUES:
                getOffsetValues().clear();
                return;
            case SensitivityPackage.DOUBLE_OFFSET_SEQUENCE__DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE:
                setDoubleOffsetType__DoubleOffsetSequence(DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE_EDEFAULT);
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
            case SensitivityPackage.DOUBLE_OFFSET_SEQUENCE__OFFSET_VALUES:
                return offsetValues != null && !offsetValues.isEmpty();
            case SensitivityPackage.DOUBLE_OFFSET_SEQUENCE__DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE:
                return doubleOffsetType__DoubleOffsetSequence != DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE_EDEFAULT;
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
        result.append(" (offsetValues: ");
        result.append(offsetValues);
        result.append(", doubleOffsetType__DoubleOffsetSequence: ");
        result.append(doubleOffsetType__DoubleOffsetSequence);
        result.append(')');
        return result.toString();
    }

} //DoubleOffsetSequenceImpl
