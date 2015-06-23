/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Complete Component Type</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> Complete (Component) types abstract from the realisation of components.
 * They only contain provided and required roles omitting the components’ internal structure, i.e.,
 * the service effect specifications or assemblies. Thus, complete types represent a black box view
 * on components. Leaving the implementation open allows for a higher flexibility of software
 * architects and defines substitutability in the PCM. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.repository.CompleteComponentType#getParentProvidesComponentTypes
 * <em>Parent Provides Component Types</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.pcm.repository.RepositoryPackage#getCompleteComponentType()
 * @model
 * @generated
 */
public interface CompleteComponentType extends RepositoryComponent {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Parent Provides Component Types</b></em>' reference list.
     * The list contents are of type
     * {@link org.palladiosimulator.pcm.repository.ProvidesComponentType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent Provides Component Types</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Parent Provides Component Types</em>' reference list.
     * @see org.palladiosimulator.pcm.repository.RepositoryPackage#getCompleteComponentType_ParentProvidesComponentTypes()
     * @model ordered="false"
     * @generated
     */
    EList<ProvidesComponentType> getParentProvidesComponentTypes();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model annotation=
     *        "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='(\n\tself.oclIsTypeOf(CompleteComponentType)\n\tor\n\tself.oclIsTypeOf(ImplementationComponentType)\n\tor\n\tself.oclIsTypeOf(CompositeComponent)\n\tor\n\tself.oclIsTypeOf(BasicComponent)\n)\nimplies\n(\n\tself.providedRoles_InterfaceProvidingEntity->size() >= 1\n\tor\n\tself.requiredRoles_InterfaceRequiringEntity->size() >= 1\n)'"
     * @generated
     */
    boolean AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(DiagnosticChain diagnostics,
            Map<Object, Object> context);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model annotation=
     *        "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='-- CompleteTypes provided Interfaces have to be a superset\n-- of ProvidesComponentType provided Interfaces #\n--\n-- ACCx are used to accumulate Sets/Bags; usually only the very inner ACCx is used at all.\n--\n-- Recursive Query for parent Interface IDs\n-- see \"lpar2005.pdf\" (Second-order principles in specification languages for Object-Oriented Programs; Beckert, Tretelman) pp. 11 #\n--let parentInterfaces : Bag(Interface) =\n--\tself.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(Interface) = Bag{} |\n--\t\tacc2->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\n--\t) in\n--let anchestorInterfaces : Bag(Interface) =\n--\tself.providedRoles->iterate(r : ProvidedRole; acc4 : Bag(Interface) = Bag{} |\n--\t\tacc4->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #\n--\t)->union( -- union with anchestors found in former recursion #\n--\t\tself.providedRoles->iterate(r : ProvidedRole; acc6 : Bag(Interface) = Bag{} |\n--\t\t\tacc6->union(r.providedInterface.parentInterface.anchestorInterfaces) --already Set/Bag\n--\t\t)\n--\t) in\n--\t-- Directly provided anchestorInterfaces need to be a superset of provided interfaces of Supertype #\n--\tanchestorInterfaces.identifier.id->includesAll(\n--\t\tself.parentProvidesComponentTypes->iterate(pt : ProvidesComponentType; acc1 : Bag(String) = Bag{} |\n--\t\t\tpt.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(String) = Bag{} |\n--\t\t\t\tacc2->union(r.providedInterface.identifier.id->asBag()) -- asBag required to allow Set operations #\n--\t\t\t)\n--\t\t)\n--\t)\ntrue'"
     * @generated
     */
    boolean providedInterfacesHaveToConformToProvidedType2(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CompleteComponentType
