/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CollectionDataTypeImpl#getInnerDataType__CollectionDataType <em>Inner Data Type Collection Data Type</em>}</li>
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
	 * The cached value of the '{@link #getInnerDataType__CollectionDataType() <em>Inner Data Type Collection Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerDataType__CollectionDataType()
	 * @generated
	 * @ordered
	 */
	protected DataType innerDataType__CollectionDataType;

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
	public DataType getInnerDataType__CollectionDataType() {
		if (innerDataType__CollectionDataType != null && innerDataType__CollectionDataType.eIsProxy()) {
			InternalEObject oldInnerDataType__CollectionDataType = (InternalEObject)innerDataType__CollectionDataType;
			innerDataType__CollectionDataType = (DataType)eResolveProxy(oldInnerDataType__CollectionDataType);
			if (innerDataType__CollectionDataType != oldInnerDataType__CollectionDataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.COLLECTION_DATA_TYPE__INNER_DATA_TYPE_COLLECTION_DATA_TYPE, oldInnerDataType__CollectionDataType, innerDataType__CollectionDataType));
			}
		}
		return innerDataType__CollectionDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetInnerDataType__CollectionDataType() {
		return innerDataType__CollectionDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerDataType__CollectionDataType(DataType newInnerDataType__CollectionDataType) {
		DataType oldInnerDataType__CollectionDataType = innerDataType__CollectionDataType;
		innerDataType__CollectionDataType = newInnerDataType__CollectionDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.COLLECTION_DATA_TYPE__INNER_DATA_TYPE_COLLECTION_DATA_TYPE, oldInnerDataType__CollectionDataType, innerDataType__CollectionDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.COLLECTION_DATA_TYPE__INNER_DATA_TYPE_COLLECTION_DATA_TYPE:
				if (resolve) return getInnerDataType__CollectionDataType();
				return basicGetInnerDataType__CollectionDataType();
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
			case RepositoryPackage.COLLECTION_DATA_TYPE__INNER_DATA_TYPE_COLLECTION_DATA_TYPE:
				setInnerDataType__CollectionDataType((DataType)newValue);
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
			case RepositoryPackage.COLLECTION_DATA_TYPE__INNER_DATA_TYPE_COLLECTION_DATA_TYPE:
				setInnerDataType__CollectionDataType((DataType)null);
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
			case RepositoryPackage.COLLECTION_DATA_TYPE__INNER_DATA_TYPE_COLLECTION_DATA_TYPE:
				return innerDataType__CollectionDataType != null;
		}
		return super.eIsSet(featureID);
	}

} //CollectionDataTypeImpl
