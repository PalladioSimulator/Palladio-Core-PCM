package de.uka.ipd.sdq.BySuite.Study;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import JSci.maths.statistics.NormalDistribution;

/**
 * Base class for simple timer runs determining <b>how</b> to measure.
 * Sub classes need to implement the {@link #run(int)} method to determine <b>what</b> to 
 * measure. Optionally they can override 
 * @author Martin, Michael
 */
public abstract class SimpleTiming {
	
	/**
	 * 'nr' value for the timing runs.
	 */
	public static final int DEFAULT_PROBLEM_SIZE = 500;
	
	/**
	 * How often the {@link #run(int)} method is executed for measurements. 
	 */
	public static final int DEFAULT_REPETITIONS_NUMBER = 500;
	
	/**
	 * Number of warmup executions of the "run" method.
	 */
	public static final int DEFAULT_WARMUP_SIZE = 50000;

	/**
	 * Timing value directly after the measured code.
	 */
	protected long end;

	/**
	 * Member for logging purposes. 
	 */
	protected Logger log;

	/**
	 * A list of (end-start) measurements.
	 */
	private ArrayList<Long> measurements;
	
	/**
	 * Timing value directly before the measured code.
	 */
	protected long start;
	
	/**
	 * Default constructor
	 */
	public SimpleTiming() {
		start = -1;
		end = -1;
		PropertyConfigurator.configure("config/log4j.properties");
		log = Logger.getLogger(this.getClass().getCanonicalName());
		measurements = new ArrayList<Long>();
	}

	/**
	 * This is run immediately after each call to run.
	 * Implement this for important cleanup/output etc.
	 */
	protected abstract void afterRun();
	
	/**
	 * This is run immediately before each call to run.
	 * Implement this for important initializations etc.
	 */
	protected abstract void beforeRun();

	/**
	 * Print out the measurement statistics (min, max, median, mean, variance). 
	 * Assumes normal distribution of values (TODO document/replace!)
	 */
	protected void printTimes() {
		Collections.sort(measurements);
		double[] values = new double[measurements.size()];
		// copy measurements to a double array for use in jsci; 
		// cannot use Java API: ArrayList.toArray(new double[]{}) because of 
		// the type conversion.
		for(int i = 0; i < measurements.size(); i++) {
			values[i] = measurements.get(i);
		}
		NormalDistribution stat = new NormalDistribution(values);
		log.info("Passed time min: " + measurements.get(0));
		log.info("Passed time max: " + measurements.get(measurements.size()-1));
		log.info("Passed time median: " + measurements.get((measurements.size()-1)/2));
		log.info("Passed time mean: " + stat.getMean());
		log.info("Passed time variance: " + stat.getVariance());
	}

	/**
	 * This is the timing problem.
	 * To be overridden by subclasses in such a way, that {@link #start} and
	 * {@link #end} are set to timer values.
	 * @param nr The size of the problem.
	 * @return some value that should be used if (run) has otherwise 
	 * no side effects (i.e. no output, no data storage, etc.).
	 * Using the returned value is likely to deter the JVM from skipping 
	 * execution of the (otherwise skippable) method.
	 */
	protected abstract long run(int nr);
	
	/**
	 * Start the benchmark.
	 */
	public void start() {
		long hook = 0;
		log.info("Warming up " + DEFAULT_WARMUP_SIZE + " times with a problem size of "+DEFAULT_PROBLEM_SIZE+".");
		log.debug("0 % finished");
		for(int i = 0; i < DEFAULT_WARMUP_SIZE; i++) {
			hook += this.run(DEFAULT_PROBLEM_SIZE);
			if((i+1)%(DEFAULT_WARMUP_SIZE/10)==0){
				log.debug(((i+1)/(DEFAULT_WARMUP_SIZE/10)*10)+" % finished");
			}
		}
		log.info("Warmup finished, hook value = "+hook+".");
		log.info("Timer run starts with a problem size of " + DEFAULT_PROBLEM_SIZE + ", repeated " + DEFAULT_REPETITIONS_NUMBER + " times.");
		for(int i = 0; i < DEFAULT_REPETITIONS_NUMBER; i++) {
			this.beforeRun();
			hook += this.run(DEFAULT_PROBLEM_SIZE);
			this.afterRun();
			measurements.add(end-start);//end and start set in the overriden "run" method
		}
		log.info("Timed run finished, hook value = "+hook+".");
		this.printTimes();
	}
}
