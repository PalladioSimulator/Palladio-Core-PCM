/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>PCMRE Resource Interface</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.PCMREResourceInterface#getResourceInterface <em>
 * Resource Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMREResourceInterface()
 * @model
 * @generated
 */
public interface PCMREResourceInterface extends PCMRE {

    /**
     * Returns the value of the '<em><b>Resource Interface</b></em>' reference. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Resource Interface</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Resource Interface</em>' reference.
     * @see #setResourceInterface(ResourceInterface)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMREResourceInterface_ResourceInterface()
     * @model required="true" ordered="false"
     * @generated
     */
    ResourceInterface getResourceInterface();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.PCMREResourceInterface#getResourceInterface
     * <em>Resource Interface</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Resource Interface</em>' reference.
     * @see #getResourceInterface()
     * @generated
     */
    void setResourceInterface(ResourceInterface value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     *
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='self.childREs->select(pcmre | not pcmre.oclIsTypeOf(PCMREResourceRole))->size() = 0'"
     * @generated
     */
    boolean NextLowerLevelMustConsistOfTypePCMREResourceRole(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     *
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='self.parentRE.childREs->select(pcmre | pcmre.oclAsType(PCMREResourceInterface).resourceInterface = self.resourceInterface)->size() = 1'"
     * @generated
     */
    boolean EachRETargetMustBeReferencedOnlyFromOneRE(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PCMREResourceInterface
