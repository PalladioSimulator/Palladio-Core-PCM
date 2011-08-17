package de.uka.ipd.sdq.simulation.workload;

import de.uka.ipd.sdq.simulation.entities.User;

/**
 * Classes implementing this interfaces generate the workload for the system under simulation. For
 * this purpose, they spawn simulated {@link User}s in accordance to a workload description.
 * 
 * @author Philipp Merkle
 * 
 */
public interface IWorkloadGenerator {

    /**
     * Starts the workload generation.
     */
    public void processWorkload();

}
