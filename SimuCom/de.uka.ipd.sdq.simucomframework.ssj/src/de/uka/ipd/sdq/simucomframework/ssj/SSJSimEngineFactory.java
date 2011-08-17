package de.uka.ipd.sdq.simucomframework.ssj;

import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEntity;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimProcess;
import de.uka.ipd.sdq.simulation.abstractSimEngine.IEntity;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimEvent;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimProcess;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;

public class SSJSimEngineFactory<T extends ISimulationModel<T>> implements ISimEngineFactory<T> {

    private SSJModel<T> model;

    // TODO use constructor to pass model!?

    @Override
    public void setModel(T model) {
        // TODO remove modelName!?
        this.model = new SSJModel<T>(model);
    }

    @Override
    public ISimulationControl<T> createSimulationControl() {
        ISimulationControl<T> delegate = new SSJExperiment<T>(model);
        model.setSimulationControl(delegate);
        // model.setSimulationEngineFactory(this);
        return delegate;
    }

    @Override
    public ISimProcess createSimProcess(AbstractSimProcess<T> myProcess, String name) {
        return new SSJSimProcess<T>(myProcess, name);
    }

    @Override
    public <E extends IEntity> ISimEvent<E> createSimEvent(AbstractSimEvent<T, E> myEvent, String name) {
        return new SSJSimEvent<T, E>(myEvent, name);
    }

    @Override
    public IEntity createEntity(AbstractSimEntity<T> e, String name) {
        return new SSJEntity<T>(e, name);
    }

}
