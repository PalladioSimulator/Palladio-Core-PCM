package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import static org.opt4j.core.Individual.State.EMPTY;

import org.opt4j.core.Individual;
import org.opt4j.core.IndividualFactory;
import org.opt4j.operator.mutate.AdaptiveMutationRate;
import org.opt4j.start.Constant;

/**
 * The {@link AdaptiveMutationRate} always uses a mutation rate of 1 / (genome length). In this
 * class, the ratio can be configured by a factor mutationIntensity, so that the 
 * final mutation rate is min(1, 1 / (genome length) * mutationIntensity). The higher the mutation intensity, 
 * the closer the mutation rate comes to 1. If the mutation intensity is larger than the genome length, then 
 * the mutation rate is capped to 1. 
 * 
 * A mutation intensity smaller than 1 leads to less mutation that in the {@link AdaptiveMutationRate}.
 * A mutation intensity larger than 1 leads to more mutation than in the {@link AdaptiveMutationRate}.
 *
 * @author martens
 *
 */
public class ConfigurableAdaptiveMutationRate extends AdaptiveMutationRate {

	private double mutationIntensity = 1; 
	
	public ConfigurableAdaptiveMutationRate(IndividualFactory individualFactory, 
			@Constant(value = "intensity", namespace = ConfigurableAdaptiveMutationRate.class) double intensity) {
		super(individualFactory);
		this.mutationIntensity = intensity;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.IndividualStateListener#inidividualStateChanged(org.opt4j
	 * .core.Individual)
	 */
	public synchronized void inidividualStateChanged(Individual individual) {
		if (!isInit && individual.getState() != EMPTY) {
			final int size = individual.getGenotype().size();
			if (size > 0) {
				set(Math.min(1.0, 1.0 / individual.getGenotype().size() * mutationIntensity));
			}
			individualFactory.removeIndividualStateListener(this);
			isInit = true;
		}
	}


	public void setMutationIntensity(double mutationIntensity) {
		this.mutationIntensity = mutationIntensity;
	}


	public double getMutationIntensity() {
		return mutationIntensity;
	}

}
