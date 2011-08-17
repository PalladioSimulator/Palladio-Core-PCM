package de.uka.ipd.sdq.simucomframework.variables.cache;

import java.util.HashMap;

import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;

/**
 * A cache for Stoex. This saves the time to parse the stoex again.
 * Caches also the {@link IRandomGenerator} which may contain a fixed seed.
 * 
 * @author Steffen Becker
 *
 */
public class StoExCache {

	private HashMap<String,StoExCacheEntry> cache = new HashMap<String,StoExCacheEntry>();
	private static StoExCache stoexSingleton = null;
	private IRandomGenerator myRandomNumberGenerator = null;
	

	private StoExCache(IRandomGenerator randomGenerator) {
		myRandomNumberGenerator = randomGenerator;
	}
	
	public static void initialiseStoExCache(IRandomGenerator randomGenerator){
		stoexSingleton = new StoExCache(randomGenerator);
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
		if (!cache.containsKey(spec)){
			cache.put(spec, new StoExCacheEntry(spec,myRandomNumberGenerator));
		}
		return cache.get(spec);
	}
	
	public IRandomGenerator getRandomGenerator(){
		return this.myRandomNumberGenerator;
	}
}
