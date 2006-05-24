/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes.impl;

import AnnotationPackage.DefaultAnnotationDataTypes.BooleanAnnotation;
import AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage;

import AnnotationPackage.impl.AnnotationImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link AnnotationPackage.DefaultAnnotationDataTypes.impl.BooleanAnnotationImpl#isDataField <em>Data Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanAnnotationImpl extends AnnotationImpl implements BooleanAnnotation {
	/**
	 * The default value of the '{@link #isDataField() <em>Data Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDataField()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DATA_FIELD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDataField() <em>Data Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDataField()
	 * @generated
	 * @ordered
	 */
	protected boolean dataField = DATA_FIELD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DefaultAnnotationDataTypesPackage.Literals.BOOLEAN_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDataField() {
		return dataField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataField(boolean newDataField) {
		boolean oldDataField = dataField;
		dataField = newDataField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DefaultAnnotationDataTypesPackage.BOOLEAN_ANNOTATION__DATA_FIELD, oldDataField, dataField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DefaultAnnotationDataTypesPackage.BOOLEAN_ANNOTATION__DATA_FIELD:
				return isDataField() ? Boolean.TRUE : Boolean.FALSE;
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
			case DefaultAnnotationDataTypesPackage.BOOLEAN_ANNOTATION__DATA_FIELD:
				setDataField(((Boolean)newValue).booleanValue());
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
			case DefaultAnnotationDataTypesPackage.BOOLEAN_ANNOTATION__DATA_FIELD:
				setDataField(DATA_FIELD_EDEFAULT);
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
			case DefaultAnnotationDataTypesPackage.BOOLEAN_ANNOTATION__DATA_FIELD:
				return dataField != DATA_FIELD_EDEFAULT;
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
		result.append(" (dataField: ");
		result.append(dataField);
		result.append(')');
		return result.toString();
	}

} //BooleanAnnotationImpl