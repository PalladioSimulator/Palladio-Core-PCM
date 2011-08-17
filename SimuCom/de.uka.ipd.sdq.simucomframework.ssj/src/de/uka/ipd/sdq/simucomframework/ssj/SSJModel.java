/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.ssj;

import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationConfig;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;

/**
 * @author Snowball
 * @author Philipp Merkle
 * 
 */
public class SSJModel<T extends ISimulationModel<T>> implements ISimulationModel<T> {

    private final T model;

    public SSJModel(final T model) {
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void finalise() {
        this.model.finalise();
    }

    @Override
    public ISimulationConfig getConfiguration() {
        return this.model.getConfiguration();
    }

    @Override
    public ISimEngineFactory<T> getSimEngineFactory() {
        return this.model.getSimEngineFactory();
    }

    @Override
    public ISimulationControl<T> getSimulationControl() {
        return this.model.getSimulationControl();
    }

    @Override
    public void init() {
        this.model.init();
    }

    @Override
    public void setSimulationControl(final ISimulationControl<T> control) {
        this.model.setSimulationControl(control);
    }

    @Override
    public void setSimulationEngineFactory(final ISimEngineFactory<T> factory) {
        this.model.setSimulationEngineFactory(factory);
    }

}
