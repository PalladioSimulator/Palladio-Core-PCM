/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Description#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Description#getTextualDescription <em>Textual Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Description#getRepository <em>Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getDescription()
 * @model abstract="true"
 * @generated
 */
public interface Description extends Identifiable {
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
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getDescription_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Description#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Textual Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Textual Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Textual Description</em>' attribute.
	 * @see #setTextualDescription(String)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getDescription_TextualDescription()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getTextualDescription();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Description#getTextualDescription <em>Textual Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Textual Description</em>' attribute.
	 * @see #getTextualDescription()
	 * @generated
	 */
	void setTextualDescription(String value);

	/**
	 * Returns the value of the '<em><b>Repository</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository</em>' reference.
	 * @see #setRepository(Repository)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getDescription_Repository()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository#getDescription
	 * @model opposite="description" ordered="false"
	 * @generated
	 */
	Repository getRepository();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Description#getRepository <em>Repository</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository</em>' reference.
	 * @see #getRepository()
	 * @generated
	 */
	void setRepository(Repository value);

} // Description
