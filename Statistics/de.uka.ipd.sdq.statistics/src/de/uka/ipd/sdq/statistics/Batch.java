package de.uka.ipd.sdq.statistics;

/**
 * A batch, represented by the batch mean. For efficiency reasons, only the
 * number and sum of contained samples will be stored.
 * 
 * @author Philipp Merkle
 * 
 */
public class Batch {

	private int size;

	private double sum;

	public Batch() {
		super();
	}

	public Batch(double sum, int size) {
		this.sum = sum;
		this.size = size;
	}

	public void addSample(double value) {
		sum += value;
		++size;
	}

	public double getMean() {
		return sum / size;
	}

	public int getSize() {
		return size;
	}

	public double getSum() {
		return sum;
	}

}
