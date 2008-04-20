package de.uka.ipd.sdq.benchmarking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import de.uka.ipd.sdq.palladiofileshare.algorithms.Hash;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.ExistingFilesDatabase;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.util.Util;

/**
 * @author Michael
 * @deprecated because CSV file names and functionality unchecked
 */
public class ExistingDatabaseBenchmarker {
	/**
	 * @deprecated because CSV file names and functionality unchecked
	 * @param args
	 */
	public static void main(String args[]){
		ExistingDatabaseBenchmarker cmdm = new ExistingDatabaseBenchmarker();
		cmdm.addNewFileHash_measure(20, false, 25000, 350000, 400);
		cmdm.existsInDatabase_measure(20, false, 25000, 350000, 400);
	}
	
	ArrayList<byte[]> datasets;
	ExistingFilesDatabase efd;
	int[] indexesOfChosenDatasets;
	long[] measurements;
	Hash ourHasher;
	Random rd;
	
	/**
	 * @deprecated because CSV file names and functionality unchecked
	 */
	public ExistingDatabaseBenchmarker(){
		//TODO
	}
	
	/**
	 * @deprecated because CSV file names and functionality unchecked
	 * @param nrOfRandomDatasets
	 * @param constantRandomDatasetSize
	 * @param initialRandomDatasetSize
	 * @param maximumRandomDatasetSizeIfVariableSize
	 * @param nrOfAdditions
	 * @return
	 */
	public long[] addNewFileHash_measure(
			int nrOfRandomDatasets, 
			boolean constantRandomDatasetSize,
			int initialRandomDatasetSize, //TODO needs a list...
			int maximumRandomDatasetSizeIfVariableSize,
			int nrOfAdditions){
		efd = ExistingFilesDatabase.getSingleton();
		datasets = new ArrayList<byte[]>();
		datasets = Util.initialiseRandomPrimitiveByteArrays(
				nrOfRandomDatasets, 
				constantRandomDatasetSize,
				initialRandomDatasetSize,
				maximumRandomDatasetSizeIfVariableSize);
		ourHasher = new Hash();
		measurements = new long[nrOfAdditions];
		indexesOfChosenDatasets = new int[nrOfAdditions];
		rd = new Random();
		byte[] currDataset = null;
		byte[] currHash = null;
		boolean[] results = new boolean[nrOfAdditions];
		long start;
		long stop;
		long runningSum = 0L;
		int positiveReturns = 0;
		for(int i=0; i<nrOfAdditions; i++){
			currDataset = datasets.get(rd.nextInt(nrOfRandomDatasets));
			currHash = ourHasher.getMessageDigest(currDataset);
			
			start = System.nanoTime();
			results[i] = efd.addNewFileHash(currHash);
			stop = System.nanoTime();

			if(results[i]) positiveReturns++;
			measurements[i] = stop-start;
			runningSum +=measurements[i]; //Annahme: kein Überlauf
		}
		Arrays.sort(measurements);
		long[] summary = new long[]{measurements[0],
				measurements[measurements.length/2-1],
				runningSum/nrOfAdditions,
				measurements[measurements.length-1]};
		int realMaximumRandomDatasetSize = initialRandomDatasetSize;
		if(!constantRandomDatasetSize){
			realMaximumRandomDatasetSize = maximumRandomDatasetSizeIfVariableSize; 
		}
		System.out.println("Results of benchmarking "+
				nrOfAdditions+" \"addNewFileHash\" requests on "+
				"randomly chosen byte arrays from a pool of size "+
				nrOfRandomDatasets+" (where the size of entries in the pool " +
				"varies from "+initialRandomDatasetSize+" to "+
				realMaximumRandomDatasetSize+"): "+
				"minimum: "+summary[0]+", "+
				"median: "+summary[1]+", "+
				"mean: "+summary[2]+", "+
				"maximum: "+summary[3]+ " "+
				"(positive returns: "+positiveReturns+").");
		return summary;
	}

	/**
	 * @deprecated because CSV file names and functionality unchecked
	 * @param nrOfRandomDatasets
	 * @param constantRandomDatasetSize
	 * @param initialRandomDatasetSize
	 * @param maximumRandomDatasetSizeIfVariableSize
	 * @param nrOfRequests
	 * @return
	 */
	public long[] existsInDatabase_measure(
			int nrOfRandomDatasets, 
			boolean constantRandomDatasetSize,
			int initialRandomDatasetSize, //TODO needs a list...
			int maximumRandomDatasetSizeIfVariableSize,
			int nrOfRequests){
		efd = ExistingFilesDatabase.getSingleton();
		datasets = new ArrayList<byte[]>();
		datasets = Util.initialiseRandomPrimitiveByteArrays(
				nrOfRandomDatasets, 
				constantRandomDatasetSize,
				initialRandomDatasetSize,
				maximumRandomDatasetSizeIfVariableSize);
		ourHasher = new Hash();
		measurements = new long[nrOfRequests];
		indexesOfChosenDatasets = new int[nrOfRequests];
		rd = new Random();
		byte[] currDataset = null;
		byte[] currHash = null;
		boolean[] results = new boolean[nrOfRequests];
		long start;
		long stop;
		long runningSum = 0L;
		int positiveReturns = 0;
		for(int i=0; i<nrOfRequests; i++){
			currDataset = datasets.get(rd.nextInt(nrOfRandomDatasets));
			currHash = ourHasher.getMessageDigest(currDataset);
			
			start = System.nanoTime();
			results[i] = efd.existsInDatabase(currHash);
			stop = System.nanoTime();

			if(results[i]) positiveReturns++;
			measurements[i] = stop-start;
			runningSum +=measurements[i]; //Annahme: kein Überlauf
		}
		Arrays.sort(measurements);
		long[] summary = new long[]{measurements[0],
				measurements[measurements.length/2-1],
				runningSum/nrOfRequests,
				measurements[measurements.length-1]};
		int realMaximumRandomDatasetSize = initialRandomDatasetSize;
		if(!constantRandomDatasetSize){
			realMaximumRandomDatasetSize = maximumRandomDatasetSizeIfVariableSize; 
		}
		System.out.println("Results of benchmarking "+
				nrOfRequests+" \"existsInDatabase\" requests on "+
				"randomly chosen byte arrays from a pool of size "+
				nrOfRandomDatasets+" (where the size of entries in the pool " +
				"varies from "+initialRandomDatasetSize+" to "+
				realMaximumRandomDatasetSize+"): "+
				"minimum: "+summary[0]+", "+
				"median: "+summary[1]+", "+
				"mean: "+summary[2]+", "+
				"maximum: "+summary[3]+"." +
				"(positive returns: "+positiveReturns+").");
		return summary;
	}

}
