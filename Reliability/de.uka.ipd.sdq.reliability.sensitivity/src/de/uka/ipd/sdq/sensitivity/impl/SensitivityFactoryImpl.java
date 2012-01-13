/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

import de.uka.ipd.sdq.sensitivity.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SensitivityFactoryImpl extends EFactoryImpl implements SensitivityFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SensitivityFactory init() {
		try {
			SensitivityFactory theSensitivityFactory = (SensitivityFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/Sensitivity/1.0"); 
			if (theSensitivityFactory != null) {
				return theSensitivityFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SensitivityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensitivityFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SensitivityPackage.SENSITIVITY_CONFIGURATION: return createSensitivityConfiguration();
			case SensitivityPackage.COMBINED_SENSITIVITY_PARAMETER: return createCombinedSensitivityParameter();
			case SensitivityPackage.COMPONENT_RELIABILITY_PARAMETER: return createComponentReliabilityParameter();
			case SensitivityPackage.STRING_PARAMETER_SEQUENCE: return createStringParameterSequence();
			case SensitivityPackage.DOUBLE_PARAMETER_RANGE: return createDoubleParameterRange();
			case SensitivityPackage.DOUBLE_PARAMETER_SEQUENCE: return createDoubleParameterSequence();
			case SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER: return createInternalActionReliabilityParameter();
			case SensitivityPackage.PROBABILISTIC_BRANCH_PARAMETER: return createProbabilisticBranchParameter();
			case SensitivityPackage.HARDWARE_MTTF_PARAMETER: return createHardwareMTTFParameter();
			case SensitivityPackage.HARDWARE_MTTR_PARAMETER: return createHardwareMTTRParameter();
			case SensitivityPackage.RESOURCE_MTTF_PARAMETER: return createResourceMTTFParameter();
			case SensitivityPackage.RESOURCE_MTTR_PARAMETER: return createResourceMTTRParameter();
			case SensitivityPackage.NETWORK_RELIABILITY_PARAMETER: return createNetworkReliabilityParameter();
			case SensitivityPackage.COMMUNICATION_LINK_RELIABILITY_PARAMETER: return createCommunicationLinkReliabilityParameter();
			case SensitivityPackage.SOFTWARE_RELIABILITY_PARAMETER: return createSoftwareReliabilityParameter();
			case SensitivityPackage.SYSTEM_CALL_PARAMETER: return createSystemCallParameter();
			case SensitivityPackage.USAGE_BRANCH_PARAMETER: return createUsageBranchParameter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensitivityConfiguration createSensitivityConfiguration() {
		SensitivityConfigurationImpl sensitivityConfiguration = new SensitivityConfigurationImpl();
		return sensitivityConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombinedSensitivityParameter createCombinedSensitivityParameter() {
		CombinedSensitivityParameterImpl combinedSensitivityParameter = new CombinedSensitivityParameterImpl();
		return combinedSensitivityParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentReliabilityParameter createComponentReliabilityParameter() {
		ComponentReliabilityParameterImpl componentReliabilityParameter = new ComponentReliabilityParameterImpl();
		return componentReliabilityParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringParameterSequence createStringParameterSequence() {
		StringParameterSequenceImpl stringParameterSequence = new StringParameterSequenceImpl();
		return stringParameterSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleParameterRange createDoubleParameterRange() {
		DoubleParameterRangeImpl doubleParameterRange = new DoubleParameterRangeImpl();
		return doubleParameterRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleParameterSequence createDoubleParameterSequence() {
		DoubleParameterSequenceImpl doubleParameterSequence = new DoubleParameterSequenceImpl();
		return doubleParameterSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalActionReliabilityParameter createInternalActionReliabilityParameter() {
		InternalActionReliabilityParameterImpl internalActionReliabilityParameter = new InternalActionReliabilityParameterImpl();
		return internalActionReliabilityParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilisticBranchParameter createProbabilisticBranchParameter() {
		ProbabilisticBranchParameterImpl probabilisticBranchParameter = new ProbabilisticBranchParameterImpl();
		return probabilisticBranchParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HardwareMTTFParameter createHardwareMTTFParameter() {
		HardwareMTTFParameterImpl hardwareMTTFParameter = new HardwareMTTFParameterImpl();
		return hardwareMTTFParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HardwareMTTRParameter createHardwareMTTRParameter() {
		HardwareMTTRParameterImpl hardwareMTTRParameter = new HardwareMTTRParameterImpl();
		return hardwareMTTRParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceMTTFParameter createResourceMTTFParameter() {
		ResourceMTTFParameterImpl resourceMTTFParameter = new ResourceMTTFParameterImpl();
		return resourceMTTFParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceMTTRParameter createResourceMTTRParameter() {
		ResourceMTTRParameterImpl resourceMTTRParameter = new ResourceMTTRParameterImpl();
		return resourceMTTRParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetworkReliabilityParameter createNetworkReliabilityParameter() {
		NetworkReliabilityParameterImpl networkReliabilityParameter = new NetworkReliabilityParameterImpl();
		return networkReliabilityParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationLinkReliabilityParameter createCommunicationLinkReliabilityParameter() {
		CommunicationLinkReliabilityParameterImpl communicationLinkReliabilityParameter = new CommunicationLinkReliabilityParameterImpl();
		return communicationLinkReliabilityParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareReliabilityParameter createSoftwareReliabilityParameter() {
		SoftwareReliabilityParameterImpl softwareReliabilityParameter = new SoftwareReliabilityParameterImpl();
		return softwareReliabilityParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemCallParameter createSystemCallParameter() {
		SystemCallParameterImpl systemCallParameter = new SystemCallParameterImpl();
		return systemCallParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageBranchParameter createUsageBranchParameter() {
		UsageBranchParameterImpl usageBranchParameter = new UsageBranchParameterImpl();
		return usageBranchParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensitivityPackage getSensitivityPackage() {
		return (SensitivityPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SensitivityPackage getPackage() {
		return SensitivityPackage.eINSTANCE;
	}

} //SensitivityFactoryImpl
