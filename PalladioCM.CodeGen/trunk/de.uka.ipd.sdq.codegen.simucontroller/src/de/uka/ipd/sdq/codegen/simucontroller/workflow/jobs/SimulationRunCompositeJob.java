package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.UserCanceledException;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * Composite job that runs all the jobs of the simulation run
 * in the correct order. This is done because jobs added
 * to the work flow should be (order) independent, which
 * is not the case for the jobs of the simulation run.
 * 
 * @author Philipp Meier
 */
public class SimulationRunCompositeJob implements IJob {
	
	private CheckOAWConstraintsJob myCheckOAWConstraintsJob;
	private CreatePluginProjectJob myCreatePluginProjectJob;
	private GeneratePluginCodeJob myGeneratePluginCodeJob;
	private CompilePluginCodeJob myCompilePluginCodeJob;
	private LoadPluginJob myLoadPluginJob;
	private SimulateJob mySimulateJob;
	
	/**
	 * @param configuration the launch configuration
	 * @throws CoreException
	 */
	public SimulationRunCompositeJob(ILaunchConfiguration configuration) throws CoreException {
		assert (configuration != null);
		
		myCheckOAWConstraintsJob = new CheckOAWConstraintsJob(configuration);
	
		myCreatePluginProjectJob = new CreatePluginProjectJob(configuration);
		
		myGeneratePluginCodeJob = new GeneratePluginCodeJob(configuration);
	
		myCompilePluginCodeJob = new CompilePluginCodeJob(myCreatePluginProjectJob);

		myLoadPluginJob = new LoadPluginJob(myCreatePluginProjectJob);

		SimuComConfig simuConfig = new SimuComConfig(configuration.getAttributes());
		mySimulateJob = new SimulateJob(simuConfig);
	}

	public void execute() throws JobFailedException, UserCanceledException {
		myCheckOAWConstraintsJob.execute();
		myCreatePluginProjectJob.execute();
		myGeneratePluginCodeJob.execute();
		myCompilePluginCodeJob.execute();
		myLoadPluginJob.execute();
		mySimulateJob.execute();
	}

	public String getName() {
		return "Simulation Run";
	}

	public void rollback() throws RollbackFailedException {
		myCheckOAWConstraintsJob.rollback();
		myCreatePluginProjectJob.rollback();
		myGeneratePluginCodeJob.rollback();
		myCompilePluginCodeJob.rollback();
		myLoadPluginJob.rollback();
		mySimulateJob.rollback();		
	}

}
