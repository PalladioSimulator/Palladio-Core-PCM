/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pipesandfilters.Filter#getSuccessors <em>Successors</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage#getFilter()
 * @model abstract="true"
 * @generated
 */
public interface Filter extends PipeElement {
	/**
	 * Returns the value of the '<em><b>Successors</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pipesandfilters.PipeElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successors</em>' reference list.
	 * @see de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage#getFilter_Successors()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<PipeElement> getSuccessors();

} // Filter
