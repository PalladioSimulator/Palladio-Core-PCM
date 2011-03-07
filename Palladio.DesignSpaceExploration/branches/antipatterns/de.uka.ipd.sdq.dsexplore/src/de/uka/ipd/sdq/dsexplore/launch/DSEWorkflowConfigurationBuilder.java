package de.uka.ipd.sdq.dsexplore.launch;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.analysis.AnalysisProxy;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration.SearchMethod;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;

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
		
		String searchMethod = getStringAttribute(DSEConstantsContainer.SEARCH_METHOD);
		if (searchMethod.equals(DSEConstantsContainer.SEARCH_EVOLUTIONARY)){
			config.setSearchMethod(SearchMethod.EVOLUTIONARY);
 		} else if (searchMethod.equals(DSEConstantsContainer.SEARCH_RANDOM)) {
 			config.setSearchMethod(SearchMethod.RANDOM);
 		} if (searchMethod.equals(DSEConstantsContainer.SEARCH_RULE)) {
 			config.setSearchMethod(SearchMethod.RULE);
 		}

		
		config.setNewProblem(!this.configuration.getAttribute(DSEConstantsContainer.OPTIMISATION_ONLY, false));
		config.setOptimise(!this.configuration.getAttribute(DSEConstantsContainer.DESIGN_DECISIONS_ONLY, false));
		
		
		/*
		 * Heuristics settings
		 */
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
		addEvaluatorsIfSelected(evaluators, DSEConstantsContainer.PERFORMANCE, config);
		addEvaluatorsIfSelected(evaluators, DSEConstantsContainer.RELIABILITY, config);
		addEvaluatorsIfSelected(evaluators, DSEConstantsContainer.COST, config);
		//addEvaluatorsIfSelected(evaluators, DSEConstantsContainer.SECURITY, config);
		config.setEvaluators(evaluators);

	}

	private void addEvaluatorsIfSelected(ArrayList<IAnalysis> evaluators,
			String quality, DSEWorkflowConfiguration config) throws CoreException {
	    if (isAnalysisEnabledFor(quality)){
	    	String methodName = configuration.getAttribute(DSEConstantsContainer.getAnalysisMethod(quality), "");
	    	AnalysisProxy analysis = new AnalysisProxy(this.configuration, quality, this.dseLaunch, methodName);
	    	evaluators.add(analysis);
	    }
		
	}

	private boolean isAnalysisEnabledFor(String quality) throws CoreException {
		return !this.configuration.getAttribute(DSEConstantsContainer.getAnalysisMethod(quality), "").equals(DSEConstantsContainer.NONE);
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
	
	/**returns the path including the last /*/
	private String getPathTo(String fileURL){
		int index = fileURL.lastIndexOf("\\");
		String folderPath = fileURL.substring(0, index+1); 
		return folderPath;
	}
	

}
