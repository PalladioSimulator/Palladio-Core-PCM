package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.emf.mwe2.runtime.workflow.Workflow;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;

import com.google.inject.Injector;

import de.fzi.se.quality.QualityFactory;
import de.fzi.se.quality.QualityRepository;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.xtendworkflow.AllocationWorkflowComponent;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.xtendworkflow.SystemWorkflowComponent;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.xtendworkflow.UsageModelWorkflowComponent;
import de.uka.ipd.sdq.pcm.codegen.simucom.guice.SimuComModule;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.RepositoryXpt;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim.SimAccuracyInfluenceExt;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.transformations.ApplyConnectorCompletionsJob;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadMiddlewareConfigurationIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Start the Workflow-Engine of oAW - Generator
 */
public class XtendTransformPCMToCodeJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> implements IJob,
        IBlackboardInteractingJob<MDSDBlackboard> {

    /**
     * Name of the global variable used in the XPand generation to access the quality annotation
     * repository. Used for accuracy influence analysis only.
     */
    private static final String GLOBAL_VARIABLE_NAME_QUALITY_ANNOTATION_REPOSITORY = "qualityAnnotationRepository";
    /**
     * Name of the slot containing the model with the quality annotation repository.
     */
    private static final String SLOT_NAME_QUALITY_ANNOTATION_MODEL = "qualityannotationmodel";

    private AbstractCodeGenerationWorkflowRunConfiguration configuration = null;

    public XtendTransformPCMToCodeJob(AbstractCodeGenerationWorkflowRunConfiguration configuration) {
        super();

        this.configuration = configuration;
    }

    public void cleanup(IProgressMonitor monitr) throws CleanupFailedException {
        // do nothing
    }

    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {

        Workflow workflow = new Workflow();

        Injector guiceInjector = SimuComModule.getInjector(getBasePath());
        final RepositoryXpt repositoryXpt = guiceInjector.getInstance(RepositoryXpt.class);
        final SimAccuracyInfluenceExt accuracyInfluenceExt = guiceInjector.getInstance(SimAccuracyInfluenceExt.class);

        final Map<String, Object> systemTransformationSlots = getSystemTransformationSlots();
        // 1. Generate all repositories
        // private static final String REPOSITORY_ROOT_EXPAND_EXPRESSION =
        // "m2t_transforms::repository::Root FOR pcmmodel";

        final GlobalVarDef[] globalVars = new GlobalVarDef[1];
        globalVars[0] = new GlobalVarDef();
        globalVars[0].setName(GLOBAL_VARIABLE_NAME_QUALITY_ANNOTATION_REPOSITORY);
        if (configuration.isAccuracyInfluenceAnalysisEnabled()) {
            globalVars[0].setValue(SLOT_NAME_QUALITY_ANNOTATION_MODEL);
        } else {
            globalVars[0].setValue("null");
        }

        for (int repositoryIndex = 0; repositoryIndex < getRepositoryCount(); repositoryIndex++) {
            final Map<String, Object> currentRepositorySlot = getRepositoryTransformationSlots(repositoryIndex);
            final Repository repository = (Repository) currentRepositorySlot.get("pcmmodel");

            if (configuration.isAccuracyInfluenceAnalysisEnabled()) {
                workflow.addComponent(new IWorkflowComponent() {
                    @Override
                    public void preInvoke() {
                    }

                    @Override
                    public void postInvoke() {
                    }

                    @Override
                    public void invoke(IWorkflowContext ctx) {
                        accuracyInfluenceExt.setQualityAnnotationRepository((QualityRepository) currentRepositorySlot
                                .get(SLOT_NAME_QUALITY_ANNOTATION_MODEL));
                        repositoryXpt.root(repository);
                    }
                });
            } else {
                workflow.addComponent(new IWorkflowComponent() {
                    @Override
                    public void preInvoke() {
                    }

                    @Override
                    public void postInvoke() {
                    }

                    @Override
                    public void invoke(IWorkflowContext ctx) {
                        repositoryXpt.root(repository);
                    }
                });
            }
        }

        if (configuration.isLoadMiddlewareAndCompletionFiles()) {
            final Repository middlewareRepository = (Repository) getMiddlewareRepositorySlots().get("pcmmodel");
            final Repository completionRepository = (Repository) getCompletionRepositorySlots().get("pcmmodel");
            workflow.addComponent(new IWorkflowComponent() {
                @Override
                public void preInvoke() {
                }

                @Override
                public void postInvoke() {
                }

                @Override
                public void invoke(IWorkflowContext ctx) {
                    repositoryXpt.root(middlewareRepository);
                }
            });
            workflow.addComponent(new IWorkflowComponent() {
                @Override
                public void preInvoke() {
                }

                @Override
                public void postInvoke() {
                }

                @Override
                public void invoke(IWorkflowContext ctx) {
                    repositoryXpt.root(completionRepository);
                }
            });
        }

        // 2. Generate the system
        // private static final String SYSTEM_ROOT_EXPAND_EXPRESSION =
        // "m2t_transforms::system::Root FOR system";
        workflow.addComponent(new SystemWorkflowComponent(systemTransformationSlots, getBasePath()));

        // 3. Generate the allocation
        // private static final String ALLOCATION_ROOT_EXPAND_EXPRESSION =
        // "m2t_transforms::allocation::AllocationTM FOR allocation";
        workflow.addComponent(new AllocationWorkflowComponent(systemTransformationSlots, getBasePath()));

        // 4. Generate the usage
        // private static final String USAGE_ROOT_EXPAND_EXPRESSION =
        // "m2t_transforms::usage::UsageModel(allocation) FOR usage";
        workflow.addComponent(new UsageModelWorkflowComponent(systemTransformationSlots, getBasePath()));

        // // Now let them run
        workflow.invoke(null);
    }

    private HashMap<String, Object> getCompletionRepositorySlots() {
        final HashMap<String, Object> sC2 = new HashMap<String, Object>();
        final ResourceSetPartition completionRepositoryPartition = this.myBlackboard
                .getPartition(ApplyConnectorCompletionsJob.COMPLETION_REPOSITORY_PARTITION);

        sC2.put("pcmmodel", completionRepositoryPartition.getResourceSet().getResources().get(0).getContents().get(0));

        return sC2;
    }

    private HashMap<String, Object> getMiddlewareRepositorySlots() {
        HashMap<String, Object> sC2 = new HashMap<String, Object>();
        ResourceSetPartition mwRepositoryPartition = this.myBlackboard
                .getPartition(LoadMiddlewareConfigurationIntoBlackboardJob.RMI_MIDDLEWARE_PARTITION_ID);

        sC2.put("pcmmodel", mwRepositoryPartition.getResourceSet().getResources().get(0).getContents().get(0));

        return sC2;
    }

    /**
     * @return
     */
    private HashMap<String, Object> getSystemTransformationSlots() {
        HashMap<String, Object> sC2 = new HashMap<String, Object>();
        PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.myBlackboard
                .getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);

        sC2.put("middleware", pcmPartition.getMiddlewareRepository());
        if (configuration.isLoadMiddlewareAndCompletionFiles()) {
            sC2.put("featureConfig", pcmPartition.getFeatureConfig());
        }
        sC2.put("system", pcmPartition.getSystem());
        sC2.put("allocation", pcmPartition.getAllocation());
        sC2.put("usage", pcmPartition.getUsageModel());
        return sC2;
    }

    /**
     * @return Creates a HashMap with all slots required for the transformation of
     *         {@link Repository}.
     */
    private HashMap<String, Object> getRepositoryTransformationSlots(int repositoryIndex) {
        HashMap<String, Object> sC2 = new HashMap<String, Object>();
        PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.myBlackboard
                .getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
        sC2.put("pcmmodel", pcmPartition.getRepositories().get(repositoryIndex));
        if (configuration.isAccuracyInfluenceAnalysisEnabled()) {
            sC2.put(SLOT_NAME_QUALITY_ANNOTATION_MODEL,
                    pcmPartition.getElement((EClass) QualityFactory.eINSTANCE.createQualityRepository()).get(0));
        }
        return sC2;
    }

    /**
     * @return
     */
    private int getRepositoryCount() {
        PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.myBlackboard
                .getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
        return pcmPartition.getRepositories().size();
    }

    private String getBasePath() {
        String basePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + "/"
                + this.configuration.getStoragePluginID() + "/" + "src";

        return basePath;
    }

    public String getName() {
        return "Generate SimuCom Plugin Code";
    }
}