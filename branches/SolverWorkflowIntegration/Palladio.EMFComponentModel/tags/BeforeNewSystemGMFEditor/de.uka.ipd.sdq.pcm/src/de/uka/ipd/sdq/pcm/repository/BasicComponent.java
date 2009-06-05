
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
 * A representation of the model object '<em><b>Basic Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.BasicComponent#getImplementationComponentType <em>Implementation Component Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.BasicComponent#getServiceEffectSpecifications__BasicComponent <em>Service Effect Specifications Basic Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getBasicComponent()
 * @model
 * @generated
 */
public interface BasicComponent extends ImplementationComponentType {
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
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getBasicComponent_ImplementationComponentType()
	 * @model ordered="false"
	 * @generated
	 */
	ImplementationComponentType getImplementationComponentType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.BasicComponent#getImplementationComponentType <em>Implementation Component Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Component Type</em>' reference.
	 * @see #getImplementationComponentType()
	 * @generated
	 */
	void setImplementationComponentType(ImplementationComponentType value);

	/**
	 * Returns the value of the '<em><b>Service Effect Specifications Basic Component</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Effect Specifications Basic Component</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Effect Specifications Basic Component</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getBasicComponent_ServiceEffectSpecifications__BasicComponent()
	 * @model type="de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification" containment="true" ordered="false"
	 * @generated
	 */
	EList getServiceEffectSpecifications__BasicComponent();


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.serviceEffectSpecifications->forAll(p1, p2 |
	 * p1.seffTypeID <> p2.seffTypeID)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean noSeffTypeUsedTwice(DiagnosticChain diagnostics, Map context);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * -- BC has to provide the same interfaces like the implementationComponentType (if set) #
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
	 * -- BC has to require the same interfaces like the implementationComponentType (if set) #
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

} // BasicComponent