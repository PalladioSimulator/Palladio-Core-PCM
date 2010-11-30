package de.uka.ipd.sdq.workflow.mdsd.emf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;

import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.errorhandling.SeverityEnum;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.validation.ModelValidationJob;

/**
 * A job which checks all model constraints implemented by EMF directly or generated using the 
 * EMF OCL extension.
 * 
 * @author Steffen Becker
 *
 */
public class CheckEMFConstraintsJob 
extends ModelValidationJob {

	private MDSDBlackboard blackboard;
	private final String partitionName;

	/**
	 * Create a new constrains check job
	 * @param partitionName The blackboard partition containing the model to be checked
	 */
	public CheckEMFConstraintsJob(SeverityEnum errorLevel, String partitionName) {
		super(errorLevel);
		
		this.partitionName = partitionName;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		ArrayList<SeverityAndIssue> result = new ArrayList<SeverityAndIssue>();
		ResourceSetPartition partition = this.blackboard.getPartition(this.partitionName);
		partition.resolveAllProxies();
		
		for (Resource r : partition.getResourceSet().getResources()) {
			
			//Check that model is loaded. 
			//If not, add an error to the resulting diagnostics regardless of the 
			//error level of this CheckEMFConstraintsJob
			List<EObject> contents = r.getContents();
			if (contents == null || contents.size() == 0){
				Diagnostic d = new BasicDiagnostic(
						Diagnostic.ERROR,
						this.getClass().getCanonicalName(), 
						0,
						"Requested file "+r.getURI()+" cannot be loaded. Make sure it exists and is valid, or fix your model's references.",
						new Object [] { null });
				appendSeverityAndIssueFromDiagnostic(result,d, SeverityEnum.ERROR);
			} else {
				// Check model internal OCL constraints
				Diagnostician diagnostician = new Diagnostician();
				Diagnostic d = diagnostician.validate(contents.get(0));
				appendSeverityAndIssueFromDiagnostic(result,d);
			}
		}
		
		this.setJobResult(result);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#getName()
	 */
	public String getName() {
		return "Check EMF Model Constraints";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IBlackboardInteractingJob#setBlackboard(de.uka.ipd.sdq.workflow.Blackboard)
	 */
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}
	
	private void appendSeverityAndIssueFromDiagnostic(ArrayList<SeverityAndIssue> result, Diagnostic d, SeverityEnum severity) {
		if (d.getSeverity() >= Diagnostic.ERROR) {
			SeverityAndIssue sai = new SeverityAndIssue(
					severity,
					d.getMessage(),
					(EObject)d.getData().get(0));
			result.add(sai);
		}
		for (Diagnostic child : d.getChildren())
			appendSeverityAndIssueFromDiagnostic(result, child);
	}
	
	private void appendSeverityAndIssueFromDiagnostic(ArrayList<SeverityAndIssue> result, Diagnostic d) {
		appendSeverityAndIssueFromDiagnostic(result, d, this.getErrorLevel());
	}
}
