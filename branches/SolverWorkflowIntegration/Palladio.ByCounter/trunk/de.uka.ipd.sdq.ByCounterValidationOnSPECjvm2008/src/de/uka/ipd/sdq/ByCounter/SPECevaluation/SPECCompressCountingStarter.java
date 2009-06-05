package de.uka.ipd.sdq.ByCounter.SPECevaluation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.log4j.Logger;

import spec.benchmarks.compress.Harness;

import de.uka.ipd.sdq.ByCounter.execution.BytecodeCounter;
import de.uka.ipd.sdq.ByCounter.execution.BytecodeSectionDescription;
import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollectorMonitor;
import de.uka.ipd.sdq.ByCounter.instrumentation.InstrumentationParameters;
import de.uka.ipd.sdq.ByCounter.utils.CSVCountingResultWriter;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * @author Michael Kuperberg
 * TODO add documentation, proper logging, ...
 */
public class SPECCompressCountingStarter {
	private static final int DEFAULT_NUMBER_OF_MEASUREMENTS = 100;
	
	private CSVCountingResultWriter csvrw; //why not CSVWriterAndAppenderForSPEC ?

	private Thread t1;

	/**
	 * The application entry point. See source code for documentation.
	 * @param args No arguments are needed.
	 */
	public static void main(String[] args) {
		SPECCompressCountingStarter sccs = new SPECCompressCountingStarter();
		sccs.runAll();
	}

	private void runAll() {
		Harness.MK_persistExecutionDurationMeasurements = false;//TODO create and use setters
		
		CountingResult stufe1=null, stufe1posttest=null, stufe2=null, stufe3=null;
		CountingResult stufe3pretest1=null, stufe3pretest2=null;
		CountingResult stufe3pretest3=null, stufe3pretest4=null;
		CountingResult stufe3pretest5=null, stufe3pretest6=null;
		
		//only the compress method is instrumented
//		stufe1= runStufe1(sccs); 		printVisualSeparator();
		
		//the compress method plus HashTable.hsize, HashTable.of_hash and HashTable.set_hash are instrumented
//		stufe1posttest= runStufe1test(sccs);		printVisualSeparator();

		//compress and all *directly* called methods are instrumented
//		stufe2 = runStufe2(sccs);		printVisualSeparator();
		
		//compress and Compressor.getMaxCode //TODO : test CompBase.getMaxCode
//		stufe3pretest1 = runStufe3pretest1(sccs); 		printVisualSeparator();

		//compress, Compressor.getMaxCode and additionally Compresor.output (which calls Compressor.getMaxCode) 
//		stufe3pretest2 = runStufe3pretest2(sccs); 		printVisualSeparator();

		//compress and its complete non-API calling tree  
		//except HashTable.of_hash, HashTable.set_hash and Compressor.getMaxCode (TODO: test CompBase.getMaxCode )   
//		stufe3pretest3 = runStufe3pretest3(sccs); 		printVisualSeparator();
		
		//compress and its complete non-API calling tree  
		//except "only" Compressor.getMaxCode (TODO: test CompBase.getMaxCode instead)   
//		stufe3pretest4 = runStufe3pretest4(sccs); 		printVisualSeparator();
		
		//compress and its complete non-API calling tree  
		//except "only" Compressor.getMaxCode and Compressor.output   
//		stufe3pretest5 = runStufe3pretest5(sccs); 		printVisualSeparator();
		
		//compress and its complete non-API calling tree is instrumented 
		//(i.e. 3 more methods than in Stufe2)
		stufe3 = this.runStufe3(); 		
		printVisualSeparator();
		CountingResultCollector crCollector = CountingResultCollector.getInstance();
		crCollector.monitorShouldStop();
		
		
		if(stufe1!=null) 			crCollector.logResult(stufe1, false, true);
		if(stufe1posttest!=null) 	crCollector.logResult(stufe1posttest, false, true);
		if(stufe2!=null) 			crCollector.logResult(stufe2, false, true);
		if(stufe3pretest1!=null) 	crCollector.logResult(stufe3pretest1, false, true);
		if(stufe3pretest2!=null) 	crCollector.logResult(stufe3pretest2, false, true);
		if(stufe3pretest3!=null) 	crCollector.logResult(stufe3pretest3, false, true);
		if(stufe3pretest4!=null) 	crCollector.logResult(stufe3pretest4, false, true);
		if(stufe3pretest5!=null) 	crCollector.logResult(stufe3pretest5, false, true);
		if(stufe3pretest6!=null) 	crCollector.logResult(stufe3pretest6, false, true);
		if(stufe3!=null) 			crCollector.logResult(stufe3, false, true);
	}

	private static void printVisualSeparator() {
		System.out.println("============================================");
		System.out.println("============================================");
		System.out.println("============================================");
		System.out.println("============================================");
		System.out.println("============================================");
	}

	/**
	 * Only the compress method is instrumented
	 * @param sccs SPECCompressCountingStarter used
	 * @return the resulting counts
	 */
	private static CountingResult runStufe1(SPECCompressCountingStarter sccs) {
		return sccs.count(
				false, //use inline version
				"Stufe1",
				true,	//use caller
				false,	//useCallee1_CodeTable_of
				false,	//useCallee2_CodeTable_set
				false,	//useCallee3_HashTable_clear
				false,	//useCallee4_HashTable_hsize
				false,	//useCallee5_HashTable_of_hash
				false,	//useCallee6_HashTable_set_hash
				false,	//useCallee7_Compressor_clblock
				false,	//useCallee8_Compressor_output
				false,	//useCallee9_InputBuffer_readByte
				false,	//useCalleeA_Compressor_getMaxCode
				false,	//useCalleeB_OutputBuffer_writeByte
				false	//useCalleeC_OutputBuffer_writeBytes
				);
	}

	/**
	 * Only the compress method plus HashTable.hsize, HashTable.of_hash and HashTable.set_hash are instrumented
	 * @param sccs SPECCompressCountingStarter used
	 * @return the resulting counts
	 */
	private static CountingResult runStufe1test(SPECCompressCountingStarter sccs) {
		return sccs.count(
				false, //use inline version
				"Stufe1",
				true,	//use caller
				false,	//useCallee1_CodeTable_of
				false,	//useCallee2_CodeTable_set
				false,	//useCallee3_HashTable_clear
				true,	//useCallee4_HashTable_hsize
				true,	//useCallee5_HashTable_of_hash
				true,	//useCallee6_HashTable_set_hash
				false,	//useCallee7_Compressor_clblock
				false,	//useCallee8_Compressor_output
				false,	//useCallee9_InputBuffer_readByte
				false,	//useCalleeA_Compressor_getMaxCode
				false,	//useCalleeB_OutputBuffer_writeByte
				false	//useCalleeC_OutputBuffer_writeBytes
				);
	}

	/**
	 * Compress and all directly called methods are instrumented.
	 * @param sccs SPECCompressCountingStarter used
	 * @return the resulting counts
	 */
	private static CountingResult runStufe2(SPECCompressCountingStarter sccs) {
		return sccs.count(
				false, //use inline version
				"Stufe2",
				true,	//use caller (i.e. instrument it)
				true,	//useCallee1_CodeTable_of
				true,	//useCallee2_CodeTable_set
				true,	//useCallee3_HashTable_clear
				true,	//useCallee4_HashTable_hsize
				true,	//useCallee5_HashTable_of_hash
				true,	//useCallee6_HashTable_set_hash
				true,	//useCallee7_Compressor_clblock
				true,	//useCallee8_Compressor_output
				true,	//useCallee9_InputBuffer_readByte
				false,	//useCalleeA_Compressor_getMaxCode //instrumented in Stufe3
				false,	//useCalleeB_OutputBuffer_writeByte //instrumented in Stufe3
				false	//useCalleeC_OutputBuffer_writeBytes //instrumented in Stufe3
				);
	}

