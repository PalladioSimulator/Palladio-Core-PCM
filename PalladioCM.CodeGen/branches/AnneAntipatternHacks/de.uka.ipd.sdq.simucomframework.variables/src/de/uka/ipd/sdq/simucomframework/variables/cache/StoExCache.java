package de.uka.ipd.sdq.simucomframework.variables.cache;

import java.util.HashMap;

/**
 * A cache for Stoex. This saves the time to parse the stoex again
 * @author Steffen Becker
 *
 */
public class StoExCache {

	private HashMap<String,StoExCacheEntry> cache = new HashMap<String,StoExCacheEntry>();
	private static StoExCache stoexSingleton = new StoExCache();
	
	public static StoExCache singleton() {
		return stoexSingleton;
	}
	
	private StoExCache() {
	}

	/**
	 * Get a cached stoex parse tree and visitors. If entry is not in the cache it
	 * is created and added automatically.
	 * @param spec The stoex to search for in the cache
	 * @return The StoExCacheEntry containing the static information on the stoex 
	 */
	public synchronized StoExCacheEntry getEntry(String spec) {
		if (!cache.containsKey(spec)){
			cache.put(spec, new StoExCacheEntry(spec));
		}
		return cache.get(spec);
	}
}
