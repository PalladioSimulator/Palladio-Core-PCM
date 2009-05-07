/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench;

import de.uka.ipd.sdq.identifier.Identifier;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.ByBench.AtomicInstruction#getParameterValue <em>Parameter Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.AtomicInstruction#getParameterConversion <em>Parameter Conversion</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.AtomicInstruction#getOpcode <em>Opcode</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getAtomicInstruction()
 * @model
 * @generated
 */
public interface AtomicInstruction extends SequenceElement, Identifier {
	/**
	 * Returns the value of the '<em><b>Parameter Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Value</em>' attribute.
	 * @see #setParameterValue(Object)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getAtomicInstruction_ParameterValue()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Object getParameterValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.AtomicInstruction#getParameterValue <em>Parameter Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Value</em>' attribute.
	 * @see #getParameterValue()
	 * @generated
	 */
	void setParameterValue(Object value);

	/**
	 * Returns the value of the '<em><b>Parameter Conversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Conversion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Conversion</em>' attribute.
	 * @see #setParameterConversion(int)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getAtomicInstruction_ParameterConversion()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getParameterConversion();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.AtomicInstruction#getParameterConversion <em>Parameter Conversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Conversion</em>' attribute.
	 * @see #getParameterConversion()
	 * @generated
	 */
	void setParameterConversion(int value);

	/**
	 * Returns the value of the '<em><b>Opcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opcode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opcode</em>' attribute.
	 * @see #setOpcode(int)
	 * @see de.uka.ipd.sdq.ByBench.ByBenchPackage#getAtomicInstruction_Opcode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getOpcode();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.ByBench.AtomicInstruction#getOpcode <em>Opcode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opcode</em>' attribute.
	 * @see #getOpcode()
	 * @generated
	 */
	void setOpcode(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.opcode > 0 and  self.opcode < 256
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ensureValidOpcode(DiagnosticChain diagnostics, Map context);

} // AtomicInstruction
