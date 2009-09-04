/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.CategoryIdentifier#getStateLiteral <em>State Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getCategoryIdentifier()
 * @model
 * @generated
 */
public interface CategoryIdentifier extends Identifiable {
	/**
	 * Returns the value of the '<em><b>State Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Literal</em>' attribute.
	 * @see #setStateLiteral(String)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getCategoryIdentifier_StateLiteral()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getStateLiteral();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.CategoryIdentifier#getStateLiteral <em>State Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Literal</em>' attribute.
	 * @see #getStateLiteral()
	 * @generated
	 */
	void setStateLiteral(String value);

} // CategoryIdentifier
