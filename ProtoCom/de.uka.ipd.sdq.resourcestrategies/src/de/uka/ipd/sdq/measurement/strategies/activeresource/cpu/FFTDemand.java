package de.uka.ipd.sdq.measurement.strategies.activeresource.cpu;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.transform.FastFourierTransformer;

import de.uka.ipd.sdq.measurement.strategies.activeresource.AbstractDemandStrategy;
import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;
//import flanagan.complex.Complex;
//import flanagan.math.FourierTransform;

public class FFTDemand extends AbstractDemandStrategy {

	private FastFourierTransformer ft;

	public FFTDemand() {
		super(-1,-3,-5,262144,2);
		ft = new FastFourierTransformer();
	}

	private void fft(int lengthOfDistFunc) {
		Complex[] points = new Complex[lengthOfDistFunc];
		for (int i = 0; i < lengthOfDistFunc; i++) {
			points[i] = new Complex(Math.random(), 0);
		}
		
		ft.transform(points);
	}

	@Override
	public void run(long initial) {
		int length = (int)initial;
		if (!FastFourierTransformer.isPowerOf2(length)) {
			int next = nextPowerOfTwo(length);
			int last = lastPowerOfTwo(length);
			length = next - length > length - last || next > defaultIterationCount ? last : next;
		}
		fft(length);
	}

	@Override
	public ResourceTypeEnum getStrategysResource() {
		return ResourceTypeEnum.CPU;
	}

	@Override
	public String getName() {
		return "FFT";
	}
	
	@Override
	public void cleanup() {
		// Do nothing.
	}
	
	/**
     * Find the smallest power of two greater than the input value
     * @param i input value
     * @return smallest power of two greater than the input value
     */
    private static int nextPowerOfTwo(final int i) {
        return Integer.highestOneBit(i) << 1;
    }
    
    
    /**
     * Find the smallest power of two smaller than the input value
     * @param i input value
     * @return smallest power of two greater than the input value
     */
    private static int lastPowerOfTwo(final int i) {
        return Integer.highestOneBit(i);
    }
}
