package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.opt4j.core.Criterion;

import LqnCore.ActivityDefType;
import LqnCore.ActivityPhasesType;
import LqnCore.EntryType;
import LqnCore.LqnModelType;
import LqnCore.OutputResultType;
import LqnCore.ProcessorType;
import LqnCore.TaskType;
import de.uka.ipd.sdq.dsexplore.analysis.AbstractPerformanceAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EntryLevelSystemCallCriterion;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EvaluationAspectWithContext;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedCriterion;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationServiceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ServiceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn.Pcm2LqnHelper;

public abstract class LQNResult extends AbstractPerformanceAnalysisResult implements ILQNResult{
	
	protected static Logger logger = Logger
	.getLogger("de.uka.ipd.sdq.dsexplore");
	
	protected double meanResponseTime;
	protected double throughput;
	protected double maxUtilization;
	
	protected double squaredCoeffVariance = 1;
	
	private ResultDecoratorRepository results;

	private Map<Criterion, EvaluationAspectWithContext> objectiveToAspects;

	private LQNQualityAttributeDeclaration qualityAttributeInfo;

	

	public LQNResult(PCMInstance pcm, LqnModelType model,
			Criterion criterion, Map<Criterion, EvaluationAspectWithContext> objectiveToAspect,
			LQNQualityAttributeDeclaration qualityAttributeInfo) throws AnalysisFailedException {
		super(pcm);
		try{
			
			this.objectiveToAspects = objectiveToAspect;
			this.qualityAttributeInfo = qualityAttributeInfo;
			
			if (criterion instanceof UsageScenarioBasedCriterion){
				this.meanResponseTime = retrieveResponseTimeForUsageScenario(pcm, model,(UsageScenarioBasedCriterion)criterion);
				this.throughput = retrieveThroughputForUsageScenario(pcm, model, (UsageScenarioBasedCriterion)criterion);
			} else if (criterion instanceof EntryLevelSystemCallCriterion){
				this.meanResponseTime = retrieveResponseTimeForEntryLevelSystemCall(pcm, model,(EntryLevelSystemCallCriterion)criterion);
				this.throughput = retrieveThroughputForEntryLevelSystemCall(pcm, model, (EntryLevelSystemCallCriterion)criterion);
			} else {
				throw new AnalysisFailedException("Unknown criterion type "+criterion.getClass().getName());
			}
			
			this.results =  retrieveResults(pcm, model);
			
			this.maxUtilization = retrieveMaxUtilization(pcm, model, this.results, "CPU");
			
		} catch (ParseException ex) {
			throw new AnalysisFailedException("Failed to parse string value.",
					ex);
		}
	}
	
	private double retrieveMaxUtilization(PCMInstance pcm, LqnModelType model,
			ResultDecoratorRepository results2, String resourceTypeDescription) {
		double maxUtil = 0;
		for (UtilisationResult utilResult : results2.getUtilisationResults_ResultDecoratorRepository()) {
			if (utilResult instanceof ProcessingResourceSpecificationResult){
				ProcessingResourceSpecificationResult procResult = (ProcessingResourceSpecificationResult) utilResult;
				// check resource type
				if (procResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getActiveResourceType_ActiveResourceSpecification().getEntityName().contains(resourceTypeDescription)){
					if (maxUtil < procResult.getResourceUtilisation()){
						maxUtil = procResult.getResourceUtilisation();
					}
				}
				
			}
			
		}
		return maxUtil;
	}

	/**
	 * pcm must be the current candidate's PCM model. 
	 * 
	 * @param pcm
	 * @param model
	 * @return
	 * @throws ParseException
	 */
	private ResultDecoratorRepository retrieveResults(
			PCMInstance pcm, LqnModelType model) throws ParseException {
		
		ResultDecoratorRepository repo = ResultdecoratorFactory.eINSTANCE.createResultDecoratorRepository();

		List<ProcessorType> modifiableProcessorList = retrieveResourceEnvironmentResults(
				pcm, model, repo);
		
		retrieveServiceResults(pcm, repo, modifiableProcessorList);
		
		return repo;
	}

