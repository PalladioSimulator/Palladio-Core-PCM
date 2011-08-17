/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.desmoj;

import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationConfig;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;
import desmoj.core.simulator.Model;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 * 
 */
public class DesmoJModel<T extends ISimulationModel<T>> extends Model implements ISimulationModel<T> {

    private final T model;

    public DesmoJModel(final T model, final String modelName) {
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
        this.init();
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
    public ISimEngineFactory<T> getSimEngineFactory() {
        return this.model.getSimEngineFactory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ISimulationControl<T> getSimulationControl() {
        return this.model.getSimulationControl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        this.model.init();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSimulationControl(final ISimulationControl<T> control) {
        this.model.setSimulationControl(control);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSimulationEngineFactory(final ISimEngineFactory<T> factory) {
        this.model.setSimulationEngineFactory(factory);
    }

}
