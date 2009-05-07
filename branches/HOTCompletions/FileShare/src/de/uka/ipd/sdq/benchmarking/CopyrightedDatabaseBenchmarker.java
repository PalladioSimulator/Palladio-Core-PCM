package de.uka.ipd.sdq.benchmarking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import de.uka.ipd.sdq.palladiofileshare.algorithms.Hash;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.CopyrightedMaterialDatabase;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.util.Util;

/**
 * @author Michael
 * @deprecated because CSV file names and functionality unchecked
 */
public class CopyrightedDatabaseBenchmarker {
	/**
	 * @deprecated because CSV file names and functionality unchecked
	 * @param args
	 */
	public static void main(String args[]){
		CopyrightedDatabaseBenchmarker cmdm = new CopyrightedDatabaseBenchmarker();
		cmdm.isCopyrightedMaterial_measure(20, false, 25000, 350000, 400);
	}
	
	CopyrightedMaterialDatabase cmd;
	ArrayList<byte[]> datasets;
	int[] indexesOfChosenDatasets;
	long[] measurements;
	Hash ourHasher;
	Random rd;
	
	/**
	 * @deprecated because CSV file names and functionality unchecked
	 */
	public CopyrightedDatabaseBenchmarker(){
		//TODO
	}
	
	/**
	 * @deprecated because CSV file names and functionality unchecked
	 * @param nrOfRandomDatasets
	 * @param constantRandomDatasetSize
	 * @param initialRandomDatasetSize
	 * @param maximumRandomDatasetSizeIfVariableSize
	 * @param nrOfMeasurements
	 * @return
	 */
	public long[] isCopyrightedMaterial_measure(
			int nrOfRandomDatasets, 
			boolean constantRandomDatasetSize,
			int initialRandomDatasetSize, //TODO needs a list...
			int maximumRandomDatasetSizeIfVariableSize,
			int nrOfMeasurements){
		cmd = CopyrightedMaterialDatabase.getSingleton();
		datasets = new ArrayList<byte[]>();
		datasets = Util.initialiseRandomPrimitiveByteArrays(
				nrOfRandomDatasets, 
				constantRandomDatasetSize,
				initialRandomDatasetSize,
				maximumRandomDatasetSizeIfVariableSize);
		ourHasher = new Hash();
		measurements = new long[nrOfMeasurements];
		indexesOfChosenDatasets = new int[nrOfMeasurements];
		rd = new Random();
		byte[] currDataset = null;
		byte[] currHash = null;
		boolean[] results = new boolean[nrOfMeasurements];
		long start;
		long stop;
		long runningSum = 0L;
		int positiveReturns = 0;
		for(int i=0; i<nrOfMeasurements; i++){
			currDataset = datasets.get(rd.nextInt(nrOfRandomDatasets));
			currHash = ourHasher.getMessageDigest(currDataset);
			
			start = System.nanoTime();
			results[i] = cmd.isCopyrightedMaterial(currHash);
			stop = System.nanoTime();

			if(results[i]) positiveReturns++;
			measurements[i] = stop-start;
			runningSum +=measurements[i]; //Annahme: kein Überlauf
		}
		Arrays.sort(measurements);
		long[] summary = new long[]{measurements[0],
				measurements[measurements.length/2-1],
				runningSum/nrOfMeasurements,
				measurements[measurements.length-1]};
		int realMaximumRandomDatasetSize = initialRandomDatasetSize;
		if(!constantRandomDatasetSize){
			realMaximumRandomDatasetSize = maximumRandomDatasetSizeIfVariableSize; 
		}
		System.out.println("Results of benchmarking "+
				nrOfMeasurements+" \"is-copyrighted\" requests on "+
				"randomly chosen byte arrays from a pool of size "+
				nrOfRandomDatasets+" (where the size of entries in the pool " +
				"varies from "+initialRandomDatasetSize+" to "+
				realMaximumRandomDatasetSize+"): "+
				"minimum: "+summary[0]+", "+
				"median: "+summary[1]+", "+
				"mean: "+summary[2]+", "+
				"maximum: "+summary[3]+" " +
				"(positive returns: "+positiveReturns+").");
		return summary;
	}
}

