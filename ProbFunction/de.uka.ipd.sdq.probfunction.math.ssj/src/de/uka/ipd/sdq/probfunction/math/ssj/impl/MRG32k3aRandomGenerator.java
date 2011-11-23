package de.uka.ipd.sdq.probfunction.math.ssj.impl;

import umontreal.iro.lecuyer.rng.MRG32k3a;

public class MRG32k3aRandomGenerator extends SSJRandomGenerator {

	public MRG32k3aRandomGenerator() {
		super(new MRG32k3a());
	}

	@Override
	public void setSeed(int[] seed) {

		long[] longSeed = new long[seed.length];
		for (int i = 0; i < seed.length; i++) {
			longSeed[i] = (int)seed[i];;
		}
		setSeed(longSeed);
	}

	@Override
	public void setSeed(long[] seed) {
		((MRG32k3a) rng).setSeed(seed);

	}

}
