package de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results;

import java.io.Serializable;
import java.util.List;

import de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results.exceptions.NoSuchMethodSignatureException;
import de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results.exceptions.NoSuchOpcodeException;
import de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results.exceptions.NoSuchScenarioException;

/**
 * @author Michael Kuperberg, mkuper@ipd.uka.de
 * TODO create an implementing class that stores the instances and (de)serialises using CSV ...
 */
public abstract class AbstractBytecodeBenchmarkingResults_forSetting implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BenchmarkingSetting benchmarkingSetting;
	
	private String benchmarkUID;
	
	public abstract AbstractBenchmarkingResult getBenchmarkingResult_forOpcode(
			int opcode) 
		throws NoSuchOpcodeException;
	
	public abstract AbstractBenchmarkingResult getBenchmarkingResult_forOpcode(
			int opcode, 
			Object[] parameterValues, 
			String[] parameterTypes) 
		throws NoSuchOpcodeException;
	
	public abstract AbstractBenchmarkingResult getBenchmarkingResult_forOpcode(
			String methodSignature)
		throws NoSuchMethodSignatureException;
	
	public abstract AbstractBenchmarkingResult getBenchmarkingResult_forOpcode(
			String methodSignature, 
			Object[] parameterValues, 
			String[] parameterTypes)
		throws NoSuchMethodSignatureException;
	
	public abstract AbstractBenchmarkingResult getBenchmarkingResult_forScenario(
			String UID) throws NoSuchScenarioException;
	
	public BenchmarkingSetting getBenchmarkingSetting(){
		return benchmarkingSetting;
	}
	
	public String getBenchmarkUID(){
		return benchmarkUID;
	}
}
