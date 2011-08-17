package de.uka.ipd.sdq.tcfmoop.config;

/**
 * The names of the termination criteria. Used most for identifying them
 * @author Atanas Dimitrov
 */
public enum TerminationCriteriaNames{MAXIMUM_NUMBER_OF_GENERATIONS,
	  ELAPSED_TIME,
	  PARETO_OPTIMAL_SET_STABILITY,
	  NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND,
	  MINIMAL_QUALITY_CIRTERIA_VALUE,
	  INSIGNIFICANT_SET_QUALITY_IMPROVEMENT,
	  GIVEN_PARETO_FRONT_IS_REACHED,
	  INSIGNIFICANT_PARETO_FRONT_CHANGE};
