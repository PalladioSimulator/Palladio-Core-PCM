/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.impl.DelegationConnectorImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Required Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl#getParentStructure_ResourceRequiredDelegationConnector <em>Parent Structure Resource Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl#getInnerResourceRequiredRole_ResourceRequiredDelegationConnector <em>Inner Resource Required Role Resource Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl#getOuterResourceRequiredRole_ResourceRequiredDelegationConnector <em>Outer Resource Required Role Resource Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ResourceRequiredDelegationConnectorImpl#getAssemblyContext_ResourceRequiredDelegationConnector <em>Assembly Context Resource Required Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceRequiredDelegationConnectorImpl extends DelegationConnectorImpl implements ResourceRequiredDelegationConnector {
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
	protected ResourceRequiredDelegationConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.RESOURCE_REQUIRED_DELEGATION_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedStructure getParentStructure_ResourceRequiredDelegationConnector() {
		ComposedStructure parentStructure_ResourceRequiredDelegationConnector = basicGetParentStructure_ResourceRequiredDelegationConnector();
		return parentStructure_ResourceRequiredDelegationConnector != null && parentStructure_ResourceRequiredDelegationConnector.eIsProxy() ? (ComposedStructure)eResolveProxy((InternalEObject)parentStructure_ResourceRequiredDelegationConnector) : parentStructure_ResourceRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedStructure basicGetParentStructure_ResourceRequiredDelegationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStructure_ResourceRequiredDelegationConnector(ComposedStructure newParentStructure_ResourceRequiredDelegationConnector) {
		// TODO: implement this method to set the 'Parent Structure Resource Required Delegation Connector' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole getInnerResourceRequiredRole_ResourceRequiredDelegationConnector() {
		ResourceRequiredRole innerResourceRequiredRole_ResourceRequiredDelegationConnector = basicGetInnerResourceRequiredRole_ResourceRequiredDelegationConnector();
		return innerResourceRequiredRole_ResourceRequiredDelegationConnector != null && innerResourceRequiredRole_ResourceRequiredDelegationConnector.eIsProxy() ? (ResourceRequiredRole)eResolveProxy((InternalEObject)innerResourceRequiredRole_ResourceRequiredDelegationConnector) : innerResourceRequiredRole_ResourceRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole basicGetInnerResourceRequiredRole_ResourceRequiredDelegationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerResourceRequiredRole_ResourceRequiredDelegationConnector(ResourceRequiredRole newInnerResourceRequiredRole_ResourceRequiredDelegationConnector) {
		// TODO: implement this method to set the 'Inner Resource Required Role Resource Required Delegation Connector' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole getOuterResourceRequiredRole_ResourceRequiredDelegationConnector() {
		ResourceRequiredRole outerResourceRequiredRole_ResourceRequiredDelegationConnector = basicGetOuterResourceRequiredRole_ResourceRequiredDelegationConnector();
		return outerResourceRequiredRole_ResourceRequiredDelegationConnector != null && outerResourceRequiredRole_ResourceRequiredDelegationConnector.eIsProxy() ? (ResourceRequiredRole)eResolveProxy((InternalEObject)outerResourceRequiredRole_ResourceRequiredDelegationConnector) : outerResourceRequiredRole_ResourceRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole basicGetOuterResourceRequiredRole_ResourceRequiredDelegationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterResourceRequiredRole_ResourceRequiredDelegationConnector(ResourceRequiredRole newOuterResourceRequiredRole_ResourceRequiredDelegationConnector) {
		// TODO: implement this method to set the 'Outer Resource Required Role Resource Required Delegation Connector' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext_ResourceRequiredDelegationConnector() {
		AssemblyContext assemblyContext_ResourceRequiredDelegationConnector = basicGetAssemblyContext_ResourceRequiredDelegationConnector();
		return assemblyContext_ResourceRequiredDelegationConnector != null && assemblyContext_ResourceRequiredDelegationConnector.eIsProxy() ? (AssemblyContext)eResolveProxy((InternalEObject)assemblyContext_ResourceRequiredDelegationConnector) : assemblyContext_ResourceRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext_ResourceRequiredDelegationConnector() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext_ResourceRequiredDelegationConnector(AssemblyContext newAssemblyContext_ResourceRequiredDelegationConnector) {
		// TODO: implement this method to set the 'Assembly Context Resource Required Delegation Connector' reference
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
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getParentStructure_ResourceRequiredDelegationConnector();
				return basicGetParentStructure_ResourceRequiredDelegationConnector();
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getInnerResourceRequiredRole_ResourceRequiredDelegationConnector();
				return basicGetInnerResourceRequiredRole_ResourceRequiredDelegationConnector();
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getOuterResourceRequiredRole_ResourceRequiredDelegationConnector();
				return basicGetOuterResourceRequiredRole_ResourceRequiredDelegationConnector();
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getAssemblyContext_ResourceRequiredDelegationConnector();
				return basicGetAssemblyContext_ResourceRequiredDelegationConnector();
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
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				setParentStructure_ResourceRequiredDelegationConnector((ComposedStructure)newValue);
				return;
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				setInnerResourceRequiredRole_ResourceRequiredDelegationConnector((ResourceRequiredRole)newValue);
				return;
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				setOuterResourceRequiredRole_ResourceRequiredDelegationConnector((ResourceRequiredRole)newValue);
				return;
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				setAssemblyContext_ResourceRequiredDelegationConnector((AssemblyContext)newValue);
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
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				setParentStructure_ResourceRequiredDelegationConnector((ComposedStructure)null);
				return;
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				setInnerResourceRequiredRole_ResourceRequiredDelegationConnector((ResourceRequiredRole)null);
				return;
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				setOuterResourceRequiredRole_ResourceRequiredDelegationConnector((ResourceRequiredRole)null);
				return;
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				setAssemblyContext_ResourceRequiredDelegationConnector((AssemblyContext)null);
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
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				return basicGetParentStructure_ResourceRequiredDelegationConnector() != null;
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				return basicGetInnerResourceRequiredRole_ResourceRequiredDelegationConnector() != null;
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				return basicGetOuterResourceRequiredRole_ResourceRequiredDelegationConnector() != null;
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				return basicGetAssemblyContext_ResourceRequiredDelegationConnector() != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceRequiredDelegationConnectorImpl
