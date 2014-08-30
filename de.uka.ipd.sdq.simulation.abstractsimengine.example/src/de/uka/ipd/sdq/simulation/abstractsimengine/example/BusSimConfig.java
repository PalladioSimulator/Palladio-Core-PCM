package de.uka.ipd.sdq.simulation.abstractsimengine.example;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationConfig;

public class BusSimConfig implements ISimulationConfig {

    @Override
    public String getNameExperimentRun() {
        return "Bus Simulation";
    }

}
