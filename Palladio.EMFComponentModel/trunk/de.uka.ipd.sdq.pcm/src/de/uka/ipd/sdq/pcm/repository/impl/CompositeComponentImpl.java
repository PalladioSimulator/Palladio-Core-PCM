
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;

import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
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

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getProvidedRoles_InterfaceProvidingEntity <em>Provided Roles Interface Providing Entity</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getRequiredRoles_InterfaceRequiringEntity <em>Required Roles Interface Requiring Entity</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getParentProvidesComponentTypes <em>Parent Provides Component Types</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getParentCompleteComponentTypes <em>Parent Complete Component Types</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeComponentImpl#getImplementationComponentType <em>Implementation Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeComponentImpl extends ComposedStructureImpl implements CompositeComponent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getProvidedRoles_InterfaceProvidingEntity() <em>Provided Roles Interface Providing Entity</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedRoles_InterfaceProvidingEntity()
	 * @generated
	 * @ordered
	 */
	protected EList providedRoles_InterfaceProvidingEntity = null;

	/**
	 * The cached value of the '{@link #getRequiredRoles_InterfaceRequiringEntity() <em>Required Roles Interface Requiring Entity</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredRoles_InterfaceRequiringEntity()
	 * @generated
	 * @ordered
	 */
	protected EList requiredRoles_InterfaceRequiringEntity = null;

	/**
	 * The cached value of the '{@link #getParentProvidesComponentTypes() <em>Parent Provides Component Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentProvidesComponentTypes()
	 * @generated
	 * @ordered
	 */
	protected EList parentProvidesComponentTypes = null;

	/**
	 * The cached value of the '{@link #getParentCompleteComponentTypes() <em>Parent Complete Component Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentCompleteComponentTypes()
	 * @generated
	 * @ordered
	 */
	protected EList parentCompleteComponentTypes = null;

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
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #RequiredInterfacesHaveToConformToCompleteType <em>Required Interfaces Have To Conform To Complete Type</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RequiredInterfacesHaveToConformToCompleteType
	 * @generated
	 */
	private static OCLExpression RequiredInterfacesHaveToConformToCompleteTypeInvOCL;
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #providedInterfacesHaveToConformToCompleteType <em>Provided Interfaces Have To Conform To Complete Type</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #providedInterfacesHaveToConformToCompleteType
	 * @generated
	 */
	private static OCLExpression providedInterfacesHaveToConformToCompleteTypeInvOCL;
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType <em>At Least One Interface Has To Be Provided Or Required By AUsefull Complete Component Type</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType
	 * @generated
	 */
	private static OCLExpression AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentTypeInvOCL;
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #providedInterfacesHaveToConformToProvidedType2 <em>Provided Interfaces Have To Conform To Provided Type2</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #providedInterfacesHaveToConformToProvidedType2
	 * @generated
	 */
	private static OCLExpression providedInterfacesHaveToConformToProvidedType2InvOCL;
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType <em>At Least One Interface Has To Be Provided By AUsefull Provides Component Type</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType
	 * @generated
	 */
	private static OCLExpression AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentTypeInvOCL;
	
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
	public EList getProvidedRoles_InterfaceProvidingEntity() {
		if (providedRoles_InterfaceProvidingEntity == null) {
			providedRoles_InterfaceProvidingEntity = new EObjectContainmentEList(ProvidedRole.class, this, RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY);
		}
		return providedRoles_InterfaceProvidingEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRequiredRoles_InterfaceRequiringEntity() {
		if (requiredRoles_InterfaceRequiringEntity == null) {
			requiredRoles_InterfaceRequiringEntity = new EObjectContainmentEList(RequiredRole.class, this, RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY);
		}
		return requiredRoles_InterfaceRequiringEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParentProvidesComponentTypes() {
		if (parentProvidesComponentTypes == null) {
			parentProvidesComponentTypes = new EObjectResolvingEList(ProvidesComponentType.class, this, RepositoryPackage.COMPOSITE_COMPONENT__PARENT_PROVIDES_COMPONENT_TYPES);
		}
		return parentProvidesComponentTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParentCompleteComponentTypes() {
		if (parentCompleteComponentTypes == null) {
			parentCompleteComponentTypes = new EObjectResolvingEList(CompleteComponentType.class, this, RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES);
		}
		return parentCompleteComponentTypes;
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
	public boolean RequiredInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics, Map context) {
		if (RequiredInterfacesHaveToConformToCompleteTypeInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "                               true ";
			
			try {
				RequiredInterfacesHaveToConformToCompleteTypeInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(RequiredInterfacesHaveToConformToCompleteTypeInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "RequiredInterfacesHaveToConformToCompleteType", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean providedInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics, Map context) {
		if (providedInterfacesHaveToConformToCompleteTypeInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "                             true ";
			
			try {
				providedInterfacesHaveToConformToCompleteTypeInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(providedInterfacesHaveToConformToCompleteTypeInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "providedInterfacesHaveToConformToCompleteType", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(DiagnosticChain diagnostics, Map context) {
		if (AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentTypeInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "(   self.oclIsTypeOf(CompleteComponentType)   or   self.oclIsTypeOf(ImplementationComponentType)   or   self.oclIsTypeOf(CompositeComponent)   or   self.oclIsTypeOf(BasicComponent)  )  implies  (   self.providedRoles_InterfaceProvidingEntity->size() >= 1   or   self.requiredRoles_InterfaceRequiringEntity->size() >= 1  ) ";
			
			try {
				AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentTypeInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentTypeInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.COMPLETE_COMPONENT_TYPE__AT_LEAST_ONE_INTERFACE_HAS_TO_BE_PROVIDED_OR_REQUIRED_BY_AUSEFULL_COMPLETE_COMPONENT_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean providedInterfacesHaveToConformToProvidedType2(DiagnosticChain diagnostics, Map context) {
		if (providedInterfacesHaveToConformToProvidedType2InvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "                           true ";
			
			try {
				providedInterfacesHaveToConformToProvidedType2InvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(providedInterfacesHaveToConformToProvidedType2InvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.COMPLETE_COMPONENT_TYPE__PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_PROVIDED_TYPE2,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "providedInterfacesHaveToConformToProvidedType2", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(DiagnosticChain diagnostics, Map context) {
		if (AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentTypeInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.oclIsTypeOf(ProvidesComponentType)  implies  self.providedRoles_InterfaceProvidingEntity->size() >= 1 ";
			
			try {
				AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentTypeInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentTypeInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.PROVIDES_COMPONENT_TYPE__AT_LEAST_ONE_INTERFACE_HAS_TO_BE_PROVIDED_BY_AUSEFULL_PROVIDES_COMPONENT_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType", EObjectValidator.getObjectLabel(this, context) }),
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
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
				return ((InternalEList)getProvidedRoles_InterfaceProvidingEntity()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
				return ((InternalEList)getRequiredRoles_InterfaceRequiringEntity()).basicRemove(otherEnd, msgs);
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
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
				return getProvidedRoles_InterfaceProvidingEntity();
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
				return getRequiredRoles_InterfaceRequiringEntity();
			case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_PROVIDES_COMPONENT_TYPES:
				return getParentProvidesComponentTypes();
			case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES:
				return getParentCompleteComponentTypes();
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
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
				getProvidedRoles_InterfaceProvidingEntity().clear();
				getProvidedRoles_InterfaceProvidingEntity().addAll((Collection)newValue);
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
				getRequiredRoles_InterfaceRequiringEntity().clear();
				getRequiredRoles_InterfaceRequiringEntity().addAll((Collection)newValue);
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_PROVIDES_COMPONENT_TYPES:
				getParentProvidesComponentTypes().clear();
				getParentProvidesComponentTypes().addAll((Collection)newValue);
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES:
				getParentCompleteComponentTypes().clear();
				getParentCompleteComponentTypes().addAll((Collection)newValue);
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
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
				getProvidedRoles_InterfaceProvidingEntity().clear();
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
				getRequiredRoles_InterfaceRequiringEntity().clear();
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_PROVIDES_COMPONENT_TYPES:
				getParentProvidesComponentTypes().clear();
				return;
			case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES:
				getParentCompleteComponentTypes().clear();
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
			case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
				return providedRoles_InterfaceProvidingEntity != null && !providedRoles_InterfaceProvidingEntity.isEmpty();
			case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
				return requiredRoles_InterfaceRequiringEntity != null && !requiredRoles_InterfaceRequiringEntity.isEmpty();
			case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_PROVIDES_COMPONENT_TYPES:
				return parentProvidesComponentTypes != null && !parentProvidesComponentTypes.isEmpty();
			case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES:
				return parentCompleteComponentTypes != null && !parentCompleteComponentTypes.isEmpty();
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
		if (baseClass == InterfaceProvidingEntity.class) {
			switch (derivedFeatureID) {
				case RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY: return EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;
				default: return -1;
			}
		}
		if (baseClass == InterfaceRequiringEntity.class) {
			switch (derivedFeatureID) {
				case RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY: return EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;
				default: return -1;
			}
		}
		if (baseClass == InterfaceProvidingRequiringEntity.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ProvidesComponentType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CompleteComponentType.class) {
			switch (derivedFeatureID) {
				case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_PROVIDES_COMPONENT_TYPES: return RepositoryPackage.COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES;
				default: return -1;
			}
		}
		if (baseClass == ImplementationComponentType.class) {
			switch (derivedFeatureID) {
				case RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES: return RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES;
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
		if (baseClass == InterfaceProvidingEntity.class) {
			switch (baseFeatureID) {
				case EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY: return RepositoryPackage.COMPOSITE_COMPONENT__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;
				default: return -1;
			}
		}
		if (baseClass == InterfaceRequiringEntity.class) {
			switch (baseFeatureID) {
				case EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY: return RepositoryPackage.COMPOSITE_COMPONENT__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;
				default: return -1;
			}
		}
		if (baseClass == InterfaceProvidingRequiringEntity.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ProvidesComponentType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CompleteComponentType.class) {
			switch (baseFeatureID) {
				case RepositoryPackage.COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES: return RepositoryPackage.COMPOSITE_COMPONENT__PARENT_PROVIDES_COMPONENT_TYPES;
				default: return -1;
			}
		}
		if (baseClass == ImplementationComponentType.class) {
			switch (baseFeatureID) {
				case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES: return RepositoryPackage.COMPOSITE_COMPONENT__PARENT_COMPLETE_COMPONENT_TYPES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CompositeComponentImpl