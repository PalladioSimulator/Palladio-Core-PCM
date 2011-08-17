/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import org.opt4j.core.Archive;
import org.opt4j.core.Population;

import de.uka.ipd.sdq.tcfmoop.config.ElapsedTimeConfig;
import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.ElapsedTimeConfig.TimeType;

/**
 * @author Atanas Dimitrov
 *
 */
public class ElapsedTimeCriterion extends AbstractTerminationCriterion {

	//The minimum time the optimization is allowed to run
	private long executionInterval;
	private long elapsedTime;
	private TimeType timeType;
	private long startTime;
	//Required for the check whether CPU time measurement is possible
	private ThreadMXBean threadMXBean;
	private boolean isCPUTimeMeasuringSupported;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(IConfiguration conf, Population population,
			Archive archive) {
		if((conf instanceof ElapsedTimeConfig) && conf.validateConfiguration()){
			this.executionInterval = ((ElapsedTimeConfig)(conf)).getExecutionInterval();
			this.timeType = ((ElapsedTimeConfig)(conf)).getTimeType();
			this.startTime = System.currentTimeMillis();
			if(this.timeType.equals(TimeType.CPU_TIME)){
				this.threadMXBean = ManagementFactory.getThreadMXBean();
				if(this.threadMXBean.isThreadCpuTimeSupported()){
					if(!this.threadMXBean.isThreadCpuTimeEnabled()){
						this.threadMXBean.setThreadCpuTimeEnabled(true);
					}
					this.isCPUTimeMeasuringSupported = true;
				}else{
					this.isCPUTimeMeasuringSupported = false;
				}
			}
		}else{
			throw new RuntimeException("ElapsedTimeCriterion.initialize: " +
					"wrong or invalid configuration object");
		}
		super.initialize(conf, population, archive);
	}	
	
	/**
	 * {@inheritDoc}
	 * Implements the ElapsedTime Criterion: This criterion measures either the CPU time (if possible)
	 * or the Clock time. When the execution time goes past a certain value, the criterion will report
	 * that the optimization should be stopped.
	 */
	@Override
	public void evaluate(int iteration, long currentTime) {
		if(timeType.equals(TimeType.CPU_TIME)){
			if(this.isCPUTimeMeasuringSupported){
				this.elapsedTime = (threadMXBean.getThreadCpuTime(Thread.currentThread().getId())/1000000);
			}else{
				this.elapsedTime = currentTime - this.startTime;
			}
		}else if(this.timeType.equals(TimeType.USER_TIME)){
			this.elapsedTime = currentTime - this.startTime;
		}
		
		if(this.elapsedTime > this.executionInterval){
			this.evaluationResult = true;
		}else{
			this.evaluationResult = false;
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringBuilder getOutputInformation(){
		this.outputInformation = new StringBuilder();
		this.outputInformation.append("Criterion Name: Elapsed Time" + '\n');
		if(timeType.equals(TimeType.CPU_TIME)){
			if(!this.isCPUTimeMeasuringSupported){
				this.outputInformation.append("Cannot Meassure CPU Time. Measuring USER Time instead." + '\n');
			}else{
				this.outputInformation.append("Type of the Measured Time: CPU Time" + '\n');
			}
		}else{
			this.outputInformation.append("Type of the Measured Time: USER Time" + '\n');
		}
		this.outputInformation.append("Total Execution Time: " + this.executionInterval + '\n');
		this.outputInformation.append("Time Remaining: " + this.elapsedTime + '\n');
		return super.getOutputInformation();
	}

}
