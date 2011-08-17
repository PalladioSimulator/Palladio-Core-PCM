/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipes And Filters Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pipesandfilters.PipesAndFiltersRepository#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage#getPipesAndFiltersRepository()
 * @model
 * @generated
 */
public interface PipesAndFiltersRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pipesandfilters.PipeElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage#getPipesAndFiltersRepository_Elements()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PipeElement> getElements();

} // PipesAndFiltersRepository
