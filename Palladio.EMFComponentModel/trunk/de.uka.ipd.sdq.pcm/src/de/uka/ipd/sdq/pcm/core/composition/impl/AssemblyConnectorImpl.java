/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getRequiringAssemblyContext_AssemblyConnector <em>Requiring Assembly Context Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getProvidingAssemblyContext_AssemblyConnector <em>Providing Assembly Context Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getProvidedRole_AssemblyConnector <em>Provided Role Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyConnectorImpl#getRequiredRole_AssemblyConnector <em>Required Role Assembly Connector</em>}</li>
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
	public static final String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";

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
	 * The cached value of the '{@link #getProvidedRole_AssemblyConnector() <em>Provided Role Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedRole_AssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected ProvidedRole providedRole_AssemblyConnector;

	/**
	 * The cached value of the '{@link #getRequiredRole_AssemblyConnector() <em>Required Role Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredRole_AssemblyConnector()
	 * @generated
	 * @ordered
	 */
	protected RequiredRole requiredRole_AssemblyConnector;

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
	public ProvidedRole getProvidedRole_AssemblyConnector() {
		if (providedRole_AssemblyConnector != null && providedRole_AssemblyConnector.eIsProxy()) {
			InternalEObject oldProvidedRole_AssemblyConnector = (InternalEObject)providedRole_AssemblyConnector;
			providedRole_AssemblyConnector = (ProvidedRole)eResolveProxy(oldProvidedRole_AssemblyConnector);
			if (providedRole_AssemblyConnector != oldProvidedRole_AssemblyConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR, oldProvidedRole_AssemblyConnector, providedRole_AssemblyConnector));
			}
		}
		return providedRole_AssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole basicGetProvidedRole_AssemblyConnector() {
		return providedRole_AssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedRole_AssemblyConnector(ProvidedRole newProvidedRole_AssemblyConnector) {
		ProvidedRole oldProvidedRole_AssemblyConnector = providedRole_AssemblyConnector;
		providedRole_AssemblyConnector = newProvidedRole_AssemblyConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR, oldProvidedRole_AssemblyConnector, providedRole_AssemblyConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredRole getRequiredRole_AssemblyConnector() {
		if (requiredRole_AssemblyConnector != null && requiredRole_AssemblyConnector.eIsProxy()) {
			InternalEObject oldRequiredRole_AssemblyConnector = (InternalEObject)requiredRole_AssemblyConnector;
			requiredRole_AssemblyConnector = (RequiredRole)eResolveProxy(oldRequiredRole_AssemblyConnector);
			if (requiredRole_AssemblyConnector != oldRequiredRole_AssemblyConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR, oldRequiredRole_AssemblyConnector, requiredRole_AssemblyConnector));
			}
		}
		return requiredRole_AssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredRole basicGetRequiredRole_AssemblyConnector() {
		return requiredRole_AssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredRole_AssemblyConnector(RequiredRole newRequiredRole_AssemblyConnector) {
		RequiredRole oldRequiredRole_AssemblyConnector = requiredRole_AssemblyConnector;
		requiredRole_AssemblyConnector = newRequiredRole_AssemblyConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR, oldRequiredRole_AssemblyConnector, requiredRole_AssemblyConnector));
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
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
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
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
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
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR:
				if (resolve) return getProvidedRole_AssemblyConnector();
				return basicGetProvidedRole_AssemblyConnector();
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR:
				if (resolve) return getRequiredRole_AssemblyConnector();
				return basicGetRequiredRole_AssemblyConnector();
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
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR:
				setProvidedRole_AssemblyConnector((ProvidedRole)newValue);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR:
				setRequiredRole_AssemblyConnector((RequiredRole)newValue);
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
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR:
				setProvidedRole_AssemblyConnector((ProvidedRole)null);
				return;
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR:
				setRequiredRole_AssemblyConnector((RequiredRole)null);
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
			case CompositionPackage.ASSEMBLY_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_CONNECTOR:
				return providedRole_AssemblyConnector != null;
			case CompositionPackage.ASSEMBLY_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_CONNECTOR:
				return requiredRole_AssemblyConnector != null;
			case CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR:
				return getParentStructure_AssemblyConnector() != null;
		}
		return super.eIsSet(featureID);
	}

} //AssemblyConnectorImpl
