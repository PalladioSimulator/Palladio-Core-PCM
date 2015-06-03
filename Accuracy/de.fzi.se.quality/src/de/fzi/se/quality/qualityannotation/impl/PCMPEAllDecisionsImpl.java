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

import de.fzi.se.quality.qualityannotation.PCMPEAllDecisions;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>PCMPE All Decisions</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PCMPEAllDecisionsImpl extends PCMPEImpl implements PCMPEAllDecisions {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PCMPEAllDecisionsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PCMPE_ALL_DECISIONS;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #NextLowerHierarchyLevelMustBeDecision(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Hierarchy Level Must Be Decision</em>}' operation. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #NextLowerHierarchyLevelMustBeDecision(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String NEXT_LOWER_HIERARCHY_LEVEL_MUST_BE_DECISION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.childPEs->forAll(child | child.oclIsKindOf(PCMPEDecision))";

    /**
     * The cached OCL invariant for the '
     * {@link #NextLowerHierarchyLevelMustBeDecision(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Hierarchy Level Must Be Decision</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #NextLowerHierarchyLevelMustBeDecision(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint NEXT_LOWER_HIERARCHY_LEVEL_MUST_BE_DECISION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean NextLowerHierarchyLevelMustBeDecision(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (NEXT_LOWER_HIERARCHY_LEVEL_MUST_BE_DECISION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMPE_ALL_DECISIONS);
            try {
                NEXT_LOWER_HIERARCHY_LEVEL_MUST_BE_DECISION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(NEXT_LOWER_HIERARCHY_LEVEL_MUST_BE_DECISION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(NEXT_LOWER_HIERARCHY_LEVEL_MUST_BE_DECISION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(
                this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCMPE_ALL_DECISIONS__NEXT_LOWER_HIERARCHY_LEVEL_MUST_BE_DECISION,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "NextLowerHierarchyLevelMustBeDecision",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
            }
            return false;
        }
        return true;
    }

} // PCMPEAllDecisionsImpl
