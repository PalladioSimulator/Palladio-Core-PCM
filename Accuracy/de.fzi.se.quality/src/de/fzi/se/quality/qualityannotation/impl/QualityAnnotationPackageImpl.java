/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.QualityPackage;

import de.fzi.se.quality.impl.QualityPackageImpl;

import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.quality.parameters.impl.ParametersPackageImpl;

import de.fzi.se.quality.parameters.pcm.PCMPackage;

import de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl;

import de.fzi.se.quality.qualityannotation.CallParameterDeviation;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange;
import de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision;
import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision;
import de.fzi.se.quality.qualityannotation.NoPrecision;
import de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation;
import de.fzi.se.quality.qualityannotation.PCMParameterPartition;
import de.fzi.se.quality.qualityannotation.PCMRECategory;
import de.fzi.se.quality.qualityannotation.PCMREInterface;
import de.fzi.se.quality.qualityannotation.PCMRERequestCategory;
import de.fzi.se.quality.qualityannotation.PCMREResource;
import de.fzi.se.quality.qualityannotation.PCMREResourceInterface;
import de.fzi.se.quality.qualityannotation.PCMREResourceRole;
import de.fzi.se.quality.qualityannotation.PCMREResourceSignature;
import de.fzi.se.quality.qualityannotation.PCMRERole;
import de.fzi.se.quality.qualityannotation.PCMRESignature;
import de.fzi.se.quality.qualityannotation.PCMServiceSpecification;
import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationFactory;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.REPrecision;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.fzi.se.quality.qualityannotation.ServiceSpecification;

import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.PcmPackage;

