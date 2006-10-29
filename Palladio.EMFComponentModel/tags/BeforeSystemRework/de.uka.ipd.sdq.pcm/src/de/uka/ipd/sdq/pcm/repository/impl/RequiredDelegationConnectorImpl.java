
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.repository.ChildComponentContext;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

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
 * An implementation of the model object '<em><b>Required Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredDelegationConnectorImpl#getInnerRequiredRole_RequiredDelegationConnector <em>Inner Required Role Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredDelegationConnectorImpl#getOuterRequiredRole_RequiredDelegationConnector <em>Outer Required Role Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredDelegationConnectorImpl#getChildComponentContext_RequiredDelegationConnector <em>Child Component Context Required Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequiredDelegationConnectorImpl extends DelegationConnectorImpl implements RequiredDelegationConnector {
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
	protected ChildComponentContext childComponentContext_RequiredDelegationConnector = null;


	/**
	 * The parsed OCL expression for the definition of the '{@link #innerAndOuterRoleNeedToHaveDifferentContextIDs <em>Inner And Outer Role Need To Have Different Context IDs</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #innerAndOuterRoleNeedToHaveDifferentContextIDs
	 * @generated
	 */
	private static OCLExpression innerAndOuterRoleNeedToHaveDifferentContextIDsInvOCL;
	
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
		return RepositoryPackage.Literals.REQUIRED_DELEGATION_CONNECTOR;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR, oldInnerRequiredRole_RequiredDelegationConnector, innerRequiredRole_RequiredDelegationConnector));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR, oldInnerRequiredRole_RequiredDelegationConnector, innerRequiredRole_RequiredDelegationConnector));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR, oldOuterRequiredRole_RequiredDelegationConnector, outerRequiredRole_RequiredDelegationConnector));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR, oldOuterRequiredRole_RequiredDelegationConnector, outerRequiredRole_RequiredDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildComponentContext getChildComponentContext_RequiredDelegationConnector() {
		if (childComponentContext_RequiredDelegationConnector != null && childComponentContext_RequiredDelegationConnector.eIsProxy()) {
			InternalEObject oldChildComponentContext_RequiredDelegationConnector = (InternalEObject)childComponentContext_RequiredDelegationConnector;
			childComponentContext_RequiredDelegationConnector = (ChildComponentContext)eResolveProxy(oldChildComponentContext_RequiredDelegationConnector);
			if (childComponentContext_RequiredDelegationConnector != oldChildComponentContext_RequiredDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR, oldChildComponentContext_RequiredDelegationConnector, childComponentContext_RequiredDelegationConnector));
			}
		}
		return childComponentContext_RequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildComponentContext basicGetChildComponentContext_RequiredDelegationConnector() {
		return childComponentContext_RequiredDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildComponentContext_RequiredDelegationConnector(ChildComponentContext newChildComponentContext_RequiredDelegationConnector) {
		ChildComponentContext oldChildComponentContext_RequiredDelegationConnector = childComponentContext_RequiredDelegationConnector;
		childComponentContext_RequiredDelegationConnector = newChildComponentContext_RequiredDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR, oldChildComponentContext_RequiredDelegationConnector, childComponentContext_RequiredDelegationConnector));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean innerAndOuterRoleNeedToHaveDifferentContextIDs(DiagnosticChain diagnostics, Map context) {
		if (innerAndOuterRoleNeedToHaveDifferentContextIDsInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self->forAll(p1, p2 |  p1.innerRequiringRole.parentContext.identifier.id <> p2.outerRequiringRole.parentContext.identifier.id) ";
			
			try {
				innerAndOuterRoleNeedToHaveDifferentContextIDsInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(innerAndOuterRoleNeedToHaveDifferentContextIDsInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.REQUIRED_DELEGATION_CONNECTOR__INNER_AND_OUTER_ROLE_NEED_TO_HAVE_DIFFERENT_CONTEXT_IDS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "innerAndOuterRoleNeedToHaveDifferentContextIDs", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean InnerContainingComponentEqualOuterRequiringComponent(DiagnosticChain diagnostics, Map context) {
		if (InnerContainingComponentEqualOuterRequiringComponentInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.parentCompositeComponent.identifier.id  =  self.outerRequiringRole.encapsulatedRole.requiringComponent.identifier.id    and    self.parentCompositeComponent.identifier.id  =  self.innerRequiringRole.encapsulatedRole.requiringComponent.identifier.id ";
			
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
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.REQUIRED_DELEGATION_CONNECTOR__INNER_CONTAINING_COMPONENT_EQUAL_OUTER_REQUIRING_COMPONENT,
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getInnerRequiredRole_RequiredDelegationConnector();
				return basicGetInnerRequiredRole_RequiredDelegationConnector();
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getOuterRequiredRole_RequiredDelegationConnector();
				return basicGetOuterRequiredRole_RequiredDelegationConnector();
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
				if (resolve) return getChildComponentContext_RequiredDelegationConnector();
				return basicGetChildComponentContext_RequiredDelegationConnector();
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
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				setInnerRequiredRole_RequiredDelegationConnector((RequiredRole)newValue);
				return;
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				setOuterRequiredRole_RequiredDelegationConnector((RequiredRole)newValue);
				return;
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
				setChildComponentContext_RequiredDelegationConnector((ChildComponentContext)newValue);
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
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				setInnerRequiredRole_RequiredDelegationConnector((RequiredRole)null);
				return;
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				setOuterRequiredRole_RequiredDelegationConnector((RequiredRole)null);
				return;
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
				setChildComponentContext_RequiredDelegationConnector((ChildComponentContext)null);
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
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				return innerRequiredRole_RequiredDelegationConnector != null;
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR:
				return outerRequiredRole_RequiredDelegationConnector != null;
			case RepositoryPackage.REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR:
				return childComponentContext_RequiredDelegationConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //RequiredDelegationConnectorImpl