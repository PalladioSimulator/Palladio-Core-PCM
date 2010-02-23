/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.impl;

import de.uka.ipd.sdq.featuremodel.Attribute;
import de.uka.ipd.sdq.featuremodel.AttributeTypes;
import de.uka.ipd.sdq.featuremodel.ChildRelation;
import de.uka.ipd.sdq.featuremodel.Constraint;
import de.uka.ipd.sdq.featuremodel.ContinousIntervalRange;
import de.uka.ipd.sdq.featuremodel.DefaultValue;
import de.uka.ipd.sdq.featuremodel.ElementListingAttribute;
import de.uka.ipd.sdq.featuremodel.EnumerationRange;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.FeatureState;
import de.uka.ipd.sdq.featuremodel.IntegerIntervalRange;
import de.uka.ipd.sdq.featuremodel.IntervalRange;
import de.uka.ipd.sdq.featuremodel.NamedElement;
import de.uka.ipd.sdq.featuremodel.PrimitiveAttribute;
import de.uka.ipd.sdq.featuremodel.ProhibitsConstraint;
import de.uka.ipd.sdq.featuremodel.RequiredConstraint;
import de.uka.ipd.sdq.featuremodel.Simple;
import de.uka.ipd.sdq.featuremodel.featuremodelFactory;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

