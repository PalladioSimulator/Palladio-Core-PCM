package de.uka.ipd.sdq.measurement.strategies.activeresource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Properties;

import org.apache.log4j.Logger;


public abstract class AbstractDemandStrategy implements IDemandStrategy {

	// declare & define variables
	private final int warmUpCycles;
	private final int low;
	private final int medium;
	private final int high;

	protected long defaultIterationCount;
	
	private Properties properties;

	private int accuracy;
	private double processingRate;
	protected long[][] calibTable = new long[2][11];
	private String configFileName = null;
	private static Logger logger = Logger
			.getLogger(AbstractDemandStrategy.class.getName());

	private static String CONFIG_PATH = "/conf/";

	// define constants
	private static final String LOGGER_CONFIG = "CPULogger.properties";
	private static final String CPU_CONFIG = "CPUConfig.properties";
	private static final int MILLION = 1000000;
	private static final int[] CALIBRATION_CYCLES = { 1024, 512, 256, 128, 64,
			50, 40, 30, 25, 20, 15, 10 };

	// class constructor
	public AbstractDemandStrategy(int low, int medium, int high, int iterationCount, int warmups) {
		super();
		
		/**
		 * Initialise the callibration algorithm's parameter set
		 */
		this.low = low; 
		this.medium = medium;
		this.high = high;
		this.defaultIterationCount = iterationCount; 
		this.warmUpCycles = warmups;
		
		// quick-fix for missing appenders error
		// org.apache.log4j.BasicConfigurator.configure();
		//org.apache.log4j.PropertyConfigurator.configure(getLoggerConfig());
		InputStream fis = getClass().getResourceAsStream(getLoggerConfig());
		Properties prop = new Properties();
		if (fis != null) {
			try {
				prop.load(fis);
				org.apache.log4j.PropertyConfigurator.configure(prop);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void initializeStrategy(DegreeOfAccuracyEnum degree,
			double initProcessingRate) {
		/** initialize strategy - see also interface */

		logger.info("Initialising " + getName() + " " + getStrategysResource().name() + "  strategy with accuracy "+degree.name());

		this.accuracy = getAccuracyValue(degree);
		this.processingRate = initProcessingRate;
		this.configFileName = getCalibrationFileName(degree);

		long[][] loadedCalibration = loadCalibration();

		if (loadedCalibration != null) {
			calibTable = loadedCalibration;
			logger.debug("Loading calibration from '" + configFileName + "'");
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
		logger.debug(getName() + " " + getStrategysResource().name() + " strategy initialised");
	}

	protected String getCalibrationFileName(DegreeOfAccuracyEnum degree) {
		return loadCalibrationPath() + getName() + "_"
				+ calibTable[1].length + "_" + degree.name() + ".ser";
	}
	
	public void initializeStrategy(DegreeOfAccuracyEnum degreeOfAccuracy,
			double processingRate,
			String calibrationPath)
	{
		Properties props = new Properties();
		props.setProperty("CalibrationPath", calibrationPath);
		setProperties(props);
		
		initializeStrategy(degreeOfAccuracy, processingRate);
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
		long difference = getRunTime(parameter, cycles) - targetTime * MILLION; 
		return difference;
	}

	private long getRunTime(long parameter, int cycles) {
		/** returns mean algorithm run time depending on the parameter */

		// measured run times in nanoseconds
		long[] approximation = new long[cycles];
		
		for (int i = 0; i < approximation.length; i++) {
			logger.trace("Messuring calibration run "+i+" of "+approximation.length);
			long start = System.nanoTime();
			run(parameter);
			approximation[i] = (System.nanoTime() - start);
		}
		logger.debug("Mean time for parameter "+parameter+" is "+mean(approximation));
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
		switch(x) {
		case HIGH:
			return high;
		case MEDIUM:
			return medium;
		case LOW:
			return low;
		}
		throw new IllegalArgumentException("Unsupported degree of accuracy");
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
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	protected String loadCalibrationPath() {
		/** loads configFileName from CPU_CONFIG_PATH */
		
		String result = null;
		
		// Test whether properties have been set externally
		if (properties != null) {
			result = properties.getProperty("CalibrationPath");
			if ((result != null) && (!result.equals(""))) {
				return result + "/";
			}
		}


		try {
			Properties p1 = new Properties();
			InputStream fis = getClass().getResourceAsStream(getCpuConfig());
			//FileInputStream fis = new FileInputStream(new File(getCpuConfig()));
			p1.load(fis);
			result = p1.getProperty("CalibrationPath");
		} catch (IOException e) {
			System.err.println(e);
		}
		return result + "/";
	}

	public void consume(double demand) {
		/** consumes demand - see also interface */

		long millisec = (long) (demand / processingRate * 1.0E3);
		logger.debug("Consume called, demand is : " + demand + ", " + millisec + "ms");
		
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

		logger.info("Request issued to consume " + demand + " abstract units");
		logger.info("Expected duration is " + millisec + "ms");
		long theTime = System.nanoTime();
		for (int h = 0; h < 10; h++) {
			for (int i = 0; i < factor.length; i++) {
				long l = factor[i];
				for (int j = 0; j < l; j++) {
					run(calibTable[1][i]);
				}
			}
		}
		theTime = (System.nanoTime() - theTime) / 10 / MILLION;
		logger.info("Demand of "+millisec+"ms consumed at an average value of " + theTime
				+ "ms. Abs. difference is "+Math.abs(millisec-theTime)+"ms");
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
				logger.trace(calibTable[0][i - 1] + " | "
						+ calibTable[1][i - 1] + " | " + result[i - 1]);
			}
			return result;
		}
	}

	private String getLoggerConfig() {
		return CONFIG_PATH + LOGGER_CONFIG;
	}

	private String getCpuConfig() {
		return CONFIG_PATH + CPU_CONFIG;
	}

	public static void setConfigPath(String path) {
		CONFIG_PATH = new File(path).getAbsolutePath();
	}

	protected abstract void run(long load);

	public abstract ResourceTypeEnum getStrategysResource();

	public abstract String getName();
}
