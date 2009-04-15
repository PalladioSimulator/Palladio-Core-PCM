package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.issues.Issue;
import org.openarchitectureware.workflow.issues.IssuesImpl;

import de.uka.ipd.sdq.codegen.runconfig.ConstantsContainer;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;

/**
 * Start the Workflow-Engine of oAW - Generator
 */
public class GenerateOAWCodeJob implements IJob {

	protected Logger logger = Logger.getLogger(GenerateOAWCodeJob.class);
	
	private final static String REPOSITORY_FILE = "codegen_repository.oaw";
	private final static String SYSTEM_FILE = "codegen_system.oaw";
	private final static String USAGE_FILE = "codegen_usage.oaw";

	private final String[] myWorkflowFiles = { REPOSITORY_FILE, SYSTEM_FILE,
			USAGE_FILE };

	private Map<String, String> properties;

	public GenerateOAWCodeJob(SimuComWorkflowConfiguration configuration) {
		this.properties = new HashMap<String, String>();
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

	public void execute(IProgressMonitor monitor) throws JobFailedException {
		if (properties.isEmpty())
			throw new JobFailedException("Setting up properties failed");

		Map<String, Object> slotContents = new HashMap<String, Object>();

		for (String workflowFile : myWorkflowFiles) {
			generateFile(slotContents, workflowFile);
		}
		properties.put("repositoryFile", properties
				.get("mwRepositoryFile"));
		generateFile(slotContents, REPOSITORY_FILE);
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
}