/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Composite Data Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeDataTypeImpl#getRepository__DataType <em>Repository Data Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeDataTypeImpl#getParentType_CompositeDataType <em>Parent Type Composite Data Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeDataTypeImpl#getInnerDeclaration_CompositeDataType <em>Inner Declaration Composite Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeDataTypeImpl extends EntityImpl implements
		CompositeDataType {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getParentType_CompositeDataType() <em>Parent Type Composite Data Type</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getParentType_CompositeDataType()
	 * @generated
	 * @ordered
	 */
	protected EList<CompositeDataType> parentType_CompositeDataType;

	/**
	 * The cached value of the '{@link #getInnerDeclaration_CompositeDataType()
	 * <em>Inner Declaration Composite Data Type</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getInnerDeclaration_CompositeDataType()
	 * @generated
	 * @ordered
	 */
	protected EList<InnerDeclaration> innerDeclaration_CompositeDataType;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.COMPOSITE_DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Repository getRepository__DataType() {
		if (eContainerFeatureID() != RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE)
			return null;
		return (Repository) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository__DataType(
			Repository newRepository__DataType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newRepository__DataType,
				RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepository__DataType(Repository newRepository__DataType) {
		if (newRepository__DataType != eInternalContainer()
				|| (eContainerFeatureID() != RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE && newRepository__DataType != null)) {
			if (EcoreUtil.isAncestor(this, (EObject) newRepository__DataType))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepository__DataType != null)
				msgs = ((InternalEObject) newRepository__DataType).eInverseAdd(
						this,
						RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY,
						Repository.class, msgs);
			msgs = basicSetRepository__DataType(newRepository__DataType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE,
					newRepository__DataType, newRepository__DataType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CompositeDataType> getParentType_CompositeDataType() {
		if (parentType_CompositeDataType == null) {
			parentType_CompositeDataType = new EObjectResolvingEList<CompositeDataType>(
					CompositeDataType.class,
					this,
					RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE);
		}
		return parentType_CompositeDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InnerDeclaration> getInnerDeclaration_CompositeDataType() {
		if (innerDeclaration_CompositeDataType == null) {
			innerDeclaration_CompositeDataType = new EObjectContainmentWithInverseEList<InnerDeclaration>(
					InnerDeclaration.class,
					this,
					RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE,
					RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION);
		}
		return innerDeclaration_CompositeDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetRepository__DataType((Repository) otherEnd, msgs);
		case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInnerDeclaration_CompositeDataType())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
			return basicSetRepository__DataType(null, msgs);
		case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
			return ((InternalEList<?>) getInnerDeclaration_CompositeDataType())
					.basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
			return eInternalContainer().eInverseRemove(this,
					RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY,
					Repository.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
			return getRepository__DataType();
		case RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE:
			return getParentType_CompositeDataType();
		case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
			return getInnerDeclaration_CompositeDataType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
			setRepository__DataType((Repository) newValue);
			return;
		case RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE:
			getParentType_CompositeDataType().clear();
			getParentType_CompositeDataType().addAll(
					(Collection<? extends CompositeDataType>) newValue);
			return;
		case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
			getInnerDeclaration_CompositeDataType().clear();
			getInnerDeclaration_CompositeDataType().addAll(
					(Collection<? extends InnerDeclaration>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
			setRepository__DataType((Repository) null);
			return;
		case RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE:
			getParentType_CompositeDataType().clear();
			return;
		case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
			getInnerDeclaration_CompositeDataType().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
			return getRepository__DataType() != null;
		case RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE:
			return parentType_CompositeDataType != null
					&& !parentType_CompositeDataType.isEmpty();
		case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
			return innerDeclaration_CompositeDataType != null
					&& !innerDeclaration_CompositeDataType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DataType.class) {
			switch (derivedFeatureID) {
			case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
				return RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DataType.class) {
			switch (baseFeatureID) {
			case RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE:
				return RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} // CompositeDataTypeImpl
