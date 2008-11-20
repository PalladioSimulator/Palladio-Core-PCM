/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl#getActiveResourceSpecifications_ResourceContainer <em>Active Resource Specifications Resource Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceContainerImpl extends EntityImpl implements ResourceContainer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";
	/**
	 * The cached value of the '{@link #getActiveResourceSpecifications_ResourceContainer() <em>Active Resource Specifications Resource Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveResourceSpecifications_ResourceContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessingResourceSpecification> activeResourceSpecifications_ResourceContainer;

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
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.RESOURCE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessingResourceSpecification> getActiveResourceSpecifications_ResourceContainer() {
		if (activeResourceSpecifications_ResourceContainer == null) {
			activeResourceSpecifications_ResourceContainer = new EObjectContainmentEList<ProcessingResourceSpecification>(ProcessingResourceSpecification.class, this, ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER);
		}
		return activeResourceSpecifications_ResourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return ((InternalEList<?>)getActiveResourceSpecifications_ResourceContainer()).basicRemove(otherEnd, msgs);
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return getActiveResourceSpecifications_ResourceContainer();
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				getActiveResourceSpecifications_ResourceContainer().clear();
				getActiveResourceSpecifications_ResourceContainer().addAll((Collection<? extends ProcessingResourceSpecification>)newValue);
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				getActiveResourceSpecifications_ResourceContainer().clear();
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return activeResourceSpecifications_ResourceContainer != null && !activeResourceSpecifications_ResourceContainer.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResourceContainerImpl
