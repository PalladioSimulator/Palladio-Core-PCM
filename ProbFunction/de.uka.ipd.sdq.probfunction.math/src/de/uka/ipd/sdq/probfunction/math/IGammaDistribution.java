package de.uka.ipd.sdq.probfunction.math;

/**
 * Gamma distribution with shape parameter alpha > 0 (also called k in Wikipedia) 
 * and scale parameter theta > 0 (called lambda in umontreal.iro.lecuyer.probdist.GammaDist). 
 * The scale parameter theta is the inverse of the rate beta which is also 
 * sometimes given to characterise a Gamma distribution. 
 * @author martens
 *
 */
public interface IGammaDistribution extends IContinousPDF {

	double getAlpha();

	double getTheta();

}
