package prediction;

import benchmarkedbytecode.BenchmarkedBytecode;
import learnedbytecode.LearnedBytecode;
import learnedbytecode.LearnedDataErrorCalculation;

public class BytecodePerformancePredictor {

	public static void main(String args[]){
		BytecodePerformancePredictor bpp = new BytecodePerformancePredictor();
		bpp.predict(
				BenchmarkedBytecode.MICHAEL_LENOVO, 
				BenchmarkedBytecode.IS_NOT_JITTED, 
				2);
	}
	
	public double[] predict(
			int platformID, 
			int isJitted, 
			int rowNumber //one greater than the file index
		){
//		String fileName = 
		LearnedBytecode lb = new LearnedBytecode();
		int platformindex = BenchmarkedBytecode.MICHAEL_LENOVO;
//		int isJitted = BenchmarkedBytecode.IS_NOT_JITTED;
		BenchmarkedBytecode bb = new BenchmarkedBytecode(
				platformindex, isJitted);
		LearnedDataErrorCalculation ldec = new LearnedDataErrorCalculation();
		double prediction = 0D;
		int currInstructionOpcode = 0;
		double currInstructionCount = 0D;
		double currInstructionDuration = 0D;
		String currFilename = ldec.getMeasuredData_String(rowNumber,-3);
		int currIsCompressed = new Double(ldec.getMeasuredData(rowNumber,-1)).intValue();;
		long currFilesize = new Double(ldec.getMeasuredData(rowNumber,-2)).longValue();
//		int currIsCompressed = new Double(ldec.getMeasuredData(rowNumber,-1)).intValue();;
		
		System.out.println("Starting prediction for platform "+platformID+", "+
				"isJitted="+isJitted+", fileName "+currFilename+" "+
				"(file compression: "+currIsCompressed+")");
		for(int i=0; i<LearnedBytecode.LEARNED_BYTECODES.length; i++){
			currInstructionOpcode = LearnedBytecode.LEARNED_BYTECODES[i];
			
			currInstructionCount = lb.getLearnedData(
					currFilesize, 
					currIsCompressed, 
					currInstructionOpcode);
			
			currInstructionDuration = bb.getBenchmarkedData(
					platformindex, 
					isJitted, 
					currInstructionOpcode);
			System.out.println("Adding opcode "+currInstructionOpcode+": "+
					currInstructionCount+" times "+currInstructionDuration+" ns");
			prediction += currInstructionCount*currInstructionDuration;
		}
		System.out.println("Prediction result: "+prediction+" ns");
		return new double[]{prediction};
	}
}
