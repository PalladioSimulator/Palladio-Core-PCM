/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.Choice#getDesigndecision <em>Designdecision</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getChoice()
 * @model abstract="true"
 * @generated
 */
public interface Choice extends EObject {
	/**
	 * Returns the value of the '<em><b>Designdecision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Designdecision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Designdecision</em>' reference.
	 * @see #setDesigndecision(DesignDecision)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getChoice_Designdecision()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DesignDecision getDesigndecision();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.Choice#getDesigndecision <em>Designdecision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Designdecision</em>' reference.
	 * @see #getDesigndecision()
	 * @generated
	 */
	void setDesigndecision(DesignDecision value);

} // Choice
