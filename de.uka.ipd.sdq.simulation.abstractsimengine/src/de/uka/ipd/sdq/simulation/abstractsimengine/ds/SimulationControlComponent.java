package de.uka.ipd.sdq.simulation.abstractsimengine.ds;

import java.util.Observer;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.SimCondition;

public class SimulationControlComponent implements ISimulationControlComponent {

    private ISimulationModel simModel;

    @Override
    public ISimEngineFactory getSimEngineFactory() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void setSimulationModel(ISimulationModel model) {
        this.simModel = model;
    }

    @Override
    public void start() {
        this.getSimulationModel().getSimulationControl().start();
    }

    @Override
    public void stop() {
        this.getSimulationModel().getSimulationControl().stop();
    }

    @Override
    public boolean isRunning() {
        return this.getSimulationModel().getSimulationControl().isRunning();
    }

    @Override
    public double getCurrentSimulationTime() {
        return this.getSimulationModel().getSimulationControl().getCurrentSimulationTime();
    }

    @Override
    public void setMaxSimTime(long simTime) {
        this.getSimulationModel().getSimulationControl().setMaxSimTime(simTime);
    }

    @Override
    public void addStopCondition(SimCondition maxMeasurementsStopCondition) {
        this.getSimulationModel().getSimulationControl().addStopCondition(maxMeasurementsStopCondition);
    }

    @Override
    public void addTimeObserver(Observer observer) {
        this.getSimulationModel().getSimulationControl().addTimeObserver(observer);
    }

    /**
     * Checks for a valid simulation model and returns it.
     * 
     * @return A simulation model
     */
    private ISimulationModel getSimulationModel() {
        if (null == this.simModel) {
            throw new RuntimeException("No simulation model was set");
        }

        return this.simModel;
    }

}
