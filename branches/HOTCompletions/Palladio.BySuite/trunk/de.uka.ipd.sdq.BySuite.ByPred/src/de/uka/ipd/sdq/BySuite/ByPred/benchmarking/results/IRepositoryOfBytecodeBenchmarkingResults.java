package de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results;

import java.util.List;

public interface IRepositoryOfBytecodeBenchmarkingResults {
	public BytecodeBenchmarkingResults getBenchmarkingResult(
			String UID);
	
	public List<BytecodeBenchmarkingResults> getAllBenchmarkingResults();
}
