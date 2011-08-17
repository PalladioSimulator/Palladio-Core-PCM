package de.uka.ipd.sdq.dsexplore.launch;

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
	
	/**
	 * Set the file extensions which the dialog can use to filter the files it
	 * shows to the argument.
	 */
	public static final String[] DESIGNDECISION_EXTENSION = new String[] { "*.designdecision" };
	
	public static final String PERFORMANCE = "de.uka.ipd.sdq.dsexplore.performance";
	public static final String RELIABILITY = "de.uka.ipd.sdq.dsexplore.reliability";
	public static final String COST = "de.uka.ipd.sdq.dsexplore.cost";
	//public static final String SECURITY = "de.uka.ipd.sdq.dsexplore.security";
	
	public static final String MEAN_RESPONSE_TIME_QUALITY = "mean response time";
	public static final String COST_QUALITY = "cost";
	public static final String POFOD_QUALITY = "POFOD"; 
	
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

	

	
}
