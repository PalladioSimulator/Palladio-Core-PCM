package de.uka.ipd.sdq.BySuite.helper.benchmarkedbytecode;

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
			{101,102,103,104,105, 106,107,108,109,110, 111,112,113,114, }, //KLAUS, JITTED
			{201,202,203,204,205, 206,207,208,209,210, 211,212,213,214, }  //KLAUS, UNJITTED
	    }, {
	    	{301,302,303,304,305, 306,307,308,309,310, 311,312,313,314, }, //MICHAEL LENOVO, JITTED
	    	{401,402,403,404,405, 406,407,408,409,410, 411,412,413,414, }  //MICHAEL LENOVO, UNJITTED
	    }, {
	    	{501,502,503,504,505, 506,507,508,509,510, 511,512,513,514, }, //MICHAEL TOSHIBA, JITTED
	    	{601,602,603,604,605, 606,607,608,609,610, 611,612,613,614, }  //MICHAEL TOSHIBA, UNJITTED
	    }};
	
	@SuppressWarnings("unused")
	private static String[] opcodeNames = new String[]{
		"AALOAD",
		"ALOAD",
		"ARRAYLENGTH",
		"ASTORE",
		"BALOAD",
		
		"ICONST_0",
		"ICONST_1",
		"ICONST_M1",
		"IF_ICMPLT",
		"IF_ICMPNE",
		
		"IINC",
		"ILOAD",
		"NEWARRAY",
		"SIPUSH"
	};
	
	@SuppressWarnings("unused")
	private static int[] opcodeIndexes = new int[]{
		50,
		25,
		190,
		58,
		51,
		
		3,
		4,
		2,
		161,
		160,
		
		132,
		21,
		188,
		17
	};
	
	public static final int IS_JITTED = 0;
	
	public static final int IS_NOT_JITTED = 1;
	
	public static final int KLAUS_ACER = 0;
	
	public static final int MICHAEL_LENOVO = 1;
	
	public static final int MICHAEL_TOSHIBA = 2;
	
	public double getBenchmarkedData(
			int platformindex, 
			int isJitted, 
			int opcode //TODO: generalise towards bytecode instruction or method
			) {
		switch (opcode) {
			case 50:   	return benchmarkResults[platformindex][isJitted][0];
			case 25:   	return benchmarkResults[platformindex][isJitted][1];
			case 190:	return benchmarkResults[platformindex][isJitted][2];
			case 58:  	return benchmarkResults[platformindex][isJitted][3];
			case 51:	return benchmarkResults[platformindex][isJitted][4];
			
			case 3:		return benchmarkResults[platformindex][isJitted][5];
			case 4:		return benchmarkResults[platformindex][isJitted][6];
			case 2:		return benchmarkResults[platformindex][isJitted][7];
			case 161:	return benchmarkResults[platformindex][isJitted][8];
			case 160:	return benchmarkResults[platformindex][isJitted][9];
			
			case 132:	return benchmarkResults[platformindex][isJitted][10];
			case 21:	return benchmarkResults[platformindex][isJitted][11];
			case 188:	return benchmarkResults[platformindex][isJitted][12];
			case 17:	return benchmarkResults[platformindex][isJitted][13];
			default: 	System.out.print("!!!: opcode "+opcode+" not supported!");
		}
				
		// no function learned:
		System.err.println("!!!: opcode "+opcode+" not supported!");
		return -1;
	}
	
	public static void main(String[] args) {
		BenchmarkedBytecode bb = new BenchmarkedBytecode();
		testPrint(bb);
		bb.readBenchmarkResultsFromFile(MICHAEL_LENOVO,IS_NOT_JITTED);		
		testPrint(bb);
		bb.readBenchmarkResultsFromFile(MICHAEL_TOSHIBA,IS_NOT_JITTED);
		testPrint(bb);
	}

	private static void testPrint(BenchmarkedBytecode bb) {
		System.out.println("KLAUS_ACER,      IS_JITTED,		2:"+ bb.getBenchmarkedData(KLAUS_ACER,      IS_JITTED,		2) );
		System.out.println("KLAUS_ACER,      IS_JITTED,		4:"+ bb.getBenchmarkedData(KLAUS_ACER,		IS_JITTED, 		4) );
		System.out.println("KLAUS_ACER,      IS_NOT_JITTED,	2:"+ bb.getBenchmarkedData(KLAUS_ACER,      IS_NOT_JITTED,	2) );
		System.out.println("KLAUS_ACER,      IS_NOT_JITTED,	4:"+ bb.getBenchmarkedData(KLAUS_ACER,		IS_NOT_JITTED,	4) );
		System.out.println("MICHAEL_LENOVO,  IS_JITTED,		2:"+ bb.getBenchmarkedData(MICHAEL_LENOVO,	IS_JITTED,		2) );
		System.out.println("MICHAEL_LENOVO,  IS_JITTED,		4:"+ bb.getBenchmarkedData(MICHAEL_LENOVO,	IS_JITTED,		4) );
		System.out.println("MICHAEL_LENOVO,  IS_NOT_JITTED,	2:"+ bb.getBenchmarkedData(MICHAEL_LENOVO,	IS_NOT_JITTED,	2) );
		System.out.println("MICHAEL_LENOVO,  IS_NOT_JITTED,	4:"+ bb.getBenchmarkedData(MICHAEL_LENOVO,	IS_NOT_JITTED,	4) );
		System.out.println("MICHAEL_TOSHIBA, IS_JITTED,		2:"+ bb.getBenchmarkedData(MICHAEL_TOSHIBA,	IS_JITTED,		2) );
		System.out.println("MICHAEL_TOSHIBA, IS_JITTED,		4:"+ bb.getBenchmarkedData(MICHAEL_TOSHIBA,	IS_JITTED,		4) );
		System.out.println("MICHAEL_TOSHIBA, IS_NOT_JITTED,	2:"+ bb.getBenchmarkedData(MICHAEL_TOSHIBA,	IS_NOT_JITTED,	2) );
		System.out.println("MICHAEL_TOSHIBA, IS_NOT_JITTED,	4:"+ bb.getBenchmarkedData(MICHAEL_TOSHIBA,	IS_NOT_JITTED,	4) );
	}
	
	CSVReader reader;
	
	public BenchmarkedBytecode(int platformID, int isJitted) {
		super();
		this.readBenchmarkResultsFromFile(platformID, isJitted);
		System.out.println("BenchmarkedBytecode initialised with values " +
				"for platformID "+platformID+" and isJitted "+isJitted);
	}
	
	public BenchmarkedBytecode() {
		super();
		System.out.println("BenchmarkedBytecode with fake values inited");
	}
	
	/** TODO test decimalseparation...
	 * @param platformID
	 * @param isJitted
	 */
	public void readBenchmarkResultsFromFile(int platformID, int isJitted) {
		String csvPath = "./results/";
		if(platformID==KLAUS_ACER){
			csvPath+="BytecodeBenchmarkComputedResults.learned_only.KK.Acer.nonEclipse.Sun1.6.-server.-Xint.csv";
		}else if(platformID==MICHAEL_LENOVO){
			csvPath+="BytecodeBenchmarkComputedResults.learned_only.MK.Lenovo.nonEclipse.Sun1.6.-server.-Xint.csv";
		}else if(platformID==MICHAEL_TOSHIBA){
			csvPath+="BytecodeBenchmarkComputedResults.learned_only.MK.Toshiba.nonEclipse.Sun1.5.-server.-Xint.csv";
		}
		
		//TODO check parameters, rewrite generically
		try {
			reader = new CSVReader(new FileReader(csvPath),';'/*separation char*/);
		
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
				System.out.println(
						"Opcode "+currInstructionName+" " +
						"(opcode number "+currInstructionOpcode+"): " +
						""+currInstructionDuration+"ns duration");
			    currLineNr++;
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
