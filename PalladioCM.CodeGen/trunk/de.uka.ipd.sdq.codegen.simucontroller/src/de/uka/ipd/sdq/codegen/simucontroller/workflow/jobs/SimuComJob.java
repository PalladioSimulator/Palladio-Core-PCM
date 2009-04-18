package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.MDSDBlackboard;
import de.uka.ipd.sdq.codegen.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.codegen.workflow.IJobWithResult;
import de.uka.ipd.sdq.codegen.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * Main job for the SDQ workflow engine which will run a SimuComSimulation
 * @author Steffen
 */
public class SimuComJob 
extends OrderPreservingBlackboardCompositeJob<MDSDBlackboard>
implements IBlackboardInteractingJob<MDSDBlackboard> {

	public SimuComJob(SimuComWorkflowConfiguration configuration) throws CoreException {
		super();
		
		// 1. Load PCM Models into memory
		this.addJob(new LoadPCMModelsIntoBlackboardJob(configuration));
		
		// 2. Validate PCM Models
		this.addJob(new ValidateModelJob(configuration));

		// 3. Create new Eclipse plugin project
		this.addJob(new CreatePluginProjectJob(configuration));

		// 4. Generate the plugin's code using oAW
		this.addJob(new TransformPCMToCodeJob(configuration));
		this.addJob(new CreateSimuComMetaDataFilesJob(configuration));

		// 5. Compile the plugin
		this.addJob(new CompilePluginCodeJob(configuration));

		// 6. Jar the compiled code into a JAR bundle
		IJobWithResult<byte[]> buildBundleJob = new BuildPluginJarJob(configuration);
		this.addJob(buildBundleJob);
		
		// 7. Transfer the JAR to a free simulation dock and simulate it
		SimuComConfig simuConfig = configuration.getSimuComConfiguration();
		this.addJob(new TransferSimulationBundleToDock(buildBundleJob,simuConfig,null /*TODO: launch!!*/ ));
	}
}
