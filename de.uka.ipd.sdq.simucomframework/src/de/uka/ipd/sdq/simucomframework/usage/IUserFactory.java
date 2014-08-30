package de.uka.ipd.sdq.simucomframework.usage;

import org.palladiosimulator.probeframework.calculator.Calculator;

/**
 * Interface for factories creating users, aka as Borg maturation chambers.
 * 
 * @author Steffen Becker
 * 
 */
public interface IUserFactory {
    /**
     * Instruct this factory to spit out a new user
     * 
     * @return The newly born user
     */
    public IUser createUser();

    public Calculator attachResponseTimeCalculator();

}