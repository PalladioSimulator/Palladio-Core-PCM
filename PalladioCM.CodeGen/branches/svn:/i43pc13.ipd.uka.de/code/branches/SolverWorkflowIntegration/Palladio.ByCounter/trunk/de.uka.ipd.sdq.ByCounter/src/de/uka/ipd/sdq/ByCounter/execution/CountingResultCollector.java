package de.uka.ipd.sdq.ByCounter.execution;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.ByCounter.instrumentation.AdditionalOpcodeInformation;
import de.uka.ipd.sdq.ByCounter.utils.ASMOpcodesMapper;
import de.uka.ipd.sdq.ByCounter.utils.ICountingResultWriter;

/**
 * Class used to collect statistics about an instrumented method.
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class CountingResultCollector {
	
	
	/**
	 * Think about the singleton pattern here :-)
	 */
	private static CountingResultCollector instance = null;
	
	/**
	 * Public singleton accessor. Use this to get a reference 
	 * to the singleton instance.
	 * @return The singleton instance of {@link CountingResultCollector}.
	 */
	public synchronized static CountingResultCollector getInstance() {
		if (instance == null) {
			instance = new CountingResultCollector();
		}
		return instance;
	}
	
	/**
	 * retrieve the full counting artefact information by the beginning time 
	 */
	private HashMap<Long,CountingArtefactInformation> countingInformationsByBeginning; //later, use SortedSet (after defining a comparator...)
	
	/**
	 * Retrieve all invocations of a method by its signature
	 */
	private HashMap<String,List<CountingArtefactInformation>> countingInformationsByMethodname; //later, use SortedSet (after defining a comparator...)
	
	/**
	 *	a simple ArrayList that holds a list of results
	 */
	private ArrayList<CountingResult> countingResults;//TODO make this a sorted list... --> runtime overhead?
	
	/**
	 * TODO
	 */
	private CountingResult inlined_countingResult;
	
	/**
	 * Database replacement ;-)
	 */
	private HashMap<CountingArtefactInformation, CountingResult> countingResultsByArtefactInformation;

	/**
	 * see http://en.wikipedia.org/wiki/Data_log
	 */
	private Logger log;

	/**
	 * When a {@link CountingResult} is logged, all known writers will be
	 * asked to log (write) it as well. This mechanism is introduced to
	 * decouple {@link CountingResultCollector} from specific mechanisms and 
	 * frameworks, such as CSV writing, JFreeChart creation etc.
	 */
	List<ICountingResultWriter> resultWriters;
		
	private TreeMap<String,Integer> inlined_methodsMap;

	private boolean monitorShouldStop;
	
	public boolean isMonitorShouldStop() {
		return monitorShouldStop;
	}

	public void setMonitorShouldStop(boolean monitorShouldStop) {
		this.monitorShouldStop = monitorShouldStop;
	}

	/**
	 * Private constructor that is invoked to create the singleton instance
	 */
	private CountingResultCollector() {
		log = Logger.getLogger(this.getClass().getCanonicalName());
		countingInformationsByBeginning = new HashMap<Long, CountingArtefactInformation>();
		countingInformationsByMethodname = new HashMap<String, List<CountingArtefactInformation>>();
		countingResultsByArtefactInformation = new HashMap<CountingArtefactInformation, CountingResult>();
		countingResults = new ArrayList<CountingResult>();
		resultWriters = new ArrayList<ICountingResultWriter>();
		inlined_countingResult = new CountingResult(
				"inlined", 
				"______inlined______",
				0, //filetype
				0L, //input characterisation
				0L, //output characterisation
				0L, //invocation beginning
				0L, //reporting time
				new TreeMap<Integer,Long>(),
				new TreeMap<String,Long>(),
				new long[]{},
				new int[]{},
				new String[]{},
				new TreeMap<BytecodeSectionDescription,SortedMap<Integer,Long>>(),
				new TreeMap<BytecodeSectionDescription,SortedMap<String,Long>>()
				);
		inlined_methodsMap = new TreeMap<String, Integer>();
	}

	/**
	 * Clear all results in the internal list.
	 */
	public synchronized void clearResults() {
		log.debug("Used to have "+countingResults.size()+" results before clearing");
		countingInformationsByBeginning.clear();
		countingInformationsByMethodname.clear();
		countingResultsByArtefactInformation.clear();
		countingResults.clear();
		inlined_countingResult.resetMethodInstructionCountsOnly();
		inlined_methodsMap = new TreeMap<String, Integer>();
	}
	
	/**
	 * Copies an int array into a new long array.
	 * @param array Array to copy.
	 * @return All int values from array in a new long array.
	 */
	private long[] convertIntArrayToLongArray(int[] array) {
		if(array == null) return null;
		long[] result = new long[array.length];
		for(int i = 0; i < array.length; i++) {
			result[i] = array[i];
		}
		return result;
	}
	
	/**
	 * 
	 * Get all results the {@link CountingResultCollector} holds.
	 * This does not clear the {@link CountingResultCollector} list. You have to explicitly
	 * call <code>clearResults()</code> if that is your intention.
	 * @param recursive When true, the counts for a result are the sum of 
	 * the counts of the respective method and recursively the counts of all 
	 * methods called by the method, i.e. of the entire calling tree.
	 * When false, only the counts for operation done in the method itself 
	 * - not those by called methods - are returned.
	 * Does NOT consider the inlined result!
	 * @return A <code>Result</code> list.
	 */
	private synchronized List<CountingResult> getAllCountingResults(boolean recursive) {
		if(!recursive) {
			return countingResults;
		} else {
			// calculate the sums for all results
			ArrayList<CountingResult> calcResult = 
				new ArrayList<CountingResult>(countingResults.size());
			long callerStartTime;
			for(int i = 0; i < countingResults.size(); i++) {
				callerStartTime = countingResults.get(i).getMethodInvocationBeginning();
				calcResult.add(this.getCountingResultByStartTime_evaluateCallingTree(callerStartTime, true));
			}
			return calcResult;
		}
	}
	
	/**
	 * Get all results the {@link CountingResultCollector} holds.
	 * This does not clear the {@link CountingResultCollector} list. You have to explicitly
	 * call <code>clearResults()</code> if that is your intention.
	 * This method is the same as <code>getResults(false)</code>.
	 * @return A <code>Result</code> list.
	 */
	public synchronized List<CountingResult> getAllCountingResults_nonRecursively() {
		return getAllCountingResults(false);
	}
	
	/**
	 * Get all results the {@link CountingResultCollector} holds, incl. methods called from a methods.
	 * This does not clear the {@link CountingResultCollector} list. You have to explicitly
	 * call <code>clearResults()</code> if that is your intention.
	 * This method is the same as <code>getResults(true)</code>.
	 * @return A <code>Result</code> list.
	 */
	public synchronized List<CountingResult> getAllCountingResults_recursively() {
		return getAllCountingResults(true);
	}

	/**
	 * Get all results the {@link CountingResultCollector} holds.
	 * This does not clear the {@link CountingResultCollector} list. You have to explicitly
	 * call <code>clearResults()</code> if that is your intention.
	 * @param recursive When true, the counts for a result are the sum of 
	 * the counts of the respective method and recursively the counts of all 
	 * methods called by the method, i.e. of the entire calling tree.
	 * When false, only the counts for operation done in the method itself 
	 * - not those by called methods - are returned.
	 * @return A Result array.
	 */
	public synchronized CountingResult[] getAllCountingResultsAsArray(boolean recursive) {
		return getAllCountingResults(recursive).toArray(new CountingResult[countingResults.size()]);
	}

	/**
	 * Gets the mapping of {@link CountingArtefactInformation} to {@link CountingResult}s.
	 * @return The mapping as {@link HashMap}.
	 */
	public HashMap<CountingArtefactInformation, CountingResult> getAllCountingResultsByArtefacts() {
		return countingResultsByArtefactInformation;
	}

	/**
	 * Gets all result writers registered to the collector.
	 * @return A list of {@link ICountingResultWriter}s.
	 */
	public List<ICountingResultWriter> getAllResultWriters() {
		return resultWriters;
	}
	
	/**
	 * Gets the {@link CountingArtefactInformation} by the time of 
	 * method execution beginning.
	 * @return A {@link HashMap}. The long value is the time as 
	 * returned by System.nanoTime().
	 */
	public HashMap<Long, CountingArtefactInformation> getCountingArtefactsByBeginning() {
		return countingInformationsByBeginning;
	}

	/**
	 * Gets the {@link CountingArtefactInformation} by method name.
	 * @return A {@link HashMap}. The {@link String} is the method name.
	 */
	public HashMap<String, List<CountingArtefactInformation>> getCountingArtefactsByMethodname() {
		return countingInformationsByMethodname;
	}

	/**
	 * Gets the {@link CountingArtefactInformation} by method name.
	 * @param name The method name used to select the 
	 * {@link CountingArtefactInformation} that is returned.
	 * @return The specified list of {@link CountingArtefactInformation}.
	 */
	public List<CountingArtefactInformation> getCountingArtefactsByName(String name){
		return this.countingInformationsByMethodname.get(name);
	}

	/**
	 * Gets the {@link CountingArtefactInformation} by the time of 
	 * method execution beginning.
	 * @param time A time as returned by System.nanoTime().
	 * @return The specified {@link CountingArtefactInformation}.
	 */
	public CountingArtefactInformation getCountingArtefactsByTime(long time){
		return this.countingInformationsByBeginning.get(time);
	}

	/**
	 * Gets the {@link CountingArtefactInformation} by the time of 
	 * method execution beginning.
	 * @param timestamp A time as {@link Timestamp}.
	 * @return The specified {@link CountingArtefactInformation}.
	 */
	public CountingArtefactInformation getCountingArtefactsByTimestamp(Timestamp timestamp){
		return this.countingInformationsByBeginning.get(timestamp.getTime());
	}

	/** 
	 * Gets the {@link CountingResult} that corresponds to the given 
	 * {@link CountingArtefactInformation}.
	 * @param cai A {@link CountingArtefactInformation}.
	 * @return The {@link CountingResult} described by cai.
	 */
	public CountingResult getCountingResultByArtefact(CountingArtefactInformation cai) {
		return this.countingResultsByArtefactInformation.get(cai);
	}

	/**
	 * Gets the {@link CountingArtefactInformation} by the time of 
	 * method execution beginning.
	 * @param time A time as returned by System.nanoTime().
	 * @return The specified {@link CountingResult}.
	 */
	public CountingResult getCountingResultByMethodStartTime(long time){
		CountingArtefactInformation cai = this.countingInformationsByBeginning.get(time);
		if(cai==null){
			log.error("No counting artefact information for starting time "+time);
			return null;
		}else{
			return this.countingResultsByArtefactInformation.get(cai);
		}
	}

	/** 
	 * Gets the {@link CountingArtefactInformation} by the time of 
	 * method execution beginning.
	 * Timestamp should be unique. 
	 * @param timestamp A time as {@link Timestamp}.
	 * @return The specified {@link CountingResult}.
	 */
	public CountingResult getCountingResultByMethodStartTimestamp(Timestamp timestamp){
		return this.countingResultsByArtefactInformation.get(this.countingInformationsByBeginning.get(timestamp));
	}
	
	/**TODO
	 * Gets a {@link CountingResult} that is the accumulation of all 
	 * 
	 * @param callerStartTime
	 * @return The calculated {@link CountingResult}.
	 */
	@SuppressWarnings("deprecation")
	public CountingResult getCountingResultByStartTime_evaluateCallingTree(Long callerStartTime, boolean suppressDebugMessages){
		log.info("Evaluating calling tree for method start time "+callerStartTime);
		CountingResult candidateCountingResult;		// The currently considered counting result
		CountingArtefactInformation canditateCAI;	// corresponding CAI
		Long candidateStartTime;					// the start time of the considered result
		Long candidateReportingTime;				// the reporting time of the considered result
		
		Long callerReportingTime 
			= this.countingInformationsByBeginning
				.get(callerStartTime)
					.getResultsReceivedByCollectorTime();
		log.debug("Corresponding caller reporting time: "+callerReportingTime);
		
		Set<Long> allKeys = this.countingInformationsByBeginning.keySet();
		// create a list of results sorted by start time
		ArrayList<Long> keysCopy = new ArrayList<Long>(allKeys);
		Collections.sort(keysCopy);
		// skip all result of methods executed before callerStartTime
		Iterator<Long> iter = keysCopy.iterator();
		candidateStartTime = iter.next();
		CountingResult totalCountingResult = this.getCountingResultByMethodStartTime(callerStartTime);
		log.debug("Counting result before Type2 addition: "+totalCountingResult);
		
		while(candidateStartTime<callerStartTime){//ECHT kleiner!
			if(!suppressDebugMessages) log.debug("Ignoring time "+candidateStartTime+" because <"+callerStartTime);
			candidateStartTime=iter.next();
		}
		
		boolean firstIt = true;
		// now add the results of the methods executed before the current 
		// result was reported.
		do {
			if(!firstIt) {
				candidateStartTime = iter.next();
			}
			firstIt = false;
			canditateCAI = countingInformationsByBeginning.get(candidateStartTime);
			candidateReportingTime = canditateCAI.getResultsReceivedByCollectorTime();
			if(!suppressDebugMessages) log.debug("Considering for addition: "+canditateCAI+"");
			if(!suppressDebugMessages){ 
				log.debug("Just for the record: trying to add " +
					"["+candidateStartTime+","+candidateReportingTime+"] to " +
					"["+callerStartTime+","+callerReportingTime+"].");
			}
			// candidate results were reported before the caller was
			// assume that the caller has called the candidate and add it
			if(candidateReportingTime.longValue()<callerReportingTime.longValue()){
				if(!suppressDebugMessages){
					log.debug("Adding callee counts of time "+candidateStartTime+
						" because its start >"+callerStartTime+
						" and because its reporting time " +
						"("+canditateCAI.getResultsReceivedByCollectorTime()+")< " +
						"caller reporting time ("+callerReportingTime+").");
				}
				candidateCountingResult = canditateCAI.getCountingResult();
				if(!suppressDebugMessages) log.debug("Added counting result: "+candidateCountingResult);
				totalCountingResult.add(candidateCountingResult);
				if(!suppressDebugMessages) log.debug("Intermediate total counting result: "+totalCountingResult);
			}else if(candidateReportingTime.longValue()>callerReportingTime.longValue()){
				if(!suppressDebugMessages) log.debug("Skipping callee counts of time "+candidateStartTime+
						" because, while its start time >"+callerStartTime+
						", its reporting time " +
						"("+canditateCAI.getResultsReceivedByCollectorTime()+")> " +
						"caller reporting time ("+callerReportingTime+").");
			}else if(candidateReportingTime.longValue()==callerReportingTime.longValue()){
				if(candidateStartTime.longValue()==callerStartTime.longValue()){ 
					if(!suppressDebugMessages) log.debug("Potential callee is the caller herself -> skipping");
				}else{
					if(!suppressDebugMessages) log.debug("A real callee that ends at the same instant " +
							"that the caller --> SKIPPING");
				}
			}else{
				log.error("This should not happen :-)");//TODO document better...
			}
			//do something with the total counting result
//			candidateStartTime = iter.next();
		} while (candidateStartTime<callerReportingTime && iter.hasNext());
		if(!suppressDebugMessages) log.debug("Finished the active part");
		while(iter.hasNext()) {
			if(!suppressDebugMessages) log.debug("Skipping callers with time "+iter.next());
		}
		return totalCountingResult;
	}

	/**
	 * Gets the {@link CountingResult}s that exist for the given method name.
	 * @param name The name of a method measured by ByCounter.
	 * @return A {@link List} of {@link CountingResult}s for the given name.
	 */
	public List<CountingResult> getCountingResultsByMethodName(String name){
		List<CountingResult> counts = new ArrayList<CountingResult>();
		Iterator<CountingArtefactInformation> iter = countingInformationsByMethodname.get(name).iterator();
		CountingArtefactInformation cai = null;
		CountingResult cr = null;
		for(;iter.hasNext();){
			cai = iter.next();
			cr = countingResultsByArtefactInformation.get(cai);
			if(cr!=null){
				counts.add(cr);
			}
		}
		return counts;
//		return this.countingResults.get(artefact);
	}

	public CountingResult getInlined_countingResult() {
		return inlined_countingResult;
	}

	/**
	 * Return an appropriate number of tabs to follow the given string.
	 * This is for log formatting purposes only.
	 * @param str String after which the tabs shall follow
	 * @param maxNumTabs maximum number of tabs to return.
	 * @return A string containing a fitting number of tabs.
	 */
	private synchronized String getTabs(String str, int maxNumTabs) {
		StringBuilder tabs = new StringBuilder();
		for(int i = maxNumTabs; i > 0; i--) {
			if(str.length() < 8*i) {//TODO encode tab width variably?
				tabs.append("\t");
			} else {
				break;
			}
		}
		return tabs.toString();
	}

	/**
	 * Print a log message that reports the result, listing all counts and
	 * data that was collected.
	 * @param cr Result to report.
	 */
	public synchronized /*DefaultCategoryDataset*/ void logResult(
			CountingResult cr, 
			boolean printZeros, //eigentlich 3 Abstufungen: gar nicht; wie gespeichert; alle opcodes (auch wenn nicht gespeichert)
			boolean vertically //TODO currently ignored
			) {
		log.info("\n");
		log.info("==START========= Logging CountingResult ================");
		if(cr==null) {
			log.error("CountingResult to log is null, EXITING");
			log.info("== END ========= Logging CountingResult ================");
			return /*null*/;
		}
		String qualifyingMethodName = cr.getQualifyingMethodName(); 
		if(qualifyingMethodName==null || qualifyingMethodName.equals("")) {
			log.error("Qualifying method name is null or empty, EXITING");
			log.info("== END ========= Logging CountingResult ================");
			return /*null*/;
		}
		log.info("qualifyingMethodName: " + qualifyingMethodName);
		if(cr==null){
			log.error("The CountingResult to log is null - nothing to do, returning immediately.");
			log.info("== END ========= Logging CountingResult ================");
			return;
		}

		TreeMap<Integer, Long> opcodeCounts 		= cr.getOpcodeCounts();
		if(opcodeCounts == null) {
			log.error("Opcode counts hashmap is null... EXITING");
			log.info("== END ========= Logging CountingResult ================");
			return /*null*/;
		}

		TreeMap<String, Long> methodCallCounts 		= cr.getMethodCallCounts();
		if(methodCallCounts == null) {
			log.error("Method counts hashmap is null... EXITING");
			log.info("== END ========= Logging CountingResult ================");
			return /*null*/;
		}

		long time = cr.getMethodInvocationBeginning(); 
		if(time<0) {
			log.error("Wrong time: "+time);//TODO which kind of time is this?
			log.info("== END ========= Logging CountingResult ================");
			return /*null*/;
		}

		if(resultWriters.size()>0){
			log.debug("Logging CountinResult using "+resultWriters.size()+
					" registered result writers");
			for(ICountingResultWriter rw : resultWriters){
				rw.writeResult(cr, false, -1);//TODO make this better/parameterised
			}
		}
		
		long[] newArrayCounts 						= cr.getNewArrayCounts();
		int[] newArrayDims 							= cr.getNewArrayDim();
		String[] newArrayTypes 						= cr.getNewArrayTypes();

		// No checks here (but below!) for array results, because null is also 
		// returned when array parameter recording is disabled.
		
		// make sure DisplayOpcodes does not interfere with the output...?
		ASMOpcodesMapper dop = ASMOpcodesMapper.getInstance();
		long totalCountOfAllOpcodes = 0; //you need longs for that...
		long totalCountOfAllMethods = 0; //you need longs for that...
		
		String 	tabs;					// tabulators (for logging)
		String 	currentOpcodeString;	// opcode as string
		long 	currentOpcodeCount;		// opcode count
		long 	currentMethodCount = 0;	// method count
		

		Iterator<Integer> opcodeKeys = opcodeCounts.keySet().iterator();
		Integer currOpcode;
		int numberOfOpcodesWithNonzeroFrequencies=0;
		while(opcodeKeys.hasNext()) {
			currOpcode = opcodeKeys.next();
			currentOpcodeString = dop.getOpcodeString(currOpcode);
			currentOpcodeCount 	= opcodeCounts.get(currOpcode).longValue();
			tabs 				= getTabs(currentOpcodeString + ":", 2);
//			dataset.addValue(currentOpcodeCount, qualifyingMethodName+": instructions", currentOpcodeString);
			if(currentOpcodeCount!=0 || printZeros){
				log.info(currentOpcodeString + ": "+tabs+currentOpcodeCount);//TODO make a cheaper call... append to a StringBuffer
			}
			if((totalCountOfAllOpcodes+currentOpcodeCount)<totalCountOfAllOpcodes){
				log.error("OVERFLOW while adding opcode counts... use BigInteger instead");
			}else{
				totalCountOfAllOpcodes += currentOpcodeCount;
				if(currentOpcodeCount>0){
					numberOfOpcodesWithNonzeroFrequencies++;
				}
			}
		}
		
		Iterator<String> methodSigs = methodCallCounts.keySet().iterator();
		String currentSig;
		while(methodSigs.hasNext()) {
			currentSig = methodSigs.next();
			currentMethodCount = methodCallCounts.get(currentSig);
			tabs = getTabs(currentSig + ":", 9);
//			dataset.addValue(currentMethodCount, qualifyingMethodName+": methods", currentMethodSignature);
			log.info(currentSig + ": " + tabs + currentMethodCount);
			if(totalCountOfAllMethods + currentMethodCount<totalCountOfAllMethods){
				log.error("OVERFLOW while adding method counts");
			}else{
				totalCountOfAllMethods += currentMethodCount;
			}
//			instrnames_texSB.append(currentMethodSignature+" & ");
//			instrcounts_texSB.append(currentMethodCount+" & ");
		}
//		instrnames_texSB.append("total \\\\");
//		instrcounts_texSB.append(totalCountOfAllMethods+" \\\\");

		// because null is a valid value for the array*Something* arrays, 
		// we need to be carefull here.
		if(newArrayCounts != null 
				&& newArrayDims != null 
				&& newArrayTypes != null) {
			for(int i = 0; i < newArrayCounts.length; i++) {
				log.info("new array of type '" + newArrayTypes[i] + "'" 
						+ (newArrayDims[i] > 0 ? ", dim " + newArrayDims[i] : "")
						+ ": " + newArrayCounts[i]);
			}
		}
		log.info("====================================================");
		log.info(totalCountOfAllOpcodes + " instruc. executions of "+
				numberOfOpcodesWithNonzeroFrequencies + " different opcodes were counted.");
		log.info(totalCountOfAllMethods + " methods invocations of "+
				methodCallCounts.size() + " different signatures were counted.");
		log.info("== END ========= Logging CountingResult ================");
	}

	/**
	 * An instrumented class calls this method to report the instruction and method call counts.
	 * This version gathers integer counts 
	 * (the simpler "IINC" instrumentation has some performance advantages), 
	 * but the data is saved as "longs" in CountingResultCollector anyway.
	 * @param executionStart Time at which the reporting method started the execution
	 * @param qualifyingMethodName Fully qualified method name.
	 * @param opcodeCounts An array of integers where each bytecode instruction is 
	 *        the index for which the value represents the number of calls to a 
	 *        specific instruction.
	 * @param methodCallCounts An array of integers where each element represents 
	 *        the number of times, the method was called.
	 *        The index is the same as for calledMethods.
	 * @param calledMethods An array of strings where each element is a 
	 *        method signature.
	 *        The index is the same as for methodCallCounts.
	 * @param newArrayCounts The counts for the specific *newarray call.
	 *        The index is the same as for newArrayTypeOrDim and newArrayDesc.
	 * @param newArrayTypeOrDim Depending on the type of the specific *newarray 
	 *        call, this is either a type integer or the dimension for the array.
	 *        The index is the same as for newArrayCounts and newArrayDesc.
	 * @param newArrayDescr For array consisting of object types, this is the 
	 *        type descriptor.
	 *        The index is the same as for newArrayCounts and newArrayTypeOrDim.
	 */
	@SuppressWarnings("boxing")
	public synchronized void protocolCountInt(
			long executionStart, 
			String qualifyingMethodName, 
			int[] opcodeCounts, 
			int[] methodCallCounts,
			String[] calledMethods,
			int[] newArrayCounts,
			int[] newArrayTypeOrDim,
			String[] newArrayDescr) {
		this.protocolCountLong(executionStart, qualifyingMethodName, //TODO 
				convertIntArrayToLongArray(opcodeCounts), 
				convertIntArrayToLongArray(methodCallCounts), calledMethods, 
				convertIntArrayToLongArray(newArrayCounts), newArrayTypeOrDim, newArrayDescr);
	}

	public synchronized void protocolCountInt_inline(
			long executionStart, 
			String qualifyingMethodName, 
			int[] opcodeCounts, 
			int[] methodCallCounts,
			String[] calledMethods,
			int[] newArrayCounts,
			int[] newArrayTypeOrDim,
			String[] newArrayDescr) {
		System.err.println("protocolCountInt_inline not implemented yet");
	}

	/**
	 * An instrumented class calls this method to report the instruction and method call counts.
	 * This version gathers long counts.
	 * @param executionStart Time at which the reporting method started the execution
	 * @param qualifyingMethodName Fully qualified method name.
	 * @param opcodeCounts An array of integers where each bytecode instruction is 
	 *        the index for which the value represents the number of calls to a 
	 *        specific instruction.
	 * @param methodCallCounts An array of integers where each element represents 
	 *        the number of times, the method was called.
	 *        The index is the same as for calledMethods.
	 * @param calledMethods An array of strings where each element is a 
	 *        method signature.
	 *        The index is the same as for methodCallCounts.
	 * @param newArrayCounts The counts for the specific *newarray call.
	 *        The index is the same as for newArrayTypeOrDim and newArrayDesc.
	 * @param newArrayTypeOrDim Depending on the type of the specific *newarray 
	 *        call, this is either a type integer or the dimension for the array.
	 *        The index is the same as for newArrayCounts and newArrayDesc.
	 * @param newArrayDescr For array consisting of object types, this is the 
	 *        type descriptor.
	 *        The index is the same as for newArrayCounts and newArrayTypeOrDim.
	 */
	@SuppressWarnings("boxing")
	public synchronized void protocolCountLong(
			long executionStart, 
			String qualifyingMethodName, 
			long[] opcodeCounts, 
			long[] methodCallCounts,
			String[] calledMethods,
			long[] newArrayCounts,
			int[] newArrayTypeOrDim,
			String[] newArrayDescr) {

//		log.info("protocolCountLong called by method "+qualifyingMethodName+"" +
//				"\n\t\t"+"to report execution that started at "+executionStart+": " +
//				"\n\t\t"+Arrays.toString(opcodeCounts)+" opcode counts, etc.");
		
		long reportingStart = System.nanoTime();
		TreeMap<Integer, Long> filteredCounts = new TreeMap<Integer, Long>();
		TreeMap<String, Long> methodCounts = new TreeMap<String, Long>();
		int[] newArrayDim = null;
		String[] newArrayType = null;

		//TODO check proper length
		// remove all 0 counts
		for(int opcode = 0; opcode < opcodeCounts.length; opcode++) {
			if(opcodeCounts[opcode] != 0) {
				filteredCounts.put(opcode, opcodeCounts[opcode]);
			}
		}
		
		assert methodCallCounts.length == calledMethods.length;
		// create a HashMap for the method signatures and their counts
		for(int i = 0; i < methodCallCounts.length; i++) {
			methodCounts.put(calledMethods[i], methodCallCounts[i]);
		}
		
		if(newArrayCounts != null && newArrayTypeOrDim != null && newArrayDescr != null) {
			// process information for the *newarray counts
			newArrayType = new String[newArrayCounts.length];
			newArrayDim = new int[newArrayCounts.length];
			
			for(int i = 0; i < newArrayCounts.length; i++) {
				// check whether the type is coded into the integer
				if(newArrayDescr[i] == AdditionalOpcodeInformation.NO_INFORMATION_STRING) {
					String str = null;
					// convert the type to a readable string
					switch(newArrayTypeOrDim[i]) {
					case 4:
						str = "boolean";
						break;
					case 5:
						str = "char";
						break;
					case 6:
						str = "float";
						break;
					case 7:
						str = "double";
						break;
					case 8:
						str = "byte";
						break;
					case 9:
						str = "short";
						break;
					case 10:
						str = "int";
						break;
					case 11:
						str = "long";
						break;
					default:
						log.error("Unknown object type id: " + newArrayTypeOrDim[i]);
						break;
					}
					newArrayType[i] = str;
					// no dimension information here
					newArrayDim[i] = AdditionalOpcodeInformation.NO_INFORMATION_INT;
				} else {
					// Type is there as descriptor - just copy it
					newArrayType[i] = newArrayDescr[i];
					// copy the dimension information
					newArrayDim[i] = newArrayTypeOrDim[i];
				}
			}
		}
		
		CountingResult res = new CountingResult(
				/*executionStart, 
				qualifyingMethodName, 
				filteredCounts, 
				methodCounts,
				newArrayCounts,
				newArrayDim,
				newArrayType*/
			qualifyingMethodName, //TODO fix it --> Martin; vgl. javadocs zu CountingResult
			qualifyingMethodName, 
			0, //TODO document
			0L, //TODO document
			0L, //TODO document
			executionStart, 
			reportingStart, 
			filteredCounts, //new HashMap<Integer,Integer>(),//TODO //opcodeCounts, //must be a hash map!
			methodCounts,
			newArrayCounts,
			newArrayDim,
			newArrayType,
			null, //sectionInstCounts,
			null  //sectionMethCounts
			);
		this.countingResults.add(res);
		
		CountingArtefactInformation artefact;
		artefact = new CountingArtefactInformation(
				qualifyingMethodName,
				executionStart,
				null,
				reportingStart,
				null);
		
		this.countingInformationsByBeginning.put(executionStart, artefact);
		Set<String> keys = this.countingInformationsByMethodname.keySet();
		if(keys.contains(qualifyingMethodName)){
			this.countingInformationsByMethodname.get(qualifyingMethodName).add(artefact);
		}else{
			List<CountingArtefactInformation> list = new ArrayList<CountingArtefactInformation>();
			list.add(artefact);
			this.countingInformationsByMethodname.put(qualifyingMethodName, list);
		}
		this.countingResultsByArtefactInformation.put(artefact, res);
//		this.logResult(res);
	}

	/**
	 * TODO test me...
	 * how far is "synchronized" problematic in multi-threading?
	 */
	public synchronized void protocolCountLong_inline(
			long executionStart, 
			String qualifyingMethodName, 
			long[] opcodeCounts, 
			long[] methodCallCounts,
			String[] calledMethods //,
//			long[] newArrayCounts, //ignore
//			int[] newArrayTypeOrDim,//ignore
//			String[] newArrayDescr //ignore
			) {
		long reportingStart = System.nanoTime();//can be ignored
		TreeMap<String,Long> methods = this.inlined_countingResult.getMethodCallCounts();
		TreeMap<Integer,Long> opcodes = this.inlined_countingResult.getOpcodeCounts();
		Long currMethodCount;
		Long currOpcodeCount;
		for(int opcode = 0; opcode < opcodeCounts.length; opcode++) {
			//check opcodeCounts[opcode] for being zero and skip the following actions?
			currOpcodeCount = opcodes.get(opcode);
			if(currOpcodeCount == null){
				opcodes.put(opcode, opcodeCounts[opcode]);
			}else{
				opcodes.put(opcode, currOpcodeCount + opcodeCounts[opcode]); //superfluous additions of repeated zeros?
			}
		}
		assert methodCallCounts.length == calledMethods.length;
		// create a HashMap for the method signatures and their counts
		for(int i = 0; i < methodCallCounts.length; i++) {
			currMethodCount = methods.get(calledMethods[i]);
			if(currMethodCount == null){
				methods.put(calledMethods[i], methodCallCounts[i]);
			}else{
				methods.put(calledMethods[i], currMethodCount+methodCallCounts[i]);//superfluous additions of repeated zeros?
			}
		}
		this.inlined_countingResult.overwriteMethodCallCounts(methods);
		this.inlined_countingResult.overwriteOpcodeCounts(opcodes);
		
		//increasing the count of how often this method was inlined //TODO make sure this is printed by SPECCompressCountingStarter etc.
		Integer count = this.inlined_methodsMap.get(qualifyingMethodName);
		if(count==null || count.equals(new Integer(0))){
			this.inlined_methodsMap.put(qualifyingMethodName, 1);
			log.debug("First time that counts inlined for "+qualifyingMethodName);
			log.warn("protocolCountLong_inline ignores array details");
		}else{
			this.inlined_methodsMap.put(qualifyingMethodName, count+1);
//			log.debug((count+1)+". time that counts inlined for "+qualifyingMethodName);
		}
		
//		//TODO replace cloning
//		TreeMap<Integer,Long> resultOpcodeCounts = new TreeMap<Integer, Long>();
//		TreeMap<String,Long>  resultMethodCallCounts = new TreeMap<String, Long>();
//		// the following three lists need to keep their indices in sync
//		ArrayList<Long> resultNewArrayCounts = new ArrayList<Long>();
//		ArrayList<Integer> resultNewArrayDim = new ArrayList<Integer>();
//		ArrayList<String> resultNewArrayType = new ArrayList<String>();	
//
//		long[] resultNewArrayCountsArray = null;
//		int[] resultNewArrayDimArray = null;
//		String[] resultNewArrayTypeArray = null;
//		
//		Integer keyInt;
//		String keyString;
//
//		Long resultValue;
//		Integer rightKey;
//		String rightKey_String;
//		Long rightValue;
//
//		// set all opcode counts for which 'left' has keys:
//		Iterator<Integer> iteratorOpcodes = left.opcodeCounts.keySet().iterator();
//		while (iteratorOpcodes.hasNext()) {
//			keyInt = iteratorOpcodes.next();
//			rightValue = right.opcodeCounts.get(keyInt);
//			resultValue = left.opcodeCounts.get(keyInt);
//			if(rightValue != null) {
//				resultValue += rightValue;
//			}
//			resultOpcodeCounts.put(
//					new Integer(keyInt), 
//					new Long(resultValue));
//		}
//		// set all opcode counts for which only 'right' has keys:
//		Iterator<Integer> opcodesKeysetRight = right.getOpcodeCounts().keySet().iterator();
//		while (opcodesKeysetRight.hasNext()){
//			rightKey = opcodesKeysetRight.next();
//			rightValue = right.opcodeCounts.get(rightKey);
//			resultValue = resultOpcodeCounts.get(rightKey);
//			if(resultValue == null) {
//				resultOpcodeCounts.put(rightKey, rightValue);
//			}
//		}
//		
//		// set all method call counts for which 'left' has keys:
//		Iterator<String> iteratorMethods = left.methodCallCounts.keySet().iterator();
//		while (iteratorMethods.hasNext()) {
//			keyString = iteratorMethods.next();
//			rightValue = right.methodCallCounts.get(keyString);
//			resultValue = left.methodCallCounts.get(keyString);
//			if(rightValue != null) {
//				resultValue += rightValue;
//			}
//			resultMethodCallCounts.put(
//					new String(keyString), 
//					new Long(resultValue));
//		}
//		// set all method call counts for which only 'right' has keys:		
//		Iterator<String> methodsKeysetRight = right.getMethodCallCounts().keySet().iterator();
//		while (methodsKeysetRight.hasNext()) {
//			rightKey_String = methodsKeysetRight.next();
//			rightValue = right.methodCallCounts.get(rightKey_String);
//			resultValue = resultMethodCallCounts.get(rightKey_String);
//			if(resultValue == null) {
//				resultMethodCallCounts.put(rightKey_String, rightValue);
//			}
//		}
//		if(left.getNewArrayCounts() != null && right.getNewArrayCounts() != null) {
//			// copy array counts from 'left':
//			for(int i = 0; i < left.getNewArrayCounts().length; i++) {
//				resultNewArrayCounts.add(left.getNewArrayCounts()[i]);
//				resultNewArrayDim.add(left.getNewArrayDim()[i]);
//				resultNewArrayType.add(left.getNewArrayTypes()[i]);
//			}
//			
//			int rightDim;
//			String rightType;
//			long rightCount;
//			int resultDim;
//			String resultType;
//			boolean currentCountDone;
//			// now merge in the array counts from 'right'
//			for(int i = 0; i < right.getNewArrayCounts().length; i++) {
//				rightDim = right.getNewArrayDim()[i];
//				rightType = right.getNewArrayTypes()[i];
//				rightCount = right.getNewArrayCounts()[i];
//				currentCountDone = false;
//				// is this entry in the list already?
//				for(int j = 0; j < resultNewArrayCounts.size() && !currentCountDone; j++) {
//					resultDim = resultNewArrayDim.get(j);
//					resultType = resultNewArrayType.get(j);
//					if(rightDim == resultDim
//							&& rightType.equals(resultType)) {
//						// add the count value
//						resultNewArrayCounts.set(j, 
//								resultNewArrayCounts.get(j) + rightCount);
//						currentCountDone = true;
//					}
//				}
//				if(!currentCountDone) {
//					// we have a new type/dimension; add it to the result
//					resultNewArrayCounts.add(rightCount);
//					resultNewArrayDim.add(rightDim);
//					resultNewArrayType.add(rightType);
//				}
//			}
//			// create arrays from the arraylists
//			int numOfNewArray = resultNewArrayCounts.size();
//			resultNewArrayCountsArray = new long[numOfNewArray];
//			resultNewArrayDimArray = new int[numOfNewArray];
//			resultNewArrayTypeArray = resultNewArrayType.toArray(new String[numOfNewArray]);
//			for(int i = 0; i < numOfNewArray; i++) {
//				resultNewArrayCountsArray[i] = resultNewArrayCounts.get(i);
//				resultNewArrayDimArray[i] = resultNewArrayDim.get(i);
//			}
//		}
//		
//		CountingResult cr;
//		cr = new CountingResult(
//				new String(""),
//				new String(""),
//				0,
//				0L,
//				0L,
//				-1L,
//				-1L,
//				resultOpcodeCounts,
//				resultMethodCallCounts,
//				resultNewArrayCountsArray,
//				resultNewArrayDimArray,
//				resultNewArrayTypeArray,
//				null,
//				null);
//		return cr;
//		
//		this.inlined_countingResult.set
//
//		TreeMap<Integer, Long> filteredCounts = new TreeMap<Integer, Long>();
//		TreeMap<String, Long> methodCounts = new TreeMap<String, Long>();
////		int[] newArrayDim = null;//ignore
////		String[] newArrayType = null;//ignore
//
//		for(int opcode = 0; opcode < opcodeCounts.length; opcode++) {
////			if(opcodeCounts[opcode] != 0) {// remove all 0 counts
//				filteredCounts.put(opcode, opcodeCounts[opcode]);
////			}
//		}
//		
//		assert methodCallCounts.length == calledMethods.length;
//		// create a HashMap for the method signatures and their counts
//		for(int i = 0; i < methodCallCounts.length; i++) {
//			methodCounts.put(calledMethods[i], methodCallCounts[i]);
//		}
//		
//		
//		CountingResult res = new CountingResult(
//				/*executionStart, 
//				qualifyingMethodName, 
//				filteredCounts, 
//				methodCounts,
//				newArrayCounts,
//				newArrayDim,
//				newArrayType*/
//			qualifyingMethodName, //ID //TODO fix it --> Martin; vgl. javadocs zu CountingResult
//			qualifyingMethodName, 
//			0, //TODO document
//			0L, //TODO document
//			0L, //TODO document
//			executionStart, 
//			reportingStart, 
//			filteredCounts, //new HashMap<Integer,Integer>(),//TODO //opcodeCounts, //must be a hash map!
//			methodCounts,
//			null, //newArrayCounts,
//			null, //newArrayDim,
//			null, //newArrayType,
//			null, //sectionInstCounts,
//			null  //sectionMethCounts
//			);
//		this.inlined_countingResult.add_methodsInstructionsOnly(res);
//		
//		CountingArtefactInformation artefact;
//		artefact = new CountingArtefactInformation(
//				qualifyingMethodName,
//				executionStart,
//				null,//input parameters
//				reportingStart,
//				null);//output parameters
//		
//		this.countingInformationsByBeginning.put(executionStart, artefact);
//		Set<String> keys = this.countingInformationsByMethodname.keySet();
//		if(keys.contains(qualifyingMethodName)){
//			this.countingInformationsByMethodname.get(qualifyingMethodName).add(artefact);
//		}else{
//			List<CountingArtefactInformation> list = new ArrayList<CountingArtefactInformation>();
//			list.add(artefact);
//			this.countingInformationsByMethodname.put(qualifyingMethodName, list);
//		}
//		this.countingResultsByArtefactInformation.put(artefact, res);
////		this.logResult(res);
	}
	
	public void registerWriter(ICountingResultWriter resultWriter){
		this.resultWriters.add(resultWriter);
	}

	public void resetInlinedCountingResult() {
		inlined_countingResult.resetMethodInstructionCountsOnly();
	}

	public void monitorShouldStop() {
		this.setMonitorShouldStop(true);
		
	}

