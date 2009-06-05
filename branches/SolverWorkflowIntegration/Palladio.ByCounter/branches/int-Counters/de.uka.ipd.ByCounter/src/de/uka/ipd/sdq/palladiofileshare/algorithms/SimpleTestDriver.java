package de.uka.ipd.sdq.palladiofileshare.algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SimpleTestDriver {

	private static Logger l;

	private static final String[] uploadFiles = { 
			"large.jpg", 	// index 0 	size 11.944.339
			"large.zip", 	// index 1 	size 11.994.017
			"lesstiny.txt", // index 2 	size 66 //TODO document change w.r.t. PalladioFileShare
			"long.txt", 	// index 3 	size 1.933.032
			"medium.jpg", 	// index 4 	size 792.492
			"medium.txt", 	// index 5 	size 934.007
			"medium.zip", 	// index 6 	size 852.945
			"small.jpg", 	// index 7 	size 25.119
			"small.txt", 	// index 8 	size 33.273
			"small.zip", 	// index 9 	size 40.931
			"superlong.txt",// index 10 size 9.665.311
			"tiny.txt", 	// index 11 size 33
	};

	// needs to terminate with a "/"
	private static final String uploadFilesLocation = "input/testFiles/";

	private static final int RUN_VERSION = 0;

	/**
	 * TODO perform warmup: 16000x with small byte arrays and monitor JIT
	 * compilation TODO use MessageDigest(<cheapesttype>) in a ByteArrayHashMap
	 * TODO profile existing application w.r.t. firstIndexOf for middle-sized
	 * problems (100KB) TODO learn on existing small inputs, then generate even
	 * more middle-sized inputs TODO compare with the performance of existing
	 * 7ZIP java implementation
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// assumption: classes have already been instrumented...
		new SimpleTestDriver().runAll(args);
	}

	public SimpleTestDriver() {
		PropertyConfigurator.configure("log4j.properties");
		l = Logger.getLogger(this.getClass().getCanonicalName());
		l.debug("Operation from " + (new File(".")).getAbsolutePath());
	}

	final void runCompression(Integer param) {
		FileInputStream sif = null;
		String fullFileName = uploadFilesLocation + uploadFiles[param];
		File inputFile = new File(fullFileName);
		int length = (int) inputFile.length();
		// OutputBuffer ob = null;
		l.debug("Compressing for option " + param + ", i.e. file "
				+ inputFile.getAbsolutePath() + " (size " + length + ")");
		try {
			sif = new FileInputStream(fullFileName);
			byte[] input = new byte[length];
			// byte[] result = new byte[length];
			int readLast = 0;
			int readTotally = 0;
			do {
				readLast = sif.read(input, readTotally, (length - readTotally));
				readTotally += readLast;
			} while (readLast > 0);

			long start = System.nanoTime();
			int[] byteStatistics = new int[256];
			Arrays.fill(byteStatistics, 0);
			for (int i = 0; i < input.length; i++) {
				byteStatistics[input[i] + 128]++;
			}
			int total = 0;
			for (int i = 0; i < byteStatistics.length; i++) {
				System.out.print(byteStatistics[i] + "+");
				total += byteStatistics[i];
			}
			System.out.println("=" + total);
			long finish = System.nanoTime();
			l.debug((finish - start) + " ns to compute statistics");

			sif.close(); // release resources
			byte[] compressed;
			if (RUN_VERSION==0) {
				System.out.println("REMOVE THIS Running version "+RUN_VERSION);
				start = System.nanoTime();
				// TODO can be null if early exit... -> take int case!
				compressed = SimpleLZW.lzwcompress_inlined(input,
						1024/*TODO document 256 * 256*/);
				// ob = Compress.performAction(input, length, Compress.COMPRESS,
				// result);
				finish = System.nanoTime();

			} else if (RUN_VERSION==1) {
				start = System.nanoTime();
				// TODO can be null if early exit... -> take int case!
				compressed = SimpleLZW.lzwcompress_final_commentless(input,
						256 * 256);
				// ob = Compress.performAction(input, length, Compress.COMPRESS,
				// result);
				finish = System.nanoTime();

			} else if (RUN_VERSION==2) {
				start = System.nanoTime();
				// TODO can be null if early exit... -> take int case!
				compressed = SimpleLZW.lzwcompress(input, 256 * 256, 0);
				// ob = Compress.performAction(input, length, Compress.COMPRESS,
				// result);
				finish = System.nanoTime();
			}
			long nsDuration = finish - start;
			long usDuration = nsDuration / 1000;
			long msDuration = usDuration / 1000;

			l.debug(nsDuration + " ns=" + usDuration + " us=" + msDuration
					+ " ms to compress " + length + " bytes to "
					+ compressed.length + " bytes (i.e., " + compressed.length
					/ 2 + " chars)");

		} catch (IOException e) {
			l.error(e);
		}

	}

	final void runAll(String[] args) {
		SimpleLZW.INLINED_VERBOSE = false;
		this.runWarmup();
		SimpleLZW.INLINED_VERBOSE = true;
		if (args != null && args.length == 1) {
			Integer param = new Integer(args[0]);
			if (param >= 0 && param < uploadFiles.length) {
				this.runCompression(param);
			} else {
				l.error("Parameter out of range: " + param
						+ " (should be between 0 and 10)");
			}
		} else {
			int hardcodedCase = 0;
			l.error("Requires exactly one parameter to describe the input data, "
							+ "choosing hard-coded case " + hardcodedCase);
			@SuppressWarnings("unused")
			Random rd = new Random();
			this.runCompression(hardcodedCase); // rd.nextInt(uploadFiles.length));
		}
	}

	final void runWarmup() {
		//TODO diversify according to RUN_VERSION, switch 
		
		int nrOfWarmups = 16400;
		int inputSize = 40;
		int randomInputPoolSize = 41; // 1/400 of nrOfWarmups... -> 2.5
										// promille
		int finalSum = 0;

		byte[] randomInput;
		byte[][] randomInputPool = new byte[randomInputPoolSize][inputSize];
		Random rd = new Random();

		for (int i = 0; i < randomInputPool.length; i++) {
			rd.nextBytes(randomInputPool[i]);
		}
		for (int i = 0; i < nrOfWarmups; i++) {
			randomInput = randomInputPool[rd.nextInt(randomInputPoolSize)];
//			finalSum += SimpleLZW.lzwcompress(randomInput, 256 * 256, 0).length;
			finalSum += SimpleLZW.lzwcompress_inlined(randomInput, 256 * 256).length;
		}
		System.out.println("Final sum in warmup: " + finalSum);
	}
}
