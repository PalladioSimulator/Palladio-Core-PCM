package de.uka.ipd.sdq.dsexplore.launch;

public class DSEConstantsContainer {
	
	public static final String MAX_ITERATIONS = "maxIterations";
	public static final String INDIVIDUALS_PER_GENERATION = "indivPerGeneration";
	public static final String MRT_REQUIREMENTS = "meanResponseTimeRequirement";
	public static final String MAX_COST = "MAX_COST";
	public static final String THRESHOLD = "strengthenResource_threshold";
	public static final String INCR_FACTOR = "strengthenResource_increaseFactor";

	/**
	 * This must not be used as a key directly, but the quality attribute has to be appended.
	 */
	private static final String ANALYSIS_METHOD_PREFIX = "analysisMethod";
	
	/** Model filenames value */
	public static final String COST_FILE = "costFile";
	public static final String PREDEFINED_INSTANCES = "predefinedInstances";
	
	/**
	 * Set the file extensions which the dialog can use to filter the files it
	 * shows to the argument.
	 */
	public static final String[] COST_MODEL_EXTENSION = new String[] { "*.cost" };
	
	/**
	 * Set the file extensions which the dialog can use to filter the files it
	 * shows to the argument.
	 */
	public static final String[] CSV_EXTENSION = new String[] { "*.csv" };
	
	public static final String PERFORMANCE = "de.uka.ipd.sdq.dsexplore.performance";
	public static final String RELIABILITY = "de.uka.ipd.sdq.dsexplore.reliability";
	public static final String COST = "de.uka.ipd.sdq.dsexplore.cost";
	
	public static final String DESIGN_DECISIONS_ONLY = "designDecisionsOnly";
	public static final String OPTIMISATION_ONLY = "optimisationOnly";
	

	public static final String NONE = "none";
	public static final String getAnalysisMethod(String qualityAttribute){
		return ANALYSIS_METHOD_PREFIX+qualityAttribute;
	}

	
}
