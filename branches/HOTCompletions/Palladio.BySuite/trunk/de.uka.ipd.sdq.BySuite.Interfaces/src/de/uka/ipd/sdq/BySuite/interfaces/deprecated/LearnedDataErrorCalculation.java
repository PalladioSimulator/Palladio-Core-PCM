package de.uka.ipd.sdq.BySuite.interfaces.deprecated;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

public class LearnedDataErrorCalculation {

	private static String csvFile = "./results/BytecodeCounts.all.csv";
	
	public static void main(String[] args) {
		LearnedDataErrorCalculation lerr = new LearnedDataErrorCalculation();
		System.out.println("error for 6: " + lerr.calculateErrorForOneFileAllBytecodes(1));
	}
	
	//number of columns the bytecode appears in a column at the right
	private int bytecodeNumerOfSet = 3;	
	
	private PalladioFileShareLearnedBytecode learnedBytecode;
	
	private CSVReader reader;
	
	public LearnedDataErrorCalculation() {
		reInit();
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
		for(int i = 0; i < PalladioFileShareLearnedBytecode.LEARNED_BYTECODES.length; i++) {

			reInit();
			
			learnedResult = 
				learnedBytecode.getLearnedData(
						getCell(rowNumber, 1),
						getCell(rowNumber, 2),
						PalladioFileShareLearnedBytecode.LEARNED_BYTECODES[i]
					);
			
			measuredResult = getCell(rowNumber,
					bytecodeNumerOfSet + PalladioFileShareLearnedBytecode.LEARNED_BYTECODES[i]);
			
			System.out.println(learnedResult + " " + measuredResult);
			
			error += Math.abs(learnedResult - measuredResult);
		}
		return error;
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
	
	private String getCell_String(int row, int column) {

		try {
			reader = new CSVReader(new FileReader(csvFile), ';');
		
			String [] nextLine;
			int currentLine = 0;
			while ((nextLine = reader.readNext()) != null) {
	
				if(currentLine == row) {
					return nextLine[column];
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
	
	/**
	 * @param rowNumber  row of the file entry (0 row is heading)
	 * @param bytecode
	 * @return
	 */
	public double getLearnedData(int rowNumber, int bytecode) {
		reInit();
		return
			learnedBytecode.getLearnedData(
					getCell(rowNumber, 1),
					getCell(rowNumber, 2),
					bytecode
				);
	}
	
	/**
	 * @param rowNumber  row of the file entry (0 row is heading)
	 * @param bytecode
	 * @return
	 */
	public double getMeasuredData(int rowNumber, int bytecode) {
		reInit();
		return
			getCell(rowNumber, bytecodeNumerOfSet + bytecode);
	}
	
	/**
	 * @param rowNumber  row of the file entry (0 row is heading)
	 * @param bytecode
	 * @return
	 */
	public String getMeasuredData_String(int rowNumber, int bytecode) {
		reInit();
		return
			getCell_String(rowNumber, bytecodeNumerOfSet + bytecode);
	}
	
	private void reInit() {
		learnedBytecode = new PalladioFileShareLearnedBytecode();
	}
}
