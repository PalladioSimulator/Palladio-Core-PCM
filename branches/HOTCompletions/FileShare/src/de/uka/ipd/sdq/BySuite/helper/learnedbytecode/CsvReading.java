package de.uka.ipd.sdq.BySuite.helper.learnedbytecode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader; //from http://opencsv.sourceforge.net/

/** Example for Michael
 * @author Michael
 *
 */
public class CsvReading {
	CSVReader reader;

	public void doSth() {
		try {
			reader = new CSVReader(new FileReader("learningInputData/Bytecounts.all.csv"), ';');
		
			// skip first line:
			reader.readNext();
			
			String [] nextLine;
			int currentLine = 0;
			while ((nextLine = reader.readNext()) != null) {
	
				// nextLine[] is an array of values from the line
			    System.out.println("C1: " + nextLine[1] + " " +
			    		"C2: " + nextLine[2] + " " +
			    		"C3: " + nextLine[3] + " " 
			    	);
			        
			    currentLine++;
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
