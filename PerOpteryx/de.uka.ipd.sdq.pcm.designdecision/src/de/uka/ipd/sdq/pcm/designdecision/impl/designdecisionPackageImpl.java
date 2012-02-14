/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.featuremodel.featuremodelPackage;
import de.uka.ipd.sdq.pcm.cost.costPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree;
import de.uka.ipd.sdq.pcm.designdecision.Candidate;
import de.uka.ipd.sdq.pcm.designdecision.Candidates;
import de.uka.ipd.sdq.pcm.designdecision.CapacityDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ClassAsReferenceDegree;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;
import de.uka.ipd.sdq.pcm.designdecision.ClassWithCopyDegree;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousComponentParamDegree;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.DataTypeDegree;
import de.uka.ipd.sdq.pcm.designdecision.DecisionSpace;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteComponentParamDegree;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteDegree;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.EnumDegree;

import de.uka.ipd.sdq.pcm.designdecision.ExchangeComponentRule;
import de.uka.ipd.sdq.pcm.designdecision.FeatureConfigDegree;
import de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree;
import de.uka.ipd.sdq.pcm.designdecision.FeatureSubset;
import de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage;
import de.uka.ipd.sdq.pcm.designdecision.GDoF.impl.GDoFPackageImpl;
import de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresAsListDegree;
import de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresAsRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresDegree;
import de.uka.ipd.sdq.pcm.designdecision.OptionalFeatureDegree;
import de.uka.ipd.sdq.pcm.designdecision.OrderedDataTypeDegree;
import de.uka.ipd.sdq.pcm.designdecision.OrderedIntegerDegree;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;
import de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityPropertiesPackage;
import de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl.QualityPropertiesPackageImpl;
import de.uka.ipd.sdq.pcm.designdecision.RangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegreeWithComponentChange;
import de.uka.ipd.sdq.pcm.designdecision.ResourceSelectionDegree;
import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree;
import de.uka.ipd.sdq.pcm.designdecision.StringComponentParamDegree;
import de.uka.ipd.sdq.pcm.designdecision.StringSetDegree;
import de.uka.ipd.sdq.pcm.designdecision.UnorderedDegree;
import de.uka.ipd.sdq.pcm.designdecision.UnorderedPrimitiveDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.designdecision.util.designdecisionValidator;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.resourcerepository.impl.resourcerepositoryPackageImpl;
import de.uka.ipd.sdq.pcm.resourcerepository.resourcerepositoryPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
public class designdecisionPackageImpl extends EPackageImpl implements designdecisionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass degreeOfFreedomInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classChoiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continousRangeChoiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continuousProcessingRateDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continuousRangeDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processingRateDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processingResourceDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allocationDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classAsReferenceDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assembledComponentDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass discreteRangeDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass discreteDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass discreteRangeChoiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceContainerReplicationDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decisionSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass candidateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass candidatesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureConfigDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureGroupDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureSubsetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionalFeatureDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass discreteProcessingRateDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass capacityDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingPolicyDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unorderedDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classWithCopyDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceSelectionDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringSetDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass discreteComponentParamDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continuousComponentParamDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringComponentParamDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unorderedPrimitiveDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberOfCoresAsRangeDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberOfCoresDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceContainerReplicationDegreeWithComponentChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exchangeComponentRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedDataTypeDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedIntegerDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberOfCoresAsListDegreeEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private designdecisionPackageImpl() {
		super(eNS_URI, designdecisionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link designdecisionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static designdecisionPackage init() {
		if (isInited) return (designdecisionPackage)EPackage.Registry.INSTANCE.getEPackage(designdecisionPackage.eNS_URI);

		// Obtain or create and register package
		designdecisionPackageImpl thedesigndecisionPackage = (designdecisionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof designdecisionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new designdecisionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		costPackage.eINSTANCE.eClass();
		featuremodelPackage.eINSTANCE.eClass();
		ResultdecoratorPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		GDoFPackageImpl theGDoFPackage = (GDoFPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GDoFPackage.eNS_URI) instanceof GDoFPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GDoFPackage.eNS_URI) : GDoFPackage.eINSTANCE);
		QualityPropertiesPackageImpl theQualityPropertiesPackage = (QualityPropertiesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QualityPropertiesPackage.eNS_URI) instanceof QualityPropertiesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QualityPropertiesPackage.eNS_URI) : QualityPropertiesPackage.eINSTANCE);
		resourcerepositoryPackageImpl theresourcerepositoryPackage = (resourcerepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(resourcerepositoryPackage.eNS_URI) instanceof resourcerepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(resourcerepositoryPackage.eNS_URI) : resourcerepositoryPackage.eINSTANCE);

		// Create package meta-data objects
		thedesigndecisionPackage.createPackageContents();
		theGDoFPackage.createPackageContents();
		theQualityPropertiesPackage.createPackageContents();
		theresourcerepositoryPackage.createPackageContents();

		// Initialize created meta-data
		thedesigndecisionPackage.initializePackageContents();
		theGDoFPackage.initializePackageContents();
		theQualityPropertiesPackage.initializePackageContents();
		theresourcerepositoryPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(thedesigndecisionPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return designdecisionValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		thedesigndecisionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(designdecisionPackage.eNS_URI, thedesigndecisionPackage);
		return thedesigndecisionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDegreeOfFreedomInstance() {
		return degreeOfFreedomInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDegreeOfFreedomInstance_PrimaryChanged() {
		return (EReference)degreeOfFreedomInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDegreeOfFreedomInstance_Dof() {
		return (EReference)degreeOfFreedomInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoice() {
		return choiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChoice_IsActive() {
		return (EAttribute)choiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoice_DegreeOfFreedomInstance() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRangeDegree() {
		return rangeDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRangeDegree_UpperBoundIncluded() {
		return (EAttribute)rangeDegreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRangeDegree_LowerBoundIncluded() {
		return (EAttribute)rangeDegreeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeDegree() {
		return dataTypeDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassDegree() {
		return classDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassDegree_ClassDesignOptions() {
		return (EReference)classDegreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassChoice() {
		return classChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassChoice_ChosenValue() {
		return (EReference)classChoiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinousRangeChoice() {
		return continousRangeChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContinousRangeChoice_ChosenValue() {
		return (EAttribute)continousRangeChoiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinuousProcessingRateDegree() {
		return continuousProcessingRateDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinuousRangeDegree() {
		return continuousRangeDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContinuousRangeDegree_To() {
		return (EAttribute)continuousRangeDegreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContinuousRangeDegree_From() {
		return (EAttribute)continuousRangeDegreeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessingRateDegree() {
		return processingRateDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessingResourceDegree() {
		return processingResourceDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessingResourceDegree_Processingresourcetype() {
		return (EReference)processingResourceDegreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllocationDegree() {
		return allocationDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassAsReferenceDegree() {
		return classAsReferenceDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssembledComponentDegree() {
		return assembledComponentDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiscreteRangeDegree() {
		return discreteRangeDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiscreteRangeDegree_To() {
		return (EAttribute)discreteRangeDegreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiscreteRangeDegree_From() {
		return (EAttribute)discreteRangeDegreeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiscreteDegree() {
		return discreteDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiscreteRangeChoice() {
		return discreteRangeChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiscreteRangeChoice_ChosenValue() {
		return (EAttribute)discreteRangeChoiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceContainerReplicationDegree() {
		return resourceContainerReplicationDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecisionSpace() {
		return decisionSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecisionSpace_DegreesOfFreedom() {
		return (EReference)decisionSpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCandidate() {
		return candidateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCandidate_Choices() {
		return (EReference)candidateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCandidate_QualityProperty() {
		return (EReference)candidateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCandidates() {
		return candidatesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCandidates_Candidate() {
		return (EReference)candidatesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCandidates_Problem() {
		return (EReference)candidatesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureConfigDegree() {
		return featureConfigDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureGroupDegree() {
		return featureGroupDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupDegree_Featuregroup() {
		return (EReference)featureGroupDegreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureGroupDegree_DomainOfFeatureConfigCombinations() {
		return (EReference)featureGroupDegreeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureSubset() {
		return featureSubsetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureSubset_Feature() {
		return (EReference)featureSubsetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOptionalFeatureDegree() {
		return optionalFeatureDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOptionalFeatureDegree_Simple() {
		return (EReference)optionalFeatureDegreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiscreteProcessingRateDegree() {
		return discreteProcessingRateDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiscreteProcessingRateDegree_NumberOfSteps() {
		return (EAttribute)discreteProcessingRateDegreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCapacityDegree() {
		return capacityDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingPolicyDegree() {
		return schedulingPolicyDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumDegree() {
		return enumDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumDegree_Enumeration() {
		return (EReference)enumDegreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnorderedDegree() {
		return unorderedDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassWithCopyDegree() {
		return classWithCopyDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceSelectionDegree() {
		return resourceSelectionDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringSetDegree() {
		return stringSetDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringSetDegree_StringValues() {
		return (EAttribute)stringSetDegreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiscreteComponentParamDegree() {
		return discreteComponentParamDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinuousComponentParamDegree() {
		return continuousComponentParamDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringComponentParamDegree() {
		return stringComponentParamDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnorderedPrimitiveDegree() {
		return unorderedPrimitiveDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberOfCoresAsRangeDegree() {
		return numberOfCoresAsRangeDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberOfCoresDegree() {
		return numberOfCoresDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceContainerReplicationDegreeWithComponentChange() {
		return resourceContainerReplicationDegreeWithComponentChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceContainerReplicationDegreeWithComponentChange_ExchangeComponentRule() {
		return (EReference)resourceContainerReplicationDegreeWithComponentChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExchangeComponentRule() {
		return exchangeComponentRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExchangeComponentRule_RepositoryComponent() {
		return (EReference)exchangeComponentRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExchangeComponentRule_AllocationContext() {
		return (EReference)exchangeComponentRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedDataTypeDegree() {
		return orderedDataTypeDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedIntegerDegree() {
		return orderedIntegerDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrderedIntegerDegree_ListOfIntegers() {
		return (EAttribute)orderedIntegerDegreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberOfCoresAsListDegree() {
		return numberOfCoresAsListDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designdecisionFactory getdesigndecisionFactory() {
		return (designdecisionFactory)getEFactoryInstance();
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
		degreeOfFreedomInstanceEClass = createEClass(DEGREE_OF_FREEDOM_INSTANCE);
		createEReference(degreeOfFreedomInstanceEClass, DEGREE_OF_FREEDOM_INSTANCE__PRIMARY_CHANGED);
		createEReference(degreeOfFreedomInstanceEClass, DEGREE_OF_FREEDOM_INSTANCE__DOF);

		choiceEClass = createEClass(CHOICE);
		createEAttribute(choiceEClass, CHOICE__IS_ACTIVE);
		createEReference(choiceEClass, CHOICE__DEGREE_OF_FREEDOM_INSTANCE);

		rangeDegreeEClass = createEClass(RANGE_DEGREE);
		createEAttribute(rangeDegreeEClass, RANGE_DEGREE__UPPER_BOUND_INCLUDED);
		createEAttribute(rangeDegreeEClass, RANGE_DEGREE__LOWER_BOUND_INCLUDED);

		dataTypeDegreeEClass = createEClass(DATA_TYPE_DEGREE);

		classDegreeEClass = createEClass(CLASS_DEGREE);
		createEReference(classDegreeEClass, CLASS_DEGREE__CLASS_DESIGN_OPTIONS);

		classChoiceEClass = createEClass(CLASS_CHOICE);
		createEReference(classChoiceEClass, CLASS_CHOICE__CHOSEN_VALUE);

		continousRangeChoiceEClass = createEClass(CONTINOUS_RANGE_CHOICE);
		createEAttribute(continousRangeChoiceEClass, CONTINOUS_RANGE_CHOICE__CHOSEN_VALUE);

		continuousProcessingRateDegreeEClass = createEClass(CONTINUOUS_PROCESSING_RATE_DEGREE);

		continuousRangeDegreeEClass = createEClass(CONTINUOUS_RANGE_DEGREE);
		createEAttribute(continuousRangeDegreeEClass, CONTINUOUS_RANGE_DEGREE__TO);
		createEAttribute(continuousRangeDegreeEClass, CONTINUOUS_RANGE_DEGREE__FROM);

		processingRateDegreeEClass = createEClass(PROCESSING_RATE_DEGREE);

		processingResourceDegreeEClass = createEClass(PROCESSING_RESOURCE_DEGREE);
		createEReference(processingResourceDegreeEClass, PROCESSING_RESOURCE_DEGREE__PROCESSINGRESOURCETYPE);

		allocationDegreeEClass = createEClass(ALLOCATION_DEGREE);

		classAsReferenceDegreeEClass = createEClass(CLASS_AS_REFERENCE_DEGREE);

		assembledComponentDegreeEClass = createEClass(ASSEMBLED_COMPONENT_DEGREE);

		discreteRangeDegreeEClass = createEClass(DISCRETE_RANGE_DEGREE);
		createEAttribute(discreteRangeDegreeEClass, DISCRETE_RANGE_DEGREE__TO);
		createEAttribute(discreteRangeDegreeEClass, DISCRETE_RANGE_DEGREE__FROM);

		discreteDegreeEClass = createEClass(DISCRETE_DEGREE);

		discreteRangeChoiceEClass = createEClass(DISCRETE_RANGE_CHOICE);
		createEAttribute(discreteRangeChoiceEClass, DISCRETE_RANGE_CHOICE__CHOSEN_VALUE);

		resourceContainerReplicationDegreeEClass = createEClass(RESOURCE_CONTAINER_REPLICATION_DEGREE);

		decisionSpaceEClass = createEClass(DECISION_SPACE);
		createEReference(decisionSpaceEClass, DECISION_SPACE__DEGREES_OF_FREEDOM);

		candidateEClass = createEClass(CANDIDATE);
		createEReference(candidateEClass, CANDIDATE__CHOICES);
		createEReference(candidateEClass, CANDIDATE__QUALITY_PROPERTY);

		candidatesEClass = createEClass(CANDIDATES);
		createEReference(candidatesEClass, CANDIDATES__CANDIDATE);
		createEReference(candidatesEClass, CANDIDATES__PROBLEM);

		featureConfigDegreeEClass = createEClass(FEATURE_CONFIG_DEGREE);

		featureGroupDegreeEClass = createEClass(FEATURE_GROUP_DEGREE);
		createEReference(featureGroupDegreeEClass, FEATURE_GROUP_DEGREE__FEATUREGROUP);
		createEReference(featureGroupDegreeEClass, FEATURE_GROUP_DEGREE__DOMAIN_OF_FEATURE_CONFIG_COMBINATIONS);

		featureSubsetEClass = createEClass(FEATURE_SUBSET);
		createEReference(featureSubsetEClass, FEATURE_SUBSET__FEATURE);

		optionalFeatureDegreeEClass = createEClass(OPTIONAL_FEATURE_DEGREE);
		createEReference(optionalFeatureDegreeEClass, OPTIONAL_FEATURE_DEGREE__SIMPLE);

		discreteProcessingRateDegreeEClass = createEClass(DISCRETE_PROCESSING_RATE_DEGREE);
		createEAttribute(discreteProcessingRateDegreeEClass, DISCRETE_PROCESSING_RATE_DEGREE__NUMBER_OF_STEPS);

		capacityDegreeEClass = createEClass(CAPACITY_DEGREE);

		schedulingPolicyDegreeEClass = createEClass(SCHEDULING_POLICY_DEGREE);

		enumDegreeEClass = createEClass(ENUM_DEGREE);
		createEReference(enumDegreeEClass, ENUM_DEGREE__ENUMERATION);

		unorderedDegreeEClass = createEClass(UNORDERED_DEGREE);

		classWithCopyDegreeEClass = createEClass(CLASS_WITH_COPY_DEGREE);

		resourceSelectionDegreeEClass = createEClass(RESOURCE_SELECTION_DEGREE);

		stringSetDegreeEClass = createEClass(STRING_SET_DEGREE);
		createEAttribute(stringSetDegreeEClass, STRING_SET_DEGREE__STRING_VALUES);

		discreteComponentParamDegreeEClass = createEClass(DISCRETE_COMPONENT_PARAM_DEGREE);

		continuousComponentParamDegreeEClass = createEClass(CONTINUOUS_COMPONENT_PARAM_DEGREE);

		stringComponentParamDegreeEClass = createEClass(STRING_COMPONENT_PARAM_DEGREE);

		unorderedPrimitiveDegreeEClass = createEClass(UNORDERED_PRIMITIVE_DEGREE);

		numberOfCoresAsRangeDegreeEClass = createEClass(NUMBER_OF_CORES_AS_RANGE_DEGREE);

		numberOfCoresDegreeEClass = createEClass(NUMBER_OF_CORES_DEGREE);

		resourceContainerReplicationDegreeWithComponentChangeEClass = createEClass(RESOURCE_CONTAINER_REPLICATION_DEGREE_WITH_COMPONENT_CHANGE);
		createEReference(resourceContainerReplicationDegreeWithComponentChangeEClass, RESOURCE_CONTAINER_REPLICATION_DEGREE_WITH_COMPONENT_CHANGE__EXCHANGE_COMPONENT_RULE);

		exchangeComponentRuleEClass = createEClass(EXCHANGE_COMPONENT_RULE);
		createEReference(exchangeComponentRuleEClass, EXCHANGE_COMPONENT_RULE__REPOSITORY_COMPONENT);
		createEReference(exchangeComponentRuleEClass, EXCHANGE_COMPONENT_RULE__ALLOCATION_CONTEXT);

		orderedDataTypeDegreeEClass = createEClass(ORDERED_DATA_TYPE_DEGREE);

		orderedIntegerDegreeEClass = createEClass(ORDERED_INTEGER_DEGREE);
		createEAttribute(orderedIntegerDegreeEClass, ORDERED_INTEGER_DEGREE__LIST_OF_INTEGERS);

		numberOfCoresAsListDegreeEClass = createEClass(NUMBER_OF_CORES_AS_LIST_DEGREE);
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
		GDoFPackage theGDoFPackage = (GDoFPackage)EPackage.Registry.INSTANCE.getEPackage(GDoFPackage.eNS_URI);
		QualityPropertiesPackage theQualityPropertiesPackage = (QualityPropertiesPackage)EPackage.Registry.INSTANCE.getEPackage(QualityPropertiesPackage.eNS_URI);
		resourcerepositoryPackage theresourcerepositoryPackage = (resourcerepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(resourcerepositoryPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ResourcetypePackage theResourcetypePackage = (ResourcetypePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI);
		featuremodelPackage thefeaturemodelPackage = (featuremodelPackage)EPackage.Registry.INSTANCE.getEPackage(featuremodelPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		AllocationPackage theAllocationPackage = (AllocationPackage)EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theGDoFPackage);
		getESubpackages().add(theQualityPropertiesPackage);
		getESubpackages().add(theresourcerepositoryPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		rangeDegreeEClass.getESuperTypes().add(this.getDataTypeDegree());
		dataTypeDegreeEClass.getESuperTypes().add(this.getDegreeOfFreedomInstance());
		classDegreeEClass.getESuperTypes().add(this.getDegreeOfFreedomInstance());
		classChoiceEClass.getESuperTypes().add(this.getChoice());
		continousRangeChoiceEClass.getESuperTypes().add(this.getChoice());
		continuousProcessingRateDegreeEClass.getESuperTypes().add(this.getContinuousRangeDegree());
		continuousProcessingRateDegreeEClass.getESuperTypes().add(this.getProcessingRateDegree());
		continuousRangeDegreeEClass.getESuperTypes().add(this.getRangeDegree());
		processingRateDegreeEClass.getESuperTypes().add(this.getProcessingResourceDegree());
		processingResourceDegreeEClass.getESuperTypes().add(this.getDegreeOfFreedomInstance());
		allocationDegreeEClass.getESuperTypes().add(this.getClassAsReferenceDegree());
		classAsReferenceDegreeEClass.getESuperTypes().add(this.getClassDegree());
		assembledComponentDegreeEClass.getESuperTypes().add(this.getClassAsReferenceDegree());
		discreteRangeDegreeEClass.getESuperTypes().add(this.getRangeDegree());
		discreteRangeDegreeEClass.getESuperTypes().add(this.getDiscreteDegree());
		discreteDegreeEClass.getESuperTypes().add(this.getDataTypeDegree());
		discreteRangeChoiceEClass.getESuperTypes().add(this.getChoice());
		resourceContainerReplicationDegreeEClass.getESuperTypes().add(this.getDiscreteRangeDegree());
		featureConfigDegreeEClass.getESuperTypes().add(this.getDegreeOfFreedomInstance());
		featureGroupDegreeEClass.getESuperTypes().add(this.getFeatureConfigDegree());
		optionalFeatureDegreeEClass.getESuperTypes().add(this.getFeatureConfigDegree());
		discreteProcessingRateDegreeEClass.getESuperTypes().add(this.getDiscreteRangeDegree());
		discreteProcessingRateDegreeEClass.getESuperTypes().add(this.getProcessingRateDegree());
		capacityDegreeEClass.getESuperTypes().add(this.getDiscreteRangeDegree());
		schedulingPolicyDegreeEClass.getESuperTypes().add(this.getClassAsReferenceDegree());
		schedulingPolicyDegreeEClass.getESuperTypes().add(this.getProcessingResourceDegree());
		enumDegreeEClass.getESuperTypes().add(this.getUnorderedDegree());
		unorderedDegreeEClass.getESuperTypes().add(this.getDataTypeDegree());
		classWithCopyDegreeEClass.getESuperTypes().add(this.getClassDegree());
		resourceSelectionDegreeEClass.getESuperTypes().add(this.getClassWithCopyDegree());
		resourceSelectionDegreeEClass.getESuperTypes().add(this.getProcessingResourceDegree());
		stringSetDegreeEClass.getESuperTypes().add(this.getUnorderedDegree());
		discreteComponentParamDegreeEClass.getESuperTypes().add(this.getDiscreteRangeDegree());
		continuousComponentParamDegreeEClass.getESuperTypes().add(this.getContinuousRangeDegree());
		stringComponentParamDegreeEClass.getESuperTypes().add(this.getStringSetDegree());
		unorderedPrimitiveDegreeEClass.getESuperTypes().add(this.getUnorderedDegree());
		numberOfCoresAsRangeDegreeEClass.getESuperTypes().add(this.getDiscreteRangeDegree());
		numberOfCoresAsRangeDegreeEClass.getESuperTypes().add(this.getNumberOfCoresDegree());
		numberOfCoresDegreeEClass.getESuperTypes().add(this.getProcessingResourceDegree());
		resourceContainerReplicationDegreeWithComponentChangeEClass.getESuperTypes().add(this.getResourceContainerReplicationDegree());
		orderedDataTypeDegreeEClass.getESuperTypes().add(this.getDataTypeDegree());
		orderedIntegerDegreeEClass.getESuperTypes().add(this.getDiscreteDegree());
		orderedIntegerDegreeEClass.getESuperTypes().add(this.getOrderedDataTypeDegree());
		numberOfCoresAsListDegreeEClass.getESuperTypes().add(this.getNumberOfCoresDegree());
		numberOfCoresAsListDegreeEClass.getESuperTypes().add(this.getOrderedIntegerDegree());

		// Initialize classes and features; add operations and parameters
		initEClass(degreeOfFreedomInstanceEClass, DegreeOfFreedomInstance.class, "DegreeOfFreedomInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDegreeOfFreedomInstance_PrimaryChanged(), theEcorePackage.getEObject(), null, "primaryChanged", null, 1, 1, DegreeOfFreedomInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDegreeOfFreedomInstance_Dof(), theGDoFPackage.getDegreeOfFreedom(), null, "dof", null, 1, 1, DegreeOfFreedomInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(choiceEClass, Choice.class, "Choice", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChoice_IsActive(), ecorePackage.getEBoolean(), "isActive", "true", 1, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getChoice_DegreeOfFreedomInstance(), this.getDegreeOfFreedomInstance(), null, "degreeOfFreedomInstance", null, 1, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rangeDegreeEClass, RangeDegree.class, "RangeDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRangeDegree_UpperBoundIncluded(), ecorePackage.getEBoolean(), "upperBoundIncluded", "true", 1, 1, RangeDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRangeDegree_LowerBoundIncluded(), ecorePackage.getEBoolean(), "lowerBoundIncluded", "true", 1, 1, RangeDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataTypeDegreeEClass, DataTypeDegree.class, "DataTypeDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classDegreeEClass, ClassDegree.class, "ClassDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassDegree_ClassDesignOptions(), theEcorePackage.getEObject(), null, "classDesignOptions", null, 1, -1, ClassDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(classChoiceEClass, ClassChoice.class, "ClassChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassChoice_ChosenValue(), theEcorePackage.getEObject(), null, "chosenValue", null, 1, 1, ClassChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(continousRangeChoiceEClass, ContinousRangeChoice.class, "ContinousRangeChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContinousRangeChoice_ChosenValue(), ecorePackage.getEDouble(), "chosenValue", null, 1, 1, ContinousRangeChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(continuousProcessingRateDegreeEClass, ContinuousProcessingRateDegree.class, "ContinuousProcessingRateDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(continuousRangeDegreeEClass, ContinuousRangeDegree.class, "ContinuousRangeDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContinuousRangeDegree_To(), ecorePackage.getEDouble(), "to", null, 1, 1, ContinuousRangeDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContinuousRangeDegree_From(), ecorePackage.getEDouble(), "from", null, 1, 1, ContinuousRangeDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(processingRateDegreeEClass, ProcessingRateDegree.class, "ProcessingRateDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(processingResourceDegreeEClass, ProcessingResourceDegree.class, "ProcessingResourceDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessingResourceDegree_Processingresourcetype(), theResourcetypePackage.getProcessingResourceType(), null, "processingresourcetype", null, 1, 1, ProcessingResourceDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(allocationDegreeEClass, AllocationDegree.class, "AllocationDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classAsReferenceDegreeEClass, ClassAsReferenceDegree.class, "ClassAsReferenceDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assembledComponentDegreeEClass, AssembledComponentDegree.class, "AssembledComponentDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(discreteRangeDegreeEClass, DiscreteRangeDegree.class, "DiscreteRangeDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiscreteRangeDegree_To(), ecorePackage.getEInt(), "to", null, 1, 1, DiscreteRangeDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDiscreteRangeDegree_From(), ecorePackage.getEInt(), "from", null, 1, 1, DiscreteRangeDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(discreteDegreeEClass, DiscreteDegree.class, "DiscreteDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(discreteRangeChoiceEClass, DiscreteRangeChoice.class, "DiscreteRangeChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiscreteRangeChoice_ChosenValue(), ecorePackage.getEInt(), "chosenValue", null, 1, 1, DiscreteRangeChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceContainerReplicationDegreeEClass, ResourceContainerReplicationDegree.class, "ResourceContainerReplicationDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(decisionSpaceEClass, DecisionSpace.class, "DecisionSpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDecisionSpace_DegreesOfFreedom(), this.getDegreeOfFreedomInstance(), null, "degreesOfFreedom", null, 1, -1, DecisionSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(candidateEClass, Candidate.class, "Candidate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCandidate_Choices(), this.getChoice(), null, "choices", null, 0, -1, Candidate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCandidate_QualityProperty(), theQualityPropertiesPackage.getQualityProperty(), null, "qualityProperty", null, 0, -1, Candidate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(candidatesEClass, Candidates.class, "Candidates", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCandidates_Candidate(), this.getCandidate(), null, "candidate", null, 0, -1, Candidates.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCandidates_Problem(), this.getDecisionSpace(), null, "problem", null, 1, 1, Candidates.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(candidatesEClass, ecorePackage.getEBoolean(), "numberOfChoicesMustEqualNumberOfDecisions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(featureConfigDegreeEClass, FeatureConfigDegree.class, "FeatureConfigDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureGroupDegreeEClass, FeatureGroupDegree.class, "FeatureGroupDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureGroupDegree_Featuregroup(), thefeaturemodelPackage.getFeatureGroup(), null, "featuregroup", null, 1, 1, FeatureGroupDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFeatureGroupDegree_DomainOfFeatureConfigCombinations(), this.getFeatureSubset(), null, "domainOfFeatureConfigCombinations", null, 1, -1, FeatureGroupDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(featureSubsetEClass, FeatureSubset.class, "FeatureSubset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureSubset_Feature(), thefeaturemodelPackage.getFeature(), null, "feature", null, 0, -1, FeatureSubset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(optionalFeatureDegreeEClass, OptionalFeatureDegree.class, "OptionalFeatureDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptionalFeatureDegree_Simple(), thefeaturemodelPackage.getSimple(), null, "simple", null, 1, 1, OptionalFeatureDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(discreteProcessingRateDegreeEClass, DiscreteProcessingRateDegree.class, "DiscreteProcessingRateDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiscreteProcessingRateDegree_NumberOfSteps(), ecorePackage.getEInt(), "numberOfSteps", null, 1, 1, DiscreteProcessingRateDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(capacityDegreeEClass, CapacityDegree.class, "CapacityDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(schedulingPolicyDegreeEClass, SchedulingPolicyDegree.class, "SchedulingPolicyDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumDegreeEClass, EnumDegree.class, "EnumDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumDegree_Enumeration(), theEcorePackage.getEEnum(), null, "enumeration", null, 0, 1, EnumDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(unorderedDegreeEClass, UnorderedDegree.class, "UnorderedDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classWithCopyDegreeEClass, ClassWithCopyDegree.class, "ClassWithCopyDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceSelectionDegreeEClass, ResourceSelectionDegree.class, "ResourceSelectionDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringSetDegreeEClass, StringSetDegree.class, "StringSetDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringSetDegree_StringValues(), ecorePackage.getEString(), "stringValues", null, 1, -1, StringSetDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(discreteComponentParamDegreeEClass, DiscreteComponentParamDegree.class, "DiscreteComponentParamDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(continuousComponentParamDegreeEClass, ContinuousComponentParamDegree.class, "ContinuousComponentParamDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringComponentParamDegreeEClass, StringComponentParamDegree.class, "StringComponentParamDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unorderedPrimitiveDegreeEClass, UnorderedPrimitiveDegree.class, "UnorderedPrimitiveDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numberOfCoresAsRangeDegreeEClass, NumberOfCoresAsRangeDegree.class, "NumberOfCoresAsRangeDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numberOfCoresDegreeEClass, NumberOfCoresDegree.class, "NumberOfCoresDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceContainerReplicationDegreeWithComponentChangeEClass, ResourceContainerReplicationDegreeWithComponentChange.class, "ResourceContainerReplicationDegreeWithComponentChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceContainerReplicationDegreeWithComponentChange_ExchangeComponentRule(), this.getExchangeComponentRule(), null, "exchangeComponentRule", null, 0, -1, ResourceContainerReplicationDegreeWithComponentChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(exchangeComponentRuleEClass, ExchangeComponentRule.class, "ExchangeComponentRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExchangeComponentRule_RepositoryComponent(), theRepositoryPackage.getRepositoryComponent(), null, "repositoryComponent", null, 1, -1, ExchangeComponentRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExchangeComponentRule_AllocationContext(), theAllocationPackage.getAllocationContext(), null, "allocationContext", null, 0, 1, ExchangeComponentRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(orderedDataTypeDegreeEClass, OrderedDataTypeDegree.class, "OrderedDataTypeDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orderedIntegerDegreeEClass, OrderedIntegerDegree.class, "OrderedIntegerDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrderedIntegerDegree_ListOfIntegers(), ecorePackage.getEInt(), "listOfIntegers", null, 1, -1, OrderedIntegerDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(numberOfCoresAsListDegreeEClass, NumberOfCoresAsListDegree.class, "NumberOfCoresAsListDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //designdecisionPackageImpl
