
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeComponent#getProvidedDelegationConnectors__CompositeComponent <em>Provided Delegation Connectors Composite Component</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeComponent#getRequiredDelegationConnectors__CompositeComponent <em>Required Delegation Connectors Composite Component</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeComponent#getImplementationComponentType <em>Implementation Component Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeComponent#getChildComponentContexts_CompositeComponent <em>Child Component Contexts Composite Component</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeComponent#getCompositeAssemblyConnectors_CompositeComponent <em>Composite Assembly Connectors Composite Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeComponent()
 * @model
 * @generated
 */
public interface CompositeComponent extends ImplementationComponentType {
	/**
	 * Returns the value of the '<em><b>Provided Delegation Connectors Composite Component</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.ProvidedDelegationConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Delegation Connectors Composite Component</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Delegation Connectors Composite Component</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeComponent_ProvidedDelegationConnectors__CompositeComponent()
	 * @model type="de.uka.ipd.sdq.pcm.repository.ProvidedDelegationConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList getProvidedDelegationConnectors__CompositeComponent();

	/**
	 * Returns the value of the '<em><b>Required Delegation Connectors Composite Component</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.RequiredDelegationConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Delegation Connectors Composite Component</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Delegation Connectors Composite Component</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeComponent_RequiredDelegationConnectors__CompositeComponent()
	 * @model type="de.uka.ipd.sdq.pcm.repository.RequiredDelegationConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList getRequiredDelegationConnectors__CompositeComponent();

	/**
	 * Returns the value of the '<em><b>Implementation Component Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Component Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Component Type</em>' reference.
	 * @see #setImplementationComponentType(ImplementationComponentType)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeComponent_ImplementationComponentType()
	 * @model ordered="false"
	 * @generated
	 */
	ImplementationComponentType getImplementationComponentType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.CompositeComponent#getImplementationComponentType <em>Implementation Component Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Component Type</em>' reference.
	 * @see #getImplementationComponentType()
	 * @generated
	 */
	void setImplementationComponentType(ImplementationComponentType value);

	/**
	 * Returns the value of the '<em><b>Child Component Contexts Composite Component</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.ChildComponentContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Component Contexts Composite Component</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Component Contexts Composite Component</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeComponent_ChildComponentContexts_CompositeComponent()
	 * @model type="de.uka.ipd.sdq.pcm.repository.ChildComponentContext" containment="true" ordered="false"
	 * @generated
	 */
	EList getChildComponentContexts_CompositeComponent();

	/**
	 * Returns the value of the '<em><b>Composite Assembly Connectors Composite Component</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Assembly Connectors Composite Component</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Assembly Connectors Composite Component</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeComponent_CompositeAssemblyConnectors_CompositeComponent()
	 * @model type="de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList getCompositeAssemblyConnectors_CompositeComponent();


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * -- CC has to provide the same interfaces like the implementationComponentType (if set) (same OCL code like BC)#
	 * self.providedRoles->iterate(pr : ProvidedRole; acc1 : Bag(String) = Bag{} |
	 *  acc1->union(pr.providedInterface.identifier.id->asBag())
	 * )
	 * =
	 * if
	 *   -- apply constraint only for non-empty ImplementationComponentTypes of a BC #
	 *  self.implementationComponentType->notEmpty()
	 * then
	 *  self.implementationComponentType.providedRoles->iterate(pr : ProvidedRole; acc2 : Bag(String) = Bag{} |
	 *   acc2->union(pr.providedInterface.identifier.id->asBag())
	 *  )
	 * else
	 *  Bag{}
	 * endif
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ProvideSameInterfaces(DiagnosticChain diagnostics, Map context);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * -- CC has to require the same interfaces like the implementationComponentType (if set) (same OCL code like BC) #
	 * self.requiredRoles->iterate(pr : RequiredRole; acc1 : Bag(String) = Bag{} |
	 *  acc1->union(pr.requiredInterface.identifier.id->asBag())
	 * )
	 * =
	 * if
	 *   -- apply constraint only for non-empty ImplementationComponentTypes of a BC #
	 *  self.implementationComponentType->notEmpty()
	 * then
	 *  self.implementationComponentType.requiredRoles->iterate(pr : RequiredRole; acc2 : Bag(String) = Bag{} |
	 *   acc2->union(pr.requiredInterface.identifier.id->asBag())
	 *  )
	 * else
	 *  Bag{}
	 * endif
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean RequireSameInterfaces(DiagnosticChain diagnostics, Map context);

} // CompositeComponent