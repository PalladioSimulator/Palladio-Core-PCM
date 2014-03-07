/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import de.uka.ipd.sdq.edp2.models.Repository.Repository;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Description#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Description#getTextualDescription <em>Textual Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Description#getRepository <em>Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Description#getDescriptions <em>Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getDescription()
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
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getDescription_Name()
     * @model required="true" ordered="false"
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Description#getName <em>Name</em>}' attribute.
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
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getDescription_TextualDescription()
     * @model required="true" ordered="false"
     * @generated
     */
	String getTextualDescription();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Description#getTextualDescription <em>Textual Description</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Textual Description</em>' attribute.
     * @see #getTextualDescription()
     * @generated
     */
	void setTextualDescription(String value);

	/**
     * Returns the value of the '<em><b>Repository</b></em>' reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.Repository.Repository#getDescriptions <em>Descriptions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Repository in which this description is stored.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Repository</em>' reference.
     * @see #setRepository(Repository)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getDescription_Repository()
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repository#getDescriptions
     * @model opposite="descriptions" transient="true" ordered="false"
     * @generated
     */
	Repository getRepository();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Description#getRepository <em>Repository</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Repository</em>' reference.
     * @see #getRepository()
     * @generated
     */
	void setRepository(Repository value);

	/**
     * Returns the value of the '<em><b>Descriptions</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Descriptions#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptions</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Descriptions</em>' container reference.
     * @see #setDescriptions(Descriptions)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getDescription_Descriptions()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Descriptions#getDescription
     * @model opposite="description" required="true" transient="false" ordered="false"
     * @generated
     */
	Descriptions getDescriptions();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Description#getDescriptions <em>Descriptions</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Descriptions</em>' container reference.
     * @see #getDescriptions()
     * @generated
     */
	void setDescriptions(Descriptions value);

} // Description
