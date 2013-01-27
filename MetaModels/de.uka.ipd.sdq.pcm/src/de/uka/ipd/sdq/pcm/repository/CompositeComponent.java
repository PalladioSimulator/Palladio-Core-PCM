/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Composite Component</b></em>
 * '. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> Composite components are special implementation component types, which
 * are composed from inner components. Component developers compose inner components within
 * composite components with assembly connectors. An assembly connector binds a provided role with a
 * required role. To access the inner components, composite components themselves provide or require
 * interfaces. A delegation connector binds a provided (required) role of the composite component
 * with an inner component provided (required) role. A composite component may contain other
 * composite components, which are also themselves composed out of inner components. This enables
 * building arbitrary hierarchies of nested components. Like a basic component, a composite
 * component may contain a SEFF. However, this SEFF is not specified manually by the composite
 * component developer, but can be computed by combining the SEFFs of the inner components. <!--
 * end-model-doc -->
 * 
 * 
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeComponent()
 * @model
 * @generated
 */
public interface CompositeComponent extends ComposedProvidingRequiringEntity, ImplementationComponentType {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * 
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='-- CC has to provide the same interfaces like the implementationComponentType (if set) (same OCL code like BC)#\r\nif\r\n\t -- apply constraint only for non-empty ImplementationComponentTypes of a BC #\r\n\tself.parentCompleteComponentTypes->notEmpty()\r\nthen\r\n\t--own interface IDs:\r\n    self.providedRoles_InterfaceProvidingEntity->select(pr|pr.oclIsTypeOf(OperationProvidedRole))->collect(pr : ProvidedRole | pr.oclAsType (OperationProvidedRole).providedInterface__OperationProvidedRole.id)->asSet()\r\n    =\r\n    --complete type interface IDs:\r\n    self.parentCompleteComponentTypes.providedRoles_InterfaceProvidingEntity->select(pr|pr.oclIsTypeOf(OperationProvidedRole))->collect(pr : ProvidedRole | pr.oclAsType (OperationProvidedRole).providedInterface__OperationProvidedRole.id)->asSet()\r\nelse\r\n\ttrue\r\nendif'"
     * @generated
     */
    boolean ProvideSameInterfaces(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * 
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='-- CC has to require the same interfaces like the implementationComponentType (if set) (same OCL code like BC) #\r\nif\r\n\t -- apply constraint only for non-empty ImplementationComponentTypes of a BC #\r\n\tself.parentCompleteComponentTypes->notEmpty()\r\nthen\r\n\t--own interface IDs:\r\n    self.requiredRoles_InterfaceRequiringEntity->select(pr|pr.oclIsTypeOf(OperationRequiredRole))->collect(rr : RequiredRole | rr.oclAsType (OperationRequiredRole).requiredInterface__OperationRequiredRole.id)->asSet()\r\n    =\r\n    --complete type interface IDs:\r\n    self.parentCompleteComponentTypes.requiredRoles_InterfaceRequiringEntity->select(pr|pr.oclIsTypeOf(OperationRequiredRole))->collect(rr : RequiredRole | rr.oclAsType (OperationRequiredRole).requiredInterface__OperationRequiredRole.id)->asSet()\r\nelse\r\n\ttrue\r\nendif'"
     * @generated
     */
    boolean RequireSameInterfaces(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CompositeComponent
