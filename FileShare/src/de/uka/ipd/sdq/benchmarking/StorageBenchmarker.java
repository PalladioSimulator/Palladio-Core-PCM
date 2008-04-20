package de.uka.ipd.sdq.benchmarking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.IStorage;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.Storage;

/** Benchmark simple fileStoring as if no JIT is there.
 * 
 * @author Michael
 * @deprecated because CSV file names and functionality unchecked
 */
public class StorageBenchmarker {
	
	/**
	 * @deprecated because CSV file names and functionality unchecked
	 * @param args
	 */
	public static void main(String args[]){
		StorageBenchmarker sb = new StorageBenchmarker();
		sb.run();
	}
	
	long nrOfBytesToBeWritten;
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

	/**
	 * @deprecated because CSV file names and functionality unchecked
	 */
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
		
		if(varyFilesize){
			nrOfBytesToBeWritten = (startingFileSize+
				(nrOfFilesizeIncreaseSteps*widthOfFilesizeIncreaseStep))*
				nrOfFilesizeIncreaseSteps/2*nrOfMeasurementsPerFilesize;
		} else {
			nrOfBytesToBeWritten = startingFileSize*
				nrOfMeasurementsPerFilesize;
		}
		File f = new File(".");
		System.out.println(nrOfBytesToBeWritten+
				" bytes to be written, "+
				nrOfMeasurementsPerFilesize+
				" measurements per filesize, etc. - "+
				f.getFreeSpace() + " free space");
		if(nrOfBytesToBeWritten > f.getFreeSpace()/2){
			System.out.println("Writing would occupy more than 50% of " +
					"free disk space, aborting..."); 
			return;
		}
	}

	/**
	 * @deprecated because CSV file names and functionality unchecked
	 */
	private void run() {
		if(!varyFilesize) nrOfFilesizeIncreaseSteps = 0;
		int currFilesize;
		int currFileIndex;
		byte[][] randomByteArrays = new byte[5][];
		StringBuffer titleCSVline = new StringBuffer();
		StringBuffer medianCSVline = new StringBuffer();
		StringBuffer minimumCSVline = new StringBuffer();
		for(int i=0; i<= nrOfFilesizeIncreaseSteps; i++){
			currFilesize = startingFileSize+i*widthOfFilesizeIncreaseStep;
			for(int j=0; j<randomByteArrays.length; j++){
				randomByteArrays[j] = new byte[currFilesize];
				rd.nextBytes(randomByteArrays[j]);
			}
			currMeasurementsList = new ArrayList<Long>(nrOfMeasurementsPerFilesize);
			for(int k=0; k<nrOfMeasurementsPerFilesize; k++){
				currFileIndex = rd.nextInt(randomByteArrays.length);
				currFileHash = new byte[20];
				rd.nextBytes(currFileHash);
				start = System.nanoTime();
				storage.storeFile(randomByteArrays[currFileIndex], currFileHash, true);
				stop = System.nanoTime();
				currMeasurementsList.add(stop-start);
			}
			Collections.sort(currMeasurementsList);
			long result = currMeasurementsList.get(currMeasurementsList.size()/2);
			resultsList.add(result);
			System.out.println(result+" ns: filesize "+currFilesize);
			titleCSVline.append(currFilesize+";");
			medianCSVline.append(result+";");
			minimumCSVline.append(currMeasurementsList.get(0)+";");
		}
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("./results/"+
					this.getClass().getName()+
					"."+System.nanoTime()+".csv");
			fos.write(("Sizes;"+titleCSVline.toString()+"\n").getBytes());
			fos.write(("Medians;"+medianCSVline.toString()+"\n").getBytes());
			fos.write(("Mins;"+minimumCSVline.toString()+"\n").getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
