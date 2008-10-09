/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This entity represents a component composed of other component, i.e., the component is not directly implemented in a programming language, but it is rather implemented by a composition of other components.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeComponent()
 * @model
 * @generated
 */
public interface CompositeComponent extends ComposedProvidingRequiringEntity, ImplementationComponentType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * -- CC has to provide the same interfaces like the implementationComponentType (if set) (same OCL code like BC)#
	 * self.providedRoles_InterfaceProvidingEntity->iterate(pr : ProvidedRole; acc1 : Bag(String) = Bag{} |
	 * 	acc1->union(pr.providedInterface__ProvidedRole.id->asBag())
	 * )
	 * =
	 * if
	 * 	 -- apply constraint only for non-empty ImplementationComponentTypes of a BC #
	 * 	self.implementationComponentType->notEmpty()
	 * then
	 * 	self.implementationComponentType.providedRoles_InterfaceProvidingEntity->iterate(pr : ProvidedRole; acc2 : Bag(String) = Bag{} |
	 * 		acc2->union(pr.providedInterface__ProvidedRole.id->asBag())
	 * 	)
	 * else
	 * 	Bag{}
	 * endif
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ProvideSameInterfaces(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * -- CC has to require the same interfaces like the implementationComponentType (if set) (same OCL code like BC) #
	 * self.requiredRoles_InterfaceRequiringEntity->iterate(pr : RequiredRole; acc1 : Bag(String) = Bag{} |
	 * 	acc1->union(pr.requiredInterface__RequiredRole.id->asBag())
	 * )
	 * =
	 * if
	 * 	 -- apply constraint only for non-empty ImplementationComponentTypes of a BC #
	 * 	self.implementationComponentType->notEmpty()
	 * then
	 * 	self.implementationComponentType.requiredRoles_InterfaceRequiringEntity->iterate(pr : RequiredRole; acc2 : Bag(String) = Bag{} |
	 * 		acc2->union(pr.requiredInterface__RequiredRole.id->asBag())
	 * 	)
	 * else
	 * 	Bag{}
	 * endif
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean RequireSameInterfaces(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CompositeComponent
