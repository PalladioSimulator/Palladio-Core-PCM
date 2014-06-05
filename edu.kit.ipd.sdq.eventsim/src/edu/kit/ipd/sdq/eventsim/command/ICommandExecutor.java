package edu.kit.ipd.sdq.eventsim.command;

/**
 * Classes implementing this interface provide the execution of {@link ICommand}s operating on a
 * certain model type M. Executing a command means to invoke the command's {@code execute()} method
 * and pass the model instance on which the command operates. 
 * 
 * @author Philipp Merkle
 * 
 * @param <M>
 *            the type of the model. Instances of this type encapsulate access to the model.
 */
public interface ICommandExecutor<M> {

    /**
     * Executes the specified command.
     * 
     * @param command
     *            the command that is to be executed
     * @return the result of executing the specified command, or null if the return type (T) is
     *         {@link Void}.
     */
    public <T> T execute(ICommand<T, M> command);

}
