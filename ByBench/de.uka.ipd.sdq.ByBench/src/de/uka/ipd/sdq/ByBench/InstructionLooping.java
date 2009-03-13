/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instruction Looping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.ByBench.InstructionLooping#getInstructionsequence <em>Instructionsequence</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.InstructionLooping#getNamedcardinality <em>Namedcardinality</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getInstructionLooping()
 * @model
 * @generated
 */
public interface InstructionLooping extends SequenceElement, Identifier {
	/**
	 * Returns the value of the '<em><b>Instructionsequence</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.ByBench.InstructionSequence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instructionsequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instructionsequence</em>' containment reference list.
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getInstructionLooping_Instructionsequence()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<InstructionSequence> getInstructionsequence();

	/**
	 * Returns the value of the '<em><b>Namedcardinality</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.ByBench.NamedCardinality#getInstructionlooping <em>Instructionlooping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namedcardinality</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namedcardinality</em>' reference.
	 * @see #setNamedcardinality(NamedCardinality)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getInstructionLooping_Namedcardinality()
	 * @see de.uka.ipd.sdq.ByBench.NamedCardinality#getInstructionlooping
	 * @model opposite="instructionlooping" required="true" ordered="false"
	 * @generated
	 */
	NamedCardinality getNamedcardinality();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.InstructionLooping#getNamedcardinality <em>Namedcardinality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namedcardinality</em>' reference.
	 * @see #getNamedcardinality()
	 * @generated
	 */
	void setNamedcardinality(NamedCardinality value);

} // InstructionLooping
