/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.fzi.se.quality.QualityPackage;
import de.fzi.se.quality.impl.QualityPackageImpl;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.fzi.se.quality.parameters.impl.ParametersPackageImpl;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange;
import de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision;
import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision;
import de.fzi.se.quality.qualityannotation.NoPrecision;
import de.fzi.se.quality.qualityannotation.PCMPEAllDecisions;
import de.fzi.se.quality.qualityannotation.PCMPEDecision;
import de.fzi.se.quality.qualityannotation.PCMParameterPartition;
import de.fzi.se.quality.qualityannotation.PCMRECIBehavior;
import de.fzi.se.quality.qualityannotation.PCMRECategory;
import de.fzi.se.quality.qualityannotation.PCMREInfrastructureInterface;
import de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole;
import de.fzi.se.quality.qualityannotation.PCMREInfrastructureSignature;
import de.fzi.se.quality.qualityannotation.PCMREInterface;
import de.fzi.se.quality.qualityannotation.PCMRERequestCategory;
import de.fzi.se.quality.qualityannotation.PCMREResource;
import de.fzi.se.quality.qualityannotation.PCMREResourceInterface;
import de.fzi.se.quality.qualityannotation.PCMREResourceRole;
import de.fzi.se.quality.qualityannotation.PCMREResourceSignature;
import de.fzi.se.quality.qualityannotation.PCMRERole;
import de.fzi.se.quality.qualityannotation.PCMRESignature;
import de.fzi.se.quality.qualityannotation.PCMServiceSpecification;
import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.ProbabilisticElement;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationFactory;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.REPrecision;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.fzi.se.quality.qualityannotation.RequiredElementDeviation;
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

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class QualityAnnotationPackageImpl extends EPackageImpl implements QualityAnnotationPackage {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass parameterValueDeviationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass qualityAnnotationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass serviceSpecificationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass requiredElementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass requiredElementDeviationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass internalStateInfluenceAnalysisAggregationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rePrecisionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass probabilisticElementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass precisionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmParameterPartitionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass characterisedPCMParameterPartitionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass characterisedPCMParameterPartitionIntervalEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass characterisedPCMParameterPartitionRangeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass exactlyAsSpecifiedPrecisionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass limitedDeviationPrecisionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass noPrecisionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreCategoryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreInterfaceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreRoleEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreSignatureEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmServiceSpecificationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreResourceInterfaceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreResourceSignatureEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreResourceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreResourceRoleEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreciBehaviorEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreInfrastructureInterfaceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreInfrastructureRoleEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmreInfrastructureSignatureEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmpeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmpeAllDecisionsEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmpeDecisionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum pcmreRequestCategoryEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
     * value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init
     * init()}, which also performs initialization of the package, or returns the registered
     * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private QualityAnnotationPackageImpl() {
        super(eNS_URI, QualityAnnotationFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
     * upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link QualityAnnotationPackage#eINSTANCE} when that field
     * is accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static QualityAnnotationPackage init() {
        if (isInited) {
            return (QualityAnnotationPackage) EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI);
        }

        // Obtain or create and register package
        final QualityAnnotationPackageImpl theQualityAnnotationPackage = (QualityAnnotationPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof QualityAnnotationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                : new QualityAnnotationPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        PcmPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        final QualityPackageImpl theQualityPackage = (QualityPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(QualityPackage.eNS_URI) instanceof QualityPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(QualityPackage.eNS_URI) : QualityPackage.eINSTANCE);
        final ParametersPackageImpl theParametersPackage = (ParametersPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ParametersPackage.eNS_URI) instanceof ParametersPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(ParametersPackage.eNS_URI) : ParametersPackage.eINSTANCE);
        final PCMPackageImpl thePCMPackage = (PCMPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(PCMPackage.eNS_URI) instanceof PCMPackageImpl ? EPackage.Registry.INSTANCE
                        .getEPackage(PCMPackage.eNS_URI) : PCMPackage.eINSTANCE);

        // Create package meta-data objects
        theQualityAnnotationPackage.createPackageContents();
        theQualityPackage.createPackageContents();
        theParametersPackage.createPackageContents();
        thePCMPackage.createPackageContents();

        // Initialize created meta-data
        theQualityAnnotationPackage.initializePackageContents();
        theQualityPackage.initializePackageContents();
        theParametersPackage.initializePackageContents();
        thePCMPackage.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put(theQualityAnnotationPackage, new EValidator.Descriptor() {

            @Override
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getParameterValueDeviation() {
        return this.parameterValueDeviationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getParameterValueDeviation_ParameterReference() {
        return (EReference) this.parameterValueDeviationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getParameterValueDeviation_InternalStateInfluenceAnalysisAggregation() {
        return (EReference) this.parameterValueDeviationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getParameterValueDeviation_RequiredElementDeviation() {
        return (EReference) this.parameterValueDeviationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getParameterValueDeviation_ParameterValue() {
        return (EReference) this.parameterValueDeviationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getQualityAnnotation() {
        return this.qualityAnnotationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getQualityAnnotation_IsValid() {
        return (EAttribute) this.qualityAnnotationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getQualityAnnotation_ForServiceSpecification() {
        return (EReference) this.qualityAnnotationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getQualityAnnotation_StipulatedREPrecisions() {
        return (EReference) this.qualityAnnotationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getQualityAnnotation_InternalStateInfluenceAnalysisResults() {
        return (EReference) this.qualityAnnotationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getQualityAnnotation_ProbabilisticElements() {
        return (EReference) this.qualityAnnotationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getQualityAnnotation_ValidForParameterPartitions() {
        return (EReference) this.qualityAnnotationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getServiceSpecification() {
        return this.serviceSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getServiceSpecification_Checksum() {
        return (EAttribute) this.serviceSpecificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getServiceSpecification_ChecksumAlg() {
        return (EAttribute) this.serviceSpecificationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getServiceSpecification_QualityAnnotation() {
        return (EReference) this.serviceSpecificationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRequiredElement() {
        return this.requiredElementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRequiredElement_RequiredElementDeviation() {
        return (EReference) this.requiredElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRequiredElement_ChildREs() {
        return (EReference) this.requiredElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRequiredElement_ParentRE() {
        return (EReference) this.requiredElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRequiredElement_Precision() {
        return (EReference) this.requiredElementEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRequiredElement_QualityAnnotation() {
        return (EReference) this.requiredElementEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRequiredElementDeviation() {
        return this.requiredElementDeviationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRequiredElementDeviation_InternalStateInfluenceAnalysisAggregation() {
        return (EReference) this.requiredElementDeviationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRequiredElementDeviation_MaximumDeviationNumberOfCalls() {
        return (EReference) this.requiredElementDeviationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRequiredElementDeviation_MaximumDeviationCallParameterValues() {
        return (EReference) this.requiredElementDeviationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRequiredElementDeviation_RequiredElement() {
        return (EReference) this.requiredElementDeviationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getInternalStateInfluenceAnalysisAggregation() {
        return this.internalStateInfluenceAnalysisAggregationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInternalStateInfluenceAnalysisAggregation_QualityAnnotation() {
        return (EReference) this.internalStateInfluenceAnalysisAggregationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInternalStateInfluenceAnalysisAggregation_ParameterValueDeviations() {
        return (EReference) this.internalStateInfluenceAnalysisAggregationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInternalStateInfluenceAnalysisAggregation_RequiredElementDeviations() {
        return (EReference) this.internalStateInfluenceAnalysisAggregationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getREPrecision() {
        return this.rePrecisionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getREPrecision_DefaultPrecisionNumberOfCalls() {
        return (EReference) this.rePrecisionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getREPrecision_DefaultPrecisionCallParameter() {
        return (EReference) this.rePrecisionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getREPrecision_RequiredElement() {
        return (EReference) this.rePrecisionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getProbabilisticElement() {
        return this.probabilisticElementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProbabilisticElement_Precision() {
        return (EReference) this.probabilisticElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProbabilisticElement_ChildPEs() {
        return (EReference) this.probabilisticElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProbabilisticElement_ParentPE() {
        return (EReference) this.probabilisticElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProbabilisticElement_QualityAnnotation() {
        return (EReference) this.probabilisticElementEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPrecision() {
        return this.precisionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMParameterPartition() {
        return this.pcmParameterPartitionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMParameterPartition_CharacerisedParameterPartitions() {
        return (EReference) this.pcmParameterPartitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCharacterisedPCMParameterPartition() {
        return this.characterisedPCMParameterPartitionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getCharacterisedPCMParameterPartition_ForCharacterisation() {
        return (EAttribute) this.characterisedPCMParameterPartitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCharacterisedPCMParameterPartition_PcmParameterPartition() {
        return (EReference) this.characterisedPCMParameterPartitionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getCharacterisedPCMParameterPartition_QualifiedElementName() {
        return (EAttribute) this.characterisedPCMParameterPartitionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCharacterisedPCMParameterPartitionInterval() {
        return this.characterisedPCMParameterPartitionIntervalEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCharacterisedPCMParameterPartitionInterval_From() {
        return (EReference) this.characterisedPCMParameterPartitionIntervalEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCharacterisedPCMParameterPartitionInterval_To() {
        return (EReference) this.characterisedPCMParameterPartitionIntervalEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCharacterisedPCMParameterPartitionRange() {
        return this.characterisedPCMParameterPartitionRangeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCharacterisedPCMParameterPartitionRange_Values() {
        return (EReference) this.characterisedPCMParameterPartitionRangeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getExactlyAsSpecifiedPrecision() {
        return this.exactlyAsSpecifiedPrecisionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getLimitedDeviationPrecision() {
        return this.limitedDeviationPrecisionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getLimitedDeviationPrecision_Absolute() {
        return (EAttribute) this.limitedDeviationPrecisionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getLimitedDeviationPrecision_Relative() {
        return (EAttribute) this.limitedDeviationPrecisionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getNoPrecision() {
        return this.noPrecisionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMRECategory() {
        return this.pcmreCategoryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getPCMRECategory_Category() {
        return (EAttribute) this.pcmreCategoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMRE() {
        return this.pcmreEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMREInterface() {
        return this.pcmreInterfaceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMREInterface_Interface() {
        return (EReference) this.pcmreInterfaceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMRERole() {
        return this.pcmreRoleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMRERole_Role() {
        return (EReference) this.pcmreRoleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMRESignature() {
        return this.pcmreSignatureEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMRESignature_Signature() {
        return (EReference) this.pcmreSignatureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMServiceSpecification() {
        return this.pcmServiceSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMServiceSpecification_ResourceDemandingSEFF() {
        return (EReference) this.pcmServiceSpecificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMREResourceInterface() {
        return this.pcmreResourceInterfaceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMREResourceInterface_ResourceInterface() {
        return (EReference) this.pcmreResourceInterfaceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMREResourceSignature() {
        return this.pcmreResourceSignatureEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMREResourceSignature_ResourceSignature() {
        return (EReference) this.pcmreResourceSignatureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMREResource() {
        return this.pcmreResourceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMREResource_ProcessingResourceType() {
        return (EReference) this.pcmreResourceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMREResourceRole() {
        return this.pcmreResourceRoleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMREResourceRole_ResourceRole() {
        return (EReference) this.pcmreResourceRoleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMRECIBehavior() {
        return this.pcmreciBehaviorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMRECIBehavior_InternalBehaviour() {
        return (EReference) this.pcmreciBehaviorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMREInfrastructureInterface() {
        return this.pcmreInfrastructureInterfaceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMREInfrastructureInterface_Interface() {
        return (EReference) this.pcmreInfrastructureInterfaceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMREInfrastructureRole() {
        return this.pcmreInfrastructureRoleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMREInfrastructureRole_Role() {
        return (EReference) this.pcmreInfrastructureRoleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMREInfrastructureSignature() {
        return this.pcmreInfrastructureSignatureEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMREInfrastructureSignature_Signature() {
        return (EReference) this.pcmreInfrastructureSignatureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMPE() {
        return this.pcmpeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMPEAllDecisions() {
        return this.pcmpeAllDecisionsEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMPEDecision() {
        return this.pcmpeDecisionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMPEDecision_BranchAction() {
        return (EReference) this.pcmpeDecisionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getPCMRERequestCategory() {
        return this.pcmreRequestCategoryEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public QualityAnnotationFactory getQualityAnnotationFactory() {
        return (QualityAnnotationFactory) this.getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on
     * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated) {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.parameterValueDeviationEClass = this.createEClass(PARAMETER_VALUE_DEVIATION);
        this.createEReference(this.parameterValueDeviationEClass, PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE);
        this.createEReference(this.parameterValueDeviationEClass,
                PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION);
        this.createEReference(this.parameterValueDeviationEClass, PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION);
        this.createEReference(this.parameterValueDeviationEClass, PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE);

        this.qualityAnnotationEClass = this.createEClass(QUALITY_ANNOTATION);
        this.createEAttribute(this.qualityAnnotationEClass, QUALITY_ANNOTATION__IS_VALID);
        this.createEReference(this.qualityAnnotationEClass, QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION);
        this.createEReference(this.qualityAnnotationEClass, QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS);
        this.createEReference(this.qualityAnnotationEClass,
                QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS);
        this.createEReference(this.qualityAnnotationEClass, QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS);
        this.createEReference(this.qualityAnnotationEClass, QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS);

        this.serviceSpecificationEClass = this.createEClass(SERVICE_SPECIFICATION);
        this.createEAttribute(this.serviceSpecificationEClass, SERVICE_SPECIFICATION__CHECKSUM);
        this.createEAttribute(this.serviceSpecificationEClass, SERVICE_SPECIFICATION__CHECKSUM_ALG);
        this.createEReference(this.serviceSpecificationEClass, SERVICE_SPECIFICATION__QUALITY_ANNOTATION);

        this.requiredElementEClass = this.createEClass(REQUIRED_ELEMENT);
        this.createEReference(this.requiredElementEClass, REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION);
        this.createEReference(this.requiredElementEClass, REQUIRED_ELEMENT__CHILD_RES);
        this.createEReference(this.requiredElementEClass, REQUIRED_ELEMENT__PARENT_RE);
        this.createEReference(this.requiredElementEClass, REQUIRED_ELEMENT__PRECISION);
        this.createEReference(this.requiredElementEClass, REQUIRED_ELEMENT__QUALITY_ANNOTATION);

        this.requiredElementDeviationEClass = this.createEClass(REQUIRED_ELEMENT_DEVIATION);
        this.createEReference(this.requiredElementDeviationEClass,
                REQUIRED_ELEMENT_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION);
        this.createEReference(this.requiredElementDeviationEClass,
                REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_NUMBER_OF_CALLS);
        this.createEReference(this.requiredElementDeviationEClass,
                REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES);
        this.createEReference(this.requiredElementDeviationEClass, REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT);

        this.internalStateInfluenceAnalysisAggregationEClass = this
                .createEClass(INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION);
        this.createEReference(this.internalStateInfluenceAnalysisAggregationEClass,
                INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION);
        this.createEReference(this.internalStateInfluenceAnalysisAggregationEClass,
                INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS);
        this.createEReference(this.internalStateInfluenceAnalysisAggregationEClass,
                INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__REQUIRED_ELEMENT_DEVIATIONS);

        this.precisionEClass = this.createEClass(PRECISION);

        this.rePrecisionEClass = this.createEClass(RE_PRECISION);
        this.createEReference(this.rePrecisionEClass, RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS);
        this.createEReference(this.rePrecisionEClass, RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER);
        this.createEReference(this.rePrecisionEClass, RE_PRECISION__REQUIRED_ELEMENT);

        this.probabilisticElementEClass = this.createEClass(PROBABILISTIC_ELEMENT);
        this.createEReference(this.probabilisticElementEClass, PROBABILISTIC_ELEMENT__PRECISION);
        this.createEReference(this.probabilisticElementEClass, PROBABILISTIC_ELEMENT__CHILD_PES);
        this.createEReference(this.probabilisticElementEClass, PROBABILISTIC_ELEMENT__PARENT_PE);
        this.createEReference(this.probabilisticElementEClass, PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION);

        this.characterisedPCMParameterPartitionEClass = this.createEClass(CHARACTERISED_PCM_PARAMETER_PARTITION);
        this.createEAttribute(this.characterisedPCMParameterPartitionEClass,
                CHARACTERISED_PCM_PARAMETER_PARTITION__FOR_CHARACTERISATION);
        this.createEReference(this.characterisedPCMParameterPartitionEClass,
                CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION);
        this.createEAttribute(this.characterisedPCMParameterPartitionEClass,
                CHARACTERISED_PCM_PARAMETER_PARTITION__QUALIFIED_ELEMENT_NAME);

        this.pcmParameterPartitionEClass = this.createEClass(PCM_PARAMETER_PARTITION);
        this.createEReference(this.pcmParameterPartitionEClass,
                PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS);

        this.characterisedPCMParameterPartitionIntervalEClass = this
                .createEClass(CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL);
        this.createEReference(this.characterisedPCMParameterPartitionIntervalEClass,
                CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM);
        this.createEReference(this.characterisedPCMParameterPartitionIntervalEClass,
                CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO);

        this.characterisedPCMParameterPartitionRangeEClass = this
                .createEClass(CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE);
        this.createEReference(this.characterisedPCMParameterPartitionRangeEClass,
                CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE__VALUES);

        this.exactlyAsSpecifiedPrecisionEClass = this.createEClass(EXACTLY_AS_SPECIFIED_PRECISION);

        this.limitedDeviationPrecisionEClass = this.createEClass(LIMITED_DEVIATION_PRECISION);
        this.createEAttribute(this.limitedDeviationPrecisionEClass, LIMITED_DEVIATION_PRECISION__ABSOLUTE);
        this.createEAttribute(this.limitedDeviationPrecisionEClass, LIMITED_DEVIATION_PRECISION__RELATIVE);

        this.noPrecisionEClass = this.createEClass(NO_PRECISION);

        this.pcmreCategoryEClass = this.createEClass(PCMRE_CATEGORY);
        this.createEAttribute(this.pcmreCategoryEClass, PCMRE_CATEGORY__CATEGORY);

        this.pcmreEClass = this.createEClass(PCMRE);

        this.pcmreInterfaceEClass = this.createEClass(PCMRE_INTERFACE);
        this.createEReference(this.pcmreInterfaceEClass, PCMRE_INTERFACE__INTERFACE);

        this.pcmreRoleEClass = this.createEClass(PCMRE_ROLE);
        this.createEReference(this.pcmreRoleEClass, PCMRE_ROLE__ROLE);

        this.pcmreSignatureEClass = this.createEClass(PCMRE_SIGNATURE);
        this.createEReference(this.pcmreSignatureEClass, PCMRE_SIGNATURE__SIGNATURE);

        this.pcmServiceSpecificationEClass = this.createEClass(PCM_SERVICE_SPECIFICATION);
        this.createEReference(this.pcmServiceSpecificationEClass, PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF);

        this.pcmreResourceInterfaceEClass = this.createEClass(PCMRE_RESOURCE_INTERFACE);
        this.createEReference(this.pcmreResourceInterfaceEClass, PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE);

        this.pcmreResourceSignatureEClass = this.createEClass(PCMRE_RESOURCE_SIGNATURE);
        this.createEReference(this.pcmreResourceSignatureEClass, PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE);

        this.pcmreResourceEClass = this.createEClass(PCMRE_RESOURCE);
        this.createEReference(this.pcmreResourceEClass, PCMRE_RESOURCE__PROCESSING_RESOURCE_TYPE);

        this.pcmreResourceRoleEClass = this.createEClass(PCMRE_RESOURCE_ROLE);
        this.createEReference(this.pcmreResourceRoleEClass, PCMRE_RESOURCE_ROLE__RESOURCE_ROLE);

        this.pcmreciBehaviorEClass = this.createEClass(PCMRECI_BEHAVIOR);
        this.createEReference(this.pcmreciBehaviorEClass, PCMRECI_BEHAVIOR__INTERNAL_BEHAVIOUR);

        this.pcmreInfrastructureInterfaceEClass = this.createEClass(PCMRE_INFRASTRUCTURE_INTERFACE);
        this.createEReference(this.pcmreInfrastructureInterfaceEClass, PCMRE_INFRASTRUCTURE_INTERFACE__INTERFACE);

        this.pcmreInfrastructureRoleEClass = this.createEClass(PCMRE_INFRASTRUCTURE_ROLE);
        this.createEReference(this.pcmreInfrastructureRoleEClass, PCMRE_INFRASTRUCTURE_ROLE__ROLE);

        this.pcmreInfrastructureSignatureEClass = this.createEClass(PCMRE_INFRASTRUCTURE_SIGNATURE);
        this.createEReference(this.pcmreInfrastructureSignatureEClass, PCMRE_INFRASTRUCTURE_SIGNATURE__SIGNATURE);

        this.pcmpeEClass = this.createEClass(PCMPE);

        this.pcmpeAllDecisionsEClass = this.createEClass(PCMPE_ALL_DECISIONS);

        this.pcmpeDecisionEClass = this.createEClass(PCMPE_DECISION);
        this.createEReference(this.pcmpeDecisionEClass, PCMPE_DECISION__BRANCH_ACTION);

        // Create enums
        this.pcmreRequestCategoryEEnum = this.createEEnum(PCMRE_REQUEST_CATEGORY);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have
     * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Obtain other dependent packages
        final ParametersPackage theParametersPackage = (ParametersPackage) EPackage.Registry.INSTANCE
                .getEPackage(ParametersPackage.eNS_URI);
        final QualityPackage theQualityPackage = (QualityPackage) EPackage.Registry.INSTANCE
                .getEPackage(QualityPackage.eNS_URI);
        final IdentifierPackage theIdentifierPackage = (IdentifierPackage) EPackage.Registry.INSTANCE
                .getEPackage(IdentifierPackage.eNS_URI);
        final ParameterPackage theParameterPackage = (ParameterPackage) EPackage.Registry.INSTANCE
                .getEPackage(ParameterPackage.eNS_URI);
        final CorePackage theCorePackage = (CorePackage) EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
        final RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
                .getEPackage(RepositoryPackage.eNS_URI);
        final SeffPackage theSeffPackage = (SeffPackage) EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
        final ResourcetypePackage theResourcetypePackage = (ResourcetypePackage) EPackage.Registry.INSTANCE
                .getEPackage(ResourcetypePackage.eNS_URI);
        final EntityPackage theEntityPackage = (EntityPackage) EPackage.Registry.INSTANCE
                .getEPackage(EntityPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.qualityAnnotationEClass.getESuperTypes().add(theQualityPackage.getQualityStatement());
        this.serviceSpecificationEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.requiredElementEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.internalStateInfluenceAnalysisAggregationEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.precisionEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.rePrecisionEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.characterisedPCMParameterPartitionEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.pcmParameterPartitionEClass.getESuperTypes().add(theParametersPackage.getParameterPartition());
        this.characterisedPCMParameterPartitionIntervalEClass.getESuperTypes().add(
                this.getCharacterisedPCMParameterPartition());
        this.characterisedPCMParameterPartitionRangeEClass.getESuperTypes().add(
                this.getCharacterisedPCMParameterPartition());
        this.exactlyAsSpecifiedPrecisionEClass.getESuperTypes().add(this.getPrecision());
        this.limitedDeviationPrecisionEClass.getESuperTypes().add(this.getPrecision());
        this.noPrecisionEClass.getESuperTypes().add(this.getPrecision());
        this.pcmreCategoryEClass.getESuperTypes().add(this.getPCMRE());
        this.pcmreEClass.getESuperTypes().add(this.getRequiredElement());
        this.pcmreInterfaceEClass.getESuperTypes().add(this.getPCMRE());
        this.pcmreRoleEClass.getESuperTypes().add(this.getPCMRE());
        this.pcmreSignatureEClass.getESuperTypes().add(this.getPCMRE());
        this.pcmServiceSpecificationEClass.getESuperTypes().add(this.getServiceSpecification());
        this.pcmreResourceInterfaceEClass.getESuperTypes().add(this.getPCMRE());
        this.pcmreResourceSignatureEClass.getESuperTypes().add(this.getPCMRE());
        this.pcmreResourceEClass.getESuperTypes().add(this.getPCMRE());
        this.pcmreResourceRoleEClass.getESuperTypes().add(this.getPCMRE());
        this.pcmreciBehaviorEClass.getESuperTypes().add(this.getPCMRE());
        this.pcmreInfrastructureInterfaceEClass.getESuperTypes().add(this.getPCMRE());
        this.pcmreInfrastructureRoleEClass.getESuperTypes().add(this.getPCMRE());
        this.pcmreInfrastructureSignatureEClass.getESuperTypes().add(this.getPCMRE());
        this.pcmpeEClass.getESuperTypes().add(this.getProbabilisticElement());
        this.pcmpeAllDecisionsEClass.getESuperTypes().add(this.getPCMPE());
        this.pcmpeDecisionEClass.getESuperTypes().add(this.getPCMPE());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.parameterValueDeviationEClass, ParameterValueDeviation.class, "ParameterValueDeviation",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getParameterValueDeviation_ParameterReference(),
                theParametersPackage.getParameterReference(),
                theParametersPackage.getParameterReference_ParameterValueDeviation(), "parameterReference", null, 1, 1,
                ParameterValueDeviation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getParameterValueDeviation_InternalStateInfluenceAnalysisAggregation(),
                this.getInternalStateInfluenceAnalysisAggregation(),
                this.getInternalStateInfluenceAnalysisAggregation_ParameterValueDeviations(),
                "internalStateInfluenceAnalysisAggregation", null, 0, 1, ParameterValueDeviation.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getParameterValueDeviation_RequiredElementDeviation(),
                this.getRequiredElementDeviation(),
                this.getRequiredElementDeviation_MaximumDeviationCallParameterValues(), "requiredElementDeviation",
                null, 0, 1, ParameterValueDeviation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getParameterValueDeviation_ParameterValue(), theParametersPackage.getParameterValue(),
                theParametersPackage.getParameterValue_ParameterValueDeviation(), "parameterValue", null, 1, 1,
                ParameterValueDeviation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.qualityAnnotationEClass, QualityAnnotation.class, "QualityAnnotation", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getQualityAnnotation_IsValid(), this.ecorePackage.getEBoolean(), "isValid", "false",
                1, 1, QualityAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getQualityAnnotation_ForServiceSpecification(), this.getServiceSpecification(),
                this.getServiceSpecification_QualityAnnotation(), "forServiceSpecification", null, 1, 1,
                QualityAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getQualityAnnotation_StipulatedREPrecisions(), this.getRequiredElement(),
                this.getRequiredElement_QualityAnnotation(), "stipulatedREPrecisions", null, 0, -1,
                QualityAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getQualityAnnotation_InternalStateInfluenceAnalysisResults(),
                this.getInternalStateInfluenceAnalysisAggregation(),
                this.getInternalStateInfluenceAnalysisAggregation_QualityAnnotation(),
                "internalStateInfluenceAnalysisResults", null, 0, -1, QualityAnnotation.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        this.initEReference(this.getQualityAnnotation_ProbabilisticElements(), this.getProbabilisticElement(),
                this.getProbabilisticElement_QualityAnnotation(), "probabilisticElements", null, 0, -1,
                QualityAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getQualityAnnotation_ValidForParameterPartitions(),
                theParametersPackage.getParameterPartition(),
                theParametersPackage.getParameterPartition_QualityAnnotation(), "validForParameterPartitions", null, 0,
                -1, QualityAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.serviceSpecificationEClass, ServiceSpecification.class, "ServiceSpecification",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getServiceSpecification_Checksum(), this.ecorePackage.getELong(), "checksum", null, 0,
                1, ServiceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getServiceSpecification_ChecksumAlg(), this.ecorePackage.getEString(), "checksumAlg",
                null, 1, 1, ServiceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getServiceSpecification_QualityAnnotation(), this.getQualityAnnotation(),
                this.getQualityAnnotation_ForServiceSpecification(), "qualityAnnotation", null, 1, 1,
                ServiceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.requiredElementEClass, RequiredElement.class, "RequiredElement", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getRequiredElement_RequiredElementDeviation(), this.getRequiredElementDeviation(),
                this.getRequiredElementDeviation_RequiredElement(), "requiredElementDeviation", null, 0, 1,
                RequiredElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getRequiredElement_ChildREs(), this.getRequiredElement(),
                this.getRequiredElement_ParentRE(), "childREs", null, 0, -1, RequiredElement.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        this.initEReference(this.getRequiredElement_ParentRE(), this.getRequiredElement(),
                this.getRequiredElement_ChildREs(), "parentRE", null, 0, 1, RequiredElement.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getRequiredElement_Precision(), this.getREPrecision(),
                this.getREPrecision_RequiredElement(), "precision", null, 0, 1, RequiredElement.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        this.initEReference(this.getRequiredElement_QualityAnnotation(), this.getQualityAnnotation(),
                this.getQualityAnnotation_StipulatedREPrecisions(), "qualityAnnotation", null, 0, 1,
                RequiredElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        EOperation op = this.addEOperation(this.requiredElementEClass, this.ecorePackage.getEBoolean(),
                "StipulatedPrecisionMustBeSetInStipulationContext", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        EGenericType g1 = this.createEGenericType(this.ecorePackage.getEMap());
        EGenericType g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.requiredElementDeviationEClass, RequiredElementDeviation.class,
                "RequiredElementDeviation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getRequiredElementDeviation_InternalStateInfluenceAnalysisAggregation(),
                this.getInternalStateInfluenceAnalysisAggregation(),
                this.getInternalStateInfluenceAnalysisAggregation_RequiredElementDeviations(),
                "internalStateInfluenceAnalysisAggregation", null, 1, 1, RequiredElementDeviation.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getRequiredElementDeviation_MaximumDeviationNumberOfCalls(), this.getPrecision(),
                null, "maximumDeviationNumberOfCalls", null, 1, 1, RequiredElementDeviation.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        this.initEReference(this.getRequiredElementDeviation_MaximumDeviationCallParameterValues(),
                this.getParameterValueDeviation(), this.getParameterValueDeviation_RequiredElementDeviation(),
                "maximumDeviationCallParameterValues", null, 0, -1, RequiredElementDeviation.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        this.initEReference(this.getRequiredElementDeviation_RequiredElement(), this.getRequiredElement(),
                this.getRequiredElement_RequiredElementDeviation(), "requiredElement", null, 1, 1,
                RequiredElementDeviation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.internalStateInfluenceAnalysisAggregationEClass,
                InternalStateInfluenceAnalysisAggregation.class, "InternalStateInfluenceAnalysisAggregation",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getInternalStateInfluenceAnalysisAggregation_QualityAnnotation(),
                this.getQualityAnnotation(), this.getQualityAnnotation_InternalStateInfluenceAnalysisResults(),
                "qualityAnnotation", null, 1, 1, InternalStateInfluenceAnalysisAggregation.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getInternalStateInfluenceAnalysisAggregation_ParameterValueDeviations(),
                this.getParameterValueDeviation(),
                this.getParameterValueDeviation_InternalStateInfluenceAnalysisAggregation(),
                "parameterValueDeviations", null, 0, -1, InternalStateInfluenceAnalysisAggregation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getInternalStateInfluenceAnalysisAggregation_RequiredElementDeviations(),
                this.getRequiredElementDeviation(),
                this.getRequiredElementDeviation_InternalStateInfluenceAnalysisAggregation(),
                "requiredElementDeviations", null, 0, -1, InternalStateInfluenceAnalysisAggregation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.precisionEClass, Precision.class, "Precision", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.rePrecisionEClass, REPrecision.class, "REPrecision", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getREPrecision_DefaultPrecisionNumberOfCalls(), this.getPrecision(), null,
                "defaultPrecisionNumberOfCalls", null, 1, 1, REPrecision.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getREPrecision_DefaultPrecisionCallParameter(), this.getPrecision(), null,
                "defaultPrecisionCallParameter", null, 1, 1, REPrecision.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getREPrecision_RequiredElement(), this.getRequiredElement(),
                this.getRequiredElement_Precision(), "requiredElement", null, 1, 1, REPrecision.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.probabilisticElementEClass, ProbabilisticElement.class, "ProbabilisticElement",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getProbabilisticElement_Precision(), this.getPrecision(), null, "precision", null, 1,
                1, ProbabilisticElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getProbabilisticElement_ChildPEs(), this.getProbabilisticElement(),
                this.getProbabilisticElement_ParentPE(), "childPEs", null, 0, -1, ProbabilisticElement.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getProbabilisticElement_ParentPE(), this.getProbabilisticElement(),
                this.getProbabilisticElement_ChildPEs(), "parentPE", null, 0, 1, ProbabilisticElement.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getProbabilisticElement_QualityAnnotation(), this.getQualityAnnotation(),
                this.getQualityAnnotation_ProbabilisticElements(), "qualityAnnotation", null, 0, 1,
                ProbabilisticElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.characterisedPCMParameterPartitionEClass, CharacterisedPCMParameterPartition.class,
                "CharacterisedPCMParameterPartition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getCharacterisedPCMParameterPartition_ForCharacterisation(),
                theParameterPackage.getVariableCharacterisationType(), "forCharacterisation", null, 1, 1,
                CharacterisedPCMParameterPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getCharacterisedPCMParameterPartition_PcmParameterPartition(),
                this.getPCMParameterPartition(), this.getPCMParameterPartition_CharacerisedParameterPartitions(),
                "pcmParameterPartition", null, 1, 1, CharacterisedPCMParameterPartition.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getCharacterisedPCMParameterPartition_QualifiedElementName(),
                this.ecorePackage.getEString(), "qualifiedElementName", null, 1, 1,
                CharacterisedPCMParameterPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.pcmParameterPartitionEClass, PCMParameterPartition.class, "PCMParameterPartition",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMParameterPartition_CharacerisedParameterPartitions(),
                this.getCharacterisedPCMParameterPartition(),
                this.getCharacterisedPCMParameterPartition_PcmParameterPartition(), "characerisedParameterPartitions",
                null, 1, -1, PCMParameterPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmParameterPartitionEClass, this.ecorePackage.getEBoolean(),
                "APCMParameterPartitionMustReferenceAPCMParameterReference", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.characterisedPCMParameterPartitionIntervalEClass,
                CharacterisedPCMParameterPartitionInterval.class, "CharacterisedPCMParameterPartitionInterval",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getCharacterisedPCMParameterPartitionInterval_From(),
                theCorePackage.getPCMRandomVariable(), null, "from", null, 1, 1,
                CharacterisedPCMParameterPartitionInterval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getCharacterisedPCMParameterPartitionInterval_To(),
                theCorePackage.getPCMRandomVariable(), null, "to", null, 1, 1,
                CharacterisedPCMParameterPartitionInterval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.characterisedPCMParameterPartitionRangeEClass,
                CharacterisedPCMParameterPartitionRange.class, "CharacterisedPCMParameterPartitionRange", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getCharacterisedPCMParameterPartitionRange_Values(),
                theCorePackage.getPCMRandomVariable(), null, "values", null, 0, -1,
                CharacterisedPCMParameterPartitionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.exactlyAsSpecifiedPrecisionEClass, ExactlyAsSpecifiedPrecision.class,
                "ExactlyAsSpecifiedPrecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.limitedDeviationPrecisionEClass, LimitedDeviationPrecision.class,
                "LimitedDeviationPrecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getLimitedDeviationPrecision_Absolute(), this.ecorePackage.getEDouble(), "absolute",
                null, 1, 1, LimitedDeviationPrecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getLimitedDeviationPrecision_Relative(), this.ecorePackage.getEDouble(), "relative",
                null, 1, 1, LimitedDeviationPrecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.noPrecisionEClass, NoPrecision.class, "NoPrecision", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.pcmreCategoryEClass, PCMRECategory.class, "PCMRECategory", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getPCMRECategory_Category(), this.getPCMRERequestCategory(), "category", null, 1, 1,
                PCMRECategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmreCategoryEClass, this.ecorePackage.getEBoolean(),
                "NextLowerHierarchyLevelIsPCMREInfrastructureInterfaceForCategoryInfrastructure", 0, 1, IS_UNIQUE,
                IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this
                .addEOperation(
                        this.pcmreCategoryEClass,
                        this.ecorePackage.getEBoolean(),
                        "ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand",
                        0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreCategoryEClass, this.ecorePackage.getEBoolean(),
                "NextLowerHierarchyLevelIsPCMREResourceInterfaceForCategoryResource", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreCategoryEClass, this.ecorePackage.getEBoolean(),
                "NextLowerHierarchyLevelIsPCMREInterfaceForCategoryComponent", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreCategoryEClass, this.ecorePackage.getEBoolean(),
                "NextLowerHierarchyLevelIsPCMREResourceForCategoryResourceDemand", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreCategoryEClass, this.ecorePackage.getEBoolean(),
                "NextLowerHierarchyLevelIsPCMRECIBehaviorForCategoryComponentInternal", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreCategoryEClass, this.ecorePackage.getEBoolean(),
                "EachCategoryExactlyOnceIfSpecified", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmreEClass, de.fzi.se.quality.qualityannotation.PCMRE.class, "PCMRE", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        op = this.addEOperation(this.pcmreEClass, this.ecorePackage.getEBoolean(),
                "TopmostLevelForPCMMustBePCMRECategory", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmreInterfaceEClass, PCMREInterface.class, "PCMREInterface", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMREInterface_Interface(), theRepositoryPackage.getOperationInterface(), null,
                "interface", null, 1, 1, PCMREInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmreInterfaceEClass, this.ecorePackage.getEBoolean(),
                "NextLowerLevelMustConsistOfTypePCMRERole", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreInterfaceEClass, this.ecorePackage.getEBoolean(),
                "EachRETargetMustBeReferencedOnlyFromOneRE", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmreRoleEClass, PCMRERole.class, "PCMRERole", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMRERole_Role(), theRepositoryPackage.getOperationRequiredRole(), null, "role",
                null, 1, 1, PCMRERole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmreRoleEClass, this.ecorePackage.getEBoolean(),
                "NextLowerLevelMustConsistOfTypePCMRESignature", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreRoleEClass, this.ecorePackage.getEBoolean(),
                "EachRETargetMustBeReferencedOnlyFromOneRE", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmreSignatureEClass, PCMRESignature.class, "PCMRESignature", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMRESignature_Signature(), theRepositoryPackage.getOperationSignature(), null,
                "signature", null, 1, 1, PCMRESignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmreSignatureEClass, this.ecorePackage.getEBoolean(),
                "ThisIsTheLowestComponentHierarchyLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreSignatureEClass, this.ecorePackage.getEBoolean(),
                "EachRETargetMustBeReferencedOnlyFromOneRE", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmServiceSpecificationEClass, PCMServiceSpecification.class, "PCMServiceSpecification",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMServiceSpecification_ResourceDemandingSEFF(),
                theSeffPackage.getResourceDemandingSEFF(), null, "resourceDemandingSEFF", null, 1, 1,
                PCMServiceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.pcmreResourceInterfaceEClass, PCMREResourceInterface.class, "PCMREResourceInterface",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMREResourceInterface_ResourceInterface(),
                theResourcetypePackage.getResourceInterface(), null, "resourceInterface", null, 1, 1,
                PCMREResourceInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmreResourceInterfaceEClass, this.ecorePackage.getEBoolean(),
                "NextLowerLevelMustConsistOfTypePCMREResourceRole", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreResourceInterfaceEClass, this.ecorePackage.getEBoolean(),
                "EachRETargetMustBeReferencedOnlyFromOneRE", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmreResourceSignatureEClass, PCMREResourceSignature.class, "PCMREResourceSignature",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMREResourceSignature_ResourceSignature(),
                theResourcetypePackage.getResourceSignature(), null, "resourceSignature", null, 1, 1,
                PCMREResourceSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmreResourceSignatureEClass, this.ecorePackage.getEBoolean(),
                "ThisIsTheLowestResourceHierarchyLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreResourceSignatureEClass, this.ecorePackage.getEBoolean(),
                "EachRETargetMustBeReferencedOnlyFromOneRE", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmreResourceEClass, PCMREResource.class, "PCMREResource", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMREResource_ProcessingResourceType(),
                theResourcetypePackage.getProcessingResourceType(), null, "processingResourceType", null, 1, 1,
                PCMREResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmreResourceEClass, this.ecorePackage.getEBoolean(),
                "ThisIsTheLowestResourceDemandHierarchyLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreResourceEClass, this.ecorePackage.getEBoolean(),
                "EachRETargetMustBeReferencedOnlyFromOneRE", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmreResourceRoleEClass, PCMREResourceRole.class, "PCMREResourceRole", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMREResourceRole_ResourceRole(), theEntityPackage.getResourceRequiredRole(), null,
                "resourceRole", null, 1, 1, PCMREResourceRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmreResourceRoleEClass, this.ecorePackage.getEBoolean(),
                "NextLowerLevelMustConsistOfTypePCMREResourceSignature", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreResourceRoleEClass, this.ecorePackage.getEBoolean(),
                "EachRETargetMustBeReferencedOnlyFromOneRE", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmreciBehaviorEClass, PCMRECIBehavior.class, "PCMRECIBehavior", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMRECIBehavior_InternalBehaviour(),
                theSeffPackage.getResourceDemandingInternalBehaviour(), null, "internalBehaviour", null, 1, 1,
                PCMRECIBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmreciBehaviorEClass, this.ecorePackage.getEBoolean(),
                "ThisIsTheLowestComponentInternalHierarchyLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreciBehaviorEClass, this.ecorePackage.getEBoolean(),
                "EachRETargetMustBeReferencedOnlyFromOneRE", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmreInfrastructureInterfaceEClass, PCMREInfrastructureInterface.class,
                "PCMREInfrastructureInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMREInfrastructureInterface_Interface(),
                theRepositoryPackage.getInfrastructureInterface(), null, "interface", null, 1, 1,
                PCMREInfrastructureInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmreInfrastructureInterfaceEClass, this.ecorePackage.getEBoolean(),
                "NextLowerLevelMustConsistOfTypePCMREInfrastructureRole", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreInfrastructureInterfaceEClass, this.ecorePackage.getEBoolean(),
                "EachRETargetMustBeReferencedOnlyFromOneRE", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmreInfrastructureRoleEClass, PCMREInfrastructureRole.class, "PCMREInfrastructureRole",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMREInfrastructureRole_Role(),
                theRepositoryPackage.getInfrastructureRequiredRole(), null, "role", null, 1, 1,
                PCMREInfrastructureRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmreInfrastructureRoleEClass, this.ecorePackage.getEBoolean(),
                "NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreInfrastructureRoleEClass, this.ecorePackage.getEBoolean(),
                "EachRETargetMustBeReferencedOnlyFromOneRE", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmreInfrastructureSignatureEClass, PCMREInfrastructureSignature.class,
                "PCMREInfrastructureSignature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMREInfrastructureSignature_Signature(),
                theRepositoryPackage.getInfrastructureSignature(), null, "signature", null, 1, 1,
                PCMREInfrastructureSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmreInfrastructureSignatureEClass, this.ecorePackage.getEBoolean(),
                "ThisIsTheLowestInfrastructureHierarchyLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = this.addEOperation(this.pcmreInfrastructureSignatureEClass, this.ecorePackage.getEBoolean(),
                "EachRETargetMustBeReferencedOnlyFromOneRE", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmpeEClass, de.fzi.se.quality.qualityannotation.PCMPE.class, "PCMPE", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        op = this.addEOperation(this.pcmpeEClass, this.ecorePackage.getEBoolean(),
                "TopmostLevelMustBePCMPEAllDecisions", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmpeAllDecisionsEClass, PCMPEAllDecisions.class, "PCMPEAllDecisions", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        op = this.addEOperation(this.pcmpeAllDecisionsEClass, this.ecorePackage.getEBoolean(),
                "NextLowerHierarchyLevelMustBeDecision", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        this.initEClass(this.pcmpeDecisionEClass, PCMPEDecision.class, "PCMPEDecision", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMPEDecision_BranchAction(), theSeffPackage.getBranchAction(), null,
                "branchAction", null, 1, 1, PCMPEDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        op = this.addEOperation(this.pcmpeDecisionEClass, this.ecorePackage.getEBoolean(),
                "ThisIsTheLowestDecisionHierarchyLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
        this.addEParameter(op, this.ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = this.createEGenericType(this.ecorePackage.getEMap());
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = this.createEGenericType(this.ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        this.addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

        // Initialize enums and add enum literals
        this.initEEnum(this.pcmreRequestCategoryEEnum, PCMRERequestCategory.class, "PCMRERequestCategory");
        this.addEEnumLiteral(this.pcmreRequestCategoryEEnum, PCMRERequestCategory.RESOURCE);
        this.addEEnumLiteral(this.pcmreRequestCategoryEEnum, PCMRERequestCategory.INFRASTRUCTURE);
        this.addEEnumLiteral(this.pcmreRequestCategoryEEnum, PCMRERequestCategory.COMPONENT);
        this.addEEnumLiteral(this.pcmreRequestCategoryEEnum, PCMRERequestCategory.RESOURCE_DEMAND);
        this.addEEnumLiteral(this.pcmreRequestCategoryEEnum, PCMRERequestCategory.COMPONENT_INTERNAL);
    }

} // QualityAnnotationPackageImpl
