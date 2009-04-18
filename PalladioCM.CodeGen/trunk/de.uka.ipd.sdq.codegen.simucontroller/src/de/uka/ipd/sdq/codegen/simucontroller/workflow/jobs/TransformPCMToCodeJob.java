package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.issues.Issue;
import org.openarchitectureware.workflow.issues.IssuesImpl;
import org.openarchitectureware.xpand2.output.Outlet;

import de.uka.ipd.sdq.codegen.runconfig.ConstantsContainer;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractPCMWorkflowRunConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.codegen.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.UserCanceledException;

/**
 * Start the Workflow-Engine of oAW - Generator
 */
public class TransformPCMToCodeJob 
extends OrderPreservingBlackboardCompositeJob<MDSDBlackboard>
implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

	private static final String SIMULATION_TEMPLATE = "simulation_template_methods";

	private static final String REPOSITORY_ROOT_EXPAND_EXPRESSION = "m2t_transforms::repository::Root FOR pcmmodel";
	private static final String SYSTEM_ROOT_EXPAND_EXPRESSION     = "m2t_transforms::system::Root FOR system";
	private static final String ALLOCATION_ROOT_EXPAND_EXPRESSION = "m2t_transforms::allocation::AllocationTM FOR allocation";
	private static final String USAGE_ROOT_EXPAND_EXPRESSION 	  = "m2t_transforms::usage::UsageModel(allocation) FOR usage";

//	protected Logger logger = Logger.getLogger(GenerateOAWCodeJob.class);
//	
//	private final static String REPOSITORY_FILE = "codegen_repository.oaw";
//	private final static String SYSTEM_FILE = "codegen_system.oaw";
//	private final static String USAGE_FILE = "codegen_usage.oaw";
//
//	private final String[] myWorkflowFiles = { USAGE_FILE };
//
//	private Map<String, String> properties;

	private SimuComWorkflowConfiguration configuration = null;

	public TransformPCMToCodeJob(SimuComWorkflowConfiguration configuration) {
		super();
		
		this.configuration  = configuration;
		
		// this.properties = new HashMap<String, String>();
		// setupOAWProperties(configuration);
	}

