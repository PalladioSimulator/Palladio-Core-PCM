/**
 * 
 */
package de.uka.ipd.sdq.simulation.abstractsimengine.desmoj;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationConfig;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import desmoj.core.simulator.Model;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 * 
 */
public class DesmoJModel extends Model implements ISimulationModel {

    private final ISimulationModel model;

    public DesmoJModel(final ISimulationModel model, final String modelName) {
        super(null, modelName, false, false);
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String description() {
        return this.getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doInitialSchedules() {
        this.model.init();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void finalise() {
        this.model.finalise();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ISimulationConfig getConfiguration() {
        return this.model.getConfiguration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ISimEngineFactory getSimEngineFactory() {
        return this.model.getSimEngineFactory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ISimulationControl getSimulationControl() {
        return this.model.getSimulationControl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        // do nothing since we have the doInitialSchedules method where initial events are scheduled
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSimulationControl(final ISimulationControl control) {
        this.model.setSimulationControl(control);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSimulationEngineFactory(final ISimEngineFactory factory) {
        this.model.setSimulationEngineFactory(factory);
    }

}
