package stoex.stochastics;

import java.util.ArrayList;

public class RandomVariable<T> {

	public static final int INTEGER_DIST = 0;

	public static final int REAL_DIST = 1;

	public static final int ENUM_DIST = 2;

	protected ArrayList<Sample<T>> samples = new ArrayList<Sample<T>>();

	@SuppressWarnings("unchecked")
	public void addRawSample(double probability, String value,
			int distributionType) {
		T val = null;
		if (distributionType == INTEGER_DIST) {
			val = (T) new Integer(Integer.parseInt(value));
		} else if (distributionType == REAL_DIST) {
			val = (T) new Double(Double.parseDouble(value));
		} else if (distributionType == ENUM_DIST) {
			val = (T) value;
		}
		samples.add(new Sample(probability, val));
	}

	public ArrayList<Sample<T>> getSamples() {
		return samples;
	}

}
