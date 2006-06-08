package de.uka.ipd.sdq.simucom;

import java.util.Hashtable;

import Statistics.NumericProbabilityMassFunction;
import Statistics.NumericSample;
import desmoj.core.dist.IntDistEmpirical;
import desmoj.core.simulator.Model;

public class DistributionObjectsStorage {
	protected Model myModel = null;

	protected Hashtable<String, IntDistEmpirical> decisionNodeDistributions = new Hashtable<String, IntDistEmpirical>();

	protected Hashtable<String, IntDistEmpirical> intEmpiricalDistributions = new Hashtable<String, IntDistEmpirical>();

	public DistributionObjectsStorage(Model myModel) {
		this.myModel = myModel;
	}

	public IntDistEmpirical getIntDistribution(
			NumericProbabilityMassFunction distribution) {
		if (intEmpiricalDistributions.containsKey(distribution.getId()))
			return intEmpiricalDistributions.get(distribution.getId());
		else {
			IntDistEmpirical newDistribution = new IntDistEmpirical(myModel,
					distribution.getId(), true, false);
			newDistribution.setSeed(System.currentTimeMillis());
			double sum = 0.0;
			for (int i = 0; i < distribution.getSamples_DistributionFunction()
					.size(); i++) {
				NumericSample sample = (NumericSample) distribution
						.getSamples_DistributionFunction().get(i);
				double probability = sample.getProbability();
				sum += probability;
				if (i == distribution.getSamples_DistributionFunction().size() - 1)
					newDistribution.addEntry(i, 1.0);
				else
					newDistribution.addEntry(i, sum);
			}
			intEmpiricalDistributions
					.put(distribution.getId(), newDistribution);
			return newDistribution;
		}
	}
}
