/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package copyException.impl;

import copyException.CopyExceptionPackage;
import copyException.DeletionException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deletion Exception</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link copyException.impl.DeletionExceptionImpl#getObject <em>Object</em>}</li>
 *   <li>{@link copyException.impl.DeletionExceptionImpl#getOcle <em>Ocle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeletionExceptionImpl extends ExceptionImpl implements DeletionException {
	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EClass object;

	/**
	 * The default value of the '{@link #getOcle() <em>Ocle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOcle()
	 * @generated
	 * @ordered
	 */
	protected static final String OCLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOcle() <em>Ocle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOcle()
	 * @generated
	 * @ordered
	 */
	protected String ocle = OCLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeletionExceptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CopyExceptionPackage.Literals.DELETION_EXCEPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObject() {
		if (object != null && object.eIsProxy()) {
			InternalEObject oldObject = (InternalEObject)object;
			object = (EClass)eResolveProxy(oldObject);
			if (object != oldObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CopyExceptionPackage.DELETION_EXCEPTION__OBJECT, oldObject, object));
			}
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(EClass newObject) {
		EClass oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CopyExceptionPackage.DELETION_EXCEPTION__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOcle() {
		return ocle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOcle(String newOcle) {
		String oldOcle = ocle;
		ocle = newOcle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CopyExceptionPackage.DELETION_EXCEPTION__OCLE, oldOcle, ocle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CopyExceptionPackage.DELETION_EXCEPTION__OBJECT:
				if (resolve) return getObject();
				return basicGetObject();
			case CopyExceptionPackage.DELETION_EXCEPTION__OCLE:
				return getOcle();
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
			case CopyExceptionPackage.DELETION_EXCEPTION__OBJECT:
				setObject((EClass)newValue);
				return;
			case CopyExceptionPackage.DELETION_EXCEPTION__OCLE:
				setOcle((String)newValue);
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
			case CopyExceptionPackage.DELETION_EXCEPTION__OBJECT:
				setObject((EClass)null);
				return;
			case CopyExceptionPackage.DELETION_EXCEPTION__OCLE:
				setOcle(OCLE_EDEFAULT);
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
			case CopyExceptionPackage.DELETION_EXCEPTION__OBJECT:
				return object != null;
			case CopyExceptionPackage.DELETION_EXCEPTION__OCLE:
				return OCLE_EDEFAULT == null ? ocle != null : !OCLE_EDEFAULT.equals(ocle);
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
		result.append(" (ocle: ");
		result.append(ocle);
		result.append(')');
		return result.toString();
	}

} //DeletionExceptionImpl
