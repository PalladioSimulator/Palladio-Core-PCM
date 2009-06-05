package de.uka.ipd.sdq.codegen.simucontroller.workflow;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.issues.Issue;
import org.openarchitectureware.workflow.issues.IssuesImpl;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.ComponentLookupEnum;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.FeatureOptionsTab;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.ResourceManagerTab;

/**
 * Start the Workflow-Engine of oAW - Generator
 */
public class GeneratePluginCodeJob implements ISimulationJob {

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

	public boolean execute() throws Exception {
		assert (myConfiguration != null);

		Map<String, String> properties = new HashMap<String, String>();
		Map<String, Object> slotContents = new HashMap<String, Object>();

		String workspaceLocation = null;

		try {
			workspaceLocation = ResourcesPlugin.getWorkspace().getRoot()
					.getRawLocationURI().getPath();
		} catch (Exception e) {
			throw new Exception("Getting workspace location failed", e);
		}

		try {
			properties.put("aop_templates", TEMPLATE_METHODS);
			properties.put("workspace_loc", workspaceLocation);

			properties.put(ResourceManagerTab.REPOSITORY_FILE, myConfiguration
					.getAttribute(ResourceManagerTab.REPOSITORY_FILE, ""));
			properties.put(ResourceManagerTab.RESOURCETYPEREPOSITORY_FILE, myConfiguration
					.getAttribute(ResourceManagerTab.RESOURCETYPEREPOSITORY_FILE, ""));
			properties.put(ResourceManagerTab.SYSTEM_FILE, myConfiguration
					.getAttribute(ResourceManagerTab.SYSTEM_FILE, ""));
			properties.put(ResourceManagerTab.ALLOCATION_FILE, myConfiguration
					.getAttribute(ResourceManagerTab.ALLOCATION_FILE, ""));
			properties.put(ResourceManagerTab.USAGE_FILE, myConfiguration
					.getAttribute(ResourceManagerTab.USAGE_FILE, ""));
			properties.put(ResourceManagerTab.OUTPUT_PATH, myConfiguration
					.getAttribute(ResourceManagerTab.OUTPUT_PATH, ""));
			properties.put("respectLinkingResources", myConfiguration
					.getAttribute(FeatureOptionsTab.SIMULATE_LINKING_RESOURCES, true) ? "true" : "false");
			properties.put("brokerLookup", myConfiguration
					.getAttribute(FeatureOptionsTab.COMPONENT_LOOKUP, ComponentLookupEnum.DEPENDENCY_INJECTION.ordinal()) == ComponentLookupEnum.BROKER.ordinal() ?
							"true" :
							"false");

		} catch (Exception e) {
			throw new Exception("Setting up properties failed", e);
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
			} catch (OawFailedException ex) {
				throw ex;
			} catch (Exception e) {
				throw new Exception("Running oAW workflow failed: "
						+ workflowFile+"\n Errors: "+e.getMessage()+". Please see the oAW console output for details!", e);
			}
		}
		return true;
	}

	public String getName() {
		return "Generate Plugin Code";
	}

	public void rollback() throws Exception {
	}
}