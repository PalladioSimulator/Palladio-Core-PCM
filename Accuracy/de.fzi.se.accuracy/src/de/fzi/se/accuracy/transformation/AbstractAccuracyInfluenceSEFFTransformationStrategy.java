/**
 *
 */
package de.fzi.se.accuracy.transformation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.fzi.se.accuracy.issues.AccuracyIssueFactory;
import de.fzi.se.accuracy.jobs.TransformPCMForAccuracyInfluenceAnalysisJob;
import de.fzi.se.quality.QualityPackage;
import de.fzi.se.quality.QualityRepository;
import de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision;
import de.fzi.se.quality.qualityannotation.PCMRECategory;
import de.fzi.se.quality.qualityannotation.PCMRERequestCategory;
import de.fzi.se.quality.qualityannotation.PCMServiceSpecification;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationFactory;
import de.fzi.se.quality.qualityannotation.REPrecision;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.fzi.se.quality.util.EMFHelper;
import de.fzi.se.quality.util.QualityAnnotationLookup;
import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.errorhandling.SeverityEnum;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.InternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingInternalBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.runconfig.AccuracyInfluenceAnalysisState;

/**
 * Abstract strategy implementing the transformation of given SEFFs for states
 * in {@link AccuracyInfluenceAnalysisState}. Start the transformation by
 * invoking {@link #doSwitch(org.eclipse.emf.ecore.EObject)} with a parameter of
 * type {@link ServiceEffectSpecification}. Subclasses must provide an
 * implementation for the abstract methods. Overwriting methods defined in this
 * class is discouraged and may lead to unexpected behavior.
 *
 * @author groenda
 */
