/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.usage;

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
 *   <li>{@link de.uka.ipd.sdq.context.usage.UsageContext#getBranchprobabilities_UsageContext <em>Branchprobabilities Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.usage.UsageContext#getLoopiterations_UsageContext <em>Loopiterations Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.usage.UsageContext#getActualParameterUsage_UsageContext <em>Actual Parameter Usage Usage Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.usage.UsagePackage#getUsageContext()
 * @model
 * @generated
 */
public interface UsageContext extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Returns the value of the '<em><b>Branchprobabilities Usage Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.usage.BranchProbability}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branchprobabilities Usage Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branchprobabilities Usage Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.usage.UsagePackage#getUsageContext_Branchprobabilities_UsageContext()
	 * @model type="de.uka.ipd.sdq.context.usage.BranchProbability" containment="true" ordered="false"
	 * @generated
	 */
	EList getBranchprobabilities_UsageContext();

	/**
	 * Returns the value of the '<em><b>Loopiterations Usage Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.usage.LoopIteration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loopiterations Usage Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loopiterations Usage Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.usage.UsagePackage#getUsageContext_Loopiterations_UsageContext()
	 * @model type="de.uka.ipd.sdq.context.usage.LoopIteration" containment="true" ordered="false"
	 * @generated
	 */
	EList getLoopiterations_UsageContext();

	/**
	 * Returns the value of the '<em><b>Actual Parameter Usage Usage Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Parameter Usage Usage Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Parameter Usage Usage Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.usage.UsagePackage#getUsageContext_ActualParameterUsage_UsageContext()
	 * @model type="de.uka.ipd.sdq.pcm.parameter.VariableUsage" containment="true" ordered="false"
	 * @generated
	 */
	EList getActualParameterUsage_UsageContext();

} // UsageContext
