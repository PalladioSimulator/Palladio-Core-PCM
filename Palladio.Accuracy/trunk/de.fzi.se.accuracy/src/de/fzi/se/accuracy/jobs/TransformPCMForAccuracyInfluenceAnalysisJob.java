/**
 *
 */
package de.fzi.se.accuracy.jobs;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import de.fzi.se.accuracy.transformation.AbstractAccuracyInfluenceSEFFTransformationStrategy;
import de.fzi.se.accuracy.transformation.AccuracyInfluenceSEFFTransformationStrategyAsSpecified;
import de.fzi.se.accuracy.transformation.AccuracyInfluenceSEFFTransformationStrategyMaximum;
import de.fzi.se.accuracy.transformation.AccuracyInfluenceSEFFTransformationStrategyMinimum;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**Job executing transformations of PCM models for the accuracy analysis.
 * As it modifies the PCM models, it should only be invoked after a working copy of the models is created.
 * @author groenda
 *
 */
public class TransformPCMForAccuracyInfluenceAnalysisJob extends OrderPreservingBlackboardCompositeJob<MDSDBlackboard> implements
		IBlackboardInteractingJob<MDSDBlackboard> {

	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(TransformPCMForAccuracyInfluenceAnalysisJob.class);

	/** Workflow configuration used by this job.*/
	private AbstractPCMWorkflowRunConfiguration configuration;

	public TransformPCMForAccuracyInfluenceAnalysisJob(AbstractPCMWorkflowRunConfiguration configuration) {
		super();
		this.configuration = configuration;
	}

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		if (!configuration.isAccuracyInfluenceAnalysisEnabled()) {
			throw new IllegalArgumentException("The transformation job on PCM models for the accuracy analysis may only be run if the accuracy influence analysis is enabled.");
		}
		PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this
				.getBlackboard().getPartition(
						LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		// discover all SEFFs potentially used in the system
		Allocation allocation = pcmPartition.getAllocation();
		List<ServiceEffectSpecification> allocatedSEFFs = new ArrayList<ServiceEffectSpecification>();
		for (AllocationContext allocationContext: allocation.getAllocationContexts_Allocation()) {
			AssemblyContext outmostAssemblyContext = allocationContext.getAssemblyContext_AllocationContext();
			List<ServiceEffectSpecification> assembledSEFFs = discoverSEFFs(outmostAssemblyContext);
			addElementsToList(allocatedSEFFs, assembledSEFFs);
		}

		// modify SEFFs according to AccuracyInfluenceAnalysisState
		AbstractAccuracyInfluenceSEFFTransformationStrategy accuracyInfluenceSEFFtransformator;
		switch (configuration.getAccuracyInfluenceAnalysisState()) {
		case MINIMUM:
			accuracyInfluenceSEFFtransformator = new AccuracyInfluenceSEFFTransformationStrategyMinimum(pcmPartition);
			break;
		case AS_SPECIFIED:
			accuracyInfluenceSEFFtransformator = new AccuracyInfluenceSEFFTransformationStrategyAsSpecified(pcmPartition);
			break;
		case MAXIMUM:
			accuracyInfluenceSEFFtransformator = new AccuracyInfluenceSEFFTransformationStrategyMaximum(pcmPartition);
			break;
		default:
			String msg = "The handling of the accuracy influence strategy "
					+ configuration.getAccuracyInformationModelFile()
					+ " provided in the configuration is not implemented.";
			logger.fatal(msg);
			throw new IllegalArgumentException(msg);
		}
		for (ServiceEffectSpecification seff : allocatedSEFFs) {
			accuracyInfluenceSEFFtransformator.doSwitch(seff);
		}
		if (configuration.getAccuracyInfluenceIssueReceivingJob() == null) {
			logger.warn("No job was specified to receive issues occured during accuracy influence analysis. There will be no notifications about warnings or errors.");
		} else {
			configuration.getAccuracyInfluenceIssueReceivingJob().addIssues(accuracyInfluenceSEFFtransformator.getIssues());
		}

	}

	/**Discovers all SEFFs which are used in an assembly context.
	 * @param outmostAssemblyContext
	 * @return List of discovered SEFFs.
	 */
	private List<ServiceEffectSpecification> discoverSEFFs(
			AssemblyContext assemblyContext) {
		// see Validation.emf::FromAllocationToSEFF for a graphical overview of the used nodes and references
		List<ServiceEffectSpecification> composedSEFFs = new ArrayList<ServiceEffectSpecification>();
		RepositoryComponent repositoryComponent = assemblyContext.getEncapsulatedComponent__AssemblyContext();
		if (repositoryComponent instanceof ComposedStructure) {
			ComposedStructure composedStructure = (ComposedStructure) repositoryComponent;
			for (AssemblyContext composedComponentsContext: composedStructure.getAssemblyContexts__ComposedStructure()) {
				List<ServiceEffectSpecification> assembledSEFFs = discoverSEFFs(composedComponentsContext);
				addElementsToList(composedSEFFs, assembledSEFFs);
			}
		} else if (repositoryComponent instanceof BasicComponent) {
			BasicComponent basicComponent = (BasicComponent) repositoryComponent;
			addElementsToList(composedSEFFs, basicComponent.getServiceEffectSpecifications__BasicComponent());
		} else {
			logger.warn("Could not process the provided repository component " + repositoryComponent.getEntityName() + " with id " + repositoryComponent.getId() + ". The component type is not supported by the implementation.");
		}
		return composedSEFFs;
	}

	/**Adds a list of SEFFs to another list.
	 * Existing SEFFs are not added twice to the list.
	 * @param target The list which will receive the SEFFs of source.
	 * @param source The SEFFs to add.
	 */
	public static <T> void addElementsToList(List<T> target, final List<T> source) {
		for (T t : source) {
			if (!target.contains(t)) {
				//TODO: Check if comparison works. Should do the job as only obj == obj2 should be excluded from the list
				target.add(t);
			}
		}
	}
}
