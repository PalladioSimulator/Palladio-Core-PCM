package de.uka.ipd.sdq.BySuite.benchmarking;

import java.io.Serializable;

import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.NoSuchMethodSignatureException;
import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.NoSuchOpcodeException;
import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.NoSuchScenarioException;

/**
 * @author Michael Kuperberg, mkuper@ipd.uka.de
 * TODO create an implementing class that stores the instances and (de)serialises using CSV ...
 */
public abstract class AbstractSettingBenchmarkingResults implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The setting for which an AbstractBenchmarkingResult is valid
	 */
	private BenchmarkingSetting benchmarkingSetting;
	
	/**
	 * TODO
	 */
	private String benchmarkUID;
	
	/**
	 * TODO
	 * @param methodSignature
	 * @return
	 * @throws NoSuchMethodSignatureException
	 */
	public abstract AbstractBenchmarkingResult getBenchmarkingResult_forMnemonicOrSignature(
			String methodSignature)
		throws NoSuchMethodSignatureException;
	
	/**
	 * TODO
	 * @param methodSignature
	 * @param parameterValues
	 * @param parameterTypes
	 * @return
	 * @throws NoSuchMethodSignatureException
	 */
	public abstract AbstractBenchmarkingResult getBenchmarkingResult_forMnemonicOrSignature(
			String methodSignature, 
			Object[] parameterValues, 
			String[] parameterTypes)
		throws NoSuchMethodSignatureException;
	
	/**
	 * TODO
	 * @param opcode
	 * @return
	 * @throws NoSuchOpcodeException
	 */
	public abstract AbstractBenchmarkingResult getBenchmarkingResult_forOpcode(
			int opcode) 
		throws NoSuchOpcodeException;
	
	/**
	 * TODO
	 * @param opcode
	 * @param parameterValues
	 * @param parameterTypes
	 * @return
	 * @throws NoSuchOpcodeException
	 */
	public abstract AbstractBenchmarkingResult getBenchmarkingResult_forOpcode(
			int opcode, 
			Object[] parameterValues, 
			String[] parameterTypes) 
		throws NoSuchOpcodeException;
	
//	/**
//	 * TODO
//	 * @param UID
//	 * @return
//	 * @throws NoSuchScenarioException
//	 */
//	public abstract AbstractBenchmarkingResult getBenchmarkingResult_forScenario(
//			String UID) throws NoSuchScenarioException;
	
	/**
	 * TODO
	 * @return
	 */
	public BenchmarkingSetting getBenchmarkingSetting(){
		return benchmarkingSetting;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public String getBenchmarkUID(){
		return benchmarkUID;
	}
}
