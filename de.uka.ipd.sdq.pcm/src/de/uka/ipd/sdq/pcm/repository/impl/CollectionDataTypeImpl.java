/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CollectionDataTypeImpl#getDataType_InnerCollectionDataType <em>Data Type Inner Collection Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionDataTypeImpl extends DataTypeImpl implements CollectionDataType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";
	/**
	 * The cached value of the '{@link #getDataType_InnerCollectionDataType() <em>Data Type Inner Collection Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType_InnerCollectionDataType()
	 * @generated
	 * @ordered
	 */
	protected DataType dataType_InnerCollectionDataType;
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
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.COLLECTION_DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDataType_InnerCollectionDataType() {
		if (dataType_InnerCollectionDataType != null && dataType_InnerCollectionDataType.eIsProxy()) {
			InternalEObject oldDataType_InnerCollectionDataType = (InternalEObject)dataType_InnerCollectionDataType;
			dataType_InnerCollectionDataType = (DataType)eResolveProxy(oldDataType_InnerCollectionDataType);
			if (dataType_InnerCollectionDataType != oldDataType_InnerCollectionDataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.COLLECTION_DATA_TYPE__DATA_TYPE_INNER_COLLECTION_DATA_TYPE, oldDataType_InnerCollectionDataType, dataType_InnerCollectionDataType));
			}
		}
		return dataType_InnerCollectionDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetDataType_InnerCollectionDataType() {
		return dataType_InnerCollectionDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType_InnerCollectionDataType(DataType newDataType_InnerCollectionDataType) {
		DataType oldDataType_InnerCollectionDataType = dataType_InnerCollectionDataType;
		dataType_InnerCollectionDataType = newDataType_InnerCollectionDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.COLLECTION_DATA_TYPE__DATA_TYPE_INNER_COLLECTION_DATA_TYPE, oldDataType_InnerCollectionDataType, dataType_InnerCollectionDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.COLLECTION_DATA_TYPE__DATA_TYPE_INNER_COLLECTION_DATA_TYPE:
				if (resolve) return getDataType_InnerCollectionDataType();
				return basicGetDataType_InnerCollectionDataType();
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
			case RepositoryPackage.COLLECTION_DATA_TYPE__DATA_TYPE_INNER_COLLECTION_DATA_TYPE:
				setDataType_InnerCollectionDataType((DataType)newValue);
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
			case RepositoryPackage.COLLECTION_DATA_TYPE__DATA_TYPE_INNER_COLLECTION_DATA_TYPE:
				setDataType_InnerCollectionDataType((DataType)null);
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
			case RepositoryPackage.COLLECTION_DATA_TYPE__DATA_TYPE_INNER_COLLECTION_DATA_TYPE:
				return dataType_InnerCollectionDataType != null;
		}
		return super.eIsSet(featureID);
	}

} //CollectionDataTypeImpl