	/**
	 * compress and Compressor.getMaxCode //TODO : test CompBase.getMaxCode
	 * @param sccs
	 * @return
	 */
	private static CountingResult runStufe3pretest1(SPECCompressCountingStarter sccs) {
		return sccs.count(
				false, //use inline version
				"Stufe3pretest1",
				true,	//use caller
				false,	//useCallee1_CodeTable_of
				false,	//useCallee2_CodeTable_set
				false,	//useCallee3_HashTable_clear
				false,	//useCallee4_HashTable_hsize
				false,	//useCallee5_HashTable_of_hash
				false,	//useCallee6_HashTable_set_hash
				false,	//useCallee7_Compressor_clblock
				false,	//useCallee8_Compressor_output
				false,	//useCallee9_InputBuffer_readByte
				true,	//useCalleeA_Compressor_getMaxCode
				false,	//useCalleeB_OutputBuffer_writeByte
				false	//useCalleeC_OutputBuffer_writeBytes
				);
	}
	/**compress and Compresor.output (which calls Compressor.getMaxCode) 
	 * @param sccs
	 * @return
	 */
	private static CountingResult runStufe3pretest2(SPECCompressCountingStarter sccs) {
		return sccs.count(
				false, //use inline version
				"Stufe3pretest2",
				true,	//use caller
				false,	//useCallee1_CodeTable_of
				false,	//useCallee2_CodeTable_set
				false,	//useCallee3_HashTable_clear
				false,	//useCallee4_HashTable_hsize
				false,	//useCallee5_HashTable_of_hash
				false,	//useCallee6_HashTable_set_hash
				false,	//useCallee7_Compressor_clblock
				true,	//useCallee8_Compressor_output
				false,	//useCallee9_InputBuffer_readByte
				true,	//useCalleeA_Compressor_getMaxCode
				false,	//useCalleeB_OutputBuffer_writeByte
				false	//useCalleeC_OutputBuffer_writeBytes
				);
	}
	
	/** Compressor.compress and its complete non-API calling tree, except 
	 * HashTable.of_hash, HashTable.set_hash and Compressor.getMaxCode   
	 * @param sccs
	 * @return
	 */
	private static CountingResult runStufe3pretest3(SPECCompressCountingStarter sccs) {
		return sccs.count(
				false, //use inline version
				"Stufe3pretest3",
				true,	//use caller
				true,	//useCallee1_CodeTable_of
				true,	//useCallee2_CodeTable_set
				true,	//useCallee3_HashTable_clear
				true,	//useCallee4_HashTable_hsize
				false,	//useCallee5_HashTable_of_hash
				false,	//useCallee6_HashTable_set_hash
				true,	//useCallee7_Compressor_clblock
				true,	//useCallee8_Compressor_output
				true,	//useCallee9_InputBuffer_readByte
				false,	//useCalleeA_Compressor_getMaxCode
				true,	//useCalleeB_OutputBuffer_writeByte
				true	//useCalleeC_OutputBuffer_writeBytes
				);
	}
	
	/** Compressor.compress and its complete non-API calling tree, 
	 * except "only" Compressor.getMaxCode (which is, however, frequent)   
	 * @param sccs
	 * @return
	 */
	private static CountingResult runStufe3pretest4(SPECCompressCountingStarter sccs) {
		return sccs.count(
				false, //use inline version of SPEC
				"Stufe3pretest4",
				true,	//use caller
				true,	//useCallee1_CodeTable_of
				true,	//useCallee2_CodeTable_set
				true,	//useCallee3_HashTable_clear
				true,	//useCallee4_HashTable_hsize
				true,	//useCallee5_HashTable_of_hash
				true,	//useCallee6_HashTable_set_hash
				true,	//useCallee7_Compressor_clblock
				true,	//useCallee8_Compressor_output
				true,	//useCallee9_InputBuffer_readByte
				false,	//useCalleeA_Compressor_getMaxCode
				true,	//useCalleeB_OutputBuffer_writeByte
				true	//useCalleeC_OutputBuffer_writeBytes
				);
	}
	
	/** Compressor.compress and its complete non-API calling tree, 
	 * except "only" Compressor.getMaxCode and Compressor.output   
	 * @param sccs
	 * @return
	 */
	private static CountingResult runStufe3pretest5(SPECCompressCountingStarter sccs) {
		return sccs.count(
				false, //use inline version of SPEC
				"Stufe3pretest5",
				true,	//use caller
				true,	//useCallee1_CodeTable_of
				true,	//useCallee2_CodeTable_set
				true,	//useCallee3_HashTable_clear
				true,	//useCallee4_HashTable_hsize
				true,	//useCallee5_HashTable_of_hash
				true,	//useCallee6_HashTable_set_hash
				true,	//useCallee7_Compressor_clblock
				false,	//useCallee8_Compressor_output
				true,	//useCallee9_InputBuffer_readByte
				false,	//useCalleeA_Compressor_getMaxCode
				true,	//useCalleeB_OutputBuffer_writeByte
				true	//useCalleeC_OutputBuffer_writeBytes
				);
	}
	
	/**
	 * Compress and its complete non-API calling tree is instrumented 
	 * (i.e. 3 more methods than in Stufe2)
	 * @param sccs SPECCompressCountingStarter used
	 * @return the resulting counts
	 */
	private CountingResult runStufe3() {
		this.t1 = new Thread( new CountingResultCollectorMonitor(2000L) );
		t1.start();
		return this.count(
				false, //use inline version
				"Stufe3",
				true,	//use caller
				true,	//useCallee1_CodeTable_of
				true,	//useCallee2_CodeTable_set
				true,	//useCallee3_HashTable_clear
				true,	//useCallee4_HashTable_hsize
				true,	//useCallee5_HashTable_of_hash
				true,	//useCallee6_HashTable_set_hash
				true,	//useCallee7_Compressor_clblock
				true,	//useCallee8_Compressor_output
				true,	//useCallee9_InputBuffer_readByte
				true,	//useCalleeA_Compressor_getMaxCode
				true,	//useCalleeB_OutputBuffer_writeByte
				true	//useCalleeC_OutputBuffer_writeBytes
				);
	}
	
	/**
	 * Logger instance
	 */
	private Logger log;

	/**
	 * Default constructor
	 */
	public SPECCompressCountingStarter() {
		log = Logger.getLogger(this.getClass().getCanonicalName());
	}

