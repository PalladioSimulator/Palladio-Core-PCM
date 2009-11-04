/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.entity.impl.NamedElementImpl;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inner Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InnerDeclarationImpl#getDatatype_InnerDeclaration <em>Datatype Inner Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InnerDeclarationImpl extends NamedElementImpl implements InnerDeclaration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";
	/**
	 * The cached value of the '{@link #getDatatype_InnerDeclaration() <em>Datatype Inner Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatype_InnerDeclaration()
	 * @generated
	 * @ordered
	 */
	protected DataType datatype_InnerDeclaration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InnerDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.INNER_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDatatype_InnerDeclaration() {
		if (datatype_InnerDeclaration != null && datatype_InnerDeclaration.eIsProxy()) {
			InternalEObject oldDatatype_InnerDeclaration = (InternalEObject)datatype_InnerDeclaration;
			datatype_InnerDeclaration = (DataType)eResolveProxy(oldDatatype_InnerDeclaration);
			if (datatype_InnerDeclaration != oldDatatype_InnerDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION, oldDatatype_InnerDeclaration, datatype_InnerDeclaration));
			}
		}
		return datatype_InnerDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetDatatype_InnerDeclaration() {
		return datatype_InnerDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatatype_InnerDeclaration(DataType newDatatype_InnerDeclaration) {
		DataType oldDatatype_InnerDeclaration = datatype_InnerDeclaration;
		datatype_InnerDeclaration = newDatatype_InnerDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION, oldDatatype_InnerDeclaration, datatype_InnerDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION:
				if (resolve) return getDatatype_InnerDeclaration();
				return basicGetDatatype_InnerDeclaration();
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
			case RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION:
				setDatatype_InnerDeclaration((DataType)newValue);
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
			case RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION:
				setDatatype_InnerDeclaration((DataType)null);
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
			case RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION:
				return datatype_InnerDeclaration != null;
		}
		return super.eIsSet(featureID);
	}

} //InnerDeclarationImpl
