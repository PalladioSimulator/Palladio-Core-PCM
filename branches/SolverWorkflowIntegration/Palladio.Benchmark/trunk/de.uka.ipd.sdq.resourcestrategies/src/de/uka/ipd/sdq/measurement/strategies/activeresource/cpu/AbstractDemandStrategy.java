package de.uka.ipd.sdq.measurement.strategies.activeresource.cpu;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum;
import de.uka.ipd.sdq.measurement.strategies.activeresource.IDemandStrategy;
import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;

public abstract class AbstractDemandStrategy implements IDemandStrategy {

	// declare & define variables
	public int high;
	public int medium;
	public int low;
	public int warmUpCycles;
	public long defaultIterationCount;

	private int accuracy;
	private double processingRate;
	private long[][] calibTable = new long[2][11];
	private String configFileName = null;
	private static Logger logger = Logger
			.getLogger(AbstractDemandStrategy.class.getName());

	private static String CONFIG_PATH = ".";
	
	// define constants
	private static final String LOGGER_CONFIG = "CPULogger.properties";
	private static final String CPU_CONFIG = "CPUConfig.properties";
	private static final int MILLION = 1000000;
	private static final int[] CALIBRATION_CYCLES = { 1024, 512, 256, 128, 64, 50, 40,
			30, 25, 20, 15, 10 };

	// class constructor
	public AbstractDemandStrategy() {
		// quick-fix for missing appenders error
		// org.apache.log4j.BasicConfigurator.configure();

		// PropertyConfigurator replaces the BasicConfigurator
		org.apache.log4j.PropertyConfigurator.configure(getLoggerConfig());
	}

	public void initializeStrategy(DegreeOfAccuracyEnum degree,
			double initProcessingRate) {
		initializeStrategy(getAccuracyValue(degree), initProcessingRate);
	}

	public void initializeStrategy(int degree, double initProcessingRate) {
		/** initialize strategy - see also interface */

		logger.info("Initialising " + getName() + " CPU strategy");

		this.accuracy = degree;
		this.processingRate = initProcessingRate;
		this.configFileName = loadCalibrationPath() + getName() + "_"
				+ calibTable[1].length + "_" + degree + ".ser";

		long[][] loadedCalibration = loadCalibration();

		if (loadedCalibration != null) {
			calibTable = loadedCalibration;
			logger.info("Loading calibration from '" + configFileName + "'");
		} else {

			for (int i = 0; i < warmUpCycles; i++)
				run(defaultIterationCount);

			logger.info("The timetable with the corresponding parameters:");
			for (int i = 0; i < calibTable[1].length; i++) {
				calibTable[0][i] = (int) Math.pow(2, i);
				calibTable[1][i] = calibrate((int) calibTable[0][i]);
				if (i > 2) { // (getName().equals("FFT") && i > 1) ||
					calibTable[0][i] = recalibrate(calibTable[1][i], i);
				}
				logger.info((int) calibTable[0][i] + " | " + calibTable[1][i]);
			}
			saveCalibration(calibTable);
			logger.info("Saving calibration to '" + configFileName + "'");
		}
		logger.info(getName() + " CPU strategy initialised");
	}

	private long calibrate(int targetTime) {
		/** returns a calibration parameter which matches the target time best */

		// approximated parameters
		long[] targetParameter = new long[2];

		// run a couple of times and calculate mean
		for (int i = 0; i < targetParameter.length; i++) {

			// calculation based on bisection method

			// input: y(x), x0, x1
			long x0 = 0, x1 = defaultIterationCount, xNew = 1;
			long yOld, yNew;
			yOld = calcRunTimeFunction(x0, targetTime);
			yNew = calcRunTimeFunction(x1, targetTime);

			// required: y(x0)*y(x1) < 0 (* => opposite sign *)
			if ((yOld > 0 && yNew > 0)) {
				logger
						.warn("PROBLEM: y(x0) > 0 && y(x1) > 0 => special algorithm"
								+ " without monotonically increasing load !?!");
				targetParameter[i] = yNew > yOld ? x0 : x1; // dummy assignments
			} else {
				if (yOld < 0 && yNew < 0) {
					int z = 0;
					// find suitable parameter x1 so that y(x1) > 0
					do {
						x1 = x1 + defaultIterationCount * (long) Math.pow(2, z);
						defaultIterationCount = x1;
						z++;
					} while (calcRunTimeFunction(x1, targetTime) < MILLION);
				}

				// run the algorithm
				while (Math.abs(x1 - x0) > 1) {
					xNew = (x0 + x1) / 2;
					yNew = calcRunTimeFunction(xNew, targetTime);
					if (yOld * yNew > 0) {
						x0 = xNew;
						yOld = yNew;
					} else {
						x1 = xNew;
					}
				}
				targetParameter[i] = xNew;
			}
		}
		return mean(targetParameter);
	}

	private long recalibrate(long parameter, int ind) {
		int cycles = CALIBRATION_CYCLES[ind];
		return getRunTime(parameter, cycles) / MILLION;
	}

	private long calcRunTimeFunction(long parameter, int targetTime) {
		int cycles = getCalibrationCycles(accuracy + 8, targetTime);
		// generate zero where the target parameter is supposed to be found
		return getRunTime(parameter, cycles) - targetTime * MILLION;
	}

