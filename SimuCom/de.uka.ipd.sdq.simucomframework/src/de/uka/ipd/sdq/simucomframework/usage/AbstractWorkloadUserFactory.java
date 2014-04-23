package de.uka.ipd.sdq.simucomframework.usage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.palladiosimulator.probeframework.calculator.ICalculatorFactory;
import org.palladiosimulator.probeframework.probes.Probe;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.probes.TakeCurrentSimulationTimeProbe;

public abstract class AbstractWorkloadUserFactory implements IUserFactory {

    protected final List<Probe> usageStartStopProbes;
    protected final String usageScenarioID;
    protected final SimuComModel model;
    private final ICalculatorFactory calculatorFactory;

    public AbstractWorkloadUserFactory(final SimuComModel model, final String usageScenarioID) {
        super();
        this.model = model;
        this.calculatorFactory = model.getProbeFrameworkContext().getCalculatorFactory();
        this.usageScenarioID = usageScenarioID;
        this.usageStartStopProbes = Collections.unmodifiableList(Arrays.asList(
                (Probe) new TakeCurrentSimulationTimeProbe(model.getSimulationControl()),
                (Probe) new TakeCurrentSimulationTimeProbe(model.getSimulationControl())));
    }

    /* (non-Javadoc)
     * @see de.uka.ipd.sdq.simucomframework.usage.IUserFactory#attachResponseTimeCalculator()
     */
    @Override
    public void attachResponseTimeCalculator() {
        this.calculatorFactory.buildResponseTimeCalculator(usageScenarioID, this.usageStartStopProbes);
    }

}