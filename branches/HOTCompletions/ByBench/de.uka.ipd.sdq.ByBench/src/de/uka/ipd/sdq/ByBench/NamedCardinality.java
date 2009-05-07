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
 * A representation of the model object '<em><b>Named Cardinality</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.ByBench.NamedCardinality#getCardinalityValue <em>Cardinality Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.NamedCardinality#getCardinalityName <em>Cardinality Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.NamedCardinality#getInstructionchaining <em>Instructionchaining</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.NamedCardinality#getInstructionlooping <em>Instructionlooping</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getNamedCardinality()
 * @model
 * @generated
 */
public interface NamedCardinality extends Identifier {
	/**
	 * Returns the value of the '<em><b>Cardinality Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality Value</em>' attribute.
	 * @see #setCardinalityValue(int)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getNamedCardinality_CardinalityValue()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getCardinalityValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.NamedCardinality#getCardinalityValue <em>Cardinality Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality Value</em>' attribute.
	 * @see #getCardinalityValue()
	 * @generated
	 */
	void setCardinalityValue(int value);

	/**
	 * Returns the value of the '<em><b>Cardinality Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality Name</em>' attribute.
	 * @see #setCardinalityName(String)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getNamedCardinality_CardinalityName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getCardinalityName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.NamedCardinality#getCardinalityName <em>Cardinality Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality Name</em>' attribute.
	 * @see #getCardinalityName()
	 * @generated
	 */
	void setCardinalityName(String value);

	/**
	 * Returns the value of the '<em><b>Instructionchaining</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.ByBench.InstructionChaining}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.ByBench.InstructionChaining#getNamedcardinality <em>Namedcardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instructionchaining</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instructionchaining</em>' reference list.
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getNamedCardinality_Instructionchaining()
	 * @see de.uka.ipd.sdq.ByBench.InstructionChaining#getNamedcardinality
	 * @model opposite="namedcardinality" required="true" ordered="false"
	 * @generated
	 */
	EList<InstructionChaining> getInstructionchaining();

	/**
	 * Returns the value of the '<em><b>Instructionlooping</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.ByBench.InstructionLooping}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.ByBench.InstructionLooping#getNamedcardinality <em>Namedcardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instructionlooping</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instructionlooping</em>' reference list.
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getNamedCardinality_Instructionlooping()
	 * @see de.uka.ipd.sdq.ByBench.InstructionLooping#getNamedcardinality
	 * @model opposite="namedcardinality" required="true" ordered="false"
	 * @generated
	 */
	EList<InstructionLooping> getInstructionlooping();

} // NamedCardinality
