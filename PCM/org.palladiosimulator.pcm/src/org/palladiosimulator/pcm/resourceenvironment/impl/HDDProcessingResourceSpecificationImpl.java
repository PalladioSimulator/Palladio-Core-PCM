/**
 * Copyright 2005-2015 by palladiosimulator.org
 */
package org.palladiosimulator.pcm.resourceenvironment.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.PCMRandomVariable;

import org.palladiosimulator.pcm.resourceenvironment.HDDProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HDD Processing Resource Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.HDDProcessingResourceSpecificationImpl#getWriteProcessingRate <em>Write Processing Rate</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.HDDProcessingResourceSpecificationImpl#getReadProcessingRate <em>Read Processing Rate</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.resourceenvironment.impl.HDDProcessingResourceSpecificationImpl#getResourceContainer <em>Resource Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HDDProcessingResourceSpecificationImpl extends ProcessingResourceSpecificationImpl
		implements HDDProcessingResourceSpecification {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2015 by palladiosimulator.org";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HDDProcessingResourceSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PCMRandomVariable getWriteProcessingRate() {
		return (PCMRandomVariable) eDynamicGet(
				ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE,
				ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE, true,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWriteProcessingRate(PCMRandomVariable newWriteProcessingRate,
			NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newWriteProcessingRate,
				ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWriteProcessingRate(PCMRandomVariable newWriteProcessingRate) {
		eDynamicSet(ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE,
				ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE,
				newWriteProcessingRate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PCMRandomVariable getReadProcessingRate() {
		return (PCMRandomVariable) eDynamicGet(
				ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE,
				ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE, true,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReadProcessingRate(PCMRandomVariable newReadProcessingRate,
			NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newReadProcessingRate,
				ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReadProcessingRate(PCMRandomVariable newReadProcessingRate) {
		eDynamicSet(ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE,
				ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE,
				newReadProcessingRate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceContainer getResourceContainer() {
		return (ResourceContainer) eDynamicGet(
				ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER,
				ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER, true,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer basicGetResourceContainer() {
		return (ResourceContainer) eDynamicGet(
				ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER,
				ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER, false,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceContainer(ResourceContainer newResourceContainer, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newResourceContainer,
				ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceContainer(ResourceContainer newResourceContainer) {
		eDynamicSet(ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER,
				ResourceenvironmentPackage.Literals.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER,
				newResourceContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER:
			ResourceContainer resourceContainer = basicGetResourceContainer();
			if (resourceContainer != null)
				msgs = ((InternalEObject) resourceContainer).eInverseRemove(this,
						ResourceenvironmentPackage.RESOURCE_CONTAINER__HDD_RESOURCE_SPECIFICATIONS,
						ResourceContainer.class, msgs);
			return basicSetResourceContainer((ResourceContainer) otherEnd, msgs);
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
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE:
			return basicSetWriteProcessingRate(null, msgs);
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE:
			return basicSetReadProcessingRate(null, msgs);
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER:
			return basicSetResourceContainer(null, msgs);
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
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE:
			return getWriteProcessingRate();
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE:
			return getReadProcessingRate();
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER:
			if (resolve)
				return getResourceContainer();
			return basicGetResourceContainer();
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
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE:
			setWriteProcessingRate((PCMRandomVariable) newValue);
			return;
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE:
			setReadProcessingRate((PCMRandomVariable) newValue);
			return;
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER:
			setResourceContainer((ResourceContainer) newValue);
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
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE:
			setWriteProcessingRate((PCMRandomVariable) null);
			return;
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE:
			setReadProcessingRate((PCMRandomVariable) null);
			return;
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER:
			setResourceContainer((ResourceContainer) null);
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
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__WRITE_PROCESSING_RATE:
			return getWriteProcessingRate() != null;
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__READ_PROCESSING_RATE:
			return getReadProcessingRate() != null;
		case ResourceenvironmentPackage.HDD_PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER:
			return basicGetResourceContainer() != null;
		}
		return super.eIsSet(featureID);
	}

} //HDDProcessingResourceSpecificationImpl
