package de.uka.ipd.sdq.simulation.abstractsimengine.example;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.preferences.SimulationPreferencesHelper;

public class BusModel extends AbstractSimulationModel {

    public BusModel(BusSimConfig config, ISimEngineFactory factory) {
        super(config, factory);
    }

    @Override
    public void init() {
        // nothing to do here
    }

    @Override
    public void finalise() {
        // nothing to do here
    }

    /**
     * Creates the simulation model for the specified configuration.
     * 
     * @param config
     *            the simulation configuration
     * @return the created simulation model
     */
    public static BusModel create(final BusSimConfig config) {
        // load factory for the preferred simulation engine
        ISimEngineFactory factory = SimulationPreferencesHelper.getPreferredSimulationEngine();
        if (factory == null) {
            throw new RuntimeException("There is no simulation engine available. Install at least one engine.");
        }

        // create and return simulation model
        final BusModel model = new BusModel(config, factory);

        return model;
    }

}
