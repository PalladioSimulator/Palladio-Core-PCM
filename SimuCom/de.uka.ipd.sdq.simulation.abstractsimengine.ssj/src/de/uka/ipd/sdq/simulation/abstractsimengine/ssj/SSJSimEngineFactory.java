package de.uka.ipd.sdq.simulation.abstractsimengine.ssj;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimProcessDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.IEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEvent;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimProcess;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 */
public class SSJSimEngineFactory implements ISimEngineFactory {

    private SSJModel model;

    @Override
    public void setModel(ISimulationModel model) {
        this.model = new SSJModel(model);
    }

    @Override
    public ISimulationControl createSimulationControl() {
        ISimulationControl delegate = new SSJExperiment(model);
        model.setSimulationControl(delegate);
        // model.setSimulationEngineFactory(this);
        return delegate;
    }

    @Override
    public ISimProcess createSimProcess(AbstractSimProcessDelegator myProcess, String name) {
        return new SSJSimProcess(myProcess, name);
    }

    @Override
    public <E extends IEntity> ISimEvent<E> createSimEvent(AbstractSimEventDelegator<E> myEvent, String name) {
        return new SSJSimEvent<E>(myEvent, name);
    }

    @Override
    public IEntity createEntity(AbstractSimEntityDelegator e, String name) {
        return new SSJEntity(e, name);
    }

}
