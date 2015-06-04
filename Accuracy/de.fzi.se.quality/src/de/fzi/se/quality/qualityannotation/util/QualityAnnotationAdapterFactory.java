/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.mdsdprofiles.StereotypableElement;

import de.fzi.se.quality.QualityStatement;
import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange;
import de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision;
import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision;
import de.fzi.se.quality.qualityannotation.NoPrecision;
import de.fzi.se.quality.qualityannotation.PCMPE;
import de.fzi.se.quality.qualityannotation.PCMPEAllDecisions;
import de.fzi.se.quality.qualityannotation.PCMPEDecision;
import de.fzi.se.quality.qualityannotation.PCMParameterPartition;
import de.fzi.se.quality.qualityannotation.PCMRE;
import de.fzi.se.quality.qualityannotation.PCMRECIBehavior;
import de.fzi.se.quality.qualityannotation.PCMRECategory;
import de.fzi.se.quality.qualityannotation.PCMREInfrastructureInterface;
import de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole;
import de.fzi.se.quality.qualityannotation.PCMREInfrastructureSignature;
import de.fzi.se.quality.qualityannotation.PCMREInterface;
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
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.REPrecision;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.fzi.se.quality.qualityannotation.RequiredElementDeviation;
import de.fzi.se.quality.qualityannotation.ServiceSpecification;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage
 * @generated
 */
