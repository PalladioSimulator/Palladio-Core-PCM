package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.HashMap;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;

import de.fzi.se.quality.QualityPackage;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.transformations.ApplyConnectorCompletionsJob;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.oaw.XpandGeneratorJob;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadMiddlewareConfigurationIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Start the Workflow-Engine of oAW - Generator
 */
public class TransformPCMToCodeJob
extends SequentialBlackboardInteractingJob<MDSDBlackboard>
implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

    private static final String REPOSITORY_ROOT_EXPAND_EXPRESSION = "m2t_transforms::repository::Root FOR pcmmodel";
    private static final String SYSTEM_ROOT_EXPAND_EXPRESSION     = "m2t_transforms::system::Root FOR system";
    private static final String ALLOCATION_ROOT_EXPAND_EXPRESSION = "m2t_transforms::allocation::AllocationTM FOR allocation";
    private static final String USAGE_ROOT_EXPAND_EXPRESSION 	  = "m2t_transforms::usage::UsageModel(allocation) FOR usage";

    /** Name of the global variable used in the XPand generation to access the quality annotation repository. Used for accuracy influence analysis only. */
    private static final String GLOBAL_VARIABLE_NAME_QUALITY_ANNOTATION_REPOSITORY = "qualityAnnotationRepository";
    /** Name of the slot containing the model with the quality annotation repository. */
    private static final String SLOT_NAME_QUALITY_ANNOTATION_MODEL = "qualityannotationmodel";

    private AbstractCodeGenerationWorkflowRunConfiguration configuration = null;

    public TransformPCMToCodeJob(final AbstractCodeGenerationWorkflowRunConfiguration configuration) {
        super();

        this.configuration  = configuration;
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException,
    UserCanceledException {
        // First generate the jobs
        // 1. Generate all repositories
        // TODO Using this global var seems to be quite bad. Why not input that normally to the transformation? Also, the use of null is questionable. Check that.
        final GlobalVarDef[] globalVars = new GlobalVarDef[1];
        globalVars[0] = new GlobalVarDef();
        globalVars[0].setName(GLOBAL_VARIABLE_NAME_QUALITY_ANNOTATION_REPOSITORY);
        if (configuration.isAccuracyInfluenceAnalysisEnabled()) {
            globalVars[0].setValue(SLOT_NAME_QUALITY_ANNOTATION_MODEL);
        } else {
            globalVars[0].setValue("null");
        }

        for(int repositoryIndex = 0; repositoryIndex < getRepositoryCount(); repositoryIndex++) {
            this.addJob(this.getGeneratorJob(getRepositoryTransformationSlots(repositoryIndex), REPOSITORY_ROOT_EXPAND_EXPRESSION, globalVars));
        }

        if (configuration.isLoadMiddlewareAndCompletionFiles()) {
            this.addJob(this.getGeneratorJob(getMiddlewareRepositorySlots(), REPOSITORY_ROOT_EXPAND_EXPRESSION));
            this.addJob(this.getGeneratorJob(getCompletionRepositorySlots(), REPOSITORY_ROOT_EXPAND_EXPRESSION));
        }

        // 2. Generate the system
        this.addJob(this.getGeneratorJob(getSystemTransformationSlots(), SYSTEM_ROOT_EXPAND_EXPRESSION));

        // 3. Generate the allocation
        this.addJob(this.getGeneratorJob(getSystemTransformationSlots(), ALLOCATION_ROOT_EXPAND_EXPRESSION));

        // 4. Generate the usage
        this.addJob(this.getGeneratorJob(getSystemTransformationSlots(), USAGE_ROOT_EXPAND_EXPRESSION));

        // Now let them run
        super.execute(monitor);
    }

    private HashMap<String, Object> getCompletionRepositorySlots() {
        final HashMap<String,Object> sC2 = new HashMap<String, Object>();
        final ResourceSetPartition completionRepositoryPartition = this.myBlackboard.getPartition(ApplyConnectorCompletionsJob.COMPLETION_REPOSITORY_PARTITION);

        sC2.put("pcmmodel",completionRepositoryPartition.getResourceSet().getResources().get(0).getContents().get(0));

        return sC2;
    }

    private HashMap<String,Object> getMiddlewareRepositorySlots() {
        final HashMap<String,Object> sC2 = new HashMap<String, Object>();
        final ResourceSetPartition mwRepositoryPartition = this.myBlackboard.getPartition(LoadMiddlewareConfigurationIntoBlackboardJob.MIDDLEWARE_PARTITION_ID);

        sC2.put("pcmmodel",mwRepositoryPartition.getResourceSet().getResources().get(0).getContents().get(0));

        return sC2;
    }

    /**Creates an XPand generator job.
     * @param slots XPand slots and their content.
     * @param expression XPand expression starting the generation.
     * @param globalVarDefs Global variables used in the generation.
     */
    private XpandGeneratorJob getGeneratorJob(
            final HashMap<String, Object> slots,
            final String expression, final GlobalVarDef[] globalVarDefs) {
        // add accuracy EMF packages to transformation
        final EPackage[] pcmAndAccuracyPackages = new EPackage[AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES.length + 3];
        System.arraycopy(AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES, 0, pcmAndAccuracyPackages, 0, AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES.length);
        pcmAndAccuracyPackages[pcmAndAccuracyPackages.length-4] = QualityPackage.eINSTANCE;
        pcmAndAccuracyPackages[pcmAndAccuracyPackages.length-3] = QualityAnnotationPackage.eINSTANCE;
        pcmAndAccuracyPackages[pcmAndAccuracyPackages.length-2] = ParametersPackage.eINSTANCE;
        pcmAndAccuracyPackages[pcmAndAccuracyPackages.length-1] = PCMPackage.eINSTANCE;
        // create job
        final XpandGeneratorJob job = new XpandGeneratorJob(
                slots,
                pcmAndAccuracyPackages,
                getPCMOutlets(),
                expression, globalVarDefs);
        job.getAdvices().add(configuration.getCodeGenerationAdvicesFile());
        for (final String advice : configuration.getCodeGenerationAdvices()) {
            job.getAdvices().add(advice);
        }
        job.setCheckProtectedRegions(true);

        return job;
    }

    /**Creates an XPand generator job without global variables.
     * @param slots XPand slots and their content.
     * @param expression XPand expression starting the generation.
     */
    private XpandGeneratorJob getGeneratorJob(
            final HashMap<String, Object> slots,
            final String expression) {
        return getGeneratorJob(slots, expression, null);
    }

    /**
     * @return
     */
    private Outlet[] getPCMOutlets() {
        final Outlet defaultOutlet = new Outlet(getBasePath());
        final Outlet interfaces = new Outlet(getBasePath());
        interfaces.setName("INTERFACES");

        return new Outlet[]{defaultOutlet,interfaces};
    }

    /**
     * @return
     */
    private HashMap<String, Object> getSystemTransformationSlots() {
        final HashMap<String,Object> sC2 = new HashMap<String, Object>();
        final PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.myBlackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);

        sC2.put("middleware",pcmPartition.getMiddlewareRepository());
        if (configuration.isLoadMiddlewareAndCompletionFiles()) {
            sC2.put("featureConfig",pcmPartition.getFeatureConfig());
        }
        sC2.put("system",pcmPartition.getSystem());
        sC2.put("allocation",pcmPartition.getAllocation());
        sC2.put("usage",pcmPartition.getUsageModel());
        return sC2;
    }

    /**
     * @return Creates a HashMap with all slots required for the transformation of {@link Repository}.
     */
    private HashMap<String, Object> getRepositoryTransformationSlots(final int repositoryIndex) {
        final HashMap<String,Object> sC2 = new HashMap<String, Object>();
        final PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.myBlackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
        sC2.put("pcmmodel",pcmPartition.getRepositories().get(repositoryIndex));
        if (configuration.isAccuracyInfluenceAnalysisEnabled()) {
            sC2.put(SLOT_NAME_QUALITY_ANNOTATION_MODEL, pcmPartition.getElement(QualityPackage.eINSTANCE.getQualityRepository()).get(0));
        }
        return sC2;
    }

    /**
     * @return
     */
    private int getRepositoryCount() {
        final PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.myBlackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
        return pcmPartition.getRepositories().size();
    }

    private String getBasePath() {
        final String basePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString()
                + "/" + this.configuration.getStoragePluginID() + "/" + "src";

        return basePath;
    }

    @Override
    public String getName() {
        return "Generate SimuCom Plugin Code";
    }
}