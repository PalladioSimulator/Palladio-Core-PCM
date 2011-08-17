package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.runconfig.SensitivityAnalysisConfiguration;

public class TransformPCMForSensitivityAnalysisJob implements
		IBlackboardInteractingJob<MDSDBlackboard> {

	private MDSDBlackboard blackboard;
	private Logger logger = Logger
			.getLogger(TransformPCMForSensitivityAnalysisJob.class);
	private List<SensitivityAnalysisConfiguration> sconfList;

	public TransformPCMForSensitivityAnalysisJob(
			SimuComWorkflowConfiguration configuration) throws CoreException {
		super();
		this.sconfList = configuration.getSensitivityAnalysisConfigurations();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.codegen.workflow.IBlackboardInteractingJob#setBlackbard
	 * (de.uka.ipd.sdq.codegen.workflow.Blackboard)
	 */
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.codegen.workflow.IJob#execute(org.eclipse.core.runtime
	 * .IProgressMonitor)
	 */
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.blackboard
				.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);

		for (SensitivityAnalysisConfiguration sconf : this.sconfList){
			applyParamterChange(sconf, pcmPartition);
		}

	}

	private void applyParamterChange(SensitivityAnalysisConfiguration sconf, PCMResourceSetPartition pcmPartition)
			throws JobFailedException {
		if (sconf.getVariable() != null && sconf.getVariable().equals(""))
			throw new JobFailedException(
					"Bad Sensitivity Analysis Job Configuration, no variable specified.");

		EObject o = null;
		for (Resource r : pcmPartition.getResourceSet().getResources()) {
			if (o == null) {
				o = findEObject(r.getContents().get(0), sconf);
				if (o != null) {
					logger
							.info("Altering PCM variable for sensitivity analysis");
					alterObject(o, sconf);
				}
			}
		}
		if (o == null)
			throw new JobFailedException(
					"Sensistivity analaysis transformation was unable to find the sensitivity variable");
	}

	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
	}

	public String getName() {
		return "Inplace Transformation job for Sensitivity Analysis";
	}

	// ---

	private void alterObject(EObject o, SensitivityAnalysisConfiguration sconf) {
		DecimalFormat df = new DecimalFormat("0.00000000", new DecimalFormatSymbols(Locale.US));
		String value = df.format( sconf.getCurrent() );
		if (o instanceof PCMRandomVariable) {
			PCMRandomVariable pcmRandVar = (PCMRandomVariable) o;
			pcmRandVar.setSpecification(value);
		}
		if (o instanceof ClosedWorkload) {
			ClosedWorkload cw = (ClosedWorkload) o;
			cw.setPopulation((int)sconf.getCurrent());
		}
		if (o instanceof OpenWorkload) {
			OpenWorkload ow = (OpenWorkload) o;
			ow.getInterArrivalTime_OpenWorkload().setSpecification("Exp(" + value + ")");
		}
	}

	private EObject findEObject(EObject object, SensitivityAnalysisConfiguration sconf) {
		Iterator<EObject> it = object.eAllContents();
		URI uri = URI.createURI(sconf.getVariable());

		while (it.hasNext()) {
			EObject eo = it.next();
			if (EcoreUtil.getURI(eo).equals(uri))
				return eo;
		}
		return null;
	}

}