public class QualityAnnotationAdapterFactory extends AdapterFactoryImpl {

    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static QualityAnnotationPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public QualityAnnotationAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = QualityAnnotationPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
     * --> This implementation returns <code>true</code> if the object is either the model's package
     * or is an instance object of the model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected QualityAnnotationSwitch<Adapter> modelSwitch = new QualityAnnotationSwitch<Adapter>() {

        @Override
        public Adapter caseParameterValueDeviation(final ParameterValueDeviation object) {
            return QualityAnnotationAdapterFactory.this.createParameterValueDeviationAdapter();
        }

        @Override
        public Adapter caseQualityAnnotation(final QualityAnnotation object) {
            return QualityAnnotationAdapterFactory.this.createQualityAnnotationAdapter();
        }

        @Override
        public Adapter caseServiceSpecification(final ServiceSpecification object) {
            return QualityAnnotationAdapterFactory.this.createServiceSpecificationAdapter();
        }

        @Override
        public Adapter caseRequiredElement(final RequiredElement object) {
            return QualityAnnotationAdapterFactory.this.createRequiredElementAdapter();
        }

        @Override
        public Adapter caseRequiredElementDeviation(final RequiredElementDeviation object) {
            return QualityAnnotationAdapterFactory.this.createRequiredElementDeviationAdapter();
        }

        @Override
        public Adapter caseInternalStateInfluenceAnalysisAggregation(
                final InternalStateInfluenceAnalysisAggregation object) {
            return QualityAnnotationAdapterFactory.this.createInternalStateInfluenceAnalysisAggregationAdapter();
        }

        @Override
        public Adapter casePrecision(final Precision object) {
            return QualityAnnotationAdapterFactory.this.createPrecisionAdapter();
        }

        @Override
        public Adapter caseREPrecision(final REPrecision object) {
            return QualityAnnotationAdapterFactory.this.createREPrecisionAdapter();
        }

        @Override
        public Adapter caseProbabilisticElement(final ProbabilisticElement object) {
            return QualityAnnotationAdapterFactory.this.createProbabilisticElementAdapter();
        }

        @Override
        public Adapter caseCharacterisedPCMParameterPartition(final CharacterisedPCMParameterPartition object) {
            return QualityAnnotationAdapterFactory.this.createCharacterisedPCMParameterPartitionAdapter();
        }

        @Override
        public Adapter casePCMParameterPartition(final PCMParameterPartition object) {
            return QualityAnnotationAdapterFactory.this.createPCMParameterPartitionAdapter();
        }

        @Override
        public Adapter caseCharacterisedPCMParameterPartitionInterval(
                final CharacterisedPCMParameterPartitionInterval object) {
            return QualityAnnotationAdapterFactory.this.createCharacterisedPCMParameterPartitionIntervalAdapter();
        }

        @Override
        public Adapter caseCharacterisedPCMParameterPartitionRange(final CharacterisedPCMParameterPartitionRange object) {
            return QualityAnnotationAdapterFactory.this.createCharacterisedPCMParameterPartitionRangeAdapter();
        }

        @Override
        public Adapter caseExactlyAsSpecifiedPrecision(final ExactlyAsSpecifiedPrecision object) {
            return QualityAnnotationAdapterFactory.this.createExactlyAsSpecifiedPrecisionAdapter();
        }

        @Override
        public Adapter caseLimitedDeviationPrecision(final LimitedDeviationPrecision object) {
            return QualityAnnotationAdapterFactory.this.createLimitedDeviationPrecisionAdapter();
        }

        @Override
        public Adapter caseNoPrecision(final NoPrecision object) {
            return QualityAnnotationAdapterFactory.this.createNoPrecisionAdapter();
        }

        @Override
        public Adapter casePCMRECategory(final PCMRECategory object) {
            return QualityAnnotationAdapterFactory.this.createPCMRECategoryAdapter();
        }

        @Override
        public Adapter casePCMRE(final PCMRE object) {
            return QualityAnnotationAdapterFactory.this.createPCMREAdapter();
        }

        @Override
        public Adapter casePCMREInterface(final PCMREInterface object) {
            return QualityAnnotationAdapterFactory.this.createPCMREInterfaceAdapter();
        }

        @Override
        public Adapter casePCMRERole(final PCMRERole object) {
            return QualityAnnotationAdapterFactory.this.createPCMRERoleAdapter();
        }

        @Override
        public Adapter casePCMRESignature(final PCMRESignature object) {
            return QualityAnnotationAdapterFactory.this.createPCMRESignatureAdapter();
        }

        @Override
        public Adapter casePCMServiceSpecification(final PCMServiceSpecification object) {
            return QualityAnnotationAdapterFactory.this.createPCMServiceSpecificationAdapter();
        }

        @Override
        public Adapter casePCMREResourceInterface(final PCMREResourceInterface object) {
            return QualityAnnotationAdapterFactory.this.createPCMREResourceInterfaceAdapter();
        }

        @Override
        public Adapter casePCMREResourceSignature(final PCMREResourceSignature object) {
            return QualityAnnotationAdapterFactory.this.createPCMREResourceSignatureAdapter();
        }

        @Override
        public Adapter casePCMREResource(final PCMREResource object) {
            return QualityAnnotationAdapterFactory.this.createPCMREResourceAdapter();
        }

        @Override
        public Adapter casePCMREResourceRole(final PCMREResourceRole object) {
            return QualityAnnotationAdapterFactory.this.createPCMREResourceRoleAdapter();
        }

        @Override
        public Adapter casePCMRECIBehavior(final PCMRECIBehavior object) {
            return QualityAnnotationAdapterFactory.this.createPCMRECIBehaviorAdapter();
        }

        @Override
        public Adapter casePCMREInfrastructureInterface(final PCMREInfrastructureInterface object) {
            return QualityAnnotationAdapterFactory.this.createPCMREInfrastructureInterfaceAdapter();
        }

        @Override
        public Adapter casePCMREInfrastructureRole(final PCMREInfrastructureRole object) {
            return QualityAnnotationAdapterFactory.this.createPCMREInfrastructureRoleAdapter();
        }

        @Override
        public Adapter casePCMREInfrastructureSignature(final PCMREInfrastructureSignature object) {
            return QualityAnnotationAdapterFactory.this.createPCMREInfrastructureSignatureAdapter();
        }

        @Override
        public Adapter casePCMPE(final PCMPE object) {
            return QualityAnnotationAdapterFactory.this.createPCMPEAdapter();
        }

        @Override
        public Adapter casePCMPEAllDecisions(final PCMPEAllDecisions object) {
            return QualityAnnotationAdapterFactory.this.createPCMPEAllDecisionsAdapter();
        }

        @Override
        public Adapter casePCMPEDecision(final PCMPEDecision object) {
            return QualityAnnotationAdapterFactory.this.createPCMPEDecisionAdapter();
        }

        @Override
        public Adapter caseStereotypableElement(final StereotypableElement object) {
            return QualityAnnotationAdapterFactory.this.createStereotypableElementAdapter();
        }

        @Override
        public Adapter caseIdentifier(final Identifier object) {
            return QualityAnnotationAdapterFactory.this.createIdentifierAdapter();
        }

        @Override
        public Adapter caseQualityStatement(final QualityStatement object) {
            return QualityAnnotationAdapterFactory.this.createQualityStatementAdapter();
        }

        @Override
        public Adapter caseParameterPartition(final ParameterPartition object) {
            return QualityAnnotationAdapterFactory.this.createParameterPartitionAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return QualityAnnotationAdapterFactory.this.createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(final Notifier target) {
        return this.modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.ParameterValueDeviation
     * <em>Parameter Value Deviation</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.ParameterValueDeviation
     * @generated
     */
    public Adapter createParameterValueDeviationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.QualityAnnotation <em>Quality Annotation</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotation
     * @generated
     */
    public Adapter createQualityAnnotationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.ServiceSpecification
     * <em>Service Specification</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.ServiceSpecification
     * @generated
     */
    public Adapter createServiceSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.RequiredElement <em>Required Element</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.RequiredElement
     * @generated
     */
    public Adapter createRequiredElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation
     * <em>Required Element Deviation</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.RequiredElementDeviation
     * @generated
     */
    public Adapter createRequiredElementDeviationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation
     * <em>Internal State Influence Analysis Aggregation</em>}'. <!-- begin-user-doc --> This
     * default implementation returns null so that we can easily ignore cases; it's useful to ignore
     * a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation
     * @generated
     */
    public Adapter createInternalStateInfluenceAnalysisAggregationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.REPrecision <em>RE Precision</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.REPrecision
     * @generated
     */
    public Adapter createREPrecisionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.ProbabilisticElement
     * <em>Probabilistic Element</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.ProbabilisticElement
     * @generated
     */
    public Adapter createProbabilisticElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.Precision <em>Precision</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.Precision
     * @generated
     */
    public Adapter createPrecisionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMParameterPartition
     * <em>PCM Parameter Partition</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMParameterPartition
     * @generated
     */
    public Adapter createPCMParameterPartitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition
     * <em>Characterised PCM Parameter Partition</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition
     * @generated
     */
    public Adapter createCharacterisedPCMParameterPartitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval
     * <em>Characterised PCM Parameter Partition Interval</em>}'. <!-- begin-user-doc --> This
     * default implementation returns null so that we can easily ignore cases; it's useful to ignore
     * a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval
     * @generated
     */
    public Adapter createCharacterisedPCMParameterPartitionIntervalAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange
     * <em>Characterised PCM Parameter Partition Range</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange
     * @generated
     */
    public Adapter createCharacterisedPCMParameterPartitionRangeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision
     * <em>Exactly As Specified Precision</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision
     * @generated
     */
    public Adapter createExactlyAsSpecifiedPrecisionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision
     * <em>Limited Deviation Precision</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision
     * @generated
     */
    public Adapter createLimitedDeviationPrecisionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.NoPrecision <em>No Precision</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.NoPrecision
     * @generated
     */
    public Adapter createNoPrecisionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMRECategory <em>PCMRE Category</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMRECategory
     * @generated
     */
    public Adapter createPCMRECategoryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMRE <em>PCMRE</em>}'. <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMRE
     * @generated
     */
    public Adapter createPCMREAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMREInterface <em>PCMRE Interface</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMREInterface
     * @generated
     */
    public Adapter createPCMREInterfaceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMRERole <em>PCMRE Role</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMRERole
     * @generated
     */
    public Adapter createPCMRERoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMRESignature <em>PCMRE Signature</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMRESignature
     * @generated
     */
    public Adapter createPCMRESignatureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMServiceSpecification
     * <em>PCM Service Specification</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMServiceSpecification
     * @generated
     */
    public Adapter createPCMServiceSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMREResourceInterface
     * <em>PCMRE Resource Interface</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMREResourceInterface
     * @generated
     */
    public Adapter createPCMREResourceInterfaceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMREResourceSignature
     * <em>PCMRE Resource Signature</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMREResourceSignature
     * @generated
     */
    public Adapter createPCMREResourceSignatureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMREResource <em>PCMRE Resource</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMREResource
     * @generated
     */
    public Adapter createPCMREResourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMREResourceRole <em>PCMRE Resource Role</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMREResourceRole
     * @generated
     */
    public Adapter createPCMREResourceRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMRECIBehavior <em>PCMRECI Behavior</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMRECIBehavior
     * @generated
     */
    public Adapter createPCMRECIBehaviorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureInterface
     * <em>PCMRE Infrastructure Interface</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMREInfrastructureInterface
     * @generated
     */
    public Adapter createPCMREInfrastructureInterfaceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole
     * <em>PCMRE Infrastructure Role</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole
     * @generated
     */
    public Adapter createPCMREInfrastructureRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureSignature
     * <em>PCMRE Infrastructure Signature</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMREInfrastructureSignature
     * @generated
     */
    public Adapter createPCMREInfrastructureSignatureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMPE <em>PCMPE</em>}'. <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMPE
     * @generated
     */
    public Adapter createPCMPEAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMPEAllDecisions <em>PCMPE All Decisions</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMPEAllDecisions
     * @generated
     */
    public Adapter createPCMPEAllDecisionsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.qualityannotation.PCMPEDecision <em>PCMPE Decision</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.qualityannotation.PCMPEDecision
     * @generated
     */
    public Adapter createPCMPEDecisionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.mdsdprofiles.StereotypableElement
     * <em>Stereotypable Element</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.palladiosimulator.mdsdprofiles.StereotypableElement
     * @generated
     */
    public Adapter createStereotypableElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier
     * <em>Identifier</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.identifier.Identifier
     * @generated
     */
    public Adapter createIdentifierAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.se.quality.QualityStatement
     * <em>Statement</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.fzi.se.quality.QualityStatement
     * @generated
     */
    public Adapter createQualityStatementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.se.quality.parameters.ParameterPartition <em>Parameter Partition</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.se.quality.parameters.ParameterPartition
     * @generated
     */
    public Adapter createParameterPartitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // QualityAnnotationAdapterFactory
