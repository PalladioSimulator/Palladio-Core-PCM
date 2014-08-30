/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType;
import de.uka.ipd.sdq.pcm.seff.InternalAction;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Internal Action Reliability Parameter</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> This&nbsp;parameter&nbsp;refers&nbsp;to&nbsp;a
 * software&nbsp;failure&nbsp
 * ;probability&nbsp;specified&nbsp;in&nbsp;the&nbsp;context&nbsp;of&nbsp;the&nbsp;given
 * InternalAction for the given SoftwareInducedFailureType. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter#getSoftwareInducedFailureType__InternalActionReliabilityParameter
 * <em>Software Induced Failure Type Internal Action Reliability Parameter</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter#getInternalAction__InternalActionReliabilityParameter
 * <em>Internal Action Internal Action Reliability Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getInternalActionReliabilityParameter()
 * @model
 * @generated
 */
public interface InternalActionReliabilityParameter extends SingleSensitivityParameter {
    /**
     * Returns the value of the '
     * <em><b>Software Induced Failure Type Internal Action Reliability Parameter</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '
     * <em>Software Induced Failure Type Internal Action Reliability Parameter</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '
     *         <em>Software Induced Failure Type Internal Action Reliability Parameter</em>'
     *         reference.
     * @see #setSoftwareInducedFailureType__InternalActionReliabilityParameter(SoftwareInducedFailureType)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getInternalActionReliabilityParameter_SoftwareInducedFailureType__InternalActionReliabilityParameter()
     * @model required="true" ordered="false"
     * @generated
     */
    SoftwareInducedFailureType getSoftwareInducedFailureType__InternalActionReliabilityParameter();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter#getSoftwareInducedFailureType__InternalActionReliabilityParameter
     * <em>Software Induced Failure Type Internal Action Reliability Parameter</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '
     *            <em>Software Induced Failure Type Internal Action Reliability Parameter</em>'
     *            reference.
     * @see #getSoftwareInducedFailureType__InternalActionReliabilityParameter()
     * @generated
     */
    void setSoftwareInducedFailureType__InternalActionReliabilityParameter(SoftwareInducedFailureType value);

    /**
     * Returns the value of the '
     * <em><b>Internal Action Internal Action Reliability Parameter</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Internal Action Internal Action Reliability Parameter</em>'
     * reference isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Internal Action Internal Action Reliability Parameter</em>'
     *         reference.
     * @see #setInternalAction__InternalActionReliabilityParameter(InternalAction)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getInternalActionReliabilityParameter_InternalAction__InternalActionReliabilityParameter()
     * @model required="true" ordered="false"
     * @generated
     */
    InternalAction getInternalAction__InternalActionReliabilityParameter();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter#getInternalAction__InternalActionReliabilityParameter
     * <em>Internal Action Internal Action Reliability Parameter</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '
     *            <em>Internal Action Internal Action Reliability Parameter</em>' reference.
     * @see #getInternalAction__InternalActionReliabilityParameter()
     * @generated
     */
    void setInternalAction__InternalActionReliabilityParameter(InternalAction value);

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
    boolean InternalActionReliabilityParameterMustHaveDoubleVariation(DiagnosticChain diagnostics,
            Map<Object, Object> context);

} // InternalActionReliabilityParameter
