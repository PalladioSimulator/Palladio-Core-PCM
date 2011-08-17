package de.uka.ipd.sdq.probespec.framework.calculator;


public interface ICalculatorFactory {

	public abstract Calculator buildResponseTimeCalculator(
			String calculatorName, Integer startProbeSetID, Integer endProbeSetID);

	public abstract WaitingTimeCalculator buildDemandBasedWaitingTimeCalculator(
			String calculatorName, Integer startWaitingProbeSetID,
			Integer stopProcessingProbeSetID);

	public abstract WaitingTimeCalculator buildWaitingTimeCalculator(
			String calculatorName, Integer startWaitingProbeSetID,
			Integer stopWaitingProbeSetID);
	
	public abstract HoldTimeCalculator buildHoldTimeCalculator(
			String calculatorName, Integer startWaitingProbeSetID,
			Integer stopWaitingProbeSetID);

	public abstract StateCalculator buildStateCalculator(String calculatorName,
			Integer probeSetId);
	
	public abstract StateCalculator buildOverallUtilizationCalculator(String calculatorName,
			Integer probeSetId);

	public abstract DemandCalculator buildDemandCalculator(
			String calculatorName, Integer probeSetID);

	public abstract ExecutionResultCalculator buildExecutionResultCalculator(
			String calculatorName, Integer probeSetID);

}