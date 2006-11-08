
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

import de.uka.ipd.sdq.pcm.core.connectors.impl.ConnectorImpl;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getRequiringChildComponentContext_CompositeAssemblyConnector <em>Requiring Child Component Context Composite Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getProvidingChildComponentContext_CompositeAssemblyConnector <em>Providing Child Component Context Composite Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getProvidedRole_CompositeAssemblyConnector <em>Provided Role Composite Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getRequiredRole_CompositeAssemblyConnector <em>Required Role Composite Assembly Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssemblyConnectorImpl extends ConnectorImpl implements AssemblyConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getRequiringChildComponentContext_CompositeAssemblyConnector() <em>Requiring Child Component Context Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiringChildComponentContext_CompositeAssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext requiringChildComponentContext_CompositeAssemblyConnector = null;

	/**
	 * The cached value of the '{@link #getProvidingChildComponentContext_CompositeAssemblyConnector() <em>Providing Child Component Context Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidingChildComponentContext_CompositeAssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext providingChildComponentContext_CompositeAssemblyConnector = null;

	/**
	 * The cached value of the '{@link #getProvidedRole_CompositeAssemblyConnector() <em>Provided Role Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedRole_CompositeAssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected ProvidedRole providedRole_CompositeAssemblyConnector = null;

	/**
	 * The cached value of the '{@link #getRequiredRole_CompositeAssemblyConnector() <em>Required Role Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredRole_CompositeAssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected RequiredRole requiredRole_CompositeAssemblyConnector = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssemblyConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.ASSEMBLY_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getRequiringChildComponentContext_CompositeAssemblyConnector() {
		if (requiringChildComponentContext_CompositeAssemblyConnector != null && requiringChildComponentContext_CompositeAssemblyConnector.eIsProxy()) {
			InternalEObject oldRequiringChildComponentContext_CompositeAssemblyConnector = (InternalEObject)requiringChildComponentContext_CompositeAssemblyConnector;
			requiringChildComponentContext_CompositeAssemblyConnector = (AssemblyContext)eResolveProxy(oldRequiringChildComponentContext_CompositeAssemblyConnector);
			if (requiringChildComponentContext_CompositeAssemblyConnector != oldRequiringChildComponentContext_CompositeAssemblyConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR, oldRequiringChildComponentContext_CompositeAssemblyConnector, requiringChildComponentContext_CompositeAssemblyConnector));
			}
		}
		return requiringChildComponentContext_CompositeAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetRequiringChildComponentContext_CompositeAssemblyConnector() {
		return requiringChildComponentContext_CompositeAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiringChildComponentContext_CompositeAssemblyConnector(AssemblyContext newRequiringChildComponentContext_CompositeAssemblyConnector) {
		AssemblyContext oldRequiringChildComponentContext_CompositeAssemblyConnector = requiringChildComponentContext_CompositeAssemblyConnector;
		requiringChildComponentContext_CompositeAssemblyConnector = newRequiringChildComponentContext_CompositeAssemblyConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR, oldRequiringChildComponentContext_CompositeAssemblyConnector, requiringChildComponentContext_CompositeAssemblyConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getProvidingChildComponentContext_CompositeAssemblyConnector() {
		if (providingChildComponentContext_CompositeAssemblyConnector != null && providingChildComponentContext_CompositeAssemblyConnector.eIsProxy()) {
			InternalEObject oldProvidingChildComponentContext_CompositeAssemblyConnector = (InternalEObject)providingChildComponentContext_CompositeAssemblyConnector;
			providingChildComponentContext_CompositeAssemblyConnector = (AssemblyContext)eResolveProxy(oldProvidingChildComponentContext_CompositeAssemblyConnector);
			if (providingChildComponentContext_CompositeAssemblyConnector != oldProvidingChildComponentContext_CompositeAssemblyConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR, oldProvidingChildComponentContext_CompositeAssemblyConnector, providingChildComponentContext_CompositeAssemblyConnector));
			}
		}
		return providingChildComponentContext_CompositeAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetProvidingChildComponentContext_CompositeAssemblyConnector() {
		return providingChildComponentContext_CompositeAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidingChildComponentContext_CompositeAssemblyConnector(AssemblyContext newProvidingChildComponentContext_CompositeAssemblyConnector) {
		AssemblyContext oldProvidingChildComponentContext_CompositeAssemblyConnector = providingChildComponentContext_CompositeAssemblyConnector;
		providingChildComponentContext_CompositeAssemblyConnector = newProvidingChildComponentContext_CompositeAssemblyConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR, oldProvidingChildComponentContext_CompositeAssemblyConnector, providingChildComponentContext_CompositeAssemblyConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole getProvidedRole_CompositeAssemblyConnector() {
		if (providedRole_CompositeAssemblyConnector != null && providedRole_CompositeAssemblyConnector.eIsProxy()) {
			InternalEObject oldProvidedRole_CompositeAssemblyConnector = (InternalEObject)providedRole_CompositeAssemblyConnector;
			providedRole_CompositeAssemblyConnector = (ProvidedRole)eResolveProxy(oldProvidedRole_CompositeAssemblyConnector);
			if (providedRole_CompositeAssemblyConnector != oldProvidedRole_CompositeAssemblyConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR, oldProvidedRole_CompositeAssemblyConnector, providedRole_CompositeAssemblyConnector));
			}
		}
		return providedRole_CompositeAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole basicGetProvidedRole_CompositeAssemblyConnector() {
		return providedRole_CompositeAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedRole_CompositeAssemblyConnector(ProvidedRole newProvidedRole_CompositeAssemblyConnector) {
		ProvidedRole oldProvidedRole_CompositeAssemblyConnector = providedRole_CompositeAssemblyConnector;
		providedRole_CompositeAssemblyConnector = newProvidedRole_CompositeAssemblyConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR, oldProvidedRole_CompositeAssemblyConnector, providedRole_CompositeAssemblyConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredRole getRequiredRole_CompositeAssemblyConnector() {
		if (requiredRole_CompositeAssemblyConnector != null && requiredRole_CompositeAssemblyConnector.eIsProxy()) {
			InternalEObject oldRequiredRole_CompositeAssemblyConnector = (InternalEObject)requiredRole_CompositeAssemblyConnector;
			requiredRole_CompositeAssemblyConnector = (RequiredRole)eResolveProxy(oldRequiredRole_CompositeAssemblyConnector);
			if (requiredRole_CompositeAssemblyConnector != oldRequiredRole_CompositeAssemblyConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR, oldRequiredRole_CompositeAssemblyConnector, requiredRole_CompositeAssemblyConnector));
			}
		}
		return requiredRole_CompositeAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredRole basicGetRequiredRole_CompositeAssemblyConnector() {
		return requiredRole_CompositeAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredRole_CompositeAssemblyConnector(RequiredRole newRequiredRole_CompositeAssemblyConnector) {
		RequiredRole oldRequiredRole_CompositeAssemblyConnector = requiredRole_CompositeAssemblyConnector;
		requiredRole_CompositeAssemblyConnector = newRequiredRole_CompositeAssemblyConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR, oldRequiredRole_CompositeAssemblyConnector, requiredRole_CompositeAssemblyConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR:
				if (resolve) return getRequiringChildComponentContext_CompositeAssemblyConnector();
				return basicGetRequiringChildComponentContext_CompositeAssemblyConnector();
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR:
				if (resolve) return getProvidingChildComponentContext_CompositeAssemblyConnector();
				return basicGetProvidingChildComponentContext_CompositeAssemblyConnector();
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				if (resolve) return getProvidedRole_CompositeAssemblyConnector();
				return basicGetProvidedRole_CompositeAssemblyConnector();
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				if (resolve) return getRequiredRole_CompositeAssemblyConnector();
				return basicGetRequiredRole_CompositeAssemblyConnector();
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
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR:
				setRequiringChildComponentContext_CompositeAssemblyConnector((AssemblyContext)newValue);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR:
				setProvidingChildComponentContext_CompositeAssemblyConnector((AssemblyContext)newValue);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				setProvidedRole_CompositeAssemblyConnector((ProvidedRole)newValue);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				setRequiredRole_CompositeAssemblyConnector((RequiredRole)newValue);
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
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR:
				setRequiringChildComponentContext_CompositeAssemblyConnector((AssemblyContext)null);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR:
				setProvidingChildComponentContext_CompositeAssemblyConnector((AssemblyContext)null);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				setProvidedRole_CompositeAssemblyConnector((ProvidedRole)null);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				setRequiredRole_CompositeAssemblyConnector((RequiredRole)null);
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
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR:
				return requiringChildComponentContext_CompositeAssemblyConnector != null;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR:
				return providingChildComponentContext_CompositeAssemblyConnector != null;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				return providedRole_CompositeAssemblyConnector != null;
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				return requiredRole_CompositeAssemblyConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //AssemblyConnectorImpl