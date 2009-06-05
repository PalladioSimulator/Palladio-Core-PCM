package de.uka.ipd.sdq.BySuite.measurements;

import java.sql.Timestamp;
import java.util.TreeMap;

public class PerformanceMeasurement {
	
//	/**
//	 * Pointer to the description of the setting where the benchmarking 
//	 * was performed (e.g. time, CPU, JVM, JVM parameters etc.)
//	 */
//	private BenchmarkingSetting setting;
	
	/**
	 * Nanoseconds (ns) or CPU cycle (CPUCYCLE)
	 * @author Michael Kuperberg
	 */
	private enum Units{CPUCYCLE, NS}

	public static void main(String[] args){
		@SuppressWarnings("unused")
		PerformanceMeasurement pm = new PerformanceMeasurement(
				"Michael.Lenovo",
				new Long[]{256L},
				100,
				101,
				102,
				103,
				"mischaArbeitet()",
				new Timestamp(System.currentTimeMillis())
		);
//		pm.writeToCSVFile();
	}
	private TreeMap<String,Object> env_dynamicicEnvironmentCharacteristics;
	
	private String env_executionEnvironmentName;
	
	private TreeMap<String,Object> env_staticEnvironmentCharacteristics;
	
	private Long[] input_externalCharacterizations;
	
	/**
	 * Describes parameter conversion flags of this opcode/method, if any
	 */
	private Integer[] input_parameterTypes;
	
	/**
	 * Describes parameter values of this opcode/method, if any
	 */
	private Object[] input_parameterValues;
	
	private long meas_avgMeasurement;
	
	private long meas_maxMeasurement;
	
	private long meas_medMeasurement;
	
	private long meas_minMeasurement;
	
	private long[] meas_rawMeasurements;
	
	/**
	 * The unit of this instance (see <code>Units</code>
	 */
	private Units meas_unit = Units.NS;
	
	/**
	 * fully qualified, incl. package
	 */
	private String run_measuredMethodSignature;
	
	private Object run_methodReturnParameter;
	
	private Integer run_methodReturnParameterType;
	
	private int run_numberOfRecordedMeasurements;
	
	private int run_numberOfWarmupMeasurements;
		
	private Timestamp run_Timestamp;
	
	public PerformanceMeasurement(
			String env_executionEnvironmentName,
			Long[] input_externalCharacterizations, 
			long meas_minMeasurement, 
			long meas_medMeasurement,
			long meas_avgMeasurement,
			long meas_maxMeasurement, 
			String run_measuredMethodSignature,
			Timestamp run_Timestamp) {
		super();
		this.env_executionEnvironmentName = env_executionEnvironmentName;
		this.input_externalCharacterizations = input_externalCharacterizations;
		this.meas_avgMeasurement = meas_avgMeasurement;
		this.meas_maxMeasurement = meas_maxMeasurement;
		this.meas_medMeasurement = meas_medMeasurement;
		this.meas_minMeasurement = meas_minMeasurement;
		this.run_measuredMethodSignature = run_measuredMethodSignature;
		this.run_Timestamp = run_Timestamp;
	}
	
//	public boolean writeToCSVFile(){
//		CSVGenericWriterAndAppender csvgw = new CSVGenericWriterAndAppender();
//		Object[][] columns = new Object[10][1];
//		columns[0][0] = env_executionEnvironmentName;
//		columns[1][0] = input_externalCharacterizations[0];
//		columns[2][0] = new Long(meas_minMeasurement);
//		columns[3][0] = new Long(meas_medMeasurement);
//		columns[4][0] = new Long(meas_avgMeasurement);
//
//		columns[5][0] = new Long(meas_maxMeasurement);
//		if(meas_unit.equals(Units.NS)){
//			columns[6][0] = "ns";
//		}else if(meas_unit.equals(Units.CPUCYCLE)){
//			columns[6][0] = "CPUcyle";
//		}else{
//			columns[6][0] = "unrecognised_unit";
//		}
//		columns[7][0] = run_measuredMethodSignature;
//		columns[8][0] = run_numberOfRecordedMeasurements;
//		columns[9][0] = run_Timestamp.getTime();
//		
//		csvgw.writeColumns_arr(
//				10,//Number of columns; here 
////											env_name, 
////											input_externalCharacterizations[0], 
////											meas_minMeasurement,
////											meas_medMeasurement, 
////											meas_avgMeasurement, 
////											meas_maxMeasurement, 
////											meas_unit,
////											run_measuredMethodSignature,
////											run_numberOfRecordedMeasurements,
////											run_Timestamp 
//				1, //numberOfRows, 
//				new String[]{
//						"env_executionEnvironmentName", 
//						"input_externalCharacterization[0]", 
//						"meas_minMeasurement", 
//						"meas_medMeasurement", 
//						"meas_avgMeasurement", 
//						
//						"meas_maxMeasurement", 
//						"meas_unit", 
//						"run_measuredMethodSignature",
//						"run_numberOfRecordedMeasurements",
//						"run_Timestamp"
//				}, //columnTitles, 
//				new Integer[]{
//						CSVGenericWriterAndAppender.STRING_COLUMN_TYPE,
//						CSVGenericWriterAndAppender.LONG_COLUMN_TYPE,
//						CSVGenericWriterAndAppender.LONG_COLUMN_TYPE,
//						CSVGenericWriterAndAppender.LONG_COLUMN_TYPE,
//						CSVGenericWriterAndAppender.LONG_COLUMN_TYPE,
//						
//						CSVGenericWriterAndAppender.LONG_COLUMN_TYPE,
//						CSVGenericWriterAndAppender.STRING_COLUMN_TYPE,
//						CSVGenericWriterAndAppender.STRING_COLUMN_TYPE,
//						CSVGenericWriterAndAppender.INTEGER_COLUMN_TYPE,
//						CSVGenericWriterAndAppender.LONG_COLUMN_TYPE
//						
//				}, //columnTypes, 
//				columns, 
//				false, //writeBooleansAsIntegers, 
//				true,  //writeMasterFile, 
//				true,  //appendMasterFile, 
//				true,  //writePieceFile, 
//				true,  //appendPieceFile, 
//				';',   //entriesSeparationChar, 
//				"."+File.separator+"MK_results"+File.separator+"measurements.csv", //masterFileNameWithPath, 
//				"."+File.separator+"MK_results", //pieceFilePath, 
//				"measurement", //pieceFileNameCore, 
//				".csv", //pieceFileNameExtension, 
//				false, //usePrevTimestamp, 
//				-1 //prevTimestampToUse
//		);
//		return true;
//	}

