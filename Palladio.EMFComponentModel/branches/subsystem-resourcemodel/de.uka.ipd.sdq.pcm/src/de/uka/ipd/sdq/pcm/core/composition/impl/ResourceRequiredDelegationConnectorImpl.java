/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector;

import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;
import de.uka.ipd.sdq.pcm.repository.impl.DelegationConnectorImpl;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;

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
	 * The cached value of the '{@link #getInnerResourceRequiredRole_ResourceRequiredDelegationConnector() <em>Inner Resource Required Role Resource Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerResourceRequiredRole_ResourceRequiredDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected ResourceRequiredRole innerResourceRequiredRole_ResourceRequiredDelegationConnector;

	/**
	 * The cached value of the '{@link #getOuterResourceRequiredRole_ResourceRequiredDelegationConnector() <em>Outer Resource Required Role Resource Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterResourceRequiredRole_ResourceRequiredDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected ResourceRequiredRole outerResourceRequiredRole_ResourceRequiredDelegationConnector;

	/**
	 * The cached value of the '{@link #getAssemblyContext_ResourceRequiredDelegationConnector() <em>Assembly Context Resource Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContext_ResourceRequiredDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblyContext_ResourceRequiredDelegationConnector;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructure <em>Resource Required Delegation Connector And The Connected Component Must Be Part Of The Same Composite Structure</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructure
	 * @generated
	 */
	private static OCLExpression ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructureInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSame <em>Component Of Child Component Context And Inner Role Resource Requiring Component Need To Be The Same</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSame
	 * @generated
	 */
	private static OCLExpression ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSameInvOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";

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
		if (eContainerFeatureID != CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR) return null;
		return (ComposedStructure)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStructure_ResourceRequiredDelegationConnector(ComposedStructure newParentStructure_ResourceRequiredDelegationConnector, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStructure_ResourceRequiredDelegationConnector, CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStructure_ResourceRequiredDelegationConnector(ComposedStructure newParentStructure_ResourceRequiredDelegationConnector) {
		if (newParentStructure_ResourceRequiredDelegationConnector != eInternalContainer() || (eContainerFeatureID != CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR && newParentStructure_ResourceRequiredDelegationConnector != null)) {
			if (EcoreUtil.isAncestor(this, newParentStructure_ResourceRequiredDelegationConnector))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStructure_ResourceRequiredDelegationConnector != null)
				msgs = ((InternalEObject)newParentStructure_ResourceRequiredDelegationConnector).eInverseAdd(this, CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
			msgs = basicSetParentStructure_ResourceRequiredDelegationConnector(newParentStructure_ResourceRequiredDelegationConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR, newParentStructure_ResourceRequiredDelegationConnector, newParentStructure_ResourceRequiredDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole getInnerResourceRequiredRole_ResourceRequiredDelegationConnector() {
		if (innerResourceRequiredRole_ResourceRequiredDelegationConnector != null && innerResourceRequiredRole_ResourceRequiredDelegationConnector.eIsProxy()) {
			InternalEObject oldInnerResourceRequiredRole_ResourceRequiredDelegationConnector = (InternalEObject)innerResourceRequiredRole_ResourceRequiredDelegationConnector;
			innerResourceRequiredRole_ResourceRequiredDelegationConnector = (ResourceRequiredRole)eResolveProxy(oldInnerResourceRequiredRole_ResourceRequiredDelegationConnector);
			if (innerResourceRequiredRole_ResourceRequiredDelegationConnector != oldInnerResourceRequiredRole_ResourceRequiredDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR, oldInnerResourceRequiredRole_ResourceRequiredDelegationConnector, innerResourceRequiredRole_ResourceRequiredDelegationConnector));
			}
		}
		return innerResourceRequiredRole_ResourceRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole basicGetInnerResourceRequiredRole_ResourceRequiredDelegationConnector() {
		return innerResourceRequiredRole_ResourceRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerResourceRequiredRole_ResourceRequiredDelegationConnector(ResourceRequiredRole newInnerResourceRequiredRole_ResourceRequiredDelegationConnector) {
		ResourceRequiredRole oldInnerResourceRequiredRole_ResourceRequiredDelegationConnector = innerResourceRequiredRole_ResourceRequiredDelegationConnector;
		innerResourceRequiredRole_ResourceRequiredDelegationConnector = newInnerResourceRequiredRole_ResourceRequiredDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR, oldInnerResourceRequiredRole_ResourceRequiredDelegationConnector, innerResourceRequiredRole_ResourceRequiredDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole getOuterResourceRequiredRole_ResourceRequiredDelegationConnector() {
		if (outerResourceRequiredRole_ResourceRequiredDelegationConnector != null && outerResourceRequiredRole_ResourceRequiredDelegationConnector.eIsProxy()) {
			InternalEObject oldOuterResourceRequiredRole_ResourceRequiredDelegationConnector = (InternalEObject)outerResourceRequiredRole_ResourceRequiredDelegationConnector;
			outerResourceRequiredRole_ResourceRequiredDelegationConnector = (ResourceRequiredRole)eResolveProxy(oldOuterResourceRequiredRole_ResourceRequiredDelegationConnector);
			if (outerResourceRequiredRole_ResourceRequiredDelegationConnector != oldOuterResourceRequiredRole_ResourceRequiredDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR, oldOuterResourceRequiredRole_ResourceRequiredDelegationConnector, outerResourceRequiredRole_ResourceRequiredDelegationConnector));
			}
		}
		return outerResourceRequiredRole_ResourceRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole basicGetOuterResourceRequiredRole_ResourceRequiredDelegationConnector() {
		return outerResourceRequiredRole_ResourceRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterResourceRequiredRole_ResourceRequiredDelegationConnector(ResourceRequiredRole newOuterResourceRequiredRole_ResourceRequiredDelegationConnector) {
		ResourceRequiredRole oldOuterResourceRequiredRole_ResourceRequiredDelegationConnector = outerResourceRequiredRole_ResourceRequiredDelegationConnector;
		outerResourceRequiredRole_ResourceRequiredDelegationConnector = newOuterResourceRequiredRole_ResourceRequiredDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR, oldOuterResourceRequiredRole_ResourceRequiredDelegationConnector, outerResourceRequiredRole_ResourceRequiredDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext_ResourceRequiredDelegationConnector() {
		if (assemblyContext_ResourceRequiredDelegationConnector != null && assemblyContext_ResourceRequiredDelegationConnector.eIsProxy()) {
			InternalEObject oldAssemblyContext_ResourceRequiredDelegationConnector = (InternalEObject)assemblyContext_ResourceRequiredDelegationConnector;
			assemblyContext_ResourceRequiredDelegationConnector = (AssemblyContext)eResolveProxy(oldAssemblyContext_ResourceRequiredDelegationConnector);
			if (assemblyContext_ResourceRequiredDelegationConnector != oldAssemblyContext_ResourceRequiredDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_RESOURCE_REQUIRED_DELEGATION_CONNECTOR, oldAssemblyContext_ResourceRequiredDelegationConnector, assemblyContext_ResourceRequiredDelegationConnector));
			}
		}
		return assemblyContext_ResourceRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext_ResourceRequiredDelegationConnector() {
		return assemblyContext_ResourceRequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext_ResourceRequiredDelegationConnector(AssemblyContext newAssemblyContext_ResourceRequiredDelegationConnector) {
		AssemblyContext oldAssemblyContext_ResourceRequiredDelegationConnector = assemblyContext_ResourceRequiredDelegationConnector;
		assemblyContext_ResourceRequiredDelegationConnector = newAssemblyContext_ResourceRequiredDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_RESOURCE_REQUIRED_DELEGATION_CONNECTOR, oldAssemblyContext_ResourceRequiredDelegationConnector, assemblyContext_ResourceRequiredDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructure(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructureInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.parentStructure_ResourceRequiredDelegationConnector = self.assemblyContext_ResourceRequiredDelegationConnector.parentStructure_AssemblyContext ";
			
			try {
				ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructureInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructureInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 CompositionValidator.DIAGNOSTIC_SOURCE,
						 CompositionValidator.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__RESOURCE_REQUIRED_DELEGATION_CONNECTOR_AND_THE_CONNECTED_COMPONENT_MUST_BE_PART_OF_THE_SAME_COMPOSITE_STRUCTURE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ResourceRequiredDelegationConnectorAndTheConnectedComponentMustBePartOfTheSameCompositeStructure", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSame(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSameInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.innerResourceRequiredRole_ResourceRequiredDelegationConnector.resourceRequiringEntity_ResourceRequiredRole = self.assemblyContext_ResourceRequiredDelegationConnector.encapsulatedComponent_AssemblyContext ";
			
			try {
				ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSameInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSameInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 CompositionValidator.DIAGNOSTIC_SOURCE,
						 CompositionValidator.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__COMPONENT_OF_CHILD_COMPONENT_CONTEXT_AND_INNER_ROLE_RESOURCE_REQUIRING_COMPONENT_NEED_TO_BE_THE_SAME,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ComponentOfChildComponentContextAndInnerRoleResourceRequiringComponentNeedToBeTheSame", EObjectValidator.getObjectLabel(this, context) }),
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
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentStructure_ResourceRequiredDelegationConnector((ComposedStructure)otherEnd, msgs);
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
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				return basicSetParentStructure_ResourceRequiredDelegationConnector(null, msgs);
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
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				return eInternalContainer().eInverseRemove(this, CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
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
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				return getParentStructure_ResourceRequiredDelegationConnector();
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
				return getParentStructure_ResourceRequiredDelegationConnector() != null;
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__INNER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				return innerResourceRequiredRole_ResourceRequiredDelegationConnector != null;
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__OUTER_RESOURCE_REQUIRED_ROLE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				return outerResourceRequiredRole_ResourceRequiredDelegationConnector != null;
			case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
				return assemblyContext_ResourceRequiredDelegationConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceRequiredDelegationConnectorImpl
