
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
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;

import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;

import de.uka.ipd.sdq.pcm.repository.RequiredRole;

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
 * An implementation of the model object '<em><b>Required Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredDelegationConnectorImpl#getInnerRequiredRole_RequiredDelegationConnector <em>Inner Required Role Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredDelegationConnectorImpl#getOuterRequiredRole_RequiredDelegationConnector <em>Outer Required Role Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredDelegationConnectorImpl#getChildComponentContext_RequiredDelegationConnector <em>Child Component Context Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.RequiredDelegationConnectorImpl#getParentStructure_RequiredDelegationConnector <em>Parent Structure Required Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequiredDelegationConnectorImpl extends DelegationConnectorImpl implements RequiredDelegationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getInnerRequiredRole_RequiredDelegationConnector() <em>Inner Required Role Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerRequiredRole_RequiredDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected RequiredRole innerRequiredRole_RequiredDelegationConnector = null;

	/**
	 * The cached value of the '{@link #getOuterRequiredRole_RequiredDelegationConnector() <em>Outer Required Role Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterRequiredRole_RequiredDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected RequiredRole outerRequiredRole_RequiredDelegationConnector = null;

	/**
	 * The cached value of the '{@link #getChildComponentContext_RequiredDelegationConnector() <em>Child Component Context Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildComponentContext_RequiredDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext childComponentContext_RequiredDelegationConnector = null;


	/**
	 * The parsed OCL expression for the definition of the '{@link #InnerContainingComponentEqualOuterRequiringComponent <em>Inner Containing Component Equal Outer Requiring Component</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #InnerContainingComponentEqualOuterRequiringComponent
	 * @generated
	 */
	private static OCLExpression InnerContainingComponentEqualOuterRequiringComponentInvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequiredDelegationConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.REQUIRED_DELEGATION_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredRole getInnerRequiredRole_RequiredDelegationConnector() {
		if (innerRequiredRole_RequiredDelegationConnector != null && innerRequiredRole_RequiredDelegationConnector.eIsProxy()) {
			InternalEObject oldInnerRequiredRole_RequiredDelegationConnector = (InternalEObject)innerRequiredRole_RequiredDelegationConnector;
			innerRequiredRole_RequiredDelegationConnector = (RequiredRole)eResolveProxy(oldInnerRequiredRole_RequiredDelegationConnector);
			if (innerRequiredRole_RequiredDelegationConnector != oldInnerRequiredRole_RequiredDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR, oldInnerRequiredRole_RequiredDelegationConnector, innerRequiredRole_RequiredDelegationConnector));
			}
		}
		return innerRequiredRole_RequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredRole basicGetInnerRequiredRole_RequiredDelegationConnector() {
		return innerRequiredRole_RequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerRequiredRole_RequiredDelegationConnector(RequiredRole newInnerRequiredRole_RequiredDelegationConnector) {
		RequiredRole oldInnerRequiredRole_RequiredDelegationConnector = innerRequiredRole_RequiredDelegationConnector;
		innerRequiredRole_RequiredDelegationConnector = newInnerRequiredRole_RequiredDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR, oldInnerRequiredRole_RequiredDelegationConnector, innerRequiredRole_RequiredDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredRole getOuterRequiredRole_RequiredDelegationConnector() {
		if (outerRequiredRole_RequiredDelegationConnector != null && outerRequiredRole_RequiredDelegationConnector.eIsProxy()) {
			InternalEObject oldOuterRequiredRole_RequiredDelegationConnector = (InternalEObject)outerRequiredRole_RequiredDelegationConnector;
			outerRequiredRole_RequiredDelegationConnector = (RequiredRole)eResolveProxy(oldOuterRequiredRole_RequiredDelegationConnector);
			if (outerRequiredRole_RequiredDelegationConnector != oldOuterRequiredRole_RequiredDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR, oldOuterRequiredRole_RequiredDelegationConnector, outerRequiredRole_RequiredDelegationConnector));
			}
		}
		return outerRequiredRole_RequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredRole basicGetOuterRequiredRole_RequiredDelegationConnector() {
		return outerRequiredRole_RequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterRequiredRole_RequiredDelegationConnector(RequiredRole newOuterRequiredRole_RequiredDelegationConnector) {
		RequiredRole oldOuterRequiredRole_RequiredDelegationConnector = outerRequiredRole_RequiredDelegationConnector;
		outerRequiredRole_RequiredDelegationConnector = newOuterRequiredRole_RequiredDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR, oldOuterRequiredRole_RequiredDelegationConnector, outerRequiredRole_RequiredDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getChildComponentContext_RequiredDelegationConnector() {
		if (childComponentContext_RequiredDelegationConnector != null && childComponentContext_RequiredDelegationConnector.eIsProxy()) {
			InternalEObject oldChildComponentContext_RequiredDelegationConnector = (InternalEObject)childComponentContext_RequiredDelegationConnector;
			childComponentContext_RequiredDelegationConnector = (AssemblyContext)eResolveProxy(oldChildComponentContext_RequiredDelegationConnector);
			if (childComponentContext_RequiredDelegationConnector != oldChildComponentContext_RequiredDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR, oldChildComponentContext_RequiredDelegationConnector, childComponentContext_RequiredDelegationConnector));
			}
		}
		return childComponentContext_RequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetChildComponentContext_RequiredDelegationConnector() {
		return childComponentContext_RequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildComponentContext_RequiredDelegationConnector(AssemblyContext newChildComponentContext_RequiredDelegationConnector) {
		AssemblyContext oldChildComponentContext_RequiredDelegationConnector = childComponentContext_RequiredDelegationConnector;
		childComponentContext_RequiredDelegationConnector = newChildComponentContext_RequiredDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR, oldChildComponentContext_RequiredDelegationConnector, childComponentContext_RequiredDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedStructure getParentStructure_RequiredDelegationConnector() {
		if (eContainerFeatureID != CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR) return null;
		return (ComposedStructure)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStructure_RequiredDelegationConnector(ComposedStructure newParentStructure_RequiredDelegationConnector, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStructure_RequiredDelegationConnector, CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStructure_RequiredDelegationConnector(ComposedStructure newParentStructure_RequiredDelegationConnector) {
		if (newParentStructure_RequiredDelegationConnector != eInternalContainer() || (eContainerFeatureID != CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR && newParentStructure_RequiredDelegationConnector != null)) {
			if (EcoreUtil.isAncestor(this, newParentStructure_RequiredDelegationConnector))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStructure_RequiredDelegationConnector != null)
				msgs = ((InternalEObject)newParentStructure_RequiredDelegationConnector).eInverseAdd(this, CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
			msgs = basicSetParentStructure_RequiredDelegationConnector(newParentStructure_RequiredDelegationConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR, newParentStructure_RequiredDelegationConnector, newParentStructure_RequiredDelegationConnector));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean InnerContainingComponentEqualOuterRequiringComponent(DiagnosticChain diagnostics, Map context) {
		if (InnerContainingComponentEqualOuterRequiringComponentInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.parentStructure_RequiredDelegationConnector = self.childComponentContext_RequiredDelegationConnector ";
			
			try {
				InnerContainingComponentEqualOuterRequiringComponentInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(InnerContainingComponentEqualOuterRequiringComponentInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 CompositionValidator.DIAGNOSTIC_SOURCE,
						 CompositionValidator.REQUIRED_DELEGATION_CONNECTOR__INNER_CONTAINING_COMPONENT_EQUAL_OUTER_REQUIRING_COMPONENT,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "InnerContainingComponentEqualOuterRequiringComponent", EObjectValidator.getObjectLabel(this, context) }),
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
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentStructure_RequiredDelegationConnector((ComposedStructure)otherEnd, msgs);
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
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR:
				return basicSetParentStructure_RequiredDelegationConnector(null, msgs);
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
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR:
				return eInternalContainer().eInverseRemove(this, CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
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
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getInnerRequiredRole_RequiredDelegationConnector();
				return basicGetInnerRequiredRole_RequiredDelegationConnector();
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getOuterRequiredRole_RequiredDelegationConnector();
				return basicGetOuterRequiredRole_RequiredDelegationConnector();
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getChildComponentContext_RequiredDelegationConnector();
				return basicGetChildComponentContext_RequiredDelegationConnector();
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR:
				return getParentStructure_RequiredDelegationConnector();
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
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				setInnerRequiredRole_RequiredDelegationConnector((RequiredRole)newValue);
				return;
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				setOuterRequiredRole_RequiredDelegationConnector((RequiredRole)newValue);
				return;
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
				setChildComponentContext_RequiredDelegationConnector((AssemblyContext)newValue);
				return;
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR:
				setParentStructure_RequiredDelegationConnector((ComposedStructure)newValue);
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
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				setInnerRequiredRole_RequiredDelegationConnector((RequiredRole)null);
				return;
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				setOuterRequiredRole_RequiredDelegationConnector((RequiredRole)null);
				return;
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
				setChildComponentContext_RequiredDelegationConnector((AssemblyContext)null);
				return;
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR:
				setParentStructure_RequiredDelegationConnector((ComposedStructure)null);
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
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				return innerRequiredRole_RequiredDelegationConnector != null;
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				return outerRequiredRole_RequiredDelegationConnector != null;
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
				return childComponentContext_RequiredDelegationConnector != null;
			case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR:
				return getParentStructure_RequiredDelegationConnector() != null;
		}
		return super.eIsSet(featureID);
	}

} //RequiredDelegationConnectorImpl