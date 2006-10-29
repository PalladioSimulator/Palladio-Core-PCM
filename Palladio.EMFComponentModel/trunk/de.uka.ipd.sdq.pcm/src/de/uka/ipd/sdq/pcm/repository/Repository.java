
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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryDescription <em>Repository Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryName <em>Repository Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Repository#getComponents__Repository <em>Components Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Repository#getInterfaces__Repository <em>Interfaces Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends EObject {
	/**
	 * Returns the value of the '<em><b>Repository Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Description</em>' attribute.
	 * @see #setRepositoryDescription(String)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_RepositoryDescription()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getRepositoryDescription();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryDescription <em>Repository Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Description</em>' attribute.
	 * @see #getRepositoryDescription()
	 * @generated
	 */
	void setRepositoryDescription(String value);

	/**
	 * Returns the value of the '<em><b>Repository Name</b></em>' attribute.
	 * The default value is <code>"New Component Model"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Name</em>' attribute.
	 * @see #setRepositoryName(String)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_RepositoryName()
	 * @model default="New Component Model" unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getRepositoryName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.Repository#getRepositoryName <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Name</em>' attribute.
	 * @see #getRepositoryName()
	 * @generated
	 */
	void setRepositoryName(String value);

	/**
	 * Returns the value of the '<em><b>Components Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_Components__Repository()
	 * @model type="de.uka.ipd.sdq.pcm.repository.ProvidesComponentType" containment="true" ordered="false"
	 * @generated
	 */
	EList getComponents__Repository();

	/**
	 * Returns the value of the '<em><b>Interfaces Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interfaces Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interfaces Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepository_Interfaces__Repository()
	 * @model type="de.uka.ipd.sdq.pcm.repository.Interface" containment="true" ordered="false"
	 * @generated
	 */
	EList getInterfaces__Repository();


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.compositeComponents->forAll(e : CompositeComponent |
	 *  e.oclIsTypeOf(CompositeComponent)
	 * )
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean GrantFirstClassEntityTypeCompositeComponent(DiagnosticChain diagnostics, Map context);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.providesComponentTypes->forAll(e : ProvidesComponentType |
	 *  e.oclIsTypeOf(ProvidesComponentType)
	 * )
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean GrantFirstClassEntityTypeProvidesComponentType(DiagnosticChain diagnostics, Map context);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.completeComponentTypes->forAll(e : CompleteComponentType |
	 *  e.oclIsTypeOf(CompleteComponentType)
	 * )
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean GrantFirstClassEntityTypeCompleteComponentType(DiagnosticChain diagnostics, Map context);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.implementationComponentTypes->forAll(e : ImplementationComponentType |
	 *  e.oclIsTypeOf(ImplementationComponentType)
	 * )
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean GrantFirstClassEntityTypeImplementationComponentType(DiagnosticChain diagnostics, Map context);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.basicComponents->forAll(e : BasicComponent |
	 *  e.oclIsTypeOf(BasicComponent)
	 * )
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean GrantFirstClassEntityTypeBasicComponent(DiagnosticChain diagnostics, Map context);

} // Repository