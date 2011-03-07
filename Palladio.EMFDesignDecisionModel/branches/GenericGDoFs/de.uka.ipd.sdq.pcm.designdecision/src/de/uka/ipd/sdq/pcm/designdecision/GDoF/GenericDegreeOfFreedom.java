/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.GDoF;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Degree Of Freedom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.GenericDegreeOfFreedom#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.GenericDegreeOfFreedom#getAddedElements <em>Added Elements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.GenericDegreeOfFreedom#getChangeableElementDescription <em>Changeable Element Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.GenericDegreeOfFreedom#getInteractionConstraint <em>Interaction Constraint</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.GenericDegreeOfFreedom#getPrimaryChangeable <em>Primary Changeable</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getGenericDegreeOfFreedom()
 * @model
 * @generated
 */
public interface GenericDegreeOfFreedom extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getGenericDegreeOfFreedom_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.GenericDegreeOfFreedom#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Added Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Added Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Added Elements</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getGenericDegreeOfFreedom_AddedElements()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EClass> getAddedElements();

	/**
	 * Returns the value of the '<em><b>Changeable Element Description</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.designdecision.GDoF.ChangeableElementDescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changeable Element Description</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changeable Element Description</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getGenericDegreeOfFreedom_ChangeableElementDescription()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ChangeableElementDescription> getChangeableElementDescription();

	/**
	 * Returns the value of the '<em><b>Interaction Constraint</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interaction Constraint</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction Constraint</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getGenericDegreeOfFreedom_InteractionConstraint()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EOperation> getInteractionConstraint();

	/**
	 * Returns the value of the '<em><b>Primary Changeable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Changeable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Changeable</em>' reference.
	 * @see #setPrimaryChangeable(ChangeableElementDescription)
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getGenericDegreeOfFreedom_PrimaryChangeable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ChangeableElementDescription getPrimaryChangeable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.GenericDegreeOfFreedom#getPrimaryChangeable <em>Primary Changeable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Changeable</em>' reference.
	 * @see #getPrimaryChangeable()
	 * @generated
	 */
	void setPrimaryChangeable(ChangeableElementDescription value);

} // GenericDegreeOfFreedom
