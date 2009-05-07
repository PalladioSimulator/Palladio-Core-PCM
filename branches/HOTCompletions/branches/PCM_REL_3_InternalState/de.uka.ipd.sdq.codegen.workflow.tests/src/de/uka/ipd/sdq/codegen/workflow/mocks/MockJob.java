package de.uka.ipd.sdq.codegen.workflow.mocks;

import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.UserCanceledException;

/**
 * Mock implementation of a job with methods to help testing.
 * 
 * @author Philipp Meier
 */
public class MockJob implements IJob {
	
	private static int executionNumber = 0;
	
	public static void resetExecutionNumber() {
		executionNumber = 0;
	}
	
	static int nextExecutionNumber() {
		executionNumber += 1;
		return executionNumber;
	}
	
	private boolean myWasExecuted = false;
	private boolean myWasRolledBack = false;
	private boolean myWasAskedName = false;
	private int myExecutionNumber = 0;

	public void execute() throws JobFailedException, UserCanceledException {
		myWasExecuted = true;
		myExecutionNumber = nextExecutionNumber();
	}

	public String getName() {
		myWasAskedName = true;
		return "MockJob";
	}

	public void rollback() throws RollbackFailedException {
		myWasRolledBack = true;
	}
	
	public boolean wasExecuted() {
		return myWasExecuted;
	}
	
	public boolean wasRolledBack() {
		return myWasRolledBack;
	}
	
	public boolean wasAskedName() {
		return myWasAskedName;
	}
	
	public int getExecutionNumber() {
		return myExecutionNumber;
	}
}
