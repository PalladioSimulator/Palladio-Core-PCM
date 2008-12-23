/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceAllocationConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Allocation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceAllocationConnectorImpl#getProcessingResourceSpecification_ResourceAllocationConnector <em>Processing Resource Specification Resource Allocation Connector</em>}</li>
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
	public ProcessingResourceSpecification getProcessingResourceSpecification_ResourceAllocationConnector() {
		ProcessingResourceSpecification processingResourceSpecification_ResourceAllocationConnector = basicGetProcessingResourceSpecification_ResourceAllocationConnector();
		return processingResourceSpecification_ResourceAllocationConnector != null && processingResourceSpecification_ResourceAllocationConnector.eIsProxy() ? (ProcessingResourceSpecification)eResolveProxy((InternalEObject)processingResourceSpecification_ResourceAllocationConnector) : processingResourceSpecification_ResourceAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification basicGetProcessingResourceSpecification_ResourceAllocationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingResourceSpecification_ResourceAllocationConnector(ProcessingResourceSpecification newProcessingResourceSpecification_ResourceAllocationConnector) {
		// TODO: implement this method to set the 'Processing Resource Specification Resource Allocation Connector' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceenvironmentPackage.RESOURCE_ALLOCATION_CONNECTOR__PROCESSING_RESOURCE_SPECIFICATION_RESOURCE_ALLOCATION_CONNECTOR:
				if (resolve) return getProcessingResourceSpecification_ResourceAllocationConnector();
				return basicGetProcessingResourceSpecification_ResourceAllocationConnector();
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
			case ResourceenvironmentPackage.RESOURCE_ALLOCATION_CONNECTOR__PROCESSING_RESOURCE_SPECIFICATION_RESOURCE_ALLOCATION_CONNECTOR:
				setProcessingResourceSpecification_ResourceAllocationConnector((ProcessingResourceSpecification)newValue);
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
			case ResourceenvironmentPackage.RESOURCE_ALLOCATION_CONNECTOR__PROCESSING_RESOURCE_SPECIFICATION_RESOURCE_ALLOCATION_CONNECTOR:
				setProcessingResourceSpecification_ResourceAllocationConnector((ProcessingResourceSpecification)null);
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
			case ResourceenvironmentPackage.RESOURCE_ALLOCATION_CONNECTOR__PROCESSING_RESOURCE_SPECIFICATION_RESOURCE_ALLOCATION_CONNECTOR:
				return basicGetProcessingResourceSpecification_ResourceAllocationConnector() != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceAllocationConnectorImpl
