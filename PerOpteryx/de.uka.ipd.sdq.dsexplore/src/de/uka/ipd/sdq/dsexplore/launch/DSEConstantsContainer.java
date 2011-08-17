package de.uka.ipd.sdq.dsexplore.launch;

import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;

/**
 * constants of DSE. QML-related constants are found in {@link QMLConstantsContainer}.
 * @author martens
 *
 */
public class DSEConstantsContainer {
	
	public static final String MAX_ITERATIONS = "maxIterations";
	public static final String INDIVIDUALS_PER_GENERATION = "indivPerGeneration";
	public static final String CROSSOVER_RATE = "crossover rate";
	
	public static final String MRT_REQUIREMENTS = "meanResponseTimeRequirement";
	public static final String MAX_COST = "MAX_COST";
	
	public static final String SEARCH_METHOD = "search method";
	
	/** Messages for the selection combo box*/ 
	public static final String SEARCH_EVOLUTIONARY = "Evolutionary search";
	public static final String SEARCH_RANDOM = "Random search";
	public static final String SEARCH_RULE = "Rule-based search";

	/**
	 * This must not be used as a key directly, but the quality attribute has to be appended.
	 */
	private static final String ANALYSIS_METHOD_PREFIX = "analysisMethod";
	
	/** Model filenames value */
	public static final String COST_FILE = "costFile";
	//public static final String SECURITY_FILE = "securityFile";
	public static final String PREDEFINED_INSTANCES = "predefinedInstances";
	public static final String CACHE_INSTANCES = "cacheInstances";
	public static final String ALL_CANDIDATES = "allCandidates";
	public static final String ARCHIVE_CANDIDATES = "archiveCandidates";
	
	
	public static final String DESIGN_DECISION_FILE = "designDecisionFile";
	
	public static final String QML_DEFINITION_FILE = "qmlDefinitionFile";
	
	/**
	 * Set the file extensions which the dialog can use to filter the files it
	 * shows to the argument.
	 */
	public static final String[] COST_MODEL_EXTENSION = new String[] { "*.cost" };
	
	//public static final String[] SECURITY_MODEL_EXTENSION = new String[] { "*.security" };;
	
	/**
	 * Set the file extensions which the dialog can use to filter the files it
	 * shows to the argument.
	 */
	public static final String[] CSV_EXTENSION = new String[] { "*.csv" };
	public static final String[] CANDIDATE_EXTENSION = new String[] { "*.csv" , "*.designdecision" };
	
	/**
	 * Set the file extensions which the dialog can use to filter the files it
	 * shows to the argument.
	 */
	public static final String[] DESIGNDECISION_EXTENSION = new String[] { "*.designdecision" };
	
	public static final String QML_DEFINITION_EXTENSION = new String ("*.qmldeclarations");

	//TODO: delete
	//XXX: use 'new QMLDimensionReader().getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH).getEntityName()' instead
//	public static final String MEAN_RESPONSE_TIME_QUALITY = "mean response time";
//	public static final String COST_QUALITY = "cost";
//	public static final String POFOD_QUALITY = "POFOD"; 
	
	public static final String DESIGN_DECISIONS_ONLY = "designDecisionsOnly";
	public static final String OPTIMISATION_ONLY = "optimisationOnly";
	

	public static final String NONE = "none";
	public static final String getAnalysisMethod(String qualityAttribute){
		return ANALYSIS_METHOD_PREFIX+qualityAttribute;
	}
	
	public static final String ALPHA = "alpha";
	public static final String UPPER_BOUND_CONFIDENCE = "upper bound confidence";
	public static final String LOWER_BOUND_CONFIDENCE = "lower bound confidence";
	
	/*
	 * Configuration of heuristics
	 */
	
	public static final String CONSIDER_QML_BOUNDS = "Consider QML bounds";
	
	public static final String USE_REALLOCATION = "Use reallocation heuristic";
	public static final String REALLOCATION_UTILISATION_DIFFERENCE = "Reallocation threshold for utilisation difference";
	public static final String REALLOCATION_WEIGHT = "Weight of reallocation heuristic";

	public static final String USE_PROCESSING_RATE = "Use processing rate heuristic";
	public static final String PROCESSING_RATE_THRESHOLD_LOW_UTILISATION = "Proceesing rate threshold for low utilisation";
	public static final String PROCESSING_RATE_THRESHOLD_HIGH_UTILISATION = "Processing rate threshold for high utilisation";
	public static final String PROCESSING_RATE_INCREASE_FACTOR = "Increase processing rate factor";
	public static final String PROCESSING_RATE_DECREASE_FACTOR = "Decrease processing rate factor";
	public static final String PROCESSING_RATE_WEIGHT = "Weight of processing rate heuristic";
	
	public static final String USE_SERVER_CONSOLIDATION = "Use server consolidation heuristic";
	public static final String SERVER_CONSOLIDATION_THRESHOLD_LOW_UTILISATION = "Server consolidation threshold for low utilisation";
	public static final String SERVER_CONSOLIDATION_WEIGHT = "Weight of server consolidation heuristic";

