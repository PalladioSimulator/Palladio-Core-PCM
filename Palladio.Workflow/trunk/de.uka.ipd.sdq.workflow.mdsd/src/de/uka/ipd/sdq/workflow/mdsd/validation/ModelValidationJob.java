package de.uka.ipd.sdq.workflow.mdsd.validation;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.errorhandling.SeverityEnum;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJobWithResult;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public abstract class ModelValidationJob 
implements 
	IJobWithResult<List<SeverityAndIssue>>,
	IBlackboardInteractingJob<MDSDBlackboard> {
	
	private List<SeverityAndIssue> jobResult = null;
	private final SeverityEnum errorLevel;

	public ModelValidationJob(SeverityEnum errorLevel) {
		super();
		this.errorLevel = errorLevel;
	}
	
	/**
	 * @return the errorLevel
	 */
	public SeverityEnum getErrorLevel() {
		return errorLevel;
	}

	/**
	 * @param jobResult the jobResult to set
	 */
	protected void setJobResult(List<SeverityAndIssue> jobResult) {
		if (jobResult == null)
			throw new IllegalArgumentException("Error list must not be null.");
		this.jobResult = jobResult;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJobWithResult#getResult()
	 */
	public List<SeverityAndIssue> getResult() {
		if (this.jobResult == null)
			return Collections.EMPTY_LIST;
		return Collections.unmodifiableList(jobResult);
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#rollback(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// Not needed
	}
}
