package learnedbytecode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

public class LearnedDataErrorCalculation {

	private static String csvFile = "learningInputData/Bytecounts.all.csv";
	//number of columns the bytecode appears in a column at the right
	private int bytecodeNumerOfSet = 3;
	
	private CSVReader reader;	
	private LearnedBytecode learnedBytecode;
	
	public LearnedDataErrorCalculation() {
		reInit();
	}
	
	public static void main(String[] args) {
		LearnedDataErrorCalculation lerr = new LearnedDataErrorCalculation();
		System.out.println("error for 6: " + lerr.calculateErrorForOneFileAllBytecodes(1));
	}
	
	/**
	 * 
	 * @param rowNumber row of the file entry (0 row is heading) 
	 * @return
	 */
	public long calculateErrorForOneFileAllBytecodes(int rowNumber) {
		long error = 0;
		
		double learnedResult;
		double measuredResult;
		for(int i = 0; i < LearnedBytecode.LEARNED_BYTECODES.length; i++) {

			reInit();
			
			learnedResult = 
				learnedBytecode.getLearnedData(
						getCell(rowNumber, 1),
						getCell(rowNumber, 2),
						LearnedBytecode.LEARNED_BYTECODES[i]
					);
			
			measuredResult = getCell(rowNumber,
					bytecodeNumerOfSet + LearnedBytecode.LEARNED_BYTECODES[i]);
			
			System.out.println(learnedResult + " " + measuredResult);
			
			error += Math.abs(learnedResult - measuredResult);
		}
		return error;
	}
	
	public double getLearnedData(int rowNumber, int bytecode) {
		return
			learnedBytecode.getLearnedData(
					getCell(rowNumber, 1),
					getCell(rowNumber, 2),
					bytecode
				);
	}
	
	public double getMeasuredData(int rowNumber, int bytecode) {
		return
			getCell(rowNumber, bytecodeNumerOfSet + bytecode);
	}
	
	private void reInit() {
		learnedBytecode = new LearnedBytecode();
	}
	
	private int getCell(int row, int column) {

		try {
			reader = new CSVReader(new FileReader(csvFile), ';');
		
			String [] nextLine;
			int currentLine = 0;
			while ((nextLine = reader.readNext()) != null) {
	
				if(currentLine == row) {
					return Integer.parseInt(nextLine[column]);
				}
			        
			    currentLine++;
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		throw new RuntimeException("should not happen. Row / Column not found");
	}
}
