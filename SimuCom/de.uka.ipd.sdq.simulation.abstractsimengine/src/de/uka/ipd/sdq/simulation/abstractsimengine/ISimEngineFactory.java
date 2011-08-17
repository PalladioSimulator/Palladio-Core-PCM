package de.uka.ipd.sdq.simulation.abstractsimengine;

public interface ISimEngineFactory<M extends ISimulationModel<M>> {

    public void setModel(M model);
    
    public ISimulationControl<M> createSimulationControl();

    public ISimProcess createSimProcess(AbstractSimProcess<M> myProcess, String name);

    public <E extends IEntity> ISimEvent<E> createSimEvent(AbstractSimEvent<M, E> myEvent, String name);

    public IEntity createEntity(AbstractSimEntity<M> e, String name);

}
