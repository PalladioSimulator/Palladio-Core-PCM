/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Software Failure Types Parameter</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> This parameter refers to all software failure probabilities specified
 * for the given SoftwareInducedFailureType. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.sensitivity.SoftwareFailureTypesParameter#getSoftwareInducedFailureTypes__SoftwareFailureTypeReliabilityParameter
 * <em>Software Induced Failure Types Software Failure Type Reliability Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getSoftwareFailureTypesParameter()
 * @model
 * @generated
 */
public interface SoftwareFailureTypesParameter extends SingleSensitivityParameter {
    /**
     * Returns the value of the '
     * <em><b>Software Induced Failure Types Software Failure Type Reliability Parameter</b></em>'
     * reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '
     * <em>Software Induced Failure Types Software Failure Type Reliability Parameter</em>'
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '
     *         <em>Software Induced Failure Types Software Failure Type Reliability Parameter</em>'
     *         reference list.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getSoftwareFailureTypesParameter_SoftwareInducedFailureTypes__SoftwareFailureTypeReliabilityParameter()
     * @model required="true" ordered="false"
     * @generated
     */
    EList<SoftwareInducedFailureType> getSoftwareInducedFailureTypes__SoftwareFailureTypeReliabilityParameter();

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
    boolean SoftwareFailureTypeReliabilityParameterMustHaveDoubleVariation(DiagnosticChain diagnostics,
            Map<Object, Object> context);

} // SoftwareFailureTypesParameter
