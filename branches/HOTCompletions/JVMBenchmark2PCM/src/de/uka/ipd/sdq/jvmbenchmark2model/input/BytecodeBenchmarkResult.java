package de.uka.ipd.sdq.jvmbenchmark2model.input;

import java.util.SortedMap;
import java.util.TreeMap;

public class BytecodeBenchmarkResult {
	boolean isJITenabled;
	String platformDescription;
	SortedMap<PCMResourceServiceNewSignature,PerformanceStatement> performance;
	
	public BytecodeBenchmarkResult() {
		isJITenabled = false;
		platformDescription = "fantasySlowJVM";
		performance = new TreeMap<PCMResourceServiceNewSignature, PerformanceStatement>();
		performance.put(new PCMResourceServiceNewSignature("iadd","blupp"), new PerformanceStatement(3D));
		performance.put(new PCMResourceServiceNewSignature("idiv","bla"), new PerformanceStatement(4D));
	}
}
