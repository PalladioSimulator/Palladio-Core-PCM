package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.codegen.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class TransformPCMForSensitivityAnalysisJob implements
		IBlackboardInteractingJob<MDSDBlackboard> {

	private MDSDBlackboard blackboard;
	private int runNo;
	private double step;
	private String variable;
	private double min;
	private Logger logger = Logger.getLogger(TransformPCMForSensitivityAnalysisJob.class);
	
	public TransformPCMForSensitivityAnalysisJob(
			String variable, int runNo, double step, double min) throws JobFailedException {
		super();
		this.runNo = runNo;
		this.step = step;
		this.variable = variable;
		this.min = min;
		if (variable != null && !variable.equals(""))
			throw new JobFailedException("Bad Sensitivity Analysis Job Configuration");
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.workflow.IBlackboardInteractingJob#setBlackbard(de.uka.ipd.sdq.codegen.workflow.Blackboard)
	 */
	public void setBlackbard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		
		EObject o = null;
		for(Resource r : pcmPartition.getResourceSet().getResources()) {
			if (o == null) {
				o = findEObject(r.getContents().get(0));
				if ( o != null ) {
					logger.info("Altering PCM variable for sensitivity analysis");
					alterObject(o);
				}
			}
		}
		if (o == null)
			throw new JobFailedException("Sensistivity analaysis transformation was unable to find the sensitivity variable");
		
	}

	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
	}

	public String getName() {
		return "Inplace Transformation job for Sensitivity Analysis";
	}
	
	// ---

	private void alterObject(EObject o) {
		int modifier = (int)(min + runNo * step);
		if (o instanceof PCMRandomVariable) {
			PCMRandomVariable pcmRandVar = (PCMRandomVariable) o;
			String spec = pcmRandVar.getSpecification();
			spec += " " + (modifier < 0 ? " - " + Math.abs(modifier) : " + " + Math.abs(modifier));
			pcmRandVar.setSpecification(
				spec	
				);
		}
		if (o instanceof ClosedWorkload) {
			ClosedWorkload cw = (ClosedWorkload) o;
			int number = cw.getPopulation();
			number += modifier;
			cw.setPopulation(number);
		}
	}

	private EObject findEObject(EObject object) {
		Iterator<EObject> it = object.eAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();
			if (EcoreUtil.getURI(eo).toString().equals(variable))
				return eo;
		}
		return null;
	}

}