public abstract class AbstractAccuracyInfluenceSEFFTransformationStrategy extends
SeffSwitch<Boolean> {
    /** Logger for this class. */
    private static final Logger LOGGER = Logger
            .getLogger(AbstractAccuracyInfluenceSEFFTransformationStrategy.class);

    /** List of available quality annotations. */
    private final List<QualityAnnotation> availableQualityAnnotations;
    /**
     * Lookup-Helper for the quality annotation corresponding to the currently
     * processed SEFF.
     */
    private QualityAnnotationLookup correspondingQualityLookup;

    /** List of warning and errors. */
    private final List<SeverityAndIssue> issues;

    /**Create a new instance.
     * @param pcmPartition Partition containing quality annotations.
     */
    public AbstractAccuracyInfluenceSEFFTransformationStrategy(
            final PCMResourceSetPartition pcmPartition) {
        this.availableQualityAnnotations = getQualityAnnotations(pcmPartition);
        correspondingQualityLookup = null;
        issues = new ArrayList<SeverityAndIssue>();
    }

    /**
     * @return Gets the list of warning and errors.
     */
    public List<SeverityAndIssue> getIssues() {
        return issues;
    }

    // START SECTION SUB-BEHAVIOR
    @Override
    public Boolean caseResourceDemandingSEFF(final ResourceDemandingSEFF object) {
        // determine accuracy
        QualityAnnotation correspondingQuality = getQualityAnnotation(object,
                availableQualityAnnotations);
        if (correspondingQuality == null) {
            issues.add(AccuracyIssueFactory.createMissingQualityAnnotationIssue(object));
            correspondingQuality = createQualityExactlyAsSpecifiedPrecision();
        } else if (correspondingQuality.isValid() == false) {
            issues.add(AccuracyIssueFactory.createInvalidQualityAnnotationIssue(object));
            correspondingQuality = createQualityExactlyAsSpecifiedPrecision();
        }
        correspondingQualityLookup = new QualityAnnotationLookup(
                correspondingQuality);
        // process resource demanding internal behaviors
        for (final ResourceDemandingInternalBehaviour rdib : object
                .getResourceDemandingInternalBehaviours()) {
            doSwitch(rdib);
        }
        // process self
        return caseResourceDemandingBehaviour(object);
    }

    /**Creates a quality annotation with default REPrecisions for all categories of {@link ExactlyAsSpecifiedPrecision}.
     * @return Quality annotation.
     */
    private QualityAnnotation createQualityExactlyAsSpecifiedPrecision() {
        QualityAnnotation correspondingQuality;
        // assume ExatlyAsSpecifiedPrecision
        correspondingQuality = QualityAnnotationFactory.eINSTANCE.createQualityAnnotation();
        correspondingQuality.setIsValid(true);
        correspondingQuality.getStipulatedREPrecisions().add(createREPrecisionExactlyAsSpecified(PCMRERequestCategory.COMPONENT));
        correspondingQuality.getStipulatedREPrecisions().add(createREPrecisionExactlyAsSpecified(PCMRERequestCategory.COMPONENT_INTERNAL));
        correspondingQuality.getStipulatedREPrecisions().add(createREPrecisionExactlyAsSpecified(PCMRERequestCategory.INFRASTRUCTURE));
        correspondingQuality.getStipulatedREPrecisions().add(createREPrecisionExactlyAsSpecified(PCMRERequestCategory.RESOURCE));
        correspondingQuality.getStipulatedREPrecisions().add(createREPrecisionExactlyAsSpecified(PCMRERequestCategory.RESOURCE_DEMAND));
        return correspondingQuality;
    }

    /**Creates a required element with default precision for a given category with {@link ExactlyAsSpecifiedPrecision}.
     * @param category Category.
     * @return Required element.
     */
    private RequiredElement createREPrecisionExactlyAsSpecified(
            final PCMRERequestCategory category) {
        final PCMRECategory re = QualityAnnotationFactory.eINSTANCE.createPCMRECategory();
        re.setCategory(category);
        final REPrecision precision = QualityAnnotationFactory.eINSTANCE.createREPrecision();
        precision.setDefaultPrecisionNumberOfCalls(QualityAnnotationFactory.eINSTANCE.createExactlyAsSpecifiedPrecision());
        if (category == PCMRERequestCategory.RESOURCE_DEMAND) {
            // Resource demand does not have any parameters
            precision.setDefaultPrecisionCallParameter(QualityAnnotationFactory.eINSTANCE.createNoPrecision());
        } else {
            precision.setDefaultPrecisionCallParameter(QualityAnnotationFactory.eINSTANCE.createExactlyAsSpecifiedPrecision());
        }
        re.setPrecision(precision);
        return re;
    }

    @Override
    public Boolean caseResourceDemandingBehaviour(
            final ResourceDemandingBehaviour object) {
        final List<AbstractAction> steps = object.getSteps_Behaviour();
        final StartAction start = EMFHelper.getFirstObjectByType(steps,
                StartAction.class);
        doSwitch(start);
        return true;
    }

    @Override
    public Boolean caseBranchAction(final BranchAction object) {
        for (final AbstractBranchTransition abt : object.getBranches_Branch()) {
            doSwitch(abt.getBranchBehaviour_BranchTransition());
        }
        // continue processing
        return caseAbstractInternalControlFlowAction(object);
    }

    @Override
    public Boolean caseAbstractLoopAction(final AbstractLoopAction object) {
        doSwitch(object.getBodyBehaviour_Loop());
        // continue processing with caseAbstractAction
        return caseAbstractAction(object);
    }

    @Override
    public Boolean caseForkAction(final ForkAction object) {
        doSwitch(object.getResourceDemandingBehaviour_AbstractAction());
        // continue processing
        return caseAbstractInternalControlFlowAction(object);
    }

    // Note: RecoveryBlockActions and RecoveryBlockAlternativeBehaviour are part
    // of seff_reliability and not handled.
    // END SECTION SUB-BEHAVIOR

    @Override
    public Boolean caseServiceEffectSpecification(
            final ServiceEffectSpecification object) {
        correspondingQualityLookup = null;
        final String msg = "The provided ServiceEffectSpecification type " + object + " is not supported by the implementation.";
        LOGGER.error(msg);
        issues.add(new SeverityAndIssue(SeverityEnum.ERROR, msg, object));
        return true;
    }

    /**
     * @return Returns all quality annotations in the PCM partition.
     */
    public List<QualityAnnotation> getQualityAnnotations(
            final PCMResourceSetPartition pcmPartition) {
        final List<QualityAnnotation> qualityAnnotations = new ArrayList<QualityAnnotation>();
        final List<QualityRepository> qualityRepos = pcmPartition
                .getElement(QualityPackage.eINSTANCE
                        .getQualityRepository());
        for (final QualityRepository qualityRepository : qualityRepos) {
            TransformPCMForAccuracyInfluenceAnalysisJob.addElementsToList(
                    qualityAnnotations, EMFHelper.getObjectsByType(qualityRepository.getQualityStatements(), QualityAnnotation.class));
        }
        return qualityAnnotations;
    }

    /**
     * Gets the quality annotation for a given RDSEFF from a list of
     * annotations.
     *
     * @param rdseff
     *            The RDSEFF.
     * @param qas
     *            The list of annotations.
     * @return The quality annotation or {@code null} if none was found.
     */
    public QualityAnnotation getQualityAnnotation(
            final ResourceDemandingSEFF rdseff,
            final List<QualityAnnotation> qas) {
        int found = 0;
        QualityAnnotation returnedAnnotation = null;
        for (final QualityAnnotation qualityAnnotation : qas) {
            if (qualityAnnotation.getForServiceSpecification() instanceof PCMServiceSpecification) {
                if (((PCMServiceSpecification) qualityAnnotation
                        .getForServiceSpecification())
                        .getResourceDemandingSEFF() == rdseff) {
                    found++;
                    returnedAnnotation = qualityAnnotation;
                }
            }
        }
        if (found > 1) {
            final String msg = "There was more than one quality annotation for the RDSEFF with id "
                    + rdseff.getId()
                    + "in basic component "
                    + rdseff.getBasicComponent_ServiceEffectSpecification()
                    .getEntityName()
                    + " with id "
                    + rdseff.getBasicComponent_ServiceEffectSpecification()
                    .getId()
                    + ". The correct one could not be identified. The annotation with id " + returnedAnnotation.getId() + " is used.";
            LOGGER.warn(msg);
            issues.add(new SeverityAndIssue(SeverityEnum.WARNING, msg, rdseff));
        }
        return returnedAnnotation;
    }

    @Override
    public Boolean caseAbstractAction(final AbstractAction object) {
        // process successor relation of actions
        if (object.getSuccessor_AbstractAction() != null) {
            return doSwitch(object.getSuccessor_AbstractAction());
        } else {
            return true;
        }
    }

    // START SECTION MODIFICATION

    @Override
    public Boolean caseAbstractInternalControlFlowAction(
            final AbstractInternalControlFlowAction object) {
        // handle infrastructure calls
        REPrecision precision;
        for (final InfrastructureCall infrastructureCall : object
                .getInfrastructureCall__Action()) {
            precision = correspondingQualityLookup.getPCMREPrecision(
                    infrastructureCall
                    .getSignature__InfrastructureCall(),
                    infrastructureCall
                    .getRequiredRole__InfrastructureCall());
            ensurePrecisionExists(precision);
            modifyInfrastructureCall(infrastructureCall, precision);
        }
        // handle explicit resource calls
        for (final ResourceCall resourceCall : object.getResourceCall__Action()) {
            precision = correspondingQualityLookup
                    .getPCMREPrecision(resourceCall
                            .getSignature__ResourceCall(), resourceCall
                            .getResourceRequiredRole__ResourceCall());
            ensurePrecisionExists(precision);
            modifyResourceCall(resourceCall, precision);
        }
        // handle implicit resource calls
        for (final ParametricResourceDemand demand : object
                .getResourceDemand_Action()) {
            precision = correspondingQualityLookup
                    .getPCMREPrecisionCategoryResourceDemand();
            ensurePrecisionExists(precision);
            modifyResourceDemand(demand, precision);
        }
        // continue processing with caseAbstractAction
        return caseAbstractAction(object);
    }

    @Override
    public Boolean caseExternalCallAction(final ExternalCallAction object) {
        final REPrecision precision = correspondingQualityLookup
                .getPCMREPrecision(object.getCalledService_ExternalService(),
                        object.getRole_ExternalService());
        ensurePrecisionExists(precision);
        modifyComponentExternalCall(object, precision);
        // continue processing
        return caseAbstractAction(object);
    }

    @Override
    public Boolean caseInternalCallAction(final InternalCallAction object) {
        final REPrecision precision = correspondingQualityLookup
                .getPCMREPrecisionCategoryComponentInternal();
        ensurePrecisionExists(precision);
        modifyComponentInternalCall(object, precision);
        // continue processing
        return caseAbstractInternalControlFlowAction(object);
    }

    /**Ensures that a precision exists.
     * @param precision The precision.
     */
    private void ensurePrecisionExists(final REPrecision precision) {
        if (precision == null) {
            final String msg = "Could not determine a precision for the SEFF. Make sure a quality annotation exists for each SEFF of the system and that a precision is provided at least for each category.";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
    }

    // END SECTION MODIFICATION

    /**
     * Implementation of modification strategy for infrastructure calls.
     *
     * @param call
     *            Infrastructure call.
     * @param precision
     *            Stated accuracy.
     */
    protected abstract void modifyInfrastructureCall(InfrastructureCall call,
            REPrecision precision);

    /**
     * Implementation of modification strategy for resource calls.
     *
     * @param call
     *            Infrastructure call.
     * @param precision
     *            Stated accuracy.
     */
    protected abstract void modifyResourceCall(ResourceCall call,
            REPrecision precision);

    /**
     * Implementation of modification strategy for (implicit) resource demands.
     *
     * @param call
     *            Infrastructure call.
     * @param precision
     *            Stated accuracy.
     */
    protected abstract void modifyResourceDemand(
            ParametricResourceDemand demand, REPrecision precision);

    /**
     * Implementation of modification strategy for (implicit) resource demands.
     *
     * @param call
     *            Infrastructure call.
     * @param precision
     *            Stated accuracy.
     */
    protected abstract void modifyComponentInternalCall(
            InternalCallAction call, REPrecision precision);

    /**
     * Implementation of modification strategy for (implicit) resource demands.
     *
     * @param call
     *            Infrastructure call.
     * @param precision
     *            Stated accuracy.
     */
    protected abstract void modifyComponentExternalCall(
            ExternalCallAction call, REPrecision precision);
}
