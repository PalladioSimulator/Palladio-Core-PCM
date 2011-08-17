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
 * 
 * @param <M>
 *            the type of the simulation model
 */
public class SSJModel<M extends ISimulationModel<M>> implements ISimulationModel<M> {

    private final M model;

    public SSJModel(final M model) {
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
    public ISimEngineFactory<M> getSimEngineFactory() {
        return this.model.getSimEngineFactory();
    }

    @Override
    public ISimulationControl<M> getSimulationControl() {
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
    public void setSimulationControl(final ISimulationControl<M> control) {
        this.model.setSimulationControl(control);
    }

    @Override
    public void setSimulationEngineFactory(final ISimEngineFactory<M> factory) {
        this.model.setSimulationEngineFactory(factory);
    }

}
