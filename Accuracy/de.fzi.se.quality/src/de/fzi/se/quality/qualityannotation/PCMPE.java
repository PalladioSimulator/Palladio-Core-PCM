/**
 */
package de.fzi.se.quality.qualityannotation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCMPE</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMPE()
 * @model abstract="true"
 * @generated
 */
public interface PCMPE extends ProbabilisticElement {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.parentPE.oclIsUndefined() implies self.oclIsKindOf(PCMPEAllDecisions)'"
     * @generated
     */
	boolean TopmostLevelMustBePCMPEAllDecisions(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PCMPE
