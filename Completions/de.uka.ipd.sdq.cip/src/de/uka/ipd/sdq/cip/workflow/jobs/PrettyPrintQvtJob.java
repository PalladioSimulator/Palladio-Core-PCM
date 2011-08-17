package de.uka.ipd.sdq.cip.workflow.jobs;

import java.util.HashMap;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xpand2.output.Outlet;

import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.cip.configuration.QVTConfigurationHelper;
import de.uka.ipd.sdq.cip.configuration.Transformation;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.jobs.QVTRTransformationJobConfiguration;
import de.uka.ipd.sdq.workflow.mdsd.oaw.XpandGeneratorJob;

public class PrettyPrintQvtJob extends
		OrderPreservingBlackboardCompositeJob<MDSDBlackboard> implements
		IBlackboardInteractingJob<MDSDBlackboard> {

	private CompletionConfiguration completionConfiguration = null;
	private Transformation transformation = null;
	private QVTRTransformationJobConfiguration jobConfiguration = null;
	private MDSDBlackboard blackboard = null;
	
	public PrettyPrintQvtJob(QVTRTransformationJobConfiguration jobConfiguration, 
			CompletionConfiguration completionConfiguration, Transformation transformation) {
		
		this.jobConfiguration = jobConfiguration;
		this.transformation = transformation;
		this.completionConfiguration = completionConfiguration;
		
	}
	
	private static final String PRETTYPRINT_EXPRESSION = "template::prettyprint::trafo FOR model"; 
	@Override
	public void execute(IProgressMonitor monitor)
			throws de.uka.ipd.sdq.workflow.exceptions.JobFailedException,
			de.uka.ipd.sdq.workflow.exceptions.UserCanceledException {

		assert (completionConfiguration != null);
		assert (transformation != null);
		assert (jobConfiguration != null);
		
		add(getGeneratorJob(getModelSlot(), PRETTYPRINT_EXPRESSION));
		
		super.execute(monitor);
	}
	
	
	private HashMap<String, Object> getModelSlot() {
		HashMap<String,Object> sC2 = new HashMap<String, Object>();
		ResourceSetPartition partition = this.myBlackboard.getPartition(ConstantsContainer.HOT_PARTITION_ID);
		URI modelURI = URI.createURI(PrepareTransformationsJob.
				getModelFolder(completionConfiguration.getProjectID()).
				getFile("qvt.xmi").getFullPath().toPortableString());
		sC2.put("model",partition.getFirstContentElement(modelURI));
		return sC2;
	}


	private Outlet[] getQVTOutlets() throws JobFailedException {
		
		IFolder modelFolder = PrepareTransformationsJob.createFolder(
					PrepareTransformationsJob.getModelFolder(completionConfiguration.getProjectID()).getFolder(
							QVTConfigurationHelper.createTransformationID(completionConfiguration, transformation)),
					logger);
		
		Outlet outlet = new Outlet(modelFolder.getFullPath().toString());
		outlet.setName("transformation");
		
		transformation.setQVTFileURI(modelFolder.getFile("trasformation.qvt").getFullPath().toString());
		
		return new Outlet[]{outlet};
	}

	
	/**
	 * @param slots 
	 * @param monitor
	 * @throws JobFailedException 
	 * @throws JobFailedException
	 * @throws UserCanceledException
	 */
	private XpandGeneratorJob getGeneratorJob(
			HashMap<String, Object> slots,
			String expression) throws JobFailedException {
		XpandGeneratorJob job = new XpandGeneratorJob(
				slots,
				ConstantsContainer.HOT_METAMODELS,
				getQVTOutlets(),
				expression);
		//job.getAdvices().add(completionConfiguration.getCodeGenerationAdvicesFile());
		job.setCheckProtectedRegions(true);
		
		return job;
	}

}
