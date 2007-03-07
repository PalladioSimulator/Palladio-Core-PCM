
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;

import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
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
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getChildComponentContexts_ComposedStructure <em>Child Component Contexts Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getProvidedDelegationConnectors_ComposedStructure <em>Provided Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getRequiredDelegationConnectors_ComposedStructure <em>Required Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getCompositeAssemblyConnectors_ComposedStructure <em>Composite Assembly Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getImplementationComponentType <em>Implementation Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeComponentImpl extends ImplementationComponentTypeImpl implements CompositeComponent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getChildComponentContexts_ComposedStructure() <em>Child Component Contexts Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildComponentContexts_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList childComponentContexts_ComposedStructure = null;

	/**
	 * The cached value of the '{@link #getProvidedDelegationConnectors_ComposedStructure() <em>Provided Delegation Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedDelegationConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList providedDelegationConnectors_ComposedStructure = null;

	/**
	 * The cached value of the '{@link #getRequiredDelegationConnectors_ComposedStructure() <em>Required Delegation Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredDelegationConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList requiredDelegationConnectors_ComposedStructure = null;

	/**
	 * The cached value of the '{@link #getCompositeAssemblyConnectors_ComposedStructure() <em>Composite Assembly Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeAssemblyConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList compositeAssemblyConnectors_ComposedStructure = null;

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
	public EList getChildComponentContexts_ComposedStructure() {
		if (childComponentContexts_ComposedStructure == null) {
			childComponentContexts_ComposedStructure = new EObjectContainmentWithInverseEList(AssemblyContext.class, this, RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE, CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT);
		}
		return childComponentContexts_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getProvidedDelegationConnectors_ComposedStructure() {
		if (providedDelegationConnectors_ComposedStructure == null) {
			providedDelegationConnectors_ComposedStructure = new EObjectContainmentWithInverseEList(ProvidedDelegationConnector.class, this, RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR);
		}
		return providedDelegationConnectors_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRequiredDelegationConnectors_ComposedStructure() {
		if (requiredDelegationConnectors_ComposedStructure == null) {
			requiredDelegationConnectors_ComposedStructure = new EObjectContainmentWithInverseEList(RequiredDelegationConnector.class, this, RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR);
		}
		return requiredDelegationConnectors_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCompositeAssemblyConnectors_ComposedStructure() {
		if (compositeAssemblyConnectors_ComposedStructure == null) {
			compositeAssemblyConnectors_ComposedStructure = new EObjectContainmentWithInverseEList(AssemblyConnector.class, this, RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE, CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR);
		}
		return compositeAssemblyConnectors_ComposedStructure;
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
	public boolean ProvideSameInterfaces(DiagnosticChain diagnostics, Map context) {
		if (ProvideSameInterfacesInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = " self.providedRoles_InterfaceProvidingEntity->iterate(pr : ProvidedRole; acc1 : Bag(String) = Bag{} |   acc1->union(pr.providedInterface__ProvidedRole.id->asBag())  )  =  if      self.implementationComponentType->notEmpty()  then   self.implementationComponentType.providedRoles_InterfaceProvidingEntity->iterate(pr : ProvidedRole; acc2 : Bag(String) = Bag{} |    acc2->union(pr.providedInterface__ProvidedRole.id->asBag())   )  else   Bag{}  endif ";
			
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
			
			
			String body = " self.requiredRoles_InterfaceRequiringEntity->iterate(pr : RequiredRole; acc1 : Bag(String) = Bag{} |   acc1->union(pr.requiredInterface__RequiredRole.id->asBag())  )  =  if      self.implementationComponentType->notEmpty()  then   self.implementationComponentType.requiredRoles_InterfaceRequiringEntity->iterate(pr : RequiredRole; acc2 : Bag(String) = Bag{} |    acc2->union(pr.requiredInterface__RequiredRole.id->asBag())   )  else   Bag{}  endif ";
			
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				return ((InternalEList)getChildComponentContexts_ComposedStructure()).basicAdd(otherEnd, msgs);
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList)getProvidedDelegationConnectors_ComposedStructure()).basicAdd(otherEnd, msgs);
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList)getRequiredDelegationConnectors_ComposedStructure()).basicAdd(otherEnd, msgs);
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList)getCompositeAssemblyConnectors_ComposedStructure()).basicAdd(otherEnd, msgs);
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
			case RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				return ((InternalEList)getChildComponentContexts_ComposedStructure()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList)getProvidedDelegationConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList)getRequiredDelegationConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList)getCompositeAssemblyConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
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
			case RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				return getChildComponentContexts_ComposedStructure();
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return getProvidedDelegationConnectors_ComposedStructure();
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return getRequiredDelegationConnectors_ComposedStructure();
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return getCompositeAssemblyConnectors_ComposedStructure();
			case RepositoryPackage.COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE:
				if (resolve) return getImplementationComponentType();
				return basicGetImplementationComponentType();
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
			case RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				getChildComponentContexts_ComposedStructure().clear();
				getChildComponentContexts_ComposedStructure().addAll((Collection)newValue);
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getProvidedDelegationConnectors_ComposedStructure().clear();
				getProvidedDelegationConnectors_ComposedStructure().addAll((Collection)newValue);
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getRequiredDelegationConnectors_ComposedStructure().clear();
				getRequiredDelegationConnectors_ComposedStructure().addAll((Collection)newValue);
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				getCompositeAssemblyConnectors_ComposedStructure().clear();
				getCompositeAssemblyConnectors_ComposedStructure().addAll((Collection)newValue);
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE:
				setImplementationComponentType((ImplementationComponentType)newValue);
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
			case RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				getChildComponentContexts_ComposedStructure().clear();
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getProvidedDelegationConnectors_ComposedStructure().clear();
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getRequiredDelegationConnectors_ComposedStructure().clear();
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				getCompositeAssemblyConnectors_ComposedStructure().clear();
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE:
				setImplementationComponentType((ImplementationComponentType)null);
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
			case RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				return childComponentContexts_ComposedStructure != null && !childComponentContexts_ComposedStructure.isEmpty();
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return providedDelegationConnectors_ComposedStructure != null && !providedDelegationConnectors_ComposedStructure.isEmpty();
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return requiredDelegationConnectors_ComposedStructure != null && !requiredDelegationConnectors_ComposedStructure.isEmpty();
			case RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return compositeAssemblyConnectors_ComposedStructure != null && !compositeAssemblyConnectors_ComposedStructure.isEmpty();
			case RepositoryPackage.COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE:
				return implementationComponentType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == ComposedStructure.class) {
			switch (derivedFeatureID) {
				case RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE: return CompositionPackage.COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE;
				case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE: return CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;
				case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE: return CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;
				case RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE: return CompositionPackage.COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == ComposedStructure.class) {
			switch (baseFeatureID) {
				case CompositionPackage.COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE: return RepositoryPackage.COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE;
				case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE: return RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;
				case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE: return RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;
				case CompositionPackage.COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE: return RepositoryPackage.COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CompositeComponentImpl