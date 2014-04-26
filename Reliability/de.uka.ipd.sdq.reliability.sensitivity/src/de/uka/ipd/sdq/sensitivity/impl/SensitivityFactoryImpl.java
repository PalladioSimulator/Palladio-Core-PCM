/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter;
import de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence;
import de.uka.ipd.sdq.sensitivity.DoubleOffsetType;
import de.uka.ipd.sdq.sensitivity.DoubleParameterRange;
import de.uka.ipd.sdq.sensitivity.DoubleParameterSequence;
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
import de.uka.ipd.sdq.sensitivity.SoftwareFailureTypesParameter;
import de.uka.ipd.sdq.sensitivity.SoftwareReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.StringParameterSequence;
import de.uka.ipd.sdq.sensitivity.UsageBranchParameter;
import de.uka.ipd.sdq.sensitivity.VariableUsageParameter;
import de.uka.ipd.sdq.sensitivity.VariableUsageType;

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
            SensitivityFactory theSensitivityFactory = (SensitivityFactory)EPackage.Registry.INSTANCE.getEFactory(SensitivityPackage.eNS_URI);
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
            case SensitivityPackage.VARIABLE_USAGE_PARAMETER: return createVariableUsageParameter();
            case SensitivityPackage.USAGE_BRANCH_PARAMETER: return createUsageBranchParameter();
            case SensitivityPackage.DOUBLE_OFFSET_SEQUENCE: return createDoubleOffsetSequence();
            case SensitivityPackage.SOFTWARE_FAILURE_TYPES_PARAMETER: return createSoftwareFailureTypesParameter();
            case SensitivityPackage.FAILURE_TYPE_RESULT_SPECIFICATION: return createFailureTypeResultSpecification();
            case SensitivityPackage.FAILURE_DIMENSION_RESULT_SPECIFICATION: return createFailureDimensionResultSpecification();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case SensitivityPackage.VARIABLE_USAGE_TYPE:
                return createVariableUsageTypeFromString(eDataType, initialValue);
            case SensitivityPackage.DOUBLE_OFFSET_TYPE:
                return createDoubleOffsetTypeFromString(eDataType, initialValue);
            case SensitivityPackage.FAILURE_DIMENSION:
                return createFailureDimensionFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case SensitivityPackage.VARIABLE_USAGE_TYPE:
                return convertVariableUsageTypeToString(eDataType, instanceValue);
            case SensitivityPackage.DOUBLE_OFFSET_TYPE:
                return convertDoubleOffsetTypeToString(eDataType, instanceValue);
            case SensitivityPackage.FAILURE_DIMENSION:
                return convertFailureDimensionToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
	public VariableUsageParameter createVariableUsageParameter() {
        VariableUsageParameterImpl variableUsageParameter = new VariableUsageParameterImpl();
        return variableUsageParameter;
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
	public DoubleOffsetSequence createDoubleOffsetSequence() {
        DoubleOffsetSequenceImpl doubleOffsetSequence = new DoubleOffsetSequenceImpl();
        return doubleOffsetSequence;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SoftwareFailureTypesParameter createSoftwareFailureTypesParameter() {
        SoftwareFailureTypesParameterImpl softwareFailureTypesParameter = new SoftwareFailureTypesParameterImpl();
        return softwareFailureTypesParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FailureTypeResultSpecification createFailureTypeResultSpecification() {
        FailureTypeResultSpecificationImpl failureTypeResultSpecification = new FailureTypeResultSpecificationImpl();
        return failureTypeResultSpecification;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FailureDimensionResultSpecification createFailureDimensionResultSpecification() {
        FailureDimensionResultSpecificationImpl failureDimensionResultSpecification = new FailureDimensionResultSpecificationImpl();
        return failureDimensionResultSpecification;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariableUsageType createVariableUsageTypeFromString(EDataType eDataType, String initialValue) {
        VariableUsageType result = VariableUsageType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertVariableUsageTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DoubleOffsetType createDoubleOffsetTypeFromString(EDataType eDataType, String initialValue) {
        DoubleOffsetType result = DoubleOffsetType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertDoubleOffsetTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FailureDimension createFailureDimensionFromString(EDataType eDataType, String initialValue) {
        FailureDimension result = FailureDimension.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertFailureDimensionToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
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
