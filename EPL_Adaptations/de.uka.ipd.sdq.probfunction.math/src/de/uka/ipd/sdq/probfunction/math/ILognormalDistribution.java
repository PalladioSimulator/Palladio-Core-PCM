package de.uka.ipd.sdq.probfunction.math;

/**
 * Lognormal distribution with parameters mu (scale parameter) 
 * and sigma (shape parameter) as defined in 
 * {@link umontreal.iro.lecuyer.probdist.LognormalDist}.
 * @author martens
 *
 */
public interface ILognormalDistribution extends IContinousPDF {

	double getMu();

	double getSigma();

}
