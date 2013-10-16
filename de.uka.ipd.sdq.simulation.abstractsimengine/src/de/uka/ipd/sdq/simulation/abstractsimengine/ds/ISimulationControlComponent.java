package de.uka.ipd.sdq.simulation.abstractsimengine.ds;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

/**
 * Definition of the simulation control declarative service.
 * 
 * @author Christoph Foehrdes
 */
public interface ISimulationControlComponent extends ISimulationControl {

    /**
     * Gives access to the simulation engine factory to create a simulation model.
     * 
     * @return A simulation engine factory instance
     */
    public ISimEngineFactory getSimEngineFactory();

    /**
     * Sets the model for the simulation.
     * 
     * @param model
     *            A simulation model
     */
    public void setSimulationModel(ISimulationModel model);

}
