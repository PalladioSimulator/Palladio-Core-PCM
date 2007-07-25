package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.issues.Issue;
import org.openarchitectureware.workflow.issues.IssuesImpl;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ComponentLookupEnum;
import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.IJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.JobFailedException;

/**
 * Start the Workflow-Engine of oAW - Generator
 */
public class GeneratePluginCodeJob implements IJob {

	private final static String REPOSITORY_FILE = "codegen_repository.oaw";
	private final static String SYSTEM_FILE = "codegen_system.oaw";
	private final static String USAGE_FILE = "codegen_usage.oaw";
	private final static String TEMPLATE_METHODS = "simulation_template_methods";

	private final String[] myWorkflowFiles = { REPOSITORY_FILE, SYSTEM_FILE,
			USAGE_FILE };

	private ILaunchConfiguration myConfiguration;

	public GeneratePluginCodeJob(ILaunchConfiguration configuration) {
		myConfiguration = configuration;
	}

	public void execute() throws JobFailedException {
		assert (myConfiguration != null);

		Map<String, String> properties = new HashMap<String, String>();
		Map<String, Object> slotContents = new HashMap<String, Object>();

		String workspaceLocation = null;

		try {
			workspaceLocation = ResourcesPlugin.getWorkspace().getRoot()
					.getRawLocationURI().getPath();
		} catch (Exception e) {
			throw new JobFailedException("Getting workspace location failed", e);
		}

		try {
			properties.put("aop_templates", TEMPLATE_METHODS);
			properties.put("workspace_loc", workspaceLocation);

			properties.put(ConstantsContainer.REPOSITORY_FILE, myConfiguration
					.getAttribute(ConstantsContainer.REPOSITORY_FILE, ""));
			properties.put(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, myConfiguration
					.getAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, ""));
			properties.put(ConstantsContainer.SYSTEM_FILE, myConfiguration
					.getAttribute(ConstantsContainer.SYSTEM_FILE, ""));
			properties.put(ConstantsContainer.ALLOCATION_FILE, myConfiguration
					.getAttribute(ConstantsContainer.ALLOCATION_FILE, ""));
			properties.put(ConstantsContainer.USAGE_FILE, myConfiguration
					.getAttribute(ConstantsContainer.USAGE_FILE, ""));
			properties.put(ConstantsContainer.OUTPUT_PATH, myConfiguration
					.getAttribute(ConstantsContainer.OUTPUT_PATH, ""));
			properties.put("respectLinkingResources", myConfiguration
					.getAttribute(ConstantsContainer.SIMULATE_LINKING_RESOURCES, true) ? "true" : "false");
			properties.put("brokerLookup", myConfiguration
					.getAttribute(ConstantsContainer.COMPONENT_LOOKUP, ComponentLookupEnum.DEPENDENCY_INJECTION.ordinal()) == ComponentLookupEnum.BROKER.ordinal() ?
							"true" :
							"false");

		} catch (Exception e) {
			throw new JobFailedException("Setting up properties failed", e);
		}

		for (String workflowFile : myWorkflowFiles) {
			try {
				IssuesImpl issues = new IssuesImpl();
				WorkflowRunner runner = new WorkflowRunner();
				runner.prepare(workflowFile, null, properties);
				
				if (!runner.executeWorkflow(slotContents, issues)) {
					String message = "";
					for (Issue i : issues.getErrors()){
						message += i.getMessage() + " [" + i.getElement() + "]";
					}
					throw new OawFailedException("Generator failed, given model is most likely invalid in "
							+ workflowFile + ". Issues given: "+message);
				}
			} catch (Exception e) {
				throw new JobFailedException("Running oAW workflow failed: "
						+ workflowFile+"\n Errors: "+e.getMessage()+". Please see the oAW console output for details!", e);
			}
		}
	}

	public String getName() {
		return "Generate Plugin Code";
	}

	public void rollback() {
		// do nothing
	}
}