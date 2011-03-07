package de.uka.ipd.sdq.simulation.command;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.simulation.PCMModel;

/*
 * TODO Speicheroverhead messen?
 * TODO get vs. contains: performanceunterschied?
 */
public class CachingPCMModelCommandExecutor implements ICommandExecutor<PCMModel> {

    // private ICachingStrategy strategy // z.B. CACHE_ALL, LRU, LFU, ...

    private PCMModel pcm;

    // maps command -> result
    private Map<ICommand<?, PCMModel>, Object> cache;

    public CachingPCMModelCommandExecutor(PCMModel pcm) {
        this.pcm = pcm;
        cache = new HashMap<ICommand<?, PCMModel>, Object>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T execute(ICommand<T, PCMModel> command) {
        if (!command.cachable()) {
            return command.execute(this.pcm, this);
        }

        Object cached = cache.get(command);
        if (cached != null) {
            // cache hit -> return cached result
            return (T) cached;
        } else {
            // cache miss -> execute command and cache result
            T result = command.execute(this.pcm, this);
            cache.put(command, result);
            return result;
        }

    }

}
