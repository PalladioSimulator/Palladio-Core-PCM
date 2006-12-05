/**
 * 
 */
package de.uka.ipd.sdq.probfunction.visualization;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

/**
 * @author Ihssane
 * 
 */
public class FunctionWrapper {

	private double max;
	private double min;
	private int maxIndex;
	private int minIndex;
	private int valuesSize;

	private IProbabilityFunction originalFunction;
	private List<Double> probabilities;
	private List<Object> values;

	public FunctionWrapper() {
	}

	public void addPMF(IProbabilityMassFunction pmf)
			throws UnorderedDomainException {
		if (!pmf.hasOrderedDomain())
			throw new UnorderedDomainException();

		List<Object> values = new ArrayList<Object>();
		List<Double> probs = new ArrayList<Double>();
		for (ISample s : pmf.getSamples()) {
			values.add(s.getValue());
			probs.add(s.getProbability());
		}
		originalFunction = pmf;
		this.values = values;
		this.probabilities = probs;
	}

	public void addSamplePDF(ISamplePDF spdf) {

		List<Object> values = new ArrayList<Object>();
		for (int i = 1; i <= spdf.getValues().size(); i++)
			values.add(round(new Double(i) * spdf.getDistance(), 3));
		originalFunction = spdf;
		this.values = values;
		this.probabilities = spdf.getValuesAsDouble();
	}

	private double round(double value, int fractal) {
		double b = value * Math.pow(10, fractal);
		return  1.0*Math.round(b)/Math.pow(10, fractal);
	}
	@SuppressWarnings("unchecked")
	private void doConfiguration() {
		maxIndex = minIndex = 0;

		if (originalFunction instanceof ISamplePDF) {
			ISamplePDF s = (ISamplePDF) originalFunction;
			int diff = values.size() + (valuesSize - values.size());
			for (int i = values.size(); i < diff; i++) {
				values.add(round(new Double(i + 1) * s.getDistance(), 3));
				probabilities.add(s.getFillValueAsDouble());
			}
		}

		if (max == Visualization.UNDEFINED && min == Visualization.UNDEFINED) {
			minIndex = 0;
			maxIndex = values.size();
		}

		if (max == Visualization.UNDEFINED)
			maxIndex = values.size();
		else {
			for (Object o : values)
				if (((Comparable) o).compareTo(max) <= 0) {
					maxIndex++;
				} else
					break;
		}
		if (min != Visualization.UNDEFINED) {
			maxIndex = maxIndex == 0 ? values.size() : maxIndex;
			for (Object o : values)
				if (((Comparable) o).compareTo(min) < 0) {
					minIndex++;
				} else
					break;
		}

	}
	@SuppressWarnings("unchecked")
	public List<Object> getValues() {
		doConfiguration();
		return values.subList(minIndex, maxIndex);
	}
	public List<Double> getProbabilities() {
		doConfiguration();
		return probabilities.subList(minIndex, maxIndex);
	}

	public void setMaxValue(double max) {
		this.max = max;
	}

	public void setMinValue(double min) {
		this.min = min;
	}

	public IProbabilityFunction getOriginal() {
		return originalFunction;
	}

	/**
	 * @param max
	 *            the max to set
	 */
	public void setMax(double max) {
		this.max = max;
	}

	/**
	 * @param min
	 *            the min to set
	 */
	public void setMin(double min) {
		this.min = min;
	}

	public void setValuesSize(int valuesSize) {
		this.valuesSize = valuesSize;
	}
}
