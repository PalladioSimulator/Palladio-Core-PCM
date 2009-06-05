/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.Mapping#getSource <em>Source</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.Mapping#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Identifier)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	Identifier getSource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.Mapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Identifier value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Identifier)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	Identifier getTarget();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.Mapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Identifier value);

} // Mapping
