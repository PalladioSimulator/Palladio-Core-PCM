package de.uka.ipd.sdq.simulation.abstractsimengine.ssj;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimProcess;
import de.uka.ipd.sdq.simulation.abstractsimengine.IEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEvent;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimProcess;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 * 
 * @param <M>
 *            the type of the simulation model
 */
public class SSJSimEngineFactory<M extends ISimulationModel<M>> implements ISimEngineFactory<M> {

    private SSJModel<M> model;

    @Override
    public void setModel(M model) {
        this.model = new SSJModel<M>(model);
    }

    @Override
    public ISimulationControl<M> createSimulationControl() {
        ISimulationControl<M> delegate = new SSJExperiment<M>(model);
        model.setSimulationControl(delegate);
        // model.setSimulationEngineFactory(this);
        return delegate;
    }

    @Override
    public ISimProcess createSimProcess(AbstractSimProcess<M> myProcess, String name) {
        return new SSJSimProcess<M>(myProcess, name);
    }

    @Override
    public <E extends IEntity> ISimEvent<E> createSimEvent(AbstractSimEvent<M, E> myEvent, String name) {
        return new SSJSimEvent<M, E>(myEvent, name);
    }

    @Override
    public IEntity createEntity(AbstractSimEntity<M> e, String name) {
        return new SSJEntity<M>(e, name);
    }

}
