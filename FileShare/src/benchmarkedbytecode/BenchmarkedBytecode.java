package benchmarkedbytecode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import au.com.bytecode.opencsv.CSVReader;

public class BenchmarkedBytecode {

	private static double[][][] benchmarkResults = {
		//first dimension: platform
		//second dimension: isJitted or not
		//third dimension: instruction value
		{
			{1,2,3,4,5, 1,1,1,1,1, 1,1,1,1, }, //KLAUS, JITTED
		    {1,1,1,1,1, 1,2,3,4,5, 1,1,1,1, }  //KLAUS, UNJITTED
	    }, {
	    	{1,1,1,1,1, 1,1,1,1,1, 1,2,3,4, }, //MICHAEL, JITTED
	    	{1,1,1,1,1, 1,1,1,1,1, 6,7,8,9, }  //MICHAEL, UNJITTED
	    }};
	
	public static final int IS_JITTED = 0;
	
	public static final int IS_NOT_JITTED = 1;
	
	public static final int KLAUS_ACER = 0;
	
	public static final int MICHAEL_LENOVO = 1;
	
	public double getBenchmarkedData(
			int platformindex, 
			int isJitted, 
			int buildingBlockIndex //bytecode instruction or method
			) {
		switch (buildingBlockIndex) {
		case 2:   return benchmarkResults[platformindex][isJitted][0];
		case 3:   return benchmarkResults[platformindex][isJitted][1];
		case 4:   return benchmarkResults[platformindex][isJitted][2];
		case 17:  return benchmarkResults[platformindex][isJitted][3];
		case 21:  return benchmarkResults[platformindex][isJitted][4];
		
		case 25:  return benchmarkResults[platformindex][isJitted][5];
		case 50:  return benchmarkResults[platformindex][isJitted][6];
		case 51:  return benchmarkResults[platformindex][isJitted][7];
		case 58:  return benchmarkResults[platformindex][isJitted][8];
		case 132: return benchmarkResults[platformindex][isJitted][9];
		
		case 160: return benchmarkResults[platformindex][isJitted][10];
		case 161: return benchmarkResults[platformindex][isJitted][11];
		case 188: return benchmarkResults[platformindex][isJitted][12];
		case 190: return benchmarkResults[platformindex][isJitted][13];

		
//		case 2: return bc2(platformindex, isJitted);
//		case 3: return bc3(platformindex, isJitted);
//		case 4: return bc4(platformindex, isJitted);
//		case 17: return bc17(platformindex, isJitted);
//		case 21: return bc21(platformindex, isJitted);
//		
//		case 25: return bc25(platformindex, isJitted);
//		case 50: return bc50(platformindex, isJitted);
//		case 51: return bc51(platformindex, isJitted);
//		case 58: return bc58(platformindex, isJitted);
//		case 132: return bc132(platformindex, isJitted);
//		
//		case 160: return bc160(platformindex, isJitted);
//		case 161: return bc161(platformindex, isJitted);
//		case 188: return bc188(platformindex, isJitted);
//		case 190: return bc190(platformindex, isJitted);
}
				
		// no function learned:
		System.err.println("basicBlockIndex not supported");
		return -1;
	}
	
	public static void main(String[] args) {
		BenchmarkedBytecode bb = new BenchmarkedBytecode();
		System.out.println( bb.getBenchmarkedData(KLAUS_ACER,      IS_JITTED,     50) );
		System.out.println( bb.getBenchmarkedData(KLAUS_ACER,      IS_NOT_JITTED, 51) );
		System.out.println( bb.getBenchmarkedData(MICHAEL_LENOVO, IS_JITTED,     58) );
		System.out.println( bb.getBenchmarkedData(MICHAEL_LENOVO, IS_NOT_JITTED, 132) );
		
		bb.readBenchmarkResultsFromFile(MICHAEL_LENOVO,IS_NOT_JITTED);
		System.out.println( bb.getBenchmarkedData(MICHAEL_LENOVO, IS_NOT_JITTED, 2) );
		System.out.println( bb.getBenchmarkedData(MICHAEL_LENOVO, IS_NOT_JITTED, 4) );
	}
	
	CSVReader reader;
	
	public BenchmarkedBytecode(int platformID, int isJitted) {
		super();
		this.readBenchmarkResultsFromFile(platformID, isJitted);
	}
	
	public BenchmarkedBytecode() {
		super();
	}
	