	private void retrieveServiceResults(PCMInstance pcm,
			ResultDecoratorRepository repo,
			List<ProcessorType> modifiableProcessorList) throws ParseException {
		// retrieve response times
		List<Repository> repositories = pcm.getRepositories();
		for (Repository repository : repositories) {
			List<RepositoryComponent> repoComponentList = repository.getComponents__Repository();
			for (RepositoryComponent repositoryComponent : repoComponentList) {
				if (repositoryComponent instanceof BasicComponent){
					BasicComponent basicComponent = (BasicComponent)repositoryComponent;
					// pass the processor list that has already been used, then it does not contain the resources anymore.
					List<ServiceResult> serviceResultList = getServiceResults(basicComponent, modifiableProcessorList);
					repo.getServiceResult_ResultDecoratorRepository().addAll(serviceResultList);
				}
			}
		}
	}

	private List<ProcessorType> retrieveResourceEnvironmentResults(
			PCMInstance pcm, LqnModelType model, ResultDecoratorRepository repo)
			throws ParseException {
		// Retrieve utilisation
		List<ProcessorType> processors = model.getProcessor();
		List<ResourceContainer> containers = pcm.getResourceEnvironment().getResourceContainer_ResourceEnvironment();
		
		//create a new list from that we can remove things without modifying the model
		List<ProcessorType> modifiableProcessorList = new ArrayList<ProcessorType>(processors.size());
		modifiableProcessorList.addAll(processors);
		
		// get results for active resources
		for (ResourceContainer container : containers) {
			for (ProcessingResourceSpecification pcmResource : container.getActiveResourceSpecifications_ResourceContainer()) {
				String processorID = Pcm2LqnHelper.getIdForProcResource(container, pcmResource.getActiveResourceType_ActiveResourceSpecification())+"_Processor";
				
				ProcessingResourceSpecificationResult result = ResourceenvironmentdecoratorFactory.eINSTANCE.createProcessingResourceSpecificationResult();
				
				retrieveUtilResultFromLQN(modifiableProcessorList, processorID,
						result);
				//if the resource has not been found, it has not been used and its utilisation is 0 (the default value). 
				
				result.setProcessingResourceSpecification_ProcessingResourceSpecificationResult(pcmResource);
				result.setEntityName("Utilisation of "+processorID);
				
				repo.getUtilisationResults_ResultDecoratorRepository().add(result);
				
			}
		}
		
		List<LinkingResource> links = pcm.getResourceEnvironment().getLinkingResources__ResourceEnvironment();
		
		for (LinkingResource linkingResource : links) {
			String processorID = Pcm2LqnHelper.getIdForCommResource(linkingResource, linkingResource.getCommunicationLinkResourceSpecifications_LinkingResource().getCommunicationLinkResourceType_CommunicationLinkResourceSpecification())+"_Processor";
			
			LinkingResourceResults result = ResourceenvironmentdecoratorFactory.eINSTANCE.createLinkingResourceResults();
			
			retrieveUtilResultFromLQN(modifiableProcessorList, processorID,
					result);
			//if the resource has not been found, it has not been used and its utilisation is 0 (the default value). 
			
			result.setLinkingResource_LinkingResourceResults(linkingResource);
			result.setEntityName("Utilisation of "+processorID);
			
			repo.getUtilisationResults_ResultDecoratorRepository().add(result);
		}
		
		// results for passive resources
		List<AllocationContext> allAssemblyContexts = EMFHelper.getAllUsedAllocationContexts(pcm.getAllocation());
		for (AllocationContext allocContext : allAssemblyContexts) {
			AssemblyContext assemblyContext = allocContext.getAssemblyContext_AllocationContext();
			RepositoryComponent innerComponent = assemblyContext.getEncapsulatedComponent__AssemblyContext();
			if (innerComponent instanceof BasicComponent){
				
				BasicComponent basicComponent = (BasicComponent) innerComponent;
				List<PassiveResource> passiveResourceOfComponentList = basicComponent
						.getPassiveResource_BasicComponent();
				for (PassiveResource passiveResource : passiveResourceOfComponentList) {

					String passiveResourceId = Pcm2LqnHelper.getIdForPassiveResource(passiveResource, allocContext);
					
					PassiveResourceResult result = ResourceenvironmentdecoratorFactory.eINSTANCE.createPassiveResourceResult();
					
					retrieveUtilResultFromLQN(modifiableProcessorList, passiveResourceId,
							result);
					//if the resource has not been found, it has not been used and its utilisation is 0 (the default value). 
					
					result.setPassiveResource_PassiveResourceResult(passiveResource);
					result.setAssemblyContext_PassiveResourceResult(assemblyContext);
					result.setEntityName("Utilisation of "+passiveResourceId);
					
					
					repo.getUtilisationResults_ResultDecoratorRepository().add(result);
					
				}
		
			}
		}
		return modifiableProcessorList;
				}
		