	public TreeMap<String, Object> getEnv_dynamicicEnvironmentCharacteristics() {
		return env_dynamicicEnvironmentCharacteristics;
	}

	public String getEnv_executionEnvironmentName() {
		return env_executionEnvironmentName;
	}

	public TreeMap<String, Object> getEnv_staticEnvironmentCharacteristics() {
		return env_staticEnvironmentCharacteristics;
	}

	public Long[] getInput_externalCharacterizations() {
		return input_externalCharacterizations;
	}

	public Integer[] getInput_parameterTypes() {
		return input_parameterTypes;
	}

	public Object[] getInput_parameterValues() {
		return input_parameterValues;
	}

	public long getMeas_avgMeasurement() {
		return meas_avgMeasurement;
	}

	public long getMeas_maxMeasurement() {
		return meas_maxMeasurement;
	}

	public long getMeas_medMeasurement() {
		return meas_medMeasurement;
	}

	public long getMeas_minMeasurement() {
		return meas_minMeasurement;
	}

	public long[] getMeas_rawMeasurements() {
		return meas_rawMeasurements;
	}

	public Units getMeas_unit() {
		return meas_unit;
	}

	public String getRun_measuredMethodSignature() {
		return run_measuredMethodSignature;
	}

	public Object getRun_methodReturnParameter() {
		return run_methodReturnParameter;
	}

	public Integer getRun_methodReturnParameterType() {
		return run_methodReturnParameterType;
	}

	public int getRun_numberOfRecordedMeasurements() {
		return run_numberOfRecordedMeasurements;
	}

	public int getRun_numberOfWarmupMeasurements() {
		return run_numberOfWarmupMeasurements;
	}

	public Timestamp getRun_Timestamp() {
		return run_Timestamp;
	}

	public void setEnv_dynamicicEnvironmentCharacteristics(
			TreeMap<String, Object> env_dynamicicEnvironmentCharacteristics) {
		this.env_dynamicicEnvironmentCharacteristics = env_dynamicicEnvironmentCharacteristics;
	}

	public void setEnv_executionEnvironmentName(String env_executionEnvironmentName) {
		this.env_executionEnvironmentName = env_executionEnvironmentName;
	}

	public void setEnv_staticEnvironmentCharacteristics(
			TreeMap<String, Object> env_staticEnvironmentCharacteristics) {
		this.env_staticEnvironmentCharacteristics = env_staticEnvironmentCharacteristics;
	}

	public void setInput_externalCharacterizations(
			Long[] input_externalCharacterizations) {
		this.input_externalCharacterizations = input_externalCharacterizations;
	}

	public void setInput_parameterTypes(Integer[] input_parameterTypes) {
		this.input_parameterTypes = input_parameterTypes;
	}

	public void setInput_parameterValues(Object[] input_parameterValues) {
		this.input_parameterValues = input_parameterValues;
	}

	public void setMeas_avgMeasurement(long meas_avgMeasurement) {
		this.meas_avgMeasurement = meas_avgMeasurement;
	}

	public void setMeas_maxMeasurement(long meas_maxMeasurement) {
		this.meas_maxMeasurement = meas_maxMeasurement;
	}

	public void setMeas_medMeasurement(long meas_medMeasurement) {
		this.meas_medMeasurement = meas_medMeasurement;
	}

	public void setMeas_minMeasurement(long meas_minMeasurement) {
		this.meas_minMeasurement = meas_minMeasurement;
	}

	public void setMeas_rawMeasurements(long[] meas_rawMeasurements) {
		this.meas_rawMeasurements = meas_rawMeasurements;
	}

	public void setMeas_unit(Units meas_unit) {
		this.meas_unit = meas_unit;
	}

	public void setRun_measuredMethodSignature(String run_measuredMethodSignature) {
		this.run_measuredMethodSignature = run_measuredMethodSignature;
	}

	public void setRun_methodReturnParameter(Object run_methodReturnParameter) {
		this.run_methodReturnParameter = run_methodReturnParameter;
	}

	public void setRun_methodReturnParameterType(
			Integer run_methodReturnParameterType) {
		this.run_methodReturnParameterType = run_methodReturnParameterType;
	}

	public void setRun_numberOfRecordedMeasurements(
			int run_numberOfRecordedMeasurements) {
		this.run_numberOfRecordedMeasurements = run_numberOfRecordedMeasurements;
	}

	public void setRun_numberOfWarmupMeasurements(int run_numberOfWarmupMeasurements) {
		this.run_numberOfWarmupMeasurements = run_numberOfWarmupMeasurements;
	}

	public void setRun_Timestamp(Timestamp run_Timestamp) {
		this.run_Timestamp = run_Timestamp;
	}

}
