package de.uka.ipd.sdq.BySuite.deprecated;

import de.uka.ipd.sdq.BySuite.utils.AbstractExecutionSetting;
import de.uka.ipd.sdq.BySuite.utils.NoSuchMethodSignatureException;
import de.uka.ipd.sdq.BySuite.utils.NoSuchOpcodeException;


/**
 * @deprecated
 * @author Michael
 */
public abstract class BytecodeBenchmarkingResults {
	private AbstractExecutionSetting benchmarkingSetting;
	
	private String benchmarkUID;
	
	public abstract AbstractBenchmarkingResult_legacy getBenchmarkingResult(
			int opcode) 
		throws NoSuchOpcodeException;
	
	public abstract AbstractBenchmarkingResult_legacy getBenchmarkingResult(
			int opcode, 
			Object[] parameterValues, 
			String[] parameterTypes) 
		throws NoSuchOpcodeException;
	
	public abstract AbstractBenchmarkingResult_legacy getBenchmarkingResult(
			String methodSignature)
		throws NoSuchMethodSignatureException;
	
	public abstract AbstractBenchmarkingResult_legacy getBenchmarkingResult(
			String methodSignature, 
			Object[] parameterValues, 
			String[] parameterTypes)
		throws NoSuchMethodSignatureException;
	
	public AbstractExecutionSetting getBenchmarkingSetting(){
		return benchmarkingSetting;
	}
	
	public String getBenchmarkUID(){
		return benchmarkUID;
	}
}
