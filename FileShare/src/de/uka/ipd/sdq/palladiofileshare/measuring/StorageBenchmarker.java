package de.uka.ipd.sdq.palladiofileshare.measuring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.IStorage;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.Storage;

/** Benchmark simple fileStoring as if no JIT is there.
 * 
 * @author Michael
 *
 */
public class StorageBenchmarker {
	
	public static void main(String args[]){
		StorageBenchmarker sb = new StorageBenchmarker();
		sb.run();
	}
	
	byte[] currFileHash;
	List<Long> currMeasurementsList;
	int nrOfFilesizeIncreaseSteps;
	int nrOfMeasurementsPerFilesize;
	Random rd;
	List<Long> resultsList;
	long start;
	int startingFileSize;
	long stop;
	IStorage storage;
	boolean varyFilesize;
	int widthOfFilesizeIncreaseStep;

	public StorageBenchmarker() {
		super();
		this.currMeasurementsList = new ArrayList<Long>();
		this.nrOfFilesizeIncreaseSteps = 20;
		this.nrOfMeasurementsPerFilesize = 100;
		this.rd = new Random();
		this.resultsList = new ArrayList<Long>();
		this.startingFileSize = 10000;
		this.storage = new Storage();
		this.varyFilesize = true;
		this.widthOfFilesizeIncreaseStep = 2500;
	}

	private void run() {
		if(!varyFilesize) nrOfFilesizeIncreaseSteps = 0;
		int currFilesize;
		int currFileIndex;
		byte[][] randomByteArrays = new byte[5][];
		for(int i=0; i<= nrOfFilesizeIncreaseSteps; i++){
			currFilesize = startingFileSize+i*widthOfFilesizeIncreaseStep;
			for(int j=0; j<randomByteArrays.length; j++){
				randomByteArrays[j] = new byte[currFilesize];
				rd.nextBytes(randomByteArrays[j]);
			}
			currMeasurementsList = new ArrayList<Long>();
			for(int k=0; k<nrOfMeasurementsPerFilesize; k++){
				currFileIndex = rd.nextInt(randomByteArrays.length);
				currFileHash = new byte[20];
				rd.nextBytes(currFileHash);
				start = System.nanoTime();
				storage.storeFile(randomByteArrays[currFileIndex], currFileHash);
				stop = System.nanoTime();
				currMeasurementsList.add(stop-start);
			}
			Collections.sort(currMeasurementsList);
			long result = currMeasurementsList.get(currMeasurementsList.size()/2-1);
			resultsList.add(result);
			System.out.println(result+" ns: filesize "+currFilesize);
		}
	}
}