import de.uka.ipd.sdq.featuremodel.util.featuremodelValidator;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.CorePackage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class featuremodelPackageImpl extends EPackageImpl implements featuremodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requiredConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prohibitsConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intervalRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerIntervalRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continousIntervalRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementListingAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum attributeTypesEEnum = null;

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
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private featuremodelPackageImpl() {
		super(eNS_URI, featuremodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link featuremodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static featuremodelPackage init() {
		if (isInited) return (featuremodelPackage)EPackage.Registry.INSTANCE.getEPackage(featuremodelPackage.eNS_URI);

		// Obtain or create and register package
		featuremodelPackageImpl thefeaturemodelPackage = (featuremodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof featuremodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new featuremodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		IdentifierPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thefeaturemodelPackage.createPackageContents();

		// Initialize created meta-data
		thefeaturemodelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(thefeaturemodelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return featuremodelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		thefeaturemodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(featuremodelPackage.eNS_URI, thefeaturemodelPackage);
		return thefeaturemodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_Attributes() {
		return (EReference)featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_Childrelation() {
		return (EReference)featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_SimpleMandatory() {
		return (EReference)featureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_SimpleOptional() {
		return (EReference)featureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildRelation() {
		return childRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimple() {
		return simpleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimple_OptionalChildren() {
		return (EReference)simpleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimple_MandatoryChildren() {
		return (EReference)simpleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureGroup() {
		return featureGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureGroup_Min() {
		return (EAttribute)featureGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureGroup_Max() {
		return (EAttribute)featureGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroup_Children() {
		return (EReference)featureGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureDiagram() {
		return featureDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureDiagram_RootFeature() {
		return (EReference)featureDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureDiagram_Constraints() {
		return (EReference)featureDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureDiagram_AnnotatableElement() {
		return (EReference)featureDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Source() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Target() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Description() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequiredConstraint() {
		return requiredConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProhibitsConstraint() {
		return prohibitsConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultValue() {
		return defaultValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefaultValue_Value() {
		return (EAttribute)defaultValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefaultValue_Type() {
		return (EAttribute)defaultValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultValue_Attribute() {
		return (EReference)defaultValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveAttribute() {
		return primitiveAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveAttribute_Type() {
		return (EAttribute)primitiveAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveAttribute_Range() {
		return (EReference)primitiveAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveAttribute_Defaultvalue() {
		return (EReference)primitiveAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntervalRange() {
		return intervalRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervalRange_LowerBoundIncluded() {
		return (EAttribute)intervalRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervalRange_UpperBoundIncluded() {
		return (EAttribute)intervalRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationRange() {
		return enumerationRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationRange_Values() {
		return (EReference)enumerationRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerIntervalRange() {
		return integerIntervalRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerIntervalRange_To() {
		return (EAttribute)integerIntervalRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerIntervalRange_From() {
		return (EAttribute)integerIntervalRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinousIntervalRange() {
		return continousIntervalRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContinousIntervalRange_To() {
		return (EAttribute)continousIntervalRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContinousIntervalRange_From() {
		return (EAttribute)continousIntervalRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementListingAttribute() {
		return elementListingAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementListingAttribute_Range() {
		return (EReference)elementListingAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAttributeTypes() {
		return attributeTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public featuremodelFactory getfeaturemodelFactory() {
		return (featuremodelFactory)getEFactoryInstance();
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
		featureEClass = createEClass(FEATURE);
		createEReference(featureEClass, FEATURE__ATTRIBUTES);
		createEReference(featureEClass, FEATURE__CHILDRELATION);
		createEReference(featureEClass, FEATURE__SIMPLE_MANDATORY);
		createEReference(featureEClass, FEATURE__SIMPLE_OPTIONAL);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		attributeEClass = createEClass(ATTRIBUTE);

		childRelationEClass = createEClass(CHILD_RELATION);

		simpleEClass = createEClass(SIMPLE);
		createEReference(simpleEClass, SIMPLE__OPTIONAL_CHILDREN);
		createEReference(simpleEClass, SIMPLE__MANDATORY_CHILDREN);

		featureGroupEClass = createEClass(FEATURE_GROUP);
		createEAttribute(featureGroupEClass, FEATURE_GROUP__MIN);
		createEAttribute(featureGroupEClass, FEATURE_GROUP__MAX);
		createEReference(featureGroupEClass, FEATURE_GROUP__CHILDREN);

		featureDiagramEClass = createEClass(FEATURE_DIAGRAM);
		createEReference(featureDiagramEClass, FEATURE_DIAGRAM__ROOT_FEATURE);
		createEReference(featureDiagramEClass, FEATURE_DIAGRAM__CONSTRAINTS);
		createEReference(featureDiagramEClass, FEATURE_DIAGRAM__ANNOTATABLE_ELEMENT);

		constraintEClass = createEClass(CONSTRAINT);
		createEReference(constraintEClass, CONSTRAINT__SOURCE);
		createEReference(constraintEClass, CONSTRAINT__TARGET);
		createEAttribute(constraintEClass, CONSTRAINT__DESCRIPTION);

		requiredConstraintEClass = createEClass(REQUIRED_CONSTRAINT);

		prohibitsConstraintEClass = createEClass(PROHIBITS_CONSTRAINT);

		defaultValueEClass = createEClass(DEFAULT_VALUE);
		createEAttribute(defaultValueEClass, DEFAULT_VALUE__VALUE);
		createEAttribute(defaultValueEClass, DEFAULT_VALUE__TYPE);
		createEReference(defaultValueEClass, DEFAULT_VALUE__ATTRIBUTE);

		primitiveAttributeEClass = createEClass(PRIMITIVE_ATTRIBUTE);
		createEAttribute(primitiveAttributeEClass, PRIMITIVE_ATTRIBUTE__TYPE);
		createEReference(primitiveAttributeEClass, PRIMITIVE_ATTRIBUTE__RANGE);
		createEReference(primitiveAttributeEClass, PRIMITIVE_ATTRIBUTE__DEFAULTVALUE);

		intervalRangeEClass = createEClass(INTERVAL_RANGE);
		createEAttribute(intervalRangeEClass, INTERVAL_RANGE__LOWER_BOUND_INCLUDED);
		createEAttribute(intervalRangeEClass, INTERVAL_RANGE__UPPER_BOUND_INCLUDED);

		enumerationRangeEClass = createEClass(ENUMERATION_RANGE);
		createEReference(enumerationRangeEClass, ENUMERATION_RANGE__VALUES);

		integerIntervalRangeEClass = createEClass(INTEGER_INTERVAL_RANGE);
		createEAttribute(integerIntervalRangeEClass, INTEGER_INTERVAL_RANGE__TO);
		createEAttribute(integerIntervalRangeEClass, INTEGER_INTERVAL_RANGE__FROM);

		continousIntervalRangeEClass = createEClass(CONTINOUS_INTERVAL_RANGE);
		createEAttribute(continousIntervalRangeEClass, CONTINOUS_INTERVAL_RANGE__TO);
		createEAttribute(continousIntervalRangeEClass, CONTINOUS_INTERVAL_RANGE__FROM);

		elementListingAttributeEClass = createEClass(ELEMENT_LISTING_ATTRIBUTE);
		createEReference(elementListingAttributeEClass, ELEMENT_LISTING_ATTRIBUTE__RANGE);

		// Create enums
		attributeTypesEEnum = createEEnum(ATTRIBUTE_TYPES);
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
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		featureEClass.getESuperTypes().add(this.getNamedElement());
		namedElementEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		attributeEClass.getESuperTypes().add(this.getNamedElement());
		simpleEClass.getESuperTypes().add(this.getChildRelation());
		featureGroupEClass.getESuperTypes().add(this.getChildRelation());
		featureDiagramEClass.getESuperTypes().add(this.getNamedElement());
		constraintEClass.getESuperTypes().add(this.getNamedElement());
		requiredConstraintEClass.getESuperTypes().add(this.getConstraint());
		prohibitsConstraintEClass.getESuperTypes().add(this.getConstraint());
		primitiveAttributeEClass.getESuperTypes().add(this.getAttribute());
		integerIntervalRangeEClass.getESuperTypes().add(this.getIntervalRange());
		continousIntervalRangeEClass.getESuperTypes().add(this.getIntervalRange());
		elementListingAttributeEClass.getESuperTypes().add(this.getAttribute());

		// Initialize classes and features; add operations and parameters
		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeature_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFeature_Childrelation(), this.getChildRelation(), null, "childrelation", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFeature_SimpleMandatory(), this.getSimple(), this.getSimple_MandatoryChildren(), "simpleMandatory", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFeature_SimpleOptional(), this.getSimple(), this.getSimple_OptionalChildren(), "simpleOptional", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(featureEClass, ecorePackage.getEBoolean(), "EachAttributeNameDefinedJustOnce", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(childRelationEClass, ChildRelation.class, "ChildRelation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleEClass, Simple.class, "Simple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimple_OptionalChildren(), this.getFeature(), this.getFeature_SimpleOptional(), "optionalChildren", null, 0, -1, Simple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSimple_MandatoryChildren(), this.getFeature(), this.getFeature_SimpleMandatory(), "mandatoryChildren", null, 0, -1, Simple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(simpleEClass, ecorePackage.getEBoolean(), "atLeastOneChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(featureGroupEClass, FeatureGroup.class, "FeatureGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureGroup_Min(), ecorePackage.getEInt(), "min", "1", 1, 1, FeatureGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFeatureGroup_Max(), ecorePackage.getEInt(), "max", "1", 1, 1, FeatureGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFeatureGroup_Children(), this.getFeature(), null, "children", null, 2, -1, FeatureGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(featureGroupEClass, ecorePackage.getEBoolean(), "XORorORImpliesChildrenAreMandatory", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(featureGroupEClass, ecorePackage.getEBoolean(), "ALLImpliesCardinalitiesToBeMinusOne", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(featureGroupEClass, ecorePackage.getEBoolean(), "ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOne", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(featureGroupEClass, ecorePackage.getEBoolean(), "XORImpliesCardinalitiesToBeOne", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(featureDiagramEClass, FeatureDiagram.class, "FeatureDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureDiagram_RootFeature(), this.getFeature(), null, "rootFeature", null, 1, 1, FeatureDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFeatureDiagram_Constraints(), this.getConstraint(), null, "constraints", null, 0, -1, FeatureDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFeatureDiagram_AnnotatableElement(), theEcorePackage.getEObject(), null, "annotatableElement", null, 0, -1, FeatureDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraint_Source(), this.getFeature(), null, "source", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConstraint_Target(), this.getFeature(), null, "target", null, 1, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getConstraint_Description(), ecorePackage.getEString(), "description", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(requiredConstraintEClass, RequiredConstraint.class, "RequiredConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(prohibitsConstraintEClass, ProhibitsConstraint.class, "ProhibitsConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(defaultValueEClass, DefaultValue.class, "DefaultValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefaultValue_Value(), ecorePackage.getEString(), "value", null, 1, 1, DefaultValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDefaultValue_Type(), this.getAttributeTypes(), "type", null, 1, 1, DefaultValue.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getDefaultValue_Attribute(), this.getPrimitiveAttribute(), this.getPrimitiveAttribute_Defaultvalue(), "attribute", null, 1, 1, DefaultValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(defaultValueEClass, ecorePackage.getEBoolean(), "DefaultValueMustBeOfSpecifiedType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(primitiveAttributeEClass, PrimitiveAttribute.class, "PrimitiveAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveAttribute_Type(), this.getAttributeTypes(), "type", null, 1, 1, PrimitiveAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPrimitiveAttribute_Range(), this.getIntervalRange(), null, "range", null, 0, 1, PrimitiveAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPrimitiveAttribute_Defaultvalue(), this.getDefaultValue(), this.getDefaultValue_Attribute(), "defaultvalue", null, 1, 1, PrimitiveAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(intervalRangeEClass, IntervalRange.class, "IntervalRange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntervalRange_LowerBoundIncluded(), ecorePackage.getEBoolean(), "lowerBoundIncluded", null, 1, 1, IntervalRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervalRange_UpperBoundIncluded(), ecorePackage.getEBoolean(), "upperBoundIncluded", null, 1, 1, IntervalRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(enumerationRangeEClass, EnumerationRange.class, "EnumerationRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumerationRange_Values(), theEcorePackage.getEObject(), null, "values", null, 0, -1, EnumerationRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(integerIntervalRangeEClass, IntegerIntervalRange.class, "IntegerIntervalRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerIntervalRange_To(), ecorePackage.getEInt(), "to", null, 1, 1, IntegerIntervalRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntegerIntervalRange_From(), ecorePackage.getEInt(), "from", "0", 1, 1, IntegerIntervalRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(continousIntervalRangeEClass, ContinousIntervalRange.class, "ContinousIntervalRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContinousIntervalRange_To(), ecorePackage.getEDouble(), "to", null, 1, 1, ContinousIntervalRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContinousIntervalRange_From(), ecorePackage.getEDouble(), "from", null, 1, 1, ContinousIntervalRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(elementListingAttributeEClass, ElementListingAttribute.class, "ElementListingAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementListingAttribute_Range(), this.getEnumerationRange(), null, "range", null, 0, 1, ElementListingAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(attributeTypesEEnum, AttributeTypes.class, "AttributeTypes");
		addEEnumLiteral(attributeTypesEEnum, AttributeTypes.INT);
		addEEnumLiteral(attributeTypesEEnum, AttributeTypes.STRING);
		addEEnumLiteral(attributeTypesEEnum, AttributeTypes.REAL);

		// Create resource
		createResource(eNS_URI);
	}

} //featuremodelPackageImpl
