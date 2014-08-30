package de.uka.ipd.sdq.reliability.solver.reporting;

/**
 * Enumeration describing the type of entities (e.g. component's ID, a component's interface ID, a
 * component's signature ID) that are grouped together for creating a Markov reporting.
 * 
 * @author Daniel Patejdl
 * 
 */
public enum ImpactAnalysisFailureType {
    /**
     * Group together components' internal actions.
     */
    COMPONENTS_INTERNAL_ACTIONS,

    /**
     * Group together components' service operations (signatures).
     */
    COMPONENTS_SERVICE_OPERATIONS,

    /**
     * Group together components' services (interfaces).
     */
    COMPONENTS_SERVICES,

    /**
     * Group together external services' operations (signatures).
     */
    EXTERNAL_SERVICE_OPERATIONS,

    /**
     * Group together external services (roles and interfaces).
     */
    EXTERNAL_SERVICES
};