	/**
	 * Sets utilization, average queue length and average waiting time, if available. 
	 * @param modifiableProcessorList
	 * @param processorID
	 * @param result
	 * @throws ParseException
	 */
	private void retrieveUtilResultFromLQN(
			List<ProcessorType> modifiableProcessorList, String processorID,
			UtilisationResult result) throws ParseException {
				//use iterator to be allowed to modify the list while searching
				Iterator<ProcessorType> lqnProcessorIterator = modifiableProcessorList.iterator();
				while (lqnProcessorIterator.hasNext()){
					ProcessorType lqnProc = lqnProcessorIterator.next();
					if (lqnProc.getName().contains(processorID)){
						
						List<OutputResultType> lqnResultProc = lqnProc.getResultProcessor();
						if (lqnResultProc.size() > 0){
							
							OutputResultType processorResult = lqnResultProc.get(0);
							
							String utilString = (String)processorResult.getUtilization();
							result.setResourceUtilisation(LQNUtils
									.convertStringToDouble(utilString));
							
							// determine waiting times and service times by checking all result entries (contained in the first task)
							double waitingTime = 0;
							double serviceTime = 0;
							
							double totalThroughput = 0;
							
							List<TaskType> resultTask = lqnProc.getTask();
							if (resultTask.size() > 0){
								
								List<EntryType> procTaskEntries = resultTask.get(0).getEntry();
								for (EntryType entryType : procTaskEntries) {
									List<OutputResultType> entryResults = entryType.getResultEntry();
									if (entryResults.size() > 0 ){
										
										OutputResultType entryResult = entryResults.get(0);
										String throughputString = (String)entryResult.getThroughput();
										
										EList<ActivityPhasesType> entryPhaseActivities = entryType.getEntryPhaseActivities().getActivity();
										if (entryPhaseActivities.size() > 0 ){
											List<OutputResultType> activityResults = entryPhaseActivities.get(0).getResultActivity();
											if (activityResults.size() > 0){
												String waitingTimeString = (String)activityResults.get(0).getProcWaiting();
												String serviceTimeString = (String)activityResults.get(0).getServiceTime();
												
												double throughput = LQNUtils.convertStringToDouble(throughputString);
												double entryWaitingTime = LQNUtils.convertStringToDouble(waitingTimeString);
												double entryServiceTime = LQNUtils.convertStringToDouble(serviceTimeString);
												
												// only look at service times greater than one, because the others do not seem to have to wait.
												// weight the current waiting time and service time by the current throughgput to get the overall times. 
												if (entryServiceTime > 0){
													waitingTime = entryWaitingTime * throughput;
													serviceTime = entryServiceTime * throughput;
													totalThroughput += throughput;
												}
												
											}
										}
									}
								}
								
								if (totalThroughput > 0 && serviceTime > 0){
									//	weight waiting time and service time by throughput.
									waitingTime = waitingTime / totalThroughput;
									serviceTime = serviceTime / totalThroughput;
								
									// 	queue length is queue waiting time / queue service time in average
									result.setAverageQueueLength(waitingTime / serviceTime);
									result.setAverageWaitTime(waitingTime);
									if (result instanceof ProcessingResourceSpecificationResult){
										((ProcessingResourceSpecificationResult) result).setDemandedTime(serviceTime);
									}
								}
							}
							

							logger.debug("Resource "+processorID+" has utilisation "+utilString+ " and waiting time "+result.getAverageQueueLength());
						}
						
						//we can remove this element now and do not have to iterate over this one again in the next loop iterations. 
						lqnProcessorIterator.remove();
					}
				}
			}
		
