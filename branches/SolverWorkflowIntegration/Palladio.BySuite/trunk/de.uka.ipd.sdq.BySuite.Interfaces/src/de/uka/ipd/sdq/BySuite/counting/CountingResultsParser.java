package de.uka.ipd.sdq.BySuite.counting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import de.uka.ipd.sdq.BySuite.utils.CountingResult;

public class CountingResultsParser {
	
	public static void main(String[] args){
		CountingResultsParser crp = new CountingResultsParser();
		crp.testDeserialisation();
	}
	
	public void testDeserialisation(){
		File currDir = new File(".");
		File currSCResultFile;
		String[] currDirContents = currDir.list();
		for (int i = 0; i < currDirContents.length; i++) {
			if(currDirContents[i].endsWith(".SCResult")){
				currSCResultFile = new File(currDirContents[i]);
				if(currSCResultFile.isFile()){
					FileInputStream fis;
					ObjectInputStream ois;
					try {
						fis = new FileInputStream(currDirContents[i]);
						ois = new ObjectInputStream(fis);
						CountingResult result = (CountingResult) ois.readObject();
						System.out.println("Data parsed from serialised" +
								"CountingResult instance from file " +
								currDirContents[i]+": ID="+result.getID()+", "+
								"invocation start="+result.getMethodInvocationBeginning()+", "+
								"method reporting time="+result.getMethodReportingTime()+", "+
								"qualifying method name="+result.getQualifyingMethodName()+".");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
