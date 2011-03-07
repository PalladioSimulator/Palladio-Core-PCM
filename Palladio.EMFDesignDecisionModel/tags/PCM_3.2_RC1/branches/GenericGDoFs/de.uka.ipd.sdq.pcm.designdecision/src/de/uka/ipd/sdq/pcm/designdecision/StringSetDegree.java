/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Set Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.StringSetDegree#getStringValues <em>String Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getStringSetDegree()
 * @model abstract="true"
 * @generated
 */
public interface StringSetDegree extends UnorderedDegree {
	/**
	 * Returns the value of the '<em><b>String Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Values</em>' attribute list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getStringSetDegree_StringValues()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<String> getStringValues();

} // StringSetDegree
