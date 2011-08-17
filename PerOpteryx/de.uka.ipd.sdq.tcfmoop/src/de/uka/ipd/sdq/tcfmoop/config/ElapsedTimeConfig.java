/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.config;

import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;

/**
 * Configuration class for ElapsedTime termination criterion.
 * @author Atanas Dimitrov
 */
public class ElapsedTimeConfig extends AbstractConfiguration {

	public enum TimeType{USER_TIME, CPU_TIME};
	
	//The minimum time the optimization is allowed to run
	private Long executionInterval;
	//The type of the time
	private TimeType timeType;
	
	
	public ElapsedTimeConfig(){
		super(TerminationCriteriaNames.ELAPSED_TIME);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validateConfiguration() {
		if(this.getTerminationCriterionName() != TerminationCriteriaNames.ELAPSED_TIME ||
		   this.executionInterval == null ||
		   this.timeType != TimeType.CPU_TIME &&
		   this.timeType != TimeType.USER_TIME){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * Sets the minimum time that the optimization is allowed to run.
	 * @param timeInMilis The minimum time in milliseconds that the optimization is allowed to run. Should be at least 1.
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setExecutionInterval(long timeInMilis) throws InvalidConfigException{
		if(timeInMilis < 1){
			throw new InvalidConfigException("ElapsedTimeConfig.setExecutionInterval: Negative Time is not allowed.");
		}
		this.executionInterval = timeInMilis;
	}
	
	/**
	 * Returns the minimum time in milliseconds that the optimization is allowed to run.
	 * @return the minimum time in milliseconds that the optimization is allowed to run.
	 */
	public long getExecutionInterval(){
		return this.executionInterval;
	}
	
	/**
	 * Sets the type of the time that is going to be measured: Pure-CPU time or Clock time. Please note that the 
	 * measurement of the SPU-Time might not always be possible. If this is the case, then the criterion will
	 * automatically switch to Clock time.
	 * @param timeType the type of the time to be measured.
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setTimeType(TimeType timeType) throws InvalidConfigException{
		if(timeType == null){
			throw new InvalidConfigException("ElapsedTimeConfig.setTimeType(): The supplied parameter should be TimeType.CPU_TIME or TimeType.USER_TIME." +
					"Currently the parameter is null.");
		}
		this.timeType = timeType;
	}
	
	/**
	 * Returns the type of the time that is going to be measured.
	 * @return the type of the time that is going to be measured.
	 */
	public TimeType getTimeType(){
		return this.timeType;
	}

}