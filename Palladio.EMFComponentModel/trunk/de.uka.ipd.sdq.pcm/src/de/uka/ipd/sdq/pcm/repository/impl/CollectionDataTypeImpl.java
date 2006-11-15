
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CollectionDataTypeImpl#getInnerType_CollectionDataType <em>Inner Type Collection Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionDataTypeImpl extends EntityImpl implements CollectionDataType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getInnerType_CollectionDataType() <em>Inner Type Collection Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerType_CollectionDataType()
	 * @generated
	 * @ordered
	 */
	protected DataType innerType_CollectionDataType = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.COLLECTION_DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getInnerType_CollectionDataType() {
		if (innerType_CollectionDataType != null && innerType_CollectionDataType.eIsProxy()) {
			InternalEObject oldInnerType_CollectionDataType = (InternalEObject)innerType_CollectionDataType;
			innerType_CollectionDataType = (DataType)eResolveProxy(oldInnerType_CollectionDataType);
			if (innerType_CollectionDataType != oldInnerType_CollectionDataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE, oldInnerType_CollectionDataType, innerType_CollectionDataType));
			}
		}
		return innerType_CollectionDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetInnerType_CollectionDataType() {
		return innerType_CollectionDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerType_CollectionDataType(DataType newInnerType_CollectionDataType) {
		DataType oldInnerType_CollectionDataType = innerType_CollectionDataType;
		innerType_CollectionDataType = newInnerType_CollectionDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE, oldInnerType_CollectionDataType, innerType_CollectionDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE:
				if (resolve) return getInnerType_CollectionDataType();
				return basicGetInnerType_CollectionDataType();
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
			case RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE:
				setInnerType_CollectionDataType((DataType)newValue);
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
			case RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE:
				setInnerType_CollectionDataType((DataType)null);
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
			case RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE:
				return innerType_CollectionDataType != null;
		}
		return super.eIsSet(featureID);
	}

} //CollectionDataTypeImpl