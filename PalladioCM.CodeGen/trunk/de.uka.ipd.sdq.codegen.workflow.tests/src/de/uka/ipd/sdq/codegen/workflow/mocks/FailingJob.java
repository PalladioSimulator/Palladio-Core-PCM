package de.uka.ipd.sdq.codegen.workflow.mocks;


import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.UserCanceledException;

public class FailingJob extends MockJob {

	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		super.execute(monitor);
		throw new JobFailedException();
	}

	public String getName() {
		super.getName();
		return "FailingJob";
	}
}
