/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usage Branch Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This&nbsp;parameter&nbsp;refers&nbsp;to&nbsp;a&nbsp;branch&nbsp;transition&nbsp;probability&nbsp;specified&nbsp;in&nbsp;the&nbsp;context&nbsp;of&nbsp;the&nbsp;given&nbsp;user
 * Branch.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.UsageBranchParameter#getBranch__UsageBranchParameter <em>Branch Usage Branch Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.UsageBranchParameter#getScenarioBehaviour__UsageBranchParameter <em>Scenario Behaviour Usage Branch Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getUsageBranchParameter()
 * @model
 * @generated
 */
public interface UsageBranchParameter extends SingleSensitivityParameter {
	/**
     * Returns the value of the '<em><b>Branch Usage Branch Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Usage Branch Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Branch Usage Branch Parameter</em>' reference.
     * @see #setBranch__UsageBranchParameter(Branch)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getUsageBranchParameter_Branch__UsageBranchParameter()
     * @model required="true" ordered="false"
     * @generated
     */
	Branch getBranch__UsageBranchParameter();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.UsageBranchParameter#getBranch__UsageBranchParameter <em>Branch Usage Branch Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Branch Usage Branch Parameter</em>' reference.
     * @see #getBranch__UsageBranchParameter()
     * @generated
     */
	void setBranch__UsageBranchParameter(Branch value);

	/**
     * Returns the value of the '<em><b>Scenario Behaviour Usage Branch Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenario Behaviour Usage Branch Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Scenario Behaviour Usage Branch Parameter</em>' reference.
     * @see #setScenarioBehaviour__UsageBranchParameter(ScenarioBehaviour)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getUsageBranchParameter_ScenarioBehaviour__UsageBranchParameter()
     * @model required="true" ordered="false"
     * @generated
     */
	ScenarioBehaviour getScenarioBehaviour__UsageBranchParameter();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.UsageBranchParameter#getScenarioBehaviour__UsageBranchParameter <em>Scenario Behaviour Usage Branch Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Scenario Behaviour Usage Branch Parameter</em>' reference.
     * @see #getScenarioBehaviour__UsageBranchParameter()
     * @generated
     */
	void setScenarioBehaviour__UsageBranchParameter(ScenarioBehaviour value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.sensitivityParameterVariation__SingleSensitivityParameter.oclIsTypeOf(DoubleParameterVariation)
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
	boolean UsageBranchParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // UsageBranchParameter
