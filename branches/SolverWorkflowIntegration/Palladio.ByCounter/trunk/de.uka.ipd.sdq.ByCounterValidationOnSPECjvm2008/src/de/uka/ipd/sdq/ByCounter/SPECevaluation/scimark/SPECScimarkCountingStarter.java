package de.uka.ipd.sdq.ByCounter.SPECevaluation.scimark;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import de.uka.ipd.sdq.ByCounter.execution.BytecodeCounter;
import de.uka.ipd.sdq.ByCounter.execution.BytecodeSectionDescription;
import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;
import de.uka.ipd.sdq.ByCounter.instrumentation.InstrumentationParameters;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * @author Michael
 * TODO add documentation, proper logging, ...
 * TODO replace string-based class names with XXX.getClassname or similar
 */
public class SPECScimarkCountingStarter {
	public final static String FFT_CALLER = "public static void main(java.lang.String args[])";
	public final static String FFT_CLASSNAME = "spec.benchmarks.scimark.fft.FFT";
	public final static String FFT_INSTR1 = "protected void transform_internal(double data[], int direction)";
	public final static String FFT_INSTR2 = "public void inverse(double data[])";
	public final static int FFT_LEFT_INCL_ADD_BOUND = 0;
	public final static int FFT_RIGHT_INCL_ADD_BOUND = 2;

	public final static String LU_CALLER = "public static void main(java.lang.String args[])";
	public final static String LU_CLASSNAME = "spec.benchmarks.scimark.lu.LU";
	public final static String LU_INSTR1 = "public int factor(double A[][],  int pivot[])";
//	public final static int LU_LEFT_INCL_ADD_BOUND = 0;
//	public final static int LU_RIGHT_INCL_ADD_BOUND = 1;
	public final static int LU_LEFT_INCL_ADD_BOUND = 0;
	public final static int LU_RIGHT_INCL_ADD_BOUND = Integer.MAX_VALUE;
	
	public final static String MC_CALLER = "public static void main(java.lang.String args[])";
	public final static String MC_CLASSNAME = "spec.benchmarks.scimark.monte_carlo.MonteCarloMK";
	//	private final static String LU_INSTR2 = "";
	public final static String MC_INSTR1 = "public final double integrate(int numSamples)";
	public final static String RD_CLASSNAME = "spec.benchmarks.scimark.utils.Random";
	public final static String RD_INSTR1 = "public final synchronized double nextDouble()";
	public final static int MC_LEFT_INCL_ADD_BOUND = 0;
	public final static int MC_RIGHT_INCL_ADD_BOUND = Integer.MAX_VALUE;

	public final static String SMM_CALLER = "public static void main(java.lang.String args[])";
	public final static String SMM_CLASSNAME = "spec.benchmarks.scimark.sparse.SparseCompRow";
	public final static String SMM_INSTR1 = "public void matmult(double y[], double val[], int row[], int col[], double x[], int NUM_ITERATIONS, int call_count)";
	public final static int SMM_LEFT_INCL_ADD_BOUND = 0;
	public final static int SMM_RIGHT_INCL_ADD_BOUND = Integer.MAX_VALUE;
	
	public final static String SOR_CALLER = "public static void main(java.lang.String args[])";
	public final static String SOR_CLASSNAME = "spec.benchmarks.scimark.sor.SOR";
	public final static String SOR_INSTR1 = "public final double execute(double omega, double G[][], int num_iterations)";
	public final static int SOR_LEFT_INCL_ADD_BOUND = 0;
	public final static int SOR_RIGHT_INCL_ADD_BOUND = Integer.MAX_VALUE;

	public final static int WORK_FFT = 0;
	public final static int WORK_LU = 1;
	public final static int WORK_MC = 2;
	public final static int WORK_SMM = 3;
	public final static int WORK_SOR = 4;
	
	/**
	 * Control the algorithm which is instrumented
	 */
	private static Integer input = WORK_SOR;

	/**
	 * The application entry point.
	 * @param args No arguments are accepted.
	 */
	public static void main(String[] args) {
		if(args!=null && args.length==1){
			try{
				input = new Integer(args[0]);
			}catch (Exception e) {
				System.out.println("Could not parse the command line: taking default value ("+input+")");
			}
		}
		SPECScimarkCountingStarter sccs = new SPECScimarkCountingStarter();
		sccs.run(input);
	}

	private boolean logAdditionMK = false;
	private int currRightBound = 0;
	private int currLeftBound = 0;
	
//	private int work = 0;

	public SPECScimarkCountingStarter() {
//		log = Logger.getLogger(this.getClass().getCanonicalName());
	}

