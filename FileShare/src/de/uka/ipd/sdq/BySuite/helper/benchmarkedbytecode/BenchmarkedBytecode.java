package de.uka.ipd.sdq.BySuite.helper.benchmarkedbytecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
	    }, {
	    	{701,702,703,704,705, 706,707,708,709,710, 711,712,713,714, }, //SDQ LENOVO, JITTED
	    	{801,802,803,804,805, 806,807,808,809,810, 811,812,813,814, }  //SDQ LENOVO, UNJITTED
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
	
	private Map<Integer,String> opcodeToStringMapping;
	
	private Map<String, Integer> stringToOpcodeMapping;
	
	public int getOpcode(String strOpcode){
		return this.stringToOpcodeMapping.get(strOpcode);
	}
	public String getString(int opcode){
		return this.opcodeToStringMapping.get(opcode);
	}
	
	public static final int IS_JITTED = 0;
	
	public static final int IS_NOT_JITTED = 1;
	
	public static final int KLAUS_ACER = 0;
	
	public static final int MICHAEL_LENOVO = 1;
	
	public static final int MICHAEL_TOSHIBA = 2;
	
	public static final int SDQ_LENOVO = 3;
	
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
		bb.readBenchmarkResultsFromFile(KLAUS_ACER,IS_NOT_JITTED);		
		testPrint(bb);
		bb.readBenchmarkResultsFromFile(MICHAEL_LENOVO,IS_NOT_JITTED);		
		testPrint(bb);
		bb.readBenchmarkResultsFromFile(MICHAEL_TOSHIBA,IS_NOT_JITTED);
		testPrint(bb);
		bb.readBenchmarkResultsFromFile(SDQ_LENOVO,IS_NOT_JITTED);		
		testPrint(bb);
		bb.showRatios(true);
	}

	private void showRatios(boolean writeToCSV) {
		showInterOpcodeRatiosForOnePlatform(KLAUS_ACER, writeToCSV);
		showInterOpcodeRatiosForOnePlatform(MICHAEL_LENOVO, writeToCSV);
		showInterOpcodeRatiosForOnePlatform(MICHAEL_TOSHIBA, writeToCSV);
		showInterOpcodeRatiosForOnePlatform(SDQ_LENOVO, writeToCSV);
		showInterPlatformRatiosForAllOpcodes(writeToCSV);
		
	}

	private void showInterPlatformRatiosForAllOpcodes(boolean writeToCSV) {
		FileWriter fwPiece;
		String sepChar = ";";
		StringBuffer sbFirstLine = new StringBuffer();
		sbFirstLine.append("First platform"+sepChar);
		StringBuffer sbSecondLine = new StringBuffer();
		sbSecondLine.append("Second platform"+sepChar);
//		String[] platformDescriptions = new String[]{
//				"KLAUS_ACER", "MICHAEL_LENOVO", "MICHAEL_TOSHIBA", "SDQ_LENOVO"
//		};
		int nr = platformDescriptions.length;
		boolean noSelfComparison = true;
		int nrOfINdexes = nr*nr;
		if(noSelfComparison){
			nrOfINdexes = nr*(nr-1);
		}
		int[] indexesDividend = new int[nrOfINdexes];
		int[] indexesDivisor  = new int[nrOfINdexes];
		int currDivisionIndex = 0;
		for(int i=0; i<nr; i++){
			for(int j=0; j<nr; j++){
				if(noSelfComparison && i==j){//wegkommentieren zum testen
					//dunno
				}else{
					sbFirstLine.append(platformDescriptions[i]+sepChar);
					sbSecondLine.append(platformDescriptions[j]+sepChar);
					indexesDividend[currDivisionIndex] = i;
					indexesDivisor[currDivisionIndex] = j;
					currDivisionIndex++;
				}
			}
		}
		sbFirstLine.append("\n");
		sbSecondLine.append("\n");
		StringBuffer sbRemainder = new StringBuffer();
		for(int i=0; i<benchmarkResults[0][0].length; i++){
			sbRemainder.append(opcodeNames[i]+sepChar);
			for(int j=0; j<indexesDividend.length; j++){
				sbRemainder.append(
						benchmarkResults[indexesDividend[j]][IS_NOT_JITTED][i]
				        / benchmarkResults[indexesDivisor[j]][IS_NOT_JITTED][i]
				+sepChar);
			}
			sbRemainder.append("\n");
		}
		System.out.println(sbFirstLine);
		System.out.println(sbSecondLine);
		System.out.println(sbRemainder);
		try{
			fwPiece = new FileWriter(
					("."+File.separator+"results"+File.separator+
						"InterPlatformRatiosForAllOpcodes."+System.currentTimeMillis()+".csv"), 
					true);
			fwPiece.append(sbFirstLine.toString());
			fwPiece.append(sbSecondLine.toString());
			fwPiece.append(sbRemainder.toString());
			fwPiece.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static final String[] platformDescriptions = new String[]{
			"KLAUS_ACER", "MICHAEL_LENOVO", "MICHAEL_TOSHIBA", "SDQ_LENOVO"};
	
	private void showInterOpcodeRatiosForOnePlatform(
			int platformIndex,
			boolean writeToCSV) {
		String sepChar = ";";
		StringBuffer sbFirstLine = new StringBuffer();
		sbFirstLine.append(
				"first_platform"+sepChar+
				"second_platform"+sepChar+
				"ratio_first_through_second"+sepChar+"\n");
		StringBuffer sbRemainder = new StringBuffer();
		for(int i=0; i<benchmarkResults[0][0].length; i++){
			for(int j=0; j<benchmarkResults[0][0].length; j++){
				if(i!=j){
					sbRemainder.append(opcodeNames[i]+sepChar+
							opcodeNames[j]+sepChar+
							(benchmarkResults[platformIndex][IS_NOT_JITTED][i]
							/benchmarkResults[platformIndex][IS_NOT_JITTED][j])
							+sepChar+"\n");
				}
			}
		}
		System.out.println(sbFirstLine);
		System.out.println(sbRemainder);
		
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
		System.out.println("SDQ_LENOVO,      IS_JITTED,		2:"+ bb.getBenchmarkedData(SDQ_LENOVO,	IS_JITTED,		2) );
		System.out.println("SDQ_LENOVO,      IS_JITTED,		4:"+ bb.getBenchmarkedData(SDQ_LENOVO,	IS_JITTED,		4) );
		System.out.println("SDQ_LENOVO,      IS_NOT_JITTED,	2:"+ bb.getBenchmarkedData(SDQ_LENOVO,	IS_NOT_JITTED,	2) );
		System.out.println("SDQ_LENOVO,      IS_NOT_JITTED,	4:"+ bb.getBenchmarkedData(SDQ_LENOVO,	IS_NOT_JITTED,	4) );
	}
	
	CSVReader reader;
	
	public BenchmarkedBytecode(
			int platformID, 
			int isJitted) {
		this();
		this.readBenchmarkResultsFromFile(platformID, isJitted);
		System.out.println("BenchmarkedBytecode initialised with values " +
				"for platformID "+platformID+" and isJitted "+isJitted);
	}
	
	public BenchmarkedBytecode() {
		super();
		this.opcodeToStringMapping = new HashMap<Integer, String>();
		this.stringToOpcodeMapping = new HashMap<String, Integer>();
		System.out.println("BenchmarkedBytecode with fake values inited");
		for(int i=0; i<opcodeIndexes.length; i++){
			this.opcodeToStringMapping.put(opcodeIndexes[i],opcodeNames[i]);
			this.stringToOpcodeMapping.put(opcodeNames[i],opcodeIndexes[i]);
		}
	}
	
	public void ichMoechteWiederGeloeschtWerden(){
		int[] egal = new int[1];
		egal[0]=2;
		long[] nichtegal = new long[1];
		nichtegal[0]=egal[0];
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
		}else if(platformID==SDQ_LENOVO){
			csvPath+="BytecodeBenchmarkComputedResults.learned_only.SDQ.Lenovo.nonEclipse.Sun1.5.-server.-Xint.csv";
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
