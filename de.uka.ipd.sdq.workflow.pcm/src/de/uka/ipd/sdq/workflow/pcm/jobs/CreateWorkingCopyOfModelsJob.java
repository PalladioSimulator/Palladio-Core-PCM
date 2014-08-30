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
 * Job to create a working copy of the models to simulate.
 * This ensures that any downstream job changing the models
 * does not modify the original models.
 *
 * Prerequisite of this job:
 * This job copies the models to the configured project created in
 * the workflow. It has to exist to be able to store the model copy
 * into it.
 *
 * @author Benjamin Klatt
 *
 */
public class CreateWorkingCopyOfModelsJob implements IJob,
	IBlackboardInteractingJob<MDSDBlackboard> {

	/** The LOGGER for this class */
	private static final Logger LOGGER = Logger.getLogger(CreateWorkingCopyOfModelsJob.class);

	/** The blackboard to interact with */
	private MDSDBlackboard blackboard = null;

	/** The work flow configuration to get the required information from */
	private final AbstractPCMWorkflowRunConfiguration configuration;

	/**
	 * Constructor requiring the necessary configuration object.
	 *
	 * @param configuration The configuration for this job.
	 */
	public CreateWorkingCopyOfModelsJob(AbstractPCMWorkflowRunConfiguration configuration) {
		this.configuration = configuration;
	}

	/**
	 * Execute this job and create the model copy.
	 */
	@Override
    public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {

		assert (this.configuration != null);
		IProject project = CreatePluginProjectJob.getProject(this.configuration
				.getStoragePluginID());
		assert (project != null);

		// prepare the target path
		IFolder modelFolder = project.getFolder("model");
		if (project.isOpen() && !modelFolder.exists()) {
			if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("Creating folder " + modelFolder.getName());
            }
			try {
				modelFolder.create(false, true, null);
			} catch (CoreException e) {
				if(LOGGER.isEnabledFor(Level.ERROR)) {
                    LOGGER.error("unable to create model folder");
                }
				throw new JobFailedException(e);
			}
		}
		final String modelBasePath = "file:/"+modelFolder.getLocation().toOSString();

		// access the resources
		PCMResourceSetPartition partition = (PCMResourceSetPartition) this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		ResourceSet resourceSet = partition.getResourceSet();
		
		
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
		List<Resource> resourceListToIterate = new ArrayList<Resource>();
		resourceListToIterate.addAll(resourceSet.getResources());
		
		for (Resource resource : resourceListToIterate) {

			// we only need to copy the file models
			if (resource.getURI().scheme() != "pathmap") {
				final URI uri = resource.getURI();
				final String relativePath = uri.lastSegment();
				final URI newURI = URI.createURI(modelBasePath +"/"+ relativePath);
				
				final ResourceSet newResSet = new ResourceSetImpl();
                final Resource newResource = newResSet.createResource(newURI);
                // deep copy
                newResource.getContents().addAll(EcoreUtil.copyAll(resource.getContents())); // FIXME Enable inter-model references 
				try {
				    newResource.save(null);
				} catch (IOException e) {
					if(LOGGER.isEnabledFor(Level.ERROR)) {
                        LOGGER.error("Unable to store resource "+resource.getURI(),e);
                    }
				}
			}
		}
	}

	@Override
    public String getName() {
		return "Create working copy of models";
	}

	@Override
    public void cleanup(IProgressMonitor monitor)
			throws CleanupFailedException {
		// nothing to clean up
	}

	@Override
    public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
