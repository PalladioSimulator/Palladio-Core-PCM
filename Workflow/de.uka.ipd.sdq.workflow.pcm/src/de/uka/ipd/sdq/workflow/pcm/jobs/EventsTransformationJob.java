package de.uka.ipd.sdq.workflow.pcm.jobs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.SavePartitionToDiskJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJobConfiguration;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

/**
 * Workflow job to transform the event related model elements to classic pcm model elements
 * 
 * @author Benjamin Klatt <klatt@fzi.de>
 */
public class EventsTransformationJob implements IBlackboardInteractingJob<MDSDBlackboard> {

    /** Logger for this class. */
    private static final Logger LOGGER = Logger.getLogger(EventsTransformationJob.class);

    /** Path to the qvto transformation script */
    protected static final String TRANSFORMATION_SCRIPT = "platform:/plugin/org.palladiosimulator.pcm.resources/transformations/events/transformation-psm.qvto";

    private static final String TRACESFOLDER = "traces";

    /** Reference to the blackboard to access it in the complete job */
    private MDSDBlackboard blackboard;

    /** SimuCom configuration to be used in this job */
    private final AbstractPCMWorkflowRunConfiguration configuration;

    /**
     * Constructor providing access to the SimuCom workflow specific configuration..
     * 
     * @param configuration
     *            The configuration object to work with.
     */
    public EventsTransformationJob(final AbstractPCMWorkflowRunConfiguration configuration) {
        super();
        this.configuration = configuration;
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {

        // get the models to work with
        final ModelLocation[] modelLocations = getRequiredModels(this.blackboard);

        if (checkEventGroups(modelLocations)) {
            LOGGER.info("Skipping Event Transformation: No EventGroup was found");
            return;
        }

        this.configuration.getEventMiddlewareFile();

        // build file paths
        final URI traceFileURI = URI.createURI(getProject(this.configuration.getStoragePluginID())
                .getFolder(TRACESFOLDER).getFullPath().toOSString());
        final URI scriptFileURI = URI.createURI(TRANSFORMATION_SCRIPT);

        // configure the QVTO Job
        final QVTOTransformationJobConfiguration qvtoConfig = new QVTOTransformationJobConfiguration();
        qvtoConfig.setInoutModels(modelLocations);
        qvtoConfig.setTraceFileURI(traceFileURI);
        qvtoConfig.setScriptFileURI(scriptFileURI);
        qvtoConfig.setOptions(new HashMap<String, Object>());

        // create and add the qvto job
        final QVTOTransformationJob job = new QVTOTransformationJob(qvtoConfig);
        job.setBlackboard(this.blackboard);

        try {
            job.execute(monitor);
        } catch (final JobFailedException e) {
            if (LOGGER.isEnabledFor(Level.ERROR)) {
                LOGGER.error("Failed to perform Event Transformation: " + e.getMessage());
            }
            if (LOGGER.isEnabledFor(Level.INFO)) {
                LOGGER.info("Trying to continue processing");
            }
        }

        // add the event middleware model to the blackboard
        final ResourceSetPartition partition = this.blackboard
                .getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
        partition.loadModel(this.configuration.getEventMiddlewareFile());

        // save the modified model
        final SavePartitionToDiskJob savePartitionJob = new SavePartitionToDiskJob(
                LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
        savePartitionJob.setBlackboard(this.blackboard);
        savePartitionJob.execute(monitor);

    }

    /**
     * Search for an EventGroup in the repository
     * 
     * @param modelLocations
     *            the model locations
     * @return true when no EventGroup is found
     */
    private boolean checkEventGroups(final ModelLocation[] modelLocations) {
        boolean skipQVTO = true;
        for (final ModelLocation loc : modelLocations) {
            final URI modelId = loc.getModelID();
            final String fileExtension = modelId.fileExtension();
            if (fileExtension != null && fileExtension.equals("repository")) {
                final ResourceSetPartition partition = this.blackboard.getPartition(loc.getPartitionID());
                final List<EObject> contents = partition.getContents(modelId);
                final Repository repo = (Repository) EcoreUtil.getObjectByType(contents,
                        RepositoryPackage.eINSTANCE.getRepository());
                if (repo == null) {
                    continue;
                }

                final Object eventgroup = EcoreUtil.getObjectByType(repo.getInterfaces__Repository(),
                        RepositoryPackage.eINSTANCE.getEventGroup());
                if (eventgroup != null) {
                    skipQVTO = false;
                }
            }

        }
        return skipQVTO;
    }

    /**
     * Build the location objects out of the blackboards PCM model partition.
     * 
     * @param blackboard
     *            The blackboard to work with.
     * @return The prepared model locations for the PCM models.
     */
    private ModelLocation[] getRequiredModels(final MDSDBlackboard blackboard) {

        // prepare the models required for the transformation
        ModelLocation allocationModelLocation = null;
        ModelLocation systemModelLocation = null;
        ModelLocation repositoryModelLocation = null;

        // find the models in the blackboard
        final String pcmModelPartitionId = LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID;
        final ResourceSetPartition partition = blackboard.getPartition(pcmModelPartitionId);
        partition.resolveAllProxies();
        for (final Resource r : partition.getResourceSet().getResources()) {
            final URI modelURI = r.getURI();
            final String fileExtension = modelURI.fileExtension();

            if (fileExtension.equals("allocation")) {
                allocationModelLocation = new ModelLocation(pcmModelPartitionId, modelURI);
            }

            if (fileExtension.equals("system")) {
                systemModelLocation = new ModelLocation(pcmModelPartitionId, modelURI);
            }

            if (fileExtension.equals("repository") && repositoryModelLocation == null
                    && !modelURI.toString().startsWith("pathmap://")
                    && !modelURI.toString().contains("PrimitiveTypes.repository")) {
                repositoryModelLocation = new ModelLocation(pcmModelPartitionId, modelURI);
            }
        }

        // Build the model location list
        final ArrayList<ModelLocation> modelLocations = new ArrayList<ModelLocation>();
        modelLocations.add(allocationModelLocation);
        modelLocations.add(systemModelLocation);
        modelLocations.add(repositoryModelLocation);

        // add the additional event middleware model
        modelLocations.add(getEventMiddlewareModel(blackboard));

        return modelLocations.toArray(new ModelLocation[] {});
    }

    /**
     * Get the middleware repository from the PCM blackboard partition
     * 
     * @param blackboard
     *            The blackboard to get the model from
     * @return The event middleware model
     */
    private ModelLocation getEventMiddlewareModel(final MDSDBlackboard blackboard) {

        final ResourceSetPartition pcmPartition = blackboard
                .getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
        pcmPartition.resolveAllProxies();

        // Only the first resource is necessary.
        // All the others are eventually referenced models like the PrimitiveTypes repository we do
        // not need here
        // Check for an empty list (happened when being called by PerOpteryx)
        if (pcmPartition.getResourceSet().getResources().size() > 0) {
            final Resource r = pcmPartition.getResourceSet().getResources().get(0);
            return new ModelLocation(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID, r.getURI());
        } else {
            return new ModelLocation(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID, URI.createURI(""));
        }
    }

    @Override
    public void setBlackboard(final MDSDBlackboard blackboard) {
        this.blackboard = blackboard;
    }

    @Override
    public String getName() {
        return "Add event transformation job";
    }

    @Override
    public void cleanup(final IProgressMonitor monitor) throws CleanupFailedException {
        // Nothing to do for the roll back
    }

    /**
     * returns a new project to be used for the simulation
     * 
     * @return a handle to the project to be used for the simulation
     */
    public static IProject getProject(final String projectId) {
        return ResourcesPlugin.getWorkspace().getRoot().getProject(projectId);
    }

}
