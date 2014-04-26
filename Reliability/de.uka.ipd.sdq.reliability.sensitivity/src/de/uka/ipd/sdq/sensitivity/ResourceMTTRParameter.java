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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource MTTR Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This parameter refers to an MTTR value of a given ProcessingResourceSpecification.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter#getResourceContainer__ResourceMTTRParameter <em>Resource Container Resource MTTR Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter#getProcessingResourceType__ResourceMTTRParameter <em>Processing Resource Type Resource MTTR Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getResourceMTTRParameter()
 * @model
 * @generated
 */
public interface ResourceMTTRParameter extends SingleSensitivityParameter {
	/**
     * Returns the value of the '<em><b>Resource Container Resource MTTR Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Container Resource MTTR Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Resource Container Resource MTTR Parameter</em>' reference.
     * @see #setResourceContainer__ResourceMTTRParameter(ResourceContainer)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getResourceMTTRParameter_ResourceContainer__ResourceMTTRParameter()
     * @model required="true" ordered="false"
     * @generated
     */
	ResourceContainer getResourceContainer__ResourceMTTRParameter();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter#getResourceContainer__ResourceMTTRParameter <em>Resource Container Resource MTTR Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Resource Container Resource MTTR Parameter</em>' reference.
     * @see #getResourceContainer__ResourceMTTRParameter()
     * @generated
     */
	void setResourceContainer__ResourceMTTRParameter(ResourceContainer value);

	/**
     * Returns the value of the '<em><b>Processing Resource Type Resource MTTR Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Resource Type Resource MTTR Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Processing Resource Type Resource MTTR Parameter</em>' reference.
     * @see #setProcessingResourceType__ResourceMTTRParameter(ProcessingResourceType)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getResourceMTTRParameter_ProcessingResourceType__ResourceMTTRParameter()
     * @model required="true" ordered="false"
     * @generated
     */
	ProcessingResourceType getProcessingResourceType__ResourceMTTRParameter();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter#getProcessingResourceType__ResourceMTTRParameter <em>Processing Resource Type Resource MTTR Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Processing Resource Type Resource MTTR Parameter</em>' reference.
     * @see #getProcessingResourceType__ResourceMTTRParameter()
     * @generated
     */
	void setProcessingResourceType__ResourceMTTRParameter(ProcessingResourceType value);

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
	boolean ResourceMTTRParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ResourceMTTRParameter
