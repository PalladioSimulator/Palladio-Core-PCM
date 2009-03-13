/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.ByBench.SequenceElement#getSuccessor <em>Successor</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getSequenceElement()
 * @model
 * @generated
 */
public interface SequenceElement extends Identifier {
	/**
	 * Returns the value of the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor</em>' reference.
	 * @see #setSuccessor(SequenceElement)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getSequenceElement_Successor()
	 * @model ordered="false"
	 * @generated
	 */
	SequenceElement getSuccessor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.SequenceElement#getSuccessor <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor</em>' reference.
	 * @see #getSuccessor()
	 * @generated
	 */
	void setSuccessor(SequenceElement value);

} // SequenceElement
