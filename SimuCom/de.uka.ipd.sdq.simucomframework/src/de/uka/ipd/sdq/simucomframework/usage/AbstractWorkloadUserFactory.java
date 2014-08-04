package de.uka.ipd.sdq.simucomframework.usage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.ResourceURIMeasuringPoint;
import org.palladiosimulator.edp2.util.MeasuringPointUtility;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointFactory;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint;
import org.palladiosimulator.probeframework.calculator.Calculator;
import org.palladiosimulator.probeframework.calculator.ICalculatorFactory;
import org.palladiosimulator.probeframework.probes.Probe;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simucomframework.ModelsAtRuntime;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.probes.TakeCurrentSimulationTimeProbe;

public abstract class AbstractWorkloadUserFactory implements IUserFactory {

    protected final List<Probe> usageStartStopProbes;
    private final UsageScenario usageScenario;
    protected final SimuComModel model;
    private final ICalculatorFactory calculatorFactory;

    /** Default EMF factory for measuring points. */
    private static final MeasuringpointFactory MEASURINGPOINT_FACTORY = MeasuringpointFactory.eINSTANCE;

    /** Default EMF factory for pcm measuring points. */
    private static final PcmmeasuringpointFactory PCM_MEASURINGPOINT_FACTORY = PcmmeasuringpointFactory.eINSTANCE;

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
        final UsageScenarioMeasuringPoint mp = PCM_MEASURINGPOINT_FACTORY.createUsageScenarioMeasuringPoint();
        mp.setUsageScenario(usageScenario);

        final ResourceURIMeasuringPoint measuringPoint = MEASURINGPOINT_FACTORY.createResourceURIMeasuringPoint();
        measuringPoint.setResourceURI(ModelsAtRuntime.getResourceURI(usageScenario));
        measuringPoint.setMeasuringPoint(MeasuringPointUtility.measuringPointToString(mp));

        return this.calculatorFactory.buildResponseTimeCalculator(measuringPoint, this.usageStartStopProbes);
    }
}