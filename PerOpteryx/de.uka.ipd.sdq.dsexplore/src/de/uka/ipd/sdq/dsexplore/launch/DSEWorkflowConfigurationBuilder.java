package de.uka.ipd.sdq.dsexplore.launch;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.opt4j.core.DoubleValue;
import org.opt4j.core.Value;

import de.uka.ipd.sdq.dsexplore.analysis.AnalysisProxy;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisQualityAttributes;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer.QualityAttribute;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration.SearchMethod;
import de.uka.ipd.sdq.tcfmoop.config.ElapsedTimeConfig;
import de.uka.ipd.sdq.tcfmoop.config.GivenParetoFrontIsReachedConfig;
import de.uka.ipd.sdq.tcfmoop.config.InsignificantParetoFrontChangeConfig;
import de.uka.ipd.sdq.tcfmoop.config.InsignificantSetQualityImprovementConfig;
import de.uka.ipd.sdq.tcfmoop.config.MaxGenerationNumberConfig;
import de.uka.ipd.sdq.tcfmoop.config.MinimalQualityCriteriaValueConfig;
import de.uka.ipd.sdq.tcfmoop.config.NoNewParetoOptimalCandidatesFoundConfig;
import de.uka.ipd.sdq.tcfmoop.config.ParetoOptimalSetStabilityConfig;
import de.uka.ipd.sdq.tcfmoop.config.ElapsedTimeConfig.TimeType;
import de.uka.ipd.sdq.tcfmoop.config.InsignificantSetQualityImprovementConfig.UnresolvedValueDifference;
import de.uka.ipd.sdq.tcfmoop.config.ParetoOptimalSetStabilityConfig.EvaluationMode;
import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

