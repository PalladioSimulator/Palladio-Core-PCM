/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

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
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;
import de.uka.ipd.sdq.pcm.core.connectors.impl.ConnectorImpl;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getRequiringAssemblyContext_AssemblyConnector <em>Requiring Assembly Context Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getProvidingAssemblyContext_AssemblyConnector <em>Providing Assembly Context Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getProvidedRole_CompositeAssemblyConnector <em>Provided Role Composite Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getRequiredRole_CompositeAssemblyConnector <em>Required Role Composite Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getParentStructure_AssemblyConnector <em>Parent Structure Assembly Connector</em>}</li>
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
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getRequiringAssemblyContext_AssemblyConnector() <em>Requiring Assembly Context Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiringAssemblyContext_AssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext requiringAssemblyContext_AssemblyConnector;

	/**
	 * The cached value of the '{@link #getProvidingAssemblyContext_AssemblyConnector() <em>Providing Assembly Context Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidingAssemblyContext_AssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext providingAssemblyContext_AssemblyConnector;

	/**
	 * The cached value of the '{@link #getProvidedRole_CompositeAssemblyConnector() <em>Provided Role Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedRole_CompositeAssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected ProvidedRole providedRole_CompositeAssemblyConnector;

	/**
	 * The cached value of the '{@link #getRequiredRole_CompositeAssemblyConnector() <em>Required Role Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredRole_CompositeAssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected RequiredRole requiredRole_CompositeAssemblyConnector;

	/**
	 * The parsed OCL expression for the definition of the '{@link #AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch <em>Assembly Connectors Referenced Provided Roles And Child Context Must Match</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch
	 * @generated
	 */
	private static OCLExpression AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatchInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '{@link #AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch <em>Assembly Connectors Referenced Required Role And Child Context Must Match</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch
	 * @generated
	 */
	private static OCLExpression AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatchInvOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";

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
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.ASSEMBLY_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getRequiringAssemblyContext_AssemblyConnector() {
		if (requiringAssemblyContext_AssemblyConnector != null && requiringAssemblyContext_AssemblyConnector.eIsProxy()) {
			InternalEObject oldRequiringAssemblyContext_AssemblyConnector = (InternalEObject)requiringAssemblyContext_AssemblyConnector;
			requiringAssemblyContext_AssemblyConnector = (AssemblyContext)eResolveProxy(oldRequiringAssemblyContext_AssemblyConnector);
			if (requiringAssemblyContext_AssemblyConnector != oldRequiringAssemblyContext_AssemblyConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR, oldRequiringAssemblyContext_AssemblyConnector, requiringAssemblyContext_AssemblyConnector));
			}
		}
		return requiringAssemblyContext_AssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetRequiringAssemblyContext_AssemblyConnector() {
		return requiringAssemblyContext_AssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiringAssemblyContext_AssemblyConnector(AssemblyContext newRequiringAssemblyContext_AssemblyConnector) {
		AssemblyContext oldRequiringAssemblyContext_AssemblyConnector = requiringAssemblyContext_AssemblyConnector;
		requiringAssemblyContext_AssemblyConnector = newRequiringAssemblyContext_AssemblyConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR, oldRequiringAssemblyContext_AssemblyConnector, requiringAssemblyContext_AssemblyConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getProvidingAssemblyContext_AssemblyConnector() {
		if (providingAssemblyContext_AssemblyConnector != null && providingAssemblyContext_AssemblyConnector.eIsProxy()) {
			InternalEObject oldProvidingAssemblyContext_AssemblyConnector = (InternalEObject)providingAssemblyContext_AssemblyConnector;
			providingAssemblyContext_AssemblyConnector = (AssemblyContext)eResolveProxy(oldProvidingAssemblyContext_AssemblyConnector);
			if (providingAssemblyContext_AssemblyConnector != oldProvidingAssemblyContext_AssemblyConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR, oldProvidingAssemblyContext_AssemblyConnector, providingAssemblyContext_AssemblyConnector));
			}
		}
		return providingAssemblyContext_AssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetProvidingAssemblyContext_AssemblyConnector() {
		return providingAssemblyContext_AssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidingAssemblyContext_AssemblyConnector(AssemblyContext newProvidingAssemblyContext_AssemblyConnector) {
		AssemblyContext oldProvidingAssemblyContext_AssemblyConnector = providingAssemblyContext_AssemblyConnector;
		providingAssemblyContext_AssemblyConnector = newProvidingAssemblyContext_AssemblyConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR, oldProvidingAssemblyContext_AssemblyConnector, providingAssemblyContext_AssemblyConnector));
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
	public ComposedStructure getParentStructure_AssemblyConnector() {
		if (eContainerFeatureID != CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR) return null;
		return (ComposedStructure)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStructure_AssemblyConnector(ComposedStructure newParentStructure_AssemblyConnector, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStructure_AssemblyConnector, CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStructure_AssemblyConnector(ComposedStructure newParentStructure_AssemblyConnector) {
		if (newParentStructure_AssemblyConnector != eInternalContainer() || (eContainerFeatureID != CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR && newParentStructure_AssemblyConnector != null)) {
			if (EcoreUtil.isAncestor(this, newParentStructure_AssemblyConnector))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStructure_AssemblyConnector != null)
				msgs = ((InternalEObject)newParentStructure_AssemblyConnector).eInverseAdd(this, CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
			msgs = basicSetParentStructure_AssemblyConnector(newParentStructure_AssemblyConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR, newParentStructure_AssemblyConnector, newParentStructure_AssemblyConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatchInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "An AssemblyConnector references an assembly context and a provided role on the provider side. This constraint ensures that the referenced provided role is really available in the referenced assembly context.   self.providingChildComponentContext_CompositeAssemblyConnector.encapsulatedComponent_ChildComponentContext.providedRoles_InterfaceProvidingEntity->includes(self.providedRole_CompositeAssemblyConnector)  ";
			
			try {
				AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatchInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatchInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 CompositionValidator.DIAGNOSTIC_SOURCE,
						 CompositionValidator.ASSEMBLY_CONNECTOR__ASSEMBLY_CONNECTORS_REFERENCED_PROVIDED_ROLES_AND_CHILD_CONTEXT_MUST_MATCH,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatchInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "An AssemblyConnector references an assembly context and a required role on the client side. This constraint ensures that the referenced required role is really available in the referenced assembly context.   self.requiringChildComponentContext_CompositeAssemblyConnector.encapsulatedComponent_ChildComponentContext.requiredRoles_InterfaceProvidingEntity->includes(self.requiredRole_CompositeAssemblyConnector) ";
			
			try {
				AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatchInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatchInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 CompositionValidator.DIAGNOSTIC_SOURCE,
						 CompositionValidator.ASSEMBLY_CONNECTOR__ASSEMBLY_CONNECTORS_REFERENCED_REQUIRED_ROLE_AND_CHILD_CONTEXT_MUST_MATCH,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch", EObjectValidator.getObjectLabel(this, context) }),
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
			case CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentStructure_AssemblyConnector((ComposedStructure)otherEnd, msgs);
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
			case CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR:
				return basicSetParentStructure_AssemblyConnector(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR:
				return eInternalContainer().eInverseRemove(this, CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
				if (resolve) return getRequiringAssemblyContext_AssemblyConnector();
				return basicGetRequiringAssemblyContext_AssemblyConnector();
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
				if (resolve) return getProvidingAssemblyContext_AssemblyConnector();
				return basicGetProvidingAssemblyContext_AssemblyConnector();
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				if (resolve) return getProvidedRole_CompositeAssemblyConnector();
				return basicGetProvidedRole_CompositeAssemblyConnector();
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				if (resolve) return getRequiredRole_CompositeAssemblyConnector();
				return basicGetRequiredRole_CompositeAssemblyConnector();
			case CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR:
				return getParentStructure_AssemblyConnector();
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
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
				setRequiringAssemblyContext_AssemblyConnector((AssemblyContext)newValue);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
				setProvidingAssemblyContext_AssemblyConnector((AssemblyContext)newValue);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				setProvidedRole_CompositeAssemblyConnector((ProvidedRole)newValue);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				setRequiredRole_CompositeAssemblyConnector((RequiredRole)newValue);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR:
				setParentStructure_AssemblyConnector((ComposedStructure)newValue);
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
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
				setRequiringAssemblyContext_AssemblyConnector((AssemblyContext)null);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
				setProvidingAssemblyContext_AssemblyConnector((AssemblyContext)null);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				setProvidedRole_CompositeAssemblyConnector((ProvidedRole)null);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				setRequiredRole_CompositeAssemblyConnector((RequiredRole)null);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR:
				setParentStructure_AssemblyConnector((ComposedStructure)null);
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
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
				return requiringAssemblyContext_AssemblyConnector != null;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_CONNECTOR:
				return providingAssemblyContext_AssemblyConnector != null;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				return providedRole_CompositeAssemblyConnector != null;
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR:
				return requiredRole_CompositeAssemblyConnector != null;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR:
				return getParentStructure_AssemblyConnector() != null;
		}
		return super.eIsSet(featureID);
	}

} //AssemblyConnectorImpl
