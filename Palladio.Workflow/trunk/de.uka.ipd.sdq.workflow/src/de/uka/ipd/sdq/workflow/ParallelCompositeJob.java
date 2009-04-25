package de.uka.ipd.sdq.workflow;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

class CallableJob implements Callable<Boolean> {

	private IJob job;
	private IProgressMonitor monitor;

	public CallableJob(IJob job, IProgressMonitor monitor) {
		this.job = job;
		this.monitor = monitor;
	}

	public Boolean call() throws JobFailedException, UserCanceledException {
		job.execute(monitor);

		try {
			job.rollback(monitor);
		} catch (RollbackFailedException e) {
			throw new JobFailedException("Automated simulation run failed", e);
		}
		return true;
	}
	
	public IJob getJob() {
		return job;
	}
}

public class ParallelCompositeJob extends AbstractCompositeJob {
	int threadPoolSize = -1;
	private ExecutorService executorService;
	private ExecutorCompletionService<Boolean> executorCompletionService;
	private HashMap<Future<Boolean>,CallableJob> futures = new HashMap<Future<Boolean>,CallableJob>();

	public ParallelCompositeJob() {
		this(-1);
	}

	public ParallelCompositeJob(int threadPoolSize) {
		super();

		this.threadPoolSize = threadPoolSize;
		setupExecutor();
	}

	@Override
	public void execute(final IProgressMonitor monitor)
			throws JobFailedException, UserCanceledException {

		for (final IJob job : myJobs) {
			CallableJob task = new CallableJob(job, monitor);
			Future<Boolean> future = executorCompletionService.submit(task);
			futures.put(future, task);
		}
		while (futures.size() > 0) {
			try {
				Future<Boolean> completedTask = executorCompletionService
						.take();
				completedTask.get();
				futures.remove(completedTask);
				myExecutedJobs.add(futures.get(completedTask).getJob());
			} catch (InterruptedException e) {
				throw new JobFailedException(
						"Failed waiting for job to finish", e);
			} catch (ExecutionException e) {
				throw new JobFailedException(
						"Failed waiting for job to finish", e);
			}
		}
	}

	private void setupExecutor() {
		if (threadPoolSize < 0)
			executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
					.availableProcessors());
		else
			executorService = Executors.newFixedThreadPool(threadPoolSize);

		executorCompletionService = new ExecutorCompletionService<Boolean>(
				executorService);
	}

}