	public static final String USE_SERVER_EXPANSION = "Use server expansion heuristic";
	public static final String SERVER_EXPANSION_THRESHOLD_HIGH_UTILISATION = "Server expansion threshold for high utilisation";
	public static final String SERVER_EXPANSION_MAX_NUMBER_OF_REPLACEMENTS = "Server expansion maximum number of reallocations";
	public static final String SERVER_EXPANSION_WEIGHT = "Weight of server expansion heuristic";
	
	public static final String USE_ANTIPATTERNS = "Use antipattern knowledge";
	
	public final static String USE_STARTING_POPULATION_HEURISTIC = "Use starting population heuristic";
	public final static String MIN_NUMBER_RESOURCE_CONTAINERS = "Minimum number of resource containers";
	public final static String MAX_NUMBER_RESOURCE_CONTAINERS = "Maximum number of resource containers";
	public final static String NUMBER_OF_CANDIDATES_PER_ALLOCATION_LEVEL = "Number of candidates per allocation level";
	
	/*
	 * Termination Criteria related constants
	 */
	
	//General
	public static final String TC_GENERAL_USE_TERMINATION_CRITERIA = "Use Termination Criteria";
	public static final String TC_GENERAL_COMPARISION_MODE = "Run in comparision mode";
	
	//Composed Criteria
	public static final String TC_COMPOSED_CRITERIA_ACTIVATE = "Activate composed Criteria";
	public static final String TC_COMPOSED_CRITERIA_EXPRESSION = "Composed Criteria Expression";
	
	//Maximum Generation Number Criterion
	public static final String TC_MAX_NUM_OF_GEN_ACTIVATE = "Activate Maximum number of generation";
	public static final String TC_MAX_NUM_OF_GEN_LIMIT = "Maximum Number Of Generations";
	
	//Elapsed Time Criterion
	public static final String TC_ELAPSED_TIME_ACTIVATE = "Activate Elapsed Time Criterion";
	public static final String TC_ELAPSED_TIME_TYPE = "Type of the measured time";
	public static final String TC_ELAPSED_TIME_TIME_LIMIT = "Time in minutes";
	
	//No New Pareto Optimal Candidates Found Criterion
	public static final String TC_NO_NEW_CANDIDATES_ACTIVATE = "Activate No New Pareto Optimal Candidates";
	public static final String TC_NO_NEW_CANDIDATES_ITERATIONS_WITHOUT = "Iterations without new Pareto optimal candidates";
	
	//Pareto Optimal Set Stability
	public static final String TC_SET_STABILITY_ACTIVATE = "Activate Pareto Optimal Set Stability";
	public static final String TC_SET_STABILITY_MODE = "Evaluation Mode";
	public static final String TC_SET_STABILITY_MINIMUM_ITERATION_TO_SURVIVE = "Minimum iterations to survive";
	public static final String TC_SET_STABILITY_NUMBER_OF_SURVIVORS_EXACT = "Exact number of survivors";
	public static final String TC_SET_STABILITY_NUMBER_OF_SURVIVORS_PERCENTAGE = "Percentage number of survivors";
	
	//Minimal Quality Criteria Value
	public static final String TC_MINIMAL_VALUES_ACTIVATE = "Activate Minimal Quality Criteria Value";
	public static final String TC_MINIMAL_VALUES_CANDIDATES_TO_CONFORM = "Number of candidates to conform";
	public static final String TC_MINIMAL_VALUES_CONFIGURED_OBJECTIVES = "Configured objectives with values";
	
	//A Given Pareto Front is Reached
	public static final String TC_PARETO_FRONT_IS_REACHED_ACTIVATE = "Activate a Given Pareto Front Is reached";
	public static final String TC_PARETO_FRONT_IS_REACHED_PERCENTAGES_TO_COVER = "Percentages to cover";
	public static final String TC_PARETO_FRONT_IS_REACHED_PATH_TO_FRONT_FILE = "Path to the pareto front description file";

	//Insignificant Set Quality Improvement
	public static final String TC_INSIGNIFICANT_SET_IMPROVEMENT_ACTIVATE = "Activate Insignificant Set Quality Improvement";
	public static final String TC_INSIGNIFICANT_SET_IMPROVEMENT_GENERATION_X = "Number of the n-x generation";
	public static final String TC_INSIGNIFICANT_SET_IMPROVEMENT_CONFIGURED_OBJECTIVES = "Configured Objectives with averages";
	
	//Insignificant Pareto Front Change
	public static final String TC_INSIGNIFICANT_FRONT_CHANGE_ACTIVATE = "Activate Insignificant Pareto Front Change";
	public static final String TC_INSIGNIFICANT_FRONT_CHANGE_GENERATION_X = "Number of the n-x generation for front";
	public static final String TC_INSIGNIFICANT_FRONT_CHANGE_IMPROVEMENT = "Minimum percentage improvement";
	

	
}