	private List<ServiceResult> getServiceResults(BasicComponent basicComponent, List<ProcessorType> modifiableProcessorResultList) throws ParseException {
		
		
		
		List<ServiceEffectSpecification> seffList = basicComponent.getServiceEffectSpecifications__BasicComponent();
		List<ServiceResult> results = new ArrayList<ServiceResult>(seffList.size());
		
		//Create only one service result per SEFF: weight each response time by throughput and then divide by overall throughput.
		for (ServiceEffectSpecification seff : seffList) {
			
			double overallThroughput = 0;
			double responseTimesTimesThroughputSum = 0;
			
			String processorIDRegex = basicComponent.getEntityName() + "_"
				+ ((OperationSignature)seff.getDescribedService__SEFF()).getInterface__OperationSignature().getEntityName() + "_"
				+ seff.getDescribedService__SEFF().getEntityName(); // + "_*_Processor";
			
			// Obtain processor, representing the SEFF's overall resource demand
			ProcessorType processor = null;
			Iterator<ProcessorType> itProcessors = modifiableProcessorResultList.iterator();
			while (itProcessors.hasNext()) {
				ProcessorType proc = itProcessors.next();
				if (proc.getName().contains(processorIDRegex) && proc.getName().contains("_Processor")) {
					processor = proc;
					itProcessors.remove();
					
					List<TaskType> taskList = processor.getTask();
					if (taskList.size() > 0){

						double responseTime = LQNUtils.getResponseTimeOfSubActivities(taskList.get(0));
						double throughput = 0;
						
						List<EntryType> procTaskEntries = taskList.get(0)
								.getEntry();
						for (EntryType entryType : procTaskEntries) {
							List<OutputResultType> entryResults = entryType
									.getResultEntry();
							if (entryResults.size() > 0) {

								OutputResultType entryResult = entryResults
										.get(0);
								String throughputString = (String) entryResult
										.getThroughput();
								throughput += LQNUtils.convertStringToDouble(throughputString);
							}
						}
						
						responseTimesTimesThroughputSum += responseTime * throughput;
						overallThroughput += throughput;
					}
					
				}
			}
			
			// create result if service has been used
			if (overallThroughput > 0) {
				double overallResponseTime = responseTimesTimesThroughputSum
						/ overallThroughput;

				AllocationServiceResult serviceResult = RepositorydecoratorFactory.eINSTANCE
						.createAllocationServiceResult();

				// FIXME: currently only works with one allocation per seff
				// serviceResult.setAllocationcontext(value);
				serviceResult.setServiceEffectSpecification_ServiceResult(seff);
				serviceResult.setMeanResponseTime(overallResponseTime);
				results.add(serviceResult);
			}
			
		}
		
		return results;
	}