	/**
	 * This method is called after counting is finished to aggregate 
	 * and to evaluate calling trees etc. 
	 * @param suffix
	 * @param crCollector
	 * @param countingResults
	 * @return
	 */
	private CountingResult aggregateEvaluateAndCompareResults(
			String suffix,
			CountingResultCollector crCollector, 
			List<CountingResult> countingResults) {
        // only see how many CountingResults a signature has in "results"
		this.aggregateResultBySignature(countingResults);//TODO add comments
		
		log.debug("CountingResult that is the sum of counts " +
				"reported using _inlined reporting methods: \n"+
				crCollector.getInlined_countingResult());
		
		long timestampToUse = System.nanoTime();
		CountingResult sumOfAllCountingResults = null; //"Type 1"
		CountingResult compressCR_evaluated = null;    //"Type 2"

		if(countingResults.size()==0){
			log.error("Zero counting results!");
		}else{
//6. add up (first approach)
			sumOfAllCountingResults = new CountingResult(
					"allCountingResults", //ID
					"spec.benchmarks.compress.Compressor.compress", //results.get(0).getQualifyingMethodName(),//qualifyingMethodName
					countingResults.get(0).getFileType(), //fileType
					countingResults.get(0).getInputCharacterisation(), //inputCharacterisation
					countingResults.get(0).getOutputCharacterisation(),//outputCharacterisation
					0L, //methodInvocationBeginning
					0L, //methodReportingTime
					new TreeMap<Integer,Long>(), //opcodeCounts
					new TreeMap<String,Long>(), //methodCallCounts
					new long[]{}, //arrayCreationCounts
					new int[]{}, //arrayCreationDimensions
					new String[]{}, //arrayCreationTypeInfo
					new TreeMap<BytecodeSectionDescription, SortedMap<Integer,Long>>(), //sectionInstCounts
					new TreeMap<BytecodeSectionDescription, SortedMap<String,Long>>()); //sectionMethCounts
					
			int currResultIndex = 0;
			CountingResult compressCR = null;
			for(CountingResult r : countingResults) {
				if(r.getQualifyingMethodName().contains("compress")){//TODO document this
					compressCR = r;
				}
				sumOfAllCountingResults.add(r);//TODO
	//			log.debug("after adding CountingResult "+currResultIndex+":");
				currResultIndex++;
			}
			if(compressCR!=null){
				sumOfAllCountingResults.setMethodInvocationBeginning(compressCR.getMethodInvocationBeginning());
				sumOfAllCountingResults.setMethodReportingTime(compressCR.getMethodReportingTime());
			}
			log.info("Addition Type1 \"simply all, before adding the inlined\": "+sumOfAllCountingResults);
			
			sumOfAllCountingResults.add_methodsInstructionsOnly(crCollector.getInlined_countingResult());
			log.info("Addition Type1 \"simply all, after adding the inlined\", final result: "+sumOfAllCountingResults);
			
			String[] splits = Harness.MK_FILES_NAMES[Harness.MK_getFileIndex()].split("/");
			csvrw = new CSVCountingResultWriter(
					true, //append grand total at the end
					';',//entriesSeparationChar
					true,//listInvokeOpcodes
					true,//performIntegrityCheckOnInvokeOpcodes
					"CountingResult.Sum1",//pieceFileNameCore
					splits[splits.length-1]+"."+suffix+".MK.csv",//pieceFileNameExtension
					"MK_results",//pieceFilePath
					true,//writeBooleansAsIntegers
					true,//writeOpcodesAsIntegers
					true,//writeUnusedOpcodes
					true,//truncateUndefinedOpcodes
					false//writeArrayDetailsToSeparateFile
				);
			csvrw.writeResult(
					sumOfAllCountingResults, 
					true, //use previous timestamp 
					timestampToUse //previous timestamp to use
				);
					
			//8. serialise first CountingResult
			FileOutputStream fos=null;
			try{
				String fileName = "MK_Results"+File.separator+
				"CountingResult.Sum1."+
	//			"serialised."+
				timestampToUse+"."+
				splits[splits.length-1]+//input file name
					"."+suffix+
					".MK.SCResult";
				fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(sumOfAllCountingResults);
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(fos!=null){
					try{
						fos.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
//7. try a different addition approach:
			if(compressCR==null){
				log.error("There is no CountingResult for the compress() method !!!");
			}else{
				log.debug("The compress() method DOES have a CountingResult");
				long callerStartTime;
				callerStartTime = compressCR.getMethodInvocationBeginning();
				compressCR_evaluated = crCollector.getCountingResultByStartTime_evaluateCallingTree(callerStartTime, true);
				log.info("Addition Type2 \"within timespan, without inlined\""+compressCR_evaluated);
				
				compressCR_evaluated.add_methodsInstructionsOnly(crCollector.getInlined_countingResult());
				log.info("Addition Type2 \"within timespan, with inlined\", final result: "+compressCR_evaluated);

				if(compressCR_evaluated.shallowEquals(sumOfAllCountingResults)){
					log.info("Aggregated results are equal for both computation ways; not writing CountingResult as second time");
				}else{
					log.error("Aggregated results are different for both computation ways; writing the different CountingResult (as CSV only)");
					
					csvrw = new CSVCountingResultWriter(
							true,
							';',
							true,
							true,
							"CountingResult.Sum2",
							splits[splits.length-1]+"."+suffix+".MK.csv",
							"MK_results",
							true,
							false,
							true,
							true,
							false);
					csvrw.writeResult(compressCR_evaluated, true, timestampToUse);//TODO use the timestamp!
				}
			}
			
	
	//		for(int i = 0; i < results.size(); i++) {
	//			callerStartTime = results.get(i).getMethodInvocationBeginning();
	//			calcResult.add(crc.getCountingResultByStartTime_evaluateCallingTree(callerStartTime));
	//		}
	//		TODO
	//		for(CountingResult c in calcResult) {
	//			if c name is compress log
	//		}
		}
		return sumOfAllCountingResults;
	}

	/**
	 * Does not evaluate the results - only counts how many CountingResults 
	 * a particular signature possesses
	 * @param results
	 * @return
	 */
	private TreeMap<String, Integer> aggregateResultBySignature(final List<CountingResult> results) {
		CountingResult countingResult;
		String signature;
		Integer value;
		TreeMap<String,Integer> classification = new TreeMap<String, Integer>();
		for (Iterator<CountingResult> iterator = results.iterator(); iterator.hasNext();) {
			countingResult = iterator.next();
			signature = countingResult.getQualifyingMethodName();
			value = classification.get(signature);
			if(value==null){//classification.keySet().contains(signature)){
				classification.put(signature, 1);
			}else{
				classification.put(signature, new Integer(value+1));
			}
		}
		log.debug("Counting results by method name (\"classification\"): "+classification.toString());
		return classification;
	}

	/**
	 * TODO add proper documentation
	 * @param useInlinedVersion
	 * @param useCaller
	 * @param useCallee1_CodeTable_of
	 * @param useCallee2_CodeTable_set
	 * @param useCallee3_HashTable_clear
	 * @param useCallee4_HashTable_clear
	 * @param useCallee5
	 * @param useCallee6
	 * @param useCallee7
	 * @param useCallee8
	 * @param useCallee9
	 * @param useCallee0
	 * @return 
	 */
	@SuppressWarnings("deprecation")
	public CountingResult count(
			boolean useInlinedVersion,
			String suffix,		//for naming purposes
			boolean useCaller,  //Compressor.compress
			boolean useCallee1_CodeTable_of, //CodeTable.of
			boolean useCallee2_CodeTable_set, //CodeTable.set
			boolean useCallee3_HashTable_clear, //HashTable.clear
			boolean useCallee4_HashTable_hsize, //HashTable.hsize
			boolean useCallee5_HashTable_of_hash, //HashTable.of_hash
			boolean useCallee6_HashTable_set_hash, //HashTable.set_hash
			boolean useCallee7_Compressor_clblock, //Compressor.clblock
			boolean useCallee8_Compressor_output, //Compressor.output
			boolean useCallee9_InputBuffer_readByte, //InputBuffer.readByte
			boolean useCalleeA_Compressor_getMaxCode,  //
			boolean useCalleeB_OutputBuffer_writeByte,
			boolean useCalleeC_OutputBuffer_writeBytes
			
			) {
		log.debug("Entering SPECCompressStartingCounter.count with file "+
				Harness.MK_FILES_NAMES[Harness.MK_getFileIndex()]+", size "+
				Harness.MK_FILES_SIZES[Harness.MK_getFileIndex()]+"");
		String packageName = "spec.benchmarks.compress";
		if (useInlinedVersion){
			packageName = "spec.benchmarks.compress_inlined";
		}
		
//1. Set up a BytecodeCounter instance to use ByCounter, using a parameterless constructor. 
		BytecodeCounter counter = new BytecodeCounter(); //the only constructor available
		CountingResultCollector.getInstance().clearResults();

//2. Specify the methods to be instrumented //TODO shift into "if"-bodies
		List<MethodDescriptor> methodsToInstrument = new ArrayList<MethodDescriptor>();
		
		prepareMethodsToInstrument(
				useInlinedVersion, 
				useCaller, 
				useCallee1_CodeTable_of,
				useCallee2_CodeTable_set, 
				useCallee3_HashTable_clear, //problematic
				useCallee4_HashTable_hsize, //problematic
				useCallee5_HashTable_of_hash, 
				useCallee6_HashTable_set_hash,
				useCallee7_Compressor_clblock, 
				useCallee8_Compressor_output, 
				useCallee9_InputBuffer_readByte,
				useCalleeA_Compressor_getMaxCode, 
				useCalleeB_OutputBuffer_writeByte,
				useCalleeC_OutputBuffer_writeBytes,
				packageName,
				methodsToInstrument);
	
		InstrumentationParameters ip = new InstrumentationParameters(
				methodsToInstrument, //methods to instrument
				true,  // use high registers for counting
				true,  // use resultCollector
				false, // use array parameter recording
				false, // count statically
				-1,    // start line
				-1,    // stop line
				InstrumentationParameters.COUNTER_PRECISION_LONG);
		counter.setInstrumentationParams(ip);
		
//3. now tell ByCounter to instrument the specified method(s)
		counter.instrument();
		
//4. let ByCounter execute a (not necessarily instrumented) method 
		//note that this class must be reloaded! TODO check TODO explain: reloaded <by whom>?
		MethodDescriptor methodToExecute = new MethodDescriptor(
				packageName+".Main", 
				"public static void main(java.lang.String args[])");
		counter.execute(methodToExecute, new Object[] {new String[]{}});
		
//5. now that ByCounter has completed counting, we can fetch all the results,
		//i.e. get the results list from CountingResultCollector
		CountingResultCollector crc = CountingResultCollector.getInstance();
		List<CountingResult> results = 
			crc.getAllCountingResults_nonRecursively();
		log.info(results.size()+" counting results found in CountingResultCollector");
//		if(results!=null && results.size()>0){//this check should happen further above...
//			CountingResult lastResultInCollection = results.get(results.size()-1);
//			log.debug("Last CountingResult in collection: ");
//			CountingResultCollector.getInstance().logResult(lastResultInCollection);
////			csvrw = new CSVResultWriter(true,';',true,true,"CountingResult_last","MK.csv","MK_results",true,false,true,true,false);
////			csvrw.writeResult(lastResultInCollection);
//		}
		
		System.err.println("START of full CountingResult logging, reinstante \"last results\" logging instead!");
		for(CountingResult r : results){
//			crc.logResult(r, true, true);
			log.debug(r);
		}
		System.err.println("END   of full CountingResult logging, reinstante \"last results\" logging instead!");
		
//6.+7. aggregate and compare total results
		CountingResult sumOfAllCountingResults = aggregateEvaluateAndCompareResults(
				suffix, //TODO 
				crc,    //CountingResultCollector instance
				results //List of CountingResults, not yet aggregated (i.e. not yet evaluated)
		);
		
		log.info("Finished compressing the file "+
				Harness.MK_FILES_NAMES[Harness.MK_getFileIndex()]+"with size "+
				Harness.MK_FILES_SIZES[Harness.MK_getFileIndex()]+"");
		//8. clear the results as we do not need them anymore
		CountingResultCollector.getInstance().clearResults();
		CountingResultCollector.getInstance().resetInlinedCountingResult();
		return sumOfAllCountingResults;
	}

	/**
	 * TODO
	 * @param i
	 * @return
	 */
	public String getFileNameByIndex_fromSPECharness(int i){
		if(i<0 || i>=spec.benchmarks.compress.Harness.MK_FILES_NAMES.length){
			log.error("File index "+i+" out of bounds");
			return null;
		}else{
			return spec.benchmarks.compress.Harness.MK_FILES_NAMES[i];
		}
	}
	
//	/**
//	 * Get index of the file to compress.
//	 * @return index of the file to compress
//	 */
//	public int getFileIndex() {
//		return fileIndexForCompression;
//	}

	/**
	 * TODO
	 */
	@SuppressWarnings("unused")
	private void measureCompress() {
		int nrOfMeasurements = DEFAULT_NUMBER_OF_MEASUREMENTS;
//		boolean groupByInputs = false;
		File f = new File(".");
		log.info("Absolute path: "+f.getAbsolutePath());
		String filePath;
		long[] fileSizes = new long[spec.benchmarks.compress.Harness.MK_FILES_NAMES.length];
		long[][] measurements = new long[spec.benchmarks.compress.Harness.MK_FILES_NAMES.length][nrOfMeasurements];
		long[][] measurementsSummary = new long[spec.benchmarks.compress.Harness.MK_FILES_NUMBER][3]; 
		double[] timePerInputByte = new double[spec.benchmarks.compress.Harness.MK_FILES_NUMBER];

		//1. compute and output file sizes
		for(int i=0; i<spec.benchmarks.compress.Harness.MK_FILES_NUMBER; i++){
			filePath = /*"."+File.separatorChar+".."+File.separatorChar+"SPECjvm2008_1.00"+File.separatorChar+*/
				spec.benchmarks.compress.Harness.MK_FILES_NAMES[i];
			f = new File(filePath);
			fileSizes[i] = f.length();
			log.debug(filePath+": "+fileSizes[i]);
		}
		
		long start = 0L;
		long finish = 0L;
//		if(groupByInputs){
			int k=0;
			int l=0;
			for(;k<spec.benchmarks.compress.Harness.MK_FILES_NUMBER;k++){
//				System.out.print(/*"."+File.separatorChar+".."+
//						File.separatorChar+"SPECjvm2008_1.00"+
//						File.separatorChar+*/Harness.FILES_NAMES[k]+": ");
				l=0;
				for(;l<nrOfMeasurements;l++){
					start = System.nanoTime();
					try {
						spec.benchmarks.compress.Harness.MK_setFileIndex(k);
						spec.benchmarks.compress.Main.main(new String[]{});
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					finish = System.nanoTime();
					measurements[k][l] = finish-start;
//					System.out.print(measurements[k][l]+" ");
				}
//				System.out.println("");
			}
//		}
		k=0;
		l=0;
		for(;k<spec.benchmarks.compress.Harness.MK_FILES_NUMBER;k++){
			System.out.print(spec.benchmarks.compress.Harness.MK_FILES_NAMES[k]+": ");
			l=0;
			for(;l<nrOfMeasurements;l++){
				System.out.print(measurements[k][l]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		
		int i=0;
		for(; i<measurements.length; i++){
			Arrays.sort(measurements[i]);
			measurementsSummary[i][0] = measurements[i][0]; //min
			measurementsSummary[i][1] = measurements[i][measurements[i].length/2]; //median
			measurementsSummary[i][2] = measurements[i][measurements[i].length-1]; //max
			log.info("Summary for file "+i+": "+"" +
					  "min="+measurementsSummary[i][0]+" ns"+
					", med="+measurementsSummary[i][1]+" ns"+
					", max="+measurementsSummary[i][2]+" ns");
		}
		
		log.info(" median ns per byte ===========");	
		i=0;
		for(; i<measurements.length; i++){
			timePerInputByte[i] = ((double) measurementsSummary[i][1])/((double) fileSizes[i]);
			log.info("Summary for file "+i+": "+"" +
					timePerInputByte[i]+" ns per byte");//TODO CSV writer
		}
			
//		putIntoCSVFile("SPECcompressSummary."+System.nanoTime()+".csv",
//				Harness.FILES_NAMES,
//				fileSizes,
//				measurementsSummary,
//				timePerInputByte);
	}
	
	/**
	 * Method that performs tedious ByCounter conversion and preparation work
	 * @param useInlinedVersion
	 * @param useCaller Compressor.compress
	 * @param useCallee1 CodeTable.of
	 * @param useCallee2 CodeTable.set
	 * @param useCallee3 HashTable.clear
	 * @param useCallee4 HashTable.hsize
	 * @param useCallee5 HashTable.of_hash
	 * @param useCallee6 HashTable.set_hash
	 * @param useCallee7 Compressor.clblock
	 * @param useCallee8 Compressor.output
	 * @param useCallee9 InputBuffer.readByte
	 * @param useCalleeA Compressor.getMaxCode
	 * @param useCalleeB OutputBuffer.writeByte
	 * @param useCalleeC OutputBuffer.writeBytes
	 * @param packageName
	 * @param methodsToInstrument list of MethodDescriptors into which the result of preparation is saved
	 */
	private void prepareMethodsToInstrument(
			boolean useInlinedVersion,
			boolean useCaller,  // Compressor.compress
			boolean useCallee1, // CodeTable.of
			boolean useCallee2, // CodeTable.set
			boolean useCallee3, // HashTable.clear
			boolean useCallee4, // HashTable.hsize
			boolean useCallee5, // HashTable.of_hash
			boolean useCallee6, // HashTable.set_hash
			boolean useCallee7, // Compressor.clblock
			boolean useCallee8, // Compressor.output
			boolean useCallee9, // InputBuffer.readByte
			boolean useCalleeA, // Compressor.getMaxCode
			boolean useCalleeB, // OutputBuffer.writeByte
			boolean useCalleeC, // OutputBuffer.writeBytes
			String packageName,
			List<MethodDescriptor> methodsToInstrument
		) {
		MethodDescriptor caller = new MethodDescriptor(
				packageName+".Compressor", //Compressor is not an inner class! thus, do not try Compress$Compressor!
				"public void compress()",
				MethodDescriptor.IS_VARIANT,
				MethodDescriptor.IS_COUNTED_SEPARATELY
				); 
		caller.setContext(new UUID(System.currentTimeMillis(),System.currentTimeMillis()));
		
		MethodDescriptor callee1 = new MethodDescriptor(
				packageName+".CodeTable", 
				"public int of(int i)",
				MethodDescriptor.IS_INVARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		callee1.setContext(caller.getContext());
		
		MethodDescriptor callee2 = new MethodDescriptor(
				packageName+".CodeTable", 
				"public void set(int i, int v)",
				MethodDescriptor.IS_INVARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		callee2.setContext(caller.getContext());
		
		MethodDescriptor callee3;
		if(useInlinedVersion){
			callee3 = new MethodDescriptor(
				packageName+".HashTable", 
				"public void clear()",
				MethodDescriptor.IS_INVARIANT,//"size" always 69001... 
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		}else{
			callee3 = new MethodDescriptor(
				packageName+".Compressor$HashTable", 
				"public void clear()",
				MethodDescriptor.IS_INVARIANT,//"size" always 69001...
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		}
		callee3.setContext(caller.getContext());

		MethodDescriptor callee4;
		if(useInlinedVersion){
			callee4 = new MethodDescriptor(
				packageName+".HashTable", 
				"public int hsize()",
				MethodDescriptor.IS_INVARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		}else{
			callee4 = new MethodDescriptor(
				packageName+".Compressor$HashTable", 
				"public int hsize()",
				MethodDescriptor.IS_INVARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		}
		callee4.setContext(caller.getContext());
		
		MethodDescriptor callee5;
		if(useInlinedVersion){
			log.error("Inlined version of callee6 still with a problematic method name of");
			callee5 = new MethodDescriptor(
				packageName+".HashTable", 
				"public int of(int i)",
				MethodDescriptor.IS_INVARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		}else{
			callee5 = new MethodDescriptor(
				packageName+".Compressor$HashTable", 
				"public int of_hash(int i)",
				MethodDescriptor.IS_INVARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		}
		callee5.setContext(caller.getContext());
		
		MethodDescriptor callee6;
		if(useInlinedVersion){
			log.error("Inlined version of callee6 still with a problematic method name set");
			callee6 = new MethodDescriptor(
				packageName+".HashTable", 
				"public void set(int i, int v)",
				MethodDescriptor.IS_INVARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		}else{
			callee6 = new MethodDescriptor(
				packageName+".Compressor$HashTable", 
				"public void set_hash(int i, int v)",
				MethodDescriptor.IS_INVARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		}
		callee6.setContext(caller.getContext());
		
		MethodDescriptor callee7 = new MethodDescriptor(
				packageName+".Compressor", 
				"public void clBlock()",
				MethodDescriptor.IS_VARIANT,
				MethodDescriptor.IS_COUNTED_SEPARATELY
				); //I had an error here
		callee7.setContext(caller.getContext());
		
		System.err.println("Callee 8 (Compressor.output) not inlined - may be a scalability issue (see prepareMethodsToInstrument)");
		MethodDescriptor callee8 = new MethodDescriptor(
				packageName+".Compressor", 
				"public void output(int code)",
				MethodDescriptor.IS_VARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		callee8.setContext(caller.getContext());
		
		System.err.println("Callee 9 (InputBuffer.readByte) not inlined - may be a scalability issue (see prepareMethodsToInstrument)");
		MethodDescriptor callee9 = new MethodDescriptor(
				packageName+".InputBuffer",
				"public int readByte()",
				MethodDescriptor.IS_VARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		callee9.setContext(caller.getContext());
				
		//called from Compressor.output, implemented in Compressor's superclass (CompBase)
		//does not call other methods
		log.warn("For instrumenting getMaxCode: replaced Compressor with CompBase, but only in prepareMethodsToInstrument");
		MethodDescriptor calleeA = new MethodDescriptor(
				packageName+".CompBase",
				"public int getMaxCode()",//TODO inherited but not overwritten method!!!
				MethodDescriptor.IS_INVARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		calleeA.setContext(caller.getContext());
				
		//called from Compressor.output
		//does not call other methods
		MethodDescriptor calleeB = new MethodDescriptor(
				packageName+".OutputBuffer",
				"public void writeByte(byte c)",
				MethodDescriptor.IS_INVARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		calleeB.setContext(caller.getContext());
				
		//called from Compressor.output
		//does not call other methods
		MethodDescriptor calleeC = new MethodDescriptor(
				packageName+".OutputBuffer",
				"public void writebytes(byte[] buf, int n)",
				MethodDescriptor.IS_VARIANT,
				MethodDescriptor.IS_IMMEDIATELY_INLINED
				);
		calleeC.setContext(caller.getContext());
				
		if(useCaller){
			methodsToInstrument.add(caller);
		}
		if(useCallee1){
			methodsToInstrument.add(callee1);
		}
		if(useCallee2){
			methodsToInstrument.add(callee2);
		}
		if(useCallee3){
			methodsToInstrument.add(callee3);
		}
		if(useCallee4){
			methodsToInstrument.add(callee4);
		}
		if(useCallee5){
			methodsToInstrument.add(callee5);
		}
		if(useCallee6){
			methodsToInstrument.add(callee6);
		}
		if(useCallee7){
			methodsToInstrument.add(callee7);
		}
		if(useCallee8){
			methodsToInstrument.add(callee8);
		}
		if(useCallee9){
			methodsToInstrument.add(callee9);
		}
		if(useCalleeA){
			methodsToInstrument.add(calleeA);
		}
		if(useCalleeB){
			methodsToInstrument.add(calleeB);
		}
		if(useCalleeC){
			methodsToInstrument.add(calleeC);
		}
	}

	/**
	 * @param pathForCSVFile
	 * @param filesNames
	 * @param fileSizes
	 * @param measurementsSummary
	 * @param timePerInputByte
	 * @deprecated because untested
	 */
	private void putIntoCSVFile(String pathForCSVFile,
			String[] filesNames, 
			long[] fileSizes,
			long[][] measurementsSummary, 
			double[] timePerInputByte) {
		StringBuffer sb = new StringBuffer();
		sb.append("filename;filesize;medianduration;timeperinputbyte\n");
		for(int i=0; i<filesNames.length; i++){
			sb.append(filesNames[i]+";"+
					fileSizes[i]+";"+
					measurementsSummary[i][1]+";"+
					timePerInputByte[i]+"\n");
		}
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(pathForCSVFile);
			fos.write(sb.toString().getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if(fos!=null) fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
//	private void run(int mainSwitchFlag) {
//		boolean callerFirst = false;
//		
//		if(mainSwitchFlag==INSTRUMENT_ONLY_COMPRESS){
//			this.count(useInlinedVersion, useCaller, useCallee1, useCallee2, useCallee3, useCallee4, useCallee5, useCallee6, useCallee7, useCallee8, useCallee9, useCallee0)
//			this.countOnlyCompress_WithDefaults(); //TODO switch back from forced Harness reading of fileIndex... fix instrumentation problem
//		}else if(mainSwitchFlag==INSTRUMENT_ONLY_OUTPUT){
//			this.countOnlyOutput_WithDefaults(); //TODO switch back from forced Harness reading of fileIndex... fix instrumentation problem
//		}else if(mainSwitchFlag==INSTRUMENT_ONLY_COMPRESS_AND_OUTPUT){
//			this.countOnlyCompressAndOutput_WithDefaults(callerFirst); //TODO switch back from forced Harness reading of fileIndex... fix instrumentation problem
//		}else if(mainSwitchFlag==INSTRUMENT_ALL){
//			this.countAll_WithDefaults();
//		}else if(mainSwitchFlag==INSTRUMENT_ALL_INLINED){
//			this.countAll_inlined_WithDefaults();
//		}else if(mainSwitchFlag==INSTRUMENT_ONLY_COMPRESS_AND_CLEAR){//only "clear"-Method
//		}else if(mainSwitchFlag==INSTRUMENT_ONLY_COMPRESS_AND_CLEAR_INLINED){//only "clear"-Method
//			this.count(
//					true,  //use inlined version
//					true,  //caller
//					false, //callee 1
//					false, //etc.
//					true,
//					false,
//					false,
//					false,
//					false,
//					false,
//					false,
//					false);
//		}else{
//			log.error("Switch flag in SPECCompressCountingStarter is NONSENSE!");	
//		}
//		this.count(
//				false,  //use inlined version
//				true,  //caller
//				false, //callee 1
//				false, //etc.
//				true,
//				false,
//				false,
//				false,
//				false,
//				false,
//				false,
//				false);
//	}
	
//	/**
//	 * Set file index for compression
//	 * @param index of file to compress
//	 */
//	public void setFileIndex(int index) {
//		fileIndexForCompression = index;
//	}

//	/**
//	 * TODO
//	 */
//	private void countAll_inlined_WithDefaults(){
//		count_WithDefaults(
//				true, 
//				true,
//				true,
//				true,
//				true,
//				true,
//				true,
//				true,
//				true,
//				true,
//				true,
//				true); 
//		//TODO switch back from forced Harness reading of fileIndex... fix instrumentation problem
//	}
//	
//	/**
//	 * TODO
//	 */
//	private void countAll_WithDefaults(){
//		count_WithDefaults(
//				false,
//				true,
//				true,
//				true,
//				true,
//				true,
//				true,
//				true,
//				true,
//				true,
//				true,
//				true); 
//		//TODO switch back from forced Harness reading of fileIndex... fix instrumentation problem
//	}
//	
//	/**
//	 * Quickstart example of the most basic ByCounter usage.
//	 * @deprecated because parameterised method should be used instead
//	 */
//	private void countOnlyCompress_WithDefaults(/*int fileIndex*/) {
////		if(fileIndex<0 || fileIndex>=Harness.FILES_NAMES.length){
////			System.out.println("ERROR: file index out of bounds");
////			return;
////		}else{
//////			fileIndexForCompression = fileIndex; //TODO Martin
//////			Harness.setFileIndex(fileIndexForCompression);//TODO Martin
////			System.out.println(">>>MK OK: file index is "+fileIndexForCompression+", set to Harness");
//			fileIndexForCompression = spec.benchmarks.compress.Harness.getFileIndex();
//			System.out.println(">>>MK file index in Harness "+spec.benchmarks.compress.Harness.getFileIndex());
////			
////		}
//			
//		//1. Set up a BytecodeCounter instance to use ByCounter, using a parameterless constructor. 
//		BytecodeCounter counter = new BytecodeCounter(); //the only constructor available
//		System.out.println(">>>@1 MK file index in Harness "+spec.benchmarks.compress.Harness.getFileIndex());
//		
//
//		//2. Specify the methods to be instrumented
//		List<MethodDescriptor> methodsToInstrument = new ArrayList<MethodDescriptor>();
//		methodsToInstrument.add(new MethodDescriptor(
//				"spec.benchmarks.compress.Compressor", //Compressor is not an inner class! thus, do not try Compress$Compressor!
//				"public void compress()"));
//		System.out.println(">>>@2 MK file index in Harness "+spec.benchmarks.compress.Harness.getFileIndex());
//
////		TODO some problems with the following addition! --> Martin Email
////		methodsToInstrument.add(new MethodDescriptor(
////				"spec.benchmarks.compress.Compressor", //Compressor is not an inner class! thus, do not try Compress$Compressor!
////				"public void output(int a)")); //TODO it is important to have "(int a)", not just "(int): TODO programm in a more tolerant way!
//
//		InstrumentationParameters ip = new InstrumentationParameters(
//				methodsToInstrument, //methods to instrument
//				true,  // use high registers for counting
//				true,  // use resultCollector
//				false, // use array parameter recording
//				false, // count statically
//				-1,    // start line
//				-1,    // stop line
//				InstrumentationParameters.COUNTER_PRECISION_LONG);
//		counter.setInstrumentationParams(ip);
//		System.out.println(">>>@3 MK file index in Harness "+spec.benchmarks.compress.Harness.getFileIndex());
//		
//		//3. now tell ByCounter to instrument the specified method
//		counter.instrument();
//		System.out.println(">>>@4 MK file index in Harness "+spec.benchmarks.compress.Harness.getFileIndex());
//		
//		//4. let ByCounter execute the method (note that this class must be reloaded! TODO check)
//		MethodDescriptor methodToExecute = new MethodDescriptor(
//				"spec.benchmarks.compress.Main", //Compressor is not an inner class! thus, do not try Compress$Compressor!
//				"public static void main(java.lang.String args[])");
//		
//		counter.execute(methodToExecute, new Object[] {new String[]{}});
//		System.out.println(">>>@5 MK file index in Harness "+spec.benchmarks.compress.Harness.getFileIndex());
//		
//		//5. now that ByCounter has completed counting, we can fetch the results,
//		//i.e. get the results list from CountingResultCollector
//		List<CountingResult> results = 
//			CountingResultCollector.getInstance().getAllCountingResults_nonRecursively();
//		System.out.println(results.size()+" results found in CountingResultCollector");
//		
//		//6. output the results to the console/log and serialise them
//		OpcodeFrequencySorter ofs = new OpcodeFrequencySorter();
//		for(CountingResult r : results) {
//			r.setFileType(spec.benchmarks.compress.Harness.getLastInputType()); //TODO document this
//			r.setInputCharacterisation(spec.benchmarks.compress.Harness.getLastInputSize());
//			r.setOutputCharacterisation(spec.benchmarks.compress.Harness.getLastOutputSize());
////			System.out.println("InputCharacterisation: "+r.getInputCharacterisation());
////			System.out.println("OutputCharacterisation: "+r.getOutputCharacterisation());
//
//			//6a. log
//			CountingResultCollector.getInstance().logResult(r);
//			
//			String[] fileNameTokens = spec.benchmarks.compress.Harness.FILES_NAMES[spec.benchmarks.compress.Harness.getFileIndex()].split("/");
//			String pureFileName = fileNameTokens[fileNameTokens.length-1];
//			
//			//6b. find and CSVwrite the most frequent ("the most frequent" what ?)
//			
//			boolean includeInvokeOpcodes=true;
//			SortedSet<SortableFrequency> sortedResults = null;
//			try {
//				System.out.println(">>> "+r.getOpcodeCounts().keySet().size()+
//						" input opcodes counts for " +
//						"getMostFrequentOpcodesInOneDataset_Integer");
//				sortedResults = ofs.getMostFrequentOpcodesInOneDataset_Integer(
//						OpcodeFrequencySorter.RELATIVE_LOCAL_FREQUENCY, 
//						r.getOpcodeCounts(), 
//						r.getTotalOpcodeCount(includeInvokeOpcodes));
//				System.out.println(">>> "+sortedResults.size()+
//						" output frequencies from " +
//						"getMostFrequentOpcodesInOneDataset_Integer");
////				String sortedFrequenciesFileName;
////				sortedFrequenciesFileName = 
////					pureFileName+
////					"."+System.nanoTime()+
////					".sortedFrequencies.CSV";
////				ofs.serialiseSortedFrequenciesToCSV(
////						sortedResults,
////						sortedFrequenciesFileName);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			
////			//6c. serialise CountingResult
////			FileOutputStream fos=null;
////			try{
////				String fileName = r.getQualifyingMethodName()+"."+
////				r.getMethodInvocationBeginning()+"."+
////				r.getMethodReportingTime()+"_"+
////				pureFileName+"_.SCResult";
////				fos = new FileOutputStream(fileName);
////				ObjectOutputStream oos = new ObjectOutputStream(fos);
////				CountingResult resultToSerialise = (CountingResult) r.clone();
////				resultToSerialise.setID(pureFileName);
////				oos.writeObject(resultToSerialise);
////			}catch (Exception e) {
////				e.printStackTrace();
////			}finally{
////				if(fos!=null){
////					try{
////						fos.close();
////					}catch (Exception e) {
////						e.printStackTrace();
////					}
////				}
////			}
//		}
//		
////		//7. write an unsorted, all-counts CSV file for a single result
////		CSVResultWriter crw = new CSVResultWriter(
////				true,
////				';',
////				true, //list invoke opcodes
////				true, //perform consistency check on invoke opcodes
////				getFileNameByIndex(fileIndexForCompression),
////				"csv",
////				".",
////				false,  //write booleans as integers
////				false,  //write opcodes as integers
////				true,   //write unused opcodes
////				false,  //truncate undefined opcodes
////				false); //write array details to separate file
////		if(results.size()>0){
////			crw.writeResult(results.get(0));//TODO document the fixed results index!
////		}else{
////			System.err.println("No counting result found!");
////		}
//		
//		//8. clear the results as we do not need them anymore
//		CountingResultCollector.getInstance().clearResults();
//	}
//	
//	/**
//	 * @param callerFirst
//	 * @deprecated because parameterised method should be used instead
//	 */
//	private void countOnlyCompressAndOutput_WithDefaults(boolean callerFirst) {
//		//1. Set up a BytecodeCounter instance to use ByCounter, using a parameterless constructor. 
//		BytecodeCounter counter = new BytecodeCounter(); //the only constructor available
//
//		//2. Specify the methods to be instrumented
//		List<MethodDescriptor> methodsToInstrument = new ArrayList<MethodDescriptor>();
//		MethodDescriptor callee = new MethodDescriptor(
//				"spec.benchmarks.compress.Compressor", //Compressor is not an inner class! thus, do not try Compress$Compressor!
//				"public void output(int code)");
//		MethodDescriptor caller = new MethodDescriptor(
//				"spec.benchmarks.compress.Compressor", //Compressor is not an inner class! thus, do not try Compress$Compressor!
//				"public void compress()"); 
//		if(callerFirst){
//			methodsToInstrument.add(caller);
//			methodsToInstrument.add(callee);
//		}else{
//			methodsToInstrument.add(callee);
//			methodsToInstrument.add(caller);
//		}
//
//		InstrumentationParameters ip = new InstrumentationParameters(
//				methodsToInstrument, //methods to instrument
//				true,  // use high registers for counting
//				true,  // use resultCollector
//				false, // use array parameter recording
//				false, // count statically
//				-1,    // start line
//				-1,    // stop line
//				InstrumentationParameters.COUNTER_PRECISION_LONG);
//		counter.setInstrumentationParams(ip);
//		
//		//3. now tell ByCounter to instrument the specified method
//		counter.instrument();
//		
//		//4. let ByCounter execute (not necessarily identical) method 
//		//note that this class must be reloaded! TODO check TODO explaine reloaded <by whom>
//		MethodDescriptor methodToExecute = new MethodDescriptor(
//				"spec.benchmarks.compress.Main", //Compressor is not an inner class! thus, do not try Compress$Compressor!
//				"public static void main(java.lang.String args[])");
//		
//		counter.execute(methodToExecute, new Object[] {new String[]{}});
//		
//		//5. now that ByCounter has completed counting, we can fetch all the results,
//		//i.e. get the results list from CountingResultCollector
//		List<CountingResult> results = 
//			CountingResultCollector.getInstance().getAllCountingResults_nonRecursively();
//		System.out.println("\n============================================\n"+
//				results.size()+" results found in CountingResultCollector\n"+
//				"============================================\n");
//		
//		//6. output the results to the console/log and serialise them
//		
//		CountingResult sumOfAllCountingResults = new CountingResult(
//				"allCountingResults",
//				results.get(0).getQualifyingMethodName(),
//				results.get(0).getFileType(),
//				results.get(0).getInputCharacterisation(),
//				results.get(0).getOutputCharacterisation(),
//				-1L,
//				-1L,
//				new HashMap<Integer,Long>(),
//				new HashMap<String,Long>(),
//				new long[]{},
//				new int[]{},
//				new String[]{},
//				new TreeMap<BytecodeSectionDescription, SortedMap<Integer,Long>>(),
//				new TreeMap<BytecodeSectionDescription, SortedMap<String,Long>>());
//				
//		int currResultIndex = 0;
//		for(CountingResult r : results) {
//			//6a. log (here: partially)
//			System.out.println("ILOAD: "+r.getOpcodeCount("ILOAD"));
//			
//			//6b. TODO add the counting result to the above 
//			sumOfAllCountingResults.add(r);
//			System.out.println("\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n" +
//					"after adding CountingResult "+currResultIndex+":\n");
//			System.out.println("ILOAD: "+sumOfAllCountingResults.getOpcodeCount("ILOAD"));
//			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
//
//			currResultIndex++;
//		}
//		System.out.println("\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n" +
//				"\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n" +
//				"FINAL RESULT:\n");
//		System.out.println("ILOAD: "+sumOfAllCountingResults.getOpcodeCount("ILOAD"));
//		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
//				
//		//7. clear the results as we do not need them anymore
//		CountingResultCollector.getInstance().clearResults();
//	}
//	
//	/**
//	 * Quickstart example of the most basic ByCounter usage.
//	 * @deprecated because parameterised method should be used instead
//	 */
//	@SuppressWarnings("deprecation")
//	private void countOnlyOutput_WithDefaults() {
////		fileIndexForCompression = Harness.getFileIndex();
////		System.out.println(">>>MK file index in Harness "+Harness.getFileIndex());
//			
//		//1. Set up a BytecodeCounter instance to use ByCounter, using a parameterless constructor. 
//		BytecodeCounter counter = new BytecodeCounter(); //the only constructor available
//
//		//2. Specify the methods to be instrumented
//		List<MethodDescriptor> methodsToInstrument = new ArrayList<MethodDescriptor>();
//		methodsToInstrument.add(new MethodDescriptor(
//				"spec.benchmarks.compress.Compressor", //Compressor is not an inner class! thus, do not try Compress$Compressor!
//				"public void output(int code)"));
//
//		InstrumentationParameters ip = new InstrumentationParameters(
//				methodsToInstrument, //methods to instrument
//				true,  // use high registers for counting
//				true,  // use resultCollector
//				false, // use array parameter recording
//				false, // count statically
//				-1,    // start line
//				-1,    // stop line
//				InstrumentationParameters.COUNTER_PRECISION_LONG);
//		counter.setInstrumentationParams(ip);
//		
//		//3. now tell ByCounter to instrument the specified method
//		counter.instrument();
//		
//		//4. let ByCounter execute (not necessarily identical) method 
//		//note that this class must be reloaded! TODO check TODO explaine reloaded <by whom>
//		MethodDescriptor methodToExecute = new MethodDescriptor(
//				"spec.benchmarks.compress.Main", //Compressor is not an inner class! thus, do not try Compress$Compressor!
//				"public static void main(java.lang.String args[])");
//		
//		counter.execute(methodToExecute, new Object[] {new String[]{}});
//		
//		//5. now that ByCounter has completed counting, we can fetch all the results,
//		//i.e. get the results list from CountingResultCollector
//		List<CountingResult> results = 
//			CountingResultCollector.getInstance().getAllCountingResults_nonRecursively();
//		System.out.println("\n============================================\n"+
//				results.size()+" results found in CountingResultCollector\n"+
//				"============================================\n");
//		
//		//6. output the results to the console/log and serialise them
//		
////prepare a CountingResult where the per-opcode total sums are created by adding up incrementally
////		String ID,
////		String qualifyingMethodName, 
////		int fileType,
////		long inputCharacterisation,
////		long outputCharacterisation,
////		long methodInvocationBeginning, 
////		long methodReportingTime, 
////		HashMap<Integer, Long> opcodeCounts, 
////		HashMap<String, Long> methodCallCounts,
////		long[] arrayCreationCounts,
////		int[] arrayCreationDimensions,
////		String[] arrayCreationTypeInfo,
////		SortedMap<BytecodeSectionDescription,SortedMap<Integer,Long>> sectionInstCounts,
////		SortedMap<BytecodeSectionDescription,SortedMap<String,Long>> sectionMethCounts		
//		CountingResult sumOfAllCountingResults = new CountingResult(
//				"allCountingResults",
//				results.get(0).getQualifyingMethodName(),
//				results.get(0).getFileType(),
//				
//				results.get(0).getInputCharacterisation(),
//				results.get(0).getOutputCharacterisation(),
//				-1L,
//				-1L,
//				new HashMap<Integer,Long>(),
//				new HashMap<String,Long>(),
//				new long[]{},
//				new int[]{},
//				new String[]{},
//				new TreeMap<BytecodeSectionDescription, SortedMap<Integer,Long>>(),
//				new TreeMap<BytecodeSectionDescription, SortedMap<String,Long>>());
//				
////		OpcodeFrequencySorter ofs = new OpcodeFrequencySorter();
//		int currResultIndex = 0;
//		for(CountingResult r : results) {
//			//6a. log (here: partially)
////			CountingResultCollector.getInstance().logResult(r);
//			System.out.println("ILOAD: "+r.getOpcodeCount("ILOAD"));
//			
//			//6b. TODO add the counting result to the above 
//			sumOfAllCountingResults.add(r);
//			System.out.println("\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n" +
//					"after adding CountingResult "+currResultIndex+":\n");
////			CountingResultCollector.getInstance().logResult(sumOfAllCountingResults);
//			System.out.println("ILOAD: "+sumOfAllCountingResults.getOpcodeCount("ILOAD"));
//			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
//			
//			
////			r.setFileType(Harness.getLastInputType()); //TODO document this
////			r.setInputCharacterisation(Harness.getLastInputSize());
////			r.setOutputCharacterisation(Harness.getLastOutputSize());
////			System.out.println("Input size: "+r.getInputCharacterisation());
////			System.out.println("Output size: "+r.getOutputCharacterisation());
//
////			//6c. find and CSVwrite the opcodes by the frequency of their counts
////			String[] fileNameTokens = Harness.FILES_NAMES[Harness.getFileIndex()].split("/");
////			String pureFileName = fileNameTokens[fileNameTokens.length-1];
////			
////			
////			boolean includeInvokeOpcodes=true;
////			SortedSet<SortableFrequency> sortedResults = null;
////			try {
////				System.out.println(">>> "+r.getOpcodeCounts().keySet().size()+
////						" input opcodes counts for " +
////						"getMostFrequentOpcodesInOneDataset_Integer");
////				sortedResults = ofs.getMostFrequentOpcodesInOneDataset_Integer(
////						OpcodeFrequencySorter.RELATIVE_LOCAL_FREQUENCY, 
////						r.getOpcodeCounts(), 
////						r.getTotalOpcodeCount(includeInvokeOpcodes));
////				System.out.println(">>> "+sortedResults.size()+
////						" output frequencies from " +
////						"getMostFrequentOpcodesInOneDataset_Integer");
////				String sortedFrequenciesFileName;
////				sortedFrequenciesFileName = 
////					pureFileName+
////					"."+System.nanoTime()+
////					".sortedFrequencies.CSV";
////				ofs.serialiseSortedFrequenciesToCSV(
////						sortedResults,
////						sortedFrequenciesFileName);
////			} catch (Exception e1) {
////				e1.printStackTrace();
////			}
////			
////			//6d. serialise CountingResult
////			FileOutputStream fos=null;
////			try{
////				String fileName = r.getQualifyingMethodName()+"."+
////				r.getMethodInvocationBeginning()+"."+
////				r.getMethodReportingTime()+"_"+
////				pureFileName+"_.SCResult";
////				fos = new FileOutputStream(fileName);
////				ObjectOutputStream oos = new ObjectOutputStream(fos);
////				CountingResult resultToSerialise = (CountingResult) r.clone();
////				resultToSerialise.setID(pureFileName);
////				oos.writeObject(resultToSerialise);
////			}catch (Exception e) {
////				e.printStackTrace();
////			}finally{
////				if(fos!=null){
////					try{
////						fos.close();
////					}catch (Exception e) {
////						e.printStackTrace();
////					}
////				}
////			}
//			currResultIndex++;
//		}//end of iterating over "CountingResult"s currently available in CountingResultCollector
//		
////		//7. write an unsorted, *all-counts* CSV file for a single result
////		CSVResultWriter crw = new CSVResultWriter(
////				true,
////				';',
////				true, //list invoke opcodes
////				true, //perform consistency check on invoke opcodes
////				getFileNameByIndex(fileIndexForCompression),
////				"csv",
////				".",
////				false,  //write booleans as integers
////				false,  //write opcodes as integers
////				true,   //write unused opcodes
////				false,  //truncate undefined opcodes
////				false); //write array details to separate file
////		if(results.size()>0){
////			crw.writeResult(results.get(0));//TODO document the fixed results index!
////		}else{
////			System.err.println("No counting result found!");
////		}
//		
//		//8. clear the results as we do not need them anymore
//		CountingResultCollector.getInstance().clearResults();
//	}
//	
}
//public static final int INSTRUMENT_ALL = -1;
//
//	public static final int INSTRUMENT_ALL_INLINED = 0;
//
//	public static final int INSTRUMENT_ONLY_COMPRESS = 1;
//	
//	public static final int INSTRUMENT_ONLY_COMPRESS_AND_CLEAR = 2;
//	
//	public static final int INSTRUMENT_ONLY_COMPRESS_AND_CLEAR_INLINED = 3;
//	
//	public static final int INSTRUMENT_ONLY_COMPRESS_AND_OUTPUT = 4;
//	
//	public static final int INSTRUMENT_ONLY_OUTPUT = 5;
	
