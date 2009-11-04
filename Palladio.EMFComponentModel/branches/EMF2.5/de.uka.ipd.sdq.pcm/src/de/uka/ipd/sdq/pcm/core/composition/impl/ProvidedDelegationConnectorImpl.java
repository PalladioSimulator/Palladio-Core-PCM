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
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.impl.DelegationConnectorImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Provided Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl#getInnerProvidedRole_ProvidedDelegationConnector <em>Inner Provided Role Provided Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl#getOuterProvidedRole_ProvidedDelegationConnector <em>Outer Provided Role Provided Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl#getAssemblyContext_ProvidedDelegationConnector <em>Assembly Context Provided Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl#getParentStructure_ProvidedDelegationConnector <em>Parent Structure Provided Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProvidedDelegationConnectorImpl extends DelegationConnectorImpl implements ProvidedDelegationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getInnerProvidedRole_ProvidedDelegationConnector() <em>Inner Provided Role Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerProvidedRole_ProvidedDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected ProvidedRole innerProvidedRole_ProvidedDelegationConnector;

	/**
	 * The cached value of the '{@link #getOuterProvidedRole_ProvidedDelegationConnector() <em>Outer Provided Role Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterProvidedRole_ProvidedDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected ProvidedRole outerProvidedRole_ProvidedDelegationConnector;

	/**
	 * The cached value of the '{@link #getAssemblyContext_ProvidedDelegationConnector() <em>Assembly Context Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContext_ProvidedDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblyContext_ProvidedDelegationConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProvidedDelegationConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.PROVIDED_DELEGATION_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole getInnerProvidedRole_ProvidedDelegationConnector() {
		if (innerProvidedRole_ProvidedDelegationConnector != null && innerProvidedRole_ProvidedDelegationConnector.eIsProxy()) {
			InternalEObject oldInnerProvidedRole_ProvidedDelegationConnector = (InternalEObject)innerProvidedRole_ProvidedDelegationConnector;
			innerProvidedRole_ProvidedDelegationConnector = (ProvidedRole)eResolveProxy(oldInnerProvidedRole_ProvidedDelegationConnector);
			if (innerProvidedRole_ProvidedDelegationConnector != oldInnerProvidedRole_ProvidedDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR, oldInnerProvidedRole_ProvidedDelegationConnector, innerProvidedRole_ProvidedDelegationConnector));
			}
		}
		return innerProvidedRole_ProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole basicGetInnerProvidedRole_ProvidedDelegationConnector() {
		return innerProvidedRole_ProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerProvidedRole_ProvidedDelegationConnector(ProvidedRole newInnerProvidedRole_ProvidedDelegationConnector) {
		ProvidedRole oldInnerProvidedRole_ProvidedDelegationConnector = innerProvidedRole_ProvidedDelegationConnector;
		innerProvidedRole_ProvidedDelegationConnector = newInnerProvidedRole_ProvidedDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR, oldInnerProvidedRole_ProvidedDelegationConnector, innerProvidedRole_ProvidedDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole getOuterProvidedRole_ProvidedDelegationConnector() {
		if (outerProvidedRole_ProvidedDelegationConnector != null && outerProvidedRole_ProvidedDelegationConnector.eIsProxy()) {
			InternalEObject oldOuterProvidedRole_ProvidedDelegationConnector = (InternalEObject)outerProvidedRole_ProvidedDelegationConnector;
			outerProvidedRole_ProvidedDelegationConnector = (ProvidedRole)eResolveProxy(oldOuterProvidedRole_ProvidedDelegationConnector);
			if (outerProvidedRole_ProvidedDelegationConnector != oldOuterProvidedRole_ProvidedDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR, oldOuterProvidedRole_ProvidedDelegationConnector, outerProvidedRole_ProvidedDelegationConnector));
			}
		}
		return outerProvidedRole_ProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedRole basicGetOuterProvidedRole_ProvidedDelegationConnector() {
		return outerProvidedRole_ProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterProvidedRole_ProvidedDelegationConnector(ProvidedRole newOuterProvidedRole_ProvidedDelegationConnector) {
		ProvidedRole oldOuterProvidedRole_ProvidedDelegationConnector = outerProvidedRole_ProvidedDelegationConnector;
		outerProvidedRole_ProvidedDelegationConnector = newOuterProvidedRole_ProvidedDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR, oldOuterProvidedRole_ProvidedDelegationConnector, outerProvidedRole_ProvidedDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext_ProvidedDelegationConnector() {
		if (assemblyContext_ProvidedDelegationConnector != null && assemblyContext_ProvidedDelegationConnector.eIsProxy()) {
			InternalEObject oldAssemblyContext_ProvidedDelegationConnector = (InternalEObject)assemblyContext_ProvidedDelegationConnector;
			assemblyContext_ProvidedDelegationConnector = (AssemblyContext)eResolveProxy(oldAssemblyContext_ProvidedDelegationConnector);
			if (assemblyContext_ProvidedDelegationConnector != oldAssemblyContext_ProvidedDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR, oldAssemblyContext_ProvidedDelegationConnector, assemblyContext_ProvidedDelegationConnector));
			}
		}
		return assemblyContext_ProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext_ProvidedDelegationConnector() {
		return assemblyContext_ProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext_ProvidedDelegationConnector(AssemblyContext newAssemblyContext_ProvidedDelegationConnector) {
		AssemblyContext oldAssemblyContext_ProvidedDelegationConnector = assemblyContext_ProvidedDelegationConnector;
		assemblyContext_ProvidedDelegationConnector = newAssemblyContext_ProvidedDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR, oldAssemblyContext_ProvidedDelegationConnector, assemblyContext_ProvidedDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedStructure getParentStructure_ProvidedDelegationConnector() {
		if (eContainerFeatureID() != CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR) return null;
		return (ComposedStructure)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStructure_ProvidedDelegationConnector(ComposedStructure newParentStructure_ProvidedDelegationConnector, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStructure_ProvidedDelegationConnector, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStructure_ProvidedDelegationConnector(ComposedStructure newParentStructure_ProvidedDelegationConnector) {
		if (newParentStructure_ProvidedDelegationConnector != eInternalContainer() || (eContainerFeatureID() != CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR && newParentStructure_ProvidedDelegationConnector != null)) {
			if (EcoreUtil.isAncestor(this, newParentStructure_ProvidedDelegationConnector))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStructure_ProvidedDelegationConnector != null)
				msgs = ((InternalEObject)newParentStructure_ProvidedDelegationConnector).eInverseAdd(this, CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
			msgs = basicSetParentStructure_ProvidedDelegationConnector(newParentStructure_ProvidedDelegationConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR, newParentStructure_ProvidedDelegationConnector, newParentStructure_ProvidedDelegationConnector));
	}

	/**
	 * The cached OCL expression body for the '{@link #ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Provided Delegation Connectorandtheconnected Componentmustbepartofthesamecompositestructure</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentStructure_ProvidedDelegationConnector = self.assemblyContext_ProvidedDelegationConnector.parentStructure_AssemblyContext";

	/**
	 * The cached OCL invariant for the '{@link #ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Provided Delegation Connectorandtheconnected Componentmustbepartofthesamecompositestructure</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(CompositionPackage.Literals.PROVIDED_DELEGATION_CONNECTOR);
			try {
				PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 CompositionValidator.DIAGNOSTIC_SOURCE,
						 CompositionValidator.PROVIDED_DELEGATION_CONNECTOR__PROVIDED_DELEGATION_CONNECTORANDTHECONNECTED_COMPONENTMUSTBEPARTOFTHESAMECOMPOSITESTRUCTURE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Component Of Assembly Context And Inner Role Providing Component Need To Be The Same</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.innerProvidedRole_ProvidedDelegationConnector.providingEntity_ProvidedRole = self.assemblyContext_ProvidedDelegationConnector.encapsulatedComponent_AssemblyContext";

	/**
	 * The cached OCL invariant for the '{@link #ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Component Of Assembly Context And Inner Role Providing Component Need To Be The Same</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(CompositionPackage.Literals.PROVIDED_DELEGATION_CONNECTOR);
			try {
				COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 CompositionValidator.DIAGNOSTIC_SOURCE,
						 CompositionValidator.PROVIDED_DELEGATION_CONNECTOR__COMPONENT_OF_ASSEMBLY_CONTEXT_AND_INNER_ROLE_PROVIDING_COMPONENT_NEED_TO_BE_THE_SAME,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ComponentOfAssemblyContextAndInnerRoleProvidingComponentNeedToBeTheSame", EObjectValidator.getObjectLabel(this, context) }),
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
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentStructure_ProvidedDelegationConnector((ComposedStructure)otherEnd, msgs);
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
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR:
				return basicSetParentStructure_ProvidedDelegationConnector(null, msgs);
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
		switch (eContainerFeatureID()) {
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR:
				return eInternalContainer().eInverseRemove(this, CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
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
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				if (resolve) return getInnerProvidedRole_ProvidedDelegationConnector();
				return basicGetInnerProvidedRole_ProvidedDelegationConnector();
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				if (resolve) return getOuterProvidedRole_ProvidedDelegationConnector();
				return basicGetOuterProvidedRole_ProvidedDelegationConnector();
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR:
				if (resolve) return getAssemblyContext_ProvidedDelegationConnector();
				return basicGetAssemblyContext_ProvidedDelegationConnector();
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR:
				return getParentStructure_ProvidedDelegationConnector();
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
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				setInnerProvidedRole_ProvidedDelegationConnector((ProvidedRole)newValue);
				return;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				setOuterProvidedRole_ProvidedDelegationConnector((ProvidedRole)newValue);
				return;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR:
				setAssemblyContext_ProvidedDelegationConnector((AssemblyContext)newValue);
				return;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR:
				setParentStructure_ProvidedDelegationConnector((ComposedStructure)newValue);
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
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				setInnerProvidedRole_ProvidedDelegationConnector((ProvidedRole)null);
				return;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				setOuterProvidedRole_ProvidedDelegationConnector((ProvidedRole)null);
				return;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR:
				setAssemblyContext_ProvidedDelegationConnector((AssemblyContext)null);
				return;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR:
				setParentStructure_ProvidedDelegationConnector((ComposedStructure)null);
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
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				return innerProvidedRole_ProvidedDelegationConnector != null;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				return outerProvidedRole_ProvidedDelegationConnector != null;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_PROVIDED_DELEGATION_CONNECTOR:
				return assemblyContext_ProvidedDelegationConnector != null;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR:
				return getParentStructure_ProvidedDelegationConnector() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //ProvidedDelegationConnectorImpl
