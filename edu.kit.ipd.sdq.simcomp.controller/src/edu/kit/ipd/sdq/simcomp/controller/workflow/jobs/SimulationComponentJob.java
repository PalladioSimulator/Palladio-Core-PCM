package edu.kit.ipd.sdq.simcomp.controller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.analyzer.workflow.blackboard.PCMResourceSetPartition;
import org.palladiosimulator.analyzer.workflow.jobs.LoadPCMModelsIntoBlackboardJob;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractSimulationJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.BuildPluginJarJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.CompilePluginCodeJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.TransferSimulationBundleToDock;
import de.uka.ipd.sdq.workflow.extension.AbstractExtendableJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import edu.kit.ipd.sdq.simcomp.controller.runconfig.SimulationComponentWorkflowConfiguration;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.PCMModel;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulationComponentConfiguration;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulationConfiguration;

/**
 * The simulation component workflow job. This job generates a nearly empty simulation code project 
 * which only delegates the simulation control to the simulation middleware.
 * 
 * This class is based on {@link EventSimJob}. Some code has been reused.
 * 
 * @author Christoph Föhrdes
 */
public class SimulationComponentJob extends AbstractSimulationJob<SimulationComponentWorkflowConfiguration> {

    public SimulationComponentJob(SimulationComponentWorkflowConfiguration configuration, IDebugListener listener, boolean loadModels)
            throws CoreException {
        super(configuration, listener, loadModels);
    }

    public SimulationComponentJob(SimulationComponentWorkflowConfiguration configuration, IDebugListener listener) throws CoreException {
        super(configuration, listener);
    }

    public SimulationComponentJob(SimulationComponentWorkflowConfiguration configuration) throws CoreException {
        super(configuration);
    }

    @Override
    protected void addSimulatorSpecificJobs(final SimulationComponentWorkflowConfiguration configuration) {
        // 1. Generate the plugin's code
        this.addJob(new CreateSimulationComponentMetaDataFilesJob(configuration));
        this.addJob(new CreateSimulationComponentMainFile(configuration));

        // 2. Compile the plugin
        this.addJob(new CompilePluginCodeJob(configuration));

        // 3. Jar the compiled code into a JAR bundle
        BuildPluginJarJob buildBundleJob = new BuildPluginJarJob(configuration);
        this.addJob(buildBundleJob);
        
        // TODO document and FIXME
        this.addJob(new AbstractExtendableJob<MDSDBlackboard>() {

			@Override
			public void execute(IProgressMonitor monitor)
					throws JobFailedException, UserCanceledException {
				// TODO Auto-generated method stub
				PCMResourceSetPartition p = (PCMResourceSetPartition)getBlackboard().getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
				
				// TODO revise
				SimulationConfiguration sc = configuration.getSimulationConfiguration();
				sc.setModel(new PCMModel(p.getAllocation(), p.getRepositories().get(0), p.getResourceEnvironment(), p.getSystem(), p.getUsageModel(), p.getResourceTypeRepository()));
				System.out.println(sc);
				System.out.println(p.getResourceEnvironment().eResource().getURI());
				super.execute(monitor);
			}
        	
        });

        // 4. Transfer the JAR to a free simulation dock and simulate it
        this.addJob(new TransferSimulationBundleToDock(configuration, debugListener, buildBundleJob));
    }

    public String getWorkflowId() {
        return "workflow.extension.simcomp";
    }

}
