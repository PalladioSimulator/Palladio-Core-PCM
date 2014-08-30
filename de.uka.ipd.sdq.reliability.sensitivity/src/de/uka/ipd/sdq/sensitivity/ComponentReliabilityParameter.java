/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Component Reliability Parameter</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> This parameter refers to the set of all software failure probabilities
 * specified in the context of the given BasicComponent. All software failure probabilities are
 * altered together according to the same sequence of values. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter#getBasicComponent__ComponentReliabilityParameter
 * <em>Basic Component Component Reliability Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getComponentReliabilityParameter()
 * @model
 * @generated
 */
public interface ComponentReliabilityParameter extends SingleSensitivityParameter {
    /**
     * Returns the value of the '<em><b>Basic Component Component Reliability Parameter</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Basic Component Component Reliability Parameter</em>' reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Basic Component Component Reliability Parameter</em>'
     *         reference.
     * @see #setBasicComponent__ComponentReliabilityParameter(BasicComponent)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getComponentReliabilityParameter_BasicComponent__ComponentReliabilityParameter()
     * @model required="true" ordered="false"
     * @generated
     */
    BasicComponent getBasicComponent__ComponentReliabilityParameter();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter#getBasicComponent__ComponentReliabilityParameter
     * <em>Basic Component Component Reliability Parameter</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Basic Component Component Reliability Parameter</em>'
     *            reference.
     * @see #getBasicComponent__ComponentReliabilityParameter()
     * @generated
     */
    void setBasicComponent__ComponentReliabilityParameter(BasicComponent value);

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
    boolean ComponentReliabilityParameterMustHaveDoubleVariation(DiagnosticChain diagnostics,
            Map<Object, Object> context);

} // ComponentReliabilityParameter
