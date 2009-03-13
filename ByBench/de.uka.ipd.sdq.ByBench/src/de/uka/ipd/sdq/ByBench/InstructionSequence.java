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
 * A representation of the model object '<em><b>Instruction Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.ByBench.InstructionSequence#getSequenceelement <em>Sequenceelement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getInstructionSequence()
 * @model
 * @generated
 */
public interface InstructionSequence extends Identifier {
	/**
	 * Returns the value of the '<em><b>Sequenceelement</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.ByBench.SequenceElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequenceelement</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequenceelement</em>' containment reference list.
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getInstructionSequence_Sequenceelement()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SequenceElement> getSequenceelement();

} // InstructionSequence