//	/**
//	 * Print a log message that reports the result, listing all counts and
//	 * data that was collected.
//	 * @param r Result to report.
//	 * @return A dataset of the counting results.
//	 */
//	public synchronized DefaultCategoryDataset logResult_alt(CountingResult r) {
//		
//		long time = r.getTime(); 
//		String qualifyingMethodName = r.getQualifyingMethodName(); 
//		
//		HashMap<Integer, Integer> opcodeCounts = r.getOpcodeCounts();
//		HashMap<String, Integer> methodCallCounts = r.getMethodCallCounts();
//		
//		int[] newArrayCounts = r.getNewArrayCounts();
//		int[] newArrayDims = r.getNewArrayDim();
//		String[] newArrayTypes = r.getNewArrayTypes();
//
//		if(time<0) {
//			log.error("Wrong time: "+time);
//			return null;
//		}
//		if(qualifyingMethodName==null || qualifyingMethodName.equals("")) {
//			log.error("Qualifying method name is null or empty");
//			return null;
//		}
//		if(opcodeCounts == null) {
//			log.error("Opcode counts hashmap is null... returning");
//			return null;
//		}
//		if(methodCallCounts == null) {
//			log.error("Method counts hashmap is null... returning");
//			return null;
//		}
//		
//		// make sure DisplayOpcodes does not interfer the output
//		ASMOpcodesMapper dop = ASMOpcodesMapper.getInstance();
//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//		log.info("\n================ CountingResultCollector ================");
//		log.info("qualifyingMethodName: " + qualifyingMethodName);
//		log.info("Opcodes, methods and their counts:");
//		int totalNrOfCountedOpcodes = 0;
//		int totalNrOfCountedMethods = 0;
//		
//		String 	opcString;	// opcode as string
//		int 	currentOpcodeCount;	// opcode count
//		String 	tabs;		// tabulators (for logging)
//		int currMethodCount = 0;
//		
//		for(int opcode : opcodeCounts.keySet()) {
//			opcString = dop.getOpcodeString(opcode);
//			currentOpcodeCount = opcodeCounts.get(opcode).intValue();
//			tabs = getTabs(opcString + ":", 2);
//			dataset.addValue(currentOpcodeCount, qualifyingMethodName+": instructions", opcString);
//			log.info(opcString + ": "+tabs+currentOpcodeCount);
//			totalNrOfCountedOpcodes += currentOpcodeCount;
//		}
//		for(String methodSig : methodCallCounts.keySet()) {
//			currMethodCount = methodCallCounts.get(methodSig);
//			tabs = getTabs(methodSig + ":", 9);
//			dataset.addValue(currMethodCount, qualifyingMethodName+": methods", methodSig);
//			log.info(methodSig + ": " + tabs + currMethodCount);
//			totalNrOfCountedMethods += currMethodCount;
//		}
//
//		if(newArrayCounts != null 
//				&& newArrayDims != null 
//				&& newArrayTypes != null) {
//			for(int i = 0; i < newArrayCounts.length; i++) {
//				log.info("new array of type '" + newArrayTypes[i] + "'" 
//						+ (newArrayDims[i] > 0 ? ", dim " + newArrayDims[i] : "")
//						+ ": " + newArrayCounts[i]);
//			}
//		}
//		System.out.println("====================================================");
//		log.info(totalNrOfCountedOpcodes + " opcodes of "+opcodeCounts.size() + " different types were counted.\n");
//		log.info(totalNrOfCountedMethods + " methods of "+methodCallCounts.size() + " different types were counted.\n");
//		createAndSaveChart(time, dataset, true, true, 1200, 900, qualifyingMethodName, "charts");
//		return dataset;
//	}

}
