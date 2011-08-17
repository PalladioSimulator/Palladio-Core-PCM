package de.uka.ipd.sdq.simucomframework.desmoj;

import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEntity;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimProcess;
import de.uka.ipd.sdq.simulation.abstractSimEngine.IEntity;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimEvent;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimProcess;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;

public class DesmoJSimEngineFactory<T extends ISimulationModel<T>> implements ISimEngineFactory<T> {

    private DesmoJModel<T> model;

    // TODO use constructor to pass model!?
    
    @Override
    public void setModel(T model) {
        this.model = new DesmoJModel<T>(model, "TODO: model name");
    }

    @Override
    public ISimulationControl<T> createSimulationControl() {
        ISimulationControl<T> delegate = new DesmoJExperiment<T>(this.model);
        return delegate;
    }

    @Override
    public IEntity createEntity(AbstractSimEntity<T> e, String name) {
        return new DesmoJEntity<T>(e, this.model, name);
    }

    @Override
    public <E extends IEntity> ISimEvent<E> createSimEvent(AbstractSimEvent<T, E> myEvent, String name) {
        return new DesmoJSimEvent<T, E>(myEvent, this.model, name);
    }

    @Override
    public ISimProcess createSimProcess(AbstractSimProcess<T> myProcess, String name) {
        return new DesmoJSimProcess<T>(myProcess, this.model, name);
    }

}