	@SuppressWarnings("deprecation")
	private void count_dynamicpart(int input, boolean callerFirst) {
		//1. Set up a BytecodeCounter instance to use ByCounter, using a parameterless constructor. 
		BytecodeCounter counter = new BytecodeCounter(); //the only constructor available

		//2. Specify the methods to be instrumented
		List<MethodDescriptor> methodsToInstrument = new ArrayList<MethodDescriptor>();
		if(input==0){
			MethodDescriptor instr1 = new MethodDescriptor(
					FFT_CLASSNAME,
					FFT_INSTR1);
			MethodDescriptor instr2 = new MethodDescriptor(
					FFT_CLASSNAME,
					FFT_INSTR2);
			methodsToInstrument.add(instr1);
			methodsToInstrument.add(instr2);
		}else if(input==1){
			MethodDescriptor instr1 = new MethodDescriptor(
					LU_CLASSNAME,
					LU_INSTR1);
//			MethodDescriptor instr2 = new MethodDescriptor(
//					LU_CLASSNAME,
//					LU_INSTR2);
			methodsToInstrument.add(instr1);
//			methodsToInstrument.add(instr2);
		}else if(input==2){
			MethodDescriptor instr1 = new MethodDescriptor(
					MC_CLASSNAME,
					MC_INSTR1);
			MethodDescriptor instr2 = new MethodDescriptor(
					RD_CLASSNAME,
					RD_INSTR1);
			methodsToInstrument.add(instr1);
			methodsToInstrument.add(instr2);
		}else if(input==3){
			MethodDescriptor instr1 = new MethodDescriptor(
					SMM_CLASSNAME,
					SMM_INSTR1);
//			MethodDescriptor instr2 = new MethodDescriptor(
//					SMM_CLASSNAME,
//					SMM_INSTR2);
			methodsToInstrument.add(instr1);
//			methodsToInstrument.add(instr2);
		}else if(input==4){
			MethodDescriptor instr1 = new MethodDescriptor(
					SOR_CLASSNAME,
					SOR_INSTR1);
//			MethodDescriptor instr2 = new MethodDescriptor(
//					SOR_CLASSNAME,
//					SOR_INSTR2);
			methodsToInstrument.add(instr1);
//			methodsToInstrument.add(instr2);
		}else{
			System.out.println("Invalid input: "+input);
		}
		
//		MethodDescriptor caller = new MethodDescriptor(
//				"spec.benchmarks.scimark.monte_carlo.MonteCarloMK",
//				"public double measureMonteCarlo(double min_time, spec.benchmarks.scimark.utils.Random R)"); //full signature needed here!!! --> TODO simplify in ByCounter
//		MethodDescriptor callee1 = new MethodDescriptor(
//				"spec.benchmarks.scimark.monte_carlo.MonteCarloMK",
//				"public final double integrate(int numSamples)");
//		MethodDescriptor callee2 = new MethodDescriptor(
//				"spec.benchmarks.scimark.monte_carlo.MonteCarloMK",
//				"public final double integrate(int numSamples)");
//		if(callerFirst){
//			methodsToInstrument.add(caller);
//			methodsToInstrument.add(callee1);
//		}else{
//			methodsToInstrument.add(callee1);
//			methodsToInstrument.add(caller);
//		}

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
		
		//3. now tell ByCounter to instrument the specified method
		counter.instrument();
		
		//4. let ByCounter execute (not necessarily identical) method 
		//note that this class must be reloaded! TODO check TODO explaine reloaded <by whom>
		MethodDescriptor methodToExecute = null;
		if(input==0){
			methodToExecute = new MethodDescriptor(
				FFT_CLASSNAME, 
				FFT_CALLER);
			currLeftBound  = FFT_LEFT_INCL_ADD_BOUND;
			currRightBound = FFT_RIGHT_INCL_ADD_BOUND;
		}else if(input==1){
			methodToExecute = new MethodDescriptor(
				LU_CLASSNAME, 
				LU_CALLER);
			currLeftBound  = LU_LEFT_INCL_ADD_BOUND;
			currRightBound = LU_RIGHT_INCL_ADD_BOUND;
		}else if(input==2){
			methodToExecute = new MethodDescriptor(
				MC_CLASSNAME, 
				MC_CALLER);
			currLeftBound  = MC_LEFT_INCL_ADD_BOUND;
			currRightBound = MC_RIGHT_INCL_ADD_BOUND;
		}else if(input==3){
			methodToExecute = new MethodDescriptor(
				SMM_CLASSNAME, 
				SMM_CALLER);
			currLeftBound  = SMM_LEFT_INCL_ADD_BOUND;
			currRightBound = SMM_RIGHT_INCL_ADD_BOUND;
		}else if(input==4){
			methodToExecute = new MethodDescriptor(
				SOR_CLASSNAME, 
				SOR_CALLER);
			currLeftBound  = SOR_LEFT_INCL_ADD_BOUND;
			currRightBound = SOR_RIGHT_INCL_ADD_BOUND;
		}
		
		counter.execute(methodToExecute, new Object[] {new String[]{}});
		
		//5. now that ByCounter has completed counting, we can fetch all the results,
		//i.e. get the results list from CountingResultCollector
		List<CountingResult> results = 
			CountingResultCollector.getInstance().getAllCountingResults_nonRecursively();
		System.out.println("\n============================================\n"+
				results.size()+" results found in CountingResultCollector\n"+
				"============================================\n");
		
		//6. output the results to the console/log and serialise them
		
		CountingResult sumOfAllCountingResults = new CountingResult(
				methodToExecute.getMethodName(),
				methodToExecute.getMethodName(), //TODO explain why this is true?
				results.get(0).getFileType(),
				results.get(0).getInputCharacterisation(),
				results.get(0).getOutputCharacterisation(),
				-1L,
				-1L,
				new TreeMap<Integer,Long>(),
				new TreeMap<String,Long>(),
				new long[]{},
				new int[]{},
				new String[]{},
				new TreeMap<BytecodeSectionDescription, SortedMap<Integer,Long>>(),
				new TreeMap<BytecodeSectionDescription, SortedMap<String,Long>>());
				
		int currResultIndex = 0;
		for(CountingResult r : results) {
			System.out.println(r.toString());

			//6b. TODO add the counting result to the above 
			if(currResultIndex>=currLeftBound && currResultIndex<=currRightBound){
				sumOfAllCountingResults.add(r);
			}else{
				System.out.println("Not adding "+currResultIndex+". result: " +
						"out of range ["+currLeftBound+","+currRightBound+"]");
			}
			if(logAdditionMK){
				System.out.println("\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n" +
					"after adding CountingResult "+currResultIndex+":\n");
				System.out.println(sumOfAllCountingResults);
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
			}

			currResultIndex++;
		}
		System.out.println("\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n" +
				"\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n" +
				"FINAL RESULT:\n");
		System.out.println(sumOfAllCountingResults);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
				
		//7. clear the results as we do not need them anymore
		CountingResultCollector.getInstance().clearResults();
	}
	
