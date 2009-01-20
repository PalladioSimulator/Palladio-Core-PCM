/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.allocation.impl.ResourceProvidedRoleConnectorImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceAllocationConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Allocation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceAllocationConnectorImpl#getToProcessingResourceSpecification_ResourceAllocationConnector <em>To Processing Resource Specification Resource Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceAllocationConnectorImpl extends ResourceProvidedRoleConnectorImpl implements ResourceAllocationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getToProcessingResourceSpecification_ResourceAllocationConnector() <em>To Processing Resource Specification Resource Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToProcessingResourceSpecification_ResourceAllocationConnector()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResourceSpecification toProcessingResourceSpecification_ResourceAllocationConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceAllocationConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.RESOURCE_ALLOCATION_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification getToProcessingResourceSpecification_ResourceAllocationConnector() {
		if (toProcessingResourceSpecification_ResourceAllocationConnector != null && toProcessingResourceSpecification_ResourceAllocationConnector.eIsProxy()) {
			InternalEObject oldToProcessingResourceSpecification_ResourceAllocationConnector = (InternalEObject)toProcessingResourceSpecification_ResourceAllocationConnector;
			toProcessingResourceSpecification_ResourceAllocationConnector = (ProcessingResourceSpecification)eResolveProxy(oldToProcessingResourceSpecification_ResourceAllocationConnector);
			if (toProcessingResourceSpecification_ResourceAllocationConnector != oldToProcessingResourceSpecification_ResourceAllocationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentPackage.RESOURCE_ALLOCATION_CONNECTOR__TO_PROCESSING_RESOURCE_SPECIFICATION_RESOURCE_ALLOCATION_CONNECTOR, oldToProcessingResourceSpecification_ResourceAllocationConnector, toProcessingResourceSpecification_ResourceAllocationConnector));
			}
		}
		return toProcessingResourceSpecification_ResourceAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification basicGetToProcessingResourceSpecification_ResourceAllocationConnector() {
		return toProcessingResourceSpecification_ResourceAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToProcessingResourceSpecification_ResourceAllocationConnector(ProcessingResourceSpecification newToProcessingResourceSpecification_ResourceAllocationConnector) {
		ProcessingResourceSpecification oldToProcessingResourceSpecification_ResourceAllocationConnector = toProcessingResourceSpecification_ResourceAllocationConnector;
		toProcessingResourceSpecification_ResourceAllocationConnector = newToProcessingResourceSpecification_ResourceAllocationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.RESOURCE_ALLOCATION_CONNECTOR__TO_PROCESSING_RESOURCE_SPECIFICATION_RESOURCE_ALLOCATION_CONNECTOR, oldToProcessingResourceSpecification_ResourceAllocationConnector, toProcessingResourceSpecification_ResourceAllocationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceenvironmentPackage.RESOURCE_ALLOCATION_CONNECTOR__TO_PROCESSING_RESOURCE_SPECIFICATION_RESOURCE_ALLOCATION_CONNECTOR:
				if (resolve) return getToProcessingResourceSpecification_ResourceAllocationConnector();
				return basicGetToProcessingResourceSpecification_ResourceAllocationConnector();
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
			case ResourceenvironmentPackage.RESOURCE_ALLOCATION_CONNECTOR__TO_PROCESSING_RESOURCE_SPECIFICATION_RESOURCE_ALLOCATION_CONNECTOR:
				setToProcessingResourceSpecification_ResourceAllocationConnector((ProcessingResourceSpecification)newValue);
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
			case ResourceenvironmentPackage.RESOURCE_ALLOCATION_CONNECTOR__TO_PROCESSING_RESOURCE_SPECIFICATION_RESOURCE_ALLOCATION_CONNECTOR:
				setToProcessingResourceSpecification_ResourceAllocationConnector((ProcessingResourceSpecification)null);
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
			case ResourceenvironmentPackage.RESOURCE_ALLOCATION_CONNECTOR__TO_PROCESSING_RESOURCE_SPECIFICATION_RESOURCE_ALLOCATION_CONNECTOR:
				return toProcessingResourceSpecification_ResourceAllocationConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceAllocationConnectorImpl
