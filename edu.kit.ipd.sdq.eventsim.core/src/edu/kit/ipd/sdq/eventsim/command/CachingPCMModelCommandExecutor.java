package edu.kit.ipd.sdq.eventsim.command;

import java.util.HashMap;
import java.util.Map;

import edu.kit.ipd.sdq.eventsim.middleware.simulation.PCMModel;

/**
 * 
 * Use this class to execute {@link ICommand}s requiring access to a PCM model. Commands that are
 * cachable, are executed only once. Further executions of the same command are served from the
 * cache.
 * <p>
 * In order to be cached, the {@code isCachable()} method of the command must return {@code true}.
 * 
 * @author Philipp Merkle
 * 
 */
public class CachingPCMModelCommandExecutor implements ICommandExecutor<PCMModel> {

    // TODO the caching strategy (CACHE_ALL, LRU, LFU, ...) could be implemented by using the
    // strategy pattern

    private final PCMModel pcm;

    // maps commands to result
    private final Map<ICommand<?, PCMModel>, Object> cache;

    /**
     * Constructs an executor that is capable of executing {@link ICommand}s operating on PCM
     * models. Additionally, the commands are served from cache, if caching is enabled for the
     * command and the command has been executed before.
     * 
     * @param pcm
     *            the PCM model on which the executed commands are to operate
     */
    public CachingPCMModelCommandExecutor(final PCMModel pcm) {
        this.pcm = pcm;
        this.cache = new HashMap<ICommand<?, PCMModel>, Object>();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T execute(final ICommand<T, PCMModel> command) {
        // check, whether we may cache the command
        if (!command.cachable()) {
            return command.execute(this.pcm, this);
        }

        // TODO may better use contains() here, as it is probably more efficient than get().
        final Object cached = this.cache.get(command);
        if (cached != null) {
            // cache hit -> return cached result
            return (T) cached;
        } else {
            // cache miss -> execute command and cache result
            final T result = command.execute(this.pcm, this);
            this.cache.put(command, result);
            return result;
        }

    }

}
