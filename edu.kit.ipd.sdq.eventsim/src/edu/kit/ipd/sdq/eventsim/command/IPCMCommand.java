package edu.kit.ipd.sdq.eventsim.command;

import edu.kit.ipd.sdq.eventsim.PCMModel;

/**
 * Instances of this interface provide operations that require access to a PCM model in order to
 * produce the desired result.
 * 
 * @author Philipp Merkle
 * 
 * @param <R>
 *            the return type of the command. Use {@link Void}, if the command is not supposed to
 *            return a value.
 * @see ICommand
 */
public interface IPCMCommand<R> extends ICommand<R, PCMModel> {

    // the sole purpose of this interface is to set ICommand's type parameter <M> for commands that
    // operate on a PCM model

}
