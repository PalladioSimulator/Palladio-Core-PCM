/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter;
import de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence;
import de.uka.ipd.sdq.sensitivity.DoubleOffsetType;
import de.uka.ipd.sdq.sensitivity.DoubleParameterFunction;
import de.uka.ipd.sdq.sensitivity.DoubleParameterRange;
import de.uka.ipd.sdq.sensitivity.DoubleParameterSequence;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;
import de.uka.ipd.sdq.sensitivity.FailureDimension;
import de.uka.ipd.sdq.sensitivity.FailureDimensionResultSpecification;
import de.uka.ipd.sdq.sensitivity.FailureTypeResultSpecification;
import de.uka.ipd.sdq.sensitivity.HardwareMTTFParameter;
import de.uka.ipd.sdq.sensitivity.HardwareMTTRParameter;
import de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.NetworkReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.ProbabilisticBranchParameter;
import de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter;
import de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityConfiguration;
import de.uka.ipd.sdq.sensitivity.SensitivityFactory;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.SensitivityParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation;
import de.uka.ipd.sdq.sensitivity.SensitivityResultSpecification;
import de.uka.ipd.sdq.sensitivity.SingleSensitivityParameter;
import de.uka.ipd.sdq.sensitivity.SoftwareFailureTypesParameter;
import de.uka.ipd.sdq.sensitivity.SoftwareReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.StringParameterSequence;
import de.uka.ipd.sdq.sensitivity.UsageBranchParameter;
import de.uka.ipd.sdq.sensitivity.VariableUsageParameter;
import de.uka.ipd.sdq.sensitivity.VariableUsageType;
import de.uka.ipd.sdq.sensitivity.util.SensitivityValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SensitivityPackageImpl extends EPackageImpl implements SensitivityPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensitivityConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensitivityParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass combinedSensitivityParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensitivityResultSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleSensitivityParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensitivityParameterVariationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentReliabilityParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleParameterVariationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringParameterSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleParameterRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleParameterSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleParameterFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalActionReliabilityParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass probabilisticBranchParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hardwareMTTFParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hardwareMTTRParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceMTTFParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceMTTRParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass networkReliabilityParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationLinkReliabilityParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass softwareReliabilityParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableUsageParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usageBranchParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleOffsetSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass softwareFailureTypesParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failureTypeResultSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failureDimensionResultSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableUsageTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum doubleOffsetTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum failureDimensionEEnum = null;

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
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SensitivityPackageImpl() {
		super(eNS_URI, SensitivityFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SensitivityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SensitivityPackage init() {
		if (isInited) return (SensitivityPackage)EPackage.Registry.INSTANCE.getEPackage(SensitivityPackage.eNS_URI);

		// Obtain or create and register package
		SensitivityPackageImpl theSensitivityPackage = (SensitivityPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SensitivityPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SensitivityPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PcmPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSensitivityPackage.createPackageContents();

		// Initialize created meta-data
		theSensitivityPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theSensitivityPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return SensitivityValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theSensitivityPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SensitivityPackage.eNS_URI, theSensitivityPackage);
		return theSensitivityPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensitivityConfiguration() {
		return sensitivityConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSensitivityConfiguration_SensitivityParameters__SensitivityConfiguration() {
		return (EReference)sensitivityConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSensitivityConfiguration_SensitivityResultSpecifications__SensitivityConfiguration() {
		return (EReference)sensitivityConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensitivityParameter() {
		return sensitivityParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSensitivityParameter_ParentParameter__SensitivityParameter() {
		return (EReference)sensitivityParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSensitivityParameter_SensitivityConfiguration__SensitivityParameter() {
		return (EReference)sensitivityParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCombinedSensitivityParameter() {
		return combinedSensitivityParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombinedSensitivityParameter_IsCombinatory() {
		return (EAttribute)combinedSensitivityParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCombinedSensitivityParameter_ChildParameters__CombinedSensitivityParameter() {
		return (EReference)combinedSensitivityParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensitivityResultSpecification() {
		return sensitivityResultSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleSensitivityParameter() {
		return singleSensitivityParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleSensitivityParameter_SensitivityParameterVariation__SingleSensitivityParameter() {
		return (EReference)singleSensitivityParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensitivityParameterVariation() {
		return sensitivityParameterVariationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSensitivityParameterVariation_SingleSensitivityParameter__SensitivityParameterVariation() {
		return (EReference)sensitivityParameterVariationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentReliabilityParameter() {
		return componentReliabilityParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentReliabilityParameter_BasicComponent__ComponentReliabilityParameter() {
		return (EReference)componentReliabilityParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleParameterVariation() {
		return doubleParameterVariationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringParameterSequence() {
		return stringParameterSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringParameterSequence_StringValues() {
		return (EAttribute)stringParameterSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleParameterRange() {
		return doubleParameterRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleParameterRange_ConsiderStepSize() {
		return (EAttribute)doubleParameterRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleParameterRange_FirstValue() {
		return (EAttribute)doubleParameterRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleParameterRange_LastValue() {
		return (EAttribute)doubleParameterRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleParameterRange_StepSize() {
		return (EAttribute)doubleParameterRangeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleParameterRange_StepCount() {
		return (EAttribute)doubleParameterRangeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleParameterSequence() {
		return doubleParameterSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleParameterSequence_DoubleValues() {
		return (EAttribute)doubleParameterSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleParameterFunction() {
		return doubleParameterFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalActionReliabilityParameter() {
		return internalActionReliabilityParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalActionReliabilityParameter_SoftwareInducedFailureType__InternalActionReliabilityParameter() {
		return (EReference)internalActionReliabilityParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalActionReliabilityParameter_InternalAction__InternalActionReliabilityParameter() {
		return (EReference)internalActionReliabilityParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProbabilisticBranchParameter() {
		return probabilisticBranchParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProbabilisticBranchParameter_ProbabilisticBranchTransition__ProbabilisticBranchParameter() {
		return (EReference)probabilisticBranchParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHardwareMTTFParameter() {
		return hardwareMTTFParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHardwareMTTRParameter() {
		return hardwareMTTRParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceMTTFParameter() {
		return resourceMTTFParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceMTTFParameter_ProcessingResourceType__ResourceMTTFParameter() {
		return (EReference)resourceMTTFParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceMTTFParameter_ResourceContainer__ResourceMTTFParameter() {
		return (EReference)resourceMTTFParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceMTTRParameter() {
		return resourceMTTRParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceMTTRParameter_ResourceContainer__ResourceMTTRParameter() {
		return (EReference)resourceMTTRParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceMTTRParameter_ProcessingResourceType__ResourceMTTRParameter() {
		return (EReference)resourceMTTRParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNetworkReliabilityParameter() {
		return networkReliabilityParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationLinkReliabilityParameter() {
		return communicationLinkReliabilityParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunicationLinkReliabilityParameter_CommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter() {
		return (EReference)communicationLinkReliabilityParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoftwareReliabilityParameter() {
		return softwareReliabilityParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableUsageParameter() {
		return variableUsageParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableUsageParameter_VariableName() {
		return (EAttribute)variableUsageParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableUsageParameter_EntryLevelSystemCall__VariableUsageParameter() {
		return (EReference)variableUsageParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableUsageParameter_VariableCharacterisationType__VariableUsageParameter() {
		return (EAttribute)variableUsageParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableUsageParameter_VariableUsageType__VariableUsageParameter() {
		return (EAttribute)variableUsageParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableUsageParameter_BasicComponent__VariableUsageParameter() {
		return (EReference)variableUsageParameterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUsageBranchParameter() {
		return usageBranchParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUsageBranchParameter_Branch__UsageBranchParameter() {
		return (EReference)usageBranchParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUsageBranchParameter_ScenarioBehaviour__UsageBranchParameter() {
		return (EReference)usageBranchParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleOffsetSequence() {
		return doubleOffsetSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleOffsetSequence_OffsetValues() {
		return (EAttribute)doubleOffsetSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleOffsetSequence_DoubleOffsetType__DoubleOffsetSequence() {
		return (EAttribute)doubleOffsetSequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoftwareFailureTypesParameter() {
		return softwareFailureTypesParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSoftwareFailureTypesParameter_SoftwareInducedFailureTypes__SoftwareFailureTypeReliabilityParameter() {
		return (EReference)softwareFailureTypesParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailureTypeResultSpecification() {
		return failureTypeResultSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailureTypeResultSpecification_FailureTypes__FailureTypeResultSpecification() {
		return (EReference)failureTypeResultSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailureDimensionResultSpecification() {
		return failureDimensionResultSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureDimensionResultSpecification_FailureDimension__FailureDimensionResultSpecification() {
		return (EAttribute)failureDimensionResultSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariableUsageType() {
		return variableUsageTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDoubleOffsetType() {
		return doubleOffsetTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFailureDimension() {
		return failureDimensionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensitivityFactory getSensitivityFactory() {
		return (SensitivityFactory)getEFactoryInstance();
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
		sensitivityConfigurationEClass = createEClass(SENSITIVITY_CONFIGURATION);
		createEReference(sensitivityConfigurationEClass, SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION);
		createEReference(sensitivityConfigurationEClass, SENSITIVITY_CONFIGURATION__SENSITIVITY_RESULT_SPECIFICATIONS_SENSITIVITY_CONFIGURATION);

		sensitivityParameterEClass = createEClass(SENSITIVITY_PARAMETER);
		createEReference(sensitivityParameterEClass, SENSITIVITY_PARAMETER__PARENT_PARAMETER_SENSITIVITY_PARAMETER);
		createEReference(sensitivityParameterEClass, SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER);

		combinedSensitivityParameterEClass = createEClass(COMBINED_SENSITIVITY_PARAMETER);
		createEAttribute(combinedSensitivityParameterEClass, COMBINED_SENSITIVITY_PARAMETER__IS_COMBINATORY);
		createEReference(combinedSensitivityParameterEClass, COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER);

		sensitivityResultSpecificationEClass = createEClass(SENSITIVITY_RESULT_SPECIFICATION);

		singleSensitivityParameterEClass = createEClass(SINGLE_SENSITIVITY_PARAMETER);
		createEReference(singleSensitivityParameterEClass, SINGLE_SENSITIVITY_PARAMETER__SENSITIVITY_PARAMETER_VARIATION_SINGLE_SENSITIVITY_PARAMETER);

		sensitivityParameterVariationEClass = createEClass(SENSITIVITY_PARAMETER_VARIATION);
		createEReference(sensitivityParameterVariationEClass, SENSITIVITY_PARAMETER_VARIATION__SINGLE_SENSITIVITY_PARAMETER_SENSITIVITY_PARAMETER_VARIATION);

		componentReliabilityParameterEClass = createEClass(COMPONENT_RELIABILITY_PARAMETER);
		createEReference(componentReliabilityParameterEClass, COMPONENT_RELIABILITY_PARAMETER__BASIC_COMPONENT_COMPONENT_RELIABILITY_PARAMETER);

		doubleParameterVariationEClass = createEClass(DOUBLE_PARAMETER_VARIATION);

		stringParameterSequenceEClass = createEClass(STRING_PARAMETER_SEQUENCE);
		createEAttribute(stringParameterSequenceEClass, STRING_PARAMETER_SEQUENCE__STRING_VALUES);

		doubleParameterRangeEClass = createEClass(DOUBLE_PARAMETER_RANGE);
		createEAttribute(doubleParameterRangeEClass, DOUBLE_PARAMETER_RANGE__CONSIDER_STEP_SIZE);
		createEAttribute(doubleParameterRangeEClass, DOUBLE_PARAMETER_RANGE__FIRST_VALUE);
		createEAttribute(doubleParameterRangeEClass, DOUBLE_PARAMETER_RANGE__LAST_VALUE);
		createEAttribute(doubleParameterRangeEClass, DOUBLE_PARAMETER_RANGE__STEP_SIZE);
		createEAttribute(doubleParameterRangeEClass, DOUBLE_PARAMETER_RANGE__STEP_COUNT);

		doubleParameterSequenceEClass = createEClass(DOUBLE_PARAMETER_SEQUENCE);
		createEAttribute(doubleParameterSequenceEClass, DOUBLE_PARAMETER_SEQUENCE__DOUBLE_VALUES);

		doubleParameterFunctionEClass = createEClass(DOUBLE_PARAMETER_FUNCTION);

		internalActionReliabilityParameterEClass = createEClass(INTERNAL_ACTION_RELIABILITY_PARAMETER);
		createEReference(internalActionReliabilityParameterEClass, INTERNAL_ACTION_RELIABILITY_PARAMETER__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_ACTION_RELIABILITY_PARAMETER);
		createEReference(internalActionReliabilityParameterEClass, INTERNAL_ACTION_RELIABILITY_PARAMETER__INTERNAL_ACTION_INTERNAL_ACTION_RELIABILITY_PARAMETER);

		probabilisticBranchParameterEClass = createEClass(PROBABILISTIC_BRANCH_PARAMETER);
		createEReference(probabilisticBranchParameterEClass, PROBABILISTIC_BRANCH_PARAMETER__PROBABILISTIC_BRANCH_TRANSITION_PROBABILISTIC_BRANCH_PARAMETER);

		hardwareMTTFParameterEClass = createEClass(HARDWARE_MTTF_PARAMETER);

		hardwareMTTRParameterEClass = createEClass(HARDWARE_MTTR_PARAMETER);

		resourceMTTFParameterEClass = createEClass(RESOURCE_MTTF_PARAMETER);
		createEReference(resourceMTTFParameterEClass, RESOURCE_MTTF_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTF_PARAMETER);
		createEReference(resourceMTTFParameterEClass, RESOURCE_MTTF_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTF_PARAMETER);

		resourceMTTRParameterEClass = createEClass(RESOURCE_MTTR_PARAMETER);
		createEReference(resourceMTTRParameterEClass, RESOURCE_MTTR_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTR_PARAMETER);
		createEReference(resourceMTTRParameterEClass, RESOURCE_MTTR_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTR_PARAMETER);

		networkReliabilityParameterEClass = createEClass(NETWORK_RELIABILITY_PARAMETER);

		communicationLinkReliabilityParameterEClass = createEClass(COMMUNICATION_LINK_RELIABILITY_PARAMETER);
		createEReference(communicationLinkReliabilityParameterEClass, COMMUNICATION_LINK_RELIABILITY_PARAMETER__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_COMMUNICATION_LINK_RELIABILITY_PARAMETER);

		softwareReliabilityParameterEClass = createEClass(SOFTWARE_RELIABILITY_PARAMETER);

		variableUsageParameterEClass = createEClass(VARIABLE_USAGE_PARAMETER);
		createEAttribute(variableUsageParameterEClass, VARIABLE_USAGE_PARAMETER__VARIABLE_NAME);
		createEReference(variableUsageParameterEClass, VARIABLE_USAGE_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE_PARAMETER);
		createEAttribute(variableUsageParameterEClass, VARIABLE_USAGE_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER);
		createEAttribute(variableUsageParameterEClass, VARIABLE_USAGE_PARAMETER__VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER);
		createEReference(variableUsageParameterEClass, VARIABLE_USAGE_PARAMETER__BASIC_COMPONENT_VARIABLE_USAGE_PARAMETER);

		usageBranchParameterEClass = createEClass(USAGE_BRANCH_PARAMETER);
		createEReference(usageBranchParameterEClass, USAGE_BRANCH_PARAMETER__BRANCH_USAGE_BRANCH_PARAMETER);
		createEReference(usageBranchParameterEClass, USAGE_BRANCH_PARAMETER__SCENARIO_BEHAVIOUR_USAGE_BRANCH_PARAMETER);

		doubleOffsetSequenceEClass = createEClass(DOUBLE_OFFSET_SEQUENCE);
		createEAttribute(doubleOffsetSequenceEClass, DOUBLE_OFFSET_SEQUENCE__OFFSET_VALUES);
		createEAttribute(doubleOffsetSequenceEClass, DOUBLE_OFFSET_SEQUENCE__DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE);

		softwareFailureTypesParameterEClass = createEClass(SOFTWARE_FAILURE_TYPES_PARAMETER);
		createEReference(softwareFailureTypesParameterEClass, SOFTWARE_FAILURE_TYPES_PARAMETER__SOFTWARE_INDUCED_FAILURE_TYPES_SOFTWARE_FAILURE_TYPE_RELIABILITY_PARAMETER);

		failureTypeResultSpecificationEClass = createEClass(FAILURE_TYPE_RESULT_SPECIFICATION);
		createEReference(failureTypeResultSpecificationEClass, FAILURE_TYPE_RESULT_SPECIFICATION__FAILURE_TYPES_FAILURE_TYPE_RESULT_SPECIFICATION);

		failureDimensionResultSpecificationEClass = createEClass(FAILURE_DIMENSION_RESULT_SPECIFICATION);
		createEAttribute(failureDimensionResultSpecificationEClass, FAILURE_DIMENSION_RESULT_SPECIFICATION__FAILURE_DIMENSION_FAILURE_DIMENSION_RESULT_SPECIFICATION);

		// Create enums
		variableUsageTypeEEnum = createEEnum(VARIABLE_USAGE_TYPE);
		doubleOffsetTypeEEnum = createEEnum(DOUBLE_OFFSET_TYPE);
		failureDimensionEEnum = createEEnum(FAILURE_DIMENSION);
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
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		ReliabilityPackage theReliabilityPackage = (ReliabilityPackage)EPackage.Registry.INSTANCE.getEPackage(ReliabilityPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		ResourcetypePackage theResourcetypePackage = (ResourcetypePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI);
		ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI);
		UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage)EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI);
		ParameterPackage theParameterPackage = (ParameterPackage)EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sensitivityConfigurationEClass.getESuperTypes().add(theEntityPackage.getEntity());
		sensitivityParameterEClass.getESuperTypes().add(theEntityPackage.getEntity());
		combinedSensitivityParameterEClass.getESuperTypes().add(this.getSensitivityParameter());
		sensitivityResultSpecificationEClass.getESuperTypes().add(theEntityPackage.getEntity());
		singleSensitivityParameterEClass.getESuperTypes().add(this.getSensitivityParameter());
		componentReliabilityParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		doubleParameterVariationEClass.getESuperTypes().add(this.getSensitivityParameterVariation());
		stringParameterSequenceEClass.getESuperTypes().add(this.getSensitivityParameterVariation());
		doubleParameterRangeEClass.getESuperTypes().add(this.getDoubleParameterVariation());
		doubleParameterSequenceEClass.getESuperTypes().add(this.getDoubleParameterVariation());
		doubleParameterFunctionEClass.getESuperTypes().add(this.getDoubleParameterVariation());
		internalActionReliabilityParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		probabilisticBranchParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		hardwareMTTFParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		hardwareMTTRParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		resourceMTTFParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		resourceMTTRParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		networkReliabilityParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		communicationLinkReliabilityParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		softwareReliabilityParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		variableUsageParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		usageBranchParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		doubleOffsetSequenceEClass.getESuperTypes().add(this.getDoubleParameterVariation());
		softwareFailureTypesParameterEClass.getESuperTypes().add(this.getSingleSensitivityParameter());
		failureTypeResultSpecificationEClass.getESuperTypes().add(this.getSensitivityResultSpecification());
		failureDimensionResultSpecificationEClass.getESuperTypes().add(this.getSensitivityResultSpecification());

		// Initialize classes and features; add operations and parameters
		initEClass(sensitivityConfigurationEClass, SensitivityConfiguration.class, "SensitivityConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSensitivityConfiguration_SensitivityParameters__SensitivityConfiguration(), this.getSensitivityParameter(), this.getSensitivityParameter_SensitivityConfiguration__SensitivityParameter(), "sensitivityParameters__SensitivityConfiguration", null, 1, 1, SensitivityConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSensitivityConfiguration_SensitivityResultSpecifications__SensitivityConfiguration(), this.getSensitivityResultSpecification(), null, "sensitivityResultSpecifications__SensitivityConfiguration", null, 0, -1, SensitivityConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensitivityParameterEClass, SensitivityParameter.class, "SensitivityParameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSensitivityParameter_ParentParameter__SensitivityParameter(), this.getCombinedSensitivityParameter(), this.getCombinedSensitivityParameter_ChildParameters__CombinedSensitivityParameter(), "parentParameter__SensitivityParameter", null, 0, 1, SensitivityParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSensitivityParameter_SensitivityConfiguration__SensitivityParameter(), this.getSensitivityConfiguration(), this.getSensitivityConfiguration_SensitivityParameters__SensitivityConfiguration(), "sensitivityConfiguration__SensitivityParameter", null, 0, 1, SensitivityParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(combinedSensitivityParameterEClass, CombinedSensitivityParameter.class, "CombinedSensitivityParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCombinedSensitivityParameter_IsCombinatory(), ecorePackage.getEBoolean(), "isCombinatory", null, 1, 1, CombinedSensitivityParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCombinedSensitivityParameter_ChildParameters__CombinedSensitivityParameter(), this.getSensitivityParameter(), this.getSensitivityParameter_ParentParameter__SensitivityParameter(), "childParameters__CombinedSensitivityParameter", null, 1, -1, CombinedSensitivityParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensitivityResultSpecificationEClass, SensitivityResultSpecification.class, "SensitivityResultSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(singleSensitivityParameterEClass, SingleSensitivityParameter.class, "SingleSensitivityParameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingleSensitivityParameter_SensitivityParameterVariation__SingleSensitivityParameter(), this.getSensitivityParameterVariation(), this.getSensitivityParameterVariation_SingleSensitivityParameter__SensitivityParameterVariation(), "sensitivityParameterVariation__SingleSensitivityParameter", null, 1, 1, SingleSensitivityParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensitivityParameterVariationEClass, SensitivityParameterVariation.class, "SensitivityParameterVariation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSensitivityParameterVariation_SingleSensitivityParameter__SensitivityParameterVariation(), this.getSingleSensitivityParameter(), this.getSingleSensitivityParameter_SensitivityParameterVariation__SingleSensitivityParameter(), "singleSensitivityParameter__SensitivityParameterVariation", null, 1, 1, SensitivityParameterVariation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(componentReliabilityParameterEClass, ComponentReliabilityParameter.class, "ComponentReliabilityParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentReliabilityParameter_BasicComponent__ComponentReliabilityParameter(), theRepositoryPackage.getBasicComponent(), null, "basicComponent__ComponentReliabilityParameter", null, 1, 1, ComponentReliabilityParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(componentReliabilityParameterEClass, ecorePackage.getEBoolean(), "ComponentReliabilityParameterMustHaveDoubleVariation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(doubleParameterVariationEClass, DoubleParameterVariation.class, "DoubleParameterVariation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringParameterSequenceEClass, StringParameterSequence.class, "StringParameterSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringParameterSequence_StringValues(), ecorePackage.getEString(), "stringValues", null, 1, -1, StringParameterSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(doubleParameterRangeEClass, DoubleParameterRange.class, "DoubleParameterRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleParameterRange_ConsiderStepSize(), ecorePackage.getEBoolean(), "considerStepSize", null, 1, 1, DoubleParameterRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDoubleParameterRange_FirstValue(), ecorePackage.getEDouble(), "firstValue", null, 1, 1, DoubleParameterRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDoubleParameterRange_LastValue(), ecorePackage.getEDouble(), "lastValue", null, 1, 1, DoubleParameterRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDoubleParameterRange_StepSize(), ecorePackage.getEDouble(), "stepSize", null, 1, 1, DoubleParameterRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDoubleParameterRange_StepCount(), ecorePackage.getEInt(), "stepCount", null, 1, 1, DoubleParameterRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(doubleParameterSequenceEClass, DoubleParameterSequence.class, "DoubleParameterSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleParameterSequence_DoubleValues(), ecorePackage.getEDouble(), "doubleValues", null, 1, -1, DoubleParameterSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleParameterFunctionEClass, DoubleParameterFunction.class, "DoubleParameterFunction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(internalActionReliabilityParameterEClass, InternalActionReliabilityParameter.class, "InternalActionReliabilityParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalActionReliabilityParameter_SoftwareInducedFailureType__InternalActionReliabilityParameter(), theReliabilityPackage.getSoftwareInducedFailureType(), null, "softwareInducedFailureType__InternalActionReliabilityParameter", null, 1, 1, InternalActionReliabilityParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInternalActionReliabilityParameter_InternalAction__InternalActionReliabilityParameter(), theSeffPackage.getInternalAction(), null, "internalAction__InternalActionReliabilityParameter", null, 1, 1, InternalActionReliabilityParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(internalActionReliabilityParameterEClass, ecorePackage.getEBoolean(), "InternalActionReliabilityParameterMustHaveDoubleVariation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(probabilisticBranchParameterEClass, ProbabilisticBranchParameter.class, "ProbabilisticBranchParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProbabilisticBranchParameter_ProbabilisticBranchTransition__ProbabilisticBranchParameter(), theSeffPackage.getProbabilisticBranchTransition(), null, "probabilisticBranchTransition__ProbabilisticBranchParameter", null, 1, 1, ProbabilisticBranchParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(probabilisticBranchParameterEClass, ecorePackage.getEBoolean(), "ProbabilisticBranchParameterMustHaveDoubleVariation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(hardwareMTTFParameterEClass, HardwareMTTFParameter.class, "HardwareMTTFParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(hardwareMTTFParameterEClass, ecorePackage.getEBoolean(), "HardwareMTTFParameterMustHaveDoubleVariation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(hardwareMTTRParameterEClass, HardwareMTTRParameter.class, "HardwareMTTRParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(hardwareMTTRParameterEClass, ecorePackage.getEBoolean(), "HardwareMTTRParameterMustHaveDoubleVariation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(resourceMTTFParameterEClass, ResourceMTTFParameter.class, "ResourceMTTFParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceMTTFParameter_ProcessingResourceType__ResourceMTTFParameter(), theResourcetypePackage.getProcessingResourceType(), null, "processingResourceType__ResourceMTTFParameter", null, 1, 1, ResourceMTTFParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceMTTFParameter_ResourceContainer__ResourceMTTFParameter(), theResourceenvironmentPackage.getResourceContainer(), null, "resourceContainer__ResourceMTTFParameter", null, 1, 1, ResourceMTTFParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(resourceMTTFParameterEClass, ecorePackage.getEBoolean(), "ResourceMTTFParameterMustHaveDoubleVariation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(resourceMTTRParameterEClass, ResourceMTTRParameter.class, "ResourceMTTRParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceMTTRParameter_ResourceContainer__ResourceMTTRParameter(), theResourceenvironmentPackage.getResourceContainer(), null, "resourceContainer__ResourceMTTRParameter", null, 1, 1, ResourceMTTRParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceMTTRParameter_ProcessingResourceType__ResourceMTTRParameter(), theResourcetypePackage.getProcessingResourceType(), null, "processingResourceType__ResourceMTTRParameter", null, 1, 1, ResourceMTTRParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(resourceMTTRParameterEClass, ecorePackage.getEBoolean(), "ResourceMTTRParameterMustHaveDoubleVariation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(networkReliabilityParameterEClass, NetworkReliabilityParameter.class, "NetworkReliabilityParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(networkReliabilityParameterEClass, ecorePackage.getEBoolean(), "NetworkReliabilityParameterMustHaveDoubleVariation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(communicationLinkReliabilityParameterEClass, CommunicationLinkReliabilityParameter.class, "CommunicationLinkReliabilityParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommunicationLinkReliabilityParameter_CommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter(), theResourceenvironmentPackage.getCommunicationLinkResourceSpecification(), null, "communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter", null, 1, 1, CommunicationLinkReliabilityParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(communicationLinkReliabilityParameterEClass, ecorePackage.getEBoolean(), "CommunicationLinkParameterMustHaveDoubleVariation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(softwareReliabilityParameterEClass, SoftwareReliabilityParameter.class, "SoftwareReliabilityParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(softwareReliabilityParameterEClass, ecorePackage.getEBoolean(), "SoftwareReliabilityParameterMustHaveDoubleVariation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(variableUsageParameterEClass, VariableUsageParameter.class, "VariableUsageParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableUsageParameter_VariableName(), ecorePackage.getEString(), "VariableName", null, 1, 1, VariableUsageParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableUsageParameter_EntryLevelSystemCall__VariableUsageParameter(), theUsagemodelPackage.getEntryLevelSystemCall(), null, "entryLevelSystemCall__VariableUsageParameter", null, 0, 1, VariableUsageParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariableUsageParameter_VariableCharacterisationType__VariableUsageParameter(), theParameterPackage.getVariableCharacterisationType(), "variableCharacterisationType__VariableUsageParameter", null, 1, 1, VariableUsageParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariableUsageParameter_VariableUsageType__VariableUsageParameter(), this.getVariableUsageType(), "variableUsageType__VariableUsageParameter", null, 1, 1, VariableUsageParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableUsageParameter_BasicComponent__VariableUsageParameter(), theRepositoryPackage.getBasicComponent(), null, "basicComponent__VariableUsageParameter", null, 0, 1, VariableUsageParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(variableUsageParameterEClass, ecorePackage.getEBoolean(), "SystemCallParameterMustHaveStringSequence", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(usageBranchParameterEClass, UsageBranchParameter.class, "UsageBranchParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUsageBranchParameter_Branch__UsageBranchParameter(), theUsagemodelPackage.getBranch(), null, "branch__UsageBranchParameter", null, 1, 1, UsageBranchParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getUsageBranchParameter_ScenarioBehaviour__UsageBranchParameter(), theUsagemodelPackage.getScenarioBehaviour(), null, "scenarioBehaviour__UsageBranchParameter", null, 1, 1, UsageBranchParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(usageBranchParameterEClass, ecorePackage.getEBoolean(), "UsageBranchParameterMustHaveDoubleVariation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(doubleOffsetSequenceEClass, DoubleOffsetSequence.class, "DoubleOffsetSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleOffsetSequence_OffsetValues(), ecorePackage.getEDouble(), "offsetValues", null, 1, -1, DoubleOffsetSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDoubleOffsetSequence_DoubleOffsetType__DoubleOffsetSequence(), this.getDoubleOffsetType(), "doubleOffsetType__DoubleOffsetSequence", null, 1, 1, DoubleOffsetSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(softwareFailureTypesParameterEClass, SoftwareFailureTypesParameter.class, "SoftwareFailureTypesParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSoftwareFailureTypesParameter_SoftwareInducedFailureTypes__SoftwareFailureTypeReliabilityParameter(), theReliabilityPackage.getSoftwareInducedFailureType(), null, "softwareInducedFailureTypes__SoftwareFailureTypeReliabilityParameter", null, 1, -1, SoftwareFailureTypesParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(softwareFailureTypesParameterEClass, ecorePackage.getEBoolean(), "SoftwareFailureTypeReliabilityParameterMustHaveDoubleVariation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(failureTypeResultSpecificationEClass, FailureTypeResultSpecification.class, "FailureTypeResultSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFailureTypeResultSpecification_FailureTypes__FailureTypeResultSpecification(), theReliabilityPackage.getFailureType(), null, "failureTypes__FailureTypeResultSpecification", null, 1, -1, FailureTypeResultSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(failureDimensionResultSpecificationEClass, FailureDimensionResultSpecification.class, "FailureDimensionResultSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFailureDimensionResultSpecification_FailureDimension__FailureDimensionResultSpecification(), this.getFailureDimension(), "failureDimension__FailureDimensionResultSpecification", null, 1, 1, FailureDimensionResultSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(variableUsageTypeEEnum, VariableUsageType.class, "VariableUsageType");
		addEEnumLiteral(variableUsageTypeEEnum, VariableUsageType.SYSTEM_CALL_INPUT);
		addEEnumLiteral(variableUsageTypeEEnum, VariableUsageType.COMPONENT_CONFIGURATION);

		initEEnum(doubleOffsetTypeEEnum, DoubleOffsetType.class, "DoubleOffsetType");
		addEEnumLiteral(doubleOffsetTypeEEnum, DoubleOffsetType.ADD);
		addEEnumLiteral(doubleOffsetTypeEEnum, DoubleOffsetType.SUBTRACT);
		addEEnumLiteral(doubleOffsetTypeEEnum, DoubleOffsetType.MULTIPLY);
		addEEnumLiteral(doubleOffsetTypeEEnum, DoubleOffsetType.DIVIDE);

		initEEnum(failureDimensionEEnum, FailureDimension.class, "FailureDimension");
		addEEnumLiteral(failureDimensionEEnum, FailureDimension.SOFTWARE);
		addEEnumLiteral(failureDimensionEEnum, FailureDimension.HARDWARE);
		addEEnumLiteral(failureDimensionEEnum, FailureDimension.NETWORK);

		// Create resource
		createResource(eNS_URI);
	}

} //SensitivityPackageImpl
