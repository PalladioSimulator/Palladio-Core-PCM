package de.uka.ipd.sdq.codegen.workflow.jobs;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.issues.Issue;
import org.openarchitectureware.workflow.issues.IssuesImpl;

import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;

/**
 * Start the Workflow-Engine of oAW - Generator
 */
public class GenerateOAWCodeJob implements IJob {

	protected Log logger = LogFactory.getLog(GenerateOAWCodeJob.class);
	
	private final static String REPOSITORY_FILE = "codegen_repository.oaw";
	private final static String SYSTEM_FILE = "codegen_system.oaw";
	private final static String USAGE_FILE = "codegen_usage.oaw";

	private final String[] myWorkflowFiles = { REPOSITORY_FILE, SYSTEM_FILE,
			USAGE_FILE };

	private Map<String, String> properties;

	public GenerateOAWCodeJob(Map<String, String> properties) {
		this.properties = new HashMap<String, String>();
		this.properties.putAll(properties);
	}

	public void execute() throws JobFailedException {
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

	public void rollback() {
		// do nothing
	}
}