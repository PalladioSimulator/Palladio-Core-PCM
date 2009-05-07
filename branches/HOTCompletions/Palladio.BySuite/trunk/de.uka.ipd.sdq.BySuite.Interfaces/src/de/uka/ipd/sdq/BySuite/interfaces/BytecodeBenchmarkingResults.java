package de.uka.ipd.sdq.BySuite.interfaces;


/**
 * @deprecated
 * @author Michael
 */
public abstract class BytecodeBenchmarkingResults {
	private AbstractBenchmarkingSetting benchmarkingSetting;
	
	private String benchmarkUID;
	
	public abstract AbstractBenchmarkingResult getBenchmarkingResult(
			int opcode) 
		throws NoSuchOpcodeException;
	
	public abstract AbstractBenchmarkingResult getBenchmarkingResult(
			int opcode, 
			Object[] parameterValues, 
			String[] parameterTypes) 
		throws NoSuchOpcodeException;
	
	public abstract AbstractBenchmarkingResult getBenchmarkingResult(
			String methodSignature)
		throws NoSuchMethodSignatureException;
	
	public abstract AbstractBenchmarkingResult getBenchmarkingResult(
			String methodSignature, 
			Object[] parameterValues, 
			String[] parameterTypes)
		throws NoSuchMethodSignatureException;
	
	public AbstractBenchmarkingSetting getBenchmarkingSetting(){
		return benchmarkingSetting;
	}
	
	public String getBenchmarkUID(){
		return benchmarkUID;
	}
}
