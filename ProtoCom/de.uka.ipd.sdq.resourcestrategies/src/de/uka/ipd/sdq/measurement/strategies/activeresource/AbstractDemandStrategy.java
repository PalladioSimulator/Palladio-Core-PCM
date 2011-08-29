package de.uka.ipd.sdq.measurement.strategies.activeresource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Properties;

import org.apache.log4j.Logger;

class CalibrationEntry implements Serializable {
	private static final long serialVersionUID = -1969713798721640687L;
	
	final private int bitPosition;
	final private long parameter;
	
	public CalibrationEntry(int bitPosition, long parameter) {
		super();
		this.bitPosition = bitPosition;
		this.parameter = parameter;
	}
	
	public int getBitPosition() {
		return bitPosition;
	}
	
	public long getParameter() {
		return parameter;
	}
}


/**
 * Abstract superclass of all active demand strategies.
 * 
 * c.f.: Steffen Becker, Tobias Dencker, and Jens Happe. 
 *       Model-Driven Generation of Performance Prototypes. 
 *       In Performance Evaluation: Metrics, Models and Benchmarks (SIPEW 2008), volume 5119 of Lecture Notes in Computer Science, pages 79-98. 
 *       Springer-Verlag Berlin Heidelberg, 2008.
 * 
 * @author Tobias Denker, Anne Koziolek, Steffen Becker
 */
public abstract class AbstractDemandStrategy implements IDemandStrategy {

	private static final int MIN_CALIBRATION_CYCLES = 5;

	protected static final int MAX_BIT_POSITION = 11;

	private static final int ONE_MILLISECOND = 1;

	private static final int DEFAULT_ACCURACY = 8;

	private final int warmUpCycles;
	
	/** Modifier for low, medium and high calibration.  */
	private final int low, medium, high;

	/** Iteration count for calibration */
	protected long defaultIterationCount;
	
	private Properties properties;

	private int accuracy;
	private double processingRate;
	protected CalibrationEntry[] calibrationTable;
	private String configFileName = null;
	private static Logger logger = Logger.getLogger(AbstractDemandStrategy.class.getName());

	private static String CONFIG_PATH = "/conf/";

	// define constants
	private static final String LOGGER_CONFIG = "CPULogger.properties";
	private static final String CPU_CONFIG = "CPUConfig.properties";
	private static final int MILLION = 1000000;
	private static final double THOUSAND = 1.0E3;
	private static final int[] CALIBRATION_CYCLES = { 1024, 512, 256, 128, 64, 50, 40, 30, 25, 20, 15, 10 };

	/** Amount of outlier when calculating the mean. elements/OUTLIER_RATE of lowest and highest values are discarded */
	private static final int OUTLIER_RATE = 5;
	