	private long getRunTime(long parameter, int cycles) {
		/** returns mean algorithm run time depending on the parameter */

		// measured run times in nanoseconds
		long[] approximation = new long[cycles];
		
		for (int i = 0; i < approximation.length; i++) {
			long start = System.nanoTime();
			run(parameter);
			approximation[i] = (System.nanoTime() - start);
		}
		return mean(approximation);
	}

	private long mean(long[] p) {
		/** calculates mean value */

		long sum = 0; // sum of all the elements
		Arrays.sort(p);
		int start = p.length > 5 ? p.length / 5 : 0;
		for (int i = start; i < p.length - start; i++) {
			sum += p[i];
		}

		return sum / (p.length - start * 2);
	}

	private int getCalibrationCycles(int exponent, int divisor) {
		/**
		 * returns number of iterations to calculate the mean from. It is aimed
		 * at being reverse proportional to the targetTime
		 */
		int len = (int) Math.pow(2, exponent) / divisor;

		return len > 0 ? len : 1;
	}

	private int getAccuracyValue(DegreeOfAccuracyEnum x) {
		/** resolves accuracy parameter */

		switch (x) {
		case HIGH:
			return high;
		case MEDIUM:
			return medium;
		default:
		case LOW:
			return low;
		}
	}

	private void saveCalibration(long[][] theArray) {
		/** saves calibration to config file */

		OutputStream fos = null;

		try {
			fos = new FileOutputStream(configFileName);
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(theArray);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
			}
		}
	}

	private long[][] loadCalibration() {
		/** loads calibration from config file - if existing */

		InputStream fis = null;
		long[][] theArray = null;
		File configFile = new File(configFileName);

		// tests whether the calibration file exists and can be loaded
		if (configFile.exists()) {

			try {
				fis = new FileInputStream(configFileName);
				ObjectInputStream o = new ObjectInputStream(fis);
				theArray = (long[][]) o.readObject();
			} catch (IOException e) {
				System.err.println(e);
			} catch (ClassNotFoundException e) {
				System.err.println(e);
			} finally {
				try {
					fis.close();
				} catch (Exception e) {
				}
			}
		}
		return theArray;
	}

	private String loadCalibrationPath() {
		/** loads configFileName from CPU_CONFIG_PATH */

		String result = null;

		try {
			Properties p1 = new Properties();
			FileInputStream fis = new FileInputStream(new File(getCpuConfig()));
			p1.load(fis);
			result = p1.getProperty("CalibrationPath");
		} catch (IOException e) {
			System.err.println(e);
		}
		return result + File.separatorChar;
	}

	public void consume(double demand) {
		/** consumes demand - see also interface */

		long millisec = (long) (demand / processingRate * 1.0E3);
		long[] factor = fillTimeFrame(millisec);

		for (int i = 0; i < factor.length; i++) {
			long l = factor[i];
			for (int j = 0; j < l; j++) {
				run(calibTable[1][i]);
			}
		}
		logger.debug("Demand consumed");
	}

	public void watchConsume(double demand) {
		/** consumes demand - best used for debugging */

		long millisec = (long) (demand / processingRate * 1.0E3);

		logger.info("The timetable with the specific factors:");
		long[] factor = fillTimeFrame(millisec);

		logger.info("Consume CPU demand " + millisec + "[millisec]");
		logger.info("Calculating " + demand + " units");
		long theTime = System.nanoTime();
		for (int h = 0; h < 10; h++) {
			for (int i = 0; i < factor.length; i++) {
				long l = factor[i];
				for (int j = 0; j < l; j++) {
					run(calibTable[1][i]);
				}
			}
		}
		theTime = (System.nanoTime() - theTime) / 10;
		logger.debug("Demand consumed at an average value of " + theTime
				/ 1000000 + "[millisec]");
	}

	private long[] fillTimeFrame(long millisec) {
		/** use greedy strategy to fill time frame with smaller run times */

		// checks whether strategy has already been initialized
		if (calibTable[0][0] == 0) {
			logger
					.fatal("No calibration found - STRATEGY HAS TO BE INITIALIZED FIRST!");
			return null;
		} else {
			long[] result = new long[calibTable[1].length];
			long sum = millisec;

			for (int i = calibTable[1].length; i > 0; i--) {
				result[i - 1] = (long) (sum / calibTable[0][i - 1]);
				if (result[i - 1] >= 1) {
					sum = sum - calibTable[0][i - 1] * result[i - 1];
				}
				logger.debug(calibTable[0][i - 1] + " | "
						+ calibTable[1][i - 1] + " | " + result[i - 1]);
			}
			return result;
		}
	}
	
	private String getLoggerConfig() {
		return CONFIG_PATH + File.separatorChar + LOGGER_CONFIG; 
	}
	
	private String getCpuConfig() {
		return CONFIG_PATH + File.separatorChar + CPU_CONFIG;
	}
	
	public static void setConfigPath(String path){
		CONFIG_PATH = new File(path).getAbsolutePath();
	}

	protected abstract void run(long load);

	public abstract ResourceTypeEnum getStrategysResource();

	public abstract String getName();
}
