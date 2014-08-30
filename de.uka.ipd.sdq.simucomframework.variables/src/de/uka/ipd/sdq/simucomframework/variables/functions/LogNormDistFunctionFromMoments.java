package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.ILognormalDistribution;
import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

/**
 * Lognormal distribution from the distributions moments: Parameters mean and standard deviation.
 * 
 * @author Anne
 *
 */
public class LogNormDistFunctionFromMoments extends AbstractProbDistFunction {

    public LogNormDistFunctionFromMoments(IRandomGenerator random, IPDFFactory factory) {
        super(random, factory);
    }

    /**
     * Checks the validity of the parameter. LognormFromMoments takes two parameters mean and
     * standard deviation mean needs to be larger than 0. stdev needs to be larger than 0.
     */
    public boolean checkParameters(List<Object> parameters) {
        // two parameters mean and c
        if (parameters.size() != 2)
            return false;
        // mean needs to be larger than 0.
        if (NumberConverter.toDouble(parameters.get(0)) < 0)
            return false;
        // stdev needs to be larger than 0.
        if (NumberConverter.toDouble(parameters.get(1)) < 0)
            return false;
        return true;
    }

    public Object evaluate(List<Object> parameters) {
        double mean = NumberConverter.toDouble(parameters.get(0));
        double stdev = NumberConverter.toDouble(parameters.get(1));
        double variance = stdev * stdev;
        ILognormalDistribution distribution = factory.createLognormalDistributionFromMoments(mean, variance);
        return distribution.inverseF(randomGen.random());
    }

}
