/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCMRE</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMRE()
 * @model abstract="true"
 * @generated
 */
public interface PCMRE extends RequiredElement {

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.parentRE.oclIsUndefined() implies self.oclIsTypeOf(PCMRECategory)'"
     * @generated
     */
	boolean TopmostLevelForPCMMustBePCMRECategory(DiagnosticChain diagnostics, Map<Object, Object> context);
} // PCMRE