//	private void setupOAWProperties(SimuComWorkflowConfiguration configuration) {
//		properties.put(ConstantsContainer.AOP_TEMPLATE, SIMULATION_TEMPLATE );
//		properties.put(ConstantsContainer.REPOSITORY_FILE, configuration
//				.getRepositoryFile());
//		properties.put(ConstantsContainer.MWREPOSITORY_FILE, configuration
//				.getMiddlewareFile());
//		properties.put(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, configuration
//				.getResourceTypeFile());
//		properties.put(ConstantsContainer.SYSTEM_FILE, configuration
//				.getSystemFile());
//		properties.put(ConstantsContainer.ALLOCATION_FILE, configuration
//				.getAllocationFile());
//		properties.put(ConstantsContainer.USAGE_FILE, configuration
//				.getUsageModelFile());
//		properties.put(ConstantsContainer.FEATURE_FILE, configuration
//				.getFeatureConfigFile());
//		
//		String basePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() 
//							+ "/" +
//							(configuration.isSensitivityAnalysisEnabled() 
//									? configuration.getGeneratedPluginId()+"."+configuration.getSensitivityAnalysisConfiguration().getRunNo() 
//									: configuration.getGeneratedPluginId()) 
//							+ "/" + "src";
//		
//		properties.put(ConstantsContainer.EAROUT_PATH, basePath);
//		properties.put(ConstantsContainer.INTERFACESOUT_PATH, basePath);
//		properties.put(ConstantsContainer.CLIENTOUT_PATH, basePath);
//		properties.put(ConstantsContainer.EJBSOUT_PATH, basePath);
//		properties.put(ConstantsContainer.SIMULATE_LINKING_RESOURCES, 
//				configuration.getSimulateLinkingResources() ? "true" : "false");
//		
//		if (configuration.isSensitivityAnalysisEnabled()) {
//			properties.put(ConstantsContainer.VARIABLE_TEXT, configuration.getSensitivityAnalysisConfiguration().getVariable());
//			properties.put(ConstantsContainer.MINIMUM_TEXT, configuration.getSensitivityAnalysisConfiguration().getMin()+"");
//			properties.put(ConstantsContainer.MAXIMUM_TEXT, configuration.getSensitivityAnalysisConfiguration().getMax()+"");
//			properties.put(ConstantsContainer.STEP_WIDTH_TEXT, configuration.getSensitivityAnalysisConfiguration().getStep()+"");
//			properties.put(ConstantsContainer.RUN_NO, configuration.getSensitivityAnalysisConfiguration().getRunNo()+"");
//		} else {
//			properties.put(ConstantsContainer.VARIABLE_TEXT, "");
//			properties.put(ConstantsContainer.MINIMUM_TEXT, "");
//			properties.put(ConstantsContainer.MAXIMUM_TEXT, "");
//			properties.put(ConstantsContainer.STEP_WIDTH_TEXT, "");
//			properties.put(ConstantsContainer.RUN_NO, "1");
//		}
//
//		properties.put(ConstantsContainer.SIMULATE_LINKING_RESOURCES, configuration
//				.getSimulateLinkingResources() ? "true" : "false");
//	}
//
//	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
//		if (properties.isEmpty())
//			throw new JobFailedException("Setting up properties failed");
//
//		Map<String, Object> slotContents = new HashMap<String, Object>();
//
//		IProgressMonitor subProgressMonitor = new SubProgressMonitor(monitor,1);
//		subProgressMonitor.beginTask("Generate with oAW source files", myWorkflowFiles.length + 1);
//		
//		getGeneratorJob(getRepositoryTransformationSlots(), REPOSITORY_ROOT_EXPAND_EXPRESSION);
//		
//		for (String workflowFile : myWorkflowFiles) {
//			if (monitor.isCanceled())
//				throw new UserCanceledException();
//			generateFile(slotContents, workflowFile);
//			subProgressMonitor.worked(1);
//		}
//		properties.put("repositoryFile", properties
//				.get("mwRepositoryFile"));
//		generateFile(slotContents, REPOSITORY_FILE);
//		
//		subProgressMonitor.worked(1);
//		subProgressMonitor.done();
//	}

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		// First generate the jobs
		// 1. Generate the repository
		this.addJob(this.getGeneratorJob(getRepositoryTransformationSlots(), REPOSITORY_ROOT_EXPAND_EXPRESSION));
		
		// 2. Generate the system
		this.addJob(this.getGeneratorJob(getSystemTransformationSlots(), SYSTEM_ROOT_EXPAND_EXPRESSION));
		
		// 3. Generate the allocation
		this.addJob(this.getGeneratorJob(getSystemTransformationSlots(), ALLOCATION_ROOT_EXPAND_EXPRESSION));

		// 4. Generate the usgae
		this.addJob(this.getGeneratorJob(getSystemTransformationSlots(), USAGE_ROOT_EXPAND_EXPRESSION));
		
		// Now let them run
		super.execute(monitor);
	}

	/**
	 * @param slots 
	 * @param monitor
	 * @throws JobFailedException
	 * @throws UserCanceledException
	 */
	private XpandGeneratorJob getGeneratorJob(
			HashMap<String, EObject> slots,
			String expression) {
		XpandGeneratorJob job = new XpandGeneratorJob(
				slots,
				AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES,
				getPCMOutlets(),
				expression);
		job.setAdvice(SIMULATION_TEMPLATE);
		job.setCheckProtectedRegions(true);
		
		return job;
	}

	/**
	 * @return
	 */
	private Outlet[] getPCMOutlets() {
		Outlet defaultOutlet = new Outlet(getBasePath());
		Outlet interfaces = new Outlet(getBasePath());
		interfaces.setName("INTERFACES");
		
		return new Outlet[]{defaultOutlet,interfaces};
	}

	/**
	 * @return
	 */
	private HashMap<String, EObject> getSystemTransformationSlots() {
		HashMap<String,EObject> sC2 = new HashMap<String, EObject>();
		PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.myBlackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		
		sC2.put("middleware",pcmPartition.getMiddlewareRepository());
		sC2.put("featureConfig",pcmPartition.getFeatureConfig());
		sC2.put("system",pcmPartition.getSystem());
		sC2.put("allocation",pcmPartition.getAllocation());
		sC2.put("usage",pcmPartition.getUsageModel());
		return sC2;
	}

	/**
	 * @return
	 */
	private HashMap<String, EObject> getRepositoryTransformationSlots() {
		HashMap<String,EObject> sC2 = new HashMap<String, EObject>();
		PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.myBlackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		sC2.put("pcmmodel",pcmPartition.getRepository());
		return sC2;
	}
	
//	private void generateFile(Map<String, Object> slotContents,
//			String workflowFile) throws JobFailedException {
//		try {
//			IssuesImpl issues = new IssuesImpl();
//			WorkflowRunner runner = new WorkflowRunner();
//			runner.prepare(workflowFile, null, properties);
//
//			logger.info("Calling openArchitectureWare for file "+workflowFile);
//			if (!runner.executeWorkflow(slotContents, issues)) {
//				String message = "";
//				for (Issue i : issues.getErrors()) {
//					message += i.getMessage() + " [" + i.getElement() + "]";
//				}
//				throw new OawFailedException(
//						"Generator failed, given model is most likely invalid in "
//								+ workflowFile + ". Issues given: "
//								+ message);
//			}
//		} catch (Exception e) {
//			throw new JobFailedException("Running oAW workflow failed: "
//					+ workflowFile + "\n Errors: " + e.getMessage()
//					+ ". Please see the oAW console output for details!", e);
//		}
//	}
	
	private String getBasePath() {
		String basePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() 
		+ "/" +
		(this.configuration.isSensitivityAnalysisEnabled() 
				? this.configuration.getPluginID()+"."+this.configuration.getSensitivityAnalysisConfiguration().getRunNo() 
				: this.configuration.getPluginID()) 
		+ "/" + "src";
		
		return basePath;
	}

	public String getName() {
		return "Generate SimuCom Plugin Code";
	}
}