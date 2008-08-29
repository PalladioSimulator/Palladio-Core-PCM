package de.uka.ipd.sdq.ByCounter.SPECevaluation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;

import spec.benchmarks.compress.Harness;
import spec.benchmarks.compress.Main;
import de.uka.ipd.sdq.ByCounter.execution.BytecodeCounter;
import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;
import de.uka.ipd.sdq.ByCounter.instrumentation.InstrumentationParameters;
import de.uka.ipd.sdq.ByCounter.utils.CSVResultWriter;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;
import de.uka.ipd.sdq.BySuite.ByPred.counting.results.OpcodeFrequencySorter;
import de.uka.ipd.sdq.BySuite.ByPred.counting.results.SortableFrequency;

public class SPECCompressCountingStarter {
	private static int fileIndexForCompression=0;

	/**
	 * Quickstart example of the most basic ByCounter usage.
	 */
	public static void countCompressWithDefaults(/*int fileIndex*/) {
//		if(fileIndex<0 || fileIndex>=Harness.FILES_NAMES.length){
//			System.out.println("ERROR: file index out of bounds");
//			return;
//		}else{
////			fileIndexForCompression = fileIndex; //TODO Martin
////			Harness.setFileIndex(fileIndexForCompression);//TODO Martin
//			System.out.println(">>>MK OK: file index is "+fileIndexForCompression+", set to Harness");
			fileIndexForCompression = Harness.getFileIndex();
			System.out.println(">>>MK file index in Harness "+Harness.getFileIndex());
//			
//		}
			
		//1. Set up a BytecodeCounter instance to use ByCounter, using a parameterless constructor. 
		BytecodeCounter counter = new BytecodeCounter(); //the only constructor available
		System.out.println(">>>@1 MK file index in Harness "+Harness.getFileIndex());
		

		//2. Specify the methods to be instrumented
		List<MethodDescriptor> methodsToInstrument = new ArrayList<MethodDescriptor>();
		methodsToInstrument.add(new MethodDescriptor(
				"spec.benchmarks.compress.Compressor", //Compressor is not an inner class! thus, do not try Compress$Compressor!
				"public void compress()"));
		System.out.println(">>>@2 MK file index in Harness "+Harness.getFileIndex());

//		TODO some problems with the following addition! --> Martin Email
//		methodsToInstrument.add(new MethodDescriptor(
//				"spec.benchmarks.compress.Compressor", //Compressor is not an inner class! thus, do not try Compress$Compressor!
//				"public void output(int a)")); //TODO it is important to have "(int a)", not just "(int): TODO programm in a more tolerant way!

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
		System.out.println(">>>@3 MK file index in Harness "+Harness.getFileIndex());
		
		//3. now tell ByCounter to instrument the specified method
		counter.instrument();
		System.out.println(">>>@4 MK file index in Harness "+Harness.getFileIndex());
		
		//4. let ByCounter execute the method (note that this class must be reloaded! TODO check)
		MethodDescriptor methodToExecute = new MethodDescriptor(
				"spec.benchmarks.compress.Main", //Compressor is not an inner class! thus, do not try Compress$Compressor!
				"public static void main(java.lang.String args[])");
		
		counter.execute(methodToExecute, new Object[] {new String[]{}});
		System.out.println(">>>@5 MK file index in Harness "+Harness.getFileIndex());
		
		//5. now that ByCounter has completed counting, we can fetch the results,
		//i.e. get the results list from CountingResultCollector
		List<CountingResult> results = 
			CountingResultCollector.getInstance().getResults();
		System.out.println(results.size()+" results found in CountingResultCollector");
		
		//6. output the results to the console/log and serialise them
		OpcodeFrequencySorter ofs = new OpcodeFrequencySorter();
		for(CountingResult r : results) {
			r.setFileType(Harness.getLastInputType()); //TODO document this
			r.setInputCharacterisation(Harness.getLastInputSize());
			r.setOutputCharacterisation(Harness.getLastOutputSize());
			System.out.println("???: "+r.getInputCharacterisation());
			System.out.println("???: "+r.getOutputCharacterisation());

			//6a. log
			CountingResultCollector.getInstance().logResult(r);
			
			String[] fileNameTokens = Harness.FILES_NAMES[Harness.getFileIndex()].split("/");
			String pureFileName = fileNameTokens[fileNameTokens.length-1];
			
			//6b. find and CSVwrite the most frequent ("the most frequent" what ?)
			
			boolean includeInvokeOpcodes=true;
			SortedSet<SortableFrequency> sortedResults = null;
			try {
				System.out.println(">>> "+r.getOpcodeCounts().keySet().size()+
						" input opcodes counts for " +
						"getMostFrequentOpcodesInOneDataset_Integer");
				sortedResults = ofs.getMostFrequentOpcodesInOneDataset_Integer(
						OpcodeFrequencySorter.RELATIVE_LOCAL_FREQUENCY, 
						r.getOpcodeCounts(), 
						r.getTotalOpcodeCount(includeInvokeOpcodes));
				System.out.println(">>> "+sortedResults.size()+
						" output frequencies from " +
						"getMostFrequentOpcodesInOneDataset_Integer");
				String sortedFrequenciesFileName;
				sortedFrequenciesFileName = 
					pureFileName+
					"."+System.nanoTime()+
					".sortedFrequencies.CSV";
				ofs.serialiseSortedFrequenciesToCSV(
						sortedResults,
						sortedFrequenciesFileName);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			//6c. serialise CountingResult
			FileOutputStream fos=null;
			try{
				String fileName = r.getQualifyingMethodName()+"."+
				r.getMethodInvocationBeginning()+"."+
				r.getMethodReportingTime()+"_"+
				pureFileName+"_.SCResult";
				fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				CountingResult resultToSerialise = (CountingResult) r.clone();
				resultToSerialise.setID(pureFileName);
				oos.writeObject(resultToSerialise);
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
		}
		
		//7. write an unsorted, all-counts CSV file for a single result
		CSVResultWriter crw = new CSVResultWriter(
				true,
				';',
				true, //list invoke opcodes
				true, //perform consistency check on invoke opcodes
				getFileNameByIndex(fileIndexForCompression),
				"csv",
				".",
				false,  //write booleans as integers
				false,  //write opcodes as integers
				true,   //write unused opcodes
				false,  //truncate undefined opcodes
				false); //write array details to separate file
		if(results.size()>0){
			crw.writeResult(results.get(0));//TODO document the fixed results index!
		}else{
			System.err.println("No counting result found!");
		}
		
		//8. clear the results as we do not need them anymore
		CountingResultCollector.getInstance().clearResults();
	}
	
	public static int getFileIndex() {
		return fileIndexForCompression;
	}

	public static void setFileIndex(int index) {
		fileIndexForCompression = index;
	}

	public static String getFileNameByIndex(int i){
		if(i<0 || i>=Harness.FILES_NAMES.length){
			System.out.println("ERROR: file index out of bounds");
			return null;
		}else{
			return Harness.FILES_NAMES[i];
		}
	}

	/**
	 * The application entry point.
	 * @param args No arguments are accepted.
	 */
	public static void main(String[] args) {
//		measureCompress();
//		int usedFileIndex=2;
//		for(; i<Harness.FILES_NUMBER; i++){
			countCompressWithDefaults(/*usedFileIndex*/); //TODO switch back from forced Harness reading of fileIndex... fix instrumentation problem
//		}
	}
	
	/**
	 * TODO
	 */
	@SuppressWarnings("unused")
	private static void measureCompress() {
		int nrOfMeasurements = 100;
//		boolean groupByInputs = false;
		File f = new File(".");
		System.out.println(f.getAbsolutePath());
		String filePath;
		long[] fileSizes = new long[Harness.FILES_NAMES.length];
		long[][] measurements = new long[Harness.FILES_NAMES.length][nrOfMeasurements];
		long[][] measurementsSummary = new long[Harness.FILES_NUMBER][3]; 
		double[] timePerInputByte = new double[Harness.FILES_NUMBER];

		int i=0;
		for(; i<Harness.FILES_NUMBER; i++){
			filePath = /*"."+File.separatorChar+".."+File.separatorChar+"SPECjvm2008_1.00"+File.separatorChar+*/
				Harness.FILES_NAMES[i];
			f = new File(filePath);
			fileSizes[i] = f.length();
			System.out.println(filePath+": "+fileSizes[i]);
		}
		
		long start = 0L;
		long finish = 0L;
//		if(groupByInputs){
			int k=0;
			int l=0;
			for(;k<Harness.FILES_NUMBER;k++){
//				System.out.print(/*"."+File.separatorChar+".."+
//						File.separatorChar+"SPECjvm2008_1.00"+
//						File.separatorChar+*/Harness.FILES_NAMES[k]+": ");
				l=0;
				for(;l<nrOfMeasurements;l++){
					start = System.nanoTime();
					try {
						Harness.setFileIndex(k);
						Main.main(new String[]{});
						
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
		for(;k<Harness.FILES_NUMBER;k++){
			System.out.print(Harness.FILES_NAMES[k]+": ");
			l=0;
			for(;l<nrOfMeasurements;l++){
				System.out.print(measurements[k][l]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		
		i=0;
		for(; i<measurements.length; i++){
			Arrays.sort(measurements[i]);
			measurementsSummary[i][0] = measurements[i][0]; //min
			measurementsSummary[i][1] = measurements[i][measurements[i].length/2]; //median
			measurementsSummary[i][2] = measurements[i][measurements[i].length-1]; //max
			System.out.println("Summary for file "+i+": "+"" +
					  "min="+measurementsSummary[i][0]+" ns"+
					", med="+measurementsSummary[i][1]+" ns"+
					", max="+measurementsSummary[i][2]+" ns");
		}
		
		System.out.println(" median ns per byte ===========");	
		i=0;
		for(; i<measurements.length; i++){
			timePerInputByte[i] = ((double) measurementsSummary[i][1])/((double) fileSizes[i]);
			System.out.println("Summary for file "+i+": "+"" +
					timePerInputByte[i]+" ns per byte");//TODO CSV writer
		}
			
		putIntoCSVFile("SPECcompressSummary."+System.nanoTime()+".csv",
				Harness.FILES_NAMES,
				fileSizes,
				measurementsSummary,
				timePerInputByte);
	}
	private static void putIntoCSVFile(String pathForCSVFile,
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

}
