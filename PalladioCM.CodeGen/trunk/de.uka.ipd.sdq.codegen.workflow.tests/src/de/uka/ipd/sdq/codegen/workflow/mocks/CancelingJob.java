package de.uka.ipd.sdq.codegen.workflow.mocks;


import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.UserCanceledException;

public class CancelingJob extends MockJob {

	public void execute() throws JobFailedException, UserCanceledException {
		super.execute();
		throw new UserCanceledException();
	}

	public String getName() {
		super.getName();
		return "CancelingJob";
	}
}
