/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Observed Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedCategory#getCategoryIdentifier <em>Category Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getObservedCategory()
 * @model
 * @generated
 */
public interface ObservedCategory extends EObject {
	/**
	 * Returns the value of the '<em><b>Category Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category Identifier</em>' reference.
	 * @see #setCategoryIdentifier(CategoryIdentifier)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getObservedCategory_CategoryIdentifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CategoryIdentifier getCategoryIdentifier();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedCategory#getCategoryIdentifier <em>Category Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category Identifier</em>' reference.
	 * @see #getCategoryIdentifier()
	 * @generated
	 */
	void setCategoryIdentifier(CategoryIdentifier value);

} // ObservedCategory
