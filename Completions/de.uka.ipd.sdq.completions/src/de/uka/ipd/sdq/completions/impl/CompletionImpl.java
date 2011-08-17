/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 *
 * $Id$
 */
package de.uka.ipd.sdq.completions.impl;

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
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.completions.Completion;
import de.uka.ipd.sdq.completions.CompletionsPackage;
import de.uka.ipd.sdq.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.ComponentType;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.completions.impl.CompletionImpl#getRepository__RepositoryComponent <em>Repository Repository Component</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.completions.impl.CompletionImpl#getParentCompleteComponentTypes <em>Parent Complete Component Types</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.completions.impl.CompletionImpl#getComponentParameterUsage_ImplementationComponentType <em>Component Parameter Usage Implementation Component Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.completions.impl.CompletionImpl#getComponentType <em>Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompletionImpl extends ComposedProvidingRequiringEntityImpl implements Completion {
	/**
	 * The cached value of the '{@link #getParentCompleteComponentTypes() <em>Parent Complete Component Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentCompleteComponentTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<CompleteComponentType> parentCompleteComponentTypes;

	/**
	 * The cached value of the '{@link #getComponentParameterUsage_ImplementationComponentType() <em>Component Parameter Usage Implementation Component Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentParameterUsage_ImplementationComponentType()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableUsage> componentParameterUsage_ImplementationComponentType;

	/**
	 * The default value of the '{@link #getComponentType() <em>Component Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentType()
	 * @generated
	 * @ordered
	 */
	protected static final ComponentType COMPONENT_TYPE_EDEFAULT = ComponentType.BUSINESS_COMPONENT;

	/**
	 * The cached value of the '{@link #getComponentType() <em>Component Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentType()
	 * @generated
	 * @ordered
	 */
	protected ComponentType componentType = COMPONENT_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompletionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompletionsPackage.Literals.COMPLETION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository getRepository__RepositoryComponent() {
		if (eContainerFeatureID() != CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT) return null;
		return (Repository)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository__RepositoryComponent(Repository newRepository__RepositoryComponent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepository__RepositoryComponent, CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepository__RepositoryComponent(Repository newRepository__RepositoryComponent) {
		if (newRepository__RepositoryComponent != eInternalContainer() || (eContainerFeatureID() != CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT && newRepository__RepositoryComponent != null)) {
			if (EcoreUtil.isAncestor(this, newRepository__RepositoryComponent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepository__RepositoryComponent != null)
				msgs = ((InternalEObject)newRepository__RepositoryComponent).eInverseAdd(this, RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY, Repository.class, msgs);
			msgs = basicSetRepository__RepositoryComponent(newRepository__RepositoryComponent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT, newRepository__RepositoryComponent, newRepository__RepositoryComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompleteComponentType> getParentCompleteComponentTypes() {
		if (parentCompleteComponentTypes == null) {
			parentCompleteComponentTypes = new EObjectResolvingEList<CompleteComponentType>(CompleteComponentType.class, this, CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES);
		}
		return parentCompleteComponentTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableUsage> getComponentParameterUsage_ImplementationComponentType() {
		if (componentParameterUsage_ImplementationComponentType == null) {
			componentParameterUsage_ImplementationComponentType = new EObjectContainmentEList<VariableUsage>(VariableUsage.class, this, CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE);
		}
		return componentParameterUsage_ImplementationComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType getComponentType() {
		return componentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentType(ComponentType newComponentType) {
		ComponentType oldComponentType = componentType;
		componentType = newComponentType == null ? COMPONENT_TYPE_EDEFAULT : newComponentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompletionsPackage.COMPLETION__COMPONENT_TYPE, oldComponentType, componentType));
	}

	/**
	 * The cached OCL expression body for the '{@link #RequiredInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Required Interfaces Have To Conform To Complete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RequiredInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- ImplementationTypes required Interfaces have to be a subset"+
"-- of CompleteComponentType required Interfaces #"+
"--"+
"-- ACCx are used to accumulate Sets/Bags; usually only the very inner ACCx is used at all."+
"--"+
"-- Recursive Query for parent Interface IDs"+
"-- see 'lpar2005.pdf' (Second-order principles in specification languages for Object-Oriented Programs; Beckert, Tretelman) pp. 11 #"+
"--let parentInterfaces : Bag(Interface) ="+
"--	self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc1 : Bag(Interface) = Bag{} |"+
"--		acc1->union(pt.requiredRoles->iterate(r : RequiredRole; acc2 : Bag(Interface) = Bag{} |"+
"--			acc2->union(r.requiredInterface.parentInterface->asBag()) -- asBag required to allow Set operations #"+
"--		))"+
"--	) in"+
"--let anchestorInterfaces : Bag(Interface) ="+
"--	self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc3 : Bag(Interface) = Bag{} |"+
"--		acc3->union(pt.requiredRoles->iterate(r : RequiredRole; acc4 : Bag(Interface) = Bag{} |"+
"--			acc4->union(r.requiredInterface.parentInterface->asBag()) -- asBag required to allow Set operations #"+
"--		))"+
"--	)->union( -- union with anchestors found in former recursion #"+
"--		self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc5 : Bag(Interface) = Bag{} |"+
"--			acc5->union(pt.requiredRoles->iterate(r : RequiredRole; acc6 : Bag(Interface) = Bag{} |"+
"--				acc6->union(r.requiredInterface.parentInterface.anchestorInterfaces) --already Set/Bag"+
"--			))"+
"--		)"+
"--	) in"+
"-- Directly required interfaces need to be a subset of required anchestorInterfaces of Supertype #"+
"--anchestorInterfaces.identifier.id->includesAll("+
"--	self.requiredRoles->iterate(p : RequiredRole; acc7 : Bag(String) = Bag{} |"+
"--		acc7->union(p.requiredInterface.identifier.id->asBag())"+
"--	)	"+
"--)"+
"true";

	/**
	 * The cached OCL invariant for the '{@link #RequiredInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Required Interfaces Have To Conform To Complete Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RequiredInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean RequiredInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE);
			try {
				REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
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
	 * The cached OCL expression body for the '{@link #providedInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Provided Interfaces Have To Conform To Complete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #providedInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- ### EXACT COPY FROM ABOVE ###"+
"-- ImplementationComponentTypes provided Interfaces have to be a superset"+
"-- of CompleteComponentType provided Interfaces #"+
"--"+
"-- ACCx are used to accumulate Sets/Bags; usually only the very inner ACCx is used at all."+
"--"+
"-- Recursive Query for parent Interface IDs"+
"-- see 'lpar2005.pdf' (Second-order principles in specification languages for Object-Oriented Programs; Beckert, Tretelman) pp. 11 #"+
"--let parentInterfaces : Bag(Interface) ="+
"--	self.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(Interface) = Bag{} |"+
"--		acc2->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #"+
"--	) in"+
"--let anchestorInterfaces : Bag(Interface) ="+
"--	self.providedRoles->iterate(r : ProvidedRole; acc4 : Bag(Interface) = Bag{} |"+
"--		acc4->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #"+
"--	)->union( -- union with anchestors found in former recursion #"+
"--		self.providedRoles->iterate(r : ProvidedRole; acc6 : Bag(Interface) = Bag{} |"+
"--			acc6->union(r.providedInterface.parentInterface.anchestorInterfaces) --already Set/Bag"+
"--		)"+
"--	) in"+
"	-- Directly provided anchestorInterfaces need to be a superset of provided interfaces of Supertype #"+
"--	anchestorInterfaces.identifier.id->includesAll("+
"--		self.parentProvidesComponentTypes->iterate(pt : ProvidesComponentType; acc1 : Bag(String) = Bag{} |"+
"--			pt.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(String) = Bag{} |"+
"--				acc2->union(r.providedInterface.identifier.id->asBag()) -- asBag required to allow Set operations #"+
"--			)"+
"--		)"+
"--	)"+
"true";

	/**
	 * The cached OCL invariant for the '{@link #providedInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Provided Interfaces Have To Conform To Complete Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #providedInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean providedInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE);
			try {
				PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
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
	 * The cached OCL expression body for the '{@link #ProvidedInterfaceHaveToConformToComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Provided Interface Have To Conform To Component Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ProvidedInterfaceHaveToConformToComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "if self.componentType = ComponentType::INFRASTRUCTURE_COMPONENT then"+
"	self.providedRoles_InterfaceProvidingEntity->select(role | role.oclIsTypeOf(OperationInterface) or role.oclIsTypeOf(EventGroup))->size() = 0"+
"else if self.componentType = ComponentType::BUSINESS_COMPONENT then"+
"	self.providedRoles_InterfaceProvidingEntity->select(role | role.oclIsTypeOf(InfrastructureInterface))->size() = 0"+
"else"+
"	1 = 0"+
"endif"+
"endif";

	/**
	 * The cached OCL invariant for the '{@link #ProvidedInterfaceHaveToConformToComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Provided Interface Have To Conform To Component Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ProvidedInterfaceHaveToConformToComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ProvidedInterfaceHaveToConformToComponentType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE);
			try {
				PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ProvidedInterfaceHaveToConformToComponentType", EObjectValidator.getObjectLabel(this, context) }),
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
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRepository__RepositoryComponent((Repository)otherEnd, msgs);
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
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				return basicSetRepository__RepositoryComponent(null, msgs);
			case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				return ((InternalEList<?>)getComponentParameterUsage_ImplementationComponentType()).basicRemove(otherEnd, msgs);
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
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY, Repository.class, msgs);
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
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				return getRepository__RepositoryComponent();
			case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
				return getParentCompleteComponentTypes();
			case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				return getComponentParameterUsage_ImplementationComponentType();
			case CompletionsPackage.COMPLETION__COMPONENT_TYPE:
				return getComponentType();
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
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				setRepository__RepositoryComponent((Repository)newValue);
				return;
			case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
				getParentCompleteComponentTypes().clear();
				getParentCompleteComponentTypes().addAll((Collection<? extends CompleteComponentType>)newValue);
				return;
			case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				getComponentParameterUsage_ImplementationComponentType().clear();
				getComponentParameterUsage_ImplementationComponentType().addAll((Collection<? extends VariableUsage>)newValue);
				return;
			case CompletionsPackage.COMPLETION__COMPONENT_TYPE:
				setComponentType((ComponentType)newValue);
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
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				setRepository__RepositoryComponent((Repository)null);
				return;
			case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
				getParentCompleteComponentTypes().clear();
				return;
			case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				getComponentParameterUsage_ImplementationComponentType().clear();
				return;
			case CompletionsPackage.COMPLETION__COMPONENT_TYPE:
				setComponentType(COMPONENT_TYPE_EDEFAULT);
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
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				return getRepository__RepositoryComponent() != null;
			case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
				return parentCompleteComponentTypes != null && !parentCompleteComponentTypes.isEmpty();
			case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				return componentParameterUsage_ImplementationComponentType != null && !componentParameterUsage_ImplementationComponentType.isEmpty();
			case CompletionsPackage.COMPLETION__COMPONENT_TYPE:
				return componentType != COMPONENT_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == RepositoryComponent.class) {
			switch (derivedFeatureID) {
				case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT: return RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT;
				default: return -1;
			}
		}
		if (baseClass == ImplementationComponentType.class) {
			switch (derivedFeatureID) {
				case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES: return RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES;
				case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE: return RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE;
				case CompletionsPackage.COMPLETION__COMPONENT_TYPE: return RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE;
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
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == RepositoryComponent.class) {
			switch (baseFeatureID) {
				case RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT: return CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT;
				default: return -1;
			}
		}
		if (baseClass == ImplementationComponentType.class) {
			switch (baseFeatureID) {
				case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES: return CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES;
				case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE: return CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE;
				case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE: return CompletionsPackage.COMPLETION__COMPONENT_TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (componentType: ");
		result.append(componentType);
		result.append(')');
		return result.toString();
	}

} //CompletionImpl
