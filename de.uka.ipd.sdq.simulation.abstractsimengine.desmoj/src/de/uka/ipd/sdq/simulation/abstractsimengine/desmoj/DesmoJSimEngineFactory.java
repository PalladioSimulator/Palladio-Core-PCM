package de.uka.ipd.sdq.simulation.abstractsimengine.desmoj;

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
public class DesmoJSimEngineFactory implements ISimEngineFactory {

    private DesmoJModel model;

    @Override
    public void setModel(final ISimulationModel model) {
        final String modelName = model.getConfiguration().getNameExperimentRun();
        this.model = new DesmoJModel(model, modelName);
    }

    @Override
    public ISimulationControl createSimulationControl() {
        final ISimulationControl delegate = new DesmoJExperiment(this.model);
        this.model.setSimulationControl(delegate);
        return delegate;
    }

    @Override
    public IEntity createEntity(final AbstractSimEntityDelegator e, final String name) {
        return new DesmoJEntity(e, this.model, name);
    }

    @Override
    public <E extends IEntity> ISimEvent<E> createSimEvent(final AbstractSimEventDelegator<E> myEvent, final String name) {
        return new DesmoJSimEvent<E>(myEvent, this.model, name);
    }

    @Override
    public ISimProcess createSimProcess(final AbstractSimProcessDelegator myProcess, final String name) {
        return new DesmoJSimProcess(myProcess, this.model, name);
    }

}
