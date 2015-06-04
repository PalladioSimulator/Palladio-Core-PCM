/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import de.fzi.se.quality.parameters.ParameterPartition;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>PCM Parameter Partition</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.PCMParameterPartition#getCharacerisedParameterPartitions
 * <em>Characerised Parameter Partitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMParameterPartition()
 * @model
 * @generated
 */
public interface PCMParameterPartition extends ParameterPartition {

    /**
     * Returns the value of the '<em><b>Characerised Parameter Partitions</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition}. It is
     * bidirectional and its opposite is '
     * {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition#getPcmParameterPartition
     * <em>Pcm Parameter Partition</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Characerised Parameter Partitions</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Characerised Parameter Partitions</em>' containment reference
     *         list.
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMParameterPartition_CharacerisedParameterPartitions()
     * @see de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition#getPcmParameterPartition
     * @model opposite="pcmParameterPartition" containment="true" required="true" ordered="false"
     * @generated
     */
    EList<CharacterisedPCMParameterPartition> getCharacerisedParameterPartitions();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     *
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='self.parameterReference.oclIsKindOf(quality::parameters::pcm::PCMParameterReference)'"
     * @generated
     */
    boolean APCMParameterPartitionMustReferenceAPCMParameterReference(DiagnosticChain diagnostics,
            Map<Object, Object> context);

} // PCMParameterPartition