	/**
	 * Constructor. Configures a demand strategy with low, medium and high modifier, as well 
	 * as number of standard and warm-up cycles
	 *  
	 * @param low		accuracy modifier for low precision calibration
	 * @param medium	accuracy modifier for medium precision calibration
	 * @param high		accuracy modifier for high precision calibration
	 * @param iterationCount
	 * @param warmups
	 */
	public AbstractDemandStrategy(int low, int medium, int high, int iterationCount, int warmups) {
		super();
		
		/**
		 * Initialise the calibration algorithm's parameter set
		 */
		this.low = low; 
		this.medium = medium;
		this.high = high;
		this.defaultIterationCount = iterationCount; 
		this.warmUpCycles = warmups;
		
		InputStream fis = getClass().getResourceAsStream(getLoggerConfig());
		Properties prop = new Properties();
		if (fis != null) {
			try {
				prop.load(fis);
				org.apache.log4j.PropertyConfigurator.configure(prop);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * @see IDemandStrategy#initializeStrategy(DegreeOfAccuracyEnum, double)
	 */
	@Override
	public void initializeStrategy(DegreeOfAccuracyEnum degree, double initProcessingRate) {
		logger.info("Initialising " + getName() + " " + getStrategysResource().name() + "  strategy with accuracy "+degree.name());
		
		this.accuracy = getAccuracyValue(degree);
		this.processingRate = initProcessingRate;
		this.configFileName = getCalibrationFileName(degree);

		CalibrationEntry[] loadedCalibration = loadCalibration();

		if (loadedCalibration != null) {
			calibrationTable = loadedCalibration;

		} else {

			calibrate();
			logger.info("Saving calibration to '" + configFileName + "'");
		}
		logger.debug(getName() + " " + getStrategysResource().name() + " strategy initialised");
	}

	/**
	 * Create a new calibration table for this host
	 */
	private void calibrate() {
		
		this.calibrationTable = new CalibrationEntry[MAX_BIT_POSITION];
		
		for (int i = 0; i < warmUpCycles; i++) {
			run(defaultIterationCount);
		}

		logger.info("The timetable with the corresponding parameters:");
		for (int i = 0; i < MAX_BIT_POSITION; i++) {
			int power = 1 << i;
			long parameter = getRoot(power);
			
			if (i > 2) { 
				power = (int)recalibrate(parameter, i);
			}
			
			calibrationTable[i] = new CalibrationEntry(power, parameter);
			logger.info(power + " | " + parameter);
		}
		saveCalibration();
	}

	protected String getCalibrationFileName(DegreeOfAccuracyEnum degree) {
		return loadCalibrationPath() + getName() + "_"
				+ MAX_BIT_POSITION + "_" + degree.name() + ".ser";
	}
	
	/**
	 * @see IDemandStrategy#initializeStrategy(DegreeOfAccuracyEnum, double, String)
	 */
	@Override
	public void initializeStrategy(DegreeOfAccuracyEnum degreeOfAccuracy,
			double processingRate, String calibrationPath) {
		Properties props = new Properties();
		props.setProperty("CalibrationPath", calibrationPath);
		setProperties(props);
		
		initializeStrategy(degreeOfAccuracy, processingRate);
	}


	/**
	 * Iteratively approximates the best input value to reach a specified execution time.
	 * Let the result of this method be parameter. Then this method determines a parameter, 
	 * s.t. exec_alg(parameter) = targetTime 
	 * 
	 * The accepted tolerance is one millisecond.
	 * 
	 * @param targetTime	target time in milliseconds
	 * @return exec_alg^(-1)(targetTime)
	 */
	private long getRoot(int targetTime) {
		// approximated parameters
		long[] targetParameter = new long[2];

		// run a couple of times and calculate mean
		for (int i = 0; i < targetParameter.length; i++) {

			targetParameter[i] = getRootOnce(targetTime);
		}
		return mean(targetParameter);
	}

	/**
	 * Mathematical root finding algorithm. Calculation based on bisection method.
	 * 
	 * @param targetTime
	 * @return root
	 */
	private long getRootOnce(int targetTime) {
		long n_left = 0; 
		long n_right = initialiseNRight(targetTime);
		long f_n_left = calcRunTimeFunction(n_left, targetTime);
		long f_n_right = calcRunTimeFunction(n_right, targetTime);

		if (!hasRoot(f_n_left, f_n_right) || f_n_left > f_n_right) { 
			logger.error("PROBLEM: y(x0) > 0 && y(x1) > 0 => special algorithm"
							+ " without monotonically increasing load !?!");
			throw new RuntimeException("PROBLEM: y(x0) > 0 && y(x1) > 0 => special algorithm"
					+ " without monotonically increasing load !?!");
		} 
		
		while (Math.abs(n_right - n_left) > ONE_MILLISECOND) {
			long intervalMedian = (n_left + n_right) / 2;
			long f_n_median = calcRunTimeFunction(intervalMedian, targetTime);
			if (hasSameSign(f_n_left, f_n_median)) {
				n_left = intervalMedian;
			} else {
				n_right = intervalMedian;
			}
		}
		return (n_left + n_right) / 2;
	
	}

	private boolean hasSameSign(long a, long b) {
		return a * b > 0;
	}

	
	private long recalibrate(long parameter, int index) {
		int cycles = CALIBRATION_CYCLES[index];
		return getRunTime(parameter, cycles) / MILLION;
	}
	
	/**
	 * The initial value of f(n_right) has to be greater than 0.
	 * 
	 * @param targetTime
	 * @return n_right with f(n_right) > 0
	 */
	private long initialiseNRight(int targetTime) {
		long n_right = 0; int z = 0;
		do {
			n_right = defaultIterationCount * (1 << z);
			z++;
		} while (calcRunTimeFunction(n_right, targetTime) < MILLION);

		return n_right;
	}

	private boolean hasRoot(long f_n_left, long f_n_right) {
		return (!hasSameSign(f_n_left, f_n_right));
	}


	/**
	 * Derives a function f(n) = exec_alg(n) - targetTime, whose root is at 
	 * targetTime, i.e, f(targetTime) = 0
	 *  
	 * @param parameter
	 * @param targetTime
	 * @return
	 */
	private long calcRunTimeFunction(long parameter, int targetTime) {
		return getRunTime(parameter, targetTime) - targetTime * MILLION;
	}

	/**
	 * Returns mean algorithm run time depending on the parameter. The approximation 
	 * accuracy of the algorithm run time depends on the targetTime. For small 
	 * targetTime several approximation cycles are executed and their mean is returned. 
	 * For larger targetTime just a single cycle is executed.
	 * 
	 * @param parameter		characterising parameter of the load generating algorithm
	 * @param targetTime	target time (used to determine approximation accuracy, s.a.)
	 * @return approximated run time in nanoseconds, i.e., exec_alg(parameter)
	 */
	private long getRunTime(long parameter, int targetTime) {
		int cycles = getCalibrationCycles(accuracy + DEFAULT_ACCURACY, targetTime);

		long[] approximation = new long[cycles];
		
		for (int i = 0; i < cycles; i++) {
			if (logger.isTraceEnabled()) {
				logger.trace("Measuring calibration run " + i + " of " + cycles);
			}
			long start = System.nanoTime();
			run(parameter);
			approximation[i] = (System.nanoTime() - start);
		}
		
		long mean = mean(approximation);
		logger.debug("Mean time for parameter " + parameter + " is " + mean);
		return mean;
	}

	/**
	 * Calculates mean value of array p. If p has more than five elements, the lowest 
	 * and highest 'length / OUTLIER_RATE' are removed.
	 * 
	 * @param p		array of numbers
	 * @return		mean value
	 */
	private long mean(long[] p) {
		long sum = 0; 
		Arrays.sort(p);
		int start = p.length > OUTLIER_RATE ? p.length / OUTLIER_RATE : 0;
		for (int i = start; i < p.length - start; i++) {
			sum += p[i];
		}

		return sum / (p.length - start * 2);
	}

	/**
	 * Returns number of iterations to calculate the mean from. It is aimed
	 * at being reverse proportional to the targetTime.
	 * 
	 * For long target times only one cycle will be executed.
	 * Example: MEDIUM accuracy: Exponent = DEFAULT_ACCURACY (8) + 0 = 8
	 *                           TargetTime >= 2^8 => len = 1
	 *                                      <  2^8 => len = 2^8/TargetTime
     *
	 * @param exponent
	 * @param targetTime
	 * @return
	 */
	private int getCalibrationCycles(int exponent, int targetTime) {
		int threshold = 1 << exponent;
	
		assert(((int) Math.pow(2, exponent)) - threshold == 0);

		return Math.max(threshold / targetTime, MIN_CALIBRATION_CYCLES);
	}

	/**
	 * Maps an accuracy (LOW, MEDIUM, HIGH) to the values specified during the 
	 * configuration (in the constructor).
	 * 
	 * @param accuracy	LOW, MEDIUM or HIGH
	 * @return			accuracy modifier
	 */
	private int getAccuracyValue(DegreeOfAccuracyEnum accuracy) {
		switch(accuracy) {
		case HIGH:
			return high;
		case MEDIUM:
			return medium;
		case LOW:
			return low;
		}
		throw new IllegalArgumentException("Unsupported degree of accuracy");
	}

	/**
	 * Saves calibration to config file 
	 * 
	 * @param calibrationData
	 */
	private void saveCalibration() {
		OutputStream fos = null;

		try {
			fos = new FileOutputStream(configFileName);
			
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(calibrationTable);
			
		} catch (IOException e) {
			logger.error("Error while writing calibration data", e);
			
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Loads calibration from config file
	 * @return
	 */
	private CalibrationEntry[] loadCalibration() {
		File configFile = new File(configFileName);
		CalibrationEntry[] calibrationData = null;
		
		// tests whether the calibration file exists and can be loaded
		if (configFile.exists()) {
			logger.debug("Loaded calibration from '" + configFileName + "'");

			InputStream fis = null;
			try {
				fis = new FileInputStream(configFileName);
				ObjectInputStream o = new ObjectInputStream(fis);
				calibrationData = (CalibrationEntry[]) o.readObject();
			} catch (IOException e) {
				logger.error("Error while loading " + configFileName, e);
				
			} catch (ClassNotFoundException e) {
				logger.error("Error while reading " + configFileName, e);

			} finally {
				try {
					fis.close();
				} catch (Exception e) {
				}
			}
			
		} else {
			logger.debug(configFileName + " not existing yet");
		}
		
		return calibrationData;
	}
	
	/**
	 * @see IDemandStrategy#setProperties(Properties)
	 */
	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * Loads configFileName from CPU_CONFIG_PATH
	 * @return
	 */
	protected String loadCalibrationPath() {
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

	/**
	 * @see IDemandStrategy#consume(double)
	 */
	@Override
	public void consume(double demand) {
		long millisec = (long) (demand / processingRate * THOUSAND);
		logger.debug("Consume called, demand is : " + demand + ", " + millisec + "ms");
		
		long[] factor = fillTimeFrame(millisec);

		for (int i = 0; i < factor.length; i++) {
			long l = factor[i];
			for (int j = 0; j < l; j++) {
				run(calibrationTable[i].getParameter());
			}
		}
		logger.debug("Demand consumed");
	}

	/**
	 * Consumes demands (only used for testing purpose!)
	 * @param demand
	 */
	@Deprecated
	public void watchConsume(double demand) {
		long millisec = (long) (demand / processingRate * THOUSAND);

		logger.info("The timetable with the specific factors:");
		long[] factor = fillTimeFrame(millisec);

		logger.info("Request issued to consume " + demand + " abstract units");
		logger.info("Expected duration is " + millisec + "ms");
		long theTime = System.nanoTime();
		for (int h = 0; h < 10; h++) {
			for (int i = 0; i < factor.length; i++) {
				long l = factor[i];
				for (int j = 0; j < l; j++) {
					run(calibrationTable[i].getParameter());
				}
			}
		}
		theTime = (System.nanoTime() - theTime) / 10 / MILLION;
		logger.info("Demand of "+millisec+"ms consumed at an average value of " + theTime
				+ "ms. Abs. difference is "+Math.abs(millisec-theTime)+"ms");
	}

	/**
	 * Use greedy strategy to fill time frame with smaller run times
	 * 
	 * @param millisec
	 * @return
	 */
	private long[] fillTimeFrame(long millisec) {
		// checks whether strategy has already been initialized
		if (calibrationTable == null) {
			logger.fatal("No calibration found - STRATEGY HAS TO BE INITIALIZED FIRST!");
			System.exit(-1);
			return null;
			
		} else {
			long[] result = new long[MAX_BIT_POSITION];
			long sum = millisec;

			for (int i = MAX_BIT_POSITION; i > 0; i--) {
				result[i - 1] = (long) (sum / calibrationTable[i - 1].getBitPosition());
				if (result[i - 1] >= 1) {
					sum = sum - calibrationTable[i - 1].getBitPosition() * result[i - 1];
				}
				logger.trace(calibrationTable[i - 1].getBitPosition() + " | "
						+ calibrationTable[i - 1].getParameter() + " | " + result[i - 1]);
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
