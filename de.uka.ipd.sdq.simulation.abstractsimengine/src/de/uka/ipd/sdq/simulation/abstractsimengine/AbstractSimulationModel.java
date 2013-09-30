package de.uka.ipd.sdq.simulation.abstractsimengine;


public abstract class AbstractSimulationModel implements ISimulationModel {

    protected final ISimulationConfig config;
    protected ISimEngineFactory factory;
    private ISimulationControl simControl;

    public AbstractSimulationModel(ISimulationConfig config, ISimEngineFactory factory) {
        this.config = config;
        this.factory = factory;
        this.factory.setModel(this);
        this.simControl = this.factory.createSimulationControl();
    }

    @Override
    public ISimulationControl getSimulationControl() {
        return this.simControl;
    }

    @Override
    public void setSimulationControl(ISimulationControl control) {
        this.simControl = control;
    }

    @Override
    public void setSimulationEngineFactory(ISimEngineFactory factory) {
        this.factory = factory;
    }

    @Override
    public ISimEngineFactory getSimEngineFactory() {
        return factory;
    }

    @Override
    public ISimulationConfig getConfiguration() {
        return config;
    }

}