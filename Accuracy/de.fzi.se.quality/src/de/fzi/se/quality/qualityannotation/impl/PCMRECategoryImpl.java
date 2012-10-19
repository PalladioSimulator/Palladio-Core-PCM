package de.fzi.se.quality.qualityannotation.impl;


import de.fzi.se.quality.qualityannotation.PCMRECategory;
import de.fzi.se.quality.qualityannotation.PCMRERequestCategory;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCMRE Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMRECategoryImpl#getCategory <em>Category</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMRECategoryImpl extends PCMREImpl implements PCMRECategory {
	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final PCMRERequestCategory CATEGORY_EDEFAULT = PCMRERequestCategory.RESOURCE;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected PCMRERequestCategory category = CATEGORY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMRECategoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.PCMRE_CATEGORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRERequestCategory getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(PCMRERequestCategory newCategory) {
		PCMRERequestCategory oldCategory = category;
		category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PCMRE_CATEGORY__CATEGORY, oldCategory, category));
	}

	/**
	 * The cached OCL expression body for the '{@link #NextLowerHierarchyLevelIsInterface(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Next Lower Hierarchy Level Is Interface</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NextLowerHierarchyLevelIsInterface(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NEXT_LOWER_HIERARCHY_LEVEL_IS_INTERFACE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.childREs->forAll(child | child.oclIsTypeOf(PCMREInterface))";

	/**
	 * The cached OCL invariant for the '{@link #NextLowerHierarchyLevelIsInterface(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Next Lower Hierarchy Level Is Interface</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NextLowerHierarchyLevelIsInterface(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint NEXT_LOWER_HIERARCHY_LEVEL_IS_INTERFACE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean NextLowerHierarchyLevelIsInterface(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (NEXT_LOWER_HIERARCHY_LEVEL_IS_INTERFACE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QualityAnnotationPackage.Literals.PCMRE_CATEGORY);
			try {
				NEXT_LOWER_HIERARCHY_LEVEL_IS_INTERFACE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(NEXT_LOWER_HIERARCHY_LEVEL_IS_INTERFACE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(NEXT_LOWER_HIERARCHY_LEVEL_IS_INTERFACE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
						 QualityAnnotationValidator.PCMRE_CATEGORY__NEXT_LOWER_HIERARCHY_LEVEL_IS_INTERFACE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "NextLowerHierarchyLevelIsInterface", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #ThisIsHighestHierarchyLevel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>This Is Highest Hierarchy Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ThisIsHighestHierarchyLevel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String THIS_IS_HIGHEST_HIERARCHY_LEVEL__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentRE.oclIsUndefined()";

	/**
	 * The cached OCL invariant for the '{@link #ThisIsHighestHierarchyLevel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>This Is Highest Hierarchy Level</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ThisIsHighestHierarchyLevel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint THIS_IS_HIGHEST_HIERARCHY_LEVEL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ThisIsHighestHierarchyLevel(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (THIS_IS_HIGHEST_HIERARCHY_LEVEL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QualityAnnotationPackage.Literals.PCMRE_CATEGORY);
			try {
				THIS_IS_HIGHEST_HIERARCHY_LEVEL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(THIS_IS_HIGHEST_HIERARCHY_LEVEL__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(THIS_IS_HIGHEST_HIERARCHY_LEVEL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
						 QualityAnnotationValidator.PCMRE_CATEGORY__THIS_IS_HIGHEST_HIERARCHY_LEVEL,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ThisIsHighestHierarchyLevel", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #NoSublevelsForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Sublevels For Category Resource Demand</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NoSublevelsForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NO_SUBLEVELS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.category = PCMRERequestCategory::ResourceDemand implies self.childREs->size() = 0";

	/**
	 * The cached OCL invariant for the '{@link #NoSublevelsForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Sublevels For Category Resource Demand</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NoSublevelsForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint NO_SUBLEVELS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean NoSublevelsForCategoryResourceDemand(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (NO_SUBLEVELS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QualityAnnotationPackage.Literals.PCMRE_CATEGORY);
			try {
				NO_SUBLEVELS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(NO_SUBLEVELS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(NO_SUBLEVELS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
						 QualityAnnotationValidator.PCMRE_CATEGORY__NO_SUBLEVELS_FOR_CATEGORY_RESOURCE_DEMAND,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "NoSublevelsForCategoryResourceDemand", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Existing RE Precision Call Parameter Must Be No Precision Due To The Non Existence Of Parameters For Category Resource Demand</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "(self.precision->size() > 0 and category = PCMRERequestCategory::ResourceDemand) implies self.precision.defaultPrecisionCallParameter.oclIsTypeOf(NoPrecision)";

	/**
	 * The cached OCL invariant for the '{@link #ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Existing RE Precision Call Parameter Must Be No Precision Due To The Non Existence Of Parameters For Category Resource Demand</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QualityAnnotationPackage.Literals.PCMRE_CATEGORY);
			try {
				EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
						 QualityAnnotationValidator.PCMRE_CATEGORY__EXISTING_RE_PRECISION_CALL_PARAMETER_MUST_BE_NO_PRECISION_DUE_TO_THE_NON_EXISTENCE_OF_PARAMETERS_FOR_CATEGORY_RESOURCE_DEMAND,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QualityAnnotationPackage.PCMRE_CATEGORY__CATEGORY:
				return getCategory();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QualityAnnotationPackage.PCMRE_CATEGORY__CATEGORY:
				setCategory((PCMRERequestCategory)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case QualityAnnotationPackage.PCMRE_CATEGORY__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QualityAnnotationPackage.PCMRE_CATEGORY__CATEGORY:
				return category != CATEGORY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (category: ");
		result.append(category);
		result.append(')');
		return result.toString();
	}

} //PCMRECategoryImpl