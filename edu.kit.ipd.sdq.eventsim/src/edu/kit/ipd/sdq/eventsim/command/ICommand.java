package edu.kit.ipd.sdq.eventsim.command;

/**
 * Instances of this interface provide operations that require access to a certain model in order to
 * produce the desired result. When executing such an operation, the required model is injected as a
 * method parameter, which frees the operation implementation from caring about finding and loading
 * the model.
 * <p>
 * Operations implementing this interface are executed by an {@link ICommandExecutor}.
 * 
 * @author Philipp Merkle
 * 
 * @param R
 *            the return type of the command
 * @param M
 *            the type of the model. Instances of this type encapsulate access to the model.
 */
public interface ICommand<R, M> {

    /**
     * Executes the operation encapsulated by this class.
     * <p>
     * <strong>Notice:</strong> This method is not intended to be called by clients. Use a
     * {@link ICommandExecutor} instead to execute the operation.
     * 
     * @param model
     *            the model
     * @param executor
     *            the {@link ICommandExecutor} that currently executes this operation. Use this
     *            reference to invoke sub-operations also implementing this {@link ICommand}
     *            interface.
     * @return
     */
    public R execute(M model, ICommandExecutor<M> executor);

    /**
     * @return whether the command may be cached or not.
     */
    public boolean cachable();

}
