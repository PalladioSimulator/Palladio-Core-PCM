package de.uka.ipd.sdq.workflow.mocks;


import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public class CancelingJob extends MockJob {

	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		super.execute(monitor);
		throw new UserCanceledException();
	}

	public String getName() {
		super.getName();
		return "CancelingJob";
	}
}
