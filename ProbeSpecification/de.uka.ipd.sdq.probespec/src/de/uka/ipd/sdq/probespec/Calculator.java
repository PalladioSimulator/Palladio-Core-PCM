/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pipesandfilters.PipeElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Calculator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probespec.Calculator#isActive <em>Active</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.probespec.Calculator#getPipeElement <em>Pipe Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.probespec.probespecPackage#getCalculator()
 * @model abstract="true"
 * @generated
 */
public interface Calculator extends Identifier {
	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see de.uka.ipd.sdq.probespec.probespecPackage#getCalculator_Active()
	 * @model default="true" required="true" ordered="false"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.probespec.Calculator#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Pipe Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pipe Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipe Element</em>' reference.
	 * @see #setPipeElement(PipeElement)
	 * @see de.uka.ipd.sdq.probespec.probespecPackage#getCalculator_PipeElement()
	 * @model ordered="false"
	 * @generated
	 */
	PipeElement getPipeElement();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.probespec.Calculator#getPipeElement <em>Pipe Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pipe Element</em>' reference.
	 * @see #getPipeElement()
	 * @generated
	 */
	void setPipeElement(PipeElement value);

} // Calculator
