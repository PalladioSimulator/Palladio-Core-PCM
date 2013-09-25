package de.uka.ipd.sdq.simulation.abstractsimengine;

/**
 * A condition which is continuously checked over the course of a simulation run. Whenever the
 * condition is satisfied, the <code>check</code> method performs a specific action, such as
 * stopping the simulation run, for example.
 * <p>
 * A common use of this class is the implementation of a stop condition, which causes the simulation
 * run to stop whenever the <code>check</code> method evaluates to <code>true</code>.
 *
 * @author Steffen Becker (this code has been factored out from SimuCom)
 * @author Philipp Merkle
 */
public interface SimCondition {

    /**
     * Checks whether this condition is satisfied. This is the case, for instance, if a certain
     * stopping criterion holds.
     * 
     * @return true, if the condition is satisfied; false, else.
     */
    public boolean check();

}
