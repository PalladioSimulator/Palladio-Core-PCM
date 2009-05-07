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
 * A representation of the model object '<em><b>Instruction Chaining</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.ByBench.InstructionChaining#getInstructionsequence <em>Instructionsequence</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.InstructionChaining#getNamedcardinality <em>Namedcardinality</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getInstructionChaining()
 * @model
 * @generated
 */
public interface InstructionChaining extends SequenceElement, Identifier {
	/**
	 * Returns the value of the '<em><b>Instructionsequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instructionsequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instructionsequence</em>' containment reference.
	 * @see #setInstructionsequence(InstructionSequence)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getInstructionChaining_Instructionsequence()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	InstructionSequence getInstructionsequence();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.InstructionChaining#getInstructionsequence <em>Instructionsequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instructionsequence</em>' containment reference.
	 * @see #getInstructionsequence()
	 * @generated
	 */
	void setInstructionsequence(InstructionSequence value);

	/**
	 * Returns the value of the '<em><b>Namedcardinality</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.ByBench.NamedCardinality#getInstructionchaining <em>Instructionchaining</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namedcardinality</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namedcardinality</em>' reference.
	 * @see #setNamedcardinality(NamedCardinality)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getInstructionChaining_Namedcardinality()
	 * @see de.uka.ipd.sdq.ByBench.NamedCardinality#getInstructionchaining
	 * @model opposite="instructionchaining" required="true" ordered="false"
	 * @generated
	 */
	NamedCardinality getNamedcardinality();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.InstructionChaining#getNamedcardinality <em>Namedcardinality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namedcardinality</em>' reference.
	 * @see #getNamedcardinality()
	 * @generated
	 */
	void setNamedcardinality(NamedCardinality value);

} // InstructionChaining
