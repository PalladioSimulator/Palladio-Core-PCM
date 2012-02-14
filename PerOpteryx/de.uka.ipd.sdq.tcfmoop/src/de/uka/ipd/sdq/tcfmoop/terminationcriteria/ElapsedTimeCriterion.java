/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.optimizer.Population;

import de.uka.ipd.sdq.tcfmoop.config.ElapsedTimeConfig;
import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.ElapsedTimeConfig.TimeType;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node.NodeType;

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
	
	//OutputNodes
	//static
	@SuppressWarnings("unused")
	private Node timeTypeNode;
	//dynamic
	private Node executionTimeNode;
	private Node remainingTimeNode;
	
	public ElapsedTimeCriterion(IConfiguration conf, Population population,
			Archive archive){
		
		super(conf, population, archive);
		
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
		initializeOutputTree();
		
	}
	
	private void initializeOutputTree(){
		this.outputInformation.updateValue("Elapsed Time");
		this.outputInformation.getChildren().clear();
		
		if(timeType.equals(TimeType.CPU_TIME)){
			if(!this.isCPUTimeMeasuringSupported){
				this.timeTypeNode = this.outputInformation.addChild("Time Type: Cannot Meassure CPU Time. Measuring USER Time instead.", NodeType.PARAMETER);
			}else{
				this.timeTypeNode = this.outputInformation.addChild("Time Type: CPU Time", NodeType.PARAMETER);
			}
		}else{
			this.timeTypeNode = this.outputInformation.addChild("Time Type: USER Time", NodeType.PARAMETER);
		}
		
		this.executionTimeNode = this.outputInformation.addChild("Minimum Execution Time: " + this.executionInterval + " ms", NodeType.PARAMETER);
		this.remainingTimeNode = this.outputInformation.addChild("Elapsed Time: " + this.elapsedTime + " ms", NodeType.PARAMETER);
		this.outputInformation.getChildren().add(this.suggestedStop);
	}
	
	/**
	 * {@inheritDoc}
	 * Implements the ElapsedTime Criterion: This criterion measures either the CPU time (if possible)
	 * or the Clock time. When the execution time goes past a certain value, the criterion will report
	 * that the optimization should be stopped.
	 */
	@Override
	public void evaluateImpl(int iteration, long currentTime) {
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
	public void updateOutputInformation(){
		this.executionTimeNode.updateValue("Minimum Execution Time: " + this.executionInterval + " ms");
		this.remainingTimeNode.updateValue("Elapsed Time: " + this.elapsedTime + " ms");
	}

}
