/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Resource MTTF Parameter</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> This parameter refers to an MTTF value&nbsp;of a given
 * ProcessingResourceSpecification. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter#getProcessingResourceType__ResourceMTTFParameter
 * <em>Processing Resource Type Resource MTTF Parameter</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter#getResourceContainer__ResourceMTTFParameter
 * <em>Resource Container Resource MTTF Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getResourceMTTFParameter()
 * @model
 * @generated
 */
public interface ResourceMTTFParameter extends SingleSensitivityParameter {
    /**
     * Returns the value of the '<em><b>Processing Resource Type Resource MTTF Parameter</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Processing Resource Type Resource MTTF Parameter</em>' reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Processing Resource Type Resource MTTF Parameter</em>'
     *         reference.
     * @see #setProcessingResourceType__ResourceMTTFParameter(ProcessingResourceType)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getResourceMTTFParameter_ProcessingResourceType__ResourceMTTFParameter()
     * @model required="true" ordered="false"
     * @generated
     */
    ProcessingResourceType getProcessingResourceType__ResourceMTTFParameter();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter#getProcessingResourceType__ResourceMTTFParameter
     * <em>Processing Resource Type Resource MTTF Parameter</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Processing Resource Type Resource MTTF Parameter</em>'
     *            reference.
     * @see #getProcessingResourceType__ResourceMTTFParameter()
     * @generated
     */
    void setProcessingResourceType__ResourceMTTFParameter(ProcessingResourceType value);

    /**
     * Returns the value of the '<em><b>Resource Container Resource MTTF Parameter</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Container Resource MTTF Parameter</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Resource Container Resource MTTF Parameter</em>' reference.
     * @see #setResourceContainer__ResourceMTTFParameter(ResourceContainer)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getResourceMTTFParameter_ResourceContainer__ResourceMTTFParameter()
     * @model required="true" ordered="false"
     * @generated
     */
    ResourceContainer getResourceContainer__ResourceMTTFParameter();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter#getResourceContainer__ResourceMTTFParameter
     * <em>Resource Container Resource MTTF Parameter</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Resource Container Resource MTTF Parameter</em>'
     *            reference.
     * @see #getResourceContainer__ResourceMTTFParameter()
     * @generated
     */
    void setResourceContainer__ResourceMTTFParameter(ResourceContainer value);

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
    boolean ResourceMTTFParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ResourceMTTFParameter
