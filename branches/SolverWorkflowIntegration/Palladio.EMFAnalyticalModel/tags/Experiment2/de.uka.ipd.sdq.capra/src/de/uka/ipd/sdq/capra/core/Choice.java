/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.Choice#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getChoice()
 * @model
 * @generated
 */
public interface Choice extends Operator {
	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.core.ExternalSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getChoice_Options()
	 * @model type="de.uka.ipd.sdq.capra.core.ExternalSelector" containment="true"
	 * @generated
	 */
	EList<ExternalSelector> getOptions();

} // Choice
