package de.uka.ipd.sdq.statistics;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Batch means algorithm with manually configured batch size. 
 * Specify the size of each batch and the minimum number of batches. 
 * It will then provide the mean values for the defined batches to the simulation. 
 * @author martens
 *
 */
public class StaticBatchAlgorithm extends ABatchAlgorithm {
	
	private int batchSize;
	private int minNumberOfBatches;
	
	private List<Double> buffer;
	
	private Logger logger = Logger.getLogger("de.uka.ipd.sdq.statistics.StaticBatchAlgorithm.log");


	public StaticBatchAlgorithm(int batchSize, int minNumberOfBatches){
		this.batchSize = batchSize;
		this.minNumberOfBatches = minNumberOfBatches;
		if (minNumberOfBatches > 0){
			this.setValid(false);
		} else {
			this.setValid(true);
		}
		
		if (batchSize > 100000){
			logger.warn("Batch size is larger than 100 000, thus more than 700KB are needed to store intermediate values. Decrease batch size of you have memory problems, or ask the developers to implement a sliding mean calculation for the batchs.");
		}
		this.buffer = new LinkedList<Double>();
	}

	/**
	 * Store all values of the current batch to avoid numerical errors with 
	 * sliding mean calculation. 
	 * Should not be too many values in one batch. 
	 */
	@Override
	public synchronized void offerSample(double value) {

		buffer.add(value);
		
		if (buffer.size() > batchSize){
			// calculate a new batch mean
			int batchSize = buffer.size();
			double batchSum = 0;
			for (Double sample : buffer) {
				batchSum += sample;
			}
			
			this.batches.add(new Batch(batchSum, batchSize));
			
			if (!this.hasValidBatches()){
				if (this.minNumberOfBatches <= this.batches.size()){
					this.setValid(true);
				}
			}
			
			// empty buffer
			buffer.clear();
		}

	}

}
