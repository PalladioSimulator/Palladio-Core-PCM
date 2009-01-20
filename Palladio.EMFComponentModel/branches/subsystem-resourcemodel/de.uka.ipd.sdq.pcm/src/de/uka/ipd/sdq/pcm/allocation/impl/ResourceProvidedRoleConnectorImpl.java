/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.ResourceProvidedRoleConnector;

import de.uka.ipd.sdq.pcm.allocation.util.AllocationValidator;

import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ocl.expressions.OCLExpression;

import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;

import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Provided Role Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.ResourceProvidedRoleConnectorImpl#getResourceProvidedRole_ResourceProvidedRoleAllocationConnector <em>Resource Provided Role Resource Provided Role Allocation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.ResourceProvidedRoleConnectorImpl#getFromControllerInstance_ControllerAllocationConnector <em>From Controller Instance Controller Allocation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ResourceProvidedRoleConnectorImpl extends AllocationConnectorImpl implements ResourceProvidedRoleConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getResourceProvidedRole_ResourceProvidedRoleAllocationConnector() <em>Resource Provided Role Resource Provided Role Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceProvidedRole_ResourceProvidedRoleAllocationConnector()
	 * @generated
	 * @ordered
	 */
	protected ResourceProvidedRole resourceProvidedRole_ResourceProvidedRoleAllocationConnector;

	/**
	 * The cached value of the '{@link #getFromControllerInstance_ControllerAllocationConnector() <em>From Controller Instance Controller Allocation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromControllerInstance_ControllerAllocationConnector()
	 * @generated
	 * @ordered
	 */
	protected ControllerInstance fromControllerInstance_ControllerAllocationConnector;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ReferencedResourceRequiredRoleRoleAndResourceProvidedRoleMustMatch <em>Referenced Resource Required Role Role And Resource Provided Role Must Match</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ReferencedResourceRequiredRoleRoleAndResourceProvidedRoleMustMatch
	 * @generated
	 */
	private static OCLExpression ReferencedResourceRequiredRoleRoleAndResourceProvidedRoleMustMatchInvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceProvidedRoleConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AllocationPackage.Literals.RESOURCE_PROVIDED_ROLE_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceProvidedRole getResourceProvidedRole_ResourceProvidedRoleAllocationConnector() {
		if (resourceProvidedRole_ResourceProvidedRoleAllocationConnector != null && resourceProvidedRole_ResourceProvidedRoleAllocationConnector.eIsProxy()) {
			InternalEObject oldResourceProvidedRole_ResourceProvidedRoleAllocationConnector = (InternalEObject)resourceProvidedRole_ResourceProvidedRoleAllocationConnector;
			resourceProvidedRole_ResourceProvidedRoleAllocationConnector = (ResourceProvidedRole)eResolveProxy(oldResourceProvidedRole_ResourceProvidedRoleAllocationConnector);
			if (resourceProvidedRole_ResourceProvidedRoleAllocationConnector != oldResourceProvidedRole_ResourceProvidedRoleAllocationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR, oldResourceProvidedRole_ResourceProvidedRoleAllocationConnector, resourceProvidedRole_ResourceProvidedRoleAllocationConnector));
			}
		}
		return resourceProvidedRole_ResourceProvidedRoleAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceProvidedRole basicGetResourceProvidedRole_ResourceProvidedRoleAllocationConnector() {
		return resourceProvidedRole_ResourceProvidedRoleAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceProvidedRole_ResourceProvidedRoleAllocationConnector(ResourceProvidedRole newResourceProvidedRole_ResourceProvidedRoleAllocationConnector) {
		ResourceProvidedRole oldResourceProvidedRole_ResourceProvidedRoleAllocationConnector = resourceProvidedRole_ResourceProvidedRoleAllocationConnector;
		resourceProvidedRole_ResourceProvidedRoleAllocationConnector = newResourceProvidedRole_ResourceProvidedRoleAllocationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR, oldResourceProvidedRole_ResourceProvidedRoleAllocationConnector, resourceProvidedRole_ResourceProvidedRoleAllocationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerInstance getFromControllerInstance_ControllerAllocationConnector() {
		if (fromControllerInstance_ControllerAllocationConnector != null && fromControllerInstance_ControllerAllocationConnector.eIsProxy()) {
			InternalEObject oldFromControllerInstance_ControllerAllocationConnector = (InternalEObject)fromControllerInstance_ControllerAllocationConnector;
			fromControllerInstance_ControllerAllocationConnector = (ControllerInstance)eResolveProxy(oldFromControllerInstance_ControllerAllocationConnector);
			if (fromControllerInstance_ControllerAllocationConnector != oldFromControllerInstance_ControllerAllocationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR, oldFromControllerInstance_ControllerAllocationConnector, fromControllerInstance_ControllerAllocationConnector));
			}
		}
		return fromControllerInstance_ControllerAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerInstance basicGetFromControllerInstance_ControllerAllocationConnector() {
		return fromControllerInstance_ControllerAllocationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFromControllerInstance_ControllerAllocationConnector(ControllerInstance newFromControllerInstance_ControllerAllocationConnector, NotificationChain msgs) {
		ControllerInstance oldFromControllerInstance_ControllerAllocationConnector = fromControllerInstance_ControllerAllocationConnector;
		fromControllerInstance_ControllerAllocationConnector = newFromControllerInstance_ControllerAllocationConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR, oldFromControllerInstance_ControllerAllocationConnector, newFromControllerInstance_ControllerAllocationConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromControllerInstance_ControllerAllocationConnector(ControllerInstance newFromControllerInstance_ControllerAllocationConnector) {
		if (newFromControllerInstance_ControllerAllocationConnector != fromControllerInstance_ControllerAllocationConnector) {
			NotificationChain msgs = null;
			if (fromControllerInstance_ControllerAllocationConnector != null)
				msgs = ((InternalEObject)fromControllerInstance_ControllerAllocationConnector).eInverseRemove(this, ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE, ControllerInstance.class, msgs);
			if (newFromControllerInstance_ControllerAllocationConnector != null)
				msgs = ((InternalEObject)newFromControllerInstance_ControllerAllocationConnector).eInverseAdd(this, ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE, ControllerInstance.class, msgs);
			msgs = basicSetFromControllerInstance_ControllerAllocationConnector(newFromControllerInstance_ControllerAllocationConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR, newFromControllerInstance_ControllerAllocationConnector, newFromControllerInstance_ControllerAllocationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ReferencedResourceRequiredRoleRoleAndResourceProvidedRoleMustMatch(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ReferencedResourceRequiredRoleRoleAndResourceProvidedRoleMustMatchInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.resourceRequiredRole_AllocationConnector.requiredResourceInterface_ResourceRequiredRole = self.resourceProvidedRole_ResourceProvidedRoleAllocationConnector.providedResourceInterface_ResourceProvidedRole ";
			
			try {
				ReferencedResourceRequiredRoleRoleAndResourceProvidedRoleMustMatchInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ReferencedResourceRequiredRoleRoleAndResourceProvidedRoleMustMatchInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.RESOURCE_PROVIDED_ROLE_CONNECTOR__REFERENCED_RESOURCE_REQUIRED_ROLE_ROLE_AND_RESOURCE_PROVIDED_ROLE_MUST_MATCH,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ReferencedResourceRequiredRoleRoleAndResourceProvidedRoleMustMatch", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				if (fromControllerInstance_ControllerAllocationConnector != null)
					msgs = ((InternalEObject)fromControllerInstance_ControllerAllocationConnector).eInverseRemove(this, ResourceenvironmentPackage.CONTROLLER_INSTANCE__LOWER_CONTROLLER_ALLOCATION_CONNECTORS_CONTROLLER_INSTANCE, ControllerInstance.class, msgs);
				return basicSetFromControllerInstance_ControllerAllocationConnector((ControllerInstance)otherEnd, msgs);
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
			case AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				return basicSetFromControllerInstance_ControllerAllocationConnector(null, msgs);
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
			case AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				if (resolve) return getResourceProvidedRole_ResourceProvidedRoleAllocationConnector();
				return basicGetResourceProvidedRole_ResourceProvidedRoleAllocationConnector();
			case AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				if (resolve) return getFromControllerInstance_ControllerAllocationConnector();
				return basicGetFromControllerInstance_ControllerAllocationConnector();
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
			case AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				setResourceProvidedRole_ResourceProvidedRoleAllocationConnector((ResourceProvidedRole)newValue);
				return;
			case AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				setFromControllerInstance_ControllerAllocationConnector((ControllerInstance)newValue);
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
			case AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				setResourceProvidedRole_ResourceProvidedRoleAllocationConnector((ResourceProvidedRole)null);
				return;
			case AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				setFromControllerInstance_ControllerAllocationConnector((ControllerInstance)null);
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
			case AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__RESOURCE_PROVIDED_ROLE_RESOURCE_PROVIDED_ROLE_ALLOCATION_CONNECTOR:
				return resourceProvidedRole_ResourceProvidedRoleAllocationConnector != null;
			case AllocationPackage.RESOURCE_PROVIDED_ROLE_CONNECTOR__FROM_CONTROLLER_INSTANCE_CONTROLLER_ALLOCATION_CONNECTOR:
				return fromControllerInstance_ControllerAllocationConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceProvidedRoleConnectorImpl
