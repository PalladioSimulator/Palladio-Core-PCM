package org.palladiosimulator.protocom.resourcestrategies.ee.activeresource;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;

import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;
import javax.measure.unit.BaseUnit;
import javax.measure.unit.NonSI;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.apache.log4j.Logger;
import org.jscience.physics.amount.Amount;

/**
 * Abstract superclass of all active demand strategies.
 *
 * c.f.: Steffen Becker, Tobias Dencker, and Jens Happe. Model-Driven Generation of Performance
 * Prototypes. In Performance Evaluation: Metrics, Models and Benchmarks (SIPEW 2008), volume 5119
 * of Lecture Notes in Computer Science, pages 79-98. Springer-Verlag Berlin Heidelberg, 2008.
 *
 * @author Tobias Denker, Anne Koziolek, Steffen Becker, Thomas Zolynski, Sebastian Lehrig
 */
public abstract class AbstractDemandStrategy implements IDemandStrategy {

    private static final int RIGHT_ENDPOINT = 1;

    private static final int LEFT_ENDPOINT = 0;

    public static final Unit<Work> WORKUNITS = new BaseUnit<Work>("WU");

    public interface Work extends Quantity {
        public static final Unit<Work> UNIT = WORKUNITS;
    }

    public interface ProcessingRate extends Quantity {
        public static final Unit<ProcessingRate> UNIT = new ProductUnit<ProcessingRate>(Work.UNIT.divide(SI.SECOND));
    }

    public static final String CALIBRATION_PATH_CONFIG_KEY = "CalibrationPath";

    private static final int MIN_CALIBRATION_CYCLES = 5;

    private CalibrationTable calibrationTable;

    private static final Amount<Duration> ONE_MILLISECOND = Amount.valueOf(1, SI.MILLI(SI.SECOND));

    private static final int DEFAULT_ACCURACY = 8;

    private final int warmUpCycles;

    /** Modifier for low, medium and high calibration. */
    private final int low, medium, high;

    /** Iteration count for calibration */
    protected long defaultIterationCount;

    private Properties properties;

    private Amount<ProcessingRate> processingRate;

    private File configFile = null;
    private ICalibrationListener listener;

    protected DegreeOfAccuracyEnum degreeOfAccuracy;
    private static final Logger LOGGER = Logger.getLogger(AbstractDemandStrategy.class.getName());

    private static final String CALIBRATION_PATH = "../ProtoComCalibration/";

    // define constants
    private static final int[] CALIBRATION_CYCLES = {
            1024, 512, 256, 128, 64, 50, 40, 30, 25, 20, 15, 10
    };

    /**
     * Amount of outlier when calculating the mean. elements/OUTLIER_RATE of lowest and highest
     * values are discarded
     */
    private static final int OUTLIER_RATE = 5;

    /**
     * Constructor. Configures a demand strategy with low, medium and high modifier, as well as
     * number of standard and warm-up cycles
     *
     * @param low
     *            accuracy modifier for low precision calibration
     * @param medium
     *            accuracy modifier for medium precision calibration
     * @param high
     *            accuracy modifier for high precision calibration
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
    }

    /**
     * @see IDemandStrategy#initializeStrategy(DegreeOfAccuracyEnum, double)
     */
    @Override
    public void initializeStrategy(DegreeOfAccuracyEnum degree, double initProcessingRate) {
//        LOGGER.info("Initialising " + getName() + " " + getStrategysResource().name() + "  strategy with accuracy "
//                + degree.name());

        /*if (!isCalibrated()) {
        	throw new StrategyNotCalibratedException();
        }*/

        this.degreeOfAccuracy = degree;
        this.processingRate = Amount.valueOf(initProcessingRate, ProcessingRate.UNIT);
        this.configFile = new File(getCalibrationFileName());

        /*CalibrationTable loadedCalibration = CalibrationTable.load(configFile);

        if (loadedCalibration != null) {
            calibrationTable = loadedCalibration;

        } else {
            calibrate();
        }*/

        //calibrate();
        LOGGER.debug(getName() + " " + getStrategysResource().name() + " strategy initialised");
    }

    /**
     * @see IDemandStrategy#initializeStrategy(DegreeOfAccuracyEnum, double, String)
     */
    @Override
    public void initializeStrategy(DegreeOfAccuracyEnum degreeOfAccuracy, double processingRate, String calibrationPath) {
        if (calibrationPath != null) {
            Properties props = new Properties();
            props.setProperty(CALIBRATION_PATH_CONFIG_KEY, calibrationPath);
            setProperties(props);
        }

        initializeStrategy(degreeOfAccuracy, processingRate);
    }

    /**
     * @see IDemandStrategy#setProperties(Properties)
     */
    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     * @see IDemandStrategy#consume(double)
     */
    @Override
    public void consume(double demand) {
        if (calibrationTable == null) {
            LOGGER.fatal("No calibration found - STRATEGY HAS TO BE INITIALIZED FIRST!");
            throw new RuntimeException("No calibration found - STRATEGY HAS TO BE INITIALIZED FIRST!");
        }

        Amount<Work> demandedWork = Amount.valueOf(demand, Work.UNIT);
        Amount<Duration> millisec = demandedWork.divide(processingRate).to(SI.SECOND);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Consume called, demand is : " + demandedWork + ", " + millisec);
        }

        long[] factors = fillTimeFrame(millisec);

        for (int i = 0; i < factors.length; i++) {
            long loopCount = factors[i];
            for (int j = 0; j < loopCount; j++) {
                run(calibrationTable.getEntry(i).getParameter());
            }
        }
        LOGGER.debug("Demand consumed");
    }

    /**
     * Template method to return the real hardware resource type simulated by this strategy
     *
     * @see org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.IDemandStrategy#getStrategysResource()
     */
    @Override
    public abstract ResourceTypeEnum getStrategysResource();

    /**
     * Template method to return the name of this strategy
     *
     * @see org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.IDemandStrategy#getName()
     */
    @Override
    public abstract String getName();

    /**
     * Returns the name of the file used to store the calibration table Filename depends on
     * paramters of this class
     *
     * @return The calibration table file name
     */
    protected String getCalibrationFileName() {
        return getCalibrationPath() + "/" + getName() + "_" + CalibrationTable.DEFAULT_CALIBRATION_TABLE_SIZE + "_"
                + this.degreeOfAccuracy.name() + ".ser";
    }

    /**
     * Query the calibration path from the properties of this object
     *
     * @return The file system path used to load and store the calibration data, or the current
     *         working directory if it is not set
     */
    protected File getCalibrationPath() {
        String pathString = null;

        // Check whether properties have been set externally or not
        if (properties != null) {
            pathString = properties.getProperty(CALIBRATION_PATH_CONFIG_KEY) + "/";
        } else {
            pathString = CALIBRATION_PATH;
        }

        // create File object
        File path = null;
        if (pathString != null) {
            path = new File(pathString);
        }

        // Create path if it does not exist
        if (!path.exists()) {
            if (path.mkdirs()) {
//                LOGGER.info("Created Calibration Path " + path);
            } else {
                LOGGER.error("Could not create " + path
                        + ". Assure you have the rights to create and write to this folder.");
                System.exit(0);
            }
        }
        return path;
    }

    /**
     * Template method. This starts running the strategy with the parameter load
     *
     * @param load
     *            Complexity parameter. Algorithm should take longer if parameter is larger, i.e.,
     *            ideally run(a) < run(b) <==> a < b
     */
    protected abstract void run(long load);

    @Override
	public void setCalibrationListener(ICalibrationListener listener) {
    	this.listener = listener;
    }

    public boolean isCalibrated() {
    	return calibrationTable != null;
    }

    /**
     * Create a new calibration table for this host by measuring the execution times of our
     * algorithm and creating an according calibration table
     */
    @Override
	public CalibrationTable calibrate() {
        this.calibrationTable = new CalibrationTable();

        System.out.println("starting calibration");

        for (int i = 0; i < warmUpCycles; i++) {
            run(defaultIterationCount);
        }

        LOGGER.info("The timetable with the corresponding parameters:");
        for (int i = 0; i < calibrationTable.size(); i++) {
            Amount<Duration> targetTime = Amount.valueOf(1 << i, SI.MILLI(SI.SECOND));
            long parameter = getRoot(targetTime);

            if (i > 2) { // TODO: Why 2?
                // TODO: This is smart, but absolutely not maintainable...
                targetTime = recalibrate(parameter, i);
            }

            if (listener != null) {
            	float progress = (float) i / (calibrationTable.size() - 1);
            	listener.progressChanged(progress);
            }

            calibrationTable.addEntry(i, targetTime, parameter);
            LOGGER.info(calibrationTable.getEntry(i));
        }
        //calibrationTable.save(configFile);

        return calibrationTable;
    }

    public void setCalibrationTable(CalibrationTable table) {
    	this.calibrationTable = table;
    }

    /**
     * Iteratively approximates the best input value to reach a specified execution time. Let the
     * result of this method be parameter. Then this method determines a parameter, s.t.
     * exec_alg(parameter) = targetTime
     *
     * The accepted tolerance is one millisecond.
     *
     * @param targetTime
     *            target time in milliseconds
     * @return exec_alg^(-1)(targetTime)
     */
    private long getRoot(Amount<Duration> targetTime) {
        final int numberOfRepetitions = 2; // TODO: Why 2? Configurable?
        return getRoot(targetTime, numberOfRepetitions);
    }

    /**
     * Iteratively approximates the best input value to reach a specified execution time. Let the
     * result of this method be parameter. Then this method determines a parameter, s.t.
     * exec_alg(parameter) = targetTime
     *
     * The accepted tolerance is one millisecond.
     *
     * @param targetTime
     *            target time in milliseconds
     * @param numberOfRepetitions
     *            number of times the algorithm determines the root. This is needed as the function
     *            is only approximated by running measurements
     * @return exec_alg^(-1)(targetTime)
     */
    private long getRoot(Amount<Duration> targetTime, int numberOfRepetitions) {
        // approximated parameters
        long[] targetParameter = new long[numberOfRepetitions];

        // run a couple of times and calculate mean
        for (int i = 0; i < numberOfRepetitions; i++) {
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
    private long getRootOnce(Amount<Duration> targetTime) {
        long[] intervalEndpoints = new long[2];
        Amount<Duration>[] intervalFunctionValues = new Amount[2];
        initialiseInterval(targetTime, intervalEndpoints, intervalFunctionValues);
        if (!hasRoot(intervalFunctionValues[LEFT_ENDPOINT], intervalFunctionValues[RIGHT_ENDPOINT])
                || intervalFunctionValues[LEFT_ENDPOINT].isGreaterThan(intervalFunctionValues[RIGHT_ENDPOINT])) {
            LOGGER.error("PROBLEM: No root found. Special algorithm" + " without monotonically increasing load !?!");
            LOGGER.error("f_n_left = " + intervalFunctionValues[LEFT_ENDPOINT]);
            LOGGER.error("f_n_right = " + intervalFunctionValues[RIGHT_ENDPOINT]);
            throw new RuntimeException("PROBLEM: No root found. Special algorithm"
                    + " without monotonically increasing load !?!");
        }

        LOGGER.debug("--- Running bisection method ----");
        Amount<Duration> epsilon = getEpsilon(targetTime);
        while (Math.abs(intervalEndpoints[LEFT_ENDPOINT] - intervalEndpoints[RIGHT_ENDPOINT]) > 2
                && intervalFunctionValues[RIGHT_ENDPOINT].minus(intervalFunctionValues[LEFT_ENDPOINT]).abs()
                        .isLargerThan(epsilon)) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("[" + intervalEndpoints[LEFT_ENDPOINT] + ", " + intervalEndpoints[RIGHT_ENDPOINT]
                        + "] --> " + "[" + formatDuration(intervalFunctionValues[LEFT_ENDPOINT]) + ", "
                        + formatDuration(intervalFunctionValues[RIGHT_ENDPOINT]) + "]");
            }
            long intervalMedian = (intervalEndpoints[LEFT_ENDPOINT] + intervalEndpoints[RIGHT_ENDPOINT]) / 2;
            Amount<Duration> f_n_median = calcRunTimeFunction(intervalMedian, targetTime);
            if (hasSameSign(intervalFunctionValues[LEFT_ENDPOINT].getEstimatedValue(), f_n_median.getEstimatedValue())) {
                intervalEndpoints[LEFT_ENDPOINT] = intervalMedian;
                intervalFunctionValues[LEFT_ENDPOINT] = f_n_median;
            } else {
                intervalEndpoints[RIGHT_ENDPOINT] = intervalMedian;
                intervalFunctionValues[RIGHT_ENDPOINT] = f_n_median;
            }
        }
        return (intervalEndpoints[LEFT_ENDPOINT] + intervalEndpoints[RIGHT_ENDPOINT]) / 2;

    }

    private Amount<Duration> getEpsilon(Amount<Duration> targetTime) {
        Amount<Duration> result = targetTime.times(0.01d);
        if (result.to(SI.MILLI(SI.SECOND)).isGreaterThan(ONE_MILLISECOND)) {
            return ONE_MILLISECOND;
        }
        return result;
    }

    /**
     * @param a
     * @param b
     * @return true if a and b have the same sign
     */
    private boolean hasSameSign(double a, double b) {
        return a * b > 0;
    }

    private Amount<Duration> recalibrate(long parameter, int index) {
        int cycles = CALIBRATION_CYCLES[index];
        return getRunTime(parameter, Amount.valueOf(cycles, SI.MILLI(SI.SECOND)));
    }

    /**
     * The initial value of f(n_right) has to be greater than 0.
     *
     * @param targetTime
     * @return n_right with f(n_right) > 0
     */
    private void initialiseInterval(Amount<Duration> targetTime, long[] intervalEndpoints,
            Amount<Duration>[] intervalFunctionValues) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Find inital interval for target time " + formatDuration(targetTime));
        }
        long z = 0;
        do {
            intervalEndpoints[LEFT_ENDPOINT] = intervalEndpoints[RIGHT_ENDPOINT];
            intervalFunctionValues[LEFT_ENDPOINT] = intervalFunctionValues[RIGHT_ENDPOINT];
            intervalEndpoints[RIGHT_ENDPOINT] = z * defaultIterationCount;
            intervalFunctionValues[RIGHT_ENDPOINT] = calcRunTimeFunction(intervalEndpoints[RIGHT_ENDPOINT], targetTime);
            z = z == 0 ? 1 : z << 1;
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("[" + intervalEndpoints[LEFT_ENDPOINT] + ", " + intervalEndpoints[RIGHT_ENDPOINT]
                        + "] --> " + "[" + formatDuration(intervalFunctionValues[LEFT_ENDPOINT]) + ", "
                        + formatDuration(intervalFunctionValues[RIGHT_ENDPOINT]) + "]");
            }
        } while (intervalFunctionValues[RIGHT_ENDPOINT].isLessThan(Amount.valueOf(0L, SI.SECOND)));
    }

    /**
     * Checks whether there is a root (Nullstelle) between the two function values
     *
     * @param f_n_left
     *            Left interval end point function value
     * @param f_n_right
     *            Right interval end point function value
     * @return true if there is a root between the two function values
     */
    private boolean hasRoot(Amount<Duration> f_n_left, Amount<Duration> f_n_right) {
        return (!hasSameSign(f_n_left.getEstimatedValue(), f_n_right.getEstimatedValue()));
    }

    /**
     * Derives a function f(n) = exec_alg(n) - targetTime, whose root is at targetTime, i.e,
     * f(targetTime) = 0
     *
     * @param parameter
     * @param targetTime
     * @return
     */
    private Amount<Duration> calcRunTimeFunction(long parameter, Amount<Duration> targetTime) {
        return getRunTime(parameter, targetTime).minus(targetTime);
    }

    /**
     * Returns mean algorithm run time depending on the parameter. The approximation accuracy of the
     * algorithm run time depends on the targetTime. For small targetTime several approximation
     * cycles are executed and their mean is returned. For larger targetTime just a single cycle is
     * executed.
     *
     * @param parameter
     *            characterising parameter of the load generating algorithm
     * @param targetTime
     *            target time (used to determine approximation accuracy, s.a.)
     * @return approximated run time in nanoseconds, i.e., exec_alg(parameter)
     */
    private Amount<Duration> getRunTime(long parameter, Amount<Duration> targetTime) {
        int cycles = getCalibrationCycles(getAccuracyValue(), targetTime);

        long[] approximation = new long[cycles];

        for (int i = 0; i < cycles; i++) {
            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace("Measuring calibration run " + i + " of " + cycles);
            }
            long start = System.nanoTime();
            run(parameter);
            approximation[i] = (System.nanoTime() - start);
        }

        long mean = mean(approximation);
        LOGGER.debug("Mean time for parameter " + parameter + " is " + mean);
        return Amount.valueOf(mean, SI.NANO(SI.SECOND));
    }

    /**
     * Calculates mean value of array p. If p has more than five elements, the lowest and highest
     * 'length / OUTLIER_RATE' are removed.
     *
     * @param p
     *            array of numbers
     * @return mean value
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
     * Returns number of iterations to calculate the mean from. It is aimed at being reverse
     * proportional to the targetTime.
     *
     * For long target times only one cycle will be executed. Example: MEDIUM accuracy: Exponent =
     * DEFAULT_ACCURACY (8) + 0 = 8 TargetTime >= 2^8 => len = 1 < 2^8 => len = 2^8/TargetTime
     *
     * @param exponent
     * @param targetTime
     * @return
     */
    private int getCalibrationCycles(int exponent, Amount<Duration> targetTime) {
        Amount<Duration> threshold = Amount.valueOf(1 << exponent, SI.MILLI(SI.SECOND));

        return Math.max((int) Math.floor(threshold.divide(targetTime).getEstimatedValue()), MIN_CALIBRATION_CYCLES);
    }

    /**
     * Maps an accuracy (LOW, MEDIUM, HIGH) to the values specified during the configuration (in the
     * constructor).
     *
     * @return accuracy modifier
     */
    private int getAccuracyValue() {
        int result = DEFAULT_ACCURACY;

        switch (this.degreeOfAccuracy) {
        case HIGH:
            result += high;
            break;
        case MEDIUM:
            result += medium;
            break;
        case LOW:
            result += low;
            break;
        default:
            throw new IllegalArgumentException("Unsupported degree of accuracy");
        }
        return result;
    }

    /**
     * Computes a vector of (scaling) factors for each entry in the calibration table. These factors
     * give the number of repetitions of each of the calibration entries to reach a given target
     * time. Use greedy strategy to fill time frame with smaller run times
     *
     * @param millisec
     *            The target time to factorise
     * @return An array of scaling factors for the calibration table entries
     */
    private long[] fillTimeFrame(Amount<Duration> millisec) {
        long[] result = new long[CalibrationTable.DEFAULT_CALIBRATION_TABLE_SIZE];
        Amount<Duration> sum = millisec;

        for (int i = CalibrationTable.DEFAULT_CALIBRATION_TABLE_SIZE - 1; i >= 0; i--) {
            CalibrationEntry calibrationEntry = calibrationTable.getEntry(i);

            result[i] = (long) Math.floor((sum.divide(calibrationEntry.getTargetTime())).to(Unit.ONE)
                    .getEstimatedValue());
            if (result[i] >= 1) {
                sum = sum.minus(calibrationEntry.getTargetTime().times(result[i]));
            }
            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace(formatDuration(calibrationEntry.getTargetTime()) + " | " + calibrationEntry.getParameter()
                        + " | " + result[i] + "|" + formatDuration(sum));
            }
        }
        return result;
    }

    /**
     * Consumes demands (only used for testing purpose!)
     *
     * @param demand
     */
    @Deprecated
    public void watchConsume(double demand) {
        final int repetitionCount = 10;
        if (calibrationTable == null) {
            LOGGER.fatal("No calibration found - STRATEGY HAS TO BE INITIALIZED FIRST!");
            throw new RuntimeException("No calibration found - STRATEGY HAS TO BE INITIALIZED FIRST!");
        }

        Amount<Work> demandedWork = Amount.valueOf(demand, Work.UNIT);
        Amount<Duration> expectedTime = demandedWork.divide(processingRate).to(SI.SECOND);
        LOGGER.info("Request issued to consume " + demandedWork);
        LOGGER.info("Expected duration is " + formatDuration(expectedTime));
        long theTime = System.nanoTime();

        for (int h = 0; h < repetitionCount; h++) {
            consume(demand);
        }
        Amount<Duration> measuredTime = Amount.valueOf((System.nanoTime() - theTime) / repetitionCount,
                SI.NANO(SI.SECOND));
        LOGGER.info("Demand of " + formatDuration(expectedTime) + " consumed at an average value of "
                + formatDuration(measuredTime) + ". Abs. difference is "
                + formatDuration(measuredTime.minus(expectedTime).abs()));
    }

    @SuppressWarnings("unchecked")
    public static String formatDuration(Amount<Duration> t) {
        if (t == null) {
            return "null";
        }

        Unit<Duration>[] units = new Unit[] {
                SI.NANO(SI.SECOND), SI.MICRO(SI.SECOND), SI.MILLI(SI.SECOND), SI.SECOND, NonSI.MINUTE, NonSI.HOUR
        };
        for (Unit<Duration> u : units) {
            double value = t.to(u).getEstimatedValue();
            if (Math.abs(value) < 1000) {
                return value + " " + u;
            }
        }
        return t.toText().toString();
    }
}
