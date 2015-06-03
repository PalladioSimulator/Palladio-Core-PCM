/**
 */
package de.fzi.se.quality.qualityannotation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>PCMRE Infrastructure Role</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMREInfrastructureRole()
 * @model
 * @generated
 */
public interface PCMREInfrastructureRole extends PCMRE {

    /**
     * Returns the value of the '<em><b>Role</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Role</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Role</em>' reference.
     * @see #setRole(InfrastructureRequiredRole)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMREInfrastructureRole_Role()
     * @model required="true" ordered="false"
     * @generated
     */
    InfrastructureRequiredRole getRole();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole#getRole <em>Role</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Role</em>' reference.
     * @see #getRole()
     * @generated
     */
    void setRole(InfrastructureRequiredRole value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     *
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='self.childREs->select(pcmre | not pcmre.oclIsTypeOf(PCMREInfrastructureSignature))->size() = 0'"
     * @generated
     */
    boolean NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature(DiagnosticChain diagnostics,
            Map<Object, Object> context);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     *
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='self.parentRE.childREs->select(pcmre | pcmre.oclAsType(PCMREInfrastructureRole).role = self.role)->size() = 1'"
     * @generated
     */
    boolean EachRETargetMustBeReferencedOnlyFromOneRE(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PCMREInfrastructureRole
