package de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results;

public abstract class BytecodeBenchmarkingResults {
	public abstract BenchmarkingResult getBenchmarkingResult(
			int opcode) 
		throws NoSuchOpcodeException;
	
	public abstract BenchmarkingResult getBenchmarkingResult(
			int opcode, 
			Object[] parameterValues, 
			String[] parameterTypes) 
		throws NoSuchOpcodeException;
	
	public abstract BenchmarkingResult getBenchmarkingResult(
			String methodSignature)
		throws NoSuchMethodSignatureException;
	
	public abstract BenchmarkingResult getBenchmarkingResult(
			String methodSignature, 
			Object[] parameterValues, 
			String[] parameterTypes)
		throws NoSuchMethodSignatureException;
	
	private String benchmarkUID;
	
	public String getBenchmarkUID(){
		return benchmarkUID;
	}
	
	private BenchmarkingSetting benchmarkingSetting;
	
	public BenchmarkingSetting getBenchmarkingSetting(){
		return benchmarkingSetting;
	}
}
