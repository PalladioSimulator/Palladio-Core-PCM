/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceSignature;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>PCMRE Resource Signature</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.PCMREResourceSignature#getResourceSignature <em>
 * Resource Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMREResourceSignature()
 * @model
 * @generated
 */
public interface PCMREResourceSignature extends PCMRE {

    /**
     * Returns the value of the '<em><b>Resource Signature</b></em>' reference. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Resource Signature</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Resource Signature</em>' reference.
     * @see #setResourceSignature(ResourceSignature)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMREResourceSignature_ResourceSignature()
     * @model required="true" ordered="false"
     * @generated
     */
    ResourceSignature getResourceSignature();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.PCMREResourceSignature#getResourceSignature
     * <em>Resource Signature</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Resource Signature</em>' reference.
     * @see #getResourceSignature()
     * @generated
     */
    void setResourceSignature(ResourceSignature value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     *
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model 
     *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.childREs->isEmpty()'"
     * @generated
     */
    boolean ThisIsTheLowestResourceHierarchyLevel(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     *
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='self.parentRE.childREs->select(pcmre | pcmre.oclAsType(PCMREResourceSignature).resourceSignature = self.resourceSignature)->size() = 1'"
     * @generated
     */
    boolean EachRETargetMustBeReferencedOnlyFromOneRE(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PCMREResourceSignature
