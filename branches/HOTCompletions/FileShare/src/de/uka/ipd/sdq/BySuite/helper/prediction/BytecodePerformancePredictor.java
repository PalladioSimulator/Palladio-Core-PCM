package de.uka.ipd.sdq.BySuite.helper.prediction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.BySuite.helper.benchmarkedbytecode.BenchmarkedBytecode;
import de.uka.ipd.sdq.BySuite.helper.learnedbytecode.LearnedBytecode;
import de.uka.ipd.sdq.BySuite.helper.learnedbytecode.LearnedDataErrorCalculation;

public class BytecodePerformancePredictor {

	public static void main(String[] args){
		BytecodePerformancePredictor bpp = new BytecodePerformancePredictor();
		ComprehensivePredictionResult[] predAcer = bpp.predictAllFiles(
				BenchmarkedBytecode.KLAUS_ACER, 
				BenchmarkedBytecode.IS_NOT_JITTED);
		ComprehensivePredictionResult[] predLenovo = bpp.predictAllFiles(
				BenchmarkedBytecode.MICHAEL_LENOVO, 
				BenchmarkedBytecode.IS_NOT_JITTED);
		ComprehensivePredictionResult[] predToshiba = bpp.predictAllFiles(
				BenchmarkedBytecode.MICHAEL_TOSHIBA, 
				BenchmarkedBytecode.IS_NOT_JITTED);
		ComprehensivePredictionResult[] predSDQLenovo = bpp.predictAllFiles(
				BenchmarkedBytecode.SDQ_LENOVO, 
				BenchmarkedBytecode.IS_NOT_JITTED);
//		long[] predAcer = bpp.predict(BenchmarkedBytecode.KLAUS_ACER, 
//				BenchmarkedBytecode.IS_NOT_JITTED);
//		long[] predLenovo = bpp.predict(BenchmarkedBytecode.MICHAEL_LENOVO, 
//				BenchmarkedBytecode.IS_NOT_JITTED);
//		long[] predToshiba = bpp.predict(BenchmarkedBytecode.MICHAEL_TOSHIBA, 
//				BenchmarkedBytecode.IS_NOT_JITTED);
//		long[] predSDQLenovo = bpp.predict(BenchmarkedBytecode.SDQ_LENOVO, 
//				BenchmarkedBytecode.IS_NOT_JITTED);
		System.out.println("\n\n\n");
		System.out.println("KK_Acer, eleventh file: "+predAcer[10]);
		System.out.println("\n\n\n");
		System.out.println("MK_Lenovo, eleventh file: "+predLenovo[10]);
//		System.out.println("\n\n\n");
//		System.out.println("MK Lenovo: "+Arrays.toString(predLenovo));
//		System.out.println("\n\n\n");
//		System.out.println("Toshiba: "+Arrays.toString(predToshiba));
//		System.out.println("\n\n\n");
//		System.out.println("SDQ Lenovo: "+Arrays.toString(predSDQLenovo));
//		int indexForCheck = 10;
//		System.out.println("Check: pred for file at index "+indexForCheck+
//				": KK_Acer="+predAcer[indexForCheck]+
//				", MK_Lenovo="+predLenovo[indexForCheck]+
//				", MK_Toshiba="+predToshiba[indexForCheck]+
//				", SDQ_Lenovo="+predSDQLenovo[indexForCheck]);
	}

	private ComprehensivePredictionResult[] predictAllFiles(
			int platform, 
			int jitFlag) {
//		long[] allResults = new long[20];
//		long[] allCounts  = new long[20];
		ComprehensivePredictionResult[] results = new ComprehensivePredictionResult[20];
//		double[] allResults = new double[20];
//		double[] currResult;
		
		//iterate over files...
		for(int i=1; i<21; i++){
			results[i-1] = this.predictSingleFile(
					platform, 
					jitFlag, 
					i //file: rownumber == fileindex+1 --> it starts from 1!
			);
		}
//		System.out.println("=============\n" +
//				"Predicted duration results: "+Arrays.toString(allResults)+"\n"+
//				"Learned counts cesults: "+Arrays.toString(allCounts));
		return results;
	}
	
	public ComprehensivePredictionResult predictSingleFile(
			int platformID, 
			int isJitted, 
			int rowNumber //one greater than the file index
		){
		LearnedBytecode lb = new LearnedBytecode(); //does not need to read any files...
		
		BenchmarkedBytecode bb;
		bb = new BenchmarkedBytecode(platformID, isJitted);//reads from file //TODO optimise
		
		LearnedDataErrorCalculation ldec = new LearnedDataErrorCalculation();
		double prediction = 0D;
		int currInstructionOpcode = 0;
		double currInstructionCount = 0D;
		double currInstructionDuration = 0D;
		String currFilename = ldec.getMeasuredData_String(rowNumber,-3);
		int currIsCompressed = new Double(ldec.getMeasuredData(rowNumber,-1)).intValue();;
		long currFilesize = new Double(ldec.getMeasuredData(rowNumber,-2)).longValue();
		
		long totalSumOfEvalutedInstructions = 0L;
//		int currIsCompressed = new Double(ldec.getMeasuredData(rowNumber,-1)).intValue();;
		
		System.out.println("Starting prediction for platform "+platformID+", "+
				"isJitted="+isJitted+", " +
				"fileName "+currFilename+" "+
				"(file compression: "+currIsCompressed+")");
		
		Map<Integer,Long> tempCounts = new HashMap<Integer, Long>();
		Map<Integer,Double> tempDurations = new HashMap<Integer, Double>();
		String tempPlatformID = "platformID"+platformID;
		for(int i=0; i<LearnedBytecode.LEARNED_BYTECODES.length; i++){
			currInstructionOpcode = LearnedBytecode.LEARNED_BYTECODES[i];
			
			currInstructionCount = lb.getLearnedData(
					currFilesize, 
					currIsCompressed, 
					currInstructionOpcode);
			totalSumOfEvalutedInstructions+=currInstructionCount;
			tempCounts.put(currInstructionOpcode, new Long((long) currInstructionCount));
			
			currInstructionDuration = bb.getBenchmarkedData(
					platformID, 
					isJitted, 
					currInstructionOpcode);
			tempDurations.put(currInstructionOpcode, currInstructionDuration);
			System.out.println("Adding opcode "+currInstructionOpcode+": "+
					currInstructionCount+" times "+currInstructionDuration+" ns");
			prediction += currInstructionCount*currInstructionDuration;
		}
		
		System.out.println(prediction+" ns: " + "prediction result");
		System.out.println(totalSumOfEvalutedInstructions+" learned instructions evaluated)");
		System.out.println(((long) prediction)+" ns: " + "prediction result as long");
		return new ComprehensivePredictionResult(tempPlatformID,tempCounts,tempDurations);
	}
	
//	public long[] predictSingleFile_long(
//			int platformID, 
//			int isJitted, 
//			int rowNumber //one greater than the file index
//		){
//		double[] doubleRes = this.predict(platformID, isJitted, rowNumber); 
//		return new long[]{((long) doubleRes[0]), ((long) doubleRes[1])};
//	}
}
