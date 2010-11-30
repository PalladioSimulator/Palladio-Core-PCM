package de.uka.ipd.sdq.pcmsolver.runconfig;

import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

public class PCMSolverWorkflowRunConfiguration extends
		AbstractPCMWorkflowRunConfiguration {

	public PCMSolverWorkflowRunConfiguration() {
		super();
	}

	private int domainSize;
	private double distance;
	private String sreOutputFile;
	private boolean isUseSREInputModel;
	
	private String solver;
	private int debugLevel;

	private boolean isReliabilityAnalysis;
	private boolean printMarkovStatistics;
	private boolean printMarkovSingleResults;

	private String lqnsOutput;
	private String lqnsOutputDir;
	private String lqsimOutput;
	private String lqsimOutputDir;
	private String psQuantum;
	private String convValue;
	private String itLimit;
	private String printInt;
	private String underCoeff;

	private boolean numberOfEvaluatedSystemStatesEnabled;
	private long numberOfEvaluatedSystemStates;

	private boolean numberOfExactDecimalPlacesEnabled;
	private int numberOfExactDecimalPlaces;

	private boolean solvingTimeLimitEnabled;
	private long solvingTimeLimit;
	
	private String logFile;
	
	private boolean markovModelReductionEnabled;
	
	private boolean markovModelTracesEnabled;
	
	private boolean iterationOverPhysicalSystemStatesEnabled;

	private boolean markovModelStorageEnabled;

	private String markovModelFile;

	public boolean isMarkovModelReductionEnabled() {
		return markovModelReductionEnabled;
	}

	public void setMarkovModelReductionEnabled(boolean markovModelReductionEnabled) {
		this.markovModelReductionEnabled = markovModelReductionEnabled;
	}
	
	public boolean isMarkovModelTracesEnabled() {
		return markovModelTracesEnabled;
	}

	public void setMarkovModelTracesEnabled(boolean markovModelTracesEnabled) {
		this.markovModelTracesEnabled = markovModelTracesEnabled;
	}
	
	public boolean isIterationOverPhysicalSystemStatesEnabled() {
		return iterationOverPhysicalSystemStatesEnabled;
	}

	public void setIterationOverPhysicalSystemStatesEnabled(
			boolean iterationOverPhysicalSystemStatesEnabled) {
		this.iterationOverPhysicalSystemStatesEnabled = iterationOverPhysicalSystemStatesEnabled;
	}
	
	public boolean isMarkovModelStorageEnabled() {
		return markovModelStorageEnabled;
	}

	public void setMarkovModelStorageEnabled(boolean markovModelStorageEnabled) {
		this.markovModelStorageEnabled = markovModelStorageEnabled;
	}

	public String getMarkovModelFile() {
		return markovModelFile;
	}

	public void setMarkovModelFile(String markovModelFile) {
		this.markovModelFile = markovModelFile;
	}

	public String getLogFile() {
		return logFile;
	}

	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}

	public boolean isNumberOfEvaluatedSystemStatesEnabled() {
		return numberOfEvaluatedSystemStatesEnabled;
	}

	public void setNumberOfEvaluatedSystemStatesEnabled(
			boolean numberOfEvaluatedSystemStatesEnabled) {
		this.numberOfEvaluatedSystemStatesEnabled = numberOfEvaluatedSystemStatesEnabled;
	}

	public long getNumberOfEvaluatedSystemStates() {
		return numberOfEvaluatedSystemStates;
	}

	public void setNumberOfEvaluatedSystemStates(long numberOfEvaluatedSystemStates) {
		this.numberOfEvaluatedSystemStates = numberOfEvaluatedSystemStates;
	}

	public boolean isNumberOfExactDecimalPlacesEnabled() {
		return numberOfExactDecimalPlacesEnabled;
	}

	public void setNumberOfExactDecimalPlacesEnabled(
			boolean numberOfExactDecimalPlacesEnabled) {
		this.numberOfExactDecimalPlacesEnabled = numberOfExactDecimalPlacesEnabled;
	}

	public int getNumberOfExactDecimalPlaces() {
		return numberOfExactDecimalPlaces;
	}

	public void setNumberOfExactDecimalPlaces(int numberOfExactDecimalPlaces) {
		this.numberOfExactDecimalPlaces = numberOfExactDecimalPlaces;
	}

	public boolean isSolvingTimeLimitEnabled() {
		return solvingTimeLimitEnabled;
	}

	public void setSolvingTimeLimitEnabled(boolean solvingTimeLimitEnabled) {
		this.solvingTimeLimitEnabled = solvingTimeLimitEnabled;
	}

	public long getSolvingTimeLimit() {
		return solvingTimeLimit;
	}

	public void setSolvingTimeLimit(long solvingTimeLimit) {
		this.solvingTimeLimit = solvingTimeLimit;
	}

	public String getUnderCoeff() {
		return underCoeff;
	}

	public void setUnderCoeff(String underCoeff) {
		this.underCoeff = underCoeff;
	}

	public String getPrintInt() {
		return printInt;
	}

	public void setPrintInt(String printInt) {
		this.printInt = printInt;
	}

	public String getItLimit() {
		return itLimit;
	}

	public void setItLimit(String itLimit) {
		this.itLimit = itLimit;
	}

	public String getConvValue() {
		return convValue;
	}

	public void setConvValue(String convValue) {
		this.convValue = convValue;
	}

	public String getPsQuantum() {
		return psQuantum;
	}

	public void setPsQuantum(String psQuantum) {
		this.psQuantum = psQuantum;
	}

	public String getLqsimOutputDir() {
		return lqsimOutputDir;
	}

	public void setLqsimOutputDir(String lqsimOutputDir) {
		this.lqsimOutputDir = lqsimOutputDir;
	}

	public boolean isReliabilityAnalysis() {
		return this.isReliabilityAnalysis;
	}

	public void setReliabilityAnalysis(boolean isReliabilityAnalysis) {
		this.isReliabilityAnalysis = isReliabilityAnalysis;
	}

	public int getDomainSize() {
		return domainSize;
	}

	public void setDomainSize(int domainSize) {
		this.domainSize = domainSize;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getSolver() {
		return solver;
	}

	public void setSolver(String solver) {
		this.solver = solver;
	}

	public boolean isPrintMarkovStatistics() {
		return printMarkovStatistics;
	}

	public void setPrintMarkovStatistics(boolean printMarkovStatistics) {
		this.printMarkovStatistics = printMarkovStatistics;
	}

	public boolean isPrintMarkovSingleResults() {
		return printMarkovSingleResults;
	}

	public void setPrintMarkovSingleResults(boolean printMarkovSingleResults) {
		this.printMarkovSingleResults = printMarkovSingleResults;
	}

	public int getDebugLevel() {
		return debugLevel;
	}

	public void setDebugLevel(int debugLevel) {
		this.debugLevel = debugLevel;
	}

	public String getLqnsOutputDir() {
		return lqnsOutputDir;
	}

	public void setLqnsOutputDir(String lqnsOutputDir) {
		this.lqnsOutputDir = lqnsOutputDir;
	}

	public String getLqnsOutput() {
		return lqnsOutput;
	}

	public void setLqnsOutput(String lqnsOutput) {
		this.lqnsOutput = lqnsOutput;
	}

	public String getLqsimOutput() {
		return lqsimOutput;
	}

	public void setLqsimOutput(String lqsimOutput) {
		this.lqsimOutput = lqsimOutput;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDefaults() {
		// TODO Auto-generated method stub

	}

	public void setSREOutputFile(String outputDir) {
		this.sreOutputFile = outputDir;
	}
	
	public String getSREOutputFile() {
		return this.sreOutputFile;
	}

	public void setIsUseSREInputModel(boolean b) {
		this.isUseSREInputModel = b;
		
	}
	
	public boolean isUseSREInputModel(){
		return this.isUseSREInputModel;
	}
}
