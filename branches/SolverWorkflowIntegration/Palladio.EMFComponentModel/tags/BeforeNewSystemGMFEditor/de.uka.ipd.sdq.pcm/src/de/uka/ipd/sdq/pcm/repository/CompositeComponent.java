
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeComponent#getImplementationComponentType <em>Implementation Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeComponent()
 * @model
 * @generated
 */
public interface CompositeComponent extends ImplementationComponentType, ComposedStructure {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

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