/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.impl;

import AnnotationPackage.Annotation;
import AnnotationPackage.AnnotationPackagePackage;
import AnnotationPackage.AnnotationType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link AnnotationPackage.impl.AnnotationImpl#getAnnotationTypeID <em>Annotation Type ID</em>}</li>
 *   <li>{@link AnnotationPackage.impl.AnnotationImpl#isIsCalculated <em>Is Calculated</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AnnotationImpl extends EObjectImpl implements Annotation {
	/**
	 * The default value of the '{@link #getAnnotationTypeID() <em>Annotation Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationTypeID()
	 * @generated
	 * @ordered
	 */
	protected static final AnnotationType ANNOTATION_TYPE_ID_EDEFAULT = AnnotationType.DESCRIPTION_LITERAL;

	/**
	 * The cached value of the '{@link #getAnnotationTypeID() <em>Annotation Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationTypeID()
	 * @generated
	 * @ordered
	 */
	protected AnnotationType annotationTypeID = ANNOTATION_TYPE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsCalculated() <em>Is Calculated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCalculated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CALCULATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCalculated() <em>Is Calculated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCalculated()
	 * @generated
	 * @ordered
	 */
	protected boolean isCalculated = IS_CALCULATED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AnnotationPackagePackage.Literals.ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationType getAnnotationTypeID() {
		return annotationTypeID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCalculated() {
		return isCalculated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCalculated(boolean newIsCalculated) {
		boolean oldIsCalculated = isCalculated;
		isCalculated = newIsCalculated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnnotationPackagePackage.ANNOTATION__IS_CALCULATED, oldIsCalculated, isCalculated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnnotationPackagePackage.ANNOTATION__ANNOTATION_TYPE_ID:
				return getAnnotationTypeID();
			case AnnotationPackagePackage.ANNOTATION__IS_CALCULATED:
				return isIsCalculated() ? Boolean.TRUE : Boolean.FALSE;
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
			case AnnotationPackagePackage.ANNOTATION__IS_CALCULATED:
				setIsCalculated(((Boolean)newValue).booleanValue());
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
			case AnnotationPackagePackage.ANNOTATION__IS_CALCULATED:
				setIsCalculated(IS_CALCULATED_EDEFAULT);
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
			case AnnotationPackagePackage.ANNOTATION__ANNOTATION_TYPE_ID:
				return annotationTypeID != ANNOTATION_TYPE_ID_EDEFAULT;
			case AnnotationPackagePackage.ANNOTATION__IS_CALCULATED:
				return isCalculated != IS_CALCULATED_EDEFAULT;
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
		result.append(" (annotationTypeID: ");
		result.append(annotationTypeID);
		result.append(", isCalculated: ");
		result.append(isCalculated);
		result.append(')');
		return result.toString();
	}

} //AnnotationImpl