	/**
	 * @param pcm Can be any PCM instance, only the usage model is used. 
	 * @param model
	 * @param criterion
	 * @return
	 * @throws ParseException
	 * @throws AnalysisFailedException
	 */
	private double retrieveResponseTimeForUsageScenario(PCMInstance pcm, LqnModelType model, UsageScenarioBasedCriterion criterion) throws ParseException, AnalysisFailedException {

		ProcessorType processor = getUsageScenarioProcessor(pcm, model,	criterion.getUsageScenario());

		if (processor != null) {

			if (processor.getTask() != null && processor.getTask().size() > 0) {

				// TODO: Can we really assume there is only one task?
				TaskType task = processor.getTask().get(0);

				if (task != null){
					double responseTime = Double.NaN;

					if (task.getResultTask().size() > 0){
						OutputResultType outputResult = task.getResultTask().get(0);

						if (outputResult != null)
							responseTime = LQNUtils.getResponseTimeOfSubActivities(task);

						if (outputResult.getSquaredCoeffVariation() != null) {
							this.squaredCoeffVariance = LQNUtils
							.convertStringToDouble((String) outputResult
									.getSquaredCoeffVariation());
						} 
						return responseTime;
					}
				}


			}
		}
		logger.warn("No task or empty task for processor "
				+ processor.getName()
				+ ". Cannot determine response time, using NaN. Check your models or the LQNResult code.");

		return Double.NaN;

	}
	
	private double retrieveResponseTimeForEntryLevelSystemCall(PCMInstance pcm,
			LqnModelType model, EntryLevelSystemCallCriterion criterion) throws AnalysisFailedException, ParseException {
		
		ProcessorType usageScenarioProcessor = getUsageScenarioProcessor(pcm, model, criterion);
		
		if (usageScenarioProcessor != null) {

			if (usageScenarioProcessor.getTask() != null && usageScenarioProcessor.getTask().size() > 0) {

				OutputResultType entryLevelCallActivityResult =  getResultActivityForEntryLevelSystemCall(
						criterion, usageScenarioProcessor);
				
				if (entryLevelCallActivityResult != null){
					return LQNUtils.convertStringToDouble((String) entryLevelCallActivityResult.getServiceTime());
				}
				
			} 
		}
		logger.warn("No task or empty task for processor or empty activity results"
				+ usageScenarioProcessor.getName()
				+ ". Cannot determine response time, using NaN. Check your models or the LQNResult code.");
		return Double.NaN;
	}

	private OutputResultType getResultActivityForEntryLevelSystemCall(
			EntryLevelSystemCallCriterion criterion,
			ProcessorType usageScenarioProcessor) {
		// TODO: Can we really assume there is only one task?
		TaskType task = usageScenarioProcessor.getTask().get(0);
		
		String entryLevelCallId = Pcm2LqnHelper.getIdForEntryLevelSystemCall(criterion.getEntryLevelSystemCall());
		TreeIterator<Object> allProcessorContentIterator = EcoreUtil.getAllContents(task.getTaskActivities().getActivity(), true);
		OutputResultType activity = findActivityForEntryLevelCallById(entryLevelCallId,
				allProcessorContentIterator);
		
		if (activity == null){

			// the activity might be contained in another processor, e.g. a usage scenario loop processor. 
			TreeIterator<Object> allContentIterator = EcoreUtil.getAllContents(usageScenarioProcessor.eContainer(), true);
			activity = findActivityForEntryLevelCallById(entryLevelCallId, allContentIterator);
		}
		
		return activity;
	}

	private OutputResultType findActivityForEntryLevelCallById(String entryLevelCallId,
			TreeIterator<Object> allProcessorContentIterator) {
		while (allProcessorContentIterator.hasNext()) {
			Object object = allProcessorContentIterator.next();
			
			if (object instanceof ActivityDefType && ((ActivityDefType)object).getName().equals(entryLevelCallId)){
				// this is the entry level system call
				OutputResultType activityResult = ((ActivityDefType)object).getResultActivity().get(0);
				if (activityResult != null){
					return activityResult;
				}
			}
		};
		return null;
	}
	
