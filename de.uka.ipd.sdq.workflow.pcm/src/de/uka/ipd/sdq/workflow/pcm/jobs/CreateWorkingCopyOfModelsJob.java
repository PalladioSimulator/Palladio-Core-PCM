package de.uka.ipd.sdq.workflow.pcm.jobs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

/**
 * Job to create a working copy of the models to simulate. This ensures that any downstream job
 * changing the models does not modify the original models.
 *
 * Prerequisite of this job: This job copies the models to the configured project created in the
 * workflow. It has to exist to be able to store the model copy into it.
 * 
 * The job currently only creates a working copy of the partition containing the pcm models:
 * {@link LoadPCMModelsIntoBlackboardJob}.PCM_MODELS_PARTITION_ID
 *
 * @author Benjamin Klatt, Sebastian Krach
 *
 */
public class CreateWorkingCopyOfModelsJob implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

    private static final String MODEL_FOLDER = "model";

    /** The LOGGER for this class */
    private static final Logger LOGGER = Logger.getLogger(CreateWorkingCopyOfModelsJob.class);

    /** The blackboard to interact with */
    private MDSDBlackboard blackboard = null;

    /** The work flow configuration to get the required information from */
    private final AbstractPCMWorkflowRunConfiguration configuration;

    /**
     * Constructor requiring the necessary configuration object.
     *
     * @param configuration
     *            The configuration for this job.
     */
    public CreateWorkingCopyOfModelsJob(AbstractPCMWorkflowRunConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * Execute this job and create the model copy.
     */
    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {

        IFolder modelFolder = getOrCreateModelFolder();

        URI modelFolderURI = URI.createFileURI(modelFolder.getLocation().toOSString());

        // access the resources
        PCMResourceSetPartition partition = (PCMResourceSetPartition) this.blackboard
                .getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
        ResourceSet resourceSet = partition.getResourceSet();
        
        PCMResourceSetPartition workingCopyPartition = new PCMResourceSetPartition();

        // Cannot do a deep copy within iterating the resource set, because if
        // proxies are resolved, new resources are created within the resource
        // set and a ConcurrentModificationException will be raised (happened
        // for Peropteryx when having the ConnectorConfig.featureconfig in the
        // ResourceSet, which causes the FeatureConfig to be copied, which has a
        // FeatureDiagram as "annotatedElement" which needs to be resolved.
        // Resolving the FeatureDiagramImpl proxy lead to modification of the
        // ResourceSet).
        // Thus, create new ArrayList to iterate.
        // TODO test whether the resource of resolved proxy is copied as expected.
        
        // TODO check whether latest change conflicts with the deep copy issue from above (Sebastian Krach)
        // should not be the case since there is no deep copy anymore
        
        List<Resource> resourceListToIterate = new ArrayList<Resource>();
        resourceListToIterate.addAll(resourceSet.getResources());
        
        List<String> originalModelPaths = new ArrayList<String>();
        
        for (Resource resource : resourceListToIterate) {
            if (resource.getURI().scheme().equals("pathmap")) {
                //If its a pathmap resource we do not need to change its path
                workingCopyPartition.setContents(resource.getURI(), 
                        resource.getContents());
            } else {
                //Otherwise redirect path to generated simulation plugin
                final URI uri = resource.getURI();
                
				// Use all segments of URI as model files may reside in
				// different folders or projects and may have the same file
				// name, e.g. a myproject/default.system referencing a
				// myproject/default.repository and a
				// anotherproject/default.repository.
				final String[] segments = uri.segments();
                final String schemeSegment = uri.scheme();
                
                final URI newURI = modelFolderURI.appendSegment(schemeSegment).appendSegments(segments) ;

                // Add base Plug-in ID and model paths to the configuration
                if (configuration.getBaseProjectID() == null) {
                    String[] splitString = uri.toString().split("/");
                    configuration.setBaseProjectID(splitString[2]);
                }


                if (uri.toString() != null) {
                    originalModelPaths.add(uri.toString());
                }
                
                workingCopyPartition.setContents(newURI, resource.getContents());
            }
        }
        
        try {
            workingCopyPartition.storeAllResources();
        } catch (IOException e) {
            if(LOGGER.isEnabledFor(Level.ERROR)) {
                LOGGER.error("Unable to serialize the working copy of the pcm models." ,e);
            }
        }
        
        //Remove the partition which references the models in the original project
        this.blackboard.removePartition(
                LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
        
        //and replace it with the new working copy, so that further modifications of the
        //model do not change the original model files.
        this.blackboard.addPartition(
                LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID, 
                workingCopyPartition);
        
        configuration.setModelPaths(originalModelPaths);
    }

    private IFolder getOrCreateModelFolder() throws JobFailedException {
        assert (this.configuration != null);
        IProject project = CreatePluginProjectJob.getProject(this.configuration.getStoragePluginID());
        assert (project != null);

        // prepare the target path
        IFolder modelFolder = project.getFolder(MODEL_FOLDER);
        if (project.isOpen() && !modelFolder.exists()) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Creating folder " + modelFolder.getName());
            }
            try {
                modelFolder.create(false, true, null);
            } catch (CoreException e) {
                if (LOGGER.isEnabledFor(Level.ERROR)) {
                    LOGGER.error("unable to create model folder");
                }
                throw new JobFailedException(e);
            }
        }
        return modelFolder;
    }

    @Override
    public String getName() {
        return "Create working copy of models";
    }

    @Override
    public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
        // nothing to clean up
    }

    @Override
    public void setBlackboard(MDSDBlackboard blackboard) {
        this.blackboard = blackboard;
    }

}
