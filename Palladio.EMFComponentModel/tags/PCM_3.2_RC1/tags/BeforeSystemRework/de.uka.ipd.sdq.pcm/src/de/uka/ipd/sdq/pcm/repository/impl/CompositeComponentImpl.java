
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.repository.ChildComponentContext;
import de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredDelegationConnector;

import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.OCLExpression;

import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;

import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getProvidedDelegationConnectors__CompositeComponent <em>Provided Delegation Connectors Composite Component</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getRequiredDelegationConnectors__CompositeComponent <em>Required Delegation Connectors Composite Component</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getImplementationComponentType <em>Implementation Component Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getChildComponentContexts_CompositeComponent <em>Child Component Contexts Composite Component</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getCompositeAssemblyConnectors_CompositeComponent <em>Composite Assembly Connectors Composite Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeComponentImpl extends ImplementationComponentTypeImpl implements CompositeComponent {
	/**
	 * The cached value of the '{@link #getProvidedDelegationConnectors__CompositeComponent() <em>Provided Delegation Connectors Composite Component</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedDelegationConnectors__CompositeComponent()
	 * @generated
	 * @ordered
	 */
	protected EList providedDelegationConnectors__CompositeComponent = null;

	/**
	 * The cached value of the '{@link #getRequiredDelegationConnectors__CompositeComponent() <em>Required Delegation Connectors Composite Component</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredDelegationConnectors__CompositeComponent()
	 * @generated
	 * @ordered
	 */
	protected EList requiredDelegationConnectors__CompositeComponent = null;

	/**
	 * The cached value of the '{@link #getImplementationComponentType() <em>Implementation Component Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationComponentType()
	 * @generated
	 * @ordered
	 */
	protected ImplementationComponentType implementationComponentType = null;

	/**
	 * The cached value of the '{@link #getChildComponentContexts_CompositeComponent() <em>Child Component Contexts Composite Component</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildComponentContexts_CompositeComponent()
	 * @generated
	 * @ordered
	 */
	protected EList childComponentContexts_CompositeComponent = null;

	/**
	 * The cached value of the '{@link #getCompositeAssemblyConnectors_CompositeComponent() <em>Composite Assembly Connectors Composite Component</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeAssemblyConnectors_CompositeComponent()
	 * @generated
	 * @ordered
	 */
	protected EList compositeAssemblyConnectors_CompositeComponent = null;


	/**
	 * The parsed OCL expression for the definition of the '{@link #ProvideSameInterfaces <em>Provide Same Interfaces</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ProvideSameInterfaces
	 * @generated
	 */
	private static OCLExpression ProvideSameInterfacesInvOCL;
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #RequireSameInterfaces <em>Require Same Interfaces</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RequireSameInterfaces
	 * @generated
	 */
	private static OCLExpression RequireSameInterfacesInvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.COMPOSITE_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getProvidedDelegationConnectors__CompositeComponent() {
		if (providedDelegationConnectors__CompositeComponent == null) {
			providedDelegationConnectors__CompositeComponent = new EObjectContainmentEList(ProvidedDelegationConnector.class, this, RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT);
		}
		return providedDelegationConnectors__CompositeComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRequiredDelegationConnectors__CompositeComponent() {
		if (requiredDelegationConnectors__CompositeComponent == null) {
			requiredDelegationConnectors__CompositeComponent = new EObjectContainmentEList(RequiredDelegationConnector.class, this, RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT);
		}
		return requiredDelegationConnectors__CompositeComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationComponentType getImplementationComponentType() {
		if (implementationComponentType != null && implementationComponentType.eIsProxy()) {
			InternalEObject oldImplementationComponentType = (InternalEObject)implementationComponentType;
			implementationComponentType = (ImplementationComponentType)eResolveProxy(oldImplementationComponentType);
			if (implementationComponentType != oldImplementationComponentType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE, oldImplementationComponentType, implementationComponentType));
			}
		}
		return implementationComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationComponentType basicGetImplementationComponentType() {
		return implementationComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationComponentType(ImplementationComponentType newImplementationComponentType) {
		ImplementationComponentType oldImplementationComponentType = implementationComponentType;
		implementationComponentType = newImplementationComponentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE, oldImplementationComponentType, implementationComponentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getChildComponentContexts_CompositeComponent() {
		if (childComponentContexts_CompositeComponent == null) {
			childComponentContexts_CompositeComponent = new EObjectContainmentEList(ChildComponentContext.class, this, RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSITE_COMPONENT);
		}
		return childComponentContexts_CompositeComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCompositeAssemblyConnectors_CompositeComponent() {
		if (compositeAssemblyConnectors_CompositeComponent == null) {
			compositeAssemblyConnectors_CompositeComponent = new EObjectContainmentEList(CompositeAssemblyConnector.class, this, RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSITE_COMPONENT);
		}
		return compositeAssemblyConnectors_CompositeComponent;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ProvideSameInterfaces(DiagnosticChain diagnostics, Map context) {
		if (ProvideSameInterfacesInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = " self.providedRoles->iterate(pr : ProvidedRole; acc1 : Bag(String) = Bag{} |   acc1->union(pr.providedInterface.identifier.id->asBag())  )  =  if      self.implementationComponentType->notEmpty()  then   self.implementationComponentType.providedRoles->iterate(pr : ProvidedRole; acc2 : Bag(String) = Bag{} |    acc2->union(pr.providedInterface.identifier.id->asBag())   )  else   Bag{}  endif ";
			
			try {
				ProvideSameInterfacesInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ProvideSameInterfacesInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.COMPOSITE_COMPONENT__PROVIDE_SAME_INTERFACES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ProvideSameInterfaces", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean RequireSameInterfaces(DiagnosticChain diagnostics, Map context) {
		if (RequireSameInterfacesInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = " self.requiredRoles->iterate(pr : RequiredRole; acc1 : Bag(String) = Bag{} |   acc1->union(pr.requiredInterface.identifier.id->asBag())  )  =  if      self.implementationComponentType->notEmpty()  then   self.implementationComponentType.requiredRoles->iterate(pr : RequiredRole; acc2 : Bag(String) = Bag{} |    acc2->union(pr.requiredInterface.identifier.id->asBag())   )  else   Bag{}  endif ";
			
			try {
				RequireSameInterfacesInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(RequireSameInterfacesInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.COMPOSITE_COMPONENT__REQUIRE_SAME_INTERFACES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "RequireSameInterfaces", EObjectValidator.getObjectLabel(this, context) }),
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT:
				return ((InternalEList)getProvidedDelegationConnectors__CompositeComponent()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT:
				return ((InternalEList)getRequiredDelegationConnectors__CompositeComponent()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSITE_COMPONENT:
				return ((InternalEList)getChildComponentContexts_CompositeComponent()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSITE_COMPONENT:
				return ((InternalEList)getCompositeAssemblyConnectors_CompositeComponent()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT:
				return getProvidedDelegationConnectors__CompositeComponent();
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT:
				return getRequiredDelegationConnectors__CompositeComponent();
			case RepositoryPackage.COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE:
				if (resolve) return getImplementationComponentType();
				return basicGetImplementationComponentType();
			case RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSITE_COMPONENT:
				return getChildComponentContexts_CompositeComponent();
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSITE_COMPONENT:
				return getCompositeAssemblyConnectors_CompositeComponent();
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
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT:
				getProvidedDelegationConnectors__CompositeComponent().clear();
				getProvidedDelegationConnectors__CompositeComponent().addAll((Collection)newValue);
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT:
				getRequiredDelegationConnectors__CompositeComponent().clear();
				getRequiredDelegationConnectors__CompositeComponent().addAll((Collection)newValue);
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE:
				setImplementationComponentType((ImplementationComponentType)newValue);
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSITE_COMPONENT:
				getChildComponentContexts_CompositeComponent().clear();
				getChildComponentContexts_CompositeComponent().addAll((Collection)newValue);
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSITE_COMPONENT:
				getCompositeAssemblyConnectors_CompositeComponent().clear();
				getCompositeAssemblyConnectors_CompositeComponent().addAll((Collection)newValue);
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
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT:
				getProvidedDelegationConnectors__CompositeComponent().clear();
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT:
				getRequiredDelegationConnectors__CompositeComponent().clear();
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE:
				setImplementationComponentType((ImplementationComponentType)null);
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSITE_COMPONENT:
				getChildComponentContexts_CompositeComponent().clear();
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSITE_COMPONENT:
				getCompositeAssemblyConnectors_CompositeComponent().clear();
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
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT:
				return providedDelegationConnectors__CompositeComponent != null && !providedDelegationConnectors__CompositeComponent.isEmpty();
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT:
				return requiredDelegationConnectors__CompositeComponent != null && !requiredDelegationConnectors__CompositeComponent.isEmpty();
			case RepositoryPackage.COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE:
				return implementationComponentType != null;
			case RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSITE_COMPONENT:
				return childComponentContexts_CompositeComponent != null && !childComponentContexts_CompositeComponent.isEmpty();
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSITE_COMPONENT:
				return compositeAssemblyConnectors_CompositeComponent != null && !compositeAssemblyConnectors_CompositeComponent.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeComponentImpl