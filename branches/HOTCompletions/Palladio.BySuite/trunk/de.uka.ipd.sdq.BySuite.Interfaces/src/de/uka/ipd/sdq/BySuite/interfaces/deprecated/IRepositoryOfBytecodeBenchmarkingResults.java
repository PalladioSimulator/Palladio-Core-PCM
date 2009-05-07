package de.uka.ipd.sdq.BySuite.interfaces.deprecated;

import java.util.List;

import de.uka.ipd.sdq.BySuite.interfaces.BytecodeBenchmarkingResults;

public interface IRepositoryOfBytecodeBenchmarkingResults {
	public BytecodeBenchmarkingResults getBenchmarkingResult(
			String UID);
	
	public List<BytecodeBenchmarkingResults> getAllBenchmarkingResults();
}
