/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Creation Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter#getN <em>N</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter#getTargetId <em>Target Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathsCreationParameter()
 * @model
 * @generated
 */
public interface JJnPathsCreationParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>N</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>N</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>N</em>' attribute.
	 * @see #setN(int)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathsCreationParameter_N()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getN();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter#getN <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>N</em>' attribute.
	 * @see #getN()
	 * @generated
	 */
	void setN(int value);

	/**
	 * Returns the value of the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Id</em>' attribute.
	 * @see #setTargetId(String)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathsCreationParameter_TargetId()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getTargetId();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter#getTargetId <em>Target Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Id</em>' attribute.
	 * @see #getTargetId()
	 * @generated
	 */
	void setTargetId(String value);

} // JJnPathsCreationParameter
