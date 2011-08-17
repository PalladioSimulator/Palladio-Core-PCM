package de.uka.ipd.sdq.measurement.strategies.activeresource.cpu;

import de.uka.ipd.sdq.measurement.strategies.activeresource.AbstractDemandStrategy;
import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;
import flanagan.complex.Complex;
import flanagan.math.FourierTransform;

public class FFTDemand extends AbstractDemandStrategy {

	public FFTDemand() {
		super(-1,-3,-5,262144,2);
	}

	private void fft(int lengthOfDistFunc) {
		Complex[] points = new Complex[lengthOfDistFunc];
		for (int i = 0; i < lengthOfDistFunc; i++) {
			points[i] = new Complex(Math.random(), 0);
		}
		FourierTransform ft = new FourierTransform(points);
		ft.transform();
	}

	@Override
	public void run(long initial) {
		int length = (int)initial;
		if (!FourierTransform.checkPowerOfTwo(length)) {
			int next = FourierTransform.nextPowerOfTwo(length);
			int last = FourierTransform.lastPowerOfTwo(length);
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
}
