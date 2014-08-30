package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.INormalDistribution;
import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class NormDistFunction extends AbstractProbDistFunction {

    public NormDistFunction(IRandomGenerator random, IPDFFactory factory) {
        super(random, factory);
    }

    public boolean checkParameters(List<Object> parameters) {
        if (parameters.size() != 2)
            return false;
        return true;
    }

    public Object evaluate(List<Object> parameters) {
        double mean = NumberConverter.toDouble(parameters.get(0));
        double deviation = NumberConverter.toDouble(parameters.get(1));
        INormalDistribution distribution = factory.createNormalDistribution(mean, deviation);
        return distribution.inverseF(randomGen.random());
    }

}
