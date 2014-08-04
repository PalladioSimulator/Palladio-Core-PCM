package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.IUniformIntDistribution;

public class UniIntDistFunction extends AbstractProbDistFunction {

    public UniIntDistFunction(IRandomGenerator random, IPDFFactory factory) {
        super(random, factory);
    }

    public boolean checkParameters(List<Object> parameters) {
        if (parameters.size() != 2)
            return false;
        if (!(parameters.get(0) instanceof Integer && parameters.get(1) instanceof Integer))
            return false;
        return true;
    }

    public Object evaluate(List<Object> parameters) {
        int a = (Integer) parameters.get(0);
        int b = (Integer) parameters.get(1);
        IUniformIntDistribution distribution = factory.createUniformIntDistribution(a, b);
        return distribution.inverseF(randomGen.random());
    }

}
