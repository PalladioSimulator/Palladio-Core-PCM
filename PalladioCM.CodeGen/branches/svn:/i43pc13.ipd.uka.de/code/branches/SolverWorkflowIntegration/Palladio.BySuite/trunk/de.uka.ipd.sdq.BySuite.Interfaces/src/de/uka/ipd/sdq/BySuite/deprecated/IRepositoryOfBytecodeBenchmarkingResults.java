package de.uka.ipd.sdq.BySuite.deprecated;

import java.util.List;


public interface IRepositoryOfBytecodeBenchmarkingResults {
	@SuppressWarnings("deprecation")
	public List<BytecodeBenchmarkingResults> getAllBenchmarkingResults();
	
	@SuppressWarnings("deprecation")
	public BytecodeBenchmarkingResults getBenchmarkingResult(
			String UID);
}
