package de.uka.ipd.sdq.probespec.framework.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class supports the generation of numeric probe set ids required when
 * using the Probe Specification.
 * 
 * @author Philipp Merkle
 * 
 */
public class ProbeSetIDGenerator {

	private Map<String, Integer> idMap;
	
	private int lastId = -1;

	public ProbeSetIDGenerator() {
		idMap = new ConcurrentHashMap<String, Integer>();
	}

	/**
	 * Generates a numeric probe set id satisfying two conditions: When the
	 * String passed by the parameter id has not yet been passed before, the
	 * returned probe set id will be greater than all probe set ids generated
	 * before. Else the same probe set id generated previously will be returned.
	 * Thus, the same values for id will be mapped to the same numerical probe
	 * set id.
	 * 
	 * @param ID
	 * @return
	 */
	public int obtainId(String ID) {
		Integer foundId = idMap.get(ID);
		if (foundId == null) {
			idMap.put(ID, ++lastId);
			return lastId;
		}
		return foundId;
	}
	
	public String obtainOriginalId(Integer id) {
		for (Entry<String, Integer> e : idMap.entrySet()) {
			if (e.getValue().equals(id)) {
				return e.getKey();
			}
		}
		return null;
	}

}
