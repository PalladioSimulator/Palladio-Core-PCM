/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implementation Component Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This entity represents an abstraction of a component, where both sets of provided and required interfaces as well as the implementation is visible. It fully specifies the component type. The specification of
 * the internal structure depends on the way the component is realised. In general, components can either be implemented from the scratch or composed out of other components. In the first case, the implemented behaviour of each provided service needs to be specified with a service effect specification (SEFF) to describe the component’s abstract internal structure. We refer to such components as basic components, since they form the basic building blocks of a software architecture. On the other hand, developers can use existing components to assemble new, composite components.
 * 
 * TODO: ? Possibly add constraint that the VariableUsages must have unique names within one component. Maybe this constraint can even be added to the VariableUsage in general (for each containment of VariableUsages, each name inside must be unique, for example). 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ImplementationComponentType#getParentCompleteComponentTypes <em>Parent Complete Component Types</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ImplementationComponentType#getComponentParameterUsage_ImplementationComponentType <em>Component Parameter Usage Implementation Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getImplementationComponentType()
 * @model abstract="true"
 * @generated
 */
public interface ImplementationComponentType extends RepositoryComponent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Parent Complete Component Types</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.CompleteComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Complete Component Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Complete Component Types</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getImplementationComponentType_ParentCompleteComponentTypes()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CompleteComponentType> getParentCompleteComponentTypes();

	/**
	 * Returns the value of the '<em><b>Component Parameter Usage Implementation Component Type</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Parameter Usage Implementation Component Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property specified the variables of the component that are to be initialized using the assembly context to parametrize the component.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Component Parameter Usage Implementation Component Type</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getImplementationComponentType_ComponentParameterUsage_ImplementationComponentType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableUsage> getComponentParameterUsage_ImplementationComponentType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * -- ImplementationTypes required Interfaces have to be a subset
	 * -- of CompleteComponentType required Interfaces #
	 * --
	 * -- ACCx are used to accumulate Sets/Bags; usually only the very inner ACCx is used at all.
	 * --
	 * -- Recursive Query for parent Interface IDs
	 * -- see "lpar2005.pdf" (Second-order principles in specification languages for Object-Oriented Programs; Beckert, Tretelman) pp. 11 #
	 * --let parentInterfaces : Bag(Interface) =
	 * --	self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc1 : Bag(Interface) = Bag{} |
	 * --		acc1->union(pt.requiredRoles->iterate(r : RequiredRole; acc2 : Bag(Interface) = Bag{} |
	 * --			acc2->union(r.requiredInterface.parentInterface->asBag()) -- asBag required to allow Set operations #
	 * --		))
	 * --	) in
	 * --let anchestorInterfaces : Bag(Interface) =
	 * --	self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc3 : Bag(Interface) = Bag{} |
	 * --		acc3->union(pt.requiredRoles->iterate(r : RequiredRole; acc4 : Bag(Interface) = Bag{} |
	 * --			acc4->union(r.requiredInterface.parentInterface->asBag()) -- asBag required to allow Set operations #
	 * --		))
	 * --	)->union( -- union with anchestors found in former recursion #
	 * --		self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc5 : Bag(Interface) = Bag{} |
	 * --			acc5->union(pt.requiredRoles->iterate(r : RequiredRole; acc6 : Bag(Interface) = Bag{} |
	 * --				acc6->union(r.requiredInterface.parentInterface.anchestorInterfaces) --already Set/Bag
	 * --			))
	 * --		)
	 * --	) in
	 * -- Directly required interfaces need to be a subset of required anchestorInterfaces of Supertype #
	 * --anchestorInterfaces.identifier.id->includesAll(
	 * --	self.requiredRoles->iterate(p : RequiredRole; acc7 : Bag(String) = Bag{} |
	 * --		acc7->union(p.requiredInterface.identifier.id->asBag())
	 * --	)	
	 * --)
	 * true
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='-- ImplementationTypes required Interfaces have to be a subset\r\n-- of CompleteComponentType required Interfaces #\r\n--\r\n-- ACCx are used to accumulate Sets/Bags; usually only the very inner ACCx is used at all.\r\n--\r\n-- Recursive Query for parent Interface IDs\r\n-- see \"lpar2005.pdf\" (Second-order principles in specification languages for Object-Oriented Programs; Beckert, Tretelman) pp. 11 #\r\n--let parentInterfaces : Bag(Interface) =\r\n--\tself.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc1 : Bag(Interface) = Bag{} |\r\n--\t\tacc1->union(pt.requiredRoles->iterate(r : RequiredRole; acc2 : Bag(Interface) = Bag{} |\r\n--\t\t\tacc2->union(r.requiredInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\r\n--\t\t))\r\n--\t) in\r\n--let anchestorInterfaces : Bag(Interface) =\r\n--\tself.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc3 : Bag(Interface) = Bag{} |\r\n--\t\tacc3->union(pt.requiredRoles->iterate(r : RequiredRole; acc4 : Bag(Interface) = Bag{} |\r\n--\t\t\tacc4->union(r.requiredInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\r\n--\t\t))\r\n--\t)->union( -- union with anchestors found in former recursion #\r\n--\t\tself.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc5 : Bag(Interface) = Bag{} |\r\n--\t\t\tacc5->union(pt.requiredRoles->iterate(r : RequiredRole; acc6 : Bag(Interface) = Bag{} |\r\n--\t\t\t\tacc6->union(r.requiredInterface.parentInterface.anchestorInterfaces) --already Set/Bag\r\n--\t\t\t))\r\n--\t\t)\r\n--\t) in\r\n-- Directly required interfaces need to be a subset of required anchestorInterfaces of Supertype #\r\n--anchestorInterfaces.identifier.id->includesAll(\r\n--\tself.requiredRoles->iterate(p : RequiredRole; acc7 : Bag(String) = Bag{} |\r\n--\t\tacc7->union(p.requiredInterface.identifier.id->asBag())\r\n--\t)\t\r\n--)\r\ntrue'"
	 * @generated
	 */
	boolean RequiredInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * -- ### EXACT COPY FROM ABOVE ###
	 * -- ImplementationComponentTypes provided Interfaces have to be a superset
	 * -- of CompleteComponentType provided Interfaces #
	 * --
	 * -- ACCx are used to accumulate Sets/Bags; usually only the very inner ACCx is used at all.
	 * --
	 * -- Recursive Query for parent Interface IDs
	 * -- see "lpar2005.pdf" (Second-order principles in specification languages for Object-Oriented Programs; Beckert, Tretelman) pp. 11 #
	 * --let parentInterfaces : Bag(Interface) =
	 * --	self.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(Interface) = Bag{} |
	 * --		acc2->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #
	 * --	) in
	 * --let anchestorInterfaces : Bag(Interface) =
	 * --	self.providedRoles->iterate(r : ProvidedRole; acc4 : Bag(Interface) = Bag{} |
	 * --		acc4->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #
	 * --	)->union( -- union with anchestors found in former recursion #
	 * --		self.providedRoles->iterate(r : ProvidedRole; acc6 : Bag(Interface) = Bag{} |
	 * --			acc6->union(r.providedInterface.parentInterface.anchestorInterfaces) --already Set/Bag
	 * --		)
	 * --	) in
	 * 	-- Directly provided anchestorInterfaces need to be a superset of provided interfaces of Supertype #
	 * --	anchestorInterfaces.identifier.id->includesAll(
	 * --		self.parentProvidesComponentTypes->iterate(pt : ProvidesComponentType; acc1 : Bag(String) = Bag{} |
	 * --			pt.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(String) = Bag{} |
	 * --				acc2->union(r.providedInterface.identifier.id->asBag()) -- asBag required to allow Set operations #
	 * --			)
	 * --		)
	 * --	)
	 * true
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='-- ### EXACT COPY FROM ABOVE ###\r\n-- ImplementationComponentTypes provided Interfaces have to be a superset\r\n-- of CompleteComponentType provided Interfaces #\r\n--\r\n-- ACCx are used to accumulate Sets/Bags; usually only the very inner ACCx is used at all.\r\n--\r\n-- Recursive Query for parent Interface IDs\r\n-- see \"lpar2005.pdf\" (Second-order principles in specification languages for Object-Oriented Programs; Beckert, Tretelman) pp. 11 #\r\n--let parentInterfaces : Bag(Interface) =\r\n--\tself.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(Interface) = Bag{} |\r\n--\t\tacc2->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\r\n--\t) in\r\n--let anchestorInterfaces : Bag(Interface) =\r\n--\tself.providedRoles->iterate(r : ProvidedRole; acc4 : Bag(Interface) = Bag{} |\r\n--\t\tacc4->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\r\n--\t)->union( -- union with anchestors found in former recursion #\r\n--\t\tself.providedRoles->iterate(r : ProvidedRole; acc6 : Bag(Interface) = Bag{} |\r\n--\t\t\tacc6->union(r.providedInterface.parentInterface.anchestorInterfaces) --already Set/Bag\r\n--\t\t)\r\n--\t) in\r\n\t-- Directly provided anchestorInterfaces need to be a superset of provided interfaces of Supertype #\r\n--\tanchestorInterfaces.identifier.id->includesAll(\r\n--\t\tself.parentProvidesComponentTypes->iterate(pt : ProvidesComponentType; acc1 : Bag(String) = Bag{} |\r\n--\t\t\tpt.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(String) = Bag{} |\r\n--\t\t\t\tacc2->union(r.providedInterface.identifier.id->asBag()) -- asBag required to allow Set operations #\r\n--\t\t\t)\r\n--\t\t)\r\n--\t)\r\ntrue'"
	 * @generated
	 */
	boolean providedInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ImplementationComponentType
