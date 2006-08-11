
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usage Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.UsageModel#getUsageScenario_UsageModel <em>Usage Scenario Usage Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getUsageModel()
 * @model
 * @generated
 */
public interface UsageModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Usage Scenario Usage Model</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.usagemodel.UsageScenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Scenario Usage Model</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Scenario Usage Model</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getUsageModel_UsageScenario_UsageModel()
	 * @model type="de.uka.ipd.sdq.pcm.usagemodel.UsageScenario" containment="true" ordered="false"
	 * @generated
	 */
	EList getUsageScenario_UsageModel();

} // UsageModel