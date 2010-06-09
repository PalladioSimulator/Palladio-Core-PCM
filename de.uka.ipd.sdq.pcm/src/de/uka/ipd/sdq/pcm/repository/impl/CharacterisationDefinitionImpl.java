/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.repository.CharacterisationDefinition;
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Characterisation Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CharacterisationDefinitionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CharacterisationDefinitionImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CharacterisationDefinitionImpl#getRepository_ChracterisationDefinition <em>Repository Chracterisation Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CharacterisationDefinitionImpl extends EntityImpl implements CharacterisationDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected static final PrimitiveTypeEnum VALUE_TYPE_EDEFAULT = PrimitiveTypeEnum.BOOL;

	/**
	 * The cached value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveTypeEnum valueType = VALUE_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CharacterisationDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.CHARACTERISATION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CHARACTERISATION_DEFINITION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeEnum getValueType() {
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueType(PrimitiveTypeEnum newValueType) {
		PrimitiveTypeEnum oldValueType = valueType;
		valueType = newValueType == null ? VALUE_TYPE_EDEFAULT : newValueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CHARACTERISATION_DEFINITION__VALUE_TYPE, oldValueType, valueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository getRepository_ChracterisationDefinition() {
		if (eContainerFeatureID() != RepositoryPackage.CHARACTERISATION_DEFINITION__REPOSITORY_CHRACTERISATION_DEFINITION) return null;
		return (Repository)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository_ChracterisationDefinition(Repository newRepository_ChracterisationDefinition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepository_ChracterisationDefinition, RepositoryPackage.CHARACTERISATION_DEFINITION__REPOSITORY_CHRACTERISATION_DEFINITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepository_ChracterisationDefinition(Repository newRepository_ChracterisationDefinition) {
		if (newRepository_ChracterisationDefinition != eInternalContainer() || (eContainerFeatureID() != RepositoryPackage.CHARACTERISATION_DEFINITION__REPOSITORY_CHRACTERISATION_DEFINITION && newRepository_ChracterisationDefinition != null)) {
			if (EcoreUtil.isAncestor(this, newRepository_ChracterisationDefinition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepository_ChracterisationDefinition != null)
				msgs = ((InternalEObject)newRepository_ChracterisationDefinition).eInverseAdd(this, RepositoryPackage.REPOSITORY__CHARACTERISATION_DEFINITIONS, Repository.class, msgs);
			msgs = basicSetRepository_ChracterisationDefinition(newRepository_ChracterisationDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CHARACTERISATION_DEFINITION__REPOSITORY_CHRACTERISATION_DEFINITION, newRepository_ChracterisationDefinition, newRepository_ChracterisationDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.CHARACTERISATION_DEFINITION__REPOSITORY_CHRACTERISATION_DEFINITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRepository_ChracterisationDefinition((Repository)otherEnd, msgs);
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
			case RepositoryPackage.CHARACTERISATION_DEFINITION__REPOSITORY_CHRACTERISATION_DEFINITION:
				return basicSetRepository_ChracterisationDefinition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RepositoryPackage.CHARACTERISATION_DEFINITION__REPOSITORY_CHRACTERISATION_DEFINITION:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__CHARACTERISATION_DEFINITIONS, Repository.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.CHARACTERISATION_DEFINITION__DESCRIPTION:
				return getDescription();
			case RepositoryPackage.CHARACTERISATION_DEFINITION__VALUE_TYPE:
				return getValueType();
			case RepositoryPackage.CHARACTERISATION_DEFINITION__REPOSITORY_CHRACTERISATION_DEFINITION:
				return getRepository_ChracterisationDefinition();
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
			case RepositoryPackage.CHARACTERISATION_DEFINITION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case RepositoryPackage.CHARACTERISATION_DEFINITION__VALUE_TYPE:
				setValueType((PrimitiveTypeEnum)newValue);
				return;
			case RepositoryPackage.CHARACTERISATION_DEFINITION__REPOSITORY_CHRACTERISATION_DEFINITION:
				setRepository_ChracterisationDefinition((Repository)newValue);
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
			case RepositoryPackage.CHARACTERISATION_DEFINITION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case RepositoryPackage.CHARACTERISATION_DEFINITION__VALUE_TYPE:
				setValueType(VALUE_TYPE_EDEFAULT);
				return;
			case RepositoryPackage.CHARACTERISATION_DEFINITION__REPOSITORY_CHRACTERISATION_DEFINITION:
				setRepository_ChracterisationDefinition((Repository)null);
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
			case RepositoryPackage.CHARACTERISATION_DEFINITION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case RepositoryPackage.CHARACTERISATION_DEFINITION__VALUE_TYPE:
				return valueType != VALUE_TYPE_EDEFAULT;
			case RepositoryPackage.CHARACTERISATION_DEFINITION__REPOSITORY_CHRACTERISATION_DEFINITION:
				return getRepository_ChracterisationDefinition() != null;
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
		result.append(" (description: ");
		result.append(description);
		result.append(", valueType: ");
		result.append(valueType);
		result.append(')');
		return result.toString();
	}

} //CharacterisationDefinitionImpl
