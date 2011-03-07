package de.uka.ipd.sdq.simulation.command;


public interface ICommandExecutor<M> {

    public <T> T execute(ICommand<T, M> command);
    
}
