/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel.impl;

import EMOF.EMOFPackage;

import EssentialOCL.EssentialOCLPackage;

import QVTBase.QVTBasePackage;

import QVTRelation.QVTRelationPackage;

import QVTTemplate.QVTTemplatePackage;

import copyException.CopyExceptionPackage;

import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

import edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature;
import edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureDiagram;
import edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureGroup;
import edu.kit.ipd.sdq.completionfeaturemodel.CompletionSimple;
import edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule;
import edu.kit.ipd.sdq.completionfeaturemodel.FeatureState;
import edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelFactory;
import edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class completionfeaturemodelPackageImpl extends EPackageImpl implements completionfeaturemodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completionFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass disambiguationRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completionFeatureDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completionSimpleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completionFeatureGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum featureStateEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private completionfeaturemodelPackageImpl() {
		super(eNS_URI, completionfeaturemodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link completionfeaturemodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static completionfeaturemodelPackage init() {
		if (isInited) return (completionfeaturemodelPackage)EPackage.Registry.INSTANCE.getEPackage(completionfeaturemodelPackage.eNS_URI);

		// Obtain or create and register package
		completionfeaturemodelPackageImpl thecompletionfeaturemodelPackage = (completionfeaturemodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof completionfeaturemodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new completionfeaturemodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		featuremodelPackage.eINSTANCE.eClass();
		CopyExceptionPackage.eINSTANCE.eClass();
		EMOFPackage.eINSTANCE.eClass();
		EssentialOCLPackage.eINSTANCE.eClass();
		QVTBasePackage.eINSTANCE.eClass();
		QVTRelationPackage.eINSTANCE.eClass();
		QVTTemplatePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thecompletionfeaturemodelPackage.createPackageContents();

		// Initialize created meta-data
		thecompletionfeaturemodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thecompletionfeaturemodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(completionfeaturemodelPackage.eNS_URI, thecompletionfeaturemodelPackage);
		return thecompletionfeaturemodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompletionFeature() {
		return completionFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompletionFeature_CopyException() {
		return (EReference)completionFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompletionFeature_DisambiguationRule() {
		return (EReference)completionFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompletionFeature_TransformationFragment() {
		return (EReference)completionFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompletionFeature_FeatureState() {
		return (EAttribute)completionFeatureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisambiguationRule() {
		return disambiguationRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDisambiguationRule_Feature() {
		return (EReference)disambiguationRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDisambiguationRule_DisambiguationCondition() {
		return (EReference)disambiguationRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDisambiguationRule_TransformationFragment() {
		return (EReference)disambiguationRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompletionFeatureDiagram() {
		return completionFeatureDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompletionSimple() {
		return completionSimpleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompletionFeatureGroup() {
		return completionFeatureGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFeatureState() {
		return featureStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public completionfeaturemodelFactory getcompletionfeaturemodelFactory() {
		return (completionfeaturemodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		completionFeatureEClass = createEClass(COMPLETION_FEATURE);
		createEReference(completionFeatureEClass, COMPLETION_FEATURE__COPY_EXCEPTION);
		createEReference(completionFeatureEClass, COMPLETION_FEATURE__DISAMBIGUATION_RULE);
		createEReference(completionFeatureEClass, COMPLETION_FEATURE__TRANSFORMATION_FRAGMENT);
		createEAttribute(completionFeatureEClass, COMPLETION_FEATURE__FEATURE_STATE);

		disambiguationRuleEClass = createEClass(DISAMBIGUATION_RULE);
		createEReference(disambiguationRuleEClass, DISAMBIGUATION_RULE__FEATURE);
		createEReference(disambiguationRuleEClass, DISAMBIGUATION_RULE__DISAMBIGUATION_CONDITION);
		createEReference(disambiguationRuleEClass, DISAMBIGUATION_RULE__TRANSFORMATION_FRAGMENT);

		completionFeatureDiagramEClass = createEClass(COMPLETION_FEATURE_DIAGRAM);

		completionSimpleEClass = createEClass(COMPLETION_SIMPLE);

		completionFeatureGroupEClass = createEClass(COMPLETION_FEATURE_GROUP);

		// Create enums
		featureStateEEnum = createEEnum(FEATURE_STATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		featuremodelPackage thefeaturemodelPackage = (featuremodelPackage)EPackage.Registry.INSTANCE.getEPackage(featuremodelPackage.eNS_URI);
		CopyExceptionPackage theCopyExceptionPackage = (CopyExceptionPackage)EPackage.Registry.INSTANCE.getEPackage(CopyExceptionPackage.eNS_URI);
		QVTRelationPackage theQVTRelationPackage = (QVTRelationPackage)EPackage.Registry.INSTANCE.getEPackage(QVTRelationPackage.eNS_URI);
		EssentialOCLPackage theEssentialOCLPackage = (EssentialOCLPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		completionFeatureEClass.getESuperTypes().add(thefeaturemodelPackage.getFeature());
		completionFeatureDiagramEClass.getESuperTypes().add(thefeaturemodelPackage.getFeatureDiagram());
		completionSimpleEClass.getESuperTypes().add(thefeaturemodelPackage.getSimple());
		completionFeatureGroupEClass.getESuperTypes().add(thefeaturemodelPackage.getFeatureGroup());

		// Initialize classes and features; add operations and parameters
		initEClass(completionFeatureEClass, CompletionFeature.class, "CompletionFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompletionFeature_CopyException(), theCopyExceptionPackage.getException(), null, "copyException", null, 0, -1, CompletionFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompletionFeature_DisambiguationRule(), this.getDisambiguationRule(), null, "disambiguationRule", null, 0, -1, CompletionFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompletionFeature_TransformationFragment(), theQVTRelationPackage.getRelation(), null, "transformationFragment", null, 0, -1, CompletionFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCompletionFeature_FeatureState(), this.getFeatureState(), "FeatureState", "NOT_SET", 1, 1, CompletionFeature.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(disambiguationRuleEClass, DisambiguationRule.class, "DisambiguationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDisambiguationRule_Feature(), this.getCompletionFeature(), null, "feature", null, 0, 1, DisambiguationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDisambiguationRule_DisambiguationCondition(), theEssentialOCLPackage.getOperationCallExp(), null, "disambiguationCondition", null, 0, -1, DisambiguationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDisambiguationRule_TransformationFragment(), theQVTRelationPackage.getRelation(), null, "transformationFragment", null, 0, -1, DisambiguationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(completionFeatureDiagramEClass, CompletionFeatureDiagram.class, "CompletionFeatureDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(completionSimpleEClass, CompletionSimple.class, "CompletionSimple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(completionFeatureGroupEClass, CompletionFeatureGroup.class, "CompletionFeatureGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(featureStateEEnum, FeatureState.class, "FeatureState");
		addEEnumLiteral(featureStateEEnum, FeatureState.NOT_SET);
		addEEnumLiteral(featureStateEEnum, FeatureState.OPTIONAL);
		addEEnumLiteral(featureStateEEnum, FeatureState.MANDATORY);

		// Create resource
		createResource(eNS_URI);
	}

} //completionfeaturemodelPackageImpl
