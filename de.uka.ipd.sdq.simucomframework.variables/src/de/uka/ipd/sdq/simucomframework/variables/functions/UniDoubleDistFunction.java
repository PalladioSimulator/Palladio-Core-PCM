package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.IUniformDistribution;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class UniDoubleDistFunction extends AbstractProbDistFunction {

    public UniDoubleDistFunction(IRandomGenerator random, IPDFFactory factory) {
        super(random, factory);
    }

    public boolean checkParameters(List<Object> parameters) {
        if (parameters.size() != 2)
            return false;
        if (NumberConverter.toDouble(parameters.get(0)) > NumberConverter.toDouble(parameters.get(1)))
            return false;
        return true;
    }

    public Object evaluate(List<Object> parameters) {
        double a = NumberConverter.toDouble(parameters.get(0));
        double b = NumberConverter.toDouble(parameters.get(1));
        IUniformDistribution distribution = factory.createUniformDistribution(a, b);
        return distribution.inverseF(randomGen.random());
    }

}