	@SuppressWarnings("unused")
	private void count_staticpart() {
		//1. Set up a BytecodeCounter instance to use ByCounter, using a parameterless constructor. 
		BytecodeCounter counter = new BytecodeCounter(); //the only constructor available

		//2. Specify the methods to be instrumented
		List<MethodDescriptor> methodsToInstrument = new ArrayList<MethodDescriptor>();
		MethodDescriptor nextDouble = new MethodDescriptor(
				"spec.benchmarks.scimark.utils.Random",
				"public final synchronized double nextDouble()"); 
		methodsToInstrument.add(nextDouble);

		InstrumentationParameters ip = new InstrumentationParameters(
				methodsToInstrument, //methods to instrument
				true,  // use high registers for counting
				true,  // use resultCollector
				false, // use array parameter recording
				true, // count statically
				-1,    // start line
				-1,    // stop line
				InstrumentationParameters.COUNTER_PRECISION_LONG);
		counter.setInstrumentationParams(ip);
		
		//3. now tell ByCounter to instrument the specified method
		counter.instrument();
		
		//4. let ByCounter execute (not necessarily identical) method 
		//note that this class must be reloaded! TODO check TODO explaine reloaded <by whom>
		MethodDescriptor methodToExecute = new MethodDescriptor(
				"spec.benchmarks.scimark.monte_carlo.MainMK", 
				"public static void main(java.lang.String args[])");
		
		counter.execute(methodToExecute, new Object[] {new String[]{}});
		
		//5. now that ByCounter has completed counting, we can fetch all the results,
		//i.e. get the results list from CountingResultCollector
		List<CountingResult> results = 
			CountingResultCollector.getInstance().getAllCountingResults_nonRecursively();
		System.out.println("\n============================================\n"+
				results.size()+" results found in CountingResultCollector\n"+
				"============================================\n");
		
		//6. output the results to the console/log and serialise them
		for(CountingResult r : results) {
			System.out.println(r.toString());
		}

		//7. clear the results as we do not need them anymore
		CountingResultCollector.getInstance().clearResults();
	}
	
	/**
	 * @param pathForCSVFile
	 * @param filesNames
	 * @param fileSizes
	 * @param measurementsSummary
	 * @param timePerInputByte
	 * @deprecated because untested
	 */
	@SuppressWarnings("unused")
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
	
	private void run(int input) {
//		try{
//			this.count_staticpart();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		try{
			this.count_dynamicpart(input, true); //caller first
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
