package de.uka.ipd.sdq.workflow.mdsd.emf;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;

import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJobWithResult;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

public class CheckEMFConstraintsJob 
implements IJobWithResult<ArrayList<SeverityAndIssue>>,
		IBlackboardInteractingJob<MDSDBlackboard> {

	private ArrayList<SeverityAndIssue> result;
	private MDSDBlackboard blackboard;
	private String partitionName;

	public CheckEMFConstraintsJob(String partitionName) {
		super();
		
		this.partitionName = partitionName;
	}

	public ArrayList<SeverityAndIssue> getResult() {
		return this.result;
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		this.result = new ArrayList<SeverityAndIssue>();
		ResourceSetPartition partition = this.blackboard.getPartition(this.partitionName);
		partition.resolveAllProxies();
		
		for (Resource r : partition.getResourceSet().getResources()) {
			// Check PCM internal OCL constraints
			Diagnostician diagnostician = new Diagnostician();
			Diagnostic d = diagnostician.validate(r.getContents().get(0));
			appendSeverityAndIssueFromDiagnostic(result,d);
		}

	}

	public String getName() {
		return "Check EMF Model Constraints";
	}

	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// Not needed
	}

	public void setBlackbard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}
	
	private void appendSeverityAndIssueFromDiagnostic(ArrayList<SeverityAndIssue> result, Diagnostic d) {
		if (d.getSeverity() >= Diagnostic.ERROR) {
			SeverityAndIssue sai = new SeverityAndIssue(
					SeverityAndIssue.WARNING,
					d.getMessage(),
					(EObject)d.getData().get(0));
			result.add(sai);
		}
		for (Diagnostic child : d.getChildren())
			appendSeverityAndIssueFromDiagnostic(result, child);
	}
}
