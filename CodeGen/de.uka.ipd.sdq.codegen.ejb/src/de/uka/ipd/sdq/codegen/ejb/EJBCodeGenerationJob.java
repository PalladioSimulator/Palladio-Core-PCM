package de.uka.ipd.sdq.codegen.ejb;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.CompilePluginCodeJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.CreateProtoComMetaDataFilesJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.TransformPCMToCodeJob;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.CreatePluginProjectJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.ValidatePCMModelsJob;

/**
 * Main job for the SDQ workflow engine which will run a SimuComSimulation
 * @author Steffen
 */
public class EJBCodeGenerationJob 
extends OrderPreservingBlackboardCompositeJob<MDSDBlackboard>
implements IBlackboardInteractingJob<MDSDBlackboard> {

	public EJBCodeGenerationJob(EjbCodeGenerationConfiguration configuration, IDebugListener listener) throws CoreException {
		this(configuration, listener, true);
		
	}

	public EJBCodeGenerationJob(EjbCodeGenerationConfiguration configuration) throws CoreException {
		this(configuration,null);
	}
	
	public EJBCodeGenerationJob(EjbCodeGenerationConfiguration configuration, IDebugListener listener, boolean loadModels) throws CoreException {
		super();
		
		if (listener == null && configuration.isDebug())
			throw new IllegalArgumentException("Debug listener has to be non-null for debug runs");
		// 1. Load PCM Models into memory		
		if (loadModels == true) {
			this.addJob(new LoadPCMModelsIntoBlackboardJob(configuration));
		}
		//this.addJob(new LoadMiddlewareConfigurationIntoBlackboardJob(configuration));
		
		// 2. Validate PCM Models
		this.addJob(new ValidatePCMModelsJob(configuration));
		
		// 3. Create new Eclipse plugin project
		// We do NOT perform this step anymore. It causes PCM to delete and generate the
		// plugin project twice! [zolynski]
		//this.addJob(new CreatePluginProjectJob(configuration));

		// 4. Generate the plugin's code using oAW
		this.addJob(new TransformPCMToCodeJob(configuration));

		if (configuration.getCodeGenerationAdvice() == AbstractCodeGenerationWorkflowRunConfiguration.CodeGenerationAdvice.PROTO ||
				configuration.getCodeGenerationAdvice() == AbstractCodeGenerationWorkflowRunConfiguration.CodeGenerationAdvice.EJB3) {
			this.addJob(new CreateProtoComMetaDataFilesJob(configuration));			
		} else if (configuration.getCodeGenerationAdvice() == AbstractCodeGenerationWorkflowRunConfiguration.CodeGenerationAdvice.POJO) {
			// TODO: Change to MANIFEST.MF with less dependencies
			this.addJob(new CreateProtoComMetaDataFilesJob(configuration));						
		}

		// 5. Compile the plugin (otherwise the source files are not properly found)
		this.addJob(new CompilePluginCodeJob(configuration));

	}
}