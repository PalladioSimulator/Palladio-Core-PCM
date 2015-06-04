/**
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

import de.fzi.se.quality.qualityannotation.PCMPE;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>PCMPE</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class PCMPEImpl extends ProbabilisticElementImpl implements PCMPE {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PCMPEImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PCMPE;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #TopmostLevelMustBePCMPEAllDecisions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Topmost Level Must Be PCMPE All Decisions</em>}' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #TopmostLevelMustBePCMPEAllDecisions(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String TOPMOST_LEVEL_MUST_BE_PCMPE_ALL_DECISIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentPE.oclIsUndefined() implies self.oclIsKindOf(PCMPEAllDecisions)";

    /**
     * The cached OCL invariant for the '
     * {@link #TopmostLevelMustBePCMPEAllDecisions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Topmost Level Must Be PCMPE All Decisions</em>}' invariant operation. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #TopmostLevelMustBePCMPEAllDecisions(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint TOPMOST_LEVEL_MUST_BE_PCMPE_ALL_DECISIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean TopmostLevelMustBePCMPEAllDecisions(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (TOPMOST_LEVEL_MUST_BE_PCMPE_ALL_DECISIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMPE);
            try {
                TOPMOST_LEVEL_MUST_BE_PCMPE_ALL_DECISIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(TOPMOST_LEVEL_MUST_BE_PCMPE_ALL_DECISIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(TOPMOST_LEVEL_MUST_BE_PCMPE_ALL_DECISIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(Diagnostic.ERROR, QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCMPE__TOPMOST_LEVEL_MUST_BE_PCMPE_ALL_DECISIONS,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "TopmostLevelMustBePCMPEAllDecisions",
                                        EObjectValidator.getObjectLabel(this, context) }),
                                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // PCMPEImpl
