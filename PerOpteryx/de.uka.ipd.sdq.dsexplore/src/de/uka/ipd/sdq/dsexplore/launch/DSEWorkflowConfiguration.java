package de.uka.ipd.sdq.dsexplore.launch;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

/**
 * Configuration for a PerOpteryx run.
 * 
 * Contains different types of information:
 * <ul>
 * <li>Inherits the PCM model information</li>
 * <li>Contains information on the run, such as max iterations</li>
 * <li>Contains the raw ILaunchConfiguration in order to derive SimuCom and
 * PCMSolver configuration (TODO: refactor, make this a composite configuration
 * and initialise the proper configurations earlier. Make the analysis extension
 * provide access to the appropriate configuration builder.)</li>
 * </ul>
 * 
 * @author martens
 * 
 */
public class DSEWorkflowConfiguration extends
AbstractPCMWorkflowRunConfiguration {
	
	public enum SearchMethod{
		EVOLUTIONARY,
		RANDOM,
		RULE,
		RULE_OPT
	};
	
	private ILaunchConfiguration rawConfiguration;

	private ILaunchConfiguration originalConfig;
	
	private List<IAnalysis> evaluators = Collections.emptyList();
	
	private String decimalFormat = "0.#######";
	
	/**
	 * A default to be overridden by the settings in the run dialog.
	 */
	private int maxIterations = Integer.MAX_VALUE;
	private double mrtRequirements = 0;
	private int individualsPerGeneration = 5;
	private double crossoverRate = 0.5;
	
	private double maxCost = 0;
	private double maxPOFOD = 0;
	
	private boolean newProblem;
	private boolean optimise;

	private String designDecisionFileName;
	private String resultFolder;

	private String configurationName;
	
	/**
	 * Settings for the termination criteria
	 */
	
	private boolean useTerminationCriteria = false;
	public void setUseTerminationCriteria(boolean useTerminationCriteria){
		this.useTerminationCriteria = useTerminationCriteria;
	}
	public boolean getUseTerminationCriteria(){
		return this.useTerminationCriteria;
	}
	
	private boolean runInComparisionMode = false;
	public void setRunInComparisionMode(boolean runInComparisionMode){
		this.runInComparisionMode = runInComparisionMode;
	}
	public boolean getRunInComparisionMode(){
		return this.runInComparisionMode;
	}
	
	private boolean activateComposedTerminationCriteria = false;
	public void setActivateComposedTerminationCriteria(boolean activateComposedTerminationCriteria){
		this.activateComposedTerminationCriteria = activateComposedTerminationCriteria;
	}
	public boolean getActivateComposedTerminationCriteria(){
		return this.activateComposedTerminationCriteria;
	}
	
	private String composedCriteriaExpression = "";
	public void setComposedCriteriaExpression(String expression){
		this.composedCriteriaExpression = expression;
	}
	public String getComposedCriteriaExpression(){
		return this.composedCriteriaExpression;
	}
	
	private List<IConfiguration> tcConfigurations = new LinkedList<IConfiguration>();
	public void setTCConfigurations(List<IConfiguration> tcConfigurations){
		this.tcConfigurations = tcConfigurations;
	}
	public List<IConfiguration> getTCConfigurations(){
		return this.tcConfigurations;
	}
	
	
	/**
	 * Setting for heuristics
	 */
	private boolean considerQMLBoundsWhenApplyingHeuristics;
	private double tacticsProbability = DSEConstantsContainer.TACTICS_PROBABILITY_DEFAULT;
	
	private boolean useReallocation;
	private double reallocationThresholdUtilisationDifference;
	private double reallocationWeight;
	
	private boolean useProcessingRate;
	private double processingRateThresholdLowUtilisation;
	private double processingRateThresholdHighUtilisation;
	private double processingRateDecreaseFactor;
	private double processingRateIncreaseFactor;
	private double processingRateWeight;
	
	private boolean useServerConsolidation;
	private double serverConsolidationThresholdLowUtilisation;
	private double serverConsolidationWeight;
	
	private boolean useServerExpansion;
	private double serverExpansionThresholdHighUtilisation;
	private int serverExpansionMaxNumberOfReplacements;
	private double serverExpansionWeight;
	
	private int minNumberOfResourceContainers;
	private int maxNumberOfResourceContainers;
	private int numberOfCandidatesPerAllocationLevel;
	

	
	public final String startTimestamp;

	private SearchMethod searchMethod = SearchMethod.EVOLUTIONARY;
	

	/*
	 * Starting population heuristic
	 */
	private boolean useStartingPopulationHeuristic;

	private boolean useLinkReallocationTactic;
	
	private boolean useAntipatternKnowledge;

	private boolean stopOnInitialFailure;

	private boolean resultsAsEMF;

	private boolean resultsAsCSV;

	private String predefinedInstancesFileName = "";
	private String cacheInstancesFileName = "";
	private String predefinedAllCandidatesFileName = "";
	private String archiveCandidateFileName = "";




	/**
	 * @return the useStartingPopulationHeuristic
	 */
	public boolean getUseStartingPopulationHeuristic() {
		return useStartingPopulationHeuristic;
	}

	/**
	 * @param useStartingPopulationHeuristic the useStartingPopulationHeuristic to set
	 */
	public void setUseStartingPopulationHeuristic(boolean useStartingPopulationHeuristic) {
		this.useStartingPopulationHeuristic = useStartingPopulationHeuristic;
	}

	/**
	 * @return the minNumberOfResourceContainers
	 */
	public int getMinNumberOfResourceContainers() {
		return minNumberOfResourceContainers;
	}

	/**
	 * @param minNumberOfResourceContainers the minNumberOfResourceContainers to set
	 */
	public void setMinNumberOfResourceContainers(int minNumberOfResourceContainers) {
		this.minNumberOfResourceContainers = minNumberOfResourceContainers;
	}

	/**
	 * @return the maxNumberOfResourceContainers
	 */
	public int getMaxNumberOfResourceContainers() {
		return maxNumberOfResourceContainers;
	}

	/**
	 * @param maxNumberOfResourceContainers the maxNumberOfResourceContainers to set
	 */
	public void setMaxNumberOfResourceContainers(int maxNumberOfResourceContainers) {
		this.maxNumberOfResourceContainers = maxNumberOfResourceContainers;
	}

	/**
	 * @return the numberOfCandidatesPerAllocationLevel
	 */
	public int getNumberOfCandidatesPerAllocationLevel() {
		return numberOfCandidatesPerAllocationLevel;
	}

	/**
	 * @param numberOfCandidatesPerAllocationLevel the numberOfCandidatesPerAllocationLevel to set
	 */
	public void setNumberOfCandidatesPerAllocationLevel(int numberOfCandidatesPerAllocationLevel) {
		this.numberOfCandidatesPerAllocationLevel = numberOfCandidatesPerAllocationLevel;
	}


	public DSEWorkflowConfiguration()  {
		String DATE_FORMAT_NOW = "yyyy-MM-dd-HHmmss";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		this.startTimestamp = sdf.format(cal.getTime());
	}
	
	public String getDecimalFormat() {
		return decimalFormat;
	}
	
	public ILaunchConfiguration getOriginalConfig() {
		return originalConfig;
	}

	public void setOriginalConfig(ILaunchConfiguration originalConfig) {
		this.originalConfig = originalConfig;
	}

	public void setMaxIterations(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	public void setMrtRequirements(double mrtRequirements) {
		this.mrtRequirements = mrtRequirements;
	}

	public void setIndividualsPerGeneration(int individualsPerGeneration) {
		this.individualsPerGeneration = individualsPerGeneration;
	}

	public void setMaxCost(double maxCost) {
		this.maxCost = maxCost;
	}

	public void setMaxPOFOD(double maxPOFOD) {
		this.maxPOFOD = maxPOFOD;
	}

	public void setNewProblem(boolean newProblem) {
		this.newProblem = newProblem;
	}

	public void setOptimise(boolean optimise) {
		this.optimise = optimise;
	}

	public void setDesignDecisionFileName(String designDecisionFileName) {
		this.designDecisionFileName = designDecisionFileName;
	}

	public void setConfigurationName(String configurationName) {
		this.configurationName = configurationName;
	}

	public int getMaxIterations() {
		return maxIterations;
	}

	public int getIndividualsPerGeneration() {
		return individualsPerGeneration;
	}

	public boolean isNewProblem() {
		return newProblem;
	}

	public boolean isOptimise() {
		return optimise;
	}
	
	public double getMrtRequirements() {
		return mrtRequirements;
	}



	public double getMaxCost() {
		return maxCost;
	}



	public double getMaxPOFOD() {
		return maxPOFOD;
	}

	@Override
	public String getErrorMessage() {
		return null;
	}

	@Override
	public void setDefaults() {
		
	}
	
	public ILaunchConfiguration getOriginalConfiguration(){
		return this.originalConfig;
	}



	public boolean hasPredefinedInstances() throws CoreException {
		return this.getPredefinedInstancesFileName() != "" 
			|| this.getPredefinedAllCandidatesFileName() != "" 
			|| this.getArchiveCandidateFileName() != "" ;
	}
 
	public boolean isRandomSearch() {
		return this.searchMethod == SearchMethod.RANDOM;
	}
	
	public boolean isRuleBasedSearch() {
		return 
			(this.searchMethod == SearchMethod.RULE
				|| this.searchMethod == SearchMethod.RULE_OPT);
	}
	
	/**
	 * Returns whether the rule based search should explore the full search 
	 * tree up to the depth given by the number of iterations. 
	 * Otherwise, suboptimal candidates are pruned and not further 
	 * explored per iteration. 
	 * @return
	 */
	public boolean isFullRuleBasedSearch(){
		return this.searchMethod == SearchMethod.RULE;
	}

	public String getPredefinedInstancesFileName() {
		return this.predefinedInstancesFileName;
	}
	
	public String getCacheInstancesFileName() {
		return this.cacheInstancesFileName;
	}
	
	public String getPredefinedAllCandidatesFileName()  {
		return this.predefinedAllCandidatesFileName;
	}
	
	public String getArchiveCandidateFileName()  {
		return this.archiveCandidateFileName;
	}
	
	public void setPredefinedInstancesFileName(String name)  {
		this.predefinedInstancesFileName = name;
	}
	
	public void setCacheInstancesFileName(String name) {
		this.cacheInstancesFileName = name;
	}
	
	public void setPredefinedAllCandidatesFileName(String name)  {
		this.predefinedAllCandidatesFileName = name;
	}
	
	public void setArchiveCandidateFileName(String name)  {
		this.archiveCandidateFileName = name;
	}
	
	public boolean hasCacheInstances() throws CoreException {
		return this.originalConfig.hasAttribute(DSEConstantsContainer.CACHE_INSTANCES) 
		&& !this.originalConfig.getAttribute(DSEConstantsContainer.CACHE_INSTANCES, "").equals("")
		;
	}

	public String getDesignDecisionFileName(){
		return this.designDecisionFileName;
	}
	
	public void setRawConfig(ILaunchConfiguration configuration) {
		this.rawConfiguration = configuration;		
	}

	public ILaunchConfiguration getRawConfiguration(){
		return rawConfiguration;
	}

	public String getConfigurationName() {
		return configurationName;
	}

	/**
	 * @param resultFolder the resultFolder to set
	 */
	public void setResultFolder(String resultFolder) {
		this.resultFolder = resultFolder;
	}

	/**
	 * @return the resultFolder
	 */
	public String getResultFolder() {
		return resultFolder;
	}

	public double getCrossoverRate() {
		return crossoverRate;
	}

	public void setCrossoverRate(double crossoverRate) {
		this.crossoverRate = crossoverRate;
	}

	public boolean isConsiderQMLBoundsWhenApplyingHeuristics() {
		return considerQMLBoundsWhenApplyingHeuristics;
	}

	public void setConsiderQMLBoundsWhenApplyingHeuristics(boolean considerQMLBoundsWhenApplyingHeuristics) {
		this.considerQMLBoundsWhenApplyingHeuristics = considerQMLBoundsWhenApplyingHeuristics;
	}
	
	public void setTacticsProbability(double tacticsProbability) {
		this.tacticsProbability = tacticsProbability;
	}
	
	public double getTacticsProbability(){
		return this.tacticsProbability;
	}
	
	public boolean getUseReallocation() {
		return useReallocation;
	}

	public void setUseReallocation(boolean useReallocation) {
		this.useReallocation = useReallocation;
	}

	public double getReallocationThresholdUtilisationDifference() {
		return reallocationThresholdUtilisationDifference;
	}

	public void setReallocationThresholdUtilisationDifference(
			double reallocationThresholdUtilisationDifference) {
		this.reallocationThresholdUtilisationDifference = reallocationThresholdUtilisationDifference;
	}


	public double getReallocationWeight() {
		return reallocationWeight;
	}

	public void setReallocationWeight(double reallocationWeight) {
		this.reallocationWeight = reallocationWeight;
	}

	public boolean getUseProcessingRate() {
		return useProcessingRate;
	}

	public void setUseProcessingRate(boolean useProcessingRate) {
		this.useProcessingRate = useProcessingRate;
	}

	public double getProcessingRateThresholdLowUtilisation() {
		return processingRateThresholdLowUtilisation;
	}

	public void setProcessingRateThresholdLowUtilisation(
			double processingRateThresholdLowUtilisation) {
		this.processingRateThresholdLowUtilisation = processingRateThresholdLowUtilisation;
	}

	public double getProcessingRateThresholdHighUtilisation() {
		return processingRateThresholdHighUtilisation;
	}

	public void setProcessingRateThresholdHighUtilisation(
			double processingRateThresholdHighUtilisation) {
		this.processingRateThresholdHighUtilisation = processingRateThresholdHighUtilisation;
	}

	public double getProcessingRateDecreaseFactor() {
		return processingRateDecreaseFactor;
	}

	public void setProcessingRateDecreaseFactor(double processingRateDecreaseFactor) {
		this.processingRateDecreaseFactor = processingRateDecreaseFactor;
	}

	public double getProcessingRateIncreaseFactor() {
		return processingRateIncreaseFactor;
	}

	public void setProcessingRateIncreaseFactor(double processingRateIncreaseFactor) {
		this.processingRateIncreaseFactor = processingRateIncreaseFactor;
	}

	public double getProcessingRateWeight() {
		return processingRateWeight;
	}

	public void setProcessingRateWeight(double processingRateWeight) {
		this.processingRateWeight = processingRateWeight;
	}

	public boolean getUseServerConsolidation() {
		return useServerConsolidation;
	}

	public void setUseServerConsolidation(boolean useServerConsolidation) {
		this.useServerConsolidation = useServerConsolidation;
	}

	public double getServerConsolidationThresholdLowUtilisation() {
		return serverConsolidationThresholdLowUtilisation;
	}

	public void setServerConsolidationThresholdLowUtilisation(
			double serverConsolidationThresholdLowUtilisation) {
		this.serverConsolidationThresholdLowUtilisation = serverConsolidationThresholdLowUtilisation;
	}

	public double getServerConsolidationWeight() {
		return serverConsolidationWeight;
	}

	public void setServerConsolidationWeight(double serverConsolidationWeight) {
		this.serverConsolidationWeight = serverConsolidationWeight;
	}

	public boolean getUseServerExpansion() {
		return useServerExpansion;
	}

	public void setUseServerExpansion(boolean useServerExpansion) {
		this.useServerExpansion = useServerExpansion;
	}

	public double getServerExpansionThresholdHighUtilisation() {
		return serverExpansionThresholdHighUtilisation;
	}

	public void setServerExpansionThresholdHighUtilisation(
			double serverExpansionThresholdHighUtilisation) {
		this.serverExpansionThresholdHighUtilisation = serverExpansionThresholdHighUtilisation;
	}

	public int getServerExpansionMaxNumberOfReplacements() {
		return serverExpansionMaxNumberOfReplacements;
	}

	public void setServerExpansionMaxNumberOfReplacements(
			int serverExpansionMaxNumberOfReplacements) {
		this.serverExpansionMaxNumberOfReplacements = serverExpansionMaxNumberOfReplacements;
	}

	public double getServerExpansionWeight() {
		return serverExpansionWeight;
	}

	public void setServerExpansionWeight(double serverExpansionWeight) {
		this.serverExpansionWeight = serverExpansionWeight;
	}
	
	public void setSearchMethod(SearchMethod searchMethod) {
		this.searchMethod  = searchMethod;
		
	}

	public boolean isUseHeuristics() {
		return getUseReallocation() 
		|| getUseProcessingRate() 
		|| getUseServerConsolidation() 
		|| getUseServerExpansion() 
		|| getUseLinkReallocationTactic()
		|| getUseAntipatternKnowledge();
		//return true;
	}

	public void setEvaluators(List<IAnalysis> evaluators) {
		this.evaluators = evaluators;
		
	}
	
	public List<IAnalysis> getEvaluators(){
		return this.evaluators;
	}
	
	public boolean getUseLinkReallocationTactic() {
		return this.useLinkReallocationTactic;
	}
	
	public void setUseLinkReallocationTactic(boolean isUseLinkReallocationTactic){
		this.useLinkReallocationTactic = isUseLinkReallocationTactic;
	}

	public boolean getUseAntipatternKnowledge() {
		return this.useAntipatternKnowledge;
	}
	
	public void setUseAntipatternKnowledge(boolean isUseAntipattern){
		this.useAntipatternKnowledge = isUseAntipattern;
	}
	public boolean isStopOnInitialFailure() {
		return this.stopOnInitialFailure;
	}
	
	public void setStopOnInitialFailure(boolean stop){
		this.stopOnInitialFailure = stop;
	}
	
	public boolean isResultsAsEMF() {
		return this.resultsAsEMF;
	}
	
	public void setResultsAsEMF(boolean asEMF){
		this.resultsAsEMF = asEMF;
	}
	public boolean isResultsAsCSV() {
		return this.resultsAsCSV;
	}
	
	public void setResultsAsCSV(boolean resultsAsCVS){
		this.resultsAsCSV = resultsAsCVS;
	}


}
