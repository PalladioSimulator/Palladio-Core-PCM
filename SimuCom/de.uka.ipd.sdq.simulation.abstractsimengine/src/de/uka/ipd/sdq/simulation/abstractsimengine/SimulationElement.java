package de.uka.ipd.sdq.simulation.abstractsimengine;

/**
 * A simulation element is a named object which is a part of the simulation model and, as such,
 * needs access to the implementation class of the {@link ISimulationModel} interface.
 * 
 * @author Steffen Becker (this code has been factored out from SimuCom)
 * @author Philipp Merkle
 * 
 * @param <M>
 *            the type of the simulation model
 */
public abstract class SimulationElement<M extends ISimulationModel<M>> {

    private String name;
    private M model;

    public SimulationElement(M model, String name) {
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
    public M getModel() {
        return model;
    }

}
