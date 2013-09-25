package de.uka.ipd.sdq.simulation.abstractsimengine;

/**
 * A simulation element is a named object which is a part of the simulation model and, as such,
 * needs access to the implementation class of the {@link ISimulationModel} interface.
 * 
 * @author Steffen Becker (this code has been factored out from SimuCom)
 * @author Philipp Merkle
 */
public abstract class SimulationElement {

    private String name;
    private ISimulationModel model;

    public SimulationElement(ISimulationModel model, String name) {
        this.model = model;
        this.name = name;
    }

    /**
     * Returns the name of this simulation element.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the simulation model.
     */
    public ISimulationModel getModel() {
        return this.model;
    }

}
