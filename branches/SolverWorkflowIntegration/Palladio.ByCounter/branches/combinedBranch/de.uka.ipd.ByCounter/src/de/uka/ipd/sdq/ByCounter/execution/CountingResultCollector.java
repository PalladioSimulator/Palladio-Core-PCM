package de.uka.ipd.sdq.ByCounter.execution;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger; //TODO remove a dependency on this... use Java-own logger?

import de.uka.ipd.sdq.ByCounter.instrumentation.AdditionalOpcodeInformation;
import de.uka.ipd.sdq.ByCounter.utils.ASMOpcodesMapper;
import de.uka.ipd.sdq.ByCounter.utils.IResultWriter;

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
	 * Database replacement ;-)
	 */
	private HashMap<CountingArtefactInformation, CountingResult> countingResults;
	
	/**
	 * see http://en.wikipedia.org/wiki/Data_log
	 */
	private Logger log;
		
	/**
	 *	a simple ArrayList that holds a list of results
	 */
	private ArrayList<CountingResult> results;
	
	/**
	 * When a {@link CountingResult} is logged, all known writers will be
	 * asked to log (write) it as well. This mechanism is introduced to
	 * decouple {@link CountingResultCollector} from specific mechanisms and 
	 * frameworks, such as CSV writing, JFreeChart creation etc.
	 */
	List<IResultWriter> resultWriters;
	
	/**
	 * Private constructor that is invoked to create the singleton instance
	 */
	private CountingResultCollector() {
		log = Logger.getLogger(this.getClass().getCanonicalName());
		countingInformationsByBeginning = new HashMap<Long, CountingArtefactInformation>();
		countingInformationsByMethodname = new HashMap<String, List<CountingArtefactInformation>>();
		countingResults = new HashMap<CountingArtefactInformation, CountingResult>();
		results = new ArrayList<CountingResult>();
		resultWriters = new ArrayList<IResultWriter>();
	}
	
	/**
	 * Clear all results in the internal list.
	 */
	public synchronized void clearResults() {
		log.debug("Used to have "+results.size()+" results before clearing");
		countingInformationsByBeginning.clear();
		countingInformationsByMethodname.clear();
		countingResults.clear();
		results.clear();
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
	 * Gets the {@link CountingArtefactInformation} by the time of 
	 * method execution beginning.
	 * @return A {@link HashMap}. The long value is the time as 
	 * returned by System.nanoTime().
	 */
	public HashMap<Long, CountingArtefactInformation> getCountingInformationsByBeginning() {
		return countingInformationsByBeginning;
	}
	
	/**
	 * Gets the {@link CountingArtefactInformation} by method name.
	 * @return A {@link HashMap}. The {@link String} is the method name.
	 */
	public HashMap<String, List<CountingArtefactInformation>> getCountingInformationsByMethodname() {
		return countingInformationsByMethodname;
	}

	/**
	 * Gets the mapping of {@link CountingArtefactInformation} to {@link CountingResult}s.
	 * @return The mapping as {@link HashMap}.
	 */
	public HashMap<CountingArtefactInformation, CountingResult> getCountingResults() {
		return countingResults;
	}

	/** 
	 * Gets the {@link CountingResult} that corresponds to the given 
	 * {@link CountingArtefactInformation}.
	 * @param cai A {@link CountingArtefactInformation}.
	 * @return The {@link CountingResult} described by cai.
	 */
	public CountingResult getCountsByArtefact(CountingArtefactInformation cai) {
		return this.countingResults.get(cai);
	}

	/**TODO
	 * Gets a {@link CountingResult} that is the accumulation of all 
	 * 
	 * @param callerStartTime
	 * @return The calculated {@link CountingResult}.
	 */
	public CountingResult getCounts_evaluateCallingTree(Long callerStartTime){
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
		CountingResult totalCountingResult = this.getCountsByTime(callerStartTime);
		log.debug("Counting result before addition: "+totalCountingResult);
		
		while(candidateStartTime<callerStartTime){//ECHT kleiner!
			log.debug("Ignoring time "+candidateStartTime+" because <"+callerStartTime);
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
			log.debug("Considering  for addition: "+canditateCAI+"");
			log.debug("Just for the record: trying to add " +
					"["+candidateStartTime+","+candidateReportingTime+"] to " +
					"["+callerStartTime+","+callerReportingTime+"].");
			// candidate results were reported before the caller was
			// assume that the caller has called the candidate and add it
			if(candidateReportingTime.longValue()<callerReportingTime.longValue()){
				log.debug("Adding callee counts of time "+candidateStartTime+
						" because its start >"+callerStartTime+
						" and because its reporting time " +
						"("+canditateCAI.getResultsReceivedByCollectorTime()+")< " +
						"caller reporting time ("+callerReportingTime+").");
				candidateCountingResult = canditateCAI.getCountingResult();
				log.debug("Added counting result: "+candidateCountingResult);
				totalCountingResult.add(candidateCountingResult);
				log.debug("Intermediate total counting result: "+totalCountingResult);
			}else if(candidateReportingTime.longValue()>callerReportingTime.longValue()){
				log.debug("Skipping callee counts of time "+candidateStartTime+
						" because, while its start time >"+callerStartTime+
						", its reporting time " +
						"("+canditateCAI.getResultsReceivedByCollectorTime()+")> " +
						"caller reporting time ("+callerReportingTime+").");
			}else if(candidateReportingTime.longValue()==callerReportingTime.longValue()){
				if(candidateStartTime.longValue()==callerStartTime.longValue()){ 
					log.debug("Potential callee is the caller herself -> skipping");
				}else{
					log.error("A real callee that ends at the same instant " +
							"that the caller --> SKIPPING");
				}
			}else{
				log.error("This should not happen :-)");//TODO document better...
			}
			//do something with the total counting result
//			candidateStartTime = iter.next();
		} while (candidateStartTime<callerReportingTime && iter.hasNext());
		log.debug("Finished the active part");
		while(iter.hasNext()) {
			log.debug("Skipping callers with time "+iter.next());
		}
		return totalCountingResult;
	}

	/**
	 * Gets the {@link CountingResult}s that exist for the given method name.
	 * @param name The name of a method measured by ByCounter.
	 * @return A {@link List} of {@link CountingResult}s for the given name.
	 */
	public List<CountingResult> getCountsByName(String name){
		List<CountingResult> counts = new ArrayList<CountingResult>();
		Iterator<CountingArtefactInformation> iter = countingInformationsByMethodname.get(name).iterator();
		CountingArtefactInformation cai = null;
		CountingResult cr = null;
		for(;iter.hasNext();){
			cai = iter.next();
			cr = countingResults.get(cai);
			if(cr!=null){
				counts.add(cr);
			}
		}
		return counts;
//		return this.countingResults.get(artefact);
	}

	/**
	 * Gets the {@link CountingArtefactInformation} by the time of 
	 * method execution beginning.
	 * @param time A time as returned by System.nanoTime().
	 * @return The specified {@link CountingResult}.
	 */
	public CountingResult getCountsByTime(long time){
		CountingArtefactInformation cai = this.countingInformationsByBeginning.get(time);
		if(cai==null){
			log.error("No counting artefact information for starting time "+time);
			return null;
		}else{
			return this.countingResults.get(cai);
		}
	}

	/** 
	 * Gets the {@link CountingArtefactInformation} by the time of 
	 * method execution beginning.
	 * Timestamp should be unique. 
	 * @param timestamp A time as {@link Timestamp}.
	 * @return The specified {@link CountingResult}.
	 */
	public CountingResult getCountsByTimestamp(Timestamp timestamp){
		return this.countingResults.get(this.countingInformationsByBeginning.get(timestamp));
	}

	/**
	 * Get all results the {@link CountingResultCollector} holds.
	 * This does not clear the {@link CountingResultCollector} list. You have to explicitly
	 * call <code>clearResults()</code> if that is your intention.
	 * This method is the same as <code>getResults(false)</code>.
	 * @return A <code>Result</code> list.
	 */
	public synchronized List<CountingResult> getResults() {
		return getResults(false);
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
	 * @return A <code>Result</code> list.
	 */
	public synchronized List<CountingResult> getResults(boolean recursive) {
		if(!recursive) {
			return results;
		} else {
			// calculate the sums for all results
			ArrayList<CountingResult> calcResult = 
				new ArrayList<CountingResult>(results.size());
			long callerStartTime;
			for(int i = 0; i < results.size(); i++) {
				callerStartTime = results.get(i).getTime();
				calcResult.add(this.getCounts_evaluateCallingTree(callerStartTime));
			}
			return calcResult;
		}
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
	public synchronized CountingResult[] getResultsAsArray(boolean recursive) {
		return getResults(recursive).toArray(new CountingResult[results.size()]);
	}

	/**
	 * Gets all result writers registered to the collector.
	 * @return A list of {@link IResultWriter}s.
	 */
	public List<IResultWriter> getResultWriters() {
		return resultWriters;
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
	public synchronized /*DefaultCategoryDataset*/ void logResult(CountingResult cr) {
		log.info("Logging/writing results...");
		for(IResultWriter rw : resultWriters){
			rw.writeResult(cr);
		}
		
		long time = cr.getTime(); 
		String qualifyingMethodName = cr.getQualifyingMethodName(); 

		HashMap<Integer, Long> opcodeCounts 		= cr.getOpcodeCounts();
		HashMap<String, Long> methodCallCounts 		= cr.getMethodCallCounts();
		long[] newArrayCounts 						= cr.getNewArrayCounts();
		int[] newArrayDims 							= cr.getNewArrayDim();
		String[] newArrayTypes 						= cr.getNewArrayTypes();

		if(time<0) {
			log.error("Wrong time: "+time);//TODO which kind of time is this?
			return /*null*/;
		}
		if(qualifyingMethodName==null || qualifyingMethodName.equals("")) {
			log.error("Qualifying method name is null or empty, EXITING");
			return /*null*/;
		}
		if(opcodeCounts == null) {
			log.error("Opcode counts hashmap is null... EXITING");
			return /*null*/;
		}
		if(methodCallCounts == null) {
			log.error("Method counts hashmap is null... EXITING");
			return /*null*/;
		}
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
		

		log.info("\n");
		log.info("================ CountingResultCollector ================");
		log.info("qualifyingMethodName: " + qualifyingMethodName);
		log.info("Opcodes, methods and their counts:");
		
		//TODO FIXME TESTME
		List<Integer> listOpcodes = new ArrayList<Integer>(opcodeCounts.keySet());
		Collections.sort(listOpcodes);
		
		for(int currentOpcode : listOpcodes) {
			currentOpcodeString = dop.getOpcodeString(currentOpcode);
			currentOpcodeCount 	= opcodeCounts.get(currentOpcode).intValue();
			tabs 				= getTabs(currentOpcodeString + ":", 2);
//			dataset.addValue(currentOpcodeCount, qualifyingMethodName+": instructions", currentOpcodeString);
			log.info(currentOpcodeString + ": "+tabs+currentOpcodeCount);
			if((totalCountOfAllOpcodes+currentOpcodeCount)<totalCountOfAllOpcodes){
				log.error("OVERFLOW while adding opcode counts... use BigInteger instead");
			}else{
				totalCountOfAllOpcodes += currentOpcodeCount;
			}
//			opcodes_texSB.append(currentOpcode+" & ");
//			opnames_texSB.append(currentOpcodeString+" & ");
//			opcounts_texSB.append(currentOpcodeCount+" & ");
		}
//		opcodes_texSB.append("total \\\\");
//		opnames_texSB.append("total \\\\");
//		opcounts_texSB.append(totalCountOfAllOpcodes+" \\\\");
		
		
		List<String> methodSigs = new ArrayList<String>(methodCallCounts.keySet());
		Collections.sort(methodSigs);
		for(String currentMethodSignature : methodSigs) {
			currentMethodCount = methodCallCounts.get(currentMethodSignature);
			tabs = getTabs(currentMethodSignature + ":", 9);
//			dataset.addValue(currentMethodCount, qualifyingMethodName+": methods", currentMethodSignature);
			log.info(currentMethodSignature + ": " + tabs + currentMethodCount);
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
		log.info(totalCountOfAllOpcodes + " opcodes of "+opcodeCounts.size() + " different types were counted.\n");
		log.info(totalCountOfAllMethods + " methods of "+methodCallCounts.size() + " different types were counted.\n");
		log.info("====================================================");
		//TODO put this into an appropriate place... createAndSaveChart(time, dataset, true, true, 1200, 900, qualifyingMethodName, "charts");
		log.info("\n");
//		log.info("\\begin{table}[b]");
		log.info("\n");
//		log.info(opcodes_texSB.toString());//intentionally non-logger output
//		log.info(opnames_texSB.toString());
//		log.info(opcounts_texSB.toString());
		log.info("\n");
//		log.info(instrnames_texSB.toString());
//		log.info(instrcounts_texSB.toString());
		
//		List<Integer> methodCounts = methodCallCounts.values();
//		int manualSum
//		for (Iterator<Integer> iterator = methodCounts.iterator(); iterator.hasNext();) {
//			Integer integer = iterator.next();
//			
//		}
//		return dataset;
	}

	/**
	 * An instrumented class calls this method to report the instruction and method call counts.
	 * This version gathers integer counts.
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
		this.protocolCountLong(executionStart, qualifyingMethodName, 
				convertIntArrayToLongArray(opcodeCounts), 
				convertIntArrayToLongArray(methodCallCounts), calledMethods, 
				convertIntArrayToLongArray(newArrayCounts), newArrayTypeOrDim, newArrayDescr);
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
		log.info("Called by method "+qualifyingMethodName+"" +
				"\n\t\t"+"to report execution that started at "+executionStart+": " +
				"\n\t\t"+Arrays.toString(opcodeCounts)+" opcode counts, etc.");
		
		long reportingStart = System.nanoTime();
		HashMap<Integer, Long> filteredCounts = new HashMap<Integer, Long>();
		HashMap<String, Long> methodCounts = new HashMap<String, Long>();
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
			qualifyingMethodName, 
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
		this.results.add(res);
		
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
		this.countingResults.put(artefact, res);
//		this.logResult(res);
	}

	public void registerWriter(IResultWriter resultWriter){
		this.resultWriters.add(resultWriter);
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
