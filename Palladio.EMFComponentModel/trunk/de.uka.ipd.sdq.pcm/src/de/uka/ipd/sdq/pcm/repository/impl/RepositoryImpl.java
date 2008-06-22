/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getRepositoryDescription <em>Repository Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getComponents__Repository <em>Components Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getInterfaces__Repository <em>Interfaces Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getDatatypes_Repository <em>Datatypes Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RepositoryImpl extends EntityImpl implements Repository {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The default value of the '{@link #getRepositoryDescription() <em>Repository Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryDescription() <em>Repository Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryDescription()
	 * @generated
	 * @ordered
	 */
	protected String repositoryDescription = REPOSITORY_DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComponents__Repository() <em>Components Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents__Repository()
	 * @generated
	 * @ordered
	 */
	protected EList<ProvidesComponentType> components__Repository;

	/**
	 * The cached value of the '{@link #getInterfaces__Repository() <em>Interfaces Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaces__Repository()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> interfaces__Repository;

	/**
	 * The cached value of the '{@link #getDatatypes_Repository() <em>Datatypes Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatypes_Repository()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> datatypes_Repository;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryDescription() {
		return repositoryDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryDescription(String newRepositoryDescription) {
		String oldRepositoryDescription = repositoryDescription;
		repositoryDescription = newRepositoryDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION, oldRepositoryDescription, repositoryDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProvidesComponentType> getComponents__Repository() {
		if (components__Repository == null) {
			components__Repository = new EObjectContainmentWithInverseEList<ProvidesComponentType>(ProvidesComponentType.class, this, RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY, RepositoryPackage.PROVIDES_COMPONENT_TYPE__REPOSITORY_PROVIDES_COMPONENT_TYPE);
		}
		return components__Repository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getInterfaces__Repository() {
		if (interfaces__Repository == null) {
			interfaces__Repository = new EObjectContainmentWithInverseEList<Interface>(Interface.class, this, RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY, RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE);
		}
		return interfaces__Repository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataType> getDatatypes_Repository() {
		if (datatypes_Repository == null) {
			datatypes_Repository = new EObjectContainmentWithInverseEList<DataType>(DataType.class, this, RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY, RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE);
		}
		return datatypes_Repository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComponents__Repository()).basicAdd(otherEnd, msgs);
			case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInterfaces__Repository()).basicAdd(otherEnd, msgs);
			case RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDatatypes_Repository()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
				return ((InternalEList<?>)getComponents__Repository()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
				return ((InternalEList<?>)getInterfaces__Repository()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY:
				return ((InternalEList<?>)getDatatypes_Repository()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
				return getRepositoryDescription();
			case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
				return getComponents__Repository();
			case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
				return getInterfaces__Repository();
			case RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY:
				return getDatatypes_Repository();
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
			case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
				setRepositoryDescription((String)newValue);
				return;
			case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
				getComponents__Repository().clear();
				getComponents__Repository().addAll((Collection<? extends ProvidesComponentType>)newValue);
				return;
			case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
				getInterfaces__Repository().clear();
				getInterfaces__Repository().addAll((Collection<? extends Interface>)newValue);
				return;
			case RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY:
				getDatatypes_Repository().clear();
				getDatatypes_Repository().addAll((Collection<? extends DataType>)newValue);
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
			case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
				setRepositoryDescription(REPOSITORY_DESCRIPTION_EDEFAULT);
				return;
			case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
				getComponents__Repository().clear();
				return;
			case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
				getInterfaces__Repository().clear();
				return;
			case RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY:
				getDatatypes_Repository().clear();
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
			case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
				return REPOSITORY_DESCRIPTION_EDEFAULT == null ? repositoryDescription != null : !REPOSITORY_DESCRIPTION_EDEFAULT.equals(repositoryDescription);
			case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
				return components__Repository != null && !components__Repository.isEmpty();
			case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
				return interfaces__Repository != null && !interfaces__Repository.isEmpty();
			case RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY:
				return datatypes_Repository != null && !datatypes_Repository.isEmpty();
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
		result.append(" (repositoryDescription: ");
		result.append(repositoryDescription);
		result.append(')');
		return result.toString();
	}

} //RepositoryImpl
