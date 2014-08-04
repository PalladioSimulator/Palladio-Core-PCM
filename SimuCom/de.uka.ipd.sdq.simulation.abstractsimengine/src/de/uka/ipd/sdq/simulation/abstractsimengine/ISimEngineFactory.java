package de.uka.ipd.sdq.simulation.abstractsimengine;

public interface ISimEngineFactory {

    public void setModel(ISimulationModel model);

    public ISimulationControl createSimulationControl();

    public ISimProcess createSimProcess(AbstractSimProcessDelegator myProcess, String name);

    public <E extends IEntity> ISimEvent<E> createSimEvent(AbstractSimEventDelegator<E> myEvent, String name);

    public IEntity createEntity(AbstractSimEntityDelegator e, String name);

}
