/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.ComponentType;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Implementation Component Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ImplementationComponentTypeImpl#getParentCompleteComponentTypes <em>Parent Complete Component Types</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ImplementationComponentTypeImpl#getComponentParameterUsage_ImplementationComponentType <em>Component Parameter Usage Implementation Component Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ImplementationComponentTypeImpl#getComponentType <em>Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ImplementationComponentTypeImpl extends RepositoryComponentImpl implements
        ImplementationComponentType {
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
	 * The cached value of the '{@link #getParentCompleteComponentTypes() <em>Parent Complete Component Types</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getParentCompleteComponentTypes()
	 * @generated
	 * @ordered
	 */
    protected EList<CompleteComponentType> parentCompleteComponentTypes;

    /**
	 * The cached value of the '{@link #getComponentParameterUsage_ImplementationComponentType() <em>Component Parameter Usage Implementation Component Type</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getComponentParameterUsage_ImplementationComponentType()
	 * @generated
	 * @ordered
	 */
    protected EList<VariableUsage> componentParameterUsage_ImplementationComponentType;

    /**
	 * The default value of the '{@link #getComponentType() <em>Component Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getComponentType()
	 * @generated
	 * @ordered
	 */
    protected static final ComponentType COMPONENT_TYPE_EDEFAULT = ComponentType.BUSINESS_COMPONENT;

    /**
     * The cached value of the '{@link #getComponentType() <em>Component Type</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getComponentType()
     * @generated
     * @ordered
     */
    protected ComponentType componentType = COMPONENT_TYPE_EDEFAULT;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected ImplementationComponentTypeImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EList<CompleteComponentType> getParentCompleteComponentTypes() {
		if (parentCompleteComponentTypes == null) {
			parentCompleteComponentTypes = new EObjectResolvingEList<CompleteComponentType>(CompleteComponentType.class, this, RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES);
		}
		return parentCompleteComponentTypes;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EList<VariableUsage> getComponentParameterUsage_ImplementationComponentType() {
		if (componentParameterUsage_ImplementationComponentType == null) {
			componentParameterUsage_ImplementationComponentType = new EObjectContainmentEList<VariableUsage>(VariableUsage.class, this, RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE);
		}
		return componentParameterUsage_ImplementationComponentType;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ComponentType getComponentType() {
		return componentType;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setComponentType(ComponentType newComponentType) {
		ComponentType oldComponentType = componentType;
		componentType = newComponentType == null ? COMPONENT_TYPE_EDEFAULT : newComponentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE, oldComponentType, componentType));
	}

    /**
     * The cached OCL expression body for the '
     * {@link #RequiredInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Required Interfaces Have To Conform To Complete Type</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #RequiredInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- ImplementationTypes required Interfaces have to be a subset\n"+"-- of CompleteComponentType required Interfaces #\n"+"--\n"+"-- ACCx are used to accumulate Sets/Bags; usually only the very inner ACCx is used at all.\n"+"--\n"+"-- Recursive Query for parent Interface IDs\n"+"-- see 'lpar2005.pdf' (Second-order principles in specification languages for Object-Oriented Programs; Beckert, Tretelman) pp. 11 #\n"+"--let parentInterfaces : Bag(Interface) =\n"+"--	self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc1 : Bag(Interface) = Bag{} |\n"+"--		acc1->union(pt.requiredRoles->iterate(r : RequiredRole; acc2 : Bag(Interface) = Bag{} |\n"+"--			acc2->union(r.requiredInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\n"+"--		))\n"+"--	) in\n"+"--let anchestorInterfaces : Bag(Interface) =\n"+"--	self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc3 : Bag(Interface) = Bag{} |\n"+"--		acc3->union(pt.requiredRoles->iterate(r : RequiredRole; acc4 : Bag(Interface) = Bag{} |\n"+"--			acc4->union(r.requiredInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\n"+"--		))\n"+"--	)->union( -- union with anchestors found in former recursion #\n"+"--		self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc5 : Bag(Interface) = Bag{} |\n"+"--			acc5->union(pt.requiredRoles->iterate(r : RequiredRole; acc6 : Bag(Interface) = Bag{} |\n"+"--				acc6->union(r.requiredInterface.parentInterface.anchestorInterfaces) --already Set/Bag\n"+"--			))\n"+"--		)\n"+"--	) in\n"+"-- Directly required interfaces need to be a subset of required anchestorInterfaces of Supertype #\n"+"--anchestorInterfaces.identifier.id->includesAll(\n"+"--	self.requiredRoles->iterate(p : RequiredRole; acc7 : Bag(String) = Bag{} |\n"+"--		acc7->union(p.requiredInterface.identifier.id->asBag())\n"+"--	)	\n"+"--)\n"+"true";

    /**
     * The cached OCL invariant for the '
     * {@link #RequiredInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Required Interfaces Have To Conform To Complete Type</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #RequiredInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean RequiredInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
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
     * The cached OCL expression body for the '
     * {@link #providedInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Provided Interfaces Have To Conform To Complete Type</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #providedInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- ### EXACT COPY FROM ABOVE ###\n"+"-- ImplementationComponentTypes provided Interfaces have to be a superset\n"+"-- of CompleteComponentType provided Interfaces #\n"+"--\n"+"-- ACCx are used to accumulate Sets/Bags; usually only the very inner ACCx is used at all.\n"+"--\n"+"-- Recursive Query for parent Interface IDs\n"+"-- see 'lpar2005.pdf' (Second-order principles in specification languages for Object-Oriented Programs; Beckert, Tretelman) pp. 11 #\n"+"--let parentInterfaces : Bag(Interface) =\n"+"--	self.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(Interface) = Bag{} |\n"+"--		acc2->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\n"+"--	) in\n"+"--let anchestorInterfaces : Bag(Interface) =\n"+"--	self.providedRoles->iterate(r : ProvidedRole; acc4 : Bag(Interface) = Bag{} |\n"+"--		acc4->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\n"+"--	)->union( -- union with anchestors found in former recursion #\n"+"--		self.providedRoles->iterate(r : ProvidedRole; acc6 : Bag(Interface) = Bag{} |\n"+"--			acc6->union(r.providedInterface.parentInterface.anchestorInterfaces) --already Set/Bag\n"+"--		)\n"+"--	) in\n"+"	-- Directly provided anchestorInterfaces need to be a superset of provided interfaces of Supertype #\n"+"--	anchestorInterfaces.identifier.id->includesAll(\n"+"--		self.parentProvidesComponentTypes->iterate(pt : ProvidesComponentType; acc1 : Bag(String) = Bag{} |\n"+"--			pt.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(String) = Bag{} |\n"+"--				acc2->union(r.providedInterface.identifier.id->asBag()) -- asBag required to allow Set operations #\n"+"--			)\n"+"--		)\n"+"--	)\n"+"true";

    /**
     * The cached OCL invariant for the '
     * {@link #providedInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Provided Interfaces Have To Conform To Complete Type</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #providedInterfacesHaveToConformToCompleteType(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean providedInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
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
     * The cached OCL expression body for the '
     * {@link #ProvidedInterfaceHaveToConformToComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Provided Interface Have To Conform To Component Type</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ProvidedInterfaceHaveToConformToComponentType(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- assures that InfrastructureComponents only have InfrastructureInterfaces and that BusinessComponents only have OperationInterfaces or EventGroups\n"+"if self.componentType = ComponentType::INFRASTRUCTURE_COMPONENT then\n"+"	self.providedRoles_InterfaceProvidingEntity->select(role | role.oclIsTypeOf(OperationInterface) or role.oclIsTypeOf(EventGroup))->size() = 0\n"+"else if self.componentType = ComponentType::BUSINESS_COMPONENT then\n"+"	self.providedRoles_InterfaceProvidingEntity->select(role | role.oclIsTypeOf(InfrastructureInterface))->size() = 0\n"+"else\n"+"	1 = 0\n"+"endif\n"+"endif";

    /**
     * The cached OCL invariant for the '
     * {@link #ProvidedInterfaceHaveToConformToComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Provided Interface Have To Conform To Component Type</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ProvidedInterfaceHaveToConformToComponentType(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean ProvidedInterfaceHaveToConformToComponentType(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
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
	 * The cached OCL expression body for the '{@link #ProvideSameOrMoreInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Provide Same Or More Interfaces As Complete Component Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ProvideSameOrMoreInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- ImplementationComponent has to provide the same or more interfaces like the CompleteComponentType (if set) #\n"+"	if\n"+"		 -- apply constraint only for non-empty CompleteComponentTypes #\n"+"		self.parentCompleteComponentTypes->notEmpty()\n"+"	then\n"+"		let\n"+"			--own interfaces:\n"+"			ownInterfaces : Set(OperationInterface)\n"+"			  = self.providedRoles_InterfaceProvidingEntity->select(pr|pr.oclIsTypeOf(OperationProvidedRole))->collect(pr : ProvidedRole | pr.oclAsType (OperationProvidedRole).providedInterface__OperationProvidedRole)->asSet()\n"+"    in    \n"+"    	--complete type interfaces:\n"+"    	self.parentCompleteComponentTypes->forAll\n"+"      ( p : CompleteComponentType |\n"+"        (\n"+"        	p.providedRoles_InterfaceProvidingEntity->select(pr|pr.oclIsTypeOf(OperationProvidedRole))->collect(pr : ProvidedRole | pr.oclAsType (OperationProvidedRole).providedInterface__OperationProvidedRole)->asSet()\n"+"        	-\n"+"        	ownInterfaces\n"+"      	)->isEmpty()\n"+"    	)\n"+"	else\n"+"		true\n"+"	endif";

				/**
	 * The cached OCL invariant for the '{@link #ProvideSameOrMoreInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Provide Same Or More Interfaces As Complete Component Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ProvideSameOrMoreInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ProvideSameOrMoreInterfacesAsCompleteComponentType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE);
			try {
				PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ProvideSameOrMoreInterfacesAsCompleteComponentType", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

				/**
	 * The cached OCL expression body for the '{@link #RequireSameOrFewerInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Require Same Or Fewer Interfaces As Complete Component Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RequireSameOrFewerInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- ImplementationComponent has to require the same or fewer interfaces like the CompleteComponentType (if set) #\n"+"	if\n"+"		-- apply constraint only for non-empty CompleteComponentTypes #\n"+"		self.parentCompleteComponentTypes->notEmpty()\n"+"	then\n"+"	    let\n"+"	      --own interfaces:\n"+"	      ownInterfaces : Set(OperationInterface) \n"+"	        = self.requiredRoles_InterfaceRequiringEntity->select(rr|rr.oclIsTypeOf(OperationRequiredRole))->collect(rr : RequiredRole | rr.oclAsType (OperationRequiredRole).requiredInterface__OperationRequiredRole)->asSet()\n"+"	    in\n"+"	      --complete type interfaces:\n"+"	      self.parentCompleteComponentTypes->forAll\n"+"	      ( p : CompleteComponentType |\n"+"	      	(\n"+"		      	ownInterfaces\n"+"		        -\n"+"		        p.requiredRoles_InterfaceRequiringEntity->select(rr|rr.oclIsTypeOf(OperationRequiredRole))->collect(rr : RequiredRole | rr.oclAsType (OperationRequiredRole).requiredInterface__OperationRequiredRole)->asSet()\n"+"	      	)->isEmpty()\n"+"	    	)\n"+"	else\n"+"		true\n"+"	endif";

				/**
	 * The cached OCL invariant for the '{@link #RequireSameOrFewerInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Require Same Or Fewer Interfaces As Complete Component Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RequireSameOrFewerInterfacesAsCompleteComponentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean RequireSameOrFewerInterfacesAsCompleteComponentType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE);
			try {
				REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "RequireSameOrFewerInterfacesAsCompleteComponentType", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

				/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				return ((InternalEList<?>)getComponentParameterUsage_ImplementationComponentType()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES:
				return getParentCompleteComponentTypes();
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				return getComponentParameterUsage_ImplementationComponentType();
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE:
				return getComponentType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES:
				getParentCompleteComponentTypes().clear();
				getParentCompleteComponentTypes().addAll((Collection<? extends CompleteComponentType>)newValue);
				return;
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				getComponentParameterUsage_ImplementationComponentType().clear();
				getComponentParameterUsage_ImplementationComponentType().addAll((Collection<? extends VariableUsage>)newValue);
				return;
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE:
				setComponentType((ComponentType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES:
				getParentCompleteComponentTypes().clear();
				return;
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				getComponentParameterUsage_ImplementationComponentType().clear();
				return;
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE:
				setComponentType(COMPONENT_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES:
				return parentCompleteComponentTypes != null && !parentCompleteComponentTypes.isEmpty();
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				return componentParameterUsage_ImplementationComponentType != null && !componentParameterUsage_ImplementationComponentType.isEmpty();
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE:
				return componentType != COMPONENT_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

    /**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // ImplementationComponentTypeImpl
