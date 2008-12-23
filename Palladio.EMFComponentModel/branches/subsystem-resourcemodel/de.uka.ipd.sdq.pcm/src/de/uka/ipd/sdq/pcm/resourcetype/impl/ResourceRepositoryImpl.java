/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import de.uka.ipd.sdq.pcm.resourcetype.ControllerStack;
import de.uka.ipd.sdq.pcm.resourcetype.ControllerType;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl#getAvailableResourceTypes_ResourceRepository <em>Available Resource Types Resource Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl#getAvailableControllerStacks_ResourceRepository <em>Available Controller Stacks Resource Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl#getAvailableControllerTypes_ResourceRepository <em>Available Controller Types Resource Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceRepositoryImpl extends EObjectImpl implements ResourceRepository {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getAvailableResourceTypes_ResourceRepository() <em>Available Resource Types Resource Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableResourceTypes_ResourceRepository()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceType> availableResourceTypes_ResourceRepository;

	/**
	 * The cached value of the '{@link #getAvailableControllerStacks_ResourceRepository() <em>Available Controller Stacks Resource Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableControllerStacks_ResourceRepository()
	 * @generated
	 * @ordered
	 */
	protected EList<ControllerStack> availableControllerStacks_ResourceRepository;

	/**
	 * The cached value of the '{@link #getAvailableControllerTypes_ResourceRepository() <em>Available Controller Types Resource Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableControllerTypes_ResourceRepository()
	 * @generated
	 * @ordered
	 */
	protected EList<ControllerType> availableControllerTypes_ResourceRepository;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcetypePackage.Literals.RESOURCE_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceType> getAvailableResourceTypes_ResourceRepository() {
		if (availableResourceTypes_ResourceRepository == null) {
			availableResourceTypes_ResourceRepository = new EObjectContainmentEList<ResourceType>(ResourceType.class, this, ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY);
		}
		return availableResourceTypes_ResourceRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ControllerStack> getAvailableControllerStacks_ResourceRepository() {
		if (availableControllerStacks_ResourceRepository == null) {
			availableControllerStacks_ResourceRepository = new EObjectContainmentEList<ControllerStack>(ControllerStack.class, this, ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_STACKS_RESOURCE_REPOSITORY);
		}
		return availableControllerStacks_ResourceRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ControllerType> getAvailableControllerTypes_ResourceRepository() {
		if (availableControllerTypes_ResourceRepository == null) {
			availableControllerTypes_ResourceRepository = new EObjectContainmentEList<ControllerType>(ControllerType.class, this, ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_TYPES_RESOURCE_REPOSITORY);
		}
		return availableControllerTypes_ResourceRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
				return ((InternalEList<?>)getAvailableResourceTypes_ResourceRepository()).basicRemove(otherEnd, msgs);
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_STACKS_RESOURCE_REPOSITORY:
				return ((InternalEList<?>)getAvailableControllerStacks_ResourceRepository()).basicRemove(otherEnd, msgs);
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_TYPES_RESOURCE_REPOSITORY:
				return ((InternalEList<?>)getAvailableControllerTypes_ResourceRepository()).basicRemove(otherEnd, msgs);
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
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
				return getAvailableResourceTypes_ResourceRepository();
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_STACKS_RESOURCE_REPOSITORY:
				return getAvailableControllerStacks_ResourceRepository();
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_TYPES_RESOURCE_REPOSITORY:
				return getAvailableControllerTypes_ResourceRepository();
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
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
				getAvailableResourceTypes_ResourceRepository().clear();
				getAvailableResourceTypes_ResourceRepository().addAll((Collection<? extends ResourceType>)newValue);
				return;
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_STACKS_RESOURCE_REPOSITORY:
				getAvailableControllerStacks_ResourceRepository().clear();
				getAvailableControllerStacks_ResourceRepository().addAll((Collection<? extends ControllerStack>)newValue);
				return;
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_TYPES_RESOURCE_REPOSITORY:
				getAvailableControllerTypes_ResourceRepository().clear();
				getAvailableControllerTypes_ResourceRepository().addAll((Collection<? extends ControllerType>)newValue);
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
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
				getAvailableResourceTypes_ResourceRepository().clear();
				return;
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_STACKS_RESOURCE_REPOSITORY:
				getAvailableControllerStacks_ResourceRepository().clear();
				return;
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_TYPES_RESOURCE_REPOSITORY:
				getAvailableControllerTypes_ResourceRepository().clear();
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
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY:
				return availableResourceTypes_ResourceRepository != null && !availableResourceTypes_ResourceRepository.isEmpty();
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_STACKS_RESOURCE_REPOSITORY:
				return availableControllerStacks_ResourceRepository != null && !availableControllerStacks_ResourceRepository.isEmpty();
			case ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_CONTROLLER_TYPES_RESOURCE_REPOSITORY:
				return availableControllerTypes_ResourceRepository != null && !availableControllerTypes_ResourceRepository.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResourceRepositoryImpl
