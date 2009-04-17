package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.issues.Issue;
import org.openarchitectureware.workflow.issues.IssuesImpl;
import org.openarchitectureware.xpand2.output.Outlet;

import de.uka.ipd.sdq.codegen.runconfig.ConstantsContainer;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractPCMWorkflowRunConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.MDSDBlackboard;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.PCMResourceSetPartition;
import de.uka.ipd.sdq.codegen.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;

/**
 * Start the Workflow-Engine of oAW - Generator
 */
public class GenerateOAWCodeJob implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

	protected Logger logger = Logger.getLogger(GenerateOAWCodeJob.class);
	
	private final static String REPOSITORY_FILE = "codegen_repository.oaw";
	private final static String SYSTEM_FILE = "codegen_system.oaw";
	private final static String USAGE_FILE = "codegen_usage.oaw";

	private final String[] myWorkflowFiles = { SYSTEM_FILE,
			USAGE_FILE };

	private Map<String, String> properties;

	private SimuComWorkflowConfiguration configuration;

	private MDSDBlackboard blackboard;

	public GenerateOAWCodeJob(SimuComWorkflowConfiguration configuration) {
		this.properties = new HashMap<String, String>();
		this.configuration = configuration;
		setupOAWProperties(configuration);
	}

	private void setupOAWProperties(SimuComWorkflowConfiguration configuration) {
		properties.put(ConstantsContainer.AOP_TEMPLATE, "simulation_template_methods" );
		properties.put(ConstantsContainer.REPOSITORY_FILE, configuration
				.getRepositoryFile());
		properties.put(ConstantsContainer.MWREPOSITORY_FILE, configuration
				.getMiddlewareFile());
		properties.put(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, configuration
				.getResourceTypeFile());
		properties.put(ConstantsContainer.SYSTEM_FILE, configuration
				.getSystemFile());
		properties.put(ConstantsContainer.ALLOCATION_FILE, configuration
				.getAllocationFile());
		properties.put(ConstantsContainer.USAGE_FILE, configuration
				.getUsageModelFile());
		properties.put(ConstantsContainer.FEATURE_FILE, configuration
				.getFeatureConfigFile());
		
		String basePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() 
							+ "/" +
							(configuration.isSensitivityAnalysisEnabled() 
									? configuration.getGeneratedPluginId()+"."+configuration.getSensitivityAnalysisConfiguration().getRunNo() 
									: configuration.getGeneratedPluginId()) 
							+ "/" + "src";
		
		properties.put(ConstantsContainer.EAROUT_PATH, basePath);
		properties.put(ConstantsContainer.INTERFACESOUT_PATH, basePath);
		properties.put(ConstantsContainer.CLIENTOUT_PATH, basePath);
		properties.put(ConstantsContainer.EJBSOUT_PATH, basePath);
		properties.put(ConstantsContainer.SIMULATE_LINKING_RESOURCES, 
				configuration.getSimulateLinkingResources() ? "true" : "false");
		
		if (configuration.isSensitivityAnalysisEnabled()) {
			properties.put(ConstantsContainer.VARIABLE_TEXT, configuration.getSensitivityAnalysisConfiguration().getVariable());
			properties.put(ConstantsContainer.MINIMUM_TEXT, configuration.getSensitivityAnalysisConfiguration().getMin()+"");
			properties.put(ConstantsContainer.MAXIMUM_TEXT, configuration.getSensitivityAnalysisConfiguration().getMax()+"");
			properties.put(ConstantsContainer.STEP_WIDTH_TEXT, configuration.getSensitivityAnalysisConfiguration().getStep()+"");
			properties.put(ConstantsContainer.RUN_NO, configuration.getSensitivityAnalysisConfiguration().getRunNo()+"");
		} else {
			properties.put(ConstantsContainer.VARIABLE_TEXT, "");
			properties.put(ConstantsContainer.MINIMUM_TEXT, "");
			properties.put(ConstantsContainer.MAXIMUM_TEXT, "");
			properties.put(ConstantsContainer.STEP_WIDTH_TEXT, "");
			properties.put(ConstantsContainer.RUN_NO, "1");
		}

		properties.put(ConstantsContainer.SIMULATE_LINKING_RESOURCES, configuration
				.getSimulateLinkingResources() ? "true" : "false");
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		if (properties.isEmpty())
			throw new JobFailedException("Setting up properties failed");

		Map<String, Object> slotContents = new HashMap<String, Object>();

		IProgressMonitor subProgressMonitor = new SubProgressMonitor(monitor,1);
		subProgressMonitor.beginTask("Generate with oAW source files", myWorkflowFiles.length + 1);
		
		HashMap<String,EObject> sC2 = new HashMap<String, EObject>();
		PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.blackboard.getPartition(LoadPCMModelsIntoBlackboard.PCM_MODELS_PARTITION_ID);
		sC2.put("pcmmodel",pcmPartition.getRepository());
		Outlet defaultOutlet = new Outlet(properties.get(ConstantsContainer.EJBSOUT_PATH));
		Outlet interfaces = new Outlet(properties.get(ConstantsContainer.INTERFACESOUT_PATH));
		interfaces.setName("INTERFACES");
		XpandGeneratorJob job = new XpandGeneratorJob(
				sC2,
				AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES,
				new Outlet[]{defaultOutlet,interfaces},
				"m2t_transforms::repository::Root FOR pcmmodel");
		job.execute(monitor);
		
		for (String workflowFile : myWorkflowFiles) {
			if (monitor.isCanceled())
				throw new UserCanceledException();
			generateFile(slotContents, workflowFile);
			subProgressMonitor.worked(1);
		}
		properties.put("repositoryFile", properties
				.get("mwRepositoryFile"));
		generateFile(slotContents, REPOSITORY_FILE);
		
		subProgressMonitor.worked(1);
		subProgressMonitor.done();
	}

	private void generateFile(Map<String, Object> slotContents,
			String workflowFile) throws JobFailedException {
		try {
			IssuesImpl issues = new IssuesImpl();
			WorkflowRunner runner = new WorkflowRunner();
			runner.prepare(workflowFile, null, properties);

			logger.info("Calling openArchitectureWare for file "+workflowFile);
			if (!runner.executeWorkflow(slotContents, issues)) {
				String message = "";
				for (Issue i : issues.getErrors()) {
					message += i.getMessage() + " [" + i.getElement() + "]";
				}
				throw new OawFailedException(
						"Generator failed, given model is most likely invalid in "
								+ workflowFile + ". Issues given: "
								+ message);
			}
		} catch (Exception e) {
			throw new JobFailedException("Running oAW workflow failed: "
					+ workflowFile + "\n Errors: " + e.getMessage()
					+ ". Please see the oAW console output for details!", e);
		}
	}

	public String getName() {
		return "Generate Plugin Code";
	}

	public void rollback(IProgressMonitor monitor) {
		// do nothing
	}

	@Override
	public void setBlackbard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}
}