package de.uka.ipd.sdq.simulation.command;

import de.uka.ipd.sdq.simulation.PCMModel;

/*
 *  TODO implement caching facility -> execution of previously executed commands are served from cache (return result without actually execute)
 *  "Intelligentes Cahing": Cache größe beschränken, evtl. mitloggen wie häufig command ausgeführt wurde; häufige commands eher cachen
 *  Kombination LRU und Most used 
 */
public class PCMModelCommandExecutor implements ICommandExecutor<PCMModel> {

    private final PCMModel pcm;

    public PCMModelCommandExecutor(final PCMModel pcm) {
        this.pcm = pcm;
    }

    @Override
    public <T> T execute(final ICommand<T, PCMModel> command) {
        return command.execute(this.pcm, this);
    }

}