public class DSEWorkflowConfigurationBuilder extends
		AbstractWorkflowConfigurationBuilder {
	
	/**XXX Quickfix to reset the loggers in the analysis Proxies */
	DSELaunch dseLaunch;

	public DSEWorkflowConfigurationBuilder(ILaunchConfiguration configuration,
			String mode, DSELaunch dseLaunch) throws CoreException {
		super(configuration, mode);
		this.dseLaunch = dseLaunch;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fillConfiguration(
			AbstractWorkflowBasedRunConfiguration abstractConfiguration)
			throws CoreException {
		
		DSEWorkflowConfiguration config = (DSEWorkflowConfiguration)abstractConfiguration;
		
		config.setOriginalConfig(this.configuration);
		
		config.setMaxIterations(getIntAttribute(DSEConstantsContainer.MAX_ITERATIONS));
		config.setIndividualsPerGeneration(getIntAttribute(DSEConstantsContainer.INDIVIDUALS_PER_GENERATION));
		config.setCrossoverRate(getDoubleAttribute(DSEConstantsContainer.CROSSOVER_RATE));
		
		
		config.setPredefinedInstancesFileName(getStringAttribute(DSEConstantsContainer.PREDEFINED_INSTANCES));
		config.setCacheInstancesFileName(getStringAttribute(DSEConstantsContainer.CACHE_INSTANCES));
		config.setPredefinedAllCandidatesFileName(getStringAttribute(DSEConstantsContainer.ALL_CANDIDATES));
		config.setArchiveCandidateFileName(getStringAttribute(DSEConstantsContainer.ARCHIVE_CANDIDATES));
		
		
		String searchMethod = getStringAttribute(DSEConstantsContainer.SEARCH_METHOD);
		if (searchMethod.equals(DSEConstantsContainer.SEARCH_EVOLUTIONARY)){
			config.setSearchMethod(SearchMethod.EVOLUTIONARY);
 		} else if (searchMethod.equals(DSEConstantsContainer.SEARCH_RANDOM)) {
 			config.setSearchMethod(SearchMethod.RANDOM);
 		} else if (searchMethod.equals(DSEConstantsContainer.SEARCH_RULE)) {
 			config.setSearchMethod(SearchMethod.RULE);
 		} else if (searchMethod.equals(DSEConstantsContainer.SEARCH_RULE_OPT)){
 			config.setSearchMethod(SearchMethod.RULE_OPT);
 		}

		
		config.setNewProblem(!this.configuration.getAttribute(DSEConstantsContainer.OPTIMISATION_ONLY, false));
		config.setOptimise(!this.configuration.getAttribute(DSEConstantsContainer.DESIGN_DECISIONS_ONLY, false));
		
		
		/*
		 * Heuristics settings
		 */
		boolean isConsiderQMLBounds = getBooleanAttribute(DSEConstantsContainer.CONSIDER_QML_BOUNDS);
		config.setConsiderQMLBoundsWhenApplyingHeuristics(isConsiderQMLBounds);
		
		double tacticsProbability = getDoubleAttribute(DSEConstantsContainer.TACTICS_PROBABILITY);
		config.setTacticsProbability(tacticsProbability);
		
		boolean isUseReallocation = getBooleanAttribute(DSEConstantsContainer.USE_REALLOCATION);
		config.setUseReallocation(isUseReallocation);
		if (isUseReallocation){
			config.setReallocationThresholdUtilisationDifference(getDoubleAttribute(DSEConstantsContainer.REALLOCATION_UTILISATION_DIFFERENCE));
			config.setReallocationWeight(getDoubleAttribute(DSEConstantsContainer.REALLOCATION_WEIGHT));
		}
		
		boolean isUseProcRate = getBooleanAttribute(DSEConstantsContainer.USE_PROCESSING_RATE);
		config.setUseProcessingRate(isUseProcRate);
		if (isUseProcRate){
			config.setProcessingRateDecreaseFactor(getDoubleAttribute(DSEConstantsContainer.PROCESSING_RATE_DECREASE_FACTOR));
			config.setProcessingRateIncreaseFactor(getDoubleAttribute(DSEConstantsContainer.PROCESSING_RATE_INCREASE_FACTOR));
			config.setProcessingRateThresholdHighUtilisation(getDoubleAttribute(DSEConstantsContainer.PROCESSING_RATE_THRESHOLD_HIGH_UTILISATION));
			config.setProcessingRateThresholdLowUtilisation(getDoubleAttribute(DSEConstantsContainer.PROCESSING_RATE_THRESHOLD_LOW_UTILISATION));
			config.setProcessingRateWeight(getDoubleAttribute(DSEConstantsContainer.PROCESSING_RATE_WEIGHT));
		}
		
		boolean isUseServerConsolidation = getBooleanAttribute(DSEConstantsContainer.USE_SERVER_CONSOLIDATION);
		config.setUseServerConsolidation(isUseServerConsolidation);
		if (isUseServerConsolidation){
			config.setServerConsolidationThresholdLowUtilisation(getDoubleAttribute(DSEConstantsContainer.SERVER_CONSOLIDATION_THRESHOLD_LOW_UTILISATION));
			config.setServerConsolidationWeight(getDoubleAttribute(DSEConstantsContainer.SERVER_CONSOLIDATION_WEIGHT));
		}
		
		boolean isUseServerExpansion = getBooleanAttribute(DSEConstantsContainer.USE_SERVER_EXPANSION);
		config.setUseServerExpansion(isUseServerExpansion);
		if (isUseServerExpansion){
			config.setServerExpansionMaxNumberOfReplacements(getIntAttribute(DSEConstantsContainer.SERVER_EXPANSION_MAX_NUMBER_OF_REPLACEMENTS));
			config.setServerExpansionThresholdHighUtilisation(getDoubleAttribute(DSEConstantsContainer.SERVER_EXPANSION_THRESHOLD_HIGH_UTILISATION));
			config.setServerExpansionWeight(getDoubleAttribute(DSEConstantsContainer.SERVER_EXPANSION_WEIGHT));
		}
		
		boolean isUseLinkRealloc = getBooleanAttribute(DSEConstantsContainer.USE_LINK_REALLOCATION);
		config.setUseLinkReallocationTactic(isUseLinkRealloc);
		
		boolean isUseAntipattern = getBooleanAttribute(DSEConstantsContainer.USE_ANTIPATTERNS);
		config.setUseAntipatternKnowledge(isUseAntipattern);
		
		/*
		 * Starting Population
		 */
		boolean isUseStartingPop = getBooleanAttribute(DSEConstantsContainer.USE_STARTING_POPULATION_HEURISTIC);
		config.setUseStartingPopulationHeuristic(isUseStartingPop);
		if (isUseStartingPop){
			config.setMinNumberOfResourceContainers(getIntAttribute(DSEConstantsContainer.MIN_NUMBER_RESOURCE_CONTAINERS));
			config.setMaxNumberOfResourceContainers(getIntAttribute(DSEConstantsContainer.MAX_NUMBER_RESOURCE_CONTAINERS));
			config.setNumberOfCandidatesPerAllocationLevel(getIntAttribute(DSEConstantsContainer.NUMBER_OF_CANDIDATES_PER_ALLOCATION_LEVEL));
		}
		
		
		
		String ddfilename = this.configuration.getAttribute(DSEConstantsContainer.DESIGN_DECISION_FILE, "");
		if (ddfilename.length() == 0){
			ddfilename = getDefaultDesignDecisionFileName();
		}
		config.setDesignDecisionFileName(ddfilename);
		
		//Write results "next to" allocation model file. 
		String folderPathOnly = getPathToAllocation();
		
		String resultsPath = folderPathOnly+"PerOpteryx_results/";
		File f = new File(resultsPath);
		if (f.exists()){
			if (!f.isDirectory()){
				throw new CoreException(new Status(Status.ERROR,"de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfigurationBuilder","File "+resultsPath+" already exists and is not a directory, please rename that file."));
			}
		} else {
			f.mkdir();
		}
		
		config.setResultFolder(resultsPath);
		
		config.setConfigurationName(this.configuration.getName());
		
		//Initialise Evaluators last
		ArrayList<IAnalysis> evaluators = new ArrayList<IAnalysis>();
		for(QualityAttribute d : new AnalysisQualityAttributes().getAllQualityAttributes()) {
			addEvaluatorsIfSelected(evaluators, d, config);
		}
		//addEvaluatorsIfSelected(evaluators, DSEConstantsContainer.SECURITY, config);
		config.setEvaluators(evaluators);
		
		addTerminationCriteriaSettings(config);
		
		config.setStopOnInitialFailure(getBooleanAttribute(DSEConstantsContainer.STOP_ON_INITIAL_FAILURE));
		config.setResultsAsEMF(getBooleanAttribute(DSEConstantsContainer.STORE_RESULTS_AS_EMF));
		config.setResultsAsCSV(!getBooleanAttribute(DSEConstantsContainer.STORE_RESULTS_AS_EMF));

	}

	private void addEvaluatorsIfSelected(ArrayList<IAnalysis> evaluators,
			QualityAttribute d, DSEWorkflowConfiguration config) throws CoreException {
	    
		String methodName = configuration.getAttribute(DSEConstantsContainer.getAnalysisMethod(d), "");
		if (!methodName.equals(DSEConstantsContainer.NONE)){
	    	AnalysisProxy analysis = new AnalysisProxy(config, d, this.dseLaunch, methodName);
	    	evaluators.add(analysis);
	    }
		
	}


	private String getPathToAllocation() throws CoreException {
		String allocFileName = this.configuration.getAttribute(ConstantsContainer.ALLOCATION_FILE, "");
		String folderPathOnly = getPathTo(allocFileName);
		if ("".equals(folderPathOnly)){
			throw new CoreException(new Status(Status.ERROR,"de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfigurationBuilder","Cannot determine path to allocation model to decide where to put the result files. Please check you allocation model."));
		}
		return folderPathOnly;
	}
	
	   /**
	 * Reads an attribute from the configurations and tries to parse it as an integer. 
	 * @param configuration The {@link ILaunchConfiguration}
	 * @param key The key under which the attribute is stored
	 * @param defaultValue A default value if the attribute is not found
	 * @return An integer value for the attribute, 0 if parsing was unsuccessful
	 * @throws CoreException thrown by {@link ILaunchConfiguration#getAttribute(String, String)}
	 */
	private int getIntAttribute(String key)
			throws CoreException {
		String stringValue = configuration.getAttribute(key, "0");
		if (stringValue.equals("")){
			return 0;
		} else {
			int i = Integer.parseInt(stringValue);
			return i;
		}
	}
	

	private String getDefaultDesignDecisionFileName() throws CoreException {
		String problemName = this.configuration.getName();
		return getPathToAllocation()+problemName+".designdecision";
	}
	
	/**returns the path including the last slash */
	private String getPathTo(String fileURL){
		// if this is a platform URL, first resolve it to an absolute path
		if (fileURL.startsWith("platform:")){
			try {
				URL solvedURL = FileLocator.resolve(new URL(fileURL));
				fileURL =  solvedURL.getPath();
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			} 
		} 

		// now this should be an absolute path, but it can have either slashes or backslashes
		int indexBackslash = fileURL.lastIndexOf("\\");
		int indexSlash = fileURL.lastIndexOf("/");
		// the right directory separator is the one where the above results in the higher index (assuming that linux file systems do not allow backslashes in file names...)
		int index = indexBackslash > indexSlash ? indexBackslash : indexSlash; 
		String folderPath = fileURL.substring(0, index+1); 
		return folderPath;

	}
	
	private void addTerminationCriteriaSettings(DSEWorkflowConfiguration config) throws CoreException {
		config.setUseTerminationCriteria(this.getBooleanAttribute(DSEConstantsContainer.TC_GENERAL_USE_TERMINATION_CRITERIA));
		
		if(config.getUseTerminationCriteria()){
			config.setRunInComparisionMode(this.getBooleanAttribute(DSEConstantsContainer.TC_GENERAL_COMPARISION_MODE));
			
			config.setActivateComposedTerminationCriteria(this.getBooleanAttribute(DSEConstantsContainer.TC_COMPOSED_CRITERIA_ACTIVATE));
			if(config.getActivateComposedTerminationCriteria()){
				config.setComposedCriteriaExpression(this.getStringAttribute(DSEConstantsContainer.TC_COMPOSED_CRITERIA_EXPRESSION));
			}
			
			//Maximum Generation Number Criterion
			if(getBooleanAttribute(DSEConstantsContainer.TC_MAX_NUM_OF_GEN_ACTIVATE)){
				try {
					MaxGenerationNumberConfig mgnc = new MaxGenerationNumberConfig();
					mgnc.setMaximumNumberOfIterations(this.getIntegerAttribute(DSEConstantsContainer.TC_MAX_NUM_OF_GEN_LIMIT));
					config.getTCConfigurations().add(mgnc);
				} catch (InvalidConfigException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			//Elapsed Time Criterion
			if (getBooleanAttribute(DSEConstantsContainer.TC_ELAPSED_TIME_ACTIVATE)) {
				try {
					ElapsedTimeConfig etc = new ElapsedTimeConfig();
					etc.setExecutionInterval(this.getIntegerAttribute(DSEConstantsContainer.TC_ELAPSED_TIME_TIME_LIMIT)*60*1000L);
					if (getStringAttribute(DSEConstantsContainer.TC_ELAPSED_TIME_TYPE).equalsIgnoreCase("USER_TIME")) {
						etc.setTimeType(TimeType.USER_TIME);
						config.getTCConfigurations().add(etc);
					} else if (getStringAttribute(DSEConstantsContainer.TC_ELAPSED_TIME_TYPE).equalsIgnoreCase("CPU_TIME")) {
						etc.setTimeType(TimeType.CPU_TIME);
						etc.setExecutionInterval(this.getIntegerAttribute(DSEConstantsContainer.TC_ELAPSED_TIME_TIME_LIMIT)*60*1000L);
						config.getTCConfigurations().add(etc);
					}
				} catch (InvalidConfigException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			//No New Pareto Optimal Candidates Found Criterion
			if(getBooleanAttribute(DSEConstantsContainer.TC_NO_NEW_CANDIDATES_ACTIVATE)){
				try {
					NoNewParetoOptimalCandidatesFoundConfig nnpocf = new NoNewParetoOptimalCandidatesFoundConfig();
					nnpocf.setIterationsWithoutNewCandidates(this.getIntegerAttribute(DSEConstantsContainer.TC_NO_NEW_CANDIDATES_ITERATIONS_WITHOUT));
					config.getTCConfigurations().add(nnpocf);
				} catch (InvalidConfigException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Pareto Optimal Set Stability
			if(getBooleanAttribute(DSEConstantsContainer.TC_SET_STABILITY_ACTIVATE)){
				try {
					ParetoOptimalSetStabilityConfig poss = new ParetoOptimalSetStabilityConfig();
					poss.setMinimumIterationsToSurvive(this.getIntegerAttribute(DSEConstantsContainer.TC_SET_STABILITY_MINIMUM_ITERATION_TO_SURVIVE));
					if(getStringAttribute(DSEConstantsContainer.TC_SET_STABILITY_MODE).equalsIgnoreCase("EXACT_NUMBER")){
						poss.setEvaluationMode(EvaluationMode.EXACT_NUMBER);
						poss.setMinimumSurvivors(this.getIntegerAttribute(DSEConstantsContainer.TC_SET_STABILITY_NUMBER_OF_SURVIVORS_EXACT));
					}else if(getStringAttribute(DSEConstantsContainer.TC_SET_STABILITY_MODE).equalsIgnoreCase("PERCENTAGE")){
						poss.setEvaluationMode(EvaluationMode.PERCENTAGE);
						poss.setMinimumSurvivorsInPercentage(this.getIntegerAttribute(DSEConstantsContainer.TC_SET_STABILITY_NUMBER_OF_SURVIVORS_PERCENTAGE) / 100.0);
					}
					config.getTCConfigurations().add(poss);
				} catch (InvalidConfigException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Minimal Quality Criteria Value
			if(getBooleanAttribute(DSEConstantsContainer.TC_MINIMAL_VALUES_ACTIVATE)){
				try {
					MinimalQualityCriteriaValueConfig mqcvc = new MinimalQualityCriteriaValueConfig();
					mqcvc.setNumberOfCandidatesToConform(this.getIntegerAttribute(DSEConstantsContainer.TC_MINIMAL_VALUES_CANDIDATES_TO_CONFORM));
					
					String[] configuredObjectivesLines = getStringAttribute(DSEConstantsContainer.TC_MINIMAL_VALUES_CONFIGURED_OBJECTIVES).split(";");
					List<String[]> decodedLines = new LinkedList<String[]>();
					for(String item : configuredObjectivesLines){
						decodedLines.add(item.split("\\|"));
					}
					
					Map<String, Value<?>> unresolvedObjectives = new HashMap<String, Value<?>>();
					for (String[] singleLine : decodedLines) {
						unresolvedObjectives.put(singleLine[0], new DoubleValue(Double.parseDouble(singleLine[1])));
					}
					
					mqcvc.setUnresolvedObjectiveMinimalValue(unresolvedObjectives);
					config.getTCConfigurations().add(mqcvc);
				} catch (InvalidConfigException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//A Given Pareto Front is Reached
			if(getBooleanAttribute(DSEConstantsContainer.TC_PARETO_FRONT_IS_REACHED_ACTIVATE)){
				try {
					GivenParetoFrontIsReachedConfig gpfir = new GivenParetoFrontIsReachedConfig();
					gpfir.setParetoFrontFile(getStringAttribute(DSEConstantsContainer.TC_PARETO_FRONT_IS_REACHED_PATH_TO_FRONT_FILE));
					gpfir.setPercentagesToCover(this.getIntegerAttribute(DSEConstantsContainer.TC_PARETO_FRONT_IS_REACHED_PERCENTAGES_TO_COVER)/100d);
					config.getTCConfigurations().add(gpfir);
				} catch (InvalidConfigException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Insignificant Set Quality Improvement
			if(getBooleanAttribute(DSEConstantsContainer.TC_INSIGNIFICANT_SET_IMPROVEMENT_ACTIVATE)){
				try {
					InsignificantSetQualityImprovementConfig isqic = new InsignificantSetQualityImprovementConfig();
					isqic.setComparisionGenerations(configuration.getAttribute(DSEConstantsContainer.TC_INSIGNIFICANT_SET_IMPROVEMENT_GENERATION_X, 1));
					
					String[] configuredObjectivesLines = getStringAttribute(DSEConstantsContainer.TC_INSIGNIFICANT_SET_IMPROVEMENT_CONFIGURED_OBJECTIVES).split(";");
					List<String[]> decodedLines = new LinkedList<String[]>();
					for(String item : configuredObjectivesLines){
						decodedLines.add(item.split("\\|"));
					}
					
					List<UnresolvedValueDifference> unresolvedValueDifferences = new LinkedList<UnresolvedValueDifference>();

					for(String[] singleLine : decodedLines){
						unresolvedValueDifferences.add(isqic.new UnresolvedValueDifference(singleLine[0], Double.parseDouble(singleLine[1])/100d, Double.parseDouble(singleLine[2])/100d));
					}

					isqic.setUnresolvedValueDifferences(unresolvedValueDifferences);
					config.getTCConfigurations().add(isqic);
				} catch (InvalidConfigException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Insignificant Pareto Front Change
			if(getBooleanAttribute(DSEConstantsContainer.TC_INSIGNIFICANT_FRONT_CHANGE_ACTIVATE)){
				try {
					InsignificantParetoFrontChangeConfig ipfc = new InsignificantParetoFrontChangeConfig();
					ipfc.setPastIterationNumber(this.getIntegerAttribute(DSEConstantsContainer.TC_INSIGNIFICANT_FRONT_CHANGE_GENERATION_X));
					ipfc.setMinimumAllowedDifference(this.getIntegerAttribute(DSEConstantsContainer.TC_INSIGNIFICANT_FRONT_CHANGE_IMPROVEMENT)/100d);
					config.getTCConfigurations().add(ipfc);
				} catch (InvalidConfigException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
