/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity;

import de.uka.ipd.sdq.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl;

import de.uka.ipd.sdq.pcm.resourcetype.InfrastructureComponent;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.InfrastructureComponentImpl#getResourceProvidedRoles_ResourceInterfaceProvidingEntity <em>Resource Provided Roles Resource Interface Providing Entity</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.InfrastructureComponentImpl#getAvailableInfrastructureComponents_ResourceRepository <em>Available Infrastructure Components Resource Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfrastructureComponentImpl extends ComposedProvidingRequiringEntityImpl implements InfrastructureComponent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getResourceProvidedRoles_ResourceInterfaceProvidingEntity() <em>Resource Provided Roles Resource Interface Providing Entity</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceProvidedRoles_ResourceInterfaceProvidingEntity()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceProvidedRole> resourceProvidedRoles_ResourceInterfaceProvidingEntity;

	/**
	 * The cached value of the '{@link #getAvailableInfrastructureComponents_ResourceRepository() <em>Available Infrastructure Components Resource Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableInfrastructureComponents_ResourceRepository()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceRepository> availableInfrastructureComponents_ResourceRepository;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfrastructureComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcetypePackage.Literals.INFRASTRUCTURE_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceProvidedRole> getResourceProvidedRoles_ResourceInterfaceProvidingEntity() {
		if (resourceProvidedRoles_ResourceInterfaceProvidingEntity == null) {
			resourceProvidedRoles_ResourceInterfaceProvidingEntity = new EObjectContainmentWithInverseEList<ResourceProvidedRole>(ResourceProvidedRole.class, this, ResourcetypePackage.INFRASTRUCTURE_COMPONENT__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY, ResourcetypePackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE);
		}
		return resourceProvidedRoles_ResourceInterfaceProvidingEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceRepository> getAvailableInfrastructureComponents_ResourceRepository() {
		if (availableInfrastructureComponents_ResourceRepository == null) {
			availableInfrastructureComponents_ResourceRepository = new EObjectContainmentEList<ResourceRepository>(ResourceRepository.class, this, ResourcetypePackage.INFRASTRUCTURE_COMPONENT__AVAILABLE_INFRASTRUCTURE_COMPONENTS_RESOURCE_REPOSITORY);
		}
		return availableInfrastructureComponents_ResourceRepository;
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
			case ResourcetypePackage.INFRASTRUCTURE_COMPONENT__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResourceProvidedRoles_ResourceInterfaceProvidingEntity()).basicAdd(otherEnd, msgs);
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
			case ResourcetypePackage.INFRASTRUCTURE_COMPONENT__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY:
				return ((InternalEList<?>)getResourceProvidedRoles_ResourceInterfaceProvidingEntity()).basicRemove(otherEnd, msgs);
			case ResourcetypePackage.INFRASTRUCTURE_COMPONENT__AVAILABLE_INFRASTRUCTURE_COMPONENTS_RESOURCE_REPOSITORY:
				return ((InternalEList<?>)getAvailableInfrastructureComponents_ResourceRepository()).basicRemove(otherEnd, msgs);
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
			case ResourcetypePackage.INFRASTRUCTURE_COMPONENT__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY:
				return getResourceProvidedRoles_ResourceInterfaceProvidingEntity();
			case ResourcetypePackage.INFRASTRUCTURE_COMPONENT__AVAILABLE_INFRASTRUCTURE_COMPONENTS_RESOURCE_REPOSITORY:
				return getAvailableInfrastructureComponents_ResourceRepository();
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
			case ResourcetypePackage.INFRASTRUCTURE_COMPONENT__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY:
				getResourceProvidedRoles_ResourceInterfaceProvidingEntity().clear();
				getResourceProvidedRoles_ResourceInterfaceProvidingEntity().addAll((Collection<? extends ResourceProvidedRole>)newValue);
				return;
			case ResourcetypePackage.INFRASTRUCTURE_COMPONENT__AVAILABLE_INFRASTRUCTURE_COMPONENTS_RESOURCE_REPOSITORY:
				getAvailableInfrastructureComponents_ResourceRepository().clear();
				getAvailableInfrastructureComponents_ResourceRepository().addAll((Collection<? extends ResourceRepository>)newValue);
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
			case ResourcetypePackage.INFRASTRUCTURE_COMPONENT__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY:
				getResourceProvidedRoles_ResourceInterfaceProvidingEntity().clear();
				return;
			case ResourcetypePackage.INFRASTRUCTURE_COMPONENT__AVAILABLE_INFRASTRUCTURE_COMPONENTS_RESOURCE_REPOSITORY:
				getAvailableInfrastructureComponents_ResourceRepository().clear();
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
			case ResourcetypePackage.INFRASTRUCTURE_COMPONENT__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY:
				return resourceProvidedRoles_ResourceInterfaceProvidingEntity != null && !resourceProvidedRoles_ResourceInterfaceProvidingEntity.isEmpty();
			case ResourcetypePackage.INFRASTRUCTURE_COMPONENT__AVAILABLE_INFRASTRUCTURE_COMPONENTS_RESOURCE_REPOSITORY:
				return availableInfrastructureComponents_ResourceRepository != null && !availableInfrastructureComponents_ResourceRepository.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ResourceInterfaceProvidingEntity.class) {
			switch (derivedFeatureID) {
				case ResourcetypePackage.INFRASTRUCTURE_COMPONENT__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY: return EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ResourceInterfaceProvidingEntity.class) {
			switch (baseFeatureID) {
				case EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY: return ResourcetypePackage.INFRASTRUCTURE_COMPONENT__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //InfrastructureComponentImpl
