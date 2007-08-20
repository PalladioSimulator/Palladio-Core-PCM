package de.uka.ipd.sdq.codegen.workflow.tests;

import java.util.LinkedList;
import org.junit.*;

import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.OrderPreservingCompositeJob;
import de.uka.ipd.sdq.codegen.workflow.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.UserCanceledException;
import de.uka.ipd.sdq.codegen.workflow.mocks.CancelingJob;
import de.uka.ipd.sdq.codegen.workflow.mocks.FailingJob;
import de.uka.ipd.sdq.codegen.workflow.mocks.MockJob;
import static org.junit.Assert.*;

public class OrderPreservingCompositeJobTests {
	
	private OrderPreservingCompositeJob myCompJob = null;
	
	@Before
	public void setup() {
		myCompJob = new OrderPreservingCompositeJob();
		MockJob.resetExecutionNumber();
	}
	
	/**
	 * add a job.
	 * execute the composite job.
	 * check if the added job was executed.
	 * roll back the composite job.
	 * check if the added job was rolled back.
	 * 
	 * @throws UserCanceledException 
	 * @throws JobFailedException 
	 * @throws RollbackFailedException 
	 */
	@Test
	public void testJobHandling() throws JobFailedException, UserCanceledException, RollbackFailedException {
		MockJob job = new MockJob();
		myCompJob.addJob(job);
		
		myCompJob.execute();		
		assertEquals(true, job.wasExecuted());
		
		myCompJob.rollback();
		assertEquals(true, job.wasRolledBack());
	}
	
	/**
	 * add a number of jobs.
	 * execute the composite job.
	 * check if all jobs were executed in the order they were added.
	 * 
	 * @throws UserCanceledException 
	 * @throws JobFailedException 
	 */
	@Test
	public void testInOrderExecution() throws JobFailedException, UserCanceledException {
		LinkedList<MockJob> jobs = new LinkedList<MockJob>();
		for (int i = 0; i < 20; i++) {
			jobs.addLast(new MockJob());
			myCompJob.addJob(jobs.peekLast());
		}		
		
		myCompJob.execute();
		
		int executionNumber = 0;
		while (!jobs.isEmpty()) {
			MockJob job = jobs.removeFirst();
			assertTrue("Job was executed in the wrong order!", job.getExecutionNumber() > executionNumber);
			executionNumber = job.getExecutionNumber();
		}	
	}
	
	/**
	 * test a failed job
	 * 
	 * @throws UserCanceledException 
	 * @throws JobFailedException 
	 */
	@Test(expected = JobFailedException.class)
	public void testFailedJob() throws JobFailedException, UserCanceledException {
		myCompJob.addJob(new FailingJob());
		myCompJob.execute();
	}
	
	/**
	 * test a canceled job
	 * 
	 * @throws UserCanceledException 
	 * @throws JobFailedException 
	 */
	@Test(expected = UserCanceledException.class)
	public void testCanceledJob() throws JobFailedException, UserCanceledException {
		myCompJob.addJob(new CancelingJob());
		myCompJob.execute();
	}
}