	/** TODO test decimalseparation...
	 * @param platformID
	 * @param isJitted
	 */
	public void readBenchmarkResultsFromFile(int platformID, int isJitted) {
		//TODO check parameters
		try {
			reader = new CSVReader(
					new FileReader(
							"benchmarkedBytecode/BenchmarkResults.learned_only.csv"), 
							';' //separation char
					);
		
			String [] currLine;
			
			// first line: contains titles
			/*String[] firstLine = */reader.readNext();
			
			int currLineNr = 0;
			String currInstructionName;
			int currInstructionOpcode;
			double currInstructionDuration;
			while ((currLine = reader.readNext()) != null 
					&& currLineNr < benchmarkResults[0][0].length) {
				System.out.println("Line "+currLineNr+": "+Arrays.toString(currLine));
				
				currInstructionName 	= currLine[0];
				currInstructionOpcode 	= new Integer(currLine[1]).intValue();
				currInstructionDuration = new Double(currLine[2]).doubleValue();
				benchmarkResults[platformID][isJitted][currLineNr] = currInstructionDuration;
				System.out.println("Opcode "+currInstructionName+" " +
						"(opcode number "+currInstructionOpcode+"): " +
						""+currInstructionDuration+"ns duration");
			    currLineNr++;
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	private static double bc2(long X1, int X2) {
//		return X1 + X1 + 3.0;	
//	}
//	
//	private static double bc3(long X1, int X2) {
//		String exp = "315.0 + 315.0 + ((MyIF(0.7244477 >= (71.0 + 0.0),315.0)) + (X1 + (((((71.0 + 0.0) * X1) + (211.0 + (X2 * (0.7244477 + (0.7244477 + (0.7244477 + ((333.0 * (MyIF(0.7244477 >= (MyIF(0.7244477 >= 0.7244477,315.0)),(333.0 * X1)))) * 0.7244477) + (((211.0 * X1) + 315.0 + ((MyIF(0.7244477 >= (MyIF(0.7244477 >= 0.7244477,315.0)),315.0)) + (333.0 * 0.7244477))) + X1)) + (333.0 * X1)) + 333.0)) + X1) + (MyIF(0.7244477 >= (71.0 + 0.0),(333.0 * (348.0 * X1))))) + (0.7244477 + ((X1 + (Exp(X2))) + (348.0 * X1) + 0.7244477) + 333.0) + (0.7244477 + (MyIF(0.7244477 >= (333.0 * 0.7244477),(0.7244477 + (4.0 + 0.37233508) + X1))) + X1)) + (333.0 * X1)) + 4.0))";				
//      	return evalExpression(X1, X2, exp);
//	}
//	
//	private static double bc4(long X1, int X2) {
//		String exp = "((X1 * 1.1 * 347.0) + (sin (MyIF(93.0 >= (MyIF(20000.0 >= X2,X2)),1000.0))) + (273.0 * X2 * X1)) + (SIN((X2 * 1.9 * 1.9) / (0.7 / 10.0))) + 0.9";				
//      	return evalExpression(X1, X2, exp);
//	}
//	
//	private static double bc17(long X1, int X2) {
//		String exp = "((X1 - X2) - 367.0) * (sin (1.5 ^ X2))";				
//      	return evalExpression(X1, X2, exp);
//	}
//
//	private static double bc21(long X1, int X2) {
//		String exp = "((0.12728024 + 1.7 + X2) * (0.12728024 * X1) * (0.12728024 * 1000.0 * 213.0)) - (Exp((0.12728024 / 0.12728024)))";				
//      	return evalExpression(X1, X2, exp);
//	}
//	
//	private static double bc25(long X1, int X2) {
//		String exp = "((X1 * 199.0) + (1.3 + 4.0 + ((1.7 ^ X2) * (X1 * 199.0) * (9.0 - X2))) + ((X1 * 199.0) - 199.0)) + ((X1 + X1) + (10.0 * 1000.0) + (X1 * 199.0)) + (X1 * 199.0)";				
//      	return evalExpression(X1, X2, exp);
//	}
//	
//	private static double bc50(long X1, int X2) {
//		String exp = "(X1 * 392.0) + (64.0 + (X1 * (MyIfThenElse(35.0 >= X2,392.0,(1.9 + X1 + 5.0))))) + ((X1 * 30.0) * (4.0 + (MyIf(X2 >= 392.0,(1.9 + (64.0 + (0.53918666 + (4.0 + (4.0 + (MyIfThenElse(139.0 >= 0.026080012,1.1,100.0)) + 2.0) + 2.0)))))) + (Exp(X2))))";				
//      	return evalExpression(X1, X2, exp);
//	}
//	
//	private static double bc51(long X1, int X2) {
//		String exp = "((MyIF((155.0 + (sin(X2)) + 356.0) >= X1,356.0)) + X2 + 356.0) + ((155.0 + X2 + (MyIF((X2 * (400000.0 - 100.0) * X1) >= X1,356.0))) + (X1 * ((0.30710447 + ((MyIF(0.9 >= X1,356.0)) + (MyIF((0.30710447 + X2 + X2) >= 0.9,(MyIF(X1 >= 0.9,51.0)))) + X2) + (X2 * 100.0)) + (155.0 + (MyIF((X2 * 356.0 * X1) >= X1,356.0)) + (MyIF(X1 >= 0.9,51.0))) + (0.30710447 + X2 + X2))) + (155.0 + (MyIF(X1 >= 0.9,51.0)) + (X1 * (155.0 + ((MyIF((155.0 + (0.5 / 0.12519497) + 356.0) >= X1,356.0)) + (MyIF(X1 >= 0.9,51.0)) + 356.0) + X2)))) + X2";				
//      	return evalExpression(X1, X2, exp);
//	}
//	
//	private static double bc58(long X1, int X2) {
//		String exp = "MyIfThenElse((217.0 * X1) >= X2,((((100.0 * X1 * X2) * (0.7 * 217.0)) / X1) + ((100.0 * X1 * X2) + (217.0 * X1) + (1.3 + (217.0 * X1) + ((268.0 + 203.0) * (MyIf(217.0 >= 0.02760756,X1))))) + (MyIf((X1 + X2 + (X1 / X1)) >= 1.7,0.02760756))),268.0)";				
//      	return evalExpression(X1, X2, exp);
//	}
//	
//	private static double bc132(long X1, int X2) {
//		String exp = "((X1 + 1.1 + (5.0 + (328.0 * X1 * X2))) + X1) + ((((X1 + 4.0 + (328.0 * X1 * 4.0)) + 223.0 + 121.0) + (X2 + X1) + 223.0) + 223.0 + 121.0) + ((MyIfThenElse(4.0 >= (5.0 + (328.0 * X1 * X2)),(173.0 * 4.0 * 1.5),X2)) + 223.0 + 121.0)";				
//      	return evalExpression(X1, X2, exp);
//	}
//	
//	private static double bc160(long X1, int X2) {
//		String exp = "4.0 * ((X2 + (0.7 * X1 * 162.0) + (0.7 * X1 * 162.0)) + ((3.0 ^ X2) + (X2 - X2) + ((((0.7 * X1 * 1.5) + (MyIf((76.0 + 200.0 + 0.1) >= 20000.0,X1)) + X1) + (((MyIfThenElse(0.9 >= X1,5.0,(0.7 * X1 * (1000.0 ^ X2)))) + 5.0) - X2) + (MyIfThenElse(X1 >= X1,X1,X1))) + X1 + (4.0 / 0.7841332))) + X1)";				
//      	return evalExpression(X1, X2, exp);
//	}
//	
//	private static double bc161(long X1, int X2) {
//		String exp = "(1.9 + (X1 + 113.0 + (400000.0 + ((30.0 * 1.1 * 0.34182966) * X1 * 4.0) + (30000.0 / 148.0)))) + 376.0 + ((3.0 + (30000.0 + (X1 - 200.0) + ((113.0 * X2 * X1) + ((113.0 * X1 * 4.0) + 1.3 + (0.7906137 / (30000.0 / 148.0))) + X1)) + (399.0 * X1 * 3.0)) + (((X2 * (X1 + (113.0 * X1 * 4.0) + (X2 - 10.0))) - 10.0) + (0.7906137 / 257.0)) + 376.0)";				
//      	return evalExpression(X1, X2, exp);
//	}
//
//	private static double bc188(long X1, int X2) {
//		String exp = "X1 + (X1 - ((((X2 + ((X2 + X2 + (((((360.0 + X2 + 360.0) / (Exp(X2))) + (X2 + 28.0 + 5.0) + 360.0) / (Exp(X2))) + X2 + X2)) * 5.0) + X2) / (Exp(X2))) + X2 + X2) + X2 + X2))";				
//      	return evalExpression(X1, X2, exp);
//	}
//
//	private static double bc190(long X1, int X2) {
//		String exp = "((((5.0 + (1.1 * X1 * 10.0)) + (MyIfThenElse(93.0 >= 93.0,0.5,93.0))) + X2) + ((1.9 + ((5.0 * X1 * 93.0) + (5.0 + (1.1 * X1 * 10.0)))) + ((((5.0 * X1 * 93.0) + 183.0) + ((((5.0 * X1 * 93.0) + (1.1 * 5.0 * 5.0)) + 100.0) * X2 * 0.1)) + (5.0 * 5.0 * 5.0)))) + 100.0";				
//      	return evalExpression(X1, X2, exp);
//	}
//	
//	private static double evalExpression(long X1, int X2, String exp) {
//		double result = 0;
//					
//		parser.setExpression(exp);
//				
//		try {
//			parser.createFunc("MyIfThenElse", new IfThenElse());
//			parser.createFunc("MyIf", new IfThen());
//			//parser.setExpression("SIN");
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		
//		try {
////			parser.setX(X1);
////			parser.setY(X2);
//			parser.setVariable("X1", X1);
//			parser.setVariable("X2", X2);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//				
//		parser.setOptimizationOn(true);
//		
//		try {
//			result = parser.getValue();			
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		
//      	return result;	
//	}
}
