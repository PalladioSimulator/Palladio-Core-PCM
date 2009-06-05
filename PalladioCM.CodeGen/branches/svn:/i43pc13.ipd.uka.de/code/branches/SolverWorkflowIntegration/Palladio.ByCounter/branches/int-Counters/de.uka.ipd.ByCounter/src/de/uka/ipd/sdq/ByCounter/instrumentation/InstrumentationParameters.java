package de.uka.ipd.sdq.ByCounter.instrumentation;

import java.io.File;
import java.util.List;

import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * A collection of properties that determine the way the instrumentation
 * is done.
 * 
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class InstrumentationParameters {

	/** When true, ByCounter makes a static analysis of the specified code. */
	private boolean countStatically;

//	/** When true, ByCounter will attempt to instrument all methods */
//	private boolean instrumentAllMethods;
//
	/** Name of the methods that shall be instrumented. */
	private List<MethodDescriptor> methodsToInstrument = null;
	
	/** The filename of the log containing the results, that is used if useResultCollector == false. */
	private String resultLogFileName;
	
	/** When not -1, this is the first line in the method, that is analysed/is instrumented for counting. */
	private int startLine;
	
	/** Last line to count when not -1. */
	private int stopLine;
	
	/** Decides whether instrumentation for the recording of parameters of array construction takes place. 
	 * Causes some additional overhead.
	 * When false, results are written to disk directly.  */
	private boolean useArrayParameterRecording;
	
	/** Decides whether to preallocate registers near max_locals instead of using LocalVariablesSorter. */
	private boolean useHighRegistersForCounting;
	
	/** Decides whether to use the CountingResultCollector framework. */
	private boolean useResultCollector;

	/**
	 * This is intended only for construction in multiple steps.
	 * Methods to instrument are NOT set - you must do so manually! 
	 * Assumes dynamic analysis and usage of the CountingResultCollector.
	 * Uses high registers for counting and the CountingResultCollector 
	 * framework. 
	 * @deprecated
	 */
	public InstrumentationParameters() {
		this(	null,   // methods to instrument
				true,  	// use high registers for counting
				true,	// use CountingResultCollector
				false,	// static analysis
				-1,     // start line for section counting
				-1      // stop line for section counting
			);
	}
	
	/**
	 * Assumes dynamic analysis and usage of the CountingResultCollector. Array 
	 * construction parameters will not be recorded.
	 * Uses high registers for counting.
	 * @param pMethodsToInstrument Name of the methods that shall be instrumented.
	 * When false, results are written to disk directly. 
	 * @deprecated
	 */
	public InstrumentationParameters(List<MethodDescriptor> pMethodsToInstrument) {
		this(pMethodsToInstrument, 
				true, 	// use high registers for counting
				true,	// use CountingResultCollector
				false,	// no static analysis
				-1,
				-1);
	}
	

	/**
	 * Assumes dynamic analysis and usage of the CountingResultCollector. Array 
	 * construction parameters will not be recorded.
	 * @param pMethodsToInstrument Name of the methods that shall be instrumented.
	 * @param pUseHighRegistersForCounting Decides whether to preallocate registers near max_locals instead of using LocalVariablesSorter.
	 * When false, results are written to disk directly. 
	 * @deprecated
	 */
	public InstrumentationParameters(List<MethodDescriptor> pMethodsToInstrument,
			boolean pUseHighRegistersForCounting) {
		this(pMethodsToInstrument, 
				pUseHighRegistersForCounting, 
				true,	// use CountingResultCollector
				false,	// no static analysis
				-1,
				-1);
	}
	
	/**
	 * Assumes dynamic analysis without array parameter recording.
	 * @param pMethodsToInstrument Name of the methods that shall be instrumented.
	 * @param pUseHighRegistersForCounting Decides whether to preallocate registers near max_locals instead of using LocalVariablesSorter.
	 * @param pUseResultCollector Decides whether to use the CountingResultCollector framework.
	 * When false, results are written to disk directly. 
	 * @deprecated
	 */
	public InstrumentationParameters(List<MethodDescriptor> pMethodsToInstrument,
			boolean pUseHighRegistersForCounting, 
			boolean pUseResultCollector) {
		this(pMethodsToInstrument, 
				pUseHighRegistersForCounting, 
				pUseResultCollector,
				false,	// no static analysis
				-1,
				-1);
	}
	
	/**
	 * Assumes dynamic analysis.
	 * @param pMethodsToInstrument Name of the methods that shall be instrumented.
	 * @param pUseHighRegistersForCounting Decides whether to preallocate registers near max_locals instead of using LocalVariablesSorter.
	 * @param pUseResultCollector Decides whether to use the CountingResultCollector framework.
	 * @param pUseArrayParameterRecording Decides whether instrumentation for the recording of parameters of array construction takes place. Causes some additional overhead.
	 * When false, results are written to disk directly. 
	 * @deprecated
	 */
	public InstrumentationParameters(List<MethodDescriptor> pMethodsToInstrument,
			boolean pUseHighRegistersForCounting, 
			boolean pUseResultCollector,
			boolean pUseArrayParameterRecording) {
		this(pMethodsToInstrument, 
				pUseHighRegistersForCounting, 
				pUseResultCollector);
		this.useArrayParameterRecording = pUseArrayParameterRecording;
	}

	/**
	 * @param pMethodsToInstrument Name of the methods that shall be instrumented.
	 * @param pUseHighRegistersForCounting Decides whether to preallocate registers near max_locals instead of using LocalVariablesSorter.
	 * @param pUseResultCollector Decides whether to use the CountingResultCollector framework.
	 * @param pUseArrayParameterRecording Decides whether instrumentation for the recording of parameters of array construction takes place. Causes some additional overhead.
	 * @param countStatically When true, ByCounter makes a static analysis of the specified code.
	 * @param startLine When this is >=0, this is the first line in the method, that is analysed.
	 * A value < 0 means that the entire method is instrumented.
	 * @param stopLine When startLine is >=0, this is the last line to count.
	 * When false, results are written to disk directly. 
	 */
	public InstrumentationParameters(
			List<MethodDescriptor> pMethodsToInstrument,
			boolean pUseHighRegistersForCounting, 
			boolean pUseResultCollector,
			boolean pUseArrayParameterRecording,
			boolean countStatically,
			int startLine,
			int stopLine) {
		this.setMethodsToInstrument(pMethodsToInstrument);
		this.setUseHighRegistersForCounting(pUseHighRegistersForCounting);
		this.setUseResultCollector(pUseResultCollector);
		this.setCountStatically(countStatically);
		this.setStartLine(startLine);
		this.setStopLine(stopLine);
		this.setUseArrayParameterRecording(pUseArrayParameterRecording);
		
	}

	/**
	 * Does not use array parameter recording.
	 * @param pMethodsToInstrument Name of the methods that shall be instrumented.
	 * @param pUseHighRegistersForCounting Decides whether to preallocate registers near max_locals instead of using LocalVariablesSorter.
	 * @param pUseResultCollector Decides whether to use the CountingResultCollector framework.
	 * When false, results are written to disk directly.
	 * @param countStatically When true, ByCounter makes a static analysis of the specified code.
	 * @param startLine When this is >=0, this is the first line in the method, that is analysed.
	 * A value < 0 means that the entire method is instrumented.
	 * @param stopLine When startLine is >=0, this is the last line to count.
	 * When false, results are written to disk directly.  
	 * @deprecated
	 */
	public InstrumentationParameters(List<MethodDescriptor> pMethodsToInstrument,
			boolean pUseHighRegistersForCounting, 
			boolean pUseResultCollector,
			boolean countStatically,
			int startLine,
			int stopLine) {
		this(pMethodsToInstrument, pUseHighRegistersForCounting, 
				pUseResultCollector, countStatically,
				false,		// do not use array parameter recording
				startLine,
				stopLine);
	}
	
	/**
	 * Check whether a method matching the given description is contained 
	 * in the list of methods to instrument.
	 * @param name Simple method name (not qualified). For example: <code>doMethodsMatch</code>.
	 * @param desc A method descriptor as used by java bytecode. For example: <code>(Ljava/lang/String;Ljava/lang/String;)Z</code>
	 * @return True if the method matches a method description in the {@link InstrumentationParameters}.
	 */
	public boolean doMethodsMatch(String name, String desc) {
		boolean methodsMatch = false;
		for(MethodDescriptor descr : getMethodsToInstrument()) {
			if (descr.getMethodName().equals(name) 
					&& descr.getDescriptor().equals(desc)) {
				methodsMatch = true;
				break;
			}
		}
		return methodsMatch;
	}

	/**
	 * @return Reflects, whether dynamic or static method analysis is employed.
	 */
	public boolean getCountStatically() {
		return countStatically;
	}

	/**
	 * @return The methods to instrument described as <code>MethodDescriptor</code>.
	 */
	public List<MethodDescriptor> getMethodsToInstrument() {
		return methodsToInstrument;
	}
	
	/**
	 * @return The result log filename used if useResultCollector == false.
	 * The filename can contain template strings that are replaced at runtime.
	 * @see InstrumentationParameters.setResultLogFileName()
	 */
	public String getResultLogFileName() {
		return resultLogFileName;
	}

	/**
	 * @return the startLine
	 */
	public int getStartLine() {
		return startLine;
	}

	/**
	 * @return the stopLine
	 */
	public int getStopLine() {
		return stopLine;
	}

	/**
	 * Decides whether instrumentation for the recording of parameters of array construction takes place. Causes some additional overhead. 
	 * @return True if recording is inserted, false otherwise.
	 */
	public boolean getUseArrayParameterRecording() {
		return useArrayParameterRecording;
	}

	/**
	 * @return useHighRegistersForCounting
	 */
	public boolean getUseHighRegistersForCounting() {
		return useHighRegistersForCounting;
	}

	/**
	 * @return useResultCollector
	 */
	public boolean getUseResultCollector() {
		return useResultCollector;
	}

	/**
	 * @param countStatically When true, no runtime analysis is done. Instead the
	 * method is statically analysed.
	 */
	public void setCountStatically(boolean countStatically) {
		this.countStatically = countStatically;
	}

	/**
	 * @param methodsToInstrument Sets the methods to instrument described as <code>MethodDescriptor</code>.
	 */
	public void setMethodsToInstrument(
			List<MethodDescriptor> methodsToInstrument) {
		this.methodsToInstrument = methodsToInstrument;
	}

	/**
	 * Sets the filename for the log that is created if useResultCollector == false.
	 * Use this if you want to override the default file name that consists 
	 * of a time stamp and the class and method name and will be written to
	 * the 'ByCounter output' directory.
	 * (specifically: "ByCounter output" + File.separatorChar +
	 *	"{$TIME}_{$CLASSNAME}_{$METHODNAME}{$METHODDESC}.log")
	 * Basic templating is supported. The following strings will be replaced:
	 * {$TIME}				- The System.currentTimeMillis() value returned when instrumenting the method.
	 * {$CLASSNAME}			- The fully qualified class name for the instrumented method.
	 * {$METHODNAME}		- The method name of the instrumented method.
	 * {$METHODDESC}		- The method descriptor of the instrumented method.
	 * 
	 * @param resultLogFileName the resultLogFileName to set
	 */
	public void setResultLogFileName(String resultLogFileName) {
		this.resultLogFileName = resultLogFileName;
	}

	/**
	 * @param startLine the startLine to set
	 */
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}

	/**
	 * @param stopLine the stopLine to set
	 */
	public void setStopLine(int stopLine) {
		this.stopLine = stopLine;
	}

	/**
	 * Decides whether instrumentation for the recording of parameters of array construction takes place. Causes some additional overhead.
	 * @param useArrayParameterRecording Set to true if recording is to be inserted, false otherwise.
	 */
	public void setUseArrayParameterRecording(boolean useArrayParameterRecording) {
		this.useArrayParameterRecording = useArrayParameterRecording;
	}

	/**
	 * Decides whether to preallocate registers near max_locals instead of using LocalVariablesSorter.
	 * The default (when not called) is false.
	 * When true, the instrumented bytecode remains closer to the original bytecode in that the register numbers stay the same.
	 * Setting this to true might cause problems if the instrumented code uses very high register numbers (near 65000).
	 * @param useHighRegisters Defaults to false.
	 */
	public void setUseHighRegistersForCounting(boolean useHighRegistersForCounting) {
		this.useHighRegistersForCounting = useHighRegistersForCounting;
	}

	/**
	 * @param useResultCollector Set whether to use the 
	 * <code>CountingResultCollector</code>. When false, a log file is written.
	 * @see setResultLogFileName();
	 */
	public void setUseResultCollector(boolean useResultCollector) {
		this.useResultCollector = useResultCollector;

		if(useResultCollector == false 
				&& (this.resultLogFileName == null 
					|| this.resultLogFileName.isEmpty())) {
			this.setResultLogFileName( 
				"ByCounter output" + File.separatorChar +
				"{$TIME}_{$CLASSNAME}_{$METHODNAME}{$METHODDESC}.log");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder("InstrumentationParameters {");
		b.append("countStatically: " 		+ countStatically + ", ");
		b.append("methodsToInstrument: " 	+ methodsToInstrument + ", ");
		b.append("resultLogFileName: " 		+ resultLogFileName + ", ");
		b.append("startLine: " 				+ startLine + ", ");
		b.append("stopLine: " 				+ stopLine + ", ");
		b.append("useArrayParameterRecording: "	+ useArrayParameterRecording + ", ");
		b.append("useHighRegistersForCounting: " + useHighRegistersForCounting + ", ");
		b.append("useResultCollector: " 	+ useResultCollector + ", ");
		b.append("}");
		return b.toString();
	}
}
