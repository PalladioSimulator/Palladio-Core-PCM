/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composed Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getAssemblyContexts_ComposedStructure <em>Assembly Contexts Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getAssemblyConnectors_ComposedStructure <em>Assembly Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getRequiredDelegationConnectors_ComposedStructure <em>Required Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getResourceRequiredDelegationConnectors_ComposedStructure <em>Resource Required Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getAssemblyEventConnector__ComposedStructure <em>Assembly Event Connector Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getSinkDelegationConnectors__ComposedStructure <em>Sink Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getSourceDelegationConnectors__ComposedStructure <em>Source Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getProvidedDelegationConnectors_ComposedStructure <em>Provided Delegation Connectors Composed Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComposedStructureImpl extends EntityImpl implements ComposedStructure {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getAssemblyContexts_ComposedStructure() <em>Assembly Contexts Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContexts_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<AssemblyContext> assemblyContexts_ComposedStructure;

	/**
	 * The cached value of the '{@link #getAssemblyConnectors_ComposedStructure() <em>Assembly Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<AssemblyConnector> assemblyConnectors_ComposedStructure;

	/**
	 * The cached value of the '{@link #getRequiredDelegationConnectors_ComposedStructure() <em>Required Delegation Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredDelegationConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<RequiredDelegationConnector> requiredDelegationConnectors_ComposedStructure;

	/**
	 * The cached value of the '{@link #getResourceRequiredDelegationConnectors_ComposedStructure() <em>Resource Required Delegation Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRequiredDelegationConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceRequiredDelegationConnector> resourceRequiredDelegationConnectors_ComposedStructure;

	/**
	 * The cached value of the '{@link #getAssemblyEventConnector__ComposedStructure() <em>Assembly Event Connector Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyEventConnector__ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<AssemblyEventConnector> assemblyEventConnector__ComposedStructure;

	/**
	 * The cached value of the '{@link #getSinkDelegationConnectors__ComposedStructure() <em>Sink Delegation Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSinkDelegationConnectors__ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<SinkDelegationConnector> sinkDelegationConnectors__ComposedStructure;

	/**
	 * The cached value of the '{@link #getSourceDelegationConnectors__ComposedStructure() <em>Source Delegation Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceDelegationConnectors__ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceDelegationConnector> sourceDelegationConnectors__ComposedStructure;

	/**
	 * The cached value of the '{@link #getProvidedDelegationConnectors_ComposedStructure() <em>Provided Delegation Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedDelegationConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<ProvidedDelegationConnector> providedDelegationConnectors_ComposedStructure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedStructureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.COMPOSED_STRUCTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssemblyContext> getAssemblyContexts_ComposedStructure() {
		if (assemblyContexts_ComposedStructure == null) {
			assemblyContexts_ComposedStructure = new EObjectContainmentWithInverseEList<AssemblyContext>(AssemblyContext.class, this, CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE, CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT);
		}
		return assemblyContexts_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssemblyConnector> getAssemblyConnectors_ComposedStructure() {
		if (assemblyConnectors_ComposedStructure == null) {
			assemblyConnectors_ComposedStructure = new EObjectContainmentWithInverseEList<AssemblyConnector>(AssemblyConnector.class, this, CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE, CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR);
		}
		return assemblyConnectors_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequiredDelegationConnector> getRequiredDelegationConnectors_ComposedStructure() {
		if (requiredDelegationConnectors_ComposedStructure == null) {
			requiredDelegationConnectors_ComposedStructure = new EObjectContainmentWithInverseEList<RequiredDelegationConnector>(RequiredDelegationConnector.class, this, CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR);
		}
		return requiredDelegationConnectors_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceRequiredDelegationConnector> getResourceRequiredDelegationConnectors_ComposedStructure() {
		if (resourceRequiredDelegationConnectors_ComposedStructure == null) {
			resourceRequiredDelegationConnectors_ComposedStructure = new EObjectContainmentWithInverseEList<ResourceRequiredDelegationConnector>(ResourceRequiredDelegationConnector.class, this, CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR);
		}
		return resourceRequiredDelegationConnectors_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssemblyEventConnector> getAssemblyEventConnector__ComposedStructure() {
		if (assemblyEventConnector__ComposedStructure == null) {
			assemblyEventConnector__ComposedStructure = new EObjectContainmentWithInverseEList<AssemblyEventConnector>(AssemblyEventConnector.class, this, CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_EVENT_CONNECTOR_COMPOSED_STRUCTURE, CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_EVENT_CONNECTOR);
		}
		return assemblyEventConnector__ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SinkDelegationConnector> getSinkDelegationConnectors__ComposedStructure() {
		if (sinkDelegationConnectors__ComposedStructure == null) {
			sinkDelegationConnectors__ComposedStructure = new EObjectContainmentWithInverseEList<SinkDelegationConnector>(SinkDelegationConnector.class, this, CompositionPackage.COMPOSED_STRUCTURE__SINK_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, CompositionPackage.SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR);
		}
		return sinkDelegationConnectors__ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceDelegationConnector> getSourceDelegationConnectors__ComposedStructure() {
		if (sourceDelegationConnectors__ComposedStructure == null) {
			sourceDelegationConnectors__ComposedStructure = new EObjectContainmentWithInverseEList<SourceDelegationConnector>(SourceDelegationConnector.class, this, CompositionPackage.COMPOSED_STRUCTURE__SOURCE_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, CompositionPackage.SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR);
		}
		return sourceDelegationConnectors__ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProvidedDelegationConnector> getProvidedDelegationConnectors_ComposedStructure() {
		if (providedDelegationConnectors_ComposedStructure == null) {
			providedDelegationConnectors_ComposedStructure = new EObjectContainmentWithInverseEList<ProvidedDelegationConnector>(ProvidedDelegationConnector.class, this, CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR);
		}
		return providedDelegationConnectors_ComposedStructure;
	}

	/**
	 * The cached OCL expression body for the '{@link #MultipleConnectorsConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Multiple Connectors Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MultipleConnectorsConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.providedDelegationConnectors_ComposedStructure->forAll( c1, c2 | c1 <> c2 implies c1.outerProvidedRole_ProvidedDelegationConnector <> c2.outerProvidedRole_ProvidedDelegationConnector)\n"+"";

	/**
	 * The cached OCL invariant for the '{@link #MultipleConnectorsConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Multiple Connectors Constraint</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MultipleConnectorsConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean MultipleConnectorsConstraint(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(CompositionPackage.Literals.COMPOSED_STRUCTURE);
			try {
				MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 CompositionValidator.DIAGNOSTIC_SOURCE,
						 CompositionValidator.COMPOSED_STRUCTURE__MULTIPLE_CONNECTORS_CONSTRAINT,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "MultipleConnectorsConstraint", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #MultipleConnectorConstraintForAssembyConnectors(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Multiple Connector Constraint For Assemby Connectors</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MultipleConnectorConstraintForAssembyConnectors(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String MULTIPLE_CONNECTOR_CONSTRAINT_FOR_ASSEMBY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.assemblyConnectors_ComposedStructure->forAll( c1, c2 | c1 <> c2 implies c1.requiredRole__AssemblyConnector <> c2.requiredRole__AssemblyConnector) ";

	/**
	 * The cached OCL invariant for the '{@link #MultipleConnectorConstraintForAssembyConnectors(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Multiple Connector Constraint For Assemby Connectors</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MultipleConnectorConstraintForAssembyConnectors(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint MULTIPLE_CONNECTOR_CONSTRAINT_FOR_ASSEMBY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean MultipleConnectorConstraintForAssembyConnectors(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (MULTIPLE_CONNECTOR_CONSTRAINT_FOR_ASSEMBY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(CompositionPackage.Literals.COMPOSED_STRUCTURE);
			try {
				MULTIPLE_CONNECTOR_CONSTRAINT_FOR_ASSEMBY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(MULTIPLE_CONNECTOR_CONSTRAINT_FOR_ASSEMBY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(MULTIPLE_CONNECTOR_CONSTRAINT_FOR_ASSEMBY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 CompositionValidator.DIAGNOSTIC_SOURCE,
						 CompositionValidator.COMPOSED_STRUCTURE__MULTIPLE_CONNECTOR_CONSTRAINT_FOR_ASSEMBY_CONNECTORS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "MultipleConnectorConstraintForAssembyConnectors", EObjectValidator.getObjectLabel(this, context) }),
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssemblyContexts_ComposedStructure()).basicAdd(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssemblyConnectors_ComposedStructure()).basicAdd(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredDelegationConnectors_ComposedStructure()).basicAdd(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResourceRequiredDelegationConnectors_ComposedStructure()).basicAdd(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_EVENT_CONNECTOR_COMPOSED_STRUCTURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssemblyEventConnector__ComposedStructure()).basicAdd(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__SINK_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSinkDelegationConnectors__ComposedStructure()).basicAdd(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__SOURCE_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSourceDelegationConnectors__ComposedStructure()).basicAdd(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProvidedDelegationConnectors_ComposedStructure()).basicAdd(otherEnd, msgs);
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
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
				return ((InternalEList<?>)getAssemblyContexts_ComposedStructure()).basicRemove(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<?>)getAssemblyConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<?>)getRequiredDelegationConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<?>)getResourceRequiredDelegationConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_EVENT_CONNECTOR_COMPOSED_STRUCTURE:
				return ((InternalEList<?>)getAssemblyEventConnector__ComposedStructure()).basicRemove(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__SINK_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<?>)getSinkDelegationConnectors__ComposedStructure()).basicRemove(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__SOURCE_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<?>)getSourceDelegationConnectors__ComposedStructure()).basicRemove(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<?>)getProvidedDelegationConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
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
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
				return getAssemblyContexts_ComposedStructure();
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return getAssemblyConnectors_ComposedStructure();
			case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return getRequiredDelegationConnectors_ComposedStructure();
			case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return getResourceRequiredDelegationConnectors_ComposedStructure();
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_EVENT_CONNECTOR_COMPOSED_STRUCTURE:
				return getAssemblyEventConnector__ComposedStructure();
			case CompositionPackage.COMPOSED_STRUCTURE__SINK_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return getSinkDelegationConnectors__ComposedStructure();
			case CompositionPackage.COMPOSED_STRUCTURE__SOURCE_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return getSourceDelegationConnectors__ComposedStructure();
			case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return getProvidedDelegationConnectors_ComposedStructure();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
				getAssemblyContexts_ComposedStructure().clear();
				getAssemblyContexts_ComposedStructure().addAll((Collection<? extends AssemblyContext>)newValue);
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				getAssemblyConnectors_ComposedStructure().clear();
				getAssemblyConnectors_ComposedStructure().addAll((Collection<? extends AssemblyConnector>)newValue);
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getRequiredDelegationConnectors_ComposedStructure().clear();
				getRequiredDelegationConnectors_ComposedStructure().addAll((Collection<? extends RequiredDelegationConnector>)newValue);
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getResourceRequiredDelegationConnectors_ComposedStructure().clear();
				getResourceRequiredDelegationConnectors_ComposedStructure().addAll((Collection<? extends ResourceRequiredDelegationConnector>)newValue);
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_EVENT_CONNECTOR_COMPOSED_STRUCTURE:
				getAssemblyEventConnector__ComposedStructure().clear();
				getAssemblyEventConnector__ComposedStructure().addAll((Collection<? extends AssemblyEventConnector>)newValue);
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__SINK_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getSinkDelegationConnectors__ComposedStructure().clear();
				getSinkDelegationConnectors__ComposedStructure().addAll((Collection<? extends SinkDelegationConnector>)newValue);
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__SOURCE_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getSourceDelegationConnectors__ComposedStructure().clear();
				getSourceDelegationConnectors__ComposedStructure().addAll((Collection<? extends SourceDelegationConnector>)newValue);
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getProvidedDelegationConnectors_ComposedStructure().clear();
				getProvidedDelegationConnectors_ComposedStructure().addAll((Collection<? extends ProvidedDelegationConnector>)newValue);
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
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
				getAssemblyContexts_ComposedStructure().clear();
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				getAssemblyConnectors_ComposedStructure().clear();
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getRequiredDelegationConnectors_ComposedStructure().clear();
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getResourceRequiredDelegationConnectors_ComposedStructure().clear();
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_EVENT_CONNECTOR_COMPOSED_STRUCTURE:
				getAssemblyEventConnector__ComposedStructure().clear();
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__SINK_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getSinkDelegationConnectors__ComposedStructure().clear();
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__SOURCE_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getSourceDelegationConnectors__ComposedStructure().clear();
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getProvidedDelegationConnectors_ComposedStructure().clear();
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
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
				return assemblyContexts_ComposedStructure != null && !assemblyContexts_ComposedStructure.isEmpty();
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return assemblyConnectors_ComposedStructure != null && !assemblyConnectors_ComposedStructure.isEmpty();
			case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return requiredDelegationConnectors_ComposedStructure != null && !requiredDelegationConnectors_ComposedStructure.isEmpty();
			case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return resourceRequiredDelegationConnectors_ComposedStructure != null && !resourceRequiredDelegationConnectors_ComposedStructure.isEmpty();
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_EVENT_CONNECTOR_COMPOSED_STRUCTURE:
				return assemblyEventConnector__ComposedStructure != null && !assemblyEventConnector__ComposedStructure.isEmpty();
			case CompositionPackage.COMPOSED_STRUCTURE__SINK_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return sinkDelegationConnectors__ComposedStructure != null && !sinkDelegationConnectors__ComposedStructure.isEmpty();
			case CompositionPackage.COMPOSED_STRUCTURE__SOURCE_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return sourceDelegationConnectors__ComposedStructure != null && !sourceDelegationConnectors__ComposedStructure.isEmpty();
			case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return providedDelegationConnectors_ComposedStructure != null && !providedDelegationConnectors_ComposedStructure.isEmpty();
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

} //ComposedStructureImpl
