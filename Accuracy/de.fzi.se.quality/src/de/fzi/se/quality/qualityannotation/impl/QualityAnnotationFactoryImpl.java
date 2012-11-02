/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class QualityAnnotationFactoryImpl extends EFactoryImpl implements QualityAnnotationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QualityAnnotationFactory init() {
		try {
			QualityAnnotationFactory theQualityAnnotationFactory = (QualityAnnotationFactory)EPackage.Registry.INSTANCE.getEFactory("http://fzi.de/PalladioComponentModel/Quality/QualityAnnotation/0.2"); 
			if (theQualityAnnotationFactory != null) {
				return theQualityAnnotationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QualityAnnotationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityAnnotationFactoryImpl() {
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
			case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION: return createParameterValueDeviation();
			case QualityAnnotationPackage.QUALITY_ANNOTATION: return createQualityAnnotation();
			case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION: return createRequiredElementDeviation();
			case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION: return createInternalStateInfluenceAnalysisAggregation();
			case QualityAnnotationPackage.RE_PRECISION: return createREPrecision();
			case QualityAnnotationPackage.PCM_PARAMETER_PARTITION: return createPCMParameterPartition();
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL: return createCharacterisedPCMParameterPartitionInterval();
			case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE: return createCharacterisedPCMParameterPartitionRange();
			case QualityAnnotationPackage.EXACTLY_AS_SPECIFIED_PRECISION: return createExactlyAsSpecifiedPrecision();
			case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION: return createLimitedDeviationPrecision();
			case QualityAnnotationPackage.NO_PRECISION: return createNoPrecision();
			case QualityAnnotationPackage.PCMRE_CATEGORY: return createPCMRECategory();
			case QualityAnnotationPackage.PCMRE_INTERFACE: return createPCMREInterface();
			case QualityAnnotationPackage.PCMRE_ROLE: return createPCMRERole();
			case QualityAnnotationPackage.PCMRE_SIGNATURE: return createPCMRESignature();
			case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION: return createPCMServiceSpecification();
			case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE: return createPCMREResourceInterface();
			case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE: return createPCMREResourceSignature();
			case QualityAnnotationPackage.PCMRE_RESOURCE: return createPCMREResource();
			case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE: return createPCMREResourceRole();
			case QualityAnnotationPackage.PCMRECI_BEHAVIOR: return createPCMRECIBehavior();
			case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_INTERFACE: return createPCMREInfrastructureInterface();
			case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_ROLE: return createPCMREInfrastructureRole();
			case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_SIGNATURE: return createPCMREInfrastructureSignature();
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
			case QualityAnnotationPackage.PCMRE_REQUEST_CATEGORY:
				return createPCMRERequestCategoryFromString(eDataType, initialValue);
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
			case QualityAnnotationPackage.PCMRE_REQUEST_CATEGORY:
				return convertPCMRERequestCategoryToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterValueDeviation createParameterValueDeviation() {
		ParameterValueDeviationImpl parameterValueDeviation = new ParameterValueDeviationImpl();
		return parameterValueDeviation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityAnnotation createQualityAnnotation() {
		QualityAnnotationImpl qualityAnnotation = new QualityAnnotationImpl();
		return qualityAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredElementDeviation createRequiredElementDeviation() {
		RequiredElementDeviationImpl requiredElementDeviation = new RequiredElementDeviationImpl();
		return requiredElementDeviation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalStateInfluenceAnalysisAggregation createInternalStateInfluenceAnalysisAggregation() {
		InternalStateInfluenceAnalysisAggregationImpl internalStateInfluenceAnalysisAggregation = new InternalStateInfluenceAnalysisAggregationImpl();
		return internalStateInfluenceAnalysisAggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public REPrecision createREPrecision() {
		REPrecisionImpl rePrecision = new REPrecisionImpl();
		return rePrecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMParameterPartition createPCMParameterPartition() {
		PCMParameterPartitionImpl pcmParameterPartition = new PCMParameterPartitionImpl();
		return pcmParameterPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterisedPCMParameterPartitionInterval createCharacterisedPCMParameterPartitionInterval() {
		CharacterisedPCMParameterPartitionIntervalImpl characterisedPCMParameterPartitionInterval = new CharacterisedPCMParameterPartitionIntervalImpl();
		return characterisedPCMParameterPartitionInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterisedPCMParameterPartitionRange createCharacterisedPCMParameterPartitionRange() {
		CharacterisedPCMParameterPartitionRangeImpl characterisedPCMParameterPartitionRange = new CharacterisedPCMParameterPartitionRangeImpl();
		return characterisedPCMParameterPartitionRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExactlyAsSpecifiedPrecision createExactlyAsSpecifiedPrecision() {
		ExactlyAsSpecifiedPrecisionImpl exactlyAsSpecifiedPrecision = new ExactlyAsSpecifiedPrecisionImpl();
		return exactlyAsSpecifiedPrecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LimitedDeviationPrecision createLimitedDeviationPrecision() {
		LimitedDeviationPrecisionImpl limitedDeviationPrecision = new LimitedDeviationPrecisionImpl();
		return limitedDeviationPrecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoPrecision createNoPrecision() {
		NoPrecisionImpl noPrecision = new NoPrecisionImpl();
		return noPrecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRECategory createPCMRECategory() {
		PCMRECategoryImpl pcmreCategory = new PCMRECategoryImpl();
		return pcmreCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMREInterface createPCMREInterface() {
		PCMREInterfaceImpl pcmreInterface = new PCMREInterfaceImpl();
		return pcmreInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRERole createPCMRERole() {
		PCMRERoleImpl pcmreRole = new PCMRERoleImpl();
		return pcmreRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRESignature createPCMRESignature() {
		PCMRESignatureImpl pcmreSignature = new PCMRESignatureImpl();
		return pcmreSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMServiceSpecification createPCMServiceSpecification() {
		PCMServiceSpecificationImpl pcmServiceSpecification = new PCMServiceSpecificationImpl();
		return pcmServiceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMREResourceInterface createPCMREResourceInterface() {
		PCMREResourceInterfaceImpl pcmreResourceInterface = new PCMREResourceInterfaceImpl();
		return pcmreResourceInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMREResourceSignature createPCMREResourceSignature() {
		PCMREResourceSignatureImpl pcmreResourceSignature = new PCMREResourceSignatureImpl();
		return pcmreResourceSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMREResource createPCMREResource() {
		PCMREResourceImpl pcmreResource = new PCMREResourceImpl();
		return pcmreResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMREResourceRole createPCMREResourceRole() {
		PCMREResourceRoleImpl pcmreResourceRole = new PCMREResourceRoleImpl();
		return pcmreResourceRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRECIBehavior createPCMRECIBehavior() {
		PCMRECIBehaviorImpl pcmreciBehavior = new PCMRECIBehaviorImpl();
		return pcmreciBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMREInfrastructureInterface createPCMREInfrastructureInterface() {
		PCMREInfrastructureInterfaceImpl pcmreInfrastructureInterface = new PCMREInfrastructureInterfaceImpl();
		return pcmreInfrastructureInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMREInfrastructureRole createPCMREInfrastructureRole() {
		PCMREInfrastructureRoleImpl pcmreInfrastructureRole = new PCMREInfrastructureRoleImpl();
		return pcmreInfrastructureRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMREInfrastructureSignature createPCMREInfrastructureSignature() {
		PCMREInfrastructureSignatureImpl pcmreInfrastructureSignature = new PCMREInfrastructureSignatureImpl();
		return pcmreInfrastructureSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRERequestCategory createPCMRERequestCategoryFromString(EDataType eDataType, String initialValue) {
		PCMRERequestCategory result = PCMRERequestCategory.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPCMRERequestCategoryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityAnnotationPackage getQualityAnnotationPackage() {
		return (QualityAnnotationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QualityAnnotationPackage getPackage() {
		return QualityAnnotationPackage.eINSTANCE;
	}

} //QualityAnnotationFactoryImpl
