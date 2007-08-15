/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

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
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getParameterUsages_ComputedUsageContext <em>Parameter Usages Computed Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getAssemblyContext_ComputedUsageContext <em>Assembly Context Computed Usage Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getComputedUsageContext()
 * @model
 * @generated
 */
public interface ComputedUsageContext extends EObject {
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
	 * @model type="de.uka.ipd.sdq.context.computed_usage.BranchProbability" containment="true" ordered="false"
	 * @generated
	 */
	EList getBranchProbabilities_ComputedUsageContext();

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
	 * @model type="de.uka.ipd.sdq.context.computed_usage.LoopIteration" containment="true" ordered="false"
	 * @generated
	 */
	EList getLoopiterations_ComputedUsageContext();

	/**
	 * Returns the value of the '<em><b>Parameter Usages Computed Usage Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Usages Computed Usage Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Usages Computed Usage Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getComputedUsageContext_ParameterUsages_ComputedUsageContext()
	 * @model type="de.uka.ipd.sdq.pcm.parameter.VariableUsage" containment="true" ordered="false"
	 * @generated
	 */
	EList getParameterUsages_ComputedUsageContext();

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

} // ComputedUsageContext
