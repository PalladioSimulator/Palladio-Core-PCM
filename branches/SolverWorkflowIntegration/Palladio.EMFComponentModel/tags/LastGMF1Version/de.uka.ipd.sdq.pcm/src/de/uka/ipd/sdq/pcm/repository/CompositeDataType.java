
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeDataType#getParentType_CompositeDataType <em>Parent Type Composite Data Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeDataType#getInnerDeclaration_CompositeDataType <em>Inner Declaration Composite Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeDataType()
 * @model
 * @generated
 */
public interface CompositeDataType extends Entity, DataType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Parent Type Composite Data Type</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.CompositeDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Type Composite Data Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Type Composite Data Type</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeDataType_ParentType_CompositeDataType()
	 * @model type="de.uka.ipd.sdq.pcm.repository.CompositeDataType" ordered="false"
	 * @generated
	 */
	EList getParentType_CompositeDataType();

	/**
	 * Returns the value of the '<em><b>Inner Declaration Composite Data Type</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.InnerDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Declaration Composite Data Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Declaration Composite Data Type</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeDataType_InnerDeclaration_CompositeDataType()
	 * @model type="de.uka.ipd.sdq.pcm.repository.InnerDeclaration" containment="true" ordered="false"
	 * @generated
	 */
	EList getInnerDeclaration_CompositeDataType();

} // CompositeDataType