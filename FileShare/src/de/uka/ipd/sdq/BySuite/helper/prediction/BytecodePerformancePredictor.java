package de.uka.ipd.sdq.BySuite.helper.prediction;

import java.util.Arrays;

import de.uka.ipd.sdq.BySuite.helper.benchmarkedbytecode.BenchmarkedBytecode;
import de.uka.ipd.sdq.BySuite.helper.learnedbytecode.LearnedBytecode;
import de.uka.ipd.sdq.BySuite.helper.learnedbytecode.LearnedDataErrorCalculation;

public class BytecodePerformancePredictor {

	public static void main(String[] args){
		BytecodePerformancePredictor bpp = new BytecodePerformancePredictor();
		long[] predLenovo = bpp.predict(BenchmarkedBytecode.MICHAEL_LENOVO, BenchmarkedBytecode.IS_NOT_JITTED);
		long[] predToshiba = bpp.predict(BenchmarkedBytecode.MICHAEL_TOSHIBA, BenchmarkedBytecode.IS_NOT_JITTED);
		System.out.println("\n\n\n");
		System.out.println("Lenovo: "+Arrays.toString(predLenovo));
		System.out.println("\n\n\n");
		System.out.println("Toshiba: "+Arrays.toString(predToshiba));
		int indexForCheck = 10;
		System.out.println("Check: pred lenovo for file at index "+indexForCheck+
				": Lenovo="+predLenovo[indexForCheck]+
				", Toshiba="+predToshiba[indexForCheck]);
	}

	private long[] predict(int platform, int jitFlag) {
		long[] allResults = new long[20];
		long[] allCounts  = new long[20];
		long[] currResult;
//		double[] allResults = new double[20];
//		double[] currResult;
		
		//iterate over files...
		for(int i=1; i<21; i++){
			currResult = this.predict_long(
					platform, 
					jitFlag, 
					i //file: rownumber == fileindex+1 --> it starts from 1!
			);
			allResults[i-1] = currResult[0];//prediction
			allCounts[i-1] = currResult[1];//total sum of evaluated instructions
		}
		System.out.println("=============\n" +
				"Predicted duration results: "+Arrays.toString(allResults)+"\n"+
				"Learned counts cesults: "+Arrays.toString(allCounts));
		return allResults;
	}
	
	public double[] predict(
			int platformID, 
			int isJitted, 
			int rowNumber //one greater than the file index
		){
		LearnedBytecode lb = new LearnedBytecode(); //does not read any files...
		
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
		for(int i=0; i<LearnedBytecode.LEARNED_BYTECODES.length; i++){
			currInstructionOpcode = LearnedBytecode.LEARNED_BYTECODES[i];
			
			currInstructionCount = lb.getLearnedData(
					currFilesize, 
					currIsCompressed, 
					currInstructionOpcode);
			totalSumOfEvalutedInstructions+=currInstructionCount;
			
			currInstructionDuration = bb.getBenchmarkedData(
					platformID, 
					isJitted, 
					currInstructionOpcode);
			System.out.println("Adding opcode "+currInstructionOpcode+": "+
					currInstructionCount+" times "+currInstructionDuration+" ns");
			prediction += currInstructionCount*currInstructionDuration;
		}
		System.out.println(prediction+" ns: " + "prediction result");
		System.out.println(totalSumOfEvalutedInstructions+" learned instructions evaluated)");
		System.out.println(((long) prediction)+" ns: " + "prediction result as long");
		return new double[]{prediction,totalSumOfEvalutedInstructions};
	}
	
	public long[] predict_long(
			int platformID, 
			int isJitted, 
			int rowNumber //one greater than the file index
		){
		double[] doubleRes = this.predict(platformID, isJitted, rowNumber); 
		return new long[]{((long) doubleRes[0]), ((long) doubleRes[1])};
	}
}
