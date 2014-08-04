/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Probabilistic Branch Parameter</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> This&nbsp;parameter&nbsp;refers&nbsp;to&nbsp;a&nbsp;branch
 * transition&nbsp
 * ;probability&nbsp;specified&nbsp;in&nbsp;the&nbsp;context&nbsp;of&nbsp;the&nbsp;given
 * ProbabilisticBranchTransition. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.sensitivity.ProbabilisticBranchParameter#getProbabilisticBranchTransition__ProbabilisticBranchParameter
 * <em>Probabilistic Branch Transition Probabilistic Branch Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getProbabilisticBranchParameter()
 * @model
 * @generated
 */
public interface ProbabilisticBranchParameter extends SingleSensitivityParameter {
    /**
     * Returns the value of the '
     * <em><b>Probabilistic Branch Transition Probabilistic Branch Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '
     * <em>Probabilistic Branch Transition Probabilistic Branch Parameter</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '
     *         <em>Probabilistic Branch Transition Probabilistic Branch Parameter</em>' reference.
     * @see #setProbabilisticBranchTransition__ProbabilisticBranchParameter(ProbabilisticBranchTransition)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getProbabilisticBranchParameter_ProbabilisticBranchTransition__ProbabilisticBranchParameter()
     * @model required="true" ordered="false"
     * @generated
     */
    ProbabilisticBranchTransition getProbabilisticBranchTransition__ProbabilisticBranchParameter();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.sensitivity.ProbabilisticBranchParameter#getProbabilisticBranchTransition__ProbabilisticBranchParameter
     * <em>Probabilistic Branch Transition Probabilistic Branch Parameter</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '
     *            <em>Probabilistic Branch Transition Probabilistic Branch Parameter</em>'
     *            reference.
     * @see #getProbabilisticBranchTransition__ProbabilisticBranchParameter()
     * @generated
     */
    void setProbabilisticBranchTransition__ProbabilisticBranchParameter(ProbabilisticBranchTransition value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * self.sensitivityParameterVariation__SingleSensitivityParameter
     * .oclIsTypeOf(DoubleParameterVariation)
     * 
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean ProbabilisticBranchParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ProbabilisticBranchParameter
