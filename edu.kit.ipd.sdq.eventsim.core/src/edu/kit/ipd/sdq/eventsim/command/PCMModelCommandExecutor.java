package edu.kit.ipd.sdq.eventsim.command;

import edu.kit.ipd.sdq.eventsim.middleware.simulation.PCMModel;

/**
 * Use this class to execute {@link ICommand}s requiring access to a PCM model.
 * 
 * @author Philipp Merkle
 * 
 * @see ICommandExecutor
 */
public class PCMModelCommandExecutor implements ICommandExecutor<PCMModel> {

    private final PCMModel pcm;

    /**
     * Constructs an executor that is capable of executing {@link ICommand}s operating on PCM
     * models.
     * 
     * @param pcm
     *            the PCM model on which the executed commands are to operate
     */
    public PCMModelCommandExecutor(final PCMModel pcm) {
        this.pcm = pcm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T execute(final ICommand<T, PCMModel> command) {
        return command.execute(this.pcm, this);
    }

}
