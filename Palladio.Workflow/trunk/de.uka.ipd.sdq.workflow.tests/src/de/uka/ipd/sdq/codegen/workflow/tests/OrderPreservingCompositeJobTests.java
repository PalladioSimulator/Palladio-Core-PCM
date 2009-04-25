package de.uka.ipd.sdq.codegen.workflow.tests;

import java.util.LinkedList;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.core.runtime.NullProgressMonitor;

import de.uka.ipd.sdq.codegen.workflow.mocks.CancelingJob;
import de.uka.ipd.sdq.codegen.workflow.mocks.FailingJob;
import de.uka.ipd.sdq.codegen.workflow.mocks.MockJob;
import de.uka.ipd.sdq.workflow.OrderPreservingCompositeJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public class OrderPreservingCompositeJobTests extends TestCase {

	private OrderPreservingCompositeJob myCompJob = null;

	@Override
	protected void setUp() {
		myCompJob = new OrderPreservingCompositeJob();
		MockJob.resetExecutionNumber();
	}

	/**
	 * add a job. execute the composite job. check if the added job was
	 * executed. roll back the composite job. check if the added job was rolled
	 * back.
	 * 
	 * @throws UserCanceledException
	 * @throws JobFailedException
	 * @throws RollbackFailedException
	 */
	public void testJobHandling() throws JobFailedException,
			UserCanceledException, RollbackFailedException {
		MockJob job = new MockJob();
		myCompJob.addJob(job);
		NullProgressMonitor monitor = new NullProgressMonitor();

		myCompJob.execute(monitor);
		assertEquals(true, job.wasExecuted());

		myCompJob.rollback(monitor);
		assertEquals(true, job.wasRolledBack());
	}

	/**
	 * add a number of jobs. execute the composite job. check if all jobs were
	 * executed in the order they were added.
	 * 
	 * @throws UserCanceledException
	 * @throws JobFailedException
	 */
	public void testInOrderExecution() throws JobFailedException,
			UserCanceledException {
		LinkedList<MockJob> jobs = new LinkedList<MockJob>();
		NullProgressMonitor monitor = new NullProgressMonitor();

		for (int i = 0; i < 20; i++) {
			jobs.addLast(new MockJob());
			myCompJob.addJob(jobs.peekLast());
		}

		myCompJob.execute(monitor);

		int executionNumber = 0;
		while (!jobs.isEmpty()) {
			MockJob job = jobs.removeFirst();
			assertTrue("Job was executed in the wrong order!", job
					.getExecutionNumber() > executionNumber);
			executionNumber = job.getExecutionNumber();
		}
	}

	/**
	 * test a failed job
	 * 
	 * @throws UserCanceledException
	 * @throws JobFailedException
	 */
	public void testFailedJob() throws JobFailedException,
			UserCanceledException {
		try {
			NullProgressMonitor monitor = new NullProgressMonitor();

			myCompJob.addJob(new FailingJob());
			myCompJob.execute(monitor);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof JobFailedException);
			return;
		}
		Assert.fail("Expected exception not thrown");
	}

	/**
	 * test a canceled job
	 * 
	 * @throws UserCanceledException
	 * @throws JobFailedException
	 */
	public void testCanceledJob() throws JobFailedException,
			UserCanceledException {
		try {
			NullProgressMonitor monitor = new NullProgressMonitor();

			myCompJob.addJob(new CancelingJob());
			myCompJob.execute(monitor);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof UserCanceledException);
			return;
		}
		Assert.fail("Expected exception not thrown");
	}
}
