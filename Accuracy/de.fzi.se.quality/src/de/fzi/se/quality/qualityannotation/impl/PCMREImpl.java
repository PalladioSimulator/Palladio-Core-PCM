/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.fzi.se.quality.qualityannotation.PCMRE;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>PCMRE</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class PCMREImpl extends RequiredElementImpl implements PCMRE {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PCMREImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PCMRE;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #TopmostLevelForPCMMustBePCMRECategory(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Topmost Level For PCM Must Be PCMRE Category</em>}' operation. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #TopmostLevelForPCMMustBePCMRECategory(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String TOPMOST_LEVEL_FOR_PCM_MUST_BE_PCMRE_CATEGORY__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentRE.oclIsUndefined() implies self.oclIsTypeOf(PCMRECategory)";
    /**
     * The cached OCL invariant for the '
     * {@link #TopmostLevelForPCMMustBePCMRECategory(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Topmost Level For PCM Must Be PCMRE Category</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #TopmostLevelForPCMMustBePCMRECategory(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint TOPMOST_LEVEL_FOR_PCM_MUST_BE_PCMRE_CATEGORY__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean TopmostLevelForPCMMustBePCMRECategory(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (TOPMOST_LEVEL_FOR_PCM_MUST_BE_PCMRE_CATEGORY__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE);
            try {
                TOPMOST_LEVEL_FOR_PCM_MUST_BE_PCMRE_CATEGORY__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(TOPMOST_LEVEL_FOR_PCM_MUST_BE_PCMRE_CATEGORY__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(TOPMOST_LEVEL_FOR_PCM_MUST_BE_PCMRE_CATEGORY__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(
                this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCMRE__TOPMOST_LEVEL_FOR_PCM_MUST_BE_PCMRE_CATEGORY,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "TopmostLevelForPCMMustBePCMRECategory",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
            }
            return false;
        }
        return true;
    }

} // PCMREImpl
