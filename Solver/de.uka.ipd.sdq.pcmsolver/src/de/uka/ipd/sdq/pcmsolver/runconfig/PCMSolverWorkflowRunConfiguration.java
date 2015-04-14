package de.uka.ipd.sdq.pcmsolver.runconfig;

import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

public class PCMSolverWorkflowRunConfiguration extends
		AbstractCodeGenerationWorkflowRunConfiguration {

	private String convValue;

	private int debugLevel;
	private double distance;
	private int domainSize;

	private boolean isReliabilityAnalysis;

	private boolean isUseSREInputModel;
	private boolean iterationOverPhysicalSystemStatesEnabled;

	private String itLimit;
	private String logFile;
	private String lqnsOutput;
	private String lqnsOutputDir;
	
	/** The output directory for the PerfEng solver. */
	private String perfEngOutputDir;
	private String perfEngPropFile;

	private String lqsimBlocks;
	private String lqsimOutput;
	private String lqsimOutputDir;
	private String lqsimRuntime;
	private String markovEvaluationMode;
	private String markovModelFile;
	private boolean markovModelReductionEnabled;
	private boolean markovModelStorageEnabled;

	private boolean markovModelTracesEnabled;
	private Integer maxRealRuntimeSec = null;
	private long numberOfEvaluatedSystemStates;
	private boolean numberOfEvaluatedSystemStatesEnabled;

	private int numberOfExactDecimalPlaces;
	private boolean numberOfExactDecimalPlacesEnabled;

	private String outputFilename;

	private String printInt;

	private boolean printMarkovSingleResults;
	private boolean printMarkovStatistics;
	
	private boolean sensitivityModelEnabled;
	private String sensitivityModelFileName;
	private String sensitivityLogFileName;

	private String psQuantum;

	private String solver;

	private long solvingTimeLimit;

	private boolean solvingTimeLimitEnabled;

	private String sreOutputFile;

	private boolean stopOnMessageLossLQNS;
	private boolean stopOnMessageLossLQSim;
	
	private boolean debugPerfEngine;

	private boolean isInfiniteTaskMultiplicity;

	private String saveFile;
	private boolean saveResultsToFileEnabled;
	private boolean isShowHtmlResults = true;

	public boolean isInfiniteTaskMultiplicity() {
		return isInfiniteTaskMultiplicity;
	}

	public void setInfiniteTaskMultiplicity(boolean isInfiniteTaskMultiplicity) {
		this.isInfiniteTaskMultiplicity = isInfiniteTaskMultiplicity;
	}

	private String underCoeff;

	private String lqnPragmas;

	public PCMSolverWorkflowRunConfiguration() {
		super();
	}

	public String getConvValue() {
		return convValue;
	}
	
	public boolean getDebugPerfEng() {
		return this.debugPerfEngine;
	}

	public int getDebugLevel() {
		return debugLevel;
	}

	public double getDistance() {
		return distance;
	}

	public int getDomainSize() {
		return domainSize;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItLimit() {
		return itLimit;
	}

	public String getLogFile() {
		return logFile;
	}

	/**
	 * LQN output type. Uses constants {@link MessageStrings.LQN_OUTPUT_HTML} etc. 
	 * @return
	 */
	public String getLqnsOutput() {
		return lqnsOutput;
	}

	public String getLqnsOutputDir() {
		return lqnsOutputDir;
	}

	public String getLQSimBlocks() {
		return this.lqsimBlocks;
	}

	public String getLqsimOutput() {
		return lqsimOutput;
	}

	public String getLqsimOutputDir() {
		return lqsimOutputDir;
	}

	public String getLQSimRuntime() {
		return this.lqsimRuntime;
	}

	public String getMarkovEvaluationMode() {
		return markovEvaluationMode;
	}

	public String getMarkovModelFile() {
		return markovModelFile;
	}

	public Integer getMaxRealRuntimeSec() {
		return maxRealRuntimeSec;
	}

	public long getNumberOfEvaluatedSystemStates() {
		return numberOfEvaluatedSystemStates;
	}
	
	public String getPerfEngOutputDir() {
		return perfEngOutputDir;
	}

	public String getPerfEngPropFile() {
		return perfEngPropFile;
	}
	
	public int getNumberOfExactDecimalPlaces() {
		return numberOfExactDecimalPlaces;
	}

	public String getOutputFilename() {
		return outputFilename;
	}

	public String getPrintInt() {
		return printInt;
	}

	public String getPsQuantum() {
		return psQuantum;
	}

	public String getSolver() {
		return solver;
	}

	public long getSolvingTimeLimit() {
		return solvingTimeLimit;
	}

	public String getSREOutputFile() {
		return this.sreOutputFile;
	}

	public boolean getStopOnMessageLossLQNS() {
		return this.stopOnMessageLossLQNS;
	}

	public boolean getStopOnMessageLossLQSim() {
		return this.stopOnMessageLossLQSim;
	}

	public String getUnderCoeff() {
		return underCoeff;
	}

	public String getPragmas() {
		return this.lqnPragmas;
	}

	public boolean isIterationOverPhysicalSystemStatesEnabled() {
		return iterationOverPhysicalSystemStatesEnabled;
	}

	public boolean isMarkovModelReductionEnabled() {
		return markovModelReductionEnabled;
	}

	public boolean isMarkovModelStorageEnabled() {
		return markovModelStorageEnabled;
	}

	public boolean isMarkovModelTracesEnabled() {
		return markovModelTracesEnabled;
	}

	public boolean isNumberOfEvaluatedSystemStatesEnabled() {
		return numberOfEvaluatedSystemStatesEnabled;
	}

	public boolean isNumberOfExactDecimalPlacesEnabled() {
		return numberOfExactDecimalPlacesEnabled;
	}

	public boolean isPrintMarkovSingleResults() {
		return printMarkovSingleResults;
	}

	public boolean isPrintMarkovStatistics() {
		return printMarkovStatistics;
	}

	public boolean isSensitivityModelEnabled() {
		return sensitivityModelEnabled;
	}
	
	public String getSensitivityModelFileName() {
		return sensitivityModelFileName;
	}
	
	public String getSensitivityLogFileName() {
		return sensitivityLogFileName;
	}

	public boolean isReliabilityAnalysis() {
		return this.isReliabilityAnalysis;
	}
	
	/**
	 * Show HTML results of reliability analysis. For HTML results of LQN solver analysis, see {@link #getLqnsOutput()}.
	 *
	 * @return true, if is show html results
	 */
	public boolean isShowHtmlResults() {
		return this.isShowHtmlResults;
	}

	public boolean isSolvingTimeLimitEnabled() {
		return solvingTimeLimitEnabled;
	}

	public boolean isUseSREInputModel() {
		return this.isUseSREInputModel;
	}

	public void setConvValue(String convValue) {
		this.convValue = convValue;
	}

	public void setDebugLevel(int debugLevel) {
		this.debugLevel = debugLevel;
	}
	
	public void setDebugPerfEngine(boolean b) {
		this.debugPerfEngine = b;
	}

	@Override
	public void setDefaults() {
		// TODO Auto-generated method stub

	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setDomainSize(int domainSize) {
		this.domainSize = domainSize;
	}

	public void setIsUseSREInputModel(boolean b) {
		this.isUseSREInputModel = b;

	}

	public void setIterationOverPhysicalSystemStatesEnabled(
			boolean iterationOverPhysicalSystemStatesEnabled) {
		this.iterationOverPhysicalSystemStatesEnabled = iterationOverPhysicalSystemStatesEnabled;
	}

	public void setItLimit(String itLimit) {
		this.itLimit = itLimit;
	}

	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}

	public void setLqnsOutput(String lqnsOutput) {
		this.lqnsOutput = lqnsOutput;
	}

	public void setLqnsOutputDir(String lqnsOutputDir) {
		this.lqnsOutputDir = lqnsOutputDir;
	}

	public void setLQSimBlocks(String blocks) {
		this.lqsimBlocks = blocks;
	}

	public void setLqsimOutput(String lqsimOutput) {
		this.lqsimOutput = lqsimOutput;
	}

	public void setLqsimOutputDir(String lqsimOutputDir) {
		this.lqsimOutputDir = lqsimOutputDir;
	}

	public void setLQSimRuntime(String runtime) {
		this.lqsimRuntime = runtime;
	}

	public void setMarkovEvaluationMode(String markovEvaluationMode) {
		this.markovEvaluationMode = markovEvaluationMode;
	}

	public void setMarkovModelFile(String markovModelFile) {
		this.markovModelFile = markovModelFile;
	}

	public void setMarkovModelReductionEnabled(
			boolean markovModelReductionEnabled) {
		this.markovModelReductionEnabled = markovModelReductionEnabled;
	}

	public void setMarkovModelStorageEnabled(boolean markovModelStorageEnabled) {
		this.markovModelStorageEnabled = markovModelStorageEnabled;
	}

	public void setMarkovModelTracesEnabled(boolean markovModelTracesEnabled) {
		this.markovModelTracesEnabled = markovModelTracesEnabled;
	}

	public void setMaxRealRuntimeSec(Integer maxRealRuntimeSec) {
		this.maxRealRuntimeSec = maxRealRuntimeSec;
	}

	public void setNumberOfEvaluatedSystemStates(
			long numberOfEvaluatedSystemStates) {
		this.numberOfEvaluatedSystemStates = numberOfEvaluatedSystemStates;
	}

	public void setNumberOfEvaluatedSystemStatesEnabled(
			boolean numberOfEvaluatedSystemStatesEnabled) {
		this.numberOfEvaluatedSystemStatesEnabled = numberOfEvaluatedSystemStatesEnabled;
	}

	public void setNumberOfExactDecimalPlaces(int numberOfExactDecimalPlaces) {
		this.numberOfExactDecimalPlaces = numberOfExactDecimalPlaces;
	}

	public void setNumberOfExactDecimalPlacesEnabled(
			boolean numberOfExactDecimalPlacesEnabled) {
		this.numberOfExactDecimalPlacesEnabled = numberOfExactDecimalPlacesEnabled;
	}

	public void setOutputFilename(String outputFilename) {
		this.outputFilename = outputFilename;
	}
	
	public void setPerfEngOutputDir(String perfEngOutDir) {
		this.perfEngOutputDir = perfEngOutDir;
	}

	public void setPerfEngPropFile(String perfEngPropFile) {
		this.perfEngPropFile = perfEngPropFile;
	}

	public void setPrintInt(String printInt) {
		this.printInt = printInt;
	}

	public void setPrintMarkovSingleResults(boolean printMarkovSingleResults) {
		this.printMarkovSingleResults = printMarkovSingleResults;
	}

	public void setPrintMarkovStatistics(boolean printMarkovStatistics) {
		this.printMarkovStatistics = printMarkovStatistics;
	}
	
	public void setSensitivityModelEnabled(boolean sensitivityModelEnabled) {
		this.sensitivityModelEnabled = sensitivityModelEnabled;
	}

	public void setSensitivityModelFileName(String sensitivityModelFileName) {
		this.sensitivityModelFileName = sensitivityModelFileName;
	}

	public void setSensitivityLogFileName(String sensitivityLogFileName) {
		this.sensitivityLogFileName = sensitivityLogFileName;
	}

	public void setPsQuantum(String psQuantum) {
		this.psQuantum = psQuantum;
	}

	public void setReliabilityAnalysis(boolean isReliabilityAnalysis) {
		this.isReliabilityAnalysis = isReliabilityAnalysis;
	}
	
	public void setSolver(String solver) {
		this.solver = solver;
	}

	public void setSolvingTimeLimit(long solvingTimeLimit) {
		this.solvingTimeLimit = solvingTimeLimit;
	}

	public void setSolvingTimeLimitEnabled(boolean solvingTimeLimitEnabled) {
		this.solvingTimeLimitEnabled = solvingTimeLimitEnabled;
	}

	public void setSREOutputFile(String outputDir) {
		this.sreOutputFile = outputDir;
	}

	public void setStopOnMessageLossLQNS(boolean b) {
		this.stopOnMessageLossLQNS = b;
	}

	public void setStopOnMessageLossLQSim(boolean b) {
		this.stopOnMessageLossLQSim = b;
	}

	public void setUnderCoeff(String underCoeff) {
		this.underCoeff = underCoeff;
	}

	public String getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}

	public boolean isSaveResultsToFileEnabled() {
		return saveResultsToFileEnabled;
	}
	
	public void setSaveResultsToFileEnabled(boolean saveResultsToFileEnabled) {
		this.saveResultsToFileEnabled = saveResultsToFileEnabled;
	}
	
	public void setShowHtmlResults(boolean isShowHtmlResults) {
		this.isShowHtmlResults = isShowHtmlResults;
	}

	public void setPragmas(String pragmaString) {
		this.lqnPragmas = pragmaString;
	}


}
