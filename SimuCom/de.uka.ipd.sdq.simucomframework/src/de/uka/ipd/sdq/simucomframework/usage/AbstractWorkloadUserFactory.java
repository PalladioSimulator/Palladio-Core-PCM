package de.uka.ipd.sdq.simucomframework.usage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.UsageScenarioMeasuringPoint;
import org.palladiosimulator.probeframework.calculator.Calculator;
import org.palladiosimulator.probeframework.calculator.ICalculatorFactory;
import org.palladiosimulator.probeframework.probes.Probe;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.probes.TakeCurrentSimulationTimeProbe;

public abstract class AbstractWorkloadUserFactory implements IUserFactory {

    protected final List<Probe> usageStartStopProbes;
    protected final UsageScenario usageScenario;
    protected final SimuComModel model;
    private final ICalculatorFactory calculatorFactory;

    /** Default EMF factory for measuring points. */
    private final MeasuringpointFactory measuringpointFactory = MeasuringpointFactory.eINSTANCE;

    public AbstractWorkloadUserFactory(final SimuComModel model, final UsageScenario usageScenario) {
        super();
        this.model = model;
        this.calculatorFactory = model.getProbeFrameworkContext().getCalculatorFactory();
        this.usageScenario = usageScenario;
        this.usageStartStopProbes = Collections.unmodifiableList(Arrays.asList(
                (Probe) new TakeCurrentSimulationTimeProbe(model.getSimulationControl()),
                (Probe) new TakeCurrentSimulationTimeProbe(model.getSimulationControl())));
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.simucomframework.usage.IUserFactory#attachResponseTimeCalculator()
     */
    @Override
    public Calculator attachResponseTimeCalculator() {
        UsageScenarioMeasuringPoint mp = this.measuringpointFactory.createUsageScenarioMeasuringPoint();
        mp.setUsageScenario(usageScenario);
        return this.calculatorFactory.buildResponseTimeCalculator(mp, this.usageStartStopProbes);
    }
}