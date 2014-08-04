package de.uka.ipd.sdq.pcm.transformations.builder;

/**
 * Interface of a class which creates or changes model elements. It defines the method build which
 * contains the actions to take for the respective builder.
 * 
 * @author Steffen
 */
public interface IBuilder {

    /**
     * Called to perform this builders actions
     */
    public abstract void build();

}