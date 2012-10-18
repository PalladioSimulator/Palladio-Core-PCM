/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Communication Link Reliability Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This parameter refers to a network failure probability specified in the context of the given
 * CommunicationLinkResourceSpecification.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter#getCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter <em>Communication Link Resource Specification Communication Link Reliability Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getCommunicationLinkReliabilityParameter()
 * @model
 * @generated
 */
public interface CommunicationLinkReliabilityParameter extends SingleSensitivityParameter {
	/**
	 * Returns the value of the '<em><b>Communication Link Resource Specification Communication Link Reliability Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Communication Link Resource Specification Communication Link Reliability Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communication Link Resource Specification Communication Link Reliability Parameter</em>' reference.
	 * @see #setCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter(CommunicationLinkResourceSpecification)
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getCommunicationLinkReliabilityParameter_CommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CommunicationLinkResourceSpecification getCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter#getCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter <em>Communication Link Resource Specification Communication Link Reliability Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Communication Link Resource Specification Communication Link Reliability Parameter</em>' reference.
	 * @see #getCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter()
	 * @generated
	 */
	void setCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter(CommunicationLinkResourceSpecification value);

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
	boolean CommunicationLinkParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CommunicationLinkReliabilityParameter
