
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.assembly.impl;

import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;
import de.uka.ipd.sdq.pcm.assembly.AssemblyPackage;
import de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector;

import de.uka.ipd.sdq.pcm.assembly.util.AssemblyValidator;

import de.uka.ipd.sdq.pcm.core.connectors.impl.ConnectorImpl;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

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
 * An implementation of the model object '<em><b>System Assembly Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.impl.SystemAssemblyConnectorImpl#getProvidingContext_SystemAssemblyConnector <em>Providing Context System Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.impl.SystemAssemblyConnectorImpl#getRequiringContext_SystemAssemblyConnector <em>Requiring Context System Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.impl.SystemAssemblyConnectorImpl#getProvidedRole_SystemAssemblyConnector <em>Provided Role System Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.impl.SystemAssemblyConnectorImpl#getRequiredRole_SystemAssemblyConnector <em>Required Role System Assembly Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemAssemblyConnectorImpl extends ConnectorImpl implements SystemAssemblyConnector {
	/**
	 * The cached value of the '{@link #getProvidingContext_SystemAssemblyConnector() <em>Providing Context System Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidingContext_SystemAssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext providingContext_SystemAssemblyConnector = null;

	/**
	 * The cached value of the '{@link #getRequiringContext_SystemAssemblyConnector() <em>Requiring Context System Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiringContext_SystemAssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext requiringContext_SystemAssemblyConnector = null;

	/**
	 * The cached value of the '{@link #getProvidedRole_SystemAssemblyConnector() <em>Provided Role System Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedRole_SystemAssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected ProvidedRole providedRole_SystemAssemblyConnector = null;

	/**
	 * The cached value of the '{@link #getRequiredRole_SystemAssemblyConnector() <em>Required Role System Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredRole_SystemAssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected RequiredRole requiredRole_SystemAssemblyConnector = null;


	/**
	 * The parsed OCL expression for the definition of the '{@link #contextIDsOfProvidesRoleNotEqualRequiresRole <em>Context IDs Of Provides Role Not Equal Requires Role</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #contextIDsOfProvidesRoleNotEqualRequiresRole
	 * @generated
	 */
	private static OCLExpression contextIDsOfProvidesRoleNotEqualRequiresRoleInvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemAssemblyConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AssemblyPackage.Literals.SYSTEM_ASSEMBLY_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getProvidingContext_SystemAssemblyConnector() {
		if (providingContext_SystemAssemblyConnector != null && providingContext_SystemAssemblyConnector.eIsProxy()) {
			InternalEObject oldProvidingContext_SystemAssemblyConnector = (InternalEObject)providingContext_SystemAssemblyConnector;
			providingContext_SystemAssemblyConnector = (AssemblyContext)eResolveProxy(oldProvidingContext_SystemAssemblyConnector);
			if (providingContext_SystemAssemblyConnector != oldProvidingContext_SystemAssemblyConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR, oldProvidingContext_SystemAssemblyConnector, providingContext_SystemAssemblyConnector));
			}
		}
		return providingContext_SystemAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetProvidingContext_SystemAssemblyConnector() {
		return providingContext_SystemAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidingContext_SystemAssemblyConnector(AssemblyContext newProvidingContext_SystemAssemblyConnector) {
		AssemblyContext oldProvidingContext_SystemAssemblyConnector = providingContext_SystemAssemblyConnector;
		providingContext_SystemAssemblyConnector = newProvidingContext_SystemAssemblyConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR, oldProvidingContext_SystemAssemblyConnector, providingContext_SystemAssemblyConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getRequiringContext_SystemAssemblyConnector() {
		if (requiringContext_SystemAssemblyConnector != null && requiringContext_SystemAssemblyConnector.eIsProxy()) {
			InternalEObject oldRequiringContext_SystemAssemblyConnector = (InternalEObject)requiringContext_SystemAssemblyConnector;
			requiringContext_SystemAssemblyConnector = (AssemblyContext)eResolveProxy(oldRequiringContext_SystemAssemblyConnector);
			if (requiringContext_SystemAssemblyConnector != oldRequiringContext_SystemAssemblyConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR, oldRequiringContext_SystemAssemblyConnector, requiringContext_SystemAssemblyConnector));
			}
		}
		return requiringContext_SystemAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetRequiringContext_SystemAssemblyConnector() {
		return requiringContext_SystemAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiringContext_SystemAssemblyConnector(AssemblyContext newRequiringContext_SystemAssemblyConnector) {
		AssemblyContext oldRequiringContext_SystemAssemblyConnector = requiringContext_SystemAssemblyConnector;
		requiringContext_SystemAssemblyConnector = newRequiringContext_SystemAssemblyConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR, oldRequiringContext_SystemAssemblyConnector, requiringContext_SystemAssemblyConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole getProvidedRole_SystemAssemblyConnector() {
		if (providedRole_SystemAssemblyConnector != null && providedRole_SystemAssemblyConnector.eIsProxy()) {
			InternalEObject oldProvidedRole_SystemAssemblyConnector = (InternalEObject)providedRole_SystemAssemblyConnector;
			providedRole_SystemAssemblyConnector = (ProvidedRole)eResolveProxy(oldProvidedRole_SystemAssemblyConnector);
			if (providedRole_SystemAssemblyConnector != oldProvidedRole_SystemAssemblyConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR, oldProvidedRole_SystemAssemblyConnector, providedRole_SystemAssemblyConnector));
			}
		}
		return providedRole_SystemAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole basicGetProvidedRole_SystemAssemblyConnector() {
		return providedRole_SystemAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedRole_SystemAssemblyConnector(ProvidedRole newProvidedRole_SystemAssemblyConnector) {
		ProvidedRole oldProvidedRole_SystemAssemblyConnector = providedRole_SystemAssemblyConnector;
		providedRole_SystemAssemblyConnector = newProvidedRole_SystemAssemblyConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR, oldProvidedRole_SystemAssemblyConnector, providedRole_SystemAssemblyConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredRole getRequiredRole_SystemAssemblyConnector() {
		if (requiredRole_SystemAssemblyConnector != null && requiredRole_SystemAssemblyConnector.eIsProxy()) {
			InternalEObject oldRequiredRole_SystemAssemblyConnector = (InternalEObject)requiredRole_SystemAssemblyConnector;
			requiredRole_SystemAssemblyConnector = (RequiredRole)eResolveProxy(oldRequiredRole_SystemAssemblyConnector);
			if (requiredRole_SystemAssemblyConnector != oldRequiredRole_SystemAssemblyConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR, oldRequiredRole_SystemAssemblyConnector, requiredRole_SystemAssemblyConnector));
			}
		}
		return requiredRole_SystemAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredRole basicGetRequiredRole_SystemAssemblyConnector() {
		return requiredRole_SystemAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredRole_SystemAssemblyConnector(RequiredRole newRequiredRole_SystemAssemblyConnector) {
		RequiredRole oldRequiredRole_SystemAssemblyConnector = requiredRole_SystemAssemblyConnector;
		requiredRole_SystemAssemblyConnector = newRequiredRole_SystemAssemblyConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR, oldRequiredRole_SystemAssemblyConnector, requiredRole_SystemAssemblyConnector));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean contextIDsOfProvidesRoleNotEqualRequiresRole(DiagnosticChain diagnostics, Map context) {
		if (contextIDsOfProvidesRoleNotEqualRequiresRoleInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = " self.providingRole.parentContext.identifier.id<>self.requiringRole.parentContext.identifier.id ";
			
			try {
				contextIDsOfProvidesRoleNotEqualRequiresRoleInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(contextIDsOfProvidesRoleNotEqualRequiresRoleInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AssemblyValidator.DIAGNOSTIC_SOURCE,
						 AssemblyValidator.SYSTEM_ASSEMBLY_CONNECTOR__CONTEXT_IDS_OF_PROVIDES_ROLE_NOT_EQUAL_REQUIRES_ROLE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "contextIDsOfProvidesRoleNotEqualRequiresRole", EObjectValidator.getObjectLabel(this, context) }),
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR:
				if (resolve) return getProvidingContext_SystemAssemblyConnector();
				return basicGetProvidingContext_SystemAssemblyConnector();
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR:
				if (resolve) return getRequiringContext_SystemAssemblyConnector();
				return basicGetRequiringContext_SystemAssemblyConnector();
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR:
				if (resolve) return getProvidedRole_SystemAssemblyConnector();
				return basicGetProvidedRole_SystemAssemblyConnector();
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR:
				if (resolve) return getRequiredRole_SystemAssemblyConnector();
				return basicGetRequiredRole_SystemAssemblyConnector();
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
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR:
				setProvidingContext_SystemAssemblyConnector((AssemblyContext)newValue);
				return;
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR:
				setRequiringContext_SystemAssemblyConnector((AssemblyContext)newValue);
				return;
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR:
				setProvidedRole_SystemAssemblyConnector((ProvidedRole)newValue);
				return;
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR:
				setRequiredRole_SystemAssemblyConnector((RequiredRole)newValue);
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
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR:
				setProvidingContext_SystemAssemblyConnector((AssemblyContext)null);
				return;
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR:
				setRequiringContext_SystemAssemblyConnector((AssemblyContext)null);
				return;
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR:
				setProvidedRole_SystemAssemblyConnector((ProvidedRole)null);
				return;
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR:
				setRequiredRole_SystemAssemblyConnector((RequiredRole)null);
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
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR:
				return providingContext_SystemAssemblyConnector != null;
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRING_CONTEXT_SYSTEM_ASSEMBLY_CONNECTOR:
				return requiringContext_SystemAssemblyConnector != null;
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__PROVIDED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR:
				return providedRole_SystemAssemblyConnector != null;
			case AssemblyPackage.SYSTEM_ASSEMBLY_CONNECTOR__REQUIRED_ROLE_SYSTEM_ASSEMBLY_CONNECTOR:
				return requiredRole_SystemAssemblyConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //SystemAssemblyConnectorImpl