package de.uka.ipd.sdq.simucom;

import java.util.Hashtable;

import stoex.stochastics.RandomVariable;
import stoex.stochastics.Sample;
import desmoj.core.dist.IntDistEmpirical;
import desmoj.core.simulator.Model;

public class DistributionObjectsStorage {
	protected Model myModel = null;
	
	protected static DistributionObjectsStorage singleton = new DistributionObjectsStorage();

	protected Hashtable<String, IntDistEmpirical> intEmpiricalDistributions = new Hashtable<String, IntDistEmpirical>();

	public static DistributionObjectsStorage getSingletonInstance()
	{
		return singleton;
	}
	
	public void initializeModel(Model m)
	{
		getSingletonInstance().myModel = m;
	}

	private DistributionObjectsStorage() {
	}

	private IntDistEmpirical getIntDistribution(RandomVariable distribution, String spec) {
		IntDistEmpirical newDistribution = new IntDistEmpirical(myModel,
				spec, true, false);
		newDistribution.setSeed(System.currentTimeMillis());
		double sum = 0.0;
		for (int i = 0; i < distribution.getSamples().size(); i++) {
			Sample<Integer> sample = (Sample<Integer>) distribution
					.getSamples().get(i);
			double probability = sample.getProbability();
			sum += probability;
			if (i == distribution.getSamples().size() - 1)
				newDistribution.addEntry(i, 1.0);
			else
				newDistribution.addEntry(i, sum);
		}
		return newDistribution;
	}

	public Object getDistributionSample(String specification, RandomVariable r) {
		long index = -1;
		if (!intEmpiricalDistributions.containsKey(specification)) {
			intEmpiricalDistributions.put(specification, getIntDistribution(r,specification));
		}
		index = intEmpiricalDistributions.get(specification).sample();
		return ((Sample) r.getSamples().get((int) index)).getValue();
	}
}
