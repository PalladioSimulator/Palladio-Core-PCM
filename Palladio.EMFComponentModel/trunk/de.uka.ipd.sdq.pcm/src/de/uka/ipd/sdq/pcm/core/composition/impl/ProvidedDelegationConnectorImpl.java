
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;

import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;

import de.uka.ipd.sdq.pcm.repository.impl.DelegationConnectorImpl;

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
 * An implementation of the model object '<em><b>Provided Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl#getInnerProvidedRole_ProvidedDelegationConnector <em>Inner Provided Role Provided Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl#getOuterProvidedRole_ProvidedDelegationConnector <em>Outer Provided Role Provided Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ProvidedDelegationConnectorImpl#getChildComponentContext_ProvidedDelegationConnector <em>Child Component Context Provided Delegation Connector</em>}</li>
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
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getInnerProvidedRole_ProvidedDelegationConnector() <em>Inner Provided Role Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerProvidedRole_ProvidedDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected ProvidedRole innerProvidedRole_ProvidedDelegationConnector = null;

	/**
	 * The cached value of the '{@link #getOuterProvidedRole_ProvidedDelegationConnector() <em>Outer Provided Role Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterProvidedRole_ProvidedDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected ProvidedRole outerProvidedRole_ProvidedDelegationConnector = null;

	/**
	 * The cached value of the '{@link #getChildComponentContext_ProvidedDelegationConnector() <em>Child Component Context Provided Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildComponentContext_ProvidedDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext childComponentContext_ProvidedDelegationConnector = null;


	/**
	 * The parsed OCL expression for the definition of the '{@link #ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure <em>Provided Delegation Connectorandtheconnected Componentmustbepartofthesamecompositestructure</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure
	 * @generated
	 */
	private static OCLExpression ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructureInvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
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
	public AssemblyContext getChildComponentContext_ProvidedDelegationConnector() {
		if (childComponentContext_ProvidedDelegationConnector != null && childComponentContext_ProvidedDelegationConnector.eIsProxy()) {
			InternalEObject oldChildComponentContext_ProvidedDelegationConnector = (InternalEObject)childComponentContext_ProvidedDelegationConnector;
			childComponentContext_ProvidedDelegationConnector = (AssemblyContext)eResolveProxy(oldChildComponentContext_ProvidedDelegationConnector);
			if (childComponentContext_ProvidedDelegationConnector != oldChildComponentContext_ProvidedDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_PROVIDED_DELEGATION_CONNECTOR, oldChildComponentContext_ProvidedDelegationConnector, childComponentContext_ProvidedDelegationConnector));
			}
		}
		return childComponentContext_ProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetChildComponentContext_ProvidedDelegationConnector() {
		return childComponentContext_ProvidedDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildComponentContext_ProvidedDelegationConnector(AssemblyContext newChildComponentContext_ProvidedDelegationConnector) {
		AssemblyContext oldChildComponentContext_ProvidedDelegationConnector = childComponentContext_ProvidedDelegationConnector;
		childComponentContext_ProvidedDelegationConnector = newChildComponentContext_ProvidedDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_PROVIDED_DELEGATION_CONNECTOR, oldChildComponentContext_ProvidedDelegationConnector, childComponentContext_ProvidedDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedStructure getParentStructure_ProvidedDelegationConnector() {
		if (eContainerFeatureID != CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR) return null;
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
		if (newParentStructure_ProvidedDelegationConnector != eInternalContainer() || (eContainerFeatureID != CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR && newParentStructure_ProvidedDelegationConnector != null)) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(DiagnosticChain diagnostics, Map context) {
		if (ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructureInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.parentStructure_ProvidedDelegationConnector = self.childComponentContext_ProvidedDelegationConnector ";
			
			try {
				ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructureInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ProvidedDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructureInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				if (resolve) return getInnerProvidedRole_ProvidedDelegationConnector();
				return basicGetInnerProvidedRole_ProvidedDelegationConnector();
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				if (resolve) return getOuterProvidedRole_ProvidedDelegationConnector();
				return basicGetOuterProvidedRole_ProvidedDelegationConnector();
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_PROVIDED_DELEGATION_CONNECTOR:
				if (resolve) return getChildComponentContext_ProvidedDelegationConnector();
				return basicGetChildComponentContext_ProvidedDelegationConnector();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				setInnerProvidedRole_ProvidedDelegationConnector((ProvidedRole)newValue);
				return;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				setOuterProvidedRole_ProvidedDelegationConnector((ProvidedRole)newValue);
				return;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_PROVIDED_DELEGATION_CONNECTOR:
				setChildComponentContext_ProvidedDelegationConnector((AssemblyContext)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				setInnerProvidedRole_ProvidedDelegationConnector((ProvidedRole)null);
				return;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				setOuterProvidedRole_ProvidedDelegationConnector((ProvidedRole)null);
				return;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_PROVIDED_DELEGATION_CONNECTOR:
				setChildComponentContext_ProvidedDelegationConnector((AssemblyContext)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				return innerProvidedRole_ProvidedDelegationConnector != null;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR:
				return outerProvidedRole_ProvidedDelegationConnector != null;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_PROVIDED_DELEGATION_CONNECTOR:
				return childComponentContext_ProvidedDelegationConnector != null;
			case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR:
				return getParentStructure_ProvidedDelegationConnector() != null;
		}
		return super.eIsSet(featureID);
	}

} //ProvidedDelegationConnectorImpl