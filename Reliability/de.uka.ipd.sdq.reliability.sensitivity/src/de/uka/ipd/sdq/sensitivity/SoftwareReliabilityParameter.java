/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Software Reliability Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This parameter refers to the set of all software failure probabilities specified for the given PCM instance. All
 * probabilities are altered together according to the same sequence of values.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getSoftwareReliabilityParameter()
 * @model
 * @generated
 */
public interface SoftwareReliabilityParameter extends SingleSensitivityParameter {
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
	boolean SoftwareReliabilityParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SoftwareReliabilityParameter
