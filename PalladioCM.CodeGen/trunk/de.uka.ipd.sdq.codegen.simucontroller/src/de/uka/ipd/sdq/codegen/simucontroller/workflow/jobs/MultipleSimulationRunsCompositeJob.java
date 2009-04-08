package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.OrderPreservingCompositeJob;
import de.uka.ipd.sdq.codegen.workflow.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.UserCanceledException;

/**
 * A job which runs multiple simulations in sequence or parallel to perform a sensitivity analysis
 * 
 * @author Steffen
 */
public class MultipleSimulationRunsCompositeJob extends
		OrderPreservingCompositeJob {


	private ExecutorService executorService;
	private ExecutorCompletionService<Boolean> executorCompletionService;
	private ArrayList<Future<Boolean>> oawGeneratorFutures = new ArrayList<Future<Boolean>>();

	public MultipleSimulationRunsCompositeJob(SimuComWorkflowConfiguration configuration) throws CoreException {
		setupExecutor();

		// Map<String, String> p = attributes.getOAWWorkflowProperties(1);
		double current = configuration.getSensitivityAnalysisConfiguration().getCurrent(); 
		// Double.parseDouble(p.get(ConstantsContainer.MINIMUM_TEXT));
		double step = configuration.getSensitivityAnalysisConfiguration().getStep(); 
		// Double.parseDouble(p.get(ConstantsContainer.STEP_WIDTH_TEXT));
		double max = configuration.getSensitivityAnalysisConfiguration().getMax(); 
		// Double.parseDouble(p.get(ConstantsContainer.MAXIMUM_TEXT));
		int i = 1;
		for (; current <= max; current += step) {
			this.addJob(new SimulationRunCompositeJob(configuration,i));
			i++;
		}
	}

	private void setupExecutor() {
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		executorCompletionService = new ExecutorCompletionService<Boolean>(executorService);
	}

	public void execute() throws JobFailedException, UserCanceledException {
		
		for (final IJob job : myJobs) {
			Callable<Boolean> task = new Callable<Boolean>(){

				public Boolean call() throws Exception {
					job.execute();

					try {
						job.rollback();
					} catch (RollbackFailedException e) {
						throw new JobFailedException("Automated simulation run failed",e);
					}
					return true;
				}
				
			};
			oawGeneratorFutures.add(executorCompletionService.submit(task));
		}
		while (oawGeneratorFutures.size() > 0) {
			try {
				Future<Boolean> completedTask = executorCompletionService.take();
				Boolean result = completedTask.get();
				oawGeneratorFutures.remove(completedTask);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