import de.uka.ipd.sdq.pcm.core.CorePackage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import probfunction.ProbfunctionPackage;
import probfunction.impl.ProbfunctionPackageImpl;
import types.TypesPackage;
import types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QualityAnnotationPackageImpl extends EPackageImpl implements QualityAnnotationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callParameterDeviationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualityAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requiredElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberOfCallsDeviationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalStateInfluenceAnalysisAggregationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rePrecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass precisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmParameterPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterisedPCMParameterPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterisedPCMParameterPartitionIntervalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterisedPCMParameterPartitionRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exactlyAsSpecifiedPrecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass limitedDeviationPrecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noPrecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmreCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmreInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmreRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmreSignatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmServiceSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmreResourceInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmreResourceSignatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum pcmreRequestCategoryEEnum = null;

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
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QualityAnnotationPackageImpl() {
		super(eNS_URI, QualityAnnotationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QualityAnnotationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QualityAnnotationPackage init() {
		if (isInited) return (QualityAnnotationPackage)EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI);

		// Obtain or create and register package
		QualityAnnotationPackageImpl theQualityAnnotationPackage = (QualityAnnotationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QualityAnnotationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QualityAnnotationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PcmPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		QualityPackageImpl theQualityPackage = (QualityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QualityPackage.eNS_URI) instanceof QualityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QualityPackage.eNS_URI) : QualityPackage.eINSTANCE);
		ParametersPackageImpl theParametersPackage = (ParametersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI) instanceof ParametersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI) : ParametersPackage.eINSTANCE);
		PCMPackageImpl thePCMPackage = (PCMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI) instanceof PCMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI) : PCMPackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		ProbfunctionPackageImpl theProbfunctionPackage = (ProbfunctionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProbfunctionPackage.eNS_URI) instanceof ProbfunctionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProbfunctionPackage.eNS_URI) : ProbfunctionPackage.eINSTANCE);

		// Create package meta-data objects
		theQualityAnnotationPackage.createPackageContents();
		theQualityPackage.createPackageContents();
		theParametersPackage.createPackageContents();
		thePCMPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theProbfunctionPackage.createPackageContents();

		// Initialize created meta-data
		theQualityAnnotationPackage.initializePackageContents();
		theQualityPackage.initializePackageContents();
		theParametersPackage.initializePackageContents();
		thePCMPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theProbfunctionPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theQualityAnnotationPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return QualityAnnotationValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theQualityAnnotationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QualityAnnotationPackage.eNS_URI, theQualityAnnotationPackage);
		return theQualityAnnotationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallParameterDeviation() {
		return callParameterDeviationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallParameterDeviation_ParameterReference() {
		return (EReference)callParameterDeviationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallParameterDeviation_InternalStateInfluenceAnalysisAggregation() {
		return (EReference)callParameterDeviationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallParameterDeviation_Maximum() {
		return (EAttribute)callParameterDeviationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualityAnnotation() {
		return qualityAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualityAnnotation_IsValid() {
		return (EAttribute)qualityAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualityAnnotation_ForServiceSpecification() {
		return (EReference)qualityAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualityAnnotation_StipulatedREPrecisions() {
		return (EReference)qualityAnnotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualityAnnotation_InternalStateInfluenceAnalysisResult() {
		return (EReference)qualityAnnotationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualityAnnotation_ValidForParameterPartitions() {
		return (EReference)qualityAnnotationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceSpecification() {
		return serviceSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceSpecification_Checksum() {
		return (EAttribute)serviceSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceSpecification_QualityAnnotation() {
		return (EReference)serviceSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequiredElement() {
		return requiredElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredElement_NumberOfCallsDeviation() {
		return (EReference)requiredElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredElement_ChildREs() {
		return (EReference)requiredElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredElement_ParentRE() {
		return (EReference)requiredElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredElement_Precision() {
		return (EReference)requiredElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredElement_QualityAnnotation() {
		return (EReference)requiredElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberOfCallsDeviation() {
		return numberOfCallsDeviationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberOfCallsDeviation_InternalStateInfluenceAnalysisAggregation() {
		return (EReference)numberOfCallsDeviationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberOfCallsDeviation_Maximum() {
		return (EAttribute)numberOfCallsDeviationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberOfCallsDeviation_RequiredElement() {
		return (EReference)numberOfCallsDeviationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalStateInfluenceAnalysisAggregation() {
		return internalStateInfluenceAnalysisAggregationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalStateInfluenceAnalysisAggregation_QualityAnnotation() {
		return (EReference)internalStateInfluenceAnalysisAggregationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalStateInfluenceAnalysisAggregation_CallParameterDeviation() {
		return (EReference)internalStateInfluenceAnalysisAggregationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalStateInfluenceAnalysisAggregation_NumberOfCallsDeviation() {
		return (EReference)internalStateInfluenceAnalysisAggregationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getREPrecision() {
		return rePrecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREPrecision_DefaultPrecisionNumberOfCalls() {
		return (EReference)rePrecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREPrecision_DefaultPrecisionCallParameter() {
		return (EReference)rePrecisionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREPrecision_RequiredElement() {
		return (EReference)rePrecisionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrecision() {
		return precisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMParameterPartition() {
		return pcmParameterPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMParameterPartition_CharacerisedParameterPartitions() {
		return (EReference)pcmParameterPartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMParameterPartition_ParameterReference() {
		return (EReference)pcmParameterPartitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterisedPCMParameterPartition() {
		return characterisedPCMParameterPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCharacterisedPCMParameterPartition_ForCharacterisation() {
		return (EAttribute)characterisedPCMParameterPartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacterisedPCMParameterPartition_PcmParameterPartition() {
		return (EReference)characterisedPCMParameterPartitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterisedPCMParameterPartitionInterval() {
		return characterisedPCMParameterPartitionIntervalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacterisedPCMParameterPartitionInterval_From() {
		return (EReference)characterisedPCMParameterPartitionIntervalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacterisedPCMParameterPartitionInterval_To() {
		return (EReference)characterisedPCMParameterPartitionIntervalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterisedPCMParameterPartitionRange() {
		return characterisedPCMParameterPartitionRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacterisedPCMParameterPartitionRange_Values() {
		return (EReference)characterisedPCMParameterPartitionRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExactlyAsSpecifiedPrecision() {
		return exactlyAsSpecifiedPrecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLimitedDeviationPrecision() {
		return limitedDeviationPrecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLimitedDeviationPrecision_Absolute() {
		return (EAttribute)limitedDeviationPrecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLimitedDeviationPrecision_Relative() {
		return (EAttribute)limitedDeviationPrecisionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNoPrecision() {
		return noPrecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMRECategory() {
		return pcmreCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPCMRECategory_Category() {
		return (EAttribute)pcmreCategoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMRE() {
		return pcmreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMREInterface() {
		return pcmreInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMREInterface_Interface() {
		return (EReference)pcmreInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMRERole() {
		return pcmreRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMRERole_Role() {
		return (EReference)pcmreRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMRESignature() {
		return pcmreSignatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMRESignature_Signature() {
		return (EReference)pcmreSignatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMServiceSpecification() {
		return pcmServiceSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMServiceSpecification_ResourceDemandingSEFF() {
		return (EReference)pcmServiceSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMREResourceInterface() {
		return pcmreResourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMREResourceInterface_ResourceInterface() {
		return (EReference)pcmreResourceInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMREResourceSignature() {
		return pcmreResourceSignatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMREResourceSignature_ResourceSignature() {
		return (EReference)pcmreResourceSignatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPCMRERequestCategory() {
		return pcmreRequestCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityAnnotationFactory getQualityAnnotationFactory() {
		return (QualityAnnotationFactory)getEFactoryInstance();
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
		callParameterDeviationEClass = createEClass(CALL_PARAMETER_DEVIATION);
		createEReference(callParameterDeviationEClass, CALL_PARAMETER_DEVIATION__PARAMETER_REFERENCE);
		createEReference(callParameterDeviationEClass, CALL_PARAMETER_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION);
		createEAttribute(callParameterDeviationEClass, CALL_PARAMETER_DEVIATION__MAXIMUM);

		qualityAnnotationEClass = createEClass(QUALITY_ANNOTATION);
		createEAttribute(qualityAnnotationEClass, QUALITY_ANNOTATION__IS_VALID);
		createEReference(qualityAnnotationEClass, QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION);
		createEReference(qualityAnnotationEClass, QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS);
		createEReference(qualityAnnotationEClass, QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULT);
		createEReference(qualityAnnotationEClass, QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS);

		serviceSpecificationEClass = createEClass(SERVICE_SPECIFICATION);
		createEAttribute(serviceSpecificationEClass, SERVICE_SPECIFICATION__CHECKSUM);
		createEReference(serviceSpecificationEClass, SERVICE_SPECIFICATION__QUALITY_ANNOTATION);

		requiredElementEClass = createEClass(REQUIRED_ELEMENT);
		createEReference(requiredElementEClass, REQUIRED_ELEMENT__NUMBER_OF_CALLS_DEVIATION);
		createEReference(requiredElementEClass, REQUIRED_ELEMENT__CHILD_RES);
		createEReference(requiredElementEClass, REQUIRED_ELEMENT__PARENT_RE);
		createEReference(requiredElementEClass, REQUIRED_ELEMENT__PRECISION);
		createEReference(requiredElementEClass, REQUIRED_ELEMENT__QUALITY_ANNOTATION);

		numberOfCallsDeviationEClass = createEClass(NUMBER_OF_CALLS_DEVIATION);
		createEReference(numberOfCallsDeviationEClass, NUMBER_OF_CALLS_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION);
		createEAttribute(numberOfCallsDeviationEClass, NUMBER_OF_CALLS_DEVIATION__MAXIMUM);
		createEReference(numberOfCallsDeviationEClass, NUMBER_OF_CALLS_DEVIATION__REQUIRED_ELEMENT);

		internalStateInfluenceAnalysisAggregationEClass = createEClass(INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION);
		createEReference(internalStateInfluenceAnalysisAggregationEClass, INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION);
		createEReference(internalStateInfluenceAnalysisAggregationEClass, INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__CALL_PARAMETER_DEVIATION);
		createEReference(internalStateInfluenceAnalysisAggregationEClass, INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__NUMBER_OF_CALLS_DEVIATION);

		rePrecisionEClass = createEClass(RE_PRECISION);
		createEReference(rePrecisionEClass, RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS);
		createEReference(rePrecisionEClass, RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER);
		createEReference(rePrecisionEClass, RE_PRECISION__REQUIRED_ELEMENT);

		precisionEClass = createEClass(PRECISION);

		pcmParameterPartitionEClass = createEClass(PCM_PARAMETER_PARTITION);
		createEReference(pcmParameterPartitionEClass, PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS);
		createEReference(pcmParameterPartitionEClass, PCM_PARAMETER_PARTITION__PARAMETER_REFERENCE);

		characterisedPCMParameterPartitionEClass = createEClass(CHARACTERISED_PCM_PARAMETER_PARTITION);
		createEAttribute(characterisedPCMParameterPartitionEClass, CHARACTERISED_PCM_PARAMETER_PARTITION__FOR_CHARACTERISATION);
		createEReference(characterisedPCMParameterPartitionEClass, CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION);

		characterisedPCMParameterPartitionIntervalEClass = createEClass(CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL);
		createEReference(characterisedPCMParameterPartitionIntervalEClass, CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM);
		createEReference(characterisedPCMParameterPartitionIntervalEClass, CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO);

		characterisedPCMParameterPartitionRangeEClass = createEClass(CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE);
		createEReference(characterisedPCMParameterPartitionRangeEClass, CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE__VALUES);

		exactlyAsSpecifiedPrecisionEClass = createEClass(EXACTLY_AS_SPECIFIED_PRECISION);

		limitedDeviationPrecisionEClass = createEClass(LIMITED_DEVIATION_PRECISION);
		createEAttribute(limitedDeviationPrecisionEClass, LIMITED_DEVIATION_PRECISION__ABSOLUTE);
		createEAttribute(limitedDeviationPrecisionEClass, LIMITED_DEVIATION_PRECISION__RELATIVE);

		noPrecisionEClass = createEClass(NO_PRECISION);

		pcmreCategoryEClass = createEClass(PCMRE_CATEGORY);
		createEAttribute(pcmreCategoryEClass, PCMRE_CATEGORY__CATEGORY);

		pcmreEClass = createEClass(PCMRE);

		pcmreInterfaceEClass = createEClass(PCMRE_INTERFACE);
		createEReference(pcmreInterfaceEClass, PCMRE_INTERFACE__INTERFACE);

		pcmreRoleEClass = createEClass(PCMRE_ROLE);
		createEReference(pcmreRoleEClass, PCMRE_ROLE__ROLE);

		pcmreSignatureEClass = createEClass(PCMRE_SIGNATURE);
		createEReference(pcmreSignatureEClass, PCMRE_SIGNATURE__SIGNATURE);

		pcmServiceSpecificationEClass = createEClass(PCM_SERVICE_SPECIFICATION);
		createEReference(pcmServiceSpecificationEClass, PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF);

		pcmreResourceInterfaceEClass = createEClass(PCMRE_RESOURCE_INTERFACE);
		createEReference(pcmreResourceInterfaceEClass, PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE);

		pcmreResourceSignatureEClass = createEClass(PCMRE_RESOURCE_SIGNATURE);
		createEReference(pcmreResourceSignatureEClass, PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE);

		// Create enums
		pcmreRequestCategoryEEnum = createEEnum(PCMRE_REQUEST_CATEGORY);
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
		ParametersPackage theParametersPackage = (ParametersPackage)EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI);
		QualityPackage theQualityPackage = (QualityPackage)EPackage.Registry.INSTANCE.getEPackage(QualityPackage.eNS_URI);
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		PCMPackage thePCMPackage = (PCMPackage)EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI);
		ParameterPackage theParameterPackage = (ParameterPackage)EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		ResourcetypePackage theResourcetypePackage = (ResourcetypePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		qualityAnnotationEClass.getESuperTypes().add(theQualityPackage.getQualityStatement());
		serviceSpecificationEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		requiredElementEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		internalStateInfluenceAnalysisAggregationEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		precisionEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		pcmParameterPartitionEClass.getESuperTypes().add(theParametersPackage.getParameterPartition());
		characterisedPCMParameterPartitionEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		characterisedPCMParameterPartitionIntervalEClass.getESuperTypes().add(this.getCharacterisedPCMParameterPartition());
		characterisedPCMParameterPartitionRangeEClass.getESuperTypes().add(this.getCharacterisedPCMParameterPartition());
		exactlyAsSpecifiedPrecisionEClass.getESuperTypes().add(this.getPrecision());
		limitedDeviationPrecisionEClass.getESuperTypes().add(this.getPrecision());
		noPrecisionEClass.getESuperTypes().add(this.getPrecision());
		pcmreCategoryEClass.getESuperTypes().add(this.getPCMRE());
		pcmreEClass.getESuperTypes().add(this.getRequiredElement());
		pcmreInterfaceEClass.getESuperTypes().add(this.getPCMRE());
		pcmreRoleEClass.getESuperTypes().add(this.getPCMRE());
		pcmreSignatureEClass.getESuperTypes().add(this.getPCMRE());
		pcmServiceSpecificationEClass.getESuperTypes().add(this.getServiceSpecification());
		pcmreResourceInterfaceEClass.getESuperTypes().add(this.getPCMRE());
		pcmreResourceSignatureEClass.getESuperTypes().add(this.getPCMRE());

		// Initialize classes and features; add operations and parameters
		initEClass(callParameterDeviationEClass, CallParameterDeviation.class, "CallParameterDeviation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallParameterDeviation_ParameterReference(), theParametersPackage.getParameterReference(), theParametersPackage.getParameterReference_CallParameterDeviation(), "parameterReference", null, 0, -1, CallParameterDeviation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCallParameterDeviation_InternalStateInfluenceAnalysisAggregation(), this.getInternalStateInfluenceAnalysisAggregation(), this.getInternalStateInfluenceAnalysisAggregation_CallParameterDeviation(), "internalStateInfluenceAnalysisAggregation", null, 1, 1, CallParameterDeviation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCallParameterDeviation_Maximum(), ecorePackage.getEDouble(), "maximum", null, 1, 1, CallParameterDeviation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(qualityAnnotationEClass, QualityAnnotation.class, "QualityAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQualityAnnotation_IsValid(), ecorePackage.getEBoolean(), "isValid", "false", 1, 1, QualityAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getQualityAnnotation_ForServiceSpecification(), this.getServiceSpecification(), this.getServiceSpecification_QualityAnnotation(), "forServiceSpecification", null, 1, 1, QualityAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getQualityAnnotation_StipulatedREPrecisions(), this.getRequiredElement(), this.getRequiredElement_QualityAnnotation(), "stipulatedREPrecisions", null, 0, -1, QualityAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getQualityAnnotation_InternalStateInfluenceAnalysisResult(), this.getInternalStateInfluenceAnalysisAggregation(), this.getInternalStateInfluenceAnalysisAggregation_QualityAnnotation(), "internalStateInfluenceAnalysisResult", null, 0, -1, QualityAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getQualityAnnotation_ValidForParameterPartitions(), theParametersPackage.getParameterPartition(), theParametersPackage.getParameterPartition_ValidatedSetting(), "validForParameterPartitions", null, 0, -1, QualityAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(serviceSpecificationEClass, ServiceSpecification.class, "ServiceSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceSpecification_Checksum(), ecorePackage.getELong(), "checksum", null, 0, 1, ServiceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getServiceSpecification_QualityAnnotation(), this.getQualityAnnotation(), this.getQualityAnnotation_ForServiceSpecification(), "qualityAnnotation", null, 1, 1, ServiceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(requiredElementEClass, RequiredElement.class, "RequiredElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequiredElement_NumberOfCallsDeviation(), this.getNumberOfCallsDeviation(), this.getNumberOfCallsDeviation_RequiredElement(), "numberOfCallsDeviation", null, 0, 1, RequiredElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRequiredElement_ChildREs(), this.getRequiredElement(), this.getRequiredElement_ParentRE(), "childREs", null, 0, -1, RequiredElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRequiredElement_ParentRE(), this.getRequiredElement(), this.getRequiredElement_ChildREs(), "parentRE", null, 0, 1, RequiredElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRequiredElement_Precision(), this.getREPrecision(), this.getREPrecision_RequiredElement(), "precision", null, 0, 1, RequiredElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRequiredElement_QualityAnnotation(), this.getQualityAnnotation(), this.getQualityAnnotation_StipulatedREPrecisions(), "qualityAnnotation", null, 0, 1, RequiredElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(requiredElementEClass, ecorePackage.getEBoolean(), "StipulatedPrecisionMustBeSetInStipulationContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(numberOfCallsDeviationEClass, NumberOfCallsDeviation.class, "NumberOfCallsDeviation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNumberOfCallsDeviation_InternalStateInfluenceAnalysisAggregation(), this.getInternalStateInfluenceAnalysisAggregation(), this.getInternalStateInfluenceAnalysisAggregation_NumberOfCallsDeviation(), "internalStateInfluenceAnalysisAggregation", null, 1, 1, NumberOfCallsDeviation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNumberOfCallsDeviation_Maximum(), ecorePackage.getEDouble(), "maximum", null, 1, 1, NumberOfCallsDeviation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNumberOfCallsDeviation_RequiredElement(), this.getRequiredElement(), this.getRequiredElement_NumberOfCallsDeviation(), "requiredElement", null, 1, 1, NumberOfCallsDeviation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(internalStateInfluenceAnalysisAggregationEClass, InternalStateInfluenceAnalysisAggregation.class, "InternalStateInfluenceAnalysisAggregation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalStateInfluenceAnalysisAggregation_QualityAnnotation(), this.getQualityAnnotation(), this.getQualityAnnotation_InternalStateInfluenceAnalysisResult(), "qualityAnnotation", null, 1, 1, InternalStateInfluenceAnalysisAggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInternalStateInfluenceAnalysisAggregation_CallParameterDeviation(), this.getCallParameterDeviation(), this.getCallParameterDeviation_InternalStateInfluenceAnalysisAggregation(), "callParameterDeviation", null, 0, -1, InternalStateInfluenceAnalysisAggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInternalStateInfluenceAnalysisAggregation_NumberOfCallsDeviation(), this.getNumberOfCallsDeviation(), this.getNumberOfCallsDeviation_InternalStateInfluenceAnalysisAggregation(), "numberOfCallsDeviation", null, 0, -1, InternalStateInfluenceAnalysisAggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rePrecisionEClass, REPrecision.class, "REPrecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getREPrecision_DefaultPrecisionNumberOfCalls(), this.getPrecision(), null, "defaultPrecisionNumberOfCalls", null, 1, 1, REPrecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getREPrecision_DefaultPrecisionCallParameter(), this.getPrecision(), null, "defaultPrecisionCallParameter", null, 1, 1, REPrecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getREPrecision_RequiredElement(), this.getRequiredElement(), this.getRequiredElement_Precision(), "requiredElement", null, 1, 1, REPrecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(precisionEClass, Precision.class, "Precision", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pcmParameterPartitionEClass, PCMParameterPartition.class, "PCMParameterPartition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMParameterPartition_CharacerisedParameterPartitions(), this.getCharacterisedPCMParameterPartition(), this.getCharacterisedPCMParameterPartition_PcmParameterPartition(), "characerisedParameterPartitions", null, 0, -1, PCMParameterPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPCMParameterPartition_ParameterReference(), thePCMPackage.getPCMParameterReference(), thePCMPackage.getPCMParameterReference_ParameterPartition(), "parameterReference", null, 1, 1, PCMParameterPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(characterisedPCMParameterPartitionEClass, CharacterisedPCMParameterPartition.class, "CharacterisedPCMParameterPartition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCharacterisedPCMParameterPartition_ForCharacterisation(), theParameterPackage.getVariableCharacterisationType(), "forCharacterisation", null, 1, 1, CharacterisedPCMParameterPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCharacterisedPCMParameterPartition_PcmParameterPartition(), this.getPCMParameterPartition(), this.getPCMParameterPartition_CharacerisedParameterPartitions(), "pcmParameterPartition", null, 1, 1, CharacterisedPCMParameterPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(characterisedPCMParameterPartitionIntervalEClass, CharacterisedPCMParameterPartitionInterval.class, "CharacterisedPCMParameterPartitionInterval", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCharacterisedPCMParameterPartitionInterval_From(), theCorePackage.getPCMRandomVariable(), null, "from", null, 1, 1, CharacterisedPCMParameterPartitionInterval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCharacterisedPCMParameterPartitionInterval_To(), theCorePackage.getPCMRandomVariable(), null, "to", null, 1, 1, CharacterisedPCMParameterPartitionInterval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(characterisedPCMParameterPartitionRangeEClass, CharacterisedPCMParameterPartitionRange.class, "CharacterisedPCMParameterPartitionRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCharacterisedPCMParameterPartitionRange_Values(), theCorePackage.getPCMRandomVariable(), null, "values", null, 0, -1, CharacterisedPCMParameterPartitionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(exactlyAsSpecifiedPrecisionEClass, ExactlyAsSpecifiedPrecision.class, "ExactlyAsSpecifiedPrecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(limitedDeviationPrecisionEClass, LimitedDeviationPrecision.class, "LimitedDeviationPrecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLimitedDeviationPrecision_Absolute(), ecorePackage.getEDouble(), "absolute", null, 1, 1, LimitedDeviationPrecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLimitedDeviationPrecision_Relative(), ecorePackage.getEDouble(), "relative", null, 1, 1, LimitedDeviationPrecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(noPrecisionEClass, NoPrecision.class, "NoPrecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pcmreCategoryEClass, PCMRECategory.class, "PCMRECategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPCMRECategory_Category(), this.getPCMRERequestCategory(), "category", null, 1, 1, PCMRECategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(pcmreCategoryEClass, ecorePackage.getEBoolean(), "NextLowerHierarchyLevelIsInterface", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pcmreCategoryEClass, ecorePackage.getEBoolean(), "ThisIsHighestHierarchyLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pcmreCategoryEClass, ecorePackage.getEBoolean(), "NoSublevelsForCategoryResourceDemand", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pcmreCategoryEClass, ecorePackage.getEBoolean(), "ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(pcmreEClass, de.fzi.se.quality.qualityannotation.PCMRE.class, "PCMRE", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pcmreInterfaceEClass, PCMREInterface.class, "PCMREInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMREInterface_Interface(), theRepositoryPackage.getInterface(), null, "interface", null, 1, 1, PCMREInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(pcmreInterfaceEClass, ecorePackage.getEBoolean(), "NextLowerHierachyLevelIsRole", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pcmreInterfaceEClass, ecorePackage.getEBoolean(), "NextUpperHierarchyLevelIsCategory", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(pcmreRoleEClass, PCMRERole.class, "PCMRERole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMRERole_Role(), theRepositoryPackage.getRole(), null, "role", null, 1, 1, PCMRERole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(pcmreRoleEClass, ecorePackage.getEBoolean(), "NextLowerHierarchyLevelIsSignature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pcmreRoleEClass, ecorePackage.getEBoolean(), "NextUpperHierarchyLevelIsInterface", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(pcmreSignatureEClass, PCMRESignature.class, "PCMRESignature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMRESignature_Signature(), theRepositoryPackage.getSignature(), null, "signature", null, 1, 1, PCMRESignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(pcmreSignatureEClass, ecorePackage.getEBoolean(), "ThisIsTheLowestHierarchyLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pcmreSignatureEClass, ecorePackage.getEBoolean(), "NextUpperHierarchyLevelIsRole", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(pcmServiceSpecificationEClass, PCMServiceSpecification.class, "PCMServiceSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMServiceSpecification_ResourceDemandingSEFF(), theSeffPackage.getResourceDemandingSEFF(), null, "resourceDemandingSEFF", null, 0, 1, PCMServiceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pcmreResourceInterfaceEClass, PCMREResourceInterface.class, "PCMREResourceInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMREResourceInterface_ResourceInterface(), theResourcetypePackage.getResourceInterface(), null, "resourceInterface", null, 1, 1, PCMREResourceInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pcmreResourceSignatureEClass, PCMREResourceSignature.class, "PCMREResourceSignature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMREResourceSignature_ResourceSignature(), theResourcetypePackage.getResourceSignature(), null, "resourceSignature", null, 1, 1, PCMREResourceSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(pcmreRequestCategoryEEnum, PCMRERequestCategory.class, "PCMRERequestCategory");
		addEEnumLiteral(pcmreRequestCategoryEEnum, PCMRERequestCategory.RESOURCE);
		addEEnumLiteral(pcmreRequestCategoryEEnum, PCMRERequestCategory.INFRASTRUCTURE);
		addEEnumLiteral(pcmreRequestCategoryEEnum, PCMRERequestCategory.COMPONENT);
		addEEnumLiteral(pcmreRequestCategoryEEnum, PCMRERequestCategory.RESOURCE_DEMAND);
		addEEnumLiteral(pcmreRequestCategoryEEnum, PCMRERequestCategory.COMPONENT_INTERNAL);
	}

} //QualityAnnotationPackageImpl
