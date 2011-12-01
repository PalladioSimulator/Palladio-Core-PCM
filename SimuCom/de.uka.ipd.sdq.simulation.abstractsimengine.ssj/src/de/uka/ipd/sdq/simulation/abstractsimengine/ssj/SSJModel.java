/**
 * 
 */
package de.uka.ipd.sdq.simulation.abstractsimengine.ssj;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationConfig;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 */
public class SSJModel implements ISimulationModel {

    private final ISimulationModel model;

    public SSJModel(final ISimulationModel model) {
        this.model = model;
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

    @Override
    public ISimEngineFactory getSimEngineFactory() {
        return this.model.getSimEngineFactory();
    }

    @Override
    public ISimulationControl getSimulationControl() {
        return this.model.getSimulationControl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        this.model.init();
    }

    @Override
    public void setSimulationControl(final ISimulationControl control) {
        this.model.setSimulationControl(control);
    }

    @Override
    public void setSimulationEngineFactory(final ISimEngineFactory factory) {
        this.model.setSimulationEngineFactory(factory);
    }

}
