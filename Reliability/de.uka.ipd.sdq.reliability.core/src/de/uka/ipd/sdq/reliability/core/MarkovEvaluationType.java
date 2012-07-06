package de.uka.ipd.sdq.reliability.core;

/**
 * Describes the granularity of distinction between failure types in the reliability analysis and
 * simulation.
 * 
 * @author brosch
 * 
 */
public enum MarkovEvaluationType {

    /**
     * Rough distinction between software, hardware and network failure types.
     * 
     * This setting induces a simplified reliability evaluation without failure recovery.
     */
    CLASSES,

    /**
     * Distinction between individual points of failure.
     */
    POINTSOFFAILURE,

    /**
     * No distinction between different failure types.
     * 
     * This setting induces a simplified reliability evaluation without failure recovery.
     */
    SINGLE,

    /**
     * Distinction between user-defined failure types.
     */
    TYPES,
}
