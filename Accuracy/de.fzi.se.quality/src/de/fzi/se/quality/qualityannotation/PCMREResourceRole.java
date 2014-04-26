/**
 */
package de.fzi.se.quality.qualityannotation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCMRE Resource Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.PCMREResourceRole#getResourceRole <em>Resource Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMREResourceRole()
 * @model
 * @generated
 */
public interface PCMREResourceRole extends PCMRE {
	/**
     * Returns the value of the '<em><b>Resource Role</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Resource Role</em>' reference.
     * @see #setResourceRole(ResourceRequiredRole)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMREResourceRole_ResourceRole()
     * @model required="true" ordered="false"
     * @generated
     */
	ResourceRequiredRole getResourceRole();

	/**
     * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.PCMREResourceRole#getResourceRole <em>Resource Role</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Resource Role</em>' reference.
     * @see #getResourceRole()
     * @generated
     */
	void setResourceRole(ResourceRequiredRole value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.childREs->select(pcmre | not pcmre.oclIsTypeOf(PCMREResourceSignature))->size() = 0'"
     * @generated
     */
	boolean NextLowerLevelMustConsistOfTypePCMREResourceSignature(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.parentRE.childREs->select(pcmre | pcmre.oclAsType(PCMREResourceRole).resourceRequiredRole = self.resourceRequiredRole)->size() = 1'"
     * @generated
     */
	boolean EachRETargetMustBeReferencedOnlyFromOneRE(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PCMREResourceRole
