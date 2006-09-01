package stoex.stochastics;

public class Sample<T> {
	private T value;

	private double probability;

	public Sample(double probability, T value) {
		this.value = value;
		this.probability = probability;
	}

	/**
	 * @return the probability
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}
}
