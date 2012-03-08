/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getBranchProbabilities_ComputedUsageContext <em>Branch Probabilities Computed Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getLoopiterations_ComputedUsageContext <em>Loopiterations Computed Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getAssemblyContext_ComputedUsageContext <em>Assembly Context Computed Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getInput_ComputedUsageContext <em>Input Computed Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getExternalCallOutput_ComputedUsageContext <em>External Call Output Computed Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getExternalCallInput_ComputedUsageContext <em>External Call Input Computed Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getOutput_ComputedUsageContext <em>Output Computed Usage Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getComputedUsageContext()
 * @model
 * @generated
 */
public interface ComputedUsageContext extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Returns the value of the '<em><b>Branch Probabilities Computed Usage Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.computed_usage.BranchProbability}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Probabilities Computed Usage Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Probabilities Computed Usage Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getComputedUsageContext_BranchProbabilities_ComputedUsageContext()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<BranchProbability> getBranchProbabilities_ComputedUsageContext();

	/**
	 * Returns the value of the '<em><b>Loopiterations Computed Usage Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.computed_usage.LoopIteration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loopiterations Computed Usage Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loopiterations Computed Usage Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getComputedUsageContext_Loopiterations_ComputedUsageContext()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<LoopIteration> getLoopiterations_ComputedUsageContext();

	/**
	 * Returns the value of the '<em><b>Assembly Context Computed Usage Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Computed Usage Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Computed Usage Context</em>' reference.
	 * @see #setAssemblyContext_ComputedUsageContext(AssemblyContext)
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getComputedUsageContext_AssemblyContext_ComputedUsageContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext_ComputedUsageContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getAssemblyContext_ComputedUsageContext <em>Assembly Context Computed Usage Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Computed Usage Context</em>' reference.
	 * @see #getAssemblyContext_ComputedUsageContext()
	 * @generated
	 */
	void setAssemblyContext_ComputedUsageContext(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Input Computed Usage Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Computed Usage Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Computed Usage Context</em>' containment reference.
	 * @see #setInput_ComputedUsageContext(Input)
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getComputedUsageContext_Input_ComputedUsageContext()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Input getInput_ComputedUsageContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getInput_ComputedUsageContext <em>Input Computed Usage Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Computed Usage Context</em>' containment reference.
	 * @see #getInput_ComputedUsageContext()
	 * @generated
	 */
	void setInput_ComputedUsageContext(Input value);

	/**
	 * Returns the value of the '<em><b>External Call Output Computed Usage Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Call Output Computed Usage Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Call Output Computed Usage Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getComputedUsageContext_ExternalCallOutput_ComputedUsageContext()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ExternalCallOutput> getExternalCallOutput_ComputedUsageContext();

	/**
	 * Returns the value of the '<em><b>External Call Input Computed Usage Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.computed_usage.ExternalCallInput}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getComputedUsageContext_ExternalCallInput <em>Computed Usage Context External Call Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Call Input Computed Usage Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Call Input Computed Usage Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getComputedUsageContext_ExternalCallInput_ComputedUsageContext()
	 * @see de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getComputedUsageContext_ExternalCallInput
	 * @model opposite="computedUsageContext_ExternalCallInput" containment="true" ordered="false"
	 * @generated
	 */
	EList<ExternalCallInput> getExternalCallInput_ComputedUsageContext();

	/**
	 * Returns the value of the '<em><b>Output Computed Usage Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Computed Usage Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Computed Usage Context</em>' containment reference.
	 * @see #setOutput_ComputedUsageContext(Output)
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getComputedUsageContext_Output_ComputedUsageContext()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Output getOutput_ComputedUsageContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getOutput_ComputedUsageContext <em>Output Computed Usage Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Computed Usage Context</em>' containment reference.
	 * @see #getOutput_ComputedUsageContext()
	 * @generated
	 */
	void setOutput_ComputedUsageContext(Output value);

} // ComputedUsageContext