	/**
	 * 
	 * @param pcm Can be any PCM instance, only the usage model is used.
	 * @param model
	 * @param criterion
	 * @return
	 * @throws AnalysisFailedException 
	 * @throws ParseException 
	 */
	private double retrieveThroughputForUsageScenario(PCMInstance pcm,
			LqnModelType model, UsageScenarioBasedCriterion criterion) throws AnalysisFailedException, ParseException {
		
		ProcessorType processor = getUsageScenarioProcessor(pcm, model,	criterion);
		
		if (processor.getTask() != null && processor.getTask().size() > 0) {
			
			TaskType usageScenarioTask = processor.getTask().get(0);
			if (usageScenarioTask != null && usageScenarioTask.getResultTask().size()>0){
				OutputResultType outputResult = usageScenarioTask.getResultTask().get(0);
				if (outputResult != null){
					return LQNUtils.convertStringToDouble((String)outputResult.getThroughput());
				}
			}
			
		}
		logger.warn("No task or empty task for processor or empty activity results"
				+ processor.getName()
				+ ". Cannot determine throughput, using NaN. Check your models or the LQNResult code.");
		return Double.NaN;
		
	}
	
	private double retrieveThroughputForEntryLevelSystemCall(PCMInstance pcm,
			LqnModelType model, EntryLevelSystemCallCriterion criterion) throws AnalysisFailedException, ParseException {
		ProcessorType usageScenarioProcessor = getUsageScenarioProcessor(pcm, model,	criterion);
		
		if (usageScenarioProcessor != null) {

			if (usageScenarioProcessor.getTask() != null && usageScenarioProcessor.getTask().size() > 0) {

				OutputResultType entryLevelCallActivityResult =  getResultActivityForEntryLevelSystemCall(
						criterion, usageScenarioProcessor);
				
				if (entryLevelCallActivityResult != null){
					return LQNUtils.convertStringToDouble((String) entryLevelCallActivityResult.getThroughput());
				}
				
			} 
		}
		logger.warn("No task or empty task for processor or empty activity results"
				+ usageScenarioProcessor.getName()
				+ ". Cannot determine throughput, using NaN. Check your models or the LQNResult code.");
		
		return Double.NaN;
	}
	
	
	private ProcessorType getUsageScenarioProcessor(PCMInstance pcm,
			LqnModelType model, UsageScenarioBasedCriterion criterion)
	throws AnalysisFailedException {
		UsageScenario currentUsageScenaro = null;
		List<UsageScenario> scenarios = pcm.getUsageModel().getUsageScenario_UsageModel();
		for (UsageScenario usageScenario : scenarios) {
			usageScenario.getId().equals(
					criterion.getUsageScenario().getId());
			currentUsageScenaro = usageScenario;
			break;
		}
		return getUsageScenarioProcessor(pcm, model, currentUsageScenaro);
	}
	
	private ProcessorType getUsageScenarioProcessor(PCMInstance pcm,
			LqnModelType model, EntryLevelSystemCallCriterion criterion)
	throws AnalysisFailedException {
		UsageScenario currentUsageScenaro = null;
		List<UsageScenario> scenarios = pcm.getUsageModel().getUsageScenario_UsageModel();
		UsageScenario scenarioToLookFor = getUsageScenarioOfEObject(criterion.getEntryLevelSystemCall());
		for (UsageScenario usageScenario : scenarios) {
			if (usageScenario.getId().equals(scenarioToLookFor.getId())){
				currentUsageScenaro = usageScenario;
				break;
			}
		}
		return getUsageScenarioProcessor(pcm, model, currentUsageScenaro);
	}

	private UsageScenario getUsageScenarioOfEObject(
			EObject object) {
		EObject container = object.eContainer();
		if (container instanceof UsageScenario){
			return (UsageScenario)container;
		} else {
			if (container != null){
				return getUsageScenarioOfEObject(container);
			}
		}
		return null;
	}

