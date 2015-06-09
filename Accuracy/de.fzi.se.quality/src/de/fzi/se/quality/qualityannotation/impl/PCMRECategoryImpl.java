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

import de.fzi.se.quality.qualityannotation.PCMRECategory;
import de.fzi.se.quality.qualityannotation.PCMRERequestCategory;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>PCMRE Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMRECategoryImpl#getCategory <em>Category
 * </em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMRECategoryImpl extends PCMREImpl implements PCMRECategory {

    /**
     * The default value of the '{@link #getCategory() <em>Category</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getCategory()
     * @generated
     * @ordered
     */
    protected static final PCMRERequestCategory CATEGORY_EDEFAULT = PCMRERequestCategory.RESOURCE;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PCMRECategoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PCMRE_CATEGORY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMRERequestCategory getCategory() {
        return (PCMRERequestCategory) this.eDynamicGet(QualityAnnotationPackage.PCMRE_CATEGORY__CATEGORY,
                QualityAnnotationPackage.Literals.PCMRE_CATEGORY__CATEGORY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCategory(final PCMRERequestCategory newCategory) {
        this.eDynamicSet(QualityAnnotationPackage.PCMRE_CATEGORY__CATEGORY,
                QualityAnnotationPackage.Literals.PCMRE_CATEGORY__CATEGORY, newCategory);
    }

    /**
     * The cached OCL expression body for the '
     * {@link #NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Hierarchy Level Is PCMRE Infrastructure Interface For Category Infrastructure</em>}
     * ' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INFRASTRUCTURE_INTERFACE_FOR_CATEGORY_INFRASTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.category = PCMRERequestCategory::Infrastructure implies self.childREs->forAll(child | child.oclIsTypeOf(PCMREInfrastructureInterface))";

    /**
     * The cached OCL invariant for the '
     * {@link #NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Hierarchy Level Is PCMRE Infrastructure Interface For Category Infrastructure</em>}
     * ' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INFRASTRUCTURE_INTERFACE_FOR_CATEGORY_INFRASTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INFRASTRUCTURE_INTERFACE_FOR_CATEGORY_INFRASTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_CATEGORY);
            try {
                NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INFRASTRUCTURE_INTERFACE_FOR_CATEGORY_INFRASTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INFRASTRUCTURE_INTERFACE_FOR_CATEGORY_INFRASTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INFRASTRUCTURE_INTERFACE_FOR_CATEGORY_INFRASTRUCTURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                        .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INFRASTRUCTURE_INTERFACE_FOR_CATEGORY_INFRASTRUCTURE,
                        EcorePlugin.INSTANCE
                        .getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] {
                                        "NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure",
                                        EObjectValidator.getObjectLabel(this, context) }),
                                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Existing RE Precision Call Parameter Must Be No Precision Due To The Non Existence Of Parameters For Category Resource Demand</em>}
     * ' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "(self.precision->size() > 0 and category = PCMRERequestCategory::ResourceDemand) implies self.precision.defaultPrecisionCallParameter.oclIsTypeOf(NoPrecision)";

    /**
     * The cached OCL invariant for the '
     * {@link #ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Existing RE Precision Call Parameter Must Be No Precision Due To The Non Existence Of Parameters For Category Resource Demand</em>}
     * ' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_CATEGORY);
            try {
                EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                        .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCMRE_CATEGORY__EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND,
                        EcorePlugin.INSTANCE
                        .getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] {
                                        "ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand",
                                        EObjectValidator.getObjectLabel(this, context) }),
                                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Hierarchy Level Is PCMRE Resource Interface For Category Resource</em>}'
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_INTERFACE_FOR_CATEGORY_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.category = PCMRERequestCategory::Resource implies self.childREs->forAll(child | child.oclIsTypeOf(PCMREResourceInterface))";

    /**
     * The cached OCL invariant for the '
     * {@link #NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Hierarchy Level Is PCMRE Resource Interface For Category Resource</em>}'
     * invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_INTERFACE_FOR_CATEGORY_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_INTERFACE_FOR_CATEGORY_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_CATEGORY);
            try {
                NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_INTERFACE_FOR_CATEGORY_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_INTERFACE_FOR_CATEGORY_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_INTERFACE_FOR_CATEGORY_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                        .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_INTERFACE_FOR_CATEGORY_RESOURCE,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource",
                                EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Hierarchy Level Is PCMRE Interface For Category Component</em>}' operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INTERFACE_FOR_CATEGORY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.category = PCMRERequestCategory::Component implies self.childREs->forAll(child | child.oclIsTypeOf(PCMREInterface))";

    /**
     * The cached OCL invariant for the '
     * {@link #NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Hierarchy Level Is PCMRE Interface For Category Component</em>}' invariant
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INTERFACE_FOR_CATEGORY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INTERFACE_FOR_CATEGORY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_CATEGORY);
            try {
                NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INTERFACE_FOR_CATEGORY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INTERFACE_FOR_CATEGORY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INTERFACE_FOR_CATEGORY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_INTERFACE_FOR_CATEGORY_COMPONENT,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                new Object[] { "NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent",
                                EObjectValidator.getObjectLabel(this, context) }),
                                new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Hierarchy Level Is PCMRE Resource For Category Resource Demand</em>}'
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.category = PCMRERequestCategory::ResourceDemand implies self.childREs->forAll(child | child.oclIsTypeOf(PCMREResource))";

    /**
     * The cached OCL invariant for the '
     * {@link #NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Hierarchy Level Is PCMRE Resource For Category Resource Demand</em>}'
     * invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_CATEGORY);
            try {
                NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                        .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRE_RESOURCE_FOR_CATEGORY_RESOURCE_DEMAND,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand",
                                EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Hierarchy Level Is PCMRECI Behavior For Category Component Internal</em>}'
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRECI_BEHAVIOR_FOR_CATEGORY_COMPONENT_INTERNAL__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.category = PCMRERequestCategory::ComponentInternal implies self.childREs->forAll(child | child.oclIsTypeOf(PCMRECIBehavior))";

    /**
     * The cached OCL invariant for the '
     * {@link #NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Hierarchy Level Is PCMRECI Behavior For Category Component Internal</em>}'
     * invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRECI_BEHAVIOR_FOR_CATEGORY_COMPONENT_INTERNAL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRECI_BEHAVIOR_FOR_CATEGORY_COMPONENT_INTERNAL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_CATEGORY);
            try {
                NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRECI_BEHAVIOR_FOR_CATEGORY_COMPONENT_INTERNAL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRECI_BEHAVIOR_FOR_CATEGORY_COMPONENT_INTERNAL__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRECI_BEHAVIOR_FOR_CATEGORY_COMPONENT_INTERNAL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                        .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_PCMRECI_BEHAVIOR_FOR_CATEGORY_COMPONENT_INTERNAL,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal",
                                EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #EachCategoryExactlyOnceIfSpecified(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Each Category Exactly Once If Specified</em>}' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #EachCategoryExactlyOnceIfSpecified(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String EACH_CATEGORY_EXACTLY_ONCE_IF_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.qualityAnnotation.stipulatedREPrecisions->select(pcmre | pcmre.oclIsTypeOf(PCMRECategory) and pcmre.oclAsType(PCMRECategory).category = self.category)->size() = 1";

    /**
     * The cached OCL invariant for the '
     * {@link #EachCategoryExactlyOnceIfSpecified(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Each Category Exactly Once If Specified</em>}' invariant operation. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #EachCategoryExactlyOnceIfSpecified(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint EACH_CATEGORY_EXACTLY_ONCE_IF_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean EachCategoryExactlyOnceIfSpecified(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (EACH_CATEGORY_EXACTLY_ONCE_IF_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_CATEGORY);
            try {
                EACH_CATEGORY_EXACTLY_ONCE_IF_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(EACH_CATEGORY_EXACTLY_ONCE_IF_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(EACH_CATEGORY_EXACTLY_ONCE_IF_SPECIFIED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(Diagnostic.ERROR, QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCMRE_CATEGORY__EACH_CATEGORY_EXACTLY_ONCE_IF_SPECIFIED,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "EachCategoryExactlyOnceIfSpecified",
                                        EObjectValidator.getObjectLabel(this, context) }),
                                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case QualityAnnotationPackage.PCMRE_CATEGORY__CATEGORY:
            return this.getCategory();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case QualityAnnotationPackage.PCMRE_CATEGORY__CATEGORY:
            this.setCategory((PCMRERequestCategory) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case QualityAnnotationPackage.PCMRE_CATEGORY__CATEGORY:
            this.setCategory(CATEGORY_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case QualityAnnotationPackage.PCMRE_CATEGORY__CATEGORY:
            return this.getCategory() != CATEGORY_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} // PCMRECategoryImpl