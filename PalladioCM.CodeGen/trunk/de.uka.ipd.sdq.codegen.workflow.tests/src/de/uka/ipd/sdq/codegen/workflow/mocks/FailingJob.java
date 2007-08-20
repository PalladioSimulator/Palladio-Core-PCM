package de.uka.ipd.sdq.codegen.workflow.mocks;


import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.UserCanceledException;

public class FailingJob extends MockJob {

	public void execute() throws JobFailedException, UserCanceledException {
		super.execute();
		throw new JobFailedException();
	}

	public String getName() {
		super.getName();
		return "FailingJob";
	}
}