	/**
	 * Get usage scenario processor for a given {@link UsageScenario}. I am not sure here, 
	 * but maybe we have to be careful and  
	 * the {@link UsageScenario} must be the one from the actual PCM model that has been analyzed, 
	 * not the one referenced from the Criterion. These may differ if they have been loaded 
	 * separately several Java objects may represent the same model objects.  
	 * @param pcm
	 * @param model
	 * @param currentUsageScenaro
	 * @return
	 * @throws AnalysisFailedException
	 */
	private ProcessorType getUsageScenarioProcessor(PCMInstance pcm,
			LqnModelType model, UsageScenario currentUsageScenaro)
			throws AnalysisFailedException {

		if (currentUsageScenaro == null){
			throw new AnalysisFailedException("Could not analyse LQN results, because the usage scenario from references QML Criterion is not contained in this PCM model's usage model.");
		}
		
		// Retrieve the usage scenario's name used within the result
		// Remove the number from the id as that may have changed(?) XXX 
		String scenarioName = Pcm2LqnHelper.getIdForUsageScenario(currentUsageScenaro);
		scenarioName = scenarioName.substring(0, scenarioName.lastIndexOf("_")); 
		// \\d stands for a digital number.
		String processorNameRegex = scenarioName + "_\\d+_Processor"; // see class LqnBuilder#getProcessorTypeFromModel(String)
		
		// Obtain processor, representing the usage scenario's overall resource demand
		ProcessorType processor = null;
		Iterator<ProcessorType> itProcessors = model.getProcessor().iterator();
		while (itProcessors.hasNext()) {
			ProcessorType proc = itProcessors.next();
			if (proc.getName().matches(processorNameRegex)) {
				processor = proc;
				break;
			}
		}
		if (processor == null) {
			logger.warn("Could not find LQN processor matching name "
					+ processorNameRegex + ". Cannot determine response time, using NaN. Check your models or the LQNResult code.");
				
		}
		return processor;
	}


	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.lqn.ILQNResult#getMedianValue()
	 */
	public double getMedianValue() {
		return Double.NaN;
	}
	
	@Override
	public double getValueFor(Criterion criterion) {
		EvaluationAspectWithContext aspect = this.objectiveToAspects.get(criterion);
		
		if (aspect != null){
			if (EcoreUtil.equals(aspect.getDimension(), this.qualityAttributeInfo.getResponseTime())){
				return this.getMeanValue();
			} else if (EcoreUtil.equals(aspect.getDimension(), this.qualityAttributeInfo.getThroughput())){
				return this.getThroughput();
			}  else if (EcoreUtil.equals(aspect.getDimension(), this.qualityAttributeInfo.getMaxUtilization())){
				return this.getMaxUtilisation();
			}
		} 
		
		logger.warn("Unknown aspect for LQN result, adding NaN.");
		return Double.NaN;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.lqn.ILQNResult#getMeanValue()
	 */
	public double getMeanValue() {
		return meanResponseTime;
	}
	
	public double getThroughput() {
		return throughput;
	}
	
	public double getMaxUtilisation(){
		return this.maxUtilization;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.lqn.ILQNResult#getSquaredCoefficientOfVariance()
	 */
	public double getSquaredCoefficientOfVariance(){
		return this.squaredCoeffVariance;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.lqn.ILQNResult#getCoefficientOfVariance()
	 */
	public double getCoefficientOfVariance(){
		return  Math.sqrt(this.squaredCoeffVariance);
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.lqn.ILQNResult#getVariance()
	 */
	public double getVariance(){
		double var = this.getSquaredCoefficientOfVariance() * this.getMeanValue() * this.getMeanValue(); 
		return var;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.lqn.ILQNResult#getStandardDeviation()
	 */
	public double getStandardDeviation(){
		double std = Math.sqrt(this.getVariance()); 
		return std;
	}
	
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.lqn.ILQNResult#getResults()
	 */
	public ResultDecoratorRepository getResults() {
		return results;
	}
	

}
