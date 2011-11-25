package de.uka.ipd.sdq.probfunction.math;


public interface IBinomialDistribution extends IDiscretePDF {


	/**
     * Access the number of trials for this distribution.
     * @return the number of trials.
     */
    int getTrials();

    /**
     * Access the probability of success for this distribution.
     * @return the probability of success.
     */
    double getProbability();


}
