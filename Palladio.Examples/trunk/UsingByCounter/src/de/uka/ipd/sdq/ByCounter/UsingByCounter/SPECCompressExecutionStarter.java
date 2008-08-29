/**
 * 
 */
package de.uka.ipd.sdq.ByCounter.SPECevaluation;

import java.sql.Timestamp;
import java.util.Collections;

import spec.benchmarks.compress.Harness;
import spec.benchmarks.compress.Main;
import spec.benchmarks.compress.Compress;

/**
 * @author Michael
 *
 */
public class SPECCompressExecutionStarter {
	
	private static int DEFAULT_FILE_INDEX = 39;
	public static final int DEFAULT_NUMBER_OF_MEASUREMENTS = 100;
	private int numberOfMeasurements;

	/**
	 * 
	 */
	public SPECCompressExecutionStarter() {
		numberOfMeasurements = DEFAULT_NUMBER_OF_MEASUREMENTS;//TODO
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SPECCompressExecutionStarter sces = new SPECCompressExecutionStarter();
		sces.start(DEFAULT_FILE_INDEX);

	}
	public void start(int fileIndex) {
		Harness.setFileIndex(fileIndex);
		Compress.lastResults.clear();
		int tencentile = numberOfMeasurements/10;
		if(numberOfMeasurements%10 != 0){
			System.out.println("Last tencentile contains "+
					numberOfMeasurements%10+" measurements more than others");
		}
		System.out.println("File index: "+fileIndex+", " +
				"nr of measurements: "+numberOfMeasurements);
		for(int i=0; i<numberOfMeasurements; i++){
			if(i%tencentile==0){
				System.out.println("Starting "+((i/tencentile)+1)+"st " +
						"tencentile at "+new Timestamp(System.currentTimeMillis()));
				Collections.sort(Compress.lastResults);
				int currResultsSize = Compress.lastResults.size();
				System.out.println("So far: "+currResultsSize+" results:");
				if(Compress.lastResults.size()>0){
					System.out.println("Min: "+Compress.lastResults.get(0));
					System.out.println("Med: "+Compress.lastResults.get(currResultsSize/2));
					System.out.println("Max: "+Compress.lastResults.get(currResultsSize-1));
				}
			}
			try{
				Main.main(new String[]{});
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		Collections.sort(Compress.lastResults);
		System.out.println("\n==================\nFinal results:");
		System.out.println("File index: "+fileIndex+", " +
				"nr of measurements: "+numberOfMeasurements);
		System.out.println("Min: "+Compress.lastResults.get(0));
		System.out.println("Med: "+Compress.lastResults.get(numberOfMeasurements/2));
		System.out.println("Max: "+Compress.lastResults.get(numberOfMeasurements-1));
		System.out.println("Compressed file size: "+Harness.getLastOutputSize());
		
	}

}
