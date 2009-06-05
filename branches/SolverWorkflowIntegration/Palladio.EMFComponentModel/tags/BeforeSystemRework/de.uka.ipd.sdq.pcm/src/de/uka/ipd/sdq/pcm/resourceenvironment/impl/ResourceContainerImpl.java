
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl#getActiveResourceSpecifications_ResourceContainer <em>Active Resource Specifications Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl#getPassiveResourceSpecifications_ResourceContainer <em>Passive Resource Specifications Resource Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceContainerImpl extends EntityImpl implements ResourceContainer {
	/**
	 * The cached value of the '{@link #getActiveResourceSpecifications_ResourceContainer() <em>Active Resource Specifications Resource Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveResourceSpecifications_ResourceContainer()
	 * @generated
	 * @ordered
	 */
	protected EList activeResourceSpecifications_ResourceContainer = null;

	/**
	 * The cached value of the '{@link #getPassiveResourceSpecifications_ResourceContainer() <em>Passive Resource Specifications Resource Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassiveResourceSpecifications_ResourceContainer()
	 * @generated
	 * @ordered
	 */
	protected EList passiveResourceSpecifications_ResourceContainer = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.RESOURCE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getActiveResourceSpecifications_ResourceContainer() {
		if (activeResourceSpecifications_ResourceContainer == null) {
			activeResourceSpecifications_ResourceContainer = new EObjectContainmentEList(ProcessingResourceSpecification.class, this, ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER);
		}
		return activeResourceSpecifications_ResourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPassiveResourceSpecifications_ResourceContainer() {
		if (passiveResourceSpecifications_ResourceContainer == null) {
			passiveResourceSpecifications_ResourceContainer = new EObjectContainmentEList(PassiveResourceSpecification.class, this, ResourceenvironmentPackage.RESOURCE_CONTAINER__PASSIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER);
		}
		return passiveResourceSpecifications_ResourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return ((InternalEList)getActiveResourceSpecifications_ResourceContainer()).basicRemove(otherEnd, msgs);
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__PASSIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return ((InternalEList)getPassiveResourceSpecifications_ResourceContainer()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return getActiveResourceSpecifications_ResourceContainer();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__PASSIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return getPassiveResourceSpecifications_ResourceContainer();
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				getActiveResourceSpecifications_ResourceContainer().clear();
				getActiveResourceSpecifications_ResourceContainer().addAll((Collection)newValue);
				return;
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__PASSIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				getPassiveResourceSpecifications_ResourceContainer().clear();
				getPassiveResourceSpecifications_ResourceContainer().addAll((Collection)newValue);
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				getActiveResourceSpecifications_ResourceContainer().clear();
				return;
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__PASSIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				getPassiveResourceSpecifications_ResourceContainer().clear();
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return activeResourceSpecifications_ResourceContainer != null && !activeResourceSpecifications_ResourceContainer.isEmpty();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__PASSIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return passiveResourceSpecifications_ResourceContainer != null && !passiveResourceSpecifications_ResourceContainer.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResourceContainerImpl