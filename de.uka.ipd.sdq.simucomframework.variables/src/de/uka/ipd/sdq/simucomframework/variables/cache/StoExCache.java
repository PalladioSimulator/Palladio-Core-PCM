package de.uka.ipd.sdq.simucomframework.variables.cache;

import java.util.HashMap;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;

/**
 * A cache for Stoex. This saves the time to parse the stoex again.
 * Caches also the {@link IRandomGenerator} which may contain a fixed seed.
 * 
 * @author Steffen Becker
 *
 */
public class StoExCache {

	/**
	 * Hashmap mapping stoex strings on StoEx AST incl. Type Inferer and ProbfunctionCache
	 */
	private final HashMap<String,StoExCacheEntry> cache = new HashMap<String,StoExCacheEntry>();
	
	// TODO: This is no real singleton anymore, as each simulation can have its own seed.
	// Franz' version of adding the random number generator to the cache does not work in 
	// concurrent runs as well as in Protocom
	private static StoExCache stoexSingleton = null;
	private IProbabilityFunctionFactory probFunctionFactory = null;
	
	

	/**
	 * Only protected because the cost model should have its own instance of the StoExCache
	 * so that it can be resetted independently of the main singleton instance. 
	 * @param randomGenerator
	 */
	protected StoExCache(IProbabilityFunctionFactory probFunctionFactory) {
		this.probFunctionFactory = probFunctionFactory;
	}
	
	public static void initialiseStoExCache(IProbabilityFunctionFactory probFunctionFactory){
		assert probFunctionFactory != null;
		stoexSingleton = new StoExCache(probFunctionFactory);
	}
	
	public static StoExCache singleton() {
		assert stoexSingleton != null;
		return stoexSingleton;
	}
	
	/**
	 * Get a cached stoex parse tree and visitors. If entry is not in the cache it
	 * is created and added automatically.
	 * @param spec The stoex to search for in the cache
	 * @return The StoExCacheEntry containing the static information on the stoex 
	 */
	public synchronized StoExCacheEntry getEntry(String spec) {
		assert probFunctionFactory.getRandomGenerator() != null;
		if (!cache.containsKey(spec)){
			cache.put(spec, new StoExCacheEntry(spec));
		}
		return cache.get(spec);
	}
	
	public IRandomGenerator getRandomGenerator(){
		return this.probFunctionFactory.getRandomGenerator();
	}
	
	public IProbabilityFunctionFactory getProbabilityFunctionFactory(){
		return this.probFunctionFactory;
	}
}
