/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.featuremodel.featuremodelPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.CorePackage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree;
import de.uka.ipd.sdq.pcm.designdecision.Candidate;
import de.uka.ipd.sdq.pcm.designdecision.Candidates;
import de.uka.ipd.sdq.pcm.designdecision.CapacityDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ConnectorConfigDegree;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.EnumDegree;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree;

import de.uka.ipd.sdq.pcm.designdecision.FeatureConfigDegree;
import de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree;
import de.uka.ipd.sdq.pcm.designdecision.FeatureSubset;
import de.uka.ipd.sdq.pcm.designdecision.OptionalFeatureDegree;
import de.uka.ipd.sdq.pcm.designdecision.PrimitiveTypes.PrimitiveTypesPackage;

import de.uka.ipd.sdq.pcm.designdecision.PrimitiveTypes.impl.PrimitiveTypesPackageImpl;

import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;
import de.uka.ipd.sdq.pcm.designdecision.RangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree;
import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyChoice;
import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.designdecision.util.designdecisionValidator;

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
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

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
	private EClass degreeOfFreedomEClass = null;

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
	private EClass enumerationDegreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationChoiceEClass = null;

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
	private EClass problemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorConfigDegreeEClass = null;

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
	private EClass schedulingPolicyChoiceEClass = null;

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
		featuremodelPackage.eINSTANCE.eClass();
		CorePackage.eINSTANCE.eClass();
		ParameterPackage.eINSTANCE.eClass();
		UsagemodelPackage.eINSTANCE.eClass();
		RepositoryPackage.eINSTANCE.eClass();
		ProtocolPackage.eINSTANCE.eClass();
		SeffPackage.eINSTANCE.eClass();
		ResourcetypePackage.eINSTANCE.eClass();
		QosannotationsPackage.eINSTANCE.eClass();
		SystemPackage.eINSTANCE.eClass();
		ResourceenvironmentPackage.eINSTANCE.eClass();
		AllocationPackage.eINSTANCE.eClass();
		SubsystemPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PrimitiveTypesPackageImpl thePrimitiveTypesPackage = (PrimitiveTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesPackage.eNS_URI) instanceof PrimitiveTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesPackage.eNS_URI) : PrimitiveTypesPackage.eINSTANCE);

		// Create package meta-data objects
		thedesigndecisionPackage.createPackageContents();
		thePrimitiveTypesPackage.createPackageContents();

		// Initialize created meta-data
		thedesigndecisionPackage.initializePackageContents();
		thePrimitiveTypesPackage.initializePackageContents();

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
	public EClass getDegreeOfFreedom() {
		return degreeOfFreedomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDegreeOfFreedom_ChangeableEntity() {
		return (EReference)degreeOfFreedomEClass.getEStructuralFeatures().get(0);
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
	public EReference getChoice_DegreeOfFreedom() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(0);
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
	public EClass getEnumerationDegree() {
		return enumerationDegreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationDegree_DomainOfEntities() {
		return (EReference)enumerationDegreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationChoice() {
		return enumerationChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationChoice_Entity() {
		return (EReference)enumerationChoiceEClass.getEStructuralFeatures().get(0);
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
	public EClass getProblem() {
		return problemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProblem_Designdecision() {
		return (EReference)problemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorConfigDegree() {
		return connectorConfigDegreeEClass;
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
	public EReference getCandidate_Choice() {
		return (EReference)candidateEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getSchedulingPolicyDegree_DomainOfAllowedSchedulingPolicies() {
		return (EAttribute)schedulingPolicyDegreeEClass.getEStructuralFeatures().get(0);
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
	public EClass getSchedulingPolicyChoice() {
		return schedulingPolicyChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulingPolicyChoice_ChosenValue() {
		return (EAttribute)schedulingPolicyChoiceEClass.getEStructuralFeatures().get(0);
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
		degreeOfFreedomEClass = createEClass(DEGREE_OF_FREEDOM);
		createEReference(degreeOfFreedomEClass, DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY);

		choiceEClass = createEClass(CHOICE);
		createEReference(choiceEClass, CHOICE__DEGREE_OF_FREEDOM);

		rangeDegreeEClass = createEClass(RANGE_DEGREE);
		createEAttribute(rangeDegreeEClass, RANGE_DEGREE__UPPER_BOUND_INCLUDED);
		createEAttribute(rangeDegreeEClass, RANGE_DEGREE__LOWER_BOUND_INCLUDED);

		enumerationDegreeEClass = createEClass(ENUMERATION_DEGREE);
		createEReference(enumerationDegreeEClass, ENUMERATION_DEGREE__DOMAIN_OF_ENTITIES);

		enumerationChoiceEClass = createEClass(ENUMERATION_CHOICE);
		createEReference(enumerationChoiceEClass, ENUMERATION_CHOICE__ENTITY);

		continousRangeChoiceEClass = createEClass(CONTINOUS_RANGE_CHOICE);
		createEAttribute(continousRangeChoiceEClass, CONTINOUS_RANGE_CHOICE__CHOSEN_VALUE);

		continuousProcessingRateDegreeEClass = createEClass(CONTINUOUS_PROCESSING_RATE_DEGREE);

		continuousRangeDegreeEClass = createEClass(CONTINUOUS_RANGE_DEGREE);
		createEAttribute(continuousRangeDegreeEClass, CONTINUOUS_RANGE_DEGREE__TO);
		createEAttribute(continuousRangeDegreeEClass, CONTINUOUS_RANGE_DEGREE__FROM);

		processingResourceDegreeEClass = createEClass(PROCESSING_RESOURCE_DEGREE);
		createEReference(processingResourceDegreeEClass, PROCESSING_RESOURCE_DEGREE__PROCESSINGRESOURCETYPE);

		allocationDegreeEClass = createEClass(ALLOCATION_DEGREE);

		assembledComponentDegreeEClass = createEClass(ASSEMBLED_COMPONENT_DEGREE);

		discreteRangeDegreeEClass = createEClass(DISCRETE_RANGE_DEGREE);
		createEAttribute(discreteRangeDegreeEClass, DISCRETE_RANGE_DEGREE__TO);
		createEAttribute(discreteRangeDegreeEClass, DISCRETE_RANGE_DEGREE__FROM);

		discreteRangeChoiceEClass = createEClass(DISCRETE_RANGE_CHOICE);
		createEAttribute(discreteRangeChoiceEClass, DISCRETE_RANGE_CHOICE__CHOSEN_VALUE);

		resourceContainerReplicationDegreeEClass = createEClass(RESOURCE_CONTAINER_REPLICATION_DEGREE);

		problemEClass = createEClass(PROBLEM);
		createEReference(problemEClass, PROBLEM__DESIGNDECISION);

		connectorConfigDegreeEClass = createEClass(CONNECTOR_CONFIG_DEGREE);

		candidateEClass = createEClass(CANDIDATE);
		createEReference(candidateEClass, CANDIDATE__CHOICE);

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
		createEAttribute(schedulingPolicyDegreeEClass, SCHEDULING_POLICY_DEGREE__DOMAIN_OF_ALLOWED_SCHEDULING_POLICIES);

		enumDegreeEClass = createEClass(ENUM_DEGREE);

		schedulingPolicyChoiceEClass = createEClass(SCHEDULING_POLICY_CHOICE);
		createEAttribute(schedulingPolicyChoiceEClass, SCHEDULING_POLICY_CHOICE__CHOSEN_VALUE);
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
		PrimitiveTypesPackage thePrimitiveTypesPackage = (PrimitiveTypesPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesPackage.eNS_URI);
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
		ResourcetypePackage theResourcetypePackage = (ResourcetypePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI);
		featuremodelPackage thefeaturemodelPackage = (featuremodelPackage)EPackage.Registry.INSTANCE.getEPackage(featuremodelPackage.eNS_URI);
		ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(thePrimitiveTypesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		rangeDegreeEClass.getESuperTypes().add(this.getDegreeOfFreedom());
		enumerationDegreeEClass.getESuperTypes().add(this.getDegreeOfFreedom());
		enumerationChoiceEClass.getESuperTypes().add(this.getChoice());
		continousRangeChoiceEClass.getESuperTypes().add(this.getChoice());
		continuousProcessingRateDegreeEClass.getESuperTypes().add(this.getContinuousRangeDegree());
		continuousProcessingRateDegreeEClass.getESuperTypes().add(this.getProcessingResourceDegree());
		continuousRangeDegreeEClass.getESuperTypes().add(this.getRangeDegree());
		processingResourceDegreeEClass.getESuperTypes().add(this.getDegreeOfFreedom());
		allocationDegreeEClass.getESuperTypes().add(this.getEnumerationDegree());
		assembledComponentDegreeEClass.getESuperTypes().add(this.getEnumerationDegree());
		discreteRangeDegreeEClass.getESuperTypes().add(this.getRangeDegree());
		discreteRangeChoiceEClass.getESuperTypes().add(this.getChoice());
		resourceContainerReplicationDegreeEClass.getESuperTypes().add(this.getDiscreteRangeDegree());
		connectorConfigDegreeEClass.getESuperTypes().add(this.getEnumerationDegree());
		featureConfigDegreeEClass.getESuperTypes().add(this.getDegreeOfFreedom());
		featureGroupDegreeEClass.getESuperTypes().add(this.getFeatureConfigDegree());
		optionalFeatureDegreeEClass.getESuperTypes().add(this.getFeatureConfigDegree());
		discreteProcessingRateDegreeEClass.getESuperTypes().add(this.getDiscreteRangeDegree());
		discreteProcessingRateDegreeEClass.getESuperTypes().add(this.getProcessingResourceDegree());
		capacityDegreeEClass.getESuperTypes().add(this.getDiscreteRangeDegree());
		schedulingPolicyDegreeEClass.getESuperTypes().add(this.getProcessingResourceDegree());
		schedulingPolicyDegreeEClass.getESuperTypes().add(this.getEnumDegree());
		enumDegreeEClass.getESuperTypes().add(this.getDegreeOfFreedom());
		schedulingPolicyChoiceEClass.getESuperTypes().add(this.getChoice());

		// Initialize classes and features; add operations and parameters
		initEClass(degreeOfFreedomEClass, DegreeOfFreedom.class, "DegreeOfFreedom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDegreeOfFreedom_ChangeableEntity(), theEntityPackage.getEntity(), null, "changeableEntity", null, 1, 1, DegreeOfFreedom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(choiceEClass, Choice.class, "Choice", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoice_DegreeOfFreedom(), this.getDegreeOfFreedom(), null, "degreeOfFreedom", null, 1, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rangeDegreeEClass, RangeDegree.class, "RangeDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRangeDegree_UpperBoundIncluded(), ecorePackage.getEBoolean(), "upperBoundIncluded", "true", 1, 1, RangeDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRangeDegree_LowerBoundIncluded(), ecorePackage.getEBoolean(), "lowerBoundIncluded", "true", 1, 1, RangeDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(enumerationDegreeEClass, EnumerationDegree.class, "EnumerationDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumerationDegree_DomainOfEntities(), theEntityPackage.getEntity(), null, "domainOfEntities", null, 1, -1, EnumerationDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(enumerationChoiceEClass, EnumerationChoice.class, "EnumerationChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumerationChoice_Entity(), theEntityPackage.getEntity(), null, "entity", null, 0, 1, EnumerationChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(continousRangeChoiceEClass, ContinousRangeChoice.class, "ContinousRangeChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContinousRangeChoice_ChosenValue(), thePrimitiveTypesPackage.getdouble(), "chosenValue", null, 1, 1, ContinousRangeChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(continuousProcessingRateDegreeEClass, ContinuousProcessingRateDegree.class, "ContinuousProcessingRateDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(continuousRangeDegreeEClass, ContinuousRangeDegree.class, "ContinuousRangeDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContinuousRangeDegree_To(), ecorePackage.getEDouble(), "to", null, 1, 1, ContinuousRangeDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContinuousRangeDegree_From(), ecorePackage.getEDouble(), "from", null, 1, 1, ContinuousRangeDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(processingResourceDegreeEClass, ProcessingResourceDegree.class, "ProcessingResourceDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessingResourceDegree_Processingresourcetype(), theResourcetypePackage.getProcessingResourceType(), null, "processingresourcetype", null, 1, 1, ProcessingResourceDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(allocationDegreeEClass, AllocationDegree.class, "AllocationDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assembledComponentDegreeEClass, AssembledComponentDegree.class, "AssembledComponentDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(discreteRangeDegreeEClass, DiscreteRangeDegree.class, "DiscreteRangeDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiscreteRangeDegree_To(), ecorePackage.getEInt(), "to", null, 1, 1, DiscreteRangeDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDiscreteRangeDegree_From(), ecorePackage.getEInt(), "from", null, 1, 1, DiscreteRangeDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(discreteRangeChoiceEClass, DiscreteRangeChoice.class, "DiscreteRangeChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiscreteRangeChoice_ChosenValue(), ecorePackage.getEInt(), "chosenValue", null, 1, 1, DiscreteRangeChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceContainerReplicationDegreeEClass, ResourceContainerReplicationDegree.class, "ResourceContainerReplicationDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(problemEClass, Problem.class, "Problem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProblem_Designdecision(), this.getDegreeOfFreedom(), null, "designdecision", null, 1, -1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(connectorConfigDegreeEClass, ConnectorConfigDegree.class, "ConnectorConfigDegree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(candidateEClass, Candidate.class, "Candidate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCandidate_Choice(), this.getChoice(), null, "choice", null, 0, -1, Candidate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(candidatesEClass, Candidates.class, "Candidates", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCandidates_Candidate(), this.getCandidate(), null, "candidate", null, 0, -1, Candidates.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCandidates_Problem(), this.getProblem(), null, "problem", null, 1, 1, Candidates.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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
		initEAttribute(getSchedulingPolicyDegree_DomainOfAllowedSchedulingPolicies(), theResourceenvironmentPackage.getSchedulingPolicy(), "domainOfAllowedSchedulingPolicies", null, 0, -1, SchedulingPolicyDegree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(enumDegreeEClass, EnumDegree.class, "EnumDegree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(schedulingPolicyChoiceEClass, SchedulingPolicyChoice.class, "SchedulingPolicyChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSchedulingPolicyChoice_ChosenValue(), theResourceenvironmentPackage.getSchedulingPolicy(), "chosenValue", null, 1, 1, SchedulingPolicyChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //designdecisionPackageImpl
