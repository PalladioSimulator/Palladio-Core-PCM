package de.uka.ipd.sdq.measurement.strategies.activeresource.cpu;

import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;

public class MandelbrotDemand extends AbstractDemandStrategy {

	private int BAILOUT = 16;
	private int MAX_ITERATIONS = 1000;

	public MandelbrotDemand() {
		// this.initialValue = initialValue;
		
		/** define the calibration accuracy parameter */
		high = 2; 
		medium = 0;
		low = -2;

		/** which amount of time is waited for the test */
		defaultIterationCount = 40;
		
		/** number of warm up cycles before calibrating */
		warmUpCycles = 20;
	}

	private int iterate(float x, float y) {
		float cr = y - 0.5f;
		float ci = x;
		float zi = 0.0f;
		float zr = 0.0f;
		int i = 0;
		while (true) {
			i++;
			float temp = zr * zi;
			float zr2 = zr * zr;
			float zi2 = zi * zi;
			zr = zr2 - zi2 + cr;
			zi = temp + temp + ci;
			if (zi2 + zr2 > BAILOUT)
				return i;
			if (i > MAX_ITERATIONS)
				return 0;
		}
	}

	private void drawMandelbrot(long init) {
		// Date d1 = new Date();
		int n = (int) init;
		float m = (float) n;
		int x, y;
		for (y = -n; y < n; y++) {
			// System.out.print("\n");
			for (x = -n; x < n; x++) {
				if (iterate(x / m, y / m) == 0) {
					// System.out.print("*");
				} else {
					// System.out.print(" ");
				}

			}
		}
		// Date d2 = new Date();
		// long diff = d2.getTime() - d1.getTime();
		// System.out.println("\nJava Elapsed " + diff / 1000.0f);
	}

	@Override
	public void run(long initial) {
		drawMandelbrot(initial);
	}

	@Override
	public ResourceTypeEnum getStrategysResource() {
		return ResourceTypeEnum.CPU;
	}

	@Override
	public String getName() {
		return "Mandelbrot";
	}
}
